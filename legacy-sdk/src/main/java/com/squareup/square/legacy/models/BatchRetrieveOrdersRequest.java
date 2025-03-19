package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveOrdersRequest type.
 */
public class BatchRetrieveOrdersRequest {
    private final OptionalNullable<String> locationId;
    private final List<String> orderIds;

    /**
     * Initialization constructor.
     * @param  orderIds  List of String value for orderIds.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public BatchRetrieveOrdersRequest(
            @JsonProperty("order_ids") List<String> orderIds, @JsonProperty("location_id") String locationId) {
        this.locationId = OptionalNullable.of(locationId);
        this.orderIds = orderIds;
    }

    /**
     * Initialization constructor.
     * @param  orderIds  List of String value for orderIds.
     * @param  locationId  String value for locationId.
     */
    protected BatchRetrieveOrdersRequest(List<String> orderIds, OptionalNullable<String> locationId) {
        this.locationId = locationId;
        this.orderIds = orderIds;
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the location for these orders. This field is optional: omit it to retrieve orders
     * within the scope of the current authorization's merchant ID.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location for these orders. This field is optional: omit it to retrieve orders
     * within the scope of the current authorization's merchant ID.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Getter for OrderIds.
     * The IDs of the orders to retrieve. A maximum of 100 orders can be retrieved per request.
     * @return Returns the List of String
     */
    @JsonGetter("order_ids")
    public List<String> getOrderIds() {
        return orderIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, orderIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveOrdersRequest)) {
            return false;
        }
        BatchRetrieveOrdersRequest other = (BatchRetrieveOrdersRequest) obj;
        return Objects.equals(locationId, other.locationId) && Objects.equals(orderIds, other.orderIds);
    }

    /**
     * Converts this BatchRetrieveOrdersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveOrdersRequest [" + "orderIds=" + orderIds + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link BatchRetrieveOrdersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveOrdersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(orderIds);
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveOrdersRequest}.
     */
    public static class Builder {
        private List<String> orderIds;
        private OptionalNullable<String> locationId;

        /**
         * Initialization constructor.
         * @param  orderIds  List of String value for orderIds.
         */
        public Builder(List<String> orderIds) {
            this.orderIds = orderIds;
        }

        /**
         * Setter for orderIds.
         * @param  orderIds  List of String value for orderIds.
         * @return Builder
         */
        public Builder orderIds(List<String> orderIds) {
            this.orderIds = orderIds;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveOrdersRequest} object using the set fields.
         * @return {@link BatchRetrieveOrdersRequest}
         */
        public BatchRetrieveOrdersRequest build() {
            return new BatchRetrieveOrdersRequest(orderIds, locationId);
        }
    }
}
