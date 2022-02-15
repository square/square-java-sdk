
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateSubscriptionRequest type.
 */
public class UpdateSubscriptionRequest {
    private final Subscription subscription;

    /**
     * Initialization constructor.
     * @param  subscription  Subscription value for subscription.
     */
    @JsonCreator
    public UpdateSubscriptionRequest(
            @JsonProperty("subscription") Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Getter for Subscription.
     * Represents a subscription to a subscription plan by a subscriber. For an overview of the
     * `Subscription` type, see [Subscription
     * object](https://developer.squareup.com/docs/subscriptions-api/overview#subscription-object-overview).
     * @return Returns the Subscription
     */
    @JsonGetter("subscription")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscription);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateSubscriptionRequest)) {
            return false;
        }
        UpdateSubscriptionRequest other = (UpdateSubscriptionRequest) obj;
        return Objects.equals(subscription, other.subscription);
    }

    /**
     * Converts this UpdateSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateSubscriptionRequest [" + "subscription=" + subscription + "]";
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
     * Class to build instances of {@link UpdateSubscriptionRequest}.
     */
    public static class Builder {
        private Subscription subscription;



        /**
         * Setter for subscription.
         * @param  subscription  Subscription value for subscription.
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
