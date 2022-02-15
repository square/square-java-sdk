
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchInvoicesRequest type.
 */
public class SearchInvoicesRequest {
    private final InvoiceQuery query;
    private final Integer limit;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  query  InvoiceQuery value for query.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchInvoicesRequest(
            @JsonProperty("query") InvoiceQuery query,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.query = query;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for Query.
     * Describes query criteria for searching invoices.
     * @return Returns the InvoiceQuery
     */
    @JsonGetter("query")
    public InvoiceQuery getQuery() {
        return query;
    }

    /**
     * Getter for Limit.
     * The maximum number of invoices to return (200 is the maximum `limit`). If not provided, the
     * server uses a default limit of 100 invoices.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchInvoicesRequest)) {
            return false;
        }
        SearchInvoicesRequest other = (SearchInvoicesRequest) obj;
        return Objects.equals(query, other.query)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchInvoicesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchInvoicesRequest [" + "query=" + query + ", limit=" + limit + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link SearchInvoicesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchInvoicesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(query)
                .limit(getLimit())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchInvoicesRequest}.
     */
    public static class Builder {
        private InvoiceQuery query;
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor.
         * @param  query  InvoiceQuery value for query.
         */
        public Builder(InvoiceQuery query) {
            this.query = query;
        }

        /**
         * Setter for query.
         * @param  query  InvoiceQuery value for query.
         * @return Builder
         */
        public Builder query(InvoiceQuery query) {
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
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link SearchInvoicesRequest} object using the set fields.
         * @return {@link SearchInvoicesRequest}
         */
        public SearchInvoicesRequest build() {
            return new SearchInvoicesRequest(query, limit, cursor);
        }
    }
}
