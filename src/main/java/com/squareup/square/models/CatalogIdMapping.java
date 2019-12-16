package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogIdMapping {

    @JsonCreator
    public CatalogIdMapping(
            @JsonProperty("client_object_id") String clientObjectId,
            @JsonProperty("object_id") String objectId) {
        this.clientObjectId = clientObjectId;
        this.objectId = objectId;
    }

    private final String clientObjectId;
    private final String objectId;

    @Override
    public int hashCode() {
        return Objects.hash(clientObjectId, objectId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogIdMapping)) {
            return false;
        }
        CatalogIdMapping catalogIdMapping = (CatalogIdMapping) o;
        return Objects.equals(clientObjectId, catalogIdMapping.clientObjectId) &&
            Objects.equals(objectId, catalogIdMapping.objectId);
    }

    /**
     * Getter for ClientObjectId.
     * The client-supplied, temporary `#`-prefixed ID for a new `CatalogObject`.
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .clientObjectId(getClientObjectId())
            .objectId(getObjectId());
            return builder;
    }

    public static class Builder {
        private String clientObjectId;
        private String objectId;

        public Builder() { }

        public Builder clientObjectId(String value) {
            clientObjectId = value;
            return this;
        }
        public Builder objectId(String value) {
            objectId = value;
            return this;
        }

        public CatalogIdMapping build() {
            return new CatalogIdMapping(clientObjectId,
                objectId);
        }
    }
}
