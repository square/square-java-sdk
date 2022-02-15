
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TimeRange type.
 */
public class TimeRange {
    private final String startAt;
    private final String endAt;

    /**
     * Initialization constructor.
     * @param  startAt  String value for startAt.
     * @param  endAt  String value for endAt.
     */
    @JsonCreator
    public TimeRange(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("end_at") String endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    /**
     * Getter for StartAt.
     * A datetime value in RFC 3339 format indicating when the time range starts.
     * @return Returns the String
     */
    @JsonGetter("start_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStartAt() {
        return startAt;
    }

    /**
     * Getter for EndAt.
     * A datetime value in RFC 3339 format indicating when the time range ends.
     * @return Returns the String
     */
    @JsonGetter("end_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndAt() {
        return endAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startAt, endAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeRange)) {
            return false;
        }
        TimeRange other = (TimeRange) obj;
        return Objects.equals(startAt, other.startAt)
            && Objects.equals(endAt, other.endAt);
    }

    /**
     * Converts this TimeRange into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TimeRange [" + "startAt=" + startAt + ", endAt=" + endAt + "]";
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
     * Class to build instances of {@link TimeRange}.
     */
    public static class Builder {
        private String startAt;
        private String endAt;



        /**
         * Setter for startAt.
         * @param  startAt  String value for startAt.
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }

        /**
         * Setter for endAt.
         * @param  endAt  String value for endAt.
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
            return new TimeRange(startAt, endAt);
        }
    }
}
