package com.squareup.square.legacy.http.request;

import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.http.Headers;
import io.apimatic.coreinterfaces.http.request.ArraySerializationFormat;
import io.apimatic.coreinterfaces.http.request.Request;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for creating and managing HTTP Requests.
 */
public class HttpRequest implements Request {

    /**
     * Private store for properties.
     */
    private HttpMethod httpMethod;

    private Headers headers;
    private StringBuilder queryUrlBuilder;
    private List<SimpleEntry<String, Object>> parameters;
    private Map<String, Object> queryParameters;
    private Object body;

    /**
     * Initializes a simple http request.
     * @param method           The HTTP method to use. Can be GET, HEAD, PUT, POST, DELETE and PATCH
     * @param queryUrlBuilder  The fully qualified absolute http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent
     * @param queryParameters  The query parameters in a key-value map
     * @param parameters       The form data values in a key-value map
     */
    public HttpRequest(
            HttpMethod method,
            StringBuilder queryUrlBuilder,
            Headers headers,
            Map<String, Object> queryParameters,
            List<SimpleEntry<String, Object>> parameters) {
        this.httpMethod = method;
        this.queryUrlBuilder = queryUrlBuilder;
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.parameters = parameters;
    }

    /**
     * Initializes a simple http request.
     *
     * @param method The HTTP method to use. Can be GET, HEAD, PUT, POST, DELETE and PATCH
     * @param queryUrlBuilder The fully qualified absolute http url to create the HTTP Request.
     * @param headers The key-value map of all http headers to be sent
     * @param queryParameters The query parameters in a key-value map
     * @param body The object to be sent as body after serialization
     */
    public HttpRequest(
            HttpMethod method,
            StringBuilder queryUrlBuilder,
            Headers headers,
            Map<String, Object> queryParameters,
            Object body) {
        this(method, queryUrlBuilder, headers, queryParameters, null);
        this.body = body != null ? body : "";
    }

    /**
     * HttpMethod for the http request.
     * @return HttpMethod
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * Headers for the http request.
     * @return Headers
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Query url for the http request.
     * @return String query url
     */
    public String getQueryUrl() {
        return queryUrlBuilder.toString();
    }

    /**
     * Parameters for the http request.
     * @return List of simple entries for form parameters
     */
    public List<SimpleEntry<String, Object>> getParameters() {
        return parameters;
    }

    /**
     * Query parameters for the http request.
     * @return Map of queryParameters
     */
    public Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    /**
     * Body for the http request.
     *
     * @return Object body
     */
    public Object getBody() {
        return body;
    }

    /**
     * Add Query parameter in http request.
     * @param key   The key of query parameter to be added
     * @param value The value for respective query parameter
     */
    public void addQueryParameter(String key, Object value) {
        if (key == null || key.isEmpty() || value == null) {
            return;
        }
        if (queryParameters == null) {
            queryParameters = new HashMap<String, Object>();
        }
        queryParameters.put(key, value);
    }

    /**
     * Converts this HttpRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "HttpRequest [httpMethod=" + httpMethod + ", headers=" + headers
                + ", queryUrlBuilder=" + queryUrlBuilder + ", queryParameters=" + queryParameters
                + ", parameters=" + parameters + "]";
    }

    /**
     * Get the request URL
     *
     * @param arraySerializationFormat Array serialization format
     * @return The complete URL including serialized query parameters
     */
    @Override
    public String getUrl(ArraySerializationFormat arraySerializationFormat) {
        return getQueryUrl();
    }

    /**
     * Get the request URL without query parameters
     *
     * @return The complete URL excluding query parameters
     */
    @Override
    public String getUrl() {
        return ApiHelper.removeQueryParametersFromUrl(getQueryUrl());
    }
}
