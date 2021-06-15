
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchTeamMembersFilter type.
 */
public class SearchTeamMembersFilter {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> locationIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  status  String value for status.
     */
    @JsonCreator
    public SearchTeamMembersFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("status") String status) {
        this.locationIds = locationIds;
        this.status = status;
    }

    /**
     * Getter for LocationIds.
     * When present, filters by team members assigned to the specified locations. When empty,
     * includes team members assigned to any location.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
    }

    /**
     * Getter for Status.
     * Enumerates the possible statuses the team member can have within a business.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTeamMembersFilter)) {
            return false;
        }
        SearchTeamMembersFilter other = (SearchTeamMembersFilter) obj;
        return Objects.equals(locationIds, other.locationIds)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this SearchTeamMembersFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTeamMembersFilter [" + "locationIds=" + locationIds + ", status=" + status
                + "]";
    }

    /**
     * Builds a new {@link SearchTeamMembersFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTeamMembersFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationIds(getLocationIds())
                .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTeamMembersFilter}.
     */
    public static class Builder {
        private List<String> locationIds;
        private String status;



        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link SearchTeamMembersFilter} object using the set fields.
         * @return {@link SearchTeamMembersFilter}
         */
        public SearchTeamMembersFilter build() {
            return new SearchTeamMembersFilter(locationIds, status);
        }
    }
}
