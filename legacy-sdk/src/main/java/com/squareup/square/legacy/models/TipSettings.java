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
 * This is a model class for TipSettings type.
 */
public class TipSettings {
    private final OptionalNullable<Boolean> allowTipping;
    private final OptionalNullable<Boolean> separateTipScreen;
    private final OptionalNullable<Boolean> customTipField;
    private final OptionalNullable<List<Integer>> tipPercentages;
    private final OptionalNullable<Boolean> smartTipping;

    /**
     * Initialization constructor.
     * @param  allowTipping  Boolean value for allowTipping.
     * @param  separateTipScreen  Boolean value for separateTipScreen.
     * @param  customTipField  Boolean value for customTipField.
     * @param  tipPercentages  List of Integer value for tipPercentages.
     * @param  smartTipping  Boolean value for smartTipping.
     */
    @JsonCreator
    public TipSettings(
            @JsonProperty("allow_tipping") Boolean allowTipping,
            @JsonProperty("separate_tip_screen") Boolean separateTipScreen,
            @JsonProperty("custom_tip_field") Boolean customTipField,
            @JsonProperty("tip_percentages") List<Integer> tipPercentages,
            @JsonProperty("smart_tipping") Boolean smartTipping) {
        this.allowTipping = OptionalNullable.of(allowTipping);
        this.separateTipScreen = OptionalNullable.of(separateTipScreen);
        this.customTipField = OptionalNullable.of(customTipField);
        this.tipPercentages = OptionalNullable.of(tipPercentages);
        this.smartTipping = OptionalNullable.of(smartTipping);
    }

    /**
     * Initialization constructor.
     * @param  allowTipping  Boolean value for allowTipping.
     * @param  separateTipScreen  Boolean value for separateTipScreen.
     * @param  customTipField  Boolean value for customTipField.
     * @param  tipPercentages  List of Integer value for tipPercentages.
     * @param  smartTipping  Boolean value for smartTipping.
     */
    protected TipSettings(
            OptionalNullable<Boolean> allowTipping,
            OptionalNullable<Boolean> separateTipScreen,
            OptionalNullable<Boolean> customTipField,
            OptionalNullable<List<Integer>> tipPercentages,
            OptionalNullable<Boolean> smartTipping) {
        this.allowTipping = allowTipping;
        this.separateTipScreen = separateTipScreen;
        this.customTipField = customTipField;
        this.tipPercentages = tipPercentages;
        this.smartTipping = smartTipping;
    }

    /**
     * Internal Getter for AllowTipping.
     * Indicates whether tipping is enabled for this checkout. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("allow_tipping")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAllowTipping() {
        return this.allowTipping;
    }

    /**
     * Getter for AllowTipping.
     * Indicates whether tipping is enabled for this checkout. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAllowTipping() {
        return OptionalNullable.getFrom(allowTipping);
    }

    /**
     * Internal Getter for SeparateTipScreen.
     * Indicates whether tip options should be presented on the screen before presenting the
     * signature screen during card payment. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("separate_tip_screen")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSeparateTipScreen() {
        return this.separateTipScreen;
    }

    /**
     * Getter for SeparateTipScreen.
     * Indicates whether tip options should be presented on the screen before presenting the
     * signature screen during card payment. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSeparateTipScreen() {
        return OptionalNullable.getFrom(separateTipScreen);
    }

    /**
     * Internal Getter for CustomTipField.
     * Indicates whether custom tip amounts are allowed during the checkout flow. Defaults to false.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("custom_tip_field")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCustomTipField() {
        return this.customTipField;
    }

    /**
     * Getter for CustomTipField.
     * Indicates whether custom tip amounts are allowed during the checkout flow. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCustomTipField() {
        return OptionalNullable.getFrom(customTipField);
    }

    /**
     * Internal Getter for TipPercentages.
     * A list of tip percentages that should be presented during the checkout flow, specified as up
     * to 3 non-negative integers from 0 to 100 (inclusive). Defaults to 15, 20, and 25.
     * @return Returns the Internal List of Integer
     */
    @JsonGetter("tip_percentages")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Integer>> internalGetTipPercentages() {
        return this.tipPercentages;
    }

    /**
     * Getter for TipPercentages.
     * A list of tip percentages that should be presented during the checkout flow, specified as up
     * to 3 non-negative integers from 0 to 100 (inclusive). Defaults to 15, 20, and 25.
     * @return Returns the List of Integer
     */
    @JsonIgnore
    public List<Integer> getTipPercentages() {
        return OptionalNullable.getFrom(tipPercentages);
    }

