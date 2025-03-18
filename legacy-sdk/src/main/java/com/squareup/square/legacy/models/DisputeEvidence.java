package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidence type.
 */
public class DisputeEvidence {
    private final OptionalNullable<String> evidenceId;
    private final String id;
    private final OptionalNullable<String> disputeId;
    private final DisputeEvidenceFile evidenceFile;
    private final OptionalNullable<String> evidenceText;
    private final OptionalNullable<String> uploadedAt;
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
        this.evidenceId = OptionalNullable.of(evidenceId);
        this.id = id;
        this.disputeId = OptionalNullable.of(disputeId);
        this.evidenceFile = evidenceFile;
        this.evidenceText = OptionalNullable.of(evidenceText);
        this.uploadedAt = OptionalNullable.of(uploadedAt);
        this.evidenceType = evidenceType;
    }

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
    protected DisputeEvidence(
            OptionalNullable<String> evidenceId,
            String id,
            OptionalNullable<String> disputeId,
            DisputeEvidenceFile evidenceFile,
            OptionalNullable<String> evidenceText,
            OptionalNullable<String> uploadedAt,
            String evidenceType) {
        this.evidenceId = evidenceId;
        this.id = id;
        this.disputeId = disputeId;
        this.evidenceFile = evidenceFile;
        this.evidenceText = evidenceText;
        this.uploadedAt = uploadedAt;
        this.evidenceType = evidenceType;
    }

    /**
     * Internal Getter for EvidenceId.
     * The Square-generated ID of the evidence.
     * @return Returns the Internal String
     */
    @JsonGetter("evidence_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEvidenceId() {
        return this.evidenceId;
    }

    /**
     * Getter for EvidenceId.
     * The Square-generated ID of the evidence.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEvidenceId() {
        return OptionalNullable.getFrom(evidenceId);
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
     * Internal Getter for DisputeId.
     * The ID of the dispute the evidence is associated with.
     * @return Returns the Internal String
     */
    @JsonGetter("dispute_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDisputeId() {
        return this.disputeId;
    }

    /**
     * Getter for DisputeId.
     * The ID of the dispute the evidence is associated with.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDisputeId() {
        return OptionalNullable.getFrom(disputeId);
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
     * Internal Getter for EvidenceText.
     * Raw text
     * @return Returns the Internal String
     */
    @JsonGetter("evidence_text")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEvidenceText() {
        return this.evidenceText;
    }

    /**
     * Getter for EvidenceText.
     * Raw text
     * @return Returns the String
     */
    @JsonIgnore
    public String getEvidenceText() {
        return OptionalNullable.getFrom(evidenceText);
    }

    /**
     * Internal Getter for UploadedAt.
     * The time when the evidence was uploaded, in RFC 3339 format.
     * @return Returns the Internal String
     */
    @JsonGetter("uploaded_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUploadedAt() {
        return this.uploadedAt;
    }

    /**
     * Getter for UploadedAt.
     * The time when the evidence was uploaded, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUploadedAt() {
        return OptionalNullable.getFrom(uploadedAt);
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
        return Objects.hash(evidenceId, id, disputeId, evidenceFile, evidenceText, uploadedAt, evidenceType);
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
        Builder builder =
                new Builder().id(getId()).evidenceFile(getEvidenceFile()).evidenceType(getEvidenceType());
        builder.evidenceId = internalGetEvidenceId();
        builder.disputeId = internalGetDisputeId();
        builder.evidenceText = internalGetEvidenceText();
        builder.uploadedAt = internalGetUploadedAt();
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidence}.
     */
    public static class Builder {
        private OptionalNullable<String> evidenceId;
        private String id;
        private OptionalNullable<String> disputeId;
        private DisputeEvidenceFile evidenceFile;
        private OptionalNullable<String> evidenceText;
        private OptionalNullable<String> uploadedAt;
        private String evidenceType;

        /**
         * Setter for evidenceId.
         * @param  evidenceId  String value for evidenceId.
         * @return Builder
         */
        public Builder evidenceId(String evidenceId) {
            this.evidenceId = OptionalNullable.of(evidenceId);
            return this;
        }

        /**
         * UnSetter for evidenceId.
         * @return Builder
         */
        public Builder unsetEvidenceId() {
            evidenceId = null;
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
            this.disputeId = OptionalNullable.of(disputeId);
            return this;
        }

        /**
         * UnSetter for disputeId.
         * @return Builder
         */
        public Builder unsetDisputeId() {
            disputeId = null;
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
            this.evidenceText = OptionalNullable.of(evidenceText);
            return this;
        }

        /**
         * UnSetter for evidenceText.
         * @return Builder
         */
        public Builder unsetEvidenceText() {
            evidenceText = null;
            return this;
        }

        /**
         * Setter for uploadedAt.
         * @param  uploadedAt  String value for uploadedAt.
         * @return Builder
         */
        public Builder uploadedAt(String uploadedAt) {
            this.uploadedAt = OptionalNullable.of(uploadedAt);
            return this;
        }

        /**
         * UnSetter for uploadedAt.
         * @return Builder
         */
        public Builder unsetUploadedAt() {
            uploadedAt = null;
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
            return new DisputeEvidence(evidenceId, id, disputeId, evidenceFile, evidenceText, uploadedAt, evidenceType);
        }
    }
}
