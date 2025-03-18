package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListEmployeesResponse type.
 */
public class ListEmployeesResponse {
    private HttpContext httpContext;
    private final List<Employee> employees;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  employees  List of Employee value for employees.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListEmployeesResponse(
            @JsonProperty("employees") List<Employee> employees,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.employees = employees;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Employees.
     * @return Returns the List of Employee
     */
    @JsonGetter("employees")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Getter for Cursor.
     * The token to be used to retrieve the next page of results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListEmployeesResponse)) {
            return false;
        }
        ListEmployeesResponse other = (ListEmployeesResponse) obj;
        return Objects.equals(employees, other.employees)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListEmployeesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListEmployeesResponse [" + "employees=" + employees + ", cursor=" + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListEmployeesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEmployeesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder =
                new Builder().employees(getEmployees()).cursor(getCursor()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListEmployeesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Employee> employees;
        private String cursor;
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
         * Setter for employees.
         * @param  employees  List of Employee value for employees.
         * @return Builder
         */
        public Builder employees(List<Employee> employees) {
            this.employees = employees;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link ListEmployeesResponse} object using the set fields.
         * @return {@link ListEmployeesResponse}
         */
        public ListEmployeesResponse build() {
            ListEmployeesResponse model = new ListEmployeesResponse(employees, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
