
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
 * This is a model class for ListWebhookSubscriptionsResponse type.
 */
public class ListWebhookSubscriptionsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<WebhookSubscription> subscriptions;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  subscriptions  List of WebhookSubscription value for subscriptions.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListWebhookSubscriptionsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("subscriptions") List<WebhookSubscription> subscriptions,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.subscriptions = subscriptions;
        this.cursor = cursor;
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
     * Getter for Subscriptions.
     * The requested list of [Subscription]($m/WebhookSubscription)s.
     * @return Returns the List of WebhookSubscription
     */
    @JsonGetter("subscriptions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<WebhookSubscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, subscriptions, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListWebhookSubscriptionsResponse)) {
            return false;
        }
        ListWebhookSubscriptionsResponse other = (ListWebhookSubscriptionsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(subscriptions, other.subscriptions)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListWebhookSubscriptionsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListWebhookSubscriptionsResponse [" + "errors=" + errors + ", subscriptions="
                + subscriptions + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListWebhookSubscriptionsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListWebhookSubscriptionsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .subscriptions(getSubscriptions())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListWebhookSubscriptionsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<WebhookSubscription> subscriptions;
        private String cursor;



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
         * Setter for subscriptions.
         * @param  subscriptions  List of WebhookSubscription value for subscriptions.
         * @return Builder
         */
        public Builder subscriptions(List<WebhookSubscription> subscriptions) {
            this.subscriptions = subscriptions;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListWebhookSubscriptionsResponse} object using the set fields.
         * @return {@link ListWebhookSubscriptionsResponse}
         */
        public ListWebhookSubscriptionsResponse build() {
            ListWebhookSubscriptionsResponse model =
                    new ListWebhookSubscriptionsResponse(errors, subscriptions, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
