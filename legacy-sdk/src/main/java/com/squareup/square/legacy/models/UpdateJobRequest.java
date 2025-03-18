package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateJobRequest type.
 */
public class UpdateJobRequest {
    private final Job job;

    /**
     * Initialization constructor.
     * @param  job  Job value for job.
     */
    @JsonCreator
    public UpdateJobRequest(@JsonProperty("job") Job job) {
        this.job = job;
    }

    /**
     * Getter for Job.
     * Represents a job that can be assigned to [team members]($m/TeamMember). This object defines
     * the job's title and tip eligibility. Compensation is defined in a [job
     * assignment]($m/JobAssignment) in a team member's wage setting.
     * @return Returns the Job
     */
    @JsonGetter("job")
    public Job getJob() {
        return job;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateJobRequest)) {
            return false;
        }
        UpdateJobRequest other = (UpdateJobRequest) obj;
        return Objects.equals(job, other.job);
    }

    /**
     * Converts this UpdateJobRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateJobRequest [" + "job=" + job + "]";
    }

    /**
     * Builds a new {@link UpdateJobRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateJobRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(job);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateJobRequest}.
     */
    public static class Builder {
        private Job job;

        /**
         * Initialization constructor.
         * @param  job  Job value for job.
         */
        public Builder(Job job) {
            this.job = job;
        }

        /**
         * Setter for job.
         * @param  job  Job value for job.
         * @return Builder
         */
        public Builder job(Job job) {
            this.job = job;
            return this;
        }

        /**
         * Builds a new {@link UpdateJobRequest} object using the set fields.
         * @return {@link UpdateJobRequest}
         */
        public UpdateJobRequest build() {
            return new UpdateJobRequest(job);
        }
    }
}
