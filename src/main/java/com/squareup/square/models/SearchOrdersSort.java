package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersSort {

    @JsonCreator
    public SearchOrdersSort(
            @JsonProperty("sort_field") String sortField,
            @JsonProperty("sort_order") String sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    private final String sortField;
    private final String sortOrder;

    @Override
    public int hashCode() {
        return Objects.hash(sortField, sortOrder);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersSort)) {
            return false;
        }
        SearchOrdersSort searchOrdersSort = (SearchOrdersSort) o;
        return Objects.equals(sortField, searchOrdersSort.sortField) &&
            Objects.equals(sortOrder, searchOrdersSort.sortOrder);
    }

    /**
     * Getter for SortField.
     * Specifies which timestamp to use to sort SearchOrder results.
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
        Builder builder = new Builder(sortField)
            .sortOrder(getSortOrder());
            return builder;
    }

    public static class Builder {
        private String sortField;
        private String sortOrder;

        public Builder(String sortField) {
            this.sortField = sortField;
        }

        public Builder sortField(String value) {
            sortField = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }

        public SearchOrdersSort build() {
            return new SearchOrdersSort(sortField,
                sortOrder);
        }
    }
}
