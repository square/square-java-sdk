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
     * @param ordinal
     * @param modifierListId
     */
    @JsonCreator
    public CatalogModifier(
            @JsonProperty("name") String name,
            @JsonProperty("price_money") Money priceMoney,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("modifier_list_id") String modifierListId) {
        this.name = name;
        this.priceMoney = priceMoney;
        this.ordinal = ordinal;
        this.modifierListId = modifierListId;
    }

    private final String name;
    private final Money priceMoney;
    private final Integer ordinal;
    private final String modifierListId;
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

    /**
     * Getter for Ordinal.
     * Determines where this `CatalogModifier` appears in the `CatalogModifierList`.
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for ModifierListId.
     * The ID of the `CatalogModifierList` associated with this modifier. Searchable.
     */
    @JsonGetter("modifier_list_id")
    public String getModifierListId() {
        return this.modifierListId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, priceMoney, ordinal, modifierListId);
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
            Objects.equals(priceMoney, catalogModifier.priceMoney) &&
            Objects.equals(ordinal, catalogModifier.ordinal) &&
            Objects.equals(modifierListId, catalogModifier.modifierListId);
    }

    /**
     * Builds a new {@link CatalogModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .priceMoney(getPriceMoney())
            .ordinal(getOrdinal())
            .modifierListId(getModifierListId());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogModifier}
     */
    public static class Builder {
        private String name;
        private Money priceMoney;
        private Integer ordinal;
        private String modifierListId;

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
         * Setter for ordinal
         * @param ordinal
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }
        /**
         * Setter for modifierListId
         * @param modifierListId
         * @return Builder
         */
        public Builder modifierListId(String modifierListId) {
            this.modifierListId = modifierListId;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifier} object using the set fields.
         * @return {@link CatalogModifier}
         */
        public CatalogModifier build() {
            return new CatalogModifier(name,
                priceMoney,
                ordinal,
                modifierListId);
        }
    }
}
