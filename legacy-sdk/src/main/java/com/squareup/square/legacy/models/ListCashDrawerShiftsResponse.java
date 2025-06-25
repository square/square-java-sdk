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
 * This is a model class for ListCashDrawerShiftsResponse type.
 */
public class ListCashDrawerShiftsResponse {
    private HttpContext httpContext;
    private final String cursor;
    private final List<Error> errors;
    private final List<CashDrawerShiftSummary> cashDrawerShifts;

    /**
     * Initialization constructor.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     * @param  cashDrawerShifts  List of CashDrawerShiftSummary value for cashDrawerShifts.
     */
    @JsonCreator
    public ListCashDrawerShiftsResponse(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cash_drawer_shifts") List<CashDrawerShiftSummary> cashDrawerShifts) {
        this.cursor = cursor;
        this.errors = errors;
        this.cashDrawerShifts = cashDrawerShifts;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page of results. Cursor is not present in the last page
     * of results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for CashDrawerShifts.
     * A collection of CashDrawerShiftSummary objects for shifts that match the query.
     * @return Returns the List of CashDrawerShiftSummary
     */
    @JsonGetter("cash_drawer_shifts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CashDrawerShiftSummary> getCashDrawerShifts() {
        return cashDrawerShifts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cursor, errors, cashDrawerShifts);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCashDrawerShiftsResponse)) {
            return false;
        }
        ListCashDrawerShiftsResponse other = (ListCashDrawerShiftsResponse) obj;
        return Objects.equals(cursor, other.cursor)
                && Objects.equals(errors, other.errors)
                && Objects.equals(cashDrawerShifts, other.cashDrawerShifts);
    }

    /**
     * Converts this ListCashDrawerShiftsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCashDrawerShiftsResponse [" + "cursor=" + cursor + ", errors=" + errors + ", cashDrawerShifts="
                + cashDrawerShifts + "]";
    }

    /**
     * Builds a new {@link ListCashDrawerShiftsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().cursor(getCursor()).errors(getErrors()).cashDrawerShifts(getCashDrawerShifts());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String cursor;
        private List<Error> errors;
        private List<CashDrawerShiftSummary> cashDrawerShifts;

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
         * Setter for cashDrawerShifts.
         * @param  cashDrawerShifts  List of CashDrawerShiftSummary value for cashDrawerShifts.
         * @return Builder
         */
        public Builder cashDrawerShifts(List<CashDrawerShiftSummary> cashDrawerShifts) {
            this.cashDrawerShifts = cashDrawerShifts;
            return this;
        }

        /**
         * Builds a new {@link ListCashDrawerShiftsResponse} object using the set fields.
         * @return {@link ListCashDrawerShiftsResponse}
         */
        public ListCashDrawerShiftsResponse build() {
            ListCashDrawerShiftsResponse model = new ListCashDrawerShiftsResponse(cursor, errors, cashDrawerShifts);
            model.httpContext = httpContext;
            return model;
        }
    }
}
