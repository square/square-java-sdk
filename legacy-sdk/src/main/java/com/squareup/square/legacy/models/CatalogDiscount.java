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
 * This is a model class for CatalogDiscount type.
 */
public class CatalogDiscount {
    private final OptionalNullable<String> name;
    private final String discountType;
    private final OptionalNullable<String> percentage;
    private final Money amountMoney;
    private final OptionalNullable<Boolean> pinRequired;
    private final OptionalNullable<String> labelColor;
    private final String modifyTaxBasis;
    private final Money maximumAmountMoney;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  discountType  String value for discountType.
     * @param  percentage  String value for percentage.
     * @param  amountMoney  Money value for amountMoney.
     * @param  pinRequired  Boolean value for pinRequired.
     * @param  labelColor  String value for labelColor.
     * @param  modifyTaxBasis  String value for modifyTaxBasis.
     * @param  maximumAmountMoney  Money value for maximumAmountMoney.
     */
    @JsonCreator
    public CatalogDiscount(
            @JsonProperty("name") String name,
            @JsonProperty("discount_type") String discountType,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("pin_required") Boolean pinRequired,
            @JsonProperty("label_color") String labelColor,
            @JsonProperty("modify_tax_basis") String modifyTaxBasis,
            @JsonProperty("maximum_amount_money") Money maximumAmountMoney) {
        this.name = OptionalNullable.of(name);
        this.discountType = discountType;
        this.percentage = OptionalNullable.of(percentage);
        this.amountMoney = amountMoney;
        this.pinRequired = OptionalNullable.of(pinRequired);
        this.labelColor = OptionalNullable.of(labelColor);
        this.modifyTaxBasis = modifyTaxBasis;
        this.maximumAmountMoney = maximumAmountMoney;
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  discountType  String value for discountType.
     * @param  percentage  String value for percentage.
     * @param  amountMoney  Money value for amountMoney.
     * @param  pinRequired  Boolean value for pinRequired.
     * @param  labelColor  String value for labelColor.
     * @param  modifyTaxBasis  String value for modifyTaxBasis.
     * @param  maximumAmountMoney  Money value for maximumAmountMoney.
     */
    protected CatalogDiscount(
            OptionalNullable<String> name,
            String discountType,
            OptionalNullable<String> percentage,
            Money amountMoney,
            OptionalNullable<Boolean> pinRequired,
            OptionalNullable<String> labelColor,
            String modifyTaxBasis,
            Money maximumAmountMoney) {
        this.name = name;
        this.discountType = discountType;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.pinRequired = pinRequired;
        this.labelColor = labelColor;
        this.modifyTaxBasis = modifyTaxBasis;
        this.maximumAmountMoney = maximumAmountMoney;
    }

    /**
     * Internal Getter for Name.
     * The discount name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
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
     * The discount name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for DiscountType.
     * How to apply a CatalogDiscount to a CatalogItem.
     * @return Returns the String
     */
    @JsonGetter("discount_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Internal Getter for Percentage.
     * The percentage of the discount as a string representation of a decimal number, using a `.` as
     * the decimal separator and without a `%` sign. A value of `7.5` corresponds to `7.5%`. Specify
     * a percentage of `0` if `discount_type` is `VARIABLE_PERCENTAGE`. Do not use this field for
     * amount-based or variable discounts.
     * @return Returns the Internal String
     */
    @JsonGetter("percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPercentage() {
        return this.percentage;
    }

    /**
     * Getter for Percentage.
     * The percentage of the discount as a string representation of a decimal number, using a `.` as
     * the decimal separator and without a `%` sign. A value of `7.5` corresponds to `7.5%`. Specify
     * a percentage of `0` if `discount_type` is `VARIABLE_PERCENTAGE`. Do not use this field for
     * amount-based or variable discounts.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentage() {
        return OptionalNullable.getFrom(percentage);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Internal Getter for PinRequired.
     * Indicates whether a mobile staff member needs to enter their PIN to apply the discount to a
     * payment in the Square Point of Sale app.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("pin_required")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetPinRequired() {
        return this.pinRequired;
    }

    /**
     * Getter for PinRequired.
     * Indicates whether a mobile staff member needs to enter their PIN to apply the discount to a
     * payment in the Square Point of Sale app.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getPinRequired() {
        return OptionalNullable.getFrom(pinRequired);
    }

    /**
     * Internal Getter for LabelColor.
     * The color of the discount display label in the Square Point of Sale app. This must be a valid
     * hex color code.
     * @return Returns the Internal String
     */
    @JsonGetter("label_color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLabelColor() {
        return this.labelColor;
    }

    /**
     * Getter for LabelColor.
     * The color of the discount display label in the Square Point of Sale app. This must be a valid
     * hex color code.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLabelColor() {
        return OptionalNullable.getFrom(labelColor);
    }

    /**
     * Getter for ModifyTaxBasis.
     * @return Returns the String
     */
    @JsonGetter("modify_tax_basis")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getModifyTaxBasis() {
        return modifyTaxBasis;
    }

    /**
     * Getter for MaximumAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("maximum_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getMaximumAmountMoney() {
        return maximumAmountMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                discountType,
                percentage,
                amountMoney,
                pinRequired,
                labelColor,
                modifyTaxBasis,
                maximumAmountMoney);
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
                && Objects.equals(modifyTaxBasis, other.modifyTaxBasis)
                && Objects.equals(maximumAmountMoney, other.maximumAmountMoney);
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
                + ", maximumAmountMoney=" + maximumAmountMoney + "]";
    }

    /**
     * Builds a new {@link CatalogDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .discountType(getDiscountType())
                .amountMoney(getAmountMoney())
                .modifyTaxBasis(getModifyTaxBasis())
                .maximumAmountMoney(getMaximumAmountMoney());
        builder.name = internalGetName();
        builder.percentage = internalGetPercentage();
        builder.pinRequired = internalGetPinRequired();
        builder.labelColor = internalGetLabelColor();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogDiscount}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private String discountType;
        private OptionalNullable<String> percentage;
        private Money amountMoney;
        private OptionalNullable<Boolean> pinRequired;
        private OptionalNullable<String> labelColor;
        private String modifyTaxBasis;
        private Money maximumAmountMoney;

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
            this.percentage = OptionalNullable.of(percentage);
            return this;
        }

        /**
         * UnSetter for percentage.
         * @return Builder
         */
        public Builder unsetPercentage() {
            percentage = null;
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
            this.pinRequired = OptionalNullable.of(pinRequired);
            return this;
        }

        /**
         * UnSetter for pinRequired.
         * @return Builder
         */
        public Builder unsetPinRequired() {
            pinRequired = null;
            return this;
        }

        /**
         * Setter for labelColor.
         * @param  labelColor  String value for labelColor.
         * @return Builder
         */
        public Builder labelColor(String labelColor) {
            this.labelColor = OptionalNullable.of(labelColor);
            return this;
        }

        /**
         * UnSetter for labelColor.
         * @return Builder
         */
        public Builder unsetLabelColor() {
            labelColor = null;
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
         * Setter for maximumAmountMoney.
         * @param  maximumAmountMoney  Money value for maximumAmountMoney.
         * @return Builder
         */
        public Builder maximumAmountMoney(Money maximumAmountMoney) {
            this.maximumAmountMoney = maximumAmountMoney;
            return this;
        }

        /**
         * Builds a new {@link CatalogDiscount} object using the set fields.
         * @return {@link CatalogDiscount}
         */
        public CatalogDiscount build() {
            return new CatalogDiscount(
                    name,
                    discountType,
                    percentage,
                    amountMoney,
                    pinRequired,
                    labelColor,
                    modifyTaxBasis,
                    maximumAmountMoney);
        }
    }
}
