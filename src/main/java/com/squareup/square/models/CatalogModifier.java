package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogModifier type.
 */
public class CatalogModifier {

    /**
     * Initialization constructor.
     * @param name
     * @param priceMoney
     */
    @JsonCreator
    public CatalogModifier(
            @JsonProperty("name") String name,
            @JsonProperty("price_money") Money priceMoney) {
        this.name = name;
        this.priceMoney = priceMoney;
    }

    private final String name;
    private final Money priceMoney;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(name, priceMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogModifier)) {
            return false;
        }
        CatalogModifier catalogModifier = (CatalogModifier) obj;
        return Objects.equals(name, catalogModifier.name) &&
            Objects.equals(priceMoney, catalogModifier.priceMoney);
    }

    /**
     * Builds a new {@link CatalogModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .priceMoney(getPriceMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogModifier}
     */
    public static class Builder {
        private String name;
        private Money priceMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for priceMoney
         * @param priceMoney
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifier} object using the set fields.
         * @return {@link CatalogModifier}
         */
        public CatalogModifier build() {
            return new CatalogModifier(name,
                priceMoney);
        }
    }
}
