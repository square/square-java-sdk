package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DeviceCode type.
 */
public class DeviceCode {

    /**
     * Initialization constructor.
     * @param productType
     * @param id
     * @param name
     * @param code
     * @param deviceId
     * @param locationId
     * @param status
     * @param pairBy
     * @param createdAt
     * @param statusChangedAt
     * @param pairedAt
     */
    @JsonCreator
    public DeviceCode(
            @JsonProperty("product_type") String productType,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("code") String code,
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("pair_by") String pairBy,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("status_changed_at") String statusChangedAt,
            @JsonProperty("paired_at") String pairedAt) {
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
    }

    private final String id;
    private final String name;
    private final String code;
    private final String deviceId;
    private final String productType;
    private final String locationId;
    private final String status;
    private final String pairBy;
    private final String createdAt;
    private final String statusChangedAt;
    private final String pairedAt;
    /**
     * Getter for Id.
     * The unique id for this device code.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * An optional user-defined name for the device code.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Code.
     * The unique code that can be used to login.
     */
    @JsonGetter("code")
    public String getCode() {
        return this.code;
    }

    /**
     * Getter for DeviceId.
     * The unique id of the device that used this code. Populated when the device is paired up.
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for ProductType.
     */
    @JsonGetter("product_type")
    public String getProductType() {
        return this.productType;
    }

    /**
     * Getter for LocationId.
     * The location assigned to this code.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Status.
     * DeviceCode.Status enum.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for PairBy.
     * When this DeviceCode will expire and no longer login. Timestamp in RFC 3339 format.
     */
    @JsonGetter("pair_by")
    public String getPairBy() {
        return this.pairBy;
    }

    /**
     * Getter for CreatedAt.
     * When this DeviceCode was created. Timestamp in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for StatusChangedAt.
     * When this DeviceCode's status was last changed. Timestamp in RFC 3339 format.
     */
    @JsonGetter("status_changed_at")
    public String getStatusChangedAt() {
        return this.statusChangedAt;
    }

    /**
     * Getter for PairedAt.
     * When this DeviceCode was paired. Timestamp in RFC 3339 format.
     */
    @JsonGetter("paired_at")
    public String getPairedAt() {
        return this.pairedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, deviceId, productType, locationId, status, pairBy,
            createdAt, statusChangedAt, pairedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DeviceCode)) {
            return false;
        }
        DeviceCode deviceCode = (DeviceCode) obj;
        return Objects.equals(id, deviceCode.id) &&
            Objects.equals(name, deviceCode.name) &&
            Objects.equals(code, deviceCode.code) &&
            Objects.equals(deviceId, deviceCode.deviceId) &&
            Objects.equals(productType, deviceCode.productType) &&
            Objects.equals(locationId, deviceCode.locationId) &&
            Objects.equals(status, deviceCode.status) &&
            Objects.equals(pairBy, deviceCode.pairBy) &&
            Objects.equals(createdAt, deviceCode.createdAt) &&
            Objects.equals(statusChangedAt, deviceCode.statusChangedAt) &&
            Objects.equals(pairedAt, deviceCode.pairedAt);
    }

    /**
     * Builds a new {@link DeviceCode.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceCode.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(productType)
            .id(getId())
            .name(getName())
            .code(getCode())
            .deviceId(getDeviceId())
            .locationId(getLocationId())
            .status(getStatus())
            .pairBy(getPairBy())
            .createdAt(getCreatedAt())
            .statusChangedAt(getStatusChangedAt())
            .pairedAt(getPairedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link DeviceCode}
     */
    public static class Builder {
        private String productType = "TERMINAL_API";
        private String id;
        private String name;
        private String code;
        private String deviceId;
        private String locationId;
        private String status;
        private String pairBy;
        private String createdAt;
        private String statusChangedAt;
        private String pairedAt;

        /**
         * Initialization constructor
         */
        public Builder(String productType) {
            this.productType = productType;
        }

        /**
         * Setter for productType
         * @param productType
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for code
         * @param code
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }
        /**
         * Setter for deviceId
         * @param deviceId
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        /**
         * Setter for pairBy
         * @param pairBy
         * @return Builder
         */
        public Builder pairBy(String pairBy) {
            this.pairBy = pairBy;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for statusChangedAt
         * @param statusChangedAt
         * @return Builder
         */
        public Builder statusChangedAt(String statusChangedAt) {
            this.statusChangedAt = statusChangedAt;
            return this;
        }
        /**
         * Setter for pairedAt
         * @param pairedAt
         * @return Builder
         */
        public Builder pairedAt(String pairedAt) {
            this.pairedAt = pairedAt;
            return this;
        }

        /**
         * Builds a new {@link DeviceCode} object using the set fields.
         * @return {@link DeviceCode}
         */
        public DeviceCode build() {
            return new DeviceCode(productType,
                id,
                name,
                code,
                deviceId,
                locationId,
                status,
                pairBy,
                createdAt,
                statusChangedAt,
                pairedAt);
        }
    }
}
