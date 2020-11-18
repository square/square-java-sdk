
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveEmployeeResponse type.
 */
public class RetrieveEmployeeResponse {
    private HttpContext httpContext;
    private final Employee employee;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param employee Employee value for employee.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public RetrieveEmployeeResponse(
            @JsonProperty("employee") Employee employee,
            @JsonProperty("errors") List<Error> errors) {
        this.employee = employee;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Employee.
     * An employee object that is used by the external API.
     * @return Returns the Employee
     */
    @JsonGetter("employee")
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveEmployeeResponse)) {
            return false;
        }
        RetrieveEmployeeResponse other = (RetrieveEmployeeResponse) obj;
        return Objects.equals(employee, other.employee)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveEmployeeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveEmployeeResponse [" + "employee=" + employee + ", errors=" + errors + "]";
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
     * Class to build instances of {@link RetrieveEmployeeResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Employee employee;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for employee.
         * @param employee Employee value for employee.
         * @return Builder
         */
        public Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
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
            RetrieveEmployeeResponse model =
                    new RetrieveEmployeeResponse(employee, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
