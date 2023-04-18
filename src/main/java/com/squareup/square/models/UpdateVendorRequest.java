
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for UpdateVendorRequest type.
 */
public class UpdateVendorRequest {
    private final OptionalNullable<String> idempotencyKey;
    private final Vendor vendor;

    /**
     * Initialization constructor.
     * @param  vendor  Vendor value for vendor.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpdateVendorRequest(
            @JsonProperty("vendor") Vendor vendor,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
        this.vendor = vendor;
    }

    /**
     * Internal initialization constructor.
     */
    protected UpdateVendorRequest(Vendor vendor, OptionalNullable<String> idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.vendor = vendor;
    }

    /**
     * Internal Getter for IdempotencyKey.
     * A client-supplied, universally unique identifier (UUID) for the request. See
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency)
     * in the [API Development 101](https://developer.squareup.com/docs/buildbasics) section for
     * more information.
     * @return Returns the Internal String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A client-supplied, universally unique identifier (UUID) for the request. See
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency)
     * in the [API Development 101](https://developer.squareup.com/docs/buildbasics) section for
     * more information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    /**
     * Getter for Vendor.
     * Represents a supplier to a seller.
     * @return Returns the Vendor
     */
    @JsonGetter("vendor")
    public Vendor getVendor() {
        return vendor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, vendor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateVendorRequest)) {
            return false;
        }
        UpdateVendorRequest other = (UpdateVendorRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(vendor, other.vendor);
    }

    /**
     * Converts this UpdateVendorRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateVendorRequest [" + "vendor=" + vendor + ", idempotencyKey=" + idempotencyKey
                + "]";
    }

    /**
     * Builds a new {@link UpdateVendorRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateVendorRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(vendor);
        builder.idempotencyKey = internalGetIdempotencyKey();
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateVendorRequest}.
     */
    public static class Builder {
        private Vendor vendor;
        private OptionalNullable<String> idempotencyKey;

        /**
         * Initialization constructor.
         * @param  vendor  Vendor value for vendor.
         */
        public Builder(Vendor vendor) {
            this.vendor = vendor;
        }

        /**
         * Setter for vendor.
         * @param  vendor  Vendor value for vendor.
         * @return Builder
         */
        public Builder vendor(Vendor vendor) {
            this.vendor = vendor;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = OptionalNullable.of(idempotencyKey);
            return this;
        }

        /**
         * UnSetter for idempotencyKey.
         * @return Builder
         */
        public Builder unsetIdempotencyKey() {
            idempotencyKey = null;
            return this;
        }

        /**
         * Builds a new {@link UpdateVendorRequest} object using the set fields.
         * @return {@link UpdateVendorRequest}
         */
        public UpdateVendorRequest build() {
            return new UpdateVendorRequest(vendor, idempotencyKey);
        }
    }
}
