
package com.squareup.square.http.client;

import com.squareup.square.ApiHelper;
import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpBodyRequest;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.utilities.FileWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * HTTP Client class to send HTTP Requests and read the responses.
 */
public class OkClient implements HttpClient {
    private static final Object syncObject = new Object();
    private static volatile okhttp3.OkHttpClient defaultOkHttpClient;

    /**
     * Private instance of the okhttp3.OkHttpClient.
     */
    private okhttp3.OkHttpClient client;

    /**
     * Default constructor.
     * @param  httpClientConfig  The specified http client configuration.
     */
    public OkClient(ReadonlyHttpClientConfiguration httpClientConfig) {
        okhttp3.OkHttpClient.Builder clientBuilder = getDefaultOkHttpClient().newBuilder();
        clientBuilder.readTimeout(httpClientConfig.getTimeout(), TimeUnit.SECONDS)
                .writeTimeout(httpClientConfig.getTimeout(), TimeUnit.SECONDS)
                .connectTimeout(httpClientConfig.getTimeout(), TimeUnit.SECONDS);
        // If retries are allowed then RetryInterceptor must be registered
        if (httpClientConfig.getNumberOfRetries() > 0) {
            clientBuilder.callTimeout(httpClientConfig.getMaxBackOff(), TimeUnit.SECONDS)
                    .addInterceptor(new RetryInterceptor(httpClientConfig));
        } else {
            clientBuilder.callTimeout(httpClientConfig.getTimeout(), TimeUnit.SECONDS);
        }

        clientBuilder.addInterceptor(new HttpRedirectInterceptor(true));
        this.client = clientBuilder.build();
    }

