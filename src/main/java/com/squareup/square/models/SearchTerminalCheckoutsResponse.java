
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
 * This is a model class for SearchTerminalCheckoutsResponse type.
 */
public class SearchTerminalCheckoutsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<TerminalCheckout> checkouts;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  checkouts  List of TerminalCheckout value for checkouts.
     * @param  cursor  String value for cursor.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Checkouts.
     * The requested search result of `TerminalCheckout` objects.
     * @return Returns the List of TerminalCheckout
     */
    @JsonGetter("checkouts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<TerminalCheckout> getCheckouts() {
        return checkouts;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, checkouts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTerminalCheckoutsResponse)) {
            return false;
        }
        SearchTerminalCheckoutsResponse other = (SearchTerminalCheckoutsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(checkouts, other.checkouts)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchTerminalCheckoutsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTerminalCheckoutsResponse [" + "errors=" + errors + ", checkouts=" + checkouts
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link SearchTerminalCheckoutsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<TerminalCheckout> checkouts;
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
         * Setter for checkouts.
         * @param  checkouts  List of TerminalCheckout value for checkouts.
         * @return Builder
         */
        public Builder checkouts(List<TerminalCheckout> checkouts) {
            this.checkouts = checkouts;
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
         * Builds a new {@link SearchTerminalCheckoutsResponse} object using the set fields.
         * @return {@link SearchTerminalCheckoutsResponse}
         */
        public SearchTerminalCheckoutsResponse build() {
            SearchTerminalCheckoutsResponse model =
                    new SearchTerminalCheckoutsResponse(errors, checkouts, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
