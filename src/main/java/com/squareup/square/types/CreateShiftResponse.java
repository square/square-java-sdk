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
@JsonDeserialize(builder = CreateShiftResponse.Builder.class)
public final class CreateShiftResponse {
    private final Optional<Shift> shift;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private CreateShiftResponse(
            Optional<Shift> shift, Optional<List<Error>> errors, Map<String, Object> additionalProperties) {
        this.shift = shift;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The <code>Shift</code> that was created on the request.
     */
    @JsonProperty("shift")
    public Optional<Shift> getShift() {
        return shift;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateShiftResponse && equalTo((CreateShiftResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateShiftResponse other) {
        return shift.equals(other.shift) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.shift, this.errors);
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
        private Optional<Shift> shift = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateShiftResponse other) {
            shift(other.getShift());
            errors(other.getErrors());
            return this;
        }

        /**
         * <p>The <code>Shift</code> that was created on the request.</p>
         */
        @JsonSetter(value = "shift", nulls = Nulls.SKIP)
        public Builder shift(Optional<Shift> shift) {
            this.shift = shift;
            return this;
        }

        public Builder shift(Shift shift) {
            this.shift = Optional.ofNullable(shift);
            return this;
        }

        /**
         * <p>Any errors that occurred during the request.</p>
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

        public CreateShiftResponse build() {
            return new CreateShiftResponse(shift, errors, additionalProperties);
        }
    }
}
