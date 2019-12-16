package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersRequest {

    @JsonCreator
    public SearchOrdersRequest(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("query") SearchOrdersQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("return_entries") Boolean returnEntries) {
        this.locationIds = locationIds;
        this.cursor = cursor;
        this.query = query;
        this.limit = limit;
        this.returnEntries = returnEntries;
    }

    private final List<String> locationIds;
    private final String cursor;
    private final SearchOrdersQuery query;
    private final Integer limit;
    private final Boolean returnEntries;

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, cursor, query, limit, returnEntries);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersRequest)) {
            return false;
        }
        SearchOrdersRequest searchOrdersRequest = (SearchOrdersRequest) o;
        return Objects.equals(locationIds, searchOrdersRequest.locationIds) &&
            Objects.equals(cursor, searchOrdersRequest.cursor) &&
            Objects.equals(query, searchOrdersRequest.query) &&
            Objects.equals(limit, searchOrdersRequest.limit) &&
            Objects.equals(returnEntries, searchOrdersRequest.returnEntries);
    }

    /**
     * Getter for LocationIds.
     * The location IDs for the orders to query. All locations must belong to
     * the same merchant.
     * Min: 1 location IDs.
     * Max: 10 location IDs.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() { 
        return this.locationIds;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for your original query.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

    /**
     * Getter for Query.
     * Contains query criteria for the search.
     */
    @JsonGetter("query")
    public SearchOrdersQuery getQuery() { 
        return this.query;
    }

    /**
     * Getter for Limit.
     * Maximum number of results to be returned in a single page. It is
     * possible to receive fewer results than the specified limit on a given page.
     * Default: `500`
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

    /**
     * Getter for ReturnEntries.
     * Boolean that controls the format of the search results. If `true`,
     * SearchOrders will return [`OrderEntry`](#type-orderentry) objects. If `false`, SearchOrders
     * will return complete Order objects.
     * Default: `false`.
     */
    @JsonGetter("return_entries")
    public Boolean getReturnEntries() { 
        return this.returnEntries;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationIds(getLocationIds())
            .cursor(getCursor())
            .query(getQuery())
            .limit(getLimit())
            .returnEntries(getReturnEntries());
            return builder;
    }

    public static class Builder {
        private List<String> locationIds;
        private String cursor;
        private SearchOrdersQuery query;
        private Integer limit;
        private Boolean returnEntries;

        public Builder() { }

        public Builder locationIds(List<String> value) {
            locationIds = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder query(SearchOrdersQuery value) {
            query = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder returnEntries(Boolean value) {
            returnEntries = value;
            return this;
        }

        public SearchOrdersRequest build() {
            return new SearchOrdersRequest(locationIds,
                cursor,
                query,
                limit,
                returnEntries);
        }
    }
}
