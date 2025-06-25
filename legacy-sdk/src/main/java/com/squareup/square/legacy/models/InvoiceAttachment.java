package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InvoiceAttachment type.
 */
public class InvoiceAttachment {
    private final String id;
    private final String filename;
    private final String description;
    private final Integer filesize;
    private final String hash;
    private final String mimeType;
    private final String uploadedAt;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  filename  String value for filename.
     * @param  description  String value for description.
     * @param  filesize  Integer value for filesize.
     * @param  hash  String value for hash.
     * @param  mimeType  String value for mimeType.
     * @param  uploadedAt  String value for uploadedAt.
     */
    @JsonCreator
    public InvoiceAttachment(
            @JsonProperty("id") String id,
            @JsonProperty("filename") String filename,
            @JsonProperty("description") String description,
            @JsonProperty("filesize") Integer filesize,
            @JsonProperty("hash") String hash,
            @JsonProperty("mime_type") String mimeType,
            @JsonProperty("uploaded_at") String uploadedAt) {
        this.id = id;
        this.filename = filename;
        this.description = description;
        this.filesize = filesize;
        this.hash = hash;
        this.mimeType = mimeType;
        this.uploadedAt = uploadedAt;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the attachment.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Filename.
     * The file name of the attachment, which is displayed on the invoice.
     * @return Returns the String
     */
    @JsonGetter("filename")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFilename() {
        return filename;
    }

    /**
     * Getter for Description.
     * The description of the attachment, which is displayed on the invoice. This field maps to the
     * seller-defined **Message** field.
     * @return Returns the String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }

    /**
     * Getter for Filesize.
     * The file size of the attachment in bytes.
     * @return Returns the Integer
     */
    @JsonGetter("filesize")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getFilesize() {
        return filesize;
    }

    /**
     * Getter for Hash.
     * The MD5 hash that was generated from the file contents.
     * @return Returns the String
     */
    @JsonGetter("hash")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getHash() {
        return hash;
    }

    /**
     * Getter for MimeType.
     * The mime type of the attachment. The following mime types are supported: image/gif,
     * image/jpeg, image/png, image/tiff, image/bmp, application/pdf.
     * @return Returns the String
     */
    @JsonGetter("mime_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Getter for UploadedAt.
     * The timestamp when the attachment was uploaded, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("uploaded_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUploadedAt() {
        return uploadedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filename, description, filesize, hash, mimeType, uploadedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoiceAttachment)) {
            return false;
        }
        InvoiceAttachment other = (InvoiceAttachment) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(filename, other.filename)
                && Objects.equals(description, other.description)
                && Objects.equals(filesize, other.filesize)
                && Objects.equals(hash, other.hash)
                && Objects.equals(mimeType, other.mimeType)
                && Objects.equals(uploadedAt, other.uploadedAt);
    }

    /**
     * Converts this InvoiceAttachment into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceAttachment [" + "id=" + id + ", filename=" + filename + ", description="
                + description + ", filesize=" + filesize + ", hash=" + hash + ", mimeType="
                + mimeType + ", uploadedAt=" + uploadedAt + "]";
    }

    /**
     * Builds a new {@link InvoiceAttachment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceAttachment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .filename(getFilename())
                .description(getDescription())
                .filesize(getFilesize())
                .hash(getHash())
                .mimeType(getMimeType())
                .uploadedAt(getUploadedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceAttachment}.
     */
    public static class Builder {
        private String id;
        private String filename;
        private String description;
        private Integer filesize;
        private String hash;
        private String mimeType;
        private String uploadedAt;

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
         * Setter for filename.
         * @param  filename  String value for filename.
         * @return Builder
         */
        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for filesize.
         * @param  filesize  Integer value for filesize.
         * @return Builder
         */
        public Builder filesize(Integer filesize) {
            this.filesize = filesize;
            return this;
        }

        /**
         * Setter for hash.
         * @param  hash  String value for hash.
         * @return Builder
         */
        public Builder hash(String hash) {
            this.hash = hash;
            return this;
        }

        /**
         * Setter for mimeType.
         * @param  mimeType  String value for mimeType.
         * @return Builder
         */
        public Builder mimeType(String mimeType) {
            this.mimeType = mimeType;
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
         * Builds a new {@link InvoiceAttachment} object using the set fields.
         * @return {@link InvoiceAttachment}
         */
        public InvoiceAttachment build() {
            return new InvoiceAttachment(id, filename, description, filesize, hash, mimeType, uploadedAt);
        }
    }
}
