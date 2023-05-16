
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
 * This is a model class for BulkDeleteMerchantCustomAttributesResponse type.
 */
public class BulkDeleteMerchantCustomAttributesResponse {
    private HttpContext httpContext;
    private final Map<String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse> values;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkDeleteMerchantCustomAttributesResponse(
            @JsonProperty("values") Map<String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse> values,
            @JsonProperty("errors") List<Error> errors) {
        this.values = values;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Values.
     * A map of responses that correspond to individual delete requests. Each response has the same
     * key as the corresponding request.
     * @return Returns the Map of String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse
     */
    @JsonGetter("values")
    public Map<String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse> getValues() {
        return values;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkDeleteMerchantCustomAttributesResponse)) {
            return false;
        }
        BulkDeleteMerchantCustomAttributesResponse other =
                (BulkDeleteMerchantCustomAttributesResponse) obj;
        return Objects.equals(values, other.values)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkDeleteMerchantCustomAttributesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteMerchantCustomAttributesResponse [" + "values=" + values + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link BulkDeleteMerchantCustomAttributesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteMerchantCustomAttributesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values)
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteMerchantCustomAttributesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse> values;
        private List<Error> errors;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse> values) {
            this.values = values;
        }

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
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse> values) {
            this.values = values;
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
         * Builds a new {@link BulkDeleteMerchantCustomAttributesResponse} object using the set
         * fields.
         * @return {@link BulkDeleteMerchantCustomAttributesResponse}
         */
        public BulkDeleteMerchantCustomAttributesResponse build() {
            BulkDeleteMerchantCustomAttributesResponse model =
                    new BulkDeleteMerchantCustomAttributesResponse(values, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
