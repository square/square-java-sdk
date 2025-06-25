package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DeviceStatus type.
 */
public class DeviceStatus {
    private final String category;

    /**
     * Initialization constructor.
     * @param  category  String value for category.
     */
    @JsonCreator
    public DeviceStatus(@JsonProperty("category") String category) {
        this.category = category;
    }

    /**
     * Getter for Category.
     * @return Returns the String
     */
    @JsonGetter("category")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCategory() {
        return category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus other = (DeviceStatus) obj;
        return Objects.equals(category, other.category);
    }

    /**
     * Converts this DeviceStatus into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceStatus [" + "category=" + category + "]";
    }

    /**
     * Builds a new {@link DeviceStatus.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceStatus.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().category(getCategory());
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceStatus}.
     */
    public static class Builder {
        private String category;

        /**
         * Setter for category.
         * @param  category  String value for category.
         * @return Builder
         */
        public Builder category(String category) {
            this.category = category;
            return this;
        }

        /**
         * Builds a new {@link DeviceStatus} object using the set fields.
         * @return {@link DeviceStatus}
         */
        public DeviceStatus build() {
            return new DeviceStatus(category);
        }
    }
}
