package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ShiftQuery type.
 */
public class ShiftQuery {

    /**
     * Initialization constructor.
     * @param filter
     * @param sort
     */
    @JsonCreator
    public ShiftQuery(
            @JsonProperty("filter") ShiftFilter filter,
            @JsonProperty("sort") ShiftSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    private final ShiftFilter filter;
    private final ShiftSort sort;
    /**
     * Getter for Filter.
     * Defines a filter used in a search for `Shift` records. `AND` logic is
     * used by Square's servers to apply each filter property specified.
     */
    @JsonGetter("filter")
    public ShiftFilter getFilter() {
        return this.filter;
    }

    /**
     * Getter for Sort.
     * Sets the sort order of search results.
     */
    @JsonGetter("sort")
    public ShiftSort getSort() {
        return this.sort;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ShiftQuery)) {
            return false;
        }
        ShiftQuery shiftQuery = (ShiftQuery) obj;
        return Objects.equals(filter, shiftQuery.filter) &&
            Objects.equals(sort, shiftQuery.sort);
    }

    /**
     * Builds a new {@link ShiftQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
            return builder;
    }

    /**
     * Class to build instances of {@link ShiftQuery}
     */
    public static class Builder {
        private ShiftFilter filter;
        private ShiftSort sort;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filter
         * @param filter
         * @return Builder
         */
        public Builder filter(ShiftFilter filter) {
            this.filter = filter;
            return this;
        }
        /**
         * Setter for sort
         * @param sort
         * @return Builder
         */
        public Builder sort(ShiftSort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link ShiftQuery} object using the set fields.
         * @return {@link ShiftQuery}
         */
        public ShiftQuery build() {
            return new ShiftQuery(filter,
                sort);
        }
    }
}
