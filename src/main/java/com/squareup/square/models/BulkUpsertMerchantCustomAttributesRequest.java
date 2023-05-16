
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertMerchantCustomAttributesRequest type.
 */
public class BulkUpsertMerchantCustomAttributesRequest {
    private final Map<String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkUpsertMerchantCustomAttributesRequest(
            @JsonProperty("values") Map<String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map containing 1 to 25 individual upsert requests. For each request, provide an arbitrary
     * ID that is unique for this `BulkUpsertMerchantCustomAttributes` request and the information
     * needed to create or update a custom attribute.
     * @return Returns the Map of String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest
     */
    @JsonGetter("values")
    public Map<String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest> getValues() {
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
        if (!(obj instanceof BulkUpsertMerchantCustomAttributesRequest)) {
            return false;
        }
        BulkUpsertMerchantCustomAttributesRequest other =
                (BulkUpsertMerchantCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkUpsertMerchantCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertMerchantCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkUpsertMerchantCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertMerchantCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertMerchantCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkUpsertMerchantCustomAttributesRequestMerchantCustomAttributeUpsertRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkUpsertMerchantCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkUpsertMerchantCustomAttributesRequest}
         */
        public BulkUpsertMerchantCustomAttributesRequest build() {
            return new BulkUpsertMerchantCustomAttributesRequest(values);
        }
    }
}
