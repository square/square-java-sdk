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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SearchTeamMembersQuery.Builder.class)
public final class SearchTeamMembersQuery {
    private final Optional<SearchTeamMembersFilter> filter;

    private final Map<String, Object> additionalProperties;

    private SearchTeamMembersQuery(Optional<SearchTeamMembersFilter> filter, Map<String, Object> additionalProperties) {
        this.filter = filter;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The options to filter by.
     */
    @JsonProperty("filter")
    public Optional<SearchTeamMembersFilter> getFilter() {
        return filter;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchTeamMembersQuery && equalTo((SearchTeamMembersQuery) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SearchTeamMembersQuery other) {
        return filter.equals(other.filter);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.filter);
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
        private Optional<SearchTeamMembersFilter> filter = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SearchTeamMembersQuery other) {
            filter(other.getFilter());
            return this;
        }

        /**
         * <p>The options to filter by.</p>
         */
        @JsonSetter(value = "filter", nulls = Nulls.SKIP)
        public Builder filter(Optional<SearchTeamMembersFilter> filter) {
            this.filter = filter;
            return this;
        }

        public Builder filter(SearchTeamMembersFilter filter) {
            this.filter = Optional.ofNullable(filter);
            return this;
        }

        public SearchTeamMembersQuery build() {
            return new SearchTeamMembersQuery(filter, additionalProperties);
        }
    }
}
