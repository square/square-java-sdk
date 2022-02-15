
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogModifier type.
 */
public class CatalogModifier {
    private final String name;
    private final Money priceMoney;
    private final Integer ordinal;
    private final String modifierListId;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  priceMoney  Money value for priceMoney.
     * @param  ordinal  Integer value for ordinal.
     * @param  modifierListId  String value for modifierListId.
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

    /**
     * Getter for Name.
     * The modifier name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for PriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("price_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getPriceMoney() {
        return priceMoney;
    }

    /**
     * Getter for Ordinal.
     * Determines where this `CatalogModifier` appears in the `CatalogModifierList`.
     * @return Returns the Integer
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getOrdinal() {
        return ordinal;
    }

    /**
     * Getter for ModifierListId.
     * The ID of the `CatalogModifierList` associated with this modifier.
     * @return Returns the String
     */
    @JsonGetter("modifier_list_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getModifierListId() {
        return modifierListId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priceMoney, ordinal, modifierListId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogModifier)) {
            return false;
        }
        CatalogModifier other = (CatalogModifier) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(priceMoney, other.priceMoney)
            && Objects.equals(ordinal, other.ordinal)
            && Objects.equals(modifierListId, other.modifierListId);
    }

    /**
     * Converts this CatalogModifier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogModifier [" + "name=" + name + ", priceMoney=" + priceMoney + ", ordinal="
                + ordinal + ", modifierListId=" + modifierListId + "]";
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
     * Class to build instances of {@link CatalogModifier}.
     */
    public static class Builder {
        private String name;
        private Money priceMoney;
        private Integer ordinal;
        private String modifierListId;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for priceMoney.
         * @param  priceMoney  Money value for priceMoney.
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Setter for modifierListId.
         * @param  modifierListId  String value for modifierListId.
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
            return new CatalogModifier(name, priceMoney, ordinal, modifierListId);
        }
    }
}
