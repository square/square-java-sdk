package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RetrieveCatalogObjectRequest {

    @JsonCreator
    public RetrieveCatalogObjectRequest(
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects) {
        this.includeRelatedObjects = includeRelatedObjects;
    }

    private final Boolean includeRelatedObjects;

    @Override
    public int hashCode() {
        return Objects.hash(includeRelatedObjects);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveCatalogObjectRequest)) {
            return false;
        }
        RetrieveCatalogObjectRequest retrieveCatalogObjectRequest = (RetrieveCatalogObjectRequest) o;
        return Objects.equals(includeRelatedObjects, retrieveCatalogObjectRequest.includeRelatedObjects);
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the
     * requested object, as follows:
     * If the `object` field of the response contains a CatalogItem,
     * its associated CatalogCategory, CatalogTax objects,
     * CatalogImages and CatalogModifierLists
     * will be returned in the `related_objects` field of the response. If the `object`
     * field of the response contains a CatalogItemVariation,
     * its parent CatalogItem will be returned in the `related_objects` field of
     * the response.
     * Default value: `false`
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() { 
        return this.includeRelatedObjects;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .includeRelatedObjects(getIncludeRelatedObjects());
            return builder;
    }

    public static class Builder {
        private Boolean includeRelatedObjects;

        public Builder() { }

        public Builder includeRelatedObjects(Boolean value) {
            includeRelatedObjects = value;
            return this;
        }

        public RetrieveCatalogObjectRequest build() {
            return new RetrieveCatalogObjectRequest(includeRelatedObjects);
        }
    }
}
