package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersSort type.
 */
public class SearchOrdersSort {

    /**
     * Initialization constructor.
     * @param sortField
     * @param sortOrder
     */
    @JsonCreator
    public SearchOrdersSort(
            @JsonProperty("sort_field") String sortField,
            @JsonProperty("sort_order") String sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    private final String sortField;
    private final String sortOrder;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(sortField, sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersSort)) {
            return false;
        }
        SearchOrdersSort searchOrdersSort = (SearchOrdersSort) obj;
        return Objects.equals(sortField, searchOrdersSort.sortField) &&
            Objects.equals(sortOrder, searchOrdersSort.sortOrder);
    }

    /**
     * Builds a new {@link SearchOrdersSort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersSort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(sortField)
            .sortOrder(getSortOrder());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersSort}
     */
    public static class Builder {
        private String sortField;
        private String sortOrder;

        /**
         * Initialization constructor
         */
        public Builder(String sortField) {
            this.sortField = sortField;
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
         * Builds a new {@link SearchOrdersSort} object using the set fields.
         * @return {@link SearchOrdersSort}
         */
        public SearchOrdersSort build() {
            return new SearchOrdersSort(sortField,
                sortOrder);
        }
    }
}
