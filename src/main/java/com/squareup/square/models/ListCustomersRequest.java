
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListCustomersRequest type.
 */
public class ListCustomersRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sortField;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sortOrder;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  sortField  String value for sortField.
     * @param  sortOrder  String value for sortOrder.
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

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for your original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for SortField.
     * Specifies customer attributes as the sort key to customer profiles returned from a search.
     * @return Returns the String
     */
    @JsonGetter("sort_field")
    public String getSortField() {
        return sortField;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, sortField, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomersRequest)) {
            return false;
        }
        ListCustomersRequest other = (ListCustomersRequest) obj;
        return Objects.equals(cursor, other.cursor)
            && Objects.equals(sortField, other.sortField)
            && Objects.equals(sortOrder, other.sortOrder);
    }

    /**
     * Converts this ListCustomersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomersRequest [" + "cursor=" + cursor + ", sortField=" + sortField
                + ", sortOrder=" + sortOrder + "]";
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
     * Class to build instances of {@link ListCustomersRequest}.
     */
    public static class Builder {
        private String cursor;
        private String sortField;
        private String sortOrder;



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
         * Setter for sortField.
         * @param  sortField  String value for sortField.
         * @return Builder
         */
        public Builder sortField(String sortField) {
            this.sortField = sortField;
            return this;
        }

        /**
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
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
            return new ListCustomersRequest(cursor, sortField, sortOrder);
        }
    }
}
