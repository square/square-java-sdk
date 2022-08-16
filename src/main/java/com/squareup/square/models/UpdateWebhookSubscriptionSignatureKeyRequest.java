
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateWebhookSubscriptionSignatureKeyRequest type.
 */
public class UpdateWebhookSubscriptionSignatureKeyRequest {
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpdateWebhookSubscriptionSignatureKeyRequest(
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the
     * [UpdateWebhookSubscriptionSignatureKey]($e/WebhookSubscriptions/UpdateWebhookSubscriptionSignatureKey)
     * request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
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
        Builder builder = new Builder()
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateWebhookSubscriptionSignatureKeyRequest}.
     */
    public static class Builder {
        private String idempotencyKey;



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
         * Builds a new {@link UpdateWebhookSubscriptionSignatureKeyRequest} object using the set
         * fields.
         * @return {@link UpdateWebhookSubscriptionSignatureKeyRequest}
         */
        public UpdateWebhookSubscriptionSignatureKeyRequest build() {
            return new UpdateWebhookSubscriptionSignatureKeyRequest(idempotencyKey);
        }
    }
}
