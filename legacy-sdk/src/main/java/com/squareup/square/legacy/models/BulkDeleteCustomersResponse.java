package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteCustomersResponse type.
 */
public class BulkDeleteCustomersResponse {
    private HttpContext httpContext;
    private final Map<String, DeleteCustomerResponse> responses;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  responses  Map of String, value for responses.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkDeleteCustomersResponse(
            @JsonProperty("responses") Map<String, DeleteCustomerResponse> responses,
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
     * A map of responses that correspond to individual delete requests, represented by key-value
     * pairs. Each key is the customer ID that was specified for a delete request and each value is
     * the corresponding response. If the request succeeds, the value is an empty object (`{ }`). If
     * the request fails, the value contains any errors that occurred during the request.
     * @return Returns the Map of String, DeleteCustomerResponse
     */
    @JsonGetter("responses")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, DeleteCustomerResponse> getResponses() {
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
        if (!(obj instanceof BulkDeleteCustomersResponse)) {
            return false;
        }
        BulkDeleteCustomersResponse other = (BulkDeleteCustomersResponse) obj;
        return Objects.equals(responses, other.responses) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkDeleteCustomersResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteCustomersResponse [" + "responses=" + responses + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkDeleteCustomersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteCustomersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().responses(getResponses()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteCustomersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, DeleteCustomerResponse> responses;
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
        public Builder responses(Map<String, DeleteCustomerResponse> responses) {
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
         * Builds a new {@link BulkDeleteCustomersResponse} object using the set fields.
         * @return {@link BulkDeleteCustomersResponse}
         */
        public BulkDeleteCustomersResponse build() {
            BulkDeleteCustomersResponse model = new BulkDeleteCustomersResponse(responses, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
