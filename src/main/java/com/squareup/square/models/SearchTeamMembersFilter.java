package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchTeamMembersFilter type.
 */
public class SearchTeamMembersFilter {

    /**
     * Initialization constructor.
     * @param locationIds
     * @param status
     */
    @JsonCreator
    public SearchTeamMembersFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("status") String status) {
        this.locationIds = locationIds;
        this.status = status;
    }

    private final List<String> locationIds;
    private final String status;
    /**
     * Getter for LocationIds.
     * When present, filter by team members assigned to the specified locations.
     * When empty, include team members assigned to any location.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for Status.
     * Enumerates the possible statuses the team member can have within a business.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationIds, status);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchTeamMembersFilter)) {
            return false;
        }
        SearchTeamMembersFilter searchTeamMembersFilter = (SearchTeamMembersFilter) obj;
        return Objects.equals(locationIds, searchTeamMembersFilter.locationIds) &&
            Objects.equals(status, searchTeamMembersFilter.status);
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
     * Class to build instances of {@link SearchTeamMembersFilter}
     */
    public static class Builder {
        private List<String> locationIds;
        private String status;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }
        /**
         * Setter for status
         * @param status
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
            return new SearchTeamMembersFilter(locationIds,
                status);
        }
    }
}
