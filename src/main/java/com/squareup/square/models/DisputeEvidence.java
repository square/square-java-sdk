
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidence type.
 */
public class DisputeEvidence {
    private final String evidenceId;
    private final String id;
    private final String disputeId;
    private final DisputeEvidenceFile evidenceFile;
    private final String evidenceText;
    private final String uploadedAt;
    private final String evidenceType;

    /**
     * Initialization constructor.
     * @param  evidenceId  String value for evidenceId.
     * @param  id  String value for id.
     * @param  disputeId  String value for disputeId.
     * @param  evidenceFile  DisputeEvidenceFile value for evidenceFile.
     * @param  evidenceText  String value for evidenceText.
     * @param  uploadedAt  String value for uploadedAt.
     * @param  evidenceType  String value for evidenceType.
     */
    @JsonCreator
    public DisputeEvidence(
            @JsonProperty("evidence_id") String evidenceId,
            @JsonProperty("id") String id,
            @JsonProperty("dispute_id") String disputeId,
            @JsonProperty("evidence_file") DisputeEvidenceFile evidenceFile,
            @JsonProperty("evidence_text") String evidenceText,
            @JsonProperty("uploaded_at") String uploadedAt,
            @JsonProperty("evidence_type") String evidenceType) {
        this.evidenceId = evidenceId;
        this.id = id;
        this.disputeId = disputeId;
        this.evidenceFile = evidenceFile;
        this.evidenceText = evidenceText;
        this.uploadedAt = uploadedAt;
        this.evidenceType = evidenceType;
    }

    /**
     * Getter for EvidenceId.
     * The Square-generated ID of the evidence.
     * @return Returns the String
     */
    @JsonGetter("evidence_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEvidenceId() {
        return evidenceId;
    }

    /**
     * Getter for Id.
     * The Square-generated ID of the evidence.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for DisputeId.
     * The ID of the dispute the evidence is associated with.
     * @return Returns the String
     */
    @JsonGetter("dispute_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisputeId() {
        return disputeId;
    }

    /**
     * Getter for EvidenceFile.
     * A file to be uploaded as dispute evidence.
     * @return Returns the DisputeEvidenceFile
     */
    @JsonGetter("evidence_file")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DisputeEvidenceFile getEvidenceFile() {
        return evidenceFile;
    }

    /**
     * Getter for EvidenceText.
     * Raw text
     * @return Returns the String
     */
    @JsonGetter("evidence_text")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEvidenceText() {
        return evidenceText;
    }

    /**
     * Getter for UploadedAt.
     * The time when the evidence was uploaded, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("uploaded_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUploadedAt() {
        return uploadedAt;
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

    @Override
    public int hashCode() {
        return Objects.hash(evidenceId, id, disputeId, evidenceFile, evidenceText, uploadedAt,
                evidenceType);
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
            && Objects.equals(id, other.id)
            && Objects.equals(disputeId, other.disputeId)
            && Objects.equals(evidenceFile, other.evidenceFile)
            && Objects.equals(evidenceText, other.evidenceText)
            && Objects.equals(uploadedAt, other.uploadedAt)
            && Objects.equals(evidenceType, other.evidenceType);
    }

    /**
     * Converts this DisputeEvidence into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DisputeEvidence [" + "evidenceId=" + evidenceId + ", id=" + id + ", disputeId="
                + disputeId + ", evidenceFile=" + evidenceFile + ", evidenceText=" + evidenceText
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
                .id(getId())
                .disputeId(getDisputeId())
                .evidenceFile(getEvidenceFile())
                .evidenceText(getEvidenceText())
                .uploadedAt(getUploadedAt())
                .evidenceType(getEvidenceType());
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidence}.
     */
    public static class Builder {
        private String evidenceId;
        private String id;
        private String disputeId;
        private DisputeEvidenceFile evidenceFile;
        private String evidenceText;
        private String uploadedAt;
        private String evidenceType;



        /**
         * Setter for evidenceId.
         * @param  evidenceId  String value for evidenceId.
         * @return Builder
         */
        public Builder evidenceId(String evidenceId) {
            this.evidenceId = evidenceId;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for disputeId.
         * @param  disputeId  String value for disputeId.
         * @return Builder
         */
        public Builder disputeId(String disputeId) {
            this.disputeId = disputeId;
            return this;
        }

        /**
         * Setter for evidenceFile.
         * @param  evidenceFile  DisputeEvidenceFile value for evidenceFile.
         * @return Builder
         */
        public Builder evidenceFile(DisputeEvidenceFile evidenceFile) {
            this.evidenceFile = evidenceFile;
            return this;
        }

        /**
         * Setter for evidenceText.
         * @param  evidenceText  String value for evidenceText.
         * @return Builder
         */
        public Builder evidenceText(String evidenceText) {
            this.evidenceText = evidenceText;
            return this;
        }

        /**
         * Setter for uploadedAt.
         * @param  uploadedAt  String value for uploadedAt.
         * @return Builder
         */
        public Builder uploadedAt(String uploadedAt) {
            this.uploadedAt = uploadedAt;
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
         * Builds a new {@link DisputeEvidence} object using the set fields.
         * @return {@link DisputeEvidence}
         */
        public DisputeEvidence build() {
            return new DisputeEvidence(evidenceId, id, disputeId, evidenceFile, evidenceText,
                    uploadedAt, evidenceType);
        }
    }
}
