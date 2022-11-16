
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderSource type.
 */
public class OrderSource {
    private final OptionalNullable<String> name;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     */
    @JsonCreator
    public OrderSource(
            @JsonProperty("name") String name) {
        this.name = OptionalNullable.of(name);
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderSource(OptionalNullable<String> name) {
        this.name = name;
    }

    /**
     * Internal Getter for Name.
     * The name used to identify the place (physical or digital) that an order originates. If unset,
     * the name defaults to the name of the application that created the order.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name used to identify the place (physical or digital) that an order originates. If unset,
     * the name defaults to the name of the application that created the order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderSource)) {
            return false;
        }
        OrderSource other = (OrderSource) obj;
        return Objects.equals(name, other.name);
    }

    /**
     * Converts this OrderSource into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderSource [" + "name=" + name + "]";
    }

    /**
     * Builds a new {@link OrderSource.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderSource.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.name = internalGetName();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderSource}.
     */
    public static class Builder {
        private OptionalNullable<String> name;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Builds a new {@link OrderSource} object using the set fields.
         * @return {@link OrderSource}
         */
        public OrderSource build() {
            return new OrderSource(name);
        }
    }
}
