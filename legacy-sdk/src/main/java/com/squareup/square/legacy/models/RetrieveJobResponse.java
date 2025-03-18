package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveJobResponse type.
 */
public class RetrieveJobResponse {
    private HttpContext httpContext;
    private final Job job;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  job  Job value for job.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveJobResponse(@JsonProperty("job") Job job, @JsonProperty("errors") List<Error> errors) {
        this.job = job;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Job.
     * Represents a job that can be assigned to [team members]($m/TeamMember). This object defines
     * the job's title and tip eligibility. Compensation is defined in a [job
     * assignment]($m/JobAssignment) in a team member's wage setting.
     * @return Returns the Job
     */
    @JsonGetter("job")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Job getJob() {
        return job;
    }

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveJobResponse)) {
            return false;
        }
        RetrieveJobResponse other = (RetrieveJobResponse) obj;
        return Objects.equals(job, other.job) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveJobResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveJobResponse [" + "job=" + job + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link RetrieveJobResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveJobResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().job(getJob()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveJobResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Job job;
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
         * Setter for job.
         * @param  job  Job value for job.
         * @return Builder
         */
        public Builder job(Job job) {
            this.job = job;
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
         * Builds a new {@link RetrieveJobResponse} object using the set fields.
         * @return {@link RetrieveJobResponse}
         */
        public RetrieveJobResponse build() {
            RetrieveJobResponse model = new RetrieveJobResponse(job, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
