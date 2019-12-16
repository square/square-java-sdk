package com.squareup.square.http.response;

import java.io.InputStream;

import com.squareup.square.http.Headers;

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
    public int getStatusCode() { return statusCode; }

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
     * @param _code    The HTTP status code
     * @param _headers The HTTP headers read from response
     * @param _rawBody The raw data returned by the HTTP request
     * @return Http response initialized with the given code, headers and rawBody
     */
    public HttpResponse(int _code, Headers _headers, InputStream _rawBody) {
        this.statusCode = _code;
        this.headers = _headers;
        this.rawBody = _rawBody;
    }
}
