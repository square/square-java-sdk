package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BusinessHours type.
 */
public class BusinessHours {

    /**
     * Initialization constructor.
     * @param periods
     */
    @JsonCreator
    public BusinessHours(
            @JsonProperty("periods") List<BusinessHoursPeriod> periods) {
        this.periods = periods;
    }

    private final List<BusinessHoursPeriod> periods;
    /**
     * Getter for Periods.
     * The list of time periods during which the business is open. There may be at most 10
     * periods per day.
     */
    @JsonGetter("periods")
    public List<BusinessHoursPeriod> getPeriods() {
        return this.periods;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(periods);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BusinessHours)) {
            return false;
        }
        BusinessHours businessHours = (BusinessHours) obj;
        return Objects.equals(periods, businessHours.periods);
    }

    /**
     * Builds a new {@link BusinessHours.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessHours.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .periods(getPeriods());
            return builder;
    }

    /**
     * Class to build instances of {@link BusinessHours}
     */
    public static class Builder {
        private List<BusinessHoursPeriod> periods;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for periods
         * @param periods
         * @return Builder
         */
        public Builder periods(List<BusinessHoursPeriod> periods) {
            this.periods = periods;
            return this;
        }

        /**
         * Builds a new {@link BusinessHours} object using the set fields.
         * @return {@link BusinessHours}
         */
        public BusinessHours build() {
            return new BusinessHours(periods);
        }
    }
}
