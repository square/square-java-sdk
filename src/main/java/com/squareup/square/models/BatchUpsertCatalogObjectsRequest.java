package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BatchUpsertCatalogObjectsRequest type.
 */
public class BatchUpsertCatalogObjectsRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param batches
     */
    @JsonCreator
    public BatchUpsertCatalogObjectsRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("batches") List<CatalogObjectBatch> batches) {
        this.idempotencyKey = idempotencyKey;
        this.batches = batches;
    }

    private final String idempotencyKey;
    private final List<CatalogObjectBatch> batches;
    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this
     * request among all your requests. A common way to create
     * a valid idempotency key is to use a Universally unique
     * identifier (UUID).
     * If you're unsure whether a particular request was successful,
     * you can reattempt it with the same idempotency key without
     * worrying about creating duplicate objects.
     * See [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for Batches.
     * A batch of CatalogObjects to be inserted/updated atomically.
     * The objects within a batch will be inserted in an all-or-nothing fashion, i.e., if an error occurs
     * attempting to insert or update an object within a batch, the entire batch will be rejected. However, an error
     * in one batch will not affect other batches within the same request.
     * For each object, its `updated_at` field is ignored and replaced with a current [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates), and its
     * `is_deleted` field must not be set to `true`.
     * To modify an existing object, supply its ID. To create a new object, use an ID starting
     * with `#`. These IDs may be used to create relationships between an object and attributes of
     * other objects that reference it. For example, you can create a CatalogItem with
     * ID `#ABC` and a CatalogItemVariation with its `item_id` attribute set to
     * `#ABC` in order to associate the CatalogItemVariation with its parent
     * CatalogItem.
     * Any `#`-prefixed IDs are valid only within a single atomic batch, and will be replaced by server-generated IDs.
     * Each batch may contain up to 1,000 objects. The total number of objects across all batches for a single request
     * may not exceed 10,000. If either of these limits is violated, an error will be returned and no objects will
     * be inserted or updated.
     */
    @JsonGetter("batches")
    public List<CatalogObjectBatch> getBatches() {
        return this.batches;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, batches);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchUpsertCatalogObjectsRequest)) {
            return false;
        }
        BatchUpsertCatalogObjectsRequest batchUpsertCatalogObjectsRequest = (BatchUpsertCatalogObjectsRequest) obj;
        return Objects.equals(idempotencyKey, batchUpsertCatalogObjectsRequest.idempotencyKey) &&
            Objects.equals(batches, batchUpsertCatalogObjectsRequest.batches);
    }

    /**
     * Builds a new {@link BatchUpsertCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchUpsertCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            batches);
            return builder;
    }

    /**
     * Class to build instances of {@link BatchUpsertCatalogObjectsRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private List<CatalogObjectBatch> batches;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey,
                List<CatalogObjectBatch> batches) {
            this.idempotencyKey = idempotencyKey;
            this.batches = batches;
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for batches
         * @param batches
         * @return Builder
         */
        public Builder batches(List<CatalogObjectBatch> batches) {
            this.batches = batches;
            return this;
        }

        /**
         * Builds a new {@link BatchUpsertCatalogObjectsRequest} object using the set fields.
         * @return {@link BatchUpsertCatalogObjectsRequest}
         */
        public BatchUpsertCatalogObjectsRequest build() {
            return new BatchUpsertCatalogObjectsRequest(idempotencyKey,
                batches);
        }
    }
}
