
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkRetrieveVendorsRequest type.
 */
public class BulkRetrieveVendorsRequest {
    private final List<String> vendorIds;

    /**
     * Initialization constructor.
     * @param  vendorIds  List of String value for vendorIds.
     */
    @JsonCreator
    public BulkRetrieveVendorsRequest(
            @JsonProperty("vendor_ids") List<String> vendorIds) {
        this.vendorIds = vendorIds;
    }

    /**
     * Getter for VendorIds.
     * IDs of the [Vendor]($m/Vendor) objects to retrieve.
     * @return Returns the List of String
     */
    @JsonGetter("vendor_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getVendorIds() {
        return vendorIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkRetrieveVendorsRequest)) {
            return false;
        }
        BulkRetrieveVendorsRequest other = (BulkRetrieveVendorsRequest) obj;
        return Objects.equals(vendorIds, other.vendorIds);
    }

    /**
     * Converts this BulkRetrieveVendorsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveVendorsRequest [" + "vendorIds=" + vendorIds + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveVendorsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveVendorsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .vendorIds(getVendorIds());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveVendorsRequest}.
     */
    public static class Builder {
        private List<String> vendorIds;



        /**
         * Setter for vendorIds.
         * @param  vendorIds  List of String value for vendorIds.
         * @return Builder
         */
        public Builder vendorIds(List<String> vendorIds) {
            this.vendorIds = vendorIds;
            return this;
        }

        /**
         * Builds a new {@link BulkRetrieveVendorsRequest} object using the set fields.
         * @return {@link BulkRetrieveVendorsRequest}
         */
        public BulkRetrieveVendorsRequest build() {
            return new BulkRetrieveVendorsRequest(vendorIds);
        }
    }
}
