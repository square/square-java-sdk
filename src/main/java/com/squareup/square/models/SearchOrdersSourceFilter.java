package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersSourceFilter {

    @JsonCreator
    public SearchOrdersSourceFilter(
            @JsonProperty("source_names") List<String> sourceNames) {
        this.sourceNames = sourceNames;
    }

    private final List<String> sourceNames;

    @Override
    public int hashCode() {
        return Objects.hash(sourceNames);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersSourceFilter)) {
            return false;
        }
        SearchOrdersSourceFilter searchOrdersSourceFilter = (SearchOrdersSourceFilter) o;
        return Objects.equals(sourceNames, searchOrdersSourceFilter.sourceNames);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .sourceNames(getSourceNames());
            return builder;
    }

    public static class Builder {
        private List<String> sourceNames;

        public Builder() { }

        public Builder sourceNames(List<String> value) {
            sourceNames = value;
            return this;
        }

        public SearchOrdersSourceFilter build() {
            return new SearchOrdersSourceFilter(sourceNames);
        }
    }
}
