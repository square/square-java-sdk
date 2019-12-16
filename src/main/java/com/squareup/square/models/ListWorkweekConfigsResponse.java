package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListWorkweekConfigsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(workweekConfigs, cursor, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListWorkweekConfigsResponse)) {
            return false;
        }
        ListWorkweekConfigsResponse listWorkweekConfigsResponse = (ListWorkweekConfigsResponse) o;
        return Objects.equals(workweekConfigs, listWorkweekConfigsResponse.workweekConfigs) &&
            Objects.equals(cursor, listWorkweekConfigsResponse.cursor) &&
            Objects.equals(errors, listWorkweekConfigsResponse.errors);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .workweekConfigs(getWorkweekConfigs())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<WorkweekConfig> workweekConfigs;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder workweekConfigs(List<WorkweekConfig> value) {
            workweekConfigs = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public ListWorkweekConfigsResponse build() {
            ListWorkweekConfigsResponse model = new ListWorkweekConfigsResponse(workweekConfigs,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
