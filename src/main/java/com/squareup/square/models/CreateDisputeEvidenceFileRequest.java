package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateDisputeEvidenceFileRequest type.
 */
public class CreateDisputeEvidenceFileRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param evidenceType
     * @param contentType
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

    private final String idempotencyKey;
    private final String evidenceType;
    private final String contentType;
    /**
     * Getter for IdempotencyKey.
     * Unique ID. For more information,
     * see [Idempotency](https://developer.squareup.com/docs/docs/working-with-apis/idempotency).
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for EvidenceType.
     * Type of the dispute evidence.
     */
    @JsonGetter("evidence_type")
    public String getEvidenceType() {
        return this.evidenceType;
    }

    /**
     * Getter for ContentType.
     * The MIME type of the uploaded file.
     * One of image/heic, image/heif, image/jpeg, application/pdf,  image/png, image/tiff.
     */
    @JsonGetter("content_type")
    public String getContentType() {
        return this.contentType;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, evidenceType, contentType);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateDisputeEvidenceFileRequest)) {
            return false;
        }
        CreateDisputeEvidenceFileRequest createDisputeEvidenceFileRequest = (CreateDisputeEvidenceFileRequest) obj;
        return Objects.equals(idempotencyKey, createDisputeEvidenceFileRequest.idempotencyKey) &&
            Objects.equals(evidenceType, createDisputeEvidenceFileRequest.evidenceType) &&
            Objects.equals(contentType, createDisputeEvidenceFileRequest.contentType);
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
     * Class to build instances of {@link CreateDisputeEvidenceFileRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private String evidenceType;
        private String contentType;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for evidenceType
         * @param evidenceType
         * @return Builder
         */
        public Builder evidenceType(String evidenceType) {
            this.evidenceType = evidenceType;
            return this;
        }
        /**
         * Setter for contentType
         * @param contentType
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
            return new CreateDisputeEvidenceFileRequest(idempotencyKey,
                evidenceType,
                contentType);
        }
    }
}
