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
 * This is a model class for TestWebhookSubscriptionResponse type.
 */
public class TestWebhookSubscriptionResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final SubscriptionTestResult subscriptionTestResult;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  subscriptionTestResult  SubscriptionTestResult value for subscriptionTestResult.
     */
    @JsonCreator
    public TestWebhookSubscriptionResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("subscription_test_result") SubscriptionTestResult subscriptionTestResult) {
        this.errors = errors;
        this.subscriptionTestResult = subscriptionTestResult;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for SubscriptionTestResult.
     * Represents the details of a webhook subscription, including notification URL, event types,
     * and signature key.
     * @return Returns the SubscriptionTestResult
     */
    @JsonGetter("subscription_test_result")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SubscriptionTestResult getSubscriptionTestResult() {
        return subscriptionTestResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, subscriptionTestResult);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TestWebhookSubscriptionResponse)) {
            return false;
        }
        TestWebhookSubscriptionResponse other = (TestWebhookSubscriptionResponse) obj;
        return Objects.equals(errors, other.errors)
                && Objects.equals(subscriptionTestResult, other.subscriptionTestResult);
    }

    /**
     * Converts this TestWebhookSubscriptionResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TestWebhookSubscriptionResponse [" + "errors=" + errors + ", subscriptionTestResult="
                + subscriptionTestResult + "]";
    }

    /**
     * Builds a new {@link TestWebhookSubscriptionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TestWebhookSubscriptionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).subscriptionTestResult(getSubscriptionTestResult());
        return builder;
    }

    /**
     * Class to build instances of {@link TestWebhookSubscriptionResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private SubscriptionTestResult subscriptionTestResult;

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
         * Setter for subscriptionTestResult.
         * @param  subscriptionTestResult  SubscriptionTestResult value for subscriptionTestResult.
         * @return Builder
         */
        public Builder subscriptionTestResult(SubscriptionTestResult subscriptionTestResult) {
            this.subscriptionTestResult = subscriptionTestResult;
            return this;
        }

        /**
         * Builds a new {@link TestWebhookSubscriptionResponse} object using the set fields.
         * @return {@link TestWebhookSubscriptionResponse}
         */
        public TestWebhookSubscriptionResponse build() {
            TestWebhookSubscriptionResponse model = new TestWebhookSubscriptionResponse(errors, subscriptionTestResult);
            model.httpContext = httpContext;
            return model;
        }
    }
}
