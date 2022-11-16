
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogTimePeriod type.
 */
public class CatalogTimePeriod {
    private final OptionalNullable<String> event;

    /**
     * Initialization constructor.
     * @param  event  String value for event.
     */
    @JsonCreator
    public CatalogTimePeriod(
            @JsonProperty("event") String event) {
        this.event = OptionalNullable.of(event);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogTimePeriod(OptionalNullable<String> event) {
        this.event = event;
    }

    /**
     * Internal Getter for Event.
     * An iCalendar (RFC 5545) [event](https://tools.ietf.org/html/rfc5545#section-3.6.1), which
     * specifies the name, timing, duration and recurrence of this time period. Example: ```
     * DTSTART:20190707T180000 DURATION:P2H RRULE:FREQ=WEEKLY;BYDAY=MO,WE,FR ``` Only `SUMMARY`,
     * `DTSTART`, `DURATION` and `RRULE` fields are supported. `DTSTART` must be in local (unzoned)
     * time format. Note that while `BEGIN:VEVENT` and `END:VEVENT` is not required in the request.
     * The response will always include them.
     * @return Returns the Internal String
     */
    @JsonGetter("event")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEvent() {
        return this.event;
    }

    /**
     * Getter for Event.
     * An iCalendar (RFC 5545) [event](https://tools.ietf.org/html/rfc5545#section-3.6.1), which
     * specifies the name, timing, duration and recurrence of this time period. Example: ```
     * DTSTART:20190707T180000 DURATION:P2H RRULE:FREQ=WEEKLY;BYDAY=MO,WE,FR ``` Only `SUMMARY`,
     * `DTSTART`, `DURATION` and `RRULE` fields are supported. `DTSTART` must be in local (unzoned)
     * time format. Note that while `BEGIN:VEVENT` and `END:VEVENT` is not required in the request.
     * The response will always include them.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEvent() {
        return OptionalNullable.getFrom(event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogTimePeriod)) {
            return false;
        }
        CatalogTimePeriod other = (CatalogTimePeriod) obj;
        return Objects.equals(event, other.event);
    }

    /**
     * Converts this CatalogTimePeriod into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogTimePeriod [" + "event=" + event + "]";
    }

    /**
     * Builds a new {@link CatalogTimePeriod.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogTimePeriod.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.event = internalGetEvent();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogTimePeriod}.
     */
    public static class Builder {
        private OptionalNullable<String> event;



        /**
         * Setter for event.
         * @param  event  String value for event.
         * @return Builder
         */
        public Builder event(String event) {
            this.event = OptionalNullable.of(event);
            return this;
        }

        /**
         * UnSetter for event.
         * @return Builder
         */
        public Builder unsetEvent() {
            event = null;
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
