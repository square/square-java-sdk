/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.devices.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.types.DeviceCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateDeviceCodeRequest.Builder.class)
public final class CreateDeviceCodeRequest {
    private final String idempotencyKey;

    private final DeviceCode deviceCode;

    private final Map<String, Object> additionalProperties;

    private CreateDeviceCodeRequest(
            String idempotencyKey, DeviceCode deviceCode, Map<String, Object> additionalProperties) {
        this.idempotencyKey = idempotencyKey;
        this.deviceCode = deviceCode;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique string that identifies this CreateDeviceCode request. Keys can
     * be any valid string but must be unique for every CreateDeviceCode request.
     * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency keys</a> for more information.</p>
     */
    @JsonProperty("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * @return The device code to create.
     */
    @JsonProperty("device_code")
    public DeviceCode getDeviceCode() {
        return deviceCode;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateDeviceCodeRequest && equalTo((CreateDeviceCodeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateDeviceCodeRequest other) {
        return idempotencyKey.equals(other.idempotencyKey) && deviceCode.equals(other.deviceCode);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.idempotencyKey, this.deviceCode);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdempotencyKeyStage builder() {
        return new Builder();
    }

    public interface IdempotencyKeyStage {
        /**
         * <p>A unique string that identifies this CreateDeviceCode request. Keys can
         * be any valid string but must be unique for every CreateDeviceCode request.</p>
         * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency keys</a> for more information.</p>
         */
        DeviceCodeStage idempotencyKey(@NotNull String idempotencyKey);

        Builder from(CreateDeviceCodeRequest other);
    }

    public interface DeviceCodeStage {
        /**
         * <p>The device code to create.</p>
         */
        _FinalStage deviceCode(@NotNull DeviceCode deviceCode);
    }

    public interface _FinalStage {
        CreateDeviceCodeRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdempotencyKeyStage, DeviceCodeStage, _FinalStage {
        private String idempotencyKey;

        private DeviceCode deviceCode;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateDeviceCodeRequest other) {
            idempotencyKey(other.getIdempotencyKey());
            deviceCode(other.getDeviceCode());
            return this;
        }

        /**
         * <p>A unique string that identifies this CreateDeviceCode request. Keys can
         * be any valid string but must be unique for every CreateDeviceCode request.</p>
         * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency keys</a> for more information.</p>
         * <p>A unique string that identifies this CreateDeviceCode request. Keys can
         * be any valid string but must be unique for every CreateDeviceCode request.</p>
         * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency keys</a> for more information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("idempotency_key")
        public DeviceCodeStage idempotencyKey(@NotNull String idempotencyKey) {
            this.idempotencyKey = Objects.requireNonNull(idempotencyKey, "idempotencyKey must not be null");
            return this;
        }

        /**
         * <p>The device code to create.</p>
         * <p>The device code to create.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("device_code")
        public _FinalStage deviceCode(@NotNull DeviceCode deviceCode) {
            this.deviceCode = Objects.requireNonNull(deviceCode, "deviceCode must not be null");
            return this;
        }

        @java.lang.Override
        public CreateDeviceCodeRequest build() {
            return new CreateDeviceCodeRequest(idempotencyKey, deviceCode, additionalProperties);
        }
    }
}
