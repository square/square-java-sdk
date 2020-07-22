package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CancelInvoiceRequest type.
 */
public class CancelInvoiceRequest {

    /**
     * Initialization constructor.
     * @param version
     */
    @JsonCreator
    public CancelInvoiceRequest(
            @JsonProperty("version") int version) {
        this.version = version;
    }

    private final int version;
    /**
     * Getter for Version.
     * The version of the [invoice](#type-invoice) to cancel.
     * If you do not know the version, you can call 
     * [GetInvoice](#endpoint-Invoices-GetInvoice) or [ListInvoices](#endpoint-Invoices-ListInvoices).
     */
    @JsonGetter("version")
    public int getVersion() {
        return this.version;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CancelInvoiceRequest)) {
            return false;
        }
        CancelInvoiceRequest cancelInvoiceRequest = (CancelInvoiceRequest) obj;
        return Objects.equals(version, cancelInvoiceRequest.version);
    }

    /**
     * Builds a new {@link CancelInvoiceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelInvoiceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(version);
            return builder;
    }

    /**
     * Class to build instances of {@link CancelInvoiceRequest}
     */
    public static class Builder {
        private int version;

        /**
         * Initialization constructor
         */
        public Builder(int version) {
            this.version = version;
        }

        /**
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(int version) {
            this.version = version;
            return this;
        }

        /**
         * Builds a new {@link CancelInvoiceRequest} object using the set fields.
         * @return {@link CancelInvoiceRequest}
         */
        public CancelInvoiceRequest build() {
            return new CancelInvoiceRequest(version);
        }
    }
}
