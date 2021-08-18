
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for GetEmployeeWageResponse type.
 */
public class GetEmployeeWageResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final EmployeeWage employeeWage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  employeeWage  EmployeeWage value for employeeWage.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public GetEmployeeWageResponse(
            @JsonProperty("employee_wage") EmployeeWage employeeWage,
            @JsonProperty("errors") List<Error> errors) {
        this.employeeWage = employeeWage;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for EmployeeWage.
     * The hourly wage rate that an employee earns on a `Shift` for doing the job specified by the
     * `title` property of this object. Deprecated at version 2020-08-26. Use `TeamMemberWage`
     * instead.
     * @return Returns the EmployeeWage
     */
    @JsonGetter("employee_wage")
    public EmployeeWage getEmployeeWage() {
        return employeeWage;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeWage, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetEmployeeWageResponse)) {
            return false;
        }
        GetEmployeeWageResponse other = (GetEmployeeWageResponse) obj;
        return Objects.equals(employeeWage, other.employeeWage)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this GetEmployeeWageResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GetEmployeeWageResponse [" + "employeeWage=" + employeeWage + ", errors=" + errors
                + "]";
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
     * Class to build instances of {@link GetEmployeeWageResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private EmployeeWage employeeWage;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for employeeWage.
         * @param  employeeWage  EmployeeWage value for employeeWage.
         * @return Builder
         */
        public Builder employeeWage(EmployeeWage employeeWage) {
            this.employeeWage = employeeWage;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
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
            GetEmployeeWageResponse model =
                    new GetEmployeeWageResponse(employeeWage, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
