
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for SearchOrdersStateFilter type.
 */
public class SearchOrdersStateFilter {
    private final List<String> states;

    /**
     * Initialization constructor.
     * @param states List of String value for states.
     */
    @JsonCreator
    public SearchOrdersStateFilter(
            @JsonProperty("states") List<String> states) {
        this.states = states;
    }

    /**
     * Getter for States.
     * States to filter for. See [OrderState](#type-orderstate) for possible values
     * @return Returns the List of String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersStateFilter)) {
            return false;
        }
        SearchOrdersStateFilter other = (SearchOrdersStateFilter) obj;
        return Objects.equals(states, other.states);
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
     * Class to build instances of {@link SearchOrdersStateFilter}.
     */
    public static class Builder {
        private List<String> states;

        /**
         * Initialization constructor.
         * @param states List of String value for states.
         */
        public Builder(List<String> states) {
            this.states = states;
        }

        /**
         * Setter for states.
         * @param states List of String value for states.
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
