package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListPaymentsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, payments, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListPaymentsResponse)) {
            return false;
        }
        ListPaymentsResponse listPaymentsResponse = (ListPaymentsResponse) o;
        return Objects.equals(errors, listPaymentsResponse.errors) &&
            Objects.equals(payments, listPaymentsResponse.payments) &&
            Objects.equals(cursor, listPaymentsResponse.cursor);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .payments(getPayments())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Payment> payments;
        private String cursor;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder payments(List<Payment> value) {
            payments = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListPaymentsResponse build() {
            ListPaymentsResponse model = new ListPaymentsResponse(errors,
                payments,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
