
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for CustomerQuery type.
 */
public class CustomerQuery {
    private final CustomerFilter filter;
    private final CustomerSort sort;

    /**
     * Initialization constructor.
     * @param filter CustomerFilter value for filter.
     * @param sort CustomerSort value for sort.
     */
    @JsonCreator
    public CustomerQuery(
            @JsonProperty("filter") CustomerFilter filter,
            @JsonProperty("sort") CustomerSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    /**
     * Getter for Filter.
     * Represents a set of `CustomerQuery` filters used to limit the set of `Customers` returned by
     * `SearchCustomers`.
     * @return Returns the CustomerFilter
     */
    @JsonGetter("filter")
    public CustomerFilter getFilter() {
        return this.filter;
    }

    /**
     * Getter for Sort.
     * Specifies how searched customers profiles are sorted, including the sort key and sort order.
     * @return Returns the CustomerSort
     */
    @JsonGetter("sort")
    public CustomerSort getSort() {
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
        if (!(obj instanceof CustomerQuery)) {
            return false;
        }
        CustomerQuery other = (CustomerQuery) obj;
        return Objects.equals(filter, other.filter)
            && Objects.equals(sort, other.sort);
    }

    /**
     * Builds a new {@link CustomerQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerQuery}.
     */
    public static class Builder {
        private CustomerFilter filter;
        private CustomerSort sort;



        /**
         * Setter for filter.
         * @param filter CustomerFilter value for filter.
         * @return Builder
         */
        public Builder filter(CustomerFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for sort.
         * @param sort CustomerSort value for sort.
         * @return Builder
         */
        public Builder sort(CustomerSort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link CustomerQuery} object using the set fields.
         * @return {@link CustomerQuery}
         */
        public CustomerQuery build() {
            return new CustomerQuery(filter,
                sort);
        }
    }
}
