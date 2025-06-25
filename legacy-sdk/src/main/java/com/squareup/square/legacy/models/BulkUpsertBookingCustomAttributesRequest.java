package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertBookingCustomAttributesRequest type.
 */
public class BulkUpsertBookingCustomAttributesRequest {
    private final Map<String, BookingCustomAttributeUpsertRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkUpsertBookingCustomAttributesRequest(
            @JsonProperty("values") Map<String, BookingCustomAttributeUpsertRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map containing 1 to 25 individual upsert requests. For each request, provide an arbitrary
     * ID that is unique for this `BulkUpsertBookingCustomAttributes` request and the information
     * needed to create or update a custom attribute.
     * @return Returns the Map of String, BookingCustomAttributeUpsertRequest
     */
    @JsonGetter("values")
    public Map<String, BookingCustomAttributeUpsertRequest> getValues() {
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
        if (!(obj instanceof BulkUpsertBookingCustomAttributesRequest)) {
            return false;
        }
        BulkUpsertBookingCustomAttributesRequest other = (BulkUpsertBookingCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkUpsertBookingCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertBookingCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkUpsertBookingCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertBookingCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertBookingCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BookingCustomAttributeUpsertRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(Map<String, BookingCustomAttributeUpsertRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(Map<String, BookingCustomAttributeUpsertRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkUpsertBookingCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkUpsertBookingCustomAttributesRequest}
         */
        public BulkUpsertBookingCustomAttributesRequest build() {
            return new BulkUpsertBookingCustomAttributesRequest(values);
        }
    }
}
