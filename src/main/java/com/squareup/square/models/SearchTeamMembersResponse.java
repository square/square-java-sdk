package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchTeamMembersResponse type.
 */
public class SearchTeamMembersResponse {

    /**
     * Initialization constructor.
     * @param teamMembers
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public SearchTeamMembersResponse(
            @JsonProperty("team_members") List<TeamMember> teamMembers,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMembers = teamMembers;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<TeamMember> teamMembers;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMembers.
     * The filtered list of `TeamMember` objects.
     */
    @JsonGetter("team_members")
    public List<TeamMember> getTeamMembers() {
        return this.teamMembers;
    }

    /**
     * Getter for Cursor.
     * The opaque cursor for fetching the next page. Read about
     * [pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) with Square APIs for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
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
        return Objects.hash(teamMembers, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchTeamMembersResponse)) {
            return false;
        }
        SearchTeamMembersResponse searchTeamMembersResponse = (SearchTeamMembersResponse) obj;
        return Objects.equals(teamMembers, searchTeamMembersResponse.teamMembers) &&
            Objects.equals(cursor, searchTeamMembersResponse.cursor) &&
            Objects.equals(errors, searchTeamMembersResponse.errors);
    }

    /**
     * Builds a new {@link SearchTeamMembersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTeamMembersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .teamMembers(getTeamMembers())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchTeamMembersResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<TeamMember> teamMembers;
        private String cursor;
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
        public Builder teamMembers(List<TeamMember> teamMembers) {
            this.teamMembers = teamMembers;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link SearchTeamMembersResponse} object using the set fields.
         * @return {@link SearchTeamMembersResponse}
         */
        public SearchTeamMembersResponse build() {
            SearchTeamMembersResponse model = new SearchTeamMembersResponse(teamMembers,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
