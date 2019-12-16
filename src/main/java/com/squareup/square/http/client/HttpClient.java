package com.squareup.square.http.client;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.squareup.square.http.Headers;
import com.squareup.square.http.request.HttpBodyRequest;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;


public interface HttpClient {

    /**
     * Execute a given HttpRequest to get string response back
     * @param   request     The given HttpRequest to execute
     * @return  CompletableFuture<HttpResponse> after execution
     */
    public CompletableFuture<HttpResponse> executeAsStringAsync(final HttpRequest request);

    /**
     * Execute a given HttpRequest to get binary response back
     * @param   request     The given HttpRequest to execute
     * @return   CompletableFuture<HttpResponse> after execution
     */
    public CompletableFuture<HttpResponse> executeAsBinaryAsync(final HttpRequest request);

    /**
     * Execute a given HttpRequest to get binary response back
     * @param   request     The given HttpRequest to execute     
     */
    public HttpResponse executeAsBinary(final HttpRequest request) throws IOException;

    /**
     * Execute a given HttpRequest to get string response back
     * @param   request     The given HttpRequest to execute     
     */
    public HttpResponse executeAsString(final HttpRequest request) throws IOException;


    /**
     * Create a simple HTTP GET request
     */
    public HttpRequest get(String _queryUrl,
                    Headers _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
    * Create a simple HTTP HEAD request
    */
    public HttpRequest head(String _queryUrl,
            Headers _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP POST request with parameters
     */
    public HttpRequest post(String _queryUrl,
                     Headers _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP POST request with body
     */
    public HttpBodyRequest postBody(String _queryUrl,
                             Headers _headers, String _body);

    /**
     * Create an HTTP PUT request with parameters
     */
    public HttpRequest put(String _queryUrl,
                    Headers _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP PUT request with body
     */
    HttpBodyRequest putBody(String _queryUrl,
                            Headers _headers, String _body);

    /**
     * Create an HTTP PATCH request with parameters
     */
    public HttpRequest patch(String _queryUrl,
                      Headers _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP PATCH request with body
     */
    public HttpBodyRequest patchBody(String _queryUrl,
                              Headers _headers, String _body);

    /**
     * Create an HTTP DELETE request with parameters
     */
    HttpRequest delete(String _queryUrl,
                       Headers _headers, List<SimpleEntry<String, Object>> _parameters);

    /**
     * Create an HTTP DELETE request with body
     */
    public HttpBodyRequest deleteBody(String _queryUrl,
                               Headers _headers, String _body);
}
