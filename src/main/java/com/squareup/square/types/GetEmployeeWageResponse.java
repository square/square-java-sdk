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
@JsonDeserialize(builder = GetEmployeeWageResponse.Builder.class)
public final class GetEmployeeWageResponse {
    private final Optional<EmployeeWage> employeeWage;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private GetEmployeeWageResponse(
            Optional<EmployeeWage> employeeWage,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.employeeWage = employeeWage;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The requested <code>EmployeeWage</code> object.
     */
    @JsonProperty("employee_wage")
    public Optional<EmployeeWage> getEmployeeWage() {
        return employeeWage;
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
        return other instanceof GetEmployeeWageResponse && equalTo((GetEmployeeWageResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetEmployeeWageResponse other) {
        return employeeWage.equals(other.employeeWage) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.employeeWage, this.errors);
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
        private Optional<EmployeeWage> employeeWage = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetEmployeeWageResponse other) {
            employeeWage(other.getEmployeeWage());
            errors(other.getErrors());
            return this;
        }

        /**
         * <p>The requested <code>EmployeeWage</code> object.</p>
         */
        @JsonSetter(value = "employee_wage", nulls = Nulls.SKIP)
        public Builder employeeWage(Optional<EmployeeWage> employeeWage) {
            this.employeeWage = employeeWage;
            return this;
        }

        public Builder employeeWage(EmployeeWage employeeWage) {
            this.employeeWage = Optional.ofNullable(employeeWage);
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

        public GetEmployeeWageResponse build() {
            return new GetEmployeeWageResponse(employeeWage, errors, additionalProperties);
        }
    }
}
