
package com.squareup.square.models;

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
 * This is a model class for OrderServiceCharge type.
 */
public class OrderServiceCharge {
    private final OptionalNullable<String> uid;
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
    private final OptionalNullable<Map<String, String>> metadata;
    private final String type;
    private final String treatmentType;
    private final String scope;
    private final OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges;
    private final Money totalServiceChargeMoney;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
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
     * @param  metadata  Map of String, value for metadata.
     * @param  type  String value for type.
     * @param  treatmentType  String value for treatmentType.
     * @param  scope  String value for scope.
     * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
     *         appliedServiceCharges.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
     */
    @JsonCreator
    public OrderServiceCharge(
            @JsonProperty("uid") String uid,
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
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("type") String type,
            @JsonProperty("treatment_type") String treatmentType,
            @JsonProperty("scope") String scope,
            @JsonProperty("applied_service_charges") List<OrderLineItemAppliedServiceCharge> appliedServiceCharges,
            @JsonProperty("total_service_charge_money") Money totalServiceChargeMoney) {
        this.uid = OptionalNullable.of(uid);
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
        this.metadata = OptionalNullable.of(metadata);
        this.type = type;
        this.treatmentType = treatmentType;
        this.scope = scope;
        this.appliedServiceCharges = OptionalNullable.of(appliedServiceCharges);
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
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
     * @param  metadata  Map of String, value for metadata.
     * @param  type  String value for type.
     * @param  treatmentType  String value for treatmentType.
     * @param  scope  String value for scope.
     * @param  appliedServiceCharges  List of OrderLineItemAppliedServiceCharge value for
     *         appliedServiceCharges.
     * @param  totalServiceChargeMoney  Money value for totalServiceChargeMoney.
     */

    protected OrderServiceCharge(OptionalNullable<String> uid, OptionalNullable<String> name,
            OptionalNullable<String> catalogObjectId, OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> percentage, Money amountMoney, Money appliedMoney,
            Money totalMoney, Money totalTaxMoney, String calculationPhase,
            OptionalNullable<Boolean> taxable,
            OptionalNullable<List<OrderLineItemAppliedTax>> appliedTaxes,
            OptionalNullable<Map<String, String>> metadata, String type, String treatmentType,
            String scope,
            OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges,
            Money totalServiceChargeMoney) {
        this.uid = uid;
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
        this.metadata = metadata;
        this.type = type;
        this.treatmentType = treatmentType;
        this.scope = scope;
        this.appliedServiceCharges = appliedServiceCharges;
        this.totalServiceChargeMoney = totalServiceChargeMoney;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the service charge only within this order.
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
     * A unique ID that identifies the service charge only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
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
     * The catalog object ID referencing the service charge [CatalogObject](entity:CatalogObject).
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
     * The catalog object ID referencing the service charge [CatalogObject](entity:CatalogObject).
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
     * The service charge percentage as a string representation of a decimal number. For example,
     * `"7.25"` indicates a service charge of 7.25%. Exactly 1 of `percentage` or `amount_money`
     * should be set.
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
     * The service charge percentage as a string representation of a decimal number. For example,
     * `"7.25"` indicates a service charge of 7.25%. Exactly 1 of `percentage` or `amount_money`
     * should be set.
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
     * Indicates whether the service charge can be taxed. If set to `true`, order-level taxes
     * automatically apply to the service charge. Note that service charges calculated in the
     * `TOTAL_PHASE` cannot be marked as taxable.
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
     * Indicates whether the service charge can be taxed. If set to `true`, order-level taxes
     * automatically apply to the service charge. Note that service charges calculated in the
     * `TOTAL_PHASE` cannot be marked as taxable.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getTaxable() {
        return OptionalNullable.getFrom(taxable);
    }

    /**
     * Internal Getter for AppliedTaxes.
     * The list of references to the taxes applied to this service charge. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a top-level
     * `OrderLineItemTax` that is being applied to this service charge. On reads, the amount applied
     * is populated. An `OrderLineItemAppliedTax` is automatically created on every taxable service
     * charge for all `ORDER` scoped taxes that are added to the order. `OrderLineItemAppliedTax`
     * records for `LINE_ITEM` scoped taxes must be added in requests for the tax to apply to any
     * taxable service charge. Taxable service charges have the `taxable` field set to `true` and
     * calculated in the `SUBTOTAL_PHASE`. To change the amount of a tax, modify the referenced
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
     * The list of references to the taxes applied to this service charge. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a top-level
     * `OrderLineItemTax` that is being applied to this service charge. On reads, the amount applied
     * is populated. An `OrderLineItemAppliedTax` is automatically created on every taxable service
     * charge for all `ORDER` scoped taxes that are added to the order. `OrderLineItemAppliedTax`
     * records for `LINE_ITEM` scoped taxes must be added in requests for the tax to apply to any
     * taxable service charge. Taxable service charges have the `taxable` field set to `true` and
     * calculated in the `SUBTOTAL_PHASE`. To change the amount of a tax, modify the referenced
     * top-level tax.
     * @return Returns the List of OrderLineItemAppliedTax
     */
    @JsonIgnore
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return OptionalNullable.getFrom(appliedTaxes);
    }

    /**
     * Internal Getter for Metadata.
     * Application-defined data attached to this service charge. Metadata fields are intended to
     * store descriptive references or associations with an entity in another system or store brief
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
     * Application-defined data attached to this service charge. Metadata fields are intended to
     * store descriptive references or associations with an entity in another system or store brief
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
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
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

    /**
     * Internal Getter for AppliedServiceCharges.
     * The list of references to service charges applied to this service charge. Each
     * `OrderLineItemAppliedServiceCharge` has a `service_charge_id` that references the `uid` of a
     * top-level `OrderServiceCharge`. On reads, the amount applied is populated. To change the
     * amount of a service charge, modify the referenced top-level service charge.
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
     * The list of references to service charges applied to this service charge. Each
     * `OrderLineItemAppliedServiceCharge` has a `service_charge_id` that references the `uid` of a
     * top-level `OrderServiceCharge`. On reads, the amount applied is populated. To change the
     * amount of a service charge, modify the referenced top-level service charge.
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
        return Objects.hash(uid, name, catalogObjectId, catalogVersion, percentage, amountMoney,
                appliedMoney, totalMoney, totalTaxMoney, calculationPhase, taxable, appliedTaxes,
                metadata, type, treatmentType, scope, appliedServiceCharges,
                totalServiceChargeMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderServiceCharge)) {
            return false;
        }
        OrderServiceCharge other = (OrderServiceCharge) obj;
        return Objects.equals(uid, other.uid)
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
            && Objects.equals(metadata, other.metadata)
            && Objects.equals(type, other.type)
            && Objects.equals(treatmentType, other.treatmentType)
            && Objects.equals(scope, other.scope)
            && Objects.equals(appliedServiceCharges, other.appliedServiceCharges)
            && Objects.equals(totalServiceChargeMoney, other.totalServiceChargeMoney);
    }

    /**
     * Converts this OrderServiceCharge into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderServiceCharge [" + "uid=" + uid + ", name=" + name + ", catalogObjectId="
                + catalogObjectId + ", catalogVersion=" + catalogVersion + ", percentage="
                + percentage + ", amountMoney=" + amountMoney + ", appliedMoney=" + appliedMoney
                + ", totalMoney=" + totalMoney + ", totalTaxMoney=" + totalTaxMoney
                + ", calculationPhase=" + calculationPhase + ", taxable=" + taxable
                + ", appliedTaxes=" + appliedTaxes + ", metadata=" + metadata + ", type=" + type
                + ", treatmentType=" + treatmentType + ", scope=" + scope
                + ", appliedServiceCharges=" + appliedServiceCharges + ", totalServiceChargeMoney="
                + totalServiceChargeMoney + "]";
    }

    /**
     * Builds a new {@link OrderServiceCharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderServiceCharge.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .amountMoney(getAmountMoney())
                .appliedMoney(getAppliedMoney())
                .totalMoney(getTotalMoney())
                .totalTaxMoney(getTotalTaxMoney())
                .calculationPhase(getCalculationPhase())
                .type(getType())
                .treatmentType(getTreatmentType())
                .scope(getScope())
                .totalServiceChargeMoney(getTotalServiceChargeMoney());
        builder.uid = internalGetUid();
        builder.name = internalGetName();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.percentage = internalGetPercentage();
        builder.taxable = internalGetTaxable();
        builder.appliedTaxes = internalGetAppliedTaxes();
        builder.metadata = internalGetMetadata();
        builder.appliedServiceCharges = internalGetAppliedServiceCharges();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderServiceCharge}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
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
        private OptionalNullable<Map<String, String>> metadata;
        private String type;
        private String treatmentType;
        private String scope;
        private OptionalNullable<List<OrderLineItemAppliedServiceCharge>> appliedServiceCharges;
        private Money totalServiceChargeMoney;



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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
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
         * Builds a new {@link OrderServiceCharge} object using the set fields.
         * @return {@link OrderServiceCharge}
         */
        public OrderServiceCharge build() {
            return new OrderServiceCharge(uid, name, catalogObjectId, catalogVersion, percentage,
                    amountMoney, appliedMoney, totalMoney, totalTaxMoney, calculationPhase, taxable,
                    appliedTaxes, metadata, type, treatmentType, scope, appliedServiceCharges,
                    totalServiceChargeMoney);
        }
    }
}
