
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkCreateTeamMembersRequest type.
 */
public class BulkCreateTeamMembersRequest {
    private final Map<String, CreateTeamMemberRequest> teamMembers;

    /**
     * Initialization constructor.
     * @param teamMembers Map of String, value for teamMembers.
     */
    @JsonCreator
    public BulkCreateTeamMembersRequest(
            @JsonProperty("team_members") Map<String, CreateTeamMemberRequest> teamMembers) {
        this.teamMembers = teamMembers;
    }

    /**
     * Getter for TeamMembers.
     * The data which will be used to create the `TeamMember` objects. Each key is the
     * `idempotency_key` that maps to the `CreateTeamMemberRequest`.
     * @return Returns the Map of String, CreateTeamMemberRequest
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkCreateTeamMembersRequest)) {
            return false;
        }
        BulkCreateTeamMembersRequest other = (BulkCreateTeamMembersRequest) obj;
        return Objects.equals(teamMembers, other.teamMembers);
    }

    /**
     * Converts this BulkCreateTeamMembersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkCreateTeamMembersRequest [" + "teamMembers=" + teamMembers + "]";
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
     * Class to build instances of {@link BulkCreateTeamMembersRequest}.
     */
    public static class Builder {
        private Map<String, CreateTeamMemberRequest> teamMembers;

        /**
         * Initialization constructor.
         * @param teamMembers Map of String, value for teamMembers.
         */
        public Builder(Map<String, CreateTeamMemberRequest> teamMembers) {
            this.teamMembers = teamMembers;
        }

        /**
         * Setter for teamMembers.
         * @param teamMembers Map of String, value for teamMembers.
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
