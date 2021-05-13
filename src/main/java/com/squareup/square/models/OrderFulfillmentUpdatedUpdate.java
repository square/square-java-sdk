
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentUpdatedUpdate type.
 */
public class OrderFulfillmentUpdatedUpdate {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String fulfillmentUid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String oldState;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String newState;

    /**
     * Initialization constructor.
     * @param  fulfillmentUid  String value for fulfillmentUid.
     * @param  oldState  String value for oldState.
     * @param  newState  String value for newState.
     */
    @JsonCreator
    public OrderFulfillmentUpdatedUpdate(
            @JsonProperty("fulfillment_uid") String fulfillmentUid,
            @JsonProperty("old_state") String oldState,
            @JsonProperty("new_state") String newState) {
        this.fulfillmentUid = fulfillmentUid;
        this.oldState = oldState;
        this.newState = newState;
    }

    /**
     * Getter for FulfillmentUid.
     * A unique ID that identifies the fulfillment only within this order.
     * @return Returns the String
     */
    @JsonGetter("fulfillment_uid")
    public String getFulfillmentUid() {
        return fulfillmentUid;
    }

    /**
     * Getter for OldState.
     * The current state of this fulfillment.
     * @return Returns the String
     */
    @JsonGetter("old_state")
    public String getOldState() {
        return oldState;
    }

    /**
     * Getter for NewState.
     * The current state of this fulfillment.
     * @return Returns the String
     */
    @JsonGetter("new_state")
    public String getNewState() {
        return newState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fulfillmentUid, oldState, newState);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentUpdatedUpdate)) {
            return false;
        }
        OrderFulfillmentUpdatedUpdate other = (OrderFulfillmentUpdatedUpdate) obj;
        return Objects.equals(fulfillmentUid, other.fulfillmentUid)
            && Objects.equals(oldState, other.oldState)
            && Objects.equals(newState, other.newState);
    }

    /**
     * Converts this OrderFulfillmentUpdatedUpdate into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentUpdatedUpdate [" + "fulfillmentUid=" + fulfillmentUid
                + ", oldState=" + oldState + ", newState=" + newState + "]";
    }

    /**
     * Builds a new {@link OrderFulfillmentUpdatedUpdate.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentUpdatedUpdate.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .fulfillmentUid(getFulfillmentUid())
                .oldState(getOldState())
                .newState(getNewState());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentUpdatedUpdate}.
     */
    public static class Builder {
        private String fulfillmentUid;
        private String oldState;
        private String newState;



        /**
         * Setter for fulfillmentUid.
         * @param  fulfillmentUid  String value for fulfillmentUid.
         * @return Builder
         */
        public Builder fulfillmentUid(String fulfillmentUid) {
            this.fulfillmentUid = fulfillmentUid;
            return this;
        }

        /**
         * Setter for oldState.
         * @param  oldState  String value for oldState.
         * @return Builder
         */
        public Builder oldState(String oldState) {
            this.oldState = oldState;
            return this;
        }

        /**
         * Setter for newState.
         * @param  newState  String value for newState.
         * @return Builder
         */
        public Builder newState(String newState) {
            this.newState = newState;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentUpdatedUpdate} object using the set fields.
         * @return {@link OrderFulfillmentUpdatedUpdate}
         */
        public OrderFulfillmentUpdatedUpdate build() {
            return new OrderFulfillmentUpdatedUpdate(fulfillmentUid, oldState, newState);
        }
    }
}
