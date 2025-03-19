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
 * This is a model class for Order type.
 */
public class Order {
    private final String id;
    private final String locationId;
    private final OptionalNullable<String> referenceId;
    private final OrderSource source;
    private final OptionalNullable<String> customerId;
    private final OptionalNullable<List<OrderLineItem>> lineItems;
    private final OptionalNullable<List<OrderLineItemTax>> taxes;
    private final OptionalNullable<List<OrderLineItemDiscount>> discounts;
    private final OptionalNullable<List<OrderServiceCharge>> serviceCharges;
    private final OptionalNullable<List<Fulfillment>> fulfillments;
    private final List<OrderReturn> returns;
    private final OrderMoneyAmounts returnAmounts;
    private final OrderMoneyAmounts netAmounts;
    private final OrderRoundingAdjustment roundingAdjustment;
    private final List<Tender> tenders;
    private final List<Refund> refunds;
    private final OptionalNullable<Map<String, String>> metadata;
    private final String createdAt;
    private final String updatedAt;
    private final String closedAt;
    private final String state;
    private final Integer version;
    private final Money totalMoney;
    private final Money totalTaxMoney;
    private final Money totalDiscountMoney;
    private final Money totalTipMoney;
    private final Money totalServiceChargeMoney;
    private final OptionalNullable<String> ticketName;
    private final OrderPricingOptions pricingOptions;
    private final List<OrderReward> rewards;
    private final Money netAmountDueMoney;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  source  OrderSource value for source.
     * @param  customerId  String value for customerId.
     * @param  lineItems  List of OrderLineItem value for lineItems.
     * @param  taxes  List of OrderLineItemTax value for taxes.
     * @param  discounts  List of OrderLineItemDiscount value for discounts.
     * @param  serviceCharges  List of OrderServiceCharge value for serviceCharges.
     * @param  fulfillments  List of Fulfillment value for fulfillments.
     * @param  returns  List of OrderReturn value for returns.
     * @param  returnAmounts  OrderMoneyAmounts value for returnAmounts.
     * @param  netAmounts  OrderMoneyAmounts value for netAmounts.
     * @param  roundingAdjustment  OrderRoundingAdjustment value for roundingAdjustment.
     * @param  tenders  List of Tender value for tenders.
     * @param  refunds  List of Refund value for refunds.
     * @param  metadata  Map of String, value for metadata.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  closedAt  String value for closedAt.
     * @param  state  String value for state.
     * @param  version  Integer value for version.
     * @param  totalMoney  Money value for totalMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalTipMoney  Money value for totalTipMoney.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
     * @param  ticketName  String value for ticketName.
     * @param  pricingOptions  OrderPricingOptions value for pricingOptions.
     * @param  rewards  List of OrderReward value for rewards.
     * @param  netAmountDueMoney  Money value for netAmountDueMoney.
     */
    @JsonCreator
    public Order(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("id") String id,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("source") OrderSource source,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("line_items") List<OrderLineItem> lineItems,
            @JsonProperty("taxes") List<OrderLineItemTax> taxes,
            @JsonProperty("discounts") List<OrderLineItemDiscount> discounts,
            @JsonProperty("service_charges") List<OrderServiceCharge> serviceCharges,
            @JsonProperty("fulfillments") List<Fulfillment> fulfillments,
            @JsonProperty("returns") List<OrderReturn> returns,
            @JsonProperty("return_amounts") OrderMoneyAmounts returnAmounts,
            @JsonProperty("net_amounts") OrderMoneyAmounts netAmounts,
            @JsonProperty("rounding_adjustment") OrderRoundingAdjustment roundingAdjustment,
            @JsonProperty("tenders") List<Tender> tenders,
            @JsonProperty("refunds") List<Refund> refunds,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("closed_at") String closedAt,
            @JsonProperty("state") String state,
            @JsonProperty("version") Integer version,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("total_discount_money") Money totalDiscountMoney,
            @JsonProperty("total_tip_money") Money totalTipMoney,
            @JsonProperty("total_service_charge_money") Money totalServiceChargeMoney,
            @JsonProperty("ticket_name") String ticketName,
            @JsonProperty("pricing_options") OrderPricingOptions pricingOptions,
            @JsonProperty("rewards") List<OrderReward> rewards,
            @JsonProperty("net_amount_due_money") Money netAmountDueMoney) {
        this.id = id;
        this.locationId = locationId;
        this.referenceId = OptionalNullable.of(referenceId);
        this.source = source;
        this.customerId = OptionalNullable.of(customerId);
        this.lineItems = OptionalNullable.of(lineItems);
        this.taxes = OptionalNullable.of(taxes);
        this.discounts = OptionalNullable.of(discounts);
        this.serviceCharges = OptionalNullable.of(serviceCharges);
        this.fulfillments = OptionalNullable.of(fulfillments);
        this.returns = returns;
        this.returnAmounts = returnAmounts;
        this.netAmounts = netAmounts;
        this.roundingAdjustment = roundingAdjustment;
        this.tenders = tenders;
        this.refunds = refunds;
        this.metadata = OptionalNullable.of(metadata);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.state = state;
        this.version = version;
        this.totalMoney = totalMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalTipMoney = totalTipMoney;
        this.totalServiceChargeMoney = totalServiceChargeMoney;
        this.ticketName = OptionalNullable.of(ticketName);
        this.pricingOptions = pricingOptions;
        this.rewards = rewards;
        this.netAmountDueMoney = netAmountDueMoney;
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  source  OrderSource value for source.
     * @param  customerId  String value for customerId.
     * @param  lineItems  List of OrderLineItem value for lineItems.
     * @param  taxes  List of OrderLineItemTax value for taxes.
     * @param  discounts  List of OrderLineItemDiscount value for discounts.
     * @param  serviceCharges  List of OrderServiceCharge value for serviceCharges.
     * @param  fulfillments  List of Fulfillment value for fulfillments.
     * @param  returns  List of OrderReturn value for returns.
     * @param  returnAmounts  OrderMoneyAmounts value for returnAmounts.
     * @param  netAmounts  OrderMoneyAmounts value for netAmounts.
     * @param  roundingAdjustment  OrderRoundingAdjustment value for roundingAdjustment.
     * @param  tenders  List of Tender value for tenders.
     * @param  refunds  List of Refund value for refunds.
     * @param  metadata  Map of String, value for metadata.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  closedAt  String value for closedAt.
     * @param  state  String value for state.
     * @param  version  Integer value for version.
     * @param  totalMoney  Money value for totalMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  totalDiscountMoney  Money value for totalDiscountMoney.
     * @param  totalTipMoney  Money value for totalTipMoney.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
     * @param  ticketName  String value for ticketName.
     * @param  pricingOptions  OrderPricingOptions value for pricingOptions.
     * @param  rewards  List of OrderReward value for rewards.
     * @param  netAmountDueMoney  Money value for netAmountDueMoney.
     */
    protected Order(
            String locationId,
            String id,
            OptionalNullable<String> referenceId,
            OrderSource source,
            OptionalNullable<String> customerId,
            OptionalNullable<List<OrderLineItem>> lineItems,
            OptionalNullable<List<OrderLineItemTax>> taxes,
            OptionalNullable<List<OrderLineItemDiscount>> discounts,
            OptionalNullable<List<OrderServiceCharge>> serviceCharges,
            OptionalNullable<List<Fulfillment>> fulfillments,
            List<OrderReturn> returns,
            OrderMoneyAmounts returnAmounts,
            OrderMoneyAmounts netAmounts,
            OrderRoundingAdjustment roundingAdjustment,
            List<Tender> tenders,
            List<Refund> refunds,
            OptionalNullable<Map<String, String>> metadata,
            String createdAt,
            String updatedAt,
            String closedAt,
            String state,
            Integer version,
            Money totalMoney,
            Money totalTaxMoney,
            Money totalDiscountMoney,
            Money totalTipMoney,
            Money totalServiceChargeMoney,
            OptionalNullable<String> ticketName,
            OrderPricingOptions pricingOptions,
            List<OrderReward> rewards,
            Money netAmountDueMoney) {
        this.id = id;
        this.locationId = locationId;
        this.referenceId = referenceId;
        this.source = source;
        this.customerId = customerId;
        this.lineItems = lineItems;
        this.taxes = taxes;
        this.discounts = discounts;
        this.serviceCharges = serviceCharges;
        this.fulfillments = fulfillments;
        this.returns = returns;
        this.returnAmounts = returnAmounts;
        this.netAmounts = netAmounts;
        this.roundingAdjustment = roundingAdjustment;
        this.tenders = tenders;
        this.refunds = refunds;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.state = state;
        this.version = version;
        this.totalMoney = totalMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalTipMoney = totalTipMoney;
        this.totalServiceChargeMoney = totalServiceChargeMoney;
        this.ticketName = ticketName;
        this.pricingOptions = pricingOptions;
        this.rewards = rewards;
        this.netAmountDueMoney = netAmountDueMoney;
    }

    /**
     * Getter for Id.
     * The order's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for LocationId.
     * The ID of the seller location that this order is associated with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Internal Getter for ReferenceId.
     * A client-specified ID to associate an entity in another system with this order.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID to associate an entity in another system with this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Getter for Source.
     * Represents the origination details of an order.
     * @return Returns the OrderSource
     */
    @JsonGetter("source")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderSource getSource() {
        return source;
    }

    /**
     * Internal Getter for CustomerId.
     * The ID of the [customer]($m/Customer) associated with the order. You should specify a
     * `customer_id` on the order (or the payment) to ensure that transactions are reliably linked
     * to customers. Omitting this field might result in the creation of new [instant
     * profiles](https://developer.squareup.com/docs/customers-api/what-it-does#instant-profiles).
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the [customer]($m/Customer) associated with the order. You should specify a
     * `customer_id` on the order (or the payment) to ensure that transactions are reliably linked
     * to customers. Omitting this field might result in the creation of new [instant
     * profiles](https://developer.squareup.com/docs/customers-api/what-it-does#instant-profiles).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Internal Getter for LineItems.
     * The line items included in the order.
     * @return Returns the Internal List of OrderLineItem
     */
    @JsonGetter("line_items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItem>> internalGetLineItems() {
        return this.lineItems;
    }

    /**
     * Getter for LineItems.
     * The line items included in the order.
     * @return Returns the List of OrderLineItem
     */
    @JsonIgnore
    public List<OrderLineItem> getLineItems() {
        return OptionalNullable.getFrom(lineItems);
    }

    /**
     * Internal Getter for Taxes.
     * The list of all taxes associated with the order. Taxes can be scoped to either `ORDER` or
     * `LINE_ITEM`. For taxes with `LINE_ITEM` scope, an `OrderLineItemAppliedTax` must be added to
     * each line item that the tax applies to. For taxes with `ORDER` scope, the server generates an
     * `OrderLineItemAppliedTax` for every line item. On reads, each tax in the list includes the
     * total amount of that tax applied to the order. __IMPORTANT__: If `LINE_ITEM` scope is set on
     * any taxes in this field, using the deprecated `line_items.taxes` field results in an error.
     * Use `line_items.applied_taxes` instead.
     * @return Returns the Internal List of OrderLineItemTax
     */
    @JsonGetter("taxes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemTax>> internalGetTaxes() {
        return this.taxes;
    }

    /**
     * Getter for Taxes.
     * The list of all taxes associated with the order. Taxes can be scoped to either `ORDER` or
     * `LINE_ITEM`. For taxes with `LINE_ITEM` scope, an `OrderLineItemAppliedTax` must be added to
     * each line item that the tax applies to. For taxes with `ORDER` scope, the server generates an
     * `OrderLineItemAppliedTax` for every line item. On reads, each tax in the list includes the
     * total amount of that tax applied to the order. __IMPORTANT__: If `LINE_ITEM` scope is set on
     * any taxes in this field, using the deprecated `line_items.taxes` field results in an error.
     * Use `line_items.applied_taxes` instead.
     * @return Returns the List of OrderLineItemTax
     */
    @JsonIgnore
    public List<OrderLineItemTax> getTaxes() {
        return OptionalNullable.getFrom(taxes);
    }

    /**
     * Internal Getter for Discounts.
     * The list of all discounts associated with the order. Discounts can be scoped to either
     * `ORDER` or `LINE_ITEM`. For discounts scoped to `LINE_ITEM`, an
     * `OrderLineItemAppliedDiscount` must be added to each line item that the discount applies to.
     * For discounts with `ORDER` scope, the server generates an `OrderLineItemAppliedDiscount` for
     * every line item. __IMPORTANT__: If `LINE_ITEM` scope is set on any discounts in this field,
     * using the deprecated `line_items.discounts` field results in an error. Use
     * `line_items.applied_discounts` instead.
     * @return Returns the Internal List of OrderLineItemDiscount
     */
    @JsonGetter("discounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderLineItemDiscount>> internalGetDiscounts() {
        return this.discounts;
    }

    /**
     * Getter for Discounts.
     * The list of all discounts associated with the order. Discounts can be scoped to either
     * `ORDER` or `LINE_ITEM`. For discounts scoped to `LINE_ITEM`, an
     * `OrderLineItemAppliedDiscount` must be added to each line item that the discount applies to.
     * For discounts with `ORDER` scope, the server generates an `OrderLineItemAppliedDiscount` for
     * every line item. __IMPORTANT__: If `LINE_ITEM` scope is set on any discounts in this field,
     * using the deprecated `line_items.discounts` field results in an error. Use
     * `line_items.applied_discounts` instead.
     * @return Returns the List of OrderLineItemDiscount
     */
    @JsonIgnore
    public List<OrderLineItemDiscount> getDiscounts() {
        return OptionalNullable.getFrom(discounts);
    }

    /**
     * Internal Getter for ServiceCharges.
     * A list of service charges applied to the order.
     * @return Returns the Internal List of OrderServiceCharge
     */
    @JsonGetter("service_charges")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<OrderServiceCharge>> internalGetServiceCharges() {
        return this.serviceCharges;
    }

    /**
     * Getter for ServiceCharges.
     * A list of service charges applied to the order.
     * @return Returns the List of OrderServiceCharge
     */
    @JsonIgnore
    public List<OrderServiceCharge> getServiceCharges() {
        return OptionalNullable.getFrom(serviceCharges);
    }

    /**
     * Internal Getter for Fulfillments.
     * Details about order fulfillment. Orders can only be created with at most one fulfillment.
     * However, orders returned by the API might contain multiple fulfillments.
     * @return Returns the Internal List of Fulfillment
     */
    @JsonGetter("fulfillments")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Fulfillment>> internalGetFulfillments() {
        return this.fulfillments;
    }

    /**
     * Getter for Fulfillments.
     * Details about order fulfillment. Orders can only be created with at most one fulfillment.
     * However, orders returned by the API might contain multiple fulfillments.
     * @return Returns the List of Fulfillment
     */
    @JsonIgnore
    public List<Fulfillment> getFulfillments() {
        return OptionalNullable.getFrom(fulfillments);
    }

    /**
     * Getter for Returns.
     * A collection of items from sale orders being returned in this one. Normally part of an
     * itemized return or exchange. There is exactly one `Return` object per sale `Order` being
     * referenced.
     * @return Returns the List of OrderReturn
     */
    @JsonGetter("returns")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<OrderReturn> getReturns() {
        return returns;
    }

    /**
     * Getter for ReturnAmounts.
     * A collection of various money amounts.
     * @return Returns the OrderMoneyAmounts
     */
    @JsonGetter("return_amounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderMoneyAmounts getReturnAmounts() {
        return returnAmounts;
    }

    /**
     * Getter for NetAmounts.
     * A collection of various money amounts.
     * @return Returns the OrderMoneyAmounts
     */
    @JsonGetter("net_amounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderMoneyAmounts getNetAmounts() {
        return netAmounts;
    }

    /**
     * Getter for RoundingAdjustment.
     * A rounding adjustment of the money being returned. Commonly used to apply cash rounding when
     * the minimum unit of the account is smaller than the lowest physical denomination of the
     * currency.
     * @return Returns the OrderRoundingAdjustment
     */
    @JsonGetter("rounding_adjustment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderRoundingAdjustment getRoundingAdjustment() {
        return roundingAdjustment;
    }

    /**
     * Getter for Tenders.
     * The tenders that were used to pay for the order.
     * @return Returns the List of Tender
     */
    @JsonGetter("tenders")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Tender> getTenders() {
        return tenders;
    }

    /**
     * Getter for Refunds.
     * The refunds that are part of this order.
     * @return Returns the List of Refund
     */
    @JsonGetter("refunds")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Refund> getRefunds() {
        return refunds;
    }

    /**
     * Internal Getter for Metadata.
     * Application-defined data attached to this order. Metadata fields are intended to store
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
     * Application-defined data attached to this order. Metadata fields are intended to store
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
     * Getter for CreatedAt.
     * The timestamp for when the order was created, at server side, in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp for when the order was last updated, at server side, in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for ClosedAt.
     * The timestamp for when the order reached a terminal [state](entity:OrderState), in RFC 3339
     * format (for example "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("closed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getClosedAt() {
        return closedAt;
    }

    /**
     * Getter for State.
     * The state of the order.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Getter for Version.
     * The version number, which is incremented each time an update is committed to the order.
     * Orders not created through the API do not include a version number and therefore cannot be
     * updated. [Read more about working with
     * versions](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders).
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
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
     * Getter for TotalTipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_tip_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalTipMoney() {
        return totalTipMoney;
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

    /**
     * Internal Getter for TicketName.
     * A short-term identifier for the order (such as a customer first name, table number, or
     * auto-generated order number that resets daily).
     * @return Returns the Internal String
     */
    @JsonGetter("ticket_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTicketName() {
        return this.ticketName;
    }

    /**
     * Getter for TicketName.
     * A short-term identifier for the order (such as a customer first name, table number, or
     * auto-generated order number that resets daily).
     * @return Returns the String
     */
    @JsonIgnore
    public String getTicketName() {
        return OptionalNullable.getFrom(ticketName);
    }

    /**
     * Getter for PricingOptions.
     * Pricing options for an order. The options affect how the order's price is calculated. They
     * can be used, for example, to apply automatic price adjustments that are based on
     * preconfigured [pricing rules]($m/CatalogPricingRule).
     * @return Returns the OrderPricingOptions
     */
    @JsonGetter("pricing_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderPricingOptions getPricingOptions() {
        return pricingOptions;
    }

    /**
     * Getter for Rewards.
     * A set-like list of Rewards that have been added to the Order.
     * @return Returns the List of OrderReward
     */
    @JsonGetter("rewards")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<OrderReward> getRewards() {
        return rewards;
    }

    /**
     * Getter for NetAmountDueMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("net_amount_due_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getNetAmountDueMoney() {
        return netAmountDueMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                locationId,
                referenceId,
                source,
                customerId,
                lineItems,
                taxes,
                discounts,
                serviceCharges,
                fulfillments,
                returns,
                returnAmounts,
                netAmounts,
                roundingAdjustment,
                tenders,
                refunds,
                metadata,
                createdAt,
                updatedAt,
                closedAt,
                state,
                version,
                totalMoney,
                totalTaxMoney,
                totalDiscountMoney,
                totalTipMoney,
                totalServiceChargeMoney,
                ticketName,
                pricingOptions,
                rewards,
                netAmountDueMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order other = (Order) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(locationId, other.locationId)
                && Objects.equals(referenceId, other.referenceId)
                && Objects.equals(source, other.source)
                && Objects.equals(customerId, other.customerId)
                && Objects.equals(lineItems, other.lineItems)
                && Objects.equals(taxes, other.taxes)
                && Objects.equals(discounts, other.discounts)
                && Objects.equals(serviceCharges, other.serviceCharges)
                && Objects.equals(fulfillments, other.fulfillments)
                && Objects.equals(returns, other.returns)
                && Objects.equals(returnAmounts, other.returnAmounts)
                && Objects.equals(netAmounts, other.netAmounts)
                && Objects.equals(roundingAdjustment, other.roundingAdjustment)
                && Objects.equals(tenders, other.tenders)
                && Objects.equals(refunds, other.refunds)
                && Objects.equals(metadata, other.metadata)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(closedAt, other.closedAt)
                && Objects.equals(state, other.state)
                && Objects.equals(version, other.version)
                && Objects.equals(totalMoney, other.totalMoney)
                && Objects.equals(totalTaxMoney, other.totalTaxMoney)
                && Objects.equals(totalDiscountMoney, other.totalDiscountMoney)
                && Objects.equals(totalTipMoney, other.totalTipMoney)
                && Objects.equals(totalServiceChargeMoney, other.totalServiceChargeMoney)
                && Objects.equals(ticketName, other.ticketName)
                && Objects.equals(pricingOptions, other.pricingOptions)
                && Objects.equals(rewards, other.rewards)
                && Objects.equals(netAmountDueMoney, other.netAmountDueMoney);
    }

    /**
     * Converts this Order into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Order [" + "locationId=" + locationId + ", id=" + id + ", referenceId="
                + referenceId + ", source=" + source + ", customerId=" + customerId + ", lineItems="
                + lineItems + ", taxes=" + taxes + ", discounts=" + discounts + ", serviceCharges="
                + serviceCharges + ", fulfillments=" + fulfillments + ", returns=" + returns
                + ", returnAmounts=" + returnAmounts + ", netAmounts=" + netAmounts
                + ", roundingAdjustment=" + roundingAdjustment + ", tenders=" + tenders
                + ", refunds=" + refunds + ", metadata=" + metadata + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + ", closedAt=" + closedAt + ", state=" + state
                + ", version=" + version + ", totalMoney=" + totalMoney + ", totalTaxMoney="
                + totalTaxMoney + ", totalDiscountMoney=" + totalDiscountMoney + ", totalTipMoney="
                + totalTipMoney + ", totalServiceChargeMoney=" + totalServiceChargeMoney
                + ", ticketName=" + ticketName + ", pricingOptions=" + pricingOptions + ", rewards="
                + rewards + ", netAmountDueMoney=" + netAmountDueMoney + "]";
    }

    /**
     * Builds a new {@link Order.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Order.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
                .id(getId())
                .source(getSource())
                .returns(getReturns())
                .returnAmounts(getReturnAmounts())
                .netAmounts(getNetAmounts())
                .roundingAdjustment(getRoundingAdjustment())
                .tenders(getTenders())
                .refunds(getRefunds())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .closedAt(getClosedAt())
                .state(getState())
                .version(getVersion())
                .totalMoney(getTotalMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .totalDiscountMoney(getTotalDiscountMoney())
                .totalTipMoney(getTotalTipMoney())
                .totalServiceChargeMoney(getTotalServiceChargeMoney())
                .pricingOptions(getPricingOptions())
                .rewards(getRewards())
                .netAmountDueMoney(getNetAmountDueMoney());
        builder.referenceId = internalGetReferenceId();
        builder.customerId = internalGetCustomerId();
        builder.lineItems = internalGetLineItems();
        builder.taxes = internalGetTaxes();
        builder.discounts = internalGetDiscounts();
        builder.serviceCharges = internalGetServiceCharges();
        builder.fulfillments = internalGetFulfillments();
        builder.metadata = internalGetMetadata();
        builder.ticketName = internalGetTicketName();
        return builder;
    }

    /**
     * Class to build instances of {@link Order}.
     */
    public static class Builder {
        private String locationId;
        private String id;
        private OptionalNullable<String> referenceId;
        private OrderSource source;
        private OptionalNullable<String> customerId;
        private OptionalNullable<List<OrderLineItem>> lineItems;
        private OptionalNullable<List<OrderLineItemTax>> taxes;
        private OptionalNullable<List<OrderLineItemDiscount>> discounts;
        private OptionalNullable<List<OrderServiceCharge>> serviceCharges;
        private OptionalNullable<List<Fulfillment>> fulfillments;
        private List<OrderReturn> returns;
        private OrderMoneyAmounts returnAmounts;
        private OrderMoneyAmounts netAmounts;
        private OrderRoundingAdjustment roundingAdjustment;
        private List<Tender> tenders;
        private List<Refund> refunds;
        private OptionalNullable<Map<String, String>> metadata;
        private String createdAt;
        private String updatedAt;
        private String closedAt;
        private String state;
        private Integer version;
        private Money totalMoney;
        private Money totalTaxMoney;
        private Money totalDiscountMoney;
        private Money totalTipMoney;
        private Money totalServiceChargeMoney;
        private OptionalNullable<String> ticketName;
        private OrderPricingOptions pricingOptions;
        private List<OrderReward> rewards;
        private Money netAmountDueMoney;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         */
        public Builder(String locationId) {
            this.locationId = locationId;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
            return this;
        }

        /**
         * Setter for source.
         * @param  source  OrderSource value for source.
         * @return Builder
         */
        public Builder source(OrderSource source) {
            this.source = source;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
            return this;
        }

        /**
         * Setter for lineItems.
         * @param  lineItems  List of OrderLineItem value for lineItems.
         * @return Builder
         */
        public Builder lineItems(List<OrderLineItem> lineItems) {
            this.lineItems = OptionalNullable.of(lineItems);
            return this;
        }

        /**
         * UnSetter for lineItems.
         * @return Builder
         */
        public Builder unsetLineItems() {
            lineItems = null;
            return this;
        }

        /**
         * Setter for taxes.
         * @param  taxes  List of OrderLineItemTax value for taxes.
         * @return Builder
         */
        public Builder taxes(List<OrderLineItemTax> taxes) {
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
         * @param  discounts  List of OrderLineItemDiscount value for discounts.
         * @return Builder
         */
        public Builder discounts(List<OrderLineItemDiscount> discounts) {
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
         * Setter for serviceCharges.
         * @param  serviceCharges  List of OrderServiceCharge value for serviceCharges.
         * @return Builder
         */
        public Builder serviceCharges(List<OrderServiceCharge> serviceCharges) {
            this.serviceCharges = OptionalNullable.of(serviceCharges);
            return this;
        }

        /**
         * UnSetter for serviceCharges.
         * @return Builder
         */
        public Builder unsetServiceCharges() {
            serviceCharges = null;
            return this;
        }

        /**
         * Setter for fulfillments.
         * @param  fulfillments  List of Fulfillment value for fulfillments.
         * @return Builder
         */
        public Builder fulfillments(List<Fulfillment> fulfillments) {
            this.fulfillments = OptionalNullable.of(fulfillments);
            return this;
        }

        /**
         * UnSetter for fulfillments.
         * @return Builder
         */
        public Builder unsetFulfillments() {
            fulfillments = null;
            return this;
        }

        /**
         * Setter for returns.
         * @param  returns  List of OrderReturn value for returns.
         * @return Builder
         */
        public Builder returns(List<OrderReturn> returns) {
            this.returns = returns;
            return this;
        }

        /**
         * Setter for returnAmounts.
         * @param  returnAmounts  OrderMoneyAmounts value for returnAmounts.
         * @return Builder
         */
        public Builder returnAmounts(OrderMoneyAmounts returnAmounts) {
            this.returnAmounts = returnAmounts;
            return this;
        }

        /**
         * Setter for netAmounts.
         * @param  netAmounts  OrderMoneyAmounts value for netAmounts.
         * @return Builder
         */
        public Builder netAmounts(OrderMoneyAmounts netAmounts) {
            this.netAmounts = netAmounts;
            return this;
        }

        /**
         * Setter for roundingAdjustment.
         * @param  roundingAdjustment  OrderRoundingAdjustment value for roundingAdjustment.
         * @return Builder
         */
        public Builder roundingAdjustment(OrderRoundingAdjustment roundingAdjustment) {
            this.roundingAdjustment = roundingAdjustment;
            return this;
        }

        /**
         * Setter for tenders.
         * @param  tenders  List of Tender value for tenders.
         * @return Builder
         */
        public Builder tenders(List<Tender> tenders) {
            this.tenders = tenders;
            return this;
        }

        /**
         * Setter for refunds.
         * @param  refunds  List of Refund value for refunds.
         * @return Builder
         */
        public Builder refunds(List<Refund> refunds) {
            this.refunds = refunds;
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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for closedAt.
         * @param  closedAt  String value for closedAt.
         * @return Builder
         */
        public Builder closedAt(String closedAt) {
            this.closedAt = closedAt;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Setter for totalTipMoney.
         * @param  totalTipMoney  Money value for totalTipMoney.
         * @return Builder
         */
        public Builder totalTipMoney(Money totalTipMoney) {
            this.totalTipMoney = totalTipMoney;
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
         * Setter for ticketName.
         * @param  ticketName  String value for ticketName.
         * @return Builder
         */
        public Builder ticketName(String ticketName) {
            this.ticketName = OptionalNullable.of(ticketName);
            return this;
        }

        /**
         * UnSetter for ticketName.
         * @return Builder
         */
        public Builder unsetTicketName() {
            ticketName = null;
            return this;
        }

        /**
         * Setter for pricingOptions.
         * @param  pricingOptions  OrderPricingOptions value for pricingOptions.
         * @return Builder
         */
        public Builder pricingOptions(OrderPricingOptions pricingOptions) {
            this.pricingOptions = pricingOptions;
            return this;
        }

        /**
         * Setter for rewards.
         * @param  rewards  List of OrderReward value for rewards.
         * @return Builder
         */
        public Builder rewards(List<OrderReward> rewards) {
            this.rewards = rewards;
            return this;
        }

        /**
         * Setter for netAmountDueMoney.
         * @param  netAmountDueMoney  Money value for netAmountDueMoney.
         * @return Builder
         */
        public Builder netAmountDueMoney(Money netAmountDueMoney) {
            this.netAmountDueMoney = netAmountDueMoney;
            return this;
        }

        /**
         * Builds a new {@link Order} object using the set fields.
         * @return {@link Order}
         */
        public Order build() {
            return new Order(
                    locationId,
                    id,
                    referenceId,
                    source,
                    customerId,
                    lineItems,
                    taxes,
                    discounts,
                    serviceCharges,
                    fulfillments,
                    returns,
                    returnAmounts,
                    netAmounts,
                    roundingAdjustment,
                    tenders,
                    refunds,
                    metadata,
                    createdAt,
                    updatedAt,
                    closedAt,
                    state,
                    version,
                    totalMoney,
                    totalTaxMoney,
                    totalDiscountMoney,
                    totalTipMoney,
                    totalServiceChargeMoney,
                    ticketName,
                    pricingOptions,
                    rewards,
                    netAmountDueMoney);
        }
    }
}
