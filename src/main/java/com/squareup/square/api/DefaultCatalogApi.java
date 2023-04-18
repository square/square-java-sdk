
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.BatchDeleteCatalogObjectsRequest;
import com.squareup.square.models.BatchDeleteCatalogObjectsResponse;
import com.squareup.square.models.BatchRetrieveCatalogObjectsRequest;
import com.squareup.square.models.BatchRetrieveCatalogObjectsResponse;
import com.squareup.square.models.BatchUpsertCatalogObjectsRequest;
import com.squareup.square.models.BatchUpsertCatalogObjectsResponse;
import com.squareup.square.models.CatalogInfoResponse;
import com.squareup.square.models.CreateCatalogImageRequest;
import com.squareup.square.models.CreateCatalogImageResponse;
import com.squareup.square.models.DeleteCatalogObjectResponse;
import com.squareup.square.models.ListCatalogResponse;
import com.squareup.square.models.RetrieveCatalogObjectResponse;
import com.squareup.square.models.SearchCatalogItemsRequest;
import com.squareup.square.models.SearchCatalogItemsResponse;
import com.squareup.square.models.SearchCatalogObjectsRequest;
import com.squareup.square.models.SearchCatalogObjectsResponse;
import com.squareup.square.models.UpdateCatalogImageRequest;
import com.squareup.square.models.UpdateCatalogImageResponse;
import com.squareup.square.models.UpdateItemModifierListsRequest;
import com.squareup.square.models.UpdateItemModifierListsResponse;
import com.squareup.square.models.UpdateItemTaxesRequest;
import com.squareup.square.models.UpdateItemTaxesResponse;
import com.squareup.square.models.UpsertCatalogObjectRequest;
import com.squareup.square.models.UpsertCatalogObjectResponse;
import com.squareup.square.utilities.FileWrapper;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import io.apimatic.coreinterfaces.http.request.MutliPartRequestType;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCatalogApi extends BaseApi implements CatalogApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCatalogApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Deletes a set of [CatalogItem]($m/CatalogItem)s based on the provided list of target IDs and
     * returns a set of successfully deleted IDs in the response. Deletion is a cascading event such
     * that all children of the targeted object are also deleted. For example, deleting a
     * CatalogItem will also delete all of its [CatalogItemVariation]($m/CatalogItemVariation)
     * children. `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted IDs can
     * be deleted. The response will only include IDs that were actually deleted. To ensure
     * consistency, only one delete request is processed at a time per seller account. While one
     * (batch or non-batch) delete request is being processed, other (batched and non-batched)
     * delete requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchDeleteCatalogObjectsResponse batchDeleteCatalogObjects(
            final BatchDeleteCatalogObjectsRequest body) throws ApiException, IOException {
        return prepareBatchDeleteCatalogObjectsRequest(body).execute();
    }

    /**
     * Deletes a set of [CatalogItem]($m/CatalogItem)s based on the provided list of target IDs and
     * returns a set of successfully deleted IDs in the response. Deletion is a cascading event such
     * that all children of the targeted object are also deleted. For example, deleting a
     * CatalogItem will also delete all of its [CatalogItemVariation]($m/CatalogItemVariation)
     * children. `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted IDs can
     * be deleted. The response will only include IDs that were actually deleted. To ensure
     * consistency, only one delete request is processed at a time per seller account. While one
     * (batch or non-batch) delete request is being processed, other (batched and non-batched)
     * delete requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
            final BatchDeleteCatalogObjectsRequest body) {
        try { 
            return prepareBatchDeleteCatalogObjectsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchDeleteCatalogObjects.
     */
    private ApiCall<BatchDeleteCatalogObjectsResponse, ApiException> prepareBatchDeleteCatalogObjectsRequest(
            final BatchDeleteCatalogObjectsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchDeleteCatalogObjectsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/batch-delete")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchDeleteCatalogObjectsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a set of objects based on the provided ID. Each [CatalogItem]($m/CatalogItem)
     * returned in the set includes all of its child information including: all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) objects, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjects(
            final BatchRetrieveCatalogObjectsRequest body) throws ApiException, IOException {
        return prepareBatchRetrieveCatalogObjectsRequest(body).execute();
    }

    /**
     * Returns a set of objects based on the provided ID. Each [CatalogItem]($m/CatalogItem)
     * returned in the set includes all of its child information including: all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) objects, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
            final BatchRetrieveCatalogObjectsRequest body) {
        try { 
            return prepareBatchRetrieveCatalogObjectsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchRetrieveCatalogObjects.
     */
    private ApiCall<BatchRetrieveCatalogObjectsResponse, ApiException> prepareBatchRetrieveCatalogObjectsRequest(
            final BatchRetrieveCatalogObjectsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchRetrieveCatalogObjectsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/batch-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchRetrieveCatalogObjectsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates up to 10,000 target objects based on the provided list of objects. The
     * target objects are grouped into batches and each batch is inserted/updated in an
     * all-or-nothing manner. If an object within a batch is malformed in some way, or violates a
     * database constraint, the entire batch containing that item will be disregarded. However,
     * other batches in the same request may still succeed. Each batch may contain up to 1,000
     * objects, and batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more than 10,000. To
     * ensure consistency, only one update request is processed at a time per seller account. While
     * one (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjects(
            final BatchUpsertCatalogObjectsRequest body) throws ApiException, IOException {
        return prepareBatchUpsertCatalogObjectsRequest(body).execute();
    }

    /**
     * Creates or updates up to 10,000 target objects based on the provided list of objects. The
     * target objects are grouped into batches and each batch is inserted/updated in an
     * all-or-nothing manner. If an object within a batch is malformed in some way, or violates a
     * database constraint, the entire batch containing that item will be disregarded. However,
     * other batches in the same request may still succeed. Each batch may contain up to 1,000
     * objects, and batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more than 10,000. To
     * ensure consistency, only one update request is processed at a time per seller account. While
     * one (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<BatchUpsertCatalogObjectsResponse> batchUpsertCatalogObjectsAsync(
            final BatchUpsertCatalogObjectsRequest body) {
        try { 
            return prepareBatchUpsertCatalogObjectsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for batchUpsertCatalogObjects.
     */
    private ApiCall<BatchUpsertCatalogObjectsResponse, ApiException> prepareBatchUpsertCatalogObjectsRequest(
            final BatchUpsertCatalogObjectsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BatchUpsertCatalogObjectsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/batch-upsert")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BatchUpsertCatalogObjectsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Uploads an image file to be represented by a [CatalogImage]($m/CatalogImage) object that can
     * be linked to an existing [CatalogObject]($m/CatalogObject) instance. The resulting
     * `CatalogImage` is unattached to any `CatalogObject` if the `object_id` is not specified. This
     * `CreateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and
     * an image file part in JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.
     * @param  request  Optional parameter: Example:
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateCatalogImageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCatalogImageResponse createCatalogImage(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) throws ApiException, IOException {
        return prepareCreateCatalogImageRequest(request, imageFile).execute();
    }

    /**
     * Uploads an image file to be represented by a [CatalogImage]($m/CatalogImage) object that can
     * be linked to an existing [CatalogObject]($m/CatalogObject) instance. The resulting
     * `CatalogImage` is unattached to any `CatalogObject` if the `object_id` is not specified. This
     * `CreateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and
     * an image file part in JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.
     * @param  request  Optional parameter: Example:
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateCatalogImageResponse response from the API call
     */
    public CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) {
        try { 
            return prepareCreateCatalogImageRequest(request, imageFile).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createCatalogImage.
     */
    private ApiCall<CreateCatalogImageResponse, ApiException> prepareCreateCatalogImageRequest(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCatalogImageResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/images")
                        .formParam(param -> param.key("request")
                                .value(request)
                                .multipartSerializer(() -> 
                                        ApiHelper.serialize(request))
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART)
                                .multipartHeaders("Content-Type", "application/json; charset=utf-8"))
                        .formParam(param -> param.key("image_file")
                                .value(imageFile)
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART_FILE)
                                .multipartHeaders("Content-Type", "image/jpeg"))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateCatalogImageResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Uploads a new image file to replace the existing one in the specified
     * [CatalogImage]($m/CatalogImage) object. This `UpdateCatalogImage` endpoint accepts HTTP
     * multipart/form-data requests with a JSON part and an image file part in JPEG, PJPEG, PNG, or
     * GIF format. The maximum file size is 15MB.
     * @param  imageId  Required parameter: The ID of the `CatalogImage` object to update the
     *         encapsulated image file.
     * @param  request  Optional parameter: Example:
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the UpdateCatalogImageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateCatalogImageResponse updateCatalogImage(
            final String imageId,
            final UpdateCatalogImageRequest request,
            final FileWrapper imageFile) throws ApiException, IOException {
        return prepareUpdateCatalogImageRequest(imageId, request, imageFile).execute();
    }

    /**
     * Uploads a new image file to replace the existing one in the specified
     * [CatalogImage]($m/CatalogImage) object. This `UpdateCatalogImage` endpoint accepts HTTP
     * multipart/form-data requests with a JSON part and an image file part in JPEG, PJPEG, PNG, or
     * GIF format. The maximum file size is 15MB.
     * @param  imageId  Required parameter: The ID of the `CatalogImage` object to update the
     *         encapsulated image file.
     * @param  request  Optional parameter: Example:
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the UpdateCatalogImageResponse response from the API call
     */
    public CompletableFuture<UpdateCatalogImageResponse> updateCatalogImageAsync(
            final String imageId,
            final UpdateCatalogImageRequest request,
            final FileWrapper imageFile) {
        try { 
            return prepareUpdateCatalogImageRequest(imageId, request, imageFile).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateCatalogImage.
     */
    private ApiCall<UpdateCatalogImageResponse, ApiException> prepareUpdateCatalogImageRequest(
            final String imageId,
            final UpdateCatalogImageRequest request,
            final FileWrapper imageFile) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateCatalogImageResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/images/{image_id}")
                        .formParam(param -> param.key("request")
                                .value(request)
                                .multipartSerializer(() -> 
                                        ApiHelper.serialize(request))
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART)
                                .multipartHeaders("Content-Type", "application/json; charset=utf-8"))
                        .formParam(param -> param.key("image_file")
                                .value(imageFile)
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART_FILE)
                                .multipartHeaders("Content-Type", "image/jpeg"))
                        .templateParam(param -> param.key("image_id").value(imageId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateCatalogImageResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves information about the Square Catalog API, such as batch size limits that can be
     * used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CatalogInfoResponse catalogInfo() throws ApiException, IOException {
        return prepareCatalogInfoRequest().execute();
    }

    /**
     * Retrieves information about the Square Catalog API, such as batch size limits that can be
     * used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     */
    public CompletableFuture<CatalogInfoResponse> catalogInfoAsync() {
        try { 
            return prepareCatalogInfoRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for catalogInfo.
     */
    private ApiCall<CatalogInfoResponse, ApiException> prepareCatalogInfoRequest() throws IOException {
        return new ApiCall.Builder<CatalogInfoResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/info")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CatalogInfoResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a list of all [CatalogObject]($m/CatalogObject)s of the specified types in the
     * catalog. The `types` parameter is specified as a comma-separated list of the
     * [CatalogObjectType]($m/CatalogObjectType) values, for example, "`ITEM`, `ITEM_VARIATION`,
     * `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`". __Important:__
     * ListCatalog does not return deleted catalog items. To retrieve deleted catalog items, use
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) and set the `include_deleted_objects`
     * attribute value to `true`.
     * @param  cursor  Optional parameter: The pagination cursor returned in the previous response.
     *         Leave unset for an initial request. The page size is currently set to be 100. See
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     *         for more information.
     * @param  types  Optional parameter: An optional case-insensitive, comma-separated list of
     *         object types to retrieve. The valid values are defined in the
     *         [CatalogObjectType](entity:CatalogObjectType) enum, for example, `ITEM`,
     *         `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`,
     *         `IMAGE`, etc. If this is unspecified, the operation returns objects of all the top
     *         level types at the version of the Square API used to make the request. Object types
     *         that are nested onto other object types are not included in the defaults. At the
     *         current API version the default object types are: ITEM, CATEGORY, TAX, DISCOUNT,
     *         MODIFIER_LIST, PRICING_RULE, PRODUCT_SET, TIME_PERIOD, MEASUREMENT_UNIT,
     *         SUBSCRIPTION_PLAN, ITEM_OPTION, CUSTOM_ATTRIBUTE_DEFINITION, QUICK_AMOUNT_SETTINGS.
     * @param  catalogVersion  Optional parameter: The specific version of the catalog objects to be
     *         included in the response. This allows you to retrieve historical versions of objects.
     *         The specified version value is matched against the
     *         [CatalogObject]($m/CatalogObject)s' `version` attribute. If not included, results
     *         will be from the current version of the catalog.
     * @return    Returns the ListCatalogResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCatalogResponse listCatalog(
            final String cursor,
            final String types,
            final Long catalogVersion) throws ApiException, IOException {
        return prepareListCatalogRequest(cursor, types, catalogVersion).execute();
    }

    /**
     * Returns a list of all [CatalogObject]($m/CatalogObject)s of the specified types in the
     * catalog. The `types` parameter is specified as a comma-separated list of the
     * [CatalogObjectType]($m/CatalogObjectType) values, for example, "`ITEM`, `ITEM_VARIATION`,
     * `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`". __Important:__
     * ListCatalog does not return deleted catalog items. To retrieve deleted catalog items, use
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) and set the `include_deleted_objects`
     * attribute value to `true`.
     * @param  cursor  Optional parameter: The pagination cursor returned in the previous response.
     *         Leave unset for an initial request. The page size is currently set to be 100. See
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     *         for more information.
     * @param  types  Optional parameter: An optional case-insensitive, comma-separated list of
     *         object types to retrieve. The valid values are defined in the
     *         [CatalogObjectType](entity:CatalogObjectType) enum, for example, `ITEM`,
     *         `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`,
     *         `IMAGE`, etc. If this is unspecified, the operation returns objects of all the top
     *         level types at the version of the Square API used to make the request. Object types
     *         that are nested onto other object types are not included in the defaults. At the
     *         current API version the default object types are: ITEM, CATEGORY, TAX, DISCOUNT,
     *         MODIFIER_LIST, PRICING_RULE, PRODUCT_SET, TIME_PERIOD, MEASUREMENT_UNIT,
     *         SUBSCRIPTION_PLAN, ITEM_OPTION, CUSTOM_ATTRIBUTE_DEFINITION, QUICK_AMOUNT_SETTINGS.
     * @param  catalogVersion  Optional parameter: The specific version of the catalog objects to be
     *         included in the response. This allows you to retrieve historical versions of objects.
     *         The specified version value is matched against the
     *         [CatalogObject]($m/CatalogObject)s' `version` attribute. If not included, results
     *         will be from the current version of the catalog.
     * @return    Returns the ListCatalogResponse response from the API call
     */
    public CompletableFuture<ListCatalogResponse> listCatalogAsync(
            final String cursor,
            final String types,
            final Long catalogVersion) {
        try { 
            return prepareListCatalogRequest(cursor, types, catalogVersion).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCatalog.
     */
    private ApiCall<ListCatalogResponse, ApiException> prepareListCatalogRequest(
            final String cursor,
            final String types,
            final Long catalogVersion) throws IOException {
        return new ApiCall.Builder<ListCatalogResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/list")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("types")
                                .value(types).isRequired(false))
                        .queryParam(param -> param.key("catalog_version")
                                .value(catalogVersion).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCatalogResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a new or updates the specified [CatalogObject]($m/CatalogObject). To ensure
     * consistency, only one update request is processed at a time per seller account. While one
     * (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertCatalogObjectResponse upsertCatalogObject(
            final UpsertCatalogObjectRequest body) throws ApiException, IOException {
        return prepareUpsertCatalogObjectRequest(body).execute();
    }

    /**
     * Creates a new or updates the specified [CatalogObject]($m/CatalogObject). To ensure
     * consistency, only one update request is processed at a time per seller account. While one
     * (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     */
    public CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
            final UpsertCatalogObjectRequest body) {
        try { 
            return prepareUpsertCatalogObjectRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for upsertCatalogObject.
     */
    private ApiCall<UpsertCatalogObjectResponse, ApiException> prepareUpsertCatalogObjectRequest(
            final UpsertCatalogObjectRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpsertCatalogObjectResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/object")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpsertCatalogObjectResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a single [CatalogObject]($m/CatalogObject) based on the provided ID and returns the
     * set of successfully deleted IDs in the response. Deletion is a cascading event such that all
     * children of the targeted object are also deleted. For example, deleting a
     * [CatalogItem]($m/CatalogItem) will also delete all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) children. To ensure consistency, only one
     * delete request is processed at a time per seller account. While one (batch or non-batch)
     * delete request is being processed, other (batched and non-batched) delete requests are
     * rejected with the `429` error code.
     * @param  objectId  Required parameter: The ID of the catalog object to be deleted. When an
     *         object is deleted, other objects in the graph that depend on that object will be
     *         deleted as well (for example, deleting a catalog item will delete its catalog item
     *         variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCatalogObjectResponse deleteCatalogObject(
            final String objectId) throws ApiException, IOException {
        return prepareDeleteCatalogObjectRequest(objectId).execute();
    }

    /**
     * Deletes a single [CatalogObject]($m/CatalogObject) based on the provided ID and returns the
     * set of successfully deleted IDs in the response. Deletion is a cascading event such that all
     * children of the targeted object are also deleted. For example, deleting a
     * [CatalogItem]($m/CatalogItem) will also delete all of its
     * [CatalogItemVariation]($m/CatalogItemVariation) children. To ensure consistency, only one
     * delete request is processed at a time per seller account. While one (batch or non-batch)
     * delete request is being processed, other (batched and non-batched) delete requests are
     * rejected with the `429` error code.
     * @param  objectId  Required parameter: The ID of the catalog object to be deleted. When an
     *         object is deleted, other objects in the graph that depend on that object will be
     *         deleted as well (for example, deleting a catalog item will delete its catalog item
     *         variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call
     */
    public CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(
            final String objectId) {
        try { 
            return prepareDeleteCatalogObjectRequest(objectId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteCatalogObject.
     */
    private ApiCall<DeleteCatalogObjectResponse, ApiException> prepareDeleteCatalogObjectRequest(
            final String objectId) throws IOException {
        return new ApiCall.Builder<DeleteCatalogObjectResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/object/{object_id}")
                        .templateParam(param -> param.key("object_id").value(objectId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteCatalogObjectResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a single [CatalogItem]($m/CatalogItem) as a [CatalogObject]($m/CatalogObject) based
     * on the provided ID. The returned object includes all of the relevant
     * [CatalogItem]($m/CatalogItem) information including:
     * [CatalogItemVariation]($m/CatalogItemVariation) children, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  objectId  Required parameter: The object ID of any type of catalog objects to be
     *         retrieved.
     * @param  includeRelatedObjects  Optional parameter: If `true`, the response will include
     *         additional objects that are related to the requested objects. Related objects are
     *         defined as any objects referenced by ID by the results in the `objects` field of the
     *         response. These objects are put in the `related_objects` field. Setting this to
     *         `true` is helpful when the objects are needed for immediate display to a user. This
     *         process only goes one level deep. Objects referenced by the related objects will not
     *         be included. For example, if the `objects` field of the response contains a
     *         CatalogItem, its associated CatalogCategory objects, CatalogTax objects, CatalogImage
     *         objects and CatalogModifierLists will be returned in the `related_objects` field of
     *         the response. If the `objects` field of the response contains a CatalogItemVariation,
     *         its parent CatalogItem will be returned in the `related_objects` field of the
     *         response. Default value: `false`
     * @param  catalogVersion  Optional parameter: Requests objects as of a specific version of the
     *         catalog. This allows you to retrieve historical versions of objects. The value to
     *         retrieve a specific version of an object can be found in the version field of
     *         [CatalogObject]($m/CatalogObject)s. If not included, results will be from the current
     *         version of the catalog.
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCatalogObjectResponse retrieveCatalogObject(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion) throws ApiException, IOException {
        return prepareRetrieveCatalogObjectRequest(objectId, includeRelatedObjects,
                catalogVersion).execute();
    }

    /**
     * Returns a single [CatalogItem]($m/CatalogItem) as a [CatalogObject]($m/CatalogObject) based
     * on the provided ID. The returned object includes all of the relevant
     * [CatalogItem]($m/CatalogItem) information including:
     * [CatalogItemVariation]($m/CatalogItemVariation) children, references to its
     * [CatalogModifierList]($m/CatalogModifierList) objects, and the ids of any
     * [CatalogTax]($m/CatalogTax) objects that apply to it.
     * @param  objectId  Required parameter: The object ID of any type of catalog objects to be
     *         retrieved.
     * @param  includeRelatedObjects  Optional parameter: If `true`, the response will include
     *         additional objects that are related to the requested objects. Related objects are
     *         defined as any objects referenced by ID by the results in the `objects` field of the
     *         response. These objects are put in the `related_objects` field. Setting this to
     *         `true` is helpful when the objects are needed for immediate display to a user. This
     *         process only goes one level deep. Objects referenced by the related objects will not
     *         be included. For example, if the `objects` field of the response contains a
     *         CatalogItem, its associated CatalogCategory objects, CatalogTax objects, CatalogImage
     *         objects and CatalogModifierLists will be returned in the `related_objects` field of
     *         the response. If the `objects` field of the response contains a CatalogItemVariation,
     *         its parent CatalogItem will be returned in the `related_objects` field of the
     *         response. Default value: `false`
     * @param  catalogVersion  Optional parameter: Requests objects as of a specific version of the
     *         catalog. This allows you to retrieve historical versions of objects. The value to
     *         retrieve a specific version of an object can be found in the version field of
     *         [CatalogObject]($m/CatalogObject)s. If not included, results will be from the current
     *         version of the catalog.
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     */
    public CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion) {
        try { 
            return prepareRetrieveCatalogObjectRequest(objectId, includeRelatedObjects,
            catalogVersion).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCatalogObject.
     */
    private ApiCall<RetrieveCatalogObjectResponse, ApiException> prepareRetrieveCatalogObjectRequest(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion) throws IOException {
        return new ApiCall.Builder<RetrieveCatalogObjectResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/object/{object_id}")
                        .queryParam(param -> param.key("include_related_objects")
                                .value((includeRelatedObjects != null) ? includeRelatedObjects : false).isRequired(false))
                        .queryParam(param -> param.key("catalog_version")
                                .value(catalogVersion).isRequired(false))
                        .templateParam(param -> param.key("object_id").value(objectId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCatalogObjectResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Searches for [CatalogObject]($m/CatalogObject) of any type by matching supported search
     * attribute values, excluding custom attribute values on items or item variations, against one
     * or more of the specified query filters. This (`SearchCatalogObjects`) endpoint differs from
     * the [SearchCatalogItems]($e/Catalog/SearchCatalogItems) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints have different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchCatalogObjectsResponse searchCatalogObjects(
            final SearchCatalogObjectsRequest body) throws ApiException, IOException {
        return prepareSearchCatalogObjectsRequest(body).execute();
    }

    /**
     * Searches for [CatalogObject]($m/CatalogObject) of any type by matching supported search
     * attribute values, excluding custom attribute values on items or item variations, against one
     * or more of the specified query filters. This (`SearchCatalogObjects`) endpoint differs from
     * the [SearchCatalogItems]($e/Catalog/SearchCatalogItems) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints have different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call
     */
    public CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(
            final SearchCatalogObjectsRequest body) {
        try { 
            return prepareSearchCatalogObjectsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchCatalogObjects.
     */
    private ApiCall<SearchCatalogObjectsResponse, ApiException> prepareSearchCatalogObjectsRequest(
            final SearchCatalogObjectsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchCatalogObjectsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchCatalogObjectsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values,
     * including custom attribute values, against one or more of the specified query filters. This
     * (`SearchCatalogItems`) endpoint differs from the
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints use different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogItemsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchCatalogItemsResponse searchCatalogItems(
            final SearchCatalogItemsRequest body) throws ApiException, IOException {
        return prepareSearchCatalogItemsRequest(body).execute();
    }

    /**
     * Searches for catalog items or item variations by matching supported search attribute values,
     * including custom attribute values, against one or more of the specified query filters. This
     * (`SearchCatalogItems`) endpoint differs from the
     * [SearchCatalogObjects]($e/Catalog/SearchCatalogObjects) endpoint in the following aspects: -
     * `SearchCatalogItems` can only search for items or item variations, whereas
     * `SearchCatalogObjects` can search for any type of catalog objects. - `SearchCatalogItems`
     * supports the custom attribute query filters to return items or item variations that contain
     * custom attribute values, where `SearchCatalogObjects` does not. - `SearchCatalogItems` does
     * not support the `include_deleted_objects` filter to search for deleted items or item
     * variations, whereas `SearchCatalogObjects` does. - The both endpoints use different call
     * conventions, including the query filter formats.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogItemsResponse response from the API call
     */
    public CompletableFuture<SearchCatalogItemsResponse> searchCatalogItemsAsync(
            final SearchCatalogItemsRequest body) {
        try { 
            return prepareSearchCatalogItemsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchCatalogItems.
     */
    private ApiCall<SearchCatalogItemsResponse, ApiException> prepareSearchCatalogItemsRequest(
            final SearchCatalogItemsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchCatalogItemsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/search-catalog-items")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchCatalogItemsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates the [CatalogModifierList]($m/CatalogModifierList) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateItemModifierListsResponse updateItemModifierLists(
            final UpdateItemModifierListsRequest body) throws ApiException, IOException {
        return prepareUpdateItemModifierListsRequest(body).execute();
    }

    /**
     * Updates the [CatalogModifierList]($m/CatalogModifierList) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     */
    public CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
            final UpdateItemModifierListsRequest body) {
        try { 
            return prepareUpdateItemModifierListsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateItemModifierLists.
     */
    private ApiCall<UpdateItemModifierListsResponse, ApiException> prepareUpdateItemModifierListsRequest(
            final UpdateItemModifierListsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateItemModifierListsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/update-item-modifier-lists")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateItemModifierListsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates the [CatalogTax]($m/CatalogTax) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateItemTaxesResponse updateItemTaxes(
            final UpdateItemTaxesRequest body) throws ApiException, IOException {
        return prepareUpdateItemTaxesRequest(body).execute();
    }

    /**
     * Updates the [CatalogTax]($m/CatalogTax) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     */
    public CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
            final UpdateItemTaxesRequest body) {
        try { 
            return prepareUpdateItemTaxesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateItemTaxes.
     */
    private ApiCall<UpdateItemTaxesResponse, ApiException> prepareUpdateItemTaxesRequest(
            final UpdateItemTaxesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateItemTaxesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/catalog/update-item-taxes")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateItemTaxesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}