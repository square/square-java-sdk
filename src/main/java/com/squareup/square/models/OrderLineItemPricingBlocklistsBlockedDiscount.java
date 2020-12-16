
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemPricingBlocklistsBlockedDiscount type.
 */
public class OrderLineItemPricingBlocklistsBlockedDiscount {
    private final String uid;
    private final String discountUid;
    private final String discountCatalogObjectId;

    /**
     * Initialization constructor.
     * @param uid String value for uid.
     * @param discountUid String value for discountUid.
     * @param discountCatalogObjectId String value for discountCatalogObjectId.
     */
    @JsonCreator
    public OrderLineItemPricingBlocklistsBlockedDiscount(
            @JsonProperty("uid") String uid,
            @JsonProperty("discount_uid") String discountUid,
            @JsonProperty("discount_catalog_object_id") String discountCatalogObjectId) {
        this.uid = uid;
        this.discountUid = discountUid;
        this.discountCatalogObjectId = discountCatalogObjectId;
    }

    /**
     * Getter for Uid.
     * Unique ID of the `BlockedDiscount` within the order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for DiscountUid.
     * The `uid` of the discount that should be blocked. Use this field to block ad-hoc discounts.
     * For catalog discounts use the `discount_catalog_object_id` field.
     * @return Returns the String
     */
    @JsonGetter("discount_uid")
    public String getDiscountUid() {
        return this.discountUid;
    }

    /**
     * Getter for DiscountCatalogObjectId.
     * The `catalog_object_id` of the discount that should be blocked. Use this field to block
     * catalog discounts. For ad-hoc discounts use the `discount_uid` field.
     * @return Returns the String
     */
    @JsonGetter("discount_catalog_object_id")
    public String getDiscountCatalogObjectId() {
        return this.discountCatalogObjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, discountUid, discountCatalogObjectId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemPricingBlocklistsBlockedDiscount)) {
            return false;
        }
        OrderLineItemPricingBlocklistsBlockedDiscount other =
                (OrderLineItemPricingBlocklistsBlockedDiscount) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(discountUid, other.discountUid)
            && Objects.equals(discountCatalogObjectId, other.discountCatalogObjectId);
    }

    /**
     * Converts this OrderLineItemPricingBlocklistsBlockedDiscount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemPricingBlocklistsBlockedDiscount [" + "uid=" + uid + ", discountUid="
                + discountUid + ", discountCatalogObjectId=" + discountCatalogObjectId + "]";
    }

    /**
     * Builds a new {@link OrderLineItemPricingBlocklistsBlockedDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemPricingBlocklistsBlockedDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .uid(getUid())
                .discountUid(getDiscountUid())
                .discountCatalogObjectId(getDiscountCatalogObjectId());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemPricingBlocklistsBlockedDiscount}.
     */
    public static class Builder {
        private String uid;
        private String discountUid;
        private String discountCatalogObjectId;



        /**
         * Setter for uid.
         * @param uid String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for discountUid.
         * @param discountUid String value for discountUid.
         * @return Builder
         */
        public Builder discountUid(String discountUid) {
            this.discountUid = discountUid;
            return this;
        }

        /**
         * Setter for discountCatalogObjectId.
         * @param discountCatalogObjectId String value for discountCatalogObjectId.
         * @return Builder
         */
        public Builder discountCatalogObjectId(String discountCatalogObjectId) {
            this.discountCatalogObjectId = discountCatalogObjectId;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemPricingBlocklistsBlockedDiscount} object using the set
         * fields.
         * @return {@link OrderLineItemPricingBlocklistsBlockedDiscount}
         */
        public OrderLineItemPricingBlocklistsBlockedDiscount build() {
            return new OrderLineItemPricingBlocklistsBlockedDiscount(uid, discountUid,
                    discountCatalogObjectId);
        }
    }
}
