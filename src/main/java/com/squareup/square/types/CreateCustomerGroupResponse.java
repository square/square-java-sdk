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
@JsonDeserialize(builder = CreateCustomerGroupResponse.Builder.class)
public final class CreateCustomerGroupResponse {
    private final Optional<List<Error>> errors;

    private final Optional<CustomerGroup> group;

    private final Map<String, Object> additionalProperties;

    private CreateCustomerGroupResponse(
            Optional<List<Error>> errors, Optional<CustomerGroup> group, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.group = group;
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
     * @return The successfully created customer group.
     */
    @JsonProperty("group")
    public Optional<CustomerGroup> getGroup() {
        return group;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateCustomerGroupResponse && equalTo((CreateCustomerGroupResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateCustomerGroupResponse other) {
        return errors.equals(other.errors) && group.equals(other.group);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.group);
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

        private Optional<CustomerGroup> group = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CreateCustomerGroupResponse other) {
            errors(other.getErrors());
            group(other.getGroup());
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

        /**
         * <p>The successfully created customer group.</p>
         */
        @JsonSetter(value = "group", nulls = Nulls.SKIP)
        public Builder group(Optional<CustomerGroup> group) {
            this.group = group;
            return this;
        }

        public Builder group(CustomerGroup group) {
            this.group = Optional.ofNullable(group);
            return this;
        }

        public CreateCustomerGroupResponse build() {
            return new CreateCustomerGroupResponse(errors, group, additionalProperties);
        }
    }
}
