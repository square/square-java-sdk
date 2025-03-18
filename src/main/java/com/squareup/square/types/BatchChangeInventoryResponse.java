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
@JsonDeserialize(builder = BatchChangeInventoryResponse.Builder.class)
public final class BatchChangeInventoryResponse {
    private final Optional<List<Error>> errors;

    private final Optional<List<InventoryCount>> counts;

    private final Optional<List<InventoryChange>> changes;

    private final Map<String, Object> additionalProperties;

    private BatchChangeInventoryResponse(
            Optional<List<Error>> errors,
            Optional<List<InventoryCount>> counts,
            Optional<List<InventoryChange>> changes,
            Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.counts = counts;
        this.changes = changes;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Any errors that occurred during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The current counts for all objects referenced in the request.
     */
    @JsonProperty("counts")
    public Optional<List<InventoryCount>> getCounts() {
        return counts;
    }

    /**
     * @return Changes created for the request.
     */
    @JsonProperty("changes")
    public Optional<List<InventoryChange>> getChanges() {
        return changes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BatchChangeInventoryResponse && equalTo((BatchChangeInventoryResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BatchChangeInventoryResponse other) {
        return errors.equals(other.errors) && counts.equals(other.counts) && changes.equals(other.changes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.counts, this.changes);
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
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<List<InventoryCount>> counts = Optional.empty();

        private Optional<List<InventoryChange>> changes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BatchChangeInventoryResponse other) {
            errors(other.getErrors());
            counts(other.getCounts());
            changes(other.getChanges());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        @JsonSetter(value = "counts", nulls = Nulls.SKIP)
        public Builder counts(Optional<List<InventoryCount>> counts) {
            this.counts = counts;
            return this;
        }

        public Builder counts(List<InventoryCount> counts) {
            this.counts = Optional.ofNullable(counts);
            return this;
        }

        @JsonSetter(value = "changes", nulls = Nulls.SKIP)
        public Builder changes(Optional<List<InventoryChange>> changes) {
            this.changes = changes;
            return this;
        }

        public Builder changes(List<InventoryChange> changes) {
            this.changes = Optional.ofNullable(changes);
            return this;
        }

        public BatchChangeInventoryResponse build() {
            return new BatchChangeInventoryResponse(errors, counts, changes, additionalProperties);
        }
    }
}
