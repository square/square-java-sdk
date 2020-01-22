package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CashDrawerDevice type.
 */
public class CashDrawerDevice {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     */
    @JsonCreator
    public CashDrawerDevice(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    private final String id;
    private final String name;
    /**
     * Getter for Id.
     * The device Square-issued ID
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The device merchant-specified name.
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
        if(!(obj instanceof CashDrawerDevice)) {
            return false;
        }
        CashDrawerDevice cashDrawerDevice = (CashDrawerDevice) obj;
        return Objects.equals(id, cashDrawerDevice.id) &&
            Objects.equals(name, cashDrawerDevice.name);
    }

    /**
     * Builds a new {@link CashDrawerDevice.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashDrawerDevice.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName());
            return builder;
    }

    /**
     * Class to build instances of {@link CashDrawerDevice}
     */
    public static class Builder {
        private String id;
        private String name;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Builds a new {@link CashDrawerDevice} object using the set fields.
         * @return {@link CashDrawerDevice}
         */
        public CashDrawerDevice build() {
            return new CashDrawerDevice(id,
                name);
        }
    }
}
