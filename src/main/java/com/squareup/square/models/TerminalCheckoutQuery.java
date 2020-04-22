package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TerminalCheckoutQuery type.
 */
public class TerminalCheckoutQuery {

    /**
     * Initialization constructor.
     * @param filter
     * @param sort
     */
    @JsonCreator
    public TerminalCheckoutQuery(
            @JsonProperty("filter") TerminalCheckoutQueryFilter filter,
            @JsonProperty("sort") TerminalCheckoutQuerySort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    private final TerminalCheckoutQueryFilter filter;
    private final TerminalCheckoutQuerySort sort;
    /**
     * Getter for Filter.
     */
    @JsonGetter("filter")
    public TerminalCheckoutQueryFilter getFilter() {
        return this.filter;
    }

    /**
     * Getter for Sort.
     */
    @JsonGetter("sort")
    public TerminalCheckoutQuerySort getSort() {
        return this.sort;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filter, sort);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TerminalCheckoutQuery)) {
            return false;
        }
        TerminalCheckoutQuery terminalCheckoutQuery = (TerminalCheckoutQuery) obj;
        return Objects.equals(filter, terminalCheckoutQuery.filter) &&
            Objects.equals(sort, terminalCheckoutQuery.sort);
    }

    /**
     * Builds a new {@link TerminalCheckoutQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalCheckoutQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter())
            .sort(getSort());
            return builder;
    }

    /**
     * Class to build instances of {@link TerminalCheckoutQuery}
     */
    public static class Builder {
        private TerminalCheckoutQueryFilter filter;
        private TerminalCheckoutQuerySort sort;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filter
         * @param filter
         * @return Builder
         */
        public Builder filter(TerminalCheckoutQueryFilter filter) {
            this.filter = filter;
            return this;
        }
        /**
         * Setter for sort
         * @param sort
         * @return Builder
         */
        public Builder sort(TerminalCheckoutQuerySort sort) {
            this.sort = sort;
            return this;
        }

        /**
         * Builds a new {@link TerminalCheckoutQuery} object using the set fields.
         * @return {@link TerminalCheckoutQuery}
         */
        public TerminalCheckoutQuery build() {
            return new TerminalCheckoutQuery(filter,
                sort);
        }
    }
}
