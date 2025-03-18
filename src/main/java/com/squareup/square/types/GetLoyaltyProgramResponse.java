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
@JsonDeserialize(builder = GetLoyaltyProgramResponse.Builder.class)
public final class GetLoyaltyProgramResponse {
    private final Optional<List<Error>> errors;

    private final Optional<LoyaltyProgram> program;

    private final Map<String, Object> additionalProperties;

    private GetLoyaltyProgramResponse(
            Optional<List<Error>> errors, Optional<LoyaltyProgram> program, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.program = program;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The loyalty program that was requested.
     */
    @JsonProperty("program")
    public Optional<LoyaltyProgram> getProgram() {
        return program;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetLoyaltyProgramResponse && equalTo((GetLoyaltyProgramResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetLoyaltyProgramResponse other) {
        return errors.equals(other.errors) && program.equals(other.program);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.program);
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

        private Optional<LoyaltyProgram> program = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetLoyaltyProgramResponse other) {
            errors(other.getErrors());
            program(other.getProgram());
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

        @JsonSetter(value = "program", nulls = Nulls.SKIP)
        public Builder program(Optional<LoyaltyProgram> program) {
            this.program = program;
            return this;
        }

        public Builder program(LoyaltyProgram program) {
            this.program = Optional.ofNullable(program);
            return this;
        }

        public GetLoyaltyProgramResponse build() {
            return new GetLoyaltyProgramResponse(errors, program, additionalProperties);
        }
    }
}
