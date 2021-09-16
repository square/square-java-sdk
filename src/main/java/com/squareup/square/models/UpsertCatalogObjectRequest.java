
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpsertCatalogObjectRequest type.
 */
public class UpsertCatalogObjectRequest {
    private final String idempotencyKey;
    private final CatalogObject object;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  object  CatalogObject value for object.
     */
    @JsonCreator
    public UpsertCatalogObjectRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("object") CatalogObject object) {
        this.idempotencyKey = idempotencyKey;
        this.object = object;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this request among all your requests. A common
     * way to create a valid idempotency key is to use a Universally unique identifier (UUID). If
     * you're unsure whether a particular request was successful, you can reattempt it with the same
     * idempotency key without worrying about creating duplicate objects. See
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Object.
     * The wrapper object for the catalog entries of a given object type. Depending on the `type`
     * attribute value, a `CatalogObject` instance assumes a type-specific data to yield the
     * corresponding type of catalog object. For example, if `type=ITEM`, the `CatalogObject`
     * instance must have the ITEM-specific data set on the `item_data` attribute. The resulting
     * `CatalogObject` instance is also a `CatalogItem` instance. In general, if
     * `type=<OBJECT_TYPE>`, the `CatalogObject` instance must have the `<OBJECT_TYPE>`-specific
     * data set on the `<object_type>_data` attribute. The resulting `CatalogObject` instance is
     * also a `Catalog<ObjectType>` instance. For a more detailed discussion of the Catalog data
     * model, please see the [Design a
     * Catalog](https://developer.squareup.com/docs/catalog-api/design-a-catalog) guide.
     * @return Returns the CatalogObject
     */
    @JsonGetter("object")
    public CatalogObject getObject() {
        return object;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, object);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpsertCatalogObjectRequest)) {
            return false;
        }
        UpsertCatalogObjectRequest other = (UpsertCatalogObjectRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(object, other.object);
    }

    /**
     * Converts this UpsertCatalogObjectRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpsertCatalogObjectRequest [" + "idempotencyKey=" + idempotencyKey + ", object="
                + object + "]";
    }

    /**
     * Builds a new {@link UpsertCatalogObjectRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertCatalogObjectRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, object);
        return builder;
    }

    /**
     * Class to build instances of {@link UpsertCatalogObjectRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private CatalogObject object;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  object  CatalogObject value for object.
         */
        public Builder(String idempotencyKey, CatalogObject object) {
            this.idempotencyKey = idempotencyKey;
            this.object = object;
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
         * Setter for object.
         * @param  object  CatalogObject value for object.
         * @return Builder
         */
        public Builder object(CatalogObject object) {
            this.object = object;
            return this;
        }

        /**
         * Builds a new {@link UpsertCatalogObjectRequest} object using the set fields.
         * @return {@link UpsertCatalogObjectRequest}
         */
        public UpsertCatalogObjectRequest build() {
            return new UpsertCatalogObjectRequest(idempotencyKey, object);
        }
    }
}
