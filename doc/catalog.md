# Catalog

```java
CatalogApi catalogApi = client.getCatalogApi();
```

## Class Name

`CatalogApi`

## Methods

* [Batch Delete Catalog Objects](/doc/catalog.md#batch-delete-catalog-objects)
* [Batch Retrieve Catalog Objects](/doc/catalog.md#batch-retrieve-catalog-objects)
* [Batch Upsert Catalog Objects](/doc/catalog.md#batch-upsert-catalog-objects)
* [Create Catalog Image](/doc/catalog.md#create-catalog-image)
* [Catalog Info](/doc/catalog.md#catalog-info)
* [List Catalog](/doc/catalog.md#list-catalog)
* [Upsert Catalog Object](/doc/catalog.md#upsert-catalog-object)
* [Delete Catalog Object](/doc/catalog.md#delete-catalog-object)
* [Retrieve Catalog Object](/doc/catalog.md#retrieve-catalog-object)
* [Search Catalog Objects](/doc/catalog.md#search-catalog-objects)
* [Search Catalog Items](/doc/catalog.md#search-catalog-items)
* [Update Item Modifier Lists](/doc/catalog.md#update-item-modifier-lists)
* [Update Item Taxes](/doc/catalog.md#update-item-taxes)

## Batch Delete Catalog Objects

Deletes a set of [CatalogItem](#type-catalogitem)s based on the
provided list of target IDs and returns a set of successfully deleted IDs in
the response. Deletion is a cascading event such that all children of the
targeted object are also deleted. For example, deleting a CatalogItem will
also delete all of its [CatalogItemVariation](#type-catalogitemvariation)
children.

`BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
IDs can be deleted. The response will only include IDs that were
actually deleted.

```java
CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
    final BatchDeleteCatalogObjectsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchDeleteCatalogObjectsRequest`](/doc/models/batch-delete-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchDeleteCatalogObjectsResponse`](/doc/models/batch-delete-catalog-objects-response.md)

### Example Usage

```java
List<String> bodyObjectIds = new LinkedList<>();
bodyObjectIds.add("W62UWFY35CWMYGVWK6TWJDNI");
bodyObjectIds.add("AA27W3M2GGTF3H6AVPNB77CK");
BatchDeleteCatalogObjectsRequest body = new BatchDeleteCatalogObjectsRequest.Builder()
    .objectIds(bodyObjectIds)
    .build();

catalogApi.batchDeleteCatalogObjectsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Batch Retrieve Catalog Objects

Returns a set of objects based on the provided ID.
Each [CatalogItem](#type-catalogitem) returned in the set includes all of its
child information including: all of its
[CatalogItemVariation](#type-catalogitemvariation) objects, references to
its [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
any [CatalogTax](#type-catalogtax) objects that apply to it.

```java
CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
    final BatchRetrieveCatalogObjectsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveCatalogObjectsRequest`](/doc/models/batch-retrieve-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchRetrieveCatalogObjectsResponse`](/doc/models/batch-retrieve-catalog-objects-response.md)

### Example Usage

```java
List<String> bodyObjectIds = new LinkedList<>();
bodyObjectIds.add("W62UWFY35CWMYGVWK6TWJDNI");
bodyObjectIds.add("AA27W3M2GGTF3H6AVPNB77CK");
BatchRetrieveCatalogObjectsRequest body = new BatchRetrieveCatalogObjectsRequest.Builder(
        bodyObjectIds)
    .includeRelatedObjects(true)
    .build();

catalogApi.batchRetrieveCatalogObjectsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Batch Upsert Catalog Objects

Creates or updates up to 10,000 target objects based on the provided
list of objects. The target objects are grouped into batches and each batch is
inserted/updated in an all-or-nothing manner. If an object within a batch is
malformed in some way, or violates a database constraint, the entire batch
containing that item will be disregarded. However, other batches in the same
request may still succeed. Each batch may contain up to 1,000 objects, and
batches will be processed in order as long as the total object count for the
request (items, variations, modifier lists, discounts, and taxes) is no more
than 10,000.

```java
CompletableFuture<BatchUpsertCatalogObjectsResponse> batchUpsertCatalogObjectsAsync(
    final BatchUpsertCatalogObjectsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchUpsertCatalogObjectsRequest`](/doc/models/batch-upsert-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchUpsertCatalogObjectsResponse`](/doc/models/batch-upsert-catalog-objects-response.md)

### Example Usage

```java
List<CatalogObjectBatch> bodyBatches = new LinkedList<>();

List<CatalogObject> bodyBatches0Objects = new LinkedList<>();

List<String> bodyBatches0Objects0ItemDataTaxIds = new LinkedList<>();
bodyBatches0Objects0ItemDataTaxIds.add("#SalesTax");
List<CatalogObject> bodyBatches0Objects0ItemDataVariations = new LinkedList<>();

CatalogItemVariation bodyBatches0Objects0ItemDataVariations0ItemVariationData = new CatalogItemVariation.Builder()
    .itemId("#Tea")
    .name("Mug")
    .pricingType("FIXED_PRICING")
    .build();
CatalogObject bodyBatches0Objects0ItemDataVariations0 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Tea_Mug")
    .presentAtAllLocations(true)
    .itemVariationData(bodyBatches0Objects0ItemDataVariations0ItemVariationData)
    .build();
bodyBatches0Objects0ItemDataVariations.add(bodyBatches0Objects0ItemDataVariations0);

CatalogItem bodyBatches0Objects0ItemData = new CatalogItem.Builder()
    .name("Tea")
    .description("Hot Leaf Juice")
    .categoryId("#Beverages")
    .taxIds(bodyBatches0Objects0ItemDataTaxIds)
    .variations(bodyBatches0Objects0ItemDataVariations)
    .build();
CatalogObject bodyBatches0Objects0 = new CatalogObject.Builder(
        "ITEM",
        "#Tea")
    .presentAtAllLocations(true)
    .itemData(bodyBatches0Objects0ItemData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects0);

List<String> bodyBatches0Objects1ItemDataTaxIds = new LinkedList<>();
bodyBatches0Objects1ItemDataTaxIds.add("#SalesTax");
List<CatalogObject> bodyBatches0Objects1ItemDataVariations = new LinkedList<>();

CatalogItemVariation bodyBatches0Objects1ItemDataVariations0ItemVariationData = new CatalogItemVariation.Builder()
    .itemId("#Coffee")
    .name("Regular")
    .pricingType("FIXED_PRICING")
    .build();
CatalogObject bodyBatches0Objects1ItemDataVariations0 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Coffee_Regular")
    .presentAtAllLocations(true)
    .itemVariationData(bodyBatches0Objects1ItemDataVariations0ItemVariationData)
    .build();
bodyBatches0Objects1ItemDataVariations.add(bodyBatches0Objects1ItemDataVariations0);

CatalogItemVariation bodyBatches0Objects1ItemDataVariations1ItemVariationData = new CatalogItemVariation.Builder()
    .itemId("#Coffee")
    .name("Large")
    .pricingType("FIXED_PRICING")
    .build();
CatalogObject bodyBatches0Objects1ItemDataVariations1 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Coffee_Large")
    .presentAtAllLocations(true)
    .itemVariationData(bodyBatches0Objects1ItemDataVariations1ItemVariationData)
    .build();
bodyBatches0Objects1ItemDataVariations.add(bodyBatches0Objects1ItemDataVariations1);

CatalogItem bodyBatches0Objects1ItemData = new CatalogItem.Builder()
    .name("Coffee")
    .description("Hot Bean Juice")
    .categoryId("#Beverages")
    .taxIds(bodyBatches0Objects1ItemDataTaxIds)
    .variations(bodyBatches0Objects1ItemDataVariations)
    .build();
CatalogObject bodyBatches0Objects1 = new CatalogObject.Builder(
        "ITEM",
        "#Coffee")
    .presentAtAllLocations(true)
    .itemData(bodyBatches0Objects1ItemData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects1);

CatalogCategory bodyBatches0Objects2CategoryData = new CatalogCategory.Builder()
    .name("Beverages")
    .build();
CatalogObject bodyBatches0Objects2 = new CatalogObject.Builder(
        "CATEGORY",
        "#Beverages")
    .presentAtAllLocations(true)
    .categoryData(bodyBatches0Objects2CategoryData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects2);

CatalogTax bodyBatches0Objects3TaxData = new CatalogTax.Builder()
    .name("Sales Tax")
    .calculationPhase("TAX_SUBTOTAL_PHASE")
    .inclusionType("ADDITIVE")
    .percentage("5.0")
    .appliesToCustomAmounts(true)
    .enabled(true)
    .build();
CatalogObject bodyBatches0Objects3 = new CatalogObject.Builder(
        "TAX",
        "#SalesTax")
    .presentAtAllLocations(true)
    .taxData(bodyBatches0Objects3TaxData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects3);

CatalogObjectBatch bodyBatches0 = new CatalogObjectBatch.Builder(
        bodyBatches0Objects)
    .build();
bodyBatches.add(bodyBatches0);

BatchUpsertCatalogObjectsRequest body = new BatchUpsertCatalogObjectsRequest.Builder(
        "789ff020-f723-43a9-b4b5-43b5dc1fa3dc",
        bodyBatches)
    .build();

catalogApi.batchUpsertCatalogObjectsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Catalog Image

Uploads an image file to be represented by an [CatalogImage](#type-catalogimage) object linked to an existing
[CatalogObject](#type-catalogobject) instance. A call to this endpoint can upload an image, link an image to
a catalog object, or do both.

This `CreateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and an image file part in
JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.

Additional information and an example cURL request can be found in the [Create a Catalog Image recipe](https://developer.squareup.com/docs/more-apis/catalog/cookbook/create-catalog-images).

```java
CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
    final CreateCatalogImageRequest request,
    final FileWrapper imageFile)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `request` | [`CreateCatalogImageRequest`](/doc/models/create-catalog-image-request.md) | Form, Optional | - |
| `imageFile` | `FileWrapper` | Form, Optional | - |

### Response Type

[`CreateCatalogImageResponse`](/doc/models/create-catalog-image-response.md)

### Example Usage

```java
CatalogImage requestImageImageData = new CatalogImage.Builder()
    .caption("A picture of a cup of coffee")
    .build();
CatalogObject requestImage = new CatalogObject.Builder(
        "IMAGE",
        "#TEMP_ID")
    .imageData(requestImageImageData)
    .build();
CreateCatalogImageRequest request = new CreateCatalogImageRequest.Builder(
        "528dea59-7bfb-43c1-bd48-4a6bba7dd61f86")
    .objectId("ND6EA5AAJEO5WL3JNNIAQA32")
    .image(requestImage)
    .build();

catalogApi.createCatalogImageAsync(request, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Catalog Info

Retrieves information about the Square Catalog API, such as batch size
limits that can be used by the `BatchUpsertCatalogObjects` endpoint.

```java
CompletableFuture<CatalogInfoResponse> catalogInfoAsync()
```

### Response Type

[`CatalogInfoResponse`](/doc/models/catalog-info-response.md)

### Example Usage

```java
catalogApi.catalogInfoAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Catalog

Returns a list of [CatalogObject](#type-catalogobject)s that includes
all objects of a set of desired types (for example, all [CatalogItem](#type-catalogitem)
and [CatalogTax](#type-catalogtax) objects) in the catalog. The `types` parameter
is specified as a comma-separated list of valid [CatalogObject](#type-catalogobject) types:
`ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`.

__Important:__ ListCatalog does not return deleted catalog items. To retrieve
deleted catalog items, use SearchCatalogObjects and set `include_deleted_objects`
to `true`.

```java
CompletableFuture<ListCatalogResponse> listCatalogAsync(
    final String cursor,
    final String types)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | The pagination cursor returned in the previous response. Leave unset for an initial request.<br>See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information. |
| `types` | `String` | Query, Optional | An optional case-insensitive, comma-separated list of object types to retrieve, for example<br>`ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.<br><br>The legal values are taken from the CatalogObjectType enum:<br>`ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`,<br>`MODIFIER`, `MODIFIER_LIST`, or `IMAGE`. |

### Response Type

[`ListCatalogResponse`](/doc/models/list-catalog-response.md)

### Example Usage

```java
catalogApi.listCatalogAsync(null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Upsert Catalog Object

Creates or updates the target [CatalogObject](#type-catalogobject).

```java
CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
    final UpsertCatalogObjectRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpsertCatalogObjectRequest`](/doc/models/upsert-catalog-object-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`UpsertCatalogObjectResponse`](/doc/models/upsert-catalog-object-response.md)

### Example Usage

```java
CatalogItem bodyObjectItemData = new CatalogItem.Builder()
    .name("Cocoa")
    .description("Hot chocolate")
    .abbreviation("Ch")
    .build();
CatalogObject bodyObject = new CatalogObject.Builder(
        "ITEM",
        "#Cocoa")
    .itemData(bodyObjectItemData)
    .build();
UpsertCatalogObjectRequest body = new UpsertCatalogObjectRequest.Builder(
        "af3d1afc-7212-4300-b463-0bfc5314a5ae",
        bodyObject)
    .build();

catalogApi.upsertCatalogObjectAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Catalog Object

Deletes a single [CatalogObject](#type-catalogobject) based on the
provided ID and returns the set of successfully deleted IDs in the response.
Deletion is a cascading event such that all children of the targeted object
are also deleted. For example, deleting a [CatalogItem](#type-catalogitem)
will also delete all of its
[CatalogItemVariation](#type-catalogitemvariation) children.

```java
CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(
    final String objectId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `objectId` | `String` | Template, Required | The ID of the catalog object to be deleted. When an object is deleted, other<br>objects in the graph that depend on that object will be deleted as well (for example, deleting a<br>catalog item will delete its catalog item variations). |

### Response Type

[`DeleteCatalogObjectResponse`](/doc/models/delete-catalog-object-response.md)

### Example Usage

```java
String objectId = "object_id8";

catalogApi.deleteCatalogObjectAsync(objectId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Catalog Object

Returns a single [CatalogItem](#type-catalogitem) as a
[CatalogObject](#type-catalogobject) based on the provided ID. The returned
object includes all of the relevant [CatalogItem](#type-catalogitem)
information including: [CatalogItemVariation](#type-catalogitemvariation)
children, references to its
[CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
any [CatalogTax](#type-catalogtax) objects that apply to it.

```java
CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
    final String objectId,
    final Boolean includeRelatedObjects)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `objectId` | `String` | Template, Required | The object ID of any type of catalog objects to be retrieved. |
| `includeRelatedObjects` | `Boolean` | Query, Optional | If `true`, the response will include additional objects that are related to the<br>requested object, as follows:<br><br>If the `object` field of the response contains a CatalogItem,<br>its associated CatalogCategory, CatalogTax objects,<br>CatalogImages and CatalogModifierLists<br>will be returned in the `related_objects` field of the response. If the `object`<br>field of the response contains a CatalogItemVariation,<br>its parent CatalogItem will be returned in the `related_objects` field of<br>the response.<br><br>Default value: `false` |

### Response Type

[`RetrieveCatalogObjectResponse`](/doc/models/retrieve-catalog-object-response.md)

### Example Usage

```java
String objectId = "object_id8";

catalogApi.retrieveCatalogObjectAsync(objectId, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Search Catalog Objects

Searches for [CatalogObject](#type-CatalogObject) of any types against supported search attribute values, 
excluding custom attribute values on items or item variations, against one or more of the specified query expressions, 

This (`SearchCatalogObjects`) endpoint differs from the [SearchCatalogItems](#endpoint-Catalog-SearchCatalogItems)
endpoint in the following aspects:

- `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
- `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
- `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
- The both endpoints have different call conventions, including the query filter formats.

```java
CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(
    final SearchCatalogObjectsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCatalogObjectsRequest`](/doc/models/search-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`SearchCatalogObjectsResponse`](/doc/models/search-catalog-objects-response.md)

### Example Usage

```java
List<String> bodyObjectTypes = new LinkedList<>();
bodyObjectTypes.add("ITEM");
CatalogQueryPrefix bodyQueryPrefixQuery = new CatalogQueryPrefix.Builder(
        "name",
        "tea")
    .build();
CatalogQuery bodyQuery = new CatalogQuery.Builder()
    .prefixQuery(bodyQueryPrefixQuery)
    .build();
SearchCatalogObjectsRequest body = new SearchCatalogObjectsRequest.Builder()
    .objectTypes(bodyObjectTypes)
    .query(bodyQuery)
    .limit(100)
    .build();

catalogApi.searchCatalogObjectsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Search Catalog Items

Searches for catalog items or item variations by matching supported search attribute values, including
custom attribute values, against one or more of the specified query expressions, 

This (`SearchCatalogItems`) endpoint differs from the [SearchCatalogObjects](#endpoint-Catalog-SearchCatalogObjects)
endpoint in the following aspects:

- `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
- `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
- `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
- The both endpoints use different call conventions, including the query filter formats.

```java
CompletableFuture<SearchCatalogItemsResponse> searchCatalogItemsAsync(
    final SearchCatalogItemsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCatalogItemsRequest`](/doc/models/search-catalog-items-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`SearchCatalogItemsResponse`](/doc/models/search-catalog-items-response.md)

### Example Usage

```java
List<String> bodyCategoryIds = new LinkedList<>();
bodyCategoryIds.add("WINE_CATEGORY_ID");
List<String> bodyStockLevels = new LinkedList<>();
bodyStockLevels.add("OUT");
bodyStockLevels.add("LOW");
List<String> bodyEnabledLocationIds = new LinkedList<>();
bodyEnabledLocationIds.add("ATL_LOCATION_ID");
List<String> bodyProductTypes = new LinkedList<>();
bodyProductTypes.add("REGULAR");
List<CustomAttributeFilter> bodyCustomAttributeFilters = new LinkedList<>();

CustomAttributeFilter bodyCustomAttributeFilters0 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("VEGAN_DEFINITION_ID")
    .boolFilter(true)
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters0);

CustomAttributeFilter bodyCustomAttributeFilters1 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("BRAND_DEFINITION_ID")
    .stringFilter("Dark Horse")
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters1);

Range bodyCustomAttributeFilters2NumberFilter = new Range.Builder()
    .min("2017")
    .max("2018")
    .build();
CustomAttributeFilter bodyCustomAttributeFilters2 = new CustomAttributeFilter.Builder()
    .key("VINTAGE")
    .numberFilter(bodyCustomAttributeFilters2NumberFilter)
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters2);

CustomAttributeFilter bodyCustomAttributeFilters3 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("VARIETAL_DEFINITION_ID")
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters3);

SearchCatalogItemsRequest body = new SearchCatalogItemsRequest.Builder()
    .textFilter("red")
    .categoryIds(bodyCategoryIds)
    .stockLevels(bodyStockLevels)
    .enabledLocationIds(bodyEnabledLocationIds)
    .limit(100)
    .sortOrder("ASC")
    .productTypes(bodyProductTypes)
    .customAttributeFilters(bodyCustomAttributeFilters)
    .build();

catalogApi.searchCatalogItemsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Item Modifier Lists

Updates the [CatalogModifierList](#type-catalogmodifierlist) objects
that apply to the targeted [CatalogItem](#type-catalogitem) without having
to perform an upsert on the entire item.

```java
CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
    final UpdateItemModifierListsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateItemModifierListsRequest`](/doc/models/update-item-modifier-lists-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`UpdateItemModifierListsResponse`](/doc/models/update-item-modifier-lists-response.md)

### Example Usage

```java
List<String> bodyItemIds = new LinkedList<>();
bodyItemIds.add("H42BRLUJ5KTZTTMPVSLFAACQ");
bodyItemIds.add("2JXOBJIHCWBQ4NZ3RIXQGJA6");
List<String> bodyModifierListsToEnable = new LinkedList<>();
bodyModifierListsToEnable.add("H42BRLUJ5KTZTTMPVSLFAACQ");
bodyModifierListsToEnable.add("2JXOBJIHCWBQ4NZ3RIXQGJA6");
List<String> bodyModifierListsToDisable = new LinkedList<>();
bodyModifierListsToDisable.add("7WRC16CJZDVLSNDQ35PP6YAD");
UpdateItemModifierListsRequest body = new UpdateItemModifierListsRequest.Builder(
        bodyItemIds)
    .modifierListsToEnable(bodyModifierListsToEnable)
    .modifierListsToDisable(bodyModifierListsToDisable)
    .build();

catalogApi.updateItemModifierListsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Item Taxes

Updates the [CatalogTax](#type-catalogtax) objects that apply to the
targeted [CatalogItem](#type-catalogitem) without having to perform an
upsert on the entire item.

```java
CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
    final UpdateItemTaxesRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateItemTaxesRequest`](/doc/models/update-item-taxes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`UpdateItemTaxesResponse`](/doc/models/update-item-taxes-response.md)

### Example Usage

```java
List<String> bodyItemIds = new LinkedList<>();
bodyItemIds.add("H42BRLUJ5KTZTTMPVSLFAACQ");
bodyItemIds.add("2JXOBJIHCWBQ4NZ3RIXQGJA6");
List<String> bodyTaxesToEnable = new LinkedList<>();
bodyTaxesToEnable.add("4WRCNHCJZDVLSNDQ35PP6YAD");
List<String> bodyTaxesToDisable = new LinkedList<>();
bodyTaxesToDisable.add("AQCEGCEBBQONINDOHRGZISEX");
UpdateItemTaxesRequest body = new UpdateItemTaxesRequest.Builder(
        bodyItemIds)
    .taxesToEnable(bodyTaxesToEnable)
    .taxesToDisable(bodyTaxesToDisable)
    .build();

catalogApi.updateItemTaxesAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

