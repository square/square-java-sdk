package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Order {

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
            @JsonProperty("fulfillments") List<OrderFulfillment> fulfillments,
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
            @JsonProperty("total_service_charge_money") Money totalServiceChargeMoney) {
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
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

    private final String id;
    private final String locationId;
    private final String referenceId;
    private final OrderSource source;
    private final String customerId;
    private final List<OrderLineItem> lineItems;
    private final List<OrderLineItemTax> taxes;
    private final List<OrderLineItemDiscount> discounts;
    private final List<OrderServiceCharge> serviceCharges;
    private final List<OrderFulfillment> fulfillments;
    private final List<OrderReturn> returns;
    private final OrderMoneyAmounts returnAmounts;
    private final OrderMoneyAmounts netAmounts;
    private final OrderRoundingAdjustment roundingAdjustment;
    private final List<Tender> tenders;
    private final List<Refund> refunds;
    private final Map<String, String> metadata;
    private final String createdAt;
    private final String updatedAt;
    private final String closedAt;
    private final String state;
    private final Integer version;
    private final Money totalMoney;
    private final Money totalTaxMoney;
    private final Money totalDiscountMoney;
    private final Money totalServiceChargeMoney;

    @Override
    public int hashCode() {
        return Objects.hash(locationId, id, referenceId, source, customerId, lineItems, taxes, discounts, serviceCharges, fulfillments, returns, returnAmounts, netAmounts, roundingAdjustment, tenders, refunds, metadata, createdAt, updatedAt, closedAt, state, version, totalMoney, totalTaxMoney, totalDiscountMoney, totalServiceChargeMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(locationId, order.locationId) &&
            Objects.equals(id, order.id) &&
            Objects.equals(referenceId, order.referenceId) &&
            Objects.equals(source, order.source) &&
            Objects.equals(customerId, order.customerId) &&
            Objects.equals(lineItems, order.lineItems) &&
            Objects.equals(taxes, order.taxes) &&
            Objects.equals(discounts, order.discounts) &&
            Objects.equals(serviceCharges, order.serviceCharges) &&
            Objects.equals(fulfillments, order.fulfillments) &&
            Objects.equals(returns, order.returns) &&
            Objects.equals(returnAmounts, order.returnAmounts) &&
            Objects.equals(netAmounts, order.netAmounts) &&
            Objects.equals(roundingAdjustment, order.roundingAdjustment) &&
            Objects.equals(tenders, order.tenders) &&
            Objects.equals(refunds, order.refunds) &&
            Objects.equals(metadata, order.metadata) &&
            Objects.equals(createdAt, order.createdAt) &&
            Objects.equals(updatedAt, order.updatedAt) &&
            Objects.equals(closedAt, order.closedAt) &&
            Objects.equals(state, order.state) &&
            Objects.equals(version, order.version) &&
            Objects.equals(totalMoney, order.totalMoney) &&
            Objects.equals(totalTaxMoney, order.totalTaxMoney) &&
            Objects.equals(totalDiscountMoney, order.totalDiscountMoney) &&
            Objects.equals(totalServiceChargeMoney, order.totalServiceChargeMoney);
    }

    /**
     * Getter for Id.
     * The order's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for LocationId.
     * The ID of the merchant location this order is associated with.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for ReferenceId.
     * A client specified identifier to associate an entity in another system
     * with this order.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() { 
        return this.referenceId;
    }

    /**
     * Getter for Source.
     * Represents the origination details of an order.
     */
    @JsonGetter("source")
    public OrderSource getSource() { 
        return this.source;
    }

    /**
     * Getter for CustomerId.
     * The [Customer](#type-customer) ID of the customer associated with the order.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() { 
        return this.customerId;
    }

    /**
     * Getter for LineItems.
     * The line items included in the order.
     */
    @JsonGetter("line_items")
    public List<OrderLineItem> getLineItems() { 
        return this.lineItems;
    }

    /**
     * Getter for Taxes.
     * The list of all taxes associated with the order.
     * Taxes can be scoped to either `ORDER` or `LINE_ITEM`. For taxes with `LINE_ITEM` scope, an
     * `OrderLineItemAppliedTax` must be added to each line item that the tax applies to. For taxes
     * with `ORDER` scope, the server will generate an `OrderLineItemAppliedTax` for every line item.
     * On reads, each tax in the list will include the total amount of that tax applied to the order.
     * __IMPORTANT__: If `LINE_ITEM` scope is set on any taxes in this field, usage of the deprecated
     * `line_items.taxes` field will result in an error. Please use `line_items.applied_taxes`
     * instead.
     */
    @JsonGetter("taxes")
    public List<OrderLineItemTax> getTaxes() { 
        return this.taxes;
    }

    /**
     * Getter for Discounts.
     * The list of all discounts associated with the order.
     * Discounts can be scoped to either `ORDER` or `LINE_ITEM`. For discounts scoped to `LINE_ITEM`,
     * an `OrderLineItemAppliedDiscount` must be added to each line item that the discount applies to.
     * For discounts with `ORDER` scope, the server will generate an `OrderLineItemAppliedDiscount`
     * for every line item.
     * __IMPORTANT__: If `LINE_ITEM` scope is set on any discounts in this field, usage of the deprecated
     * `line_items.discounts` field will result in an error. Please use `line_items.applied_discounts`
     * instead.
     */
    @JsonGetter("discounts")
    public List<OrderLineItemDiscount> getDiscounts() { 
        return this.discounts;
    }

    /**
     * Getter for ServiceCharges.
     * A list of service charges applied to the order.
     */
    @JsonGetter("service_charges")
    public List<OrderServiceCharge> getServiceCharges() { 
        return this.serviceCharges;
    }

    /**
     * Getter for Fulfillments.
     * Details on order fulfillment.
     * Orders can only be created with at most one fulfillment. However, orders returned
     * by the API may contain multiple fulfillments.
     */
    @JsonGetter("fulfillments")
    public List<OrderFulfillment> getFulfillments() { 
        return this.fulfillments;
    }

    /**
     * Getter for Returns.
     * Collection of items from sale Orders being returned in this one. Normally part of an
     * Itemized Return or Exchange.  There will be exactly one `Return` object per sale Order being
     * referenced.
     */
    @JsonGetter("returns")
    public List<OrderReturn> getReturns() { 
        return this.returns;
    }

    /**
     * Getter for ReturnAmounts.
     * A collection of various money amounts.
     */
    @JsonGetter("return_amounts")
    public OrderMoneyAmounts getReturnAmounts() { 
        return this.returnAmounts;
    }

    /**
     * Getter for NetAmounts.
     * A collection of various money amounts.
     */
    @JsonGetter("net_amounts")
    public OrderMoneyAmounts getNetAmounts() { 
        return this.netAmounts;
    }

    /**
     * Getter for RoundingAdjustment.
     * A rounding adjustment of the money being returned. Commonly used to apply Cash Rounding
     * when the minimum unit of account is smaller than the lowest physical denomination of currency.
     */
    @JsonGetter("rounding_adjustment")
    public OrderRoundingAdjustment getRoundingAdjustment() { 
        return this.roundingAdjustment;
    }

    /**
     * Getter for Tenders.
     * The Tenders which were used to pay for the Order.
     */
    @JsonGetter("tenders")
    public List<Tender> getTenders() { 
        return this.tenders;
    }

    /**
     * Getter for Refunds.
     * The Refunds that are part of this Order.
     */
    @JsonGetter("refunds")
    public List<Refund> getRefunds() { 
        return this.refunds;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this order. Metadata fields are intended
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
     * Getter for CreatedAt.
     * Timestamp for when the order was created. In RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * Timestamp for when the order was last updated. In RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

    /**
     * Getter for ClosedAt.
     * Timestamp for when the order was closed. In RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("closed_at")
    public String getClosedAt() { 
        return this.closedAt;
    }

    /**
     * Getter for State.
     * The state of the order.
     */
    @JsonGetter("state")
    public String getState() { 
        return this.state;
    }

    /**
     * Getter for Version.
     * Version number which is incremented each time an update is committed to the order.
     * Orders that were not created through the API will not include a version and
     * thus cannot be updated.
     * [Read more about working with versions](https://developer.squareup.com/docs/orders-api/manage-orders#update-orders).
     */
    @JsonGetter("version")
    public Integer getVersion() { 
        return this.version;
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
     * Getter for TotalServiceChargeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_service_charge_money")
    public Money getTotalServiceChargeMoney() { 
        return this.totalServiceChargeMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
            .id(getId())
            .referenceId(getReferenceId())
            .source(getSource())
            .customerId(getCustomerId())
            .lineItems(getLineItems())
            .taxes(getTaxes())
            .discounts(getDiscounts())
            .serviceCharges(getServiceCharges())
            .fulfillments(getFulfillments())
            .returns(getReturns())
            .returnAmounts(getReturnAmounts())
            .netAmounts(getNetAmounts())
            .roundingAdjustment(getRoundingAdjustment())
            .tenders(getTenders())
            .refunds(getRefunds())
            .metadata(getMetadata())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .closedAt(getClosedAt())
            .state(getState())
            .version(getVersion())
            .totalMoney(getTotalMoney())
            .totalTaxMoney(getTotalTaxMoney())
            .totalDiscountMoney(getTotalDiscountMoney())
            .totalServiceChargeMoney(getTotalServiceChargeMoney());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private String id;
        private String referenceId;
        private OrderSource source;
        private String customerId;
        private List<OrderLineItem> lineItems;
        private List<OrderLineItemTax> taxes;
        private List<OrderLineItemDiscount> discounts;
        private List<OrderServiceCharge> serviceCharges;
        private List<OrderFulfillment> fulfillments;
        private List<OrderReturn> returns;
        private OrderMoneyAmounts returnAmounts;
        private OrderMoneyAmounts netAmounts;
        private OrderRoundingAdjustment roundingAdjustment;
        private List<Tender> tenders;
        private List<Refund> refunds;
        private Map<String, String> metadata;
        private String createdAt;
        private String updatedAt;
        private String closedAt;
        private String state;
        private Integer version;
        private Money totalMoney;
        private Money totalTaxMoney;
        private Money totalDiscountMoney;
        private Money totalServiceChargeMoney;

        public Builder(String locationId) {
            this.locationId = locationId;
        }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder referenceId(String value) {
            referenceId = value;
            return this;
        }
        public Builder source(OrderSource value) {
            source = value;
            return this;
        }
        public Builder customerId(String value) {
            customerId = value;
            return this;
        }
        public Builder lineItems(List<OrderLineItem> value) {
            lineItems = value;
            return this;
        }
        public Builder taxes(List<OrderLineItemTax> value) {
            taxes = value;
            return this;
        }
        public Builder discounts(List<OrderLineItemDiscount> value) {
            discounts = value;
            return this;
        }
        public Builder serviceCharges(List<OrderServiceCharge> value) {
            serviceCharges = value;
            return this;
        }
        public Builder fulfillments(List<OrderFulfillment> value) {
            fulfillments = value;
            return this;
        }
        public Builder returns(List<OrderReturn> value) {
            returns = value;
            return this;
        }
        public Builder returnAmounts(OrderMoneyAmounts value) {
            returnAmounts = value;
            return this;
        }
        public Builder netAmounts(OrderMoneyAmounts value) {
            netAmounts = value;
            return this;
        }
        public Builder roundingAdjustment(OrderRoundingAdjustment value) {
            roundingAdjustment = value;
            return this;
        }
        public Builder tenders(List<Tender> value) {
            tenders = value;
            return this;
        }
        public Builder refunds(List<Refund> value) {
            refunds = value;
            return this;
        }
        public Builder metadata(Map<String, String> value) {
            metadata = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }
        public Builder closedAt(String value) {
            closedAt = value;
            return this;
        }
        public Builder state(String value) {
            state = value;
            return this;
        }
        public Builder version(Integer value) {
            version = value;
            return this;
        }
        public Builder totalMoney(Money value) {
            totalMoney = value;
            return this;
        }
        public Builder totalTaxMoney(Money value) {
            totalTaxMoney = value;
            return this;
        }
        public Builder totalDiscountMoney(Money value) {
            totalDiscountMoney = value;
            return this;
        }
        public Builder totalServiceChargeMoney(Money value) {
            totalServiceChargeMoney = value;
            return this;
        }

        public Order build() {
            return new Order(locationId,
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
                totalServiceChargeMoney);
        }
    }
}
