package com.squareup.square.legacy.http.request;

import com.squareup.square.legacy.http.Headers;
import java.util.Map;

/**
 * HTTP Request with an explicit body.
 */
public class HttpBodyRequest extends HttpRequest {

    /**
     * Create a request with explicit body.
     * @param method          The HTTP method to use. Can be PUT, POST, DELETE and PATCH
     * @param queryUrlBuilder The fully qualified absolute http url to create the HTTP Request.
     * @param headers         The key-value map of all http headers to be sent
     * @param queryParams     The query parameters in a key-value map
     * @param body            The object to be sent as body after serialization
     */
    public HttpBodyRequest(
            HttpMethod method,
            StringBuilder queryUrlBuilder,
            Headers headers,
            Map<String, Object> queryParams,
            Object body) {
        super(method, queryUrlBuilder, headers, queryParams, body);
    }

    /**
     * Converts this HttpBodyRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpBodyRequest [httpMethod=" + getHttpMethod()
                + ", headers=" + getHeaders() + ", queryUrlBuilder=" + getQueryUrl()
                + ", queryParameters=" + getQueryParameters() + ", body=" + getBody() + "]";
    }
}
