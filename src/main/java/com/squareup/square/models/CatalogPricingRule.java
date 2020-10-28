
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CatalogPricingRule type.
 */
public class CatalogPricingRule {
    private final String name;
    private final List<String> timePeriodIds;
    private final String discountId;
    private final String matchProductsId;
    private final String applyProductsId;
    private final String excludeProductsId;
    private final String validFromDate;
    private final String validFromLocalTime;
    private final String validUntilDate;
    private final String validUntilLocalTime;
    private final String excludeStrategy;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param timePeriodIds List of String value for timePeriodIds.
     * @param discountId String value for discountId.
     * @param matchProductsId String value for matchProductsId.
     * @param applyProductsId String value for applyProductsId.
     * @param excludeProductsId String value for excludeProductsId.
     * @param validFromDate String value for validFromDate.
     * @param validFromLocalTime String value for validFromLocalTime.
     * @param validUntilDate String value for validUntilDate.
     * @param validUntilLocalTime String value for validUntilLocalTime.
     * @param excludeStrategy String value for excludeStrategy.
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
            @JsonProperty("exclude_strategy") String excludeStrategy) {
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
    }

    /**
     * Getter for Name.
     * User-defined name for the pricing rule. For example, "Buy one get one free" or "10% off".
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for TimePeriodIds.
     * A list of unique IDs for the catalog time periods when this pricing rule is in effect. If
     * left unset, the pricing rule is always in effect.
     * @return Returns the List of String
     */
    @JsonGetter("time_period_ids")
    public List<String> getTimePeriodIds() {
        return this.timePeriodIds;
    }

    /**
     * Getter for DiscountId.
     * Unique ID for the `CatalogDiscount` to take off the price of all matched items.
     * @return Returns the String
     */
    @JsonGetter("discount_id")
    public String getDiscountId() {
        return this.discountId;
    }

    /**
     * Getter for MatchProductsId.
     * Unique ID for the `CatalogProductSet` that will be matched by this rule. A match rule matches
     * within the entire cart, and can match multiple times. This field will always be set.
     * @return Returns the String
     */
    @JsonGetter("match_products_id")
    public String getMatchProductsId() {
        return this.matchProductsId;
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
    @JsonGetter("apply_products_id")
    public String getApplyProductsId() {
        return this.applyProductsId;
    }

    /**
     * Getter for ExcludeProductsId.
     * `CatalogProductSet` to exclude from the pricing rule. An exclude rule matches within the
     * subset of the cart that fits the match rules (the match set). An exclude rule can only match
     * once in the match set. If not supplied, the pricing will be applied to all products in the
     * match set. Other products retain their base price, or a price generated by other rules.
     * @return Returns the String
     */
    @JsonGetter("exclude_products_id")
    public String getExcludeProductsId() {
        return this.excludeProductsId;
    }

    /**
     * Getter for ValidFromDate.
     * Represents the date the Pricing Rule is valid from. Represented in RFC 3339 full-date format
     * (YYYY-MM-DD).
     * @return Returns the String
     */
    @JsonGetter("valid_from_date")
    public String getValidFromDate() {
        return this.validFromDate;
    }

    /**
     * Getter for ValidFromLocalTime.
     * Represents the local time the pricing rule should be valid from. Represented in RFC 3339
     * partial-time format (HH:MM:SS). Partial seconds will be truncated.
     * @return Returns the String
     */
    @JsonGetter("valid_from_local_time")
    public String getValidFromLocalTime() {
        return this.validFromLocalTime;
    }

    /**
     * Getter for ValidUntilDate.
     * Represents the date the Pricing Rule is valid until. Represented in RFC 3339 full-date format
     * (YYYY-MM-DD).
     * @return Returns the String
     */
    @JsonGetter("valid_until_date")
    public String getValidUntilDate() {
        return this.validUntilDate;
    }

    /**
     * Getter for ValidUntilLocalTime.
     * Represents the local time the pricing rule should be valid until. Represented in RFC 3339
     * partial-time format (HH:MM:SS). Partial seconds will be truncated.
     * @return Returns the String
     */
    @JsonGetter("valid_until_local_time")
    public String getValidUntilLocalTime() {
        return this.validUntilLocalTime;
    }

    /**
     * Getter for ExcludeStrategy.
     * Indicates which products matched by a CatalogPricingRule will be excluded if the pricing rule
     * uses an exclude set.
     * @return Returns the String
     */
    @JsonGetter("exclude_strategy")
    public String getExcludeStrategy() {
        return this.excludeStrategy;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, timePeriodIds, discountId, matchProductsId, applyProductsId,
                excludeProductsId, validFromDate, validFromLocalTime, validUntilDate,
                validUntilLocalTime, excludeStrategy);
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
            && Objects.equals(excludeStrategy, other.excludeStrategy);
    }

    /**
     * Builds a new {@link CatalogPricingRule.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogPricingRule.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .timePeriodIds(getTimePeriodIds())
            .discountId(getDiscountId())
            .matchProductsId(getMatchProductsId())
            .applyProductsId(getApplyProductsId())
            .excludeProductsId(getExcludeProductsId())
            .validFromDate(getValidFromDate())
            .validFromLocalTime(getValidFromLocalTime())
            .validUntilDate(getValidUntilDate())
            .validUntilLocalTime(getValidUntilLocalTime())
            .excludeStrategy(getExcludeStrategy());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogPricingRule}.
     */
    public static class Builder {
        private String name;
        private List<String> timePeriodIds;
        private String discountId;
        private String matchProductsId;
        private String applyProductsId;
        private String excludeProductsId;
        private String validFromDate;
        private String validFromLocalTime;
        private String validUntilDate;
        private String validUntilLocalTime;
        private String excludeStrategy;



        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for timePeriodIds.
         * @param timePeriodIds List of String value for timePeriodIds.
         * @return Builder
         */
        public Builder timePeriodIds(List<String> timePeriodIds) {
            this.timePeriodIds = timePeriodIds;
            return this;
        }

        /**
         * Setter for discountId.
         * @param discountId String value for discountId.
         * @return Builder
         */
        public Builder discountId(String discountId) {
            this.discountId = discountId;
            return this;
        }

        /**
         * Setter for matchProductsId.
         * @param matchProductsId String value for matchProductsId.
         * @return Builder
         */
        public Builder matchProductsId(String matchProductsId) {
            this.matchProductsId = matchProductsId;
            return this;
        }

        /**
         * Setter for applyProductsId.
         * @param applyProductsId String value for applyProductsId.
         * @return Builder
         */
        public Builder applyProductsId(String applyProductsId) {
            this.applyProductsId = applyProductsId;
            return this;
        }

        /**
         * Setter for excludeProductsId.
         * @param excludeProductsId String value for excludeProductsId.
         * @return Builder
         */
        public Builder excludeProductsId(String excludeProductsId) {
            this.excludeProductsId = excludeProductsId;
            return this;
        }

        /**
         * Setter for validFromDate.
         * @param validFromDate String value for validFromDate.
         * @return Builder
         */
        public Builder validFromDate(String validFromDate) {
            this.validFromDate = validFromDate;
            return this;
        }

        /**
         * Setter for validFromLocalTime.
         * @param validFromLocalTime String value for validFromLocalTime.
         * @return Builder
         */
        public Builder validFromLocalTime(String validFromLocalTime) {
            this.validFromLocalTime = validFromLocalTime;
            return this;
        }

        /**
         * Setter for validUntilDate.
         * @param validUntilDate String value for validUntilDate.
         * @return Builder
         */
        public Builder validUntilDate(String validUntilDate) {
            this.validUntilDate = validUntilDate;
            return this;
        }

        /**
         * Setter for validUntilLocalTime.
         * @param validUntilLocalTime String value for validUntilLocalTime.
         * @return Builder
         */
        public Builder validUntilLocalTime(String validUntilLocalTime) {
            this.validUntilLocalTime = validUntilLocalTime;
            return this;
        }

        /**
         * Setter for excludeStrategy.
         * @param excludeStrategy String value for excludeStrategy.
         * @return Builder
         */
        public Builder excludeStrategy(String excludeStrategy) {
            this.excludeStrategy = excludeStrategy;
            return this;
        }

        /**
         * Builds a new {@link CatalogPricingRule} object using the set fields.
         * @return {@link CatalogPricingRule}
         */
        public CatalogPricingRule build() {
            return new CatalogPricingRule(name,
                timePeriodIds,
                discountId,
                matchProductsId,
                applyProductsId,
                excludeProductsId,
                validFromDate,
                validFromLocalTime,
                validUntilDate,
                validUntilLocalTime,
                excludeStrategy);
        }
    }
}
