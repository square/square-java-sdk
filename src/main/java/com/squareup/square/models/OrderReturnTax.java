
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderReturnTax type.
 */
public class OrderReturnTax {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String uid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sourceTaxUid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String catalogObjectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String percentage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money appliedMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String scope;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  sourceTaxUid  String value for sourceTaxUid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  name  String value for name.
     * @param  type  String value for type.
     * @param  percentage  String value for percentage.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  scope  String value for scope.
     */
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

    /**
     * Getter for Uid.
     * A unique ID that identifies the returned tax only within this order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * Getter for SourceTaxUid.
     * The tax `uid` from the order that contains the original tax charge.
     * @return Returns the String
     */
    @JsonGetter("source_tax_uid")
    public String getSourceTaxUid() {
        return sourceTaxUid;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogTax]($m/CatalogTax).
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return catalogObjectId;
    }

    /**
     * Getter for Name.
     * The tax's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Type.
     * Indicates how the tax is applied to the associated line item or order.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Percentage.
     * The percentage of the tax, as a string representation of a decimal number. For example, a
     * value of `"7.25"` corresponds to a percentage of 7.25%.
     * @return Returns the String
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return percentage;
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
        return appliedMoney;
    }

    /**
     * Getter for Scope.
     * Indicates whether this is a line-item or order-level tax.
     * @return Returns the String
     */
    @JsonGetter("scope")
    public String getScope() {
        return scope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceTaxUid, catalogObjectId, name, type, percentage,
                appliedMoney, scope);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderReturnTax)) {
            return false;
        }
        OrderReturnTax other = (OrderReturnTax) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(sourceTaxUid, other.sourceTaxUid)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(name, other.name)
            && Objects.equals(type, other.type)
            && Objects.equals(percentage, other.percentage)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(scope, other.scope);
    }

    /**
     * Converts this OrderReturnTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderReturnTax [" + "uid=" + uid + ", sourceTaxUid=" + sourceTaxUid
                + ", catalogObjectId=" + catalogObjectId + ", name=" + name + ", type=" + type
                + ", percentage=" + percentage + ", appliedMoney=" + appliedMoney + ", scope="
                + scope + "]";
    }

    /**
     * Builds a new {@link OrderReturnTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnTax.Builder} object
     */
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

    /**
     * Class to build instances of {@link OrderReturnTax}.
     */
    public static class Builder {
        private String uid;
        private String sourceTaxUid;
        private String catalogObjectId;
        private String name;
        private String type;
        private String percentage;
        private Money appliedMoney;
        private String scope;



        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for sourceTaxUid.
         * @param  sourceTaxUid  String value for sourceTaxUid.
         * @return Builder
         */
        public Builder sourceTaxUid(String sourceTaxUid) {
            this.sourceTaxUid = sourceTaxUid;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
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
         * Setter for percentage.
         * @param  percentage  String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
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
         * Setter for scope.
         * @param  scope  String value for scope.
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnTax} object using the set fields.
         * @return {@link OrderReturnTax}
         */
        public OrderReturnTax build() {
            return new OrderReturnTax(uid, sourceTaxUid, catalogObjectId, name, type, percentage,
                    appliedMoney, scope);
        }
    }
}
