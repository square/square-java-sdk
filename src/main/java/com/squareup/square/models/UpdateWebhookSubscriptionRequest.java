
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateWebhookSubscriptionRequest type.
 */
public class UpdateWebhookSubscriptionRequest {
    private final WebhookSubscription subscription;

    /**
     * Initialization constructor.
     * @param  subscription  WebhookSubscription value for subscription.
     */
    @JsonCreator
    public UpdateWebhookSubscriptionRequest(
            @JsonProperty("subscription") WebhookSubscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Getter for Subscription.
     * Represents the details of a webhook subscription, including notification URL, event types,
     * and signature key.
     * @return Returns the WebhookSubscription
     */
    @JsonGetter("subscription")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public WebhookSubscription getSubscription() {
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
        if (!(obj instanceof UpdateWebhookSubscriptionRequest)) {
            return false;
        }
        UpdateWebhookSubscriptionRequest other = (UpdateWebhookSubscriptionRequest) obj;
        return Objects.equals(subscription, other.subscription);
    }

    /**
     * Converts this UpdateWebhookSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWebhookSubscriptionRequest [" + "subscription=" + subscription + "]";
    }

    /**
     * Builds a new {@link UpdateWebhookSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWebhookSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .subscription(getSubscription());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateWebhookSubscriptionRequest}.
     */
    public static class Builder {
        private WebhookSubscription subscription;



        /**
         * Setter for subscription.
         * @param  subscription  WebhookSubscription value for subscription.
         * @return Builder
         */
        public Builder subscription(WebhookSubscription subscription) {
            this.subscription = subscription;
            return this;
        }

        /**
         * Builds a new {@link UpdateWebhookSubscriptionRequest} object using the set fields.
         * @return {@link UpdateWebhookSubscriptionRequest}
         */
        public UpdateWebhookSubscriptionRequest build() {
            return new UpdateWebhookSubscriptionRequest(subscription);
        }
    }
}
