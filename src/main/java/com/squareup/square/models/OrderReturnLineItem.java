
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for OrderReturnLineItem type.
 */
public class OrderReturnLineItem {
    private final String uid;
    private final String sourceLineItemUid;
    private final String name;
    private final String quantity;
    private final OrderQuantityUnit quantityUnit;
    private final String note;
    private final String catalogObjectId;
    private final String variationName;
    private final List<OrderReturnLineItemModifier> returnModifiers;
    private final List<OrderLineItemAppliedTax> appliedTaxes;
    private final List<OrderLineItemAppliedDiscount> appliedDiscounts;
    private final Money basePriceMoney;
    private final Money variationTotalPriceMoney;
    private final Money grossReturnMoney;
    private final Money totalTaxMoney;
    private final Money totalDiscountMoney;
    private final Money totalMoney;

    /**
     * Initialization constructor.
     * @param quantity String value for quantity.
     * @param uid String value for uid.
     * @param sourceLineItemUid String value for sourceLineItemUid.
     * @param name String value for name.
     * @param quantityUnit OrderQuantityUnit value for quantityUnit.
     * @param note String value for note.
     * @param catalogObjectId String value for catalogObjectId.
     * @param variationName String value for variationName.
     * @param returnModifiers List of OrderReturnLineItemModifier value for returnModifiers.
     * @param appliedTaxes List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param appliedDiscounts List of OrderLineItemAppliedDiscount value for appliedDiscounts.
     * @param basePriceMoney Money value for basePriceMoney.
     * @param variationTotalPriceMoney Money value for variationTotalPriceMoney.
     * @param grossReturnMoney Money value for grossReturnMoney.
     * @param totalTaxMoney Money value for totalTaxMoney.
     * @param totalDiscountMoney Money value for totalDiscountMoney.
     * @param totalMoney Money value for totalMoney.
     */
    @JsonCreator
    public OrderReturnLineItem(
            @JsonProperty("quantity") String quantity,
            @JsonProperty("uid") String uid,
            @JsonProperty("source_line_item_uid") String sourceLineItemUid,
            @JsonProperty("name") String name,
            @JsonProperty("quantity_unit") OrderQuantityUnit quantityUnit,
            @JsonProperty("note") String note,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("variation_name") String variationName,
            @JsonProperty("return_modifiers") List<OrderReturnLineItemModifier> returnModifiers,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes,
            @JsonProperty("applied_discounts") List<OrderLineItemAppliedDiscount> appliedDiscounts,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("variation_total_price_money") Money variationTotalPriceMoney,
            @JsonProperty("gross_return_money") Money grossReturnMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("total_discount_money") Money totalDiscountMoney,
            @JsonProperty("total_money") Money totalMoney) {
        this.uid = uid;
        this.sourceLineItemUid = sourceLineItemUid;
        this.name = name;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.note = note;
        this.catalogObjectId = catalogObjectId;
        this.variationName = variationName;
        this.returnModifiers = returnModifiers;
        this.appliedTaxes = appliedTaxes;
        this.appliedDiscounts = appliedDiscounts;
        this.basePriceMoney = basePriceMoney;
        this.variationTotalPriceMoney = variationTotalPriceMoney;
        this.grossReturnMoney = grossReturnMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalMoney = totalMoney;
    }

    /**
     * Getter for Uid.
     * Unique identifier for this return line item entry.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for SourceLineItemUid.
     * `uid` of the LineItem in the original sale Order.
     * @return Returns the String
     */
    @JsonGetter("source_line_item_uid")
    public String getSourceLineItemUid() {
        return this.sourceLineItemUid;
    }

    /**
     * Getter for Name.
     * The name of the line item.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Quantity.
     * The quantity returned, formatted as a decimal number. For example: `"3"`. Line items with a
     * `quantity_unit` can have non-integer quantities. For example: `"1.70000"`.
     * @return Returns the String
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return this.quantity;
    }

    /**
     * Getter for QuantityUnit.
     * Contains the measurement unit for a quantity and a precision which specifies the number of
     * digits after the decimal point for decimal quantities.
     * @return Returns the OrderQuantityUnit
     */
    @JsonGetter("quantity_unit")
    public OrderQuantityUnit getQuantityUnit() {
        return this.quantityUnit;
    }

    /**
     * Getter for Note.
     * The note of the returned line item.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
    }

    /**
     * Getter for CatalogObjectId.
     * The [CatalogItemVariation](#type-catalogitemvariation) id applied to this returned line item.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for VariationName.
     * The name of the variation applied to this returned line item.
     * @return Returns the String
     */
    @JsonGetter("variation_name")
    public String getVariationName() {
        return this.variationName;
    }

