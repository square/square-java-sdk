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
@JsonDeserialize(builder = UpdateWorkweekConfigResponse.Builder.class)
public final class UpdateWorkweekConfigResponse {
    private final Optional<WorkweekConfig> workweekConfig;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private UpdateWorkweekConfigResponse(
            Optional<WorkweekConfig> workweekConfig,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.workweekConfig = workweekConfig;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The response object.
     */
    @JsonProperty("workweek_config")
    public Optional<WorkweekConfig> getWorkweekConfig() {
        return workweekConfig;
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
        return other instanceof UpdateWorkweekConfigResponse && equalTo((UpdateWorkweekConfigResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateWorkweekConfigResponse other) {
        return workweekConfig.equals(other.workweekConfig) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.workweekConfig, this.errors);
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
        private Optional<WorkweekConfig> workweekConfig = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(UpdateWorkweekConfigResponse other) {
            workweekConfig(other.getWorkweekConfig());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "workweek_config", nulls = Nulls.SKIP)
        public Builder workweekConfig(Optional<WorkweekConfig> workweekConfig) {
            this.workweekConfig = workweekConfig;
            return this;
        }

        public Builder workweekConfig(WorkweekConfig workweekConfig) {
            this.workweekConfig = Optional.ofNullable(workweekConfig);
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

        public UpdateWorkweekConfigResponse build() {
            return new UpdateWorkweekConfigResponse(workweekConfig, errors, additionalProperties);
        }
    }
}
