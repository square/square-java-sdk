package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RedeemLoyaltyRewardResponse type.
 */
public class RedeemLoyaltyRewardResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param event
     */
    @JsonCreator
    public RedeemLoyaltyRewardResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("event") LoyaltyEvent event) {
        this.errors = errors;
        this.event = event;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyEvent event;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Event.
     * Provides information about a loyalty event. 
     * For more information, see [Loyalty events](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-events).
     */
    @JsonGetter("event")
    public LoyaltyEvent getEvent() {
        return this.event;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, event);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RedeemLoyaltyRewardResponse)) {
            return false;
        }
        RedeemLoyaltyRewardResponse redeemLoyaltyRewardResponse = (RedeemLoyaltyRewardResponse) obj;
        return Objects.equals(errors, redeemLoyaltyRewardResponse.errors) &&
            Objects.equals(event, redeemLoyaltyRewardResponse.event);
    }

    /**
     * Builds a new {@link RedeemLoyaltyRewardResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RedeemLoyaltyRewardResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .event(getEvent());
            return builder;
    }

    /**
     * Class to build instances of {@link RedeemLoyaltyRewardResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyEvent event;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for event
         * @param event
         * @return Builder
         */
        public Builder event(LoyaltyEvent event) {
            this.event = event;
            return this;
        }

        /**
         * Builds a new {@link RedeemLoyaltyRewardResponse} object using the set fields.
         * @return {@link RedeemLoyaltyRewardResponse}
         */
        public RedeemLoyaltyRewardResponse build() {
            RedeemLoyaltyRewardResponse model = new RedeemLoyaltyRewardResponse(errors,
                event);
            model.httpContext = httpContext;
            return model;
        }
    }
}
