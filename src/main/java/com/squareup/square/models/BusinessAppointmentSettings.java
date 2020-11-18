
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BusinessAppointmentSettings type.
 */
public class BusinessAppointmentSettings {
    private final List<String> locationTypes;
    private final String alignmentTime;
    private final Integer minBookingLeadTimeSeconds;
    private final Integer maxBookingLeadTimeSeconds;
    private final Boolean anyTeamMemberBookingEnabled;
    private final Boolean multipleServiceBookingEnabled;
    private final String maxAppointmentsPerDayLimitType;
    private final Integer maxAppointmentsPerDayLimit;
    private final Integer cancellationWindowSeconds;
    private final Money cancellationFeeMoney;
    private final String cancellationPolicy;
    private final String cancellationPolicyText;
    private final Boolean skipBookingFlowStaffSelection;

    /**
     * Initialization constructor.
     * @param locationTypes List of String value for locationTypes.
     * @param alignmentTime String value for alignmentTime.
     * @param minBookingLeadTimeSeconds Integer value for minBookingLeadTimeSeconds.
     * @param maxBookingLeadTimeSeconds Integer value for maxBookingLeadTimeSeconds.
     * @param anyTeamMemberBookingEnabled Boolean value for anyTeamMemberBookingEnabled.
     * @param multipleServiceBookingEnabled Boolean value for multipleServiceBookingEnabled.
     * @param maxAppointmentsPerDayLimitType String value for maxAppointmentsPerDayLimitType.
     * @param maxAppointmentsPerDayLimit Integer value for maxAppointmentsPerDayLimit.
     * @param cancellationWindowSeconds Integer value for cancellationWindowSeconds.
     * @param cancellationFeeMoney Money value for cancellationFeeMoney.
     * @param cancellationPolicy String value for cancellationPolicy.
     * @param cancellationPolicyText String value for cancellationPolicyText.
     * @param skipBookingFlowStaffSelection Boolean value for skipBookingFlowStaffSelection.
     */
    @JsonCreator
    public BusinessAppointmentSettings(
            @JsonProperty("location_types") List<String> locationTypes,
            @JsonProperty("alignment_time") String alignmentTime,
            @JsonProperty("min_booking_lead_time_seconds") Integer minBookingLeadTimeSeconds,
            @JsonProperty("max_booking_lead_time_seconds") Integer maxBookingLeadTimeSeconds,
            @JsonProperty("any_team_member_booking_enabled") Boolean anyTeamMemberBookingEnabled,
            @JsonProperty("multiple_service_booking_enabled") Boolean multipleServiceBookingEnabled,
            @JsonProperty("max_appointments_per_day_limit_type") String maxAppointmentsPerDayLimitType,
            @JsonProperty("max_appointments_per_day_limit") Integer maxAppointmentsPerDayLimit,
            @JsonProperty("cancellation_window_seconds") Integer cancellationWindowSeconds,
            @JsonProperty("cancellation_fee_money") Money cancellationFeeMoney,
            @JsonProperty("cancellation_policy") String cancellationPolicy,
            @JsonProperty("cancellation_policy_text") String cancellationPolicyText,
            @JsonProperty("skip_booking_flow_staff_selection") Boolean skipBookingFlowStaffSelection) {
        this.locationTypes = locationTypes;
        this.alignmentTime = alignmentTime;
        this.minBookingLeadTimeSeconds = minBookingLeadTimeSeconds;
        this.maxBookingLeadTimeSeconds = maxBookingLeadTimeSeconds;
        this.anyTeamMemberBookingEnabled = anyTeamMemberBookingEnabled;
        this.multipleServiceBookingEnabled = multipleServiceBookingEnabled;
        this.maxAppointmentsPerDayLimitType = maxAppointmentsPerDayLimitType;
        this.maxAppointmentsPerDayLimit = maxAppointmentsPerDayLimit;
        this.cancellationWindowSeconds = cancellationWindowSeconds;
        this.cancellationFeeMoney = cancellationFeeMoney;
        this.cancellationPolicy = cancellationPolicy;
        this.cancellationPolicyText = cancellationPolicyText;
        this.skipBookingFlowStaffSelection = skipBookingFlowStaffSelection;
    }

    /**
     * Getter for LocationTypes.
     * Types of the location allowed for bookings. See
     * [BookingLocationType](#type-bookinglocationtype) for possible values
     * @return Returns the List of String
     */
    @JsonGetter("location_types")
    public List<String> getLocationTypes() {
        return this.locationTypes;
    }

