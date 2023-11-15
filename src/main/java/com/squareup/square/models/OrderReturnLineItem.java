
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
 * This is a model class for OrderReturnLineItem type.
 */
public class OrderReturnLineItem {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> sourceLineItemUid;
    private final OptionalNullable<String> name;
    private final String quantity;
    private final OrderQuantityUnit quantityUnit;
    private final OptionalNullable<String> note;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> variationName;
    private final String itemType;
    private final OptionalNullable<List<OrderReturnLineItemModifier>> returnModifiers;
    private final OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes;
    private final OptionalNullable<List<OrderLineItemAppliedDiscount>> appliedDiscounts;
    private final Money basePriceMoney;
    private final Money variationTotalPriceMoney;
    private final Money grossReturnMoney;
    private final Money totalTaxMoney;
    private final Money totalDiscountMoney;
    private final Money totalMoney;
    private final OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges;
    private final Money totalServiceChargeMoney;

    /**
     * Initialization constructor.
     * @param  quantity  String value for quantity.
     * @param  uid  String value for uid.
     * @param  sourceLineItemUid  String value for sourceLineItemUid.
     * @param  name  String value for name.
     * @param  quantityUnit  OrderQuantityUnit value for quantityUnit.
     * @param  note  String value for note.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  variationName  String value for variationName.
     * @param  itemType  String value for itemType.
     * @param  returnModifiers  List of OrderReturnLineItemModifier value for returnModifiers.
     * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param  appliedDiscounts  List of OrderLineItemAppliedDiscount value for appliedDiscounts.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  variationTotalPriceMoney  Money value for variationTotalPriceMoney.
     * @param  grossReturnMoney  Money value for grossReturnMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
     *         appliedServiceCharges.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
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
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("variation_name") String variationName,
            @JsonProperty("item_type") String itemType,
            @JsonProperty("return_modifiers") List<OrderReturnLineItemModifier> returnModifiers,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes,
            @JsonProperty("applied_discounts") List<OrderLineItemAppliedDiscount> appliedDiscounts,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("variation_total_price_money") Money variationTotalPriceMoney,
            @JsonProperty("gross_return_money") Money grossReturnMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("total_discount_money") Money totalDiscountMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("applied_service_charges") List<OrderLineItemAppliedServiceCharge> appliedServiceCharges,
            @JsonProperty("total_service_charge_money") Money totalServiceChargeMoney) {
        this.uid = OptionalNullable.of(uid);
        this.sourceLineItemUid = OptionalNullable.of(sourceLineItemUid);
        this.name = OptionalNullable.of(name);
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.note = OptionalNullable.of(note);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.variationName = OptionalNullable.of(variationName);
        this.itemType = itemType;
        this.returnModifiers = OptionalNullable.of(returnModifiers);
        this.appliedTaxes = OptionalNullable.of(appliedTaxes);
        this.appliedDiscounts = OptionalNullable.of(appliedDiscounts);
        this.basePriceMoney = basePriceMoney;
        this.variationTotalPriceMoney = variationTotalPriceMoney;
        this.grossReturnMoney = grossReturnMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalMoney = totalMoney;
        this.appliedServiceCharges = OptionalNullable.of(appliedServiceCharges);
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

    /**
     * Initialization constructor.
     * @param  quantity  String value for quantity.
     * @param  uid  String value for uid.
     * @param  sourceLineItemUid  String value for sourceLineItemUid.
     * @param  name  String value for name.
     * @param  quantityUnit  OrderQuantityUnit value for quantityUnit.
     * @param  note  String value for note.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  variationName  String value for variationName.
     * @param  itemType  String value for itemType.
     * @param  returnModifiers  List of OrderReturnLineItemModifier value for returnModifiers.
     * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param  appliedDiscounts  List of OrderLineItemAppliedDiscount value for appliedDiscounts.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  variationTotalPriceMoney  Money value for variationTotalPriceMoney.
     * @param  grossReturnMoney  Money value for grossReturnMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
     *         appliedServiceCharges.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
     */

