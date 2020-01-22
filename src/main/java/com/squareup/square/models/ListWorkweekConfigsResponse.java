package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListWorkweekConfigsResponse type.
 */
public class ListWorkweekConfigsResponse {

    /**
     * Initialization constructor.
     * @param workweekConfigs
     * @param cursor
     * @param errors
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

    private HttpContext httpContext;
    private final List<WorkweekConfig> workweekConfigs;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for WorkweekConfigs.
     * A page of Employee Wage results.
     */
    @JsonGetter("workweek_configs")
    public List<WorkweekConfig> getWorkweekConfigs() {
        return this.workweekConfigs;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next page of
     * Employee Wage results.
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
        return Objects.hash(workweekConfigs, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListWorkweekConfigsResponse)) {
            return false;
        }
        ListWorkweekConfigsResponse listWorkweekConfigsResponse = (ListWorkweekConfigsResponse) obj;
        return Objects.equals(workweekConfigs, listWorkweekConfigsResponse.workweekConfigs) &&
            Objects.equals(cursor, listWorkweekConfigsResponse.cursor) &&
            Objects.equals(errors, listWorkweekConfigsResponse.errors);
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
     * Class to build instances of {@link ListWorkweekConfigsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<WorkweekConfig> workweekConfigs;
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
         * Setter for workweekConfigs
         * @param workweekConfigs
         * @return Builder
         */
        public Builder workweekConfigs(List<WorkweekConfig> workweekConfigs) {
            this.workweekConfigs = workweekConfigs;
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
         * Builds a new {@link ListWorkweekConfigsResponse} object using the set fields.
         * @return {@link ListWorkweekConfigsResponse}
         */
        public ListWorkweekConfigsResponse build() {
            ListWorkweekConfigsResponse model = new ListWorkweekConfigsResponse(workweekConfigs,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
