package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderSource type.
 */
public class OrderSource {

    /**
     * Initialization constructor.
     * @param name
     */
    @JsonCreator
    public OrderSource(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    private final String name;
    /**
     * Getter for Name.
     * The name used to identify the place (physical or digital) that an order originates.
     * If unset, the name defaults to the name of the application that created the order.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderSource)) {
            return false;
        }
        OrderSource orderSource = (OrderSource) obj;
        return Objects.equals(name, orderSource.name);
    }

    /**
     * Builds a new {@link OrderSource.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderSource.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderSource}
     */
    public static class Builder {
        private String name;

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
         * Builds a new {@link OrderSource} object using the set fields.
         * @return {@link OrderSource}
         */
        public OrderSource build() {
            return new OrderSource(name);
        }
    }
}
