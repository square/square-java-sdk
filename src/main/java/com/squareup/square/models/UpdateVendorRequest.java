
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateVendorRequest type.
 */
public class UpdateVendorRequest {
    private final String idempotencyKey;
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
        this.idempotencyKey = idempotencyKey;
        this.vendor = vendor;
    }

    /**
     * Getter for IdempotencyKey.
     * A client-supplied, universally unique identifier (UUID) for the request. See
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) in the [API
     * Development 101](https://developer.squareup.com/docs/basics/api101/overview) section for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
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
        Builder builder = new Builder(vendor)
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateVendorRequest}.
     */
    public static class Builder {
        private Vendor vendor;
        private String idempotencyKey;

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
            this.idempotencyKey = idempotencyKey;
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
