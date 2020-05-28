package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListCustomersRequest type.
 */
public class ListCustomersRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param sortField
     * @param sortOrder
     */
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
     * Specifies customer attributes as the sort key to customer profiles returned from a search.
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

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, sortField, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCustomersRequest)) {
            return false;
        }
        ListCustomersRequest listCustomersRequest = (ListCustomersRequest) obj;
        return Objects.equals(cursor, listCustomersRequest.cursor) &&
            Objects.equals(sortField, listCustomersRequest.sortField) &&
            Objects.equals(sortOrder, listCustomersRequest.sortOrder);
    }

    /**
     * Builds a new {@link ListCustomersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .sortField(getSortField())
            .sortOrder(getSortOrder());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCustomersRequest}
     */
    public static class Builder {
        private String cursor;
        private String sortField;
        private String sortOrder;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for sortField
         * @param sortField
         * @return Builder
         */
        public Builder sortField(String sortField) {
            this.sortField = sortField;
            return this;
        }
        /**
         * Setter for sortOrder
         * @param sortOrder
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Builds a new {@link ListCustomersRequest} object using the set fields.
         * @return {@link ListCustomersRequest}
         */
        public ListCustomersRequest build() {
            return new ListCustomersRequest(cursor,
                sortField,
                sortOrder);
        }
    }
}
