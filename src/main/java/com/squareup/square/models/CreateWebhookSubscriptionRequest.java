
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateWebhookSubscriptionRequest type.
 */
public class CreateWebhookSubscriptionRequest {
    private final String idempotencyKey;
    private final WebhookSubscription subscription;

    /**
     * Initialization constructor.
     * @param  subscription  WebhookSubscription value for subscription.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateWebhookSubscriptionRequest(
            @JsonProperty("subscription") WebhookSubscription subscription,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.subscription = subscription;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the
     * [CreateWebhookSubscription]($e/WebhookSubscriptions/CreateWebhookSubscription) request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Subscription.
     * Represents the details of a webhook subscription, including notification URL, event types,
     * and signature key.
     * @return Returns the WebhookSubscription
     */
    @JsonGetter("subscription")
    public WebhookSubscription getSubscription() {
        return subscription;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, subscription);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateWebhookSubscriptionRequest)) {
            return false;
        }
        CreateWebhookSubscriptionRequest other = (CreateWebhookSubscriptionRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(subscription, other.subscription);
    }

    /**
     * Converts this CreateWebhookSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateWebhookSubscriptionRequest [" + "subscription=" + subscription
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateWebhookSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateWebhookSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(subscription)
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateWebhookSubscriptionRequest}.
     */
    public static class Builder {
        private WebhookSubscription subscription;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  subscription  WebhookSubscription value for subscription.
         */
        public Builder(WebhookSubscription subscription) {
            this.subscription = subscription;
        }

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
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateWebhookSubscriptionRequest} object using the set fields.
         * @return {@link CreateWebhookSubscriptionRequest}
         */
        public CreateWebhookSubscriptionRequest build() {
            return new CreateWebhookSubscriptionRequest(subscription, idempotencyKey);
        }
    }
}
