
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalCheckoutQuery type.
 */
public class TerminalCheckoutQuery {
    private final TerminalCheckoutQueryFilter filter;
    private final TerminalCheckoutQuerySort sort;

    /**
     * Initialization constructor.
     * @param filter TerminalCheckoutQueryFilter value for filter.
     * @param sort TerminalCheckoutQuerySort value for sort.
     */
    @JsonCreator
    public TerminalCheckoutQuery(
            @JsonProperty("filter") TerminalCheckoutQueryFilter filter,
            @JsonProperty("sort") TerminalCheckoutQuerySort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * @return Returns the TerminalCheckoutQueryFilter
     */
    @JsonGetter("filter")
    public TerminalCheckoutQueryFilter getFilter() {
        return this.filter;
    }

    /**
     * Getter for Sort.
     * @return Returns the TerminalCheckoutQuerySort
     */
    @JsonGetter("sort")
    public TerminalCheckoutQuerySort getSort() {
        return this.sort;
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
        if (!(obj instanceof TerminalCheckoutQuery)) {
            return false;
        }
        TerminalCheckoutQuery other = (TerminalCheckoutQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Converts this TerminalCheckoutQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalCheckoutQuery [" + "filter=" + filter + ", sort=" + sort + "]";
    }

    /**
     * Builds a new {@link TerminalCheckoutQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalCheckoutQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filter(getFilter())
                .sort(getSort());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalCheckoutQuery}.
     */
    public static class Builder {
        private TerminalCheckoutQueryFilter filter;
        private TerminalCheckoutQuerySort sort;



        /**
         * Setter for filter.
         * @param filter TerminalCheckoutQueryFilter value for filter.
         * @return Builder
         */
        public Builder filter(TerminalCheckoutQueryFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param sort TerminalCheckoutQuerySort value for sort.
         * @return Builder
         */
        public Builder sort(TerminalCheckoutQuerySort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link TerminalCheckoutQuery} object using the set fields.
         * @return {@link TerminalCheckoutQuery}
         */
        public TerminalCheckoutQuery build() {
            return new TerminalCheckoutQuery(filter, sort);
        }
    }
}
