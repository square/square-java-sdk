package com.squareup.square.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderServiceCharge type.
 */
public class OrderServiceCharge {

    /**
     * Initialization constructor.
     * @param uid
     * @param name
     * @param catalogObjectId
     * @param percentage
     * @param amountMoney
     * @param appliedMoney
     * @param totalMoney
     * @param totalTaxMoney
     * @param calculationPhase
     * @param taxable
     * @param taxes
     * @param appliedTaxes
     * @param metadata
     */
    @JsonCreator
    public OrderServiceCharge(
            @JsonProperty("uid") String uid,
            @JsonProperty("name") String name,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("total_money") Money totalMoney,
            @JsonProperty("total_tax_money") Money totalTaxMoney,
            @JsonProperty("calculation_phase") String calculationPhase,
            @JsonProperty("taxable") Boolean taxable,
            @JsonProperty("taxes") List<OrderLineItemTax> taxes,
            @JsonProperty("applied_taxes") List<OrderLineItemAppliedTax> appliedTaxes,
            @JsonProperty("metadata") Map<String, String> metadata) {
        this.uid = uid;
        this.name = name;
        this.catalogObjectId = catalogObjectId;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.totalMoney = totalMoney;
        this.totalTaxMoney = totalTaxMoney;
        this.calculationPhase = calculationPhase;
        this.taxable = taxable;
        this.taxes = taxes;
        this.appliedTaxes = appliedTaxes;
        this.metadata = metadata;
    }

    private final String uid;
    private final String name;
    private final String catalogObjectId;
    private final String percentage;
    private final Money amountMoney;
    private final Money appliedMoney;
    private final Money totalMoney;
    private final Money totalTaxMoney;
    private final String calculationPhase;
    private final Boolean taxable;
    private final List<OrderLineItemTax> taxes;
    private final List<OrderLineItemAppliedTax> appliedTaxes;
    private final Map<String, String> metadata;
    /**
     * Getter for Uid.
     * Unique ID that identifies the service charge only within this order.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
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
     * The catalog object ID referencing the service charge [CatalogObject](#type-catalogobject).
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Percentage.
     * The service charge percentage as a string representation of a
     * decimal number. For example, `"7.25"` indicates a service charge of 7.25%.
     * Exactly 1 of `percentage` or `amount_money` should be set.
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
     * Indicates whether the service charge can be taxed. If set to `true`,
     * order-level taxes automatically apply to the service charge. Note that
     * service charges calculated in the `TOTAL_PHASE` cannot be marked as taxable.
     */
    @JsonGetter("taxable")
    public Boolean getTaxable() {
        return this.taxable;
    }

    /**
     * Getter for Taxes.
     * A list of taxes applied to this service charge. On read or retrieve, this list includes
     * both item-level taxes and any order-level taxes apportioned to this service charge.
     * When creating an Order, set your service charge-level taxes in this list. By default,
     * order-level taxes apply to service charges calculated in the `SUBTOTAL_PHASE` if `taxable` is
     * set to `true`.
     * This field has been deprecated in favour of `applied_taxes`. Usage of both this field and
     * `applied_taxes` when creating an order will result in an error. Usage of this field when
     * sending requests to the UpdateOrder endpoint will result in an error.
     */
    @JsonGetter("taxes")
    public List<OrderLineItemTax> getTaxes() {
        return this.taxes;
    }

    /**
     * Getter for AppliedTaxes.
     * The list of references to taxes applied to this service charge. Each
     * `OrderLineItemAppliedTax` has a `tax_uid` that references the `uid` of a top-level
     * `OrderLineItemTax` that is being applied to this service charge. On reads, the amount applied
     * is populated.
     * An `OrderLineItemAppliedTax` will be automatically created on every taxable service charge
     * for all `ORDER` scoped taxes that are added to the order. `OrderLineItemAppliedTax` records
     * for `LINE_ITEM` scoped taxes must be added in requests for the tax to apply to any taxable
     * service charge.  Taxable service charges have the `taxable` field set to true and calculated
     * in the `SUBTOTAL_PHASE`.
     * To change the amount of a tax, modify the referenced top-level tax.
     */
    @JsonGetter("applied_taxes")
    public List<OrderLineItemAppliedTax> getAppliedTaxes() {
        return this.appliedTaxes;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this service charge. Metadata fields are intended
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

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, name, catalogObjectId, percentage, amountMoney, appliedMoney,
            totalMoney, totalTaxMoney, calculationPhase, taxable, taxes, appliedTaxes, metadata);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderServiceCharge)) {
            return false;
        }
        OrderServiceCharge orderServiceCharge = (OrderServiceCharge) obj;
        return Objects.equals(uid, orderServiceCharge.uid) &&
            Objects.equals(name, orderServiceCharge.name) &&
            Objects.equals(catalogObjectId, orderServiceCharge.catalogObjectId) &&
            Objects.equals(percentage, orderServiceCharge.percentage) &&
            Objects.equals(amountMoney, orderServiceCharge.amountMoney) &&
            Objects.equals(appliedMoney, orderServiceCharge.appliedMoney) &&
            Objects.equals(totalMoney, orderServiceCharge.totalMoney) &&
            Objects.equals(totalTaxMoney, orderServiceCharge.totalTaxMoney) &&
            Objects.equals(calculationPhase, orderServiceCharge.calculationPhase) &&
            Objects.equals(taxable, orderServiceCharge.taxable) &&
            Objects.equals(taxes, orderServiceCharge.taxes) &&
            Objects.equals(appliedTaxes, orderServiceCharge.appliedTaxes) &&
            Objects.equals(metadata, orderServiceCharge.metadata);
    }

    /**
     * Builds a new {@link OrderServiceCharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderServiceCharge.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .name(getName())
            .catalogObjectId(getCatalogObjectId())
            .percentage(getPercentage())
            .amountMoney(getAmountMoney())
            .appliedMoney(getAppliedMoney())
            .totalMoney(getTotalMoney())
            .totalTaxMoney(getTotalTaxMoney())
            .calculationPhase(getCalculationPhase())
            .taxable(getTaxable())
            .taxes(getTaxes())
            .appliedTaxes(getAppliedTaxes())
            .metadata(getMetadata());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderServiceCharge}
     */
    public static class Builder {
        private String uid;
        private String name;
        private String catalogObjectId;
        private String percentage;
        private Money amountMoney;
        private Money appliedMoney;
        private Money totalMoney;
        private Money totalTaxMoney;
        private String calculationPhase;
        private Boolean taxable;
        private List<OrderLineItemTax> taxes;
        private List<OrderLineItemAppliedTax> appliedTaxes;
        private Map<String, String> metadata;

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
         * Setter for taxes
         * @param taxes
         * @return Builder
         */
        public Builder taxes(List<OrderLineItemTax> taxes) {
            this.taxes = taxes;
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
         * Setter for metadata
         * @param metadata
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Builds a new {@link OrderServiceCharge} object using the set fields.
         * @return {@link OrderServiceCharge}
         */
        public OrderServiceCharge build() {
            return new OrderServiceCharge(uid,
                name,
                catalogObjectId,
                percentage,
                amountMoney,
                appliedMoney,
                totalMoney,
                totalTaxMoney,
                calculationPhase,
                taxable,
                taxes,
                appliedTaxes,
                metadata);
        }
    }
}
