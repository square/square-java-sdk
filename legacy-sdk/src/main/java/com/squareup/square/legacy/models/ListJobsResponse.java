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
 * This is a model class for ListJobsResponse type.
 */
public class ListJobsResponse {
    private HttpContext httpContext;
    private final List<Job> jobs;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  jobs  List of Job value for jobs.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListJobsResponse(
            @JsonProperty("jobs") List<Job> jobs,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.jobs = jobs;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Jobs.
     * The retrieved jobs. A single paged response contains up to 100 jobs.
     * @return Returns the List of Job
     */
    @JsonGetter("jobs")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Job> getJobs() {
        return jobs;
    }

    /**
     * Getter for Cursor.
     * An opaque cursor used to retrieve the next page of results. This field is present only if the
     * request succeeded and additional results are available. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
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
        return Objects.hash(jobs, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListJobsResponse)) {
            return false;
        }
        ListJobsResponse other = (ListJobsResponse) obj;
        return Objects.equals(jobs, other.jobs)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListJobsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListJobsResponse [" + "jobs=" + jobs + ", cursor=" + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListJobsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListJobsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().jobs(getJobs()).cursor(getCursor()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListJobsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Job> jobs;
        private String cursor;
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
         * Setter for jobs.
         * @param  jobs  List of Job value for jobs.
         * @return Builder
         */
        public Builder jobs(List<Job> jobs) {
            this.jobs = jobs;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link ListJobsResponse} object using the set fields.
         * @return {@link ListJobsResponse}
         */
        public ListJobsResponse build() {
            ListJobsResponse model = new ListJobsResponse(jobs, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
