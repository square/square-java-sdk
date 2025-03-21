/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LoyaltyProgramRewardDefinition.Builder.class)
public final class LoyaltyProgramRewardDefinition {
    private final LoyaltyProgramRewardDefinitionScope scope;

    private final LoyaltyProgramRewardDefinitionType discountType;

    private final Optional<String> percentageDiscount;

    private final Optional<List<String>> catalogObjectIds;

    private final Optional<Money> fixedDiscountMoney;

    private final Optional<Money> maxDiscountMoney;

    private final Map<String, Object> additionalProperties;

    private LoyaltyProgramRewardDefinition(
            LoyaltyProgramRewardDefinitionScope scope,
            LoyaltyProgramRewardDefinitionType discountType,
            Optional<String> percentageDiscount,
            Optional<List<String>> catalogObjectIds,
            Optional<Money> fixedDiscountMoney,
            Optional<Money> maxDiscountMoney,
            Map<String, Object> additionalProperties) {
        this.scope = scope;
        this.discountType = discountType;
        this.percentageDiscount = percentageDiscount;
        this.catalogObjectIds = catalogObjectIds;
        this.fixedDiscountMoney = fixedDiscountMoney;
        this.maxDiscountMoney = maxDiscountMoney;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Indicates the scope of the reward tier. DEPRECATED at version 2020-12-16. You can find this information in the
     * <code>product_set_data</code> field of the <code>PRODUCT_SET</code> catalog object referenced by the pricing rule. For <code>ORDER</code> scopes,
     * <code>all_products</code> is true. For <code>ITEM_VARIATION</code> or <code>CATEGORY</code> scopes, <code>product_ids_any</code> is a list of
     * catalog object IDs of the given type.
     * See <a href="#type-loyaltyprogramrewarddefinitionscope">LoyaltyProgramRewardDefinitionScope</a> for possible values
     */
    @JsonProperty("scope")
    public LoyaltyProgramRewardDefinitionScope getScope() {
        return scope;
    }

    /**
     * @return The type of discount the reward tier offers. DEPRECATED at version 2020-12-16. You can find this information
     * in the <code>discount_data.discount_type</code> field of the <code>DISCOUNT</code> catalog object referenced by the pricing rule.
     * See <a href="#type-loyaltyprogramrewarddefinitiontype">LoyaltyProgramRewardDefinitionType</a> for possible values
     */
    @JsonProperty("discount_type")
    public LoyaltyProgramRewardDefinitionType getDiscountType() {
        return discountType;
    }

    /**
     * @return The fixed percentage of the discount. Present if <code>discount_type</code> is <code>FIXED_PERCENTAGE</code>.
     * For example, a 7.25% off discount will be represented as &quot;7.25&quot;. DEPRECATED at version 2020-12-16. You can find this
     * information in the <code>discount_data.percentage</code> field of the <code>DISCOUNT</code> catalog object referenced by the pricing rule.
     */
    @JsonProperty("percentage_discount")
    public Optional<String> getPercentageDiscount() {
        return percentageDiscount;
    }

    /**
     * @return The list of catalog objects to which this reward can be applied. They are either all item-variation ids or category ids, depending on the <code>type</code> field.
     * DEPRECATED at version 2020-12-16. You can find this information in the <code>product_set_data.product_ids_any</code> field
     * of the <code>PRODUCT_SET</code> catalog object referenced by the pricing rule.
     */
    @JsonProperty("catalog_object_ids")
    public Optional<List<String>> getCatalogObjectIds() {
        return catalogObjectIds;
    }

    /**
     * @return The amount of the discount. Present if <code>discount_type</code> is <code>FIXED_AMOUNT</code>. For example, $5 off.
     * DEPRECATED at version 2020-12-16. You can find this information in the <code>discount_data.amount_money</code> field of the
     * <code>DISCOUNT</code> catalog object referenced by the pricing rule.
     */
    @JsonProperty("fixed_discount_money")
    public Optional<Money> getFixedDiscountMoney() {
        return fixedDiscountMoney;
    }

    /**
     * @return When <code>discount_type</code> is <code>FIXED_PERCENTAGE</code>, the maximum discount amount that can be applied.
     * DEPRECATED at version 2020-12-16. You can find this information in the <code>discount_data.maximum_amount_money</code> field
     * of the <code>DISCOUNT</code> catalog object referenced by the the pricing rule.
     */
    @JsonProperty("max_discount_money")
    public Optional<Money> getMaxDiscountMoney() {
        return maxDiscountMoney;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyProgramRewardDefinition && equalTo((LoyaltyProgramRewardDefinition) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyProgramRewardDefinition other) {
        return scope.equals(other.scope)
                && discountType.equals(other.discountType)
                && percentageDiscount.equals(other.percentageDiscount)
                && catalogObjectIds.equals(other.catalogObjectIds)
                && fixedDiscountMoney.equals(other.fixedDiscountMoney)
                && maxDiscountMoney.equals(other.maxDiscountMoney);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.scope,
                this.discountType,
                this.percentageDiscount,
                this.catalogObjectIds,
                this.fixedDiscountMoney,
                this.maxDiscountMoney);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ScopeStage builder() {
        return new Builder();
    }

    public interface ScopeStage {
        DiscountTypeStage scope(@NotNull LoyaltyProgramRewardDefinitionScope scope);

        Builder from(LoyaltyProgramRewardDefinition other);
    }

    public interface DiscountTypeStage {
        _FinalStage discountType(@NotNull LoyaltyProgramRewardDefinitionType discountType);
    }

    public interface _FinalStage {
        LoyaltyProgramRewardDefinition build();

        _FinalStage percentageDiscount(Optional<String> percentageDiscount);

        _FinalStage percentageDiscount(String percentageDiscount);

        _FinalStage catalogObjectIds(Optional<List<String>> catalogObjectIds);

        _FinalStage catalogObjectIds(List<String> catalogObjectIds);

        _FinalStage fixedDiscountMoney(Optional<Money> fixedDiscountMoney);

        _FinalStage fixedDiscountMoney(Money fixedDiscountMoney);

        _FinalStage maxDiscountMoney(Optional<Money> maxDiscountMoney);

        _FinalStage maxDiscountMoney(Money maxDiscountMoney);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ScopeStage, DiscountTypeStage, _FinalStage {
        private LoyaltyProgramRewardDefinitionScope scope;

        private LoyaltyProgramRewardDefinitionType discountType;

        private Optional<Money> maxDiscountMoney = Optional.empty();

        private Optional<Money> fixedDiscountMoney = Optional.empty();

        private Optional<List<String>> catalogObjectIds = Optional.empty();

        private Optional<String> percentageDiscount = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LoyaltyProgramRewardDefinition other) {
            scope(other.getScope());
            discountType(other.getDiscountType());
            percentageDiscount(other.getPercentageDiscount());
            catalogObjectIds(other.getCatalogObjectIds());
            fixedDiscountMoney(other.getFixedDiscountMoney());
            maxDiscountMoney(other.getMaxDiscountMoney());
            return this;
        }

        /**
         * <p>Indicates the scope of the reward tier. DEPRECATED at version 2020-12-16. You can find this information in the
         * <code>product_set_data</code> field of the <code>PRODUCT_SET</code> catalog object referenced by the pricing rule. For <code>ORDER</code> scopes,
         * <code>all_products</code> is true. For <code>ITEM_VARIATION</code> or <code>CATEGORY</code> scopes, <code>product_ids_any</code> is a list of
         * catalog object IDs of the given type.
         * See <a href="#type-loyaltyprogramrewarddefinitionscope">LoyaltyProgramRewardDefinitionScope</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("scope")
        public DiscountTypeStage scope(@NotNull LoyaltyProgramRewardDefinitionScope scope) {
            this.scope = Objects.requireNonNull(scope, "scope must not be null");
            return this;
        }

        /**
         * <p>The type of discount the reward tier offers. DEPRECATED at version 2020-12-16. You can find this information
         * in the <code>discount_data.discount_type</code> field of the <code>DISCOUNT</code> catalog object referenced by the pricing rule.
         * See <a href="#type-loyaltyprogramrewarddefinitiontype">LoyaltyProgramRewardDefinitionType</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("discount_type")
        public _FinalStage discountType(@NotNull LoyaltyProgramRewardDefinitionType discountType) {
            this.discountType = Objects.requireNonNull(discountType, "discountType must not be null");
            return this;
        }

        /**
         * <p>When <code>discount_type</code> is <code>FIXED_PERCENTAGE</code>, the maximum discount amount that can be applied.
         * DEPRECATED at version 2020-12-16. You can find this information in the <code>discount_data.maximum_amount_money</code> field
         * of the <code>DISCOUNT</code> catalog object referenced by the the pricing rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage maxDiscountMoney(Money maxDiscountMoney) {
            this.maxDiscountMoney = Optional.ofNullable(maxDiscountMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "max_discount_money", nulls = Nulls.SKIP)
        public _FinalStage maxDiscountMoney(Optional<Money> maxDiscountMoney) {
            this.maxDiscountMoney = maxDiscountMoney;
            return this;
        }

        /**
         * <p>The amount of the discount. Present if <code>discount_type</code> is <code>FIXED_AMOUNT</code>. For example, $5 off.
         * DEPRECATED at version 2020-12-16. You can find this information in the <code>discount_data.amount_money</code> field of the
         * <code>DISCOUNT</code> catalog object referenced by the pricing rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage fixedDiscountMoney(Money fixedDiscountMoney) {
            this.fixedDiscountMoney = Optional.ofNullable(fixedDiscountMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "fixed_discount_money", nulls = Nulls.SKIP)
        public _FinalStage fixedDiscountMoney(Optional<Money> fixedDiscountMoney) {
            this.fixedDiscountMoney = fixedDiscountMoney;
            return this;
        }

        /**
         * <p>The list of catalog objects to which this reward can be applied. They are either all item-variation ids or category ids, depending on the <code>type</code> field.
         * DEPRECATED at version 2020-12-16. You can find this information in the <code>product_set_data.product_ids_any</code> field
         * of the <code>PRODUCT_SET</code> catalog object referenced by the pricing rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = Optional.ofNullable(catalogObjectIds);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "catalog_object_ids", nulls = Nulls.SKIP)
        public _FinalStage catalogObjectIds(Optional<List<String>> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }

        /**
         * <p>The fixed percentage of the discount. Present if <code>discount_type</code> is <code>FIXED_PERCENTAGE</code>.
         * For example, a 7.25% off discount will be represented as &quot;7.25&quot;. DEPRECATED at version 2020-12-16. You can find this
         * information in the <code>discount_data.percentage</code> field of the <code>DISCOUNT</code> catalog object referenced by the pricing rule.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage percentageDiscount(String percentageDiscount) {
            this.percentageDiscount = Optional.ofNullable(percentageDiscount);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "percentage_discount", nulls = Nulls.SKIP)
        public _FinalStage percentageDiscount(Optional<String> percentageDiscount) {
            this.percentageDiscount = percentageDiscount;
            return this;
        }

        @java.lang.Override
        public LoyaltyProgramRewardDefinition build() {
            return new LoyaltyProgramRewardDefinition(
                    scope,
                    discountType,
                    percentageDiscount,
                    catalogObjectIds,
                    fixedDiscountMoney,
                    maxDiscountMoney,
                    additionalProperties);
        }
    }
}
