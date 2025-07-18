/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SearchOrdersStateFilter.Builder.class)
public final class SearchOrdersStateFilter {
    private final List<OrderState> states;

    private final Map<String, Object> additionalProperties;

    private SearchOrdersStateFilter(List<OrderState> states, Map<String, Object> additionalProperties) {
        this.states = states;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return States to filter for.
     * See <a href="#type-orderstate">OrderState</a> for possible values
     */
    @JsonProperty("states")
    public List<OrderState> getStates() {
        return states;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchOrdersStateFilter && equalTo((SearchOrdersStateFilter) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SearchOrdersStateFilter other) {
        return states.equals(other.states);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.states);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<OrderState> states = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SearchOrdersStateFilter other) {
            states(other.getStates());
            return this;
        }

        /**
         * <p>States to filter for.
         * See <a href="#type-orderstate">OrderState</a> for possible values</p>
         */
        @JsonSetter(value = "states", nulls = Nulls.SKIP)
        public Builder states(List<OrderState> states) {
            this.states.clear();
            this.states.addAll(states);
            return this;
        }

        public Builder addStates(OrderState states) {
            this.states.add(states);
            return this;
        }

        public Builder addAllStates(List<OrderState> states) {
            this.states.addAll(states);
            return this;
        }

        public SearchOrdersStateFilter build() {
            return new SearchOrdersStateFilter(states, additionalProperties);
        }
    }
}
