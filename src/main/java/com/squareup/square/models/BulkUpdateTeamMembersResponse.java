package com.squareup.square.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for BulkUpdateTeamMembersResponse type.
 */
public class BulkUpdateTeamMembersResponse {

    /**
     * Initialization constructor.
     * @param teamMembers
     * @param errors
     */
    @JsonCreator
    public BulkUpdateTeamMembersResponse(
            @JsonProperty("team_members") Map<String, UpdateTeamMemberResponse> teamMembers,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMembers = teamMembers;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Map<String, UpdateTeamMemberResponse> teamMembers;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMembers.
     * The successfully updated `TeamMember` objects. Each key is the `team_member_id` that maps to the `UpdateTeamMemberRequest`.
     */
    @JsonGetter("team_members")
    public Map<String, UpdateTeamMemberResponse> getTeamMembers() {
        return this.teamMembers;
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
        return Objects.hash(teamMembers, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BulkUpdateTeamMembersResponse)) {
            return false;
        }
        BulkUpdateTeamMembersResponse bulkUpdateTeamMembersResponse = (BulkUpdateTeamMembersResponse) obj;
        return Objects.equals(teamMembers, bulkUpdateTeamMembersResponse.teamMembers) &&
            Objects.equals(errors, bulkUpdateTeamMembersResponse.errors);
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
     * Class to build instances of {@link BulkUpdateTeamMembersResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, UpdateTeamMemberResponse> teamMembers;
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
         * Setter for teamMembers
         * @param teamMembers
         * @return Builder
         */
        public Builder teamMembers(Map<String, UpdateTeamMemberResponse> teamMembers) {
            this.teamMembers = teamMembers;
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
         * Builds a new {@link BulkUpdateTeamMembersResponse} object using the set fields.
         * @return {@link BulkUpdateTeamMembersResponse}
         */
        public BulkUpdateTeamMembersResponse build() {
            BulkUpdateTeamMembersResponse model = new BulkUpdateTeamMembersResponse(teamMembers,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
