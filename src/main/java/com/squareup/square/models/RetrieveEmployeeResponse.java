package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveEmployeeResponse {

    @JsonCreator
    public RetrieveEmployeeResponse(
            @JsonProperty("employee") Employee employee,
            @JsonProperty("errors") List<Error> errors) {
        this.employee = employee;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Employee employee;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(employee, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveEmployeeResponse)) {
            return false;
        }
        RetrieveEmployeeResponse retrieveEmployeeResponse = (RetrieveEmployeeResponse) o;
        return Objects.equals(employee, retrieveEmployeeResponse.employee) &&
            Objects.equals(errors, retrieveEmployeeResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Employee.
     * An employee object that is used by the external API.
     */
    @JsonGetter("employee")
    public Employee getEmployee() { 
        return this.employee;
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
            .employee(getEmployee())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private Employee employee;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder employee(Employee value) {
            employee = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public RetrieveEmployeeResponse build() {
            RetrieveEmployeeResponse model = new RetrieveEmployeeResponse(employee,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
