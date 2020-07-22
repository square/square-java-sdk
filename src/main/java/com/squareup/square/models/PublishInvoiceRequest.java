package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for PublishInvoiceRequest type.
 */
public class PublishInvoiceRequest {

    /**
     * Initialization constructor.
     * @param version
     * @param idempotencyKey
     */
    @JsonCreator
    public PublishInvoiceRequest(
            @JsonProperty("version") int version,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.version = version;
        this.idempotencyKey = idempotencyKey;
    }

    private final int version;
    private final String idempotencyKey;
    /**
     * Getter for Version.
     * The version of the [Invoice](#type-invoice) to publish.
     * This must match the current version of the invoice,
     * otherwise the request is rejected.
     */
    @JsonGetter("version")
    public int getVersion() {
        return this.version;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `PublishInvoice` request. If you do not 
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
        return Objects.hash(version, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof PublishInvoiceRequest)) {
            return false;
        }
        PublishInvoiceRequest publishInvoiceRequest = (PublishInvoiceRequest) obj;
        return Objects.equals(version, publishInvoiceRequest.version) &&
            Objects.equals(idempotencyKey, publishInvoiceRequest.idempotencyKey);
    }

    /**
     * Builds a new {@link PublishInvoiceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PublishInvoiceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(version)
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    /**
     * Class to build instances of {@link PublishInvoiceRequest}
     */
    public static class Builder {
        private int version;
        private String idempotencyKey;

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
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link PublishInvoiceRequest} object using the set fields.
         * @return {@link PublishInvoiceRequest}
         */
        public PublishInvoiceRequest build() {
            return new PublishInvoiceRequest(version,
                idempotencyKey);
        }
    }
}
