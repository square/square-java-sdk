/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Coordinates.Builder.class)
public final class Coordinates {
    private final Optional<Double> latitude;

    private final Optional<Double> longitude;

    private final Map<String, Object> additionalProperties;

    private Coordinates(
            Optional<Double> latitude, Optional<Double> longitude, Map<String, Object> additionalProperties) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The latitude of the coordinate expressed in degrees.
     */
    @JsonIgnore
    public Optional<Double> getLatitude() {
        if (latitude == null) {
            return Optional.empty();
        }
        return latitude;
    }

    /**
     * @return The longitude of the coordinate expressed in degrees.
     */
    @JsonIgnore
    public Optional<Double> getLongitude() {
        if (longitude == null) {
            return Optional.empty();
        }
        return longitude;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("latitude")
    private Optional<Double> _getLatitude() {
        return latitude;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("longitude")
    private Optional<Double> _getLongitude() {
        return longitude;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Coordinates && equalTo((Coordinates) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Coordinates other) {
        return latitude.equals(other.latitude) && longitude.equals(other.longitude);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.latitude, this.longitude);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Double> latitude = Optional.empty();

        private Optional<Double> longitude = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Coordinates other) {
            latitude(other.getLatitude());
            longitude(other.getLongitude());
            return this;
        }

        @JsonSetter(value = "latitude", nulls = Nulls.SKIP)
        public Builder latitude(Optional<Double> latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder latitude(Double latitude) {
            this.latitude = Optional.ofNullable(latitude);
            return this;
        }

        public Builder latitude(Nullable<Double> latitude) {
            if (latitude.isNull()) {
                this.latitude = null;
            } else if (latitude.isEmpty()) {
                this.latitude = Optional.empty();
            } else {
                this.latitude = Optional.of(latitude.get());
            }
            return this;
        }

        @JsonSetter(value = "longitude", nulls = Nulls.SKIP)
        public Builder longitude(Optional<Double> longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder longitude(Double longitude) {
            this.longitude = Optional.ofNullable(longitude);
            return this;
        }

        public Builder longitude(Nullable<Double> longitude) {
            if (longitude.isNull()) {
                this.longitude = null;
            } else if (longitude.isEmpty()) {
                this.longitude = Optional.empty();
            } else {
                this.longitude = Optional.of(longitude.get());
            }
            return this;
        }

        public Coordinates build() {
            return new Coordinates(latitude, longitude, additionalProperties);
        }
    }
}
