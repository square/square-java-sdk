
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1PaymentItemization type.
 */
public class V1PaymentItemization {
    private final String name;
    private final Double quantity;
    private final String itemizationType;
    private final V1PaymentItemDetail itemDetail;
    private final String notes;
    private final String itemVariationName;
    private final V1Money totalMoney;
    private final V1Money singleQuantityMoney;
    private final V1Money grossSalesMoney;
    private final V1Money discountMoney;
    private final V1Money netSalesMoney;
    private final List<V1PaymentTax> taxes;
    private final List<V1PaymentDiscount> discounts;
    private final List<V1PaymentModifier> modifiers;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param quantity Double value for quantity.
     * @param itemizationType String value for itemizationType.
     * @param itemDetail V1PaymentItemDetail value for itemDetail.
     * @param notes String value for notes.
     * @param itemVariationName String value for itemVariationName.
     * @param totalMoney V1Money value for totalMoney.
     * @param singleQuantityMoney V1Money value for singleQuantityMoney.
     * @param grossSalesMoney V1Money value for grossSalesMoney.
     * @param discountMoney V1Money value for discountMoney.
     * @param netSalesMoney V1Money value for netSalesMoney.
     * @param taxes List of V1PaymentTax value for taxes.
     * @param discounts List of V1PaymentDiscount value for discounts.
     * @param modifiers List of V1PaymentModifier value for modifiers.
     */
    @JsonCreator
    public V1PaymentItemization(
            @JsonProperty("name") String name,
            @JsonProperty("quantity") Double quantity,
            @JsonProperty("itemization_type") String itemizationType,
            @JsonProperty("item_detail") V1PaymentItemDetail itemDetail,
            @JsonProperty("notes") String notes,
            @JsonProperty("item_variation_name") String itemVariationName,
            @JsonProperty("total_money") V1Money totalMoney,
            @JsonProperty("single_quantity_money") V1Money singleQuantityMoney,
            @JsonProperty("gross_sales_money") V1Money grossSalesMoney,
            @JsonProperty("discount_money") V1Money discountMoney,
            @JsonProperty("net_sales_money") V1Money netSalesMoney,
            @JsonProperty("taxes") List<V1PaymentTax> taxes,
            @JsonProperty("discounts") List<V1PaymentDiscount> discounts,
            @JsonProperty("modifiers") List<V1PaymentModifier> modifiers) {
        this.name = name;
        this.quantity = quantity;
        this.itemizationType = itemizationType;
        this.itemDetail = itemDetail;
        this.notes = notes;
        this.itemVariationName = itemVariationName;
        this.totalMoney = totalMoney;
        this.singleQuantityMoney = singleQuantityMoney;
        this.grossSalesMoney = grossSalesMoney;
        this.discountMoney = discountMoney;
        this.netSalesMoney = netSalesMoney;
        this.taxes = taxes;
        this.discounts = discounts;
        this.modifiers = modifiers;
    }

    /**
     * Getter for Name.
     * The item's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Quantity.
     * The quantity of the item purchased. This can be a decimal value.
     * @return Returns the Double
     */
    @JsonGetter("quantity")
    public Double getQuantity() {
        return this.quantity;
    }

    /**
     * Getter for ItemizationType.
     * @return Returns the String
     */
    @JsonGetter("itemization_type")
    public String getItemizationType() {
        return this.itemizationType;
    }

    /**
     * Getter for ItemDetail.
     * V1PaymentItemDetail
     * @return Returns the V1PaymentItemDetail
     */
    @JsonGetter("item_detail")
    public V1PaymentItemDetail getItemDetail() {
        return this.itemDetail;
    }

    /**
     * Getter for Notes.
     * Notes entered by the merchant about the item at the time of payment, if any.
     * @return Returns the String
     */
    @JsonGetter("notes")
    public String getNotes() {
        return this.notes;
    }

    /**
     * Getter for ItemVariationName.
     * The name of the item variation purchased, if any.
     * @return Returns the String
     */
    @JsonGetter("item_variation_name")
    public String getItemVariationName() {
        return this.itemVariationName;
    }

    /**
     * Getter for TotalMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_money")
    public V1Money getTotalMoney() {
        return this.totalMoney;
    }

    /**
     * Getter for SingleQuantityMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("single_quantity_money")
    public V1Money getSingleQuantityMoney() {
        return this.singleQuantityMoney;
    }

    /**
     * Getter for GrossSalesMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("gross_sales_money")
    public V1Money getGrossSalesMoney() {
        return this.grossSalesMoney;
    }

    /**
     * Getter for DiscountMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("discount_money")
    public V1Money getDiscountMoney() {
        return this.discountMoney;
    }

    /**
     * Getter for NetSalesMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("net_sales_money")
    public V1Money getNetSalesMoney() {
        return this.netSalesMoney;
    }

    /**
     * Getter for Taxes.
     * All taxes applied to this itemization.
     * @return Returns the List of V1PaymentTax
     */
    @JsonGetter("taxes")
    public List<V1PaymentTax> getTaxes() {
        return this.taxes;
    }

    /**
     * Getter for Discounts.
     * All discounts applied to this itemization.
     * @return Returns the List of V1PaymentDiscount
     */
    @JsonGetter("discounts")
    public List<V1PaymentDiscount> getDiscounts() {
        return this.discounts;
    }

