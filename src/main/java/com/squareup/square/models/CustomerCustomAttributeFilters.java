
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CustomerCustomAttributeFilters type.
 */
public class CustomerCustomAttributeFilters {
    private final List<CustomerCustomAttributeFilter> filters;

    /**
     * Initialization constructor.
     * @param  filters  List of CustomerCustomAttributeFilter value for filters.
     */
    @JsonCreator
    public CustomerCustomAttributeFilters(
            @JsonProperty("filters") List<CustomerCustomAttributeFilter> filters) {
        this.filters = filters;
    }

    /**
     * Getter for Filters.
     * The custom attribute filters. Each filter must specify `key` and include the `filter` field
     * with a type-specific filter, the `updated_at` field, or both. The provided keys must be
     * unique within the list of custom attribute filters.
     * @return Returns the List of CustomerCustomAttributeFilter
     */
    @JsonGetter("filters")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CustomerCustomAttributeFilter> getFilters() {
        return filters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filters);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerCustomAttributeFilters)) {
            return false;
        }
        CustomerCustomAttributeFilters other = (CustomerCustomAttributeFilters) obj;
        return Objects.equals(filters, other.filters);
    }

    /**
     * Converts this CustomerCustomAttributeFilters into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerCustomAttributeFilters [" + "filters=" + filters + "]";
    }

    /**
     * Builds a new {@link CustomerCustomAttributeFilters.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerCustomAttributeFilters.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filters(getFilters());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerCustomAttributeFilters}.
     */
    public static class Builder {
        private List<CustomerCustomAttributeFilter> filters;



        /**
         * Setter for filters.
         * @param  filters  List of CustomerCustomAttributeFilter value for filters.
         * @return Builder
         */
        public Builder filters(List<CustomerCustomAttributeFilter> filters) {
            this.filters = filters;
            return this;
        }

        /**
         * Builds a new {@link CustomerCustomAttributeFilters} object using the set fields.
         * @return {@link CustomerCustomAttributeFilters}
         */
        public CustomerCustomAttributeFilters build() {
            return new CustomerCustomAttributeFilters(filters);
        }
    }
}
