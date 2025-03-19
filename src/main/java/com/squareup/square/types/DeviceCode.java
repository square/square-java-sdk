/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

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
@JsonDeserialize(builder = DeviceCode.Builder.class)
public final class DeviceCode {
    private final Optional<String> id;

    private final Optional<String> name;

    private final Optional<String> code;

    private final Optional<String> deviceId;

    private final String productType;

    private final Optional<String> locationId;

    private final Optional<DeviceCodeStatus> status;

    private final Optional<String> pairBy;

    private final Optional<String> createdAt;

    private final Optional<String> statusChangedAt;

    private final Optional<String> pairedAt;

    private final Map<String, Object> additionalProperties;

    private DeviceCode(
            Optional<String> id,
            Optional<String> name,
            Optional<String> code,
            Optional<String> deviceId,
            String productType,
            Optional<String> locationId,
            Optional<DeviceCodeStatus> status,
            Optional<String> pairBy,
            Optional<String> createdAt,
            Optional<String> statusChangedAt,
            Optional<String> pairedAt,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.deviceId = deviceId;
        this.productType = productType;
        this.locationId = locationId;
        this.status = status;
        this.pairBy = pairBy;
        this.createdAt = createdAt;
        this.statusChangedAt = statusChangedAt;
        this.pairedAt = pairedAt;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique id for this device code.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return An optional user-defined name for the device code.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return The unique code that can be used to login.
     */
    @JsonProperty("code")
    public Optional<String> getCode() {
        return code;
    }

    /**
     * @return The unique id of the device that used this code. Populated when the device is paired up.
     */
    @JsonProperty("device_id")
    public Optional<String> getDeviceId() {
        return deviceId;
    }

    /**
     * @return The targeting product type of the device code.
     */
    @JsonProperty("product_type")
    public String getProductType() {
        return productType;
    }

    /**
     * @return The location assigned to this code.
     */
    @JsonIgnore
    public Optional<String> getLocationId() {
        if (locationId == null) {
            return Optional.empty();
        }
        return locationId;
    }

    /**
     * @return The pairing status of the device code.
     * See <a href="#type-devicecodestatus">DeviceCodeStatus</a> for possible values
     */
    @JsonProperty("status")
    public Optional<DeviceCodeStatus> getStatus() {
        return status;
    }

    /**
     * @return When this DeviceCode will expire and no longer login. Timestamp in RFC 3339 format.
     */
    @JsonProperty("pair_by")
    public Optional<String> getPairBy() {
        return pairBy;
    }

    /**
     * @return When this DeviceCode was created. Timestamp in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return When this DeviceCode's status was last changed. Timestamp in RFC 3339 format.
     */
    @JsonProperty("status_changed_at")
    public Optional<String> getStatusChangedAt() {
        return statusChangedAt;
    }

    /**
     * @return When this DeviceCode was paired. Timestamp in RFC 3339 format.
     */
    @JsonProperty("paired_at")
    public Optional<String> getPairedAt() {
        return pairedAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_id")
    private Optional<String> _getLocationId() {
        return locationId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeviceCode && equalTo((DeviceCode) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DeviceCode other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && code.equals(other.code)
                && deviceId.equals(other.deviceId)
                && productType.equals(other.productType)
                && locationId.equals(other.locationId)
                && status.equals(other.status)
                && pairBy.equals(other.pairBy)
                && createdAt.equals(other.createdAt)
                && statusChangedAt.equals(other.statusChangedAt)
                && pairedAt.equals(other.pairedAt);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.code,
                this.deviceId,
                this.productType,
                this.locationId,
                this.status,
                this.pairBy,
                this.createdAt,
                this.statusChangedAt,
                this.pairedAt);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ProductTypeStage builder() {
        return new Builder();
    }

    public interface ProductTypeStage {
        _FinalStage productType(@NotNull String productType);

        Builder from(DeviceCode other);
    }

    public interface _FinalStage {
        DeviceCode build();

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        _FinalStage name(Nullable<String> name);

        _FinalStage code(Optional<String> code);

        _FinalStage code(String code);

        _FinalStage deviceId(Optional<String> deviceId);

        _FinalStage deviceId(String deviceId);

        _FinalStage locationId(Optional<String> locationId);

        _FinalStage locationId(String locationId);

        _FinalStage locationId(Nullable<String> locationId);

        _FinalStage status(Optional<DeviceCodeStatus> status);

        _FinalStage status(DeviceCodeStatus status);

        _FinalStage pairBy(Optional<String> pairBy);

        _FinalStage pairBy(String pairBy);

        _FinalStage createdAt(Optional<String> createdAt);

        _FinalStage createdAt(String createdAt);

        _FinalStage statusChangedAt(Optional<String> statusChangedAt);

        _FinalStage statusChangedAt(String statusChangedAt);

        _FinalStage pairedAt(Optional<String> pairedAt);

        _FinalStage pairedAt(String pairedAt);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ProductTypeStage, _FinalStage {
        private String productType;

        private Optional<String> pairedAt = Optional.empty();

        private Optional<String> statusChangedAt = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> pairBy = Optional.empty();

        private Optional<DeviceCodeStatus> status = Optional.empty();

        private Optional<String> locationId = Optional.empty();

        private Optional<String> deviceId = Optional.empty();

        private Optional<String> code = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DeviceCode other) {
            id(other.getId());
            name(other.getName());
            code(other.getCode());
            deviceId(other.getDeviceId());
            productType(other.getProductType());
            locationId(other.getLocationId());
            status(other.getStatus());
            pairBy(other.getPairBy());
            createdAt(other.getCreatedAt());
            statusChangedAt(other.getStatusChangedAt());
            pairedAt(other.getPairedAt());
            return this;
        }

        /**
         * <p>The targeting product type of the device code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("product_type")
        public _FinalStage productType(@NotNull String productType) {
            this.productType = Objects.requireNonNull(productType, "productType must not be null");
            return this;
        }

        /**
         * <p>When this DeviceCode was paired. Timestamp in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage pairedAt(String pairedAt) {
            this.pairedAt = Optional.ofNullable(pairedAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "paired_at", nulls = Nulls.SKIP)
        public _FinalStage pairedAt(Optional<String> pairedAt) {
            this.pairedAt = pairedAt;
            return this;
        }

        /**
         * <p>When this DeviceCode's status was last changed. Timestamp in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage statusChangedAt(String statusChangedAt) {
            this.statusChangedAt = Optional.ofNullable(statusChangedAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "status_changed_at", nulls = Nulls.SKIP)
        public _FinalStage statusChangedAt(Optional<String> statusChangedAt) {
            this.statusChangedAt = statusChangedAt;
            return this;
        }

        /**
         * <p>When this DeviceCode was created. Timestamp in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>When this DeviceCode will expire and no longer login. Timestamp in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage pairBy(String pairBy) {
            this.pairBy = Optional.ofNullable(pairBy);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "pair_by", nulls = Nulls.SKIP)
        public _FinalStage pairBy(Optional<String> pairBy) {
            this.pairBy = pairBy;
            return this;
        }

        /**
         * <p>The pairing status of the device code.
         * See <a href="#type-devicecodestatus">DeviceCodeStatus</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage status(DeviceCodeStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<DeviceCodeStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * <p>The location assigned to this code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage locationId(Nullable<String> locationId) {
            if (locationId.isNull()) {
                this.locationId = null;
            } else if (locationId.isEmpty()) {
                this.locationId = Optional.empty();
            } else {
                this.locationId = Optional.of(locationId.get());
            }
            return this;
        }

        /**
         * <p>The location assigned to this code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public _FinalStage locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * <p>The unique id of the device that used this code. Populated when the device is paired up.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage deviceId(String deviceId) {
            this.deviceId = Optional.ofNullable(deviceId);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "device_id", nulls = Nulls.SKIP)
        public _FinalStage deviceId(Optional<String> deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * <p>The unique code that can be used to login.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage code(String code) {
            this.code = Optional.ofNullable(code);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "code", nulls = Nulls.SKIP)
        public _FinalStage code(Optional<String> code) {
            this.code = code;
            return this;
        }

        /**
         * <p>An optional user-defined name for the device code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage name(Nullable<String> name) {
            if (name.isNull()) {
                this.name = null;
            } else if (name.isEmpty()) {
                this.name = Optional.empty();
            } else {
                this.name = Optional.of(name.get());
            }
            return this;
        }

        /**
         * <p>An optional user-defined name for the device code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The unique id for this device code.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public DeviceCode build() {
            return new DeviceCode(
                    id,
                    name,
                    code,
                    deviceId,
                    productType,
                    locationId,
                    status,
                    pairBy,
                    createdAt,
                    statusChangedAt,
                    pairedAt,
                    additionalProperties);
        }
    }
}
