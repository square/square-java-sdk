
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ShiftQuery type.
 */
public class ShiftQuery {
    private final ShiftFilter filter;
    private final ShiftSort sort;

    /**
     * Initialization constructor.
     * @param  filter  ShiftFilter value for filter.
     * @param  sort  ShiftSort value for sort.
     */
    @JsonCreator
    public ShiftQuery(
            @JsonProperty("filter") ShiftFilter filter,
            @JsonProperty("sort") ShiftSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * Defines a filter used in a search for `Shift` records. `AND` logic is used by Square's
     * servers to apply each filter property specified.
     * @return Returns the ShiftFilter
     */
    @JsonGetter("filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ShiftFilter getFilter() {
        return filter;
    }

    /**
     * Getter for Sort.
     * Sets the sort order of search results.
     * @return Returns the ShiftSort
     */
    @JsonGetter("sort")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ShiftSort getSort() {
        return sort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShiftQuery)) {
            return false;
        }
        ShiftQuery other = (ShiftQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Converts this ShiftQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ShiftQuery [" + "filter=" + filter + ", sort=" + sort + "]";
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
     * Class to build instances of {@link ShiftQuery}.
     */
    public static class Builder {
        private ShiftFilter filter;
        private ShiftSort sort;



        /**
         * Setter for filter.
         * @param  filter  ShiftFilter value for filter.
         * @return Builder
         */
        public Builder filter(ShiftFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param  sort  ShiftSort value for sort.
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
            return new ShiftQuery(filter, sort);
        }
    }
}
