
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import com.squareup.square.models.RetrieveInventoryTransferResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultInventoryApi extends BaseApi implements InventoryApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultInventoryApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Deprecated version of
     * [RetrieveInventoryAdjustment](api-endpoint:Inventory-RetrieveInventoryAdjustment) after the
     * endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment](entity:InventoryAdjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RetrieveInventoryAdjustmentResponse deprecatedRetrieveInventoryAdjustment(
            final String adjustmentId) throws ApiException, IOException {
        return prepareDeprecatedRetrieveInventoryAdjustmentRequest(adjustmentId).execute();
    }

    /**
     * Deprecated version of
     * [RetrieveInventoryAdjustment](api-endpoint:Inventory-RetrieveInventoryAdjustment) after the
     * endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment](entity:InventoryAdjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveInventoryAdjustmentResponse> deprecatedRetrieveInventoryAdjustmentAsync(
            final String adjustmentId) {
        try { 
            return prepareDeprecatedRetrieveInventoryAdjustmentRequest(adjustmentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deprecatedRetrieveInventoryAdjustment.
     */
    private ApiCall<RetrieveInventoryAdjustmentResponse, ApiException> prepareDeprecatedRetrieveInventoryAdjustmentRequest(
            final String adjustmentId) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryAdjustmentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/adjustment/{adjustment_id}")
                        .templateParam(param -> param.key("adjustment_id").value(adjustmentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryAdjustmentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns the [InventoryAdjustment]($m/InventoryAdjustment) object with the provided
     * `adjustment_id`.
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment](entity:InventoryAdjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryAdjustmentResponse retrieveInventoryAdjustment(
            final String adjustmentId) throws ApiException, IOException {
        return prepareRetrieveInventoryAdjustmentRequest(adjustmentId).execute();
    }

    /**
     * Returns the [InventoryAdjustment]($m/InventoryAdjustment) object with the provided
     * `adjustment_id`.
     * @param  adjustmentId  Required parameter: ID of the
     *         [InventoryAdjustment](entity:InventoryAdjustment) to retrieve.
     * @return    Returns the RetrieveInventoryAdjustmentResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
            final String adjustmentId) {
        try { 
            return prepareRetrieveInventoryAdjustmentRequest(adjustmentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveInventoryAdjustment.
     */
    private ApiCall<RetrieveInventoryAdjustmentResponse, ApiException> prepareRetrieveInventoryAdjustmentRequest(
            final String adjustmentId) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryAdjustmentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/adjustments/{adjustment_id}")
                        .templateParam(param -> param.key("adjustment_id").value(adjustmentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryAdjustmentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deprecated version of [BatchChangeInventory](api-endpoint:Inventory-BatchChangeInventory)
     * after the endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public BatchChangeInventoryResponse deprecatedBatchChangeInventory(
            final BatchChangeInventoryRequest body) throws ApiException, IOException {
        return prepareDeprecatedBatchChangeInventoryRequest(body).execute();
    }

    /**
     * Deprecated version of [BatchChangeInventory](api-endpoint:Inventory-BatchChangeInventory)
     * after the endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<BatchChangeInventoryResponse> deprecatedBatchChangeInventoryAsync(
            final BatchChangeInventoryRequest body) {
        try { 
            return prepareDeprecatedBatchChangeInventoryRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deprecatedBatchChangeInventory.
     */
    private ApiCall<BatchChangeInventoryResponse, ApiException> prepareDeprecatedBatchChangeInventoryRequest(
            final BatchChangeInventoryRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchChangeInventoryResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/batch-change")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchChangeInventoryResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deprecated version of
     * [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges) after
     * the endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public BatchRetrieveInventoryChangesResponse deprecatedBatchRetrieveInventoryChanges(
            final BatchRetrieveInventoryChangesRequest body) throws ApiException, IOException {
        return prepareDeprecatedBatchRetrieveInventoryChangesRequest(body).execute();
    }

    /**
     * Deprecated version of
     * [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges) after
     * the endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<BatchRetrieveInventoryChangesResponse> deprecatedBatchRetrieveInventoryChangesAsync(
            final BatchRetrieveInventoryChangesRequest body) {
        try { 
            return prepareDeprecatedBatchRetrieveInventoryChangesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deprecatedBatchRetrieveInventoryChanges.
     */
    private ApiCall<BatchRetrieveInventoryChangesResponse, ApiException> prepareDeprecatedBatchRetrieveInventoryChangesRequest(
            final BatchRetrieveInventoryChangesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchRetrieveInventoryChangesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/batch-retrieve-changes")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchRetrieveInventoryChangesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deprecated version of
     * [BatchRetrieveInventoryCounts](api-endpoint:Inventory-BatchRetrieveInventoryCounts) after the
     * endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public BatchRetrieveInventoryCountsResponse deprecatedBatchRetrieveInventoryCounts(
            final BatchRetrieveInventoryCountsRequest body) throws ApiException, IOException {
        return prepareDeprecatedBatchRetrieveInventoryCountsRequest(body).execute();
    }

    /**
     * Deprecated version of
     * [BatchRetrieveInventoryCounts](api-endpoint:Inventory-BatchRetrieveInventoryCounts) after the
     * endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryCountsResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<BatchRetrieveInventoryCountsResponse> deprecatedBatchRetrieveInventoryCountsAsync(
            final BatchRetrieveInventoryCountsRequest body) {
        try { 
            return prepareDeprecatedBatchRetrieveInventoryCountsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deprecatedBatchRetrieveInventoryCounts.
     */
    private ApiCall<BatchRetrieveInventoryCountsResponse, ApiException> prepareDeprecatedBatchRetrieveInventoryCountsRequest(
            final BatchRetrieveInventoryCountsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchRetrieveInventoryCountsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/batch-retrieve-counts")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchRetrieveInventoryCountsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public BatchChangeInventoryResponse batchChangeInventory(
            final BatchChangeInventoryRequest body) throws ApiException, IOException {
        return prepareBatchChangeInventoryRequest(body).execute();
    }

    /**
     * Applies adjustments and counts to the provided item quantities. On success: returns the
     * current calculated counts for all objects referenced in the request. On failure: returns a
     * list of related errors.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchChangeInventoryResponse response from the API call
     */
    public CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
            final BatchChangeInventoryRequest body) {
        try { 
            return prepareBatchChangeInventoryRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchChangeInventory.
     */
    private ApiCall<BatchChangeInventoryResponse, ApiException> prepareBatchChangeInventoryRequest(
            final BatchChangeInventoryRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchChangeInventoryResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/changes/batch-create")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchChangeInventoryResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public BatchRetrieveInventoryChangesResponse batchRetrieveInventoryChanges(
            final BatchRetrieveInventoryChangesRequest body) throws ApiException, IOException {
        return prepareBatchRetrieveInventoryChangesRequest(body).execute();
    }

    /**
     * Returns historical physical counts and adjustments based on the provided filter criteria.
     * Results are paginated and sorted in ascending order according their `occurred_at` timestamp
     * (oldest first). BatchRetrieveInventoryChanges is a catch-all query endpoint for queries that
     * cannot be handled by other, simpler endpoints.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveInventoryChangesResponse response from the API call
     */
    public CompletableFuture<BatchRetrieveInventoryChangesResponse> batchRetrieveInventoryChangesAsync(
            final BatchRetrieveInventoryChangesRequest body) {
        try { 
            return prepareBatchRetrieveInventoryChangesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchRetrieveInventoryChanges.
     */
    private ApiCall<BatchRetrieveInventoryChangesResponse, ApiException> prepareBatchRetrieveInventoryChangesRequest(
            final BatchRetrieveInventoryChangesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchRetrieveInventoryChangesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/changes/batch-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchRetrieveInventoryChangesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public BatchRetrieveInventoryCountsResponse batchRetrieveInventoryCounts(
            final BatchRetrieveInventoryCountsRequest body) throws ApiException, IOException {
        return prepareBatchRetrieveInventoryCountsRequest(body).execute();
    }

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
    public CompletableFuture<BatchRetrieveInventoryCountsResponse> batchRetrieveInventoryCountsAsync(
            final BatchRetrieveInventoryCountsRequest body) {
        try { 
            return prepareBatchRetrieveInventoryCountsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchRetrieveInventoryCounts.
     */
    private ApiCall<BatchRetrieveInventoryCountsResponse, ApiException> prepareBatchRetrieveInventoryCountsRequest(
            final BatchRetrieveInventoryCountsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchRetrieveInventoryCountsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/counts/batch-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchRetrieveInventoryCountsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deprecated version of
     * [RetrieveInventoryPhysicalCount](api-endpoint:Inventory-RetrieveInventoryPhysicalCount) after
     * the endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RetrieveInventoryPhysicalCountResponse deprecatedRetrieveInventoryPhysicalCount(
            final String physicalCountId) throws ApiException, IOException {
        return prepareDeprecatedRetrieveInventoryPhysicalCountRequest(physicalCountId).execute();
    }

    /**
     * Deprecated version of
     * [RetrieveInventoryPhysicalCount](api-endpoint:Inventory-RetrieveInventoryPhysicalCount) after
     * the endpoint URL is updated to conform to the standard convention.
     * @deprecated
     * 
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveInventoryPhysicalCountResponse> deprecatedRetrieveInventoryPhysicalCountAsync(
            final String physicalCountId) {
        try { 
            return prepareDeprecatedRetrieveInventoryPhysicalCountRequest(physicalCountId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deprecatedRetrieveInventoryPhysicalCount.
     */
    private ApiCall<RetrieveInventoryPhysicalCountResponse, ApiException> prepareDeprecatedRetrieveInventoryPhysicalCountRequest(
            final String physicalCountId) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryPhysicalCountResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/physical-count/{physical_count_id}")
                        .templateParam(param -> param.key("physical_count_id").value(physicalCountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryPhysicalCountResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns the [InventoryPhysicalCount]($m/InventoryPhysicalCount) object with the provided
     * `physical_count_id`.
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryPhysicalCountResponse retrieveInventoryPhysicalCount(
            final String physicalCountId) throws ApiException, IOException {
        return prepareRetrieveInventoryPhysicalCountRequest(physicalCountId).execute();
    }

    /**
     * Returns the [InventoryPhysicalCount]($m/InventoryPhysicalCount) object with the provided
     * `physical_count_id`.
     * @param  physicalCountId  Required parameter: ID of the
     *         [InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve.
     * @return    Returns the RetrieveInventoryPhysicalCountResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
            final String physicalCountId) {
        try { 
            return prepareRetrieveInventoryPhysicalCountRequest(physicalCountId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveInventoryPhysicalCount.
     */
    private ApiCall<RetrieveInventoryPhysicalCountResponse, ApiException> prepareRetrieveInventoryPhysicalCountRequest(
            final String physicalCountId) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryPhysicalCountResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/physical-counts/{physical_count_id}")
                        .templateParam(param -> param.key("physical_count_id").value(physicalCountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryPhysicalCountResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns the [InventoryTransfer]($m/InventoryTransfer) object with the provided `transfer_id`.
     * @param  transferId  Required parameter: ID of the
     *         [InventoryTransfer](entity:InventoryTransfer) to retrieve.
     * @return    Returns the RetrieveInventoryTransferResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveInventoryTransferResponse retrieveInventoryTransfer(
            final String transferId) throws ApiException, IOException {
        return prepareRetrieveInventoryTransferRequest(transferId).execute();
    }

    /**
     * Returns the [InventoryTransfer]($m/InventoryTransfer) object with the provided `transfer_id`.
     * @param  transferId  Required parameter: ID of the
     *         [InventoryTransfer](entity:InventoryTransfer) to retrieve.
     * @return    Returns the RetrieveInventoryTransferResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryTransferResponse> retrieveInventoryTransferAsync(
            final String transferId) {
        try { 
            return prepareRetrieveInventoryTransferRequest(transferId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveInventoryTransfer.
     */
    private ApiCall<RetrieveInventoryTransferResponse, ApiException> prepareRetrieveInventoryTransferRequest(
            final String transferId) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryTransferResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/transfers/{transfer_id}")
                        .templateParam(param -> param.key("transfer_id").value(transferId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryTransferResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves the current calculated stock count for a given [CatalogObject]($m/CatalogObject) at
     * a given set of [Location]($m/Location)s. Responses are paginated and unsorted. For more
     * sophisticated queries, use a batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](entity:CatalogObject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](entity:Location) IDs to look up as a
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
    public RetrieveInventoryCountResponse retrieveInventoryCount(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException {
        return prepareRetrieveInventoryCountRequest(catalogObjectId, locationIds, cursor).execute();
    }

    /**
     * Retrieves the current calculated stock count for a given [CatalogObject]($m/CatalogObject) at
     * a given set of [Location]($m/Location)s. Responses are paginated and unsorted. For more
     * sophisticated queries, use a batch endpoint.
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](entity:CatalogObject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](entity:Location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryCountResponse response from the API call
     */
    public CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) {
        try { 
            return prepareRetrieveInventoryCountRequest(catalogObjectId, locationIds,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveInventoryCount.
     */
    private ApiCall<RetrieveInventoryCountResponse, ApiException> prepareRetrieveInventoryCountRequest(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryCountResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/{catalog_object_id}")
                        .queryParam(param -> param.key("location_ids")
                                .value(locationIds).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .templateParam(param -> param.key("catalog_object_id").value(catalogObjectId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryCountResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a set of physical counts and inventory adjustments for the provided
     * [CatalogObject](entity:CatalogObject) at the requested [Location](entity:Location)s. You can
     * achieve the same result by calling
     * [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges) and
     * having the `catalog_object_ids` list contain a single element of the `CatalogObject` ID.
     * Results are paginated and sorted in descending order according to their `occurred_at`
     * timestamp (newest first). There are no limits on how far back the caller can page. This
     * endpoint can be used to display recent changes for a specific item. For more sophisticated
     * queries, use a batch endpoint.
     * @deprecated
     * 
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](entity:CatalogObject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](entity:Location) IDs to look up as a
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
    @Deprecated
    public RetrieveInventoryChangesResponse retrieveInventoryChanges(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws ApiException, IOException {
        return prepareRetrieveInventoryChangesRequest(catalogObjectId, locationIds,
                cursor).execute();
    }

    /**
     * Returns a set of physical counts and inventory adjustments for the provided
     * [CatalogObject](entity:CatalogObject) at the requested [Location](entity:Location)s. You can
     * achieve the same result by calling
     * [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges) and
     * having the `catalog_object_ids` list contain a single element of the `CatalogObject` ID.
     * Results are paginated and sorted in descending order according to their `occurred_at`
     * timestamp (newest first). There are no limits on how far back the caller can page. This
     * endpoint can be used to display recent changes for a specific item. For more sophisticated
     * queries, use a batch endpoint.
     * @deprecated
     * 
     * @param  catalogObjectId  Required parameter: ID of the [CatalogObject](entity:CatalogObject)
     *         to retrieve.
     * @param  locationIds  Optional parameter: The [Location](entity:Location) IDs to look up as a
     *         comma-separated list. An empty list queries all locations.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @return    Returns the RetrieveInventoryChangesResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveInventoryChangesResponse> retrieveInventoryChangesAsync(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) {
        try { 
            return prepareRetrieveInventoryChangesRequest(catalogObjectId, locationIds,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveInventoryChanges.
     */
    private ApiCall<RetrieveInventoryChangesResponse, ApiException> prepareRetrieveInventoryChangesRequest(
            final String catalogObjectId,
            final String locationIds,
            final String cursor) throws IOException {
        return new ApiCall.Builder<RetrieveInventoryChangesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/inventory/{catalog_object_id}/changes")
                        .queryParam(param -> param.key("location_ids")
                                .value(locationIds).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .templateParam(param -> param.key("catalog_object_id").value(catalogObjectId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveInventoryChangesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}