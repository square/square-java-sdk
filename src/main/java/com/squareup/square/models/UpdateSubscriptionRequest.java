package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateSubscriptionRequest type.
 */
public class UpdateSubscriptionRequest {

    /**
     * Initialization constructor.
     * @param subscription
     */
    @JsonCreator
    public UpdateSubscriptionRequest(
            @JsonProperty("subscription") Subscription subscription) {
        this.subscription = subscription;
    }

    private final Subscription subscription;
    /**
     * Getter for Subscription.
     * Represents a customer subscription to a subscription plan.
     * For an overview of the `Subscription` type, see 
     * [Subscription object](https://developer.squareup.com/docs/docs/subscriptions-api/overview#subscription-object-overview).
     */
    @JsonGetter("subscription")
    public Subscription getSubscription() {
        return this.subscription;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(subscription);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateSubscriptionRequest)) {
            return false;
        }
        UpdateSubscriptionRequest updateSubscriptionRequest = (UpdateSubscriptionRequest) obj;
        return Objects.equals(subscription, updateSubscriptionRequest.subscription);
    }

    /**
     * Builds a new {@link UpdateSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .subscription(getSubscription());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateSubscriptionRequest}
     */
    public static class Builder {
        private Subscription subscription;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for subscription
         * @param subscription
         * @return Builder
         */
        public Builder subscription(Subscription subscription) {
            this.subscription = subscription;
            return this;
        }

        /**
         * Builds a new {@link UpdateSubscriptionRequest} object using the set fields.
         * @return {@link UpdateSubscriptionRequest}
         */
        public UpdateSubscriptionRequest build() {
            return new UpdateSubscriptionRequest(subscription);
        }
    }
}
