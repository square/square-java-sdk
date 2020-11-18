
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateDisputeEvidenceTextRequest type.
 */
public class CreateDisputeEvidenceTextRequest {
    private final String idempotencyKey;
    private final String evidenceType;
    private final String evidenceText;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param evidenceText String value for evidenceText.
     * @param evidenceType String value for evidenceType.
     */
    @JsonCreator
    public CreateDisputeEvidenceTextRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("evidence_text") String evidenceText,
            @JsonProperty("evidence_type") String evidenceType) {
        this.idempotencyKey = idempotencyKey;
        this.evidenceType = evidenceType;
        this.evidenceText = evidenceText;
    }

    /**
     * Getter for IdempotencyKey.
     * Unique ID. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for EvidenceType.
     * Type of the dispute evidence.
     * @return Returns the String
     */
    @JsonGetter("evidence_type")
    public String getEvidenceType() {
        return this.evidenceType;
    }

    /**
     * Getter for EvidenceText.
     * The evidence string.
     * @return Returns the String
     */
    @JsonGetter("evidence_text")
    public String getEvidenceText() {
        return this.evidenceText;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, evidenceType, evidenceText);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateDisputeEvidenceTextRequest)) {
            return false;
        }
        CreateDisputeEvidenceTextRequest other = (CreateDisputeEvidenceTextRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(evidenceType, other.evidenceType)
            && Objects.equals(evidenceText, other.evidenceText);
    }

    /**
     * Converts this CreateDisputeEvidenceTextRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateDisputeEvidenceTextRequest [" + "idempotencyKey=" + idempotencyKey
                + ", evidenceText=" + evidenceText + ", evidenceType=" + evidenceType + "]";
    }

    /**
     * Builds a new {@link CreateDisputeEvidenceTextRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateDisputeEvidenceTextRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, evidenceText)
                .evidenceType(getEvidenceType());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateDisputeEvidenceTextRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String evidenceText;
        private String evidenceType;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         * @param evidenceText String value for evidenceText.
         */
        public Builder(String idempotencyKey,
                String evidenceText) {
            this.idempotencyKey = idempotencyKey;
            this.evidenceText = evidenceText;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for evidenceText.
         * @param evidenceText String value for evidenceText.
         * @return Builder
         */
        public Builder evidenceText(String evidenceText) {
            this.evidenceText = evidenceText;
            return this;
        }

        /**
         * Setter for evidenceType.
         * @param evidenceType String value for evidenceType.
         * @return Builder
         */
        public Builder evidenceType(String evidenceType) {
            this.evidenceType = evidenceType;
            return this;
        }

        /**
         * Builds a new {@link CreateDisputeEvidenceTextRequest} object using the set fields.
         * @return {@link CreateDisputeEvidenceTextRequest}
         */
        public CreateDisputeEvidenceTextRequest build() {
            return new CreateDisputeEvidenceTextRequest(idempotencyKey, evidenceText, evidenceType);
        }
    }
}
