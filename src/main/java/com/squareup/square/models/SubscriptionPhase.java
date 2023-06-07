
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
 * This is a model class for SubscriptionPhase type.
 */
public class SubscriptionPhase {
    private final OptionalNullable<String> uid;
    private final String cadence;
    private final OptionalNullable<Integer> periods;
    private final Money recurringPriceMoney;
    private final OptionalNullable<Long> ordinal;
    private final SubscriptionPricing pricing;

    /**
     * Initialization constructor.
     * @param  cadence  String value for cadence.
     * @param  uid  String value for uid.
     * @param  periods  Integer value for periods.
     * @param  recurringPriceMoney  Money value for recurringPriceMoney.
     * @param  ordinal  Long value for ordinal.
     * @param  pricing  SubscriptionPricing value for pricing.
     */
    @JsonCreator
    public SubscriptionPhase(
            @JsonProperty("cadence") String cadence,
            @JsonProperty("uid") String uid,
            @JsonProperty("periods") Integer periods,
            @JsonProperty("recurring_price_money") Money recurringPriceMoney,
            @JsonProperty("ordinal") Long ordinal,
            @JsonProperty("pricing") SubscriptionPricing pricing) {
        this.uid = OptionalNullable.of(uid);
        this.cadence = cadence;
        this.periods = OptionalNullable.of(periods);
        this.recurringPriceMoney = recurringPriceMoney;
        this.ordinal = OptionalNullable.of(ordinal);
        this.pricing = pricing;
    }

    /**
     * Internal initialization constructor.
     */
    protected SubscriptionPhase(String cadence, OptionalNullable<String> uid,
            OptionalNullable<Integer> periods, Money recurringPriceMoney,
            OptionalNullable<Long> ordinal, SubscriptionPricing pricing) {
        this.uid = uid;
        this.cadence = cadence;
        this.periods = periods;
        this.recurringPriceMoney = recurringPriceMoney;
        this.ordinal = ordinal;
        this.pricing = pricing;
    }

    /**
     * Internal Getter for Uid.
     * The Square-assigned ID of the subscription phase. This field cannot be changed after a
     * `SubscriptionPhase` is created.
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * The Square-assigned ID of the subscription phase. This field cannot be changed after a
     * `SubscriptionPhase` is created.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
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
     * Internal Getter for Periods.
     * The number of `cadence`s the phase lasts. If not set, the phase never ends. Only the last
     * phase can be indefinite. This field cannot be changed after a `SubscriptionPhase` is created.
     * @return Returns the Internal Integer
     */
    @JsonGetter("periods")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetPeriods() {
        return this.periods;
    }

    /**
     * Getter for Periods.
     * The number of `cadence`s the phase lasts. If not set, the phase never ends. Only the last
     * phase can be indefinite. This field cannot be changed after a `SubscriptionPhase` is created.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getPeriods() {
        return OptionalNullable.getFrom(periods);
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
     * Internal Getter for Ordinal.
     * The position this phase appears in the sequence of phases defined for the plan, indexed from
     * 0. This field cannot be changed after a `SubscriptionPhase` is created.
     * @return Returns the Internal Long
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for Ordinal.
     * The position this phase appears in the sequence of phases defined for the plan, indexed from
     * 0. This field cannot be changed after a `SubscriptionPhase` is created.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getOrdinal() {
        return OptionalNullable.getFrom(ordinal);
    }

    /**
     * Getter for Pricing.
     * Describes the pricing for the subscription.
     * @return Returns the SubscriptionPricing
     */
    @JsonGetter("pricing")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SubscriptionPricing getPricing() {
        return pricing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, cadence, periods, recurringPriceMoney, ordinal, pricing);
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
            && Objects.equals(ordinal, other.ordinal)
            && Objects.equals(pricing, other.pricing);
    }

    /**
     * Converts this SubscriptionPhase into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionPhase [" + "cadence=" + cadence + ", uid=" + uid + ", periods="
                + periods + ", recurringPriceMoney=" + recurringPriceMoney + ", ordinal=" + ordinal
                + ", pricing=" + pricing + "]";
    }

    /**
     * Builds a new {@link SubscriptionPhase.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionPhase.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(cadence)
                .recurringPriceMoney(getRecurringPriceMoney())
                .pricing(getPricing());
        builder.uid = internalGetUid();
        builder.periods = internalGetPeriods();
        builder.ordinal = internalGetOrdinal();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionPhase}.
     */
    public static class Builder {
        private String cadence;
        private OptionalNullable<String> uid;
        private OptionalNullable<Integer> periods;
        private Money recurringPriceMoney;
        private OptionalNullable<Long> ordinal;
        private SubscriptionPricing pricing;

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
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Setter for periods.
         * @param  periods  Integer value for periods.
         * @return Builder
         */
        public Builder periods(Integer periods) {
            this.periods = OptionalNullable.of(periods);
            return this;
        }

        /**
         * UnSetter for periods.
         * @return Builder
         */
        public Builder unsetPeriods() {
            periods = null;
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
            this.ordinal = OptionalNullable.of(ordinal);
            return this;
        }

        /**
         * UnSetter for ordinal.
         * @return Builder
         */
        public Builder unsetOrdinal() {
            ordinal = null;
            return this;
        }

        /**
         * Setter for pricing.
         * @param  pricing  SubscriptionPricing value for pricing.
         * @return Builder
         */
        public Builder pricing(SubscriptionPricing pricing) {
            this.pricing = pricing;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionPhase} object using the set fields.
         * @return {@link SubscriptionPhase}
         */
        public SubscriptionPhase build() {
            return new SubscriptionPhase(cadence, uid, periods, recurringPriceMoney, ordinal,
                    pricing);
        }
    }
}
