package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateInvoiceResponse type.
 */
public class CreateInvoiceResponse {

    /**
     * Initialization constructor.
     * @param invoice
     * @param errors
     */
    @JsonCreator
    public CreateInvoiceResponse(
            @JsonProperty("invoice") Invoice invoice,
            @JsonProperty("errors") List<Error> errors) {
        this.invoice = invoice;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Invoice invoice;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Invoice.
     * Stores information about an invoice. You use the Invoices API to create and process
     * invoices. For more information, see [Manage Invoices Using the Invoices API](https://developer.squareup.com/docs/docs/invoices-api/overview).
     */
    @JsonGetter("invoice")
    public Invoice getInvoice() {
        return this.invoice;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateInvoiceResponse)) {
            return false;
        }
        CreateInvoiceResponse createInvoiceResponse = (CreateInvoiceResponse) obj;
        return Objects.equals(invoice, createInvoiceResponse.invoice) &&
            Objects.equals(errors, createInvoiceResponse.errors);
    }

    /**
     * Builds a new {@link CreateInvoiceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateInvoiceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .invoice(getInvoice())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateInvoiceResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Invoice invoice;
        private List<Error> errors;

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
         * Setter for invoice
         * @param invoice
         * @return Builder
         */
        public Builder invoice(Invoice invoice) {
            this.invoice = invoice;
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
         * Builds a new {@link CreateInvoiceResponse} object using the set fields.
         * @return {@link CreateInvoiceResponse}
         */
        public CreateInvoiceResponse build() {
            CreateInvoiceResponse model = new CreateInvoiceResponse(invoice,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
