
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
 * This is a model class for ChangeBillingAnchorDateRequest type.
 */
public class ChangeBillingAnchorDateRequest {
    private final OptionalNullable<Integer> monthlyBillingAnchorDate;
    private final OptionalNullable<String> effectiveDate;

    /**
     * Initialization constructor.
     * @param  monthlyBillingAnchorDate  Integer value for monthlyBillingAnchorDate.
     * @param  effectiveDate  String value for effectiveDate.
     */
    @JsonCreator
    public ChangeBillingAnchorDateRequest(
            @JsonProperty("monthly_billing_anchor_date") Integer monthlyBillingAnchorDate,
            @JsonProperty("effective_date") String effectiveDate) {
        this.monthlyBillingAnchorDate = OptionalNullable.of(monthlyBillingAnchorDate);
        this.effectiveDate = OptionalNullable.of(effectiveDate);
    }

    /**
     * Internal initialization constructor.
     */
    protected ChangeBillingAnchorDateRequest(OptionalNullable<Integer> monthlyBillingAnchorDate,
            OptionalNullable<String> effectiveDate) {
        this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
        this.effectiveDate = effectiveDate;
    }

    /**
     * Internal Getter for MonthlyBillingAnchorDate.
     * The anchor day for the billing cycle.
     * @return Returns the Internal Integer
     */
    @JsonGetter("monthly_billing_anchor_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetMonthlyBillingAnchorDate() {
        return this.monthlyBillingAnchorDate;
    }

    /**
     * Getter for MonthlyBillingAnchorDate.
     * The anchor day for the billing cycle.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getMonthlyBillingAnchorDate() {
        return OptionalNullable.getFrom(monthlyBillingAnchorDate);
    }

    /**
     * Internal Getter for EffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the scheduled `BILLING_ANCHOR_CHANGE` action takes place
     * on the subscription. When this date is unspecified or falls within the current billing cycle,
     * the billing anchor date is changed immediately.
     * @return Returns the Internal String
     */
    @JsonGetter("effective_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Getter for EffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the scheduled `BILLING_ANCHOR_CHANGE` action takes place
     * on the subscription. When this date is unspecified or falls within the current billing cycle,
     * the billing anchor date is changed immediately.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEffectiveDate() {
        return OptionalNullable.getFrom(effectiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyBillingAnchorDate, effectiveDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChangeBillingAnchorDateRequest)) {
            return false;
        }
        ChangeBillingAnchorDateRequest other = (ChangeBillingAnchorDateRequest) obj;
        return Objects.equals(monthlyBillingAnchorDate, other.monthlyBillingAnchorDate)
            && Objects.equals(effectiveDate, other.effectiveDate);
    }

    /**
     * Converts this ChangeBillingAnchorDateRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ChangeBillingAnchorDateRequest [" + "monthlyBillingAnchorDate="
                + monthlyBillingAnchorDate + ", effectiveDate=" + effectiveDate + "]";
    }

    /**
     * Builds a new {@link ChangeBillingAnchorDateRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChangeBillingAnchorDateRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.monthlyBillingAnchorDate = internalGetMonthlyBillingAnchorDate();
        builder.effectiveDate = internalGetEffectiveDate();
        return builder;
    }

    /**
     * Class to build instances of {@link ChangeBillingAnchorDateRequest}.
     */
    public static class Builder {
        private OptionalNullable<Integer> monthlyBillingAnchorDate;
        private OptionalNullable<String> effectiveDate;



        /**
         * Setter for monthlyBillingAnchorDate.
         * @param  monthlyBillingAnchorDate  Integer value for monthlyBillingAnchorDate.
         * @return Builder
         */
        public Builder monthlyBillingAnchorDate(Integer monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = OptionalNullable.of(monthlyBillingAnchorDate);
            return this;
        }

        /**
         * UnSetter for monthlyBillingAnchorDate.
         * @return Builder
         */
        public Builder unsetMonthlyBillingAnchorDate() {
            monthlyBillingAnchorDate = null;
            return this;
        }

        /**
         * Setter for effectiveDate.
         * @param  effectiveDate  String value for effectiveDate.
         * @return Builder
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = OptionalNullable.of(effectiveDate);
            return this;
        }

        /**
         * UnSetter for effectiveDate.
         * @return Builder
         */
        public Builder unsetEffectiveDate() {
            effectiveDate = null;
            return this;
        }

        /**
         * Builds a new {@link ChangeBillingAnchorDateRequest} object using the set fields.
         * @return {@link ChangeBillingAnchorDateRequest}
         */
        public ChangeBillingAnchorDateRequest build() {
            return new ChangeBillingAnchorDateRequest(monthlyBillingAnchorDate, effectiveDate);
        }
    }
}
