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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateJobRequest.Builder.class)
public final class CreateJobRequest {
    private final Job job;

    private final String idempotencyKey;

    private final Map<String, Object> additionalProperties;

    private CreateJobRequest(Job job, String idempotencyKey, Map<String, Object> additionalProperties) {
        this.job = job;
        this.idempotencyKey = idempotencyKey;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The job to create. The <code>title</code> field is required and <code>is_tip_eligible</code> defaults to true.
     */
    @JsonProperty("job")
    public Job getJob() {
        return job;
    }

    /**
     * @return A unique identifier for the <code>CreateJob</code> request. Keys can be any valid string,
     * but must be unique for each request. For more information, see
     * <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.
     */
    @JsonProperty("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateJobRequest && equalTo((CreateJobRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateJobRequest other) {
        return job.equals(other.job) && idempotencyKey.equals(other.idempotencyKey);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.job, this.idempotencyKey);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static JobStage builder() {
        return new Builder();
    }

    public interface JobStage {
        /**
         * <p>The job to create. The <code>title</code> field is required and <code>is_tip_eligible</code> defaults to true.</p>
         */
        IdempotencyKeyStage job(@NotNull Job job);

        Builder from(CreateJobRequest other);
    }

    public interface IdempotencyKeyStage {
        /**
         * <p>A unique identifier for the <code>CreateJob</code> request. Keys can be any valid string,
         * but must be unique for each request. For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         */
        _FinalStage idempotencyKey(@NotNull String idempotencyKey);
    }

    public interface _FinalStage {
        CreateJobRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements JobStage, IdempotencyKeyStage, _FinalStage {
        private Job job;

        private String idempotencyKey;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateJobRequest other) {
            job(other.getJob());
            idempotencyKey(other.getIdempotencyKey());
            return this;
        }

        /**
         * <p>The job to create. The <code>title</code> field is required and <code>is_tip_eligible</code> defaults to true.</p>
         * <p>The job to create. The <code>title</code> field is required and <code>is_tip_eligible</code> defaults to true.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("job")
        public IdempotencyKeyStage job(@NotNull Job job) {
            this.job = Objects.requireNonNull(job, "job must not be null");
            return this;
        }

        /**
         * <p>A unique identifier for the <code>CreateJob</code> request. Keys can be any valid string,
         * but must be unique for each request. For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         * <p>A unique identifier for the <code>CreateJob</code> request. Keys can be any valid string,
         * but must be unique for each request. For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("idempotency_key")
        public _FinalStage idempotencyKey(@NotNull String idempotencyKey) {
            this.idempotencyKey = Objects.requireNonNull(idempotencyKey, "idempotencyKey must not be null");
            return this;
        }

        @java.lang.Override
        public CreateJobRequest build() {
            return new CreateJobRequest(job, idempotencyKey, additionalProperties);
        }
    }
}
