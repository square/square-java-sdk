
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchDeleteCatalogObjectsRequest type.
 */
public class BatchDeleteCatalogObjectsRequest {
    private final OptionalNullable<List<String>> objectIds;

    /**
     * Initialization constructor.
     * @param  objectIds  List of String value for objectIds.
     */
    @JsonCreator
    public BatchDeleteCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds) {
        this.objectIds = OptionalNullable.of(objectIds);
    }

    /**
     * Initialization constructor.
     * @param  objectIds  List of String value for objectIds.
     */

    protected BatchDeleteCatalogObjectsRequest(OptionalNullable<List<String>> objectIds) {
        this.objectIds = objectIds;
    }

    /**
     * Internal Getter for ObjectIds.
     * The IDs of the CatalogObjects to be deleted. When an object is deleted, other objects in the
     * graph that depend on that object will be deleted as well (for example, deleting a CatalogItem
     * will delete its CatalogItemVariation.
     * @return Returns the Internal List of String
     */
    @JsonGetter("object_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetObjectIds() {
        return this.objectIds;
    }

    /**
     * Getter for ObjectIds.
     * The IDs of the CatalogObjects to be deleted. When an object is deleted, other objects in the
     * graph that depend on that object will be deleted as well (for example, deleting a CatalogItem
     * will delete its CatalogItemVariation.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getObjectIds() {
        return OptionalNullable.getFrom(objectIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchDeleteCatalogObjectsRequest)) {
            return false;
        }
        BatchDeleteCatalogObjectsRequest other = (BatchDeleteCatalogObjectsRequest) obj;
        return Objects.equals(objectIds, other.objectIds);
    }

    /**
     * Converts this BatchDeleteCatalogObjectsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchDeleteCatalogObjectsRequest [" + "objectIds=" + objectIds + "]";
    }

    /**
     * Builds a new {@link BatchDeleteCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchDeleteCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.objectIds = internalGetObjectIds();
        return builder;
    }

    /**
     * Class to build instances of {@link BatchDeleteCatalogObjectsRequest}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> objectIds;



        /**
         * Setter for objectIds.
         * @param  objectIds  List of String value for objectIds.
         * @return Builder
         */
        public Builder objectIds(List<String> objectIds) {
            this.objectIds = OptionalNullable.of(objectIds);
            return this;
        }

        /**
         * UnSetter for objectIds.
         * @return Builder
         */
        public Builder unsetObjectIds() {
            objectIds = null;
            return this;
        }

        /**
         * Builds a new {@link BatchDeleteCatalogObjectsRequest} object using the set fields.
         * @return {@link BatchDeleteCatalogObjectsRequest}
         */
        public BatchDeleteCatalogObjectsRequest build() {
            return new BatchDeleteCatalogObjectsRequest(objectIds);
        }
    }
}
