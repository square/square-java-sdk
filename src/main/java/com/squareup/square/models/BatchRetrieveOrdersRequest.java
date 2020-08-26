package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BatchRetrieveOrdersRequest type.
 */
public class BatchRetrieveOrdersRequest {

    /**
     * Initialization constructor.
     * @param orderIds
     * @param locationId
     */
    @JsonCreator
    public BatchRetrieveOrdersRequest(
            @JsonProperty("order_ids") List<String> orderIds,
            @JsonProperty("location_id") String locationId) {
        this.locationId = locationId;
        this.orderIds = orderIds;
    }

    private final String locationId;
    private final List<String> orderIds;
    /**
     * Getter for LocationId.
     * The ID of the location for these orders. This field is optional: omit it to retrieve
     * orders within the scope of the current authorization's merchant ID.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for OrderIds.
     * The IDs of the orders to retrieve. A maximum of 100 orders can be retrieved per request.
     */
    @JsonGetter("order_ids")
    public List<String> getOrderIds() {
        return this.orderIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, orderIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchRetrieveOrdersRequest)) {
            return false;
        }
        BatchRetrieveOrdersRequest batchRetrieveOrdersRequest = (BatchRetrieveOrdersRequest) obj;
        return Objects.equals(locationId, batchRetrieveOrdersRequest.locationId) &&
            Objects.equals(orderIds, batchRetrieveOrdersRequest.orderIds);
    }

    /**
     * Builds a new {@link BatchRetrieveOrdersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveOrdersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(orderIds)
            .locationId(getLocationId());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveOrdersRequest}
     */
    public static class Builder {
        private List<String> orderIds;
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder(List<String> orderIds) {
            this.orderIds = orderIds;
        }

        /**
         * Setter for orderIds
         * @param orderIds
         * @return Builder
         */
        public Builder orderIds(List<String> orderIds) {
            this.orderIds = orderIds;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveOrdersRequest} object using the set fields.
         * @return {@link BatchRetrieveOrdersRequest}
         */
        public BatchRetrieveOrdersRequest build() {
            return new BatchRetrieveOrdersRequest(orderIds,
                locationId);
        }
    }
}
