
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1PaymentModifier type.
 */
public class V1PaymentModifier {
    private final String name;
    private final V1Money appliedMoney;
    private final String modifierOptionId;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param appliedMoney V1Money value for appliedMoney.
     * @param modifierOptionId String value for modifierOptionId.
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

    /**
     * Getter for Name.
     * The modifier option's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for AppliedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("applied_money")
    public V1Money getAppliedMoney() {
        return this.appliedMoney;
    }

    /**
     * Getter for ModifierOptionId.
     * TThe ID of the applied modifier option, if available. Modifier options applied in older
     * versions of Square Register might not have an ID.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PaymentModifier)) {
            return false;
        }
        V1PaymentModifier other = (V1PaymentModifier) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(modifierOptionId, other.modifierOptionId);
    }

    /**
     * Converts this V1PaymentModifier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PaymentModifier [" + "name=" + name + ", appliedMoney=" + appliedMoney
                + ", modifierOptionId=" + modifierOptionId + "]";
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
     * Class to build instances of {@link V1PaymentModifier}.
     */
    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String modifierOptionId;



        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for appliedMoney.
         * @param appliedMoney V1Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(V1Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        /**
         * Setter for modifierOptionId.
         * @param modifierOptionId String value for modifierOptionId.
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
            return new V1PaymentModifier(name, appliedMoney, modifierOptionId);
        }
    }
}
