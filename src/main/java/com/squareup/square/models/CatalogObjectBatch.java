package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogObjectBatch {

    @JsonCreator
    public CatalogObjectBatch(
            @JsonProperty("objects") List<CatalogObject> objects) {
        this.objects = objects;
    }

    private final List<CatalogObject> objects;

    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogObjectBatch)) {
            return false;
        }
        CatalogObjectBatch catalogObjectBatch = (CatalogObjectBatch) o;
        return Objects.equals(objects, catalogObjectBatch.objects);
    }

    /**
     * Getter for Objects.
     * A list of CatalogObjects belonging to this batch.
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() { 
        return this.objects;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .objects(getObjects());
            return builder;
    }

    public static class Builder {
        private List<CatalogObject> objects;

        public Builder() { }

        public Builder objects(List<CatalogObject> value) {
            objects = value;
            return this;
        }

        public CatalogObjectBatch build() {
            return new CatalogObjectBatch(objects);
        }
    }
}
