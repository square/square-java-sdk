package com.squareup.square.legacy.http.response;

import com.squareup.square.legacy.http.Headers;
import io.apimatic.coreinterfaces.http.response.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Class to hold HTTP Response.
 */
public class HttpResponse implements Response {

    /**
     * Private store for properties.
     */
    private int statusCode;

    private Headers headers;
    private InputStream rawBody;
    private String body;

    /**
     * Initialization constructor.
     * @param code    The HTTP status code
     * @param headers The HTTP headers read from response
     * @param rawBody The raw data returned in the HTTP response
     */
    public HttpResponse(int code, Headers headers, InputStream rawBody) {
        this.statusCode = code;
        this.headers = headers;
        this.rawBody = rawBody;
    }

    /**
     * Initialization constructor.
     *
     * @param code The HTTP status code
     * @param headers The HTTP headers read from response
     * @param rawBody The raw data returned in the HTTP response
     * @param body String response body
     */
    public HttpResponse(int code, Headers headers, InputStream rawBody, String body) {
        this(code, headers, rawBody);
        this.body = body;
    }

    /**
     * HTTP Status code of the http response.
     * @return Int status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Headers of the http response.
     * @return Headers
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Raw body of the http response.
     * @return InputStream
     */
    public InputStream getRawBody() {
        return rawBody;
    }

    /**
     * String representation for raw body of the http response.
     * @return String
     */
    public String getRawBodyString() {
        try {
            if (rawBody == null || rawBody.available() == 0 || !rawBody.markSupported()) {
                return null;
            }
            rawBody.mark(0);
            String result =
                    new BufferedReader(new InputStreamReader(rawBody)).lines().collect(Collectors.joining("\n"));
            rawBody.reset();
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * String body of the http response.
     *
     * @return String response body
     */
    public String getBody() {
        return body;
    }

    /**
     * Converts this HttpResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpResponse [statusCode=" + statusCode + ", headers=" + headers + ", rawBody=" + getRawBodyString()
                + "]";
    }
}
