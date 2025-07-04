/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateWebhookSubscriptionSignatureKeyResponse.Builder.class)
public final class UpdateWebhookSubscriptionSignatureKeyResponse {
    private final Optional<List<Error>> errors;

    private final Optional<String> signatureKey;

    private final Map<String, Object> additionalProperties;

    private UpdateWebhookSubscriptionSignatureKeyResponse(
            Optional<List<Error>> errors, Optional<String> signatureKey, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.signatureKey = signatureKey;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information on errors encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The new Square-generated signature key used to validate the origin of the webhook event.
     */
    @JsonProperty("signature_key")
    public Optional<String> getSignatureKey() {
        return signatureKey;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateWebhookSubscriptionSignatureKeyResponse
                && equalTo((UpdateWebhookSubscriptionSignatureKeyResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateWebhookSubscriptionSignatureKeyResponse other) {
        return errors.equals(other.errors) && signatureKey.equals(other.signatureKey);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.signatureKey);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<String> signatureKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateWebhookSubscriptionSignatureKeyResponse other) {
            errors(other.getErrors());
            signatureKey(other.getSignatureKey());
            return this;
        }

        /**
         * <p>Information on errors encountered during the request.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        /**
         * <p>The new Square-generated signature key used to validate the origin of the webhook event.</p>
         */
        @JsonSetter(value = "signature_key", nulls = Nulls.SKIP)
        public Builder signatureKey(Optional<String> signatureKey) {
            this.signatureKey = signatureKey;
            return this;
        }

        public Builder signatureKey(String signatureKey) {
            this.signatureKey = Optional.ofNullable(signatureKey);
            return this;
        }

        public UpdateWebhookSubscriptionSignatureKeyResponse build() {
            return new UpdateWebhookSubscriptionSignatureKeyResponse(errors, signatureKey, additionalProperties);
        }
    }
}
