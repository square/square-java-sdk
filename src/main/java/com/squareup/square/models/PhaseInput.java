
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for PhaseInput type.
 */
public class PhaseInput {
    private final long ordinal;
    private final OptionalNullable<String> orderTemplateId;

    /**
     * Initialization constructor.
     * @param  ordinal  long value for ordinal.
     * @param  orderTemplateId  String value for orderTemplateId.
     */
    @JsonCreator
    public PhaseInput(
            @JsonProperty("ordinal") long ordinal,
            @JsonProperty("order_template_id") String orderTemplateId) {
        this.ordinal = ordinal;
        this.orderTemplateId = OptionalNullable.of(orderTemplateId);
    }

    /**
     * Internal initialization constructor.
     */
    protected PhaseInput(long ordinal, OptionalNullable<String> orderTemplateId) {
        this.ordinal = ordinal;
        this.orderTemplateId = orderTemplateId;
    }

    /**
     * Getter for Ordinal.
     * index of phase in total subscription plan
     * @return Returns the long
     */
    @JsonGetter("ordinal")
    public long getOrdinal() {
        return ordinal;
    }

    /**
     * Internal Getter for OrderTemplateId.
     * id of order to be used in billing
     * @return Returns the Internal String
     */
    @JsonGetter("order_template_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderTemplateId() {
        return this.orderTemplateId;
    }

    /**
     * Getter for OrderTemplateId.
     * id of order to be used in billing
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderTemplateId() {
        return OptionalNullable.getFrom(orderTemplateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordinal, orderTemplateId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhaseInput)) {
            return false;
        }
        PhaseInput other = (PhaseInput) obj;
        return Objects.equals(ordinal, other.ordinal)
            && Objects.equals(orderTemplateId, other.orderTemplateId);
    }

    /**
     * Converts this PhaseInput into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PhaseInput [" + "ordinal=" + ordinal + ", orderTemplateId=" + orderTemplateId + "]";
    }

    /**
     * Builds a new {@link PhaseInput.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PhaseInput.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(ordinal);
        builder.orderTemplateId = internalGetOrderTemplateId();
        return builder;
    }

    /**
     * Class to build instances of {@link PhaseInput}.
     */
    public static class Builder {
        private long ordinal;
        private OptionalNullable<String> orderTemplateId;

        /**
         * Initialization constructor.
         * @param  ordinal  long value for ordinal.
         */
        public Builder(long ordinal) {
            this.ordinal = ordinal;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  long value for ordinal.
         * @return Builder
         */
        public Builder ordinal(long ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Setter for orderTemplateId.
         * @param  orderTemplateId  String value for orderTemplateId.
         * @return Builder
         */
        public Builder orderTemplateId(String orderTemplateId) {
            this.orderTemplateId = OptionalNullable.of(orderTemplateId);
            return this;
        }

        /**
         * UnSetter for orderTemplateId.
         * @return Builder
         */
        public Builder unsetOrderTemplateId() {
            orderTemplateId = null;
            return this;
        }

        /**
         * Builds a new {@link PhaseInput} object using the set fields.
         * @return {@link PhaseInput}
         */
        public PhaseInput build() {
            return new PhaseInput(ordinal, orderTemplateId);
        }
    }
}
