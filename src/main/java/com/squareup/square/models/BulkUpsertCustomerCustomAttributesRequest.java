
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertCustomerCustomAttributesRequest type.
 */
public class BulkUpsertCustomerCustomAttributesRequest {
    private final Map<String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkUpsertCustomerCustomAttributesRequest(
            @JsonProperty("values") Map<String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map containing 1 to 25 individual upsert requests. For each request, provide an arbitrary
     * ID that is unique for this `BulkUpsertCustomerCustomAttributes` request and the information
     * needed to create or update a custom attribute.
     * @return Returns the Map of String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest
     */
    @JsonGetter("values")
    public Map<String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest> getValues() {
        return values;
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpsertCustomerCustomAttributesRequest)) {
            return false;
        }
        BulkUpsertCustomerCustomAttributesRequest other =
                (BulkUpsertCustomerCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkUpsertCustomerCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertCustomerCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkUpsertCustomerCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertCustomerCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertCustomerCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkUpsertCustomerCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkUpsertCustomerCustomAttributesRequest}
         */
        public BulkUpsertCustomerCustomAttributesRequest build() {
            return new BulkUpsertCustomerCustomAttributesRequest(values);
        }
    }
}
