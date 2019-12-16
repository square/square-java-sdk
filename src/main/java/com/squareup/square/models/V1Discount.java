package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Discount {

    @JsonCreator
    public V1Discount(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("rate") String rate,
            @JsonProperty("amount_money") V1Money amountMoney,
            @JsonProperty("discount_type") String discountType,
            @JsonProperty("pin_required") Boolean pinRequired,
            @JsonProperty("color") String color,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.amountMoney = amountMoney;
        this.discountType = discountType;
        this.pinRequired = pinRequired;
        this.color = color;
        this.v2Id = v2Id;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String rate;
    private final V1Money amountMoney;
    private final String discountType;
    private final Boolean pinRequired;
    private final String color;
    private final String v2Id;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate, amountMoney, discountType, pinRequired, color, v2Id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Discount)) {
            return false;
        }
        V1Discount v1Discount = (V1Discount) o;
        return Objects.equals(id, v1Discount.id) &&
            Objects.equals(name, v1Discount.name) &&
            Objects.equals(rate, v1Discount.rate) &&
            Objects.equals(amountMoney, v1Discount.amountMoney) &&
            Objects.equals(discountType, v1Discount.discountType) &&
            Objects.equals(pinRequired, v1Discount.pinRequired) &&
            Objects.equals(color, v1Discount.color) &&
            Objects.equals(v2Id, v1Discount.v2Id);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The discount's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The discount's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Rate.
     * The rate of the discount, as a string representation of a decimal number. A value of 0.07 corresponds to a rate of 7%. This rate is 0 if discount_type is VARIABLE_PERCENTAGE.
     */
    @JsonGetter("rate")
    public String getRate() { 
        return this.rate;
    }

    /**
     * Getter for AmountMoney.
     */
    @JsonGetter("amount_money")
    public V1Money getAmountMoney() { 
        return this.amountMoney;
    }

    /**
     * Getter for DiscountType.
     */
    @JsonGetter("discount_type")
    public String getDiscountType() { 
        return this.discountType;
    }

    /**
     * Getter for PinRequired.
     * Indicates whether a mobile staff member needs to enter their PIN to apply the discount to a payment.
     */
    @JsonGetter("pin_required")
    public Boolean getPinRequired() { 
        return this.pinRequired;
    }

    /**
     * Getter for Color.
     */
    @JsonGetter("color")
    public String getColor() { 
        return this.color;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID.
     */
    @JsonGetter("v2_id")
    public String getV2Id() { 
        return this.v2Id;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .rate(getRate())
            .amountMoney(getAmountMoney())
            .discountType(getDiscountType())
            .pinRequired(getPinRequired())
            .color(getColor())
            .v2Id(getV2Id());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String rate;
        private V1Money amountMoney;
        private String discountType;
        private Boolean pinRequired;
        private String color;
        private String v2Id;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder rate(String value) {
            rate = value;
            return this;
        }
        public Builder amountMoney(V1Money value) {
            amountMoney = value;
            return this;
        }
        public Builder discountType(String value) {
            discountType = value;
            return this;
        }
        public Builder pinRequired(Boolean value) {
            pinRequired = value;
            return this;
        }
        public Builder color(String value) {
            color = value;
            return this;
        }
        public Builder v2Id(String value) {
            v2Id = value;
            return this;
        }

        public V1Discount build() {
            V1Discount model = new V1Discount(id,
                name,
                rate,
                amountMoney,
                discountType,
                pinRequired,
                color,
                v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
