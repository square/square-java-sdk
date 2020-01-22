package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveEmployeeResponse type.
 */
public class RetrieveEmployeeResponse {

    /**
     * Initialization constructor.
     * @param employee
     * @param errors
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(employee, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveEmployeeResponse)) {
            return false;
        }
        RetrieveEmployeeResponse retrieveEmployeeResponse = (RetrieveEmployeeResponse) obj;
        return Objects.equals(employee, retrieveEmployeeResponse.employee) &&
            Objects.equals(errors, retrieveEmployeeResponse.errors);
    }

    /**
     * Builds a new {@link RetrieveEmployeeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveEmployeeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employee(getEmployee())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveEmployeeResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Employee employee;
        private List<Error> errors;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for employee
         * @param employee
         * @return Builder
         */
        public Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link RetrieveEmployeeResponse} object using the set fields.
         * @return {@link RetrieveEmployeeResponse}
         */
        public RetrieveEmployeeResponse build() {
            RetrieveEmployeeResponse model = new RetrieveEmployeeResponse(employee,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
