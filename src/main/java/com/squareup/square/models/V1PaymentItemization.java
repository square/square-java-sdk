package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1PaymentItemization {

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

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, itemizationType, itemDetail, notes, itemVariationName, totalMoney, singleQuantityMoney, grossSalesMoney, discountMoney, netSalesMoney, taxes, discounts, modifiers);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1PaymentItemization)) {
            return false;
        }
        V1PaymentItemization v1PaymentItemization = (V1PaymentItemization) o;
        return Objects.equals(name, v1PaymentItemization.name) &&
            Objects.equals(quantity, v1PaymentItemization.quantity) &&
            Objects.equals(itemizationType, v1PaymentItemization.itemizationType) &&
            Objects.equals(itemDetail, v1PaymentItemization.itemDetail) &&
            Objects.equals(notes, v1PaymentItemization.notes) &&
            Objects.equals(itemVariationName, v1PaymentItemization.itemVariationName) &&
            Objects.equals(totalMoney, v1PaymentItemization.totalMoney) &&
            Objects.equals(singleQuantityMoney, v1PaymentItemization.singleQuantityMoney) &&
            Objects.equals(grossSalesMoney, v1PaymentItemization.grossSalesMoney) &&
            Objects.equals(discountMoney, v1PaymentItemization.discountMoney) &&
            Objects.equals(netSalesMoney, v1PaymentItemization.netSalesMoney) &&
            Objects.equals(taxes, v1PaymentItemization.taxes) &&
            Objects.equals(discounts, v1PaymentItemization.discounts) &&
            Objects.equals(modifiers, v1PaymentItemization.modifiers);
    }

    /**
     * Getter for Name.
     * The item's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Quantity.
     * The quantity of the item purchased. This can be a decimal value.
     */
    @JsonGetter("quantity")
    public Double getQuantity() { 
        return this.quantity;
    }

    /**
     * Getter for ItemizationType.
     */
    @JsonGetter("itemization_type")
    public String getItemizationType() { 
        return this.itemizationType;
    }

    /**
     * Getter for ItemDetail.
     * V1PaymentItemDetail
     */
    @JsonGetter("item_detail")
    public V1PaymentItemDetail getItemDetail() { 
        return this.itemDetail;
    }

    /**
     * Getter for Notes.
     * Notes entered by the merchant about the item at the time of payment, if any.
     */
    @JsonGetter("notes")
    public String getNotes() { 
        return this.notes;
    }

    /**
     * Getter for ItemVariationName.
     * The name of the item variation purchased, if any.
     */
    @JsonGetter("item_variation_name")
    public String getItemVariationName() { 
        return this.itemVariationName;
    }

    /**
     * Getter for TotalMoney.
     */
    @JsonGetter("total_money")
    public V1Money getTotalMoney() { 
        return this.totalMoney;
    }

    /**
     * Getter for SingleQuantityMoney.
     */
    @JsonGetter("single_quantity_money")
    public V1Money getSingleQuantityMoney() { 
        return this.singleQuantityMoney;
    }

    /**
     * Getter for GrossSalesMoney.
     */
    @JsonGetter("gross_sales_money")
    public V1Money getGrossSalesMoney() { 
        return this.grossSalesMoney;
    }

    /**
     * Getter for DiscountMoney.
     */
    @JsonGetter("discount_money")
    public V1Money getDiscountMoney() { 
        return this.discountMoney;
    }

    /**
     * Getter for NetSalesMoney.
     */
    @JsonGetter("net_sales_money")
    public V1Money getNetSalesMoney() { 
        return this.netSalesMoney;
    }

    /**
     * Getter for Taxes.
     * All taxes applied to this itemization.
     */
    @JsonGetter("taxes")
    public List<V1PaymentTax> getTaxes() { 
        return this.taxes;
    }

    /**
     * Getter for Discounts.
     * All discounts applied to this itemization.
     */
    @JsonGetter("discounts")
    public List<V1PaymentDiscount> getDiscounts() { 
        return this.discounts;
    }

    /**
     * Getter for Modifiers.
     * All modifier options applied to this itemization.
     */
    @JsonGetter("modifiers")
    public List<V1PaymentModifier> getModifiers() { 
        return this.modifiers;
    }

 
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

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder quantity(Double value) {
            quantity = value;
            return this;
        }
        public Builder itemizationType(String value) {
            itemizationType = value;
            return this;
        }
        public Builder itemDetail(V1PaymentItemDetail value) {
            itemDetail = value;
            return this;
        }
        public Builder notes(String value) {
            notes = value;
            return this;
        }
        public Builder itemVariationName(String value) {
            itemVariationName = value;
            return this;
        }
        public Builder totalMoney(V1Money value) {
            totalMoney = value;
            return this;
        }
        public Builder singleQuantityMoney(V1Money value) {
            singleQuantityMoney = value;
            return this;
        }
        public Builder grossSalesMoney(V1Money value) {
            grossSalesMoney = value;
            return this;
        }
        public Builder discountMoney(V1Money value) {
            discountMoney = value;
            return this;
        }
        public Builder netSalesMoney(V1Money value) {
            netSalesMoney = value;
            return this;
        }
        public Builder taxes(List<V1PaymentTax> value) {
            taxes = value;
            return this;
        }
        public Builder discounts(List<V1PaymentDiscount> value) {
            discounts = value;
            return this;
        }
        public Builder modifiers(List<V1PaymentModifier> value) {
            modifiers = value;
            return this;
        }

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
