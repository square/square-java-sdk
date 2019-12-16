package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class DateRange {

    @JsonCreator
    public DateRange(
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private final String startDate;
    private final String endDate;

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DateRange)) {
            return false;
        }
        DateRange dateRange = (DateRange) o;
        return Objects.equals(startDate, dateRange.startDate) &&
            Objects.equals(endDate, dateRange.endDate);
    }

    /**
     * Getter for StartDate.
     * String in `YYYY-MM-DD` format, e.g. `2017-10-31` per the ISO 8601
     * extended format for calendar dates.
     * The beginning of a date range (inclusive)
     */
    @JsonGetter("start_date")
    public String getStartDate() { 
        return this.startDate;
    }

    /**
     * Getter for EndDate.
     * String in `YYYY-MM-DD` format, e.g. `2017-10-31` per the ISO 8601
     * extended format for calendar dates.
     * The end of a date range (inclusive)
     */
    @JsonGetter("end_date")
    public String getEndDate() { 
        return this.endDate;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .startDate(getStartDate())
            .endDate(getEndDate());
            return builder;
    }

    public static class Builder {
        private String startDate;
        private String endDate;

        public Builder() { }

        public Builder startDate(String value) {
            startDate = value;
            return this;
        }
        public Builder endDate(String value) {
            endDate = value;
            return this;
        }

        public DateRange build() {
            return new DateRange(startDate,
                endDate);
        }
    }
}
