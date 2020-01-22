package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BatchChangeInventoryRequest type.
 */
public class BatchChangeInventoryRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param changes
     * @param ignoreUnchangedCounts
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, changes, ignoreUnchangedCounts);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchChangeInventoryRequest)) {
            return false;
        }
        BatchChangeInventoryRequest batchChangeInventoryRequest = (BatchChangeInventoryRequest) obj;
        return Objects.equals(idempotencyKey, batchChangeInventoryRequest.idempotencyKey) &&
            Objects.equals(changes, batchChangeInventoryRequest.changes) &&
            Objects.equals(ignoreUnchangedCounts, batchChangeInventoryRequest.ignoreUnchangedCounts);
    }

    /**
     * Builds a new {@link BatchChangeInventoryRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchChangeInventoryRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .idempotencyKey(getIdempotencyKey())
            .changes(getChanges())
            .ignoreUnchangedCounts(getIgnoreUnchangedCounts());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchChangeInventoryRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private List<InventoryChange> changes;
        private Boolean ignoreUnchangedCounts;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for changes
         * @param changes
         * @return Builder
         */
        public Builder changes(List<InventoryChange> changes) {
            this.changes = changes;
            return this;
        }
        /**
         * Setter for ignoreUnchangedCounts
         * @param ignoreUnchangedCounts
         * @return Builder
         */
        public Builder ignoreUnchangedCounts(Boolean ignoreUnchangedCounts) {
            this.ignoreUnchangedCounts = ignoreUnchangedCounts;
            return this;
        }

        /**
         * Builds a new {@link BatchChangeInventoryRequest} object using the set fields.
         * @return {@link BatchChangeInventoryRequest}
         */
        public BatchChangeInventoryRequest build() {
            return new BatchChangeInventoryRequest(idempotencyKey,
                changes,
                ignoreUnchangedCounts);
        }
    }
}
