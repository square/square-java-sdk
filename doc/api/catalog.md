# Catalog

```java
CatalogApi catalogApi = client.getCatalogApi();
```

## Class Name

`CatalogApi`

## Methods

* [Batch Delete Catalog Objects](../../doc/api/catalog.md#batch-delete-catalog-objects)
* [Batch Retrieve Catalog Objects](../../doc/api/catalog.md#batch-retrieve-catalog-objects)
* [Batch Upsert Catalog Objects](../../doc/api/catalog.md#batch-upsert-catalog-objects)
* [Create Catalog Image](../../doc/api/catalog.md#create-catalog-image)
* [Update Catalog Image](../../doc/api/catalog.md#update-catalog-image)
* [Catalog Info](../../doc/api/catalog.md#catalog-info)
* [List Catalog](../../doc/api/catalog.md#list-catalog)
* [Upsert Catalog Object](../../doc/api/catalog.md#upsert-catalog-object)
* [Delete Catalog Object](../../doc/api/catalog.md#delete-catalog-object)
* [Retrieve Catalog Object](../../doc/api/catalog.md#retrieve-catalog-object)
* [Search Catalog Objects](../../doc/api/catalog.md#search-catalog-objects)
* [Search Catalog Items](../../doc/api/catalog.md#search-catalog-items)
* [Update Item Modifier Lists](../../doc/api/catalog.md#update-item-modifier-lists)
* [Update Item Taxes](../../doc/api/catalog.md#update-item-taxes)


# Batch Delete Catalog Objects

Deletes a set of [CatalogItem](../../doc/models/catalog-item.md)s based on the
provided list of target IDs and returns a set of successfully deleted IDs in
the response. Deletion is a cascading event such that all children of the
targeted object are also deleted. For example, deleting a CatalogItem will
also delete all of its [CatalogItemVariation](../../doc/models/catalog-item-variation.md)
children.

`BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
IDs can be deleted. The response will only include IDs that were
actually deleted.

```java
CompletableFuture<BatchDeleteCatalogObjectsResponse> batchDeleteCatalogObjectsAsync(
    final BatchDeleteCatalogObjectsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchDeleteCatalogObjectsRequest`](../../doc/models/batch-delete-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchDeleteCatalogObjectsResponse`](../../doc/models/batch-delete-catalog-objects-response.md)

## Example Usage

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


# Batch Retrieve Catalog Objects

Returns a set of objects based on the provided ID.
Each [CatalogItem](../../doc/models/catalog-item.md) returned in the set includes all of its
child information including: all of its
[CatalogItemVariation](../../doc/models/catalog-item-variation.md) objects, references to
its [CatalogModifierList](../../doc/models/catalog-modifier-list.md) objects, and the ids of
any [CatalogTax](../../doc/models/catalog-tax.md) objects that apply to it.

```java
CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
    final BatchRetrieveCatalogObjectsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveCatalogObjectsRequest`](../../doc/models/batch-retrieve-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveCatalogObjectsResponse`](../../doc/models/batch-retrieve-catalog-objects-response.md)

## Example Usage

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


# Batch Upsert Catalog Objects

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

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchUpsertCatalogObjectsRequest`](../../doc/models/batch-upsert-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchUpsertCatalogObjectsResponse`](../../doc/models/batch-upsert-catalog-objects-response.md)

## Example Usage

```java
List<CatalogObjectBatch> bodyBatches = new LinkedList<>();

List<CatalogObject> bodyBatches0Objects = new LinkedList<>();

List<String> bodyBatches0Objects0ItemDataTaxIds = new LinkedList<>();
bodyBatches0Objects0ItemDataTaxIds.add("#SalesTax");
List<CatalogObject> bodyBatches0Objects0ItemDataVariations = new LinkedList<>();

CatalogItemVariation catalogItemVariation = new CatalogItemVariation.Builder()
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

CatalogItem catalogItem = new CatalogItem.Builder()
    .name("Tea")
    .description("Hot Leaf Juice")
    .categoryId("#Beverages")
    .taxIds(catalogItemTaxIds)
    .variations(catalogItemVariations)
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

CatalogItemVariation catalogItemVariation = new CatalogItemVariation.Builder()
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

CatalogItemVariation catalogItemVariation = new CatalogItemVariation.Builder()
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

CatalogItem catalogItem = new CatalogItem.Builder()
    .name("Coffee")
    .description("Hot Bean Juice")
    .categoryId("#Beverages")
    .taxIds(catalogItemTaxIds)
    .variations(catalogItemVariations)
    .build();
CatalogObject bodyBatches0Objects1 = new CatalogObject.Builder(
        "ITEM",
        "#Coffee")
    .presentAtAllLocations(true)
    .itemData(bodyBatches0Objects1ItemData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects1);

CatalogCategory catalogCategory = new CatalogCategory.Builder()
    .name("Beverages")
    .build();
CatalogObject bodyBatches0Objects2 = new CatalogObject.Builder(
        "CATEGORY",
        "#Beverages")
    .presentAtAllLocations(true)
    .categoryData(bodyBatches0Objects2CategoryData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects2);

CatalogTax catalogTax = new CatalogTax.Builder()
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
        objects)
    .build();
bodyBatches.add(bodyBatches0);

BatchUpsertCatalogObjectsRequest body = new BatchUpsertCatalogObjectsRequest.Builder(
        "789ff020-f723-43a9-b4b5-43b5dc1fa3dc",
        batches)
    .build();

catalogApi.batchUpsertCatalogObjectsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Catalog Image

Uploads an image file to be represented by a [CatalogImage](../../doc/models/catalog-image.md) object that can be linked to an existing
[CatalogObject](../../doc/models/catalog-object.md) instance. The resulting `CatalogImage` is unattached to any `CatalogObject` if the `object_id`
is not specified.

This `CreateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and an image file part in
JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.

```java
CompletableFuture<CreateCatalogImageResponse> createCatalogImageAsync(
    final CreateCatalogImageRequest request,
    final FileWrapper imageFile)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `request` | [`CreateCatalogImageRequest`](../../doc/models/create-catalog-image-request.md) | Form, Optional | - |
| `imageFile` | `FileWrapper` | Form, Optional | - |

## Response Type

[`CreateCatalogImageResponse`](../../doc/models/create-catalog-image-response.md)

## Example Usage

```java
CatalogImage catalogImage = new CatalogImage.Builder()
    .caption("A picture of a cup of coffee")
    .build();
CatalogObject catalogObject = new CatalogObject.Builder(
        "IMAGE",
        "#TEMP_ID")
    .imageData(catalogObjectImageData)
    .build();
CreateCatalogImageRequest request = new CreateCatalogImageRequest.Builder(
        "528dea59-7bfb-43c1-bd48-4a6bba7dd61f86",
        image)
    .objectId("ND6EA5AAJEO5WL3JNNIAQA32")
    .build();

catalogApi.createCatalogImageAsync(request, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Catalog Image

Uploads a new image file to replace the existing one in the specified [CatalogImage](../../doc/models/catalog-image.md) object.

This `UpdateCatalogImage` endpoint accepts HTTP multipart/form-data requests with a JSON part and an image file part in
JPEG, PJPEG, PNG, or GIF format. The maximum file size is 15MB.

```java
CompletableFuture<UpdateCatalogImageResponse> updateCatalogImageAsync(
    final String imageId,
    final UpdateCatalogImageRequest request,
    final FileWrapper imageFile)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `imageId` | `String` | Template, Required | The ID of the `CatalogImage` object to update the encapsulated image file. |
| `request` | [`UpdateCatalogImageRequest`](../../doc/models/update-catalog-image-request.md) | Form, Optional | - |
| `imageFile` | `FileWrapper` | Form, Optional | - |

## Response Type

[`UpdateCatalogImageResponse`](../../doc/models/update-catalog-image-response.md)

## Example Usage

```java
String imageId = "image_id4";
UpdateCatalogImageRequest request = new UpdateCatalogImageRequest.Builder(
        "528dea59-7bfb-43c1-bd48-4a6bba7dd61f86")
    .build();

catalogApi.updateCatalogImageAsync(imageId, request, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Catalog Info

Retrieves information about the Square Catalog API, such as batch size
limits that can be used by the `BatchUpsertCatalogObjects` endpoint.

```java
CompletableFuture<CatalogInfoResponse> catalogInfoAsync()
```

## Response Type

[`CatalogInfoResponse`](../../doc/models/catalog-info-response.md)

## Example Usage

```java
catalogApi.catalogInfoAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Catalog

Returns a list of all [CatalogObject](../../doc/models/catalog-object.md)s of the specified types in the catalog.

The `types` parameter is specified as a comma-separated list of the [CatalogObjectType](../../doc/models/catalog-object-type.md) values,
for example, "`ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`".

__Important:__ ListCatalog does not return deleted catalog items. To retrieve
deleted catalog items, use [SearchCatalogObjects](../../doc/api/catalog.md#search-catalog-objects)
and set the `include_deleted_objects` attribute value to `true`.

```java
CompletableFuture<ListCatalogResponse> listCatalogAsync(
    final String cursor,
    final String types,
    final Long catalogVersion)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | The pagination cursor returned in the previous response. Leave unset for an initial request.<br>The page size is currently set to be 100.<br>See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information. |
| `types` | `String` | Query, Optional | An optional case-insensitive, comma-separated list of object types to retrieve.<br><br>The valid values are defined in the [CatalogObjectType](../../doc/models/catalog-object-type.md) enum, for example,<br>`ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`,<br>`MODIFIER`, `MODIFIER_LIST`, `IMAGE`, etc.<br><br>If this is unspecified, the operation returns objects of all the top level types at the version<br>of the Square API used to make the request. Object types that are nested onto other object types<br>are not included in the defaults.<br><br>At the current API version the default object types are:<br>ITEM, CATEGORY, TAX, DISCOUNT, MODIFIER_LIST, DINING_OPTION, TAX_EXEMPTION,<br>SERVICE_CHARGE, PRICING_RULE, PRODUCT_SET, TIME_PERIOD, MEASUREMENT_UNIT,<br>SUBSCRIPTION_PLAN, ITEM_OPTION, CUSTOM_ATTRIBUTE_DEFINITION, QUICK_AMOUNT_SETTINGS. |
| `catalogVersion` | `Long` | Query, Optional | The specific version of the catalog objects to be included in the response.<br>This allows you to retrieve historical<br>versions of objects. The specified version value is matched against<br>the [CatalogObject](../../doc/models/catalog-object.md)s' `version` attribute.  If not included, results will<br>be from the current version of the catalog. |

## Response Type

[`ListCatalogResponse`](../../doc/models/list-catalog-response.md)

## Example Usage

```java
catalogApi.listCatalogAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Upsert Catalog Object

Creates or updates the target [CatalogObject](../../doc/models/catalog-object.md).

```java
CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
    final UpsertCatalogObjectRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpsertCatalogObjectRequest`](../../doc/models/upsert-catalog-object-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpsertCatalogObjectResponse`](../../doc/models/upsert-catalog-object-response.md)

## Example Usage

```java
List<CatalogObject> bodyObjectItemDataVariations = new LinkedList<>();

CatalogItemVariation catalogItemVariation = new CatalogItemVariation.Builder()
    .itemId("#Cocoa")
    .name("Small")
    .pricingType("VARIABLE_PRICING")
    .build();
CatalogObject bodyObjectItemDataVariations0 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Small")
    .itemVariationData(bodyObjectItemDataVariations0ItemVariationData)
    .build();
bodyObjectItemDataVariations.add(bodyObjectItemDataVariations0);

Money money = new Money.Builder()
    .amount(400L)
    .currency("USD")
    .build();
CatalogItemVariation catalogItemVariation = new CatalogItemVariation.Builder()
    .itemId("#Cocoa")
    .name("Large")
    .pricingType("FIXED_PRICING")
    .priceMoney(catalogItemVariationPriceMoney)
    .build();
CatalogObject bodyObjectItemDataVariations1 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Large")
    .itemVariationData(bodyObjectItemDataVariations1ItemVariationData)
    .build();
bodyObjectItemDataVariations.add(bodyObjectItemDataVariations1);

CatalogItem catalogItem = new CatalogItem.Builder()
    .name("Cocoa")
    .description("Hot Chocolate")
    .abbreviation("Ch")
    .variations(catalogItemVariations)
    .build();
CatalogObject catalogObject = new CatalogObject.Builder(
        "ITEM",
        "#Cocoa")
    .itemData(catalogObjectItemData)
    .build();
UpsertCatalogObjectRequest body = new UpsertCatalogObjectRequest.Builder(
        "af3d1afc-7212-4300-b463-0bfc5314a5ae",
        object)
    .build();

catalogApi.upsertCatalogObjectAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Catalog Object

Deletes a single [CatalogObject](../../doc/models/catalog-object.md) based on the
provided ID and returns the set of successfully deleted IDs in the response.
Deletion is a cascading event such that all children of the targeted object
are also deleted. For example, deleting a [CatalogItem](../../doc/models/catalog-item.md)
will also delete all of its
[CatalogItemVariation](../../doc/models/catalog-item-variation.md) children.

```java
CompletableFuture<DeleteCatalogObjectResponse> deleteCatalogObjectAsync(
    final String objectId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `objectId` | `String` | Template, Required | The ID of the catalog object to be deleted. When an object is deleted, other<br>objects in the graph that depend on that object will be deleted as well (for example, deleting a<br>catalog item will delete its catalog item variations). |

## Response Type

[`DeleteCatalogObjectResponse`](../../doc/models/delete-catalog-object-response.md)

## Example Usage

```java
String objectId = "object_id8";

catalogApi.deleteCatalogObjectAsync(objectId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Catalog Object

Returns a single [CatalogItem](../../doc/models/catalog-item.md) as a
[CatalogObject](../../doc/models/catalog-object.md) based on the provided ID. The returned
object includes all of the relevant [CatalogItem](../../doc/models/catalog-item.md)
information including: [CatalogItemVariation](../../doc/models/catalog-item-variation.md)
children, references to its
[CatalogModifierList](../../doc/models/catalog-modifier-list.md) objects, and the ids of
any [CatalogTax](../../doc/models/catalog-tax.md) objects that apply to it.

```java
CompletableFuture<RetrieveCatalogObjectResponse> retrieveCatalogObjectAsync(
    final String objectId,
    final Boolean includeRelatedObjects,
    final Long catalogVersion)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `objectId` | `String` | Template, Required | The object ID of any type of catalog objects to be retrieved. |
| `includeRelatedObjects` | `Boolean` | Query, Optional | If `true`, the response will include additional objects that are related to the<br>requested objects. Related objects are defined as any objects referenced by ID by the results in the `objects` field<br>of the response. These objects are put in the `related_objects` field. Setting this to `true` is<br>helpful when the objects are needed for immediate display to a user.<br>This process only goes one level deep. Objects referenced by the related objects will not be included. For example,<br><br>if the `objects` field of the response contains a CatalogItem, its associated<br>CatalogCategory objects, CatalogTax objects, CatalogImage objects and<br>CatalogModifierLists will be returned in the `related_objects` field of the<br>response. If the `objects` field of the response contains a CatalogItemVariation,<br>its parent CatalogItem will be returned in the `related_objects` field of<br>the response.<br><br>Default value: `false`<br>**Default**: `false` |
| `catalogVersion` | `Long` | Query, Optional | Requests objects as of a specific version of the catalog. This allows you to retrieve historical<br>versions of objects. The value to retrieve a specific version of an object can be found<br>in the version field of [CatalogObject](../../doc/models/catalog-object.md)s. If not included, results will<br>be from the current version of the catalog. |

## Response Type

[`RetrieveCatalogObjectResponse`](../../doc/models/retrieve-catalog-object-response.md)

## Example Usage

```java
String objectId = "object_id8";
Boolean includeRelatedObjects = false;

catalogApi.retrieveCatalogObjectAsync(objectId, includeRelatedObjects, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Catalog Objects

Searches for [CatalogObject](../../doc/models/catalog-object.md) of any type by matching supported search attribute values,
excluding custom attribute values on items or item variations, against one or more of the specified query filters.

This (`SearchCatalogObjects`) endpoint differs from the [SearchCatalogItems](../../doc/api/catalog.md#search-catalog-items)
endpoint in the following aspects:

- `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
- `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
- `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
- The both endpoints have different call conventions, including the query filter formats.

```java
CompletableFuture<SearchCatalogObjectsResponse> searchCatalogObjectsAsync(
    final SearchCatalogObjectsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCatalogObjectsRequest`](../../doc/models/search-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchCatalogObjectsResponse`](../../doc/models/search-catalog-objects-response.md)

## Example Usage

```java
List<String> bodyObjectTypes = new LinkedList<>();
bodyObjectTypes.add("ITEM");
CatalogQueryPrefix catalogQueryPrefix = new CatalogQueryPrefix.Builder(
        "name",
        "tea")
    .build();
CatalogQuery catalogQuery = new CatalogQuery.Builder()
    .prefixQuery(catalogQueryPrefixQuery)
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


# Search Catalog Items

Searches for catalog items or item variations by matching supported search attribute values, including
custom attribute values, against one or more of the specified query filters.

This (`SearchCatalogItems`) endpoint differs from the [SearchCatalogObjects](../../doc/api/catalog.md#search-catalog-objects)
endpoint in the following aspects:

- `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
- `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
- `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
- The both endpoints use different call conventions, including the query filter formats.

```java
CompletableFuture<SearchCatalogItemsResponse> searchCatalogItemsAsync(
    final SearchCatalogItemsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCatalogItemsRequest`](../../doc/models/search-catalog-items-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchCatalogItemsResponse`](../../doc/models/search-catalog-items-response.md)

## Example Usage

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

Range range = new Range.Builder()
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


# Update Item Modifier Lists

Updates the [CatalogModifierList](../../doc/models/catalog-modifier-list.md) objects
that apply to the targeted [CatalogItem](../../doc/models/catalog-item.md) without having
to perform an upsert on the entire item.

```java
CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
    final UpdateItemModifierListsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateItemModifierListsRequest`](../../doc/models/update-item-modifier-lists-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateItemModifierListsResponse`](../../doc/models/update-item-modifier-lists-response.md)

## Example Usage

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


# Update Item Taxes

Updates the [CatalogTax](../../doc/models/catalog-tax.md) objects that apply to the
targeted [CatalogItem](../../doc/models/catalog-item.md) without having to perform an
upsert on the entire item.

```java
CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
    final UpdateItemTaxesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateItemTaxesRequest`](../../doc/models/update-item-taxes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateItemTaxesResponse`](../../doc/models/update-item-taxes-response.md)

## Example Usage

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

