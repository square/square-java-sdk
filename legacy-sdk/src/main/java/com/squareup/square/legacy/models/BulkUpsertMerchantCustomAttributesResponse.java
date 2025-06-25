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
 * This is a model class for BulkUpsertMerchantCustomAttributesResponse type.
 */
public class BulkUpsertMerchantCustomAttributesResponse {
    private HttpContext httpContext;
    private final Map<String, BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse> values;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkUpsertMerchantCustomAttributesResponse(
            @JsonProperty("values")
                    Map<String, BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse> values,
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
     * A map of responses that correspond to individual upsert requests. Each response has the same
     * ID as the corresponding request and contains either a `merchant_id` and `custom_attribute` or
     * an `errors` field.
     * @return Returns the Map of String, BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse
     */
    @JsonGetter("values")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse> getValues() {
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
        if (!(obj instanceof BulkUpsertMerchantCustomAttributesResponse)) {
            return false;
        }
        BulkUpsertMerchantCustomAttributesResponse other = (BulkUpsertMerchantCustomAttributesResponse) obj;
        return Objects.equals(values, other.values) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkUpsertMerchantCustomAttributesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertMerchantCustomAttributesResponse [" + "values=" + values + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkUpsertMerchantCustomAttributesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertMerchantCustomAttributesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().values(getValues()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertMerchantCustomAttributesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse> values;
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
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkUpsertMerchantCustomAttributesResponseMerchantCustomAttributeUpsertResponse> values) {
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
         * Builds a new {@link BulkUpsertMerchantCustomAttributesResponse} object using the set
         * fields.
         * @return {@link BulkUpsertMerchantCustomAttributesResponse}
         */
        public BulkUpsertMerchantCustomAttributesResponse build() {
            BulkUpsertMerchantCustomAttributesResponse model =
                    new BulkUpsertMerchantCustomAttributesResponse(values, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
