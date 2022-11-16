
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
 * This is a model class for OrderLineItemPricingBlocklistsBlockedDiscount type.
 */
public class OrderLineItemPricingBlocklistsBlockedDiscount {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> discountUid;
    private final OptionalNullable<String> discountCatalogObjectId;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  discountUid  String value for discountUid.
     * @param  discountCatalogObjectId  String value for discountCatalogObjectId.
     */
    @JsonCreator
    public OrderLineItemPricingBlocklistsBlockedDiscount(
            @JsonProperty("uid") String uid,
            @JsonProperty("discount_uid") String discountUid,
            @JsonProperty("discount_catalog_object_id") String discountCatalogObjectId) {
        this.uid = OptionalNullable.of(uid);
        this.discountUid = OptionalNullable.of(discountUid);
        this.discountCatalogObjectId = OptionalNullable.of(discountCatalogObjectId);
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderLineItemPricingBlocklistsBlockedDiscount(OptionalNullable<String> uid,
            OptionalNullable<String> discountUid,
            OptionalNullable<String> discountCatalogObjectId) {
        this.uid = uid;
        this.discountUid = discountUid;
        this.discountCatalogObjectId = discountCatalogObjectId;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID of the `BlockedDiscount` within the order.
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
     * A unique ID of the `BlockedDiscount` within the order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for DiscountUid.
     * The `uid` of the discount that should be blocked. Use this field to block ad hoc discounts.
     * For catalog discounts, use the `discount_catalog_object_id` field.
     * @return Returns the Internal String
     */
    @JsonGetter("discount_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDiscountUid() {
        return this.discountUid;
    }

    /**
     * Getter for DiscountUid.
     * The `uid` of the discount that should be blocked. Use this field to block ad hoc discounts.
     * For catalog discounts, use the `discount_catalog_object_id` field.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDiscountUid() {
        return OptionalNullable.getFrom(discountUid);
    }

    /**
     * Internal Getter for DiscountCatalogObjectId.
     * The `catalog_object_id` of the discount that should be blocked. Use this field to block
     * catalog discounts. For ad hoc discounts, use the `discount_uid` field.
     * @return Returns the Internal String
     */
    @JsonGetter("discount_catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDiscountCatalogObjectId() {
        return this.discountCatalogObjectId;
    }

    /**
     * Getter for DiscountCatalogObjectId.
     * The `catalog_object_id` of the discount that should be blocked. Use this field to block
     * catalog discounts. For ad hoc discounts, use the `discount_uid` field.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDiscountCatalogObjectId() {
        return OptionalNullable.getFrom(discountCatalogObjectId);
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
        Builder builder = new Builder();
        builder.uid = internalGetUid();
        builder.discountUid = internalGetDiscountUid();
        builder.discountCatalogObjectId = internalGetDiscountCatalogObjectId();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemPricingBlocklistsBlockedDiscount}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> discountUid;
        private OptionalNullable<String> discountCatalogObjectId;



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
         * Setter for discountUid.
         * @param  discountUid  String value for discountUid.
         * @return Builder
         */
        public Builder discountUid(String discountUid) {
            this.discountUid = OptionalNullable.of(discountUid);
            return this;
        }

        /**
         * UnSetter for discountUid.
         * @return Builder
         */
        public Builder unsetDiscountUid() {
            discountUid = null;
            return this;
        }

        /**
         * Setter for discountCatalogObjectId.
         * @param  discountCatalogObjectId  String value for discountCatalogObjectId.
         * @return Builder
         */
        public Builder discountCatalogObjectId(String discountCatalogObjectId) {
            this.discountCatalogObjectId = OptionalNullable.of(discountCatalogObjectId);
            return this;
        }

        /**
         * UnSetter for discountCatalogObjectId.
         * @return Builder
         */
        public Builder unsetDiscountCatalogObjectId() {
            discountCatalogObjectId = null;
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
