package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListPaymentsResponse type.
 */
public class ListPaymentsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param payments
     * @param cursor
     */
    @JsonCreator
    public ListPaymentsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payments") List<Payment> payments,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.payments = payments;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Payment> payments;
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
     * Getter for Payments.
     * The requested list of `Payment`s.
     */
    @JsonGetter("payments")
    public List<Payment> getPayments() {
        return this.payments;
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
        return Objects.hash(errors, payments, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListPaymentsResponse)) {
            return false;
        }
        ListPaymentsResponse listPaymentsResponse = (ListPaymentsResponse) obj;
        return Objects.equals(errors, listPaymentsResponse.errors) &&
            Objects.equals(payments, listPaymentsResponse.payments) &&
            Objects.equals(cursor, listPaymentsResponse.cursor);
    }

    /**
     * Builds a new {@link ListPaymentsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .payments(getPayments())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Payment> payments;
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
         * Setter for payments
         * @param payments
         * @return Builder
         */
        public Builder payments(List<Payment> payments) {
            this.payments = payments;
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
         * Builds a new {@link ListPaymentsResponse} object using the set fields.
         * @return {@link ListPaymentsResponse}
         */
        public ListPaymentsResponse build() {
            ListPaymentsResponse model = new ListPaymentsResponse(errors,
                payments,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
