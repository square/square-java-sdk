package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogIdMapping type.
 */
public class CatalogIdMapping {

    /**
     * Initialization constructor.
     * @param clientObjectId
     * @param objectId
     */
    @JsonCreator
    public CatalogIdMapping(
            @JsonProperty("client_object_id") String clientObjectId,
            @JsonProperty("object_id") String objectId) {
        this.clientObjectId = clientObjectId;
        this.objectId = objectId;
    }

    private final String clientObjectId;
    private final String objectId;
    /**
     * Getter for ClientObjectId.
     * The client-supplied temporary `#`-prefixed ID for a new `CatalogObject`.
     */
    @JsonGetter("client_object_id")
    public String getClientObjectId() {
        return this.clientObjectId;
    }

    /**
     * Getter for ObjectId.
     * The permanent ID for the CatalogObject created by the server.
     */
    @JsonGetter("object_id")
    public String getObjectId() {
        return this.objectId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(clientObjectId, objectId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogIdMapping)) {
            return false;
        }
        CatalogIdMapping catalogIdMapping = (CatalogIdMapping) obj;
        return Objects.equals(clientObjectId, catalogIdMapping.clientObjectId) &&
            Objects.equals(objectId, catalogIdMapping.objectId);
    }

    /**
     * Builds a new {@link CatalogIdMapping.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogIdMapping.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .clientObjectId(getClientObjectId())
            .objectId(getObjectId());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogIdMapping}
     */
    public static class Builder {
        private String clientObjectId;
        private String objectId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for clientObjectId
         * @param clientObjectId
         * @return Builder
         */
        public Builder clientObjectId(String clientObjectId) {
            this.clientObjectId = clientObjectId;
            return this;
        }
        /**
         * Setter for objectId
         * @param objectId
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = objectId;
            return this;
        }

        /**
         * Builds a new {@link CatalogIdMapping} object using the set fields.
         * @return {@link CatalogIdMapping}
         */
        public CatalogIdMapping build() {
            return new CatalogIdMapping(clientObjectId,
                objectId);
        }
    }
}
