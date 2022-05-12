
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalActionQuery type.
 */
public class TerminalActionQuery {
    private final TerminalActionQueryFilter filter;
    private final TerminalActionQuerySort sort;

    /**
     * Initialization constructor.
     * @param  filter  TerminalActionQueryFilter value for filter.
     * @param  sort  TerminalActionQuerySort value for sort.
     */
    @JsonCreator
    public TerminalActionQuery(
            @JsonProperty("filter") TerminalActionQueryFilter filter,
            @JsonProperty("sort") TerminalActionQuerySort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * @return Returns the TerminalActionQueryFilter
     */
    @JsonGetter("filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TerminalActionQueryFilter getFilter() {
        return filter;
    }

    /**
     * Getter for Sort.
     * @return Returns the TerminalActionQuerySort
     */
    @JsonGetter("sort")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TerminalActionQuerySort getSort() {
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
        if (!(obj instanceof TerminalActionQuery)) {
            return false;
        }
        TerminalActionQuery other = (TerminalActionQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Converts this TerminalActionQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalActionQuery [" + "filter=" + filter + ", sort=" + sort + "]";
    }

    /**
     * Builds a new {@link TerminalActionQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalActionQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filter(getFilter())
                .sort(getSort());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalActionQuery}.
     */
    public static class Builder {
        private TerminalActionQueryFilter filter;
        private TerminalActionQuerySort sort;



        /**
         * Setter for filter.
         * @param  filter  TerminalActionQueryFilter value for filter.
         * @return Builder
         */
        public Builder filter(TerminalActionQueryFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param  sort  TerminalActionQuerySort value for sort.
         * @return Builder
         */
        public Builder sort(TerminalActionQuerySort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link TerminalActionQuery} object using the set fields.
         * @return {@link TerminalActionQuery}
         */
        public TerminalActionQuery build() {
            return new TerminalActionQuery(filter, sort);
        }
    }
}
