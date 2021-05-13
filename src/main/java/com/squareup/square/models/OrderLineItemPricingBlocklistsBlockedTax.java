
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemPricingBlocklistsBlockedTax type.
 */
public class OrderLineItemPricingBlocklistsBlockedTax {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String uid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String taxUid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String taxCatalogObjectId;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  taxUid  String value for taxUid.
     * @param  taxCatalogObjectId  String value for taxCatalogObjectId.
     */
    @JsonCreator
    public OrderLineItemPricingBlocklistsBlockedTax(
            @JsonProperty("uid") String uid,
            @JsonProperty("tax_uid") String taxUid,
            @JsonProperty("tax_catalog_object_id") String taxCatalogObjectId) {
        this.uid = uid;
        this.taxUid = taxUid;
        this.taxCatalogObjectId = taxCatalogObjectId;
    }

    /**
     * Getter for Uid.
     * A unique ID of the `BlockedTax` within the order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * Getter for TaxUid.
     * The `uid` of the tax that should be blocked. Use this field to block ad hoc taxes. For
     * catalog, taxes use the `tax_catalog_object_id` field.
     * @return Returns the String
     */
    @JsonGetter("tax_uid")
    public String getTaxUid() {
        return taxUid;
    }

    /**
     * Getter for TaxCatalogObjectId.
     * The `catalog_object_id` of the tax that should be blocked. Use this field to block catalog
     * taxes. For ad hoc taxes, use the `tax_uid` field.
     * @return Returns the String
     */
    @JsonGetter("tax_catalog_object_id")
    public String getTaxCatalogObjectId() {
        return taxCatalogObjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, taxUid, taxCatalogObjectId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemPricingBlocklistsBlockedTax)) {
            return false;
        }
        OrderLineItemPricingBlocklistsBlockedTax other =
                (OrderLineItemPricingBlocklistsBlockedTax) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(taxUid, other.taxUid)
            && Objects.equals(taxCatalogObjectId, other.taxCatalogObjectId);
    }

    /**
     * Converts this OrderLineItemPricingBlocklistsBlockedTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemPricingBlocklistsBlockedTax [" + "uid=" + uid + ", taxUid=" + taxUid
                + ", taxCatalogObjectId=" + taxCatalogObjectId + "]";
    }

    /**
     * Builds a new {@link OrderLineItemPricingBlocklistsBlockedTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemPricingBlocklistsBlockedTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .uid(getUid())
                .taxUid(getTaxUid())
                .taxCatalogObjectId(getTaxCatalogObjectId());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemPricingBlocklistsBlockedTax}.
     */
    public static class Builder {
        private String uid;
        private String taxUid;
        private String taxCatalogObjectId;



        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for taxUid.
         * @param  taxUid  String value for taxUid.
         * @return Builder
         */
        public Builder taxUid(String taxUid) {
            this.taxUid = taxUid;
            return this;
        }

        /**
         * Setter for taxCatalogObjectId.
         * @param  taxCatalogObjectId  String value for taxCatalogObjectId.
         * @return Builder
         */
        public Builder taxCatalogObjectId(String taxCatalogObjectId) {
            this.taxCatalogObjectId = taxCatalogObjectId;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemPricingBlocklistsBlockedTax} object using the set
         * fields.
         * @return {@link OrderLineItemPricingBlocklistsBlockedTax}
         */
        public OrderLineItemPricingBlocklistsBlockedTax build() {
            return new OrderLineItemPricingBlocklistsBlockedTax(uid, taxUid, taxCatalogObjectId);
        }
    }
}
