package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogModifier {

    @JsonCreator
    public CatalogModifier(
            @JsonProperty("name") String name,
            @JsonProperty("price_money") Money priceMoney) {
        this.name = name;
        this.priceMoney = priceMoney;
    }

    private final String name;
    private final Money priceMoney;

    @Override
    public int hashCode() {
        return Objects.hash(name, priceMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogModifier)) {
            return false;
        }
        CatalogModifier catalogModifier = (CatalogModifier) o;
        return Objects.equals(name, catalogModifier.name) &&
            Objects.equals(priceMoney, catalogModifier.priceMoney);
    }

    /**
     * Getter for Name.
     * The modifier name. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for PriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("price_money")
    public Money getPriceMoney() { 
        return this.priceMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .priceMoney(getPriceMoney());
            return builder;
    }

    public static class Builder {
        private String name;
        private Money priceMoney;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder priceMoney(Money value) {
            priceMoney = value;
            return this;
        }

        public CatalogModifier build() {
            return new CatalogModifier(name,
                priceMoney);
        }
    }
}
