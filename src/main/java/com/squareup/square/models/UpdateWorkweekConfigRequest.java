
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateWorkweekConfigRequest type.
 */
public class UpdateWorkweekConfigRequest {
    private final WorkweekConfig workweekConfig;

    /**
     * Initialization constructor.
     * @param  workweekConfig  WorkweekConfig value for workweekConfig.
     */
    @JsonCreator
    public UpdateWorkweekConfigRequest(
            @JsonProperty("workweek_config") WorkweekConfig workweekConfig) {
        this.workweekConfig = workweekConfig;
    }

    /**
     * Getter for WorkweekConfig.
     * Sets the day of the week and hour of the day that a business starts a workweek. This is used
     * to calculate overtime pay.
     * @return Returns the WorkweekConfig
     */
    @JsonGetter("workweek_config")
    public WorkweekConfig getWorkweekConfig() {
        return workweekConfig;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workweekConfig);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateWorkweekConfigRequest)) {
            return false;
        }
        UpdateWorkweekConfigRequest other = (UpdateWorkweekConfigRequest) obj;
        return Objects.equals(workweekConfig, other.workweekConfig);
    }

    /**
     * Converts this UpdateWorkweekConfigRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWorkweekConfigRequest [" + "workweekConfig=" + workweekConfig + "]";
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
     * Class to build instances of {@link UpdateWorkweekConfigRequest}.
     */
    public static class Builder {
        private WorkweekConfig workweekConfig;

        /**
         * Initialization constructor.
         * @param  workweekConfig  WorkweekConfig value for workweekConfig.
         */
        public Builder(WorkweekConfig workweekConfig) {
            this.workweekConfig = workweekConfig;
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
         * Builds a new {@link UpdateWorkweekConfigRequest} object using the set fields.
         * @return {@link UpdateWorkweekConfigRequest}
         */
        public UpdateWorkweekConfigRequest build() {
            return new UpdateWorkweekConfigRequest(workweekConfig);
        }
    }
}
