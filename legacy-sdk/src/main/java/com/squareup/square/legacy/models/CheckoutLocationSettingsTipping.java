package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CheckoutLocationSettingsTipping type.
 */
public class CheckoutLocationSettingsTipping {
    private final OptionalNullable<List<Integer>> percentages;
    private final OptionalNullable<Boolean> smartTippingEnabled;
    private final OptionalNullable<Integer> defaultPercent;
    private final OptionalNullable<List<Money>> smartTips;
    private final Money defaultSmartTip;

    /**
     * Initialization constructor.
     * @param  percentages  List of Integer value for percentages.
     * @param  smartTippingEnabled  Boolean value for smartTippingEnabled.
     * @param  defaultPercent  Integer value for defaultPercent.
     * @param  smartTips  List of Money value for smartTips.
     * @param  defaultSmartTip  Money value for defaultSmartTip.
     */
    @JsonCreator
    public CheckoutLocationSettingsTipping(
            @JsonProperty("percentages") List<Integer> percentages,
            @JsonProperty("smart_tipping_enabled") Boolean smartTippingEnabled,
            @JsonProperty("default_percent") Integer defaultPercent,
            @JsonProperty("smart_tips") List<Money> smartTips,
            @JsonProperty("default_smart_tip") Money defaultSmartTip) {
        this.percentages = OptionalNullable.of(percentages);
        this.smartTippingEnabled = OptionalNullable.of(smartTippingEnabled);
        this.defaultPercent = OptionalNullable.of(defaultPercent);
        this.smartTips = OptionalNullable.of(smartTips);
        this.defaultSmartTip = defaultSmartTip;
    }

    /**
     * Initialization constructor.
     * @param  percentages  List of Integer value for percentages.
     * @param  smartTippingEnabled  Boolean value for smartTippingEnabled.
     * @param  defaultPercent  Integer value for defaultPercent.
     * @param  smartTips  List of Money value for smartTips.
     * @param  defaultSmartTip  Money value for defaultSmartTip.
     */
    protected CheckoutLocationSettingsTipping(
            OptionalNullable<List<Integer>> percentages,
            OptionalNullable<Boolean> smartTippingEnabled,
            OptionalNullable<Integer> defaultPercent,
            OptionalNullable<List<Money>> smartTips,
            Money defaultSmartTip) {
        this.percentages = percentages;
        this.smartTippingEnabled = smartTippingEnabled;
        this.defaultPercent = defaultPercent;
        this.smartTips = smartTips;
        this.defaultSmartTip = defaultSmartTip;
    }

    /**
     * Internal Getter for Percentages.
     * Set three custom percentage amounts that buyers can select at checkout. If Smart Tip is
     * enabled, this only applies to transactions totaling $10 or more.
     * @return Returns the Internal List of Integer
     */
    @JsonGetter("percentages")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Integer>> internalGetPercentages() {
        return this.percentages;
    }

    /**
     * Getter for Percentages.
     * Set three custom percentage amounts that buyers can select at checkout. If Smart Tip is
     * enabled, this only applies to transactions totaling $10 or more.
     * @return Returns the List of Integer
     */
    @JsonIgnore
    public List<Integer> getPercentages() {
        return OptionalNullable.getFrom(percentages);
    }

    /**
     * Internal Getter for SmartTippingEnabled.
     * Enables Smart Tip Amounts. If Smart Tip Amounts is enabled, tipping works as follows: If a
     * transaction is less than $10, the available tipping options include No Tip, $1, $2, or $3. If
     * a transaction is $10 or more, the available tipping options include No Tip, 15%, 20%, or 25%.
     * You can set custom percentage amounts with the `percentages` field.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("smart_tipping_enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSmartTippingEnabled() {
        return this.smartTippingEnabled;
    }

    /**
     * Getter for SmartTippingEnabled.
     * Enables Smart Tip Amounts. If Smart Tip Amounts is enabled, tipping works as follows: If a
     * transaction is less than $10, the available tipping options include No Tip, $1, $2, or $3. If
     * a transaction is $10 or more, the available tipping options include No Tip, 15%, 20%, or 25%.
     * You can set custom percentage amounts with the `percentages` field.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSmartTippingEnabled() {
        return OptionalNullable.getFrom(smartTippingEnabled);
    }

    /**
     * Internal Getter for DefaultPercent.
     * Set the pre-selected percentage amounts that appear at checkout. If Smart Tip is enabled,
     * this only applies to transactions totaling $10 or more.
     * @return Returns the Internal Integer
     */
    @JsonGetter("default_percent")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetDefaultPercent() {
        return this.defaultPercent;
    }

