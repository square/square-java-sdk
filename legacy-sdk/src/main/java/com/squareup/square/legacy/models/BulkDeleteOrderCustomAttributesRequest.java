package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteOrderCustomAttributesRequest type.
 */
public class BulkDeleteOrderCustomAttributesRequest {
    private final Map<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkDeleteOrderCustomAttributesRequest(
            @JsonProperty("values") Map<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map of requests that correspond to individual delete operations for custom attributes.
     * @return Returns the Map of String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute
     */
    @JsonGetter("values")
    public Map<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute> getValues() {
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
        if (!(obj instanceof BulkDeleteOrderCustomAttributesRequest)) {
            return false;
        }
        BulkDeleteOrderCustomAttributesRequest other = (BulkDeleteOrderCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkDeleteOrderCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteOrderCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkDeleteOrderCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteOrderCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteOrderCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(Map<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(Map<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkDeleteOrderCustomAttributesRequest} object using the set fields.
         * @return {@link BulkDeleteOrderCustomAttributesRequest}
         */
        public BulkDeleteOrderCustomAttributesRequest build() {
            return new BulkDeleteOrderCustomAttributesRequest(values);
        }
    }
}
