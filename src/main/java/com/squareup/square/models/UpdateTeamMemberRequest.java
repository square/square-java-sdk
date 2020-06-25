package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateTeamMemberRequest type.
 */
public class UpdateTeamMemberRequest {

    /**
     * Initialization constructor.
     * @param teamMember
     */
    @JsonCreator
    public UpdateTeamMemberRequest(
            @JsonProperty("team_member") TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    private final TeamMember teamMember;
    /**
     * Getter for TeamMember.
     * A record representing an individual team member for a business.
     */
    @JsonGetter("team_member")
    public TeamMember getTeamMember() {
        return this.teamMember;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(teamMember);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateTeamMemberRequest)) {
            return false;
        }
        UpdateTeamMemberRequest updateTeamMemberRequest = (UpdateTeamMemberRequest) obj;
        return Objects.equals(teamMember, updateTeamMemberRequest.teamMember);
    }

    /**
     * Builds a new {@link UpdateTeamMemberRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateTeamMemberRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMember(getTeamMember());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateTeamMemberRequest}
     */
    public static class Builder {
        private TeamMember teamMember;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for teamMember
         * @param teamMember
         * @return Builder
         */
        public Builder teamMember(TeamMember teamMember) {
            this.teamMember = teamMember;
            return this;
        }

        /**
         * Builds a new {@link UpdateTeamMemberRequest} object using the set fields.
         * @return {@link UpdateTeamMemberRequest}
         */
        public UpdateTeamMemberRequest build() {
            return new UpdateTeamMemberRequest(teamMember);
        }
    }
}