    /**
     * Internal Getter for SmartTipping.
     * Enables the "Smart Tip Amounts" behavior. Exact tipping options depend on the region in which
     * the Square seller is active. For payments under 10.00, in the Australia, Canada, Ireland,
     * United Kingdom, and United States, tipping options are presented as no tip, .50, 1.00 or
     * 2.00. For payment amounts of 10.00 or greater, tipping options are presented as the following
     * percentages: 0%, 5%, 10%, 15%. If set to true, the `tip_percentages` settings is ignored.
     * Defaults to false. To learn more about smart tipping, see [Accept Tips with the Square
     * App](https://squareup.com/help/us/en/article/5069-accept-tips-with-the-square-app).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("smart_tipping")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSmartTipping() {
        return this.smartTipping;
    }

    /**
     * Getter for SmartTipping.
     * Enables the "Smart Tip Amounts" behavior. Exact tipping options depend on the region in which
     * the Square seller is active. For payments under 10.00, in the Australia, Canada, Ireland,
     * United Kingdom, and United States, tipping options are presented as no tip, .50, 1.00 or
     * 2.00. For payment amounts of 10.00 or greater, tipping options are presented as the following
     * percentages: 0%, 5%, 10%, 15%. If set to true, the `tip_percentages` settings is ignored.
     * Defaults to false. To learn more about smart tipping, see [Accept Tips with the Square
     * App](https://squareup.com/help/us/en/article/5069-accept-tips-with-the-square-app).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSmartTipping() {
        return OptionalNullable.getFrom(smartTipping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowTipping, separateTipScreen, customTipField, tipPercentages, smartTipping);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TipSettings)) {
            return false;
        }
        TipSettings other = (TipSettings) obj;
        return Objects.equals(allowTipping, other.allowTipping)
                && Objects.equals(separateTipScreen, other.separateTipScreen)
                && Objects.equals(customTipField, other.customTipField)
                && Objects.equals(tipPercentages, other.tipPercentages)
                && Objects.equals(smartTipping, other.smartTipping);
    }

    /**
     * Converts this TipSettings into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TipSettings [" + "allowTipping=" + allowTipping + ", separateTipScreen="
                + separateTipScreen + ", customTipField=" + customTipField + ", tipPercentages="
                + tipPercentages + ", smartTipping=" + smartTipping + "]";
    }

    /**
     * Builds a new {@link TipSettings.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TipSettings.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.allowTipping = internalGetAllowTipping();
        builder.separateTipScreen = internalGetSeparateTipScreen();
        builder.customTipField = internalGetCustomTipField();
        builder.tipPercentages = internalGetTipPercentages();
        builder.smartTipping = internalGetSmartTipping();
        return builder;
    }

    /**
     * Class to build instances of {@link TipSettings}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> allowTipping;
        private OptionalNullable<Boolean> separateTipScreen;
        private OptionalNullable<Boolean> customTipField;
        private OptionalNullable<List<Integer>> tipPercentages;
        private OptionalNullable<Boolean> smartTipping;

        /**
         * Setter for allowTipping.
         * @param  allowTipping  Boolean value for allowTipping.
         * @return Builder
         */
        public Builder allowTipping(Boolean allowTipping) {
            this.allowTipping = OptionalNullable.of(allowTipping);
            return this;
        }

        /**
         * UnSetter for allowTipping.
         * @return Builder
         */
        public Builder unsetAllowTipping() {
            allowTipping = null;
            return this;
        }

        /**
         * Setter for separateTipScreen.
         * @param  separateTipScreen  Boolean value for separateTipScreen.
         * @return Builder
         */
        public Builder separateTipScreen(Boolean separateTipScreen) {
            this.separateTipScreen = OptionalNullable.of(separateTipScreen);
            return this;
        }

        /**
         * UnSetter for separateTipScreen.
         * @return Builder
         */
        public Builder unsetSeparateTipScreen() {
            separateTipScreen = null;
            return this;
        }

        /**
         * Setter for customTipField.
         * @param  customTipField  Boolean value for customTipField.
         * @return Builder
         */
        public Builder customTipField(Boolean customTipField) {
            this.customTipField = OptionalNullable.of(customTipField);
            return this;
        }

        /**
         * UnSetter for customTipField.
         * @return Builder
         */
        public Builder unsetCustomTipField() {
            customTipField = null;
            return this;
        }

        /**
         * Setter for tipPercentages.
         * @param  tipPercentages  List of Integer value for tipPercentages.
         * @return Builder
         */
        public Builder tipPercentages(List<Integer> tipPercentages) {
            this.tipPercentages = OptionalNullable.of(tipPercentages);
            return this;
        }

        /**
         * UnSetter for tipPercentages.
         * @return Builder
         */
        public Builder unsetTipPercentages() {
            tipPercentages = null;
            return this;
        }

        /**
         * Setter for smartTipping.
         * @param  smartTipping  Boolean value for smartTipping.
         * @return Builder
         */
        public Builder smartTipping(Boolean smartTipping) {
            this.smartTipping = OptionalNullable.of(smartTipping);
            return this;
        }

        /**
         * UnSetter for smartTipping.
         * @return Builder
         */
        public Builder unsetSmartTipping() {
            smartTipping = null;
            return this;
        }

        /**
         * Builds a new {@link TipSettings} object using the set fields.
         * @return {@link TipSettings}
         */
        public TipSettings build() {
            return new TipSettings(allowTipping, separateTipScreen, customTipField, tipPercentages, smartTipping);
        }
    }
}
