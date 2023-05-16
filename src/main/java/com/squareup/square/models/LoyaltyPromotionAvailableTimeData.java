
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotionAvailableTimeData type.
 */
public class LoyaltyPromotionAvailableTimeData {
    private final String startDate;
    private final String endDate;
    private final List<String> timePeriods;

    /**
     * Initialization constructor.
     * @param  timePeriods  List of String value for timePeriods.
     * @param  startDate  String value for startDate.
     * @param  endDate  String value for endDate.
     */
    @JsonCreator
    public LoyaltyPromotionAvailableTimeData(
            @JsonProperty("time_periods") List<String> timePeriods,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.timePeriods = timePeriods;
    }

    /**
     * Getter for StartDate.
     * The date that the promotion starts, in `YYYY-MM-DD` format. Square populates this field based
     * on the provided `time_periods`.
     * @return Returns the String
     */
    @JsonGetter("start_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStartDate() {
        return startDate;
    }

    /**
     * Getter for EndDate.
     * The date that the promotion ends, in `YYYY-MM-DD` format. Square populates this field based
     * on the provided `time_periods`. If an end date is not specified, an `ACTIVE` promotion
     * remains available until it is canceled.
     * @return Returns the String
     */
    @JsonGetter("end_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndDate() {
        return endDate;
    }

    /**
     * Getter for TimePeriods.
     * A list of [iCalendar (RFC 5545) events](https://tools.ietf.org/html/rfc5545#section-3.6.1)
     * (`VEVENT`). Each event represents an available time period per day or days of the week. A day
     * can have a maximum of one available time period. Only `DTSTART`, `DURATION`, and `RRULE` are
     * supported. `DTSTART` and `DURATION` are required and timestamps must be in local (unzoned)
     * time format. Include `RRULE` to specify recurring promotions, an end date (using the `UNTIL`
     * keyword), or both. For more information, see [Available
     * time](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#available-time).
     * Note that `BEGIN:VEVENT` and `END:VEVENT` are optional in a `CreateLoyaltyPromotion` request
     * but are always included in the response.
     * @return Returns the List of String
     */
    @JsonGetter("time_periods")
    public List<String> getTimePeriods() {
        return timePeriods;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, timePeriods);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyPromotionAvailableTimeData)) {
            return false;
        }
        LoyaltyPromotionAvailableTimeData other = (LoyaltyPromotionAvailableTimeData) obj;
        return Objects.equals(startDate, other.startDate)
            && Objects.equals(endDate, other.endDate)
            && Objects.equals(timePeriods, other.timePeriods);
    }

    /**
     * Converts this LoyaltyPromotionAvailableTimeData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotionAvailableTimeData [" + "timePeriods=" + timePeriods + ", startDate="
                + startDate + ", endDate=" + endDate + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotionAvailableTimeData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotionAvailableTimeData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(timePeriods)
                .startDate(getStartDate())
                .endDate(getEndDate());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotionAvailableTimeData}.
     */
    public static class Builder {
        private List<String> timePeriods;
        private String startDate;
        private String endDate;

        /**
         * Initialization constructor.
         * @param  timePeriods  List of String value for timePeriods.
         */
        public Builder(List<String> timePeriods) {
            this.timePeriods = timePeriods;
        }

        /**
         * Setter for timePeriods.
         * @param  timePeriods  List of String value for timePeriods.
         * @return Builder
         */
        public Builder timePeriods(List<String> timePeriods) {
            this.timePeriods = timePeriods;
            return this;
        }

        /**
         * Setter for startDate.
         * @param  startDate  String value for startDate.
         * @return Builder
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * Setter for endDate.
         * @param  endDate  String value for endDate.
         * @return Builder
         */
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotionAvailableTimeData} object using the set fields.
         * @return {@link LoyaltyPromotionAvailableTimeData}
         */
        public LoyaltyPromotionAvailableTimeData build() {
            return new LoyaltyPromotionAvailableTimeData(timePeriods, startDate, endDate);
        }
    }
}
