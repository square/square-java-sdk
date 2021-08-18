
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DateRange type.
 */
public class DateRange {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String startDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String endDate;

    /**
     * Initialization constructor.
     * @param  startDate  String value for startDate.
     * @param  endDate  String value for endDate.
     */
    @JsonCreator
    public DateRange(
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Getter for StartDate.
     * A string in `YYYY-MM-DD` format, such as `2017-10-31`, per the ISO 8601 extended format for
     * calendar dates. The beginning of a date range (inclusive).
     * @return Returns the String
     */
    @JsonGetter("start_date")
    public String getStartDate() {
        return startDate;
    }

    /**
     * Getter for EndDate.
     * A string in `YYYY-MM-DD` format, such as `2017-10-31`, per the ISO 8601 extended format for
     * calendar dates. The end of a date range (inclusive).
     * @return Returns the String
     */
    @JsonGetter("end_date")
    public String getEndDate() {
        return endDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateRange)) {
            return false;
        }
        DateRange other = (DateRange) obj;
        return Objects.equals(startDate, other.startDate)
            && Objects.equals(endDate, other.endDate);
    }

    /**
     * Converts this DateRange into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DateRange [" + "startDate=" + startDate + ", endDate=" + endDate + "]";
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
     * Class to build instances of {@link DateRange}.
     */
    public static class Builder {
        private String startDate;
        private String endDate;



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
         * Builds a new {@link DateRange} object using the set fields.
         * @return {@link DateRange}
         */
        public DateRange build() {
            return new DateRange(startDate, endDate);
        }
    }
}
