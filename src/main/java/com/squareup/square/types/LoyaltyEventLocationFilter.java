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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LoyaltyEventLocationFilter.Builder.class)
public final class LoyaltyEventLocationFilter {
    private final List<String> locationIds;

    private final Map<String, Object> additionalProperties;

    private LoyaltyEventLocationFilter(List<String> locationIds, Map<String, Object> additionalProperties) {
        this.locationIds = locationIds;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The <a href="entity:Location">location</a> IDs for loyalty events to query.
     * If multiple values are specified, the endpoint uses
     * a logical OR to combine them.
     */
    @JsonProperty("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyEventLocationFilter && equalTo((LoyaltyEventLocationFilter) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyEventLocationFilter other) {
        return locationIds.equals(other.locationIds);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.locationIds);
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
        private List<String> locationIds = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(LoyaltyEventLocationFilter other) {
            locationIds(other.getLocationIds());
            return this;
        }

        /**
         * <p>The <a href="entity:Location">location</a> IDs for loyalty events to query.
         * If multiple values are specified, the endpoint uses
         * a logical OR to combine them.</p>
         */
        @JsonSetter(value = "location_ids", nulls = Nulls.SKIP)
        public Builder locationIds(List<String> locationIds) {
            this.locationIds.clear();
            this.locationIds.addAll(locationIds);
            return this;
        }

        public Builder addLocationIds(String locationIds) {
            this.locationIds.add(locationIds);
            return this;
        }

        public Builder addAllLocationIds(List<String> locationIds) {
            this.locationIds.addAll(locationIds);
            return this;
        }

        public LoyaltyEventLocationFilter build() {
            return new LoyaltyEventLocationFilter(locationIds, additionalProperties);
        }
    }
}
