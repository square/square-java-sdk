
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkCreateCustomersResponse type.
 */
public class BulkCreateCustomersResponse {
    private HttpContext httpContext;
    private final Map<String, CreateCustomerResponse> responses;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  responses  Map of String, value for responses.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkCreateCustomersResponse(
            @JsonProperty("responses") Map<String, CreateCustomerResponse> responses,
            @JsonProperty("errors") List<Error> errors) {
        this.responses = responses;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Responses.
     * A map of responses that correspond to individual create requests, represented by key-value
     * pairs. Each key is the idempotency key that was provided for a create request and each value
     * is the corresponding response. If the request succeeds, the value is the new customer
     * profile. If the request fails, the value contains any errors that occurred during the
     * request.
     * @return Returns the Map of String, CreateCustomerResponse
     */
    @JsonGetter("responses")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, CreateCustomerResponse> getResponses() {
        return responses;
    }

    /**
     * Getter for Errors.
     * Any top-level errors that prevented the bulk operation from running.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(responses, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkCreateCustomersResponse)) {
            return false;
        }
        BulkCreateCustomersResponse other = (BulkCreateCustomersResponse) obj;
        return Objects.equals(responses, other.responses)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkCreateCustomersResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkCreateCustomersResponse [" + "responses=" + responses + ", errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link BulkCreateCustomersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkCreateCustomersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .responses(getResponses())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkCreateCustomersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, CreateCustomerResponse> responses;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for responses.
         * @param  responses  Map of String, value for responses.
         * @return Builder
         */
        public Builder responses(Map<String, CreateCustomerResponse> responses) {
            this.responses = responses;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link BulkCreateCustomersResponse} object using the set fields.
         * @return {@link BulkCreateCustomersResponse}
         */
        public BulkCreateCustomersResponse build() {
            BulkCreateCustomersResponse model =
                    new BulkCreateCustomersResponse(responses, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
