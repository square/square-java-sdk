package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerQuery {

    @JsonCreator
    public CustomerQuery(
            @JsonProperty("filter") CustomerFilter filter,
            @JsonProperty("sort") CustomerSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    private final CustomerFilter filter;
    private final CustomerSort sort;

    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerQuery)) {
            return false;
        }
        CustomerQuery customerQuery = (CustomerQuery) o;
        return Objects.equals(filter, customerQuery.filter) &&
            Objects.equals(sort, customerQuery.sort);
    }

    /**
     * Getter for Filter.
     * Represents a set of `CustomerQuery` filters used to limit the set of
     * `Customers` returned by SearchCustomers.
     */
    @JsonGetter("filter")
    public CustomerFilter getFilter() { 
        return this.filter;
    }

    /**
     * Getter for Sort.
     * Indicates the field to use for sorting customer profiles.
     */
    @JsonGetter("sort")
    public CustomerSort getSort() { 
        return this.sort;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
            return builder;
    }

    public static class Builder {
        private CustomerFilter filter;
        private CustomerSort sort;

        public Builder() { }

        public Builder filter(CustomerFilter value) {
            filter = value;
            return this;
        }
        public Builder sort(CustomerSort value) {
            sort = value;
            return this;
        }

        public CustomerQuery build() {
            return new CustomerQuery(filter,
                sort);
        }
    }
}
