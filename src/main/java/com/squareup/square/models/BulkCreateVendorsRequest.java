
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkCreateVendorsRequest type.
 */
public class BulkCreateVendorsRequest {
    private final Map<String, Vendor> vendors;

    /**
     * Initialization constructor.
     * @param  vendors  Map of String, value for vendors.
     */
    @JsonCreator
    public BulkCreateVendorsRequest(
            @JsonProperty("vendors") Map<String, Vendor> vendors) {
        this.vendors = vendors;
    }

    /**
     * Getter for Vendors.
     * Specifies a set of new [Vendor](entity:Vendor] objects as represented by a collection of
     * idempotency-key/`Vendor`-object pairs.
     * @return Returns the Map of String, Vendor
     */
    @JsonGetter("vendors")
    public Map<String, Vendor> getVendors() {
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
        if (!(obj instanceof BulkCreateVendorsRequest)) {
            return false;
        }
        BulkCreateVendorsRequest other = (BulkCreateVendorsRequest) obj;
        return Objects.equals(vendors, other.vendors);
    }

    /**
     * Converts this BulkCreateVendorsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkCreateVendorsRequest [" + "vendors=" + vendors + "]";
    }

    /**
     * Builds a new {@link BulkCreateVendorsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkCreateVendorsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(vendors);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkCreateVendorsRequest}.
     */
    public static class Builder {
        private Map<String, Vendor> vendors;

        /**
         * Initialization constructor.
         * @param  vendors  Map of String, value for vendors.
         */
        public Builder(Map<String, Vendor> vendors) {
            this.vendors = vendors;
        }

        /**
         * Setter for vendors.
         * @param  vendors  Map of String, value for vendors.
         * @return Builder
         */
        public Builder vendors(Map<String, Vendor> vendors) {
            this.vendors = vendors;
            return this;
        }

        /**
         * Builds a new {@link BulkCreateVendorsRequest} object using the set fields.
         * @return {@link BulkCreateVendorsRequest}
         */
        public BulkCreateVendorsRequest build() {
            return new BulkCreateVendorsRequest(vendors);
        }
    }
}
