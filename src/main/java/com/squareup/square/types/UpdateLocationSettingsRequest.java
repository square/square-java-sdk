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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateLocationSettingsRequest.Builder.class)
public final class UpdateLocationSettingsRequest {
    private final String locationId;

    private final CheckoutLocationSettings locationSettings;

    private final Map<String, Object> additionalProperties;

    private UpdateLocationSettingsRequest(
            String locationId, CheckoutLocationSettings locationSettings, Map<String, Object> additionalProperties) {
        this.locationId = locationId;
        this.locationSettings = locationSettings;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the location for which to retrieve settings.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * @return Describe your updates using the <code>location_settings</code> object. Make sure it contains only the fields that have changed.
     */
    @JsonProperty("location_settings")
    public CheckoutLocationSettings getLocationSettings() {
        return locationSettings;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateLocationSettingsRequest && equalTo((UpdateLocationSettingsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateLocationSettingsRequest other) {
        return locationId.equals(other.locationId) && locationSettings.equals(other.locationSettings);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.locationId, this.locationSettings);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LocationIdStage builder() {
        return new Builder();
    }

    public interface LocationIdStage {
        /**
         * <p>The ID of the location for which to retrieve settings.</p>
         */
        LocationSettingsStage locationId(@NotNull String locationId);

        Builder from(UpdateLocationSettingsRequest other);
    }

    public interface LocationSettingsStage {
        /**
         * <p>Describe your updates using the <code>location_settings</code> object. Make sure it contains only the fields that have changed.</p>
         */
        _FinalStage locationSettings(@NotNull CheckoutLocationSettings locationSettings);
    }

    public interface _FinalStage {
        UpdateLocationSettingsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LocationIdStage, LocationSettingsStage, _FinalStage {
        private String locationId;

        private CheckoutLocationSettings locationSettings;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UpdateLocationSettingsRequest other) {
            locationId(other.getLocationId());
            locationSettings(other.getLocationSettings());
            return this;
        }

        /**
         * <p>The ID of the location for which to retrieve settings.</p>
         * <p>The ID of the location for which to retrieve settings.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public LocationSettingsStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        /**
         * <p>Describe your updates using the <code>location_settings</code> object. Make sure it contains only the fields that have changed.</p>
         * <p>Describe your updates using the <code>location_settings</code> object. Make sure it contains only the fields that have changed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_settings")
        public _FinalStage locationSettings(@NotNull CheckoutLocationSettings locationSettings) {
            this.locationSettings = Objects.requireNonNull(locationSettings, "locationSettings must not be null");
            return this;
        }

        @java.lang.Override
        public UpdateLocationSettingsRequest build() {
            return new UpdateLocationSettingsRequest(locationId, locationSettings, additionalProperties);
        }
    }
}
