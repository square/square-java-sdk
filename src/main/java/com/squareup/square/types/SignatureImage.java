/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SignatureImage.Builder.class)
public final class SignatureImage {
    private final Optional<String> imageType;

    private final Optional<String> data;

    private final Map<String, Object> additionalProperties;

    private SignatureImage(
            Optional<String> imageType, Optional<String> data, Map<String, Object> additionalProperties) {
        this.imageType = imageType;
        this.data = data;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The mime/type of the image data.
     * Use <code>image/png;base64</code> for png.
     */
    @JsonProperty("image_type")
    public Optional<String> getImageType() {
        return imageType;
    }

    /**
     * @return The base64 representation of the image.
     */
    @JsonProperty("data")
    public Optional<String> getData() {
        return data;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SignatureImage && equalTo((SignatureImage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SignatureImage other) {
        return imageType.equals(other.imageType) && data.equals(other.data);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.imageType, this.data);
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
        private Optional<String> imageType = Optional.empty();

        private Optional<String> data = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SignatureImage other) {
            imageType(other.getImageType());
            data(other.getData());
            return this;
        }

        @JsonSetter(value = "image_type", nulls = Nulls.SKIP)
        public Builder imageType(Optional<String> imageType) {
            this.imageType = imageType;
            return this;
        }

        public Builder imageType(String imageType) {
            this.imageType = Optional.ofNullable(imageType);
            return this;
        }

        @JsonSetter(value = "data", nulls = Nulls.SKIP)
        public Builder data(Optional<String> data) {
            this.data = data;
            return this;
        }

        public Builder data(String data) {
            this.data = Optional.ofNullable(data);
            return this;
        }

        public SignatureImage build() {
            return new SignatureImage(imageType, data, additionalProperties);
        }
    }
}
