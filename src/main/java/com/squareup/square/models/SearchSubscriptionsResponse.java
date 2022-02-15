
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
 * This is a model class for SearchSubscriptionsResponse type.
 */
public class SearchSubscriptionsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Subscription> subscriptions;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  subscriptions  List of Subscription value for subscriptions.
     * @param  cursor  String value for cursor.
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
     * Getter for Subscriptions.
     * The subscriptions matching the specified query expressions.
     * @return Returns the List of Subscription
     */
    @JsonGetter("subscriptions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Getter for Cursor.
     * When the total number of resulting subscription exceeds the limit of a paged response, the
     * response includes a cursor for you to use in a subsequent request to fetch the next set of
     * results. If the cursor is unset, the response contains the last page of the results. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
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
        if (!(obj instanceof SearchSubscriptionsResponse)) {
            return false;
        }
        SearchSubscriptionsResponse other = (SearchSubscriptionsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(subscriptions, other.subscriptions)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchSubscriptionsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchSubscriptionsResponse [" + "errors=" + errors + ", subscriptions="
                + subscriptions + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link SearchSubscriptionsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Subscription> subscriptions;
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
         * @param  subscriptions  List of Subscription value for subscriptions.
         * @return Builder
         */
        public Builder subscriptions(List<Subscription> subscriptions) {
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
         * Builds a new {@link SearchSubscriptionsResponse} object using the set fields.
         * @return {@link SearchSubscriptionsResponse}
         */
        public SearchSubscriptionsResponse build() {
            SearchSubscriptionsResponse model =
                    new SearchSubscriptionsResponse(errors, subscriptions, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
