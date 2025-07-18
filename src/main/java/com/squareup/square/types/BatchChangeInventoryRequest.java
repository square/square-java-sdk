/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BatchChangeInventoryRequest.Builder.class)
public final class BatchChangeInventoryRequest {
    private final String idempotencyKey;

    private final Optional<List<InventoryChange>> changes;

    private final Optional<Boolean> ignoreUnchangedCounts;

    private final Map<String, Object> additionalProperties;

    private BatchChangeInventoryRequest(
            String idempotencyKey,
            Optional<List<InventoryChange>> changes,
            Optional<Boolean> ignoreUnchangedCounts,
            Map<String, Object> additionalProperties) {
        this.idempotencyKey = idempotencyKey;
        this.changes = changes;
        this.ignoreUnchangedCounts = ignoreUnchangedCounts;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A client-supplied, universally unique identifier (UUID) for the
     * request.
     * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a> in the
     * <a href="https://developer.squareup.com/docs/buildbasics">API Development 101</a> section for more
     * information.</p>
     */
    @JsonProperty("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * @return The set of physical counts and inventory adjustments to be made.
     * Changes are applied based on the client-supplied timestamp and may be sent
     * out of order.
     */
    @JsonIgnore
    public Optional<List<InventoryChange>> getChanges() {
        if (changes == null) {
            return Optional.empty();
        }
        return changes;
    }

    /**
     * @return Indicates whether the current physical count should be ignored if
     * the quantity is unchanged since the last physical count. Default: <code>true</code>.
     */
    @JsonIgnore
    public Optional<Boolean> getIgnoreUnchangedCounts() {
        if (ignoreUnchangedCounts == null) {
            return Optional.empty();
        }
        return ignoreUnchangedCounts;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("changes")
    private Optional<List<InventoryChange>> _getChanges() {
        return changes;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ignore_unchanged_counts")
    private Optional<Boolean> _getIgnoreUnchangedCounts() {
        return ignoreUnchangedCounts;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BatchChangeInventoryRequest && equalTo((BatchChangeInventoryRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BatchChangeInventoryRequest other) {
        return idempotencyKey.equals(other.idempotencyKey)
                && changes.equals(other.changes)
                && ignoreUnchangedCounts.equals(other.ignoreUnchangedCounts);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.idempotencyKey, this.changes, this.ignoreUnchangedCounts);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdempotencyKeyStage builder() {
        return new Builder();
    }

    public interface IdempotencyKeyStage {
        /**
         * <p>A client-supplied, universally unique identifier (UUID) for the
         * request.</p>
         * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a> in the
         * <a href="https://developer.squareup.com/docs/buildbasics">API Development 101</a> section for more
         * information.</p>
         */
        _FinalStage idempotencyKey(@NotNull String idempotencyKey);

        Builder from(BatchChangeInventoryRequest other);
    }

    public interface _FinalStage {
        BatchChangeInventoryRequest build();

        /**
         * <p>The set of physical counts and inventory adjustments to be made.
         * Changes are applied based on the client-supplied timestamp and may be sent
         * out of order.</p>
         */
        _FinalStage changes(Optional<List<InventoryChange>> changes);

        _FinalStage changes(List<InventoryChange> changes);

        _FinalStage changes(Nullable<List<InventoryChange>> changes);

        /**
         * <p>Indicates whether the current physical count should be ignored if
         * the quantity is unchanged since the last physical count. Default: <code>true</code>.</p>
         */
        _FinalStage ignoreUnchangedCounts(Optional<Boolean> ignoreUnchangedCounts);

        _FinalStage ignoreUnchangedCounts(Boolean ignoreUnchangedCounts);

        _FinalStage ignoreUnchangedCounts(Nullable<Boolean> ignoreUnchangedCounts);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdempotencyKeyStage, _FinalStage {
        private String idempotencyKey;

        private Optional<Boolean> ignoreUnchangedCounts = Optional.empty();

        private Optional<List<InventoryChange>> changes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(BatchChangeInventoryRequest other) {
            idempotencyKey(other.getIdempotencyKey());
            changes(other.getChanges());
            ignoreUnchangedCounts(other.getIgnoreUnchangedCounts());
            return this;
        }

        /**
         * <p>A client-supplied, universally unique identifier (UUID) for the
         * request.</p>
         * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a> in the
         * <a href="https://developer.squareup.com/docs/buildbasics">API Development 101</a> section for more
         * information.</p>
         * <p>A client-supplied, universally unique identifier (UUID) for the
         * request.</p>
         * <p>See <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a> in the
         * <a href="https://developer.squareup.com/docs/buildbasics">API Development 101</a> section for more
         * information.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("idempotency_key")
        public _FinalStage idempotencyKey(@NotNull String idempotencyKey) {
            this.idempotencyKey = Objects.requireNonNull(idempotencyKey, "idempotencyKey must not be null");
            return this;
        }

        /**
         * <p>Indicates whether the current physical count should be ignored if
         * the quantity is unchanged since the last physical count. Default: <code>true</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage ignoreUnchangedCounts(Nullable<Boolean> ignoreUnchangedCounts) {
            if (ignoreUnchangedCounts.isNull()) {
                this.ignoreUnchangedCounts = null;
            } else if (ignoreUnchangedCounts.isEmpty()) {
                this.ignoreUnchangedCounts = Optional.empty();
            } else {
                this.ignoreUnchangedCounts = Optional.of(ignoreUnchangedCounts.get());
            }
            return this;
        }

        /**
         * <p>Indicates whether the current physical count should be ignored if
         * the quantity is unchanged since the last physical count. Default: <code>true</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage ignoreUnchangedCounts(Boolean ignoreUnchangedCounts) {
            this.ignoreUnchangedCounts = Optional.ofNullable(ignoreUnchangedCounts);
            return this;
        }

        /**
         * <p>Indicates whether the current physical count should be ignored if
         * the quantity is unchanged since the last physical count. Default: <code>true</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "ignore_unchanged_counts", nulls = Nulls.SKIP)
        public _FinalStage ignoreUnchangedCounts(Optional<Boolean> ignoreUnchangedCounts) {
            this.ignoreUnchangedCounts = ignoreUnchangedCounts;
            return this;
        }

        /**
         * <p>The set of physical counts and inventory adjustments to be made.
         * Changes are applied based on the client-supplied timestamp and may be sent
         * out of order.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage changes(Nullable<List<InventoryChange>> changes) {
            if (changes.isNull()) {
                this.changes = null;
            } else if (changes.isEmpty()) {
                this.changes = Optional.empty();
            } else {
                this.changes = Optional.of(changes.get());
            }
            return this;
        }

        /**
         * <p>The set of physical counts and inventory adjustments to be made.
         * Changes are applied based on the client-supplied timestamp and may be sent
         * out of order.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage changes(List<InventoryChange> changes) {
            this.changes = Optional.ofNullable(changes);
            return this;
        }

        /**
         * <p>The set of physical counts and inventory adjustments to be made.
         * Changes are applied based on the client-supplied timestamp and may be sent
         * out of order.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "changes", nulls = Nulls.SKIP)
        public _FinalStage changes(Optional<List<InventoryChange>> changes) {
            this.changes = changes;
            return this;
        }

        @java.lang.Override
        public BatchChangeInventoryRequest build() {
            return new BatchChangeInventoryRequest(
                    idempotencyKey, changes, ignoreUnchangedCounts, additionalProperties);
        }
    }
}
