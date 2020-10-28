
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for OrderReturnServiceCharge type.
 */
public class OrderReturnServiceCharge {
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
     * Initialization constructor.
     * @param uid String value for uid.
     * @param sourceServiceChargeUid String value for sourceServiceChargeUid.
     * @param name String value for name.
     * @param catalogObjectId String value for catalogObjectId.
     * @param percentage String value for percentage.
     * @param amountMoney Money value for amountMoney.
     * @param appliedMoney Money value for appliedMoney.
     * @param totalMoney Money value for totalMoney.
     * @param totalTaxMoney Money value for totalTaxMoney.
     * @param calculationPhase String value for calculationPhase.
     * @param taxable Boolean value for taxable.
     * @param appliedTaxes List of OrderLineItemAppliedTax value for appliedTaxes.
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

    /**
     * Getter for Uid.
     * Unique ID that identifies the return service charge only within this order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for SourceServiceChargeUid.
     * `uid` of the Service Charge from the Order containing the original charge of the service
     * charge. `source_service_charge_uid` is `null` for unlinked returns.
     * @return Returns the String
     */
    @JsonGetter("source_service_charge_uid")
    public String getSourceServiceChargeUid() {
        return this.sourceServiceChargeUid;
    }

    /**
     * Getter for Name.
     * The name of the service charge.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID of the associated [CatalogServiceCharge](#type-catalogservicecharge).
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Percentage.
     * The percentage of the service charge, as a string representation of a decimal number. For
     * example, a value of `"7.25"` corresponds to a percentage of 7.25%. Exactly one of
     * `percentage` or `amount_money` should be set.
     * @return Returns the String
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return this.percentage;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return this.amountMoney;
    }

    /**
     * Getter for AppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("applied_money")
    public Money getAppliedMoney() {
        return this.appliedMoney;
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
     * Getter for CalculationPhase.
     * Represents a phase in the process of calculating order totals. Service charges are applied
     * __after__ the indicated phase. [Read more about how order totals are
     * calculated.](https://developer.squareup.com/docs/docs/orders-api/how-it-works#how-totals-are-calculated)
     * @return Returns the String
     */
    @JsonGetter("calculation_phase")
    public String getCalculationPhase() {
        return this.calculationPhase;
    }

    /**
     * Getter for Taxable.
     * Indicates whether the surcharge can be taxed. Service charges calculated in the `TOTAL_PHASE`
     * cannot be marked as taxable.
     * @return Returns the Boolean
     */
    @JsonGetter("taxable")
    public Boolean getTaxable() {
        return this.taxable;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to `OrderReturnTax` entities applied to the
     * `OrderReturnServiceCharge`. Each `OrderLineItemAppliedTax` has a `tax_uid` that references
     * the `uid` of a top-level `OrderReturnTax` that is being applied to the
     * `OrderReturnServiceCharge`. On reads, the amount applied is populated.
     * @return Returns the List of OrderLineItemAppliedTax
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderReturnServiceCharge)) {
            return false;
        }
        OrderReturnServiceCharge other = (OrderReturnServiceCharge) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(sourceServiceChargeUid, other.sourceServiceChargeUid)
            && Objects.equals(name, other.name)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(percentage, other.percentage)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(totalTaxMoney, other.totalTaxMoney)
            && Objects.equals(calculationPhase, other.calculationPhase)
            && Objects.equals(taxable, other.taxable)
            && Objects.equals(appliedTaxes, other.appliedTaxes);
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
     * Class to build instances of {@link OrderReturnServiceCharge}.
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
         * Setter for uid.
         * @param uid String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for sourceServiceChargeUid.
         * @param sourceServiceChargeUid String value for sourceServiceChargeUid.
         * @return Builder
         */
        public Builder sourceServiceChargeUid(String sourceServiceChargeUid) {
            this.sourceServiceChargeUid = sourceServiceChargeUid;
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
         * Setter for catalogObjectId.
         * @param catalogObjectId String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for percentage.
         * @param percentage String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param amountMoney Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for appliedMoney.
         * @param appliedMoney Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
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
         * Setter for totalTaxMoney.
         * @param totalTaxMoney Money value for totalTaxMoney.
         * @return Builder
         */
        public Builder totalTaxMoney(Money totalTaxMoney) {
            this.totalTaxMoney = totalTaxMoney;
            return this;
        }

        /**
         * Setter for calculationPhase.
         * @param calculationPhase String value for calculationPhase.
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
            return this;
        }

        /**
         * Setter for taxable.
         * @param taxable Boolean value for taxable.
         * @return Builder
         */
        public Builder taxable(Boolean taxable) {
            this.taxable = taxable;
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
