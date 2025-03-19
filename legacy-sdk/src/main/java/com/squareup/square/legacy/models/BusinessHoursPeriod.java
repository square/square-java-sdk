package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BusinessHoursPeriod type.
 */
public class BusinessHoursPeriod {
    private final String dayOfWeek;
    private final OptionalNullable<String> startLocalTime;
    private final OptionalNullable<String> endLocalTime;

    /**
     * Initialization constructor.
     * @param  dayOfWeek  String value for dayOfWeek.
     * @param  startLocalTime  String value for startLocalTime.
     * @param  endLocalTime  String value for endLocalTime.
     */
    @JsonCreator
    public BusinessHoursPeriod(
            @JsonProperty("day_of_week") String dayOfWeek,
            @JsonProperty("start_local_time") String startLocalTime,
            @JsonProperty("end_local_time") String endLocalTime) {
        this.dayOfWeek = dayOfWeek;
        this.startLocalTime = OptionalNullable.of(startLocalTime);
        this.endLocalTime = OptionalNullable.of(endLocalTime);
    }

    /**
     * Initialization constructor.
     * @param  dayOfWeek  String value for dayOfWeek.
     * @param  startLocalTime  String value for startLocalTime.
     * @param  endLocalTime  String value for endLocalTime.
     */
    protected BusinessHoursPeriod(
            String dayOfWeek, OptionalNullable<String> startLocalTime, OptionalNullable<String> endLocalTime) {
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Internal Getter for StartLocalTime.
     * The start time of a business hours period, specified in local time using partial-time RFC
     * 3339 format. For example, `8:30:00` for a period starting at 8:30 in the morning. Note that
     * the seconds value is always :00, but it is appended for conformance to the RFC.
     * @return Returns the Internal String
     */
    @JsonGetter("start_local_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStartLocalTime() {
        return this.startLocalTime;
    }

    /**
     * Getter for StartLocalTime.
     * The start time of a business hours period, specified in local time using partial-time RFC
     * 3339 format. For example, `8:30:00` for a period starting at 8:30 in the morning. Note that
     * the seconds value is always :00, but it is appended for conformance to the RFC.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStartLocalTime() {
        return OptionalNullable.getFrom(startLocalTime);
    }

    /**
     * Internal Getter for EndLocalTime.
     * The end time of a business hours period, specified in local time using partial-time RFC 3339
     * format. For example, `21:00:00` for a period ending at 9:00 in the evening. Note that the
     * seconds value is always :00, but it is appended for conformance to the RFC.
     * @return Returns the Internal String
     */
    @JsonGetter("end_local_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndLocalTime() {
        return this.endLocalTime;
    }

    /**
     * Getter for EndLocalTime.
     * The end time of a business hours period, specified in local time using partial-time RFC 3339
     * format. For example, `21:00:00` for a period ending at 9:00 in the evening. Note that the
     * seconds value is always :00, but it is appended for conformance to the RFC.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndLocalTime() {
        return OptionalNullable.getFrom(endLocalTime);
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
        return "BusinessHoursPeriod [" + "dayOfWeek=" + dayOfWeek + ", startLocalTime=" + startLocalTime
                + ", endLocalTime=" + endLocalTime + "]";
    }

    /**
     * Builds a new {@link BusinessHoursPeriod.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessHoursPeriod.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().dayOfWeek(getDayOfWeek());
        builder.startLocalTime = internalGetStartLocalTime();
        builder.endLocalTime = internalGetEndLocalTime();
        return builder;
    }

    /**
     * Class to build instances of {@link BusinessHoursPeriod}.
     */
    public static class Builder {
        private String dayOfWeek;
        private OptionalNullable<String> startLocalTime;
        private OptionalNullable<String> endLocalTime;

        /**
         * Setter for dayOfWeek.
         * @param  dayOfWeek  String value for dayOfWeek.
         * @return Builder
         */
        public Builder dayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        /**
         * Setter for startLocalTime.
         * @param  startLocalTime  String value for startLocalTime.
         * @return Builder
         */
        public Builder startLocalTime(String startLocalTime) {
            this.startLocalTime = OptionalNullable.of(startLocalTime);
            return this;
        }

        /**
         * UnSetter for startLocalTime.
         * @return Builder
         */
        public Builder unsetStartLocalTime() {
            startLocalTime = null;
            return this;
        }

        /**
         * Setter for endLocalTime.
         * @param  endLocalTime  String value for endLocalTime.
         * @return Builder
         */
        public Builder endLocalTime(String endLocalTime) {
            this.endLocalTime = OptionalNullable.of(endLocalTime);
            return this;
        }

        /**
         * UnSetter for endLocalTime.
         * @return Builder
         */
        public Builder unsetEndLocalTime() {
            endLocalTime = null;
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
