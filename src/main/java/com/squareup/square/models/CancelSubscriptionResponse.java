
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CancelSubscriptionResponse type.
 */
public class CancelSubscriptionResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Subscription subscription;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param subscription Subscription value for subscription.
     */
    @JsonCreator
    public CancelSubscriptionResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("subscription") Subscription subscription) {
        this.errors = errors;
        this.subscription = subscription;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Subscription.
     * Represents a customer subscription to a subscription plan. For an overview of the
     * `Subscription` type, see [Subscription
     * object](https://developer.squareup.com/docs/docs/subscriptions-api/overview#subscription-object-overview).
     * @return Returns the Subscription
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelSubscriptionResponse)) {
            return false;
        }
        CancelSubscriptionResponse other = (CancelSubscriptionResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(subscription, other.subscription);
    }

    /**
     * Builds a new {@link CancelSubscriptionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelSubscriptionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .subscription(getSubscription());
        return builder;
    }

    /**
     * Class to build instances of {@link CancelSubscriptionResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Subscription subscription;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for subscription.
         * @param subscription Subscription value for subscription.
         * @return Builder
         */
        public Builder subscription(Subscription subscription) {
            this.subscription = subscription;
            return this;
        }

        /**
         * Builds a new {@link CancelSubscriptionResponse} object using the set fields.
         * @return {@link CancelSubscriptionResponse}
         */
        public CancelSubscriptionResponse build() {
            CancelSubscriptionResponse model =
                    new CancelSubscriptionResponse(errors,
                            subscription);
            model.httpContext = httpContext;
            return model;
        }
    }
}