    /**
     * Getter for the default static instance of the okhttp3.OkHttpClient.
     */
    private okhttp3.OkHttpClient getDefaultOkHttpClient() {
        if (defaultOkHttpClient == null) {
            synchronized (syncObject) {
                if (defaultOkHttpClient == null) {
                    defaultOkHttpClient = new okhttp3.OkHttpClient.Builder()
                            .retryOnConnectionFailure(false)
                            .callTimeout(60, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return defaultOkHttpClient;
    }

    /**
     * Shutdown the underlying OkHttpClient instance. 
     */
    public static void shutdown() {
        if (defaultOkHttpClient != null) {
            defaultOkHttpClient.dispatcher().executorService().shutdown();
            defaultOkHttpClient.connectionPool().evictAll();
        }
    }

    /**
     * Execute a given HttpRequest to get string/binary response back.
     * @param   httpRequest        The given HttpRequest to execute.
     * @param   hasBinaryResponse  Whether the response is binary or string.
     * @return  CompletableFuture of HttpResponse after execution.
     */
    public CompletableFuture<HttpResponse> executeAsync(final HttpRequest httpRequest,
            boolean hasBinaryResponse) {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        
        RetryInterceptor retryInterceptor = getRetryInterceptor();
        if (retryInterceptor != null) {
            retryInterceptor.addRequestEntry(okHttpRequest);
        }

        final CompletableFuture<HttpResponse> callBack = new CompletableFuture<>();
        client.newCall(okHttpRequest).enqueue(new okhttp3.Callback() {

            public void onFailure(okhttp3.Call call, IOException e) {
                publishResponse(null, httpRequest, callBack, e, hasBinaryResponse);
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response okHttpResponse) {
                publishResponse(okHttpResponse, httpRequest, callBack, null, hasBinaryResponse);
            }
        });

        return callBack;
    }

    /**
     * Execute a given HttpRequest to get string/binary response back.
     * @param   httpRequest        The given HttpRequest to execute.
     * @param   hasBinaryResponse  Whether the response is binary or string.
     * @return  The converted http response.
     * @throws  IOException exception to be thrown while converting response.
     */
    public HttpResponse execute(HttpRequest httpRequest, boolean hasBinaryResponse)
            throws IOException {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        
        RetryInterceptor retryInterceptor = getRetryInterceptor();
        if (retryInterceptor != null) {
            retryInterceptor.addRequestEntry(okHttpRequest);
        }

        okhttp3.Response okHttpResponse = null;
        okHttpResponse = client.newCall(okHttpRequest).execute();
        return convertResponse(httpRequest, okHttpResponse, hasBinaryResponse);
    }

    /**
     * Returns RetryInterceptor instance registered with client.
     * @return The RetryInterceptor instance.
     */
    private RetryInterceptor getRetryInterceptor() {
        return (RetryInterceptor) this.client.interceptors().stream()
                .filter(interceptor -> interceptor instanceof RetryInterceptor).findFirst()
                .orElse(null);
    }

    /**
     * Publishes success or failure result as HttpResponse from a HttpRequest.
     * @param okHttpResponse The okhttp response to publish.
     * @param httpRequest The internal http request.
     * @param completionBlock The success and failure code block reference to invoke the delegate.
     * @param error The reported errors for getting the http response.
     * @param hasBinaryResponse Whether the response is binary or string.
     * @return The converted http response.
     */
    private HttpResponse publishResponse(okhttp3.Response okHttpResponse, 
            HttpRequest httpRequest, CompletableFuture<HttpResponse> completionBlock,
            Throwable error, boolean hasBinaryResponse) {
        HttpResponse httpResponse = null;
        try {
            httpResponse = convertResponse(httpRequest, okHttpResponse, hasBinaryResponse);

            // if there are no errors, pass on to the callback function
            if (error == null && httpResponse != null) {
                completionBlock.complete(httpResponse);
            } else {
                completionBlock.completeExceptionally(error);
            }
        } catch (IOException e) {
            completionBlock.completeExceptionally(e);
        }
        return httpResponse;
    }

    /**
     * Converts a given OkHttp response into our internal http response model.
     * @param   response           The given OkHttp response.
     * @param   hasBinaryResponse  Whether the response is binary or string.
     * @return  The converted http response.
     * @throws  IOException exception to be thrown while converting response.
     */
    protected static HttpResponse convertResponse(HttpRequest request, okhttp3.Response response,
            boolean hasBinaryResponse) throws IOException {
        HttpResponse httpResponse = null;

        if (response != null) {

            okhttp3.ResponseBody responseBody = response.body();

            Headers headers = new Headers(response.headers().toMultimap());

            if (hasBinaryResponse) {
                InputStream responseStream = responseBody.byteStream();
                httpResponse = new HttpResponse(response.code(), headers, responseStream);
            } else {
                String responseString = responseBody.string();
                InputStream responseStream = new ByteArrayInputStream(
                        responseString.getBytes());
                httpResponse = new HttpStringResponse(response.code(), headers, responseStream,
                        responseString);

                responseBody.close();
                response.close();
            }
        }

        return httpResponse;
    }

    /**
     * Converts a given internal http request into an okhttp request model.
     * @param   httpRequest     The given http request in internal format.
     * @return  The converted okhttp request
     */
    private okhttp3.Request convertRequest(HttpRequest httpRequest) {
        okhttp3.RequestBody requestBody;

        if (httpRequest instanceof HttpBodyRequest) {

            // set request media type
            String contentType;
            Object body = ((HttpBodyRequest) httpRequest).getBody();

            // set request body
            if (body instanceof FileWrapper) {
                FileWrapper file = (FileWrapper) body;

                if (file.getContentType() != null && !file.getContentType().isEmpty()) {
                    contentType = file.getContentType();
                    httpRequest.getHeaders().add("content-type", contentType);
                } else if (httpRequest.getHeaders().has("content-type")) {
                    contentType = httpRequest.getHeaders().value("content-type");
                } else {
                    contentType = "application/octet-stream";
                    httpRequest.getHeaders().add("content-type", contentType);
                }

                requestBody = okhttp3.RequestBody.create(okhttp3.MediaType.parse(contentType),
                        ((FileWrapper) body).getFile());
            } else {
                // set request body
                if (!httpRequest.getHeaders().has("content-type")) {
                    httpRequest.getHeaders().add("content-type", "application/json; charset=UTF-8");
                }

                contentType = httpRequest.getHeaders().value("content-type");
                // set request body
                requestBody = okhttp3.RequestBody.create(okhttp3.MediaType.parse(contentType),
                        ((String) body).getBytes());
            }
        } else {

            List<SimpleEntry<String, Object>> parameters = httpRequest.getParameters();
            boolean multipartRequest = false;

            // set request fields
            if (parameters != null && parameters.size() > 0) {
                // check if a request is a multipart request
                for (SimpleEntry<String, Object> param : parameters) {
                    if ((param.getValue() instanceof MultipartFileWrapper)
                            || (param.getValue() instanceof MultipartWrapper)) {
                        multipartRequest = true;
                        break;
                    }
                }

                if (multipartRequest) {
                    // make a multipart request if a file is being sent
                    requestBody = createMultipartRequestBody(httpRequest);
                } else {
                    okhttp3.FormBody.Builder formBuilder = new okhttp3.FormBody.Builder();
                    for (SimpleEntry<String, Object> param : parameters) {
                        formBuilder.add(param.getKey(),
                                (param.getValue() == null) ? "" : param.getValue().toString());
                    }
                    requestBody = formBuilder.build();
                }
            } else if (httpRequest.getHttpMethod().equals(HttpMethod.GET)) {
                requestBody = null;
            } else {
                requestBody = okhttp3.RequestBody.create(null, new byte[0]);
            }
        }

        // set request headers
        okhttp3.Headers.Builder requestHeaders = new okhttp3.Headers.Builder();
        if (httpRequest.getHeaders() != null) {
            requestHeaders = createRequestHeaders(httpRequest.getHeaders());
        }

        StringBuilder urlBuilder = new StringBuilder(httpRequest.getQueryUrl());

        // set query parameters
        ApiHelper.appendUrlWithQueryParameters(urlBuilder, httpRequest.getQueryParameters());

        // validate and preprocess url
        String url = ApiHelper.cleanUrl(urlBuilder);

        // build the request
        okhttp3.Request okHttpRequest = new okhttp3.Request.Builder()
                .method(httpRequest.getHttpMethod().toString(), requestBody)
                .headers(requestHeaders.build()).url(url)
                .build();

        return okHttpRequest;
    }
    
    private static okhttp3.RequestBody createMultipartRequestBody(HttpRequest httpRequest) {
        okhttp3.MultipartBody.Builder multipartBuilder = new okhttp3.MultipartBody.Builder()
                .setType(okhttp3.MultipartBody.FORM);
        
        for (SimpleEntry<String, Object> param : httpRequest.getParameters()) {
            if (param.getValue() instanceof MultipartFileWrapper) {
                MultipartFileWrapper wrapperObj = (MultipartFileWrapper) param.getValue();
                okhttp3.MediaType mediaType;
                if (wrapperObj.getFileWrapper().getContentType() != null
                        && !wrapperObj.getFileWrapper().getContentType().isEmpty()) {
                    mediaType =
                            okhttp3.MediaType.parse(wrapperObj.getFileWrapper().getContentType());
                } else {
                    mediaType =
                            okhttp3.MediaType.parse(wrapperObj.getHeaders().value("content-type"));
                }

                okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType,
                        wrapperObj.getFileWrapper().getFile());
                Headers fileWrapperHeaders = new Headers(wrapperObj.getHeaders());
                fileWrapperHeaders.remove("content-type");
                okhttp3.Headers.Builder fileWrapperHeadersBuilder =
                        createRequestHeaders(fileWrapperHeaders);
                
                fileWrapperHeadersBuilder.add("Content-Disposition", "form-data; name="
                        + appendQuotedStringAndEncodeEscapeCharacters(param.getKey()) 
                        + "; filename=" + appendQuotedStringAndEncodeEscapeCharacters(
                                wrapperObj.getFileWrapper().getFile().getName()));
                multipartBuilder.addPart(fileWrapperHeadersBuilder.build(), body);
            } else if (param.getValue() instanceof MultipartWrapper) {
                MultipartWrapper wrapperObject = (MultipartWrapper) param.getValue();
                okhttp3.RequestBody body = okhttp3.RequestBody.create(
                    okhttp3.MediaType.parse(wrapperObject.getHeaders().value("content-type")),
                    wrapperObject.getByteArray());
                Headers wrapperHeaders = new Headers(wrapperObject.getHeaders());
                wrapperHeaders.remove("content-type");
                okhttp3.Headers.Builder wrapperHeadersBuilder =
                        createRequestHeaders(wrapperHeaders);

                wrapperHeadersBuilder.add("Content-Disposition", "form-data; name="
                        + appendQuotedStringAndEncodeEscapeCharacters(param.getKey()));
                multipartBuilder.addPart(wrapperHeadersBuilder.build(), body);
            } else {
                multipartBuilder.addFormDataPart(param.getKey(),
                        (param.getValue() == null) ? "" : param.getValue().toString());
            }
        }
        return multipartBuilder.build();
    }

    private static okhttp3.Headers.Builder createRequestHeaders(Headers headers) {
        okhttp3.Headers.Builder requestHeaders = new okhttp3.Headers.Builder();
        for (Entry<String, List<String>> kv : headers.asMultimap().entrySet()) {
            for (String value : kv.getValue()) {
                requestHeaders.add(kv.getKey(), value);
            }
        }
        return requestHeaders;
    }

    private static String appendQuotedStringAndEncodeEscapeCharacters(String key) {
        String target = "\"";
        for (int i = 0, len = key.length(); i < len; i++) {
            char ch = key.charAt(i);
            switch (ch) {
                case '\n':
                    target += "%0A";
                    break;
                case '\r':
                    target += "%0D";
                    break;
                case '"':
                    target += "%22";
                    break;
                default:
                    target += ch;
                    break;
            }
        }
        target += '"';
        return target;
    }

    /**
     * Create a simple HTTP GET request.
     */
    public HttpRequest get(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.GET, queryUrlBuilder, headers, queryParams, parameters);
    }

    /**
     * Create a simple HTTP HEAD request.
     */
    public HttpRequest head(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.HEAD, queryUrlBuilder, headers, queryParams, parameters);
    }

    /**
     * Create an HTTP POST request with parameters.
     */
    public HttpRequest post(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.POST, queryUrlBuilder, headers, queryParams, parameters);
    }

