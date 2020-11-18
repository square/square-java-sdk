
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchTeamMembersQuery type.
 */
public class SearchTeamMembersQuery {
    private final SearchTeamMembersFilter filter;

    /**
     * Initialization constructor.
     * @param filter SearchTeamMembersFilter value for filter.
     */
    @JsonCreator
    public SearchTeamMembersQuery(
            @JsonProperty("filter") SearchTeamMembersFilter filter) {
        this.filter = filter;
    }

    /**
     * Getter for Filter.
     * Represents a filter used in a search for `TeamMember` objects. `AND` logic is applied between
     * the individual fields, and `OR` logic is applied within list-based fields. For example,
     * setting this filter value, ``` filter = (locations_ids = ["A", "B"], status = ACTIVE) ```
     * returns only active team members assigned to either location "A" or "B".
     * @return Returns the SearchTeamMembersFilter
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTeamMembersQuery)) {
            return false;
        }
        SearchTeamMembersQuery other = (SearchTeamMembersQuery) obj;
        return Objects.equals(filter, other.filter);
    }

    /**
     * Converts this SearchTeamMembersQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTeamMembersQuery [" + "filter=" + filter + "]";
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
     * Class to build instances of {@link SearchTeamMembersQuery}.
     */
    public static class Builder {
        private SearchTeamMembersFilter filter;



        /**
         * Setter for filter.
         * @param filter SearchTeamMembersFilter value for filter.
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
