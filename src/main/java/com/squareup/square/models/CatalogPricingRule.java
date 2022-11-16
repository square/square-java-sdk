
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogPricingRule type.
 */
public class CatalogPricingRule {
    private final OptionalNullable<String> name;
    private final OptionalNullable<List<String>> timePeriodIds;
    private final OptionalNullable<String> discountId;
    private final OptionalNullable<String> matchProductsId;
    private final OptionalNullable<String> applyProductsId;
    private final OptionalNullable<String> excludeProductsId;
    private final OptionalNullable<String> validFromDate;
    private final OptionalNullable<String> validFromLocalTime;
    private final OptionalNullable<String> validUntilDate;
    private final OptionalNullable<String> validUntilLocalTime;
    private final String excludeStrategy;
    private final Money minimumOrderSubtotalMoney;
    private final OptionalNullable<List<String>> customerGroupIdsAny;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  timePeriodIds  List of String value for timePeriodIds.
     * @param  discountId  String value for discountId.
     * @param  matchProductsId  String value for matchProductsId.
     * @param  applyProductsId  String value for applyProductsId.
     * @param  excludeProductsId  String value for excludeProductsId.
     * @param  validFromDate  String value for validFromDate.
     * @param  validFromLocalTime  String value for validFromLocalTime.
     * @param  validUntilDate  String value for validUntilDate.
     * @param  validUntilLocalTime  String value for validUntilLocalTime.
     * @param  excludeStrategy  String value for excludeStrategy.
     * @param  minimumOrderSubtotalMoney  Money value for minimumOrderSubtotalMoney.
     * @param  customerGroupIdsAny  List of String value for customerGroupIdsAny.
     */
    @JsonCreator
    public CatalogPricingRule(
            @JsonProperty("name") String name,
            @JsonProperty("time_period_ids") List<String> timePeriodIds,
            @JsonProperty("discount_id") String discountId,
            @JsonProperty("match_products_id") String matchProductsId,
            @JsonProperty("apply_products_id") String applyProductsId,
            @JsonProperty("exclude_products_id") String excludeProductsId,
            @JsonProperty("valid_from_date") String validFromDate,
            @JsonProperty("valid_from_local_time") String validFromLocalTime,
            @JsonProperty("valid_until_date") String validUntilDate,
            @JsonProperty("valid_until_local_time") String validUntilLocalTime,
            @JsonProperty("exclude_strategy") String excludeStrategy,
            @JsonProperty("minimum_order_subtotal_money") Money minimumOrderSubtotalMoney,
            @JsonProperty("customer_group_ids_any") List<String> customerGroupIdsAny) {
        this.name = OptionalNullable.of(name);
        this.timePeriodIds = OptionalNullable.of(timePeriodIds);
        this.discountId = OptionalNullable.of(discountId);
        this.matchProductsId = OptionalNullable.of(matchProductsId);
        this.applyProductsId = OptionalNullable.of(applyProductsId);
        this.excludeProductsId = OptionalNullable.of(excludeProductsId);
        this.validFromDate = OptionalNullable.of(validFromDate);
        this.validFromLocalTime = OptionalNullable.of(validFromLocalTime);
        this.validUntilDate = OptionalNullable.of(validUntilDate);
        this.validUntilLocalTime = OptionalNullable.of(validUntilLocalTime);
        this.excludeStrategy = excludeStrategy;
        this.minimumOrderSubtotalMoney = minimumOrderSubtotalMoney;
        this.customerGroupIdsAny = OptionalNullable.of(customerGroupIdsAny);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogPricingRule(OptionalNullable<String> name,
            OptionalNullable<List<String>> timePeriodIds, OptionalNullable<String> discountId,
            OptionalNullable<String> matchProductsId, OptionalNullable<String> applyProductsId,
            OptionalNullable<String> excludeProductsId, OptionalNullable<String> validFromDate,
            OptionalNullable<String> validFromLocalTime, OptionalNullable<String> validUntilDate,
            OptionalNullable<String> validUntilLocalTime, String excludeStrategy,
            Money minimumOrderSubtotalMoney, OptionalNullable<List<String>> customerGroupIdsAny) {
        this.name = name;
        this.timePeriodIds = timePeriodIds;
        this.discountId = discountId;
        this.matchProductsId = matchProductsId;
        this.applyProductsId = applyProductsId;
        this.excludeProductsId = excludeProductsId;
        this.validFromDate = validFromDate;
        this.validFromLocalTime = validFromLocalTime;
        this.validUntilDate = validUntilDate;
        this.validUntilLocalTime = validUntilLocalTime;
        this.excludeStrategy = excludeStrategy;
        this.minimumOrderSubtotalMoney = minimumOrderSubtotalMoney;
        this.customerGroupIdsAny = customerGroupIdsAny;
    }

    /**
     * Internal Getter for Name.
     * User-defined name for the pricing rule. For example, "Buy one get one free" or "10% off".
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
     * User-defined name for the pricing rule. For example, "Buy one get one free" or "10% off".
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for TimePeriodIds.
     * A list of unique IDs for the catalog time periods when this pricing rule is in effect. If
     * left unset, the pricing rule is always in effect.
     * @return Returns the Internal List of String
     */
    @JsonGetter("time_period_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetTimePeriodIds() {
        return this.timePeriodIds;
    }

    /**
     * Getter for TimePeriodIds.
     * A list of unique IDs for the catalog time periods when this pricing rule is in effect. If
     * left unset, the pricing rule is always in effect.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getTimePeriodIds() {
        return OptionalNullable.getFrom(timePeriodIds);
    }

    /**
     * Internal Getter for DiscountId.
     * Unique ID for the `CatalogDiscount` to take off the price of all matched items.
     * @return Returns the Internal String
     */
    @JsonGetter("discount_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDiscountId() {
        return this.discountId;
    }

    /**
     * Getter for DiscountId.
     * Unique ID for the `CatalogDiscount` to take off the price of all matched items.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDiscountId() {
        return OptionalNullable.getFrom(discountId);
    }

    /**
     * Internal Getter for MatchProductsId.
     * Unique ID for the `CatalogProductSet` that will be matched by this rule. A match rule matches
     * within the entire cart, and can match multiple times. This field will always be set.
     * @return Returns the Internal String
     */
    @JsonGetter("match_products_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMatchProductsId() {
        return this.matchProductsId;
    }

    /**
     * Getter for MatchProductsId.
     * Unique ID for the `CatalogProductSet` that will be matched by this rule. A match rule matches
     * within the entire cart, and can match multiple times. This field will always be set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMatchProductsId() {
        return OptionalNullable.getFrom(matchProductsId);
    }

    /**
     * Internal Getter for ApplyProductsId.
     * __Deprecated__: Please use the `exclude_products_id` field to apply an exclude set instead.
     * Exclude sets allow better control over quantity ranges and offer more flexibility for which
     * matched items receive a discount. `CatalogProductSet` to apply the pricing to. An apply rule
     * matches within the subset of the cart that fits the match rules (the match set). An apply
     * rule can only match once in the match set. If not supplied, the pricing will be applied to
     * all products in the match set. Other products retain their base price, or a price generated
     * by other rules.
     * @return Returns the Internal String
     */
    @JsonGetter("apply_products_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApplyProductsId() {
        return this.applyProductsId;
    }

    /**
     * Getter for ApplyProductsId.
     * __Deprecated__: Please use the `exclude_products_id` field to apply an exclude set instead.
     * Exclude sets allow better control over quantity ranges and offer more flexibility for which
     * matched items receive a discount. `CatalogProductSet` to apply the pricing to. An apply rule
     * matches within the subset of the cart that fits the match rules (the match set). An apply
     * rule can only match once in the match set. If not supplied, the pricing will be applied to
     * all products in the match set. Other products retain their base price, or a price generated
     * by other rules.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApplyProductsId() {
        return OptionalNullable.getFrom(applyProductsId);
    }

    /**
     * Internal Getter for ExcludeProductsId.
     * `CatalogProductSet` to exclude from the pricing rule. An exclude rule matches within the
     * subset of the cart that fits the match rules (the match set). An exclude rule can only match
     * once in the match set. If not supplied, the pricing will be applied to all products in the
     * match set. Other products retain their base price, or a price generated by other rules.
     * @return Returns the Internal String
     */
    @JsonGetter("exclude_products_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetExcludeProductsId() {
        return this.excludeProductsId;
    }

    /**
     * Getter for ExcludeProductsId.
     * `CatalogProductSet` to exclude from the pricing rule. An exclude rule matches within the
     * subset of the cart that fits the match rules (the match set). An exclude rule can only match
     * once in the match set. If not supplied, the pricing will be applied to all products in the
     * match set. Other products retain their base price, or a price generated by other rules.
     * @return Returns the String
     */
    @JsonIgnore
    public String getExcludeProductsId() {
        return OptionalNullable.getFrom(excludeProductsId);
    }

    /**
     * Internal Getter for ValidFromDate.
     * Represents the date the Pricing Rule is valid from. Represented in RFC 3339 full-date format
     * (YYYY-MM-DD).
     * @return Returns the Internal String
     */
    @JsonGetter("valid_from_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetValidFromDate() {
        return this.validFromDate;
    }

    /**
     * Getter for ValidFromDate.
     * Represents the date the Pricing Rule is valid from. Represented in RFC 3339 full-date format
     * (YYYY-MM-DD).
     * @return Returns the String
     */
    @JsonIgnore
    public String getValidFromDate() {
        return OptionalNullable.getFrom(validFromDate);
    }

    /**
     * Internal Getter for ValidFromLocalTime.
     * Represents the local time the pricing rule should be valid from. Represented in RFC 3339
     * partial-time format (HH:MM:SS). Partial seconds will be truncated.
     * @return Returns the Internal String
     */
    @JsonGetter("valid_from_local_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetValidFromLocalTime() {
        return this.validFromLocalTime;
    }

    /**
     * Getter for ValidFromLocalTime.
     * Represents the local time the pricing rule should be valid from. Represented in RFC 3339
     * partial-time format (HH:MM:SS). Partial seconds will be truncated.
     * @return Returns the String
     */
    @JsonIgnore
    public String getValidFromLocalTime() {
        return OptionalNullable.getFrom(validFromLocalTime);
    }

    /**
     * Internal Getter for ValidUntilDate.
     * Represents the date the Pricing Rule is valid until. Represented in RFC 3339 full-date format
     * (YYYY-MM-DD).
     * @return Returns the Internal String
     */
    @JsonGetter("valid_until_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetValidUntilDate() {
        return this.validUntilDate;
    }

    /**
     * Getter for ValidUntilDate.
     * Represents the date the Pricing Rule is valid until. Represented in RFC 3339 full-date format
     * (YYYY-MM-DD).
     * @return Returns the String
     */
    @JsonIgnore
    public String getValidUntilDate() {
        return OptionalNullable.getFrom(validUntilDate);
    }

    /**
     * Internal Getter for ValidUntilLocalTime.
     * Represents the local time the pricing rule should be valid until. Represented in RFC 3339
     * partial-time format (HH:MM:SS). Partial seconds will be truncated.
     * @return Returns the Internal String
     */
    @JsonGetter("valid_until_local_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetValidUntilLocalTime() {
        return this.validUntilLocalTime;
    }

    /**
     * Getter for ValidUntilLocalTime.
     * Represents the local time the pricing rule should be valid until. Represented in RFC 3339
     * partial-time format (HH:MM:SS). Partial seconds will be truncated.
     * @return Returns the String
     */
    @JsonIgnore
    public String getValidUntilLocalTime() {
        return OptionalNullable.getFrom(validUntilLocalTime);
    }

    /**
     * Getter for ExcludeStrategy.
     * Indicates which products matched by a CatalogPricingRule will be excluded if the pricing rule
     * uses an exclude set.
     * @return Returns the String
     */
    @JsonGetter("exclude_strategy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExcludeStrategy() {
        return excludeStrategy;
    }

    /**
     * Getter for MinimumOrderSubtotalMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("minimum_order_subtotal_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getMinimumOrderSubtotalMoney() {
        return minimumOrderSubtotalMoney;
    }

    /**
     * Internal Getter for CustomerGroupIdsAny.
     * A list of IDs of customer groups, the members of which are eligible for discounts specified
     * in this pricing rule. Notice that a group ID is generated by the Customers API. If this field
     * is not set, the specified discount applies to matched products sold to anyone whether the
     * buyer has a customer profile created or not. If this `customer_group_ids_any` field is set,
     * the specified discount applies only to matched products sold to customers belonging to the
     * specified customer groups.
     * @return Returns the Internal List of String
     */
    @JsonGetter("customer_group_ids_any")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetCustomerGroupIdsAny() {
        return this.customerGroupIdsAny;
    }

    /**
     * Getter for CustomerGroupIdsAny.
     * A list of IDs of customer groups, the members of which are eligible for discounts specified
     * in this pricing rule. Notice that a group ID is generated by the Customers API. If this field
     * is not set, the specified discount applies to matched products sold to anyone whether the
     * buyer has a customer profile created or not. If this `customer_group_ids_any` field is set,
     * the specified discount applies only to matched products sold to customers belonging to the
     * specified customer groups.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCustomerGroupIdsAny() {
        return OptionalNullable.getFrom(customerGroupIdsAny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timePeriodIds, discountId, matchProductsId, applyProductsId,
                excludeProductsId, validFromDate, validFromLocalTime, validUntilDate,
                validUntilLocalTime, excludeStrategy, minimumOrderSubtotalMoney,
                customerGroupIdsAny);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogPricingRule)) {
            return false;
        }
        CatalogPricingRule other = (CatalogPricingRule) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(timePeriodIds, other.timePeriodIds)
            && Objects.equals(discountId, other.discountId)
            && Objects.equals(matchProductsId, other.matchProductsId)
            && Objects.equals(applyProductsId, other.applyProductsId)
            && Objects.equals(excludeProductsId, other.excludeProductsId)
            && Objects.equals(validFromDate, other.validFromDate)
            && Objects.equals(validFromLocalTime, other.validFromLocalTime)
            && Objects.equals(validUntilDate, other.validUntilDate)
            && Objects.equals(validUntilLocalTime, other.validUntilLocalTime)
            && Objects.equals(excludeStrategy, other.excludeStrategy)
            && Objects.equals(minimumOrderSubtotalMoney, other.minimumOrderSubtotalMoney)
            && Objects.equals(customerGroupIdsAny, other.customerGroupIdsAny);
    }

    /**
     * Converts this CatalogPricingRule into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogPricingRule [" + "name=" + name + ", timePeriodIds=" + timePeriodIds
                + ", discountId=" + discountId + ", matchProductsId=" + matchProductsId
                + ", applyProductsId=" + applyProductsId + ", excludeProductsId="
                + excludeProductsId + ", validFromDate=" + validFromDate + ", validFromLocalTime="
                + validFromLocalTime + ", validUntilDate=" + validUntilDate
                + ", validUntilLocalTime=" + validUntilLocalTime + ", excludeStrategy="
                + excludeStrategy + ", minimumOrderSubtotalMoney=" + minimumOrderSubtotalMoney
                + ", customerGroupIdsAny=" + customerGroupIdsAny + "]";
    }

    /**
     * Builds a new {@link CatalogPricingRule.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogPricingRule.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .excludeStrategy(getExcludeStrategy())
                .minimumOrderSubtotalMoney(getMinimumOrderSubtotalMoney());
        builder.name = internalGetName();
        builder.timePeriodIds = internalGetTimePeriodIds();
        builder.discountId = internalGetDiscountId();
        builder.matchProductsId = internalGetMatchProductsId();
        builder.applyProductsId = internalGetApplyProductsId();
        builder.excludeProductsId = internalGetExcludeProductsId();
        builder.validFromDate = internalGetValidFromDate();
        builder.validFromLocalTime = internalGetValidFromLocalTime();
        builder.validUntilDate = internalGetValidUntilDate();
        builder.validUntilLocalTime = internalGetValidUntilLocalTime();
        builder.customerGroupIdsAny = internalGetCustomerGroupIdsAny();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogPricingRule}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<List<String>> timePeriodIds;
        private OptionalNullable<String> discountId;
        private OptionalNullable<String> matchProductsId;
        private OptionalNullable<String> applyProductsId;
        private OptionalNullable<String> excludeProductsId;
        private OptionalNullable<String> validFromDate;
        private OptionalNullable<String> validFromLocalTime;
        private OptionalNullable<String> validUntilDate;
        private OptionalNullable<String> validUntilLocalTime;
        private String excludeStrategy;
        private Money minimumOrderSubtotalMoney;
        private OptionalNullable<List<String>> customerGroupIdsAny;



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
         * Setter for timePeriodIds.
         * @param  timePeriodIds  List of String value for timePeriodIds.
         * @return Builder
         */
        public Builder timePeriodIds(List<String> timePeriodIds) {
            this.timePeriodIds = OptionalNullable.of(timePeriodIds);
            return this;
        }

        /**
         * UnSetter for timePeriodIds.
         * @return Builder
         */
        public Builder unsetTimePeriodIds() {
            timePeriodIds = null;
            return this;
        }

        /**
         * Setter for discountId.
         * @param  discountId  String value for discountId.
         * @return Builder
         */
        public Builder discountId(String discountId) {
            this.discountId = OptionalNullable.of(discountId);
            return this;
        }

        /**
         * UnSetter for discountId.
         * @return Builder
         */
        public Builder unsetDiscountId() {
            discountId = null;
            return this;
        }

        /**
         * Setter for matchProductsId.
         * @param  matchProductsId  String value for matchProductsId.
         * @return Builder
         */
        public Builder matchProductsId(String matchProductsId) {
            this.matchProductsId = OptionalNullable.of(matchProductsId);
            return this;
        }

        /**
         * UnSetter for matchProductsId.
         * @return Builder
         */
        public Builder unsetMatchProductsId() {
            matchProductsId = null;
            return this;
        }

        /**
         * Setter for applyProductsId.
         * @param  applyProductsId  String value for applyProductsId.
         * @return Builder
         */
        public Builder applyProductsId(String applyProductsId) {
            this.applyProductsId = OptionalNullable.of(applyProductsId);
            return this;
        }

        /**
         * UnSetter for applyProductsId.
         * @return Builder
         */
        public Builder unsetApplyProductsId() {
            applyProductsId = null;
            return this;
        }

        /**
         * Setter for excludeProductsId.
         * @param  excludeProductsId  String value for excludeProductsId.
         * @return Builder
         */
        public Builder excludeProductsId(String excludeProductsId) {
            this.excludeProductsId = OptionalNullable.of(excludeProductsId);
            return this;
        }

        /**
         * UnSetter for excludeProductsId.
         * @return Builder
         */
        public Builder unsetExcludeProductsId() {
            excludeProductsId = null;
            return this;
        }

        /**
         * Setter for validFromDate.
         * @param  validFromDate  String value for validFromDate.
         * @return Builder
         */
        public Builder validFromDate(String validFromDate) {
            this.validFromDate = OptionalNullable.of(validFromDate);
            return this;
        }

        /**
         * UnSetter for validFromDate.
         * @return Builder
         */
        public Builder unsetValidFromDate() {
            validFromDate = null;
            return this;
        }

        /**
         * Setter for validFromLocalTime.
         * @param  validFromLocalTime  String value for validFromLocalTime.
         * @return Builder
         */
        public Builder validFromLocalTime(String validFromLocalTime) {
            this.validFromLocalTime = OptionalNullable.of(validFromLocalTime);
            return this;
        }

        /**
         * UnSetter for validFromLocalTime.
         * @return Builder
         */
        public Builder unsetValidFromLocalTime() {
            validFromLocalTime = null;
            return this;
        }

        /**
         * Setter for validUntilDate.
         * @param  validUntilDate  String value for validUntilDate.
         * @return Builder
         */
        public Builder validUntilDate(String validUntilDate) {
            this.validUntilDate = OptionalNullable.of(validUntilDate);
            return this;
        }

        /**
         * UnSetter for validUntilDate.
         * @return Builder
         */
        public Builder unsetValidUntilDate() {
            validUntilDate = null;
            return this;
        }

        /**
         * Setter for validUntilLocalTime.
         * @param  validUntilLocalTime  String value for validUntilLocalTime.
         * @return Builder
         */
        public Builder validUntilLocalTime(String validUntilLocalTime) {
            this.validUntilLocalTime = OptionalNullable.of(validUntilLocalTime);
            return this;
        }

        /**
         * UnSetter for validUntilLocalTime.
         * @return Builder
         */
        public Builder unsetValidUntilLocalTime() {
            validUntilLocalTime = null;
            return this;
        }

        /**
         * Setter for excludeStrategy.
         * @param  excludeStrategy  String value for excludeStrategy.
         * @return Builder
         */
        public Builder excludeStrategy(String excludeStrategy) {
            this.excludeStrategy = excludeStrategy;
            return this;
        }

        /**
         * Setter for minimumOrderSubtotalMoney.
         * @param  minimumOrderSubtotalMoney  Money value for minimumOrderSubtotalMoney.
         * @return Builder
         */
        public Builder minimumOrderSubtotalMoney(Money minimumOrderSubtotalMoney) {
            this.minimumOrderSubtotalMoney = minimumOrderSubtotalMoney;
            return this;
        }

        /**
         * Setter for customerGroupIdsAny.
         * @param  customerGroupIdsAny  List of String value for customerGroupIdsAny.
         * @return Builder
         */
        public Builder customerGroupIdsAny(List<String> customerGroupIdsAny) {
            this.customerGroupIdsAny = OptionalNullable.of(customerGroupIdsAny);
            return this;
        }

        /**
         * UnSetter for customerGroupIdsAny.
         * @return Builder
         */
        public Builder unsetCustomerGroupIdsAny() {
            customerGroupIdsAny = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogPricingRule} object using the set fields.
         * @return {@link CatalogPricingRule}
         */
        public CatalogPricingRule build() {
            return new CatalogPricingRule(name, timePeriodIds, discountId, matchProductsId,
                    applyProductsId, excludeProductsId, validFromDate, validFromLocalTime,
                    validUntilDate, validUntilLocalTime, excludeStrategy, minimumOrderSubtotalMoney,
                    customerGroupIdsAny);
        }
    }
}
