package com.squareup.square.exceptions;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.square.ApiHelper;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.models.Error;

/**
 * This is the base class for all exceptions that represent an error response from the server.
 */
public class ApiException extends Exception {
    //UID for serialization
    private static final long serialVersionUID = 6424174253911720338L;

    //private fields
    private HttpContext httpContext;
    private List<Error> errors;

    /**
    * The HTTP response code from the API request
    */
    public int getResponseCode() {
        return (httpContext != null) ? httpContext.getResponse().getStatusCode() : -1;
    }

    /**
     * The HTTP response body from the API request
     */
    public HttpContext getHttpContext() {
        return httpContext;
    }

    /**
     * Initialization constructor
     * @param reason The reason for throwing exception
     */
    public ApiException(String reason) {
        super(reason);
    }

    /**
     * @return   A list of errors
     */
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Initialization constructor
     * @param   reason  The reason for throwing exception
     * @param   context The http context of the API exception
     */
    public ApiException(String reason, HttpContext context) {
        super(reason);
        this.httpContext = context;

        //if a derived exception class is used, then perform deserialization of response body
        if ((context == null) || (context.getResponse() == null)
            || (context.getResponse().getRawBody() == null)) {
            return;
        }

        try {
            // Can throw IOException if input has invalid content type.
            JsonNode jsonNode = ApiHelper.mapper.readTree(context.getResponse().getRawBody());
            if (jsonNode.hasNonNull("errors")) {
                errors = Arrays.asList(ApiHelper.mapper.convertValue(jsonNode.get("errors"), Error[].class));
            } else {
            	errors = new ArrayList<>();
                Error.Builder v1ErrorBuilder = new Error.Builder("V1_ERROR", jsonNode.get("type").asText());
                if (jsonNode.hasNonNull("message")) {
                    v1ErrorBuilder.detail(jsonNode.get("message").asText());
                }
                errors.add(v1ErrorBuilder.build());
            }
            if (!getClass().equals(ApiException.class)) {
                // Can throw IOException if source format, in this case JsonNode, cannot be detected.
                ApiHelper.mapper.readerForUpdating(this).readValue(jsonNode);
            }
        } catch (IOException ioException) { 
            // Can throw exception while object mapper tries to deserialize the content as JSON tree.
            // Can throw exception while object mapper tries to convert results from JSON tree into given value type.
        }
    }
}
