package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderReturnServiceCharge type.
 */
public class OrderReturnServiceCharge {

    /**
     * Initialization constructor.
     * @param uid
     * @param sourceServiceChargeUid
     * @param name
     * @param catalogObjectId
     * @param percentage
     * @param amountMoney
     * @param appliedMoney
     * @param totalMoney
     * @param totalTaxMoney
     * @param calculationPhase
     * @param taxable
     * @param appliedTaxes
     */
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
    private final List<OrderLineItemAppliedTax> appliedTaxes;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceServiceChargeUid, name, catalogObjectId, percentage,
            amountMoney, appliedMoney, totalMoney, totalTaxMoney, calculationPhase, taxable,
            appliedTaxes);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderReturnServiceCharge)) {
            return false;
        }
        OrderReturnServiceCharge orderReturnServiceCharge = (OrderReturnServiceCharge) obj;
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
            Objects.equals(appliedTaxes, orderReturnServiceCharge.appliedTaxes);
    }

    /**
     * Builds a new {@link OrderReturnServiceCharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnServiceCharge.Builder} object
     */
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
            .appliedTaxes(getAppliedTaxes());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnServiceCharge}
     */
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
        private List<OrderLineItemAppliedTax> appliedTaxes;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for sourceServiceChargeUid
         * @param sourceServiceChargeUid
         * @return Builder
         */
        public Builder sourceServiceChargeUid(String sourceServiceChargeUid) {
            this.sourceServiceChargeUid = sourceServiceChargeUid;
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
         * Setter for catalogObjectId
         * @param catalogObjectId
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }
        /**
         * Setter for percentage
         * @param percentage
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }
        /**
         * Setter for appliedMoney
         * @param appliedMoney
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
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
         * Setter for totalTaxMoney
         * @param totalTaxMoney
         * @return Builder
         */
        public Builder totalTaxMoney(Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }
        /**
         * Setter for calculationPhase
         * @param calculationPhase
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
            return this;
        }
        /**
         * Setter for taxable
         * @param taxable
         * @return Builder
         */
        public Builder taxable(Boolean taxable) {
            this.taxable = taxable;
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
         * Builds a new {@link OrderReturnServiceCharge} object using the set fields.
         * @return {@link OrderReturnServiceCharge}
         */
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
                appliedTaxes);
        }
    }
}
