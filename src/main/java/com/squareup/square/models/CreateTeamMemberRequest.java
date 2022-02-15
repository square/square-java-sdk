
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateTeamMemberRequest type.
 */
public class CreateTeamMemberRequest {
    private final String idempotencyKey;
    private final TeamMember teamMember;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  teamMember  TeamMember value for teamMember.
     */
    @JsonCreator
    public CreateTeamMemberRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("team_member") TeamMember teamMember) {
        this.idempotencyKey = idempotencyKey;
        this.teamMember = teamMember;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateTeamMember` request. Keys can be any valid
     * string, but must be unique for every request. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency). The minimum
     * length is 1 and the maximum length is 45.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for TeamMember.
     * A record representing an individual team member for a business.
     * @return Returns the TeamMember
     */
    @JsonGetter("team_member")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TeamMember getTeamMember() {
        return teamMember;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, teamMember);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateTeamMemberRequest)) {
            return false;
        }
        CreateTeamMemberRequest other = (CreateTeamMemberRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(teamMember, other.teamMember);
    }

    /**
     * Converts this CreateTeamMemberRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateTeamMemberRequest [" + "idempotencyKey=" + idempotencyKey + ", teamMember="
                + teamMember + "]";
    }

    /**
     * Builds a new {@link CreateTeamMemberRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateTeamMemberRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .idempotencyKey(getIdempotencyKey())
                .teamMember(getTeamMember());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateTeamMemberRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private TeamMember teamMember;



        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

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
         * Builds a new {@link CreateTeamMemberRequest} object using the set fields.
         * @return {@link CreateTeamMemberRequest}
         */
        public CreateTeamMemberRequest build() {
            return new CreateTeamMemberRequest(idempotencyKey, teamMember);
        }
    }
}
