
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogIdMapping type.
 */
public class CatalogIdMapping {
    private final OptionalNullable<String> clientObjectId;
    private final OptionalNullable<String> objectId;

    /**
     * Initialization constructor.
     * @param  clientObjectId  String value for clientObjectId.
     * @param  objectId  String value for objectId.
     */
    @JsonCreator
    public CatalogIdMapping(
            @JsonProperty("client_object_id") String clientObjectId,
            @JsonProperty("object_id") String objectId) {
        this.clientObjectId = OptionalNullable.of(clientObjectId);
        this.objectId = OptionalNullable.of(objectId);
    }

    /**
     * Initialization constructor.
     * @param  clientObjectId  String value for clientObjectId.
     * @param  objectId  String value for objectId.
     */

    protected CatalogIdMapping(OptionalNullable<String> clientObjectId,
            OptionalNullable<String> objectId) {
        this.clientObjectId = clientObjectId;
        this.objectId = objectId;
    }

    /**
     * Internal Getter for ClientObjectId.
     * The client-supplied temporary `#`-prefixed ID for a new `CatalogObject`.
     * @return Returns the Internal String
     */
    @JsonGetter("client_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetClientObjectId() {
        return this.clientObjectId;
    }

    /**
     * Getter for ClientObjectId.
     * The client-supplied temporary `#`-prefixed ID for a new `CatalogObject`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getClientObjectId() {
        return OptionalNullable.getFrom(clientObjectId);
    }

    /**
     * Internal Getter for ObjectId.
     * The permanent ID for the CatalogObject created by the server.
     * @return Returns the Internal String
     */
    @JsonGetter("object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetObjectId() {
        return this.objectId;
    }

    /**
     * Getter for ObjectId.
     * The permanent ID for the CatalogObject created by the server.
     * @return Returns the String
     */
    @JsonIgnore
    public String getObjectId() {
        return OptionalNullable.getFrom(objectId);
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
        Builder builder = new Builder();
        builder.clientObjectId = internalGetClientObjectId();
        builder.objectId = internalGetObjectId();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogIdMapping}.
     */
    public static class Builder {
        private OptionalNullable<String> clientObjectId;
        private OptionalNullable<String> objectId;



        /**
         * Setter for clientObjectId.
         * @param  clientObjectId  String value for clientObjectId.
         * @return Builder
         */
        public Builder clientObjectId(String clientObjectId) {
            this.clientObjectId = OptionalNullable.of(clientObjectId);
            return this;
        }

        /**
         * UnSetter for clientObjectId.
         * @return Builder
         */
        public Builder unsetClientObjectId() {
            clientObjectId = null;
            return this;
        }

        /**
         * Setter for objectId.
         * @param  objectId  String value for objectId.
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = OptionalNullable.of(objectId);
            return this;
        }

        /**
         * UnSetter for objectId.
         * @return Builder
         */
        public Builder unsetObjectId() {
            objectId = null;
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
