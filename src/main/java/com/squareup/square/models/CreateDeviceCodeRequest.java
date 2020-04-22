package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateDeviceCodeRequest type.
 */
public class CreateDeviceCodeRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param deviceCode
     */
    @JsonCreator
    public CreateDeviceCodeRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("device_code") DeviceCode deviceCode) {
        this.idempotencyKey = idempotencyKey;
        this.deviceCode = deviceCode;
    }

    private final String idempotencyKey;
    private final DeviceCode deviceCode;
    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this CreateCheckout request. Keys can be any valid string but
     * must be unique for every CreateCheckout request.
     * See [Idempotency keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for DeviceCode.
     */
    @JsonGetter("device_code")
    public DeviceCode getDeviceCode() {
        return this.deviceCode;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, deviceCode);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateDeviceCodeRequest)) {
            return false;
        }
        CreateDeviceCodeRequest createDeviceCodeRequest = (CreateDeviceCodeRequest) obj;
        return Objects.equals(idempotencyKey, createDeviceCodeRequest.idempotencyKey) &&
            Objects.equals(deviceCode, createDeviceCodeRequest.deviceCode);
    }

    /**
     * Builds a new {@link CreateDeviceCodeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateDeviceCodeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            deviceCode);
            return builder;
    }

    /**
     * Class to build instances of {@link CreateDeviceCodeRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private DeviceCode deviceCode;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey,
                DeviceCode deviceCode) {
            this.idempotencyKey = idempotencyKey;
            this.deviceCode = deviceCode;
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for deviceCode
         * @param deviceCode
         * @return Builder
         */
        public Builder deviceCode(DeviceCode deviceCode) {
            this.deviceCode = deviceCode;
            return this;
        }

        /**
         * Builds a new {@link CreateDeviceCodeRequest} object using the set fields.
         * @return {@link CreateDeviceCodeRequest}
         */
        public CreateDeviceCodeRequest build() {
            return new CreateDeviceCodeRequest(idempotencyKey,
                deviceCode);
        }
    }
}
