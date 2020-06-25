package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateTeamMemberResponse type.
 */
public class UpdateTeamMemberResponse {

    /**
     * Initialization constructor.
     * @param teamMember
     * @param errors
     */
    @JsonCreator
    public UpdateTeamMemberResponse(
            @JsonProperty("team_member") TeamMember teamMember,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMember = teamMember;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final TeamMember teamMember;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMember.
     * A record representing an individual team member for a business.
     */
    @JsonGetter("team_member")
    public TeamMember getTeamMember() {
        return this.teamMember;
    }

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(teamMember, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateTeamMemberResponse)) {
            return false;
        }
        UpdateTeamMemberResponse updateTeamMemberResponse = (UpdateTeamMemberResponse) obj;
        return Objects.equals(teamMember, updateTeamMemberResponse.teamMember) &&
            Objects.equals(errors, updateTeamMemberResponse.errors);
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
     * Class to build instances of {@link UpdateTeamMemberResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private TeamMember teamMember;
        private List<Error> errors;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
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
         * Setter for errors
         * @param errors
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
            UpdateTeamMemberResponse model = new UpdateTeamMemberResponse(teamMember,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
