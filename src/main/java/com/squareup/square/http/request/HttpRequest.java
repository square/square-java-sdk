package com.squareup.square.http.request;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import com.squareup.square.http.Headers;

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
     * @param _method     The HTTP method to use. Can be GET, HEAD, PUT, POST, DELETE and PATCH
     * @param _queryUrl   The http url to create the HTTP Request. Expect a fully qualified absolute Url
     * @param _headers    The key-value map of all http headers to be sent
     * @param _parameters The form data values in a key-value map
     * @return Http request initialized with the given method, url and headers
     */
    public HttpRequest(HttpMethod _method, String _queryUrl,
                       Headers _headers, List<SimpleEntry<String, Object>> _parameters) {
        this.httpMethod = _method;
        this.queryUrl = _queryUrl;
        this.headers = _headers;
        this.parameters = _parameters;
    }
}
