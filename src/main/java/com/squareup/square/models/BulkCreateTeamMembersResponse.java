package com.squareup.square.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for BulkCreateTeamMembersResponse type.
 */
public class BulkCreateTeamMembersResponse {

    /**
     * Initialization constructor.
     * @param teamMembers
     * @param errors
     */
    @JsonCreator
    public BulkCreateTeamMembersResponse(
            @JsonProperty("team_members") Map<String, CreateTeamMemberResponse> teamMembers,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMembers = teamMembers;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Map<String, CreateTeamMemberResponse> teamMembers;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMembers.
     * The successfully created `TeamMember` objects. Each key is the `idempotency_key` that maps to the `CreateTeamMemberRequest`.
     */
    @JsonGetter("team_members")
    public Map<String, CreateTeamMemberResponse> getTeamMembers() {
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
        if(!(obj instanceof BulkCreateTeamMembersResponse)) {
            return false;
        }
        BulkCreateTeamMembersResponse bulkCreateTeamMembersResponse = (BulkCreateTeamMembersResponse) obj;
        return Objects.equals(teamMembers, bulkCreateTeamMembersResponse.teamMembers) &&
            Objects.equals(errors, bulkCreateTeamMembersResponse.errors);
    }

    /**
     * Builds a new {@link BulkCreateTeamMembersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkCreateTeamMembersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMembers(getTeamMembers())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link BulkCreateTeamMembersResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, CreateTeamMemberResponse> teamMembers;
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
        public Builder teamMembers(Map<String, CreateTeamMemberResponse> teamMembers) {
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
         * Builds a new {@link BulkCreateTeamMembersResponse} object using the set fields.
         * @return {@link BulkCreateTeamMembersResponse}
         */
        public BulkCreateTeamMembersResponse build() {
            BulkCreateTeamMembersResponse model = new BulkCreateTeamMembersResponse(teamMembers,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
