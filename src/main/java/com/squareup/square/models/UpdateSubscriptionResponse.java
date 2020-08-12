package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpdateSubscriptionResponse type.
 */
public class UpdateSubscriptionResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param subscription
     */
    @JsonCreator
    public UpdateSubscriptionResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("subscription") Subscription subscription) {
        this.errors = errors;
        this.subscription = subscription;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Subscription subscription;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Subscription.
     * Represents a customer subscription to a subscription plan.
     * For an overview of the `Subscription` type, see 
     * [Subscription object](https://developer.squareup.com/docs/docs/subscriptions-api/overview#subscription-object-overview).
     */
    @JsonGetter("subscription")
    public Subscription getSubscription() {
        return this.subscription;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, subscription);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateSubscriptionResponse)) {
            return false;
        }
        UpdateSubscriptionResponse updateSubscriptionResponse = (UpdateSubscriptionResponse) obj;
        return Objects.equals(errors, updateSubscriptionResponse.errors) &&
            Objects.equals(subscription, updateSubscriptionResponse.subscription);
    }

    /**
     * Builds a new {@link UpdateSubscriptionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateSubscriptionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .subscription(getSubscription());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateSubscriptionResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Subscription subscription;

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
         * Setter for subscription
         * @param subscription
         * @return Builder
         */
        public Builder subscription(Subscription subscription) {
            this.subscription = subscription;
            return this;
        }

        /**
         * Builds a new {@link UpdateSubscriptionResponse} object using the set fields.
         * @return {@link UpdateSubscriptionResponse}
         */
        public UpdateSubscriptionResponse build() {
            UpdateSubscriptionResponse model = new UpdateSubscriptionResponse(errors,
                subscription);
            model.httpContext = httpContext;
            return model;
        }
    }
}
