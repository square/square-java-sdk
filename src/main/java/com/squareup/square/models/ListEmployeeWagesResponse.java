package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListEmployeeWagesResponse {

    @JsonCreator
    public ListEmployeeWagesResponse(
            @JsonProperty("employee_wages") List<EmployeeWage> employeeWages,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.employeeWages = employeeWages;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<EmployeeWage> employeeWages;
    private final String cursor;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(employeeWages, cursor, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListEmployeeWagesResponse)) {
            return false;
        }
        ListEmployeeWagesResponse listEmployeeWagesResponse = (ListEmployeeWagesResponse) o;
        return Objects.equals(employeeWages, listEmployeeWagesResponse.employeeWages) &&
            Objects.equals(cursor, listEmployeeWagesResponse.cursor) &&
            Objects.equals(errors, listEmployeeWagesResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for EmployeeWages.
     * A page of Employee Wage results.
     */
    @JsonGetter("employee_wages")
    public List<EmployeeWage> getEmployeeWages() { 
        return this.employeeWages;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next next page
     * of Employee Wage results.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
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
            .employeeWages(getEmployeeWages())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<EmployeeWage> employeeWages;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder employeeWages(List<EmployeeWage> value) {
            employeeWages = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public ListEmployeeWagesResponse build() {
            ListEmployeeWagesResponse model = new ListEmployeeWagesResponse(employeeWages,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
