package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SignatureImage type.
 */
public class SignatureImage {
    private final String imageType;
    private final String data;

    /**
     * Initialization constructor.
     * @param  imageType  String value for imageType.
     * @param  data  String value for data.
     */
    @JsonCreator
    public SignatureImage(@JsonProperty("image_type") String imageType, @JsonProperty("data") String data) {
        this.imageType = imageType;
        this.data = data;
    }

    /**
     * Getter for ImageType.
     * The mime/type of the image data. Use `image/png;base64` for png.
     * @return Returns the String
     */
    @JsonGetter("image_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getImageType() {
        return imageType;
    }

    /**
     * Getter for Data.
     * The base64 representation of the image.
     * @return Returns the String
     */
    @JsonGetter("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getData() {
        return data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageType, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignatureImage)) {
            return false;
        }
        SignatureImage other = (SignatureImage) obj;
        return Objects.equals(imageType, other.imageType) && Objects.equals(data, other.data);
    }

    /**
     * Converts this SignatureImage into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SignatureImage [" + "imageType=" + imageType + ", data=" + data + "]";
    }

    /**
     * Builds a new {@link SignatureImage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SignatureImage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().imageType(getImageType()).data(getData());
        return builder;
    }

    /**
     * Class to build instances of {@link SignatureImage}.
     */
    public static class Builder {
        private String imageType;
        private String data;

        /**
         * Setter for imageType.
         * @param  imageType  String value for imageType.
         * @return Builder
         */
        public Builder imageType(String imageType) {
            this.imageType = imageType;
            return this;
        }

        /**
         * Setter for data.
         * @param  data  String value for data.
         * @return Builder
         */
        public Builder data(String data) {
            this.data = data;
            return this;
        }

        /**
         * Builds a new {@link SignatureImage} object using the set fields.
         * @return {@link SignatureImage}
         */
        public SignatureImage build() {
            return new SignatureImage(imageType, data);
        }
    }
}
