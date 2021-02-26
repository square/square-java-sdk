
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BusinessBookingProfile type.
 */
public class BusinessBookingProfile {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sellerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean bookingEnabled;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerTimezoneChoice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bookingPolicy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean allowUserCancel;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final BusinessAppointmentSettings businessAppointmentSettings;

    /**
     * Initialization constructor.
     * @param  sellerId  String value for sellerId.
     * @param  createdAt  String value for createdAt.
     * @param  bookingEnabled  Boolean value for bookingEnabled.
     * @param  customerTimezoneChoice  String value for customerTimezoneChoice.
     * @param  bookingPolicy  String value for bookingPolicy.
     * @param  allowUserCancel  Boolean value for allowUserCancel.
     * @param  businessAppointmentSettings  BusinessAppointmentSettings value for
     *         businessAppointmentSettings.
     */
    @JsonCreator
    public BusinessBookingProfile(
            @JsonProperty("seller_id") String sellerId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("booking_enabled") Boolean bookingEnabled,
            @JsonProperty("customer_timezone_choice") String customerTimezoneChoice,
            @JsonProperty("booking_policy") String bookingPolicy,
            @JsonProperty("allow_user_cancel") Boolean allowUserCancel,
            @JsonProperty("business_appointment_settings") BusinessAppointmentSettings businessAppointmentSettings) {
        this.sellerId = sellerId;
        this.createdAt = createdAt;
        this.bookingEnabled = bookingEnabled;
        this.customerTimezoneChoice = customerTimezoneChoice;
        this.bookingPolicy = bookingPolicy;
        this.allowUserCancel = allowUserCancel;
        this.businessAppointmentSettings = businessAppointmentSettings;
    }

    /**
     * Getter for SellerId.
     * The ID of the seller, obtainable using the Merchants API.
     * @return Returns the String
     */
    @JsonGetter("seller_id")
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Getter for CreatedAt.
     * The RFC-3339 timestamp specifying the booking's creation time.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for BookingEnabled.
     * Indicates whether the seller is open for booking.
     * @return Returns the Boolean
     */
    @JsonGetter("booking_enabled")
    public Boolean getBookingEnabled() {
        return bookingEnabled;
    }

    /**
     * Getter for CustomerTimezoneChoice.
     * Choices of customer-facing time zone used for bookings.
     * @return Returns the String
     */
    @JsonGetter("customer_timezone_choice")
    public String getCustomerTimezoneChoice() {
        return customerTimezoneChoice;
    }

    /**
     * Getter for BookingPolicy.
     * Policies for accepting bookings.
     * @return Returns the String
     */
    @JsonGetter("booking_policy")
    public String getBookingPolicy() {
        return bookingPolicy;
    }

    /**
     * Getter for AllowUserCancel.
     * Indicates whether customers can cancel or reschedule their own bookings (`true`) or not
     * (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("allow_user_cancel")
    public Boolean getAllowUserCancel() {
        return allowUserCancel;
    }

    /**
     * Getter for BusinessAppointmentSettings.
     * The service appointment settings, including where and how the service is provided.
     * @return Returns the BusinessAppointmentSettings
     */
    @JsonGetter("business_appointment_settings")
    public BusinessAppointmentSettings getBusinessAppointmentSettings() {
        return businessAppointmentSettings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId, createdAt, bookingEnabled, customerTimezoneChoice,
                bookingPolicy, allowUserCancel, businessAppointmentSettings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessBookingProfile)) {
            return false;
        }
        BusinessBookingProfile other = (BusinessBookingProfile) obj;
        return Objects.equals(sellerId, other.sellerId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(bookingEnabled, other.bookingEnabled)
            && Objects.equals(customerTimezoneChoice, other.customerTimezoneChoice)
            && Objects.equals(bookingPolicy, other.bookingPolicy)
            && Objects.equals(allowUserCancel, other.allowUserCancel)
            && Objects.equals(businessAppointmentSettings, other.businessAppointmentSettings);
    }

    /**
     * Converts this BusinessBookingProfile into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BusinessBookingProfile [" + "sellerId=" + sellerId + ", createdAt=" + createdAt
                + ", bookingEnabled=" + bookingEnabled + ", customerTimezoneChoice="
                + customerTimezoneChoice + ", bookingPolicy=" + bookingPolicy + ", allowUserCancel="
                + allowUserCancel + ", businessAppointmentSettings=" + businessAppointmentSettings
                + "]";
    }

    /**
     * Builds a new {@link BusinessBookingProfile.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessBookingProfile.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .sellerId(getSellerId())
                .createdAt(getCreatedAt())
                .bookingEnabled(getBookingEnabled())
                .customerTimezoneChoice(getCustomerTimezoneChoice())
                .bookingPolicy(getBookingPolicy())
                .allowUserCancel(getAllowUserCancel())
                .businessAppointmentSettings(getBusinessAppointmentSettings());
        return builder;
    }

    /**
     * Class to build instances of {@link BusinessBookingProfile}.
     */
    public static class Builder {
        private String sellerId;
        private String createdAt;
        private Boolean bookingEnabled;
        private String customerTimezoneChoice;
        private String bookingPolicy;
        private Boolean allowUserCancel;
        private BusinessAppointmentSettings businessAppointmentSettings;



        /**
         * Setter for sellerId.
         * @param  sellerId  String value for sellerId.
         * @return Builder
         */
        public Builder sellerId(String sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for bookingEnabled.
         * @param  bookingEnabled  Boolean value for bookingEnabled.
         * @return Builder
         */
        public Builder bookingEnabled(Boolean bookingEnabled) {
            this.bookingEnabled = bookingEnabled;
            return this;
        }

        /**
         * Setter for customerTimezoneChoice.
         * @param  customerTimezoneChoice  String value for customerTimezoneChoice.
         * @return Builder
         */
        public Builder customerTimezoneChoice(String customerTimezoneChoice) {
            this.customerTimezoneChoice = customerTimezoneChoice;
            return this;
        }

        /**
         * Setter for bookingPolicy.
         * @param  bookingPolicy  String value for bookingPolicy.
         * @return Builder
         */
        public Builder bookingPolicy(String bookingPolicy) {
            this.bookingPolicy = bookingPolicy;
            return this;
        }

        /**
         * Setter for allowUserCancel.
         * @param  allowUserCancel  Boolean value for allowUserCancel.
         * @return Builder
         */
        public Builder allowUserCancel(Boolean allowUserCancel) {
            this.allowUserCancel = allowUserCancel;
            return this;
        }

        /**
         * Setter for businessAppointmentSettings.
         * @param  businessAppointmentSettings  BusinessAppointmentSettings value for
         *         businessAppointmentSettings.
         * @return Builder
         */
        public Builder businessAppointmentSettings(
                BusinessAppointmentSettings businessAppointmentSettings) {
            this.businessAppointmentSettings = businessAppointmentSettings;
            return this;
        }

        /**
         * Builds a new {@link BusinessBookingProfile} object using the set fields.
         * @return {@link BusinessBookingProfile}
         */
        public BusinessBookingProfile build() {
            return new BusinessBookingProfile(sellerId, createdAt, bookingEnabled,
                    customerTimezoneChoice, bookingPolicy, allowUserCancel,
                    businessAppointmentSettings);
        }
    }
}
