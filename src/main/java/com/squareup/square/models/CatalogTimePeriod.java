package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogTimePeriod {

    @JsonCreator
    public CatalogTimePeriod(
            @JsonProperty("event") String event) {
        this.event = event;
    }

    private final String event;

    @Override
    public int hashCode() {
        return Objects.hash(event);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogTimePeriod)) {
            return false;
        }
        CatalogTimePeriod catalogTimePeriod = (CatalogTimePeriod) o;
        return Objects.equals(event, catalogTimePeriod.event);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .event(getEvent());
            return builder;
    }

    public static class Builder {
        private String event;

        public Builder() { }

        public Builder event(String value) {
            event = value;
            return this;
        }

        public CatalogTimePeriod build() {
            return new CatalogTimePeriod(event);
        }
    }
}
