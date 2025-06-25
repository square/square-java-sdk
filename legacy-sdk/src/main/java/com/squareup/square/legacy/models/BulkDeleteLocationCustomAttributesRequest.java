package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteLocationCustomAttributesRequest type.
 */
public class BulkDeleteLocationCustomAttributesRequest {
    private final Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkDeleteLocationCustomAttributesRequest(
            @JsonProperty("values")
                    Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * The data used to update the `CustomAttribute` objects. The keys must be unique and are used
     * to map to the corresponding response.
     * @return Returns the Map of String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest
     */
    @JsonGetter("values")
    public Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> getValues() {
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
        if (!(obj instanceof BulkDeleteLocationCustomAttributesRequest)) {
            return false;
        }
        BulkDeleteLocationCustomAttributesRequest other = (BulkDeleteLocationCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkDeleteLocationCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteLocationCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkDeleteLocationCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteLocationCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteLocationCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkDeleteLocationCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkDeleteLocationCustomAttributesRequest}
         */
        public BulkDeleteLocationCustomAttributesRequest build() {
            return new BulkDeleteLocationCustomAttributesRequest(values);
        }
    }
}
