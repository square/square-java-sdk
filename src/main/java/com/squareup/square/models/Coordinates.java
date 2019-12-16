package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Coordinates {

    @JsonCreator
    public Coordinates(
            @JsonProperty("latitude") Double latitude,
            @JsonProperty("longitude") Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private final Double latitude;
    private final Double longitude;

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coordinates)) {
            return false;
        }
        Coordinates coordinates = (Coordinates) o;
        return Objects.equals(latitude, coordinates.latitude) &&
            Objects.equals(longitude, coordinates.longitude);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .latitude(getLatitude())
            .longitude(getLongitude());
            return builder;
    }

    public static class Builder {
        private Double latitude;
        private Double longitude;

        public Builder() { }

        public Builder latitude(Double value) {
            latitude = value;
            return this;
        }
        public Builder longitude(Double value) {
            longitude = value;
            return this;
        }

        public Coordinates build() {
            return new Coordinates(latitude,
                longitude);
        }
    }
}
