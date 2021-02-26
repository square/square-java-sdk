
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for TipSettings type.
 */
public class TipSettings {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean allowTipping;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean separateTipScreen;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean customTipField;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Integer> tipPercentages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean smartTipping;

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
        this.allowTipping = allowTipping;
        this.separateTipScreen = separateTipScreen;
        this.customTipField = customTipField;
        this.tipPercentages = tipPercentages;
        this.smartTipping = smartTipping;
    }

    /**
     * Getter for AllowTipping.
     * Indicates whether tipping is enabled for this checkout. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonGetter("allow_tipping")
    public Boolean getAllowTipping() {
        return allowTipping;
    }

    /**
     * Getter for SeparateTipScreen.
     * Indicates whether tip options should be presented on their own screen before presenting the
     * signature screen during card payment. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonGetter("separate_tip_screen")
    public Boolean getSeparateTipScreen() {
        return separateTipScreen;
    }

    /**
     * Getter for CustomTipField.
     * Indicates whether custom tip amounts are allowed during the checkout flow. Defaults to false.
     * @return Returns the Boolean
     */
    @JsonGetter("custom_tip_field")
    public Boolean getCustomTipField() {
        return customTipField;
    }

    /**
     * Getter for TipPercentages.
     * A list of tip percentages that should be presented during the checkout flow. Specified as up
     * to 3 non-negative integers from 0 to 100 (inclusive). Defaults to [15, 20, 25]
     * @return Returns the List of Integer
     */
    @JsonGetter("tip_percentages")
    public List<Integer> getTipPercentages() {
        return tipPercentages;
    }

    /**
     * Getter for SmartTipping.
     * Enables the "Smart Tip Amounts" behavior. Exact tipping options depend on the region the
     * Square seller is active in. In the United States and Canada, tipping options will be
     * presented in whole dollar amounts for payments under 10 USD/CAD respectively. If set to true,
     * the tip_percentages settings is ignored. Defaults to false. To learn more about smart
     * tipping, see [Accept Tips with the Square
     * App](https://squareup.com/help/us/en/article/5069-accept-tips-with-the-square-app)
     * @return Returns the Boolean
     */
    @JsonGetter("smart_tipping")
    public Boolean getSmartTipping() {
        return smartTipping;
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowTipping, separateTipScreen, customTipField, tipPercentages,
                smartTipping);
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
        Builder builder = new Builder()
                .allowTipping(getAllowTipping())
                .separateTipScreen(getSeparateTipScreen())
                .customTipField(getCustomTipField())
                .tipPercentages(getTipPercentages())
                .smartTipping(getSmartTipping());
        return builder;
    }

    /**
     * Class to build instances of {@link TipSettings}.
     */
    public static class Builder {
        private Boolean allowTipping;
        private Boolean separateTipScreen;
        private Boolean customTipField;
        private List<Integer> tipPercentages;
        private Boolean smartTipping;



        /**
         * Setter for allowTipping.
         * @param  allowTipping  Boolean value for allowTipping.
         * @return Builder
         */
        public Builder allowTipping(Boolean allowTipping) {
            this.allowTipping = allowTipping;
            return this;
        }

        /**
         * Setter for separateTipScreen.
         * @param  separateTipScreen  Boolean value for separateTipScreen.
         * @return Builder
         */
        public Builder separateTipScreen(Boolean separateTipScreen) {
            this.separateTipScreen = separateTipScreen;
            return this;
        }

        /**
         * Setter for customTipField.
         * @param  customTipField  Boolean value for customTipField.
         * @return Builder
         */
        public Builder customTipField(Boolean customTipField) {
            this.customTipField = customTipField;
            return this;
        }

        /**
         * Setter for tipPercentages.
         * @param  tipPercentages  List of Integer value for tipPercentages.
         * @return Builder
         */
        public Builder tipPercentages(List<Integer> tipPercentages) {
            this.tipPercentages = tipPercentages;
            return this;
        }

        /**
         * Setter for smartTipping.
         * @param  smartTipping  Boolean value for smartTipping.
         * @return Builder
         */
        public Builder smartTipping(Boolean smartTipping) {
            this.smartTipping = smartTipping;
            return this;
        }

        /**
         * Builds a new {@link TipSettings} object using the set fields.
         * @return {@link TipSettings}
         */
        public TipSettings build() {
            return new TipSettings(allowTipping, separateTipScreen, customTipField, tipPercentages,
                    smartTipping);
        }
    }
}
