
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * This is a model class for BulkUpdateTeamMembersResponse type.
 */
public class BulkUpdateTeamMembersResponse {
    private HttpContext httpContext;
    private final Map<String, UpdateTeamMemberResponse> teamMembers;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param teamMembers Map of String, value for teamMembers.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public BulkUpdateTeamMembersResponse(
            @JsonProperty("team_members") Map<String, UpdateTeamMemberResponse> teamMembers,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMembers = teamMembers;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMembers.
     * The successfully updated `TeamMember` objects. Each key is the `team_member_id` that maps to
     * the `UpdateTeamMemberRequest`.
     * @return Returns the Map of String, UpdateTeamMemberResponse
     */
    @JsonGetter("team_members")
    public Map<String, UpdateTeamMemberResponse> getTeamMembers() {
        return this.teamMembers;
    }

    /**
     * Getter for Errors.
     * The errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(teamMembers, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkUpdateTeamMembersResponse)) {
            return false;
        }
        BulkUpdateTeamMembersResponse other = (BulkUpdateTeamMembersResponse) obj;
        return Objects.equals(teamMembers, other.teamMembers)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Builds a new {@link BulkUpdateTeamMembersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpdateTeamMembersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMembers(getTeamMembers())
            .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpdateTeamMembersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, UpdateTeamMemberResponse> teamMembers;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for teamMembers.
         * @param teamMembers Map of String, value for teamMembers.
         * @return Builder
         */
        public Builder teamMembers(Map<String, UpdateTeamMemberResponse> teamMembers) {
            this.teamMembers = teamMembers;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link BulkUpdateTeamMembersResponse} object using the set fields.
         * @return {@link BulkUpdateTeamMembersResponse}
         */
        public BulkUpdateTeamMembersResponse build() {
            BulkUpdateTeamMembersResponse model =
                    new BulkUpdateTeamMembersResponse(teamMembers,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
