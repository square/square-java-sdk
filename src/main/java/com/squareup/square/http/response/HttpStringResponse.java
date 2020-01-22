package com.squareup.square.http.response;

import java.io.InputStream;

import com.squareup.square.http.Headers;

/**
 * Class to hold response body as string.
 */
public class HttpStringResponse extends HttpResponse {

    /**
     * Private store for properties
     */
    private String body;

    /**
     * String body of the http response
     */
    public String getBody() {
        return body;
    }

    /**
     * @param code    The HTTP status code
     * @param headers The HTTP headers read from response
     * @param rawBody The raw data returned by the HTTP request
     */
    public HttpStringResponse(int code, Headers headers, InputStream rawBody, String body) {
        super(code, headers, rawBody);
        this.body = body;
    }
}
