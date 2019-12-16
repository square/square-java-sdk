package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1PaymentModifier {

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

    @Override
    public int hashCode() {
        return Objects.hash(name, appliedMoney, modifierOptionId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1PaymentModifier)) {
            return false;
        }
        V1PaymentModifier v1PaymentModifier = (V1PaymentModifier) o;
        return Objects.equals(name, v1PaymentModifier.name) &&
            Objects.equals(appliedMoney, v1PaymentModifier.appliedMoney) &&
            Objects.equals(modifierOptionId, v1PaymentModifier.modifierOptionId);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .appliedMoney(getAppliedMoney())
            .modifierOptionId(getModifierOptionId());
            return builder;
    }

    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String modifierOptionId;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder appliedMoney(V1Money value) {
            appliedMoney = value;
            return this;
        }
        public Builder modifierOptionId(String value) {
            modifierOptionId = value;
            return this;
        }

        public V1PaymentModifier build() {
            return new V1PaymentModifier(name,
                appliedMoney,
                modifierOptionId);
        }
    }
}
