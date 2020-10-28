
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for RetrieveCatalogObjectRequest type.
 */
public class RetrieveCatalogObjectRequest {
    private final Boolean includeRelatedObjects;

    /**
     * Initialization constructor.
     * @param includeRelatedObjects Boolean value for includeRelatedObjects.
     */
    @JsonCreator
    public RetrieveCatalogObjectRequest(
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects) {
        this.includeRelatedObjects = includeRelatedObjects;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the requested
     * object, as follows: If the `object` field of the response contains a `CatalogItem`, its
     * associated `CatalogCategory`, `CatalogTax`, `CatalogImage` and `CatalogModifierList` objects
     * will be returned in the `related_objects` field of the response. If the `object` field of the
     * response contains a `CatalogItemVariation`, its parent `CatalogItem` will be returned in the
     * `related_objects` field of the response. Default value: `false`
     * @return Returns the Boolean
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCatalogObjectRequest)) {
            return false;
        }
        RetrieveCatalogObjectRequest other = (RetrieveCatalogObjectRequest) obj;
        return Objects.equals(includeRelatedObjects, other.includeRelatedObjects);
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
     * Class to build instances of {@link RetrieveCatalogObjectRequest}.
     */
    public static class Builder {
        private Boolean includeRelatedObjects;



        /**
         * Setter for includeRelatedObjects.
         * @param includeRelatedObjects Boolean value for includeRelatedObjects.
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
