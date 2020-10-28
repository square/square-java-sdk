
package com.squareup.square.exceptions;

import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.square.ApiHelper;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.models.Error;
import com.squareup.square.models.Payment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the base class for all exceptions that represent an error response from the server.
 */
public class ApiException extends Exception {
    //UID for serialization
    private static final long serialVersionUID = 6424174253911720338L;

    //private fields
    private HttpContext httpContext;
    private Object data;
    private List<Error> errors;

    /**
     * Initialization constructor.
     * @param reason The reason for throwing exception
     */
    public ApiException(String reason) {
        super(reason);
    }

    /**
     * Initialization constructor.
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
            if (jsonNode.hasNonNull("payment")) {
                data = ApiHelper.mapper.convertValue(jsonNode.get("payment"), Payment.class);
            }
            if (jsonNode.hasNonNull("errors")) {
                errors = Arrays.asList(ApiHelper.mapper.convertValue(
                        jsonNode.get("errors"), Error[].class));
            } else {
                errors = new ArrayList<>();
                Error.Builder v1ErrorBuilder = new Error.Builder("V1_ERROR",
                        jsonNode.get("type").asText());
                if (jsonNode.hasNonNull("message")) {
                    v1ErrorBuilder.detail(jsonNode.get("message").asText());
                }
                errors.add(v1ErrorBuilder.build());
            }
            if (!getClass().equals(ApiException.class)) {
                // In case of IOException JsonNode cannot be detected.
                ApiHelper.mapper.readerForUpdating(this).readValue(jsonNode);
            }
        } catch (IOException ioException) { 
            // Can throw exception while object mapper tries to:
            // Deserialize the content as JSON tree.
            // Convert results from JSON tree into given value type.
        }
    }

    /**
     * The HTTP response code from the API request.
     * @return   Returns the response code for ApiException
     */
    public int getResponseCode() {
        return (httpContext != null) ? httpContext.getResponse().getStatusCode() : -1;
    }

    /**
     * The HTTP response body from the API request.
     * @return   Returns the object of HttpContext for ApiException
     */
    public HttpContext getHttpContext() {
        return httpContext;
    }

     /**
     * Returns data about the steps that completed successfully before an error was raised.
     * This field is currently only populated for the PaymentsApi.createPayment endpoint.
     * @return   Response from the API call.
     */
    public Object getData() {
        return data;
    }

   /**
     * Getter for the list of errors.
     * @return   A list of errors
     */
    public List<Error> getErrors() {
        return errors;
    }
}