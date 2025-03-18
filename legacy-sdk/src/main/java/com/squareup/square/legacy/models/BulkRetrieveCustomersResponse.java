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
 * This is a model class for BulkRetrieveCustomersResponse type.
 */
public class BulkRetrieveCustomersResponse {
    private HttpContext httpContext;
    private final Map<String, RetrieveCustomerResponse> responses;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  responses  Map of String, value for responses.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkRetrieveCustomersResponse(
            @JsonProperty("responses") Map<String, RetrieveCustomerResponse> responses,
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
     * A map of responses that correspond to individual retrieve requests, represented by key-value
     * pairs. Each key is the customer ID that was specified for a retrieve request and each value
     * is the corresponding response. If the request succeeds, the value is the requested customer
     * profile. If the request fails, the value contains any errors that occurred during the
     * request.
     * @return Returns the Map of String, RetrieveCustomerResponse
     */
    @JsonGetter("responses")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, RetrieveCustomerResponse> getResponses() {
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
        if (!(obj instanceof BulkRetrieveCustomersResponse)) {
            return false;
        }
        BulkRetrieveCustomersResponse other = (BulkRetrieveCustomersResponse) obj;
        return Objects.equals(responses, other.responses) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkRetrieveCustomersResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveCustomersResponse [" + "responses=" + responses + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveCustomersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveCustomersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().responses(getResponses()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveCustomersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, RetrieveCustomerResponse> responses;
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
        public Builder responses(Map<String, RetrieveCustomerResponse> responses) {
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
         * Builds a new {@link BulkRetrieveCustomersResponse} object using the set fields.
         * @return {@link BulkRetrieveCustomersResponse}
         */
        public BulkRetrieveCustomersResponse build() {
            BulkRetrieveCustomersResponse model = new BulkRetrieveCustomersResponse(responses, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
