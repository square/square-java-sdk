package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchOrdersStateFilter type.
 */
public class SearchOrdersStateFilter {

    /**
     * Initialization constructor.
     * @param states
     */
    @JsonCreator
    public SearchOrdersStateFilter(
            @JsonProperty("states") List<String> states) {
        this.states = states;
    }

    private final List<String> states;
    /**
     * Getter for States.
     * States to filter for.
     * See [OrderState](#type-orderstate) for possible values
     */
    @JsonGetter("states")
    public List<String> getStates() {
        return this.states;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(states);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersStateFilter)) {
            return false;
        }
        SearchOrdersStateFilter searchOrdersStateFilter = (SearchOrdersStateFilter) obj;
        return Objects.equals(states, searchOrdersStateFilter.states);
    }

    /**
     * Builds a new {@link SearchOrdersStateFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersStateFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(states);
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersStateFilter}
     */
    public static class Builder {
        private List<String> states;

        /**
         * Initialization constructor
         */
        public Builder(List<String> states) {
            this.states = states;
        }

        /**
         * Setter for states
         * @param states
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = states;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersStateFilter} object using the set fields.
         * @return {@link SearchOrdersStateFilter}
         */
        public SearchOrdersStateFilter build() {
            return new SearchOrdersStateFilter(states);
        }
    }
}
