
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateWorkweekConfigResponse type.
 */
public class UpdateWorkweekConfigResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final WorkweekConfig workweekConfig;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  workweekConfig  WorkweekConfig value for workweekConfig.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public UpdateWorkweekConfigResponse(
            @JsonProperty("workweek_config") WorkweekConfig workweekConfig,
            @JsonProperty("errors") List<Error> errors) {
        this.workweekConfig = workweekConfig;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for WorkweekConfig.
     * Sets the Day of the week and hour of the day that a business starts a work week. Used for the
     * calculation of overtime pay.
     * @return Returns the WorkweekConfig
     */
    @JsonGetter("workweek_config")
    public WorkweekConfig getWorkweekConfig() {
        return workweekConfig;
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
        return Objects.hash(workweekConfig, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateWorkweekConfigResponse)) {
            return false;
        }
        UpdateWorkweekConfigResponse other = (UpdateWorkweekConfigResponse) obj;
        return Objects.equals(workweekConfig, other.workweekConfig)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this UpdateWorkweekConfigResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWorkweekConfigResponse [" + "workweekConfig=" + workweekConfig + ", errors="
                + errors + "]";
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
     * Class to build instances of {@link UpdateWorkweekConfigResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private WorkweekConfig workweekConfig;
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
         * Setter for workweekConfig.
         * @param  workweekConfig  WorkweekConfig value for workweekConfig.
         * @return Builder
         */
        public Builder workweekConfig(WorkweekConfig workweekConfig) {
            this.workweekConfig = workweekConfig;
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
         * Builds a new {@link UpdateWorkweekConfigResponse} object using the set fields.
         * @return {@link UpdateWorkweekConfigResponse}
         */
        public UpdateWorkweekConfigResponse build() {
            UpdateWorkweekConfigResponse model =
                    new UpdateWorkweekConfigResponse(workweekConfig, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