    /**
     * Getter for ReturnModifiers.
     * The [CatalogModifier](#type-catalogmodifier)s applied to this line item.
     * @return Returns the List of OrderReturnLineItemModifier
     */
    @JsonGetter("return_modifiers")
    public List<OrderReturnLineItemModifier> getReturnModifiers() {
        return this.returnModifiers;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to `OrderReturnTax` entities applied to the returned line item. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a top-level
     * `OrderReturnTax` applied to the returned line item. On reads, the amount applied is
     * populated.
     * @return Returns the List of OrderLineItemAppliedTax
     */
    @JsonGetter("applied_taxes")
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return this.appliedTaxes;
    }

    /**
     * Getter for AppliedDiscounts.
     * The list of references to `OrderReturnDiscount` entities applied to the returned line item.
     * Each `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a
     * top-level `OrderReturnDiscount` applied to the returned line item. On reads, the amount
     * applied is populated.
     * @return Returns the List of OrderLineItemAppliedDiscount
     */
    @JsonGetter("applied_discounts")
    public List<OrderLineItemAppliedDiscount> getAppliedDiscounts() {
        return this.appliedDiscounts;
    }

    /**
     * Getter for BasePriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("base_price_money")
    public Money getBasePriceMoney() {
        return this.basePriceMoney;
    }

    /**
     * Getter for VariationTotalPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("variation_total_price_money")
    public Money getVariationTotalPriceMoney() {
        return this.variationTotalPriceMoney;
    }

    /**
     * Getter for GrossReturnMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("gross_return_money")
    public Money getGrossReturnMoney() {
        return this.grossReturnMoney;
    }

    /**
     * Getter for TotalTaxMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_tax_money")
    public Money getTotalTaxMoney() {
        return this.totalTaxMoney;
    }

    /**
     * Getter for TotalDiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_discount_money")
    public Money getTotalDiscountMoney() {
        return this.totalDiscountMoney;
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_money")
    public Money getTotalMoney() {
        return this.totalMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceLineItemUid, name, quantity, quantityUnit, note,
                catalogObjectId, variationName, returnModifiers, appliedTaxes, appliedDiscounts,
                basePriceMoney, variationTotalPriceMoney, grossReturnMoney, totalTaxMoney,
                totalDiscountMoney, totalMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderReturnLineItem)) {
            return false;
        }
        OrderReturnLineItem other = (OrderReturnLineItem) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(sourceLineItemUid, other.sourceLineItemUid)
            && Objects.equals(name, other.name)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(quantityUnit, other.quantityUnit)
            && Objects.equals(note, other.note)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(variationName, other.variationName)
            && Objects.equals(returnModifiers, other.returnModifiers)
            && Objects.equals(appliedTaxes, other.appliedTaxes)
            && Objects.equals(appliedDiscounts, other.appliedDiscounts)
            && Objects.equals(basePriceMoney, other.basePriceMoney)
            && Objects.equals(variationTotalPriceMoney, other.variationTotalPriceMoney)
            && Objects.equals(grossReturnMoney, other.grossReturnMoney)
            && Objects.equals(totalTaxMoney, other.totalTaxMoney)
            && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
            && Objects.equals(totalMoney, other.totalMoney);
    }

    /**
     * Converts this OrderReturnLineItem into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderReturnLineItem [" + "quantity=" + quantity + ", uid=" + uid
                + ", sourceLineItemUid=" + sourceLineItemUid + ", name=" + name + ", quantityUnit="
                + quantityUnit + ", note=" + note + ", catalogObjectId=" + catalogObjectId
                + ", variationName=" + variationName + ", returnModifiers=" + returnModifiers
                + ", appliedTaxes=" + appliedTaxes + ", appliedDiscounts=" + appliedDiscounts
                + ", basePriceMoney=" + basePriceMoney + ", variationTotalPriceMoney="
                + variationTotalPriceMoney + ", grossReturnMoney=" + grossReturnMoney
                + ", totalTaxMoney=" + totalTaxMoney + ", totalDiscountMoney=" + totalDiscountMoney
                + ", totalMoney=" + totalMoney + "]";
    }

    /**
     * Builds a new {@link OrderReturnLineItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnLineItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(quantity)
                .uid(getUid())
                .sourceLineItemUid(getSourceLineItemUid())
                .name(getName())
                .quantityUnit(getQuantityUnit())
                .note(getNote())
                .catalogObjectId(getCatalogObjectId())
                .variationName(getVariationName())
                .returnModifiers(getReturnModifiers())
                .appliedTaxes(getAppliedTaxes())
                .appliedDiscounts(getAppliedDiscounts())
                .basePriceMoney(getBasePriceMoney())
                .variationTotalPriceMoney(getVariationTotalPriceMoney())
                .grossReturnMoney(getGrossReturnMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .totalDiscountMoney(getTotalDiscountMoney())
                .totalMoney(getTotalMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnLineItem}.
     */
    public static class Builder {
        private String quantity;
        private String uid;
        private String sourceLineItemUid;
        private String name;
        private OrderQuantityUnit quantityUnit;
        private String note;
        private String catalogObjectId;
        private String variationName;
        private List<OrderReturnLineItemModifier> returnModifiers;
        private List<OrderLineItemAppliedTax> appliedTaxes;
        private List<OrderLineItemAppliedDiscount> appliedDiscounts;
        private Money basePriceMoney;
        private Money variationTotalPriceMoney;
        private Money grossReturnMoney;
        private Money totalTaxMoney;
        private Money totalDiscountMoney;
        private Money totalMoney;

