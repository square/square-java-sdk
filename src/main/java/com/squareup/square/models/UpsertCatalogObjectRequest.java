package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpsertCatalogObjectRequest {

    @JsonCreator
    public UpsertCatalogObjectRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("object") CatalogObject object) {
        this.idempotencyKey = idempotencyKey;
        this.object = object;
    }

    private final String idempotencyKey;
    private final CatalogObject object;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, object);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpsertCatalogObjectRequest)) {
            return false;
        }
        UpsertCatalogObjectRequest upsertCatalogObjectRequest = (UpsertCatalogObjectRequest) o;
        return Objects.equals(idempotencyKey, upsertCatalogObjectRequest.idempotencyKey) &&
            Objects.equals(object, upsertCatalogObjectRequest.object);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            object);
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;
        private CatalogObject object;

        public Builder(String idempotencyKey,
                CatalogObject object) {
            this.idempotencyKey = idempotencyKey;
            this.object = object;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder object(CatalogObject value) {
            object = value;
            return this;
        }

        public UpsertCatalogObjectRequest build() {
            return new UpsertCatalogObjectRequest(idempotencyKey,
                object);
        }
    }
}
