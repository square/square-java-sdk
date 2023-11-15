
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateInvoiceRequest type.
 */
public class UpdateInvoiceRequest {
    private final Invoice invoice;
    private final OptionalNullable<String> idempotencyKey;
    private final OptionalNullable<List<String>> fieldsToClear;

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
        this.idempotencyKey = OptionalNullable.of(idempotencyKey);
        this.fieldsToClear = OptionalNullable.of(fieldsToClear);
    }

    /**
     * Initialization constructor.
     * @param  invoice  Invoice value for invoice.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  fieldsToClear  List of String value for fieldsToClear.
     */

    protected UpdateInvoiceRequest(Invoice invoice, OptionalNullable<String> idempotencyKey,
            OptionalNullable<List<String>> fieldsToClear) {
        this.invoice = invoice;
        this.idempotencyKey = idempotencyKey;
        this.fieldsToClear = fieldsToClear;
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
     * Internal Getter for IdempotencyKey.
     * A unique string that identifies the `UpdateInvoice` request. If you do not provide
     * `idempotency_key` (or provide an empty string as the value), the endpoint treats each request
     * as independent. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the Internal String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `UpdateInvoice` request. If you do not provide
     * `idempotency_key` (or provide an empty string as the value), the endpoint treats each request
     * as independent. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonIgnore
    public String getIdempotencyKey() {
        return OptionalNullable.getFrom(idempotencyKey);
    }

    /**
     * Internal Getter for FieldsToClear.
     * The list of fields to clear. For examples, see [Update an
     * Invoice](https://developer.squareup.com/docs/invoices-api/update-invoices).
     * @return Returns the Internal List of String
     */
    @JsonGetter("fields_to_clear")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetFieldsToClear() {
        return this.fieldsToClear;
    }

    /**
     * Getter for FieldsToClear.
     * The list of fields to clear. For examples, see [Update an
     * Invoice](https://developer.squareup.com/docs/invoices-api/update-invoices).
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getFieldsToClear() {
        return OptionalNullable.getFrom(fieldsToClear);
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
        Builder builder = new Builder(invoice);
        builder.idempotencyKey = internalGetIdempotencyKey();
        builder.fieldsToClear = internalGetFieldsToClear();
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateInvoiceRequest}.
     */
    public static class Builder {
        private Invoice invoice;
        private OptionalNullable<String> idempotencyKey;
        private OptionalNullable<List<String>> fieldsToClear;

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
            this.idempotencyKey = OptionalNullable.of(idempotencyKey);
            return this;
        }

        /**
         * UnSetter for idempotencyKey.
         * @return Builder
         */
        public Builder unsetIdempotencyKey() {
            idempotencyKey = null;
            return this;
        }

        /**
         * Setter for fieldsToClear.
         * @param  fieldsToClear  List of String value for fieldsToClear.
         * @return Builder
         */
        public Builder fieldsToClear(List<String> fieldsToClear) {
            this.fieldsToClear = OptionalNullable.of(fieldsToClear);
            return this;
        }

        /**
         * UnSetter for fieldsToClear.
         * @return Builder
         */
        public Builder unsetFieldsToClear() {
            fieldsToClear = null;
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
