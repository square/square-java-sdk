package com.squareup.square.http.request;

import com.squareup.square.http.Headers;

public class HttpBodyRequest extends HttpRequest {

    /**
     * Private store for properties
     */
    private String body;

    /**
     * Body for the http request
     */
    public String getBody() {
        return body;
    }

    /**
     * Create a request with explicit body
     *
     * @param _method   The HTTP method to use. Can be PUT, POST, DELETE and PATCH
     * @param _queryUrl The http url to create the HTTP Request. Expect a fully qualified absolute Url
     * @param _headers  The key-value map of all http headers to be sent
     * @param _body     The object to be sent as body after serialization
     * @return Http request initialized with the given method, url, headers and request body
     */
    public HttpBodyRequest(HttpMethod _method, String _queryUrl, Headers _headers, String _body) {
        super(_method, _queryUrl, _headers, null);
        this.body = _body!=null ? _body : "";
    }
}
