package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderReturn {

    @JsonCreator
    public OrderReturn(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_order_id") String sourceOrderId,
            @JsonProperty("return_line_items") List<OrderReturnLineItem> returnLineItems,
            @JsonProperty("return_service_charges") List<OrderReturnServiceCharge> returnServiceCharges,
            @JsonProperty("return_taxes") List<OrderReturnTax> returnTaxes,
            @JsonProperty("return_discounts") List<OrderReturnDiscount> returnDiscounts,
            @JsonProperty("rounding_adjustment") OrderRoundingAdjustment roundingAdjustment,
            @JsonProperty("return_amounts") OrderMoneyAmounts returnAmounts) {
        this.uid = uid;
        this.sourceOrderId = sourceOrderId;
        this.returnLineItems = returnLineItems;
        this.returnServiceCharges = returnServiceCharges;
        this.returnTaxes = returnTaxes;
        this.returnDiscounts = returnDiscounts;
        this.roundingAdjustment = roundingAdjustment;
        this.returnAmounts = returnAmounts;
    }

    private final String uid;
    private final String sourceOrderId;
    private final List<OrderReturnLineItem> returnLineItems;
    private final List<OrderReturnServiceCharge> returnServiceCharges;
    private final List<OrderReturnTax> returnTaxes;
    private final List<OrderReturnDiscount> returnDiscounts;
    private final OrderRoundingAdjustment roundingAdjustment;
    private final OrderMoneyAmounts returnAmounts;

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceOrderId, returnLineItems, returnServiceCharges, returnTaxes, returnDiscounts, roundingAdjustment, returnAmounts);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderReturn)) {
            return false;
        }
        OrderReturn orderReturn = (OrderReturn) o;
        return Objects.equals(uid, orderReturn.uid) &&
            Objects.equals(sourceOrderId, orderReturn.sourceOrderId) &&
            Objects.equals(returnLineItems, orderReturn.returnLineItems) &&
            Objects.equals(returnServiceCharges, orderReturn.returnServiceCharges) &&
            Objects.equals(returnTaxes, orderReturn.returnTaxes) &&
            Objects.equals(returnDiscounts, orderReturn.returnDiscounts) &&
            Objects.equals(roundingAdjustment, orderReturn.roundingAdjustment) &&
            Objects.equals(returnAmounts, orderReturn.returnAmounts);
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the return only within this order.
     */
    @JsonGetter("uid")
    public String getUid() { 
        return this.uid;
    }

    /**
     * Getter for SourceOrderId.
     * Order which contains the original sale of these returned line items. This will be unset
     * for unlinked returns.
     */
    @JsonGetter("source_order_id")
    public String getSourceOrderId() { 
        return this.sourceOrderId;
    }

    /**
     * Getter for ReturnLineItems.
     * Collection of line items which are being returned.
     */
    @JsonGetter("return_line_items")
    public List<OrderReturnLineItem> getReturnLineItems() { 
        return this.returnLineItems;
    }

    /**
     * Getter for ReturnServiceCharges.
     * Collection of service charges which are being returned.
     */
    @JsonGetter("return_service_charges")
    public List<OrderReturnServiceCharge> getReturnServiceCharges() { 
        return this.returnServiceCharges;
    }

    /**
     * Getter for ReturnTaxes.
     * Collection of references to taxes being returned for an order, including the total
     * applied tax amount to be returned. The taxes must reference a top-level tax ID from the source
     * order.
     */
    @JsonGetter("return_taxes")
    public List<OrderReturnTax> getReturnTaxes() { 
        return this.returnTaxes;
    }

    /**
     * Getter for ReturnDiscounts.
     * Collection of references to discounts being returned for an order, including the total
     * applied discount amount to be returned. The discounts must reference a top-level discount ID
     * from the source order.
     */
    @JsonGetter("return_discounts")
    public List<OrderReturnDiscount> getReturnDiscounts() { 
        return this.returnDiscounts;
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
     * Getter for ReturnAmounts.
     * A collection of various money amounts.
     */
    @JsonGetter("return_amounts")
    public OrderMoneyAmounts getReturnAmounts() { 
        return this.returnAmounts;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .sourceOrderId(getSourceOrderId())
            .returnLineItems(getReturnLineItems())
            .returnServiceCharges(getReturnServiceCharges())
            .returnTaxes(getReturnTaxes())
            .returnDiscounts(getReturnDiscounts())
            .roundingAdjustment(getRoundingAdjustment())
            .returnAmounts(getReturnAmounts());
            return builder;
    }

    public static class Builder {
        private String uid;
        private String sourceOrderId;
        private List<OrderReturnLineItem> returnLineItems;
        private List<OrderReturnServiceCharge> returnServiceCharges;
        private List<OrderReturnTax> returnTaxes;
        private List<OrderReturnDiscount> returnDiscounts;
        private OrderRoundingAdjustment roundingAdjustment;
        private OrderMoneyAmounts returnAmounts;

        public Builder() { }

        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder sourceOrderId(String value) {
            sourceOrderId = value;
            return this;
        }
        public Builder returnLineItems(List<OrderReturnLineItem> value) {
            returnLineItems = value;
            return this;
        }
        public Builder returnServiceCharges(List<OrderReturnServiceCharge> value) {
            returnServiceCharges = value;
            return this;
        }
        public Builder returnTaxes(List<OrderReturnTax> value) {
            returnTaxes = value;
            return this;
        }
        public Builder returnDiscounts(List<OrderReturnDiscount> value) {
            returnDiscounts = value;
            return this;
        }
        public Builder roundingAdjustment(OrderRoundingAdjustment value) {
            roundingAdjustment = value;
            return this;
        }
        public Builder returnAmounts(OrderMoneyAmounts value) {
            returnAmounts = value;
            return this;
        }

        public OrderReturn build() {
            return new OrderReturn(uid,
                sourceOrderId,
                returnLineItems,
                returnServiceCharges,
                returnTaxes,
                returnDiscounts,
                roundingAdjustment,
                returnAmounts);
        }
    }
}
