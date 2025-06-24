package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.BatchDeleteCatalogObjectsRequest;
import com.squareup.square.legacy.models.BatchDeleteCatalogObjectsResponse;
import com.squareup.square.legacy.models.BatchRetrieveCatalogObjectsRequest;
import com.squareup.square.legacy.models.BatchRetrieveCatalogObjectsResponse;
import com.squareup.square.legacy.models.BatchUpsertCatalogObjectsRequest;
import com.squareup.square.legacy.models.BatchUpsertCatalogObjectsResponse;
import com.squareup.square.legacy.models.CatalogInfoResponse;
import com.squareup.square.legacy.models.CreateCatalogImageRequest;
import com.squareup.square.legacy.models.CreateCatalogImageResponse;
import com.squareup.square.legacy.models.DeleteCatalogObjectResponse;
import com.squareup.square.legacy.models.ListCatalogResponse;
import com.squareup.square.legacy.models.RetrieveCatalogObjectResponse;
import com.squareup.square.legacy.models.SearchCatalogItemsRequest;
import com.squareup.square.legacy.models.SearchCatalogItemsResponse;
import com.squareup.square.legacy.models.SearchCatalogObjectsRequest;
import com.squareup.square.legacy.models.SearchCatalogObjectsResponse;
import com.squareup.square.legacy.models.UpdateCatalogImageRequest;
import com.squareup.square.legacy.models.UpdateCatalogImageResponse;
import com.squareup.square.legacy.models.UpdateItemModifierListsRequest;
import com.squareup.square.legacy.models.UpdateItemModifierListsResponse;
import com.squareup.square.legacy.models.UpdateItemTaxesRequest;
import com.squareup.square.legacy.models.UpdateItemTaxesResponse;
import com.squareup.square.legacy.models.UpsertCatalogObjectRequest;
import com.squareup.square.legacy.models.UpsertCatalogObjectResponse;
import com.squareup.square.legacy.utilities.FileWrapper;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CatalogApi {
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
    BatchDeleteCatalogObjectsResponse batchDeleteCatalogObjects(final BatchDeleteCatalogObjectsRequest body)
            throws ApiException, IOException;

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
    CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
            final BatchDeleteCatalogObjectsRequest body);

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
    BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjects(final BatchRetrieveCatalogObjectsRequest body)
            throws ApiException, IOException;

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
    CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
            final BatchRetrieveCatalogObjectsRequest body);

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
    BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjects(final BatchUpsertCatalogObjectsRequest body)
            throws ApiException, IOException;

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
    CompletableFuture<BatchUpsertCatalogObjectsResponse> batchUpsertCatalogObjectsAsync(
            final BatchUpsertCatalogObjectsRequest body);

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
    CreateCatalogImageResponse createCatalogImage(final CreateCatalogImageRequest request, final FileWrapper imageFile)
            throws ApiException, IOException;

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
    CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
            final CreateCatalogImageRequest request, final FileWrapper imageFile);

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
    UpdateCatalogImageResponse updateCatalogImage(
            final String imageId, final UpdateCatalogImageRequest request, final FileWrapper imageFile)
            throws ApiException, IOException;

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
    CompletableFuture<UpdateCatalogImageResponse> updateCatalogImageAsync(
            final String imageId, final UpdateCatalogImageRequest request, final FileWrapper imageFile);

    /**
     * Retrieves information about the Square Catalog API, such as batch size limits that can be
     * used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CatalogInfoResponse catalogInfo() throws ApiException, IOException;

    /**
     * Retrieves information about the Square Catalog API, such as batch size limits that can be
     * used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     */
    CompletableFuture<CatalogInfoResponse> catalogInfoAsync();

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
    ListCatalogResponse listCatalog(final String cursor, final String types, final Long catalogVersion)
            throws ApiException, IOException;

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
    CompletableFuture<ListCatalogResponse> listCatalogAsync(
            final String cursor, final String types, final Long catalogVersion);

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
    UpsertCatalogObjectResponse upsertCatalogObject(final UpsertCatalogObjectRequest body)
            throws ApiException, IOException;

    /**
     * Creates a new or updates the specified [CatalogObject]($m/CatalogObject). To ensure
     * consistency, only one update request is processed at a time per seller account. While one
     * (batch or non-batch) update request is being processed, other (batched and non-batched)
     * update requests are rejected with the `429` error code.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     */
    CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(final UpsertCatalogObjectRequest body);

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
    DeleteCatalogObjectResponse deleteCatalogObject(final String objectId) throws ApiException, IOException;

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
    CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(final String objectId);

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
     * @param  includeCategoryPathToRoot  Optional parameter: Specifies whether or not to include
     *         the `path_to_root` list for each returned category instance. The `path_to_root` list
     *         consists of `CategoryPathToRootNode` objects and specifies the path that starts with
     *         the immediate parent category of the returned category and ends with its root
     *         category. If the returned category is a top-level category, the `path_to_root` list
     *         is empty and is not returned in the response payload.
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveCatalogObjectResponse retrieveCatalogObject(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion,
            final Boolean includeCategoryPathToRoot)
            throws ApiException, IOException;

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
     * @param  includeCategoryPathToRoot  Optional parameter: Specifies whether or not to include
     *         the `path_to_root` list for each returned category instance. The `path_to_root` list
     *         consists of `CategoryPathToRootNode` objects and specifies the path that starts with
     *         the immediate parent category of the returned category and ends with its root
     *         category. If the returned category is a top-level category, the `path_to_root` list
     *         is empty and is not returned in the response payload.
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     */
    CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
            final String objectId,
            final Boolean includeRelatedObjects,
            final Long catalogVersion,
            final Boolean includeCategoryPathToRoot);

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
    SearchCatalogObjectsResponse searchCatalogObjects(final SearchCatalogObjectsRequest body)
            throws ApiException, IOException;

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
    CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(final SearchCatalogObjectsRequest body);

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
    SearchCatalogItemsResponse searchCatalogItems(final SearchCatalogItemsRequest body)
            throws ApiException, IOException;

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
    CompletableFuture<SearchCatalogItemsResponse> searchCatalogItemsAsync(final SearchCatalogItemsRequest body);

    /**
     * Updates the [CatalogModifierList]($m/CatalogModifierList) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateItemModifierListsResponse updateItemModifierLists(final UpdateItemModifierListsRequest body)
            throws ApiException, IOException;

    /**
     * Updates the [CatalogModifierList]($m/CatalogModifierList) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     */
    CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
            final UpdateItemModifierListsRequest body);

    /**
     * Updates the [CatalogTax]($m/CatalogTax) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateItemTaxesResponse updateItemTaxes(final UpdateItemTaxesRequest body) throws ApiException, IOException;

    /**
     * Updates the [CatalogTax]($m/CatalogTax) objects that apply to the targeted
     * [CatalogItem]($m/CatalogItem) without having to perform an upsert on the entire item.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     */
    CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(final UpdateItemTaxesRequest body);
}
