package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for JobAssignment type.
 */
public class JobAssignment {

    /**
     * Initialization constructor.
     * @param jobTitle
     * @param payType
     * @param hourlyRate
     * @param annualRate
     * @param weeklyHours
     */
    @JsonCreator
    public JobAssignment(
            @JsonProperty("job_title") String jobTitle,
            @JsonProperty("pay_type") String payType,
            @JsonProperty("hourly_rate") Money hourlyRate,
            @JsonProperty("annual_rate") Money annualRate,
            @JsonProperty("weekly_hours") Integer weeklyHours) {
        this.jobTitle = jobTitle;
        this.payType = payType;
        this.hourlyRate = hourlyRate;
        this.annualRate = annualRate;
        this.weeklyHours = weeklyHours;
    }

    private final String jobTitle;
    private final String payType;
    private final Money hourlyRate;
    private final Money annualRate;
    private final Integer weeklyHours;
    /**
     * Getter for JobTitle.
     * The title of the job.
     */
    @JsonGetter("job_title")
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
     * Getter for PayType.
     * Enumerates the possible pay types that a job can be assigned.
     */
    @JsonGetter("pay_type")
    public String getPayType() {
        return this.payType;
    }

    /**
     * Getter for HourlyRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("hourly_rate")
    public Money getHourlyRate() {
        return this.hourlyRate;
    }

    /**
     * Getter for AnnualRate.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("annual_rate")
    public Money getAnnualRate() {
        return this.annualRate;
    }

    /**
     * Getter for WeeklyHours.
     * The planned hours per week for the job. Set if the job `PayType` is `SALARY`.
     */
    @JsonGetter("weekly_hours")
    public Integer getWeeklyHours() {
        return this.weeklyHours;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, payType, hourlyRate, annualRate, weeklyHours);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof JobAssignment)) {
            return false;
        }
        JobAssignment jobAssignment = (JobAssignment) obj;
        return Objects.equals(jobTitle, jobAssignment.jobTitle) &&
            Objects.equals(payType, jobAssignment.payType) &&
            Objects.equals(hourlyRate, jobAssignment.hourlyRate) &&
            Objects.equals(annualRate, jobAssignment.annualRate) &&
            Objects.equals(weeklyHours, jobAssignment.weeklyHours);
    }

    /**
     * Builds a new {@link JobAssignment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link JobAssignment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(jobTitle,
            payType)
            .hourlyRate(getHourlyRate())
            .annualRate(getAnnualRate())
            .weeklyHours(getWeeklyHours());
            return builder;
    }

    /**
     * Class to build instances of {@link JobAssignment}
     */
    public static class Builder {
        private String jobTitle;
        private String payType;
        private Money hourlyRate;
        private Money annualRate;
        private Integer weeklyHours;

        /**
         * Initialization constructor
         */
        public Builder(String jobTitle,
                String payType) {
            this.jobTitle = jobTitle;
            this.payType = payType;
        }

        /**
         * Setter for jobTitle
         * @param jobTitle
         * @return Builder
         */
        public Builder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }
        /**
         * Setter for payType
         * @param payType
         * @return Builder
         */
        public Builder payType(String payType) {
            this.payType = payType;
            return this;
        }
        /**
         * Setter for hourlyRate
         * @param hourlyRate
         * @return Builder
         */
        public Builder hourlyRate(Money hourlyRate) {
            this.hourlyRate = hourlyRate;
            return this;
        }
        /**
         * Setter for annualRate
         * @param annualRate
         * @return Builder
         */
        public Builder annualRate(Money annualRate) {
            this.annualRate = annualRate;
            return this;
        }
        /**
         * Setter for weeklyHours
         * @param weeklyHours
         * @return Builder
         */
        public Builder weeklyHours(Integer weeklyHours) {
            this.weeklyHours = weeklyHours;
            return this;
        }

        /**
         * Builds a new {@link JobAssignment} object using the set fields.
         * @return {@link JobAssignment}
         */
        public JobAssignment build() {
            return new JobAssignment(jobTitle,
                payType,
                hourlyRate,
                annualRate,
                weeklyHours);
        }
    }
}
