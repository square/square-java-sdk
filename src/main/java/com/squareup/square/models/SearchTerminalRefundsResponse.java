
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchTerminalRefundsResponse type.
 */
public class SearchTerminalRefundsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<TerminalRefund> refunds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  refunds  List of TerminalRefund value for refunds.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public SearchTerminalRefundsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refunds") List<TerminalRefund> refunds,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.refunds = refunds;
        this.cursor = cursor;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Refunds.
     * The requested search result of `TerminalRefund`s.
     * @return Returns the List of TerminalRefund
     */
    @JsonGetter("refunds")
    public List<TerminalRefund> getRefunds() {
        return refunds;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, refunds, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchTerminalRefundsResponse)) {
            return false;
        }
        SearchTerminalRefundsResponse other = (SearchTerminalRefundsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(refunds, other.refunds)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchTerminalRefundsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchTerminalRefundsResponse [" + "errors=" + errors + ", refunds=" + refunds
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link SearchTerminalRefundsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchTerminalRefundsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .refunds(getRefunds())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchTerminalRefundsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<TerminalRefund> refunds;
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
         * Setter for refunds.
         * @param  refunds  List of TerminalRefund value for refunds.
         * @return Builder
         */
        public Builder refunds(List<TerminalRefund> refunds) {
            this.refunds = refunds;
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
         * Builds a new {@link SearchTerminalRefundsResponse} object using the set fields.
         * @return {@link SearchTerminalRefundsResponse}
         */
        public SearchTerminalRefundsResponse build() {
            SearchTerminalRefundsResponse model =
                    new SearchTerminalRefundsResponse(errors, refunds, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
