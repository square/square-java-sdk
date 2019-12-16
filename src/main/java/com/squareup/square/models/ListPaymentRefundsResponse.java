package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListPaymentRefundsResponse {

    @JsonCreator
    public ListPaymentRefundsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refunds") List<PaymentRefund> refunds,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.refunds = refunds;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<PaymentRefund> refunds;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(errors, refunds, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListPaymentRefundsResponse)) {
            return false;
        }
        ListPaymentRefundsResponse listPaymentRefundsResponse = (ListPaymentRefundsResponse) o;
        return Objects.equals(errors, listPaymentRefundsResponse.errors) &&
            Objects.equals(refunds, listPaymentRefundsResponse.refunds) &&
            Objects.equals(cursor, listPaymentRefundsResponse.cursor);
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
     * Getter for Refunds.
     * The list of requested refunds.
     */
    @JsonGetter("refunds")
    public List<PaymentRefund> getRefunds() { 
        return this.refunds;
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
            .refunds(getRefunds())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<PaymentRefund> refunds;
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
        public Builder refunds(List<PaymentRefund> value) {
            refunds = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListPaymentRefundsResponse build() {
            ListPaymentRefundsResponse model = new ListPaymentRefundsResponse(errors,
                refunds,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
