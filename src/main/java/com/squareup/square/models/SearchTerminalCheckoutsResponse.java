package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchTerminalCheckoutsResponse type.
 */
public class SearchTerminalCheckoutsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param checkouts
     * @param cursor
     */
    @JsonCreator
    public SearchTerminalCheckoutsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("checkouts") List<TerminalCheckout> checkouts,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.checkouts = checkouts;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<TerminalCheckout> checkouts;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Checkouts.
     * The requested search result of `TerminalCheckout`s.
     */
    @JsonGetter("checkouts")
    public List<TerminalCheckout> getCheckouts() {
        return this.checkouts;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty,
     * this is the final response.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, checkouts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchTerminalCheckoutsResponse)) {
            return false;
        }
        SearchTerminalCheckoutsResponse searchTerminalCheckoutsResponse = (SearchTerminalCheckoutsResponse) obj;
        return Objects.equals(errors, searchTerminalCheckoutsResponse.errors) &&
            Objects.equals(checkouts, searchTerminalCheckoutsResponse.checkouts) &&
            Objects.equals(cursor, searchTerminalCheckoutsResponse.cursor);
    }

    /**
     * Builds a new {@link SearchTerminalCheckoutsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTerminalCheckoutsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .checkouts(getCheckouts())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchTerminalCheckoutsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<TerminalCheckout> checkouts;
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
         * Setter for checkouts
         * @param checkouts
         * @return Builder
         */
        public Builder checkouts(List<TerminalCheckout> checkouts) {
            this.checkouts = checkouts;
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
         * Builds a new {@link SearchTerminalCheckoutsResponse} object using the set fields.
         * @return {@link SearchTerminalCheckoutsResponse}
         */
        public SearchTerminalCheckoutsResponse build() {
            SearchTerminalCheckoutsResponse model = new SearchTerminalCheckoutsResponse(errors,
                checkouts,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
