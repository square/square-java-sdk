
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateInvoiceAttachmentRequest type.
 */
public class CreateInvoiceAttachmentRequest {
    private final String idempotencyKey;
    private final String description;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  description  String value for description.
     */
    @JsonCreator
    public CreateInvoiceAttachmentRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("description") String description) {
        this.idempotencyKey = idempotencyKey;
        this.description = description;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `CreateInvoiceAttachment` request. For more information,
     * see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Description.
     * The description of the attachment to display on the invoice.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateInvoiceAttachmentRequest)) {
            return false;
        }
        CreateInvoiceAttachmentRequest other = (CreateInvoiceAttachmentRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(description, other.description);
    }

    /**
     * Converts this CreateInvoiceAttachmentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateInvoiceAttachmentRequest [" + "idempotencyKey=" + idempotencyKey
                + ", description=" + description + "]";
    }

    /**
     * Builds a new {@link CreateInvoiceAttachmentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateInvoiceAttachmentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .idempotencyKey(getIdempotencyKey())
                .description(getDescription());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateInvoiceAttachmentRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String description;



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
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds a new {@link CreateInvoiceAttachmentRequest} object using the set fields.
         * @return {@link CreateInvoiceAttachmentRequest}
         */
        public CreateInvoiceAttachmentRequest build() {
            return new CreateInvoiceAttachmentRequest(idempotencyKey, description);
        }
    }
}
