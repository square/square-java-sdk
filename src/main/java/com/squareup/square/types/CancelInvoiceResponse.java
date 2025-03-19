/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CancelInvoiceResponse.Builder.class)
public final class CancelInvoiceResponse {
    private final Optional<Invoice> invoice;

    private final Optional<List<Error>> errors;

    private final Map<String, Object> additionalProperties;

    private CancelInvoiceResponse(
            Optional<Invoice> invoice, Optional<List<Error>> errors, Map<String, Object> additionalProperties) {
        this.invoice = invoice;
        this.errors = errors;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The canceled invoice.
     */
    @JsonProperty("invoice")
    public Optional<Invoice> getInvoice() {
        return invoice;
    }

    /**
     * @return Information about errors encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CancelInvoiceResponse && equalTo((CancelInvoiceResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CancelInvoiceResponse other) {
        return invoice.equals(other.invoice) && errors.equals(other.errors);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.invoice, this.errors);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Invoice> invoice = Optional.empty();

        private Optional<List<Error>> errors = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CancelInvoiceResponse other) {
            invoice(other.getInvoice());
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "invoice", nulls = Nulls.SKIP)
        public Builder invoice(Optional<Invoice> invoice) {
            this.invoice = invoice;
            return this;
        }

        public Builder invoice(Invoice invoice) {
            this.invoice = Optional.ofNullable(invoice);
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        public CancelInvoiceResponse build() {
            return new CancelInvoiceResponse(invoice, errors, additionalProperties);
        }
    }
}
