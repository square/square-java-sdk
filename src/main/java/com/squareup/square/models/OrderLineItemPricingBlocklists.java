
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemPricingBlocklists type.
 */
public class OrderLineItemPricingBlocklists {
    private final List<OrderLineItemPricingBlocklistsBlockedDiscount> blockedDiscounts;
    private final List<OrderLineItemPricingBlocklistsBlockedTax> blockedTaxes;

    /**
     * Initialization constructor.
     * @param blockedDiscounts List of OrderLineItemPricingBlocklistsBlockedDiscount value for blockedDiscounts.
     * @param blockedTaxes List of OrderLineItemPricingBlocklistsBlockedTax value for blockedTaxes.
     */
    @JsonCreator
    public OrderLineItemPricingBlocklists(
            @JsonProperty("blocked_discounts") List<OrderLineItemPricingBlocklistsBlockedDiscount> blockedDiscounts,
            @JsonProperty("blocked_taxes") List<OrderLineItemPricingBlocklistsBlockedTax> blockedTaxes) {
        this.blockedDiscounts = blockedDiscounts;
        this.blockedTaxes = blockedTaxes;
    }

    /**
     * Getter for BlockedDiscounts.
     * A list of discounts blocked from applying to the line item. Discounts can be blocked by the
     * `discount_uid` (for ad-hoc discounts) or the `discount_catalog_object_id` (for catalog
     * discounts).
     * @return Returns the List of OrderLineItemPricingBlocklistsBlockedDiscount
     */
    @JsonGetter("blocked_discounts")
    public List<OrderLineItemPricingBlocklistsBlockedDiscount> getBlockedDiscounts() {
        return this.blockedDiscounts;
    }

    /**
     * Getter for BlockedTaxes.
     * A list of taxes blocked from applying to the line item. Taxes can be blocked by the `tax_uid`
     * (for ad-hoc taxes) or the `tax_catalog_object_id` (for catalog taxes).
     * @return Returns the List of OrderLineItemPricingBlocklistsBlockedTax
     */
    @JsonGetter("blocked_taxes")
    public List<OrderLineItemPricingBlocklistsBlockedTax> getBlockedTaxes() {
        return this.blockedTaxes;
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
        return "OrderLineItemPricingBlocklists [" + "blockedDiscounts=" + blockedDiscounts
                + ", blockedTaxes=" + blockedTaxes + "]";
    }

    /**
     * Builds a new {@link OrderLineItemPricingBlocklists.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemPricingBlocklists.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .blockedDiscounts(getBlockedDiscounts())
                .blockedTaxes(getBlockedTaxes());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemPricingBlocklists}.
     */
    public static class Builder {
        private List<OrderLineItemPricingBlocklistsBlockedDiscount> blockedDiscounts;
        private List<OrderLineItemPricingBlocklistsBlockedTax> blockedTaxes;



        /**
         * Setter for blockedDiscounts.
         * @param blockedDiscounts List of OrderLineItemPricingBlocklistsBlockedDiscount value for blockedDiscounts.
         * @return Builder
         */
        public Builder blockedDiscounts(List<OrderLineItemPricingBlocklistsBlockedDiscount> blockedDiscounts) {
            this.blockedDiscounts = blockedDiscounts;
            return this;
        }

        /**
         * Setter for blockedTaxes.
         * @param blockedTaxes List of OrderLineItemPricingBlocklistsBlockedTax value for blockedTaxes.
         * @return Builder
         */
        public Builder blockedTaxes(List<OrderLineItemPricingBlocklistsBlockedTax> blockedTaxes) {
            this.blockedTaxes = blockedTaxes;
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
