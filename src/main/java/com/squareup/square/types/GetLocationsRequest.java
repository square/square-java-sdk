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
@JsonDeserialize(builder = GetLocationsRequest.Builder.class)
public final class GetLocationsRequest {
    private final String locationId;

    private final Map<String, Object> additionalProperties;

    private GetLocationsRequest(String locationId, Map<String, Object> additionalProperties) {
        this.locationId = locationId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the location to retrieve. Specify the string
     * &quot;main&quot; to return the main location.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetLocationsRequest && equalTo((GetLocationsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetLocationsRequest other) {
        return locationId.equals(other.locationId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.locationId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LocationIdStage builder() {
        return new Builder();
    }

    public interface LocationIdStage {
        _FinalStage locationId(@NotNull String locationId);

        Builder from(GetLocationsRequest other);
    }

    public interface _FinalStage {
        GetLocationsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LocationIdStage, _FinalStage {
        private String locationId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetLocationsRequest other) {
            locationId(other.getLocationId());
            return this;
        }

        /**
         * <p>The ID of the location to retrieve. Specify the string
         * &quot;main&quot; to return the main location.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public _FinalStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        @java.lang.Override
        public GetLocationsRequest build() {
            return new GetLocationsRequest(locationId, additionalProperties);
        }
    }
}
