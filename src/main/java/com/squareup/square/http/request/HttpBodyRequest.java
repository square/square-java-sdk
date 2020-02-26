package com.squareup.square.http.request;

import com.squareup.square.http.Headers;

/**
 * HTTP Request with an explicit body
 */
public class HttpBodyRequest extends HttpRequest {

    /**
     * Private store for properties
     */
    private Object body;

    /**
     * Create a request with explicit body
     *
     * @param method   The HTTP method to use. Can be PUT, POST, DELETE and PATCH
     * @param queryUrl The http url to create the HTTP Request. Expect a fully qualified absolute Url
     * @param headers  The key-value map of all http headers to be sent
     * @param body     The object to be sent as body after serialization
     */
    public HttpBodyRequest(HttpMethod method, String queryUrl, Headers headers, Object body) {
        super(method, queryUrl, headers, null);
        this.body = body!=null ? body : "";
    }

    /**
     * Body for the http request
     */
    public Object getBody() {
        return body;
    }
}
