
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for InvoiceQuery type.
 */
public class InvoiceQuery {
    private final InvoiceFilter filter;
    private final InvoiceSort sort;

    /**
     * Initialization constructor.
     * @param filter InvoiceFilter value for filter.
     * @param sort InvoiceSort value for sort.
     */
    @JsonCreator
    public InvoiceQuery(
            @JsonProperty("filter") InvoiceFilter filter,
            @JsonProperty("sort") InvoiceSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * Describes query filters to apply.
     * @return Returns the InvoiceFilter
     */
    @JsonGetter("filter")
    public InvoiceFilter getFilter() {
        return this.filter;
    }

    /**
     * Getter for Sort.
     * Identifies the sort field and sort order.
     * @return Returns the InvoiceSort
     */
    @JsonGetter("sort")
    public InvoiceSort getSort() {
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
        if (!(obj instanceof InvoiceQuery)) {
            return false;
        }
        InvoiceQuery other = (InvoiceQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Builds a new {@link InvoiceQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(filter)
            .sort(getSort());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceQuery}.
     */
    public static class Builder {
        private InvoiceFilter filter;
        private InvoiceSort sort;

        /**
         * Initialization constructor.
         * @param filter InvoiceFilter value for filter.
         */
        public Builder(InvoiceFilter filter) {
            this.filter = filter;
        }

        /**
         * Setter for filter.
         * @param filter InvoiceFilter value for filter.
         * @return Builder
         */
        public Builder filter(InvoiceFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param sort InvoiceSort value for sort.
         * @return Builder
         */
        public Builder sort(InvoiceSort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link InvoiceQuery} object using the set fields.
         * @return {@link InvoiceQuery}
         */
        public InvoiceQuery build() {
            return new InvoiceQuery(filter,
                sort);
        }
    }
}
