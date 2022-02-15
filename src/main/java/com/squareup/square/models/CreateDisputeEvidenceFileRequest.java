
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateDisputeEvidenceFileRequest type.
 */
public class CreateDisputeEvidenceFileRequest {
    private final String idempotencyKey;
    private final String evidenceType;
    private final String contentType;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  evidenceType  String value for evidenceType.
     * @param  contentType  String value for contentType.
     */
    @JsonCreator
    public CreateDisputeEvidenceFileRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("evidence_type") String evidenceType,
            @JsonProperty("content_type") String contentType) {
        this.idempotencyKey = idempotencyKey;
        this.evidenceType = evidenceType;
        this.contentType = contentType;
    }

    /**
     * Getter for IdempotencyKey.
     * The Unique ID. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for EvidenceType.
     * The type of the dispute evidence.
     * @return Returns the String
     */
    @JsonGetter("evidence_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEvidenceType() {
        return evidenceType;
    }

    /**
     * Getter for ContentType.
     * The MIME type of the uploaded file. The type can be image/heic, image/heif, image/jpeg,
     * application/pdf, image/png, or image/tiff.
     * @return Returns the String
     */
    @JsonGetter("content_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getContentType() {
        return contentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, evidenceType, contentType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateDisputeEvidenceFileRequest)) {
            return false;
        }
        CreateDisputeEvidenceFileRequest other = (CreateDisputeEvidenceFileRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(evidenceType, other.evidenceType)
            && Objects.equals(contentType, other.contentType);
    }

    /**
     * Converts this CreateDisputeEvidenceFileRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateDisputeEvidenceFileRequest [" + "idempotencyKey=" + idempotencyKey
                + ", evidenceType=" + evidenceType + ", contentType=" + contentType + "]";
    }

    /**
     * Builds a new {@link CreateDisputeEvidenceFileRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateDisputeEvidenceFileRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
                .evidenceType(getEvidenceType())
                .contentType(getContentType());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateDisputeEvidenceFileRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String evidenceType;
        private String contentType;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for evidenceType.
         * @param  evidenceType  String value for evidenceType.
         * @return Builder
         */
        public Builder evidenceType(String evidenceType) {
            this.evidenceType = evidenceType;
            return this;
        }

        /**
         * Setter for contentType.
         * @param  contentType  String value for contentType.
         * @return Builder
         */
        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * Builds a new {@link CreateDisputeEvidenceFileRequest} object using the set fields.
         * @return {@link CreateDisputeEvidenceFileRequest}
         */
        public CreateDisputeEvidenceFileRequest build() {
            return new CreateDisputeEvidenceFileRequest(idempotencyKey, evidenceType, contentType);
        }
    }
}
