# Catalog

```java
CatalogApi catalogApi = client.getCatalogApi();
```

## Class Name

`CatalogApi`

## Methods

* [Batch Delete Catalog Objects](/doc/api/catalog.md#batch-delete-catalog-objects)
* [Batch Retrieve Catalog Objects](/doc/api/catalog.md#batch-retrieve-catalog-objects)
* [Batch Upsert Catalog Objects](/doc/api/catalog.md#batch-upsert-catalog-objects)
* [Create Catalog Image](/doc/api/catalog.md#create-catalog-image)
* [Catalog Info](/doc/api/catalog.md#catalog-info)
* [List Catalog](/doc/api/catalog.md#list-catalog)
* [Upsert Catalog Object](/doc/api/catalog.md#upsert-catalog-object)
* [Delete Catalog Object](/doc/api/catalog.md#delete-catalog-object)
* [Retrieve Catalog Object](/doc/api/catalog.md#retrieve-catalog-object)
* [Search Catalog Objects](/doc/api/catalog.md#search-catalog-objects)
* [Search Catalog Items](/doc/api/catalog.md#search-catalog-items)
* [Update Item Modifier Lists](/doc/api/catalog.md#update-item-modifier-lists)
* [Update Item Taxes](/doc/api/catalog.md#update-item-taxes)


# Batch Delete Catalog Objects

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

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchDeleteCatalogObjectsRequest`](/doc/models/batch-delete-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchDeleteCatalogObjectsResponse`](/doc/models/batch-delete-catalog-objects-response.md)

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
Each [CatalogItem](#type-catalogitem) returned in the set includes all of its
child information including: all of its
[CatalogItemVariation](#type-catalogitemvariation) objects, references to
its [CatalogModifierList](#type-catalogmodifierlist) objects, and the ids of
any [CatalogTax](#type-catalogtax) objects that apply to it.

```java
CompletableFuture<BatchRetrieveCatalogObjectsResponse> batchRetrieveCatalogObjectsAsync(
    final BatchRetrieveCatalogObjectsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveCatalogObjectsRequest`](/doc/models/batch-retrieve-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveCatalogObjectsResponse`](/doc/models/batch-retrieve-catalog-objects-response.md)

## Example Usage

```java
List<String> bodyObjectIds = new LinkedList<>();
bodyObjectIds.add("W62UWFY35CWMYGVWK6TWJDNI");
bodyObjectIds.add("AA27W3M2GGTF3H6AVPNB77CK");
BatchRetrieveCatalogObjectsRequest body = new BatchRetrieveCatalogObjectsRequest.Builder(
        bodyObjectIds)
    .includeRelatedObjects(true)
    .catalogVersion(118L)
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
| `body` | [`BatchUpsertCatalogObjectsRequest`](/doc/models/batch-upsert-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchUpsertCatalogObjectsResponse`](/doc/models/batch-upsert-catalog-objects-response.md)

## Example Usage

```java
List<CatalogObjectBatch> bodyBatches = new LinkedList<>();

List<CatalogObject> bodyBatches0Objects = new LinkedList<>();

CatalogCustomAttributeValue bodyBatches0Objects0CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects0CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects0CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id4")
    .locationId("location_id4")
    .build();
bodyBatches0Objects0CatalogV1Ids.add(bodyBatches0Objects0CatalogV1Ids0);

List<String> bodyBatches0Objects0ItemDataTaxIds = new LinkedList<>();
bodyBatches0Objects0ItemDataTaxIds.add("#SalesTax");
List<CatalogObject> bodyBatches0Objects0ItemDataVariations = new LinkedList<>();

CatalogCustomAttributeValue bodyBatches0Objects0ItemDataVariations0CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects0ItemDataVariations0CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects0ItemDataVariations0CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id3")
    .locationId("location_id3")
    .build();
bodyBatches0Objects0ItemDataVariations0CatalogV1Ids.add(bodyBatches0Objects0ItemDataVariations0CatalogV1Ids0);

CatalogItemVariation bodyBatches0Objects0ItemDataVariations0ItemVariationData = new CatalogItemVariation.Builder()
    .itemId("#Tea")
    .name("Mug")
    .sku("sku9")
    .upc("upc7")
    .ordinal(149)
    .pricingType("FIXED_PRICING")
    .build();
CatalogObject bodyBatches0Objects0ItemDataVariations0 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Tea_Mug")
    .updatedAt("updated_at5")
    .version(99L)
    .isDeleted(true)
    .customAttributeValues(bodyBatches0Objects0ItemDataVariations0CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects0ItemDataVariations0CatalogV1Ids)
    .presentAtAllLocations(true)
    .itemVariationData(bodyBatches0Objects0ItemDataVariations0ItemVariationData)
    .build();
bodyBatches0Objects0ItemDataVariations.add(bodyBatches0Objects0ItemDataVariations0);

CatalogItem bodyBatches0Objects0ItemData = new CatalogItem.Builder()
    .name("Tea")
    .description("Hot Leaf Juice")
    .abbreviation("abbreviation0")
    .labelColor("label_color0")
    .availableOnline(false)
    .categoryId("#Beverages")
    .taxIds(bodyBatches0Objects0ItemDataTaxIds)
    .variations(bodyBatches0Objects0ItemDataVariations)
    .build();
CatalogObject bodyBatches0Objects0 = new CatalogObject.Builder(
        "ITEM",
        "#Tea")
    .updatedAt("updated_at6")
    .version(252L)
    .isDeleted(false)
    .customAttributeValues(bodyBatches0Objects0CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects0CatalogV1Ids)
    .presentAtAllLocations(true)
    .itemData(bodyBatches0Objects0ItemData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects0);

CatalogCustomAttributeValue bodyBatches0Objects1CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects1CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects1CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id5")
    .locationId("location_id5")
    .build();
bodyBatches0Objects1CatalogV1Ids.add(bodyBatches0Objects1CatalogV1Ids0);

CatalogV1Id bodyBatches0Objects1CatalogV1Ids1 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id6")
    .locationId("location_id6")
    .build();
bodyBatches0Objects1CatalogV1Ids.add(bodyBatches0Objects1CatalogV1Ids1);

List<String> bodyBatches0Objects1ItemDataTaxIds = new LinkedList<>();
bodyBatches0Objects1ItemDataTaxIds.add("#SalesTax");
List<CatalogObject> bodyBatches0Objects1ItemDataVariations = new LinkedList<>();

CatalogCustomAttributeValue bodyBatches0Objects1ItemDataVariations0CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects1ItemDataVariations0CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects1ItemDataVariations0CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id4")
    .locationId("location_id4")
    .build();
bodyBatches0Objects1ItemDataVariations0CatalogV1Ids.add(bodyBatches0Objects1ItemDataVariations0CatalogV1Ids0);

CatalogV1Id bodyBatches0Objects1ItemDataVariations0CatalogV1Ids1 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id5")
    .locationId("location_id5")
    .build();
bodyBatches0Objects1ItemDataVariations0CatalogV1Ids.add(bodyBatches0Objects1ItemDataVariations0CatalogV1Ids1);

CatalogItemVariation bodyBatches0Objects1ItemDataVariations0ItemVariationData = new CatalogItemVariation.Builder()
    .itemId("#Coffee")
    .name("Regular")
    .sku("sku8")
    .upc("upc6")
    .ordinal(150)
    .pricingType("FIXED_PRICING")
    .build();
CatalogObject bodyBatches0Objects1ItemDataVariations0 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Coffee_Regular")
    .updatedAt("updated_at4")
    .version(100L)
    .isDeleted(false)
    .customAttributeValues(bodyBatches0Objects1ItemDataVariations0CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects1ItemDataVariations0CatalogV1Ids)
    .presentAtAllLocations(true)
    .itemVariationData(bodyBatches0Objects1ItemDataVariations0ItemVariationData)
    .build();
bodyBatches0Objects1ItemDataVariations.add(bodyBatches0Objects1ItemDataVariations0);

CatalogCustomAttributeValue bodyBatches0Objects1ItemDataVariations1CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects1ItemDataVariations1CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects1ItemDataVariations1CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id5")
    .locationId("location_id5")
    .build();
bodyBatches0Objects1ItemDataVariations1CatalogV1Ids.add(bodyBatches0Objects1ItemDataVariations1CatalogV1Ids0);

CatalogV1Id bodyBatches0Objects1ItemDataVariations1CatalogV1Ids1 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id6")
    .locationId("location_id6")
    .build();
bodyBatches0Objects1ItemDataVariations1CatalogV1Ids.add(bodyBatches0Objects1ItemDataVariations1CatalogV1Ids1);

CatalogV1Id bodyBatches0Objects1ItemDataVariations1CatalogV1Ids2 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id7")
    .locationId("location_id7")
    .build();
bodyBatches0Objects1ItemDataVariations1CatalogV1Ids.add(bodyBatches0Objects1ItemDataVariations1CatalogV1Ids2);

CatalogItemVariation bodyBatches0Objects1ItemDataVariations1ItemVariationData = new CatalogItemVariation.Builder()
    .itemId("#Coffee")
    .name("Large")
    .sku("sku7")
    .upc("upc5")
    .ordinal(151)
    .pricingType("FIXED_PRICING")
    .build();
CatalogObject bodyBatches0Objects1ItemDataVariations1 = new CatalogObject.Builder(
        "ITEM_VARIATION",
        "#Coffee_Large")
    .updatedAt("updated_at3")
    .version(101L)
    .isDeleted(true)
    .customAttributeValues(bodyBatches0Objects1ItemDataVariations1CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects1ItemDataVariations1CatalogV1Ids)
    .presentAtAllLocations(true)
    .itemVariationData(bodyBatches0Objects1ItemDataVariations1ItemVariationData)
    .build();
bodyBatches0Objects1ItemDataVariations.add(bodyBatches0Objects1ItemDataVariations1);

CatalogItem bodyBatches0Objects1ItemData = new CatalogItem.Builder()
    .name("Coffee")
    .description("Hot Bean Juice")
    .abbreviation("abbreviation9")
    .labelColor("label_color9")
    .availableOnline(true)
    .categoryId("#Beverages")
    .taxIds(bodyBatches0Objects1ItemDataTaxIds)
    .variations(bodyBatches0Objects1ItemDataVariations)
    .build();
CatalogObject bodyBatches0Objects1 = new CatalogObject.Builder(
        "ITEM",
        "#Coffee")
    .updatedAt("updated_at7")
    .version(253L)
    .isDeleted(true)
    .customAttributeValues(bodyBatches0Objects1CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects1CatalogV1Ids)
    .presentAtAllLocations(true)
    .itemData(bodyBatches0Objects1ItemData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects1);

CatalogCustomAttributeValue bodyBatches0Objects2CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects2CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects2CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id6")
    .locationId("location_id6")
    .build();
bodyBatches0Objects2CatalogV1Ids.add(bodyBatches0Objects2CatalogV1Ids0);

CatalogV1Id bodyBatches0Objects2CatalogV1Ids1 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id7")
    .locationId("location_id7")
    .build();
bodyBatches0Objects2CatalogV1Ids.add(bodyBatches0Objects2CatalogV1Ids1);

CatalogV1Id bodyBatches0Objects2CatalogV1Ids2 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id8")
    .locationId("location_id8")
    .build();
bodyBatches0Objects2CatalogV1Ids.add(bodyBatches0Objects2CatalogV1Ids2);

CatalogCategory bodyBatches0Objects2CategoryData = new CatalogCategory.Builder()
    .name("Beverages")
    .build();
CatalogObject bodyBatches0Objects2 = new CatalogObject.Builder(
        "CATEGORY",
        "#Beverages")
    .updatedAt("updated_at8")
    .version(254L)
    .isDeleted(false)
    .customAttributeValues(bodyBatches0Objects2CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects2CatalogV1Ids)
    .presentAtAllLocations(true)
    .categoryData(bodyBatches0Objects2CategoryData)
    .build();
bodyBatches0Objects.add(bodyBatches0Objects2);

CatalogCustomAttributeValue bodyBatches0Objects3CustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyBatches0Objects3CatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyBatches0Objects3CatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id7")
    .locationId("location_id7")
    .build();
bodyBatches0Objects3CatalogV1Ids.add(bodyBatches0Objects3CatalogV1Ids0);

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
    .updatedAt("updated_at9")
    .version(255L)
    .isDeleted(true)
    .customAttributeValues(bodyBatches0Objects3CustomAttributeValues)
    .catalogV1Ids(bodyBatches0Objects3CatalogV1Ids)
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


# Create Catalog Image

Uploads an image file to be represented by a [CatalogImage](#type-catalogimage) object linked to an existing
[CatalogObject](#type-catalogobject) instance. A call to this endpoint can upload an image, link an image to
a catalog object, or do both.

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
| `request` | [`CreateCatalogImageRequest`](/doc/models/create-catalog-image-request.md) | Form, Optional | - |
| `imageFile` | `FileWrapper` | Form, Optional | - |

## Response Type

[`CreateCatalogImageResponse`](/doc/models/create-catalog-image-response.md)

## Example Usage

```java
CatalogCustomAttributeValue requestImageCustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> requestImageCatalogV1Ids = new LinkedList<>();

CatalogV1Id requestImageCatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id4")
    .locationId("location_id4")
    .build();
requestImageCatalogV1Ids.add(requestImageCatalogV1Ids0);

CatalogImage requestImageImageData = new CatalogImage.Builder()
    .name("name0")
    .url("url4")
    .caption("A picture of a cup of coffee")
    .build();
CatalogObject requestImage = new CatalogObject.Builder(
        "IMAGE",
        "#TEMP_ID")
    .updatedAt("updated_at4")
    .version(68L)
    .isDeleted(false)
    .customAttributeValues(requestImageCustomAttributeValues)
    .catalogV1Ids(requestImageCatalogV1Ids)
    .imageData(requestImageImageData)
    .build();
CreateCatalogImageRequest request = new CreateCatalogImageRequest.Builder(
        "528dea59-7bfb-43c1-bd48-4a6bba7dd61f86")
    .objectId("ND6EA5AAJEO5WL3JNNIAQA32")
    .image(requestImage)
    .build();
FileWrapper imageFile = new FileWrapper(new File("dummy_file"), "optional-content-type");

catalogApi.createCatalogImageAsync(request, imageFile).thenAccept(result -> {
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

[`CatalogInfoResponse`](/doc/models/catalog-info-response.md)

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

Returns a list of [CatalogObject](#type-catalogobject)s that includes
all objects of a set of desired types (for example, all [CatalogItem](#type-catalogitem)
and [CatalogTax](#type-catalogtax) objects) in the catalog. The `types` parameter
is specified as a comma-separated list of valid [CatalogObject](#type-catalogobject) types:
`ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`.

__Important:__ ListCatalog does not return deleted catalog items. To retrieve
deleted catalog items, use [SearchCatalogObjects](#endpoint-Catalog-SearchCatalogObjects)
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
| `cursor` | `String` | Query, Optional | The pagination cursor returned in the previous response. Leave unset for an initial request.<br>See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information. |
| `types` | `String` | Query, Optional | An optional case-insensitive, comma-separated list of object types to retrieve, for example<br>`ITEM,ITEM_VARIATION,CATEGORY,IMAGE`.<br><br>The legal values are taken from the CatalogObjectType enum:<br>`ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`,<br>`MODIFIER`, `MODIFIER_LIST`, or `IMAGE`. |
| `catalogVersion` | `Long` | Query, Optional | The specific version of the catalog objects to be included in the response.<br>This allows you to retrieve historical<br>versions of objects. The specified version value is matched against<br>the [CatalogObject](#type-catalogobject)s' `version` attribute. |

## Response Type

[`ListCatalogResponse`](/doc/models/list-catalog-response.md)

## Example Usage

```java
String cursor = "cursor6";
String types = "types6";
Long catalogVersion = 126L;

catalogApi.listCatalogAsync(cursor, types, catalogVersion).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Upsert Catalog Object

Creates or updates the target [CatalogObject](#type-catalogobject).

```java
CompletableFuture<UpsertCatalogObjectResponse> upsertCatalogObjectAsync(
    final UpsertCatalogObjectRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpsertCatalogObjectRequest`](/doc/models/upsert-catalog-object-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpsertCatalogObjectResponse`](/doc/models/upsert-catalog-object-response.md)

## Example Usage

```java
CatalogCustomAttributeValue bodyObjectCustomAttributeValues = new CatalogCustomAttributeValue.Builder()
    .build();
List<CatalogV1Id> bodyObjectCatalogV1Ids = new LinkedList<>();

CatalogV1Id bodyObjectCatalogV1Ids0 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id0")
    .locationId("location_id0")
    .build();
bodyObjectCatalogV1Ids.add(bodyObjectCatalogV1Ids0);

CatalogV1Id bodyObjectCatalogV1Ids1 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id1")
    .locationId("location_id1")
    .build();
bodyObjectCatalogV1Ids.add(bodyObjectCatalogV1Ids1);

CatalogV1Id bodyObjectCatalogV1Ids2 = new CatalogV1Id.Builder()
    .catalogV1Id("catalog_v1_id2")
    .locationId("location_id2")
    .build();
bodyObjectCatalogV1Ids.add(bodyObjectCatalogV1Ids2);

CatalogItem bodyObjectItemData = new CatalogItem.Builder()
    .name("Cocoa")
    .description("Hot chocolate")
    .abbreviation("Ch")
    .labelColor("label_color4")
    .availableOnline(false)
    .build();
CatalogObject bodyObject = new CatalogObject.Builder(
        "ITEM",
        "#Cocoa")
    .updatedAt("updated_at8")
    .version(252L)
    .isDeleted(false)
    .customAttributeValues(bodyObjectCustomAttributeValues)
    .catalogV1Ids(bodyObjectCatalogV1Ids)
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


# Delete Catalog Object

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

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `objectId` | `String` | Template, Required | The ID of the catalog object to be deleted. When an object is deleted, other<br>objects in the graph that depend on that object will be deleted as well (for example, deleting a<br>catalog item will delete its catalog item variations). |

## Response Type

[`DeleteCatalogObjectResponse`](/doc/models/delete-catalog-object-response.md)

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
    final Boolean includeRelatedObjects,
    final Long catalogVersion)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `objectId` | `String` | Template, Required | The object ID of any type of catalog objects to be retrieved. |
| `includeRelatedObjects` | `Boolean` | Query, Optional | If `true`, the response will include additional objects that are related to the<br>requested object, as follows:<br><br>If the `object` field of the response contains a `CatalogItem`, its associated<br>`CatalogCategory`, `CatalogTax`, `CatalogImage` and `CatalogModifierList` objects will<br>be returned in the `related_objects` field of the response. If the `object` field of<br>the response contains a `CatalogItemVariation`, its parent `CatalogItem` will be returned<br>in the `related_objects` field of the response.<br><br>Default value: `false` |
| `catalogVersion` | `Long` | Query, Optional | Requests objects as of a specific version of the catalog. This allows you to retrieve historical<br>versions of objects. The value to retrieve a specific version of an object can be found<br>in the version field of [CatalogObject](#type-catalogobject)s. |

## Response Type

[`RetrieveCatalogObjectResponse`](/doc/models/retrieve-catalog-object-response.md)

## Example Usage

```java
String objectId = "object_id8";
Boolean includeRelatedObjects = false;
Long catalogVersion = 126L;

catalogApi.retrieveCatalogObjectAsync(objectId, includeRelatedObjects, catalogVersion).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Catalog Objects

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

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCatalogObjectsRequest`](/doc/models/search-catalog-objects-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchCatalogObjectsResponse`](/doc/models/search-catalog-objects-response.md)

## Example Usage

```java
List<String> bodyObjectTypes = new LinkedList<>();
bodyObjectTypes.add("ITEM");
CatalogQuerySortedAttribute bodyQuerySortedAttributeQuery = new CatalogQuerySortedAttribute.Builder(
        "attribute_name6")
    .initialAttributeValue("initial_attribute_value4")
    .sortOrder("DESC")
    .build();
CatalogQueryExact bodyQueryExactQuery = new CatalogQueryExact.Builder(
        "attribute_name2",
        "attribute_value2")
    .build();
List<String> bodyQuerySetQueryAttributeValues = new LinkedList<>();
bodyQuerySetQueryAttributeValues.add("attribute_values0");
CatalogQuerySet bodyQuerySetQuery = new CatalogQuerySet.Builder(
        "attribute_name8",
        bodyQuerySetQueryAttributeValues)
    .build();
CatalogQueryPrefix bodyQueryPrefixQuery = new CatalogQueryPrefix.Builder(
        "name",
        "tea")
    .build();
CatalogQueryRange bodyQueryRangeQuery = new CatalogQueryRange.Builder(
        "attribute_name6")
    .attributeMinValue(14L)
    .attributeMaxValue(180L)
    .build();
CatalogQuery bodyQuery = new CatalogQuery.Builder()
    .sortedAttributeQuery(bodyQuerySortedAttributeQuery)
    .exactQuery(bodyQueryExactQuery)
    .setQuery(bodyQuerySetQuery)
    .prefixQuery(bodyQueryPrefixQuery)
    .rangeQuery(bodyQueryRangeQuery)
    .build();
SearchCatalogObjectsRequest body = new SearchCatalogObjectsRequest.Builder()
    .cursor("cursor0")
    .objectTypes(bodyObjectTypes)
    .includeDeletedObjects(false)
    .includeRelatedObjects(false)
    .beginTime("begin_time4")
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

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCatalogItemsRequest`](/doc/models/search-catalog-items-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchCatalogItemsResponse`](/doc/models/search-catalog-items-response.md)

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

Range bodyCustomAttributeFilters0NumberFilter = new Range.Builder()
    .min("min0")
    .max("max2")
    .build();
List<String> bodyCustomAttributeFilters0SelectionUidsFilter = new LinkedList<>();
bodyCustomAttributeFilters0SelectionUidsFilter.add("selection_uids_filter2");
bodyCustomAttributeFilters0SelectionUidsFilter.add("selection_uids_filter3");
CustomAttributeFilter bodyCustomAttributeFilters0 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("VEGAN_DEFINITION_ID")
    .key("key2")
    .stringFilter("string_filter4")
    .numberFilter(bodyCustomAttributeFilters0NumberFilter)
    .selectionUidsFilter(bodyCustomAttributeFilters0SelectionUidsFilter)
    .boolFilter(true)
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters0);

Range bodyCustomAttributeFilters1NumberFilter = new Range.Builder()
    .min("min1")
    .max("max1")
    .build();
List<String> bodyCustomAttributeFilters1SelectionUidsFilter = new LinkedList<>();
bodyCustomAttributeFilters1SelectionUidsFilter.add("selection_uids_filter1");
CustomAttributeFilter bodyCustomAttributeFilters1 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("BRAND_DEFINITION_ID")
    .key("key3")
    .stringFilter("Dark Horse")
    .numberFilter(bodyCustomAttributeFilters1NumberFilter)
    .selectionUidsFilter(bodyCustomAttributeFilters1SelectionUidsFilter)
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters1);

Range bodyCustomAttributeFilters2NumberFilter = new Range.Builder()
    .min("2017")
    .max("2018")
    .build();
List<String> bodyCustomAttributeFilters2SelectionUidsFilter = new LinkedList<>();
bodyCustomAttributeFilters2SelectionUidsFilter.add("selection_uids_filter0");
bodyCustomAttributeFilters2SelectionUidsFilter.add("selection_uids_filter1");
bodyCustomAttributeFilters2SelectionUidsFilter.add("selection_uids_filter2");
CustomAttributeFilter bodyCustomAttributeFilters2 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("custom_attribute_definition_id8")
    .key("VINTAGE")
    .stringFilter("string_filter6")
    .numberFilter(bodyCustomAttributeFilters2NumberFilter)
    .selectionUidsFilter(bodyCustomAttributeFilters2SelectionUidsFilter)
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters2);

Range bodyCustomAttributeFilters3NumberFilter = new Range.Builder()
    .min("min3")
    .max("max9")
    .build();
List<String> bodyCustomAttributeFilters3SelectionUidsFilter = new LinkedList<>();
bodyCustomAttributeFilters3SelectionUidsFilter.add("selection_uids_filter9");
bodyCustomAttributeFilters3SelectionUidsFilter.add("selection_uids_filter0");
CustomAttributeFilter bodyCustomAttributeFilters3 = new CustomAttributeFilter.Builder()
    .customAttributeDefinitionId("VARIETAL_DEFINITION_ID")
    .key("key5")
    .stringFilter("string_filter7")
    .numberFilter(bodyCustomAttributeFilters3NumberFilter)
    .selectionUidsFilter(bodyCustomAttributeFilters3SelectionUidsFilter)
    .build();
bodyCustomAttributeFilters.add(bodyCustomAttributeFilters3);

SearchCatalogItemsRequest body = new SearchCatalogItemsRequest.Builder()
    .textFilter("red")
    .categoryIds(bodyCategoryIds)
    .stockLevels(bodyStockLevels)
    .enabledLocationIds(bodyEnabledLocationIds)
    .cursor("cursor0")
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

Updates the [CatalogModifierList](#type-catalogmodifierlist) objects
that apply to the targeted [CatalogItem](#type-catalogitem) without having
to perform an upsert on the entire item.

```java
CompletableFuture<UpdateItemModifierListsResponse> updateItemModifierListsAsync(
    final UpdateItemModifierListsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateItemModifierListsRequest`](/doc/models/update-item-modifier-lists-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateItemModifierListsResponse`](/doc/models/update-item-modifier-lists-response.md)

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

Updates the [CatalogTax](#type-catalogtax) objects that apply to the
targeted [CatalogItem](#type-catalogitem) without having to perform an
upsert on the entire item.

```java
CompletableFuture<UpdateItemTaxesResponse> updateItemTaxesAsync(
    final UpdateItemTaxesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateItemTaxesRequest`](/doc/models/update-item-taxes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateItemTaxesResponse`](/doc/models/update-item-taxes-response.md)

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

