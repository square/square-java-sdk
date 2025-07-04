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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = OrderLineItemDiscount.Builder.class)
public final class OrderLineItemDiscount {
    private final Optional<String> uid;

    private final Optional<String> catalogObjectId;

    private final Optional<Long> catalogVersion;

    private final Optional<String> name;

    private final Optional<OrderLineItemDiscountType> type;

    private final Optional<String> percentage;

    private final Optional<Money> amountMoney;

    private final Optional<Money> appliedMoney;

    private final Optional<Map<String, Optional<String>>> metadata;

    private final Optional<OrderLineItemDiscountScope> scope;

    private final Optional<List<String>> rewardIds;

    private final Optional<String> pricingRuleId;

    private final Map<String, Object> additionalProperties;

    private OrderLineItemDiscount(
            Optional<String> uid,
            Optional<String> catalogObjectId,
            Optional<Long> catalogVersion,
            Optional<String> name,
            Optional<OrderLineItemDiscountType> type,
            Optional<String> percentage,
            Optional<Money> amountMoney,
            Optional<Money> appliedMoney,
            Optional<Map<String, Optional<String>>> metadata,
            Optional<OrderLineItemDiscountScope> scope,
            Optional<List<String>> rewardIds,
            Optional<String> pricingRuleId,
            Map<String, Object> additionalProperties) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.metadata = metadata;
        this.scope = scope;
        this.rewardIds = rewardIds;
        this.pricingRuleId = pricingRuleId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique ID that identifies the discount only within this order.
     */
    @JsonIgnore
    public Optional<String> getUid() {
        if (uid == null) {
            return Optional.empty();
        }
        return uid;
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
     * @return The type of the discount.
     * <p>Discounts that do not reference a catalog object ID must have a type of
     * <code>FIXED_PERCENTAGE</code> or <code>FIXED_AMOUNT</code>.
     * See <a href="#type-orderlineitemdiscounttype">OrderLineItemDiscountType</a> for possible values</p>
     */
    @JsonProperty("type")
    public Optional<OrderLineItemDiscountType> getType() {
        return type;
    }

    /**
     * @return The percentage of the discount, as a string representation of a decimal number.
     * A value of <code>7.25</code> corresponds to a percentage of 7.25%.
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
     * @return The amount of discount actually applied to the line item.
     * <p>The amount represents the amount of money applied as a line-item scoped discount.
     * When an amount-based discount is scoped to the entire order, the value
     * of <code>applied_money</code> is different than <code>amount_money</code> because the total
     * amount of the discount is distributed across all line items.</p>
     */
    @JsonProperty("applied_money")
    public Optional<Money> getAppliedMoney() {
        return appliedMoney;
    }

    /**
     * @return Application-defined data attached to this discount. Metadata fields are intended
     * to store descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns it
     * in relevant API calls. Do not use metadata to store any sensitive information (such as personally
     * identifiable information or card details).
     * <p>Keys written by applications must be 60 characters or less and must be in the character set
     * <code>[a-zA-Z0-9_-]</code>. Entries can also include metadata generated by Square. These keys are prefixed
     * with a namespace, separated from the key with a ':' character.</p>
     * <p>Values have a maximum length of 255 characters.</p>
     * <p>An application can have up to 10 entries per metadata field.</p>
     * <p>Entries written by applications are private and can only be read or modified by the same
     * application.</p>
     * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/metadata">Metadata</a>.</p>
     */
    @JsonIgnore
    public Optional<Map<String, Optional<String>>> getMetadata() {
        if (metadata == null) {
            return Optional.empty();
        }
        return metadata;
    }

    /**
     * @return Indicates the level at which the discount applies. For <code>ORDER</code> scoped discounts,
     * Square generates references in <code>applied_discounts</code> on all order line items that do
     * not have them. For <code>LINE_ITEM</code> scoped discounts, the discount only applies to line items
     * with a discount reference in their <code>applied_discounts</code> field.
     * <p>This field is immutable. To change the scope of a discount, you must delete
     * the discount and re-add it as a new discount.
     * See <a href="#type-orderlineitemdiscountscope">OrderLineItemDiscountScope</a> for possible values</p>
     */
    @JsonProperty("scope")
    public Optional<OrderLineItemDiscountScope> getScope() {
        return scope;
    }

    /**
     * @return The reward IDs corresponding to this discount. The application and
     * specification of discounts that have <code>reward_ids</code> are completely controlled by the backing
     * criteria corresponding to the reward tiers of the rewards that are added to the order
     * through the Loyalty API. To manually unapply discounts that are the result of added rewards,
     * the rewards must be removed from the order through the Loyalty API.
     */
    @JsonProperty("reward_ids")
    public Optional<List<String>> getRewardIds() {
        return rewardIds;
    }

    /**
     * @return The object ID of a <a href="entity:CatalogPricingRule">pricing rule</a> to be applied
     * automatically to this discount. The specification and application of the discounts, to
     * which a <code>pricing_rule_id</code> is assigned, are completely controlled by the corresponding
     * pricing rule.
     */
    @JsonProperty("pricing_rule_id")
    public Optional<String> getPricingRuleId() {
        return pricingRuleId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("uid")
    private Optional<String> _getUid() {
        return uid;
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

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("metadata")
    private Optional<Map<String, Optional<String>>> _getMetadata() {
        return metadata;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OrderLineItemDiscount && equalTo((OrderLineItemDiscount) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OrderLineItemDiscount other) {
        return uid.equals(other.uid)
                && catalogObjectId.equals(other.catalogObjectId)
                && catalogVersion.equals(other.catalogVersion)
                && name.equals(other.name)
                && type.equals(other.type)
                && percentage.equals(other.percentage)
                && amountMoney.equals(other.amountMoney)
                && appliedMoney.equals(other.appliedMoney)
                && metadata.equals(other.metadata)
                && scope.equals(other.scope)
                && rewardIds.equals(other.rewardIds)
                && pricingRuleId.equals(other.pricingRuleId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.uid,
                this.catalogObjectId,
                this.catalogVersion,
                this.name,
                this.type,
                this.percentage,
                this.amountMoney,
                this.appliedMoney,
                this.metadata,
                this.scope,
                this.rewardIds,
                this.pricingRuleId);
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

        private Optional<String> catalogObjectId = Optional.empty();

        private Optional<Long> catalogVersion = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<OrderLineItemDiscountType> type = Optional.empty();

        private Optional<String> percentage = Optional.empty();

        private Optional<Money> amountMoney = Optional.empty();

        private Optional<Money> appliedMoney = Optional.empty();

        private Optional<Map<String, Optional<String>>> metadata = Optional.empty();

        private Optional<OrderLineItemDiscountScope> scope = Optional.empty();

        private Optional<List<String>> rewardIds = Optional.empty();

        private Optional<String> pricingRuleId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(OrderLineItemDiscount other) {
            uid(other.getUid());
            catalogObjectId(other.getCatalogObjectId());
            catalogVersion(other.getCatalogVersion());
            name(other.getName());
            type(other.getType());
            percentage(other.getPercentage());
            amountMoney(other.getAmountMoney());
            appliedMoney(other.getAppliedMoney());
            metadata(other.getMetadata());
            scope(other.getScope());
            rewardIds(other.getRewardIds());
            pricingRuleId(other.getPricingRuleId());
            return this;
        }

        /**
         * <p>A unique ID that identifies the discount only within this order.</p>
         */
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

        /**
         * <p>The catalog object ID referencing <a href="entity:CatalogDiscount">CatalogDiscount</a>.</p>
         */
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

        /**
         * <p>The version of the catalog object that this discount references.</p>
         */
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

        /**
         * <p>The discount's name.</p>
         */
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

        /**
         * <p>The type of the discount.</p>
         * <p>Discounts that do not reference a catalog object ID must have a type of
         * <code>FIXED_PERCENTAGE</code> or <code>FIXED_AMOUNT</code>.
         * See <a href="#type-orderlineitemdiscounttype">OrderLineItemDiscountType</a> for possible values</p>
         */
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<OrderLineItemDiscountType> type) {
            this.type = type;
            return this;
        }

        public Builder type(OrderLineItemDiscountType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * <p>The percentage of the discount, as a string representation of a decimal number.
         * A value of <code>7.25</code> corresponds to a percentage of 7.25%.</p>
         * <p><code>percentage</code> is not set for amount-based discounts.</p>
         */
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

        /**
         * <p>The total declared monetary amount of the discount.</p>
         * <p><code>amount_money</code> is not set for percentage-based discounts.</p>
         */
        @JsonSetter(value = "amount_money", nulls = Nulls.SKIP)
        public Builder amountMoney(Optional<Money> amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = Optional.ofNullable(amountMoney);
            return this;
        }

        /**
         * <p>The amount of discount actually applied to the line item.</p>
         * <p>The amount represents the amount of money applied as a line-item scoped discount.
         * When an amount-based discount is scoped to the entire order, the value
         * of <code>applied_money</code> is different than <code>amount_money</code> because the total
         * amount of the discount is distributed across all line items.</p>
         */
        @JsonSetter(value = "applied_money", nulls = Nulls.SKIP)
        public Builder appliedMoney(Optional<Money> appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = Optional.ofNullable(appliedMoney);
            return this;
        }

        /**
         * <p>Application-defined data attached to this discount. Metadata fields are intended
         * to store descriptive references or associations with an entity in another system or store brief
         * information about the object. Square does not process this field; it only stores and returns it
         * in relevant API calls. Do not use metadata to store any sensitive information (such as personally
         * identifiable information or card details).</p>
         * <p>Keys written by applications must be 60 characters or less and must be in the character set
         * <code>[a-zA-Z0-9_-]</code>. Entries can also include metadata generated by Square. These keys are prefixed
         * with a namespace, separated from the key with a ':' character.</p>
         * <p>Values have a maximum length of 255 characters.</p>
         * <p>An application can have up to 10 entries per metadata field.</p>
         * <p>Entries written by applications are private and can only be read or modified by the same
         * application.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/metadata">Metadata</a>.</p>
         */
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public Builder metadata(Optional<Map<String, Optional<String>>> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder metadata(Map<String, Optional<String>> metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        public Builder metadata(Nullable<Map<String, Optional<String>>> metadata) {
            if (metadata.isNull()) {
                this.metadata = null;
            } else if (metadata.isEmpty()) {
                this.metadata = Optional.empty();
            } else {
                this.metadata = Optional.of(metadata.get());
            }
            return this;
        }

        /**
         * <p>Indicates the level at which the discount applies. For <code>ORDER</code> scoped discounts,
         * Square generates references in <code>applied_discounts</code> on all order line items that do
         * not have them. For <code>LINE_ITEM</code> scoped discounts, the discount only applies to line items
         * with a discount reference in their <code>applied_discounts</code> field.</p>
         * <p>This field is immutable. To change the scope of a discount, you must delete
         * the discount and re-add it as a new discount.
         * See <a href="#type-orderlineitemdiscountscope">OrderLineItemDiscountScope</a> for possible values</p>
         */
        @JsonSetter(value = "scope", nulls = Nulls.SKIP)
        public Builder scope(Optional<OrderLineItemDiscountScope> scope) {
            this.scope = scope;
            return this;
        }

        public Builder scope(OrderLineItemDiscountScope scope) {
            this.scope = Optional.ofNullable(scope);
            return this;
        }

        /**
         * <p>The reward IDs corresponding to this discount. The application and
         * specification of discounts that have <code>reward_ids</code> are completely controlled by the backing
         * criteria corresponding to the reward tiers of the rewards that are added to the order
         * through the Loyalty API. To manually unapply discounts that are the result of added rewards,
         * the rewards must be removed from the order through the Loyalty API.</p>
         */
        @JsonSetter(value = "reward_ids", nulls = Nulls.SKIP)
        public Builder rewardIds(Optional<List<String>> rewardIds) {
            this.rewardIds = rewardIds;
            return this;
        }

        public Builder rewardIds(List<String> rewardIds) {
            this.rewardIds = Optional.ofNullable(rewardIds);
            return this;
        }

        /**
         * <p>The object ID of a <a href="entity:CatalogPricingRule">pricing rule</a> to be applied
         * automatically to this discount. The specification and application of the discounts, to
         * which a <code>pricing_rule_id</code> is assigned, are completely controlled by the corresponding
         * pricing rule.</p>
         */
        @JsonSetter(value = "pricing_rule_id", nulls = Nulls.SKIP)
        public Builder pricingRuleId(Optional<String> pricingRuleId) {
            this.pricingRuleId = pricingRuleId;
            return this;
        }

        public Builder pricingRuleId(String pricingRuleId) {
            this.pricingRuleId = Optional.ofNullable(pricingRuleId);
            return this;
        }

        public OrderLineItemDiscount build() {
            return new OrderLineItemDiscount(
                    uid,
                    catalogObjectId,
                    catalogVersion,
                    name,
                    type,
                    percentage,
                    amountMoney,
                    appliedMoney,
                    metadata,
                    scope,
                    rewardIds,
                    pricingRuleId,
                    additionalProperties);
        }
    }
}
