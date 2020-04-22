package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TerminalCheckoutQuerySort type.
 */
public class TerminalCheckoutQuerySort {

    /**
     * Initialization constructor.
     * @param sortOrder
     */
    @JsonCreator
    public TerminalCheckoutQuerySort(
            @JsonProperty("sort_order") String sortOrder) {
        this.sortOrder = sortOrder;
    }

    private final String sortOrder;
    /**
     * Getter for SortOrder.
     * The order in which results are listed.
     * - `ASC` - oldest to newest
     * - `DESC` - newest to oldest (default).
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return this.sortOrder;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TerminalCheckoutQuerySort)) {
            return false;
        }
        TerminalCheckoutQuerySort terminalCheckoutQuerySort = (TerminalCheckoutQuerySort) obj;
        return Objects.equals(sortOrder, terminalCheckoutQuerySort.sortOrder);
    }

    /**
     * Builds a new {@link TerminalCheckoutQuerySort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalCheckoutQuerySort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .sortOrder(getSortOrder());
            return builder;
    }

    /**
     * Class to build instances of {@link TerminalCheckoutQuerySort}
     */
    public static class Builder {
        private String sortOrder;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for sortOrder
         * @param sortOrder
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Builds a new {@link TerminalCheckoutQuerySort} object using the set fields.
         * @return {@link TerminalCheckoutQuerySort}
         */
        public TerminalCheckoutQuerySort build() {
            return new TerminalCheckoutQuerySort(sortOrder);
        }
    }
}
