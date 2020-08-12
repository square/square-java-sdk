package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
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
import com.squareup.square.models.UpdateItemModifierListsRequest;
import com.squareup.square.models.UpdateItemModifierListsResponse;
import com.squareup.square.models.UpdateItemTaxesRequest;
import com.squareup.square.models.UpdateItemTaxesResponse;
import com.squareup.square.models.UpsertCatalogObjectRequest;
import com.squareup.square.models.UpsertCatalogObjectResponse;
import com.squareup.square.utilities.FileWrapper;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CatalogApi {
    /**
     * Deletes a set of [CatalogItem](#type-catalogitem)s based on the
     * provided list of target IDs and returns a set of successfully deleted IDs in
     * the response. Deletion is a cascading event such that all children of the
     * targeted object are also deleted. For example, deleting a CatalogItem will
     * also delete all of its [CatalogItemVariation](#type-catalogitemvariation)
     * children.
     * `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
     * IDs can be deleted. The response will only include IDs that were
     * actually deleted.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call
     */
    BatchDeleteCatalogObjectsResponse batchDeleteCatalogObjects(
            final BatchDeleteCatalogObjectsRequest body) throws ApiException, IOException;

    /**
     * Deletes a set of [CatalogItem](#type-catalogitem)s based on the
     * provided list of target IDs and returns a set of successfully deleted IDs in
     * the response. Deletion is a cascading event such that all children of the
     * targeted object are also deleted. For example, deleting a CatalogItem will
     * also delete all of its [CatalogItemVariation](#type-catalogitemvariation)
     * children.
     * `BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
     * IDs can be deleted. The response will only include IDs that were
     * actually deleted.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchDeleteCatalogObjectsResponse response from the API call 
     */
    CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
            final BatchDeleteCatalogObjectsRequest body);

    /**
     * Returns a set of objects based on the provided ID.
     * Each [CatalogItem](#type-catalogitem) returned in the set includes all of its
     * child information including: all of its
     * [CatalogItemVariation](#type-catalogitemvariation) objects, references to
     * its [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call
     */
    BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjects(
            final BatchRetrieveCatalogObjectsRequest body) throws ApiException, IOException;

    /**
     * Returns a set of objects based on the provided ID.
     * Each [CatalogItem](#type-catalogitem) returned in the set includes all of its
     * child information including: all of its
     * [CatalogItemVariation](#type-catalogitemvariation) objects, references to
     * its [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchRetrieveCatalogObjectsResponse response from the API call 
     */
    CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
            final BatchRetrieveCatalogObjectsRequest body);

    /**
     * Creates or updates up to 10,000 target objects based on the provided
     * list of objects. The target objects are grouped into batches and each batch is
     * inserted/updated in an all-or-nothing manner. If an object within a batch is
     * malformed in some way, or violates a database constraint, the entire batch
     * containing that item will be disregarded. However, other batches in the same
     * request may still succeed. Each batch may contain up to 1,000 objects, and
     * batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more
     * than 10,000.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call
     */
    BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjects(
            final BatchUpsertCatalogObjectsRequest body) throws ApiException, IOException;

    /**
     * Creates or updates up to 10,000 target objects based on the provided
     * list of objects. The target objects are grouped into batches and each batch is
     * inserted/updated in an all-or-nothing manner. If an object within a batch is
     * malformed in some way, or violates a database constraint, the entire batch
     * containing that item will be disregarded. However, other batches in the same
     * request may still succeed. Each batch may contain up to 1,000 objects, and
     * batches will be processed in order as long as the total object count for the
     * request (items, variations, modifier lists, discounts, and taxes) is no more
     * than 10,000.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the BatchUpsertCatalogObjectsResponse response from the API call 
     */
    CompletableFuture<BatchUpsertCatalogObjectsResponse> batchUpsertCatalogObjectsAsync(
            final BatchUpsertCatalogObjectsRequest body);

    /**
     * Uploads an image file to be represented by an [CatalogImage](#type-catalogimage) object linked to an existing
     * [CatalogObject](#type-catalogobject) instance. A call to this endpoint can upload an image, link an image to
     * a catalog object, or do both.
     * This `CreateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and an image file part in
     * JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.
     * Additional information and an example cURL request can be found in the [Create a Catalog Image recipe](https://developer.squareup.com/docs/more-apis/catalog/cookbook/create-catalog-images).
     * @param    request    Optional parameter: Example: 
     * @param    imageFile    Optional parameter: Example: 
     * @return    Returns the CreateCatalogImageResponse response from the API call
     */
    CreateCatalogImageResponse createCatalogImage(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile) throws ApiException, IOException;

    /**
     * Uploads an image file to be represented by an [CatalogImage](#type-catalogimage) object linked to an existing
     * [CatalogObject](#type-catalogobject) instance. A call to this endpoint can upload an image, link an image to
     * a catalog object, or do both.
     * This `CreateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and an image file part in
     * JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.
     * Additional information and an example cURL request can be found in the [Create a Catalog Image recipe](https://developer.squareup.com/docs/more-apis/catalog/cookbook/create-catalog-images).
     * @param    request    Optional parameter: Example: 
     * @param    imageFile    Optional parameter: Example: 
     * @return    Returns the CreateCatalogImageResponse response from the API call 
     */
    CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
            final CreateCatalogImageRequest request,
            final FileWrapper imageFile);

    /**
     * Retrieves information about the Square Catalog API, such as batch size
     * limits that can be used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call
     */
    CatalogInfoResponse catalogInfo() throws ApiException, IOException;

    /**
     * Retrieves information about the Square Catalog API, such as batch size
     * limits that can be used by the `BatchUpsertCatalogObjects` endpoint.
     * @return    Returns the CatalogInfoResponse response from the API call 
     */
    CompletableFuture<CatalogInfoResponse> catalogInfoAsync();

    /**
     * Returns a list of [CatalogObject](#type-catalogobject)s that includes
     * all objects of a set of desired types (for example, all [CatalogItem](#type-catalogitem)
     * and [CatalogTax](#type-catalogtax) objects) in the catalog. The `types` parameter
     * is specified as a comma-separated list of valid [CatalogObject](#type-catalogobject) types:
     * `ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`.
     * __Important:__ ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use SearchCatalogObjects and set `include_deleted_objects`
     * to `true`.
     * @param    cursor    Optional parameter: The pagination cursor returned in the previous response. Leave unset for an initial request. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    types    Optional parameter: An optional case-insensitive, comma-separated list of object types to retrieve, for example `ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.  The legal values are taken from the CatalogObjectType enum: `ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`.
     * @return    Returns the ListCatalogResponse response from the API call
     */
    ListCatalogResponse listCatalog(
            final String cursor,
            final String types) throws ApiException, IOException;

    /**
     * Returns a list of [CatalogObject](#type-catalogobject)s that includes
     * all objects of a set of desired types (for example, all [CatalogItem](#type-catalogitem)
     * and [CatalogTax](#type-catalogtax) objects) in the catalog. The `types` parameter
     * is specified as a comma-separated list of valid [CatalogObject](#type-catalogobject) types:
     * `ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`.
     * __Important:__ ListCatalog does not return deleted catalog items. To retrieve
     * deleted catalog items, use SearchCatalogObjects and set `include_deleted_objects`
     * to `true`.
     * @param    cursor    Optional parameter: The pagination cursor returned in the previous response. Leave unset for an initial request. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     * @param    types    Optional parameter: An optional case-insensitive, comma-separated list of object types to retrieve, for example `ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.  The legal values are taken from the CatalogObjectType enum: `ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`, `MODIFIER`, `MODIFIER_LIST`, or `IMAGE`.
     * @return    Returns the ListCatalogResponse response from the API call 
     */
    CompletableFuture<ListCatalogResponse> listCatalogAsync(
            final String cursor,
            final String types);

    /**
     * Creates or updates the target [CatalogObject](#type-catalogobject).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call
     */
    UpsertCatalogObjectResponse upsertCatalogObject(
            final UpsertCatalogObjectRequest body) throws ApiException, IOException;

    /**
     * Creates or updates the target [CatalogObject](#type-catalogobject).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpsertCatalogObjectResponse response from the API call 
     */
    CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
            final UpsertCatalogObjectRequest body);

    /**
     * Deletes a single [CatalogObject](#type-catalogobject) based on the
     * provided ID and returns the set of successfully deleted IDs in the response.
     * Deletion is a cascading event such that all children of the targeted object
     * are also deleted. For example, deleting a [CatalogItem](#type-catalogitem)
     * will also delete all of its
     * [CatalogItemVariation](#type-catalogitemvariation) children.
     * @param    objectId    Required parameter: The ID of the catalog object to be deleted. When an object is deleted, other objects in the graph that depend on that object will be deleted as well (for example, deleting a catalog item will delete its catalog item variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call
     */
    DeleteCatalogObjectResponse deleteCatalogObject(
            final String objectId) throws ApiException, IOException;

    /**
     * Deletes a single [CatalogObject](#type-catalogobject) based on the
     * provided ID and returns the set of successfully deleted IDs in the response.
     * Deletion is a cascading event such that all children of the targeted object
     * are also deleted. For example, deleting a [CatalogItem](#type-catalogitem)
     * will also delete all of its
     * [CatalogItemVariation](#type-catalogitemvariation) children.
     * @param    objectId    Required parameter: The ID of the catalog object to be deleted. When an object is deleted, other objects in the graph that depend on that object will be deleted as well (for example, deleting a catalog item will delete its catalog item variations).
     * @return    Returns the DeleteCatalogObjectResponse response from the API call 
     */
    CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(
            final String objectId);

    /**
     * Returns a single [CatalogItem](#type-catalogitem) as a
     * [CatalogObject](#type-catalogobject) based on the provided ID. The returned
     * object includes all of the relevant [CatalogItem](#type-catalogitem)
     * information including: [CatalogItemVariation](#type-catalogitemvariation)
     * children, references to its
     * [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    objectId    Required parameter: The object ID of any type of catalog objects to be retrieved.
     * @param    includeRelatedObjects    Optional parameter: If `true`, the response will include additional objects that are related to the requested object, as follows:  If the `object` field of the response contains a CatalogItem, its associated CatalogCategory, CatalogTax objects, CatalogImages and CatalogModifierLists will be returned in the `related_objects` field of the response. If the `object` field of the response contains a CatalogItemVariation, its parent CatalogItem will be returned in the `related_objects` field of the response.  Default value: `false`
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call
     */
    RetrieveCatalogObjectResponse retrieveCatalogObject(
            final String objectId,
            final Boolean includeRelatedObjects) throws ApiException, IOException;

    /**
     * Returns a single [CatalogItem](#type-catalogitem) as a
     * [CatalogObject](#type-catalogobject) based on the provided ID. The returned
     * object includes all of the relevant [CatalogItem](#type-catalogitem)
     * information including: [CatalogItemVariation](#type-catalogitemvariation)
     * children, references to its
     * [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
     * any [CatalogTax](#type-catalogtax) objects that apply to it.
     * @param    objectId    Required parameter: The object ID of any type of catalog objects to be retrieved.
     * @param    includeRelatedObjects    Optional parameter: If `true`, the response will include additional objects that are related to the requested object, as follows:  If the `object` field of the response contains a CatalogItem, its associated CatalogCategory, CatalogTax objects, CatalogImages and CatalogModifierLists will be returned in the `related_objects` field of the response. If the `object` field of the response contains a CatalogItemVariation, its parent CatalogItem will be returned in the `related_objects` field of the response.  Default value: `false`
     * @return    Returns the RetrieveCatalogObjectResponse response from the API call 
     */
    CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
            final String objectId,
            final Boolean includeRelatedObjects);

    /**
     * Searches for [CatalogObject](#type-CatalogObject) of any types against supported search attribute values, 
     * excluding custom attribute values on items or item variations, against one or more of the specified query expressions, 
     * This (`SearchCatalogObjects`) endpoint differs from the [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems)
     * endpoint in the following aspects:
     * - `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
     * - `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
     * - `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
     * - The both endpoints have different call conventions, including the query filter formats.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call
     */
    SearchCatalogObjectsResponse searchCatalogObjects(
            final SearchCatalogObjectsRequest body) throws ApiException, IOException;

    /**
     * Searches for [CatalogObject](#type-CatalogObject) of any types against supported search attribute values, 
     * excluding custom attribute values on items or item variations, against one or more of the specified query expressions, 
     * This (`SearchCatalogObjects`) endpoint differs from the [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems)
     * endpoint in the following aspects:
     * - `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
     * - `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
     * - `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
     * - The both endpoints have different call conventions, including the query filter formats.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogObjectsResponse response from the API call 
     */
    CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(
            final SearchCatalogObjectsRequest body);

    /**
     * Searches for catalog items or item variations by matching supported search attribute values, including
     * custom attribute values, against one or more of the specified query expressions, 
     * This (`SearchCatalogItems`) endpoint differs from the [SearchCatalogObjects](#endpoint-Catalog-SearchCatalogObjects)
     * endpoint in the following aspects:
     * - `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
     * - `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
     * - `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
     * - The both endpoints use different call conventions, including the query filter formats.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogItemsResponse response from the API call
     */
    SearchCatalogItemsResponse searchCatalogItems(
            final SearchCatalogItemsRequest body) throws ApiException, IOException;

    /**
     * Searches for catalog items or item variations by matching supported search attribute values, including
     * custom attribute values, against one or more of the specified query expressions, 
     * This (`SearchCatalogItems`) endpoint differs from the [SearchCatalogObjects](#endpoint-Catalog-SearchCatalogObjects)
     * endpoint in the following aspects:
     * - `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
     * - `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
     * - `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
     * - The both endpoints use different call conventions, including the query filter formats.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCatalogItemsResponse response from the API call 
     */
    CompletableFuture<SearchCatalogItemsResponse> searchCatalogItemsAsync(
            final SearchCatalogItemsRequest body);

    /**
     * Updates the [CatalogModifierList](#type-catalogmodifierlist) objects
     * that apply to the targeted [CatalogItem](#type-catalogitem) without having
     * to perform an upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call
     */
    UpdateItemModifierListsResponse updateItemModifierLists(
            final UpdateItemModifierListsRequest body) throws ApiException, IOException;

    /**
     * Updates the [CatalogModifierList](#type-catalogmodifierlist) objects
     * that apply to the targeted [CatalogItem](#type-catalogitem) without having
     * to perform an upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemModifierListsResponse response from the API call 
     */
    CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
            final UpdateItemModifierListsRequest body);

    /**
     * Updates the [CatalogTax](#type-catalogtax) objects that apply to the
     * targeted [CatalogItem](#type-catalogitem) without having to perform an
     * upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call
     */
    UpdateItemTaxesResponse updateItemTaxes(
            final UpdateItemTaxesRequest body) throws ApiException, IOException;

    /**
     * Updates the [CatalogTax](#type-catalogtax) objects that apply to the
     * targeted [CatalogItem](#type-catalogitem) without having to perform an
     * upsert on the entire item.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateItemTaxesResponse response from the API call 
     */
    CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
            final UpdateItemTaxesRequest body);

}
