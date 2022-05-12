
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
 * This is a model class for ListPaymentLinksResponse type.
 */
public class ListPaymentLinksResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<PaymentLink> paymentLinks;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  paymentLinks  List of PaymentLink value for paymentLinks.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListPaymentLinksResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payment_links") List<PaymentLink> paymentLinks,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.paymentLinks = paymentLinks;
        this.cursor = cursor;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for PaymentLinks.
     * The list of payment links.
     * @return Returns the List of PaymentLink
     */
    @JsonGetter("payment_links")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<PaymentLink> getPaymentLinks() {
        return paymentLinks;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a subsequent request
     * to retrieve the next set of gift cards. If a cursor is not present, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, paymentLinks, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPaymentLinksResponse)) {
            return false;
        }
        ListPaymentLinksResponse other = (ListPaymentLinksResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(paymentLinks, other.paymentLinks)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListPaymentLinksResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPaymentLinksResponse [" + "errors=" + errors + ", paymentLinks=" + paymentLinks
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListPaymentLinksResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentLinksResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .paymentLinks(getPaymentLinks())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentLinksResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<PaymentLink> paymentLinks;
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
         * Setter for paymentLinks.
         * @param  paymentLinks  List of PaymentLink value for paymentLinks.
         * @return Builder
         */
        public Builder paymentLinks(List<PaymentLink> paymentLinks) {
            this.paymentLinks = paymentLinks;
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
         * Builds a new {@link ListPaymentLinksResponse} object using the set fields.
         * @return {@link ListPaymentLinksResponse}
         */
        public ListPaymentLinksResponse build() {
            ListPaymentLinksResponse model =
                    new ListPaymentLinksResponse(errors, paymentLinks, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
