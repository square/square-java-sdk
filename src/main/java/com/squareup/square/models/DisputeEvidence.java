
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidence type.
 */
public class DisputeEvidence {
    private final String evidenceId;
    private final String disputeId;
    private final String uploadedAt;
    private final String evidenceType;

    /**
     * Initialization constructor.
     * @param evidenceId String value for evidenceId.
     * @param disputeId String value for disputeId.
     * @param uploadedAt String value for uploadedAt.
     * @param evidenceType String value for evidenceType.
     */
    @JsonCreator
    public DisputeEvidence(
            @JsonProperty("evidence_id") String evidenceId,
            @JsonProperty("dispute_id") String disputeId,
            @JsonProperty("uploaded_at") String uploadedAt,
            @JsonProperty("evidence_type") String evidenceType) {
        this.evidenceId = evidenceId;
        this.disputeId = disputeId;
        this.uploadedAt = uploadedAt;
        this.evidenceType = evidenceType;
    }

    /**
     * Getter for EvidenceId.
     * The Square-generated ID of the evidence.
     * @return Returns the String
     */
    @JsonGetter("evidence_id")
    public String getEvidenceId() {
        return this.evidenceId;
    }

    /**
     * Getter for DisputeId.
     * The ID of the dispute the evidence is associated with.
     * @return Returns the String
     */
    @JsonGetter("dispute_id")
    public String getDisputeId() {
        return this.disputeId;
    }

    /**
     * Getter for UploadedAt.
     * The time when the next action is due, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("uploaded_at")
    public String getUploadedAt() {
        return this.uploadedAt;
    }

    /**
     * Getter for EvidenceType.
     * The type of the dispute evidence.
     * @return Returns the String
     */
    @JsonGetter("evidence_type")
    public String getEvidenceType() {
        return this.evidenceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(evidenceId, disputeId, uploadedAt, evidenceType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DisputeEvidence)) {
            return false;
        }
        DisputeEvidence other = (DisputeEvidence) obj;
        return Objects.equals(evidenceId, other.evidenceId)
            && Objects.equals(disputeId, other.disputeId)
            && Objects.equals(uploadedAt, other.uploadedAt)
            && Objects.equals(evidenceType, other.evidenceType);
    }

    /**
     * Converts this DisputeEvidence into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DisputeEvidence [" + "evidenceId=" + evidenceId + ", disputeId=" + disputeId
                + ", uploadedAt=" + uploadedAt + ", evidenceType=" + evidenceType + "]";
    }

    /**
     * Builds a new {@link DisputeEvidence.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DisputeEvidence.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .evidenceId(getEvidenceId())
                .disputeId(getDisputeId())
                .uploadedAt(getUploadedAt())
                .evidenceType(getEvidenceType());
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidence}.
     */
    public static class Builder {
        private String evidenceId;
        private String disputeId;
        private String uploadedAt;
        private String evidenceType;



        /**
         * Setter for evidenceId.
         * @param evidenceId String value for evidenceId.
         * @return Builder
         */
        public Builder evidenceId(String evidenceId) {
            this.evidenceId = evidenceId;
            return this;
        }

        /**
         * Setter for disputeId.
         * @param disputeId String value for disputeId.
         * @return Builder
         */
        public Builder disputeId(String disputeId) {
            this.disputeId = disputeId;
            return this;
        }

        /**
         * Setter for uploadedAt.
         * @param uploadedAt String value for uploadedAt.
         * @return Builder
         */
        public Builder uploadedAt(String uploadedAt) {
            this.uploadedAt = uploadedAt;
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
         * Builds a new {@link DisputeEvidence} object using the set fields.
         * @return {@link DisputeEvidence}
         */
        public DisputeEvidence build() {
            return new DisputeEvidence(evidenceId, disputeId, uploadedAt, evidenceType);
        }
    }
}
