
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TerminalRefundQuerySort type.
 */
public class TerminalRefundQuerySort {
    private final String sortOrder;

    /**
     * Initialization constructor.
     * @param  sortOrder  String value for sortOrder.
     */
    @JsonCreator
    public TerminalRefundQuerySort(
            @JsonProperty("sort_order") String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * Getter for SortOrder.
     * The order in which results are listed. - `ASC` - Oldest to newest. - `DESC` - Newest to
     * oldest (default).
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
        if (!(obj instanceof TerminalRefundQuerySort)) {
            return false;
        }
        TerminalRefundQuerySort other = (TerminalRefundQuerySort) obj;
        return Objects.equals(sortOrder, other.sortOrder);
    }

    /**
     * Converts this TerminalRefundQuerySort into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalRefundQuerySort [" + "sortOrder=" + sortOrder + "]";
    }

    /**
     * Builds a new {@link TerminalRefundQuerySort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalRefundQuerySort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .sortOrder(getSortOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalRefundQuerySort}.
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
         * Builds a new {@link TerminalRefundQuerySort} object using the set fields.
         * @return {@link TerminalRefundQuerySort}
         */
        public TerminalRefundQuerySort build() {
            return new TerminalRefundQuerySort(sortOrder);
        }
    }
}
