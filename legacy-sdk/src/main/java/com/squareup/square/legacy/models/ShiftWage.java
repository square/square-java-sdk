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
 * This is a model class for ShiftWage type.
 */
public class ShiftWage {
    private final OptionalNullable<String> title;
    private final Money hourlyRate;
    private final String jobId;
    private final OptionalNullable<Boolean> tipEligible;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  hourlyRate  Money value for hourlyRate.
     * @param  jobId  String value for jobId.
     * @param  tipEligible  Boolean value for tipEligible.
     */
    @JsonCreator
    public ShiftWage(
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate,
            @JsonProperty("job_id") String jobId,
            @JsonProperty("tip_eligible") Boolean tipEligible) {
        this.title = OptionalNullable.of(title);
        this.hourlyRate = hourlyRate;
        this.jobId = jobId;
        this.tipEligible = OptionalNullable.of(tipEligible);
    }

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  hourlyRate  Money value for hourlyRate.
     * @param  jobId  String value for jobId.
     * @param  tipEligible  Boolean value for tipEligible.
     */
    protected ShiftWage(
            OptionalNullable<String> title, Money hourlyRate, String jobId, OptionalNullable<Boolean> tipEligible) {
        this.title = title;
        this.hourlyRate = hourlyRate;
        this.jobId = jobId;
        this.tipEligible = tipEligible;
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

    /**
     * Internal Getter for TipEligible.
     * Whether team members are eligible for tips when working this job.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("tip_eligible")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetTipEligible() {
        return this.tipEligible;
    }

    /**
     * Getter for TipEligible.
     * Whether team members are eligible for tips when working this job.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getTipEligible() {
        return OptionalNullable.getFrom(tipEligible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, hourlyRate, jobId, tipEligible);
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
                && Objects.equals(jobId, other.jobId)
                && Objects.equals(tipEligible, other.tipEligible);
    }

    /**
     * Converts this ShiftWage into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ShiftWage [" + "title=" + title + ", hourlyRate=" + hourlyRate + ", jobId=" + jobId + ", tipEligible="
                + tipEligible + "]";
    }

    /**
     * Builds a new {@link ShiftWage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftWage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().hourlyRate(getHourlyRate()).jobId(getJobId());
        builder.title = internalGetTitle();
        builder.tipEligible = internalGetTipEligible();
        return builder;
    }

    /**
     * Class to build instances of {@link ShiftWage}.
     */
    public static class Builder {
        private OptionalNullable<String> title;
        private Money hourlyRate;
        private String jobId;
        private OptionalNullable<Boolean> tipEligible;

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
         * Setter for tipEligible.
         * @param  tipEligible  Boolean value for tipEligible.
         * @return Builder
         */
        public Builder tipEligible(Boolean tipEligible) {
            this.tipEligible = OptionalNullable.of(tipEligible);
            return this;
        }

        /**
         * UnSetter for tipEligible.
         * @return Builder
         */
        public Builder unsetTipEligible() {
            tipEligible = null;
            return this;
        }

        /**
         * Builds a new {@link ShiftWage} object using the set fields.
         * @return {@link ShiftWage}
         */
        public ShiftWage build() {
            return new ShiftWage(title, hourlyRate, jobId, tipEligible);
        }
    }
}
