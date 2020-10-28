
package com.squareup.square.http.request;

import com.squareup.square.http.Headers;
import java.util.Map;

/**
 * HTTP Request with an explicit body.
 */
public class HttpBodyRequest extends HttpRequest {

    /**
     * Private store for properties.
     */
    private Object body;

    /**
     * Create a request with explicit body.
     * @param method          The HTTP method to use. Can be PUT, POST, DELETE and PATCH
     * @param queryUrlBuilder The fully qualified absolute http url to create the HTTP Request.
     * @param headers         The key-value map of all http headers to be sent
     * @param queryParams     The query parameters in a key-value map
     * @param body            The object to be sent as body after serialization
     */
    public HttpBodyRequest(HttpMethod method, StringBuilder queryUrlBuilder, Headers headers, 
             Map<String, Object> queryParams, Object body) {
        super(method, queryUrlBuilder, headers, queryParams, null);
        this.body = body != null ? body : "";
    }

    /**
     * Body for the http request.
     * @return Object body
     */
    public Object getBody() {
        return body;
    }
}
