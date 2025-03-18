/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.merchants.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetCustomAttributesRequest.Builder.class)
public final class GetCustomAttributesRequest {
    private final String merchantId;

    private final String key;

    private final Optional<Boolean> withDefinition;

    private final Optional<Integer> version;

    private final Map<String, Object> additionalProperties;

    private GetCustomAttributesRequest(
            String merchantId,
            String key,
            Optional<Boolean> withDefinition,
            Optional<Integer> version,
            Map<String, Object> additionalProperties) {
        this.merchantId = merchantId;
        this.key = key;
        this.withDefinition = withDefinition;
        this.version = version;
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
     * @return The key of the custom attribute to retrieve. This key must match the <code>key</code> of a custom
     * attribute definition in the Square seller account. If the requesting application is not the
     * definition owner, you must use the qualified key.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * @return Indicates whether to return the <a href="entity:CustomAttributeDefinition">custom attribute definition</a> in the <code>definition</code> field of
     * the custom attribute. Set this parameter to <code>true</code> to get the name and description of the custom
     * attribute, information about the data type, or other definition details. The default value is <code>false</code>.
     */
    @JsonIgnore
    public Optional<Boolean> getWithDefinition() {
        if (withDefinition == null) {
            return Optional.empty();
        }
        return withDefinition;
    }

    /**
     * @return The current version of the custom attribute, which is used for strongly consistent reads to
     * guarantee that you receive the most up-to-date data. When included in the request, Square
     * returns the specified version or a higher version if one exists. If the specified version is
     * higher than the current version, Square returns a <code>BAD_REQUEST</code> error.
     */
    @JsonIgnore
    public Optional<Integer> getVersion() {
        if (version == null) {
            return Optional.empty();
        }
        return version;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("with_definition")
    private Optional<Boolean> _getWithDefinition() {
        return withDefinition;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("version")
    private Optional<Integer> _getVersion() {
        return version;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetCustomAttributesRequest && equalTo((GetCustomAttributesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetCustomAttributesRequest other) {
        return merchantId.equals(other.merchantId)
                && key.equals(other.key)
                && withDefinition.equals(other.withDefinition)
                && version.equals(other.version);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.merchantId, this.key, this.withDefinition, this.version);
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

        Builder from(GetCustomAttributesRequest other);
    }

    public interface KeyStage {
        _FinalStage key(@NotNull String key);
    }

    public interface _FinalStage {
        GetCustomAttributesRequest build();

        _FinalStage withDefinition(Optional<Boolean> withDefinition);

        _FinalStage withDefinition(Boolean withDefinition);

        _FinalStage withDefinition(Nullable<Boolean> withDefinition);

        _FinalStage version(Optional<Integer> version);

        _FinalStage version(Integer version);

        _FinalStage version(Nullable<Integer> version);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MerchantIdStage, KeyStage, _FinalStage {
        private String merchantId;

        private String key;

        private Optional<Integer> version = Optional.empty();

        private Optional<Boolean> withDefinition = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetCustomAttributesRequest other) {
            merchantId(other.getMerchantId());
            key(other.getKey());
            withDefinition(other.getWithDefinition());
            version(other.getVersion());
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
         * <p>The key of the custom attribute to retrieve. This key must match the <code>key</code> of a custom
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

        /**
         * <p>The current version of the custom attribute, which is used for strongly consistent reads to
         * guarantee that you receive the most up-to-date data. When included in the request, Square
         * returns the specified version or a higher version if one exists. If the specified version is
         * higher than the current version, Square returns a <code>BAD_REQUEST</code> error.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage version(Nullable<Integer> version) {
            if (version.isNull()) {
                this.version = null;
            } else if (version.isEmpty()) {
                this.version = Optional.empty();
            } else {
                this.version = Optional.of(version.get());
            }
            return this;
        }

        /**
         * <p>The current version of the custom attribute, which is used for strongly consistent reads to
         * guarantee that you receive the most up-to-date data. When included in the request, Square
         * returns the specified version or a higher version if one exists. If the specified version is
         * higher than the current version, Square returns a <code>BAD_REQUEST</code> error.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage version(Integer version) {
            this.version = Optional.ofNullable(version);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "version", nulls = Nulls.SKIP)
        public _FinalStage version(Optional<Integer> version) {
            this.version = version;
            return this;
        }

        /**
         * <p>Indicates whether to return the <a href="entity:CustomAttributeDefinition">custom attribute definition</a> in the <code>definition</code> field of
         * the custom attribute. Set this parameter to <code>true</code> to get the name and description of the custom
         * attribute, information about the data type, or other definition details. The default value is <code>false</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage withDefinition(Nullable<Boolean> withDefinition) {
            if (withDefinition.isNull()) {
                this.withDefinition = null;
            } else if (withDefinition.isEmpty()) {
                this.withDefinition = Optional.empty();
            } else {
                this.withDefinition = Optional.of(withDefinition.get());
            }
            return this;
        }

        /**
         * <p>Indicates whether to return the <a href="entity:CustomAttributeDefinition">custom attribute definition</a> in the <code>definition</code> field of
         * the custom attribute. Set this parameter to <code>true</code> to get the name and description of the custom
         * attribute, information about the data type, or other definition details. The default value is <code>false</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage withDefinition(Boolean withDefinition) {
            this.withDefinition = Optional.ofNullable(withDefinition);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "with_definition", nulls = Nulls.SKIP)
        public _FinalStage withDefinition(Optional<Boolean> withDefinition) {
            this.withDefinition = withDefinition;
            return this;
        }

        @java.lang.Override
        public GetCustomAttributesRequest build() {
            return new GetCustomAttributesRequest(merchantId, key, withDefinition, version, additionalProperties);
        }
    }
}