    /**
     * Getter for Modifiers.
     * All modifier options applied to this itemization.
     * @return Returns the List of V1PaymentModifier
     */
    @JsonGetter("modifiers")
    public List<V1PaymentModifier> getModifiers() {
        return this.modifiers;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, itemizationType, itemDetail, notes, itemVariationName,
                totalMoney, singleQuantityMoney, grossSalesMoney, discountMoney, netSalesMoney,
                taxes, discounts, modifiers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PaymentItemization)) {
            return false;
        }
        V1PaymentItemization other = (V1PaymentItemization) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(itemizationType, other.itemizationType)
            && Objects.equals(itemDetail, other.itemDetail)
            && Objects.equals(notes, other.notes)
            && Objects.equals(itemVariationName, other.itemVariationName)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(singleQuantityMoney, other.singleQuantityMoney)
            && Objects.equals(grossSalesMoney, other.grossSalesMoney)
            && Objects.equals(discountMoney, other.discountMoney)
            && Objects.equals(netSalesMoney, other.netSalesMoney)
            && Objects.equals(taxes, other.taxes)
            && Objects.equals(discounts, other.discounts)
            && Objects.equals(modifiers, other.modifiers);
    }

    /**
     * Builds a new {@link V1PaymentItemization.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentItemization.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .quantity(getQuantity())
            .itemizationType(getItemizationType())
            .itemDetail(getItemDetail())
            .notes(getNotes())
            .itemVariationName(getItemVariationName())
            .totalMoney(getTotalMoney())
            .singleQuantityMoney(getSingleQuantityMoney())
            .grossSalesMoney(getGrossSalesMoney())
            .discountMoney(getDiscountMoney())
            .netSalesMoney(getNetSalesMoney())
            .taxes(getTaxes())
            .discounts(getDiscounts())
            .modifiers(getModifiers());
        return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentItemization}.
     */
    public static class Builder {
        private String name;
        private Double quantity;
        private String itemizationType;
        private V1PaymentItemDetail itemDetail;
        private String notes;
        private String itemVariationName;
        private V1Money totalMoney;
        private V1Money singleQuantityMoney;
        private V1Money grossSalesMoney;
        private V1Money discountMoney;
        private V1Money netSalesMoney;
        private List<V1PaymentTax> taxes;
        private List<V1PaymentDiscount> discounts;
        private List<V1PaymentModifier> modifiers;



        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for quantity.
         * @param quantity Double value for quantity.
         * @return Builder
         */
        public Builder quantity(Double quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Setter for itemizationType.
         * @param itemizationType String value for itemizationType.
         * @return Builder
         */
        public Builder itemizationType(String itemizationType) {
            this.itemizationType = itemizationType;
            return this;
        }

        /**
         * Setter for itemDetail.
         * @param itemDetail V1PaymentItemDetail value for itemDetail.
         * @return Builder
         */
        public Builder itemDetail(V1PaymentItemDetail itemDetail) {
            this.itemDetail = itemDetail;
            return this;
        }

        /**
         * Setter for notes.
         * @param notes String value for notes.
         * @return Builder
         */
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        /**
         * Setter for itemVariationName.
         * @param itemVariationName String value for itemVariationName.
         * @return Builder
         */
        public Builder itemVariationName(String itemVariationName) {
            this.itemVariationName = itemVariationName;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param totalMoney V1Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for singleQuantityMoney.
         * @param singleQuantityMoney V1Money value for singleQuantityMoney.
         * @return Builder
         */
        public Builder singleQuantityMoney(V1Money singleQuantityMoney) {
            this.singleQuantityMoney = singleQuantityMoney;
            return this;
        }

        /**
         * Setter for grossSalesMoney.
         * @param grossSalesMoney V1Money value for grossSalesMoney.
         * @return Builder
         */
        public Builder grossSalesMoney(V1Money grossSalesMoney) {
            this.grossSalesMoney = grossSalesMoney;
            return this;
        }

        /**
         * Setter for discountMoney.
         * @param discountMoney V1Money value for discountMoney.
         * @return Builder
         */
        public Builder discountMoney(V1Money discountMoney) {
            this.discountMoney = discountMoney;
            return this;
        }

        /**
         * Setter for netSalesMoney.
         * @param netSalesMoney V1Money value for netSalesMoney.
         * @return Builder
         */
        public Builder netSalesMoney(V1Money netSalesMoney) {
            this.netSalesMoney = netSalesMoney;
            return this;
        }

        /**
         * Setter for taxes.
         * @param taxes List of V1PaymentTax value for taxes.
         * @return Builder
         */
        public Builder taxes(List<V1PaymentTax> taxes) {
            this.taxes = taxes;
            return this;
        }

        /**
         * Setter for discounts.
         * @param discounts List of V1PaymentDiscount value for discounts.
         * @return Builder
         */
        public Builder discounts(List<V1PaymentDiscount> discounts) {
            this.discounts = discounts;
            return this;
        }

        /**
         * Setter for modifiers.
         * @param modifiers List of V1PaymentModifier value for modifiers.
         * @return Builder
         */
        public Builder modifiers(List<V1PaymentModifier> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentItemization} object using the set fields.
         * @return {@link V1PaymentItemization}
         */
        public V1PaymentItemization build() {
            return new V1PaymentItemization(name,
                quantity,
                itemizationType,
                itemDetail,
                notes,
                itemVariationName,
                totalMoney,
                singleQuantityMoney,
                grossSalesMoney,
                discountMoney,
                netSalesMoney,
                taxes,
                discounts,
                modifiers);
        }
    }
}
