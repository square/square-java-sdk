package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchOrdersCustomerFilter type.
 */
public class SearchOrdersCustomerFilter {
    private final OptionalNullable<List<String>> customerIds;

    /**
     * Initialization constructor.
     * @param  customerIds  List of String value for customerIds.
     */
    @JsonCreator
    public SearchOrdersCustomerFilter(@JsonProperty("customer_ids") List<String> customerIds) {
        this.customerIds = OptionalNullable.of(customerIds);
    }

    /**
     * Initialization constructor.
     * @param  customerIds  List of String value for customerIds.
     */
    protected SearchOrdersCustomerFilter(OptionalNullable<List<String>> customerIds) {
        this.customerIds = customerIds;
    }

    /**
     * Internal Getter for CustomerIds.
     * A list of customer IDs to filter by. Max: 10 customer ids.
     * @return Returns the Internal List of String
     */
    @JsonGetter("customer_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetCustomerIds() {
        return this.customerIds;
    }

    /**
     * Getter for CustomerIds.
     * A list of customer IDs to filter by. Max: 10 customer ids.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCustomerIds() {
        return OptionalNullable.getFrom(customerIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersCustomerFilter)) {
            return false;
        }
        SearchOrdersCustomerFilter other = (SearchOrdersCustomerFilter) obj;
        return Objects.equals(customerIds, other.customerIds);
    }

    /**
     * Converts this SearchOrdersCustomerFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersCustomerFilter [" + "customerIds=" + customerIds + "]";
    }

    /**
     * Builds a new {@link SearchOrdersCustomerFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersCustomerFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.customerIds = internalGetCustomerIds();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersCustomerFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> customerIds;

        /**
         * Setter for customerIds.
         * @param  customerIds  List of String value for customerIds.
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = OptionalNullable.of(customerIds);
            return this;
        }

        /**
         * UnSetter for customerIds.
         * @return Builder
         */
        public Builder unsetCustomerIds() {
            customerIds = null;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersCustomerFilter} object using the set fields.
         * @return {@link SearchOrdersCustomerFilter}
         */
        public SearchOrdersCustomerFilter build() {
            return new SearchOrdersCustomerFilter(customerIds);
        }
    }
}
