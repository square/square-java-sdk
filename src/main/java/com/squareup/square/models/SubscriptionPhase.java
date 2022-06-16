
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SubscriptionPhase type.
 */
public class SubscriptionPhase {
    private final String uid;
    private final String cadence;
    private final Integer periods;
    private final Money recurringPriceMoney;
    private final Long ordinal;

    /**
     * Initialization constructor.
     * @param  cadence  String value for cadence.
     * @param  uid  String value for uid.
     * @param  periods  Integer value for periods.
     * @param  recurringPriceMoney  Money value for recurringPriceMoney.
     * @param  ordinal  Long value for ordinal.
     */
    @JsonCreator
    public SubscriptionPhase(
            @JsonProperty("cadence") String cadence,
            @JsonProperty("uid") String uid,
            @JsonProperty("periods") Integer periods,
            @JsonProperty("recurring_price_money") Money recurringPriceMoney,
            @JsonProperty("ordinal") Long ordinal) {
        this.uid = uid;
        this.cadence = cadence;
        this.periods = periods;
        this.recurringPriceMoney = recurringPriceMoney;
        this.ordinal = ordinal;
    }

    /**
     * Getter for Uid.
     * The Square-assigned ID of the subscription phase. This field cannot be changed after a
     * `SubscriptionPhase` is created.
     * @return Returns the String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUid() {
        return uid;
    }

    /**
     * Getter for Cadence.
     * Determines the billing cadence of a [Subscription]($m/Subscription)
     * @return Returns the String
     */
    @JsonGetter("cadence")
    public String getCadence() {
        return cadence;
    }

    /**
     * Getter for Periods.
     * The number of `cadence`s the phase lasts. If not set, the phase never ends. Only the last
     * phase can be indefinite. This field cannot be changed after a `SubscriptionPhase` is created.
     * @return Returns the Integer
     */
    @JsonGetter("periods")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getPeriods() {
        return periods;
    }

    /**
     * Getter for RecurringPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("recurring_price_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getRecurringPriceMoney() {
        return recurringPriceMoney;
    }

    /**
     * Getter for Ordinal.
     * The position this phase appears in the sequence of phases defined for the plan, indexed from
     * 0. This field cannot be changed after a `SubscriptionPhase` is created.
     * @return Returns the Long
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getOrdinal() {
        return ordinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, cadence, periods, recurringPriceMoney, ordinal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionPhase)) {
            return false;
        }
        SubscriptionPhase other = (SubscriptionPhase) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(cadence, other.cadence)
            && Objects.equals(periods, other.periods)
            && Objects.equals(recurringPriceMoney, other.recurringPriceMoney)
            && Objects.equals(ordinal, other.ordinal);
    }

    /**
     * Converts this SubscriptionPhase into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionPhase [" + "cadence=" + cadence + ", uid=" + uid + ", periods="
                + periods + ", recurringPriceMoney=" + recurringPriceMoney + ", ordinal=" + ordinal
                + "]";
    }

    /**
     * Builds a new {@link SubscriptionPhase.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionPhase.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(cadence)
                .uid(getUid())
                .periods(getPeriods())
                .recurringPriceMoney(getRecurringPriceMoney())
                .ordinal(getOrdinal());
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionPhase}.
     */
    public static class Builder {
        private String cadence;
        private String uid;
        private Integer periods;
        private Money recurringPriceMoney;
        private Long ordinal;

        /**
         * Initialization constructor.
         * @param  cadence  String value for cadence.
         */
        public Builder(String cadence) {
            this.cadence = cadence;
        }

        /**
         * Setter for cadence.
         * @param  cadence  String value for cadence.
         * @return Builder
         */
        public Builder cadence(String cadence) {
            this.cadence = cadence;
            return this;
        }

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for periods.
         * @param  periods  Integer value for periods.
         * @return Builder
         */
        public Builder periods(Integer periods) {
            this.periods = periods;
            return this;
        }

        /**
         * Setter for recurringPriceMoney.
         * @param  recurringPriceMoney  Money value for recurringPriceMoney.
         * @return Builder
         */
        public Builder recurringPriceMoney(Money recurringPriceMoney) {
            this.recurringPriceMoney = recurringPriceMoney;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Long value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Long ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionPhase} object using the set fields.
         * @return {@link SubscriptionPhase}
         */
        public SubscriptionPhase build() {
            return new SubscriptionPhase(cadence, uid, periods, recurringPriceMoney, ordinal);
        }
    }
}
