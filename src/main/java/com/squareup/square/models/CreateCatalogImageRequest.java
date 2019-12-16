package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateCatalogImageRequest {

    @JsonCreator
    public CreateCatalogImageRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("object_id") String objectId,
            @JsonProperty("image") CatalogObject image) {
        this.idempotencyKey = idempotencyKey;
        this.objectId = objectId;
        this.image = image;
    }

    private final String idempotencyKey;
    private final String objectId;
    private final CatalogObject image;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, objectId, image);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateCatalogImageRequest)) {
            return false;
        }
        CreateCatalogImageRequest createCatalogImageRequest = (CreateCatalogImageRequest) o;
        return Objects.equals(idempotencyKey, createCatalogImageRequest.idempotencyKey) &&
            Objects.equals(objectId, createCatalogImageRequest.objectId) &&
            Objects.equals(image, createCatalogImageRequest.image);
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this CreateCatalogImage request.
     * Keys can be any valid string but must be unique for every CreateCatalogImage request.
     * See [Idempotency keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for ObjectId.
     * Unique ID of the `CatalogObject` to attach to this `CatalogImage`. Leave this
     * field empty to create unattached images, for example if you are building an integration
     * where these images can be attached to catalog items at a later time.
     */
    @JsonGetter("object_id")
    public String getObjectId() { 
        return this.objectId;
    }

    /**
     * Getter for Image.
     */
    @JsonGetter("image")
    public CatalogObject getImage() { 
        return this.image;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
            .objectId(getObjectId())
            .image(getImage());
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;
        private String objectId;
        private CatalogObject image;

        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder objectId(String value) {
            objectId = value;
            return this;
        }
        public Builder image(CatalogObject value) {
            image = value;
            return this;
        }

        public CreateCatalogImageRequest build() {
            return new CreateCatalogImageRequest(idempotencyKey,
                objectId,
                image);
        }
    }
}