    /**
     * Create an HTTP POST request with body.
     */
    public HttpBodyRequest postBody(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, Object body) {
        return new HttpBodyRequest(HttpMethod.POST, queryUrlBuilder, headers, queryParams, body);
    }


    /**
     * Create an HTTP PUT request with parameters.
     */
    public HttpRequest put(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.PUT, queryUrlBuilder, headers, queryParams, parameters);
    }

    /**
     * Create an HTTP PUT request with body.
     */
    public HttpBodyRequest putBody(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, Object body) {
        return new HttpBodyRequest(HttpMethod.PUT, queryUrlBuilder, headers, queryParams, body);
    }

    /**
     * Create an HTTP PATCH request with parameters.
     */
    public HttpRequest patch(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.PATCH, queryUrlBuilder, headers, queryParams, parameters);
    }

    /**
     * Create an HTTP PATCH request with body.
     */
    public HttpBodyRequest patchBody(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, Object body) {
        return new HttpBodyRequest(HttpMethod.PATCH, queryUrlBuilder, headers, queryParams, body);
    }

    /**
     * Create an HTTP DELETE request with parameters.
     */
    public HttpRequest delete(StringBuilder queryUrl, Headers headers, 
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.DELETE, queryUrl, headers, queryParams, parameters);
    }

    /**
     * Create an HTTP DELETE request with body.
     */
    public HttpBodyRequest deleteBody(StringBuilder queryUrlBuilder, Headers headers, 
            Map<String, Object> queryParams, Object body) {
        return new HttpBodyRequest(HttpMethod.DELETE, queryUrlBuilder, headers, queryParams, body);
    }

}
