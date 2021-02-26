
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Device type.
 */
public class Device {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  name  String value for name.
     */
    @JsonCreator
    public Device(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for Id.
     * The device's Square-issued ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Name.
     * The device's merchant-specified name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device other = (Device) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name);
    }

    /**
     * Converts this Device into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Device [" + "id=" + id + ", name=" + name + "]";
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
     * Class to build instances of {@link Device}.
     */
    public static class Builder {
        private String id;
        private String name;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
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
            return new Device(id, name);
        }
    }
}
