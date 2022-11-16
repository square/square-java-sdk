
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertOrderCustomAttributesRequest type.
 */
public class BulkUpsertOrderCustomAttributesRequest {
    private final Map<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkUpsertOrderCustomAttributesRequest(
            @JsonProperty("values") Map<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map of requests that correspond to individual upsert operations for custom attributes.
     * @return Returns the Map of String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute
     */
    @JsonGetter("values")
    public Map<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute> getValues() {
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
        if (!(obj instanceof BulkUpsertOrderCustomAttributesRequest)) {
            return false;
        }
        BulkUpsertOrderCustomAttributesRequest other = (BulkUpsertOrderCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkUpsertOrderCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertOrderCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkUpsertOrderCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertOrderCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertOrderCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkUpsertOrderCustomAttributesRequest} object using the set fields.
         * @return {@link BulkUpsertOrderCustomAttributesRequest}
         */
        public BulkUpsertOrderCustomAttributesRequest build() {
            return new BulkUpsertOrderCustomAttributesRequest(values);
        }
    }
}
