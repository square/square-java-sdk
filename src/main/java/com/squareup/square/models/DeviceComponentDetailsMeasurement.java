
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for DeviceComponentDetailsMeasurement type.
 */
public class DeviceComponentDetailsMeasurement {
    private final OptionalNullable<Integer> value;

    /**
     * Initialization constructor.
     * @param  value  Integer value for value.
     */
    @JsonCreator
    public DeviceComponentDetailsMeasurement(
            @JsonProperty("value") Integer value) {
        this.value = OptionalNullable.of(value);
    }

    /**
     * Initialization constructor.
     * @param  value  Integer value for value.
     */

    protected DeviceComponentDetailsMeasurement(OptionalNullable<Integer> value) {
        this.value = value;
    }

    /**
     * Internal Getter for Value.
     * @return Returns the Internal Integer
     */
    @JsonGetter("value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetValue() {
        return this.value;
    }

    /**
     * Getter for Value.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getValue() {
        return OptionalNullable.getFrom(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceComponentDetailsMeasurement)) {
            return false;
        }
        DeviceComponentDetailsMeasurement other = (DeviceComponentDetailsMeasurement) obj;
        return Objects.equals(value, other.value);
    }

    /**
     * Converts this DeviceComponentDetailsMeasurement into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsMeasurement [" + "value=" + value + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsMeasurement.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsMeasurement.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.value = internalGetValue();
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsMeasurement}.
     */
    public static class Builder {
        private OptionalNullable<Integer> value;



        /**
         * Setter for value.
         * @param  value  Integer value for value.
         * @return Builder
         */
        public Builder value(Integer value) {
            this.value = OptionalNullable.of(value);
            return this;
        }

        /**
         * UnSetter for value.
         * @return Builder
         */
        public Builder unsetValue() {
            value = null;
            return this;
        }

        /**
         * Builds a new {@link DeviceComponentDetailsMeasurement} object using the set fields.
         * @return {@link DeviceComponentDetailsMeasurement}
         */
        public DeviceComponentDetailsMeasurement build() {
            return new DeviceComponentDetailsMeasurement(value);
        }
    }
}
