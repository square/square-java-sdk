package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateWorkweekConfigResponse type.
 */
public class UpdateWorkweekConfigResponse {

    /**
     * Initialization constructor.
     * @param workweekConfig
     * @param errors
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(workweekConfig, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateWorkweekConfigResponse)) {
            return false;
        }
        UpdateWorkweekConfigResponse updateWorkweekConfigResponse = (UpdateWorkweekConfigResponse) obj;
        return Objects.equals(workweekConfig, updateWorkweekConfigResponse.workweekConfig) &&
            Objects.equals(errors, updateWorkweekConfigResponse.errors);
    }

    /**
     * Builds a new {@link UpdateWorkweekConfigResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWorkweekConfigResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .workweekConfig(getWorkweekConfig())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateWorkweekConfigResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private WorkweekConfig workweekConfig;
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
         * Setter for workweekConfig
         * @param workweekConfig
         * @return Builder
         */
        public Builder workweekConfig(WorkweekConfig workweekConfig) {
            this.workweekConfig = workweekConfig;
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
         * Builds a new {@link UpdateWorkweekConfigResponse} object using the set fields.
         * @return {@link UpdateWorkweekConfigResponse}
         */
        public UpdateWorkweekConfigResponse build() {
            UpdateWorkweekConfigResponse model = new UpdateWorkweekConfigResponse(workweekConfig,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
