package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for RetrieveCatalogObjectRequest type.
 */
public class RetrieveCatalogObjectRequest {

    /**
     * Initialization constructor.
     * @param includeRelatedObjects
     */
    @JsonCreator
    public RetrieveCatalogObjectRequest(
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects) {
        this.includeRelatedObjects = includeRelatedObjects;
    }

    private final Boolean includeRelatedObjects;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(includeRelatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveCatalogObjectRequest)) {
            return false;
        }
        RetrieveCatalogObjectRequest retrieveCatalogObjectRequest = (RetrieveCatalogObjectRequest) obj;
        return Objects.equals(includeRelatedObjects, retrieveCatalogObjectRequest.includeRelatedObjects);
    }

    /**
     * Builds a new {@link RetrieveCatalogObjectRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCatalogObjectRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .includeRelatedObjects(getIncludeRelatedObjects());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCatalogObjectRequest}
     */
    public static class Builder {
        private Boolean includeRelatedObjects;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for includeRelatedObjects
         * @param includeRelatedObjects
         * @return Builder
         */
        public Builder includeRelatedObjects(Boolean includeRelatedObjects) {
            this.includeRelatedObjects = includeRelatedObjects;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCatalogObjectRequest} object using the set fields.
         * @return {@link RetrieveCatalogObjectRequest}
         */
        public RetrieveCatalogObjectRequest build() {
            return new RetrieveCatalogObjectRequest(includeRelatedObjects);
        }
    }
}
