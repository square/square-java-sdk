package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BatchChangeInventoryRequest {

    @JsonCreator
    public BatchChangeInventoryRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("changes") List<InventoryChange> changes,
            @JsonProperty("ignore_unchanged_counts") Boolean ignoreUnchangedCounts) {
        this.idempotencyKey = idempotencyKey;
        this.changes = changes;
        this.ignoreUnchangedCounts = ignoreUnchangedCounts;
    }

    private final String idempotencyKey;
    private final List<InventoryChange> changes;
    private final Boolean ignoreUnchangedCounts;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, changes, ignoreUnchangedCounts);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchChangeInventoryRequest)) {
            return false;
        }
        BatchChangeInventoryRequest batchChangeInventoryRequest = (BatchChangeInventoryRequest) o;
        return Objects.equals(idempotencyKey, batchChangeInventoryRequest.idempotencyKey) &&
            Objects.equals(changes, batchChangeInventoryRequest.changes) &&
            Objects.equals(ignoreUnchangedCounts, batchChangeInventoryRequest.ignoreUnchangedCounts);
    }

    /**
     * Getter for IdempotencyKey.
     * A client-supplied, universally unique identifier (UUID) for the
     * request.
     * See [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) in the
     * [API Development 101](https://developer.squareup.com/docs/basics/api101/overview) section for more
     * information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for Changes.
     * The set of physical counts and inventory adjustments to be made.
     * Changes are applied based on the client-supplied timestamp and may be sent
     * out of order. Max size is 100 changes.
     */
    @JsonGetter("changes")
    public List<InventoryChange> getChanges() { 
        return this.changes;
    }

    /**
     * Getter for IgnoreUnchangedCounts.
     * Indicates whether the current physical count should be ignored if
     * the quantity is unchanged since the last physical count. Default: `true`.
     */
    @JsonGetter("ignore_unchanged_counts")
    public Boolean getIgnoreUnchangedCounts() { 
        return this.ignoreUnchangedCounts;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .idempotencyKey(getIdempotencyKey())
            .changes(getChanges())
            .ignoreUnchangedCounts(getIgnoreUnchangedCounts());
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;
        private List<InventoryChange> changes;
        private Boolean ignoreUnchangedCounts;

        public Builder() { }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder changes(List<InventoryChange> value) {
            changes = value;
            return this;
        }
        public Builder ignoreUnchangedCounts(Boolean value) {
            ignoreUnchangedCounts = value;
            return this;
        }

        public BatchChangeInventoryRequest build() {
            return new BatchChangeInventoryRequest(idempotencyKey,
                changes,
                ignoreUnchangedCounts);
        }
    }
}
