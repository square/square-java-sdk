package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListEmployeeWagesResponse type.
 */
public class ListEmployeeWagesResponse {

    /**
     * Initialization constructor.
     * @param employeeWages
     * @param cursor
     * @param errors
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(employeeWages, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListEmployeeWagesResponse)) {
            return false;
        }
        ListEmployeeWagesResponse listEmployeeWagesResponse = (ListEmployeeWagesResponse) obj;
        return Objects.equals(employeeWages, listEmployeeWagesResponse.employeeWages) &&
            Objects.equals(cursor, listEmployeeWagesResponse.cursor) &&
            Objects.equals(errors, listEmployeeWagesResponse.errors);
    }

    /**
     * Builds a new {@link ListEmployeeWagesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEmployeeWagesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeWages(getEmployeeWages())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link ListEmployeeWagesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<EmployeeWage> employeeWages;
        private String cursor;
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
         * Setter for employeeWages
         * @param employeeWages
         * @return Builder
         */
        public Builder employeeWages(List<EmployeeWage> employeeWages) {
            this.employeeWages = employeeWages;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link ListEmployeeWagesResponse} object using the set fields.
         * @return {@link ListEmployeeWagesResponse}
         */
        public ListEmployeeWagesResponse build() {
            ListEmployeeWagesResponse model = new ListEmployeeWagesResponse(employeeWages,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
