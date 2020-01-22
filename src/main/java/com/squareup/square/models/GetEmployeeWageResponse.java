package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for GetEmployeeWageResponse type.
 */
public class GetEmployeeWageResponse {

    /**
     * Initialization constructor.
     * @param employeeWage
     * @param errors
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(employeeWage, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof GetEmployeeWageResponse)) {
            return false;
        }
        GetEmployeeWageResponse getEmployeeWageResponse = (GetEmployeeWageResponse) obj;
        return Objects.equals(employeeWage, getEmployeeWageResponse.employeeWage) &&
            Objects.equals(errors, getEmployeeWageResponse.errors);
    }

    /**
     * Builds a new {@link GetEmployeeWageResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetEmployeeWageResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeWage(getEmployeeWage())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link GetEmployeeWageResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private EmployeeWage employeeWage;
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
         * Setter for employeeWage
         * @param employeeWage
         * @return Builder
         */
        public Builder employeeWage(EmployeeWage employeeWage) {
            this.employeeWage = employeeWage;
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
         * Builds a new {@link GetEmployeeWageResponse} object using the set fields.
         * @return {@link GetEmployeeWageResponse}
         */
        public GetEmployeeWageResponse build() {
            GetEmployeeWageResponse model = new GetEmployeeWageResponse(employeeWage,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
