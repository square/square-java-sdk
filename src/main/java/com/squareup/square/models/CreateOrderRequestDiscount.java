package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateOrderRequestDiscount {

    @JsonCreator
    public CreateOrderRequestDiscount(
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney) {
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
    }

    private final String catalogObjectId;
    private final String name;
    private final String percentage;
    private final Money amountMoney;

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, name, percentage, amountMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateOrderRequestDiscount)) {
            return false;
        }
        CreateOrderRequestDiscount createOrderRequestDiscount = (CreateOrderRequestDiscount) o;
        return Objects.equals(catalogObjectId, createOrderRequestDiscount.catalogObjectId) &&
            Objects.equals(name, createOrderRequestDiscount.name) &&
            Objects.equals(percentage, createOrderRequestDiscount.percentage) &&
            Objects.equals(amountMoney, createOrderRequestDiscount.amountMoney);
    }

    /**
     * Getter for CatalogObjectId.
     * Only used for catalog discounts.
     * The catalog object ID for an existing [CatalogDiscount](#type-catalogdiscount).
     * Do not provide a value for this field if you provide values in other fields for an ad hoc discount.
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() { 
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * Only used for ad hoc discounts. The discount's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Percentage.
     * Only used for ad hoc discounts. The percentage of the discount, as a string representation of a decimal number.
     * A value of `7.25` corresponds to a percentage of 7.25%. This value range between 0.0 up to 100.0
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .percentage(getPercentage())
            .amountMoney(getAmountMoney());
            return builder;
    }

    public static class Builder {
        private String catalogObjectId;
        private String name;
        private String percentage;
        private Money amountMoney;

        public Builder() { }

        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
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

        public CreateOrderRequestDiscount build() {
            return new CreateOrderRequestDiscount(catalogObjectId,
                name,
                percentage,
                amountMoney);
        }
    }
}