    protected OrderReturnLineItem(String quantity, OptionalNullable<String> uid,
            OptionalNullable<String> sourceLineItemUid, OptionalNullable<String> name,
            OrderQuantityUnit quantityUnit, OptionalNullable<String> note,
            OptionalNullable<String> catalogObjectId, OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> variationName, String itemType,
            OptionalNullable<List<OrderReturnLineItemModifier>> returnModifiers,
            OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes,
            OptionalNullable<List<OrderLineItemAppliedDiscount>> appliedDiscounts,
            Money basePriceMoney, Money variationTotalPriceMoney, Money grossReturnMoney,
            Money totalTaxMoney, Money totalDiscountMoney, Money totalMoney,
            OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges,
            Money totalServiceChargeMoney) {
        this.uid = uid;
        this.sourceLineItemUid = sourceLineItemUid;
        this.name = name;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.note = note;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.variationName = variationName;
        this.itemType = itemType;
        this.returnModifiers = returnModifiers;
        this.appliedTaxes = appliedTaxes;
        this.appliedDiscounts = appliedDiscounts;
        this.basePriceMoney = basePriceMoney;
        this.variationTotalPriceMoney = variationTotalPriceMoney;
        this.grossReturnMoney = grossReturnMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalMoney = totalMoney;
        this.appliedServiceCharges = appliedServiceCharges;
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID for this return line-item entry.
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
     * A unique ID for this return line-item entry.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for SourceLineItemUid.
     * The `uid` of the line item in the original sale order.
     * @return Returns the Internal String
     */
    @JsonGetter("source_line_item_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceLineItemUid() {
        return this.sourceLineItemUid;
    }

    /**
     * Getter for SourceLineItemUid.
     * The `uid` of the line item in the original sale order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceLineItemUid() {
        return OptionalNullable.getFrom(sourceLineItemUid);
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
     * The quantity returned, formatted as a decimal number. For example, `"3"`. Line items with a
     * `quantity_unit` can have non-integer quantities. For example, `"1.70000"`.
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
     * The note of the return line item.
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
     * The note of the return line item.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The [CatalogItemVariation](entity:CatalogItemVariation) ID applied to this return line item.
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
     * The [CatalogItemVariation](entity:CatalogItemVariation) ID applied to this return line item.
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
     * The name of the variation applied to this return line item.
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
     * The name of the variation applied to this return line item.
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
     * Internal Getter for ReturnModifiers.
     * The [CatalogModifier](entity:CatalogModifier)s applied to this line item.
     * @return Returns the Internal List of OrderReturnLineItemModifier
     */
    @JsonGetter("return_modifiers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderReturnLineItemModifier>> internalGetReturnModifiers() {
        return this.returnModifiers;
    }

    /**
     * Getter for ReturnModifiers.
     * The [CatalogModifier](entity:CatalogModifier)s applied to this line item.
     * @return Returns the List of OrderReturnLineItemModifier
     */
    @JsonIgnore
    public List<OrderReturnLineItemModifier> getReturnModifiers() {
        return OptionalNullable.getFrom(returnModifiers);
    }

    /**
     * Internal Getter for AppliedTaxes.
     * The list of references to `OrderReturnTax` entities applied to the return line item. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a top-level
     * `OrderReturnTax` applied to the return line item. On reads, the applied amount is populated.
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
     * The list of references to `OrderReturnTax` entities applied to the return line item. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a top-level
     * `OrderReturnTax` applied to the return line item. On reads, the applied amount is populated.
     * @return Returns the List of OrderLineItemAppliedTax
     */
    @JsonIgnore
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return OptionalNullable.getFrom(appliedTaxes);
    }

