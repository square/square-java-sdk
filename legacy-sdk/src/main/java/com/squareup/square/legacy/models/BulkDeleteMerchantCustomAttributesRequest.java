package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteMerchantCustomAttributesRequest type.
 */
public class BulkDeleteMerchantCustomAttributesRequest {
    private final Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkDeleteMerchantCustomAttributesRequest(
            @JsonProperty("values")
                    Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * The data used to update the `CustomAttribute` objects. The keys must be unique and are used
     * to map to the corresponding response.
     * @return Returns the Map of String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest
     */
    @JsonGetter("values")
    public Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> getValues() {
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
        if (!(obj instanceof BulkDeleteMerchantCustomAttributesRequest)) {
            return false;
        }
        BulkDeleteMerchantCustomAttributesRequest other = (BulkDeleteMerchantCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkDeleteMerchantCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteMerchantCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkDeleteMerchantCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteMerchantCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteMerchantCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkDeleteMerchantCustomAttributesRequestMerchantCustomAttributeDeleteRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkDeleteMerchantCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkDeleteMerchantCustomAttributesRequest}
         */
        public BulkDeleteMerchantCustomAttributesRequest build() {
            return new BulkDeleteMerchantCustomAttributesRequest(values);
        }
    }
}
