
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Device type.
 */
public class Device {
    private final String id;
    private final DeviceAttributes attributes;
    private final OptionalNullable<List<Component>> components;
    private final DeviceStatus status;

    /**
     * Initialization constructor.
     * @param  attributes  DeviceAttributes value for attributes.
     * @param  id  String value for id.
     * @param  components  List of Component value for components.
     * @param  status  DeviceStatus value for status.
     */
    @JsonCreator
    public Device(
            @JsonProperty("attributes") DeviceAttributes attributes,
            @JsonProperty("id") String id,
            @JsonProperty("components") List<Component> components,
            @JsonProperty("status") DeviceStatus status) {
        this.id = id;
        this.attributes = attributes;
        this.components = OptionalNullable.of(components);
        this.status = status;
    }

    /**
     * Internal initialization constructor.
     */
    protected Device(DeviceAttributes attributes, String id,
            OptionalNullable<List<Component>> components, DeviceStatus status) {
        this.id = id;
        this.attributes = attributes;
        this.components = components;
        this.status = status;
    }

    /**
     * Getter for Id.
     * A synthetic identifier for the device. The identifier includes a standardized prefix and is
     * otherwise an opaque id generated from key device fields.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Attributes.
     * @return Returns the DeviceAttributes
     */
    @JsonGetter("attributes")
    public DeviceAttributes getAttributes() {
        return attributes;
    }

    /**
     * Internal Getter for Components.
     * A list of components applicable to the device.
     * @return Returns the Internal List of Component
     */
    @JsonGetter("components")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Component>> internalGetComponents() {
        return this.components;
    }

    /**
     * Getter for Components.
     * A list of components applicable to the device.
     * @return Returns the List of Component
     */
    @JsonIgnore
    public List<Component> getComponents() {
        return OptionalNullable.getFrom(components);
    }

    /**
     * Getter for Status.
     * @return Returns the DeviceStatus
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeviceStatus getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attributes, components, status);
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
            && Objects.equals(attributes, other.attributes)
            && Objects.equals(components, other.components)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this Device into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Device [" + "attributes=" + attributes + ", id=" + id + ", components=" + components
                + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link Device.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Device.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(attributes)
                .id(getId())
                .status(getStatus());
        builder.components = internalGetComponents();
        return builder;
    }

    /**
     * Class to build instances of {@link Device}.
     */
    public static class Builder {
        private DeviceAttributes attributes;
        private String id;
        private OptionalNullable<List<Component>> components;
        private DeviceStatus status;

        /**
         * Initialization constructor.
         * @param  attributes  DeviceAttributes value for attributes.
         */
        public Builder(DeviceAttributes attributes) {
            this.attributes = attributes;
        }

        /**
         * Setter for attributes.
         * @param  attributes  DeviceAttributes value for attributes.
         * @return Builder
         */
        public Builder attributes(DeviceAttributes attributes) {
            this.attributes = attributes;
            return this;
        }

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
         * Setter for components.
         * @param  components  List of Component value for components.
         * @return Builder
         */
        public Builder components(List<Component> components) {
            this.components = OptionalNullable.of(components);
            return this;
        }

        /**
         * UnSetter for components.
         * @return Builder
         */
        public Builder unsetComponents() {
            components = null;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  DeviceStatus value for status.
         * @return Builder
         */
        public Builder status(DeviceStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link Device} object using the set fields.
         * @return {@link Device}
         */
        public Device build() {
            return new Device(attributes, id, components, status);
        }
    }
}
