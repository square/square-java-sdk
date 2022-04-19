
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
 * This is a model class for ListPayoutsResponse type.
 */
public class ListPayoutsResponse {
    private HttpContext httpContext;
    private final List<Payout> payouts;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  payouts  List of Payout value for payouts.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListPayoutsResponse(
            @JsonProperty("payouts") List<Payout> payouts,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.payouts = payouts;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Payouts.
     * The requested list of payouts.
     * @return Returns the List of Payout
     */
    @JsonGetter("payouts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Payout> getPayouts() {
        return payouts;
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

    @Override
    public int hashCode() {
        return Objects.hash(payouts, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPayoutsResponse)) {
            return false;
        }
        ListPayoutsResponse other = (ListPayoutsResponse) obj;
        return Objects.equals(payouts, other.payouts)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListPayoutsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPayoutsResponse [" + "payouts=" + payouts + ", cursor=" + cursor + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link ListPayoutsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPayoutsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .payouts(getPayouts())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPayoutsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Payout> payouts;
        private String cursor;
        private List<Error> errors;



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
         * Setter for payouts.
         * @param  payouts  List of Payout value for payouts.
         * @return Builder
         */
        public Builder payouts(List<Payout> payouts) {
            this.payouts = payouts;
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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListPayoutsResponse} object using the set fields.
         * @return {@link ListPayoutsResponse}
         */
        public ListPayoutsResponse build() {
            ListPayoutsResponse model =
                    new ListPayoutsResponse(payouts, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
