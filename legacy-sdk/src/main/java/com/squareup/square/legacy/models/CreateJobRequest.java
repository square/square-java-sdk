package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateJobRequest type.
 */
public class CreateJobRequest {
    private final Job job;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  job  Job value for job.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateJobRequest(@JsonProperty("job") Job job, @JsonProperty("idempotency_key") String idempotencyKey) {
        this.job = job;
        this.idempotencyKey = idempotencyKey;
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

    /**
     * Getter for IdempotencyKey.
     * A unique identifier for the `CreateJob` request. Keys can be any valid string, but must be
     * unique for each request. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateJobRequest)) {
            return false;
        }
        CreateJobRequest other = (CreateJobRequest) obj;
        return Objects.equals(job, other.job) && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateJobRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateJobRequest [" + "job=" + job + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateJobRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateJobRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(job, idempotencyKey);
        return builder;
    }

    /**
     * Class to build instances of {@link CreateJobRequest}.
     */
    public static class Builder {
        private Job job;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  job  Job value for job.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(Job job, String idempotencyKey) {
            this.job = job;
            this.idempotencyKey = idempotencyKey;
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
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateJobRequest} object using the set fields.
         * @return {@link CreateJobRequest}
         */
        public CreateJobRequest build() {
            return new CreateJobRequest(job, idempotencyKey);
        }
    }
}
