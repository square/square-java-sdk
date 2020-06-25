package com.squareup.square.models;

import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BulkCreateTeamMembersRequest type.
 */
public class BulkCreateTeamMembersRequest {

    /**
     * Initialization constructor.
     * @param teamMembers
     */
    @JsonCreator
    public BulkCreateTeamMembersRequest(
            @JsonProperty("team_members") Map<String, CreateTeamMemberRequest> teamMembers) {
        this.teamMembers = teamMembers;
    }

    private final Map<String, CreateTeamMemberRequest> teamMembers;
    /**
     * Getter for TeamMembers.
     * The data which will be used to create the `TeamMember` objects. Each key is the `idempotency_key` that maps to the `CreateTeamMemberRequest`.
     */
    @JsonGetter("team_members")
    public Map<String, CreateTeamMemberRequest> getTeamMembers() {
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
        if(!(obj instanceof BulkCreateTeamMembersRequest)) {
            return false;
        }
        BulkCreateTeamMembersRequest bulkCreateTeamMembersRequest = (BulkCreateTeamMembersRequest) obj;
        return Objects.equals(teamMembers, bulkCreateTeamMembersRequest.teamMembers);
    }

    /**
     * Builds a new {@link BulkCreateTeamMembersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkCreateTeamMembersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(teamMembers);
            return builder;
    }

    /**
     * Class to build instances of {@link BulkCreateTeamMembersRequest}
     */
    public static class Builder {
        private Map<String, CreateTeamMemberRequest> teamMembers;

        /**
         * Initialization constructor
         */
        public Builder(Map<String, CreateTeamMemberRequest> teamMembers) {
            this.teamMembers = teamMembers;
        }

        /**
         * Setter for teamMembers
         * @param teamMembers
         * @return Builder
         */
        public Builder teamMembers(Map<String, CreateTeamMemberRequest> teamMembers) {
            this.teamMembers = teamMembers;
            return this;
        }

        /**
         * Builds a new {@link BulkCreateTeamMembersRequest} object using the set fields.
         * @return {@link BulkCreateTeamMembersRequest}
         */
        public BulkCreateTeamMembersRequest build() {
            return new BulkCreateTeamMembersRequest(teamMembers);
        }
    }
}
