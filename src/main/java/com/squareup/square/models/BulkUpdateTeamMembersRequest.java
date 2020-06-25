package com.squareup.square.models;

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BulkUpdateTeamMembersRequest type.
 */
public class BulkUpdateTeamMembersRequest {

    /**
     * Initialization constructor.
     * @param teamMembers
     */
    @JsonCreator
    public BulkUpdateTeamMembersRequest(
            @JsonProperty("team_members") Map<String, UpdateTeamMemberRequest> teamMembers) {
        this.teamMembers = teamMembers;
    }

    private final Map<String, UpdateTeamMemberRequest> teamMembers;
    /**
     * Getter for TeamMembers.
     * The data which will be used to update the `TeamMember` objects. Each key is the `team_member_id` that maps to the `UpdateTeamMemberRequest`.
     */
    @JsonGetter("team_members")
    public Map<String, UpdateTeamMemberRequest> getTeamMembers() {
        return this.teamMembers;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(teamMembers);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BulkUpdateTeamMembersRequest)) {
            return false;
        }
        BulkUpdateTeamMembersRequest bulkUpdateTeamMembersRequest = (BulkUpdateTeamMembersRequest) obj;
        return Objects.equals(teamMembers, bulkUpdateTeamMembersRequest.teamMembers);
    }

    /**
     * Builds a new {@link BulkUpdateTeamMembersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpdateTeamMembersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(teamMembers);
            return builder;
    }

    /**
     * Class to build instances of {@link BulkUpdateTeamMembersRequest}
     */
    public static class Builder {
        private Map<String, UpdateTeamMemberRequest> teamMembers;

        /**
         * Initialization constructor
         */
        public Builder(Map<String, UpdateTeamMemberRequest> teamMembers) {
            this.teamMembers = teamMembers;
        }

        /**
         * Setter for teamMembers
         * @param teamMembers
         * @return Builder
         */
        public Builder teamMembers(Map<String, UpdateTeamMemberRequest> teamMembers) {
            this.teamMembers = teamMembers;
            return this;
        }

        /**
         * Builds a new {@link BulkUpdateTeamMembersRequest} object using the set fields.
         * @return {@link BulkUpdateTeamMembersRequest}
         */
        public BulkUpdateTeamMembersRequest build() {
            return new BulkUpdateTeamMembersRequest(teamMembers);
        }
    }
}
