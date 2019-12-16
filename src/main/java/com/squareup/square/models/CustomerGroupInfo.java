package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerGroupInfo {

    @JsonCreator
    public CustomerGroupInfo(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    private final String id;
    private final String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerGroupInfo)) {
            return false;
        }
        CustomerGroupInfo customerGroupInfo = (CustomerGroupInfo) o;
        return Objects.equals(id, customerGroupInfo.id) &&
            Objects.equals(name, customerGroupInfo.name);
    }

    /**
     * Getter for Id.
     * The ID of the customer group.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The name of the customer group.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            name);
            return builder;
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder(String id,
                String name) {
            this.id = id;
            this.name = name;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }

        public CustomerGroupInfo build() {
            return new CustomerGroupInfo(id,
                name);
        }
    }
}
