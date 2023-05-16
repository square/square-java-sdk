
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for UpdateWebhookSubscriptionSignatureKeyRequest type.
 */
public class UpdateWebhookSubscriptionSignatureKeyRequest {
    private final OptionalNullable<String> idempotencyKey;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpdateWebhookSubscriptionSignatureKeyRequest(
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
    }

    /**
     * Internal initialization constructor.
     */
    protected UpdateWebhookSubscriptionSignatureKeyRequest(
            OptionalNullable<String> idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Internal Getter for IdempotencyKey.
     * A unique string that identifies the
     * [UpdateWebhookSubscriptionSignatureKey](api-endpoint:WebhookSubscriptions-UpdateWebhookSubscriptionSignatureKey)
     * request.
     * @return Returns the Internal String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the
     * [UpdateWebhookSubscriptionSignatureKey](api-endpoint:WebhookSubscriptions-UpdateWebhookSubscriptionSignatureKey)
     * request.
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateWebhookSubscriptionSignatureKeyRequest)) {
            return false;
        }
        UpdateWebhookSubscriptionSignatureKeyRequest other =
                (UpdateWebhookSubscriptionSignatureKeyRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpdateWebhookSubscriptionSignatureKeyRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWebhookSubscriptionSignatureKeyRequest [" + "idempotencyKey=" + idempotencyKey
                + "]";
    }

    /**
     * Builds a new {@link UpdateWebhookSubscriptionSignatureKeyRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWebhookSubscriptionSignatureKeyRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateWebhookSubscriptionSignatureKeyRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> idempotencyKey;



        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = OptionalNullable.of(idempotencyKey);
            return this;
        }

        /**
         * UnSetter for idempotencyKey.
         * @return Builder
         */
        public Builder unsetIdempotencyKey() {
            idempotencyKey = null;
            return this;
        }

        /**
         * Builds a new {@link UpdateWebhookSubscriptionSignatureKeyRequest} object using the set
         * fields.
         * @return {@link UpdateWebhookSubscriptionSignatureKeyRequest}
         */
        public UpdateWebhookSubscriptionSignatureKeyRequest build() {
            return new UpdateWebhookSubscriptionSignatureKeyRequest(idempotencyKey);
        }
    }
}
