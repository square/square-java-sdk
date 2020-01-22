package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpsertCatalogObjectRequest type.
 */
public class UpsertCatalogObjectRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param object
     */
    @JsonCreator
    public UpsertCatalogObjectRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("object") CatalogObject object) {
        this.idempotencyKey = idempotencyKey;
        this.object = object;
    }

    private final String idempotencyKey;
    private final CatalogObject object;
    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this
     * request among all your requests. A common way to create
     * a valid idempotency key is to use a Universally unique
     * identifier (UUID).
     * If you're unsure whether a particular request was successful,
     * you can reattempt it with the same idempotency key without
     * worrying about creating duplicate objects.
     * See [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for Object.
     */
    @JsonGetter("object")
    public CatalogObject getObject() {
        return this.object;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, object);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpsertCatalogObjectRequest)) {
            return false;
        }
        UpsertCatalogObjectRequest upsertCatalogObjectRequest = (UpsertCatalogObjectRequest) obj;
        return Objects.equals(idempotencyKey, upsertCatalogObjectRequest.idempotencyKey) &&
            Objects.equals(object, upsertCatalogObjectRequest.object);
    }

    /**
     * Builds a new {@link UpsertCatalogObjectRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertCatalogObjectRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            object);
            return builder;
    }

    /**
     * Class to build instances of {@link UpsertCatalogObjectRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private CatalogObject object;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey,
                CatalogObject object) {
            this.idempotencyKey = idempotencyKey;
            this.object = object;
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
         * Setter for object
         * @param object
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
            return new UpsertCatalogObjectRequest(idempotencyKey,
                object);
        }
    }
}
