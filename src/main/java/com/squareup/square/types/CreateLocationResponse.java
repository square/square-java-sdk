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
@JsonDeserialize(builder = CreateLocationResponse.Builder.class)
public final class CreateLocationResponse {
    private final Optional<List<Error>> errors;

    private final Optional<Location> location;

    private final Map<String, Object> additionalProperties;

    private CreateLocationResponse(
            Optional<List<Error>> errors, Optional<Location> location, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.location = location;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information about <a href="https://developer.squareup.com/docs/build-basics/handling-errors">errors</a> encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The newly created <code>Location</code> object.
     */
    @JsonProperty("location")
    public Optional<Location> getLocation() {
        return location;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateLocationResponse && equalTo((CreateLocationResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateLocationResponse other) {
        return errors.equals(other.errors) && location.equals(other.location);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.location);
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

        private Optional<Location> location = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateLocationResponse other) {
            errors(other.getErrors());
            location(other.getLocation());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        @JsonSetter(value = "location", nulls = Nulls.SKIP)
        public Builder location(Optional<Location> location) {
            this.location = location;
            return this;
        }

        public Builder location(Location location) {
            this.location = Optional.ofNullable(location);
            return this;
        }

        public CreateLocationResponse build() {
            return new CreateLocationResponse(errors, location, additionalProperties);
        }
    }
}
