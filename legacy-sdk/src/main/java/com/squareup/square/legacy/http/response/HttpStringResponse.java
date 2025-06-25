package com.squareup.square.legacy.http.response;

import com.squareup.square.legacy.http.Headers;
import java.io.InputStream;

/**
 * Class to hold response body as string.
 */
public class HttpStringResponse extends HttpResponse {

    /**
     * Initialization constructor.
     * @param code    The HTTP status code
     * @param headers The HTTP headers read from response
     * @param rawBody The raw data returned in the HTTP response
     * @param body String response body
     */
    public HttpStringResponse(int code, Headers headers, InputStream rawBody, String body) {
        super(code, headers, rawBody, body);
    }

    /**
     * Converts this HttpStringResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpStringResponse [statusCode=" + getStatusCode() + ", headers=" + getHeaders() + ", body=" + getBody()
                + "]";
    }
}
