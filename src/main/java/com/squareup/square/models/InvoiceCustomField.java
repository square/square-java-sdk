
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InvoiceCustomField type.
 */
public class InvoiceCustomField {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String label;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String placement;

    /**
     * Initialization constructor.
     * @param  label  String value for label.
     * @param  value  String value for value.
     * @param  placement  String value for placement.
     */
    @JsonCreator
    public InvoiceCustomField(
            @JsonProperty("label") String label,
            @JsonProperty("value") String value,
            @JsonProperty("placement") String placement) {
        this.label = label;
        this.value = value;
        this.placement = placement;
    }

    /**
     * Getter for Label.
     * The label or title of the custom field. This field is required for a custom field.
     * @return Returns the String
     */
    @JsonGetter("label")
    public String getLabel() {
        return label;
    }

    /**
     * Getter for Value.
     * The text of the custom field. If omitted, only the label is rendered.
     * @return Returns the String
     */
    @JsonGetter("value")
    public String getValue() {
        return value;
    }

    /**
     * Getter for Placement.
     * Indicates where to render a custom field on the Square-hosted invoice page and in emailed or
     * PDF copies of the invoice.
     * @return Returns the String
     */
    @JsonGetter("placement")
    public String getPlacement() {
        return placement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, placement);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoiceCustomField)) {
            return false;
        }
        InvoiceCustomField other = (InvoiceCustomField) obj;
        return Objects.equals(label, other.label)
            && Objects.equals(value, other.value)
            && Objects.equals(placement, other.placement);
    }

    /**
     * Converts this InvoiceCustomField into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceCustomField [" + "label=" + label + ", value=" + value + ", placement="
                + placement + "]";
    }

    /**
     * Builds a new {@link InvoiceCustomField.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceCustomField.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .label(getLabel())
                .value(getValue())
                .placement(getPlacement());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceCustomField}.
     */
    public static class Builder {
        private String label;
        private String value;
        private String placement;



        /**
         * Setter for label.
         * @param  label  String value for label.
         * @return Builder
         */
        public Builder label(String label) {
            this.label = label;
            return this;
        }

        /**
         * Setter for value.
         * @param  value  String value for value.
         * @return Builder
         */
        public Builder value(String value) {
            this.value = value;
            return this;
        }

        /**
         * Setter for placement.
         * @param  placement  String value for placement.
         * @return Builder
         */
        public Builder placement(String placement) {
            this.placement = placement;
            return this;
        }

        /**
         * Builds a new {@link InvoiceCustomField} object using the set fields.
         * @return {@link InvoiceCustomField}
         */
        public InvoiceCustomField build() {
            return new InvoiceCustomField(label, value, placement);
        }
    }
}
