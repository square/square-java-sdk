
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogDiscount type.
 */
public class CatalogDiscount {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String discountType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String percentage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean pinRequired;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String labelColor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String modifyTaxBasis;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  discountType  String value for discountType.
     * @param  percentage  String value for percentage.
     * @param  amountMoney  Money value for amountMoney.
     * @param  pinRequired  Boolean value for pinRequired.
     * @param  labelColor  String value for labelColor.
     * @param  modifyTaxBasis  String value for modifyTaxBasis.
     */
    @JsonCreator
    public CatalogDiscount(
            @JsonProperty("name") String name,
            @JsonProperty("discount_type") String discountType,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("pin_required") Boolean pinRequired,
            @JsonProperty("label_color") String labelColor,
            @JsonProperty("modify_tax_basis") String modifyTaxBasis) {
        this.name = name;
        this.discountType = discountType;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.pinRequired = pinRequired;
        this.labelColor = labelColor;
        this.modifyTaxBasis = modifyTaxBasis;
    }

    /**
     * Getter for Name.
     * The discount name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for DiscountType.
     * How to apply a CatalogDiscount to a CatalogItem.
     * @return Returns the String
     */
    @JsonGetter("discount_type")
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Getter for Percentage.
     * The percentage of the discount as a string representation of a decimal number, using a `.` as
     * the decimal separator and without a `%` sign. A value of `7.5` corresponds to `7.5%`. Specify
     * a percentage of `0` if `discount_type` is `VARIABLE_PERCENTAGE`. Do not use this field for
     * amount-based or variable discounts.
     * @return Returns the String
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return percentage;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for PinRequired.
     * Indicates whether a mobile staff member needs to enter their PIN to apply the discount to a
     * payment in the Square Point of Sale app.
     * @return Returns the Boolean
     */
    @JsonGetter("pin_required")
    public Boolean getPinRequired() {
        return pinRequired;
    }

    /**
     * Getter for LabelColor.
     * The color of the discount display label in the Square Point of Sale app. This must be a valid
     * hex color code.
     * @return Returns the String
     */
    @JsonGetter("label_color")
    public String getLabelColor() {
        return labelColor;
    }

    /**
     * Getter for ModifyTaxBasis.
     * @return Returns the String
     */
    @JsonGetter("modify_tax_basis")
    public String getModifyTaxBasis() {
        return modifyTaxBasis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, discountType, percentage, amountMoney, pinRequired, labelColor,
                modifyTaxBasis);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogDiscount)) {
            return false;
        }
        CatalogDiscount other = (CatalogDiscount) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(discountType, other.discountType)
            && Objects.equals(percentage, other.percentage)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(pinRequired, other.pinRequired)
            && Objects.equals(labelColor, other.labelColor)
            && Objects.equals(modifyTaxBasis, other.modifyTaxBasis);
    }

    /**
     * Converts this CatalogDiscount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogDiscount [" + "name=" + name + ", discountType=" + discountType
                + ", percentage=" + percentage + ", amountMoney=" + amountMoney + ", pinRequired="
                + pinRequired + ", labelColor=" + labelColor + ", modifyTaxBasis=" + modifyTaxBasis
                + "]";
    }

    /**
     * Builds a new {@link CatalogDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .name(getName())
                .discountType(getDiscountType())
                .percentage(getPercentage())
                .amountMoney(getAmountMoney())
                .pinRequired(getPinRequired())
                .labelColor(getLabelColor())
                .modifyTaxBasis(getModifyTaxBasis());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogDiscount}.
     */
    public static class Builder {
        private String name;
        private String discountType;
        private String percentage;
        private Money amountMoney;
        private Boolean pinRequired;
        private String labelColor;
        private String modifyTaxBasis;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for discountType.
         * @param  discountType  String value for discountType.
         * @return Builder
         */
        public Builder discountType(String discountType) {
            this.discountType = discountType;
            return this;
        }

        /**
         * Setter for percentage.
         * @param  percentage  String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for pinRequired.
         * @param  pinRequired  Boolean value for pinRequired.
         * @return Builder
         */
        public Builder pinRequired(Boolean pinRequired) {
            this.pinRequired = pinRequired;
            return this;
        }

        /**
         * Setter for labelColor.
         * @param  labelColor  String value for labelColor.
         * @return Builder
         */
        public Builder labelColor(String labelColor) {
            this.labelColor = labelColor;
            return this;
        }

        /**
         * Setter for modifyTaxBasis.
         * @param  modifyTaxBasis  String value for modifyTaxBasis.
         * @return Builder
         */
        public Builder modifyTaxBasis(String modifyTaxBasis) {
            this.modifyTaxBasis = modifyTaxBasis;
            return this;
        }

        /**
         * Builds a new {@link CatalogDiscount} object using the set fields.
         * @return {@link CatalogDiscount}
         */
        public CatalogDiscount build() {
            return new CatalogDiscount(name, discountType, percentage, amountMoney, pinRequired,
                    labelColor, modifyTaxBasis);
        }
    }
}
