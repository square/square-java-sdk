package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class TimeRange {

    @JsonCreator
    public TimeRange(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("end_at") String endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    private final String startAt;
    private final String endAt;

    @Override
    public int hashCode() {
        return Objects.hash(startAt, endAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TimeRange)) {
            return false;
        }
        TimeRange timeRange = (TimeRange) o;
        return Objects.equals(startAt, timeRange.startAt) &&
            Objects.equals(endAt, timeRange.endAt);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .startAt(getStartAt())
            .endAt(getEndAt());
            return builder;
    }

    public static class Builder {
        private String startAt;
        private String endAt;

        public Builder() { }

        public Builder startAt(String value) {
            startAt = value;
            return this;
        }
        public Builder endAt(String value) {
            endAt = value;
            return this;
        }

        public TimeRange build() {
            return new TimeRange(startAt,
                endAt);
        }
    }
}
