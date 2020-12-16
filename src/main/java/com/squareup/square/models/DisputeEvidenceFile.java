
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidenceFile type.
 */
public class DisputeEvidenceFile {
    private final String filename;
    private final String filetype;

    /**
     * Initialization constructor.
     * @param filename String value for filename.
     * @param filetype String value for filetype.
     */
    @JsonCreator
    public DisputeEvidenceFile(
            @JsonProperty("filename") String filename,
            @JsonProperty("filetype") String filetype) {
        this.filename = filename;
        this.filetype = filetype;
    }

    /**
     * Getter for Filename.
     * The file name including the file extension. For example: "receipt.tiff".
     * @return Returns the String
     */
    @JsonGetter("filename")
    public String getFilename() {
        return this.filename;
    }

    /**
     * Getter for Filetype.
     * Dispute evidence files must be application/pdf, image/heic, image/heif, image/jpeg,
     * image/png, or image/tiff formats.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DisputeEvidenceFile)) {
            return false;
        }
        DisputeEvidenceFile other = (DisputeEvidenceFile) obj;
        return Objects.equals(filename, other.filename)
            && Objects.equals(filetype, other.filetype);
    }

    /**
     * Converts this DisputeEvidenceFile into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DisputeEvidenceFile [" + "filename=" + filename + ", filetype=" + filetype + "]";
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
     * Class to build instances of {@link DisputeEvidenceFile}.
     */
    public static class Builder {
        private String filename;
        private String filetype;



        /**
         * Setter for filename.
         * @param filename String value for filename.
         * @return Builder
         */
        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        /**
         * Setter for filetype.
         * @param filetype String value for filetype.
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
            return new DisputeEvidenceFile(filename, filetype);
        }
    }
}