    /**
     * Getter for AlignmentTime.
     * Time units of a service duration for bookings.
     * @return Returns the String
     */
    @JsonGetter("alignment_time")
    public String getAlignmentTime() {
        return this.alignmentTime;
    }

    /**
     * Getter for MinBookingLeadTimeSeconds.
     * The minimum lead time in seconds before a service can be booked. Bookings must be created at
     * least this far ahead of the booking's starting time.
     * @return Returns the Integer
     */
    @JsonGetter("min_booking_lead_time_seconds")
    public Integer getMinBookingLeadTimeSeconds() {
        return this.minBookingLeadTimeSeconds;
    }

    /**
     * Getter for MaxBookingLeadTimeSeconds.
     * The maximum lead time in seconds before a service can be booked. Bookings must be created at
     * most this far ahead of the booking's starting time.
     * @return Returns the Integer
     */
    @JsonGetter("max_booking_lead_time_seconds")
    public Integer getMaxBookingLeadTimeSeconds() {
        return this.maxBookingLeadTimeSeconds;
    }

    /**
     * Getter for AnyTeamMemberBookingEnabled.
     * Indicates whether a customer can choose from all available time slots and have a staff member
     * assigned automatically (`true`) or not (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("any_team_member_booking_enabled")
    public Boolean getAnyTeamMemberBookingEnabled() {
        return this.anyTeamMemberBookingEnabled;
    }

    /**
     * Getter for MultipleServiceBookingEnabled.
     * Indicates whether a customer can book multiple services in a single online booking.
     * @return Returns the Boolean
     */
    @JsonGetter("multiple_service_booking_enabled")
    public Boolean getMultipleServiceBookingEnabled() {
        return this.multipleServiceBookingEnabled;
    }

    /**
     * Getter for MaxAppointmentsPerDayLimitType.
     * Types of daily appointment limits.
     * @return Returns the String
     */
    @JsonGetter("max_appointments_per_day_limit_type")
    public String getMaxAppointmentsPerDayLimitType() {
        return this.maxAppointmentsPerDayLimitType;
    }

    /**
     * Getter for MaxAppointmentsPerDayLimit.
     * The maximum number of daily appointments per team member or per location.
     * @return Returns the Integer
     */
    @JsonGetter("max_appointments_per_day_limit")
    public Integer getMaxAppointmentsPerDayLimit() {
        return this.maxAppointmentsPerDayLimit;
    }

    /**
     * Getter for CancellationWindowSeconds.
     * The cut-off time in seconds for allowing clients to cancel or reschedule an appointment.
     * @return Returns the Integer
     */
    @JsonGetter("cancellation_window_seconds")
    public Integer getCancellationWindowSeconds() {
        return this.cancellationWindowSeconds;
    }

    /**
     * Getter for CancellationFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("cancellation_fee_money")
    public Money getCancellationFeeMoney() {
        return this.cancellationFeeMoney;
    }

    /**
     * Getter for CancellationPolicy.
     * The category of the seller’s cancellation policy.
     * @return Returns the String
     */
    @JsonGetter("cancellation_policy")
    public String getCancellationPolicy() {
        return this.cancellationPolicy;
    }

    /**
     * Getter for CancellationPolicyText.
     * The free-form text of the seller's cancellation policy.
     * @return Returns the String
     */
    @JsonGetter("cancellation_policy_text")
    public String getCancellationPolicyText() {
        return this.cancellationPolicyText;
    }

