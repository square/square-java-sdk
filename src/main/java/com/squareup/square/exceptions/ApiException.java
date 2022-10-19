
package com.squareup.square.exceptions;

import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.square.models.Error;
import com.squareup.square.models.Payment;
import io.apimatic.core.types.CoreApiException;
import io.apimatic.core.utilities.CoreHelper;
import io.apimatic.coreinterfaces.http.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the base class for all exceptions that represent an error response from the server.
 */
public class ApiException extends CoreApiException {
    //UID for serialization
    private static final long serialVersionUID = 1L;

    //private fields
    private Object data;
    private List<Error> errors;

    /**
     * Initialization constructor.
     * @param reason The reason for throwing exception
     */
    public ApiException(String reason) {
        super(reason);
        // TODO Auto-generated constructor stub
    }

    /**
     * Initialization constructor.
     * @param   reason  The reason for throwing exception
     * @param   context The http context of the API exception
     */
    public ApiException(String reason, Context context) {
        super(reason, context);
        try {
            // Can throw IOException if input has invalid content type.
            JsonNode jsonNode = CoreHelper.mapper.readTree(context.getResponse().getBody());

            if (jsonNode.hasNonNull("payment")) {
                data = CoreHelper.mapper.convertValue(jsonNode.get("payment"), Payment.class);
            }
            if (jsonNode.hasNonNull("errors")) {
                errors = Arrays.asList(CoreHelper.mapper.convertValue(
                        jsonNode.get("errors"), Error[].class));
            } else {
                errors = new ArrayList<>();
                Error.Builder v1ErrorBuilder = new Error.Builder("V1_ERROR",
                        jsonNode.hasNonNull("type") ? jsonNode.get("type").asText() : null);
                if (jsonNode.hasNonNull("message")) {
                    v1ErrorBuilder.detail(jsonNode.get("message").asText());
                }
                errors.add(v1ErrorBuilder.build());
            }
        } catch (IOException ioException) { 
            // Can throw exception while object mapper tries to:
            // Deserialize the content as JSON tree.
            // Convert results from JSON tree into given value type.
        }
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