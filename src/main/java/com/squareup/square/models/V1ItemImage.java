package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ItemImage {

    @JsonCreator
    public V1ItemImage(
            @JsonProperty("id") String id,
            @JsonProperty("url") String url) {
        this.id = id;
        this.url = url;
    }

    private final String id;
    private final String url;

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ItemImage)) {
            return false;
        }
        V1ItemImage v1ItemImage = (V1ItemImage) o;
        return Objects.equals(id, v1ItemImage.id) &&
            Objects.equals(url, v1ItemImage.url);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .url(getUrl());
            return builder;
    }

    public static class Builder {
        private String id;
        private String url;

        public Builder() { }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder url(String value) {
            url = value;
            return this;
        }

        public V1ItemImage build() {
            return new V1ItemImage(id,
                url);
        }
    }
}
