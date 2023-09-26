
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkRetrieveTeamMemberBookingProfilesRequest type.
 */
public class BulkRetrieveTeamMemberBookingProfilesRequest {
    private final List<String> teamMemberIds;

    /**
     * Initialization constructor.
     * @param  teamMemberIds  List of String value for teamMemberIds.
     */
    @JsonCreator
    public BulkRetrieveTeamMemberBookingProfilesRequest(
            @JsonProperty("team_member_ids") List<String> teamMemberIds) {
        this.teamMemberIds = teamMemberIds;
    }

    /**
     * Getter for TeamMemberIds.
     * A non-empty list of IDs of team members whose booking profiles you want to retrieve.
     * @return Returns the List of String
     */
    @JsonGetter("team_member_ids")
    public List<String> getTeamMemberIds() {
        return teamMemberIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkRetrieveTeamMemberBookingProfilesRequest)) {
            return false;
        }
        BulkRetrieveTeamMemberBookingProfilesRequest other =
                (BulkRetrieveTeamMemberBookingProfilesRequest) obj;
        return Objects.equals(teamMemberIds, other.teamMemberIds);
    }

    /**
     * Converts this BulkRetrieveTeamMemberBookingProfilesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveTeamMemberBookingProfilesRequest [" + "teamMemberIds=" + teamMemberIds
                + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveTeamMemberBookingProfilesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveTeamMemberBookingProfilesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(teamMemberIds);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveTeamMemberBookingProfilesRequest}.
     */
    public static class Builder {
        private List<String> teamMemberIds;

        /**
         * Initialization constructor.
         * @param  teamMemberIds  List of String value for teamMemberIds.
         */
        public Builder(List<String> teamMemberIds) {
            this.teamMemberIds = teamMemberIds;
        }

        /**
         * Setter for teamMemberIds.
         * @param  teamMemberIds  List of String value for teamMemberIds.
         * @return Builder
         */
        public Builder teamMemberIds(List<String> teamMemberIds) {
            this.teamMemberIds = teamMemberIds;
            return this;
        }

        /**
         * Builds a new {@link BulkRetrieveTeamMemberBookingProfilesRequest} object using the set
         * fields.
         * @return {@link BulkRetrieveTeamMemberBookingProfilesRequest}
         */
        public BulkRetrieveTeamMemberBookingProfilesRequest build() {
            return new BulkRetrieveTeamMemberBookingProfilesRequest(teamMemberIds);
        }
    }
}
