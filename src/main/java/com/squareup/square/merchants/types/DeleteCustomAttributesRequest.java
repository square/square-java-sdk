/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.merchants.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DeleteCustomAttributesRequest.Builder.class)
public final class DeleteCustomAttributesRequest {
    private final String merchantId;

    private final String key;

    private final Map<String, Object> additionalProperties;

    private DeleteCustomAttributesRequest(String merchantId, String key, Map<String, Object> additionalProperties) {
        this.merchantId = merchantId;
        this.key = key;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the target <a href="entity:Merchant">merchant</a>.
     */
    @JsonProperty("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @return The key of the custom attribute to delete. This key must match the <code>key</code> of a custom
     * attribute definition in the Square seller account. If the requesting application is not the
     * definition owner, you must use the qualified key.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeleteCustomAttributesRequest && equalTo((DeleteCustomAttributesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DeleteCustomAttributesRequest other) {
        return merchantId.equals(other.merchantId) && key.equals(other.key);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.merchantId, this.key);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MerchantIdStage builder() {
        return new Builder();
    }

    public interface MerchantIdStage {
        KeyStage merchantId(@NotNull String merchantId);

        Builder from(DeleteCustomAttributesRequest other);
    }

    public interface KeyStage {
        _FinalStage key(@NotNull String key);
    }

    public interface _FinalStage {
        DeleteCustomAttributesRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MerchantIdStage, KeyStage, _FinalStage {
        private String merchantId;

        private String key;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DeleteCustomAttributesRequest other) {
            merchantId(other.getMerchantId());
            key(other.getKey());
            return this;
        }

        /**
         * <p>The ID of the target <a href="entity:Merchant">merchant</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("merchant_id")
        public KeyStage merchantId(@NotNull String merchantId) {
            this.merchantId = Objects.requireNonNull(merchantId, "merchantId must not be null");
            return this;
        }

        /**
         * <p>The key of the custom attribute to delete. This key must match the <code>key</code> of a custom
         * attribute definition in the Square seller account. If the requesting application is not the
         * definition owner, you must use the qualified key.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("key")
        public _FinalStage key(@NotNull String key) {
            this.key = Objects.requireNonNull(key, "key must not be null");
            return this;
        }

        @java.lang.Override
        public DeleteCustomAttributesRequest build() {
            return new DeleteCustomAttributesRequest(merchantId, key, additionalProperties);
        }
    }
}
