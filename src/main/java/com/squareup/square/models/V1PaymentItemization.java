
package com.squareup.square.models;

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
 * This is a model class for V1PaymentItemization type.
 */
public class V1PaymentItemization {
    private final OptionalNullable<String> name;
    private final OptionalNullable<Double> quantity;
    private final String itemizationType;
    private final V1PaymentItemDetail itemDetail;
    private final OptionalNullable<String> notes;
    private final OptionalNullable<String> itemVariationName;
    private final V1Money totalMoney;
    private final V1Money singleQuantityMoney;
    private final V1Money grossSalesMoney;
    private final V1Money discountMoney;
    private final V1Money netSalesMoney;
    private final OptionalNullable<List<V1PaymentTax>> taxes;
    private final OptionalNullable<List<V1PaymentDiscount>> discounts;
    private final OptionalNullable<List<V1PaymentModifier>> modifiers;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  quantity  Double value for quantity.
     * @param  itemizationType  String value for itemizationType.
     * @param  itemDetail  V1PaymentItemDetail value for itemDetail.
     * @param  notes  String value for notes.
     * @param  itemVariationName  String value for itemVariationName.
     * @param  totalMoney  V1Money value for totalMoney.
     * @param  singleQuantityMoney  V1Money value for singleQuantityMoney.
     * @param  grossSalesMoney  V1Money value for grossSalesMoney.
     * @param  discountMoney  V1Money value for discountMoney.
     * @param  netSalesMoney  V1Money value for netSalesMoney.
     * @param  taxes  List of V1PaymentTax value for taxes.
     * @param  discounts  List of V1PaymentDiscount value for discounts.
     * @param  modifiers  List of V1PaymentModifier value for modifiers.
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
        this.name = OptionalNullable.of(name);
        this.quantity = OptionalNullable.of(quantity);
        this.itemizationType = itemizationType;
        this.itemDetail = itemDetail;
        this.notes = OptionalNullable.of(notes);
        this.itemVariationName = OptionalNullable.of(itemVariationName);
        this.totalMoney = totalMoney;
        this.singleQuantityMoney = singleQuantityMoney;
        this.grossSalesMoney = grossSalesMoney;
        this.discountMoney = discountMoney;
        this.netSalesMoney = netSalesMoney;
        this.taxes = OptionalNullable.of(taxes);
        this.discounts = OptionalNullable.of(discounts);
        this.modifiers = OptionalNullable.of(modifiers);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  quantity  Double value for quantity.
     * @param  itemizationType  String value for itemizationType.
     * @param  itemDetail  V1PaymentItemDetail value for itemDetail.
     * @param  notes  String value for notes.
     * @param  itemVariationName  String value for itemVariationName.
     * @param  totalMoney  V1Money value for totalMoney.
     * @param  singleQuantityMoney  V1Money value for singleQuantityMoney.
     * @param  grossSalesMoney  V1Money value for grossSalesMoney.
     * @param  discountMoney  V1Money value for discountMoney.
     * @param  netSalesMoney  V1Money value for netSalesMoney.
     * @param  taxes  List of V1PaymentTax value for taxes.
     * @param  discounts  List of V1PaymentDiscount value for discounts.
     * @param  modifiers  List of V1PaymentModifier value for modifiers.
     */

