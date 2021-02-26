
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateTeamMemberRequest type.
 */
public class UpdateTeamMemberRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TeamMember teamMember;

    /**
     * Initialization constructor.
     * @param  teamMember  TeamMember value for teamMember.
     */
    @JsonCreator
    public UpdateTeamMemberRequest(
            @JsonProperty("team_member") TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    /**
     * Getter for TeamMember.
     * A record representing an individual team member for a business.
     * @return Returns the TeamMember
     */
    @JsonGetter("team_member")
    public TeamMember getTeamMember() {
        return teamMember;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMember);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateTeamMemberRequest)) {
            return false;
        }
        UpdateTeamMemberRequest other = (UpdateTeamMemberRequest) obj;
        return Objects.equals(teamMember, other.teamMember);
    }

    /**
     * Converts this UpdateTeamMemberRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateTeamMemberRequest [" + "teamMember=" + teamMember + "]";
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
     * Class to build instances of {@link UpdateTeamMemberRequest}.
     */
    public static class Builder {
        private TeamMember teamMember;



        /**
         * Setter for teamMember.
         * @param  teamMember  TeamMember value for teamMember.
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
