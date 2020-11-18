
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DeviceCode type.
 */
public class DeviceCode {
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
     * Initialization constructor.
     * @param productType String value for productType.
     * @param id String value for id.
     * @param name String value for name.
     * @param code String value for code.
     * @param deviceId String value for deviceId.
     * @param locationId String value for locationId.
     * @param status String value for status.
     * @param pairBy String value for pairBy.
     * @param createdAt String value for createdAt.
     * @param statusChangedAt String value for statusChangedAt.
     * @param pairedAt String value for pairedAt.
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

    /**
     * Getter for Id.
     * The unique id for this device code.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * An optional user-defined name for the device code.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Code.
     * The unique code that can be used to login.
     * @return Returns the String
     */
    @JsonGetter("code")
    public String getCode() {
        return this.code;
    }

    /**
     * Getter for DeviceId.
     * The unique id of the device that used this code. Populated when the device is paired up.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for ProductType.
     * @return Returns the String
     */
    @JsonGetter("product_type")
    public String getProductType() {
        return this.productType;
    }

    /**
     * Getter for LocationId.
     * The location assigned to this code.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Status.
     * DeviceCode.Status enum.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for PairBy.
     * When this DeviceCode will expire and no longer login. Timestamp in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("pair_by")
    public String getPairBy() {
        return this.pairBy;
    }

    /**
     * Getter for CreatedAt.
     * When this DeviceCode was created. Timestamp in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for StatusChangedAt.
     * When this DeviceCode's status was last changed. Timestamp in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("status_changed_at")
    public String getStatusChangedAt() {
        return this.statusChangedAt;
    }

    /**
     * Getter for PairedAt.
     * When this DeviceCode was paired. Timestamp in RFC 3339 format.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceCode)) {
            return false;
        }
        DeviceCode other = (DeviceCode) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(code, other.code)
            && Objects.equals(deviceId, other.deviceId)
            && Objects.equals(productType, other.productType)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(status, other.status)
            && Objects.equals(pairBy, other.pairBy)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(statusChangedAt, other.statusChangedAt)
            && Objects.equals(pairedAt, other.pairedAt);
    }

    /**
     * Converts this DeviceCode into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceCode [" + "productType=" + productType + ", id=" + id + ", name=" + name
                + ", code=" + code + ", deviceId=" + deviceId + ", locationId=" + locationId
                + ", status=" + status + ", pairBy=" + pairBy + ", createdAt=" + createdAt
                + ", statusChangedAt=" + statusChangedAt + ", pairedAt=" + pairedAt + "]";
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
     * Class to build instances of {@link DeviceCode}.
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
         * Initialization constructor.
         * @param productType String value for productType.
         */
        public Builder(String productType) {
            this.productType = productType;
        }

        /**
         * Setter for productType.
         * @param productType String value for productType.
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for code.
         * @param code String value for code.
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Setter for deviceId.
         * @param deviceId String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for pairBy.
         * @param pairBy String value for pairBy.
         * @return Builder
         */
        public Builder pairBy(String pairBy) {
            this.pairBy = pairBy;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for statusChangedAt.
         * @param statusChangedAt String value for statusChangedAt.
         * @return Builder
         */
        public Builder statusChangedAt(String statusChangedAt) {
            this.statusChangedAt = statusChangedAt;
            return this;
        }

        /**
         * Setter for pairedAt.
         * @param pairedAt String value for pairedAt.
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
            return new DeviceCode(productType, id, name, code, deviceId, locationId, status, pairBy,
                    createdAt, statusChangedAt, pairedAt);
        }
    }
}
