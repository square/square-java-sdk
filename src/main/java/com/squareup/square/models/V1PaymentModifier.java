package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1PaymentModifier type.
 */
public class V1PaymentModifier {

    /**
     * Initialization constructor.
     * @param name
     * @param appliedMoney
     * @param modifierOptionId
     */
    @JsonCreator
    public V1PaymentModifier(
            @JsonProperty("name") String name,
            @JsonProperty("applied_money") V1Money appliedMoney,
            @JsonProperty("modifier_option_id") String modifierOptionId) {
        this.name = name;
        this.appliedMoney = appliedMoney;
        this.modifierOptionId = modifierOptionId;
    }

    private final String name;
    private final V1Money appliedMoney;
    private final String modifierOptionId;
    /**
     * Getter for Name.
     * The modifier option's name.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for AppliedMoney.
     */
    @JsonGetter("applied_money")
    public V1Money getAppliedMoney() {
        return this.appliedMoney;
    }

    /**
     * Getter for ModifierOptionId.
     * TThe ID of the applied modifier option, if available. Modifier options applied in older versions of Square Register might not have an ID.
     */
    @JsonGetter("modifier_option_id")
    public String getModifierOptionId() {
        return this.modifierOptionId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, appliedMoney, modifierOptionId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1PaymentModifier)) {
            return false;
        }
        V1PaymentModifier v1PaymentModifier = (V1PaymentModifier) obj;
        return Objects.equals(name, v1PaymentModifier.name) &&
            Objects.equals(appliedMoney, v1PaymentModifier.appliedMoney) &&
            Objects.equals(modifierOptionId, v1PaymentModifier.modifierOptionId);
    }

    /**
     * Builds a new {@link V1PaymentModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .appliedMoney(getAppliedMoney())
            .modifierOptionId(getModifierOptionId());
            return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentModifier}
     */
    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String modifierOptionId;

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
         * Setter for appliedMoney
         * @param appliedMoney
         * @return Builder
         */
        public Builder appliedMoney(V1Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }
        /**
         * Setter for modifierOptionId
         * @param modifierOptionId
         * @return Builder
         */
        public Builder modifierOptionId(String modifierOptionId) {
            this.modifierOptionId = modifierOptionId;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentModifier} object using the set fields.
         * @return {@link V1PaymentModifier}
         */
        public V1PaymentModifier build() {
            return new V1PaymentModifier(name,
                appliedMoney,
                modifierOptionId);
        }
    }
}
