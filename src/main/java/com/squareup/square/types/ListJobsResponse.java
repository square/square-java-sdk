/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListJobsResponse.Builder.class)
public final class ListJobsResponse {
    private final Optional<List<Job>> jobs;

    private final Optional<String> cursor;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private ListJobsResponse(
            Optional<List<Job>> jobs,
            Optional<String> cursor,
            Optional<List<Error>> errors,
            Map<String, Object> additionalProperties) {
        this.jobs = jobs;
        this.cursor = cursor;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The retrieved jobs. A single paged response contains up to 100 jobs.
     */
    @JsonProperty("jobs")
    public Optional<List<Job>> getJobs() {
        return jobs;
    }

    /**
     * @return An opaque cursor used to retrieve the next page of results. This field is present only
     * if the request succeeded and additional results are available. For more information, see
     * <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.
     */
    @JsonProperty("cursor")
    public Optional<String> getCursor() {
        return cursor;
    }

    /**
     * @return The errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListJobsResponse && equalTo((ListJobsResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListJobsResponse other) {
        return jobs.equals(other.jobs) && cursor.equals(other.cursor) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.jobs, this.cursor, this.errors);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Job>> jobs = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListJobsResponse other) {
            jobs(other.getJobs());
            cursor(other.getCursor());
            errors(other.getErrors());
            return this;
        }

        /**
         * <p>The retrieved jobs. A single paged response contains up to 100 jobs.</p>
         */
        @JsonSetter(value = "jobs", nulls = Nulls.SKIP)
        public Builder jobs(Optional<List<Job>> jobs) {
            this.jobs = jobs;
            return this;
        }

        public Builder jobs(List<Job> jobs) {
            this.jobs = Optional.ofNullable(jobs);
            return this;
        }

        /**
         * <p>An opaque cursor used to retrieve the next page of results. This field is present only
         * if the request succeeded and additional results are available. For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.</p>
         */
        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        /**
         * <p>The errors that occurred during the request.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        public ListJobsResponse build() {
            return new ListJobsResponse(jobs, cursor, errors, additionalProperties);
        }
    }
}