    protected V1PaymentItemization(OptionalNullable<String> name, OptionalNullable<Double> quantity,
            String itemizationType, V1PaymentItemDetail itemDetail, OptionalNullable<String> notes,
            OptionalNullable<String> itemVariationName, V1Money totalMoney,
            V1Money singleQuantityMoney, V1Money grossSalesMoney, V1Money discountMoney,
            V1Money netSalesMoney, OptionalNullable<List<V1PaymentTax>> taxes,
            OptionalNullable<List<V1PaymentDiscount>> discounts,
            OptionalNullable<List<V1PaymentModifier>> modifiers) {
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
     * Internal Getter for Name.
     * The item's name.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The item's name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Quantity.
     * The quantity of the item purchased. This can be a decimal value.
     * @return Returns the Internal Double
     */
    @JsonGetter("quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Double> internalGetQuantity() {
        return this.quantity;
    }

    /**
     * Getter for Quantity.
     * The quantity of the item purchased. This can be a decimal value.
     * @return Returns the Double
     */
    @JsonIgnore
    public Double getQuantity() {
        return OptionalNullable.getFrom(quantity);
    }

    /**
     * Getter for ItemizationType.
     * @return Returns the String
     */
    @JsonGetter("itemization_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getItemizationType() {
        return itemizationType;
    }

    /**
     * Getter for ItemDetail.
     * V1PaymentItemDetail
     * @return Returns the V1PaymentItemDetail
     */
    @JsonGetter("item_detail")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1PaymentItemDetail getItemDetail() {
        return itemDetail;
    }

    /**
     * Internal Getter for Notes.
     * Notes entered by the merchant about the item at the time of payment, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("notes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNotes() {
        return this.notes;
    }

    /**
     * Getter for Notes.
     * Notes entered by the merchant about the item at the time of payment, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNotes() {
        return OptionalNullable.getFrom(notes);
    }

    /**
     * Internal Getter for ItemVariationName.
     * The name of the item variation purchased, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("item_variation_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetItemVariationName() {
        return this.itemVariationName;
    }

    /**
     * Getter for ItemVariationName.
     * The name of the item variation purchased, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemVariationName() {
        return OptionalNullable.getFrom(itemVariationName);
    }

    /**
     * Getter for TotalMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getTotalMoney() {
        return totalMoney;
    }

    /**
     * Getter for SingleQuantityMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("single_quantity_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getSingleQuantityMoney() {
        return singleQuantityMoney;
    }

    /**
     * Getter for GrossSalesMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("gross_sales_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getGrossSalesMoney() {
        return grossSalesMoney;
    }

    /**
     * Getter for DiscountMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("discount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getDiscountMoney() {
        return discountMoney;
    }

    /**
     * Getter for NetSalesMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("net_sales_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getNetSalesMoney() {
        return netSalesMoney;
    }

    /**
     * Internal Getter for Taxes.
     * All taxes applied to this itemization.
     * @return Returns the Internal List of V1PaymentTax
     */
    @JsonGetter("taxes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentTax>> internalGetTaxes() {
        return this.taxes;
    }

    /**
     * Getter for Taxes.
     * All taxes applied to this itemization.
     * @return Returns the List of V1PaymentTax
     */
    @JsonIgnore
    public List<V1PaymentTax> getTaxes() {
        return OptionalNullable.getFrom(taxes);
    }

    /**
     * Internal Getter for Discounts.
     * All discounts applied to this itemization.
     * @return Returns the Internal List of V1PaymentDiscount
     */
    @JsonGetter("discounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentDiscount>> internalGetDiscounts() {
        return this.discounts;
    }

    /**
     * Getter for Discounts.
     * All discounts applied to this itemization.
     * @return Returns the List of V1PaymentDiscount
     */
    @JsonIgnore
    public List<V1PaymentDiscount> getDiscounts() {
        return OptionalNullable.getFrom(discounts);
    }

    /**
     * Internal Getter for Modifiers.
     * All modifier options applied to this itemization.
     * @return Returns the Internal List of V1PaymentModifier
     */
    @JsonGetter("modifiers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentModifier>> internalGetModifiers() {
        return this.modifiers;
    }

    /**
     * Getter for Modifiers.
     * All modifier options applied to this itemization.
     * @return Returns the List of V1PaymentModifier
     */
    @JsonIgnore
    public List<V1PaymentModifier> getModifiers() {
        return OptionalNullable.getFrom(modifiers);
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
     * Converts this V1PaymentItemization into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PaymentItemization [" + "name=" + name + ", quantity=" + quantity
                + ", itemizationType=" + itemizationType + ", itemDetail=" + itemDetail + ", notes="
                + notes + ", itemVariationName=" + itemVariationName + ", totalMoney=" + totalMoney
                + ", singleQuantityMoney=" + singleQuantityMoney + ", grossSalesMoney="
                + grossSalesMoney + ", discountMoney=" + discountMoney + ", netSalesMoney="
                + netSalesMoney + ", taxes=" + taxes + ", discounts=" + discounts + ", modifiers="
                + modifiers + "]";
    }

    /**
     * Builds a new {@link V1PaymentItemization.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentItemization.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .itemizationType(getItemizationType())
                .itemDetail(getItemDetail())
                .totalMoney(getTotalMoney())
                .singleQuantityMoney(getSingleQuantityMoney())
                .grossSalesMoney(getGrossSalesMoney())
                .discountMoney(getDiscountMoney())
                .netSalesMoney(getNetSalesMoney());
        builder.name = internalGetName();
        builder.quantity = internalGetQuantity();
        builder.notes = internalGetNotes();
        builder.itemVariationName = internalGetItemVariationName();
        builder.taxes = internalGetTaxes();
        builder.discounts = internalGetDiscounts();
        builder.modifiers = internalGetModifiers();
        return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentItemization}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<Double> quantity;
        private String itemizationType;
        private V1PaymentItemDetail itemDetail;
        private OptionalNullable<String> notes;
        private OptionalNullable<String> itemVariationName;
        private V1Money totalMoney;
        private V1Money singleQuantityMoney;
        private V1Money grossSalesMoney;
        private V1Money discountMoney;
        private V1Money netSalesMoney;
        private OptionalNullable<List<V1PaymentTax>> taxes;
        private OptionalNullable<List<V1PaymentDiscount>> discounts;
        private OptionalNullable<List<V1PaymentModifier>> modifiers;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for quantity.
         * @param  quantity  Double value for quantity.
         * @return Builder
         */
        public Builder quantity(Double quantity) {
            this.quantity = OptionalNullable.of(quantity);
            return this;
        }

        /**
         * UnSetter for quantity.
         * @return Builder
         */
        public Builder unsetQuantity() {
            quantity = null;
            return this;
        }

        /**
         * Setter for itemizationType.
         * @param  itemizationType  String value for itemizationType.
         * @return Builder
         */
        public Builder itemizationType(String itemizationType) {
            this.itemizationType = itemizationType;
            return this;
        }

        /**
         * Setter for itemDetail.
         * @param  itemDetail  V1PaymentItemDetail value for itemDetail.
         * @return Builder
         */
        public Builder itemDetail(V1PaymentItemDetail itemDetail) {
            this.itemDetail = itemDetail;
            return this;
        }

        /**
         * Setter for notes.
         * @param  notes  String value for notes.
         * @return Builder
         */
        public Builder notes(String notes) {
            this.notes = OptionalNullable.of(notes);
            return this;
        }

        /**
         * UnSetter for notes.
         * @return Builder
         */
        public Builder unsetNotes() {
            notes = null;
            return this;
        }

        /**
         * Setter for itemVariationName.
         * @param  itemVariationName  String value for itemVariationName.
         * @return Builder
         */
        public Builder itemVariationName(String itemVariationName) {
            this.itemVariationName = OptionalNullable.of(itemVariationName);
            return this;
        }

        /**
         * UnSetter for itemVariationName.
         * @return Builder
         */
        public Builder unsetItemVariationName() {
            itemVariationName = null;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param  totalMoney  V1Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for singleQuantityMoney.
         * @param  singleQuantityMoney  V1Money value for singleQuantityMoney.
         * @return Builder
         */
        public Builder singleQuantityMoney(V1Money singleQuantityMoney) {
            this.singleQuantityMoney = singleQuantityMoney;
            return this;
        }

        /**
         * Setter for grossSalesMoney.
         * @param  grossSalesMoney  V1Money value for grossSalesMoney.
         * @return Builder
         */
        public Builder grossSalesMoney(V1Money grossSalesMoney) {
            this.grossSalesMoney = grossSalesMoney;
            return this;
        }

        /**
         * Setter for discountMoney.
         * @param  discountMoney  V1Money value for discountMoney.
         * @return Builder
         */
        public Builder discountMoney(V1Money discountMoney) {
            this.discountMoney = discountMoney;
            return this;
        }

        /**
         * Setter for netSalesMoney.
         * @param  netSalesMoney  V1Money value for netSalesMoney.
         * @return Builder
         */
        public Builder netSalesMoney(V1Money netSalesMoney) {
            this.netSalesMoney = netSalesMoney;
            return this;
        }

        /**
         * Setter for taxes.
         * @param  taxes  List of V1PaymentTax value for taxes.
         * @return Builder
         */
        public Builder taxes(List<V1PaymentTax> taxes) {
            this.taxes = OptionalNullable.of(taxes);
            return this;
        }

        /**
         * UnSetter for taxes.
         * @return Builder
         */
        public Builder unsetTaxes() {
            taxes = null;
            return this;
        }

        /**
         * Setter for discounts.
         * @param  discounts  List of V1PaymentDiscount value for discounts.
         * @return Builder
         */
        public Builder discounts(List<V1PaymentDiscount> discounts) {
            this.discounts = OptionalNullable.of(discounts);
            return this;
        }

        /**
         * UnSetter for discounts.
         * @return Builder
         */
        public Builder unsetDiscounts() {
            discounts = null;
            return this;
        }

        /**
         * Setter for modifiers.
         * @param  modifiers  List of V1PaymentModifier value for modifiers.
         * @return Builder
         */
        public Builder modifiers(List<V1PaymentModifier> modifiers) {
            this.modifiers = OptionalNullable.of(modifiers);
            return this;
        }

        /**
         * UnSetter for modifiers.
         * @return Builder
         */
        public Builder unsetModifiers() {
            modifiers = null;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentItemization} object using the set fields.
         * @return {@link V1PaymentItemization}
         */
        public V1PaymentItemization build() {
            return new V1PaymentItemization(name, quantity, itemizationType, itemDetail, notes,
                    itemVariationName, totalMoney, singleQuantityMoney, grossSalesMoney,
                    discountMoney, netSalesMoney, taxes, discounts, modifiers);
        }
    }
}
