
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for TimeRange type.
 */
public class TimeRange {
    private final OptionalNullable<String> startAt;
    private final OptionalNullable<String> endAt;

    /**
     * Initialization constructor.
     * @param  startAt  String value for startAt.
     * @param  endAt  String value for endAt.
     */
    @JsonCreator
    public TimeRange(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("end_at") String endAt) {
        this.startAt = OptionalNullable.of(startAt);
        this.endAt = OptionalNullable.of(endAt);
    }

    /**
     * Initialization constructor.
     * @param  startAt  String value for startAt.
     * @param  endAt  String value for endAt.
     */

    protected TimeRange(OptionalNullable<String> startAt, OptionalNullable<String> endAt) {
        this.startAt = startAt;
        this.endAt = endAt;
    }

    /**
     * Internal Getter for StartAt.
     * A datetime value in RFC 3339 format indicating when the time range starts.
     * @return Returns the Internal String
     */
    @JsonGetter("start_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStartAt() {
        return this.startAt;
    }

    /**
     * Getter for StartAt.
     * A datetime value in RFC 3339 format indicating when the time range starts.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStartAt() {
        return OptionalNullable.getFrom(startAt);
    }

    /**
     * Internal Getter for EndAt.
     * A datetime value in RFC 3339 format indicating when the time range ends.
     * @return Returns the Internal String
     */
    @JsonGetter("end_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndAt() {
        return this.endAt;
    }

    /**
     * Getter for EndAt.
     * A datetime value in RFC 3339 format indicating when the time range ends.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndAt() {
        return OptionalNullable.getFrom(endAt);
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
        Builder builder = new Builder();
        builder.startAt = internalGetStartAt();
        builder.endAt = internalGetEndAt();
        return builder;
    }

    /**
     * Class to build instances of {@link TimeRange}.
     */
    public static class Builder {
        private OptionalNullable<String> startAt;
        private OptionalNullable<String> endAt;



        /**
         * Setter for startAt.
         * @param  startAt  String value for startAt.
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = OptionalNullable.of(startAt);
            return this;
        }

        /**
         * UnSetter for startAt.
         * @return Builder
         */
        public Builder unsetStartAt() {
            startAt = null;
            return this;
        }

        /**
         * Setter for endAt.
         * @param  endAt  String value for endAt.
         * @return Builder
         */
        public Builder endAt(String endAt) {
            this.endAt = OptionalNullable.of(endAt);
            return this;
        }

        /**
         * UnSetter for endAt.
         * @return Builder
         */
        public Builder unsetEndAt() {
            endAt = null;
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
