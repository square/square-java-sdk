package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveLocationBookingProfileResponse type.
 */
public class RetrieveLocationBookingProfileResponse {
    private HttpContext httpContext;
    private final LocationBookingProfile locationBookingProfile;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  locationBookingProfile  LocationBookingProfile value for locationBookingProfile.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveLocationBookingProfileResponse(
            @JsonProperty("location_booking_profile") LocationBookingProfile locationBookingProfile,
            @JsonProperty("errors") List<Error> errors) {
        this.locationBookingProfile = locationBookingProfile;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for LocationBookingProfile.
     * The booking profile of a seller's location, including the location's ID and whether the
     * location is enabled for online booking.
     * @return Returns the LocationBookingProfile
     */
    @JsonGetter("location_booking_profile")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LocationBookingProfile getLocationBookingProfile() {
        return locationBookingProfile;
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
        return Objects.hash(locationBookingProfile, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveLocationBookingProfileResponse)) {
            return false;
        }
        RetrieveLocationBookingProfileResponse other = (RetrieveLocationBookingProfileResponse) obj;
        return Objects.equals(locationBookingProfile, other.locationBookingProfile)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveLocationBookingProfileResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveLocationBookingProfileResponse [" + "locationBookingProfile=" + locationBookingProfile
                + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link RetrieveLocationBookingProfileResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveLocationBookingProfileResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationBookingProfile(getLocationBookingProfile())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveLocationBookingProfileResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private LocationBookingProfile locationBookingProfile;
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
         * Setter for locationBookingProfile.
         * @param  locationBookingProfile  LocationBookingProfile value for locationBookingProfile.
         * @return Builder
         */
        public Builder locationBookingProfile(LocationBookingProfile locationBookingProfile) {
            this.locationBookingProfile = locationBookingProfile;
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
         * Builds a new {@link RetrieveLocationBookingProfileResponse} object using the set fields.
         * @return {@link RetrieveLocationBookingProfileResponse}
         */
        public RetrieveLocationBookingProfileResponse build() {
            RetrieveLocationBookingProfileResponse model =
                    new RetrieveLocationBookingProfileResponse(locationBookingProfile, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