    /**
     * Internal Getter for AppliedDiscounts.
     * The list of references to `OrderReturnDiscount` entities applied to the return line item.
     * Each `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a
     * top-level `OrderReturnDiscount` applied to the return line item. On reads, the applied amount
     * is populated.
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
     * The list of references to `OrderReturnDiscount` entities applied to the return line item.
     * Each `OrderLineItemAppliedDiscount` has a `discount_uid` that references the `uid` of a
     * top-level `OrderReturnDiscount` applied to the return line item. On reads, the applied amount
     * is populated.
     * @return Returns the List of OrderLineItemAppliedDiscount
     */
    @JsonIgnore
    public List<OrderLineItemAppliedDiscount> getAppliedDiscounts() {
        return OptionalNullable.getFrom(appliedDiscounts);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getGrossReturnMoney() {
        return grossReturnMoney;
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
     * Internal Getter for AppliedServiceCharges.
     * The list of references to `OrderReturnServiceCharge` entities applied to the return line
     * item. Each `OrderLineItemAppliedServiceCharge` has a `service_charge_uid` that references the
     * `uid` of a top-level `OrderReturnServiceCharge` applied to the return line item. On reads,
     * the applied amount is populated.
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
     * The list of references to `OrderReturnServiceCharge` entities applied to the return line
     * item. Each `OrderLineItemAppliedServiceCharge` has a `service_charge_uid` that references the
     * `uid` of a top-level `OrderReturnServiceCharge` applied to the return line item. On reads,
     * the applied amount is populated.
     * @return Returns the List of OrderLineItemAppliedServiceCharge
     */
    @JsonIgnore
    public List<OrderLineItemAppliedServiceCharge> getAppliedServiceCharges() {
        return OptionalNullable.getFrom(appliedServiceCharges);
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
        return Objects.hash(uid, sourceLineItemUid, name, quantity, quantityUnit, note,
                catalogObjectId, catalogVersion, variationName, itemType, returnModifiers,
                appliedTaxes, appliedDiscounts, basePriceMoney, variationTotalPriceMoney,
                grossReturnMoney, totalTaxMoney, totalDiscountMoney, totalMoney,
                appliedServiceCharges, totalServiceChargeMoney);
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
            && Objects.equals(catalogVersion, other.catalogVersion)
            && Objects.equals(variationName, other.variationName)
            && Objects.equals(itemType, other.itemType)
            && Objects.equals(returnModifiers, other.returnModifiers)
            && Objects.equals(appliedTaxes, other.appliedTaxes)
            && Objects.equals(appliedDiscounts, other.appliedDiscounts)
            && Objects.equals(basePriceMoney, other.basePriceMoney)
            && Objects.equals(variationTotalPriceMoney, other.variationTotalPriceMoney)
            && Objects.equals(grossReturnMoney, other.grossReturnMoney)
            && Objects.equals(totalTaxMoney, other.totalTaxMoney)
            && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(appliedServiceCharges, other.appliedServiceCharges)
            && Objects.equals(totalServiceChargeMoney, other.totalServiceChargeMoney);
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
                + ", catalogVersion=" + catalogVersion + ", variationName=" + variationName
                + ", itemType=" + itemType + ", returnModifiers=" + returnModifiers
                + ", appliedTaxes=" + appliedTaxes + ", appliedDiscounts=" + appliedDiscounts
                + ", basePriceMoney=" + basePriceMoney + ", variationTotalPriceMoney="
                + variationTotalPriceMoney + ", grossReturnMoney=" + grossReturnMoney
                + ", totalTaxMoney=" + totalTaxMoney + ", totalDiscountMoney=" + totalDiscountMoney
                + ", totalMoney=" + totalMoney + ", appliedServiceCharges=" + appliedServiceCharges
                + ", totalServiceChargeMoney=" + totalServiceChargeMoney + "]";
    }

    /**
     * Builds a new {@link OrderReturnLineItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnLineItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(quantity)
                .quantityUnit(getQuantityUnit())
                .itemType(getItemType())
                .basePriceMoney(getBasePriceMoney())
                .variationTotalPriceMoney(getVariationTotalPriceMoney())
                .grossReturnMoney(getGrossReturnMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .totalDiscountMoney(getTotalDiscountMoney())
                .totalMoney(getTotalMoney())
                .totalServiceChargeMoney(getTotalServiceChargeMoney());
        builder.uid = internalGetUid();
        builder.sourceLineItemUid = internalGetSourceLineItemUid();
        builder.name = internalGetName();
        builder.note = internalGetNote();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.variationName = internalGetVariationName();
        builder.returnModifiers = internalGetReturnModifiers();
        builder.appliedTaxes = internalGetAppliedTaxes();
        builder.appliedDiscounts = internalGetAppliedDiscounts();
        builder.appliedServiceCharges = internalGetAppliedServiceCharges();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnLineItem}.
     */
    public static class Builder {
        private String quantity;
        private OptionalNullable<String> uid;
        private OptionalNullable<String> sourceLineItemUid;
        private OptionalNullable<String> name;
        private OrderQuantityUnit quantityUnit;
        private OptionalNullable<String> note;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> variationName;
        private String itemType;
        private OptionalNullable<List<OrderReturnLineItemModifier>> returnModifiers;
        private OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes;
        private OptionalNullable<List<OrderLineItemAppliedDiscount>> appliedDiscounts;
        private Money basePriceMoney;
        private Money variationTotalPriceMoney;
        private Money grossReturnMoney;
        private Money totalTaxMoney;
        private Money totalDiscountMoney;
        private Money totalMoney;
        private OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges;
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
         * Setter for sourceLineItemUid.
         * @param  sourceLineItemUid  String value for sourceLineItemUid.
         * @return Builder
         */
        public Builder sourceLineItemUid(String sourceLineItemUid) {
            this.sourceLineItemUid = OptionalNullable.of(sourceLineItemUid);
            return this;
        }

        /**
         * UnSetter for sourceLineItemUid.
         * @return Builder
         */
        public Builder unsetSourceLineItemUid() {
            sourceLineItemUid = null;
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
         * Setter for returnModifiers.
         * @param  returnModifiers  List of OrderReturnLineItemModifier value for returnModifiers.
         * @return Builder
         */
        public Builder returnModifiers(List<OrderReturnLineItemModifier> returnModifiers) {
            this.returnModifiers = OptionalNullable.of(returnModifiers);
            return this;
        }

        /**
         * UnSetter for returnModifiers.
         * @return Builder
         */
        public Builder unsetReturnModifiers() {
            returnModifiers = null;
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
         * Setter for grossReturnMoney.
         * @param  grossReturnMoney  Money value for grossReturnMoney.
         * @return Builder
         */
        public Builder grossReturnMoney(Money grossReturnMoney) {
            this.grossReturnMoney = grossReturnMoney;
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
         * Setter for appliedServiceCharges.
         * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
         *         appliedServiceCharges.
         * @return Builder
         */
        public Builder appliedServiceCharges(
                List<OrderLineItemAppliedServiceCharge> appliedServiceCharges) {
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
         * Setter for totalServiceChargeMoney.
         * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
         * @return Builder
         */
        public Builder totalServiceChargeMoney(Money totalServiceChargeMoney) {
            this.totalServiceChargeMoney = totalServiceChargeMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnLineItem} object using the set fields.
         * @return {@link OrderReturnLineItem}
         */
        public OrderReturnLineItem build() {
            return new OrderReturnLineItem(quantity, uid, sourceLineItemUid, name, quantityUnit,
                    note, catalogObjectId, catalogVersion, variationName, itemType, returnModifiers,
                    appliedTaxes, appliedDiscounts, basePriceMoney, variationTotalPriceMoney,
                    grossReturnMoney, totalTaxMoney, totalDiscountMoney, totalMoney,
                    appliedServiceCharges, totalServiceChargeMoney);
        }
    }
}
