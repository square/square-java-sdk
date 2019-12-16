package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateOrderRequestModifier {

    @JsonCreator
    public CreateOrderRequestModifier(
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("base_price_money") Money basePriceMoney) {
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.basePriceMoney = basePriceMoney;
    }

    private final String catalogObjectId;
    private final String name;
    private final Money basePriceMoney;

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, name, basePriceMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateOrderRequestModifier)) {
            return false;
        }
        CreateOrderRequestModifier createOrderRequestModifier = (CreateOrderRequestModifier) o;
        return Objects.equals(catalogObjectId, createOrderRequestModifier.catalogObjectId) &&
            Objects.equals(name, createOrderRequestModifier.name) &&
            Objects.equals(basePriceMoney, createOrderRequestModifier.basePriceMoney);
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID of a [CatalogModifier](#type-catalogmodifier).
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() { 
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * Only used for ad hoc modifiers. The name of the modifier. `name` cannot exceed 255 characters.
     * Do not provide a value for `name` if you provide a value for `catalog_object_id`.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for BasePriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("base_price_money")
    public Money getBasePriceMoney() { 
        return this.basePriceMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .basePriceMoney(getBasePriceMoney());
            return builder;
    }

    public static class Builder {
        private String catalogObjectId;
        private String name;
        private Money basePriceMoney;

        public Builder() { }

        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder basePriceMoney(Money value) {
            basePriceMoney = value;
            return this;
        }

        public CreateOrderRequestModifier build() {
            return new CreateOrderRequestModifier(catalogObjectId,
                name,
                basePriceMoney);
        }
    }
}
