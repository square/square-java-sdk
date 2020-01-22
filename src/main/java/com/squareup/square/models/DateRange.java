package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DateRange type.
 */
public class DateRange {

    /**
     * Initialization constructor.
     * @param startDate
     * @param endDate
     */
    @JsonCreator
    public DateRange(
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private final String startDate;
    private final String endDate;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DateRange)) {
            return false;
        }
        DateRange dateRange = (DateRange) obj;
        return Objects.equals(startDate, dateRange.startDate) &&
            Objects.equals(endDate, dateRange.endDate);
    }

    /**
     * Builds a new {@link DateRange.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DateRange.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .startDate(getStartDate())
            .endDate(getEndDate());
            return builder;
    }

    /**
     * Class to build instances of {@link DateRange}
     */
    public static class Builder {
        private String startDate;
        private String endDate;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for startDate
         * @param startDate
         * @return Builder
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }
        /**
         * Setter for endDate
         * @param endDate
         * @return Builder
         */
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * Builds a new {@link DateRange} object using the set fields.
         * @return {@link DateRange}
         */
        public DateRange build() {
            return new DateRange(startDate,
                endDate);
        }
    }
}
