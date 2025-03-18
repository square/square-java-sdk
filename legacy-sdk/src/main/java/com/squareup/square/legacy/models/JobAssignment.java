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
 * This is a model class for JobAssignment type.
 */
public class JobAssignment {
    private final OptionalNullable<String> jobTitle;
    private final String payType;
    private final Money hourlyRate;
    private final Money annualRate;
    private final OptionalNullable<Integer> weeklyHours;
    private final OptionalNullable<String> jobId;

    /**
     * Initialization constructor.
     * @param  payType  String value for payType.
     * @param  jobTitle  String value for jobTitle.
     * @param  hourlyRate  Money value for hourlyRate.
     * @param  annualRate  Money value for annualRate.
     * @param  weeklyHours  Integer value for weeklyHours.
     * @param  jobId  String value for jobId.
     */
    @JsonCreator
    public JobAssignment(
            @JsonProperty("pay_type") String payType,
            @JsonProperty("job_title") String jobTitle,
            @JsonProperty("hourly_rate") Money hourlyRate,
            @JsonProperty("annual_rate") Money annualRate,
            @JsonProperty("weekly_hours") Integer weeklyHours,
            @JsonProperty("job_id") String jobId) {
        this.jobTitle = OptionalNullable.of(jobTitle);
        this.payType = payType;
        this.hourlyRate = hourlyRate;
        this.annualRate = annualRate;
        this.weeklyHours = OptionalNullable.of(weeklyHours);
        this.jobId = OptionalNullable.of(jobId);
    }

    /**
     * Initialization constructor.
     * @param  payType  String value for payType.
     * @param  jobTitle  String value for jobTitle.
     * @param  hourlyRate  Money value for hourlyRate.
     * @param  annualRate  Money value for annualRate.
     * @param  weeklyHours  Integer value for weeklyHours.
     * @param  jobId  String value for jobId.
     */
    protected JobAssignment(
            String payType,
            OptionalNullable<String> jobTitle,
            Money hourlyRate,
            Money annualRate,
            OptionalNullable<Integer> weeklyHours,
            OptionalNullable<String> jobId) {
        this.jobTitle = jobTitle;
        this.payType = payType;
        this.hourlyRate = hourlyRate;
        this.annualRate = annualRate;
        this.weeklyHours = weeklyHours;
        this.jobId = jobId;
    }

    /**
     * Internal Getter for JobTitle.
     * The title of the job.
     * @return Returns the Internal String
     */
    @JsonGetter("job_title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetJobTitle() {
        return this.jobTitle;
    }

    /**
     * Getter for JobTitle.
     * The title of the job.
     * @return Returns the String
     */
    @JsonIgnore
    public String getJobTitle() {
        return OptionalNullable.getFrom(jobTitle);
    }

    /**
     * Getter for PayType.
     * Enumerates the possible pay types that a job can be assigned.
     * @return Returns the String
     */
    @JsonGetter("pay_type")
    public String getPayType() {
        return payType;
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
     * Getter for AnnualRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("annual_rate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAnnualRate() {
        return annualRate;
    }

    /**
     * Internal Getter for WeeklyHours.
     * The planned hours per week for the job. Set if the job `PayType` is `SALARY`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("weekly_hours")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetWeeklyHours() {
        return this.weeklyHours;
    }

    /**
     * Getter for WeeklyHours.
     * The planned hours per week for the job. Set if the job `PayType` is `SALARY`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getWeeklyHours() {
        return OptionalNullable.getFrom(weeklyHours);
    }

    /**
     * Internal Getter for JobId.
     * The ID of the [job]($m/Job).
     * @return Returns the Internal String
     */
    @JsonGetter("job_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetJobId() {
        return this.jobId;
    }

    /**
     * Getter for JobId.
     * The ID of the [job]($m/Job).
     * @return Returns the String
     */
    @JsonIgnore
    public String getJobId() {
        return OptionalNullable.getFrom(jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, payType, hourlyRate, annualRate, weeklyHours, jobId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JobAssignment)) {
            return false;
        }
        JobAssignment other = (JobAssignment) obj;
        return Objects.equals(jobTitle, other.jobTitle)
                && Objects.equals(payType, other.payType)
                && Objects.equals(hourlyRate, other.hourlyRate)
                && Objects.equals(annualRate, other.annualRate)
                && Objects.equals(weeklyHours, other.weeklyHours)
                && Objects.equals(jobId, other.jobId);
    }

    /**
     * Converts this JobAssignment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "JobAssignment [" + "payType=" + payType + ", jobTitle=" + jobTitle + ", hourlyRate="
                + hourlyRate + ", annualRate=" + annualRate + ", weeklyHours=" + weeklyHours
                + ", jobId=" + jobId + "]";
    }

    /**
     * Builds a new {@link JobAssignment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link JobAssignment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(payType).hourlyRate(getHourlyRate()).annualRate(getAnnualRate());
        builder.jobTitle = internalGetJobTitle();
        builder.weeklyHours = internalGetWeeklyHours();
        builder.jobId = internalGetJobId();
        return builder;
    }

    /**
     * Class to build instances of {@link JobAssignment}.
     */
    public static class Builder {
        private String payType;
        private OptionalNullable<String> jobTitle;
        private Money hourlyRate;
        private Money annualRate;
        private OptionalNullable<Integer> weeklyHours;
        private OptionalNullable<String> jobId;

        /**
         * Initialization constructor.
         * @param  payType  String value for payType.
         */
        public Builder(String payType) {
            this.payType = payType;
        }

        /**
         * Setter for payType.
         * @param  payType  String value for payType.
         * @return Builder
         */
        public Builder payType(String payType) {
            this.payType = payType;
            return this;
        }

        /**
         * Setter for jobTitle.
         * @param  jobTitle  String value for jobTitle.
         * @return Builder
         */
        public Builder jobTitle(String jobTitle) {
            this.jobTitle = OptionalNullable.of(jobTitle);
            return this;
        }

        /**
         * UnSetter for jobTitle.
         * @return Builder
         */
        public Builder unsetJobTitle() {
            jobTitle = null;
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
         * Setter for annualRate.
         * @param  annualRate  Money value for annualRate.
         * @return Builder
         */
        public Builder annualRate(Money annualRate) {
            this.annualRate = annualRate;
            return this;
        }

        /**
         * Setter for weeklyHours.
         * @param  weeklyHours  Integer value for weeklyHours.
         * @return Builder
         */
        public Builder weeklyHours(Integer weeklyHours) {
            this.weeklyHours = OptionalNullable.of(weeklyHours);
            return this;
        }

        /**
         * UnSetter for weeklyHours.
         * @return Builder
         */
        public Builder unsetWeeklyHours() {
            weeklyHours = null;
            return this;
        }

        /**
         * Setter for jobId.
         * @param  jobId  String value for jobId.
         * @return Builder
         */
        public Builder jobId(String jobId) {
            this.jobId = OptionalNullable.of(jobId);
            return this;
        }

        /**
         * UnSetter for jobId.
         * @return Builder
         */
        public Builder unsetJobId() {
            jobId = null;
            return this;
        }

        /**
         * Builds a new {@link JobAssignment} object using the set fields.
         * @return {@link JobAssignment}
         */
        public JobAssignment build() {
            return new JobAssignment(payType, jobTitle, hourlyRate, annualRate, weeklyHours, jobId);
        }
    }
}
