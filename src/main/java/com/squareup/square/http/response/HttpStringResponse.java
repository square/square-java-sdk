
package com.squareup.square.http.response;

import com.squareup.square.http.Headers;
import java.io.InputStream;

/**
 * Class to hold response body as string.
 */
public class HttpStringResponse extends HttpResponse {

    /**
     * Private store for properties.
     */
    private String body;

    /**
     * Initialization constructor.
     * @param code    The HTTP status code
     * @param headers The HTTP headers read from response
     * @param rawBody The raw data returned by the HTTP request
     * @param body String response body
     */
    public HttpStringResponse(int code, Headers headers, InputStream rawBody, String body) {
        super(code, headers, rawBody);
        this.body = body;
    }

    /**
     * String body of the http response.
     * @return String response body
     */
    public String getBody() {
        return body;
    }
}
