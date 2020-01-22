package com.squareup.square.http.request;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import com.squareup.square.http.Headers;

/**
 * Class for creating and managing HTTP Requests
 */
public class HttpRequest {

    /**
     * Private store for properties
     */
    private HttpMethod httpMethod;
    private Headers headers;
    private String queryUrl;
    private List<SimpleEntry<String, Object>> parameters;

    /**
     * Headers for the http request
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * Headers for the http request
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Query url for the http request
     */
    public String getQueryUrl() {
        return queryUrl;
    }

    /**
     * Parameters for the http request
     */
    public List<SimpleEntry<String, Object>> getParameters() {
        return parameters;
    }

    /**
     * Initializes a simple http request
     *
     * @param method     The HTTP method to use. Can be GET, HEAD, PUT, POST, DELETE and PATCH
     * @param queryUrl   The http url to create the HTTP Request. Expect a fully qualified absolute Url
     * @param headers    The key-value map of all http headers to be sent
     * @param parameters The form data values in a key-value map
     */
    public HttpRequest(HttpMethod method, String queryUrl,
                       Headers headers, List<SimpleEntry<String, Object>> parameters) {
        this.httpMethod = method;
        this.queryUrl = queryUrl;
        this.headers = headers;
        this.parameters = parameters;
    }
}
