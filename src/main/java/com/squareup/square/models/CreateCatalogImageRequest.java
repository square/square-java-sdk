package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateCatalogImageRequest type.
 */
public class CreateCatalogImageRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param objectId
     * @param image
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, objectId, image);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateCatalogImageRequest)) {
            return false;
        }
        CreateCatalogImageRequest createCatalogImageRequest = (CreateCatalogImageRequest) obj;
        return Objects.equals(idempotencyKey, createCatalogImageRequest.idempotencyKey) &&
            Objects.equals(objectId, createCatalogImageRequest.objectId) &&
            Objects.equals(image, createCatalogImageRequest.image);
    }

    /**
     * Builds a new {@link CreateCatalogImageRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCatalogImageRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
            .objectId(getObjectId())
            .image(getImage());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateCatalogImageRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private String objectId;
        private CatalogObject image;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for objectId
         * @param objectId
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = objectId;
            return this;
        }
        /**
         * Setter for image
         * @param image
         * @return Builder
         */
        public Builder image(CatalogObject image) {
            this.image = image;
            return this;
        }

        /**
         * Builds a new {@link CreateCatalogImageRequest} object using the set fields.
         * @return {@link CreateCatalogImageRequest}
         */
        public CreateCatalogImageRequest build() {
            return new CreateCatalogImageRequest(idempotencyKey,
                objectId,
                image);
        }
    }
}
