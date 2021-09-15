
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
 * This is a model class for RetrieveBusinessBookingProfileResponse type.
 */
public class RetrieveBusinessBookingProfileResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final BusinessBookingProfile businessBookingProfile;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  businessBookingProfile  BusinessBookingProfile value for businessBookingProfile.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveBusinessBookingProfileResponse(
            @JsonProperty("business_booking_profile") BusinessBookingProfile businessBookingProfile,
            @JsonProperty("errors") List<Error> errors) {
        this.businessBookingProfile = businessBookingProfile;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BusinessBookingProfile.
     * @return Returns the BusinessBookingProfile
     */
    @JsonGetter("business_booking_profile")
    public BusinessBookingProfile getBusinessBookingProfile() {
        return businessBookingProfile;
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
        return Objects.hash(businessBookingProfile, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveBusinessBookingProfileResponse)) {
            return false;
        }
        RetrieveBusinessBookingProfileResponse other = (RetrieveBusinessBookingProfileResponse) obj;
        return Objects.equals(businessBookingProfile, other.businessBookingProfile)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveBusinessBookingProfileResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveBusinessBookingProfileResponse [" + "businessBookingProfile="
                + businessBookingProfile + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link RetrieveBusinessBookingProfileResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveBusinessBookingProfileResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .businessBookingProfile(getBusinessBookingProfile())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveBusinessBookingProfileResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private BusinessBookingProfile businessBookingProfile;
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
         * Setter for businessBookingProfile.
         * @param  businessBookingProfile  BusinessBookingProfile value for businessBookingProfile.
         * @return Builder
         */
        public Builder businessBookingProfile(BusinessBookingProfile businessBookingProfile) {
            this.businessBookingProfile = businessBookingProfile;
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
         * Builds a new {@link RetrieveBusinessBookingProfileResponse} object using the set fields.
         * @return {@link RetrieveBusinessBookingProfileResponse}
         */
        public RetrieveBusinessBookingProfileResponse build() {
            RetrieveBusinessBookingProfileResponse model =
                    new RetrieveBusinessBookingProfileResponse(businessBookingProfile, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
