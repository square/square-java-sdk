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
@JsonDeserialize(builder = GetEmployeeResponse.Builder.class)
public final class GetEmployeeResponse {
    private final Optional<Employee> employee;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private GetEmployeeResponse(
            Optional<Employee> employee, Optional<List<Error>> errors, Map<String, Object> additionalProperties) {
        this.employee = employee;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("employee")
    public Optional<Employee> getEmployee() {
        return employee;
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
        return other instanceof GetEmployeeResponse && equalTo((GetEmployeeResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetEmployeeResponse other) {
        return employee.equals(other.employee) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.employee, this.errors);
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
        private Optional<Employee> employee = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetEmployeeResponse other) {
            employee(other.getEmployee());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "employee", nulls = Nulls.SKIP)
        public Builder employee(Optional<Employee> employee) {
            this.employee = employee;
            return this;
        }

        public Builder employee(Employee employee) {
            this.employee = Optional.ofNullable(employee);
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

        public GetEmployeeResponse build() {
            return new GetEmployeeResponse(employee, errors, additionalProperties);
        }
    }
}
