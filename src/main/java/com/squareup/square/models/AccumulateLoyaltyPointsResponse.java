
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for AccumulateLoyaltyPointsResponse type.
 */
public class AccumulateLoyaltyPointsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyEvent event;
    private final List<LoyaltyEvent> events;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  event  LoyaltyEvent value for event.
     * @param  events  List of LoyaltyEvent value for events.
     */
    @JsonCreator
    public AccumulateLoyaltyPointsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("event") LoyaltyEvent event,
            @JsonProperty("events") List<LoyaltyEvent> events) {
        this.errors = errors;
        this.event = event;
        this.events = events;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Event.
     * Provides information about a loyalty event. For more information, see [Search for
     * Balance-Changing Loyalty
     * Events](https://developer.squareup.com/docs/loyalty-api/loyalty-events).
     * @return Returns the LoyaltyEvent
     */
    @JsonGetter("event")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEvent getEvent() {
        return event;
    }

    /**
     * Getter for Events.
     * The resulting loyalty events. The `ACCUMULATE_POINTS` event is always included. When using
     * the Orders API, the `ACCUMULATE_PROMOTION_POINTS` event is included if the purchase also
     * qualifies for a loyalty promotion.
     * @return Returns the List of LoyaltyEvent
     */
    @JsonGetter("events")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<LoyaltyEvent> getEvents() {
        return events;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, event, events);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccumulateLoyaltyPointsResponse)) {
            return false;
        }
        AccumulateLoyaltyPointsResponse other = (AccumulateLoyaltyPointsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(event, other.event)
            && Objects.equals(events, other.events);
    }

    /**
     * Converts this AccumulateLoyaltyPointsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AccumulateLoyaltyPointsResponse [" + "errors=" + errors + ", event=" + event
                + ", events=" + events + "]";
    }

    /**
     * Builds a new {@link AccumulateLoyaltyPointsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AccumulateLoyaltyPointsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .event(getEvent())
                .events(getEvents());
        return builder;
    }

    /**
     * Class to build instances of {@link AccumulateLoyaltyPointsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyEvent event;
        private List<LoyaltyEvent> events;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for event.
         * @param  event  LoyaltyEvent value for event.
         * @return Builder
         */
        public Builder event(LoyaltyEvent event) {
            this.event = event;
            return this;
        }

        /**
         * Setter for events.
         * @param  events  List of LoyaltyEvent value for events.
         * @return Builder
         */
        public Builder events(List<LoyaltyEvent> events) {
            this.events = events;
            return this;
        }

        /**
         * Builds a new {@link AccumulateLoyaltyPointsResponse} object using the set fields.
         * @return {@link AccumulateLoyaltyPointsResponse}
         */
        public AccumulateLoyaltyPointsResponse build() {
            AccumulateLoyaltyPointsResponse model =
                    new AccumulateLoyaltyPointsResponse(errors, event, events);
            model.httpContext = httpContext;
            return model;
        }
    }
}
