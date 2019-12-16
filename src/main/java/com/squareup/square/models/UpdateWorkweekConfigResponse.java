package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class UpdateWorkweekConfigResponse {

    @JsonCreator
    public UpdateWorkweekConfigResponse(
            @JsonProperty("workweek_config") WorkweekConfig workweekConfig,
            @JsonProperty("errors") List<Error> errors) {
        this.workweekConfig = workweekConfig;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final WorkweekConfig workweekConfig;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(workweekConfig, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateWorkweekConfigResponse)) {
            return false;
        }
        UpdateWorkweekConfigResponse updateWorkweekConfigResponse = (UpdateWorkweekConfigResponse) o;
        return Objects.equals(workweekConfig, updateWorkweekConfigResponse.workweekConfig) &&
            Objects.equals(errors, updateWorkweekConfigResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for WorkweekConfig.
     * Sets the Day of the week and hour of the day that a business starts a 
     * work week. Used for the calculation of overtime pay.
     */
    @JsonGetter("workweek_config")
    public WorkweekConfig getWorkweekConfig() { 
        return this.workweekConfig;
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
            .workweekConfig(getWorkweekConfig())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private WorkweekConfig workweekConfig;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder workweekConfig(WorkweekConfig value) {
            workweekConfig = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public UpdateWorkweekConfigResponse build() {
            UpdateWorkweekConfigResponse model = new UpdateWorkweekConfigResponse(workweekConfig,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
