
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BusinessBookingProfile type.
 */
public class BusinessBookingProfile {
    private final OptionalNullable<String> sellerId;
    private final String createdAt;
    private final OptionalNullable<Boolean> bookingEnabled;
    private final String customerTimezoneChoice;
    private final String bookingPolicy;
    private final OptionalNullable<Boolean> allowUserCancel;
    private final BusinessAppointmentSettings businessAppointmentSettings;
    private final OptionalNullable<Boolean> supportSellerLevelWrites;

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
     * @param  supportSellerLevelWrites  Boolean value for supportSellerLevelWrites.
     */
    @JsonCreator
    public BusinessBookingProfile(
            @JsonProperty("seller_id") String sellerId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("booking_enabled") Boolean bookingEnabled,
            @JsonProperty("customer_timezone_choice") String customerTimezoneChoice,
            @JsonProperty("booking_policy") String bookingPolicy,
            @JsonProperty("allow_user_cancel") Boolean allowUserCancel,
            @JsonProperty("business_appointment_settings") BusinessAppointmentSettings businessAppointmentSettings,
            @JsonProperty("support_seller_level_writes") Boolean supportSellerLevelWrites) {
        this.sellerId = OptionalNullable.of(sellerId);
        this.createdAt = createdAt;
        this.bookingEnabled = OptionalNullable.of(bookingEnabled);
        this.customerTimezoneChoice = customerTimezoneChoice;
        this.bookingPolicy = bookingPolicy;
        this.allowUserCancel = OptionalNullable.of(allowUserCancel);
        this.businessAppointmentSettings = businessAppointmentSettings;
        this.supportSellerLevelWrites = OptionalNullable.of(supportSellerLevelWrites);
    }

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
     * @param  supportSellerLevelWrites  Boolean value for supportSellerLevelWrites.
     */

    protected BusinessBookingProfile(OptionalNullable<String> sellerId, String createdAt,
            OptionalNullable<Boolean> bookingEnabled, String customerTimezoneChoice,
            String bookingPolicy, OptionalNullable<Boolean> allowUserCancel,
            BusinessAppointmentSettings businessAppointmentSettings,
            OptionalNullable<Boolean> supportSellerLevelWrites) {
        this.sellerId = sellerId;
        this.createdAt = createdAt;
        this.bookingEnabled = bookingEnabled;
        this.customerTimezoneChoice = customerTimezoneChoice;
        this.bookingPolicy = bookingPolicy;
        this.allowUserCancel = allowUserCancel;
        this.businessAppointmentSettings = businessAppointmentSettings;
        this.supportSellerLevelWrites = supportSellerLevelWrites;
    }

    /**
     * Internal Getter for SellerId.
     * The ID of the seller, obtainable using the Merchants API.
     * @return Returns the Internal String
     */
    @JsonGetter("seller_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSellerId() {
        return this.sellerId;
    }

    /**
     * Getter for SellerId.
     * The ID of the seller, obtainable using the Merchants API.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSellerId() {
        return OptionalNullable.getFrom(sellerId);
    }

    /**
     * Getter for CreatedAt.
     * The RFC 3339 timestamp specifying the booking's creation time.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for BookingEnabled.
     * Indicates whether the seller is open for booking.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("booking_enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetBookingEnabled() {
        return this.bookingEnabled;
    }

    /**
     * Getter for BookingEnabled.
     * Indicates whether the seller is open for booking.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getBookingEnabled() {
        return OptionalNullable.getFrom(bookingEnabled);
    }

    /**
     * Getter for CustomerTimezoneChoice.
     * Choices of customer-facing time zone used for bookings.
     * @return Returns the String
     */
    @JsonGetter("customer_timezone_choice")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerTimezoneChoice() {
        return customerTimezoneChoice;
    }

    /**
     * Getter for BookingPolicy.
     * Policies for accepting bookings.
     * @return Returns the String
     */
    @JsonGetter("booking_policy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBookingPolicy() {
        return bookingPolicy;
    }

    /**
     * Internal Getter for AllowUserCancel.
     * Indicates whether customers can cancel or reschedule their own bookings (`true`) or not
     * (`false`).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("allow_user_cancel")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAllowUserCancel() {
        return this.allowUserCancel;
    }

    /**
     * Getter for AllowUserCancel.
     * Indicates whether customers can cancel or reschedule their own bookings (`true`) or not
     * (`false`).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAllowUserCancel() {
        return OptionalNullable.getFrom(allowUserCancel);
    }

    /**
     * Getter for BusinessAppointmentSettings.
     * The service appointment settings, including where and how the service is provided.
     * @return Returns the BusinessAppointmentSettings
     */
    @JsonGetter("business_appointment_settings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public BusinessAppointmentSettings getBusinessAppointmentSettings() {
        return businessAppointmentSettings;
    }

