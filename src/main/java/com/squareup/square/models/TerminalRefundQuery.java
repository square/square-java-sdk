
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalRefundQuery type.
 */
public class TerminalRefundQuery {
    private final TerminalRefundQueryFilter filter;
    private final TerminalRefundQuerySort sort;

    /**
     * Initialization constructor.
     * @param  filter  TerminalRefundQueryFilter value for filter.
     * @param  sort  TerminalRefundQuerySort value for sort.
     */
    @JsonCreator
    public TerminalRefundQuery(
            @JsonProperty("filter") TerminalRefundQueryFilter filter,
            @JsonProperty("sort") TerminalRefundQuerySort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * @return Returns the TerminalRefundQueryFilter
     */
    @JsonGetter("filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TerminalRefundQueryFilter getFilter() {
        return filter;
    }

    /**
     * Getter for Sort.
     * @return Returns the TerminalRefundQuerySort
     */
    @JsonGetter("sort")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TerminalRefundQuerySort getSort() {
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
        if (!(obj instanceof TerminalRefundQuery)) {
            return false;
        }
        TerminalRefundQuery other = (TerminalRefundQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Converts this TerminalRefundQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalRefundQuery [" + "filter=" + filter + ", sort=" + sort + "]";
    }

    /**
     * Builds a new {@link TerminalRefundQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalRefundQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filter(getFilter())
                .sort(getSort());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalRefundQuery}.
     */
    public static class Builder {
        private TerminalRefundQueryFilter filter;
        private TerminalRefundQuerySort sort;



        /**
         * Setter for filter.
         * @param  filter  TerminalRefundQueryFilter value for filter.
         * @return Builder
         */
        public Builder filter(TerminalRefundQueryFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param  sort  TerminalRefundQuerySort value for sort.
         * @return Builder
         */
        public Builder sort(TerminalRefundQuerySort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link TerminalRefundQuery} object using the set fields.
         * @return {@link TerminalRefundQuery}
         */
        public TerminalRefundQuery build() {
            return new TerminalRefundQuery(filter, sort);
        }
    }
}
