
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for DateRange type.
 */
public class DateRange {
    private final OptionalNullable<String> startDate;
    private final OptionalNullable<String> endDate;

    /**
     * Initialization constructor.
     * @param  startDate  String value for startDate.
     * @param  endDate  String value for endDate.
     */
    @JsonCreator
    public DateRange(
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate) {
        this.startDate = OptionalNullable.of(startDate);
        this.endDate = OptionalNullable.of(endDate);
    }

    /**
     * Internal initialization constructor.
     */
    protected DateRange(OptionalNullable<String> startDate, OptionalNullable<String> endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Internal Getter for StartDate.
     * A string in `YYYY-MM-DD` format, such as `2017-10-31`, per the ISO 8601 extended format for
     * calendar dates. The beginning of a date range (inclusive).
     * @return Returns the Internal String
     */
    @JsonGetter("start_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStartDate() {
        return this.startDate;
    }

    /**
     * Getter for StartDate.
     * A string in `YYYY-MM-DD` format, such as `2017-10-31`, per the ISO 8601 extended format for
     * calendar dates. The beginning of a date range (inclusive).
     * @return Returns the String
     */
    @JsonIgnore
    public String getStartDate() {
        return OptionalNullable.getFrom(startDate);
    }

    /**
     * Internal Getter for EndDate.
     * A string in `YYYY-MM-DD` format, such as `2017-10-31`, per the ISO 8601 extended format for
     * calendar dates. The end of a date range (inclusive).
     * @return Returns the Internal String
     */
    @JsonGetter("end_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndDate() {
        return this.endDate;
    }

    /**
     * Getter for EndDate.
     * A string in `YYYY-MM-DD` format, such as `2017-10-31`, per the ISO 8601 extended format for
     * calendar dates. The end of a date range (inclusive).
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndDate() {
        return OptionalNullable.getFrom(endDate);
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
        Builder builder = new Builder();
        builder.startDate = internalGetStartDate();
        builder.endDate = internalGetEndDate();
        return builder;
    }

    /**
     * Class to build instances of {@link DateRange}.
     */
    public static class Builder {
        private OptionalNullable<String> startDate;
        private OptionalNullable<String> endDate;



        /**
         * Setter for startDate.
         * @param  startDate  String value for startDate.
         * @return Builder
         */
        public Builder startDate(String startDate) {
            this.startDate = OptionalNullable.of(startDate);
            return this;
        }

        /**
         * UnSetter for startDate.
         * @return Builder
         */
        public Builder unsetStartDate() {
            startDate = null;
            return this;
        }

        /**
         * Setter for endDate.
         * @param  endDate  String value for endDate.
         * @return Builder
         */
        public Builder endDate(String endDate) {
            this.endDate = OptionalNullable.of(endDate);
            return this;
        }

        /**
         * UnSetter for endDate.
         * @return Builder
         */
        public Builder unsetEndDate() {
            endDate = null;
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
