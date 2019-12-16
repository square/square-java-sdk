package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class GetEmployeeWageResponse {

    @JsonCreator
    public GetEmployeeWageResponse(
            @JsonProperty("employee_wage") EmployeeWage employeeWage,
            @JsonProperty("errors") List<Error> errors) {
        this.employeeWage = employeeWage;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final EmployeeWage employeeWage;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(employeeWage, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GetEmployeeWageResponse)) {
            return false;
        }
        GetEmployeeWageResponse getEmployeeWageResponse = (GetEmployeeWageResponse) o;
        return Objects.equals(employeeWage, getEmployeeWageResponse.employeeWage) &&
            Objects.equals(errors, getEmployeeWageResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for EmployeeWage.
     * The hourly wage rate that an employee will earn on a `Shift` for doing the job
     * specified by the `title` property of this object.
     */
    @JsonGetter("employee_wage")
    public EmployeeWage getEmployeeWage() { 
        return this.employeeWage;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeWage(getEmployeeWage())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private EmployeeWage employeeWage;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder employeeWage(EmployeeWage value) {
            employeeWage = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public GetEmployeeWageResponse build() {
            GetEmployeeWageResponse model = new GetEmployeeWageResponse(employeeWage,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
