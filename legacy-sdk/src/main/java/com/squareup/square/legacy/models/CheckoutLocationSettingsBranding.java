package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CheckoutLocationSettingsBranding type.
 */
public class CheckoutLocationSettingsBranding {
    private final String headerType;
    private final OptionalNullable<String> buttonColor;
    private final String buttonShape;

    /**
     * Initialization constructor.
     * @param  headerType  String value for headerType.
     * @param  buttonColor  String value for buttonColor.
     * @param  buttonShape  String value for buttonShape.
     */
    @JsonCreator
    public CheckoutLocationSettingsBranding(
            @JsonProperty("header_type") String headerType,
            @JsonProperty("button_color") String buttonColor,
            @JsonProperty("button_shape") String buttonShape) {
        this.headerType = headerType;
        this.buttonColor = OptionalNullable.of(buttonColor);
        this.buttonShape = buttonShape;
    }

    /**
     * Initialization constructor.
     * @param  headerType  String value for headerType.
     * @param  buttonColor  String value for buttonColor.
     * @param  buttonShape  String value for buttonShape.
     */
    protected CheckoutLocationSettingsBranding(
            String headerType, OptionalNullable<String> buttonColor, String buttonShape) {
        this.headerType = headerType;
        this.buttonColor = buttonColor;
        this.buttonShape = buttonShape;
    }

    /**
     * Getter for HeaderType.
     * @return Returns the String
     */
    @JsonGetter("header_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getHeaderType() {
        return headerType;
    }

    /**
     * Internal Getter for ButtonColor.
     * The HTML-supported hex color for the button on the checkout page (for example, "#FFFFFF").
     * @return Returns the Internal String
     */
    @JsonGetter("button_color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetButtonColor() {
        return this.buttonColor;
    }

    /**
     * Getter for ButtonColor.
     * The HTML-supported hex color for the button on the checkout page (for example, "#FFFFFF").
     * @return Returns the String
     */
    @JsonIgnore
    public String getButtonColor() {
        return OptionalNullable.getFrom(buttonColor);
    }

    /**
     * Getter for ButtonShape.
     * @return Returns the String
     */
    @JsonGetter("button_shape")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getButtonShape() {
        return buttonShape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(headerType, buttonColor, buttonShape);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutLocationSettingsBranding)) {
            return false;
        }
        CheckoutLocationSettingsBranding other = (CheckoutLocationSettingsBranding) obj;
        return Objects.equals(headerType, other.headerType)
                && Objects.equals(buttonColor, other.buttonColor)
                && Objects.equals(buttonShape, other.buttonShape);
    }

    /**
     * Converts this CheckoutLocationSettingsBranding into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutLocationSettingsBranding [" + "headerType=" + headerType + ", buttonColor=" + buttonColor
                + ", buttonShape=" + buttonShape + "]";
    }

    /**
     * Builds a new {@link CheckoutLocationSettingsBranding.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutLocationSettingsBranding.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().headerType(getHeaderType()).buttonShape(getButtonShape());
        builder.buttonColor = internalGetButtonColor();
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutLocationSettingsBranding}.
     */
    public static class Builder {
        private String headerType;
        private OptionalNullable<String> buttonColor;
        private String buttonShape;

        /**
         * Setter for headerType.
         * @param  headerType  String value for headerType.
         * @return Builder
         */
        public Builder headerType(String headerType) {
            this.headerType = headerType;
            return this;
        }

        /**
         * Setter for buttonColor.
         * @param  buttonColor  String value for buttonColor.
         * @return Builder
         */
        public Builder buttonColor(String buttonColor) {
            this.buttonColor = OptionalNullable.of(buttonColor);
            return this;
        }

        /**
         * UnSetter for buttonColor.
         * @return Builder
         */
        public Builder unsetButtonColor() {
            buttonColor = null;
            return this;
        }

        /**
         * Setter for buttonShape.
         * @param  buttonShape  String value for buttonShape.
         * @return Builder
         */
        public Builder buttonShape(String buttonShape) {
            this.buttonShape = buttonShape;
            return this;
        }

        /**
         * Builds a new {@link CheckoutLocationSettingsBranding} object using the set fields.
         * @return {@link CheckoutLocationSettingsBranding}
         */
        public CheckoutLocationSettingsBranding build() {
            return new CheckoutLocationSettingsBranding(headerType, buttonColor, buttonShape);
        }
    }
}
