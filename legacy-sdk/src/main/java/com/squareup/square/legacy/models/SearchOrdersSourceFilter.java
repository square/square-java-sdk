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
 * This is a model class for SearchOrdersSourceFilter type.
 */
public class SearchOrdersSourceFilter {
    private final OptionalNullable<List<String>> sourceNames;

    /**
     * Initialization constructor.
     * @param  sourceNames  List of String value for sourceNames.
     */
    @JsonCreator
    public SearchOrdersSourceFilter(@JsonProperty("source_names") List<String> sourceNames) {
        this.sourceNames = OptionalNullable.of(sourceNames);
    }

    /**
     * Initialization constructor.
     * @param  sourceNames  List of String value for sourceNames.
     */
    protected SearchOrdersSourceFilter(OptionalNullable<List<String>> sourceNames) {
        this.sourceNames = sourceNames;
    }

    /**
     * Internal Getter for SourceNames.
     * Filters by the [Source](entity:OrderSource) `name`. The filter returns any orders with a
     * `source.name` that matches any of the listed source names. Max: 10 source names.
     * @return Returns the Internal List of String
     */
    @JsonGetter("source_names")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetSourceNames() {
        return this.sourceNames;
    }

    /**
     * Getter for SourceNames.
     * Filters by the [Source](entity:OrderSource) `name`. The filter returns any orders with a
     * `source.name` that matches any of the listed source names. Max: 10 source names.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getSourceNames() {
        return OptionalNullable.getFrom(sourceNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceNames);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersSourceFilter)) {
            return false;
        }
        SearchOrdersSourceFilter other = (SearchOrdersSourceFilter) obj;
        return Objects.equals(sourceNames, other.sourceNames);
    }

    /**
     * Converts this SearchOrdersSourceFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersSourceFilter [" + "sourceNames=" + sourceNames + "]";
    }

    /**
     * Builds a new {@link SearchOrdersSourceFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersSourceFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.sourceNames = internalGetSourceNames();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersSourceFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> sourceNames;

        /**
         * Setter for sourceNames.
         * @param  sourceNames  List of String value for sourceNames.
         * @return Builder
         */
        public Builder sourceNames(List<String> sourceNames) {
            this.sourceNames = OptionalNullable.of(sourceNames);
            return this;
        }

        /**
         * UnSetter for sourceNames.
         * @return Builder
         */
        public Builder unsetSourceNames() {
            sourceNames = null;
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
