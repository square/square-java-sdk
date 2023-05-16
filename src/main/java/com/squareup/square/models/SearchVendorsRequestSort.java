
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchVendorsRequestSort type.
 */
public class SearchVendorsRequestSort {
    private final String field;
    private final String order;

    /**
     * Initialization constructor.
     * @param  field  String value for field.
     * @param  order  String value for order.
     */
    @JsonCreator
    public SearchVendorsRequestSort(
            @JsonProperty("field") String field,
            @JsonProperty("order") String order) {
        this.field = field;
        this.order = order;
    }

    /**
     * Getter for Field.
     * The field to sort the returned [Vendor]($m/Vendor) objects by.
     * @return Returns the String
     */
    @JsonGetter("field")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getField() {
        return field;
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrder() {
        return order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, order);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchVendorsRequestSort)) {
            return false;
        }
        SearchVendorsRequestSort other = (SearchVendorsRequestSort) obj;
        return Objects.equals(field, other.field)
            && Objects.equals(order, other.order);
    }

    /**
     * Converts this SearchVendorsRequestSort into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchVendorsRequestSort [" + "field=" + field + ", order=" + order + "]";
    }

    /**
     * Builds a new {@link SearchVendorsRequestSort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchVendorsRequestSort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .field(getField())
                .order(getOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchVendorsRequestSort}.
     */
    public static class Builder {
        private String field;
        private String order;



        /**
         * Setter for field.
         * @param  field  String value for field.
         * @return Builder
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }

        /**
         * Setter for order.
         * @param  order  String value for order.
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

        /**
         * Builds a new {@link SearchVendorsRequestSort} object using the set fields.
         * @return {@link SearchVendorsRequestSort}
         */
        public SearchVendorsRequestSort build() {
            return new SearchVendorsRequestSort(field, order);
        }
    }
}
