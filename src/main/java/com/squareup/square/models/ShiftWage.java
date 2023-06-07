
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
 * This is a model class for ShiftWage type.
 */
public class ShiftWage {
    private final OptionalNullable<String> title;
    private final Money hourlyRate;
    private final String jobId;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  hourlyRate  Money value for hourlyRate.
     * @param  jobId  String value for jobId.
     */
    @JsonCreator
    public ShiftWage(
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate,
            @JsonProperty("job_id") String jobId) {
        this.title = OptionalNullable.of(title);
        this.hourlyRate = hourlyRate;
        this.jobId = jobId;
    }

    /**
     * Internal initialization constructor.
     */
    protected ShiftWage(OptionalNullable<String> title, Money hourlyRate, String jobId) {
        this.title = title;
        this.hourlyRate = hourlyRate;
        this.jobId = jobId;
    }

    /**
     * Internal Getter for Title.
     * The name of the job performed during this shift.
     * @return Returns the Internal String
     */
    @JsonGetter("title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTitle() {
        return this.title;
    }

    /**
     * Getter for Title.
     * The name of the job performed during this shift.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTitle() {
        return OptionalNullable.getFrom(title);
    }

    /**
     * Getter for HourlyRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("hourly_rate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Getter for JobId.
     * The id of the job performed during this shift. Square labor-reporting UIs might group shifts
     * together by id. This cannot be used to retrieve the job.
     * @return Returns the String
     */
    @JsonGetter("job_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getJobId() {
        return jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, hourlyRate, jobId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShiftWage)) {
            return false;
        }
        ShiftWage other = (ShiftWage) obj;
        return Objects.equals(title, other.title)
            && Objects.equals(hourlyRate, other.hourlyRate)
            && Objects.equals(jobId, other.jobId);
    }

    /**
     * Converts this ShiftWage into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ShiftWage [" + "title=" + title + ", hourlyRate=" + hourlyRate + ", jobId=" + jobId
                + "]";
    }

    /**
     * Builds a new {@link ShiftWage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftWage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .hourlyRate(getHourlyRate())
                .jobId(getJobId());
        builder.title = internalGetTitle();
        return builder;
    }

    /**
     * Class to build instances of {@link ShiftWage}.
     */
    public static class Builder {
        private OptionalNullable<String> title;
        private Money hourlyRate;
        private String jobId;



        /**
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = OptionalNullable.of(title);
            return this;
        }

        /**
         * UnSetter for title.
         * @return Builder
         */
        public Builder unsetTitle() {
            title = null;
            return this;
        }

        /**
         * Setter for hourlyRate.
         * @param  hourlyRate  Money value for hourlyRate.
         * @return Builder
         */
        public Builder hourlyRate(Money hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }

        /**
         * Setter for jobId.
         * @param  jobId  String value for jobId.
         * @return Builder
         */
        public Builder jobId(String jobId) {
            this.jobId = jobId;
            return this;
        }

        /**
         * Builds a new {@link ShiftWage} object using the set fields.
         * @return {@link ShiftWage}
         */
        public ShiftWage build() {
            return new ShiftWage(title, hourlyRate, jobId);
        }
    }
}
