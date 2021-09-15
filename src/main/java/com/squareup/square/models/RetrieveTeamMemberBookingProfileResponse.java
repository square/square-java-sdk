
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
 * This is a model class for RetrieveTeamMemberBookingProfileResponse type.
 */
public class RetrieveTeamMemberBookingProfileResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TeamMemberBookingProfile teamMemberBookingProfile;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  teamMemberBookingProfile  TeamMemberBookingProfile value for
     *         teamMemberBookingProfile.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveTeamMemberBookingProfileResponse(
            @JsonProperty("team_member_booking_profile") TeamMemberBookingProfile teamMemberBookingProfile,
            @JsonProperty("errors") List<Error> errors) {
        this.teamMemberBookingProfile = teamMemberBookingProfile;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for TeamMemberBookingProfile.
     * The booking profile of a seller's team member, including the team member's ID, display name,
     * description and whether the team member can be booked as a service provider.
     * @return Returns the TeamMemberBookingProfile
     */
    @JsonGetter("team_member_booking_profile")
    public TeamMemberBookingProfile getTeamMemberBookingProfile() {
        return teamMemberBookingProfile;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamMemberBookingProfile, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveTeamMemberBookingProfileResponse)) {
            return false;
        }
        RetrieveTeamMemberBookingProfileResponse other =
                (RetrieveTeamMemberBookingProfileResponse) obj;
        return Objects.equals(teamMemberBookingProfile, other.teamMemberBookingProfile)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveTeamMemberBookingProfileResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveTeamMemberBookingProfileResponse [" + "teamMemberBookingProfile="
                + teamMemberBookingProfile + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link RetrieveTeamMemberBookingProfileResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveTeamMemberBookingProfileResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .teamMemberBookingProfile(getTeamMemberBookingProfile())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveTeamMemberBookingProfileResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private TeamMemberBookingProfile teamMemberBookingProfile;
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
         * Setter for teamMemberBookingProfile.
         * @param  teamMemberBookingProfile  TeamMemberBookingProfile value for
         *         teamMemberBookingProfile.
         * @return Builder
         */
        public Builder teamMemberBookingProfile(
                TeamMemberBookingProfile teamMemberBookingProfile) {
            this.teamMemberBookingProfile = teamMemberBookingProfile;
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
         * Builds a new {@link RetrieveTeamMemberBookingProfileResponse} object using the set
         * fields.
         * @return {@link RetrieveTeamMemberBookingProfileResponse}
         */
        public RetrieveTeamMemberBookingProfileResponse build() {
            RetrieveTeamMemberBookingProfileResponse model =
                    new RetrieveTeamMemberBookingProfileResponse(teamMemberBookingProfile, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
