/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogImage.Builder.class)
public final class CatalogImage {
    private final Optional<String> name;

    private final Optional<String> url;

    private final Optional<String> caption;

    private final Optional<String> photoStudioOrderId;

    private final Map<String, Object> additionalProperties;

    private CatalogImage(
            Optional<String> name,
            Optional<String> url,
            Optional<String> caption,
            Optional<String> photoStudioOrderId,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.url = url;
        this.caption = caption;
        this.photoStudioOrderId = photoStudioOrderId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The internal name to identify this image in calls to the Square API.
     * This is a searchable attribute for use in applicable query filters
     * using the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>.
     * It is not unique and should not be shown in a buyer facing context.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return The URL of this image, generated by Square after an image is uploaded
     * using the <a href="api-endpoint:Catalog-CreateCatalogImage">CreateCatalogImage</a> endpoint.
     * To modify the image, use the UpdateCatalogImage endpoint. Do not change the URL field.
     */
    @JsonIgnore
    public Optional<String> getUrl() {
        if (url == null) {
            return Optional.empty();
        }
        return url;
    }

    /**
     * @return A caption that describes what is shown in the image. Displayed in the
     * Square Online Store. This is a searchable attribute for use in applicable query filters
     * using the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>.
     */
    @JsonIgnore
    public Optional<String> getCaption() {
        if (caption == null) {
            return Optional.empty();
        }
        return caption;
    }

    /**
     * @return The immutable order ID for this image object created by the Photo Studio service in Square Online Store.
     */
    @JsonIgnore
    public Optional<String> getPhotoStudioOrderId() {
        if (photoStudioOrderId == null) {
            return Optional.empty();
        }
        return photoStudioOrderId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("url")
    private Optional<String> _getUrl() {
        return url;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("caption")
    private Optional<String> _getCaption() {
        return caption;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("photo_studio_order_id")
    private Optional<String> _getPhotoStudioOrderId() {
        return photoStudioOrderId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogImage && equalTo((CatalogImage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogImage other) {
        return name.equals(other.name)
                && url.equals(other.url)
                && caption.equals(other.caption)
                && photoStudioOrderId.equals(other.photoStudioOrderId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.url, this.caption, this.photoStudioOrderId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> name = Optional.empty();

        private Optional<String> url = Optional.empty();

        private Optional<String> caption = Optional.empty();

        private Optional<String> photoStudioOrderId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogImage other) {
            name(other.getName());
            url(other.getUrl());
            caption(other.getCaption());
            photoStudioOrderId(other.getPhotoStudioOrderId());
            return this;
        }

        /**
         * <p>The internal name to identify this image in calls to the Square API.
         * This is a searchable attribute for use in applicable query filters
         * using the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>.
         * It is not unique and should not be shown in a buyer facing context.</p>
         */
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Nullable<String> name) {
            if (name.isNull()) {
                this.name = null;
            } else if (name.isEmpty()) {
                this.name = Optional.empty();
            } else {
                this.name = Optional.of(name.get());
            }
            return this;
        }

        /**
         * <p>The URL of this image, generated by Square after an image is uploaded
         * using the <a href="api-endpoint:Catalog-CreateCatalogImage">CreateCatalogImage</a> endpoint.
         * To modify the image, use the UpdateCatalogImage endpoint. Do not change the URL field.</p>
         */
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public Builder url(Optional<String> url) {
            this.url = url;
            return this;
        }

        public Builder url(String url) {
            this.url = Optional.ofNullable(url);
            return this;
        }

        public Builder url(Nullable<String> url) {
            if (url.isNull()) {
                this.url = null;
            } else if (url.isEmpty()) {
                this.url = Optional.empty();
            } else {
                this.url = Optional.of(url.get());
            }
            return this;
        }

        /**
         * <p>A caption that describes what is shown in the image. Displayed in the
         * Square Online Store. This is a searchable attribute for use in applicable query filters
         * using the <a href="api-endpoint:Catalog-SearchCatalogObjects">SearchCatalogObjects</a>.</p>
         */
        @JsonSetter(value = "caption", nulls = Nulls.SKIP)
        public Builder caption(Optional<String> caption) {
            this.caption = caption;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = Optional.ofNullable(caption);
            return this;
        }

        public Builder caption(Nullable<String> caption) {
            if (caption.isNull()) {
                this.caption = null;
            } else if (caption.isEmpty()) {
                this.caption = Optional.empty();
            } else {
                this.caption = Optional.of(caption.get());
            }
            return this;
        }

        /**
         * <p>The immutable order ID for this image object created by the Photo Studio service in Square Online Store.</p>
         */
        @JsonSetter(value = "photo_studio_order_id", nulls = Nulls.SKIP)
        public Builder photoStudioOrderId(Optional<String> photoStudioOrderId) {
            this.photoStudioOrderId = photoStudioOrderId;
            return this;
        }

        public Builder photoStudioOrderId(String photoStudioOrderId) {
            this.photoStudioOrderId = Optional.ofNullable(photoStudioOrderId);
            return this;
        }

        public Builder photoStudioOrderId(Nullable<String> photoStudioOrderId) {
            if (photoStudioOrderId.isNull()) {
                this.photoStudioOrderId = null;
            } else if (photoStudioOrderId.isEmpty()) {
                this.photoStudioOrderId = Optional.empty();
            } else {
                this.photoStudioOrderId = Optional.of(photoStudioOrderId.get());
            }
            return this;
        }

        public CatalogImage build() {
            return new CatalogImage(name, url, caption, photoStudioOrderId, additionalProperties);
        }
    }
}
