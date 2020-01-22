package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Device type.
 */
public class Device {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     */
    @JsonCreator
    public Device(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    private final String id;
    private final String name;
    /**
     * Getter for Id.
     * The device's Square-issued ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The device's merchant-specified name.
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
        if(!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Objects.equals(id, device.id) &&
            Objects.equals(name, device.name);
    }

    /**
     * Builds a new {@link Device.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Device.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName());
            return builder;
    }

    /**
     * Class to build instances of {@link Device}
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
         * Builds a new {@link Device} object using the set fields.
         * @return {@link Device}
         */
        public Device build() {
            return new Device(id,
                name);
        }
    }
}
