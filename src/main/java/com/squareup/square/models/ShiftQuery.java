package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ShiftQuery {

    @JsonCreator
    public ShiftQuery(
            @JsonProperty("filter") ShiftFilter filter,
            @JsonProperty("sort") ShiftSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    private final ShiftFilter filter;
    private final ShiftSort sort;

    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ShiftQuery)) {
            return false;
        }
        ShiftQuery shiftQuery = (ShiftQuery) o;
        return Objects.equals(filter, shiftQuery.filter) &&
            Objects.equals(sort, shiftQuery.sort);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
            return builder;
    }

    public static class Builder {
        private ShiftFilter filter;
        private ShiftSort sort;

        public Builder() { }

        public Builder filter(ShiftFilter value) {
            filter = value;
            return this;
        }
        public Builder sort(ShiftSort value) {
            sort = value;
            return this;
        }

        public ShiftQuery build() {
            return new ShiftQuery(filter,
                sort);
        }
    }
}
