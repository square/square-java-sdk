
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for AdjustLoyaltyPointsResponse type.
 */
public class AdjustLoyaltyPointsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final LoyaltyEvent event;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  event  LoyaltyEvent value for event.
     */
    @JsonCreator
    public AdjustLoyaltyPointsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("event") LoyaltyEvent event) {
        this.errors = errors;
        this.event = event;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Event.
     * Provides information about a loyalty event. For more information, see [Loyalty
     * events](https://developer.squareup.com/docs/loyalty-api/overview/#loyalty-events).
     * @return Returns the LoyaltyEvent
     */
    @JsonGetter("event")
    public LoyaltyEvent getEvent() {
        return event;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, event);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdjustLoyaltyPointsResponse)) {
            return false;
        }
        AdjustLoyaltyPointsResponse other = (AdjustLoyaltyPointsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(event, other.event);
    }

    /**
     * Converts this AdjustLoyaltyPointsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AdjustLoyaltyPointsResponse [" + "errors=" + errors + ", event=" + event + "]";
    }

    /**
     * Builds a new {@link AdjustLoyaltyPointsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdjustLoyaltyPointsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .event(getEvent());
        return builder;
    }

    /**
     * Class to build instances of {@link AdjustLoyaltyPointsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyEvent event;



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
         * Builds a new {@link AdjustLoyaltyPointsResponse} object using the set fields.
         * @return {@link AdjustLoyaltyPointsResponse}
         */
        public AdjustLoyaltyPointsResponse build() {
            AdjustLoyaltyPointsResponse model =
                    new AdjustLoyaltyPointsResponse(errors, event);
            model.httpContext = httpContext;
            return model;
        }
    }
}
