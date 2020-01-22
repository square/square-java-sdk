package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ShiftWage type.
 */
public class ShiftWage {

    /**
     * Initialization constructor.
     * @param title
     * @param hourlyRate
     */
    @JsonCreator
    public ShiftWage(
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate) {
        this.title = title;
        this.hourlyRate = hourlyRate;
    }

    private final String title;
    private final Money hourlyRate;
    /**
     * Getter for Title.
     * The name of the job performed during this shift. Square
     * labor-reporting UIs may group shifts together by title.
     */
    @JsonGetter("title")
    public String getTitle() {
        return this.title;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(title, hourlyRate);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ShiftWage)) {
            return false;
        }
        ShiftWage shiftWage = (ShiftWage) obj;
        return Objects.equals(title, shiftWage.title) &&
            Objects.equals(hourlyRate, shiftWage.hourlyRate);
    }

    /**
     * Builds a new {@link ShiftWage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftWage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .title(getTitle())
            .hourlyRate(getHourlyRate());
            return builder;
    }

    /**
     * Class to build instances of {@link ShiftWage}
     */
    public static class Builder {
        private String title;
        private Money hourlyRate;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for title
         * @param title
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
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
         * Builds a new {@link ShiftWage} object using the set fields.
         * @return {@link ShiftWage}
         */
        public ShiftWage build() {
            return new ShiftWage(title,
                hourlyRate);
        }
    }
}
