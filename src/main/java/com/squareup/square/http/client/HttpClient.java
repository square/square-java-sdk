
package com.squareup.square.http.client;

import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpBodyRequest;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.request.configuration.RetryConfiguration;
import com.squareup.square.http.response.HttpResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * HTTP Client to send HTTP Requests and read the responses.
 */
public interface HttpClient {

    /**
     * Execute a given HttpRequest to get string/binary response back.
     * @param   request            The given HttpRequest to execute.
     * @param   hasBinaryResponse  Whether the response is binary or string.
     * @return  CompletableFuture of HttpResponse after execution.
     */
    public CompletableFuture<HttpResponse> executeAsync(final HttpRequest request,
            boolean hasBinaryResponse);

    /**
     * Execute a given HttpRequest to get string/binary response back.
     * @param request The given HttpRequest to execute.
     * @param hasBinaryResponse Whether the response is binary or string.
     * @param retryConfiguration The overridden retry configuration for request.
     * @return CompletableFuture of HttpResponse after execution.
     */
    public CompletableFuture<HttpResponse> executeAsync(final HttpRequest request,
            boolean hasBinaryResponse, RetryConfiguration retryConfiguration);

    /**
     * Execute a given HttpRequest to get string/binary response back.
     * @param   request            The given HttpRequest to execute.
     * @param   hasBinaryResponse  Whether the response is binary or string.
     * @return  The converted http response.
     * @throws  IOException exception to be thrown while converting response.
     */
    public HttpResponse execute(final HttpRequest request, boolean hasBinaryResponse)
            throws IOException;

    /**
     * Execute a given HttpRequest to get string/binary response back.
     * @param request The given HttpRequest to execute.
     * @param hasBinaryResponse Whether the response is binary or string.
     * @param retryConfiguration The overridden retry configuration for request.
     * @return The converted http response.
     * @throws IOException exception to be thrown while converting response.
     */
    public HttpResponse execute(final HttpRequest request, boolean hasBinaryResponse,
            RetryConfiguration retryConfiguration) throws IOException;

    /**
     * Create a simple HTTP GET request.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param parameters       The form data values in a key-value map.
     * @return Returns the object of HttpRequest
     */
    public HttpRequest get(StringBuilder queryUrlBuilder, Headers headers,
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters);

    /**
    * Create a simple HTTP HEAD request.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param parameters       The form data values in a key-value map.
     * @return Returns the object of HttpRequest
    */
    public HttpRequest head(StringBuilder queryUrlBuilder, Headers headers,
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters);

    /**
     * Create an HTTP POST request with parameters.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param parameters       The form data values in a key-value map.
     * @return Returns the object of HttpRequest
     */
    public HttpRequest post(StringBuilder queryUrlBuilder, Headers headers,
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters);

    /**
     * Create an HTTP POST request with body.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param body             The object to be sent as body after serialization.
     * @return Returns the object of HttpBodyRequest
     */
    public HttpBodyRequest postBody(StringBuilder queryUrlBuilder,
            Headers headers, Map<String, Object> queryParams, Object body);

    /**
     * Create an HTTP PUT request with parameters.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param parameters       The form data values in a key-value map.
     * @return Returns the object of HttpRequest
     */
    public HttpRequest put(StringBuilder queryUrlBuilder, Headers headers,
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters);

    /**
     * Create an HTTP PUT request with body.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param body             The object to be sent as body after serialization.
     * @return Returns the object of HttpBodyRequest
     */
    HttpBodyRequest putBody(StringBuilder queryUrlBuilder,
            Headers headers, Map<String, Object> queryParams, Object body);

    /**
     * Create an HTTP PATCH request with parameters.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param parameters       The form data values in a key-value map.
     * @return Returns the object of HttpRequest
     */
    public HttpRequest patch(StringBuilder queryUrlBuilder, Headers headers,
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters);

    /**
     * Create an HTTP PATCH request with body.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param body             The object to be sent as body after serialization.
     * @return Returns the object of HttpBodyRequest
     */
    public HttpBodyRequest patchBody(StringBuilder queryUrlBuilder,
            Headers headers, Map<String, Object> queryParams, Object body);

    /**
     * Create an HTTP DELETE request with parameters.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param parameters       The form data values in a key-value map.
     * @return Returns the object of HttpRequest
     */
    HttpRequest delete(StringBuilder queryUrlBuilder, Headers headers,
            Map<String, Object> queryParams, List<SimpleEntry<String, Object>> parameters);

    /**
     * Create an HTTP DELETE request with body.
     * @param queryUrlBuilder  The http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent.
     * @param queryParams      The query parameters in a key-value map.
     * @param body             The object to be sent as body after serialization.
     * @return Returns the object of HttpBodyRequest
     */
    public HttpBodyRequest deleteBody(StringBuilder queryUrlBuilder,
            Headers headers, Map<String, Object> queryParams, Object body);
}