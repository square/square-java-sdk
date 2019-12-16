package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ShiftWage {

    @JsonCreator
    public ShiftWage(
            @JsonProperty("title") String title,
            @JsonProperty("hourly_rate") Money hourlyRate) {
        this.title = title;
        this.hourlyRate = hourlyRate;
    }

    private final String title;
    private final Money hourlyRate;

    @Override
    public int hashCode() {
        return Objects.hash(title, hourlyRate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ShiftWage)) {
            return false;
        }
        ShiftWage shiftWage = (ShiftWage) o;
        return Objects.equals(title, shiftWage.title) &&
            Objects.equals(hourlyRate, shiftWage.hourlyRate);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .title(getTitle())
            .hourlyRate(getHourlyRate());
            return builder;
    }

    public static class Builder {
        private String title;
        private Money hourlyRate;

        public Builder() { }

        public Builder title(String value) {
            title = value;
            return this;
        }
        public Builder hourlyRate(Money value) {
            hourlyRate = value;
            return this;
        }

        public ShiftWage build() {
            return new ShiftWage(title,
                hourlyRate);
        }
    }
}
