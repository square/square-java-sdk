
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpdateVendorsRequest type.
 */
public class BulkUpdateVendorsRequest {
    private final Map<String, UpdateVendorRequest> vendors;

    /**
     * Initialization constructor.
     * @param  vendors  Map of String, value for vendors.
     */
    @JsonCreator
    public BulkUpdateVendorsRequest(
            @JsonProperty("vendors") Map<String, UpdateVendorRequest> vendors) {
        this.vendors = vendors;
    }

    /**
     * Getter for Vendors.
     * A set of [UpdateVendorRequest]($m/UpdateVendorRequest) objects encapsulating to-be-updated
     * [Vendor]($m/Vendor) objects. The set is represented by a collection of
     * `Vendor`-ID/`UpdateVendorRequest`-object pairs.
     * @return Returns the Map of String, UpdateVendorRequest
     */
    @JsonGetter("vendors")
    public Map<String, UpdateVendorRequest> getVendors() {
        return vendors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpdateVendorsRequest)) {
            return false;
        }
        BulkUpdateVendorsRequest other = (BulkUpdateVendorsRequest) obj;
        return Objects.equals(vendors, other.vendors);
    }

    /**
     * Converts this BulkUpdateVendorsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpdateVendorsRequest [" + "vendors=" + vendors + "]";
    }

    /**
     * Builds a new {@link BulkUpdateVendorsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpdateVendorsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(vendors);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpdateVendorsRequest}.
     */
    public static class Builder {
        private Map<String, UpdateVendorRequest> vendors;

        /**
         * Initialization constructor.
         * @param  vendors  Map of String, value for vendors.
         */
        public Builder(Map<String, UpdateVendorRequest> vendors) {
            this.vendors = vendors;
        }

        /**
         * Setter for vendors.
         * @param  vendors  Map of String, value for vendors.
         * @return Builder
         */
        public Builder vendors(Map<String, UpdateVendorRequest> vendors) {
            this.vendors = vendors;
            return this;
        }

        /**
         * Builds a new {@link BulkUpdateVendorsRequest} object using the set fields.
         * @return {@link BulkUpdateVendorsRequest}
         */
        public BulkUpdateVendorsRequest build() {
            return new BulkUpdateVendorsRequest(vendors);
        }
    }
}
