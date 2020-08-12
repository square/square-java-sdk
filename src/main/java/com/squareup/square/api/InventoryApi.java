package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
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

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface InventoryApi {
    /**
     * Returns the [InventoryAdjustment](#type-inventoryadjustment) object
     * with the provided `adjustment_id`.
     * @param    adjustmentId    Required parameter: ID of the [InventoryAdjustment](#type-inventoryadjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     */
    RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustment(
            final String adjustmentId) throws ApiException, IOException;

    /**
     * Returns the [InventoryAdjustment](#type-inventoryadjustment) object
     * with the provided `adjustment_id`.
     * @param    adjustmentId    Required parameter: ID of the [InventoryAdjustment](#type-inventoryadjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call 
     */
    CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
            final String adjustmentId);

    /**
     * Applies adjustments and counts to the provided item quantities.
     * On success: returns the current calculated counts for all objects
     * referenced in the request.
     * On failure: returns a list of related errors.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     */
    BatchChangeInventoryResponse batchChangeInventory(
            final BatchChangeInventoryRequest body) throws ApiException, IOException;

    /**
     * Applies adjustments and counts to the provided item quantities.
     * On success: returns the current calculated counts for all objects
     * referenced in the request.
     * On failure: returns a list of related errors.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call 
     */
    CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
            final BatchChangeInventoryRequest body);

    /**
     * Returns historical physical counts and adjustments based on the
     * provided filter criteria.
     * Results are paginated and sorted in ascending order according their
     * `occurred_at` timestamp (oldest first).
     * BatchRetrieveInventoryChanges is a catch-all query endpoint for queries
     * that cannot be handled by other, simpler endpoints.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     */
    BatchRetrieveInventoryChangesResponse batchRetrieveInventoryChanges(
            final BatchRetrieveInventoryChangesRequest body) throws ApiException, IOException;

    /**
     * Returns historical physical counts and adjustments based on the
     * provided filter criteria.
     * Results are paginated and sorted in ascending order according their
     * `occurred_at` timestamp (oldest first).
     * BatchRetrieveInventoryChanges is a catch-all query endpoint for queries
     * that cannot be handled by other, simpler endpoints.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call 
     */
    CompletableFuture<BatchRetrieveInventoryChangesResponse> batchRetrieveInventoryChangesAsync(
            final BatchRetrieveInventoryChangesRequest body);

    /**
     * Returns current counts for the provided
     * [CatalogObject](#type-catalogobject)s at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `calculated_at` timestamp (newest first).
     * When `updated_after` is specified, only counts that have changed since that
     * time (based on the server timestamp for the most recent change) are
     * returned. This allows clients to perform a "sync" operation, for example
     * in response to receiving a Webhook notification.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     */
    BatchRetrieveInventoryCountsResponse batchRetrieveInventoryCounts(
            final BatchRetrieveInventoryCountsRequest body) throws ApiException, IOException;

    /**
     * Returns current counts for the provided
     * [CatalogObject](#type-catalogobject)s at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `calculated_at` timestamp (newest first).
     * When `updated_after` is specified, only counts that have changed since that
     * time (based on the server timestamp for the most recent change) are
     * returned. This allows clients to perform a "sync" operation, for example
     * in response to receiving a Webhook notification.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call 
     */
    CompletableFuture<BatchRetrieveInventoryCountsResponse> batchRetrieveInventoryCountsAsync(
            final BatchRetrieveInventoryCountsRequest body);

    /**
     * Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount)
     * object with the provided `physical_count_id`.
     * @param    physicalCountId    Required parameter: ID of the [InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     */
    RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCount(
            final String physicalCountId) throws ApiException, IOException;

    /**
     * Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount)
     * object with the provided `physical_count_id`.
     * @param    physicalCountId    Required parameter: ID of the [InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call 
     */
    CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
            final String physicalCountId);

    /**
     * Retrieves the current calculated stock count for a given
     * [CatalogObject](#type-catalogobject) at a given set of
     * [Location](#type-location)s. Responses are paginated and unsorted.
     * For more sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     */
    RetrieveInventoryCountResponse retrieveInventoryCount(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException;

    /**
     * Retrieves the current calculated stock count for a given
     * [CatalogObject](#type-catalogobject) at a given set of
     * [Location](#type-location)s. Responses are paginated and unsorted.
     * For more sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call 
     */
    CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor);

    /**
     * Returns a set of physical counts and inventory adjustments for the
     * provided [CatalogObject](#type-catalogobject) at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `occurred_at` timestamp (newest first).
     * There are no limits on how far back the caller can page. This endpoint is
     * useful when displaying recent changes for a specific item. For more
     * sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     */
    RetrieveInventoryChangesResponse retrieveInventoryChanges(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a set of physical counts and inventory adjustments for the
     * provided [CatalogObject](#type-catalogobject) at the requested
     * [Location](#type-location)s.
     * Results are paginated and sorted in descending order according to their
     * `occurred_at` timestamp (newest first).
     * There are no limits on how far back the caller can page. This endpoint is
     * useful when displaying recent changes for a specific item. For more
     * sophisticated queries, use a batch endpoint.
     * @param    catalogObjectId    Required parameter: ID of the [CatalogObject](#type-catalogobject) to retrieve.
     * @param    locationIds    Optional parameter: The [Location](#type-location) IDs to look up as a comma-separated list. An empty list queries all locations.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query.  See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call 
     */
    CompletableFuture<RetrieveInventoryChangesResponse> retrieveInventoryChangesAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor);

}
