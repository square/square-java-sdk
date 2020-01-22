package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListPaymentRefundsResponse type.
 */
public class ListPaymentRefundsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param refunds
     * @param cursor
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, refunds, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListPaymentRefundsResponse)) {
            return false;
        }
        ListPaymentRefundsResponse listPaymentRefundsResponse = (ListPaymentRefundsResponse) obj;
        return Objects.equals(errors, listPaymentRefundsResponse.errors) &&
            Objects.equals(refunds, listPaymentRefundsResponse.refunds) &&
            Objects.equals(cursor, listPaymentRefundsResponse.cursor);
    }

    /**
     * Builds a new {@link ListPaymentRefundsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentRefundsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .refunds(getRefunds())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentRefundsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<PaymentRefund> refunds;
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
         * Setter for refunds
         * @param refunds
         * @return Builder
         */
        public Builder refunds(List<PaymentRefund> refunds) {
            this.refunds = refunds;
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
         * Builds a new {@link ListPaymentRefundsResponse} object using the set fields.
         * @return {@link ListPaymentRefundsResponse}
         */
        public ListPaymentRefundsResponse build() {
            ListPaymentRefundsResponse model = new ListPaymentRefundsResponse(errors,
                refunds,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
