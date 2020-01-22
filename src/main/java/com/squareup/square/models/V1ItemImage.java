package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ItemImage type.
 */
public class V1ItemImage {

    /**
     * Initialization constructor.
     * @param id
     * @param url
     */
    @JsonCreator
    public V1ItemImage(
            @JsonProperty("id") String id,
            @JsonProperty("url") String url) {
        this.id = id;
        this.url = url;
    }

    private final String id;
    private final String url;
    /**
     * Getter for Id.
     * The image's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Url.
     * The image's publicly accessible URL.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ItemImage)) {
            return false;
        }
        V1ItemImage v1ItemImage = (V1ItemImage) obj;
        return Objects.equals(id, v1ItemImage.id) &&
            Objects.equals(url, v1ItemImage.url);
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
     * Class to build instances of {@link V1ItemImage}
     */
    public static class Builder {
        private String id;
        private String url;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for url
         * @param url
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
            return new V1ItemImage(id,
                url);
        }
    }
}
