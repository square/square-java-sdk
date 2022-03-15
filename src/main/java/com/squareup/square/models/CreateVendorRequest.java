
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateVendorRequest type.
 */
public class CreateVendorRequest {
    private final String idempotencyKey;
    private final Vendor vendor;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  vendor  Vendor value for vendor.
     */
    @JsonCreator
    public CreateVendorRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("vendor") Vendor vendor) {
        this.idempotencyKey = idempotencyKey;
        this.vendor = vendor;
    }

    /**
     * Getter for IdempotencyKey.
     * A client-supplied, universally unique identifier (UUID) to make this
     * [CreateVendor]($e/Vendors/CreateVendor) call idempotent. See
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) in the [API
     * Development 101](https://developer.squareup.com/docs/basics/api101/overview) section for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Vendor.
     * Represents a supplier to a seller.
     * @return Returns the Vendor
     */
    @JsonGetter("vendor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        if (!(obj instanceof CreateVendorRequest)) {
            return false;
        }
        CreateVendorRequest other = (CreateVendorRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(vendor, other.vendor);
    }

    /**
     * Converts this CreateVendorRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateVendorRequest [" + "idempotencyKey=" + idempotencyKey + ", vendor=" + vendor
                + "]";
    }

    /**
     * Builds a new {@link CreateVendorRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateVendorRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
                .vendor(getVendor());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateVendorRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Vendor vendor;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for vendor.
         * @param  vendor  Vendor value for vendor.
         * @return Builder
         */
        public Builder vendor(Vendor vendor) {
            this.vendor = vendor;
            return this;
        }

        /**
         * Builds a new {@link CreateVendorRequest} object using the set fields.
         * @return {@link CreateVendorRequest}
         */
        public CreateVendorRequest build() {
            return new CreateVendorRequest(idempotencyKey, vendor);
        }
    }
}
