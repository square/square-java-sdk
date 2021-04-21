
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PublishInvoiceRequest type.
 */
public class PublishInvoiceRequest {
    private final int version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  version  int value for version.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public PublishInvoiceRequest(
            @JsonProperty("version") int version,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.version = version;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for Version.
     * The version of the [invoice]($m/Invoice) to publish. This must match the current version of
     * the invoice; otherwise, the request is rejected.
     * @return Returns the int
     */
    @JsonGetter("version")
    public int getVersion() {
        return version;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `PublishInvoice` request. If you do not provide
     * `idempotency_key` (or provide an empty string as the value), the endpoint treats each request
     * as independent. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PublishInvoiceRequest)) {
            return false;
        }
        PublishInvoiceRequest other = (PublishInvoiceRequest) obj;
        return Objects.equals(version, other.version)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this PublishInvoiceRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PublishInvoiceRequest [" + "version=" + version + ", idempotencyKey="
                + idempotencyKey + "]";
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
     * Class to build instances of {@link PublishInvoiceRequest}.
     */
    public static class Builder {
        private int version;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  version  int value for version.
         */
        public Builder(int version) {
            this.version = version;
        }

        /**
         * Setter for version.
         * @param  version  int value for version.
         * @return Builder
         */
        public Builder version(int version) {
            this.version = version;
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
         * Builds a new {@link PublishInvoiceRequest} object using the set fields.
         * @return {@link PublishInvoiceRequest}
         */
        public PublishInvoiceRequest build() {
            return new PublishInvoiceRequest(version, idempotencyKey);
        }
    }
}
