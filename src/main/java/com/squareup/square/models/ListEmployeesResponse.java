package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListEmployeesResponse {

    @JsonCreator
    public ListEmployeesResponse(
            @JsonProperty("employees") List<Employee> employees,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.employees = employees;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Employee> employees;
    private final String cursor;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(employees, cursor, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListEmployeesResponse)) {
            return false;
        }
        ListEmployeesResponse listEmployeesResponse = (ListEmployeesResponse) o;
        return Objects.equals(employees, listEmployeesResponse.employees) &&
            Objects.equals(cursor, listEmployeesResponse.cursor) &&
            Objects.equals(errors, listEmployeesResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Employees.
     * List of employees returned from the request.
     */
    @JsonGetter("employees")
    public List<Employee> getEmployees() { 
        return this.employees;
    }

    /**
     * Getter for Cursor.
     * The token to be used to retrieve the next page of results.
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
            .employees(getEmployees())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Employee> employees;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder employees(List<Employee> value) {
            employees = value;
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

        public ListEmployeesResponse build() {
            ListEmployeesResponse model = new ListEmployeesResponse(employees,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
