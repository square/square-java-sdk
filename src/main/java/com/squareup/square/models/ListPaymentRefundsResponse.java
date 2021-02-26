
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListPaymentRefundsResponse type.
 */
public class ListPaymentRefundsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<PaymentRefund> refunds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  refunds  List of PaymentRefund value for refunds.
     * @param  cursor  String value for cursor.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Refunds.
     * The list of requested refunds.
     * @return Returns the List of PaymentRefund
     */
    @JsonGetter("refunds")
    public List<PaymentRefund> getRefunds() {
        return refunds;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
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
        if (!(obj instanceof ListPaymentRefundsResponse)) {
            return false;
        }
        ListPaymentRefundsResponse other = (ListPaymentRefundsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(refunds, other.refunds)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListPaymentRefundsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPaymentRefundsResponse [" + "errors=" + errors + ", refunds=" + refunds
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link ListPaymentRefundsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<PaymentRefund> refunds;
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
         * @param  refunds  List of PaymentRefund value for refunds.
         * @return Builder
         */
        public Builder refunds(List<PaymentRefund> refunds) {
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
         * Builds a new {@link ListPaymentRefundsResponse} object using the set fields.
         * @return {@link ListPaymentRefundsResponse}
         */
        public ListPaymentRefundsResponse build() {
            ListPaymentRefundsResponse model =
                    new ListPaymentRefundsResponse(errors, refunds, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
