
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
 * This is a model class for Coordinates type.
 */
public class Coordinates {
    private final OptionalNullable<Double> latitude;
    private final OptionalNullable<Double> longitude;

    /**
     * Initialization constructor.
     * @param  latitude  Double value for latitude.
     * @param  longitude  Double value for longitude.
     */
    @JsonCreator
    public Coordinates(
            @JsonProperty("latitude") Double latitude,
            @JsonProperty("longitude") Double longitude) {
        this.latitude = OptionalNullable.of(latitude);
        this.longitude = OptionalNullable.of(longitude);
    }

    /**
     * Internal initialization constructor.
     */
    protected Coordinates(OptionalNullable<Double> latitude, OptionalNullable<Double> longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Internal Getter for Latitude.
     * The latitude of the coordinate expressed in degrees.
     * @return Returns the Internal Double
     */
    @JsonGetter("latitude")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Double> internalGetLatitude() {
        return this.latitude;
    }

    /**
     * Getter for Latitude.
     * The latitude of the coordinate expressed in degrees.
     * @return Returns the Double
     */
    @JsonIgnore
    public Double getLatitude() {
        return OptionalNullable.getFrom(latitude);
    }

    /**
     * Internal Getter for Longitude.
     * The longitude of the coordinate expressed in degrees.
     * @return Returns the Internal Double
     */
    @JsonGetter("longitude")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Double> internalGetLongitude() {
        return this.longitude;
    }

    /**
     * Getter for Longitude.
     * The longitude of the coordinate expressed in degrees.
     * @return Returns the Double
     */
    @JsonIgnore
    public Double getLongitude() {
        return OptionalNullable.getFrom(longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coordinates)) {
            return false;
        }
        Coordinates other = (Coordinates) obj;
        return Objects.equals(latitude, other.latitude)
            && Objects.equals(longitude, other.longitude);
    }

    /**
     * Converts this Coordinates into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Coordinates [" + "latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    /**
     * Builds a new {@link Coordinates.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Coordinates.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.latitude = internalGetLatitude();
        builder.longitude = internalGetLongitude();
        return builder;
    }

    /**
     * Class to build instances of {@link Coordinates}.
     */
    public static class Builder {
        private OptionalNullable<Double> latitude;
        private OptionalNullable<Double> longitude;



        /**
         * Setter for latitude.
         * @param  latitude  Double value for latitude.
         * @return Builder
         */
        public Builder latitude(Double latitude) {
            this.latitude = OptionalNullable.of(latitude);
            return this;
        }

        /**
         * UnSetter for latitude.
         * @return Builder
         */
        public Builder unsetLatitude() {
            latitude = null;
            return this;
        }

        /**
         * Setter for longitude.
         * @param  longitude  Double value for longitude.
         * @return Builder
         */
        public Builder longitude(Double longitude) {
            this.longitude = OptionalNullable.of(longitude);
            return this;
        }

        /**
         * UnSetter for longitude.
         * @return Builder
         */
        public Builder unsetLongitude() {
            longitude = null;
            return this;
        }

        /**
         * Builds a new {@link Coordinates} object using the set fields.
         * @return {@link Coordinates}
         */
        public Coordinates build() {
            return new Coordinates(latitude, longitude);
        }
    }
}
