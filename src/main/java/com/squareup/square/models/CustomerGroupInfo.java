package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomerGroupInfo type.
 */
public class CustomerGroupInfo {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     */
    @JsonCreator
    public CustomerGroupInfo(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    private final String id;
    private final String name;
    /**
     * Getter for Id.
     * The ID of the Customer Group.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The name of the Customer Group.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomerGroupInfo)) {
            return false;
        }
        CustomerGroupInfo customerGroupInfo = (CustomerGroupInfo) obj;
        return Objects.equals(id, customerGroupInfo.id) &&
            Objects.equals(name, customerGroupInfo.name);
    }

    /**
     * Builds a new {@link CustomerGroupInfo.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerGroupInfo.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            name);
            return builder;
    }

    /**
     * Class to build instances of {@link CustomerGroupInfo}
     */
    public static class Builder {
        private String id;
        private String name;

        /**
         * Initialization constructor
         */
        public Builder(String id,
                String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
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
         * Builds a new {@link CustomerGroupInfo} object using the set fields.
         * @return {@link CustomerGroupInfo}
         */
        public CustomerGroupInfo build() {
            return new CustomerGroupInfo(id,
                name);
        }
    }
}
