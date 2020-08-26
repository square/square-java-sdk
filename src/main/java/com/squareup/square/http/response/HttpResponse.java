package com.squareup.square.http.response;

import java.io.InputStream;

import com.squareup.square.http.Headers;

/**
 * Class to hold HTTP Response
 */
public class HttpResponse {

    /**
     * Private store for properties
     */
    int statusCode;
    Headers headers;
    InputStream rawBody;

    /**
     * HTTP Status code of the http response
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Headers of the http response
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Raw body of the http response
     */
    public InputStream getRawBody() {
        return rawBody;
    }

    /**
     * @param code    The HTTP status code
     * @param headers The HTTP headers read from response
     * @param rawBody The raw data returned by the HTTP request
     */
    public HttpResponse(int code, Headers headers, InputStream rawBody) {
        this.statusCode = code;
        this.headers = headers;
        this.rawBody = rawBody;
    }
}