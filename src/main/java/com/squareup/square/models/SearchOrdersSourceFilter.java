package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersSourceFilter type.
 */
public class SearchOrdersSourceFilter {

    /**
     * Initialization constructor.
     * @param sourceNames
     */
    @JsonCreator
    public SearchOrdersSourceFilter(
            @JsonProperty("source_names") List<String> sourceNames) {
        this.sourceNames = sourceNames;
    }

    private final List<String> sourceNames;
    /**
     * Getter for SourceNames.
     * Filters by [Source](#type-ordersource) `name`. Will return any orders
     * with with a `source.name` that matches any of the listed source names.
     * Max: 10 source names.
     */
    @JsonGetter("source_names")
    public List<String> getSourceNames() {
        return this.sourceNames;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(sourceNames);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersSourceFilter)) {
            return false;
        }
        SearchOrdersSourceFilter searchOrdersSourceFilter = (SearchOrdersSourceFilter) obj;
        return Objects.equals(sourceNames, searchOrdersSourceFilter.sourceNames);
    }

    /**
     * Builds a new {@link SearchOrdersSourceFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersSourceFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .sourceNames(getSourceNames());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersSourceFilter}
     */
    public static class Builder {
        private List<String> sourceNames;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for sourceNames
         * @param sourceNames
         * @return Builder
         */
        public Builder sourceNames(List<String> sourceNames) {
            this.sourceNames = sourceNames;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersSourceFilter} object using the set fields.
         * @return {@link SearchOrdersSourceFilter}
         */
        public SearchOrdersSourceFilter build() {
            return new SearchOrdersSourceFilter(sourceNames);
        }
    }
}
