package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderFulfillmentPickupDetailsCurbsidePickupDetails type.
 */
public class OrderFulfillmentPickupDetailsCurbsidePickupDetails {

    /**
     * Initialization constructor.
     * @param curbsideDetails
     * @param buyerArrivedAt
     */
    @JsonCreator
    public OrderFulfillmentPickupDetailsCurbsidePickupDetails(
            @JsonProperty("curbside_details") String curbsideDetails,
            @JsonProperty("buyer_arrived_at") String buyerArrivedAt) {
        this.curbsideDetails = curbsideDetails;
        this.buyerArrivedAt = buyerArrivedAt;
    }

    private final String curbsideDetails;
    private final String buyerArrivedAt;
    /**
     * Getter for CurbsideDetails.
     * Specific details for curbside pickup, such as parking number, vehicle model, etc.
     */
    @JsonGetter("curbside_details")
    public String getCurbsideDetails() {
        return this.curbsideDetails;
    }

    /**
     * Getter for BuyerArrivedAt.
     * The [timestamp](#workingwithdates) in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z",
     * indicating when the buyer arrived and is waiting for pickup.
     */
    @JsonGetter("buyer_arrived_at")
    public String getBuyerArrivedAt() {
        return this.buyerArrivedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(curbsideDetails, buyerArrivedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderFulfillmentPickupDetailsCurbsidePickupDetails)) {
            return false;
        }
        OrderFulfillmentPickupDetailsCurbsidePickupDetails orderFulfillmentPickupDetailsCurbsidePickupDetails = (OrderFulfillmentPickupDetailsCurbsidePickupDetails) obj;
        return Objects.equals(curbsideDetails, orderFulfillmentPickupDetailsCurbsidePickupDetails.curbsideDetails) &&
            Objects.equals(buyerArrivedAt, orderFulfillmentPickupDetailsCurbsidePickupDetails.buyerArrivedAt);
    }

    /**
     * Builds a new {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .curbsideDetails(getCurbsideDetails())
            .buyerArrivedAt(getBuyerArrivedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails}
     */
    public static class Builder {
        private String curbsideDetails;
        private String buyerArrivedAt;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for curbsideDetails
         * @param curbsideDetails
         * @return Builder
         */
        public Builder curbsideDetails(String curbsideDetails) {
            this.curbsideDetails = curbsideDetails;
            return this;
        }
        /**
         * Setter for buyerArrivedAt
         * @param buyerArrivedAt
         * @return Builder
         */
        public Builder buyerArrivedAt(String buyerArrivedAt) {
            this.buyerArrivedAt = buyerArrivedAt;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails} object using the set fields.
         * @return {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails}
         */
        public OrderFulfillmentPickupDetailsCurbsidePickupDetails build() {
            return new OrderFulfillmentPickupDetailsCurbsidePickupDetails(curbsideDetails,
                buyerArrivedAt);
        }
    }
}
