
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * This is a model class for OrderLineItem type.
 */
public class OrderLineItem {
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
     * Initialization constructor.
     * @param quantity String value for quantity.
     * @param uid String value for uid.
     * @param name String value for name.
     * @param quantityUnit OrderQuantityUnit value for quantityUnit.
     * @param note String value for note.
     * @param catalogObjectId String value for catalogObjectId.
     * @param variationName String value for variationName.
     * @param metadata Map of String, value for metadata.
     * @param modifiers List of OrderLineItemModifier value for modifiers.
     * @param appliedTaxes List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param appliedDiscounts List of OrderLineItemAppliedDiscount value for appliedDiscounts.
     * @param basePriceMoney Money value for basePriceMoney.
     * @param variationTotalPriceMoney Money value for variationTotalPriceMoney.
     * @param grossSalesMoney Money value for grossSalesMoney.
     * @param totalTaxMoney Money value for totalTaxMoney.
     * @param totalDiscountMoney Money value for totalDiscountMoney.
     * @param totalMoney Money value for totalMoney.
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

    /**
     * Getter for Uid.
     * Unique ID that identifies the line item only within this order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
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
     * The quantity purchased, formatted as a decimal number. For example: `"3"`. Line items with a
     * quantity of `"0"` will be automatically removed upon paying for or otherwise completing the
     * order. Line items with a `quantity_unit` can have non-integer quantities. For example:
     * `"1.70000"`.
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
     * The note of the line item.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
    }

    /**
     * Getter for CatalogObjectId.
     * The [CatalogItemVariation](#type-catalogitemvariation) id applied to this line item.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for VariationName.
     * The name of the variation applied to this line item.
     * @return Returns the String
     */
    @JsonGetter("variation_name")
    public String getVariationName() {
        return this.variationName;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this line item. Metadata fields are intended to store
     * descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns
     * it in relevant API calls. Do not use metadata to store any sensitive information (personally
     * identifiable information, card details, etc.). Keys written by applications must be 60
     * characters or less and must be in the character set `[a-zA-Z0-9_-]`. Entries may also include
     * metadata generated by Square. These keys are prefixed with a namespace, separated from the
     * key with a ':' character. Values have a max length of 255 characters. An application may have
     * up to 10 entries per metadata field. Entries written by applications are private and can only
     * be read or modified by the same application. See
     * [Metadata](https://developer.squareup.com/docs/build-basics/metadata) for more information.
     * @return Returns the Map of String, String
     */
    @JsonGetter("metadata")
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    /**
     * Getter for Modifiers.
     * The [CatalogModifier](#type-catalogmodifier)s applied to this line item.
     * @return Returns the List of OrderLineItemModifier
     */
    @JsonGetter("modifiers")
    public List<OrderLineItemModifier> getModifiers() {
        return this.modifiers;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to taxes applied to this line item. Each `OrderLineItemAppliedTax` has
     * a `tax_uid` that references the `uid` of a top-level `OrderLineItemTax` applied to the line
     * item. On reads, the amount applied is populated. An `OrderLineItemAppliedTax` will be
     * automatically created on every line item for all `ORDER` scoped taxes added to the order.
     * `OrderLineItemAppliedTax` records for `LINE_ITEM` scoped taxes must be added in requests for
     * the tax to apply to any line items. To change the amount of a tax, modify the referenced
     * top-level tax.
     * @return Returns the List of OrderLineItemAppliedTax
     */
    @JsonGetter("applied_taxes")
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return this.appliedTaxes;
    }

    /**
     * Getter for AppliedDiscounts.
     * The list of references to discounts applied to this line item. Each
     * `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a top-level
     * `OrderLineItemDiscounts` applied to the line item. On reads, the amount applied is populated.
     * An `OrderLineItemAppliedDiscount` will be automatically created on every line item for all
     * `ORDER` scoped discounts that are added to the order. `OrderLineItemAppliedDiscount` records
     * for `LINE_ITEM` scoped discounts must be added in requests for the discount to apply to any
     * line items. To change the amount of a discount, modify the referenced top-level discount.
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
     * Getter for GrossSalesMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("gross_sales_money")
    public Money getGrossSalesMoney() {
        return this.grossSalesMoney;
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
        return Objects.hash(uid, name, quantity, quantityUnit, note, catalogObjectId, variationName,
                metadata, modifiers, appliedTaxes, appliedDiscounts, basePriceMoney,
                variationTotalPriceMoney, grossSalesMoney, totalTaxMoney, totalDiscountMoney,
                totalMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItem)) {
            return false;
        }
        OrderLineItem other = (OrderLineItem) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(name, other.name)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(quantityUnit, other.quantityUnit)
            && Objects.equals(note, other.note)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(variationName, other.variationName)
            && Objects.equals(metadata, other.metadata)
            && Objects.equals(modifiers, other.modifiers)
            && Objects.equals(appliedTaxes, other.appliedTaxes)
            && Objects.equals(appliedDiscounts, other.appliedDiscounts)
            && Objects.equals(basePriceMoney, other.basePriceMoney)
            && Objects.equals(variationTotalPriceMoney, other.variationTotalPriceMoney)
            && Objects.equals(grossSalesMoney, other.grossSalesMoney)
            && Objects.equals(totalTaxMoney, other.totalTaxMoney)
            && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
            && Objects.equals(totalMoney, other.totalMoney);
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
     * Class to build instances of {@link OrderLineItem}.
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
         * Setter for metadata.
         * @param metadata Map of String, value for metadata.
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Setter for modifiers.
         * @param modifiers List of OrderLineItemModifier value for modifiers.
         * @return Builder
         */
        public Builder modifiers(List<OrderLineItemModifier> modifiers) {
            this.modifiers = modifiers;
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
         * Setter for grossSalesMoney.
         * @param grossSalesMoney Money value for grossSalesMoney.
         * @return Builder
         */
        public Builder grossSalesMoney(Money grossSalesMoney) {
            this.grossSalesMoney = grossSalesMoney;
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
