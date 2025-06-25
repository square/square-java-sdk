package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for OrderLineItem type.
 */
public class OrderLineItem {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> name;
    private final String quantity;
    private final OrderQuantityUnit quantityUnit;
    private final OptionalNullable<String> note;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> variationName;
    private final String itemType;
    private final OptionalNullable<Map<String, String>> metadata;
    private final OptionalNullable<List<OrderLineItemModifier>> modifiers;
    private final OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes;
    private final OptionalNullable<List<OrderLineItemAppliedDiscount>> appliedDiscounts;
    private final OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges;
    private final Money basePriceMoney;
    private final Money variationTotalPriceMoney;
    private final Money grossSalesMoney;
    private final Money totalTaxMoney;
    private final Money totalDiscountMoney;
    private final Money totalMoney;
    private final OrderLineItemPricingBlocklists pricingBlocklists;
    private final Money totalServiceChargeMoney;

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
     * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
     *         appliedServiceCharges.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  variationTotalPriceMoney  Money value for variationTotalPriceMoney.
     * @param  grossSalesMoney  Money value for grossSalesMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  pricingBlocklists  OrderLineItemPricingBlocklists value for pricingBlocklists.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
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
            @JsonProperty("applied_service_charges") List<OrderLineItemAppliedServiceCharge> appliedServiceCharges,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("variation_total_price_money") Money variationTotalPriceMoney,
            @JsonProperty("gross_sales_money") Money grossSalesMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("total_discount_money") Money totalDiscountMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("pricing_blocklists") OrderLineItemPricingBlocklists pricingBlocklists,
            @JsonProperty("total_service_charge_money") Money totalServiceChargeMoney) {
        this.uid = OptionalNullable.of(uid);
        this.name = OptionalNullable.of(name);
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.note = OptionalNullable.of(note);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.variationName = OptionalNullable.of(variationName);
        this.itemType = itemType;
        this.metadata = OptionalNullable.of(metadata);
        this.modifiers = OptionalNullable.of(modifiers);
        this.appliedTaxes = OptionalNullable.of(appliedTaxes);
        this.appliedDiscounts = OptionalNullable.of(appliedDiscounts);
        this.appliedServiceCharges = OptionalNullable.of(appliedServiceCharges);
        this.basePriceMoney = basePriceMoney;
        this.variationTotalPriceMoney = variationTotalPriceMoney;
        this.grossSalesMoney = grossSalesMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalMoney = totalMoney;
        this.pricingBlocklists = pricingBlocklists;
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

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
     * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
     *         appliedServiceCharges.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  variationTotalPriceMoney  Money value for variationTotalPriceMoney.
     * @param  grossSalesMoney  Money value for grossSalesMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  pricingBlocklists  OrderLineItemPricingBlocklists value for pricingBlocklists.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
     */
    protected OrderLineItem(
            String quantity,
            OptionalNullable<String> uid,
            OptionalNullable<String> name,
            OrderQuantityUnit quantityUnit,
            OptionalNullable<String> note,
            OptionalNullable<String> catalogObjectId,
            OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> variationName,
            String itemType,
            OptionalNullable<Map<String, String>> metadata,
            OptionalNullable<List<OrderLineItemModifier>> modifiers,
            OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes,
            OptionalNullable<List<OrderLineItemAppliedDiscount>> appliedDiscounts,
            OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges,
            Money basePriceMoney,
            Money variationTotalPriceMoney,
            Money grossSalesMoney,
            Money totalTaxMoney,
            Money totalDiscountMoney,
            Money totalMoney,
            OrderLineItemPricingBlocklists pricingBlocklists,
            Money totalServiceChargeMoney) {
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
        this.appliedServiceCharges = appliedServiceCharges;
        this.basePriceMoney = basePriceMoney;
        this.variationTotalPriceMoney = variationTotalPriceMoney;
        this.grossSalesMoney = grossSalesMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalMoney = totalMoney;
        this.pricingBlocklists = pricingBlocklists;
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the line item only within this order.
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
     * A unique ID that identifies the line item only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for Name.
     * The name of the line item.
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
     * The name of the line item.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for Quantity.
     * The count, or measurement, of a line item being purchased: If `quantity` is a whole number,
     * and `quantity_unit` is not specified, then `quantity` denotes an item count. For example: `3`
     * apples. If `quantity` is a whole or decimal number, and `quantity_unit` is also specified,
     * then `quantity` denotes a measurement. For example: `2.25` pounds of broccoli. For more
     * information, see [Specify item quantity and measurement
     * unit](https://developer.squareup.com/docs/orders-api/create-orders#specify-item-quantity-and-measurement-unit).
     * Line items with a quantity of `0` are automatically removed when paying for or otherwise
     * completing the order.
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderQuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    /**
     * Internal Getter for Note.
     * An optional note associated with the line item.
     * @return Returns the Internal String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNote() {
        return this.note;
    }

    /**
     * Getter for Note.
     * An optional note associated with the line item.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The [CatalogItemVariation](entity:CatalogItemVariation) ID applied to this line item.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectId.
     * The [CatalogItemVariation](entity:CatalogItemVariation) ID applied to this line item.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this line item references.
     * @return Returns the Internal Long
     */
    @JsonGetter("catalog_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetCatalogVersion() {
        return this.catalogVersion;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the catalog object that this line item references.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for VariationName.
     * The name of the variation applied to this line item.
     * @return Returns the Internal String
     */
    @JsonGetter("variation_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetVariationName() {
        return this.variationName;
    }

    /**
     * Getter for VariationName.
     * The name of the variation applied to this line item.
     * @return Returns the String
     */
    @JsonIgnore
    public String getVariationName() {
        return OptionalNullable.getFrom(variationName);
    }

    /**
     * Getter for ItemType.
     * Represents the line item type.
     * @return Returns the String
     */
    @JsonGetter("item_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getItemType() {
        return itemType;
    }

    /**
     * Internal Getter for Metadata.
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
     * @return Returns the Internal Map of String, String
     */
    @JsonGetter("metadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Map<String, String>> internalGetMetadata() {
        return this.metadata;
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
    @JsonIgnore
    public Map<String, String> getMetadata() {
        return OptionalNullable.getFrom(metadata);
    }

    /**
     * Internal Getter for Modifiers.
     * The [CatalogModifier](entity:CatalogModifier)s applied to this line item.
     * @return Returns the Internal List of OrderLineItemModifier
     */
    @JsonGetter("modifiers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemModifier>> internalGetModifiers() {
        return this.modifiers;
    }

    /**
     * Getter for Modifiers.
     * The [CatalogModifier](entity:CatalogModifier)s applied to this line item.
     * @return Returns the List of OrderLineItemModifier
     */
    @JsonIgnore
    public List<OrderLineItemModifier> getModifiers() {
        return OptionalNullable.getFrom(modifiers);
    }

    /**
     * Internal Getter for AppliedTaxes.
     * The list of references to taxes applied to this line item. Each `OrderLineItemAppliedTax` has
     * a `tax_uid` that references the `uid` of a top-level `OrderLineItemTax` applied to the line
     * item. On reads, the amount applied is populated. An `OrderLineItemAppliedTax` is
     * automatically created on every line item for all `ORDER` scoped taxes added to the order.
     * `OrderLineItemAppliedTax` records for `LINE_ITEM` scoped taxes must be added in requests for
     * the tax to apply to any line items. To change the amount of a tax, modify the referenced
     * top-level tax.
     * @return Returns the Internal List of OrderLineItemAppliedTax
     */
    @JsonGetter("applied_taxes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemAppliedTax>> internalGetAppliedTaxes() {
        return this.appliedTaxes;
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
    @JsonIgnore
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return OptionalNullable.getFrom(appliedTaxes);
    }

    /**
     * Internal Getter for AppliedDiscounts.
     * The list of references to discounts applied to this line item. Each
     * `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a top-level
     * `OrderLineItemDiscounts` applied to the line item. On reads, the amount applied is populated.
     * An `OrderLineItemAppliedDiscount` is automatically created on every line item for all `ORDER`
     * scoped discounts that are added to the order. `OrderLineItemAppliedDiscount` records for
     * `LINE_ITEM` scoped discounts must be added in requests for the discount to apply to any line
     * items. To change the amount of a discount, modify the referenced top-level discount.
     * @return Returns the Internal List of OrderLineItemAppliedDiscount
     */
    @JsonGetter("applied_discounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemAppliedDiscount>> internalGetAppliedDiscounts() {
        return this.appliedDiscounts;
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
    @JsonIgnore
    public List<OrderLineItemAppliedDiscount> getAppliedDiscounts() {
        return OptionalNullable.getFrom(appliedDiscounts);
    }

    /**
     * Internal Getter for AppliedServiceCharges.
     * The list of references to service charges applied to this line item. Each
     * `OrderLineItemAppliedServiceCharge` has a `service_charge_id` that references the `uid` of a
     * top-level `OrderServiceCharge` applied to the line item. On reads, the amount applied is
     * populated. To change the amount of a service charge, modify the referenced top-level service
     * charge.
     * @return Returns the Internal List of OrderLineItemAppliedServiceCharge
     */
    @JsonGetter("applied_service_charges")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemAppliedServiceCharge>> internalGetAppliedServiceCharges() {
        return this.appliedServiceCharges;
    }

    /**
     * Getter for AppliedServiceCharges.
     * The list of references to service charges applied to this line item. Each
     * `OrderLineItemAppliedServiceCharge` has a `service_charge_id` that references the `uid` of a
     * top-level `OrderServiceCharge` applied to the line item. On reads, the amount applied is
     * populated. To change the amount of a service charge, modify the referenced top-level service
     * charge.
     * @return Returns the List of OrderLineItemAppliedServiceCharge
     */
    @JsonIgnore
    public List<OrderLineItemAppliedServiceCharge> getAppliedServiceCharges() {
        return OptionalNullable.getFrom(appliedServiceCharges);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalMoney() {
        return totalMoney;
    }

    /**
     * Getter for PricingBlocklists.
     * Describes pricing adjustments that are blocked from automatic application to a line item. For
     * more information, see [Apply Taxes and
     * Discounts](https://developer.squareup.com/docs/orders-api/apply-taxes-and-discounts).
     * @return Returns the OrderLineItemPricingBlocklists
     */
    @JsonGetter("pricing_blocklists")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderLineItemPricingBlocklists getPricingBlocklists() {
        return pricingBlocklists;
    }

    /**
     * Getter for TotalServiceChargeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_service_charge_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalServiceChargeMoney() {
        return totalServiceChargeMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                uid,
                name,
                quantity,
                quantityUnit,
                note,
                catalogObjectId,
                catalogVersion,
                variationName,
                itemType,
                metadata,
                modifiers,
                appliedTaxes,
                appliedDiscounts,
                appliedServiceCharges,
                basePriceMoney,
                variationTotalPriceMoney,
                grossSalesMoney,
                totalTaxMoney,
                totalDiscountMoney,
                totalMoney,
                pricingBlocklists,
                totalServiceChargeMoney);
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
                && Objects.equals(appliedServiceCharges, other.appliedServiceCharges)
                && Objects.equals(basePriceMoney, other.basePriceMoney)
                && Objects.equals(variationTotalPriceMoney, other.variationTotalPriceMoney)
                && Objects.equals(grossSalesMoney, other.grossSalesMoney)
                && Objects.equals(totalTaxMoney, other.totalTaxMoney)
                && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
                && Objects.equals(totalMoney, other.totalMoney)
                && Objects.equals(pricingBlocklists, other.pricingBlocklists)
                && Objects.equals(totalServiceChargeMoney, other.totalServiceChargeMoney);
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
                + ", appliedDiscounts=" + appliedDiscounts + ", appliedServiceCharges="
                + appliedServiceCharges + ", basePriceMoney=" + basePriceMoney
                + ", variationTotalPriceMoney=" + variationTotalPriceMoney + ", grossSalesMoney="
                + grossSalesMoney + ", totalTaxMoney=" + totalTaxMoney + ", totalDiscountMoney="
                + totalDiscountMoney + ", totalMoney=" + totalMoney + ", pricingBlocklists="
                + pricingBlocklists + ", totalServiceChargeMoney=" + totalServiceChargeMoney + "]";
    }

    /**
     * Builds a new {@link OrderLineItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(quantity)
                .quantityUnit(getQuantityUnit())
                .itemType(getItemType())
                .basePriceMoney(getBasePriceMoney())
                .variationTotalPriceMoney(getVariationTotalPriceMoney())
                .grossSalesMoney(getGrossSalesMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .totalDiscountMoney(getTotalDiscountMoney())
                .totalMoney(getTotalMoney())
                .pricingBlocklists(getPricingBlocklists())
                .totalServiceChargeMoney(getTotalServiceChargeMoney());
        builder.uid = internalGetUid();
        builder.name = internalGetName();
        builder.note = internalGetNote();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.variationName = internalGetVariationName();
        builder.metadata = internalGetMetadata();
        builder.modifiers = internalGetModifiers();
        builder.appliedTaxes = internalGetAppliedTaxes();
        builder.appliedDiscounts = internalGetAppliedDiscounts();
        builder.appliedServiceCharges = internalGetAppliedServiceCharges();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItem}.
     */
    public static class Builder {
        private String quantity;
        private OptionalNullable<String> uid;
        private OptionalNullable<String> name;
        private OrderQuantityUnit quantityUnit;
        private OptionalNullable<String> note;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> variationName;
        private String itemType;
        private OptionalNullable<Map<String, String>> metadata;
        private OptionalNullable<List<OrderLineItemModifier>> modifiers;
        private OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes;
        private OptionalNullable<List<OrderLineItemAppliedDiscount>> appliedDiscounts;
        private OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges;
        private Money basePriceMoney;
        private Money variationTotalPriceMoney;
        private Money grossSalesMoney;
        private Money totalTaxMoney;
        private Money totalDiscountMoney;
        private Money totalMoney;
        private OrderLineItemPricingBlocklists pricingBlocklists;
        private Money totalServiceChargeMoney;

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
            this.note = OptionalNullable.of(note);
            return this;
        }

        /**
         * UnSetter for note.
         * @return Builder
         */
        public Builder unsetNote() {
            note = null;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = OptionalNullable.of(catalogObjectId);
            return this;
        }

        /**
         * UnSetter for catalogObjectId.
         * @return Builder
         */
        public Builder unsetCatalogObjectId() {
            catalogObjectId = null;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = OptionalNullable.of(catalogVersion);
            return this;
        }

        /**
         * UnSetter for catalogVersion.
         * @return Builder
         */
        public Builder unsetCatalogVersion() {
            catalogVersion = null;
            return this;
        }

        /**
         * Setter for variationName.
         * @param  variationName  String value for variationName.
         * @return Builder
         */
        public Builder variationName(String variationName) {
            this.variationName = OptionalNullable.of(variationName);
            return this;
        }

        /**
         * UnSetter for variationName.
         * @return Builder
         */
        public Builder unsetVariationName() {
            variationName = null;
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
            this.metadata = OptionalNullable.of(metadata);
            return this;
        }

        /**
         * UnSetter for metadata.
         * @return Builder
         */
        public Builder unsetMetadata() {
            metadata = null;
            return this;
        }

        /**
         * Setter for modifiers.
         * @param  modifiers  List of OrderLineItemModifier value for modifiers.
         * @return Builder
         */
        public Builder modifiers(List<OrderLineItemModifier> modifiers) {
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
         * Setter for appliedTaxes.
         * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
         * @return Builder
         */
        public Builder appliedTaxes(List<OrderLineItemAppliedTax> appliedTaxes) {
            this.appliedTaxes = OptionalNullable.of(appliedTaxes);
            return this;
        }

        /**
         * UnSetter for appliedTaxes.
         * @return Builder
         */
        public Builder unsetAppliedTaxes() {
            appliedTaxes = null;
            return this;
        }

        /**
         * Setter for appliedDiscounts.
         * @param  appliedDiscounts  List of OrderLineItemAppliedDiscount value for
         *         appliedDiscounts.
         * @return Builder
         */
        public Builder appliedDiscounts(List<OrderLineItemAppliedDiscount> appliedDiscounts) {
            this.appliedDiscounts = OptionalNullable.of(appliedDiscounts);
            return this;
        }

        /**
         * UnSetter for appliedDiscounts.
         * @return Builder
         */
        public Builder unsetAppliedDiscounts() {
            appliedDiscounts = null;
            return this;
        }

        /**
         * Setter for appliedServiceCharges.
         * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
         *         appliedServiceCharges.
         * @return Builder
         */
        public Builder appliedServiceCharges(List<OrderLineItemAppliedServiceCharge> appliedServiceCharges) {
            this.appliedServiceCharges = OptionalNullable.of(appliedServiceCharges);
            return this;
        }

        /**
         * UnSetter for appliedServiceCharges.
         * @return Builder
         */
        public Builder unsetAppliedServiceCharges() {
            appliedServiceCharges = null;
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
         * Setter for totalServiceChargeMoney.
         * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
         * @return Builder
         */
        public Builder totalServiceChargeMoney(Money totalServiceChargeMoney) {
            this.totalServiceChargeMoney = totalServiceChargeMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItem} object using the set fields.
         * @return {@link OrderLineItem}
         */
        public OrderLineItem build() {
            return new OrderLineItem(
                    quantity,
                    uid,
                    name,
                    quantityUnit,
                    note,
                    catalogObjectId,
                    catalogVersion,
                    variationName,
                    itemType,
                    metadata,
                    modifiers,
                    appliedTaxes,
                    appliedDiscounts,
                    appliedServiceCharges,
                    basePriceMoney,
                    variationTotalPriceMoney,
                    grossSalesMoney,
                    totalTaxMoney,
                    totalDiscountMoney,
                    totalMoney,
                    pricingBlocklists,
                    totalServiceChargeMoney);
        }
    }
}
