package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogTimePeriod type.
 */
public class CatalogTimePeriod {

    /**
     * Initialization constructor.
     * @param event
     */
    @JsonCreator
    public CatalogTimePeriod(
            @JsonProperty("event") String event) {
        this.event = event;
    }

    private final String event;
    /**
     * Getter for Event.
     * An iCalendar (RFC5545) [event](https://tools.ietf.org/html/rfc5545#section-3.6.1), which
     * specifies the name, timing, duration and recurrence of this time period.
     * Example:
     * ```
     * DTSTART:20190707T180000
     * DURATION:P2H
     * RRULE:FREQ=WEEKLY;BYDAY=MO,WE,FR
     * ```
     * Only `SUMMARY`, `DTSTART`, `DURATION` and `RRULE` fields are supported.
     * `DTSTART` must be in local (unzoned) time format. Note that while `BEGIN:VEVENT`
     * and `END:VEVENT` is not required in the request. The response will always
     * include them.
     */
    @JsonGetter("event")
    public String getEvent() {
        return this.event;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(event);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogTimePeriod)) {
            return false;
        }
        CatalogTimePeriod catalogTimePeriod = (CatalogTimePeriod) obj;
        return Objects.equals(event, catalogTimePeriod.event);
    }

    /**
     * Builds a new {@link CatalogTimePeriod.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogTimePeriod.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .event(getEvent());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogTimePeriod}
     */
    public static class Builder {
        private String event;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for event
         * @param event
         * @return Builder
         */
        public Builder event(String event) {
            this.event = event;
            return this;
        }

        /**
         * Builds a new {@link CatalogTimePeriod} object using the set fields.
         * @return {@link CatalogTimePeriod}
         */
        public CatalogTimePeriod build() {
            return new CatalogTimePeriod(event);
        }
    }
}
