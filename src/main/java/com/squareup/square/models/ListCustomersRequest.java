package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListCustomersRequest {

    @JsonCreator
    public ListCustomersRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("sort_field") String sortField,
            @JsonProperty("sort_order") String sortOrder) {
        this.cursor = cursor;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    private final String cursor;
    private final String sortField;
    private final String sortOrder;

    @Override
    public int hashCode() {
        return Objects.hash(cursor, sortField, sortOrder);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCustomersRequest)) {
            return false;
        }
        ListCustomersRequest listCustomersRequest = (ListCustomersRequest) o;
        return Objects.equals(cursor, listCustomersRequest.cursor) &&
            Objects.equals(sortField, listCustomersRequest.sortField) &&
            Objects.equals(sortOrder, listCustomersRequest.sortOrder);
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for your original query.
     * See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

    /**
     * Getter for SortField.
     * Indicates the sort criteria for a list of Customers.
     */
    @JsonGetter("sort_field")
    public String getSortField() { 
        return this.sortField;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("sort_order")
    public String getSortOrder() { 
        return this.sortOrder;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .sortField(getSortField())
            .sortOrder(getSortOrder());
            return builder;
    }

    public static class Builder {
        private String cursor;
        private String sortField;
        private String sortOrder;

        public Builder() { }

        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder sortField(String value) {
            sortField = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }

        public ListCustomersRequest build() {
            return new ListCustomersRequest(cursor,
                sortField,
                sortOrder);
        }
    }
}
