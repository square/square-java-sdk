
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListEmployeeWagesResponse type.
 */
public class ListEmployeeWagesResponse {
    private HttpContext httpContext;
    private final List<EmployeeWage> employeeWages;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  employeeWages  List of EmployeeWage value for employeeWages.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for EmployeeWages.
     * A page of `EmployeeWage` results.
     * @return Returns the List of EmployeeWage
     */
    @JsonGetter("employee_wages")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<EmployeeWage> getEmployeeWages() {
        return employeeWages;
    }

    /**
     * Getter for Cursor.
     * The value supplied in the subsequent request to fetch the next page of `EmployeeWage`
     * results.
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
        return Objects.hash(employeeWages, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListEmployeeWagesResponse)) {
            return false;
        }
        ListEmployeeWagesResponse other = (ListEmployeeWagesResponse) obj;
        return Objects.equals(employeeWages, other.employeeWages)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListEmployeeWagesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListEmployeeWagesResponse [" + "employeeWages=" + employeeWages + ", cursor="
                + cursor + ", errors=" + errors + "]";
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
     * Class to build instances of {@link ListEmployeeWagesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<EmployeeWage> employeeWages;
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
         * Setter for employeeWages.
         * @param  employeeWages  List of EmployeeWage value for employeeWages.
         * @return Builder
         */
        public Builder employeeWages(List<EmployeeWage> employeeWages) {
            this.employeeWages = employeeWages;
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
         * Builds a new {@link ListEmployeeWagesResponse} object using the set fields.
         * @return {@link ListEmployeeWagesResponse}
         */
        public ListEmployeeWagesResponse build() {
            ListEmployeeWagesResponse model =
                    new ListEmployeeWagesResponse(employeeWages, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
