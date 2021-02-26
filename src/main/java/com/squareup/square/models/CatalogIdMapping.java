
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogIdMapping type.
 */
public class CatalogIdMapping {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String clientObjectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String objectId;

    /**
     * Initialization constructor.
     * @param  clientObjectId  String value for clientObjectId.
     * @param  objectId  String value for objectId.
     */
    @JsonCreator
    public CatalogIdMapping(
            @JsonProperty("client_object_id") String clientObjectId,
            @JsonProperty("object_id") String objectId) {
        this.clientObjectId = clientObjectId;
        this.objectId = objectId;
    }

    /**
     * Getter for ClientObjectId.
     * The client-supplied temporary `#`-prefixed ID for a new `CatalogObject`.
     * @return Returns the String
     */
    @JsonGetter("client_object_id")
    public String getClientObjectId() {
        return clientObjectId;
    }

    /**
     * Getter for ObjectId.
     * The permanent ID for the CatalogObject created by the server.
     * @return Returns the String
     */
    @JsonGetter("object_id")
    public String getObjectId() {
        return objectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientObjectId, objectId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogIdMapping)) {
            return false;
        }
        CatalogIdMapping other = (CatalogIdMapping) obj;
        return Objects.equals(clientObjectId, other.clientObjectId)
            && Objects.equals(objectId, other.objectId);
    }

    /**
     * Converts this CatalogIdMapping into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogIdMapping [" + "clientObjectId=" + clientObjectId + ", objectId=" + objectId
                + "]";
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
     * Class to build instances of {@link CatalogIdMapping}.
     */
    public static class Builder {
        private String clientObjectId;
        private String objectId;



        /**
         * Setter for clientObjectId.
         * @param  clientObjectId  String value for clientObjectId.
         * @return Builder
         */
        public Builder clientObjectId(String clientObjectId) {
            this.clientObjectId = clientObjectId;
            return this;
        }

        /**
         * Setter for objectId.
         * @param  objectId  String value for objectId.
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
            return new CatalogIdMapping(clientObjectId, objectId);
        }
    }
}
