package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BusinessHours type.
 */
public class BusinessHours {
    private final OptionalNullable<List<BusinessHoursPeriod>> periods;

    /**
     * Initialization constructor.
     * @param  periods  List of BusinessHoursPeriod value for periods.
     */
    @JsonCreator
    public BusinessHours(@JsonProperty("periods") List<BusinessHoursPeriod> periods) {
        this.periods = OptionalNullable.of(periods);
    }

    /**
     * Initialization constructor.
     * @param  periods  List of BusinessHoursPeriod value for periods.
     */
    protected BusinessHours(OptionalNullable<List<BusinessHoursPeriod>> periods) {
        this.periods = periods;
    }

    /**
     * Internal Getter for Periods.
     * The list of time periods during which the business is open. There can be at most 10 periods
     * per day.
     * @return Returns the Internal List of BusinessHoursPeriod
     */
    @JsonGetter("periods")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<BusinessHoursPeriod>> internalGetPeriods() {
        return this.periods;
    }

    /**
     * Getter for Periods.
     * The list of time periods during which the business is open. There can be at most 10 periods
     * per day.
     * @return Returns the List of BusinessHoursPeriod
     */
    @JsonIgnore
    public List<BusinessHoursPeriod> getPeriods() {
        return OptionalNullable.getFrom(periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periods);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessHours)) {
            return false;
        }
        BusinessHours other = (BusinessHours) obj;
        return Objects.equals(periods, other.periods);
    }

    /**
     * Converts this BusinessHours into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BusinessHours [" + "periods=" + periods + "]";
    }

    /**
     * Builds a new {@link BusinessHours.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BusinessHours.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.periods = internalGetPeriods();
        return builder;
    }

    /**
     * Class to build instances of {@link BusinessHours}.
     */
    public static class Builder {
        private OptionalNullable<List<BusinessHoursPeriod>> periods;

        /**
         * Setter for periods.
         * @param  periods  List of BusinessHoursPeriod value for periods.
         * @return Builder
         */
        public Builder periods(List<BusinessHoursPeriod> periods) {
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
         * Builds a new {@link BusinessHours} object using the set fields.
         * @return {@link BusinessHours}
         */
        public BusinessHours build() {
            return new BusinessHours(periods);
        }
    }
}
