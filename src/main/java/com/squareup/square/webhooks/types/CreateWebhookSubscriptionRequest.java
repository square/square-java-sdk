/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.webhooks.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.types.WebhookSubscription;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateWebhookSubscriptionRequest.Builder.class)
public final class CreateWebhookSubscriptionRequest {
    private final Optional<String> idempotencyKey;

    private final WebhookSubscription subscription;

    private final Map<String, Object> additionalProperties;

    private CreateWebhookSubscriptionRequest(
            Optional<String> idempotencyKey,
            WebhookSubscription subscription,
            Map<String, Object> additionalProperties) {
        this.idempotencyKey = idempotencyKey;
        this.subscription = subscription;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique string that identifies the <a href="api-endpoint:WebhookSubscriptions-CreateWebhookSubscription">CreateWebhookSubscription</a> request.
     */
    @JsonProperty("idempotency_key")
    public Optional<String> getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * @return The <a href="entity:WebhookSubscription">Subscription</a> to create.
     */
    @JsonProperty("subscription")
    public WebhookSubscription getSubscription() {
        return subscription;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateWebhookSubscriptionRequest && equalTo((CreateWebhookSubscriptionRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateWebhookSubscriptionRequest other) {
        return idempotencyKey.equals(other.idempotencyKey) && subscription.equals(other.subscription);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.idempotencyKey, this.subscription);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SubscriptionStage builder() {
        return new Builder();
    }

    public interface SubscriptionStage {
        /**
         * <p>The <a href="entity:WebhookSubscription">Subscription</a> to create.</p>
         */
        _FinalStage subscription(@NotNull WebhookSubscription subscription);

        Builder from(CreateWebhookSubscriptionRequest other);
    }

    public interface _FinalStage {
        CreateWebhookSubscriptionRequest build();

        /**
         * <p>A unique string that identifies the <a href="api-endpoint:WebhookSubscriptions-CreateWebhookSubscription">CreateWebhookSubscription</a> request.</p>
         */
        _FinalStage idempotencyKey(Optional<String> idempotencyKey);

        _FinalStage idempotencyKey(String idempotencyKey);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SubscriptionStage, _FinalStage {
        private WebhookSubscription subscription;

        private Optional<String> idempotencyKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateWebhookSubscriptionRequest other) {
            idempotencyKey(other.getIdempotencyKey());
            subscription(other.getSubscription());
            return this;
        }

        /**
         * <p>The <a href="entity:WebhookSubscription">Subscription</a> to create.</p>
         * <p>The <a href="entity:WebhookSubscription">Subscription</a> to create.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("subscription")
        public _FinalStage subscription(@NotNull WebhookSubscription subscription) {
            this.subscription = Objects.requireNonNull(subscription, "subscription must not be null");
            return this;
        }

        /**
         * <p>A unique string that identifies the <a href="api-endpoint:WebhookSubscriptions-CreateWebhookSubscription">CreateWebhookSubscription</a> request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = Optional.ofNullable(idempotencyKey);
            return this;
        }

        /**
         * <p>A unique string that identifies the <a href="api-endpoint:WebhookSubscriptions-CreateWebhookSubscription">CreateWebhookSubscription</a> request.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "idempotency_key", nulls = Nulls.SKIP)
        public _FinalStage idempotencyKey(Optional<String> idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        @java.lang.Override
        public CreateWebhookSubscriptionRequest build() {
            return new CreateWebhookSubscriptionRequest(idempotencyKey, subscription, additionalProperties);
        }
    }
}
