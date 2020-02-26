package com.squareup.square.http.client;
import com.squareup.square.utilities.FileWrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpBodyRequest;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;


/**
 * HTTP Client class to send HTTP Requests and read the responses.
 */
public class OkClient implements HttpClient {
    private final static Object syncObject = new Object();
    private static okhttp3.OkHttpClient defaultOkHttpClient;
    
    /**
     * Private instance of the okhttp3.OkHttpClient
     */
    private okhttp3.OkHttpClient client;

    /**
     * Default constructor
     */
    public OkClient(HttpClientConfiguration httpClientConfig) {
        okhttp3.OkHttpClient.Builder clientBuilder = getDefaultOkHttpClient().newBuilder();
        clientBuilder.callTimeout(httpClientConfig.getTimeout(), TimeUnit.SECONDS);
        this.client = clientBuilder.build();
    }

    /**
     * Getter for the default static instance of the okhttp3.OkHttpClient
     */
    private okhttp3.OkHttpClient getDefaultOkHttpClient() {
        if (defaultOkHttpClient == null) {
            synchronized (syncObject) {
                if (defaultOkHttpClient == null) {
                    defaultOkHttpClient = new okhttp3.OkHttpClient.Builder()
                            .addInterceptor(new HttpRedirectInterceptor(true))
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
     * Execute a given HttpRequest to get string response back
     * @param   request     The given HttpRequest to execute
     * @return   CompletableFuture<HttpResponse> after execution
     */
    public CompletableFuture<HttpResponse> executeAsStringAsync(final HttpRequest httpRequest) {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        final CompletableFuture<HttpResponse> callBack = new CompletableFuture<>();
        client.newCall(okHttpRequest).enqueue(new okhttp3.Callback() {

            public void onFailure(okhttp3.Call call, IOException e) {
                try {
                    publishResponse(null, httpRequest, callBack, e, false);
                } catch (IOException ex) {
                    callBack.completeExceptionally(ex);
                }
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response okHttpResponse) throws IOException {
                try {
                    publishResponse(okHttpResponse, httpRequest, callBack, null, false);
                } catch (IOException ex) {
                    callBack.completeExceptionally(ex);
                } finally {
                    okHttpResponse.close();
                }
            }
        });

        return callBack;
    }

    /**
     * Execute a given HttpRequest to get binary response back
     * @param   request     The given HttpRequest to execute
     * @return   CompletableFuture<HttpResponse> after execution
     */
    public CompletableFuture<HttpResponse> executeAsBinaryAsync(final HttpRequest httpRequest) {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        final CompletableFuture<HttpResponse> callBack = new CompletableFuture<>();
        client.newCall(okHttpRequest).enqueue(new okhttp3.Callback() {

            public void onFailure(okhttp3.Call call, IOException e) {
                try {
                    publishResponse(null, httpRequest, callBack, e, true);
                } catch (IOException ex) {
                    callBack.completeExceptionally(ex);
                }
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response okHttpResponse) throws IOException {
                try {
                    publishResponse(okHttpResponse, httpRequest, callBack, null, true);
                } catch (IOException ex) {
                    callBack.completeExceptionally(ex);
                }
            }
        });

        return callBack;
    }

    /**
     * Execute a given HttpRequest to get string response back
     * @param   request     The given HttpRequest to execute     
     */
    public HttpResponse executeAsString(HttpRequest httpRequest) throws IOException {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        okhttp3.Response okHttpResponse = client.newCall(okHttpRequest).execute();
        return convertResponse(okHttpResponse, false);
    }

    /**
     * Execute a given HttpRequest to get binary response back
     * @param   request     The given HttpRequest to execute     
     */
    public HttpResponse executeAsBinary(HttpRequest httpRequest) throws IOException {
        okhttp3.Request okHttpRequest = convertRequest(httpRequest);
        okhttp3.Response okHttpResponse = client.newCall(okHttpRequest).execute();
        return convertResponse(okHttpResponse, true);
    }

    /**
     * Publishes success or failure result as HttpResponse from a HttpRequest
     * @param   okHttpResponse  The okhttp response to publish
     * @param   httpRequest     The internal http request
     * @param   completionBlock The success and failure code block reference to invoke the delegate
     * @param   error           The reported errors for getting the http response
     */
    private static HttpResponse publishResponse(okhttp3.Response okHttpResponse, HttpRequest httpRequest,
            CompletableFuture<HttpResponse> completionBlock, Throwable error, boolean binaryResponse) throws IOException {
        HttpResponse httpResponse = null;
        try {
            httpResponse = OkClient.convertResponse(okHttpResponse, binaryResponse);

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
     * Converts a given OkHttp response into our internal http response model
     * @param   response    The given OkHttp response
     * @return              The converted http response
     * @throws              IOException
     */
    private static HttpResponse convertResponse(okhttp3.Response response, boolean binaryResponse) throws IOException {
        HttpResponse httpResponse = null;

        if (null == response) {
            return null;
        }

        okhttp3.ResponseBody responseBody = response.body();

        Headers headers = new Headers(response.headers().toMultimap());

        if (binaryResponse) {
            InputStream responseStream = responseBody.byteStream();
            httpResponse = new HttpResponse(response.code(), headers, responseStream);
        } else {
            String responseString = responseBody.string();
            InputStream responseStream = new ByteArrayInputStream(responseString.getBytes());
            httpResponse = new HttpStringResponse(response.code(), headers, responseStream, responseString);

            responseBody.close();
            response.close();
        }

        return httpResponse;
    }

    /**
     * Converts a given internal http request into an okhttp request model
     * @param   request     The given http request in internal format
     * @return              The converted okhttp request
     */
    private static okhttp3.Request convertRequest(HttpRequest httpRequest) {
        String url = httpRequest.getQueryUrl();

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
                    if ((param.getValue() instanceof MultipartFileWrapper) || (param.getValue() instanceof MultipartWrapper)) {
                        multipartRequest = true;
                        break;
                    }
                }

                if (multipartRequest) {
                    // make a multipart request if a file is being sent
                    okhttp3.MultipartBody.Builder multipartBuilder = new okhttp3.MultipartBody.Builder()
                            .setType(okhttp3.MultipartBody.FORM);
                    for (SimpleEntry<String, Object> param : parameters) {
                        if (param.getValue() instanceof MultipartFileWrapper) {
                            MultipartFileWrapper wrapperObj = (MultipartFileWrapper) param.getValue();
                            
                            okhttp3.MediaType mediaType;
                            if (wrapperObj.getFileWrapper().getContentType() != null && !wrapperObj.getFileWrapper().getContentType().isEmpty()) {
                                mediaType = okhttp3.MediaType.parse(wrapperObj.getFileWrapper().getContentType());
                            } else {
                                mediaType = okhttp3.MediaType.parse(wrapperObj.getHeaders().value("content-type"));
                            }

                            okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, 
                                wrapperObj.getFileWrapper().getFile());
                            Headers fileWrapperHeaders = new Headers(wrapperObj.getHeaders());
                            fileWrapperHeaders.remove("content-type");
                            okhttp3.Headers.Builder fileWrapperHeadersBuilder = createRequestHeaders(fileWrapperHeaders);

                            fileWrapperHeadersBuilder.add(
                                "Content-Disposition", "form-data; name=" + appendQuotedStringAndEncodeEscapeCharacters(param.getKey()) +
                                "; filename=" + appendQuotedStringAndEncodeEscapeCharacters(wrapperObj.getFileWrapper().getFile().getName()));
                            multipartBuilder.addPart(fileWrapperHeadersBuilder.build(), body);
                        } else if (param.getValue() instanceof MultipartWrapper) {
                            MultipartWrapper wrapperObject = (MultipartWrapper) param.getValue();
                            okhttp3.RequestBody body = okhttp3.RequestBody.create(
                                okhttp3.MediaType.parse(wrapperObject.getHeaders().value("content-type")),
                                wrapperObject.getByteArray());
                            Headers wrapperHeaders = new Headers(wrapperObject.getHeaders());
                            wrapperHeaders.remove("content-type");
                            okhttp3.Headers.Builder wrapperHeadersBuilder = createRequestHeaders(wrapperHeaders);
                            wrapperHeadersBuilder.add(
                                "Content-Disposition", "form-data; name=" + appendQuotedStringAndEncodeEscapeCharacters(param.getKey()));
                            multipartBuilder.addPart(wrapperHeadersBuilder.build(), body);
                        } else {
                            multipartBuilder.addFormDataPart(param.getKey(),
                                    (param.getValue() == null) ? "" : param.getValue().toString());
                        }
                    }
                    requestBody = multipartBuilder.build();
                } else {
                    okhttp3.FormBody.Builder formBuilder = new okhttp3.FormBody.Builder();
                    for (SimpleEntry<String, Object> param : parameters) {
                        formBuilder.add(param.getKey(), (param.getValue() == null) ? "" : param.getValue().toString());
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

        // build the request
        okhttp3.Request okHttpRequest = new okhttp3.Request.Builder()
                .method(httpRequest.getHttpMethod().toString(), requestBody).headers(requestHeaders.build()).url(url)
                .build();

        return okHttpRequest;
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
     * Create a simple HTTP GET request
     */
    public HttpRequest get(String queryUrl, Headers headers, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.GET, queryUrl, headers, parameters);
    }

    /**
     * Create a simple HTTP HEAD request
     */
    public HttpRequest head(String queryUrl, Headers headers, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.HEAD, queryUrl, headers, parameters);
    }

    /**
     * Create an HTTP POST request with parameters
     */
    public HttpRequest post(String queryUrl, Headers headers, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.POST, queryUrl, headers, parameters);
    }

    /**
     * Create an HTTP POST request with body
     */
    public HttpBodyRequest postBody(String queryUrl, Headers headers, Object body) {
        return new HttpBodyRequest(HttpMethod.POST, queryUrl, headers, body);
    }


    /**
     * Create an HTTP PUT request with parameters
     */
    public HttpRequest put(String queryUrl, Headers headers,
            List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.PUT, queryUrl, headers, parameters);
    }

    /**
     * Create an HTTP PUT request with body
     */
    public HttpBodyRequest putBody(String queryUrl, Headers headers, Object body) {
        return new HttpBodyRequest(HttpMethod.PUT, queryUrl, headers, body);
    }

    /**
     * Create an HTTP PATCH request with parameters
     */
    public HttpRequest patch(String queryUrl, Headers headers, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.PATCH, queryUrl, headers, parameters);
    }

    /**
     * Create an HTTP PATCH request with body
     */
    public HttpBodyRequest patchBody(String queryUrl, Headers headers, Object body) {
        return new HttpBodyRequest(HttpMethod.PATCH, queryUrl, headers, body);
    }

    /**
     * Create an HTTP DELETE request with parameters
     */
    public HttpRequest delete(String queryUrl, Headers headers, List<SimpleEntry<String, Object>> parameters) {
        return new HttpRequest(HttpMethod.DELETE, queryUrl, headers, parameters);
    }

    /**
     * Create an HTTP DELETE request with body
     */
    public HttpBodyRequest deleteBody(String queryUrl, Headers headers, Object body) {
        return new HttpBodyRequest(HttpMethod.DELETE, queryUrl, headers, body);
    }

}
