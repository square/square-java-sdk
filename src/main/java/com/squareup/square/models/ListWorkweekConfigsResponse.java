
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
 * This is a model class for ListWorkweekConfigsResponse type.
 */
public class ListWorkweekConfigsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<WorkweekConfig> workweekConfigs;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  workweekConfigs  List of WorkweekConfig value for workweekConfigs.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListWorkweekConfigsResponse(
            @JsonProperty("workweek_configs") List<WorkweekConfig> workweekConfigs,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.workweekConfigs = workweekConfigs;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for WorkweekConfigs.
     * A page of Employee Wage results.
     * @return Returns the List of WorkweekConfig
     */
    @JsonGetter("workweek_configs")
    public List<WorkweekConfig> getWorkweekConfigs() {
        return workweekConfigs;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next page of Employee Wage results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
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
        return Objects.hash(workweekConfigs, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListWorkweekConfigsResponse)) {
            return false;
        }
        ListWorkweekConfigsResponse other = (ListWorkweekConfigsResponse) obj;
        return Objects.equals(workweekConfigs, other.workweekConfigs)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListWorkweekConfigsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListWorkweekConfigsResponse [" + "workweekConfigs=" + workweekConfigs + ", cursor="
                + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListWorkweekConfigsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListWorkweekConfigsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .workweekConfigs(getWorkweekConfigs())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListWorkweekConfigsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<WorkweekConfig> workweekConfigs;
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
         * Setter for workweekConfigs.
         * @param  workweekConfigs  List of WorkweekConfig value for workweekConfigs.
         * @return Builder
         */
        public Builder workweekConfigs(List<WorkweekConfig> workweekConfigs) {
            this.workweekConfigs = workweekConfigs;
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
         * Builds a new {@link ListWorkweekConfigsResponse} object using the set fields.
         * @return {@link ListWorkweekConfigsResponse}
         */
        public ListWorkweekConfigsResponse build() {
            ListWorkweekConfigsResponse model =
                    new ListWorkweekConfigsResponse(workweekConfigs, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
