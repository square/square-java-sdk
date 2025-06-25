package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteBookingCustomAttributesRequest type.
 */
public class BulkDeleteBookingCustomAttributesRequest {
    private final Map<String, BookingCustomAttributeDeleteRequest> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     */
    @JsonCreator
    public BulkDeleteBookingCustomAttributesRequest(
            @JsonProperty("values") Map<String, BookingCustomAttributeDeleteRequest> values) {
        this.values = values;
    }

    /**
     * Getter for Values.
     * A map containing 1 to 25 individual Delete requests. For each request, provide an arbitrary
     * ID that is unique for this `BulkDeleteBookingCustomAttributes` request and the information
     * needed to delete a custom attribute.
     * @return Returns the Map of String, BookingCustomAttributeDeleteRequest
     */
    @JsonGetter("values")
    public Map<String, BookingCustomAttributeDeleteRequest> getValues() {
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
        if (!(obj instanceof BulkDeleteBookingCustomAttributesRequest)) {
            return false;
        }
        BulkDeleteBookingCustomAttributesRequest other = (BulkDeleteBookingCustomAttributesRequest) obj;
        return Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkDeleteBookingCustomAttributesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteBookingCustomAttributesRequest [" + "values=" + values + "]";
    }

    /**
     * Builds a new {@link BulkDeleteBookingCustomAttributesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteBookingCustomAttributesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteBookingCustomAttributesRequest}.
     */
    public static class Builder {
        private Map<String, BookingCustomAttributeDeleteRequest> values;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(Map<String, BookingCustomAttributeDeleteRequest> values) {
            this.values = values;
        }

        /**
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(Map<String, BookingCustomAttributeDeleteRequest> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link BulkDeleteBookingCustomAttributesRequest} object using the set
         * fields.
         * @return {@link BulkDeleteBookingCustomAttributesRequest}
         */
        public BulkDeleteBookingCustomAttributesRequest build() {
            return new BulkDeleteBookingCustomAttributesRequest(values);
        }
    }
}
