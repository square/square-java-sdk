package com.squareup.square.http.response;

import java.io.InputStream;

import com.squareup.square.http.Headers;

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
     * @param _code    The HTTP status code
     * @param _headers The HTTP headers read from response
     * @param _rawBody The raw data returned by the HTTP request
     * @return Http response initialized with the given code, headers and rawBody
     */
    public HttpStringResponse(int _code, Headers _headers, InputStream _rawBody, String body) {
        super(_code, _headers, _rawBody);
        this.body = body;
    }
}
