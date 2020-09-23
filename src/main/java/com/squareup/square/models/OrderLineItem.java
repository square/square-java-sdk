package com.squareup.square.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderLineItem type.
 */
public class OrderLineItem {

    /**
     * Initialization constructor.
     * @param quantity
     * @param uid
     * @param name
     * @param quantityUnit
     * @param note
     * @param catalogObjectId
     * @param variationName
     * @param metadata
     * @param modifiers
     * @param appliedTaxes
     * @param appliedDiscounts
     * @param basePriceMoney
     * @param variationTotalPriceMoney
     * @param grossSalesMoney
     * @param totalTaxMoney
     * @param totalDiscountMoney
     * @param totalMoney
     */
    @JsonCreator
    public OrderLineItem(
            @JsonProperty("quantity") String quantity,
            @JsonProperty("uid") String uid,
            @JsonProperty("name") String name,
            @JsonProperty("quantity_unit") OrderQuantityUnit quantityUnit,
            @JsonProperty("note") String note,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("variation_name") String variationName,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("modifiers") List<OrderLineItemModifier> modifiers,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes,
            @JsonProperty("applied_discounts") List<OrderLineItemAppliedDiscount> appliedDiscounts,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("variation_total_price_money") Money variationTotalPriceMoney,
            @JsonProperty("gross_sales_money") Money grossSalesMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("total_discount_money") Money totalDiscountMoney,
            @JsonProperty("total_money") Money totalMoney) {
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.note = note;
        this.catalogObjectId = catalogObjectId;
        this.variationName = variationName;
        this.metadata = metadata;
        this.modifiers = modifiers;
        this.appliedTaxes = appliedTaxes;
        this.appliedDiscounts = appliedDiscounts;
        this.basePriceMoney = basePriceMoney;
        this.variationTotalPriceMoney = variationTotalPriceMoney;
        this.grossSalesMoney = grossSalesMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalMoney = totalMoney;
    }

    private final String uid;
    private final String name;
    private final String quantity;
    private final OrderQuantityUnit quantityUnit;
    private final String note;
    private final String catalogObjectId;
    private final String variationName;
    private final Map<String, String> metadata;
    private final List<OrderLineItemModifier> modifiers;
    private final List<OrderLineItemAppliedTax> appliedTaxes;
    private final List<OrderLineItemAppliedDiscount> appliedDiscounts;
    private final Money basePriceMoney;
    private final Money variationTotalPriceMoney;
    private final Money grossSalesMoney;
    private final Money totalTaxMoney;
    private final Money totalDiscountMoney;
    private final Money totalMoney;
    /**
     * Getter for Uid.
     * Unique ID that identifies the line item only within this order.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for Name.
     * The name of the line item.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Quantity.
     * The quantity purchased, formatted as a decimal number.
     * For example: `"3"`.
     * Line items with a quantity of `"0"` will be automatically removed
     * upon paying for or otherwise completing the order.
     * Line items with a `quantity_unit` can have non-integer quantities.
     * For example: `"1.70000"`.
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return this.quantity;
    }

    /**
     * Getter for QuantityUnit.
     * Contains the measurement unit for a quantity and a precision which
     * specifies the number of digits after the decimal point for decimal quantities.
     */
    @JsonGetter("quantity_unit")
    public OrderQuantityUnit getQuantityUnit() {
        return this.quantityUnit;
    }

