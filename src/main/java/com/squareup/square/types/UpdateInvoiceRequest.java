/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = UpdateInvoiceRequest.Builder.class)
public final class UpdateInvoiceRequest {
    private final String invoiceId;

    private final Invoice invoice;

    private final Optional<String> idempotencyKey;

    private final Optional<List<String>> fieldsToClear;

    private final Map<String, Object> additionalProperties;

    private UpdateInvoiceRequest(
            String invoiceId,
            Invoice invoice,
            Optional<String> idempotencyKey,
            Optional<List<String>> fieldsToClear,
            Map<String, Object> additionalProperties) {
        this.invoiceId = invoiceId;
        this.invoice = invoice;
        this.idempotencyKey = idempotencyKey;
        this.fieldsToClear = fieldsToClear;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the invoice to update.
     */
    @JsonProperty("invoice_id")
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * @return The invoice fields to add, change, or clear. Fields can be cleared using
     * null values or the <code>remove</code> field (for individual payment requests or reminders).
     * The current invoice <code>version</code> is also required. For more information, including requirements,
     * limitations, and more examples, see <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.
     */
    @JsonProperty("invoice")
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @return A unique string that identifies the <code>UpdateInvoice</code> request. If you do not
     * provide <code>idempotency_key</code> (or provide an empty string as the value), the endpoint
     * treats each request as independent.
     * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
     */
    @JsonIgnore
    public Optional<String> getIdempotencyKey() {
        if (idempotencyKey == null) {
            return Optional.empty();
        }
        return idempotencyKey;
    }

    /**
     * @return The list of fields to clear. Although this field is currently supported, we
     * recommend using null values or the <code>remove</code> field when possible. For examples, see
     * <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.
     */
    @JsonIgnore
    public Optional<List<String>> getFieldsToClear() {
        if (fieldsToClear == null) {
            return Optional.empty();
        }
        return fieldsToClear;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("idempotency_key")
    private Optional<String> _getIdempotencyKey() {
        return idempotencyKey;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("fields_to_clear")
    private Optional<List<String>> _getFieldsToClear() {
        return fieldsToClear;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UpdateInvoiceRequest && equalTo((UpdateInvoiceRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(UpdateInvoiceRequest other) {
        return invoiceId.equals(other.invoiceId)
                && invoice.equals(other.invoice)
                && idempotencyKey.equals(other.idempotencyKey)
                && fieldsToClear.equals(other.fieldsToClear);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.invoiceId, this.invoice, this.idempotencyKey, this.fieldsToClear);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static InvoiceIdStage builder() {
        return new Builder();
    }

    public interface InvoiceIdStage {
        /**
         * <p>The ID of the invoice to update.</p>
         */
        InvoiceStage invoiceId(@NotNull String invoiceId);

        Builder from(UpdateInvoiceRequest other);
    }

    public interface InvoiceStage {
        /**
         * <p>The invoice fields to add, change, or clear. Fields can be cleared using
         * null values or the <code>remove</code> field (for individual payment requests or reminders).
         * The current invoice <code>version</code> is also required. For more information, including requirements,
         * limitations, and more examples, see <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         */
        _FinalStage invoice(@NotNull Invoice invoice);
    }

    public interface _FinalStage {
        UpdateInvoiceRequest build();

        /**
         * <p>A unique string that identifies the <code>UpdateInvoice</code> request. If you do not
         * provide <code>idempotency_key</code> (or provide an empty string as the value), the endpoint
         * treats each request as independent.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         */
        _FinalStage idempotencyKey(Optional<String> idempotencyKey);

        _FinalStage idempotencyKey(String idempotencyKey);

        _FinalStage idempotencyKey(Nullable<String> idempotencyKey);

        /**
         * <p>The list of fields to clear. Although this field is currently supported, we
         * recommend using null values or the <code>remove</code> field when possible. For examples, see
         * <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         */
        _FinalStage fieldsToClear(Optional<List<String>> fieldsToClear);

        _FinalStage fieldsToClear(List<String> fieldsToClear);

        _FinalStage fieldsToClear(Nullable<List<String>> fieldsToClear);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements InvoiceIdStage, InvoiceStage, _FinalStage {
        private String invoiceId;

        private Invoice invoice;

        private Optional<List<String>> fieldsToClear = Optional.empty();

        private Optional<String> idempotencyKey = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(UpdateInvoiceRequest other) {
            invoiceId(other.getInvoiceId());
            invoice(other.getInvoice());
            idempotencyKey(other.getIdempotencyKey());
            fieldsToClear(other.getFieldsToClear());
            return this;
        }

        /**
         * <p>The ID of the invoice to update.</p>
         * <p>The ID of the invoice to update.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("invoice_id")
        public InvoiceStage invoiceId(@NotNull String invoiceId) {
            this.invoiceId = Objects.requireNonNull(invoiceId, "invoiceId must not be null");
            return this;
        }

        /**
         * <p>The invoice fields to add, change, or clear. Fields can be cleared using
         * null values or the <code>remove</code> field (for individual payment requests or reminders).
         * The current invoice <code>version</code> is also required. For more information, including requirements,
         * limitations, and more examples, see <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         * <p>The invoice fields to add, change, or clear. Fields can be cleared using
         * null values or the <code>remove</code> field (for individual payment requests or reminders).
         * The current invoice <code>version</code> is also required. For more information, including requirements,
         * limitations, and more examples, see <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("invoice")
        public _FinalStage invoice(@NotNull Invoice invoice) {
            this.invoice = Objects.requireNonNull(invoice, "invoice must not be null");
            return this;
        }

        /**
         * <p>The list of fields to clear. Although this field is currently supported, we
         * recommend using null values or the <code>remove</code> field when possible. For examples, see
         * <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage fieldsToClear(Nullable<List<String>> fieldsToClear) {
            if (fieldsToClear.isNull()) {
                this.fieldsToClear = null;
            } else if (fieldsToClear.isEmpty()) {
                this.fieldsToClear = Optional.empty();
            } else {
                this.fieldsToClear = Optional.of(fieldsToClear.get());
            }
            return this;
        }

        /**
         * <p>The list of fields to clear. Although this field is currently supported, we
         * recommend using null values or the <code>remove</code> field when possible. For examples, see
         * <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage fieldsToClear(List<String> fieldsToClear) {
            this.fieldsToClear = Optional.ofNullable(fieldsToClear);
            return this;
        }

        /**
         * <p>The list of fields to clear. Although this field is currently supported, we
         * recommend using null values or the <code>remove</code> field when possible. For examples, see
         * <a href="https://developer.squareup.com/docs/invoices-api/update-invoices">Update an Invoice</a>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "fields_to_clear", nulls = Nulls.SKIP)
        public _FinalStage fieldsToClear(Optional<List<String>> fieldsToClear) {
            this.fieldsToClear = fieldsToClear;
            return this;
        }

        /**
         * <p>A unique string that identifies the <code>UpdateInvoice</code> request. If you do not
         * provide <code>idempotency_key</code> (or provide an empty string as the value), the endpoint
         * treats each request as independent.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage idempotencyKey(Nullable<String> idempotencyKey) {
            if (idempotencyKey.isNull()) {
                this.idempotencyKey = null;
            } else if (idempotencyKey.isEmpty()) {
                this.idempotencyKey = Optional.empty();
            } else {
                this.idempotencyKey = Optional.of(idempotencyKey.get());
            }
            return this;
        }

        /**
         * <p>A unique string that identifies the <code>UpdateInvoice</code> request. If you do not
         * provide <code>idempotency_key</code> (or provide an empty string as the value), the endpoint
         * treats each request as independent.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = Optional.ofNullable(idempotencyKey);
            return this;
        }

        /**
         * <p>A unique string that identifies the <code>UpdateInvoice</code> request. If you do not
         * provide <code>idempotency_key</code> (or provide an empty string as the value), the endpoint
         * treats each request as independent.</p>
         * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency">Idempotency</a>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "idempotency_key", nulls = Nulls.SKIP)
        public _FinalStage idempotencyKey(Optional<String> idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        @java.lang.Override
        public UpdateInvoiceRequest build() {
            return new UpdateInvoiceRequest(invoiceId, invoice, idempotencyKey, fieldsToClear, additionalProperties);
        }
    }
}
