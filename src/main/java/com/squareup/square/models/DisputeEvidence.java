package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DisputeEvidence type.
 */
public class DisputeEvidence {

    /**
     * Initialization constructor.
     * @param evidenceId
     * @param disputeId
     * @param uploadedAt
     * @param evidenceType
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

    private final String evidenceId;
    private final String disputeId;
    private final String uploadedAt;
    private final String evidenceType;
    /**
     * Getter for EvidenceId.
     * The Square-generated ID of the evidence.
     */
    @JsonGetter("evidence_id")
    public String getEvidenceId() {
        return this.evidenceId;
    }

    /**
     * Getter for DisputeId.
     * The ID of the dispute the evidence is associated with.
     */
    @JsonGetter("dispute_id")
    public String getDisputeId() {
        return this.disputeId;
    }

    /**
     * Getter for UploadedAt.
     * The time when the next action is due, in RFC 3339 format.
     */
    @JsonGetter("uploaded_at")
    public String getUploadedAt() {
        return this.uploadedAt;
    }

    /**
     * Getter for EvidenceType.
     * Type of the dispute evidence.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DisputeEvidence)) {
            return false;
        }
        DisputeEvidence disputeEvidence = (DisputeEvidence) obj;
        return Objects.equals(evidenceId, disputeEvidence.evidenceId) &&
            Objects.equals(disputeId, disputeEvidence.disputeId) &&
            Objects.equals(uploadedAt, disputeEvidence.uploadedAt) &&
            Objects.equals(evidenceType, disputeEvidence.evidenceType);
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
     * Class to build instances of {@link DisputeEvidence}
     */
    public static class Builder {
        private String evidenceId;
        private String disputeId;
        private String uploadedAt;
        private String evidenceType;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for evidenceId
         * @param evidenceId
         * @return Builder
         */
        public Builder evidenceId(String evidenceId) {
            this.evidenceId = evidenceId;
            return this;
        }
        /**
         * Setter for disputeId
         * @param disputeId
         * @return Builder
         */
        public Builder disputeId(String disputeId) {
            this.disputeId = disputeId;
            return this;
        }
        /**
         * Setter for uploadedAt
         * @param uploadedAt
         * @return Builder
         */
        public Builder uploadedAt(String uploadedAt) {
            this.uploadedAt = uploadedAt;
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
         * Builds a new {@link DisputeEvidence} object using the set fields.
         * @return {@link DisputeEvidence}
         */
        public DisputeEvidence build() {
            return new DisputeEvidence(evidenceId,
                disputeId,
                uploadedAt,
                evidenceType);
        }
    }
}
