package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ShiftWorkday {

    @JsonCreator
    public ShiftWorkday(
            @JsonProperty("date_range") DateRange dateRange,
            @JsonProperty("match_shifts_by") String matchShiftsBy,
            @JsonProperty("default_timezone") String defaultTimezone) {
        this.dateRange = dateRange;
        this.matchShiftsBy = matchShiftsBy;
        this.defaultTimezone = defaultTimezone;
    }

    private final DateRange dateRange;
    private final String matchShiftsBy;
    private final String defaultTimezone;

    @Override
    public int hashCode() {
        return Objects.hash(dateRange, matchShiftsBy, defaultTimezone);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ShiftWorkday)) {
            return false;
        }
        ShiftWorkday shiftWorkday = (ShiftWorkday) o;
        return Objects.equals(dateRange, shiftWorkday.dateRange) &&
            Objects.equals(matchShiftsBy, shiftWorkday.matchShiftsBy) &&
            Objects.equals(defaultTimezone, shiftWorkday.defaultTimezone);
    }

    /**
     * Getter for DateRange.
     * A range defined by two dates. Used for filtering a query for Connect v2 
     * objects that have date properties.
     */
    @JsonGetter("date_range")
    public DateRange getDateRange() { 
        return this.dateRange;
    }

    /**
     * Getter for MatchShiftsBy.
     * Defines the logic used to apply a workday filter.
     */
    @JsonGetter("match_shifts_by")
    public String getMatchShiftsBy() { 
        return this.matchShiftsBy;
    }

    /**
     * Getter for DefaultTimezone.
     * Location-specific timezones convert workdays to datetime filters.
     * Every location included in the query must have a timezone, or this field
     * must be provided as a fallback. Format: the IANA timezone database
     * identifier for the relevant timezone.
     */
    @JsonGetter("default_timezone")
    public String getDefaultTimezone() { 
        return this.defaultTimezone;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .dateRange(getDateRange())
            .matchShiftsBy(getMatchShiftsBy())
            .defaultTimezone(getDefaultTimezone());
            return builder;
    }

    public static class Builder {
        private DateRange dateRange;
        private String matchShiftsBy;
        private String defaultTimezone;

        public Builder() { }

        public Builder dateRange(DateRange value) {
            dateRange = value;
            return this;
        }
        public Builder matchShiftsBy(String value) {
            matchShiftsBy = value;
            return this;
        }
        public Builder defaultTimezone(String value) {
            defaultTimezone = value;
            return this;
        }

        public ShiftWorkday build() {
            return new ShiftWorkday(dateRange,
                matchShiftsBy,
                defaultTimezone);
        }
    }
}
