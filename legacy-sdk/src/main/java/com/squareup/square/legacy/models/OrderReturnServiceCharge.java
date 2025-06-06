package com.squareup.square.legacy.models;

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
 * This is a model class for OrderReturnServiceCharge type.
 */
public class OrderReturnServiceCharge {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> sourceServiceChargeUid;
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> percentage;
    private final Money amountMoney;
    private final Money appliedMoney;
    private final Money totalMoney;
    private final Money totalTaxMoney;
    private final String calculationPhase;
    private final OptionalNullable<Boolean> taxable;
    private final OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes;
    private final String treatmentType;
    private final String scope;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  sourceServiceChargeUid  String value for sourceServiceChargeUid.
     * @param  name  String value for name.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  percentage  String value for percentage.
     * @param  amountMoney  Money value for amountMoney.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  calculationPhase  String value for calculationPhase.
     * @param  taxable  Boolean value for taxable.
     * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param  treatmentType  String value for treatmentType.
     * @param  scope  String value for scope.
     */
    @JsonCreator
    public OrderReturnServiceCharge(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_service_charge_uid") String sourceServiceChargeUid,
            @JsonProperty("name") String name,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("calculation_phase") String calculationPhase,
            @JsonProperty("taxable") Boolean taxable,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes,
            @JsonProperty("treatment_type") String treatmentType,
            @JsonProperty("scope") String scope) {
        this.uid = OptionalNullable.of(uid);
        this.sourceServiceChargeUid = OptionalNullable.of(sourceServiceChargeUid);
        this.name = OptionalNullable.of(name);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.percentage = OptionalNullable.of(percentage);
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.totalMoney = totalMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.calculationPhase = calculationPhase;
        this.taxable = OptionalNullable.of(taxable);
        this.appliedTaxes = OptionalNullable.of(appliedTaxes);
        this.treatmentType = treatmentType;
        this.scope = scope;
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  sourceServiceChargeUid  String value for sourceServiceChargeUid.
     * @param  name  String value for name.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  percentage  String value for percentage.
     * @param  amountMoney  Money value for amountMoney.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  totalMoney  Money value for totalMoney.
     * @param  totalTaxMoney  Money value for totalTaxMoney.
     * @param  calculationPhase  String value for calculationPhase.
     * @param  taxable  Boolean value for taxable.
     * @param  appliedTaxes  List of OrderLineItemAppliedTax value for appliedTaxes.
     * @param  treatmentType  String value for treatmentType.
     * @param  scope  String value for scope.
     */
    protected OrderReturnServiceCharge(
            OptionalNullable<String> uid,
            OptionalNullable<String> sourceServiceChargeUid,
            OptionalNullable<String> name,
            OptionalNullable<String> catalogObjectId,
            OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> percentage,
            Money amountMoney,
            Money appliedMoney,
            Money totalMoney,
            Money totalTaxMoney,
            String calculationPhase,
            OptionalNullable<Boolean> taxable,
            OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes,
            String treatmentType,
            String scope) {
        this.uid = uid;
        this.sourceServiceChargeUid = sourceServiceChargeUid;
        this.name = name;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.totalMoney = totalMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.calculationPhase = calculationPhase;
        this.taxable = taxable;
        this.appliedTaxes = appliedTaxes;
        this.treatmentType = treatmentType;
        this.scope = scope;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the return service charge only within this order.
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
     * A unique ID that identifies the return service charge only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for SourceServiceChargeUid.
     * The service charge `uid` from the order containing the original service charge.
     * `source_service_charge_uid` is `null` for unlinked returns.
     * @return Returns the Internal String
     */
    @JsonGetter("source_service_charge_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceServiceChargeUid() {
        return this.sourceServiceChargeUid;
    }

    /**
     * Getter for SourceServiceChargeUid.
     * The service charge `uid` from the order containing the original service charge.
     * `source_service_charge_uid` is `null` for unlinked returns.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceServiceChargeUid() {
        return OptionalNullable.getFrom(sourceServiceChargeUid);
    }

    /**
     * Internal Getter for Name.
     * The name of the service charge.
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
     * The name of the service charge.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The catalog object ID of the associated [OrderServiceCharge](entity:OrderServiceCharge).
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
     * The catalog object ID of the associated [OrderServiceCharge](entity:OrderServiceCharge).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this service charge references.
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
     * The version of the catalog object that this service charge references.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for Percentage.
     * The percentage of the service charge, as a string representation of a decimal number. For
     * example, a value of `"7.25"` corresponds to a percentage of 7.25%. Either `percentage` or
     * `amount_money` should be set, but not both.
     * @return Returns the Internal String
     */
    @JsonGetter("percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPercentage() {
        return this.percentage;
    }

    /**
     * Getter for Percentage.
     * The percentage of the service charge, as a string representation of a decimal number. For
     * example, a value of `"7.25"` corresponds to a percentage of 7.25%. Either `percentage` or
     * `amount_money` should be set, but not both.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentage() {
        return OptionalNullable.getFrom(percentage);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppliedMoney() {
        return appliedMoney;
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
     * Getter for CalculationPhase.
     * Represents a phase in the process of calculating order totals. Service charges are applied
     * after the indicated phase. [Read more about how order totals are
     * calculated.](https://developer.squareup.com/docs/orders-api/how-it-works#how-totals-are-calculated)
     * @return Returns the String
     */
    @JsonGetter("calculation_phase")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCalculationPhase() {
        return calculationPhase;
    }

    /**
     * Internal Getter for Taxable.
     * Indicates whether the surcharge can be taxed. Service charges calculated in the `TOTAL_PHASE`
     * cannot be marked as taxable.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("taxable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetTaxable() {
        return this.taxable;
    }

    /**
     * Getter for Taxable.
     * Indicates whether the surcharge can be taxed. Service charges calculated in the `TOTAL_PHASE`
     * cannot be marked as taxable.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getTaxable() {
        return OptionalNullable.getFrom(taxable);
    }

    /**
     * Internal Getter for AppliedTaxes.
     * The list of references to `OrderReturnTax` entities applied to the
     * `OrderReturnServiceCharge`. Each `OrderLineItemAppliedTax` has a `tax_uid` that references
     * the `uid` of a top-level `OrderReturnTax` that is being applied to the
     * `OrderReturnServiceCharge`. On reads, the applied amount is populated.
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
     * The list of references to `OrderReturnTax` entities applied to the
     * `OrderReturnServiceCharge`. Each `OrderLineItemAppliedTax` has a `tax_uid` that references
     * the `uid` of a top-level `OrderReturnTax` that is being applied to the
     * `OrderReturnServiceCharge`. On reads, the applied amount is populated.
     * @return Returns the List of OrderLineItemAppliedTax
     */
    @JsonIgnore
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return OptionalNullable.getFrom(appliedTaxes);
    }

    /**
     * Getter for TreatmentType.
     * Indicates whether the service charge will be treated as a value-holding line item or
     * apportioned toward a line item.
     * @return Returns the String
     */
    @JsonGetter("treatment_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTreatmentType() {
        return treatmentType;
    }

    /**
     * Getter for Scope.
     * Indicates whether this is a line-item or order-level apportioned service charge.
     * @return Returns the String
     */
    @JsonGetter("scope")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScope() {
        return scope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                uid,
                sourceServiceChargeUid,
                name,
                catalogObjectId,
                catalogVersion,
                percentage,
                amountMoney,
                appliedMoney,
                totalMoney,
                totalTaxMoney,
                calculationPhase,
                taxable,
                appliedTaxes,
                treatmentType,
                scope);
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
                && Objects.equals(catalogVersion, other.catalogVersion)
                && Objects.equals(percentage, other.percentage)
                && Objects.equals(amountMoney, other.amountMoney)
                && Objects.equals(appliedMoney, other.appliedMoney)
                && Objects.equals(totalMoney, other.totalMoney)
                && Objects.equals(totalTaxMoney, other.totalTaxMoney)
                && Objects.equals(calculationPhase, other.calculationPhase)
                && Objects.equals(taxable, other.taxable)
                && Objects.equals(appliedTaxes, other.appliedTaxes)
                && Objects.equals(treatmentType, other.treatmentType)
                && Objects.equals(scope, other.scope);
    }

