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
 * This is a model class for ListLocationBookingProfilesResponse type.
 */
public class ListLocationBookingProfilesResponse {
    private HttpContext httpContext;
    private final List<LocationBookingProfile> locationBookingProfiles;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  locationBookingProfiles  List of LocationBookingProfile value for
     *         locationBookingProfiles.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListLocationBookingProfilesResponse(
            @JsonProperty("location_booking_profiles") List<LocationBookingProfile> locationBookingProfiles,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.locationBookingProfiles = locationBookingProfiles;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for LocationBookingProfiles.
     * The list of a seller's location booking profiles.
     * @return Returns the List of LocationBookingProfile
     */
    @JsonGetter("location_booking_profiles")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<LocationBookingProfile> getLocationBookingProfiles() {
        return locationBookingProfiles;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in the subsequent request to get the next page of the
     * results. Stop retrieving the next page of the results when the cursor is not set.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
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
        return Objects.hash(locationBookingProfiles, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListLocationBookingProfilesResponse)) {
            return false;
        }
        ListLocationBookingProfilesResponse other = (ListLocationBookingProfilesResponse) obj;
        return Objects.equals(locationBookingProfiles, other.locationBookingProfiles)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListLocationBookingProfilesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListLocationBookingProfilesResponse [" + "locationBookingProfiles=" + locationBookingProfiles
                + ", cursor=" + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListLocationBookingProfilesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLocationBookingProfilesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationBookingProfiles(getLocationBookingProfiles())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListLocationBookingProfilesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<LocationBookingProfile> locationBookingProfiles;
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
         * Setter for locationBookingProfiles.
         * @param  locationBookingProfiles  List of LocationBookingProfile value for
         *         locationBookingProfiles.
         * @return Builder
         */
        public Builder locationBookingProfiles(List<LocationBookingProfile> locationBookingProfiles) {
            this.locationBookingProfiles = locationBookingProfiles;
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
         * Builds a new {@link ListLocationBookingProfilesResponse} object using the set fields.
         * @return {@link ListLocationBookingProfilesResponse}
         */
        public ListLocationBookingProfilesResponse build() {
            ListLocationBookingProfilesResponse model =
                    new ListLocationBookingProfilesResponse(locationBookingProfiles, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
