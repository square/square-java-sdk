
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateTeamMemberResponse type.
 */
public class UpdateTeamMemberResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TeamMember teamMember;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  teamMember  TeamMember value for teamMember.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public UpdateTeamMemberResponse(
            @JsonProperty("team_member") TeamMember teamMember,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMember = teamMember;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
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

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMember, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateTeamMemberResponse)) {
            return false;
        }
        UpdateTeamMemberResponse other = (UpdateTeamMemberResponse) obj;
        return Objects.equals(teamMember, other.teamMember)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this UpdateTeamMemberResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateTeamMemberResponse [" + "teamMember=" + teamMember + ", errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link UpdateTeamMemberResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateTeamMemberResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .teamMember(getTeamMember())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateTeamMemberResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private TeamMember teamMember;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link UpdateTeamMemberResponse} object using the set fields.
         * @return {@link UpdateTeamMemberResponse}
         */
        public UpdateTeamMemberResponse build() {
            UpdateTeamMemberResponse model =
                    new UpdateTeamMemberResponse(teamMember, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
