
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveInventoryChangesRequest type.
 */
public class BatchRetrieveInventoryChangesRequest {
    private final OptionalNullable<List<String>> catalogObjectIds;
    private final OptionalNullable<List<String>> locationIds;
    private final OptionalNullable<List<String>> types;
    private final OptionalNullable<List<String>> states;
    private final OptionalNullable<String> updatedAfter;
    private final OptionalNullable<String> updatedBefore;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  catalogObjectIds  List of String value for catalogObjectIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  types  List of String value for types.
     * @param  states  List of String value for states.
     * @param  updatedAfter  String value for updatedAfter.
     * @param  updatedBefore  String value for updatedBefore.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public BatchRetrieveInventoryChangesRequest(
            @JsonProperty("catalog_object_ids") List<String> catalogObjectIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("types") List<String> types,
            @JsonProperty("states") List<String> states,
            @JsonProperty("updated_after") String updatedAfter,
            @JsonProperty("updated_before") String updatedBefore,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.catalogObjectIds = OptionalNullable.of(catalogObjectIds);
        this.locationIds = OptionalNullable.of(locationIds);
        this.types = OptionalNullable.of(types);
        this.states = OptionalNullable.of(states);
        this.updatedAfter = OptionalNullable.of(updatedAfter);
        this.updatedBefore = OptionalNullable.of(updatedBefore);
        this.cursor = OptionalNullable.of(cursor);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Internal initialization constructor.
     */
    protected BatchRetrieveInventoryChangesRequest(OptionalNullable<List<String>> catalogObjectIds,
            OptionalNullable<List<String>> locationIds, OptionalNullable<List<String>> types,
            OptionalNullable<List<String>> states, OptionalNullable<String> updatedAfter,
            OptionalNullable<String> updatedBefore, OptionalNullable<String> cursor,
            OptionalNullable<Integer> limit) {
        this.catalogObjectIds = catalogObjectIds;
        this.locationIds = locationIds;
        this.types = types;
        this.states = states;
        this.updatedAfter = updatedAfter;
        this.updatedBefore = updatedBefore;
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Internal Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID. The filter is only applicable when set.
     * The default value is null.
     * @return Returns the Internal List of String
     */
    @JsonGetter("catalog_object_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetCatalogObjectIds() {
        return this.catalogObjectIds;
    }

    /**
     * Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID. The filter is only applicable when set.
     * The default value is null.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCatalogObjectIds() {
        return OptionalNullable.getFrom(catalogObjectIds);
    }

    /**
     * Internal Getter for LocationIds.
     * The filter to return results by `Location` ID. The filter is only applicable when set. The
     * default value is null.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * The filter to return results by `Location` ID. The filter is only applicable when set. The
     * default value is null.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Internal Getter for Types.
     * The filter to return results by `InventoryChangeType` values other than `TRANSFER`. The
     * default value is `[PHYSICAL_COUNT, ADJUSTMENT]`.
     * @return Returns the Internal List of String
     */
    @JsonGetter("types")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetTypes() {
        return this.types;
    }

    /**
     * Getter for Types.
     * The filter to return results by `InventoryChangeType` values other than `TRANSFER`. The
     * default value is `[PHYSICAL_COUNT, ADJUSTMENT]`.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getTypes() {
        return OptionalNullable.getFrom(types);
    }

    /**
     * Internal Getter for States.
     * The filter to return `ADJUSTMENT` query results by `InventoryState`. This filter is only
     * applied when set. The default value is null.
     * @return Returns the Internal List of String
     */
    @JsonGetter("states")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetStates() {
        return this.states;
    }

    /**
     * Getter for States.
     * The filter to return `ADJUSTMENT` query results by `InventoryState`. This filter is only
     * applied when set. The default value is null.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getStates() {
        return OptionalNullable.getFrom(states);
    }

    /**
     * Internal Getter for UpdatedAfter.
     * The filter to return results with their `calculated_at` value after the given time as
     * specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the Internal String
     */
    @JsonGetter("updated_after")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUpdatedAfter() {
        return this.updatedAfter;
    }

    /**
     * Getter for UpdatedAfter.
     * The filter to return results with their `calculated_at` value after the given time as
     * specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the String
     */
    @JsonIgnore
    public String getUpdatedAfter() {
        return OptionalNullable.getFrom(updatedAfter);
    }

    /**
     * Internal Getter for UpdatedBefore.
     * The filter to return results with their `created_at` or `calculated_at` value strictly before
     * the given time as specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the Internal String
     */
    @JsonGetter("updated_before")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUpdatedBefore() {
        return this.updatedBefore;
    }

    /**
     * Getter for UpdatedBefore.
     * The filter to return results with their `created_at` or `calculated_at` value strictly before
     * the given time as specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the String
     */
    @JsonIgnore
    public String getUpdatedBefore() {
        return OptionalNullable.getFrom(updatedBefore);
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for Limit.
     * The number of [records](entity:InventoryChange) to return.
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The number of [records](entity:InventoryChange) to return.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectIds, locationIds, types, states, updatedAfter,
                updatedBefore, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveInventoryChangesRequest)) {
            return false;
        }
        BatchRetrieveInventoryChangesRequest other = (BatchRetrieveInventoryChangesRequest) obj;
        return Objects.equals(catalogObjectIds, other.catalogObjectIds)
            && Objects.equals(locationIds, other.locationIds)
            && Objects.equals(types, other.types)
            && Objects.equals(states, other.states)
            && Objects.equals(updatedAfter, other.updatedAfter)
            && Objects.equals(updatedBefore, other.updatedBefore)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this BatchRetrieveInventoryChangesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveInventoryChangesRequest [" + "catalogObjectIds=" + catalogObjectIds
                + ", locationIds=" + locationIds + ", types=" + types + ", states=" + states
                + ", updatedAfter=" + updatedAfter + ", updatedBefore=" + updatedBefore
                + ", cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link BatchRetrieveInventoryChangesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveInventoryChangesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.catalogObjectIds = internalGetCatalogObjectIds();
        builder.locationIds = internalGetLocationIds();
        builder.types = internalGetTypes();
        builder.states = internalGetStates();
        builder.updatedAfter = internalGetUpdatedAfter();
        builder.updatedBefore = internalGetUpdatedBefore();
        builder.cursor = internalGetCursor();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveInventoryChangesRequest}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> catalogObjectIds;
        private OptionalNullable<List<String>> locationIds;
        private OptionalNullable<List<String>> types;
        private OptionalNullable<List<String>> states;
        private OptionalNullable<String> updatedAfter;
        private OptionalNullable<String> updatedBefore;
        private OptionalNullable<String> cursor;
        private OptionalNullable<Integer> limit;



        /**
         * Setter for catalogObjectIds.
         * @param  catalogObjectIds  List of String value for catalogObjectIds.
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = OptionalNullable.of(catalogObjectIds);
            return this;
        }

        /**
         * UnSetter for catalogObjectIds.
         * @return Builder
         */
        public Builder unsetCatalogObjectIds() {
            catalogObjectIds = null;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
            return this;
        }

        /**
         * Setter for types.
         * @param  types  List of String value for types.
         * @return Builder
         */
        public Builder types(List<String> types) {
            this.types = OptionalNullable.of(types);
            return this;
        }

        /**
         * UnSetter for types.
         * @return Builder
         */
        public Builder unsetTypes() {
            types = null;
            return this;
        }

        /**
         * Setter for states.
         * @param  states  List of String value for states.
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = OptionalNullable.of(states);
            return this;
        }

        /**
         * UnSetter for states.
         * @return Builder
         */
        public Builder unsetStates() {
            states = null;
            return this;
        }

        /**
         * Setter for updatedAfter.
         * @param  updatedAfter  String value for updatedAfter.
         * @return Builder
         */
        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = OptionalNullable.of(updatedAfter);
            return this;
        }

        /**
         * UnSetter for updatedAfter.
         * @return Builder
         */
        public Builder unsetUpdatedAfter() {
            updatedAfter = null;
            return this;
        }

        /**
         * Setter for updatedBefore.
         * @param  updatedBefore  String value for updatedBefore.
         * @return Builder
         */
        public Builder updatedBefore(String updatedBefore) {
            this.updatedBefore = OptionalNullable.of(updatedBefore);
            return this;
        }

        /**
         * UnSetter for updatedBefore.
         * @return Builder
         */
        public Builder unsetUpdatedBefore() {
            updatedBefore = null;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveInventoryChangesRequest} object using the set fields.
         * @return {@link BatchRetrieveInventoryChangesRequest}
         */
        public BatchRetrieveInventoryChangesRequest build() {
            return new BatchRetrieveInventoryChangesRequest(catalogObjectIds, locationIds, types,
                    states, updatedAfter, updatedBefore, cursor, limit);
        }
    }
}
