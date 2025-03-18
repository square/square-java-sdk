package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchChangeInventoryRequest type.
 */
public class BatchChangeInventoryRequest {
    private final String idempotencyKey;
    private final OptionalNullable<List<InventoryChange>> changes;
    private final OptionalNullable<Boolean> ignoreUnchangedCounts;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  changes  List of InventoryChange value for changes.
     * @param  ignoreUnchangedCounts  Boolean value for ignoreUnchangedCounts.
     */
    @JsonCreator
    public BatchChangeInventoryRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("changes") List<InventoryChange> changes,
            @JsonProperty("ignore_unchanged_counts") Boolean ignoreUnchangedCounts) {
        this.idempotencyKey = idempotencyKey;
        this.changes = OptionalNullable.of(changes);
        this.ignoreUnchangedCounts = OptionalNullable.of(ignoreUnchangedCounts);
    }

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  changes  List of InventoryChange value for changes.
     * @param  ignoreUnchangedCounts  Boolean value for ignoreUnchangedCounts.
     */
    protected BatchChangeInventoryRequest(
            String idempotencyKey,
            OptionalNullable<List<InventoryChange>> changes,
            OptionalNullable<Boolean> ignoreUnchangedCounts) {
        this.idempotencyKey = idempotencyKey;
        this.changes = changes;
        this.ignoreUnchangedCounts = ignoreUnchangedCounts;
    }

    /**
     * Getter for IdempotencyKey.
     * A client-supplied, universally unique identifier (UUID) for the request. See
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency)
     * in the [API Development 101](https://developer.squareup.com/docs/buildbasics) section for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Internal Getter for Changes.
     * The set of physical counts and inventory adjustments to be made. Changes are applied based on
     * the client-supplied timestamp and may be sent out of order.
     * @return Returns the Internal List of InventoryChange
     */
    @JsonGetter("changes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<InventoryChange>> internalGetChanges() {
        return this.changes;
    }

    /**
     * Getter for Changes.
     * The set of physical counts and inventory adjustments to be made. Changes are applied based on
     * the client-supplied timestamp and may be sent out of order.
     * @return Returns the List of InventoryChange
     */
    @JsonIgnore
    public List<InventoryChange> getChanges() {
        return OptionalNullable.getFrom(changes);
    }

    /**
     * Internal Getter for IgnoreUnchangedCounts.
     * Indicates whether the current physical count should be ignored if the quantity is unchanged
     * since the last physical count. Default: `true`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("ignore_unchanged_counts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIgnoreUnchangedCounts() {
        return this.ignoreUnchangedCounts;
    }

    /**
     * Getter for IgnoreUnchangedCounts.
     * Indicates whether the current physical count should be ignored if the quantity is unchanged
     * since the last physical count. Default: `true`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIgnoreUnchangedCounts() {
        return OptionalNullable.getFrom(ignoreUnchangedCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, changes, ignoreUnchangedCounts);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchChangeInventoryRequest)) {
            return false;
        }
        BatchChangeInventoryRequest other = (BatchChangeInventoryRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
                && Objects.equals(changes, other.changes)
                && Objects.equals(ignoreUnchangedCounts, other.ignoreUnchangedCounts);
    }

    /**
     * Converts this BatchChangeInventoryRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchChangeInventoryRequest [" + "idempotencyKey=" + idempotencyKey + ", changes=" + changes
                + ", ignoreUnchangedCounts=" + ignoreUnchangedCounts + "]";
    }

    /**
     * Builds a new {@link BatchChangeInventoryRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchChangeInventoryRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey);
        builder.changes = internalGetChanges();
        builder.ignoreUnchangedCounts = internalGetIgnoreUnchangedCounts();
        return builder;
    }

    /**
     * Class to build instances of {@link BatchChangeInventoryRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private OptionalNullable<List<InventoryChange>> changes;
        private OptionalNullable<Boolean> ignoreUnchangedCounts;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for changes.
         * @param  changes  List of InventoryChange value for changes.
         * @return Builder
         */
        public Builder changes(List<InventoryChange> changes) {
            this.changes = OptionalNullable.of(changes);
            return this;
        }

        /**
         * UnSetter for changes.
         * @return Builder
         */
        public Builder unsetChanges() {
            changes = null;
            return this;
        }

        /**
         * Setter for ignoreUnchangedCounts.
         * @param  ignoreUnchangedCounts  Boolean value for ignoreUnchangedCounts.
         * @return Builder
         */
        public Builder ignoreUnchangedCounts(Boolean ignoreUnchangedCounts) {
            this.ignoreUnchangedCounts = OptionalNullable.of(ignoreUnchangedCounts);
            return this;
        }

        /**
         * UnSetter for ignoreUnchangedCounts.
         * @return Builder
         */
        public Builder unsetIgnoreUnchangedCounts() {
            ignoreUnchangedCounts = null;
            return this;
        }

        /**
         * Builds a new {@link BatchChangeInventoryRequest} object using the set fields.
         * @return {@link BatchChangeInventoryRequest}
         */
        public BatchChangeInventoryRequest build() {
            return new BatchChangeInventoryRequest(idempotencyKey, changes, ignoreUnchangedCounts);
        }
    }
}
