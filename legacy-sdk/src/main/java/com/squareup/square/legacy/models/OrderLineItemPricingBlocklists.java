package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemPricingBlocklists type.
 */
public class OrderLineItemPricingBlocklists {
    private final OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedDiscount>> blockedDiscounts;
    private final OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedTax>> blockedTaxes;

    /**
     * Initialization constructor.
     * @param  blockedDiscounts  List of OrderLineItemPricingBlocklistsBlockedDiscount value for
     *         blockedDiscounts.
     * @param  blockedTaxes  List of OrderLineItemPricingBlocklistsBlockedTax value for
     *         blockedTaxes.
     */
    @JsonCreator
    public OrderLineItemPricingBlocklists(
            @JsonProperty("blocked_discounts") List<OrderLineItemPricingBlocklistsBlockedDiscount> blockedDiscounts,
            @JsonProperty("blocked_taxes") List<OrderLineItemPricingBlocklistsBlockedTax> blockedTaxes) {
        this.blockedDiscounts = OptionalNullable.of(blockedDiscounts);
        this.blockedTaxes = OptionalNullable.of(blockedTaxes);
    }

    /**
     * Initialization constructor.
     * @param  blockedDiscounts  List of OrderLineItemPricingBlocklistsBlockedDiscount value for
     *         blockedDiscounts.
     * @param  blockedTaxes  List of OrderLineItemPricingBlocklistsBlockedTax value for
     *         blockedTaxes.
     */
    protected OrderLineItemPricingBlocklists(
            OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedDiscount>> blockedDiscounts,
            OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedTax>> blockedTaxes) {
        this.blockedDiscounts = blockedDiscounts;
        this.blockedTaxes = blockedTaxes;
    }

    /**
     * Internal Getter for BlockedDiscounts.
     * A list of discounts blocked from applying to the line item. Discounts can be blocked by the
     * `discount_uid` (for ad hoc discounts) or the `discount_catalog_object_id` (for catalog
     * discounts).
     * @return Returns the Internal List of OrderLineItemPricingBlocklistsBlockedDiscount
     */
    @JsonGetter("blocked_discounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedDiscount>> internalGetBlockedDiscounts() {
        return this.blockedDiscounts;
    }

    /**
     * Getter for BlockedDiscounts.
     * A list of discounts blocked from applying to the line item. Discounts can be blocked by the
     * `discount_uid` (for ad hoc discounts) or the `discount_catalog_object_id` (for catalog
     * discounts).
     * @return Returns the List of OrderLineItemPricingBlocklistsBlockedDiscount
     */
    @JsonIgnore
    public List<OrderLineItemPricingBlocklistsBlockedDiscount> getBlockedDiscounts() {
        return OptionalNullable.getFrom(blockedDiscounts);
    }

    /**
     * Internal Getter for BlockedTaxes.
     * A list of taxes blocked from applying to the line item. Taxes can be blocked by the `tax_uid`
     * (for ad hoc taxes) or the `tax_catalog_object_id` (for catalog taxes).
     * @return Returns the Internal List of OrderLineItemPricingBlocklistsBlockedTax
     */
    @JsonGetter("blocked_taxes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedTax>> internalGetBlockedTaxes() {
        return this.blockedTaxes;
    }

    /**
     * Getter for BlockedTaxes.
     * A list of taxes blocked from applying to the line item. Taxes can be blocked by the `tax_uid`
     * (for ad hoc taxes) or the `tax_catalog_object_id` (for catalog taxes).
     * @return Returns the List of OrderLineItemPricingBlocklistsBlockedTax
     */
    @JsonIgnore
    public List<OrderLineItemPricingBlocklistsBlockedTax> getBlockedTaxes() {
        return OptionalNullable.getFrom(blockedTaxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockedDiscounts, blockedTaxes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemPricingBlocklists)) {
            return false;
        }
        OrderLineItemPricingBlocklists other = (OrderLineItemPricingBlocklists) obj;
        return Objects.equals(blockedDiscounts, other.blockedDiscounts)
                && Objects.equals(blockedTaxes, other.blockedTaxes);
    }

    /**
     * Converts this OrderLineItemPricingBlocklists into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemPricingBlocklists [" + "blockedDiscounts=" + blockedDiscounts + ", blockedTaxes="
                + blockedTaxes + "]";
    }

    /**
     * Builds a new {@link OrderLineItemPricingBlocklists.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemPricingBlocklists.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.blockedDiscounts = internalGetBlockedDiscounts();
        builder.blockedTaxes = internalGetBlockedTaxes();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemPricingBlocklists}.
     */
    public static class Builder {
        private OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedDiscount>> blockedDiscounts;
        private OptionalNullable<List<OrderLineItemPricingBlocklistsBlockedTax>> blockedTaxes;

        /**
         * Setter for blockedDiscounts.
         * @param  blockedDiscounts  List of OrderLineItemPricingBlocklistsBlockedDiscount value for
         *         blockedDiscounts.
         * @return Builder
         */
        public Builder blockedDiscounts(List<OrderLineItemPricingBlocklistsBlockedDiscount> blockedDiscounts) {
            this.blockedDiscounts = OptionalNullable.of(blockedDiscounts);
            return this;
        }

        /**
         * UnSetter for blockedDiscounts.
         * @return Builder
         */
        public Builder unsetBlockedDiscounts() {
            blockedDiscounts = null;
            return this;
        }

        /**
         * Setter for blockedTaxes.
         * @param  blockedTaxes  List of OrderLineItemPricingBlocklistsBlockedTax value for
         *         blockedTaxes.
         * @return Builder
         */
        public Builder blockedTaxes(List<OrderLineItemPricingBlocklistsBlockedTax> blockedTaxes) {
            this.blockedTaxes = OptionalNullable.of(blockedTaxes);
            return this;
        }

        /**
         * UnSetter for blockedTaxes.
         * @return Builder
         */
        public Builder unsetBlockedTaxes() {
            blockedTaxes = null;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemPricingBlocklists} object using the set fields.
         * @return {@link OrderLineItemPricingBlocklists}
         */
        public OrderLineItemPricingBlocklists build() {
            return new OrderLineItemPricingBlocklists(blockedDiscounts, blockedTaxes);
        }
    }
}
