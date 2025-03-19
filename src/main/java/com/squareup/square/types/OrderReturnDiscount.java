/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = OrderReturnDiscount.Builder.class)
public final class OrderReturnDiscount {
    private final Optional<String> uid;

    private final Optional<String> sourceDiscountUid;

    private final Optional<String> catalogObjectId;

    private final Optional<Long> catalogVersion;

    private final Optional<String> name;

    private final Optional<OrderLineItemDiscountType> type;

    private final Optional<String> percentage;

    private final Optional<Money> amountMoney;

    private final Optional<Money> appliedMoney;

    private final Optional<OrderLineItemDiscountScope> scope;

    private final Map<String, Object> additionalProperties;

    private OrderReturnDiscount(
            Optional<String> uid,
            Optional<String> sourceDiscountUid,
            Optional<String> catalogObjectId,
            Optional<Long> catalogVersion,
            Optional<String> name,
            Optional<OrderLineItemDiscountType> type,
            Optional<String> percentage,
            Optional<Money> amountMoney,
            Optional<Money> appliedMoney,
            Optional<OrderLineItemDiscountScope> scope,
            Map<String, Object> additionalProperties) {
        this.uid = uid;
        this.sourceDiscountUid = sourceDiscountUid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.scope = scope;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique ID that identifies the returned discount only within this order.
     */
    @JsonIgnore
    public Optional<String> getUid() {
        if (uid == null) {
            return Optional.empty();
        }
        return uid;
    }

    /**
     * @return The discount <code>uid</code> from the order that contains the original application of this discount.
     */
    @JsonIgnore
    public Optional<String> getSourceDiscountUid() {
        if (sourceDiscountUid == null) {
            return Optional.empty();
        }
        return sourceDiscountUid;
    }

    /**
     * @return The catalog object ID referencing <a href="entity:CatalogDiscount">CatalogDiscount</a>.
     */
    @JsonIgnore
    public Optional<String> getCatalogObjectId() {
        if (catalogObjectId == null) {
            return Optional.empty();
        }
        return catalogObjectId;
    }

    /**
     * @return The version of the catalog object that this discount references.
     */
    @JsonIgnore
    public Optional<Long> getCatalogVersion() {
        if (catalogVersion == null) {
            return Optional.empty();
        }
        return catalogVersion;
    }

    /**
     * @return The discount's name.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return The type of the discount. If it is created by the API, it is <code>FIXED_PERCENTAGE</code> or <code>FIXED_AMOUNT</code>.
     * <p>Discounts that do not reference a catalog object ID must have a type of
     * <code>FIXED_PERCENTAGE</code> or <code>FIXED_AMOUNT</code>.
     * See <a href="#type-orderlineitemdiscounttype">OrderLineItemDiscountType</a> for possible values</p>
     */
    @JsonProperty("type")
    public Optional<OrderLineItemDiscountType> getType() {
        return type;
    }

    /**
     * @return The percentage of the tax, as a string representation of a decimal number.
     * A value of <code>&quot;7.25&quot;</code> corresponds to a percentage of 7.25%.
     * <p><code>percentage</code> is not set for amount-based discounts.</p>
     */
    @JsonIgnore
    public Optional<String> getPercentage() {
        if (percentage == null) {
            return Optional.empty();
        }
        return percentage;
    }

    /**
     * @return The total declared monetary amount of the discount.
     * <p><code>amount_money</code> is not set for percentage-based discounts.</p>
     */
    @JsonProperty("amount_money")
    public Optional<Money> getAmountMoney() {
        return amountMoney;
    }

    /**
     * @return The amount of discount actually applied to this line item. When an amount-based
     * discount is at the order level, this value is different from <code>amount_money</code> because the discount
     * is distributed across the line items.
     */
    @JsonProperty("applied_money")
    public Optional<Money> getAppliedMoney() {
        return appliedMoney;
    }

    /**
     * @return Indicates the level at which the <code>OrderReturnDiscount</code> applies. For <code>ORDER</code> scoped
     * discounts, the server generates references in <code>applied_discounts</code> on all
     * <code>OrderReturnLineItem</code>s. For <code>LINE_ITEM</code> scoped discounts, the discount is only applied to
     * <code>OrderReturnLineItem</code>s with references in their <code>applied_discounts</code> field.
     * See <a href="#type-orderlineitemdiscountscope">OrderLineItemDiscountScope</a> for possible values
     */
    @JsonProperty("scope")
    public Optional<OrderLineItemDiscountScope> getScope() {
        return scope;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("uid")
    private Optional<String> _getUid() {
        return uid;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("source_discount_uid")
    private Optional<String> _getSourceDiscountUid() {
        return sourceDiscountUid;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("catalog_object_id")
    private Optional<String> _getCatalogObjectId() {
        return catalogObjectId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("catalog_version")
    private Optional<Long> _getCatalogVersion() {
        return catalogVersion;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("percentage")
    private Optional<String> _getPercentage() {
        return percentage;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OrderReturnDiscount && equalTo((OrderReturnDiscount) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OrderReturnDiscount other) {
        return uid.equals(other.uid)
                && sourceDiscountUid.equals(other.sourceDiscountUid)
                && catalogObjectId.equals(other.catalogObjectId)
                && catalogVersion.equals(other.catalogVersion)
                && name.equals(other.name)
                && type.equals(other.type)
                && percentage.equals(other.percentage)
                && amountMoney.equals(other.amountMoney)
                && appliedMoney.equals(other.appliedMoney)
                && scope.equals(other.scope);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.uid,
                this.sourceDiscountUid,
                this.catalogObjectId,
                this.catalogVersion,
                this.name,
                this.type,
                this.percentage,
                this.amountMoney,
                this.appliedMoney,
                this.scope);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> uid = Optional.empty();

        private Optional<String> sourceDiscountUid = Optional.empty();

        private Optional<String> catalogObjectId = Optional.empty();

        private Optional<Long> catalogVersion = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<OrderLineItemDiscountType> type = Optional.empty();

        private Optional<String> percentage = Optional.empty();

        private Optional<Money> amountMoney = Optional.empty();

        private Optional<Money> appliedMoney = Optional.empty();

        private Optional<OrderLineItemDiscountScope> scope = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(OrderReturnDiscount other) {
            uid(other.getUid());
            sourceDiscountUid(other.getSourceDiscountUid());
            catalogObjectId(other.getCatalogObjectId());
            catalogVersion(other.getCatalogVersion());
            name(other.getName());
            type(other.getType());
            percentage(other.getPercentage());
            amountMoney(other.getAmountMoney());
            appliedMoney(other.getAppliedMoney());
            scope(other.getScope());
            return this;
        }

        @JsonSetter(value = "uid", nulls = Nulls.SKIP)
        public Builder uid(Optional<String> uid) {
            this.uid = uid;
            return this;
        }

        public Builder uid(String uid) {
            this.uid = Optional.ofNullable(uid);
            return this;
        }

        public Builder uid(Nullable<String> uid) {
            if (uid.isNull()) {
                this.uid = null;
            } else if (uid.isEmpty()) {
                this.uid = Optional.empty();
            } else {
                this.uid = Optional.of(uid.get());
            }
            return this;
        }

        @JsonSetter(value = "source_discount_uid", nulls = Nulls.SKIP)
        public Builder sourceDiscountUid(Optional<String> sourceDiscountUid) {
            this.sourceDiscountUid = sourceDiscountUid;
            return this;
        }

        public Builder sourceDiscountUid(String sourceDiscountUid) {
            this.sourceDiscountUid = Optional.ofNullable(sourceDiscountUid);
            return this;
        }

        public Builder sourceDiscountUid(Nullable<String> sourceDiscountUid) {
            if (sourceDiscountUid.isNull()) {
                this.sourceDiscountUid = null;
            } else if (sourceDiscountUid.isEmpty()) {
                this.sourceDiscountUid = Optional.empty();
            } else {
                this.sourceDiscountUid = Optional.of(sourceDiscountUid.get());
            }
            return this;
        }

        @JsonSetter(value = "catalog_object_id", nulls = Nulls.SKIP)
        public Builder catalogObjectId(Optional<String> catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = Optional.ofNullable(catalogObjectId);
            return this;
        }

        public Builder catalogObjectId(Nullable<String> catalogObjectId) {
            if (catalogObjectId.isNull()) {
                this.catalogObjectId = null;
            } else if (catalogObjectId.isEmpty()) {
                this.catalogObjectId = Optional.empty();
            } else {
                this.catalogObjectId = Optional.of(catalogObjectId.get());
            }
            return this;
        }

        @JsonSetter(value = "catalog_version", nulls = Nulls.SKIP)
        public Builder catalogVersion(Optional<Long> catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
        }

        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = Optional.ofNullable(catalogVersion);
            return this;
        }

        public Builder catalogVersion(Nullable<Long> catalogVersion) {
            if (catalogVersion.isNull()) {
                this.catalogVersion = null;
            } else if (catalogVersion.isEmpty()) {
                this.catalogVersion = Optional.empty();
            } else {
                this.catalogVersion = Optional.of(catalogVersion.get());
            }
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Nullable<String> name) {
            if (name.isNull()) {
                this.name = null;
            } else if (name.isEmpty()) {
                this.name = Optional.empty();
            } else {
                this.name = Optional.of(name.get());
            }
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<OrderLineItemDiscountType> type) {
            this.type = type;
            return this;
        }

        public Builder type(OrderLineItemDiscountType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @JsonSetter(value = "percentage", nulls = Nulls.SKIP)
        public Builder percentage(Optional<String> percentage) {
            this.percentage = percentage;
            return this;
        }

        public Builder percentage(String percentage) {
            this.percentage = Optional.ofNullable(percentage);
            return this;
        }

        public Builder percentage(Nullable<String> percentage) {
            if (percentage.isNull()) {
                this.percentage = null;
            } else if (percentage.isEmpty()) {
                this.percentage = Optional.empty();
            } else {
                this.percentage = Optional.of(percentage.get());
            }
            return this;
        }

        @JsonSetter(value = "amount_money", nulls = Nulls.SKIP)
        public Builder amountMoney(Optional<Money> amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = Optional.ofNullable(amountMoney);
            return this;
        }

        @JsonSetter(value = "applied_money", nulls = Nulls.SKIP)
        public Builder appliedMoney(Optional<Money> appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = Optional.ofNullable(appliedMoney);
            return this;
        }

        @JsonSetter(value = "scope", nulls = Nulls.SKIP)
        public Builder scope(Optional<OrderLineItemDiscountScope> scope) {
            this.scope = scope;
            return this;
        }

        public Builder scope(OrderLineItemDiscountScope scope) {
            this.scope = Optional.ofNullable(scope);
            return this;
        }

        public OrderReturnDiscount build() {
            return new OrderReturnDiscount(
                    uid,
                    sourceDiscountUid,
                    catalogObjectId,
                    catalogVersion,
                    name,
                    type,
                    percentage,
                    amountMoney,
                    appliedMoney,
                    scope,
                    additionalProperties);
        }
    }
}
