
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Coordinates type.
 */
public class Coordinates {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Double latitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Double longitude;

    /**
     * Initialization constructor.
     * @param  latitude  Double value for latitude.
     * @param  longitude  Double value for longitude.
     */
    @JsonCreator
    public Coordinates(
            @JsonProperty("latitude") Double latitude,
            @JsonProperty("longitude") Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Getter for Latitude.
     * The latitude of the coordinate expressed in degrees.
     * @return Returns the Double
     */
    @JsonGetter("latitude")
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Getter for Longitude.
     * The longitude of the coordinate expressed in degrees.
     * @return Returns the Double
     */
    @JsonGetter("longitude")
    public Double getLongitude() {
        return longitude;
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
        Builder builder = new Builder()
                .latitude(getLatitude())
                .longitude(getLongitude());
        return builder;
    }

    /**
     * Class to build instances of {@link Coordinates}.
     */
    public static class Builder {
        private Double latitude;
        private Double longitude;



        /**
         * Setter for latitude.
         * @param  latitude  Double value for latitude.
         * @return Builder
         */
        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        /**
         * Setter for longitude.
         * @param  longitude  Double value for longitude.
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
            return new Coordinates(latitude, longitude);
        }
    }
}
