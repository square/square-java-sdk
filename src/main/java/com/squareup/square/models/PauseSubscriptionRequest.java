
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PauseSubscriptionRequest type.
 */
public class PauseSubscriptionRequest {
    private final String pauseEffectiveDate;
    private final Long pauseCycleDuration;
    private final String resumeEffectiveDate;
    private final String resumeChangeTiming;
    private final String pauseReason;

    /**
     * Initialization constructor.
     * @param  pauseEffectiveDate  String value for pauseEffectiveDate.
     * @param  pauseCycleDuration  Long value for pauseCycleDuration.
     * @param  resumeEffectiveDate  String value for resumeEffectiveDate.
     * @param  resumeChangeTiming  String value for resumeChangeTiming.
     * @param  pauseReason  String value for pauseReason.
     */
    @JsonCreator
    public PauseSubscriptionRequest(
            @JsonProperty("pause_effective_date") String pauseEffectiveDate,
            @JsonProperty("pause_cycle_duration") Long pauseCycleDuration,
            @JsonProperty("resume_effective_date") String resumeEffectiveDate,
            @JsonProperty("resume_change_timing") String resumeChangeTiming,
            @JsonProperty("pause_reason") String pauseReason) {
        this.pauseEffectiveDate = pauseEffectiveDate;
        this.pauseCycleDuration = pauseCycleDuration;
        this.resumeEffectiveDate = resumeEffectiveDate;
        this.resumeChangeTiming = resumeChangeTiming;
        this.pauseReason = pauseReason;
    }

    /**
     * Getter for PauseEffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the scheduled `PAUSE` action takes place on the
     * subscription. When this date is unspecified or falls within the current billing cycle, the
     * subscription is paused on the starting date of the next billing cycle.
     * @return Returns the String
     */
    @JsonGetter("pause_effective_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPauseEffectiveDate() {
        return pauseEffectiveDate;
    }

    /**
     * Getter for PauseCycleDuration.
     * The number of billing cycles the subscription will be paused before it is reactivated. When
     * this is set, a `RESUME` action is also scheduled to take place on the subscription at the end
     * of the specified pause cycle duration. In this case, neither `resume_effective_date` nor
     * `resume_change_timing` may be specified.
     * @return Returns the Long
     */
    @JsonGetter("pause_cycle_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getPauseCycleDuration() {
        return pauseCycleDuration;
    }

    /**
     * Getter for ResumeEffectiveDate.
     * The date when the subscription is reactivated by a scheduled `RESUME` action. This date must
     * be at least one billing cycle ahead of `pause_effective_date`.
     * @return Returns the String
     */
    @JsonGetter("resume_effective_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getResumeEffectiveDate() {
        return resumeEffectiveDate;
    }

    /**
     * Getter for ResumeChangeTiming.
     * Supported timings when a pending change, as an action, takes place to a subscription.
     * @return Returns the String
     */
    @JsonGetter("resume_change_timing")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getResumeChangeTiming() {
        return resumeChangeTiming;
    }

    /**
     * Getter for PauseReason.
     * The user-provided reason to pause the subscription.
     * @return Returns the String
     */
    @JsonGetter("pause_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPauseReason() {
        return pauseReason;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pauseEffectiveDate, pauseCycleDuration, resumeEffectiveDate,
                resumeChangeTiming, pauseReason);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PauseSubscriptionRequest)) {
            return false;
        }
        PauseSubscriptionRequest other = (PauseSubscriptionRequest) obj;
        return Objects.equals(pauseEffectiveDate, other.pauseEffectiveDate)
            && Objects.equals(pauseCycleDuration, other.pauseCycleDuration)
            && Objects.equals(resumeEffectiveDate, other.resumeEffectiveDate)
            && Objects.equals(resumeChangeTiming, other.resumeChangeTiming)
            && Objects.equals(pauseReason, other.pauseReason);
    }

    /**
     * Converts this PauseSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PauseSubscriptionRequest [" + "pauseEffectiveDate=" + pauseEffectiveDate
                + ", pauseCycleDuration=" + pauseCycleDuration + ", resumeEffectiveDate="
                + resumeEffectiveDate + ", resumeChangeTiming=" + resumeChangeTiming
                + ", pauseReason=" + pauseReason + "]";
    }

    /**
     * Builds a new {@link PauseSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PauseSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .pauseEffectiveDate(getPauseEffectiveDate())
                .pauseCycleDuration(getPauseCycleDuration())
                .resumeEffectiveDate(getResumeEffectiveDate())
                .resumeChangeTiming(getResumeChangeTiming())
                .pauseReason(getPauseReason());
        return builder;
    }

    /**
     * Class to build instances of {@link PauseSubscriptionRequest}.
     */
    public static class Builder {
        private String pauseEffectiveDate;
        private Long pauseCycleDuration;
        private String resumeEffectiveDate;
        private String resumeChangeTiming;
        private String pauseReason;



        /**
         * Setter for pauseEffectiveDate.
         * @param  pauseEffectiveDate  String value for pauseEffectiveDate.
         * @return Builder
         */
        public Builder pauseEffectiveDate(String pauseEffectiveDate) {
            this.pauseEffectiveDate = pauseEffectiveDate;
            return this;
        }

        /**
         * Setter for pauseCycleDuration.
         * @param  pauseCycleDuration  Long value for pauseCycleDuration.
         * @return Builder
         */
        public Builder pauseCycleDuration(Long pauseCycleDuration) {
            this.pauseCycleDuration = pauseCycleDuration;
            return this;
        }

        /**
         * Setter for resumeEffectiveDate.
         * @param  resumeEffectiveDate  String value for resumeEffectiveDate.
         * @return Builder
         */
        public Builder resumeEffectiveDate(String resumeEffectiveDate) {
            this.resumeEffectiveDate = resumeEffectiveDate;
            return this;
        }

        /**
         * Setter for resumeChangeTiming.
         * @param  resumeChangeTiming  String value for resumeChangeTiming.
         * @return Builder
         */
        public Builder resumeChangeTiming(String resumeChangeTiming) {
            this.resumeChangeTiming = resumeChangeTiming;
            return this;
        }

        /**
         * Setter for pauseReason.
         * @param  pauseReason  String value for pauseReason.
         * @return Builder
         */
        public Builder pauseReason(String pauseReason) {
            this.pauseReason = pauseReason;
            return this;
        }

        /**
         * Builds a new {@link PauseSubscriptionRequest} object using the set fields.
         * @return {@link PauseSubscriptionRequest}
         */
        public PauseSubscriptionRequest build() {
            return new PauseSubscriptionRequest(pauseEffectiveDate, pauseCycleDuration,
                    resumeEffectiveDate, resumeChangeTiming, pauseReason);
        }
    }
}
