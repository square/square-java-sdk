package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InvoiceSort type.
 */
public class InvoiceSort {

    /**
     * Initialization constructor.
     * @param field
     * @param order
     */
    @JsonCreator
    public InvoiceSort(
            @JsonProperty("field") String field,
            @JsonProperty("order") String order) {
        this.field = field;
        this.order = order;
    }

    private final String field;
    private final String order;
    /**
     * Getter for Field.
     * Field to use for sorting.
     */
    @JsonGetter("field")
    public String getField() {
        return this.field;
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("order")
    public String getOrder() {
        return this.order;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(field, order);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InvoiceSort)) {
            return false;
        }
        InvoiceSort invoiceSort = (InvoiceSort) obj;
        return Objects.equals(field, invoiceSort.field) &&
            Objects.equals(order, invoiceSort.order);
    }

    /**
     * Builds a new {@link InvoiceSort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceSort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(field)
            .order(getOrder());
            return builder;
    }

    /**
     * Class to build instances of {@link InvoiceSort}
     */
    public static class Builder {
        private String field = "INVOICE_SORT_DATE";
        private String order;

        /**
         * Initialization constructor
         */
        public Builder(String field) {
            this.field = field;
        }

        /**
         * Setter for field
         * @param field
         * @return Builder
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }
        /**
         * Setter for order
         * @param order
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

        /**
         * Builds a new {@link InvoiceSort} object using the set fields.
         * @return {@link InvoiceSort}
         */
        public InvoiceSort build() {
            return new InvoiceSort(field,
                order);
        }
    }
}
