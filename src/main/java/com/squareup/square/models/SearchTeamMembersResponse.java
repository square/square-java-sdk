
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for SearchTeamMembersResponse type.
 */
public class SearchTeamMembersResponse {
    private HttpContext httpContext;
    private final List<TeamMember> teamMembers;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param teamMembers List of TeamMember value for teamMembers.
     * @param cursor String value for cursor.
     * @param errors List of Error value for errors.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMembers.
     * The filtered list of `TeamMember` objects.
     * @return Returns the List of TeamMember
     */
    @JsonGetter("team_members")
    public List<TeamMember> getTeamMembers() {
        return this.teamMembers;
    }

    /**
     * Getter for Cursor.
     * The opaque cursor for fetching the next page. Read about
     * [pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) with
     * Square APIs for more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
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
        return Objects.hash(teamMembers, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTeamMembersResponse)) {
            return false;
        }
        SearchTeamMembersResponse other = (SearchTeamMembersResponse) obj;
        return Objects.equals(teamMembers, other.teamMembers)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
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
     * Class to build instances of {@link SearchTeamMembersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<TeamMember> teamMembers;
        private String cursor;
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
         * @param teamMembers List of TeamMember value for teamMembers.
         * @return Builder
         */
        public Builder teamMembers(List<TeamMember> teamMembers) {
            this.teamMembers = teamMembers;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link SearchTeamMembersResponse} object using the set fields.
         * @return {@link SearchTeamMembersResponse}
         */
        public SearchTeamMembersResponse build() {
            SearchTeamMembersResponse model =
                    new SearchTeamMembersResponse(teamMembers,
                            cursor,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
