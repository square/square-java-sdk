package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateOrderRequestDiscount type.
 */
public class CreateOrderRequestDiscount {

    /**
     * Initialization constructor.
     * @param catalogObjectId
     * @param name
     * @param percentage
     * @param amountMoney
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, name, percentage, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateOrderRequestDiscount)) {
            return false;
        }
        CreateOrderRequestDiscount createOrderRequestDiscount = (CreateOrderRequestDiscount) obj;
        return Objects.equals(catalogObjectId, createOrderRequestDiscount.catalogObjectId) &&
            Objects.equals(name, createOrderRequestDiscount.name) &&
            Objects.equals(percentage, createOrderRequestDiscount.percentage) &&
            Objects.equals(amountMoney, createOrderRequestDiscount.amountMoney);
    }

    /**
     * Builds a new {@link CreateOrderRequestDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderRequestDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .percentage(getPercentage())
            .amountMoney(getAmountMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderRequestDiscount}
     */
    public static class Builder {
        private String catalogObjectId;
        private String name;
        private String percentage;
        private Money amountMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for catalogObjectId
         * @param catalogObjectId
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for percentage
         * @param percentage
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Builds a new {@link CreateOrderRequestDiscount} object using the set fields.
         * @return {@link CreateOrderRequestDiscount}
         */
        public CreateOrderRequestDiscount build() {
            return new CreateOrderRequestDiscount(catalogObjectId,
                name,
                percentage,
                amountMoney);
        }
    }
}
