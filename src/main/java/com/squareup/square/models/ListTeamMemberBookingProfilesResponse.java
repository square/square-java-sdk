
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
 * This is a model class for ListTeamMemberBookingProfilesResponse type.
 */
public class ListTeamMemberBookingProfilesResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<TeamMemberBookingProfile> teamMemberBookingProfiles;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  teamMemberBookingProfiles  List of TeamMemberBookingProfile value for
     *         teamMemberBookingProfiles.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListTeamMemberBookingProfilesResponse(
            @JsonProperty("team_member_booking_profiles") List<TeamMemberBookingProfile> teamMemberBookingProfiles,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMemberBookingProfiles = teamMemberBookingProfiles;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMemberBookingProfiles.
     * The list of team member booking profiles.
     * @return Returns the List of TeamMemberBookingProfile
     */
    @JsonGetter("team_member_booking_profiles")
    public List<TeamMemberBookingProfile> getTeamMemberBookingProfiles() {
        return teamMemberBookingProfiles;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in the subsequent request to get the next page of the
     * results. Stop retrieving the next page of the results when the cursor is not set.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberBookingProfiles, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListTeamMemberBookingProfilesResponse)) {
            return false;
        }
        ListTeamMemberBookingProfilesResponse other = (ListTeamMemberBookingProfilesResponse) obj;
        return Objects.equals(teamMemberBookingProfiles, other.teamMemberBookingProfiles)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListTeamMemberBookingProfilesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListTeamMemberBookingProfilesResponse [" + "teamMemberBookingProfiles="
                + teamMemberBookingProfiles + ", cursor=" + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListTeamMemberBookingProfilesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTeamMemberBookingProfilesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .teamMemberBookingProfiles(getTeamMemberBookingProfiles())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListTeamMemberBookingProfilesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<TeamMemberBookingProfile> teamMemberBookingProfiles;
        private String cursor;
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
         * Setter for teamMemberBookingProfiles.
         * @param  teamMemberBookingProfiles  List of TeamMemberBookingProfile value for
         *         teamMemberBookingProfiles.
         * @return Builder
         */
        public Builder teamMemberBookingProfiles(
                List<TeamMemberBookingProfile> teamMemberBookingProfiles) {
            this.teamMemberBookingProfiles = teamMemberBookingProfiles;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link ListTeamMemberBookingProfilesResponse} object using the set fields.
         * @return {@link ListTeamMemberBookingProfilesResponse}
         */
        public ListTeamMemberBookingProfilesResponse build() {
            ListTeamMemberBookingProfilesResponse model =
                    new ListTeamMemberBookingProfilesResponse(teamMemberBookingProfiles, cursor,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
