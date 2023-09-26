
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkRetrieveTeamMemberBookingProfilesResponse type.
 */
public class BulkRetrieveTeamMemberBookingProfilesResponse {
    private HttpContext httpContext;
    private final Map<String, RetrieveTeamMemberBookingProfileResponse> teamMemberBookingProfiles;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  teamMemberBookingProfiles  Map of String, value for teamMemberBookingProfiles.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkRetrieveTeamMemberBookingProfilesResponse(
            @JsonProperty("team_member_booking_profiles") Map<String, RetrieveTeamMemberBookingProfileResponse> teamMemberBookingProfiles,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMemberBookingProfiles = teamMemberBookingProfiles;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMemberBookingProfiles.
     * The returned team members' booking profiles, as a map with `team_member_id` as the key and
     * [TeamMemberBookingProfile](entity:TeamMemberBookingProfile) the value.
     * @return Returns the Map of String, RetrieveTeamMemberBookingProfileResponse
     */
    @JsonGetter("team_member_booking_profiles")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, RetrieveTeamMemberBookingProfileResponse> getTeamMemberBookingProfiles() {
        return teamMemberBookingProfiles;
    }

    /**
     * Getter for Errors.
     * Errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberBookingProfiles, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkRetrieveTeamMemberBookingProfilesResponse)) {
            return false;
        }
        BulkRetrieveTeamMemberBookingProfilesResponse other =
                (BulkRetrieveTeamMemberBookingProfilesResponse) obj;
        return Objects.equals(teamMemberBookingProfiles, other.teamMemberBookingProfiles)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkRetrieveTeamMemberBookingProfilesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkRetrieveTeamMemberBookingProfilesResponse [" + "teamMemberBookingProfiles="
                + teamMemberBookingProfiles + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkRetrieveTeamMemberBookingProfilesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkRetrieveTeamMemberBookingProfilesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .teamMemberBookingProfiles(getTeamMemberBookingProfiles())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkRetrieveTeamMemberBookingProfilesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, RetrieveTeamMemberBookingProfileResponse> teamMemberBookingProfiles;
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
         * @param  teamMemberBookingProfiles  Map of String, value for teamMemberBookingProfiles.
         * @return Builder
         */
        public Builder teamMemberBookingProfiles(
                Map<String, RetrieveTeamMemberBookingProfileResponse> teamMemberBookingProfiles) {
            this.teamMemberBookingProfiles = teamMemberBookingProfiles;
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
         * Builds a new {@link BulkRetrieveTeamMemberBookingProfilesResponse} object using the set
         * fields.
         * @return {@link BulkRetrieveTeamMemberBookingProfilesResponse}
         */
        public BulkRetrieveTeamMemberBookingProfilesResponse build() {
            BulkRetrieveTeamMemberBookingProfilesResponse model =
                    new BulkRetrieveTeamMemberBookingProfilesResponse(teamMemberBookingProfiles,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
