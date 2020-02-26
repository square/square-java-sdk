package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DisputeEvidenceFile type.
 */
public class DisputeEvidenceFile {

    /**
     * Initialization constructor.
     * @param filename
     * @param filetype
     */
    @JsonCreator
    public DisputeEvidenceFile(
            @JsonProperty("filename") String filename,
            @JsonProperty("filetype") String filetype) {
        this.filename = filename;
        this.filetype = filetype;
    }

    private final String filename;
    private final String filetype;
    /**
     * Getter for Filename.
     * The file name including the file extension. For example: "receipt.tiff".
     */
    @JsonGetter("filename")
    public String getFilename() {
        return this.filename;
    }

    /**
     * Getter for Filetype.
     * Dispute evidence files must one of application/pdf, image/heic, image/heif, image/jpeg, image/png, image/tiff formats.
     */
    @JsonGetter("filetype")
    public String getFiletype() {
        return this.filetype;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filename, filetype);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DisputeEvidenceFile)) {
            return false;
        }
        DisputeEvidenceFile disputeEvidenceFile = (DisputeEvidenceFile) obj;
        return Objects.equals(filename, disputeEvidenceFile.filename) &&
            Objects.equals(filetype, disputeEvidenceFile.filetype);
    }

    /**
     * Builds a new {@link DisputeEvidenceFile.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DisputeEvidenceFile.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filename(getFilename())
            .filetype(getFiletype());
            return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidenceFile}
     */
    public static class Builder {
        private String filename;
        private String filetype;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filename
         * @param filename
         * @return Builder
         */
        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }
        /**
         * Setter for filetype
         * @param filetype
         * @return Builder
         */
        public Builder filetype(String filetype) {
            this.filetype = filetype;
            return this;
        }

        /**
         * Builds a new {@link DisputeEvidenceFile} object using the set fields.
         * @return {@link DisputeEvidenceFile}
         */
        public DisputeEvidenceFile build() {
            return new DisputeEvidenceFile(filename,
                filetype);
        }
    }
}
