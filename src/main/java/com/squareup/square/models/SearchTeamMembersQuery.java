package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchTeamMembersQuery type.
 */
public class SearchTeamMembersQuery {

    /**
     * Initialization constructor.
     * @param filter
     */
    @JsonCreator
    public SearchTeamMembersQuery(
            @JsonProperty("filter") SearchTeamMembersFilter filter) {
        this.filter = filter;
    }

    private final SearchTeamMembersFilter filter;
    /**
     * Getter for Filter.
     * Represents a filter used in a search for `TeamMember` objects. `AND` logic is applied
     * between the individual fields, and `OR` logic is applied within list-based fields.
     * For example, setting this filter value,
     * ```
     * filter = (locations_ids = ["A", "B"], status = ACTIVE)
     * ```
     * returns only active team members assigned to either location "A" or "B".
     */
    @JsonGetter("filter")
    public SearchTeamMembersFilter getFilter() {
        return this.filter;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filter);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchTeamMembersQuery)) {
            return false;
        }
        SearchTeamMembersQuery searchTeamMembersQuery = (SearchTeamMembersQuery) obj;
        return Objects.equals(filter, searchTeamMembersQuery.filter);
    }

    /**
     * Builds a new {@link SearchTeamMembersQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTeamMembersQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchTeamMembersQuery}
     */
    public static class Builder {
        private SearchTeamMembersFilter filter;

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
        public Builder filter(SearchTeamMembersFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Builds a new {@link SearchTeamMembersQuery} object using the set fields.
         * @return {@link SearchTeamMembersQuery}
         */
        public SearchTeamMembersQuery build() {
            return new SearchTeamMembersQuery(filter);
        }
    }
}
