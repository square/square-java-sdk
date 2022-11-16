
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentPickupDetailsCurbsidePickupDetails type.
 */
public class OrderFulfillmentPickupDetailsCurbsidePickupDetails {
    private final OptionalNullable<String> curbsideDetails;
    private final OptionalNullable<String> buyerArrivedAt;

    /**
     * Initialization constructor.
     * @param  curbsideDetails  String value for curbsideDetails.
     * @param  buyerArrivedAt  String value for buyerArrivedAt.
     */
    @JsonCreator
    public OrderFulfillmentPickupDetailsCurbsidePickupDetails(
            @JsonProperty("curbside_details") String curbsideDetails,
            @JsonProperty("buyer_arrived_at") String buyerArrivedAt) {
        this.curbsideDetails = OptionalNullable.of(curbsideDetails);
        this.buyerArrivedAt = OptionalNullable.of(buyerArrivedAt);
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderFulfillmentPickupDetailsCurbsidePickupDetails(
            OptionalNullable<String> curbsideDetails, OptionalNullable<String> buyerArrivedAt) {
        this.curbsideDetails = curbsideDetails;
        this.buyerArrivedAt = buyerArrivedAt;
    }

    /**
     * Internal Getter for CurbsideDetails.
     * Specific details for curbside pickup, such as parking number and vehicle model.
     * @return Returns the Internal String
     */
    @JsonGetter("curbside_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCurbsideDetails() {
        return this.curbsideDetails;
    }

    /**
     * Getter for CurbsideDetails.
     * Specific details for curbside pickup, such as parking number and vehicle model.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCurbsideDetails() {
        return OptionalNullable.getFrom(curbsideDetails);
    }

    /**
     * Internal Getter for BuyerArrivedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the buyer arrived and is waiting for pickup. The timestamp must be in RFC
     * 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the Internal String
     */
    @JsonGetter("buyer_arrived_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBuyerArrivedAt() {
        return this.buyerArrivedAt;
    }

    /**
     * Getter for BuyerArrivedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the buyer arrived and is waiting for pickup. The timestamp must be in RFC
     * 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonIgnore
    public String getBuyerArrivedAt() {
        return OptionalNullable.getFrom(buyerArrivedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curbsideDetails, buyerArrivedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentPickupDetailsCurbsidePickupDetails)) {
            return false;
        }
        OrderFulfillmentPickupDetailsCurbsidePickupDetails other =
                (OrderFulfillmentPickupDetailsCurbsidePickupDetails) obj;
        return Objects.equals(curbsideDetails, other.curbsideDetails)
            && Objects.equals(buyerArrivedAt, other.buyerArrivedAt);
    }

    /**
     * Converts this OrderFulfillmentPickupDetailsCurbsidePickupDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentPickupDetailsCurbsidePickupDetails [" + "curbsideDetails="
                + curbsideDetails + ", buyerArrivedAt=" + buyerArrivedAt + "]";
    }

    /**
     * Builds a new {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.curbsideDetails = internalGetCurbsideDetails();
        builder.buyerArrivedAt = internalGetBuyerArrivedAt();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> curbsideDetails;
        private OptionalNullable<String> buyerArrivedAt;



        /**
         * Setter for curbsideDetails.
         * @param  curbsideDetails  String value for curbsideDetails.
         * @return Builder
         */
        public Builder curbsideDetails(String curbsideDetails) {
            this.curbsideDetails = OptionalNullable.of(curbsideDetails);
            return this;
        }

        /**
         * UnSetter for curbsideDetails.
         * @return Builder
         */
        public Builder unsetCurbsideDetails() {
            curbsideDetails = null;
            return this;
        }

        /**
         * Setter for buyerArrivedAt.
         * @param  buyerArrivedAt  String value for buyerArrivedAt.
         * @return Builder
         */
        public Builder buyerArrivedAt(String buyerArrivedAt) {
            this.buyerArrivedAt = OptionalNullable.of(buyerArrivedAt);
            return this;
        }

        /**
         * UnSetter for buyerArrivedAt.
         * @return Builder
         */
        public Builder unsetBuyerArrivedAt() {
            buyerArrivedAt = null;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails} object using the
         * set fields.
         * @return {@link OrderFulfillmentPickupDetailsCurbsidePickupDetails}
         */
        public OrderFulfillmentPickupDetailsCurbsidePickupDetails build() {
            return new OrderFulfillmentPickupDetailsCurbsidePickupDetails(curbsideDetails,
                    buyerArrivedAt);
        }
    }
}
