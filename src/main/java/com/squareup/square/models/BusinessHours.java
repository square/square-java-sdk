package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BusinessHours {

    @JsonCreator
    public BusinessHours(
            @JsonProperty("periods") List<BusinessHoursPeriod> periods) {
        this.periods = periods;
    }

    private final List<BusinessHoursPeriod> periods;

    @Override
    public int hashCode() {
        return Objects.hash(periods);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BusinessHours)) {
            return false;
        }
        BusinessHours businessHours = (BusinessHours) o;
        return Objects.equals(periods, businessHours.periods);
    }

    /**
     * Getter for Periods.
     * The list of time periods during which the business is open. There may be at most 10
     * periods per day.
     */
    @JsonGetter("periods")
    public List<BusinessHoursPeriod> getPeriods() { 
        return this.periods;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .periods(getPeriods());
            return builder;
    }

    public static class Builder {
        private List<BusinessHoursPeriod> periods;

        public Builder() { }

        public Builder periods(List<BusinessHoursPeriod> value) {
            periods = value;
            return this;
        }

        public BusinessHours build() {
            return new BusinessHours(periods);
        }
    }
}
