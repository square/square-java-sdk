
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ResumeSubscriptionRequest type.
 */
public class ResumeSubscriptionRequest {
    private final String resumeEffectiveDate;
    private final String resumeChangeTiming;

    /**
     * Initialization constructor.
     * @param  resumeEffectiveDate  String value for resumeEffectiveDate.
     * @param  resumeChangeTiming  String value for resumeChangeTiming.
     */
    @JsonCreator
    public ResumeSubscriptionRequest(
            @JsonProperty("resume_effective_date") String resumeEffectiveDate,
            @JsonProperty("resume_change_timing") String resumeChangeTiming) {
        this.resumeEffectiveDate = resumeEffectiveDate;
        this.resumeChangeTiming = resumeChangeTiming;
    }

    /**
     * Getter for ResumeEffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the subscription reactivated.
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

    @Override
    public int hashCode() {
        return Objects.hash(resumeEffectiveDate, resumeChangeTiming);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResumeSubscriptionRequest)) {
            return false;
        }
        ResumeSubscriptionRequest other = (ResumeSubscriptionRequest) obj;
        return Objects.equals(resumeEffectiveDate, other.resumeEffectiveDate)
            && Objects.equals(resumeChangeTiming, other.resumeChangeTiming);
    }

    /**
     * Converts this ResumeSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ResumeSubscriptionRequest [" + "resumeEffectiveDate=" + resumeEffectiveDate
                + ", resumeChangeTiming=" + resumeChangeTiming + "]";
    }

    /**
     * Builds a new {@link ResumeSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ResumeSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .resumeEffectiveDate(getResumeEffectiveDate())
                .resumeChangeTiming(getResumeChangeTiming());
        return builder;
    }

    /**
     * Class to build instances of {@link ResumeSubscriptionRequest}.
     */
    public static class Builder {
        private String resumeEffectiveDate;
        private String resumeChangeTiming;



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
         * Builds a new {@link ResumeSubscriptionRequest} object using the set fields.
         * @return {@link ResumeSubscriptionRequest}
         */
        public ResumeSubscriptionRequest build() {
            return new ResumeSubscriptionRequest(resumeEffectiveDate, resumeChangeTiming);
        }
    }
}
