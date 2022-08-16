
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateInvoiceRequest type.
 */
public class CreateInvoiceRequest {
    private final Invoice invoice;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  invoice  Invoice value for invoice.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateInvoiceRequest(
            @JsonProperty("invoice") Invoice invoice,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.invoice = invoice;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for Invoice.
     * Stores information about an invoice. You use the Invoices API to create and manage invoices.
     * For more information, see [Invoices API
     * Overview](https://developer.squareup.com/docs/invoices-api/overview).
     * @return Returns the Invoice
     */
    @JsonGetter("invoice")
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `CreateInvoice` request. If you do not provide
     * `idempotency_key` (or provide an empty string as the value), the endpoint treats each request
     * as independent. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateInvoiceRequest)) {
            return false;
        }
        CreateInvoiceRequest other = (CreateInvoiceRequest) obj;
        return Objects.equals(invoice, other.invoice)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CreateInvoiceRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateInvoiceRequest [" + "invoice=" + invoice + ", idempotencyKey="
                + idempotencyKey + "]";
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
     * Class to build instances of {@link CreateInvoiceRequest}.
     */
    public static class Builder {
        private Invoice invoice;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  invoice  Invoice value for invoice.
         */
        public Builder(Invoice invoice) {
            this.invoice = invoice;
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
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
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
            return new CreateInvoiceRequest(invoice, idempotencyKey);
        }
    }
}