        /**
         * Initialization constructor.
         * @param quantity String value for quantity.
         */
        public Builder(String quantity) {
            this.quantity = quantity;
        }

        /**
         * Setter for quantity.
         * @param quantity String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

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
         * Setter for sourceLineItemUid.
         * @param sourceLineItemUid String value for sourceLineItemUid.
         * @return Builder
         */
        public Builder sourceLineItemUid(String sourceLineItemUid) {
            this.sourceLineItemUid = sourceLineItemUid;
            return this;
        }

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
         * Setter for quantityUnit.
         * @param quantityUnit OrderQuantityUnit value for quantityUnit.
         * @return Builder
         */
        public Builder quantityUnit(OrderQuantityUnit quantityUnit) {
            this.quantityUnit = quantityUnit;
            return this;
        }

        /**
         * Setter for note.
         * @param note String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param catalogObjectId String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for variationName.
         * @param variationName String value for variationName.
         * @return Builder
         */
        public Builder variationName(String variationName) {
            this.variationName = variationName;
            return this;
        }

        /**
         * Setter for returnModifiers.
         * @param returnModifiers List of OrderReturnLineItemModifier value for returnModifiers.
         * @return Builder
         */
        public Builder returnModifiers(List<OrderReturnLineItemModifier> returnModifiers) {
            this.returnModifiers = returnModifiers;
            return this;
        }

        /**
         * Setter for appliedTaxes.
         * @param appliedTaxes List of OrderLineItemAppliedTax value for appliedTaxes.
         * @return Builder
         */
        public Builder appliedTaxes(List<OrderLineItemAppliedTax> appliedTaxes) {
            this.appliedTaxes = appliedTaxes;
            return this;
        }

        /**
         * Setter for appliedDiscounts.
         * @param appliedDiscounts List of OrderLineItemAppliedDiscount value for appliedDiscounts.
         * @return Builder
         */
        public Builder appliedDiscounts(List<OrderLineItemAppliedDiscount> appliedDiscounts) {
            this.appliedDiscounts = appliedDiscounts;
            return this;
        }

        /**
         * Setter for basePriceMoney.
         * @param basePriceMoney Money value for basePriceMoney.
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }

        /**
         * Setter for variationTotalPriceMoney.
         * @param variationTotalPriceMoney Money value for variationTotalPriceMoney.
         * @return Builder
         */
        public Builder variationTotalPriceMoney(Money variationTotalPriceMoney) {
            this.variationTotalPriceMoney = variationTotalPriceMoney;
            return this;
        }

        /**
         * Setter for grossReturnMoney.
         * @param grossReturnMoney Money value for grossReturnMoney.
         * @return Builder
         */
        public Builder grossReturnMoney(Money grossReturnMoney) {
            this.grossReturnMoney = grossReturnMoney;
            return this;
        }

        /**
         * Setter for totalTaxMoney.
         * @param totalTaxMoney Money value for totalTaxMoney.
         * @return Builder
         */
        public Builder totalTaxMoney(Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }

        /**
         * Setter for totalDiscountMoney.
         * @param totalDiscountMoney Money value for totalDiscountMoney.
         * @return Builder
         */
        public Builder totalDiscountMoney(Money totalDiscountMoney) {
            this.totalDiscountMoney = totalDiscountMoney;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param totalMoney Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnLineItem} object using the set fields.
         * @return {@link OrderReturnLineItem}
         */
        public OrderReturnLineItem build() {
            return new OrderReturnLineItem(quantity, uid, sourceLineItemUid, name, quantityUnit,
                    note, catalogObjectId, variationName, returnModifiers, appliedTaxes,
                    appliedDiscounts, basePriceMoney, variationTotalPriceMoney, grossReturnMoney,
                    totalTaxMoney, totalDiscountMoney, totalMoney);
        }
    }
}
