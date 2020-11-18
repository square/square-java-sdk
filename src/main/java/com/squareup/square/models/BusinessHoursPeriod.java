
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BusinessHoursPeriod type.
 */
public class BusinessHoursPeriod {
    private final String dayOfWeek;
    private final String startLocalTime;
    private final String endLocalTime;

    /**
     * Initialization constructor.
     * @param dayOfWeek String value for dayOfWeek.
     * @param startLocalTime String value for startLocalTime.
     * @param endLocalTime String value for endLocalTime.
     */
    @JsonCreator
    public BusinessHoursPeriod(
            @JsonProperty("day_of_week") String dayOfWeek,
            @JsonProperty("start_local_time") String startLocalTime,
            @JsonProperty("end_local_time") String endLocalTime) {
        this.dayOfWeek = dayOfWeek;
        this.startLocalTime = startLocalTime;
        this.endLocalTime = endLocalTime;
    }

    /**
     * Getter for DayOfWeek.
     * Indicates the specific day of the week.
     * @return Returns the String
     */
    @JsonGetter("day_of_week")
    public String getDayOfWeek() {
        return this.dayOfWeek;
    }

    /**
     * Getter for StartLocalTime.
     * The start time of a business hours period, specified in local time using partial-time RFC
     * 3339 format.
     * @return Returns the String
     */
    @JsonGetter("start_local_time")
    public String getStartLocalTime() {
        return this.startLocalTime;
    }

    /**
     * Getter for EndLocalTime.
     * The end time of a business hours period, specified in local time using partial-time RFC 3339
     * format.
     * @return Returns the String
     */
    @JsonGetter("end_local_time")
    public String getEndLocalTime() {
        return this.endLocalTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, startLocalTime, endLocalTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessHoursPeriod)) {
            return false;
        }
        BusinessHoursPeriod other = (BusinessHoursPeriod) obj;
        return Objects.equals(dayOfWeek, other.dayOfWeek)
            && Objects.equals(startLocalTime, other.startLocalTime)
            && Objects.equals(endLocalTime, other.endLocalTime);
    }

    /**
     * Converts this BusinessHoursPeriod into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BusinessHoursPeriod [" + "dayOfWeek=" + dayOfWeek + ", startLocalTime="
                + startLocalTime + ", endLocalTime=" + endLocalTime + "]";
    }

    /**
     * Builds a new {@link BusinessHoursPeriod.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessHoursPeriod.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .dayOfWeek(getDayOfWeek())
                .startLocalTime(getStartLocalTime())
                .endLocalTime(getEndLocalTime());
        return builder;
    }

    /**
     * Class to build instances of {@link BusinessHoursPeriod}.
     */
    public static class Builder {
        private String dayOfWeek;
        private String startLocalTime;
        private String endLocalTime;



        /**
         * Setter for dayOfWeek.
         * @param dayOfWeek String value for dayOfWeek.
         * @return Builder
         */
        public Builder dayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        /**
         * Setter for startLocalTime.
         * @param startLocalTime String value for startLocalTime.
         * @return Builder
         */
        public Builder startLocalTime(String startLocalTime) {
            this.startLocalTime = startLocalTime;
            return this;
        }

        /**
         * Setter for endLocalTime.
         * @param endLocalTime String value for endLocalTime.
         * @return Builder
         */
        public Builder endLocalTime(String endLocalTime) {
            this.endLocalTime = endLocalTime;
            return this;
        }

        /**
         * Builds a new {@link BusinessHoursPeriod} object using the set fields.
         * @return {@link BusinessHoursPeriod}
         */
        public BusinessHoursPeriod build() {
            return new BusinessHoursPeriod(dayOfWeek, startLocalTime, endLocalTime);
        }
    }
}
