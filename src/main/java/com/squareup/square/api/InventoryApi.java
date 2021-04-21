
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.BatchChangeInventoryRequest;
import com.squareup.square.models.BatchChangeInventoryResponse;
import com.squareup.square.models.BatchRetrieveInventoryChangesRequest;
import com.squareup.square.models.BatchRetrieveInventoryChangesResponse;
import com.squareup.square.models.BatchRetrieveInventoryCountsRequest;
import com.squareup.square.models.BatchRetrieveInventoryCountsResponse;
import com.squareup.square.models.RetrieveInventoryAdjustmentResponse;
import com.squareup.square.models.RetrieveInventoryChangesResponse;
import com.squareup.square.models.RetrieveInventoryCountResponse;
import com.squareup.square.models.RetrieveInventoryPhysicalCountResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface InventoryApi {
    /**
     * Returns the [InventoryAdjustment]($m/InventoryAdjustment) object with the provided
     * `adjustment_id`.
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment]($m/InventoryAdjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustment(
            final String adjustmentId) throws ApiException, IOException;

    /**
     * Returns the [InventoryAdjustment]($m/InventoryAdjustment) object with the provided
     * `adjustment_id`.
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment]($m/InventoryAdjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     */
    CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
            final String adjustmentId);

    /**
     * Applies adjustments and counts to the provided item quantities. On success: returns the
     * current calculated counts for all objects referenced in the request. On failure: returns a
     * list of related errors.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BatchChangeInventoryResponse batchChangeInventory(
            final BatchChangeInventoryRequest body) throws ApiException, IOException;

    /**
     * Applies adjustments and counts to the provided item quantities. On success: returns the
     * current calculated counts for all objects referenced in the request. On failure: returns a
     * list of related errors.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     */
    CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
            final BatchChangeInventoryRequest body);

    /**
     * Returns historical physical counts and adjustments based on the provided filter criteria.
     * Results are paginated and sorted in ascending order according their `occurred_at` timestamp
     * (oldest first). BatchRetrieveInventoryChanges is a catch-all query endpoint for queries that
     * cannot be handled by other, simpler endpoints.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BatchRetrieveInventoryChangesResponse batchRetrieveInventoryChanges(
            final BatchRetrieveInventoryChangesRequest body) throws ApiException, IOException;

    /**
     * Returns historical physical counts and adjustments based on the provided filter criteria.
     * Results are paginated and sorted in ascending order according their `occurred_at` timestamp
     * (oldest first). BatchRetrieveInventoryChanges is a catch-all query endpoint for queries that
     * cannot be handled by other, simpler endpoints.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     */
    CompletableFuture<BatchRetrieveInventoryChangesResponse> batchRetrieveInventoryChangesAsync(
            final BatchRetrieveInventoryChangesRequest body);

    /**
     * Returns current counts for the provided [CatalogObject]($m/CatalogObject)s at the requested
     * [Location]($m/Location)s. Results are paginated and sorted in descending order according to
     * their `calculated_at` timestamp (newest first). When `updated_after` is specified, only
     * counts that have changed since that time (based on the server timestamp for the most recent
     * change) are returned. This allows clients to perform a "sync" operation, for example in
     * response to receiving a Webhook notification.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BatchRetrieveInventoryCountsResponse batchRetrieveInventoryCounts(
            final BatchRetrieveInventoryCountsRequest body) throws ApiException, IOException;

    /**
     * Returns current counts for the provided [CatalogObject]($m/CatalogObject)s at the requested
     * [Location]($m/Location)s. Results are paginated and sorted in descending order according to
     * their `calculated_at` timestamp (newest first). When `updated_after` is specified, only
     * counts that have changed since that time (based on the server timestamp for the most recent
     * change) are returned. This allows clients to perform a "sync" operation, for example in
     * response to receiving a Webhook notification.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     */
    CompletableFuture<BatchRetrieveInventoryCountsResponse> batchRetrieveInventoryCountsAsync(
            final BatchRetrieveInventoryCountsRequest body);

    /**
     * Returns the [InventoryPhysicalCount]($m/InventoryPhysicalCount) object with the provided
     * `physical_count_id`.
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount]($m/InventoryPhysicalCount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCount(
            final String physicalCountId) throws ApiException, IOException;

    /**
     * Returns the [InventoryPhysicalCount]($m/InventoryPhysicalCount) object with the provided
     * `physical_count_id`.
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount]($m/InventoryPhysicalCount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     */
    CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
            final String physicalCountId);

    /**
     * Retrieves the current calculated stock count for a given [CatalogObject]($m/CatalogObject) at
     * a given set of [Location]($m/Location)s. Responses are paginated and unsorted. For more
     * sophisticated queries, use a batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject]($m/CatalogObject) to
     *         retrieve.
     * @param  locationIds  Optional parameter: The [Location]($m/Location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveInventoryCountResponse retrieveInventoryCount(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException;

    /**
     * Retrieves the current calculated stock count for a given [CatalogObject]($m/CatalogObject) at
     * a given set of [Location]($m/Location)s. Responses are paginated and unsorted. For more
     * sophisticated queries, use a batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject]($m/CatalogObject) to
     *         retrieve.
     * @param  locationIds  Optional parameter: The [Location]($m/Location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     */
    CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor);

    /**
     * Returns a set of physical counts and inventory adjustments for the provided
     * [CatalogObject]($m/CatalogObject) at the requested [Location]($m/Location)s. Results are
     * paginated and sorted in descending order according to their `occurred_at` timestamp (newest
     * first). There are no limits on how far back the caller can page. This endpoint can be used to
     * display recent changes for a specific item. For more sophisticated queries, use a batch
     * endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject]($m/CatalogObject) to
     *         retrieve.
     * @param  locationIds  Optional parameter: The [Location]($m/Location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveInventoryChangesResponse retrieveInventoryChanges(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a set of physical counts and inventory adjustments for the provided
     * [CatalogObject]($m/CatalogObject) at the requested [Location]($m/Location)s. Results are
     * paginated and sorted in descending order according to their `occurred_at` timestamp (newest
     * first). There are no limits on how far back the caller can page. This endpoint can be used to
     * display recent changes for a specific item. For more sophisticated queries, use a batch
     * endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject]($m/CatalogObject) to
     *         retrieve.
     * @param  locationIds  Optional parameter: The [Location]($m/Location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     */
    CompletableFuture<RetrieveInventoryChangesResponse> retrieveInventoryChangesAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor);

}