
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderReturnTax type.
 */
public class OrderReturnTax {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> sourceTaxUid;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> name;
    private final String type;
    private final OptionalNullable<String> percentage;
    private final Money appliedMoney;
    private final String scope;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  sourceTaxUid  String value for sourceTaxUid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
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
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("scope") String scope) {
        this.uid = OptionalNullable.of(uid);
        this.sourceTaxUid = OptionalNullable.of(sourceTaxUid);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.name = OptionalNullable.of(name);
        this.type = type;
        this.percentage = OptionalNullable.of(percentage);
        this.appliedMoney = appliedMoney;
        this.scope = scope;
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderReturnTax(OptionalNullable<String> uid, OptionalNullable<String> sourceTaxUid,
            OptionalNullable<String> catalogObjectId, OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> name, String type, OptionalNullable<String> percentage,
            Money appliedMoney, String scope) {
        this.uid = uid;
        this.sourceTaxUid = sourceTaxUid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.appliedMoney = appliedMoney;
        this.scope = scope;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the returned tax only within this order.
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
     * A unique ID that identifies the returned tax only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for SourceTaxUid.
     * The tax `uid` from the order that contains the original tax charge.
     * @return Returns the Internal String
     */
    @JsonGetter("source_tax_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceTaxUid() {
        return this.sourceTaxUid;
    }

    /**
     * Getter for SourceTaxUid.
     * The tax `uid` from the order that contains the original tax charge.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceTaxUid() {
        return OptionalNullable.getFrom(sourceTaxUid);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogTax](entity:CatalogTax).
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
     * The catalog object ID referencing [CatalogTax](entity:CatalogTax).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this tax references.
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
     * The version of the catalog object that this tax references.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for Name.
     * The tax's name.
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
     * The tax's name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for Type.
     * Indicates how the tax is applied to the associated line item or order.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for Percentage.
     * The percentage of the tax, as a string representation of a decimal number. For example, a
     * value of `"7.25"` corresponds to a percentage of 7.25%.
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
     * The percentage of the tax, as a string representation of a decimal number. For example, a
     * value of `"7.25"` corresponds to a percentage of 7.25%.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentage() {
        return OptionalNullable.getFrom(percentage);
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
     * Getter for Scope.
     * Indicates whether this is a line-item or order-level tax.
     * @return Returns the String
     */
    @JsonGetter("scope")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScope() {
        return scope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceTaxUid, catalogObjectId, catalogVersion, name, type,
                percentage, appliedMoney, scope);
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
            && Objects.equals(catalogVersion, other.catalogVersion)
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
                + ", catalogObjectId=" + catalogObjectId + ", catalogVersion=" + catalogVersion
                + ", name=" + name + ", type=" + type + ", percentage=" + percentage
                + ", appliedMoney=" + appliedMoney + ", scope=" + scope + "]";
    }

    /**
     * Builds a new {@link OrderReturnTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .appliedMoney(getAppliedMoney())
                .scope(getScope());
        builder.uid = internalGetUid();
        builder.sourceTaxUid = internalGetSourceTaxUid();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.name = internalGetName();
        builder.percentage = internalGetPercentage();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnTax}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> sourceTaxUid;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> name;
        private String type;
        private OptionalNullable<String> percentage;
        private Money appliedMoney;
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
         * Setter for sourceTaxUid.
         * @param  sourceTaxUid  String value for sourceTaxUid.
         * @return Builder
         */
        public Builder sourceTaxUid(String sourceTaxUid) {
            this.sourceTaxUid = OptionalNullable.of(sourceTaxUid);
            return this;
        }

        /**
         * UnSetter for sourceTaxUid.
         * @return Builder
         */
        public Builder unsetSourceTaxUid() {
            sourceTaxUid = null;
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
            return new OrderReturnTax(uid, sourceTaxUid, catalogObjectId, catalogVersion, name,
                    type, percentage, appliedMoney, scope);
        }
    }
}
