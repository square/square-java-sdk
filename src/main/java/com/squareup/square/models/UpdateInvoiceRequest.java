
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateInvoiceRequest type.
 */
public class UpdateInvoiceRequest {
    private final Invoice invoice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String idempotencyKey;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> fieldsToClear;

    /**
     * Initialization constructor.
     * @param  invoice  Invoice value for invoice.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  fieldsToClear  List of String value for fieldsToClear.
     */
    @JsonCreator
    public UpdateInvoiceRequest(
            @JsonProperty("invoice") Invoice invoice,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("fields_to_clear") List<String> fieldsToClear) {
        this.invoice = invoice;
        this.idempotencyKey = idempotencyKey;
        this.fieldsToClear = fieldsToClear;
    }

    /**
     * Getter for Invoice.
     * Stores information about an invoice. You use the Invoices API to create and manage invoices.
     * For more information, see [Manage Invoices Using the Invoices
     * API](https://developer.squareup.com/docs/invoices-api/overview).
     * @return Returns the Invoice
     */
    @JsonGetter("invoice")
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `UpdateInvoice` request. If you do not provide
     * `idempotency_key` (or provide an empty string as the value), the endpoint treats each request
     * as independent. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for FieldsToClear.
     * The list of fields to clear. For examples, see [Update an
     * invoice](https://developer.squareup.com/docs/invoices-api/overview#update-an-invoice).
     * @return Returns the List of String
     */
    @JsonGetter("fields_to_clear")
    public List<String> getFieldsToClear() {
        return fieldsToClear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice, idempotencyKey, fieldsToClear);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateInvoiceRequest)) {
            return false;
        }
        UpdateInvoiceRequest other = (UpdateInvoiceRequest) obj;
        return Objects.equals(invoice, other.invoice)
            && Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(fieldsToClear, other.fieldsToClear);
    }

    /**
     * Converts this UpdateInvoiceRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateInvoiceRequest [" + "invoice=" + invoice + ", idempotencyKey="
                + idempotencyKey + ", fieldsToClear=" + fieldsToClear + "]";
    }

    /**
     * Builds a new {@link UpdateInvoiceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateInvoiceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(invoice)
                .idempotencyKey(getIdempotencyKey())
                .fieldsToClear(getFieldsToClear());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateInvoiceRequest}.
     */
    public static class Builder {
        private Invoice invoice;
        private String idempotencyKey;
        private List<String> fieldsToClear;

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
         * Setter for fieldsToClear.
         * @param  fieldsToClear  List of String value for fieldsToClear.
         * @return Builder
         */
        public Builder fieldsToClear(List<String> fieldsToClear) {
            this.fieldsToClear = fieldsToClear;
            return this;
        }

        /**
         * Builds a new {@link UpdateInvoiceRequest} object using the set fields.
         * @return {@link UpdateInvoiceRequest}
         */
        public UpdateInvoiceRequest build() {
            return new UpdateInvoiceRequest(invoice, idempotencyKey, fieldsToClear);
        }
    }
}
