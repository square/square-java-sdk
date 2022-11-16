
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
 * This is a model class for Device type.
 */
public class Device {
    private final String id;
    private final OptionalNullable<String> name;

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
        this.name = OptionalNullable.of(name);
    }

    /**
     * Internal initialization constructor.
     */
    protected Device(String id, OptionalNullable<String> name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for Id.
     * The device's Square-issued ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for Name.
     * The device's merchant-specified name.
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
     * The device's merchant-specified name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
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
                .id(getId());
        builder.name = internalGetName();
        return builder;
    }

    /**
     * Class to build instances of {@link Device}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> name;



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
         * Builds a new {@link Device} object using the set fields.
         * @return {@link Device}
         */
        public Device build() {
            return new Device(id, name);
        }
    }
}
