/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.cashdrawers.types;

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
@JsonDeserialize(builder = GetShiftsRequest.Builder.class)
public final class GetShiftsRequest {
    private final String shiftId;

    private final String locationId;

    private final Map<String, Object> additionalProperties;

    private GetShiftsRequest(String shiftId, String locationId, Map<String, Object> additionalProperties) {
        this.shiftId = shiftId;
        this.locationId = locationId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The shift ID.
     */
    @JsonProperty("shift_id")
    public String getShiftId() {
        return shiftId;
    }

    /**
     * @return The ID of the location to retrieve cash drawer shifts from.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetShiftsRequest && equalTo((GetShiftsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetShiftsRequest other) {
        return shiftId.equals(other.shiftId) && locationId.equals(other.locationId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.shiftId, this.locationId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ShiftIdStage builder() {
        return new Builder();
    }

    public interface ShiftIdStage {
        LocationIdStage shiftId(@NotNull String shiftId);

        Builder from(GetShiftsRequest other);
    }

    public interface LocationIdStage {
        _FinalStage locationId(@NotNull String locationId);
    }

    public interface _FinalStage {
        GetShiftsRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ShiftIdStage, LocationIdStage, _FinalStage {
        private String shiftId;

        private String locationId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetShiftsRequest other) {
            shiftId(other.getShiftId());
            locationId(other.getLocationId());
            return this;
        }

        /**
         * <p>The shift ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("shift_id")
        public LocationIdStage shiftId(@NotNull String shiftId) {
            this.shiftId = Objects.requireNonNull(shiftId, "shiftId must not be null");
            return this;
        }

        /**
         * <p>The ID of the location to retrieve cash drawer shifts from.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public _FinalStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        @java.lang.Override
        public GetShiftsRequest build() {
            return new GetShiftsRequest(shiftId, locationId, additionalProperties);
        }
    }
}
