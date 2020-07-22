package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateWorkweekConfigRequest type.
 */
public class UpdateWorkweekConfigRequest {

    /**
     * Initialization constructor.
     * @param workweekConfig
     */
    @JsonCreator
    public UpdateWorkweekConfigRequest(
            @JsonProperty("workweek_config") WorkweekConfig workweekConfig) {
        this.workweekConfig = workweekConfig;
    }

    private final WorkweekConfig workweekConfig;
    /**
     * Getter for WorkweekConfig.
     * Sets the Day of the week and hour of the day that a business starts a
     * work week. Used for the calculation of overtime pay.
     */
    @JsonGetter("workweek_config")
    public WorkweekConfig getWorkweekConfig() {
        return this.workweekConfig;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(workweekConfig);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateWorkweekConfigRequest)) {
            return false;
        }
        UpdateWorkweekConfigRequest updateWorkweekConfigRequest = (UpdateWorkweekConfigRequest) obj;
        return Objects.equals(workweekConfig, updateWorkweekConfigRequest.workweekConfig);
    }

    /**
     * Builds a new {@link UpdateWorkweekConfigRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWorkweekConfigRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(workweekConfig);
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateWorkweekConfigRequest}
     */
    public static class Builder {
        private WorkweekConfig workweekConfig;

        /**
         * Initialization constructor
         */
        public Builder(WorkweekConfig workweekConfig) {
            this.workweekConfig = workweekConfig;
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
         * Builds a new {@link UpdateWorkweekConfigRequest} object using the set fields.
         * @return {@link UpdateWorkweekConfigRequest}
         */
        public UpdateWorkweekConfigRequest build() {
            return new UpdateWorkweekConfigRequest(workweekConfig);
        }
    }
}