    /**
     * Converts this OrderReturnServiceCharge into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderReturnServiceCharge [" + "uid=" + uid + ", sourceServiceChargeUid="
                + sourceServiceChargeUid + ", name=" + name + ", catalogObjectId=" + catalogObjectId
                + ", catalogVersion=" + catalogVersion + ", percentage=" + percentage
                + ", amountMoney=" + amountMoney + ", appliedMoney=" + appliedMoney
                + ", totalMoney=" + totalMoney + ", totalTaxMoney=" + totalTaxMoney
                + ", calculationPhase=" + calculationPhase + ", taxable=" + taxable
                + ", appliedTaxes=" + appliedTaxes + ", treatmentType=" + treatmentType + ", scope="
                + scope + "]";
    }

    /**
     * Builds a new {@link OrderReturnServiceCharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnServiceCharge.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .amountMoney(getAmountMoney())
                .appliedMoney(getAppliedMoney())
                .totalMoney(getTotalMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .calculationPhase(getCalculationPhase())
                .treatmentType(getTreatmentType())
                .scope(getScope());
        builder.uid = internalGetUid();
        builder.sourceServiceChargeUid = internalGetSourceServiceChargeUid();
        builder.name = internalGetName();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.percentage = internalGetPercentage();
        builder.taxable = internalGetTaxable();
        builder.appliedTaxes = internalGetAppliedTaxes();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnServiceCharge}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> sourceServiceChargeUid;
        private OptionalNullable<String> name;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> percentage;
        private Money amountMoney;
        private Money appliedMoney;
        private Money totalMoney;
        private Money totalTaxMoney;
        private String calculationPhase;
        private OptionalNullable<Boolean> taxable;
        private OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes;
        private String treatmentType;
        private String scope;

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
         * Setter for sourceServiceChargeUid.
         * @param  sourceServiceChargeUid  String value for sourceServiceChargeUid.
         * @return Builder
         */
        public Builder sourceServiceChargeUid(String sourceServiceChargeUid) {
            this.sourceServiceChargeUid = OptionalNullable.of(sourceServiceChargeUid);
            return this;
        }

