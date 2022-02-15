
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
    private final List<String> locationIds;
    private final String status;
    private final Boolean isOwner;

    /**
     * Initialization constructor.
     * @param  locationIds  List of String value for locationIds.
     * @param  status  String value for status.
     * @param  isOwner  Boolean value for isOwner.
     */
    @JsonCreator
    public SearchTeamMembersFilter(
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("status") String status,
            @JsonProperty("is_owner") Boolean isOwner) {
        this.locationIds = locationIds;
        this.status = status;
        this.isOwner = isOwner;
    }

    /**
     * Getter for LocationIds.
     * When present, filters by team members assigned to the specified locations. When empty,
     * includes team members assigned to any location.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getLocationIds() {
        return locationIds;
    }

    /**
     * Getter for Status.
     * Enumerates the possible statuses the team member can have within a business.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for IsOwner.
     * When present and set to true, returns the team member who is the owner of the Square account.
     * @return Returns the Boolean
     */
    @JsonGetter("is_owner")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIsOwner() {
        return isOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, status, isOwner);
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
            && Objects.equals(status, other.status)
            && Objects.equals(isOwner, other.isOwner);
    }

    /**
     * Converts this SearchTeamMembersFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTeamMembersFilter [" + "locationIds=" + locationIds + ", status=" + status
                + ", isOwner=" + isOwner + "]";
    }

    /**
     * Builds a new {@link SearchTeamMembersFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTeamMembersFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationIds(getLocationIds())
                .status(getStatus())
                .isOwner(getIsOwner());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTeamMembersFilter}.
     */
    public static class Builder {
        private List<String> locationIds;
        private String status;
        private Boolean isOwner;



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
         * Setter for isOwner.
         * @param  isOwner  Boolean value for isOwner.
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = isOwner;
            return this;
        }

        /**
         * Builds a new {@link SearchTeamMembersFilter} object using the set fields.
         * @return {@link SearchTeamMembersFilter}
         */
        public SearchTeamMembersFilter build() {
            return new SearchTeamMembersFilter(locationIds, status, isOwner);
        }
    }
}
