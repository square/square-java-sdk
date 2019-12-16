package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderReturnServiceCharge {

    @JsonCreator
    public OrderReturnServiceCharge(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_service_charge_uid") String sourceServiceChargeUid,
            @JsonProperty("name") String name,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("calculation_phase") String calculationPhase,
            @JsonProperty("taxable") Boolean taxable,
            @JsonProperty("return_taxes") List<OrderReturnTax> returnTaxes,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes) {
        this.uid = uid;
        this.sourceServiceChargeUid = sourceServiceChargeUid;
        this.name = name;
        this.catalogObjectId = catalogObjectId;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.totalMoney = totalMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.calculationPhase = calculationPhase;
        this.taxable = taxable;
        this.returnTaxes = returnTaxes;
        this.appliedTaxes = appliedTaxes;
    }

    private final String uid;
    private final String sourceServiceChargeUid;
    private final String name;
    private final String catalogObjectId;
    private final String percentage;
    private final Money amountMoney;
    private final Money appliedMoney;
    private final Money totalMoney;
    private final Money totalTaxMoney;
    private final String calculationPhase;
    private final Boolean taxable;
    private final List<OrderReturnTax> returnTaxes;
    private final List<OrderLineItemAppliedTax> appliedTaxes;

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceServiceChargeUid, name, catalogObjectId, percentage, amountMoney, appliedMoney, totalMoney, totalTaxMoney, calculationPhase, taxable, returnTaxes, appliedTaxes);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderReturnServiceCharge)) {
            return false;
        }
        OrderReturnServiceCharge orderReturnServiceCharge = (OrderReturnServiceCharge) o;
        return Objects.equals(uid, orderReturnServiceCharge.uid) &&
            Objects.equals(sourceServiceChargeUid, orderReturnServiceCharge.sourceServiceChargeUid) &&
            Objects.equals(name, orderReturnServiceCharge.name) &&
            Objects.equals(catalogObjectId, orderReturnServiceCharge.catalogObjectId) &&
            Objects.equals(percentage, orderReturnServiceCharge.percentage) &&
            Objects.equals(amountMoney, orderReturnServiceCharge.amountMoney) &&
            Objects.equals(appliedMoney, orderReturnServiceCharge.appliedMoney) &&
            Objects.equals(totalMoney, orderReturnServiceCharge.totalMoney) &&
            Objects.equals(totalTaxMoney, orderReturnServiceCharge.totalTaxMoney) &&
            Objects.equals(calculationPhase, orderReturnServiceCharge.calculationPhase) &&
            Objects.equals(taxable, orderReturnServiceCharge.taxable) &&
            Objects.equals(returnTaxes, orderReturnServiceCharge.returnTaxes) &&
            Objects.equals(appliedTaxes, orderReturnServiceCharge.appliedTaxes);
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the return service charge only within this order.
     */
    @JsonGetter("uid")
    public String getUid() { 
        return this.uid;
    }

    /**
     * Getter for SourceServiceChargeUid.
     * `uid` of the Service Charge from the Order containing the original
     * charge of the service charge. `source_service_charge_uid` is `null` for
     * unlinked returns.
     */
    @JsonGetter("source_service_charge_uid")
    public String getSourceServiceChargeUid() { 
        return this.sourceServiceChargeUid;
    }

    /**
     * Getter for Name.
     * The name of the service charge.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID of the associated [CatalogServiceCharge](#type-catalogservicecharge).
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() { 
        return this.catalogObjectId;
    }

    /**
     * Getter for Percentage.
     * The percentage of the service charge, as a string representation of
     * a decimal number. For example, a value of `"7.25"` corresponds to a
     * percentage of 7.25%.
     * Exactly one of `percentage` or `amount_money` should be set.
     */
    @JsonGetter("percentage")
    public String getPercentage() { 
        return this.percentage;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() { 
        return this.amountMoney;
    }

    /**
     * Getter for AppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("applied_money")
    public Money getAppliedMoney() { 
        return this.appliedMoney;
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
     * Getter for CalculationPhase.
     * Represents a phase in the process of calculating order totals.
     * Service charges are applied __after__ the indicated phase.
     * [Read more about how order totals are calculated.](https://developer.squareup.com/docs/docs/orders-api/how-it-works#how-totals-are-calculated)
     */
    @JsonGetter("calculation_phase")
    public String getCalculationPhase() { 
        return this.calculationPhase;
    }

    /**
     * Getter for Taxable.
     * Indicates whether the surcharge can be taxed. Service charges
     * calculated in the `TOTAL_PHASE` cannot be marked as taxable.
     */
    @JsonGetter("taxable")
    public Boolean getTaxable() { 
        return this.taxable;
    }

    /**
     * Getter for ReturnTaxes.
     * Taxes applied to the `OrderReturnServiceCharge`. By default, return-level taxes apply to
     * `OrderReturnServiceCharge`s calculated in the `SUBTOTAL_PHASE` if `taxable` is set to `true`.  On
     * read or retrieve, this list includes both item-level taxes and any return-level taxes
     * apportioned to this item.
     * This field has been deprecated in favour of `applied_taxes`.
     */
    @JsonGetter("return_taxes")
    public List<OrderReturnTax> getReturnTaxes() { 
        return this.returnTaxes;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to `OrderReturnTax` entities applied to the
     * `OrderReturnServiceCharge`. Each `OrderLineItemAppliedTax` has a `tax_uid`
     * that references the `uid` of a top-level `OrderReturnTax` that is being
     * applied to the `OrderReturnServiceCharge`. On reads, the amount applied is
     * populated.
     */
    @JsonGetter("applied_taxes")
    public List<OrderLineItemAppliedTax> getAppliedTaxes() { 
        return this.appliedTaxes;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .sourceServiceChargeUid(getSourceServiceChargeUid())
            .name(getName())
            .catalogObjectId(getCatalogObjectId())
            .percentage(getPercentage())
            .amountMoney(getAmountMoney())
            .appliedMoney(getAppliedMoney())
            .totalMoney(getTotalMoney())
            .totalTaxMoney(getTotalTaxMoney())
            .calculationPhase(getCalculationPhase())
            .taxable(getTaxable())
            .returnTaxes(getReturnTaxes())
            .appliedTaxes(getAppliedTaxes());
            return builder;
    }

    public static class Builder {
        private String uid;
        private String sourceServiceChargeUid;
        private String name;
        private String catalogObjectId;
        private String percentage;
        private Money amountMoney;
        private Money appliedMoney;
        private Money totalMoney;
        private Money totalTaxMoney;
        private String calculationPhase;
        private Boolean taxable;
        private List<OrderReturnTax> returnTaxes;
        private List<OrderLineItemAppliedTax> appliedTaxes;

        public Builder() { }

        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder sourceServiceChargeUid(String value) {
            sourceServiceChargeUid = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder percentage(String value) {
            percentage = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder appliedMoney(Money value) {
            appliedMoney = value;
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
        public Builder calculationPhase(String value) {
            calculationPhase = value;
            return this;
        }
        public Builder taxable(Boolean value) {
            taxable = value;
            return this;
        }
        public Builder returnTaxes(List<OrderReturnTax> value) {
            returnTaxes = value;
            return this;
        }
        public Builder appliedTaxes(List<OrderLineItemAppliedTax> value) {
            appliedTaxes = value;
            return this;
        }

        public OrderReturnServiceCharge build() {
            return new OrderReturnServiceCharge(uid,
                sourceServiceChargeUid,
                name,
                catalogObjectId,
                percentage,
                amountMoney,
                appliedMoney,
                totalMoney,
                totalTaxMoney,
                calculationPhase,
                taxable,
                returnTaxes,
                appliedTaxes);
        }
    }
}
