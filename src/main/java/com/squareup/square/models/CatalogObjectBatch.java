package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogObjectBatch type.
 */
public class CatalogObjectBatch {

    /**
     * Initialization constructor.
     * @param objects
     */
    @JsonCreator
    public CatalogObjectBatch(
            @JsonProperty("objects") List<CatalogObject> objects) {
        this.objects = objects;
    }

    private final List<CatalogObject> objects;
    /**
     * Getter for Objects.
     * A list of CatalogObjects belonging to this batch.
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() {
        return this.objects;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogObjectBatch)) {
            return false;
        }
        CatalogObjectBatch catalogObjectBatch = (CatalogObjectBatch) obj;
        return Objects.equals(objects, catalogObjectBatch.objects);
    }

    /**
     * Builds a new {@link CatalogObjectBatch.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogObjectBatch.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(objects);
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogObjectBatch}
     */
    public static class Builder {
        private List<CatalogObject> objects;

        /**
         * Initialization constructor
         */
        public Builder(List<CatalogObject> objects) {
            this.objects = objects;
        }

        /**
         * Setter for objects
         * @param objects
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
            return this;
        }

        /**
         * Builds a new {@link CatalogObjectBatch} object using the set fields.
         * @return {@link CatalogObjectBatch}
         */
        public CatalogObjectBatch build() {
            return new CatalogObjectBatch(objects);
        }
    }
}
