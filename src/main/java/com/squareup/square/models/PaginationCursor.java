
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
 * This is a model class for PaginationCursor type.
 */
public class PaginationCursor {
    private final OptionalNullable<String> orderValue;

    /**
     * Initialization constructor.
     * @param  orderValue  String value for orderValue.
     */
    @JsonCreator
    public PaginationCursor(
            @JsonProperty("order_value") String orderValue) {
        this.orderValue = OptionalNullable.of(orderValue);
    }

    /**
     * Initialization constructor.
     * @param  orderValue  String value for orderValue.
     */

    protected PaginationCursor(OptionalNullable<String> orderValue) {
        this.orderValue = orderValue;
    }

    /**
     * Internal Getter for OrderValue.
     * The ID of the last resource in the current page. The page can be in an ascending or
     * descending order
     * @return Returns the Internal String
     */
    @JsonGetter("order_value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderValue() {
        return this.orderValue;
    }

    /**
     * Getter for OrderValue.
     * The ID of the last resource in the current page. The page can be in an ascending or
     * descending order
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderValue() {
        return OptionalNullable.getFrom(orderValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaginationCursor)) {
            return false;
        }
        PaginationCursor other = (PaginationCursor) obj;
        return Objects.equals(orderValue, other.orderValue);
    }

    /**
     * Converts this PaginationCursor into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaginationCursor [" + "orderValue=" + orderValue + "]";
    }

    /**
     * Builds a new {@link PaginationCursor.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaginationCursor.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.orderValue = internalGetOrderValue();
        return builder;
    }

    /**
     * Class to build instances of {@link PaginationCursor}.
     */
    public static class Builder {
        private OptionalNullable<String> orderValue;



        /**
         * Setter for orderValue.
         * @param  orderValue  String value for orderValue.
         * @return Builder
         */
        public Builder orderValue(String orderValue) {
            this.orderValue = OptionalNullable.of(orderValue);
            return this;
        }

        /**
         * UnSetter for orderValue.
         * @return Builder
         */
        public Builder unsetOrderValue() {
            orderValue = null;
            return this;
        }

        /**
         * Builds a new {@link PaginationCursor} object using the set fields.
         * @return {@link PaginationCursor}
         */
        public PaginationCursor build() {
            return new PaginationCursor(orderValue);
        }
    }
}
