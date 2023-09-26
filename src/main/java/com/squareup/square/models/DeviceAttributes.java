
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
 * This is a model class for DeviceAttributes type.
 */
public class DeviceAttributes {
    private final String type;
    private final String manufacturer;
    private final OptionalNullable<String> model;
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> manufacturersId;
    private final String updatedAt;
    private final String version;
    private final OptionalNullable<String> merchantToken;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  manufacturer  String value for manufacturer.
     * @param  model  String value for model.
     * @param  name  String value for name.
     * @param  manufacturersId  String value for manufacturersId.
     * @param  updatedAt  String value for updatedAt.
     * @param  version  String value for version.
     * @param  merchantToken  String value for merchantToken.
     */
    @JsonCreator
    public DeviceAttributes(
            @JsonProperty("type") String type,
            @JsonProperty("manufacturer") String manufacturer,
            @JsonProperty("model") String model,
            @JsonProperty("name") String name,
            @JsonProperty("manufacturers_id") String manufacturersId,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("version") String version,
            @JsonProperty("merchant_token") String merchantToken) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = OptionalNullable.of(model);
        this.name = OptionalNullable.of(name);
        this.manufacturersId = OptionalNullable.of(manufacturersId);
        this.updatedAt = updatedAt;
        this.version = version;
        this.merchantToken = OptionalNullable.of(merchantToken);
    }

    /**
     * Internal initialization constructor.
     */
    protected DeviceAttributes(String type, String manufacturer, OptionalNullable<String> model,
            OptionalNullable<String> name, OptionalNullable<String> manufacturersId,
            String updatedAt, String version, OptionalNullable<String> merchantToken) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.manufacturersId = manufacturersId;
        this.updatedAt = updatedAt;
        this.version = version;
        this.merchantToken = merchantToken;
    }

    /**
     * Getter for Type.
     * An enum identifier of the device type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Manufacturer.
     * The maker of the device.
     * @return Returns the String
     */
    @JsonGetter("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Internal Getter for Model.
     * The specific model of the device.
     * @return Returns the Internal String
     */
    @JsonGetter("model")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetModel() {
        return this.model;
    }

    /**
     * Getter for Model.
     * The specific model of the device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getModel() {
        return OptionalNullable.getFrom(model);
    }

    /**
     * Internal Getter for Name.
     * A seller-specified name for the device.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * A seller-specified name for the device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for ManufacturersId.
     * The manufacturer-supplied identifier for the device (where available). In many cases, this
     * identifier will be a serial number.
     * @return Returns the Internal String
     */
    @JsonGetter("manufacturers_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetManufacturersId() {
        return this.manufacturersId;
    }

    /**
     * Getter for ManufacturersId.
     * The manufacturer-supplied identifier for the device (where available). In many cases, this
     * identifier will be a serial number.
     * @return Returns the String
     */
    @JsonIgnore
    public String getManufacturersId() {
        return OptionalNullable.getFrom(manufacturersId);
    }

    /**
     * Getter for UpdatedAt.
     * The RFC 3339-formatted value of the most recent update to the device information. (Could
     * represent any field update on the device.)
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for Version.
     * The current version of software installed on the device.
     * @return Returns the String
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVersion() {
        return version;
    }

    /**
     * Internal Getter for MerchantToken.
     * The merchant_token identifying the merchant controlling the device.
     * @return Returns the Internal String
     */
    @JsonGetter("merchant_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMerchantToken() {
        return this.merchantToken;
    }

    /**
     * Getter for MerchantToken.
     * The merchant_token identifying the merchant controlling the device.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantToken() {
        return OptionalNullable.getFrom(merchantToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, manufacturer, model, name, manufacturersId, updatedAt, version,
                merchantToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceAttributes)) {
            return false;
        }
        DeviceAttributes other = (DeviceAttributes) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(manufacturer, other.manufacturer)
            && Objects.equals(model, other.model)
            && Objects.equals(name, other.name)
            && Objects.equals(manufacturersId, other.manufacturersId)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(version, other.version)
            && Objects.equals(merchantToken, other.merchantToken);
    }

    /**
     * Converts this DeviceAttributes into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceAttributes [" + "type=" + type + ", manufacturer=" + manufacturer + ", model="
                + model + ", name=" + name + ", manufacturersId=" + manufacturersId + ", updatedAt="
                + updatedAt + ", version=" + version + ", merchantToken=" + merchantToken + "]";
    }

    /**
     * Builds a new {@link DeviceAttributes.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceAttributes.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type, manufacturer)
                .updatedAt(getUpdatedAt())
                .version(getVersion());
        builder.model = internalGetModel();
        builder.name = internalGetName();
        builder.manufacturersId = internalGetManufacturersId();
        builder.merchantToken = internalGetMerchantToken();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceAttributes}.
     */
    public static class Builder {
        private String type = "TERMINAL";
        private String manufacturer;
        private OptionalNullable<String> model;
        private OptionalNullable<String> name;
        private OptionalNullable<String> manufacturersId;
        private String updatedAt;
        private String version;
        private OptionalNullable<String> merchantToken;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         * @param  manufacturer  String value for manufacturer.
         */
        public Builder(String type, String manufacturer) {
            this.type = type;
            this.manufacturer = manufacturer;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for manufacturer.
         * @param  manufacturer  String value for manufacturer.
         * @return Builder
         */
        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        /**
         * Setter for model.
         * @param  model  String value for model.
         * @return Builder
         */
        public Builder model(String model) {
            this.model = OptionalNullable.of(model);
            return this;
        }

        /**
         * UnSetter for model.
         * @return Builder
         */
        public Builder unsetModel() {
            model = null;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for manufacturersId.
         * @param  manufacturersId  String value for manufacturersId.
         * @return Builder
         */
        public Builder manufacturersId(String manufacturersId) {
            this.manufacturersId = OptionalNullable.of(manufacturersId);
            return this;
        }

        /**
         * UnSetter for manufacturersId.
         * @return Builder
         */
        public Builder unsetManufacturersId() {
            manufacturersId = null;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  String value for version.
         * @return Builder
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for merchantToken.
         * @param  merchantToken  String value for merchantToken.
         * @return Builder
         */
        public Builder merchantToken(String merchantToken) {
            this.merchantToken = OptionalNullable.of(merchantToken);
            return this;
        }

        /**
         * UnSetter for merchantToken.
         * @return Builder
         */
        public Builder unsetMerchantToken() {
            merchantToken = null;
            return this;
        }

        /**
         * Builds a new {@link DeviceAttributes} object using the set fields.
         * @return {@link DeviceAttributes}
         */
        public DeviceAttributes build() {
            return new DeviceAttributes(type, manufacturer, model, name, manufacturersId, updatedAt,
                    version, merchantToken);
        }
    }
}
