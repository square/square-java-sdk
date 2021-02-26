
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchOrdersRequest type.
 */
public class SearchOrdersRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> locationIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SearchOrdersQuery query;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean returnEntries;

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  cursor  String value for cursor.
     * @param  query  SearchOrdersQuery value for query.
     * @param  limit  Integer value for limit.
     * @param  returnEntries  Boolean value for returnEntries.
     */
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

    /**
     * Getter for LocationIds.
     * The location IDs for the orders to query. All locations must belong to the same merchant.
     * Min: 1 location IDs. Max: 10 location IDs.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for your original query. See
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Query.
     * Contains query criteria for the search.
     * @return Returns the SearchOrdersQuery
     */
    @JsonGetter("query")
    public SearchOrdersQuery getQuery() {
        return query;
    }

    /**
     * Getter for Limit.
     * Maximum number of results to be returned in a single page. It is possible to receive fewer
     * results than the specified limit on a given page. Default: `500`
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for ReturnEntries.
     * Boolean that controls the format of the search results. If `true`, SearchOrders will return
     * [`OrderEntry`](#type-orderentry) objects. If `false`, SearchOrders will return complete Order
     * objects. Default: `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("return_entries")
    public Boolean getReturnEntries() {
        return returnEntries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, cursor, query, limit, returnEntries);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersRequest)) {
            return false;
        }
        SearchOrdersRequest other = (SearchOrdersRequest) obj;
        return Objects.equals(locationIds, other.locationIds)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit)
            && Objects.equals(returnEntries, other.returnEntries);
    }

    /**
     * Converts this SearchOrdersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersRequest [" + "locationIds=" + locationIds + ", cursor=" + cursor
                + ", query=" + query + ", limit=" + limit + ", returnEntries=" + returnEntries
                + "]";
    }

    /**
     * Builds a new {@link SearchOrdersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationIds(getLocationIds())
                .cursor(getCursor())
                .query(getQuery())
                .limit(getLimit())
                .returnEntries(getReturnEntries());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersRequest}.
     */
    public static class Builder {
        private List<String> locationIds;
        private String cursor;
        private SearchOrdersQuery query;
        private Integer limit;
        private Boolean returnEntries;



        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for query.
         * @param  query  SearchOrdersQuery value for query.
         * @return Builder
         */
        public Builder query(SearchOrdersQuery query) {
            this.query = query;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for returnEntries.
         * @param  returnEntries  Boolean value for returnEntries.
         * @return Builder
         */
        public Builder returnEntries(Boolean returnEntries) {
            this.returnEntries = returnEntries;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersRequest} object using the set fields.
         * @return {@link SearchOrdersRequest}
         */
        public SearchOrdersRequest build() {
            return new SearchOrdersRequest(locationIds, cursor, query, limit, returnEntries);
        }
    }
}
