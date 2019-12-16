package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogDiscount {

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

    private final String name;
    private final String discountType;
    private final String percentage;
    private final Money amountMoney;
    private final Boolean pinRequired;
    private final String labelColor;
    private final String modifyTaxBasis;

    @Override
    public int hashCode() {
        return Objects.hash(name, discountType, percentage, amountMoney, pinRequired, labelColor, modifyTaxBasis);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogDiscount)) {
            return false;
        }
        CatalogDiscount catalogDiscount = (CatalogDiscount) o;
        return Objects.equals(name, catalogDiscount.name) &&
            Objects.equals(discountType, catalogDiscount.discountType) &&
            Objects.equals(percentage, catalogDiscount.percentage) &&
            Objects.equals(amountMoney, catalogDiscount.amountMoney) &&
            Objects.equals(pinRequired, catalogDiscount.pinRequired) &&
            Objects.equals(labelColor, catalogDiscount.labelColor) &&
            Objects.equals(modifyTaxBasis, catalogDiscount.modifyTaxBasis);
    }

    /**
     * Getter for Name.
     * The discount name. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for DiscountType.
     * How to apply a CatalogDiscount to a CatalogItem.
     */
    @JsonGetter("discount_type")
    public String getDiscountType() { 
        return this.discountType;
    }

    /**
     * Getter for Percentage.
     * The percentage of the discount as a string representation of a decimal number, using a `.` as the decimal
     * separator and without a `%` sign. A value of `7.5` corresponds to `7.5%`. Specify a percentage of `0` if `discount_type`
     * is `VARIABLE_PERCENTAGE`.
     * Do not include this field for amount-based or variable discounts.
     */
    @JsonGetter("percentage")
    public String getPercentage() { 
        return this.percentage;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() { 
        return this.amountMoney;
    }

    /**
     * Getter for PinRequired.
     * Indicates whether a mobile staff member needs to enter their PIN to apply the
     * discount to a payment in the Square Point of Sale app.
     */
    @JsonGetter("pin_required")
    public Boolean getPinRequired() { 
        return this.pinRequired;
    }

    /**
     * Getter for LabelColor.
     * The color of the discount display label in the Square Point of Sale app. This must be a valid hex color code.
     */
    @JsonGetter("label_color")
    public String getLabelColor() { 
        return this.labelColor;
    }

    /**
     * Getter for ModifyTaxBasis.
     */
    @JsonGetter("modify_tax_basis")
    public String getModifyTaxBasis() { 
        return this.modifyTaxBasis;
    }

 
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

    public static class Builder {
        private String name;
        private String discountType;
        private String percentage;
        private Money amountMoney;
        private Boolean pinRequired;
        private String labelColor;
        private String modifyTaxBasis;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder discountType(String value) {
            discountType = value;
            return this;
        }
        public Builder percentage(String value) {
            percentage = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder pinRequired(Boolean value) {
            pinRequired = value;
            return this;
        }
        public Builder labelColor(String value) {
            labelColor = value;
            return this;
        }
        public Builder modifyTaxBasis(String value) {
            modifyTaxBasis = value;
            return this;
        }

        public CatalogDiscount build() {
            return new CatalogDiscount(name,
                discountType,
                percentage,
                amountMoney,
                pinRequired,
                labelColor,
                modifyTaxBasis);
        }
    }
}
