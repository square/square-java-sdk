
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidenceFile type.
 */
public class DisputeEvidenceFile {
    private final OptionalNullable<String> filename;
    private final OptionalNullable<String> filetype;

    /**
     * Initialization constructor.
     * @param  filename  String value for filename.
     * @param  filetype  String value for filetype.
     */
    @JsonCreator
    public DisputeEvidenceFile(
            @JsonProperty("filename") String filename,
            @JsonProperty("filetype") String filetype) {
        this.filename = OptionalNullable.of(filename);
        this.filetype = OptionalNullable.of(filetype);
    }

    /**
     * Internal initialization constructor.
     */
    protected DisputeEvidenceFile(OptionalNullable<String> filename,
            OptionalNullable<String> filetype) {
        this.filename = filename;
        this.filetype = filetype;
    }

    /**
     * Internal Getter for Filename.
     * The file name including the file extension. For example: "receipt.tiff".
     * @return Returns the Internal String
     */
    @JsonGetter("filename")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFilename() {
        return this.filename;
    }

    /**
     * Getter for Filename.
     * The file name including the file extension. For example: "receipt.tiff".
     * @return Returns the String
     */
    @JsonIgnore
    public String getFilename() {
        return OptionalNullable.getFrom(filename);
    }

    /**
     * Internal Getter for Filetype.
     * Dispute evidence files must be application/pdf, image/heic, image/heif, image/jpeg,
     * image/png, or image/tiff formats.
     * @return Returns the Internal String
     */
    @JsonGetter("filetype")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFiletype() {
        return this.filetype;
    }

    /**
     * Getter for Filetype.
     * Dispute evidence files must be application/pdf, image/heic, image/heif, image/jpeg,
     * image/png, or image/tiff formats.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFiletype() {
        return OptionalNullable.getFrom(filetype);
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
        Builder builder = new Builder();
        builder.filename = internalGetFilename();
        builder.filetype = internalGetFiletype();
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidenceFile}.
     */
    public static class Builder {
        private OptionalNullable<String> filename;
        private OptionalNullable<String> filetype;



        /**
         * Setter for filename.
         * @param  filename  String value for filename.
         * @return Builder
         */
        public Builder filename(String filename) {
            this.filename = OptionalNullable.of(filename);
            return this;
        }

        /**
         * UnSetter for filename.
         * @return Builder
         */
        public Builder unsetFilename() {
            filename = null;
            return this;
        }

        /**
         * Setter for filetype.
         * @param  filetype  String value for filetype.
         * @return Builder
         */
        public Builder filetype(String filetype) {
            this.filetype = OptionalNullable.of(filetype);
            return this;
        }

        /**
         * UnSetter for filetype.
         * @return Builder
         */
        public Builder unsetFiletype() {
            filetype = null;
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
