
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateCatalogImageRequest type.
 */
public class UpdateCatalogImageRequest {
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public UpdateCatalogImageRequest(
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this UpdateCatalogImage request. Keys can be any valid string
     * but must be unique for every UpdateCatalogImage request. See [Idempotency
     * keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateCatalogImageRequest)) {
            return false;
        }
        UpdateCatalogImageRequest other = (UpdateCatalogImageRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpdateCatalogImageRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateCatalogImageRequest [" + "idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link UpdateCatalogImageRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateCatalogImageRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateCatalogImageRequest}.
     */
    public static class Builder {
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link UpdateCatalogImageRequest} object using the set fields.
         * @return {@link UpdateCatalogImageRequest}
         */
        public UpdateCatalogImageRequest build() {
            return new UpdateCatalogImageRequest(idempotencyKey);
        }
    }
}
