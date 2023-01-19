
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertLocationCustomAttributesRequest type.
 */
public class BulkUpsertLocationCustomAttributesRequest {
    private final Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkUpsertLocationCustomAttributesRequest(
            @JsonProperty("values") Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map containing 1 to 25 individual upsert requests. For each request, provide an arbitrary
     * ID that is unique for this `BulkUpsertLocationCustomAttributes` request and the information
     * needed to create or update a custom attribute.
     * @return Returns the Map of String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest
     */
    @JsonGetter("values")
    public Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> getValues() {
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
        if (!(obj instanceof BulkUpsertLocationCustomAttributesRequest)) {
            return false;
        }
        BulkUpsertLocationCustomAttributesRequest other =
                (BulkUpsertLocationCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkUpsertLocationCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertLocationCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkUpsertLocationCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertLocationCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertLocationCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(
                Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(
                Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkUpsertLocationCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkUpsertLocationCustomAttributesRequest}
         */
        public BulkUpsertLocationCustomAttributesRequest build() {
            return new BulkUpsertLocationCustomAttributesRequest(values);
        }
    }
}