    /**
     * Getter for SkipBookingFlowStaffSelection.
     * Indicates whether customers has an assigned staff member (`true`) or can select s staff
     * member of their choice (`false`).
     * @return Returns the Boolean
     */
    @JsonGetter("skip_booking_flow_staff_selection")
    public Boolean getSkipBookingFlowStaffSelection() {
        return this.skipBookingFlowStaffSelection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationTypes, alignmentTime, minBookingLeadTimeSeconds,
                maxBookingLeadTimeSeconds, anyTeamMemberBookingEnabled,
                multipleServiceBookingEnabled, maxAppointmentsPerDayLimitType,
                maxAppointmentsPerDayLimit, cancellationWindowSeconds, cancellationFeeMoney,
                cancellationPolicy, cancellationPolicyText, skipBookingFlowStaffSelection);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessAppointmentSettings)) {
            return false;
        }
        BusinessAppointmentSettings other = (BusinessAppointmentSettings) obj;
        return Objects.equals(locationTypes, other.locationTypes)
            && Objects.equals(alignmentTime, other.alignmentTime)
            && Objects.equals(minBookingLeadTimeSeconds, other.minBookingLeadTimeSeconds)
            && Objects.equals(maxBookingLeadTimeSeconds, other.maxBookingLeadTimeSeconds)
            && Objects.equals(anyTeamMemberBookingEnabled, other.anyTeamMemberBookingEnabled)
            && Objects.equals(multipleServiceBookingEnabled, other.multipleServiceBookingEnabled)
            && Objects.equals(maxAppointmentsPerDayLimitType,
                    other.maxAppointmentsPerDayLimitType)
            && Objects.equals(maxAppointmentsPerDayLimit, other.maxAppointmentsPerDayLimit)
            && Objects.equals(cancellationWindowSeconds, other.cancellationWindowSeconds)
            && Objects.equals(cancellationFeeMoney, other.cancellationFeeMoney)
            && Objects.equals(cancellationPolicy, other.cancellationPolicy)
            && Objects.equals(cancellationPolicyText, other.cancellationPolicyText)
            && Objects.equals(skipBookingFlowStaffSelection, other.skipBookingFlowStaffSelection);
    }

    /**
     * Converts this BusinessAppointmentSettings into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BusinessAppointmentSettings [" + "locationTypes=" + locationTypes
                + ", alignmentTime=" + alignmentTime + ", minBookingLeadTimeSeconds="
                + minBookingLeadTimeSeconds + ", maxBookingLeadTimeSeconds="
                + maxBookingLeadTimeSeconds + ", anyTeamMemberBookingEnabled="
                + anyTeamMemberBookingEnabled + ", multipleServiceBookingEnabled="
                + multipleServiceBookingEnabled + ", maxAppointmentsPerDayLimitType="
                + maxAppointmentsPerDayLimitType + ", maxAppointmentsPerDayLimit="
                + maxAppointmentsPerDayLimit + ", cancellationWindowSeconds="
                + cancellationWindowSeconds + ", cancellationFeeMoney=" + cancellationFeeMoney
                + ", cancellationPolicy=" + cancellationPolicy + ", cancellationPolicyText="
                + cancellationPolicyText + ", skipBookingFlowStaffSelection="
                + skipBookingFlowStaffSelection + "]";
    }

    /**
     * Builds a new {@link BusinessAppointmentSettings.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessAppointmentSettings.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationTypes(getLocationTypes())
                .alignmentTime(getAlignmentTime())
                .minBookingLeadTimeSeconds(getMinBookingLeadTimeSeconds())
                .maxBookingLeadTimeSeconds(getMaxBookingLeadTimeSeconds())
                .anyTeamMemberBookingEnabled(getAnyTeamMemberBookingEnabled())
                .multipleServiceBookingEnabled(getMultipleServiceBookingEnabled())
                .maxAppointmentsPerDayLimitType(getMaxAppointmentsPerDayLimitType())
                .maxAppointmentsPerDayLimit(getMaxAppointmentsPerDayLimit())
                .cancellationWindowSeconds(getCancellationWindowSeconds())
                .cancellationFeeMoney(getCancellationFeeMoney())
                .cancellationPolicy(getCancellationPolicy())
                .cancellationPolicyText(getCancellationPolicyText())
                .skipBookingFlowStaffSelection(getSkipBookingFlowStaffSelection());
        return builder;
    }

    /**
     * Class to build instances of {@link BusinessAppointmentSettings}.
     */
    public static class Builder {
        private List<String> locationTypes;
        private String alignmentTime;
        private Integer minBookingLeadTimeSeconds;
        private Integer maxBookingLeadTimeSeconds;
        private Boolean anyTeamMemberBookingEnabled;
        private Boolean multipleServiceBookingEnabled;
        private String maxAppointmentsPerDayLimitType;
        private Integer maxAppointmentsPerDayLimit;
        private Integer cancellationWindowSeconds;
        private Money cancellationFeeMoney;
        private String cancellationPolicy;
        private String cancellationPolicyText;
        private Boolean skipBookingFlowStaffSelection;



        /**
         * Setter for locationTypes.
         * @param locationTypes List of String value for locationTypes.
         * @return Builder
         */
        public Builder locationTypes(List<String> locationTypes) {
            this.locationTypes = locationTypes;
            return this;
        }

        /**
         * Setter for alignmentTime.
         * @param alignmentTime String value for alignmentTime.
         * @return Builder
         */
        public Builder alignmentTime(String alignmentTime) {
            this.alignmentTime = alignmentTime;
            return this;
        }

        /**
         * Setter for minBookingLeadTimeSeconds.
         * @param minBookingLeadTimeSeconds Integer value for minBookingLeadTimeSeconds.
         * @return Builder
         */
        public Builder minBookingLeadTimeSeconds(Integer minBookingLeadTimeSeconds) {
            this.minBookingLeadTimeSeconds = minBookingLeadTimeSeconds;
            return this;
        }

        /**
         * Setter for maxBookingLeadTimeSeconds.
         * @param maxBookingLeadTimeSeconds Integer value for maxBookingLeadTimeSeconds.
         * @return Builder
         */
        public Builder maxBookingLeadTimeSeconds(Integer maxBookingLeadTimeSeconds) {
            this.maxBookingLeadTimeSeconds = maxBookingLeadTimeSeconds;
            return this;
        }

        /**
         * Setter for anyTeamMemberBookingEnabled.
         * @param anyTeamMemberBookingEnabled Boolean value for anyTeamMemberBookingEnabled.
         * @return Builder
         */
        public Builder anyTeamMemberBookingEnabled(Boolean anyTeamMemberBookingEnabled) {
            this.anyTeamMemberBookingEnabled = anyTeamMemberBookingEnabled;
            return this;
        }

        /**
         * Setter for multipleServiceBookingEnabled.
         * @param multipleServiceBookingEnabled Boolean value for multipleServiceBookingEnabled.
         * @return Builder
         */
        public Builder multipleServiceBookingEnabled(Boolean multipleServiceBookingEnabled) {
            this.multipleServiceBookingEnabled = multipleServiceBookingEnabled;
            return this;
        }

        /**
         * Setter for maxAppointmentsPerDayLimitType.
         * @param maxAppointmentsPerDayLimitType String value for maxAppointmentsPerDayLimitType.
         * @return Builder
         */
        public Builder maxAppointmentsPerDayLimitType(String maxAppointmentsPerDayLimitType) {
            this.maxAppointmentsPerDayLimitType = maxAppointmentsPerDayLimitType;
            return this;
        }

        /**
         * Setter for maxAppointmentsPerDayLimit.
         * @param maxAppointmentsPerDayLimit Integer value for maxAppointmentsPerDayLimit.
         * @return Builder
         */
        public Builder maxAppointmentsPerDayLimit(Integer maxAppointmentsPerDayLimit) {
            this.maxAppointmentsPerDayLimit = maxAppointmentsPerDayLimit;
            return this;
        }

        /**
         * Setter for cancellationWindowSeconds.
         * @param cancellationWindowSeconds Integer value for cancellationWindowSeconds.
         * @return Builder
         */
        public Builder cancellationWindowSeconds(Integer cancellationWindowSeconds) {
            this.cancellationWindowSeconds = cancellationWindowSeconds;
            return this;
        }

        /**
         * Setter for cancellationFeeMoney.
         * @param cancellationFeeMoney Money value for cancellationFeeMoney.
         * @return Builder
         */
        public Builder cancellationFeeMoney(Money cancellationFeeMoney) {
            this.cancellationFeeMoney = cancellationFeeMoney;
            return this;
        }

        /**
         * Setter for cancellationPolicy.
         * @param cancellationPolicy String value for cancellationPolicy.
         * @return Builder
         */
        public Builder cancellationPolicy(String cancellationPolicy) {
            this.cancellationPolicy = cancellationPolicy;
            return this;
        }

        /**
         * Setter for cancellationPolicyText.
         * @param cancellationPolicyText String value for cancellationPolicyText.
         * @return Builder
         */
        public Builder cancellationPolicyText(String cancellationPolicyText) {
            this.cancellationPolicyText = cancellationPolicyText;
            return this;
        }

        /**
         * Setter for skipBookingFlowStaffSelection.
         * @param skipBookingFlowStaffSelection Boolean value for skipBookingFlowStaffSelection.
         * @return Builder
         */
        public Builder skipBookingFlowStaffSelection(Boolean skipBookingFlowStaffSelection) {
            this.skipBookingFlowStaffSelection = skipBookingFlowStaffSelection;
            return this;
        }

        /**
         * Builds a new {@link BusinessAppointmentSettings} object using the set fields.
         * @return {@link BusinessAppointmentSettings}
         */
        public BusinessAppointmentSettings build() {
            return new BusinessAppointmentSettings(locationTypes, alignmentTime,
                    minBookingLeadTimeSeconds, maxBookingLeadTimeSeconds,
                    anyTeamMemberBookingEnabled, multipleServiceBookingEnabled,
                    maxAppointmentsPerDayLimitType, maxAppointmentsPerDayLimit,
                    cancellationWindowSeconds, cancellationFeeMoney, cancellationPolicy,
                    cancellationPolicyText, skipBookingFlowStaffSelection);
        }
    }
}
