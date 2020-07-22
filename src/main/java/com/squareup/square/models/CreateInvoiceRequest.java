package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateInvoiceRequest type.
 */
public class CreateInvoiceRequest {

    /**
     * Initialization constructor.
     * @param invoice
     * @param idempotencyKey
     */
    @JsonCreator
    public CreateInvoiceRequest(
            @JsonProperty("invoice") Invoice invoice,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.invoice = invoice;
        this.idempotencyKey = idempotencyKey;
    }

    private final Invoice invoice;
    private final String idempotencyKey;
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
     * Getter for IdempotencyKey.
     * A unique string that identifies the `CreateInvoice` request. If you do not 
     * provide `idempotency_key` (or provide an empty string as the value), the endpoint 
     * treats each request as independent.
     * For more information, see [Idempotency](https://developer.squareup.com/docs/docs/working-with-apis/idempotency).
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(invoice, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateInvoiceRequest)) {
            return false;
        }
        CreateInvoiceRequest createInvoiceRequest = (CreateInvoiceRequest) obj;
        return Objects.equals(invoice, createInvoiceRequest.invoice) &&
            Objects.equals(idempotencyKey, createInvoiceRequest.idempotencyKey);
    }

    /**
     * Builds a new {@link CreateInvoiceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateInvoiceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(invoice)
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateInvoiceRequest}
     */
    public static class Builder {
        private Invoice invoice;
        private String idempotencyKey;

        /**
         * Initialization constructor
         */
        public Builder(Invoice invoice) {
            this.invoice = invoice;
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
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateInvoiceRequest} object using the set fields.
         * @return {@link CreateInvoiceRequest}
         */
        public CreateInvoiceRequest build() {
            return new CreateInvoiceRequest(invoice,
                idempotencyKey);
        }
    }
}
