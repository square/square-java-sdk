/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateLocationSettingsResponse.Builder.class)
public final class UpdateLocationSettingsResponse {
    private final Optional<List<Error>> errors;

    private final Optional<CheckoutLocationSettings> locationSettings;

    private final Map<String, Object> additionalProperties;

    private UpdateLocationSettingsResponse(
            Optional<List<Error>> errors,
            Optional<CheckoutLocationSettings> locationSettings,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.locationSettings = locationSettings;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred when updating the location settings.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The updated location settings.
     */
    @JsonProperty("location_settings")
    public Optional<CheckoutLocationSettings> getLocationSettings() {
        return locationSettings;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateLocationSettingsResponse && equalTo((UpdateLocationSettingsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateLocationSettingsResponse other) {
        return errors.equals(other.errors) && locationSettings.equals(other.locationSettings);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.locationSettings);
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
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<CheckoutLocationSettings> locationSettings = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateLocationSettingsResponse other) {
            errors(other.getErrors());
            locationSettings(other.getLocationSettings());
            return this;
        }

        /**
         * <p>Any errors that occurred when updating the location settings.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        /**
         * <p>The updated location settings.</p>
         */
        @JsonSetter(value = "location_settings", nulls = Nulls.SKIP)
        public Builder locationSettings(Optional<CheckoutLocationSettings> locationSettings) {
            this.locationSettings = locationSettings;
            return this;
        }

        public Builder locationSettings(CheckoutLocationSettings locationSettings) {
            this.locationSettings = Optional.ofNullable(locationSettings);
            return this;
        }

        public UpdateLocationSettingsResponse build() {
            return new UpdateLocationSettingsResponse(errors, locationSettings, additionalProperties);
        }
    }
}
