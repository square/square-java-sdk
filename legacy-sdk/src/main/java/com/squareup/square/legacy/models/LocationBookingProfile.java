package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for LocationBookingProfile type.
 */
public class LocationBookingProfile {
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> bookingSiteUrl;
    private final OptionalNullable<Boolean> onlineBookingEnabled;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  bookingSiteUrl  String value for bookingSiteUrl.
     * @param  onlineBookingEnabled  Boolean value for onlineBookingEnabled.
     */
    @JsonCreator
    public LocationBookingProfile(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("booking_site_url") String bookingSiteUrl,
            @JsonProperty("online_booking_enabled") Boolean onlineBookingEnabled) {
        this.locationId = OptionalNullable.of(locationId);
        this.bookingSiteUrl = OptionalNullable.of(bookingSiteUrl);
        this.onlineBookingEnabled = OptionalNullable.of(onlineBookingEnabled);
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  bookingSiteUrl  String value for bookingSiteUrl.
     * @param  onlineBookingEnabled  Boolean value for onlineBookingEnabled.
     */
    protected LocationBookingProfile(
            OptionalNullable<String> locationId,
            OptionalNullable<String> bookingSiteUrl,
            OptionalNullable<Boolean> onlineBookingEnabled) {
        this.locationId = locationId;
        this.bookingSiteUrl = bookingSiteUrl;
        this.onlineBookingEnabled = onlineBookingEnabled;
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the [location](entity:Location).
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the [location](entity:Location).
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for BookingSiteUrl.
     * Url for the online booking site for this location.
     * @return Returns the Internal String
     */
    @JsonGetter("booking_site_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBookingSiteUrl() {
        return this.bookingSiteUrl;
    }

    /**
     * Getter for BookingSiteUrl.
     * Url for the online booking site for this location.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBookingSiteUrl() {
        return OptionalNullable.getFrom(bookingSiteUrl);
    }

    /**
     * Internal Getter for OnlineBookingEnabled.
     * Indicates whether the location is enabled for online booking.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("online_booking_enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetOnlineBookingEnabled() {
        return this.onlineBookingEnabled;
    }

    /**
     * Getter for OnlineBookingEnabled.
     * Indicates whether the location is enabled for online booking.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getOnlineBookingEnabled() {
        return OptionalNullable.getFrom(onlineBookingEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, bookingSiteUrl, onlineBookingEnabled);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationBookingProfile)) {
            return false;
        }
        LocationBookingProfile other = (LocationBookingProfile) obj;
        return Objects.equals(locationId, other.locationId)
                && Objects.equals(bookingSiteUrl, other.bookingSiteUrl)
                && Objects.equals(onlineBookingEnabled, other.onlineBookingEnabled);
    }

    /**
     * Converts this LocationBookingProfile into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LocationBookingProfile [" + "locationId=" + locationId + ", bookingSiteUrl=" + bookingSiteUrl
                + ", onlineBookingEnabled=" + onlineBookingEnabled + "]";
    }

    /**
     * Builds a new {@link LocationBookingProfile.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LocationBookingProfile.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.locationId = internalGetLocationId();
        builder.bookingSiteUrl = internalGetBookingSiteUrl();
        builder.onlineBookingEnabled = internalGetOnlineBookingEnabled();
        return builder;
    }

    /**
     * Class to build instances of {@link LocationBookingProfile}.
     */
    public static class Builder {
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> bookingSiteUrl;
        private OptionalNullable<Boolean> onlineBookingEnabled;

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for bookingSiteUrl.
         * @param  bookingSiteUrl  String value for bookingSiteUrl.
         * @return Builder
         */
        public Builder bookingSiteUrl(String bookingSiteUrl) {
            this.bookingSiteUrl = OptionalNullable.of(bookingSiteUrl);
            return this;
        }

        /**
         * UnSetter for bookingSiteUrl.
         * @return Builder
         */
        public Builder unsetBookingSiteUrl() {
            bookingSiteUrl = null;
            return this;
        }

        /**
         * Setter for onlineBookingEnabled.
         * @param  onlineBookingEnabled  Boolean value for onlineBookingEnabled.
         * @return Builder
         */
        public Builder onlineBookingEnabled(Boolean onlineBookingEnabled) {
            this.onlineBookingEnabled = OptionalNullable.of(onlineBookingEnabled);
            return this;
        }

        /**
         * UnSetter for onlineBookingEnabled.
         * @return Builder
         */
        public Builder unsetOnlineBookingEnabled() {
            onlineBookingEnabled = null;
            return this;
        }

        /**
         * Builds a new {@link LocationBookingProfile} object using the set fields.
         * @return {@link LocationBookingProfile}
         */
        public LocationBookingProfile build() {
            return new LocationBookingProfile(locationId, bookingSiteUrl, onlineBookingEnabled);
        }
    }
}
