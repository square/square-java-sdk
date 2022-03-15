
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
 * This is a model class for BulkUpdateVendorsResponse type.
 */
public class BulkUpdateVendorsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Map<String, UpdateVendorResponse> responses;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  responses  Map of String, value for responses.
     */
    @JsonCreator
    public BulkUpdateVendorsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("responses") Map<String, UpdateVendorResponse> responses) {
        this.errors = errors;
        this.responses = responses;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors encountered when the request fails.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Responses.
     * A set of [UpdateVendorResponse]($m/UpdateVendorResponse) objects encapsulating successfully
     * created [Vendor]($m/Vendor) objects or error responses for failed attempts. The set is
     * represented by a collection of `Vendor`-ID/`UpdateVendorResponse`-object or
     * `Vendor`-ID/error-object pairs.
     * @return Returns the Map of String, UpdateVendorResponse
     */
    @JsonGetter("responses")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, UpdateVendorResponse> getResponses() {
        return responses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, responses);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpdateVendorsResponse)) {
            return false;
        }
        BulkUpdateVendorsResponse other = (BulkUpdateVendorsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(responses, other.responses);
    }

    /**
     * Converts this BulkUpdateVendorsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpdateVendorsResponse [" + "errors=" + errors + ", responses=" + responses
                + "]";
    }

    /**
     * Builds a new {@link BulkUpdateVendorsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpdateVendorsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .responses(getResponses());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpdateVendorsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Map<String, UpdateVendorResponse> responses;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for responses.
         * @param  responses  Map of String, value for responses.
         * @return Builder
         */
        public Builder responses(Map<String, UpdateVendorResponse> responses) {
            this.responses = responses;
            return this;
        }

        /**
         * Builds a new {@link BulkUpdateVendorsResponse} object using the set fields.
         * @return {@link BulkUpdateVendorsResponse}
         */
        public BulkUpdateVendorsResponse build() {
            BulkUpdateVendorsResponse model =
                    new BulkUpdateVendorsResponse(errors, responses);
            model.httpContext = httpContext;
            return model;
        }
    }
}
