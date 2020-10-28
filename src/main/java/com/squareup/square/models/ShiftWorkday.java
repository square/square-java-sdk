
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ShiftWorkday type.
 */
public class ShiftWorkday {
    private final DateRange dateRange;
    private final String matchShiftsBy;
    private final String defaultTimezone;

    /**
     * Initialization constructor.
     * @param dateRange DateRange value for dateRange.
     * @param matchShiftsBy String value for matchShiftsBy.
     * @param defaultTimezone String value for defaultTimezone.
     */
    @JsonCreator
    public ShiftWorkday(
            @JsonProperty("date_range") DateRange dateRange,
            @JsonProperty("match_shifts_by") String matchShiftsBy,
            @JsonProperty("default_timezone") String defaultTimezone) {
        this.dateRange = dateRange;
        this.matchShiftsBy = matchShiftsBy;
        this.defaultTimezone = defaultTimezone;
    }

    /**
     * Getter for DateRange.
     * A range defined by two dates. Used for filtering a query for Connect v2 objects that have
     * date properties.
     * @return Returns the DateRange
     */
    @JsonGetter("date_range")
    public DateRange getDateRange() {
        return this.dateRange;
    }

    /**
     * Getter for MatchShiftsBy.
     * Defines the logic used to apply a workday filter.
     * @return Returns the String
     */
    @JsonGetter("match_shifts_by")
    public String getMatchShiftsBy() {
        return this.matchShiftsBy;
    }

    /**
     * Getter for DefaultTimezone.
     * Location-specific timezones convert workdays to datetime filters. Every location included in
     * the query must have a timezone, or this field must be provided as a fallback. Format: the
     * IANA timezone database identifier for the relevant timezone.
     * @return Returns the String
     */
    @JsonGetter("default_timezone")
    public String getDefaultTimezone() {
        return this.defaultTimezone;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(dateRange, matchShiftsBy, defaultTimezone);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShiftWorkday)) {
            return false;
        }
        ShiftWorkday other = (ShiftWorkday) obj;
        return Objects.equals(dateRange, other.dateRange)
            && Objects.equals(matchShiftsBy, other.matchShiftsBy)
            && Objects.equals(defaultTimezone, other.defaultTimezone);
    }

    /**
     * Builds a new {@link ShiftWorkday.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftWorkday.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .dateRange(getDateRange())
            .matchShiftsBy(getMatchShiftsBy())
            .defaultTimezone(getDefaultTimezone());
        return builder;
    }

    /**
     * Class to build instances of {@link ShiftWorkday}.
     */
    public static class Builder {
        private DateRange dateRange;
        private String matchShiftsBy;
        private String defaultTimezone;



        /**
         * Setter for dateRange.
         * @param dateRange DateRange value for dateRange.
         * @return Builder
         */
        public Builder dateRange(DateRange dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        /**
         * Setter for matchShiftsBy.
         * @param matchShiftsBy String value for matchShiftsBy.
         * @return Builder
         */
        public Builder matchShiftsBy(String matchShiftsBy) {
            this.matchShiftsBy = matchShiftsBy;
            return this;
        }

        /**
         * Setter for defaultTimezone.
         * @param defaultTimezone String value for defaultTimezone.
         * @return Builder
         */
        public Builder defaultTimezone(String defaultTimezone) {
            this.defaultTimezone = defaultTimezone;
            return this;
        }

        /**
         * Builds a new {@link ShiftWorkday} object using the set fields.
         * @return {@link ShiftWorkday}
         */
        public ShiftWorkday build() {
            return new ShiftWorkday(dateRange,
                matchShiftsBy,
                defaultTimezone);
        }
    }
}
