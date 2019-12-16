package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpdateWorkweekConfigRequest {

    @JsonCreator
    public UpdateWorkweekConfigRequest(
            @JsonProperty("workweek_config") WorkweekConfig workweekConfig) {
        this.workweekConfig = workweekConfig;
    }

    private final WorkweekConfig workweekConfig;

    @Override
    public int hashCode() {
        return Objects.hash(workweekConfig);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateWorkweekConfigRequest)) {
            return false;
        }
        UpdateWorkweekConfigRequest updateWorkweekConfigRequest = (UpdateWorkweekConfigRequest) o;
        return Objects.equals(workweekConfig, updateWorkweekConfigRequest.workweekConfig);
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

 
    public Builder toBuilder() {
        Builder builder = new Builder(workweekConfig);
            return builder;
    }

    public static class Builder {
        private WorkweekConfig workweekConfig;

        public Builder(WorkweekConfig workweekConfig) {
            this.workweekConfig = workweekConfig;
        }

        public Builder workweekConfig(WorkweekConfig value) {
            workweekConfig = value;
            return this;
        }

        public UpdateWorkweekConfigRequest build() {
            return new UpdateWorkweekConfigRequest(workweekConfig);
        }
    }
}
