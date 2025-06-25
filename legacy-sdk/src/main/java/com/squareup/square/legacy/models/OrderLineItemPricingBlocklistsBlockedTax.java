package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemPricingBlocklistsBlockedTax type.
 */
public class OrderLineItemPricingBlocklistsBlockedTax {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> taxUid;
    private final OptionalNullable<String> taxCatalogObjectId;

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
        this.uid = OptionalNullable.of(uid);
        this.taxUid = OptionalNullable.of(taxUid);
        this.taxCatalogObjectId = OptionalNullable.of(taxCatalogObjectId);
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  taxUid  String value for taxUid.
     * @param  taxCatalogObjectId  String value for taxCatalogObjectId.
     */
    protected OrderLineItemPricingBlocklistsBlockedTax(
            OptionalNullable<String> uid,
            OptionalNullable<String> taxUid,
            OptionalNullable<String> taxCatalogObjectId) {
        this.uid = uid;
        this.taxUid = taxUid;
        this.taxCatalogObjectId = taxCatalogObjectId;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID of the `BlockedTax` within the order.
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * A unique ID of the `BlockedTax` within the order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for TaxUid.
     * The `uid` of the tax that should be blocked. Use this field to block ad hoc taxes. For
     * catalog, taxes use the `tax_catalog_object_id` field.
     * @return Returns the Internal String
     */
    @JsonGetter("tax_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTaxUid() {
        return this.taxUid;
    }

    /**
     * Getter for TaxUid.
     * The `uid` of the tax that should be blocked. Use this field to block ad hoc taxes. For
     * catalog, taxes use the `tax_catalog_object_id` field.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTaxUid() {
        return OptionalNullable.getFrom(taxUid);
    }

    /**
     * Internal Getter for TaxCatalogObjectId.
     * The `catalog_object_id` of the tax that should be blocked. Use this field to block catalog
     * taxes. For ad hoc taxes, use the `tax_uid` field.
     * @return Returns the Internal String
     */
    @JsonGetter("tax_catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTaxCatalogObjectId() {
        return this.taxCatalogObjectId;
    }

    /**
     * Getter for TaxCatalogObjectId.
     * The `catalog_object_id` of the tax that should be blocked. Use this field to block catalog
     * taxes. For ad hoc taxes, use the `tax_uid` field.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTaxCatalogObjectId() {
        return OptionalNullable.getFrom(taxCatalogObjectId);
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
        OrderLineItemPricingBlocklistsBlockedTax other = (OrderLineItemPricingBlocklistsBlockedTax) obj;
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
        Builder builder = new Builder();
        builder.uid = internalGetUid();
        builder.taxUid = internalGetTaxUid();
        builder.taxCatalogObjectId = internalGetTaxCatalogObjectId();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemPricingBlocklistsBlockedTax}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> taxUid;
        private OptionalNullable<String> taxCatalogObjectId;

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Setter for taxUid.
         * @param  taxUid  String value for taxUid.
         * @return Builder
         */
        public Builder taxUid(String taxUid) {
            this.taxUid = OptionalNullable.of(taxUid);
            return this;
        }

        /**
         * UnSetter for taxUid.
         * @return Builder
         */
        public Builder unsetTaxUid() {
            taxUid = null;
            return this;
        }

        /**
         * Setter for taxCatalogObjectId.
         * @param  taxCatalogObjectId  String value for taxCatalogObjectId.
         * @return Builder
         */
        public Builder taxCatalogObjectId(String taxCatalogObjectId) {
            this.taxCatalogObjectId = OptionalNullable.of(taxCatalogObjectId);
            return this;
        }

        /**
         * UnSetter for taxCatalogObjectId.
         * @return Builder
         */
        public Builder unsetTaxCatalogObjectId() {
            taxCatalogObjectId = null;
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
