package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateOrderRequestModifier type.
 */
public class CreateOrderRequestModifier {

    /**
     * Initialization constructor.
     * @param catalogObjectId
     * @param name
     * @param basePriceMoney
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, name, basePriceMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateOrderRequestModifier)) {
            return false;
        }
        CreateOrderRequestModifier createOrderRequestModifier = (CreateOrderRequestModifier) obj;
        return Objects.equals(catalogObjectId, createOrderRequestModifier.catalogObjectId) &&
            Objects.equals(name, createOrderRequestModifier.name) &&
            Objects.equals(basePriceMoney, createOrderRequestModifier.basePriceMoney);
    }

    /**
     * Builds a new {@link CreateOrderRequestModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderRequestModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .basePriceMoney(getBasePriceMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderRequestModifier}
     */
    public static class Builder {
        private String catalogObjectId;
        private String name;
        private Money basePriceMoney;

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
         * Setter for basePriceMoney
         * @param basePriceMoney
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }

        /**
         * Builds a new {@link CreateOrderRequestModifier} object using the set fields.
         * @return {@link CreateOrderRequestModifier}
         */
        public CreateOrderRequestModifier build() {
            return new CreateOrderRequestModifier(catalogObjectId,
                name,
                basePriceMoney);
        }
    }
}
