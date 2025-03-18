package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateSubscriptionResponse type.
 */
public class UpdateSubscriptionResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Subscription subscription;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  subscription  Subscription value for subscription.
     */
    @JsonCreator
    public UpdateSubscriptionResponse(
            @JsonProperty("errors") List<Error> errors, @JsonProperty("subscription") Subscription subscription) {
        this.errors = errors;
        this.subscription = subscription;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Subscription.
     * Represents a subscription purchased by a customer. For more information, see [Manage
     * Subscriptions](https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions).
     * @return Returns the Subscription
     */
    @JsonGetter("subscription")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Subscription getSubscription() {
        return subscription;
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
        if (!(obj instanceof UpdateSubscriptionResponse)) {
            return false;
        }
        UpdateSubscriptionResponse other = (UpdateSubscriptionResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(subscription, other.subscription);
    }

    /**
     * Converts this UpdateSubscriptionResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateSubscriptionResponse [" + "errors=" + errors + ", subscription=" + subscription + "]";
    }

    /**
     * Builds a new {@link UpdateSubscriptionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateSubscriptionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).subscription(getSubscription());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateSubscriptionResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Subscription subscription;

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
         * Setter for subscription.
         * @param  subscription  Subscription value for subscription.
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
            UpdateSubscriptionResponse model = new UpdateSubscriptionResponse(errors, subscription);
            model.httpContext = httpContext;
            return model;
        }
    }
}
