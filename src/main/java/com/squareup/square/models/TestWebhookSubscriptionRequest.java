
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TestWebhookSubscriptionRequest type.
 */
public class TestWebhookSubscriptionRequest {
    private final String eventType;

    /**
     * Initialization constructor.
     * @param  eventType  String value for eventType.
     */
    @JsonCreator
    public TestWebhookSubscriptionRequest(
            @JsonProperty("event_type") String eventType) {
        this.eventType = eventType;
    }

    /**
     * Getter for EventType.
     * The event type that will be used to test the [Subscription]($m/WebhookSubscription). The
     * event type must be contained in the list of event types in the
     * [Subscription]($m/WebhookSubscription).
     * @return Returns the String
     */
    @JsonGetter("event_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEventType() {
        return eventType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TestWebhookSubscriptionRequest)) {
            return false;
        }
        TestWebhookSubscriptionRequest other = (TestWebhookSubscriptionRequest) obj;
        return Objects.equals(eventType, other.eventType);
    }

    /**
     * Converts this TestWebhookSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TestWebhookSubscriptionRequest [" + "eventType=" + eventType + "]";
    }

    /**
     * Builds a new {@link TestWebhookSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TestWebhookSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .eventType(getEventType());
        return builder;
    }

    /**
     * Class to build instances of {@link TestWebhookSubscriptionRequest}.
     */
    public static class Builder {
        private String eventType;



        /**
         * Setter for eventType.
         * @param  eventType  String value for eventType.
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Builds a new {@link TestWebhookSubscriptionRequest} object using the set fields.
         * @return {@link TestWebhookSubscriptionRequest}
         */
        public TestWebhookSubscriptionRequest build() {
            return new TestWebhookSubscriptionRequest(eventType);
        }
    }
}
