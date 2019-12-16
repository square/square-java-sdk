package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderSource {

    @JsonCreator
    public OrderSource(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    private final String name;

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderSource)) {
            return false;
        }
        OrderSource orderSource = (OrderSource) o;
        return Objects.equals(name, orderSource.name);
    }

    /**
     * Getter for Name.
     * The name used to identify the place (physical or digital) that an order originates.
     * If unset, the name defaults to the name of the application that created the order.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName());
            return builder;
    }

    public static class Builder {
        private String name;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }

        public OrderSource build() {
            return new OrderSource(name);
        }
    }
}
