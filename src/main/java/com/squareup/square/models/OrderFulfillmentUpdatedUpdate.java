package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderFulfillmentUpdatedUpdate type.
 */
public class OrderFulfillmentUpdatedUpdate {

    /**
     * Initialization constructor.
     * @param fulfillmentUid
     * @param oldState
     * @param newState
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

    private final String fulfillmentUid;
    private final String oldState;
    private final String newState;
    /**
     * Getter for FulfillmentUid.
     * Unique ID that identifies the fulfillment only within this order.
     */
    @JsonGetter("fulfillment_uid")
    public String getFulfillmentUid() {
        return this.fulfillmentUid;
    }

    /**
     * Getter for OldState.
     * The current state of this fulfillment.
     */
    @JsonGetter("old_state")
    public String getOldState() {
        return this.oldState;
    }

    /**
     * Getter for NewState.
     * The current state of this fulfillment.
     */
    @JsonGetter("new_state")
    public String getNewState() {
        return this.newState;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(fulfillmentUid, oldState, newState);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderFulfillmentUpdatedUpdate)) {
            return false;
        }
        OrderFulfillmentUpdatedUpdate orderFulfillmentUpdatedUpdate = (OrderFulfillmentUpdatedUpdate) obj;
        return Objects.equals(fulfillmentUid, orderFulfillmentUpdatedUpdate.fulfillmentUid) &&
            Objects.equals(oldState, orderFulfillmentUpdatedUpdate.oldState) &&
            Objects.equals(newState, orderFulfillmentUpdatedUpdate.newState);
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
     * Class to build instances of {@link OrderFulfillmentUpdatedUpdate}
     */
    public static class Builder {
        private String fulfillmentUid;
        private String oldState;
        private String newState;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for fulfillmentUid
         * @param fulfillmentUid
         * @return Builder
         */
        public Builder fulfillmentUid(String fulfillmentUid) {
            this.fulfillmentUid = fulfillmentUid;
            return this;
        }
        /**
         * Setter for oldState
         * @param oldState
         * @return Builder
         */
        public Builder oldState(String oldState) {
            this.oldState = oldState;
            return this;
        }
        /**
         * Setter for newState
         * @param newState
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
            return new OrderFulfillmentUpdatedUpdate(fulfillmentUid,
                oldState,
                newState);
        }
    }
}
