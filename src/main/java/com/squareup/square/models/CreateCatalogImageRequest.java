
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateCatalogImageRequest type.
 */
public class CreateCatalogImageRequest {
    private final String idempotencyKey;
    private final String objectId;
    private final CatalogObject image;
    private final Boolean isPrimary;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  image  CatalogObject value for image.
     * @param  objectId  String value for objectId.
     * @param  isPrimary  Boolean value for isPrimary.
     */
    @JsonCreator
    public CreateCatalogImageRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("image") CatalogObject image,
            @JsonProperty("object_id") String objectId,
            @JsonProperty("is_primary") Boolean isPrimary) {
        this.idempotencyKey = idempotencyKey;
        this.objectId = objectId;
        this.image = image;
        this.isPrimary = isPrimary;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this CreateCatalogImage request. Keys can be any valid string
     * but must be unique for every CreateCatalogImage request. See [Idempotency
     * keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for ObjectId.
     * Unique ID of the `CatalogObject` to attach this `CatalogImage` object to. Leave this field
     * empty to create unattached images, for example if you are building an integration where an
     * image can be attached to catalog items at a later time.
     * @return Returns the String
     */
    @JsonGetter("object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getObjectId() {
        return objectId;
    }

    /**
     * Getter for Image.
     * The wrapper object for the catalog entries of a given object type. Depending on the `type`
     * attribute value, a `CatalogObject` instance assumes a type-specific data to yield the
     * corresponding type of catalog object. For example, if `type=ITEM`, the `CatalogObject`
     * instance must have the ITEM-specific data set on the `item_data` attribute. The resulting
     * `CatalogObject` instance is also a `CatalogItem` instance. In general, if
     * `type=&lt;OBJECT_TYPE&gt;`, the `CatalogObject` instance must have the `&lt;OBJECT_TYPE&gt;`-specific
     * data set on the `&lt;object_type&gt;_data` attribute. The resulting `CatalogObject` instance is
     * also a `Catalog&lt;ObjectType&gt;` instance. For a more detailed discussion of the Catalog data
     * model, please see the [Design a
     * Catalog](https://developer.squareup.com/docs/catalog-api/design-a-catalog) guide.
     * @return Returns the CatalogObject
     */
    @JsonGetter("image")
    public CatalogObject getImage() {
        return image;
    }

    /**
     * Getter for IsPrimary.
     * If this is set to `true`, the image created will be the primary, or first image of the object
     * referenced by `object_id`. If the `CatalogObject` already has a primary `CatalogImage`,
     * setting this field to `true` will replace the primary image. If this is set to `false` and
     * you use the Square API version 2021-12-15 or later, the image id will be appended to the list
     * of `image_ids` on the object. With Square API version 2021-12-15 or later, the default value
     * is `false`. Otherwise, the effective default value is `true`.
     * @return Returns the Boolean
     */
    @JsonGetter("is_primary")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, objectId, image, isPrimary);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCatalogImageRequest)) {
            return false;
        }
        CreateCatalogImageRequest other = (CreateCatalogImageRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(objectId, other.objectId)
            && Objects.equals(image, other.image)
            && Objects.equals(isPrimary, other.isPrimary);
    }

    /**
     * Converts this CreateCatalogImageRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCatalogImageRequest [" + "idempotencyKey=" + idempotencyKey + ", image="
                + image + ", objectId=" + objectId + ", isPrimary=" + isPrimary + "]";
    }

    /**
     * Builds a new {@link CreateCatalogImageRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCatalogImageRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, image)
                .objectId(getObjectId())
                .isPrimary(getIsPrimary());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCatalogImageRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private CatalogObject image;
        private String objectId;
        private Boolean isPrimary;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  image  CatalogObject value for image.
         */
        public Builder(String idempotencyKey, CatalogObject image) {
            this.idempotencyKey = idempotencyKey;
            this.image = image;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for image.
         * @param  image  CatalogObject value for image.
         * @return Builder
         */
        public Builder image(CatalogObject image) {
            this.image = image;
            return this;
        }

        /**
         * Setter for objectId.
         * @param  objectId  String value for objectId.
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = objectId;
            return this;
        }

        /**
         * Setter for isPrimary.
         * @param  isPrimary  Boolean value for isPrimary.
         * @return Builder
         */
        public Builder isPrimary(Boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        /**
         * Builds a new {@link CreateCatalogImageRequest} object using the set fields.
         * @return {@link CreateCatalogImageRequest}
         */
        public CreateCatalogImageRequest build() {
            return new CreateCatalogImageRequest(idempotencyKey, image, objectId, isPrimary);
        }
    }
}
