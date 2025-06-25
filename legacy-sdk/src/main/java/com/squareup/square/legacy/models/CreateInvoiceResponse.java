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
 * This is a model class for CreateInvoiceResponse type.
 */
public class CreateInvoiceResponse {
    private HttpContext httpContext;
    private final Invoice invoice;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  invoice  Invoice value for invoice.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CreateInvoiceResponse(@JsonProperty("invoice") Invoice invoice, @JsonProperty("errors") List<Error> errors) {
        this.invoice = invoice;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Invoice.
     * Stores information about an invoice. You use the Invoices API to create and manage invoices.
     * For more information, see [Invoices API
     * Overview](https://developer.squareup.com/docs/invoices-api/overview).
     * @return Returns the Invoice
     */
    @JsonGetter("invoice")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Invoice getInvoice() {
        return invoice;
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
        return Objects.hash(invoice, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateInvoiceResponse)) {
            return false;
        }
        CreateInvoiceResponse other = (CreateInvoiceResponse) obj;
        return Objects.equals(invoice, other.invoice) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CreateInvoiceResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateInvoiceResponse [" + "invoice=" + invoice + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link CreateInvoiceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateInvoiceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().invoice(getInvoice()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateInvoiceResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Invoice invoice;
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
         * Setter for invoice.
         * @param  invoice  Invoice value for invoice.
         * @return Builder
         */
        public Builder invoice(Invoice invoice) {
            this.invoice = invoice;
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
         * Builds a new {@link CreateInvoiceResponse} object using the set fields.
         * @return {@link CreateInvoiceResponse}
         */
        public CreateInvoiceResponse build() {
            CreateInvoiceResponse model = new CreateInvoiceResponse(invoice, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
