
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for OrderLineItem type.
 */
public class OrderLineItem {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String uid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    private final String quantity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final OrderQuantityUnit quantityUnit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String catalogObjectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long catalogVersion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String variationName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String itemType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Map<String, String> metadata;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<OrderLineItemModifier> modifiers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<OrderLineItemAppliedTax> appliedTaxes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<OrderLineItemAppliedDiscount> appliedDiscounts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money basePriceMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money variationTotalPriceMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money grossSalesMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money totalTaxMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money totalDiscountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money totalMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final OrderLineItemPricingBlocklists pricingBlocklists;

    /**
     * Initialization constructor.
     * @param  quantity  String value for quantity.
     * @param  uid  String value for uid.
     * @param  name  String value for name.
     * @param  quantityUnit  OrderQuantityUnit value for quantityUnit.
     * @param  note  String value for note.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  variationName  String value for variationName.
     * @param  itemType  String value for itemType.
     * @param  metadata  Map of String, value for metadata.
     * @param  modifiers  List of OrderLineItemModifier value for modifiers.
     * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param  appliedDiscounts  List of OrderLineItemAppliedDiscount value for appliedDiscounts.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  variationTotalPriceMoney  Money value for variationTotalPriceMoney.
     * @param  grossSalesMoney  Money value for grossSalesMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  pricingBlocklists  OrderLineItemPricingBlocklists value for pricingBlocklists.
     */
    @JsonCreator
    public OrderLineItem(
            @JsonProperty("quantity") String quantity,
            @JsonProperty("uid") String uid,
            @JsonProperty("name") String name,
            @JsonProperty("quantity_unit") OrderQuantityUnit quantityUnit,
            @JsonProperty("note") String note,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("variation_name") String variationName,
            @JsonProperty("item_type") String itemType,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("modifiers") List<OrderLineItemModifier> modifiers,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes,
            @JsonProperty("applied_discounts") List<OrderLineItemAppliedDiscount> appliedDiscounts,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("variation_total_price_money") Money variationTotalPriceMoney,
            @JsonProperty("gross_sales_money") Money grossSalesMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("total_discount_money") Money totalDiscountMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("pricing_blocklists") OrderLineItemPricingBlocklists pricingBlocklists) {
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.note = note;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.variationName = variationName;
        this.itemType = itemType;
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
        this.pricingBlocklists = pricingBlocklists;
    }

    /**
     * Getter for Uid.
     * A unique ID that identifies the line item only within this order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * Getter for Name.
     * The name of the line item.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Quantity.
     * The quantity purchased, formatted as a decimal number. For example, `"3"`. Line items with a
     * quantity of `"0"` are automatically removed when paying for or otherwise completing the
     * order. Line items with a `quantity_unit` can have non-integer quantities. For example,
     * `"1.70000"`.
     * @return Returns the String
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return quantity;
    }

    /**
     * Getter for QuantityUnit.
     * Contains the measurement unit for a quantity and a precision that specifies the number of
     * digits after the decimal point for decimal quantities.
     * @return Returns the OrderQuantityUnit
     */
    @JsonGetter("quantity_unit")
    public OrderQuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    /**
     * Getter for Note.
     * The note of the line item.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    /**
     * Getter for CatalogObjectId.
     * The [CatalogItemVariation]($m/CatalogItemVariation) ID applied to this line item.
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return catalogObjectId;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the catalog object that this line item references.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    public Long getCatalogVersion() {
        return catalogVersion;
    }

    /**
     * Getter for VariationName.
     * The name of the variation applied to this line item.
     * @return Returns the String
     */
    @JsonGetter("variation_name")
    public String getVariationName() {
        return variationName;
    }

