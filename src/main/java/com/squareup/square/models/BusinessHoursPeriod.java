package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BusinessHoursPeriod {

    @JsonCreator
    public BusinessHoursPeriod(
            @JsonProperty("day_of_week") String dayOfWeek,
            @JsonProperty("start_local_time") String startLocalTime,
            @JsonProperty("end_local_time") String endLocalTime) {
        this.dayOfWeek = dayOfWeek;
        this.startLocalTime = startLocalTime;
        this.endLocalTime = endLocalTime;
    }

    private final String dayOfWeek;
    private final String startLocalTime;
    private final String endLocalTime;

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, startLocalTime, endLocalTime);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BusinessHoursPeriod)) {
            return false;
        }
        BusinessHoursPeriod businessHoursPeriod = (BusinessHoursPeriod) o;
        return Objects.equals(dayOfWeek, businessHoursPeriod.dayOfWeek) &&
            Objects.equals(startLocalTime, businessHoursPeriod.startLocalTime) &&
            Objects.equals(endLocalTime, businessHoursPeriod.endLocalTime);
    }

    /**
     * Getter for DayOfWeek.
     * Indicates the specific day  of the week.
     */
    @JsonGetter("day_of_week")
    public String getDayOfWeek() { 
        return this.dayOfWeek;
    }

    /**
     * Getter for StartLocalTime.
     * The start time of a business hours period, specified in local time using partial-time
     * RFC3339 format.
     */
    @JsonGetter("start_local_time")
    public String getStartLocalTime() { 
        return this.startLocalTime;
    }

    /**
     * Getter for EndLocalTime.
     * The end time of a business hours period, specified in local time using partial-time
     * RFC3339 format.
     */
    @JsonGetter("end_local_time")
    public String getEndLocalTime() { 
        return this.endLocalTime;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .dayOfWeek(getDayOfWeek())
            .startLocalTime(getStartLocalTime())
            .endLocalTime(getEndLocalTime());
            return builder;
    }

    public static class Builder {
        private String dayOfWeek;
        private String startLocalTime;
        private String endLocalTime;

        public Builder() { }

        public Builder dayOfWeek(String value) {
            dayOfWeek = value;
            return this;
        }
        public Builder startLocalTime(String value) {
            startLocalTime = value;
            return this;
        }
        public Builder endLocalTime(String value) {
            endLocalTime = value;
            return this;
        }

        public BusinessHoursPeriod build() {
            return new BusinessHoursPeriod(dayOfWeek,
                startLocalTime,
                endLocalTime);
        }
    }
}
