
package com.squareup.square.http.request;

import com.squareup.square.http.Headers;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for creating and managing HTTP Requests.
 */
public class HttpRequest {

    /**
     * Private store for properties.
     */
    private HttpMethod httpMethod;
    private Headers headers;
    private StringBuilder queryUrlBuilder;
    private List<SimpleEntry<String, Object>> parameters;
    private Map<String, Object> queryParameters;

    /**
     * Initializes a simple http request.
     * @param method           The HTTP method to use. Can be GET, HEAD, PUT, POST, DELETE and PATCH
     * @param queryUrlBuilder  The fully qualified absolute http url to create the HTTP Request.
     * @param headers          The key-value map of all http headers to be sent
     * @param queryParameters  The query parameters in a key-value map
     * @param parameters       The form data values in a key-value map
     */
    public HttpRequest(HttpMethod method, StringBuilder queryUrlBuilder, Headers headers, 
             Map<String, Object> queryParameters, List<SimpleEntry<String, Object>> parameters) {
        this.httpMethod = method;
        this.queryUrlBuilder = queryUrlBuilder;
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.parameters = parameters;
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
}
