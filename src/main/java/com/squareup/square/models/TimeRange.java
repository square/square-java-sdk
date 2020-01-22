package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for TimeRange type.
 */
public class TimeRange {

    /**
     * Initialization constructor.
     * @param startAt
     * @param endAt
     */
    @JsonCreator
    public TimeRange(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("end_at") String endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    private final String startAt;
    private final String endAt;
    /**
     * Getter for StartAt.
     * A datetime value in RFC-3339 format indicating when the time range
     * starts.
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return this.startAt;
    }

    /**
     * Getter for EndAt.
     * A datetime value in RFC-3339 format indicating when the time range
     * ends.
     */
    @JsonGetter("end_at")
    public String getEndAt() {
        return this.endAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(startAt, endAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof TimeRange)) {
            return false;
        }
        TimeRange timeRange = (TimeRange) obj;
        return Objects.equals(startAt, timeRange.startAt) &&
            Objects.equals(endAt, timeRange.endAt);
    }

    /**
     * Builds a new {@link TimeRange.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TimeRange.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .startAt(getStartAt())
            .endAt(getEndAt());
            return builder;
    }

    /**
     * Class to build instances of {@link TimeRange}
     */
    public static class Builder {
        private String startAt;
        private String endAt;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for startAt
         * @param startAt
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }
        /**
         * Setter for endAt
         * @param endAt
         * @return Builder
         */
        public Builder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }

        /**
         * Builds a new {@link TimeRange} object using the set fields.
         * @return {@link TimeRange}
         */
        public TimeRange build() {
            return new TimeRange(startAt,
                endAt);
        }
    }
}