    /**
     * Internal Getter for SupportSellerLevelWrites.
     * Indicates whether the seller's subscription to Square Appointments supports creating,
     * updating or canceling an appointment through the API (`true`) or not (`false`) using seller
     * permission.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("support_seller_level_writes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSupportSellerLevelWrites() {
        return this.supportSellerLevelWrites;
    }

    /**
     * Getter for SupportSellerLevelWrites.
     * Indicates whether the seller's subscription to Square Appointments supports creating,
     * updating or canceling an appointment through the API (`true`) or not (`false`) using seller
     * permission.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSupportSellerLevelWrites() {
        return OptionalNullable.getFrom(supportSellerLevelWrites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId, createdAt, bookingEnabled, customerTimezoneChoice,
                bookingPolicy, allowUserCancel, businessAppointmentSettings,
                supportSellerLevelWrites);
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
            && Objects.equals(businessAppointmentSettings, other.businessAppointmentSettings)
            && Objects.equals(supportSellerLevelWrites, other.supportSellerLevelWrites);
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
                + ", supportSellerLevelWrites=" + supportSellerLevelWrites + "]";
    }

    /**
     * Builds a new {@link BusinessBookingProfile.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessBookingProfile.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .createdAt(getCreatedAt())
                .customerTimezoneChoice(getCustomerTimezoneChoice())
                .bookingPolicy(getBookingPolicy())
                .businessAppointmentSettings(getBusinessAppointmentSettings());
        builder.sellerId = internalGetSellerId();
        builder.bookingEnabled = internalGetBookingEnabled();
        builder.allowUserCancel = internalGetAllowUserCancel();
        builder.supportSellerLevelWrites = internalGetSupportSellerLevelWrites();
        return builder;
    }

    /**
     * Class to build instances of {@link BusinessBookingProfile}.
     */
    public static class Builder {
        private OptionalNullable<String> sellerId;
        private String createdAt;
        private OptionalNullable<Boolean> bookingEnabled;
        private String customerTimezoneChoice;
        private String bookingPolicy;
        private OptionalNullable<Boolean> allowUserCancel;
        private BusinessAppointmentSettings businessAppointmentSettings;
        private OptionalNullable<Boolean> supportSellerLevelWrites;



        /**
         * Setter for sellerId.
         * @param  sellerId  String value for sellerId.
         * @return Builder
         */
        public Builder sellerId(String sellerId) {
            this.sellerId = OptionalNullable.of(sellerId);
            return this;
        }

        /**
         * UnSetter for sellerId.
         * @return Builder
         */
        public Builder unsetSellerId() {
            sellerId = null;
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
            this.bookingEnabled = OptionalNullable.of(bookingEnabled);
            return this;
        }

        /**
         * UnSetter for bookingEnabled.
         * @return Builder
         */
        public Builder unsetBookingEnabled() {
            bookingEnabled = null;
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
            this.allowUserCancel = OptionalNullable.of(allowUserCancel);
            return this;
        }

        /**
         * UnSetter for allowUserCancel.
         * @return Builder
         */
        public Builder unsetAllowUserCancel() {
            allowUserCancel = null;
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
         * Setter for supportSellerLevelWrites.
         * @param  supportSellerLevelWrites  Boolean value for supportSellerLevelWrites.
         * @return Builder
         */
        public Builder supportSellerLevelWrites(Boolean supportSellerLevelWrites) {
            this.supportSellerLevelWrites = OptionalNullable.of(supportSellerLevelWrites);
            return this;
        }

        /**
         * UnSetter for supportSellerLevelWrites.
         * @return Builder
         */
        public Builder unsetSupportSellerLevelWrites() {
            supportSellerLevelWrites = null;
            return this;
        }

        /**
         * Builds a new {@link BusinessBookingProfile} object using the set fields.
         * @return {@link BusinessBookingProfile}
         */
        public BusinessBookingProfile build() {
            return new BusinessBookingProfile(sellerId, createdAt, bookingEnabled,
                    customerTimezoneChoice, bookingPolicy, allowUserCancel,
                    businessAppointmentSettings, supportSellerLevelWrites);
        }
    }
}
