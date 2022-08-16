
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyPromotionTriggerLimit type.
 */
public class LoyaltyPromotionTriggerLimit {
    private final int times;
    private final String interval;

    /**
     * Initialization constructor.
     * @param  times  int value for times.
     * @param  interval  String value for interval.
     */
    @JsonCreator
    public LoyaltyPromotionTriggerLimit(
            @JsonProperty("times") int times,
            @JsonProperty("interval") String interval) {
        this.times = times;
        this.interval = interval;
    }

    /**
     * Getter for Times.
     * The maximum number of times a buyer can trigger the promotion during the specified
     * `interval`.
     * @return Returns the int
     */
    @JsonGetter("times")
    public int getTimes() {
        return times;
    }

    /**
     * Getter for Interval.
     * Indicates the time period that the [trigger limit]($m/LoyaltyPromotionTriggerLimit) applies
     * to, which is used to determine the number of times a buyer can earn points for a [loyalty
     * promotion]($m/LoyaltyPromotion).
     * @return Returns the String
     */
    @JsonGetter("interval")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInterval() {
        return interval;
    }

    @Override
    public int hashCode() {
        return Objects.hash(times, interval);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyPromotionTriggerLimit)) {
            return false;
        }
        LoyaltyPromotionTriggerLimit other = (LoyaltyPromotionTriggerLimit) obj;
        return Objects.equals(times, other.times)
            && Objects.equals(interval, other.interval);
    }

    /**
     * Converts this LoyaltyPromotionTriggerLimit into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyPromotionTriggerLimit [" + "times=" + times + ", interval=" + interval + "]";
    }

    /**
     * Builds a new {@link LoyaltyPromotionTriggerLimit.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyPromotionTriggerLimit.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(times)
                .interval(getInterval());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyPromotionTriggerLimit}.
     */
    public static class Builder {
        private int times;
        private String interval;

        /**
         * Initialization constructor.
         * @param  times  int value for times.
         */
        public Builder(int times) {
            this.times = times;
        }

        /**
         * Setter for times.
         * @param  times  int value for times.
         * @return Builder
         */
        public Builder times(int times) {
            this.times = times;
            return this;
        }

        /**
         * Setter for interval.
         * @param  interval  String value for interval.
         * @return Builder
         */
        public Builder interval(String interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyPromotionTriggerLimit} object using the set fields.
         * @return {@link LoyaltyPromotionTriggerLimit}
         */
        public LoyaltyPromotionTriggerLimit build() {
            return new LoyaltyPromotionTriggerLimit(times, interval);
        }
    }
}
