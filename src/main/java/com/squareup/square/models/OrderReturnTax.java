package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderReturnTax {

    @JsonCreator
    public OrderReturnTax(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_tax_uid") String sourceTaxUid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("scope") String scope) {
        this.uid = uid;
        this.sourceTaxUid = sourceTaxUid;
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.appliedMoney = appliedMoney;
        this.scope = scope;
    }

    private final String uid;
    private final String sourceTaxUid;
    private final String catalogObjectId;
    private final String name;
    private final String type;
    private final String percentage;
    private final Money appliedMoney;
    private final String scope;

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceTaxUid, catalogObjectId, name, type, percentage, appliedMoney, scope);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderReturnTax)) {
            return false;
        }
        OrderReturnTax orderReturnTax = (OrderReturnTax) o;
        return Objects.equals(uid, orderReturnTax.uid) &&
            Objects.equals(sourceTaxUid, orderReturnTax.sourceTaxUid) &&
            Objects.equals(catalogObjectId, orderReturnTax.catalogObjectId) &&
            Objects.equals(name, orderReturnTax.name) &&
            Objects.equals(type, orderReturnTax.type) &&
            Objects.equals(percentage, orderReturnTax.percentage) &&
            Objects.equals(appliedMoney, orderReturnTax.appliedMoney) &&
            Objects.equals(scope, orderReturnTax.scope);
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the return tax only within this order.
     */
    @JsonGetter("uid")
    public String getUid() { 
        return this.uid;
    }

    /**
     * Getter for SourceTaxUid.
     * `uid` of the Tax from the Order which contains the original charge of this tax.
     */
    @JsonGetter("source_tax_uid")
    public String getSourceTaxUid() { 
        return this.sourceTaxUid;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object id referencing [CatalogTax](#type-catalogtax).
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() { 
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * The tax's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Type.
     * Indicates how the tax is applied to the associated line item or order.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for Percentage.
     * The percentage of the tax, as a string representation of a decimal number.
     * For example, a value of `"7.25"` corresponds to a percentage of 7.25%.
     */
    @JsonGetter("percentage")
    public String getPercentage() { 
        return this.percentage;
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
     * Getter for Scope.
     * Indicates whether this is a line item or order level tax.
     */
    @JsonGetter("scope")
    public String getScope() { 
        return this.scope;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .sourceTaxUid(getSourceTaxUid())
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .type(getType())
            .percentage(getPercentage())
            .appliedMoney(getAppliedMoney())
            .scope(getScope());
            return builder;
    }

    public static class Builder {
        private String uid;
        private String sourceTaxUid;
        private String catalogObjectId;
        private String name;
        private String type;
        private String percentage;
        private Money appliedMoney;
        private String scope;

        public Builder() { }

        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder sourceTaxUid(String value) {
            sourceTaxUid = value;
            return this;
        }
        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder percentage(String value) {
            percentage = value;
            return this;
        }
        public Builder appliedMoney(Money value) {
            appliedMoney = value;
            return this;
        }
        public Builder scope(String value) {
            scope = value;
            return this;
        }

        public OrderReturnTax build() {
            return new OrderReturnTax(uid,
                sourceTaxUid,
                catalogObjectId,
                name,
                type,
                percentage,
                appliedMoney,
                scope);
        }
    }
}
