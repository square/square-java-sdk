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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BatchRetrieveInventoryChangesRequest.Builder.class)
public final class BatchRetrieveInventoryChangesRequest {
    private final Optional<List<String>> catalogObjectIds;

    private final Optional<List<String>> locationIds;

    private final Optional<List<InventoryChangeType>> types;

    private final Optional<List<InventoryState>> states;

    private final Optional<String> updatedAfter;

    private final Optional<String> updatedBefore;

    private final Optional<String> cursor;

    private final Optional<Integer> limit;

    private final Map<String, Object> additionalProperties;

    private BatchRetrieveInventoryChangesRequest(
            Optional<List<String>> catalogObjectIds,
            Optional<List<String>> locationIds,
            Optional<List<InventoryChangeType>> types,
            Optional<List<InventoryState>> states,
            Optional<String> updatedAfter,
            Optional<String> updatedBefore,
            Optional<String> cursor,
            Optional<Integer> limit,
            Map<String, Object> additionalProperties) {
        this.catalogObjectIds = catalogObjectIds;
        this.locationIds = locationIds;
        this.types = types;
        this.states = states;
        this.updatedAfter = updatedAfter;
        this.updatedBefore = updatedBefore;
        this.cursor = cursor;
        this.limit = limit;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The filter to return results by <code>CatalogObject</code> ID.
     * The filter is only applicable when set. The default value is null.
     */
    @JsonIgnore
    public Optional<List<String>> getCatalogObjectIds() {
        if (catalogObjectIds == null) {
            return Optional.empty();
        }
        return catalogObjectIds;
    }

    /**
     * @return The filter to return results by <code>Location</code> ID.
     * The filter is only applicable when set. The default value is null.
     */
    @JsonIgnore
    public Optional<List<String>> getLocationIds() {
        if (locationIds == null) {
            return Optional.empty();
        }
        return locationIds;
    }

    /**
     * @return The filter to return results by <code>InventoryChangeType</code> values other than <code>TRANSFER</code>.
     * The default value is <code>[PHYSICAL_COUNT, ADJUSTMENT]</code>.
     */
    @JsonIgnore
    public Optional<List<InventoryChangeType>> getTypes() {
        if (types == null) {
            return Optional.empty();
        }
        return types;
    }

    /**
     * @return The filter to return <code>ADJUSTMENT</code> query results by
     * <code>InventoryState</code>. This filter is only applied when set.
     * The default value is null.
     */
    @JsonIgnore
    public Optional<List<InventoryState>> getStates() {
        if (states == null) {
            return Optional.empty();
        }
        return states;
    }

    /**
     * @return The filter to return results with their <code>calculated_at</code> value
     * after the given time as specified in an RFC 3339 timestamp.
     * The default value is the UNIX epoch of (<code>1970-01-01T00:00:00Z</code>).
     */
    @JsonIgnore
    public Optional<String> getUpdatedAfter() {
        if (updatedAfter == null) {
            return Optional.empty();
        }
        return updatedAfter;
    }

    /**
     * @return The filter to return results with their <code>created_at</code> or <code>calculated_at</code> value
     * strictly before the given time as specified in an RFC 3339 timestamp.
     * The default value is the UNIX epoch of (<code>1970-01-01T00:00:00Z</code>).
     */
    @JsonIgnore
    public Optional<String> getUpdatedBefore() {
        if (updatedBefore == null) {
            return Optional.empty();
        }
        return updatedBefore;
    }

    /**
     * @return A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * <p>See the <a href="https://developer.squareup.com/docs/working-with-apis/pagination">Pagination</a> guide for more information.</p>
     */
    @JsonIgnore
    public Optional<String> getCursor() {
        if (cursor == null) {
            return Optional.empty();
        }
        return cursor;
    }

    /**
     * @return The number of <a href="entity:InventoryChange">records</a> to return.
     */
    @JsonIgnore
    public Optional<Integer> getLimit() {
        if (limit == null) {
            return Optional.empty();
        }
        return limit;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("catalog_object_ids")
    private Optional<List<String>> _getCatalogObjectIds() {
        return catalogObjectIds;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_ids")
    private Optional<List<String>> _getLocationIds() {
        return locationIds;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("types")
    private Optional<List<InventoryChangeType>> _getTypes() {
        return types;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("states")
    private Optional<List<InventoryState>> _getStates() {
        return states;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("updated_after")
    private Optional<String> _getUpdatedAfter() {
        return updatedAfter;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("updated_before")
    private Optional<String> _getUpdatedBefore() {
        return updatedBefore;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("cursor")
    private Optional<String> _getCursor() {
        return cursor;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("limit")
    private Optional<Integer> _getLimit() {
        return limit;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BatchRetrieveInventoryChangesRequest
                && equalTo((BatchRetrieveInventoryChangesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BatchRetrieveInventoryChangesRequest other) {
        return catalogObjectIds.equals(other.catalogObjectIds)
                && locationIds.equals(other.locationIds)
                && types.equals(other.types)
                && states.equals(other.states)
                && updatedAfter.equals(other.updatedAfter)
                && updatedBefore.equals(other.updatedBefore)
                && cursor.equals(other.cursor)
                && limit.equals(other.limit);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.catalogObjectIds,
                this.locationIds,
                this.types,
                this.states,
                this.updatedAfter,
                this.updatedBefore,
                this.cursor,
                this.limit);
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
        private Optional<List<String>> catalogObjectIds = Optional.empty();

        private Optional<List<String>> locationIds = Optional.empty();

        private Optional<List<InventoryChangeType>> types = Optional.empty();

        private Optional<List<InventoryState>> states = Optional.empty();

        private Optional<String> updatedAfter = Optional.empty();

        private Optional<String> updatedBefore = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        private Optional<Integer> limit = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BatchRetrieveInventoryChangesRequest other) {
            catalogObjectIds(other.getCatalogObjectIds());
            locationIds(other.getLocationIds());
            types(other.getTypes());
            states(other.getStates());
            updatedAfter(other.getUpdatedAfter());
            updatedBefore(other.getUpdatedBefore());
            cursor(other.getCursor());
            limit(other.getLimit());
            return this;
        }

        /**
         * <p>The filter to return results by <code>CatalogObject</code> ID.
         * The filter is only applicable when set. The default value is null.</p>
         */
        @JsonSetter(value = "catalog_object_ids", nulls = Nulls.SKIP)
        public Builder catalogObjectIds(Optional<List<String>> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }

        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = Optional.ofNullable(catalogObjectIds);
            return this;
        }

        public Builder catalogObjectIds(Nullable<List<String>> catalogObjectIds) {
            if (catalogObjectIds.isNull()) {
                this.catalogObjectIds = null;
            } else if (catalogObjectIds.isEmpty()) {
                this.catalogObjectIds = Optional.empty();
            } else {
                this.catalogObjectIds = Optional.of(catalogObjectIds.get());
            }
            return this;
        }

        /**
         * <p>The filter to return results by <code>Location</code> ID.
         * The filter is only applicable when set. The default value is null.</p>
         */
        @JsonSetter(value = "location_ids", nulls = Nulls.SKIP)
        public Builder locationIds(Optional<List<String>> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        public Builder locationIds(List<String> locationIds) {
            this.locationIds = Optional.ofNullable(locationIds);
            return this;
        }

        public Builder locationIds(Nullable<List<String>> locationIds) {
            if (locationIds.isNull()) {
                this.locationIds = null;
            } else if (locationIds.isEmpty()) {
                this.locationIds = Optional.empty();
            } else {
                this.locationIds = Optional.of(locationIds.get());
            }
            return this;
        }

        /**
         * <p>The filter to return results by <code>InventoryChangeType</code> values other than <code>TRANSFER</code>.
         * The default value is <code>[PHYSICAL_COUNT, ADJUSTMENT]</code>.</p>
         */
        @JsonSetter(value = "types", nulls = Nulls.SKIP)
        public Builder types(Optional<List<InventoryChangeType>> types) {
            this.types = types;
            return this;
        }

        public Builder types(List<InventoryChangeType> types) {
            this.types = Optional.ofNullable(types);
            return this;
        }

        public Builder types(Nullable<List<InventoryChangeType>> types) {
            if (types.isNull()) {
                this.types = null;
            } else if (types.isEmpty()) {
                this.types = Optional.empty();
            } else {
                this.types = Optional.of(types.get());
            }
            return this;
        }

        /**
         * <p>The filter to return <code>ADJUSTMENT</code> query results by
         * <code>InventoryState</code>. This filter is only applied when set.
         * The default value is null.</p>
         */
        @JsonSetter(value = "states", nulls = Nulls.SKIP)
        public Builder states(Optional<List<InventoryState>> states) {
            this.states = states;
            return this;
        }

        public Builder states(List<InventoryState> states) {
            this.states = Optional.ofNullable(states);
            return this;
        }

        public Builder states(Nullable<List<InventoryState>> states) {
            if (states.isNull()) {
                this.states = null;
            } else if (states.isEmpty()) {
                this.states = Optional.empty();
            } else {
                this.states = Optional.of(states.get());
            }
            return this;
        }

        /**
         * <p>The filter to return results with their <code>calculated_at</code> value
         * after the given time as specified in an RFC 3339 timestamp.
         * The default value is the UNIX epoch of (<code>1970-01-01T00:00:00Z</code>).</p>
         */
        @JsonSetter(value = "updated_after", nulls = Nulls.SKIP)
        public Builder updatedAfter(Optional<String> updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = Optional.ofNullable(updatedAfter);
            return this;
        }

        public Builder updatedAfter(Nullable<String> updatedAfter) {
            if (updatedAfter.isNull()) {
                this.updatedAfter = null;
            } else if (updatedAfter.isEmpty()) {
                this.updatedAfter = Optional.empty();
            } else {
                this.updatedAfter = Optional.of(updatedAfter.get());
            }
            return this;
        }

        /**
         * <p>The filter to return results with their <code>created_at</code> or <code>calculated_at</code> value
         * strictly before the given time as specified in an RFC 3339 timestamp.
         * The default value is the UNIX epoch of (<code>1970-01-01T00:00:00Z</code>).</p>
         */
        @JsonSetter(value = "updated_before", nulls = Nulls.SKIP)
        public Builder updatedBefore(Optional<String> updatedBefore) {
            this.updatedBefore = updatedBefore;
            return this;
        }

        public Builder updatedBefore(String updatedBefore) {
            this.updatedBefore = Optional.ofNullable(updatedBefore);
            return this;
        }

        public Builder updatedBefore(Nullable<String> updatedBefore) {
            if (updatedBefore.isNull()) {
                this.updatedBefore = null;
            } else if (updatedBefore.isEmpty()) {
                this.updatedBefore = Optional.empty();
            } else {
                this.updatedBefore = Optional.of(updatedBefore.get());
            }
            return this;
        }

        /**
         * <p>A pagination cursor returned by a previous call to this endpoint.
         * Provide this to retrieve the next set of results for the original query.</p>
         * <p>See the <a href="https://developer.squareup.com/docs/working-with-apis/pagination">Pagination</a> guide for more information.</p>
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

        public Builder cursor(Nullable<String> cursor) {
            if (cursor.isNull()) {
                this.cursor = null;
            } else if (cursor.isEmpty()) {
                this.cursor = Optional.empty();
            } else {
                this.cursor = Optional.of(cursor.get());
            }
            return this;
        }

        /**
         * <p>The number of <a href="entity:InventoryChange">records</a> to return.</p>
         */
        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        public Builder limit(Nullable<Integer> limit) {
            if (limit.isNull()) {
                this.limit = null;
            } else if (limit.isEmpty()) {
                this.limit = Optional.empty();
            } else {
                this.limit = Optional.of(limit.get());
            }
            return this;
        }

        public BatchRetrieveInventoryChangesRequest build() {
            return new BatchRetrieveInventoryChangesRequest(
                    catalogObjectIds,
                    locationIds,
                    types,
                    states,
                    updatedAfter,
                    updatedBefore,
                    cursor,
                    limit,
                    additionalProperties);
        }
    }
}
