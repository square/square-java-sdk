package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchSubscriptionsResponse type.
 */
public class SearchSubscriptionsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param subscriptions
     * @param cursor
     */
    @JsonCreator
    public SearchSubscriptionsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("subscriptions") List<Subscription> subscriptions,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.subscriptions = subscriptions;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Subscription> subscriptions;
    private final String cursor;

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
     * Getter for Subscriptions.
     * The search result.
     */
    @JsonGetter("subscriptions")
    public List<Subscription> getSubscriptions() {
        return this.subscriptions;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can 
     * use in a subsequent request to fetch the next set of subscriptions. 
     * If empty, this is the final response.
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, subscriptions, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchSubscriptionsResponse)) {
            return false;
        }
        SearchSubscriptionsResponse searchSubscriptionsResponse = (SearchSubscriptionsResponse) obj;
        return Objects.equals(errors, searchSubscriptionsResponse.errors) &&
            Objects.equals(subscriptions, searchSubscriptionsResponse.subscriptions) &&
            Objects.equals(cursor, searchSubscriptionsResponse.cursor);
    }

    /**
     * Builds a new {@link SearchSubscriptionsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchSubscriptionsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .subscriptions(getSubscriptions())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Subscription> subscriptions;
        private String cursor;

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
         * Setter for subscriptions
         * @param subscriptions
         * @return Builder
         */
        public Builder subscriptions(List<Subscription> subscriptions) {
            this.subscriptions = subscriptions;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsResponse} object using the set fields.
         * @return {@link SearchSubscriptionsResponse}
         */
        public SearchSubscriptionsResponse build() {
            SearchSubscriptionsResponse model = new SearchSubscriptionsResponse(errors,
                subscriptions,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