        /**
         * UnSetter for sourceServiceChargeUid.
         * @return Builder
         */
        public Builder unsetSourceServiceChargeUid() {
            sourceServiceChargeUid = null;
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
         * Setter for percentage.
         * @param  percentage  String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = OptionalNullable.of(percentage);
            return this;
        }

        /**
         * UnSetter for percentage.
         * @return Builder
         */
        public Builder unsetPercentage() {
            percentage = null;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for appliedMoney.
         * @param  appliedMoney  Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
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
         * Setter for calculationPhase.
         * @param  calculationPhase  String value for calculationPhase.
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
            return this;
        }

        /**
         * Setter for taxable.
         * @param  taxable  Boolean value for taxable.
         * @return Builder
         */
        public Builder taxable(Boolean taxable) {
            this.taxable = OptionalNullable.of(taxable);
            return this;
        }

        /**
         * UnSetter for taxable.
         * @return Builder
         */
        public Builder unsetTaxable() {
            taxable = null;
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
         * Setter for treatmentType.
         * @param  treatmentType  String value for treatmentType.
         * @return Builder
         */
        public Builder treatmentType(String treatmentType) {
            this.treatmentType = treatmentType;
            return this;
        }

        /**
         * Setter for scope.
         * @param  scope  String value for scope.
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnServiceCharge} object using the set fields.
         * @return {@link OrderReturnServiceCharge}
         */
        public OrderReturnServiceCharge build() {
            return new OrderReturnServiceCharge(
                    uid,
                    sourceServiceChargeUid,
                    name,
                    catalogObjectId,
                    catalogVersion,
                    percentage,
                    amountMoney,
                    appliedMoney,
                    totalMoney,
                    totalTaxMoney,
                    calculationPhase,
                    taxable,
                    appliedTaxes,
                    treatmentType,
                    scope);
        }
    }
}