    /**
     * Getter for ItemType.
     * Represents the line item type.
     * @return Returns the String
     */
    @JsonGetter("item_type")
    public String getItemType() {
        return itemType;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this line item. Metadata fields are intended to store
     * descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns
     * it in relevant API calls. Do not use metadata to store any sensitive information (such as
     * personally identifiable information or card details). Keys written by applications must be 60
     * characters or less and must be in the character set `[a-zA-Z0-9_-]`. Entries can also include
     * metadata generated by Square. These keys are prefixed with a namespace, separated from the
     * key with a ':' character. Values have a maximum length of 255 characters. An application can
     * have up to 10 entries per metadata field. Entries written by applications are private and can
     * only be read or modified by the same application. For more information, see
     * [Metadata](https://developer.squareup.com/docs/build-basics/metadata).
     * @return Returns the Map of String, String
     */
    @JsonGetter("metadata")
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Getter for Modifiers.
     * The [CatalogModifier]($m/CatalogModifier)s applied to this line item.
     * @return Returns the List of OrderLineItemModifier
     */
    @JsonGetter("modifiers")
    public List<OrderLineItemModifier> getModifiers() {
        return modifiers;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to taxes applied to this line item. Each `OrderLineItemAppliedTax` has
     * a `tax_uid` that references the `uid` of a top-level `OrderLineItemTax` applied to the line
     * item. On reads, the amount applied is populated. An `OrderLineItemAppliedTax` is
     * automatically created on every line item for all `ORDER` scoped taxes added to the order.
     * `OrderLineItemAppliedTax` records for `LINE_ITEM` scoped taxes must be added in requests for
     * the tax to apply to any line items. To change the amount of a tax, modify the referenced
     * top-level tax.
     * @return Returns the List of OrderLineItemAppliedTax
     */
    @JsonGetter("applied_taxes")
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return appliedTaxes;
    }

    /**
     * Getter for AppliedDiscounts.
     * The list of references to discounts applied to this line item. Each
     * `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a top-level
     * `OrderLineItemDiscounts` applied to the line item. On reads, the amount applied is populated.
     * An `OrderLineItemAppliedDiscount` is automatically created on every line item for all `ORDER`
     * scoped discounts that are added to the order. `OrderLineItemAppliedDiscount` records for
     * `LINE_ITEM` scoped discounts must be added in requests for the discount to apply to any line
     * items. To change the amount of a discount, modify the referenced top-level discount.
     * @return Returns the List of OrderLineItemAppliedDiscount
     */
    @JsonGetter("applied_discounts")
    public List<OrderLineItemAppliedDiscount> getAppliedDiscounts() {
        return appliedDiscounts;
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
        return basePriceMoney;
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
        return variationTotalPriceMoney;
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
        return grossSalesMoney;
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
        return totalTaxMoney;
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
        return totalDiscountMoney;
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
        return totalMoney;
    }

    /**
     * Getter for PricingBlocklists.
     * Describes pricing adjustments that are blocked from manual and automatic application to a
     * line item. For more information, see [Apply Taxes and
     * Discounts](https://developer.squareup.com/docs/orders-api/apply-taxes-and-discounts).
     * @return Returns the OrderLineItemPricingBlocklists
     */
    @JsonGetter("pricing_blocklists")
    public OrderLineItemPricingBlocklists getPricingBlocklists() {
        return pricingBlocklists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, quantity, quantityUnit, note, catalogObjectId,
                catalogVersion, variationName, itemType, metadata, modifiers, appliedTaxes,
                appliedDiscounts, basePriceMoney, variationTotalPriceMoney, grossSalesMoney,
                totalTaxMoney, totalDiscountMoney, totalMoney, pricingBlocklists);
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
            && Objects.equals(catalogVersion, other.catalogVersion)
            && Objects.equals(variationName, other.variationName)
            && Objects.equals(itemType, other.itemType)
            && Objects.equals(metadata, other.metadata)
            && Objects.equals(modifiers, other.modifiers)
            && Objects.equals(appliedTaxes, other.appliedTaxes)
            && Objects.equals(appliedDiscounts, other.appliedDiscounts)
            && Objects.equals(basePriceMoney, other.basePriceMoney)
            && Objects.equals(variationTotalPriceMoney, other.variationTotalPriceMoney)
            && Objects.equals(grossSalesMoney, other.grossSalesMoney)
            && Objects.equals(totalTaxMoney, other.totalTaxMoney)
            && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(pricingBlocklists, other.pricingBlocklists);
    }

    /**
     * Converts this OrderLineItem into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItem [" + "quantity=" + quantity + ", uid=" + uid + ", name=" + name
                + ", quantityUnit=" + quantityUnit + ", note=" + note + ", catalogObjectId="
                + catalogObjectId + ", catalogVersion=" + catalogVersion + ", variationName="
                + variationName + ", itemType=" + itemType + ", metadata=" + metadata
                + ", modifiers=" + modifiers + ", appliedTaxes=" + appliedTaxes
                + ", appliedDiscounts=" + appliedDiscounts + ", basePriceMoney=" + basePriceMoney
                + ", variationTotalPriceMoney=" + variationTotalPriceMoney + ", grossSalesMoney="
                + grossSalesMoney + ", totalTaxMoney=" + totalTaxMoney + ", totalDiscountMoney="
                + totalDiscountMoney + ", totalMoney=" + totalMoney + ", pricingBlocklists="
                + pricingBlocklists + "]";
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
                .catalogVersion(getCatalogVersion())
                .variationName(getVariationName())
                .itemType(getItemType())
                .metadata(getMetadata())
                .modifiers(getModifiers())
                .appliedTaxes(getAppliedTaxes())
                .appliedDiscounts(getAppliedDiscounts())
                .basePriceMoney(getBasePriceMoney())
                .variationTotalPriceMoney(getVariationTotalPriceMoney())
                .grossSalesMoney(getGrossSalesMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .totalDiscountMoney(getTotalDiscountMoney())
                .totalMoney(getTotalMoney())
                .pricingBlocklists(getPricingBlocklists());
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
        private Long catalogVersion;
        private String variationName;
        private String itemType;
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
        private OrderLineItemPricingBlocklists pricingBlocklists;

        /**
         * Initialization constructor.
         * @param  quantity  String value for quantity.
         */
        public Builder(String quantity) {
            this.quantity = quantity;
        }

        /**
         * Setter for quantity.
         * @param  quantity  String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for quantityUnit.
         * @param  quantityUnit  OrderQuantityUnit value for quantityUnit.
         * @return Builder
         */
        public Builder quantityUnit(OrderQuantityUnit quantityUnit) {
            this.quantityUnit = quantityUnit;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
        }

        /**
         * Setter for variationName.
         * @param  variationName  String value for variationName.
         * @return Builder
         */
        public Builder variationName(String variationName) {
            this.variationName = variationName;
            return this;
        }

        /**
         * Setter for itemType.
         * @param  itemType  String value for itemType.
         * @return Builder
         */
        public Builder itemType(String itemType) {
            this.itemType = itemType;
            return this;
        }

        /**
         * Setter for metadata.
         * @param  metadata  Map of String, value for metadata.
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Setter for modifiers.
         * @param  modifiers  List of OrderLineItemModifier value for modifiers.
         * @return Builder
         */
        public Builder modifiers(List<OrderLineItemModifier> modifiers) {
            this.modifiers = modifiers;
            return this;
        }

        /**
         * Setter for appliedTaxes.
         * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
         * @return Builder
         */
        public Builder appliedTaxes(List<OrderLineItemAppliedTax> appliedTaxes) {
            this.appliedTaxes = appliedTaxes;
            return this;
        }

        /**
         * Setter for appliedDiscounts.
         * @param  appliedDiscounts  List of OrderLineItemAppliedDiscount value for
         *         appliedDiscounts.
         * @return Builder
         */
        public Builder appliedDiscounts(List<OrderLineItemAppliedDiscount> appliedDiscounts) {
            this.appliedDiscounts = appliedDiscounts;
            return this;
        }

        /**
         * Setter for basePriceMoney.
         * @param  basePriceMoney  Money value for basePriceMoney.
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }

        /**
         * Setter for variationTotalPriceMoney.
         * @param  variationTotalPriceMoney  Money value for variationTotalPriceMoney.
         * @return Builder
         */
        public Builder variationTotalPriceMoney(Money variationTotalPriceMoney) {
            this.variationTotalPriceMoney = variationTotalPriceMoney;
            return this;
        }

        /**
         * Setter for grossSalesMoney.
         * @param  grossSalesMoney  Money value for grossSalesMoney.
         * @return Builder
         */
        public Builder grossSalesMoney(Money grossSalesMoney) {
            this.grossSalesMoney = grossSalesMoney;
            return this;
        }

        /**
         * Setter for totalTaxMoney.
         * @param  totalTaxMoney  Money value for totalTaxMoney.
         * @return Builder
         */
        public Builder totalTaxMoney(Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }

        /**
         * Setter for totalDiscountMoney.
         * @param  totalDiscountMoney  Money value for totalDiscountMoney.
         * @return Builder
         */
        public Builder totalDiscountMoney(Money totalDiscountMoney) {
            this.totalDiscountMoney = totalDiscountMoney;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param  totalMoney  Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for pricingBlocklists.
         * @param  pricingBlocklists  OrderLineItemPricingBlocklists value for pricingBlocklists.
         * @return Builder
         */
        public Builder pricingBlocklists(OrderLineItemPricingBlocklists pricingBlocklists) {
            this.pricingBlocklists = pricingBlocklists;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItem} object using the set fields.
         * @return {@link OrderLineItem}
         */
        public OrderLineItem build() {
            return new OrderLineItem(quantity, uid, name, quantityUnit, note, catalogObjectId,
                    catalogVersion, variationName, itemType, metadata, modifiers, appliedTaxes,
                    appliedDiscounts, basePriceMoney, variationTotalPriceMoney, grossSalesMoney,
                    totalTaxMoney, totalDiscountMoney, totalMoney, pricingBlocklists);
        }
    }
}
