package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Coordinates type.
 */
public class Coordinates {

    /**
     * Initialization constructor.
     * @param latitude
     * @param longitude
     */
    @JsonCreator
    public Coordinates(
            @JsonProperty("latitude") Double latitude,
            @JsonProperty("longitude") Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private final Double latitude;
    private final Double longitude;
    /**
     * Getter for Latitude.
     * The latitude of the coordinate expressed in degrees.
     */
    @JsonGetter("latitude")
    public Double getLatitude() {
        return this.latitude;
    }

    /**
     * Getter for Longitude.
     * The longitude of the coordinate expressed in degrees.
     */
    @JsonGetter("longitude")
    public Double getLongitude() {
        return this.longitude;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Coordinates)) {
            return false;
        }
        Coordinates coordinates = (Coordinates) obj;
        return Objects.equals(latitude, coordinates.latitude) &&
            Objects.equals(longitude, coordinates.longitude);
    }

    /**
     * Builds a new {@link Coordinates.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Coordinates.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .latitude(getLatitude())
            .longitude(getLongitude());
            return builder;
    }

    /**
     * Class to build instances of {@link Coordinates}
     */
    public static class Builder {
        private Double latitude;
        private Double longitude;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for latitude
         * @param latitude
         * @return Builder
         */
        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }
        /**
         * Setter for longitude
         * @param longitude
         * @return Builder
         */
        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        /**
         * Builds a new {@link Coordinates} object using the set fields.
         * @return {@link Coordinates}
         */
        public Coordinates build() {
            return new Coordinates(latitude,
                longitude);
        }
    }
}