    /**
     * Getter for Note.
     * The note of the line item.
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
    }

    /**
     * Getter for CatalogObjectId.
     * The [CatalogItemVariation](#type-catalogitemvariation) id applied to this line item.
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for VariationName.
     * The name of the variation applied to this line item.
     */
    @JsonGetter("variation_name")
    public String getVariationName() {
        return this.variationName;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this line item. Metadata fields are intended
     * to store descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns it
     * in relevant API calls. Do not use metadata to store any sensitive information (personally
     * identifiable information, card details, etc.).
     * Keys written by applications must be 60 characters or less and must be in the character set
     * `[a-zA-Z0-9_-]`. Entries may also include metadata generated by Square. These keys are prefixed
     * with a namespace, separated from the key with a ':' character.
     * Values have a max length of 255 characters.
     * An application may have up to 10 entries per metadata field.
     * Entries written by applications are private and can only be read or modified by the same
     * application.
     * See [Metadata](https://developer.squareup.com/docs/build-basics/metadata) for more information.
     */
    @JsonGetter("metadata")
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    /**
     * Getter for Modifiers.
     * The [CatalogModifier](#type-catalogmodifier)s applied to this line item.
     */
    @JsonGetter("modifiers")
    public List<OrderLineItemModifier> getModifiers() {
        return this.modifiers;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to taxes applied to this line item. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a
     * top-level `OrderLineItemTax` applied to the line item. On reads, the
     * amount applied is populated.
     * An `OrderLineItemAppliedTax` will be automatically created on every line
     * item for all `ORDER` scoped taxes added to the order. `OrderLineItemAppliedTax`
     * records for `LINE_ITEM` scoped taxes must be added in requests for the tax
     * to apply to any line items.
     * To change the amount of a tax, modify the referenced top-level tax.
     */
    @JsonGetter("applied_taxes")
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return this.appliedTaxes;
    }

    /**
     * Getter for AppliedDiscounts.
     * The list of references to discounts applied to this line item. Each
     * `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a top-level
     * `OrderLineItemDiscounts` applied to the line item. On reads, the amount
     * applied is populated.
     * An `OrderLineItemAppliedDiscount` will be automatically created on every line item for all
     * `ORDER` scoped discounts that are added to the order. `OrderLineItemAppliedDiscount` records
     * for `LINE_ITEM` scoped discounts must be added in requests for the discount to apply to any
     * line items.
     * To change the amount of a discount, modify the referenced top-level discount.
     */
    @JsonGetter("applied_discounts")
    public List<OrderLineItemAppliedDiscount> getAppliedDiscounts() {
        return this.appliedDiscounts;
    }

    /**
     * Getter for BasePriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("base_price_money")
    public Money getBasePriceMoney() {
        return this.basePriceMoney;
    }

    /**
     * Getter for VariationTotalPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("variation_total_price_money")
    public Money getVariationTotalPriceMoney() {
        return this.variationTotalPriceMoney;
    }

    /**
     * Getter for GrossSalesMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("gross_sales_money")
    public Money getGrossSalesMoney() {
        return this.grossSalesMoney;
    }

    /**
     * Getter for TotalTaxMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_tax_money")
    public Money getTotalTaxMoney() {
        return this.totalTaxMoney;
    }

    /**
     * Getter for TotalDiscountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_discount_money")
    public Money getTotalDiscountMoney() {
        return this.totalDiscountMoney;
    }

    /**
     * Getter for TotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_money")
    public Money getTotalMoney() {
        return this.totalMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, name, quantity, quantityUnit, note, catalogObjectId, variationName,
            metadata, modifiers, appliedTaxes, appliedDiscounts, basePriceMoney,
            variationTotalPriceMoney, grossSalesMoney, totalTaxMoney, totalDiscountMoney, totalMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderLineItem)) {
            return false;
        }
        OrderLineItem orderLineItem = (OrderLineItem) obj;
        return Objects.equals(uid, orderLineItem.uid) &&
            Objects.equals(name, orderLineItem.name) &&
            Objects.equals(quantity, orderLineItem.quantity) &&
            Objects.equals(quantityUnit, orderLineItem.quantityUnit) &&
            Objects.equals(note, orderLineItem.note) &&
            Objects.equals(catalogObjectId, orderLineItem.catalogObjectId) &&
            Objects.equals(variationName, orderLineItem.variationName) &&
            Objects.equals(metadata, orderLineItem.metadata) &&
            Objects.equals(modifiers, orderLineItem.modifiers) &&
            Objects.equals(appliedTaxes, orderLineItem.appliedTaxes) &&
            Objects.equals(appliedDiscounts, orderLineItem.appliedDiscounts) &&
            Objects.equals(basePriceMoney, orderLineItem.basePriceMoney) &&
            Objects.equals(variationTotalPriceMoney, orderLineItem.variationTotalPriceMoney) &&
            Objects.equals(grossSalesMoney, orderLineItem.grossSalesMoney) &&
            Objects.equals(totalTaxMoney, orderLineItem.totalTaxMoney) &&
            Objects.equals(totalDiscountMoney, orderLineItem.totalDiscountMoney) &&
            Objects.equals(totalMoney, orderLineItem.totalMoney);
    }

    /**
     * Builds a new {@link OrderLineItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(quantity)
            .uid(getUid())
            .name(getName())
            .quantityUnit(getQuantityUnit())
            .note(getNote())
            .catalogObjectId(getCatalogObjectId())
            .variationName(getVariationName())
            .metadata(getMetadata())
            .modifiers(getModifiers())
            .appliedTaxes(getAppliedTaxes())
            .appliedDiscounts(getAppliedDiscounts())
            .basePriceMoney(getBasePriceMoney())
            .variationTotalPriceMoney(getVariationTotalPriceMoney())
            .grossSalesMoney(getGrossSalesMoney())
            .totalTaxMoney(getTotalTaxMoney())
            .totalDiscountMoney(getTotalDiscountMoney())
            .totalMoney(getTotalMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItem}
     */
    public static class Builder {
        private String quantity;
        private String uid;
        private String name;
        private OrderQuantityUnit quantityUnit;
        private String note;
        private String catalogObjectId;
        private String variationName;
        private Map<String, String> metadata;
        private List<OrderLineItemModifier> modifiers;
        private List<OrderLineItemAppliedTax> appliedTaxes;
        private List<OrderLineItemAppliedDiscount> appliedDiscounts;
        private Money basePriceMoney;
        private Money variationTotalPriceMoney;
        private Money grossSalesMoney;
        private Money totalTaxMoney;
        private Money totalDiscountMoney;
        private Money totalMoney;

        /**
         * Initialization constructor
         */
        public Builder(String quantity) {
            this.quantity = quantity;
        }

        /**
         * Setter for quantity
         * @param quantity
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }
        /**
         * Setter for uid
         * @param uid
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for quantityUnit
         * @param quantityUnit
         * @return Builder
         */
        public Builder quantityUnit(OrderQuantityUnit quantityUnit) {
            this.quantityUnit = quantityUnit;
            return this;
        }
        /**
         * Setter for note
         * @param note
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }
        /**
         * Setter for catalogObjectId
         * @param catalogObjectId
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }
        /**
         * Setter for variationName
         * @param variationName
         * @return Builder
         */
        public Builder variationName(String variationName) {
            this.variationName = variationName;
            return this;
        }
        /**
         * Setter for metadata
         * @param metadata
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        /**
         * Setter for modifiers
         * @param modifiers
         * @return Builder
         */
        public Builder modifiers(List<OrderLineItemModifier> modifiers) {
            this.modifiers = modifiers;
            return this;
        }
        /**
         * Setter for appliedTaxes
         * @param appliedTaxes
         * @return Builder
         */
        public Builder appliedTaxes(List<OrderLineItemAppliedTax> appliedTaxes) {
            this.appliedTaxes = appliedTaxes;
            return this;
        }
        /**
         * Setter for appliedDiscounts
         * @param appliedDiscounts
         * @return Builder
         */
        public Builder appliedDiscounts(List<OrderLineItemAppliedDiscount> appliedDiscounts) {
            this.appliedDiscounts = appliedDiscounts;
            return this;
        }
        /**
         * Setter for basePriceMoney
         * @param basePriceMoney
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }
        /**
         * Setter for variationTotalPriceMoney
         * @param variationTotalPriceMoney
         * @return Builder
         */
        public Builder variationTotalPriceMoney(Money variationTotalPriceMoney) {
            this.variationTotalPriceMoney = variationTotalPriceMoney;
            return this;
        }
        /**
         * Setter for grossSalesMoney
         * @param grossSalesMoney
         * @return Builder
         */
        public Builder grossSalesMoney(Money grossSalesMoney) {
            this.grossSalesMoney = grossSalesMoney;
            return this;
        }
        /**
         * Setter for totalTaxMoney
         * @param totalTaxMoney
         * @return Builder
         */
        public Builder totalTaxMoney(Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }
        /**
         * Setter for totalDiscountMoney
         * @param totalDiscountMoney
         * @return Builder
         */
        public Builder totalDiscountMoney(Money totalDiscountMoney) {
            this.totalDiscountMoney = totalDiscountMoney;
            return this;
        }
        /**
         * Setter for totalMoney
         * @param totalMoney
         * @return Builder
         */
        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItem} object using the set fields.
         * @return {@link OrderLineItem}
         */
        public OrderLineItem build() {
            return new OrderLineItem(quantity,
                uid,
                name,
                quantityUnit,
                note,
                catalogObjectId,
                variationName,
                metadata,
                modifiers,
                appliedTaxes,
                appliedDiscounts,
                basePriceMoney,
                variationTotalPriceMoney,
                grossSalesMoney,
                totalTaxMoney,
                totalDiscountMoney,
                totalMoney);
        }
    }
}
