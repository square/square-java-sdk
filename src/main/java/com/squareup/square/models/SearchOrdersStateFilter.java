package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SearchOrdersStateFilter {

    @JsonCreator
    public SearchOrdersStateFilter(
            @JsonProperty("states") List<String> states) {
        this.states = states;
    }

    private final List<String> states;

    @Override
    public int hashCode() {
        return Objects.hash(states);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersStateFilter)) {
            return false;
        }
        SearchOrdersStateFilter searchOrdersStateFilter = (SearchOrdersStateFilter) o;
        return Objects.equals(states, searchOrdersStateFilter.states);
    }

    /**
     * Getter for States.
     * States to filter for.
     * See [OrderState](#type-orderstate) for possible values
     */
    @JsonGetter("states")
    public List<String> getStates() { 
        return this.states;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(states);
            return builder;
    }

    public static class Builder {
        private List<String> states;

        public Builder(List<String> states) {
            this.states = states;
        }

        public Builder states(List<String> value) {
            states = value;
            return this;
        }

        public SearchOrdersStateFilter build() {
            return new SearchOrdersStateFilter(states);
        }
    }
}
