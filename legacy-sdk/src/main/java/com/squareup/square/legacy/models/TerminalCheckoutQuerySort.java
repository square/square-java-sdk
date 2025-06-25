package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalCheckoutQuerySort type.
 */
public class TerminalCheckoutQuerySort {
    private final String sortOrder;

    /**
     * Initialization constructor.
     * @param  sortOrder  String value for sortOrder.
     */
    @JsonCreator
    public TerminalCheckoutQuerySort(@JsonProperty("sort_order") String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortOrder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalCheckoutQuerySort)) {
            return false;
        }
        TerminalCheckoutQuerySort other = (TerminalCheckoutQuerySort) obj;
        return Objects.equals(sortOrder, other.sortOrder);
    }

    /**
     * Converts this TerminalCheckoutQuerySort into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalCheckoutQuerySort [" + "sortOrder=" + sortOrder + "]";
    }

    /**
     * Builds a new {@link TerminalCheckoutQuerySort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalCheckoutQuerySort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().sortOrder(getSortOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalCheckoutQuerySort}.
     */
    public static class Builder {
        private String sortOrder;

        /**
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
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
