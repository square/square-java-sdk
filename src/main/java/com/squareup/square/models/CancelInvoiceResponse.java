
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CancelInvoiceResponse type.
 */
public class CancelInvoiceResponse {
    private HttpContext httpContext;
    private final Invoice invoice;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param invoice Invoice value for invoice.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public CancelInvoiceResponse(
            @JsonProperty("invoice") Invoice invoice,
            @JsonProperty("errors") List<Error> errors) {
        this.invoice = invoice;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Invoice.
     * Stores information about an invoice. You use the Invoices API to create and process invoices.
     * For more information, see [Manage Invoices Using the Invoices
     * API](https://developer.squareup.com/docs/docs/invoices-api/overview).
     * @return Returns the Invoice
     */
    @JsonGetter("invoice")
    public Invoice getInvoice() {
        return this.invoice;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(invoice, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelInvoiceResponse)) {
            return false;
        }
        CancelInvoiceResponse other = (CancelInvoiceResponse) obj;
        return Objects.equals(invoice, other.invoice)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Builds a new {@link CancelInvoiceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelInvoiceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .invoice(getInvoice())
            .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CancelInvoiceResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Invoice invoice;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for invoice.
         * @param invoice Invoice value for invoice.
         * @return Builder
         */
        public Builder invoice(Invoice invoice) {
            this.invoice = invoice;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link CancelInvoiceResponse} object using the set fields.
         * @return {@link CancelInvoiceResponse}
         */
        public CancelInvoiceResponse build() {
            CancelInvoiceResponse model =
                    new CancelInvoiceResponse(invoice,
                            errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
