
package com.squareup.square.http.client;

import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;

/**
 * Class to wrap the request sent to the server and the response received from the server.
 */
public class HttpContext {
    private HttpRequest request;
    private HttpResponse response;

    /**
     * Initialization constructor.
     * @param request  Instance of HttpRequest.
     * @param response Instance of HttpResponse.
     */
    public HttpContext(HttpRequest request, HttpResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * Getter for the Http Request.
     * @return HttpRequest request.
     */
    public HttpRequest getRequest() {
        return request;
    }

    /**
     * Getter for the Http Response.
     * @return HttpResponse response.
     */
    public HttpResponse getResponse() {
        return response;
    }

    /**
     * Converts this HttpContext into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpContext [request=" + request + ", response=" + response + "]";
    }
}