    /**
     * Getter for DefaultPercent.
     * Set the pre-selected percentage amounts that appear at checkout. If Smart Tip is enabled,
     * this only applies to transactions totaling $10 or more.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getDefaultPercent() {
        return OptionalNullable.getFrom(defaultPercent);
    }

    /**
     * Internal Getter for SmartTips.
     * Show the Smart Tip Amounts for this location.
     * @return Returns the Internal List of Money
     */
    @JsonGetter("smart_tips")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Money>> internalGetSmartTips() {
        return this.smartTips;
    }

    /**
     * Getter for SmartTips.
     * Show the Smart Tip Amounts for this location.
     * @return Returns the List of Money
     */
    @JsonIgnore
    public List<Money> getSmartTips() {
        return OptionalNullable.getFrom(smartTips);
    }

    /**
     * Getter for DefaultSmartTip.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("default_smart_tip")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getDefaultSmartTip() {
        return defaultSmartTip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentages, smartTippingEnabled, defaultPercent, smartTips, defaultSmartTip);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutLocationSettingsTipping)) {
            return false;
        }
        CheckoutLocationSettingsTipping other = (CheckoutLocationSettingsTipping) obj;
        return Objects.equals(percentages, other.percentages)
                && Objects.equals(smartTippingEnabled, other.smartTippingEnabled)
                && Objects.equals(defaultPercent, other.defaultPercent)
                && Objects.equals(smartTips, other.smartTips)
                && Objects.equals(defaultSmartTip, other.defaultSmartTip);
    }

    /**
     * Converts this CheckoutLocationSettingsTipping into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutLocationSettingsTipping [" + "percentages=" + percentages
                + ", smartTippingEnabled=" + smartTippingEnabled + ", defaultPercent="
                + defaultPercent + ", smartTips=" + smartTips + ", defaultSmartTip="
                + defaultSmartTip + "]";
    }

    /**
     * Builds a new {@link CheckoutLocationSettingsTipping.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutLocationSettingsTipping.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().defaultSmartTip(getDefaultSmartTip());
        builder.percentages = internalGetPercentages();
        builder.smartTippingEnabled = internalGetSmartTippingEnabled();
        builder.defaultPercent = internalGetDefaultPercent();
        builder.smartTips = internalGetSmartTips();
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutLocationSettingsTipping}.
     */
    public static class Builder {
        private OptionalNullable<List<Integer>> percentages;
        private OptionalNullable<Boolean> smartTippingEnabled;
        private OptionalNullable<Integer> defaultPercent;
        private OptionalNullable<List<Money>> smartTips;
        private Money defaultSmartTip;

        /**
         * Setter for percentages.
         * @param  percentages  List of Integer value for percentages.
         * @return Builder
         */
        public Builder percentages(List<Integer> percentages) {
            this.percentages = OptionalNullable.of(percentages);
            return this;
        }

        /**
         * UnSetter for percentages.
         * @return Builder
         */
        public Builder unsetPercentages() {
            percentages = null;
            return this;
        }

        /**
         * Setter for smartTippingEnabled.
         * @param  smartTippingEnabled  Boolean value for smartTippingEnabled.
         * @return Builder
         */
        public Builder smartTippingEnabled(Boolean smartTippingEnabled) {
            this.smartTippingEnabled = OptionalNullable.of(smartTippingEnabled);
            return this;
        }

        /**
         * UnSetter for smartTippingEnabled.
         * @return Builder
         */
        public Builder unsetSmartTippingEnabled() {
            smartTippingEnabled = null;
            return this;
        }

        /**
         * Setter for defaultPercent.
         * @param  defaultPercent  Integer value for defaultPercent.
         * @return Builder
         */
        public Builder defaultPercent(Integer defaultPercent) {
            this.defaultPercent = OptionalNullable.of(defaultPercent);
            return this;
        }

        /**
         * UnSetter for defaultPercent.
         * @return Builder
         */
        public Builder unsetDefaultPercent() {
            defaultPercent = null;
            return this;
        }

        /**
         * Setter for smartTips.
         * @param  smartTips  List of Money value for smartTips.
         * @return Builder
         */
        public Builder smartTips(List<Money> smartTips) {
            this.smartTips = OptionalNullable.of(smartTips);
            return this;
        }

        /**
         * UnSetter for smartTips.
         * @return Builder
         */
        public Builder unsetSmartTips() {
            smartTips = null;
            return this;
        }

        /**
         * Setter for defaultSmartTip.
         * @param  defaultSmartTip  Money value for defaultSmartTip.
         * @return Builder
         */
        public Builder defaultSmartTip(Money defaultSmartTip) {
            this.defaultSmartTip = defaultSmartTip;
            return this;
        }

        /**
         * Builds a new {@link CheckoutLocationSettingsTipping} object using the set fields.
         * @return {@link CheckoutLocationSettingsTipping}
         */
        public CheckoutLocationSettingsTipping build() {
            return new CheckoutLocationSettingsTipping(
                    percentages, smartTippingEnabled, defaultPercent, smartTips, defaultSmartTip);
        }
    }
}
