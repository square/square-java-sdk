
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1ItemImage type.
 */
public class V1ItemImage {
    private final String id;
    private final String url;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param url String value for url.
     */
    @JsonCreator
    public V1ItemImage(
            @JsonProperty("id") String id,
            @JsonProperty("url") String url) {
        this.id = id;
        this.url = url;
    }

    /**
     * Getter for Id.
     * The image's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Url.
     * The image's publicly accessible URL.
     * @return Returns the String
     */
    @JsonGetter("url")
    public String getUrl() {
        return this.url;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ItemImage)) {
            return false;
        }
        V1ItemImage other = (V1ItemImage) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(url, other.url);
    }

    /**
     * Converts this V1ItemImage into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ItemImage [" + "id=" + id + ", url=" + url + "]";
    }

    /**
     * Builds a new {@link V1ItemImage.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ItemImage.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .url(getUrl());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ItemImage}.
     */
    public static class Builder {
        private String id;
        private String url;



        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for url.
         * @param url String value for url.
         * @return Builder
         */
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * Builds a new {@link V1ItemImage} object using the set fields.
         * @return {@link V1ItemImage}
         */
        public V1ItemImage build() {
            return new V1ItemImage(id, url);
        }
    }
}
