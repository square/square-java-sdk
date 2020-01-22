# V1 Items

```java
V1ItemsApi v1ItemsApi = client.getV1ItemsApi();
```

## Class Name

`V1ItemsApi`

## Methods

* [List Categories](/doc/v1-items.md#list-categories)
* [Create Category](/doc/v1-items.md#create-category)
* [Delete Category](/doc/v1-items.md#delete-category)
* [Update Category](/doc/v1-items.md#update-category)
* [List Discounts](/doc/v1-items.md#list-discounts)
* [Create Discount](/doc/v1-items.md#create-discount)
* [Delete Discount](/doc/v1-items.md#delete-discount)
* [Update Discount](/doc/v1-items.md#update-discount)
* [List Fees](/doc/v1-items.md#list-fees)
* [Create Fee](/doc/v1-items.md#create-fee)
* [Delete Fee](/doc/v1-items.md#delete-fee)
* [Update Fee](/doc/v1-items.md#update-fee)
* [List Inventory](/doc/v1-items.md#list-inventory)
* [Adjust Inventory](/doc/v1-items.md#adjust-inventory)
* [List Items](/doc/v1-items.md#list-items)
* [Create Item](/doc/v1-items.md#create-item)
* [Delete Item](/doc/v1-items.md#delete-item)
* [Retrieve Item](/doc/v1-items.md#retrieve-item)
* [Update Item](/doc/v1-items.md#update-item)
* [Remove Fee](/doc/v1-items.md#remove-fee)
* [Apply Fee](/doc/v1-items.md#apply-fee)
* [Remove Modifier List](/doc/v1-items.md#remove-modifier-list)
* [Apply Modifier List](/doc/v1-items.md#apply-modifier-list)
* [Create Variation](/doc/v1-items.md#create-variation)
* [Delete Variation](/doc/v1-items.md#delete-variation)
* [Update Variation](/doc/v1-items.md#update-variation)
* [List Modifier Lists](/doc/v1-items.md#list-modifier-lists)
* [Create Modifier List](/doc/v1-items.md#create-modifier-list)
* [Delete Modifier List](/doc/v1-items.md#delete-modifier-list)
* [Retrieve Modifier List](/doc/v1-items.md#retrieve-modifier-list)
* [Update Modifier List](/doc/v1-items.md#update-modifier-list)
* [Create Modifier Option](/doc/v1-items.md#create-modifier-option)
* [Delete Modifier Option](/doc/v1-items.md#delete-modifier-option)
* [Update Modifier Option](/doc/v1-items.md#update-modifier-option)
* [List Pages](/doc/v1-items.md#list-pages)
* [Create Page](/doc/v1-items.md#create-page)
* [Delete Page](/doc/v1-items.md#delete-page)
* [Update Page](/doc/v1-items.md#update-page)
* [Delete Page Cell](/doc/v1-items.md#delete-page-cell)
* [Update Page Cell](/doc/v1-items.md#update-page-cell)

## List Categories

Lists all the item categories for a given location.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1Category>> listCategoriesAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list categories for. |

### Response Type

[`List<V1Category>`](/doc/models/v1-category.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listCategoriesAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Category

Creates an item category.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Category> createCategoryAsync(
    final String locationId,
    final V1Category body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to create an item for. |
| `body` | [`V1Category`](/doc/models/v1-category.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Category`](/doc/models/v1-category.md)

### Example Usage

```java
String locationId = "location_id4";
V1Category body = new V1Category.Builder()
    .build();

v1ItemsApi.createCategoryAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Category

Deletes an existing item category.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteCategory__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeleteCategoryRequest` object
as documented below.

```java
CompletableFuture<V1Category> deleteCategoryAsync(
    final String locationId,
    final String categoryId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `categoryId` | `String` | Template, Required | The ID of the category to delete. |

### Response Type

[`V1Category`](/doc/models/v1-category.md)

### Example Usage

```java
String locationId = "location_id4";
String categoryId = "category_id8";

v1ItemsApi.deleteCategoryAsync(locationId, categoryId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Category

Modifies the details of an existing item category.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Category> updateCategoryAsync(
    final String locationId,
    final String categoryId,
    final V1Category body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the category's associated location. |
| `categoryId` | `String` | Template, Required | The ID of the category to edit. |
| `body` | [`V1Category`](/doc/models/v1-category.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Category`](/doc/models/v1-category.md)

### Example Usage

```java
String locationId = "location_id4";
String categoryId = "category_id8";
V1Category body = new V1Category.Builder()
    .build();

v1ItemsApi.updateCategoryAsync(locationId, categoryId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Discounts

Lists all the discounts for a given location.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1Discount>> listDiscountsAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list categories for. |

### Response Type

[`List<V1Discount>`](/doc/models/v1-discount.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listDiscountsAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Discount

Creates a discount.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Discount> createDiscountAsync(
    final String locationId,
    final V1Discount body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to create an item for. |
| `body` | [`V1Discount`](/doc/models/v1-discount.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Discount`](/doc/models/v1-discount.md)

### Example Usage

```java
String locationId = "location_id4";
V1Discount body = new V1Discount.Builder()
    .build();

v1ItemsApi.createDiscountAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Discount

Deletes an existing discount.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteDiscount__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeleteDiscountRequest` object
as documented below.

```java
CompletableFuture<V1Discount> deleteDiscountAsync(
    final String locationId,
    final String discountId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `discountId` | `String` | Template, Required | The ID of the discount to delete. |

### Response Type

[`V1Discount`](/doc/models/v1-discount.md)

### Example Usage

```java
String locationId = "location_id4";
String discountId = "discount_id8";

v1ItemsApi.deleteDiscountAsync(locationId, discountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Discount

Modifies the details of an existing discount.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Discount> updateDiscountAsync(
    final String locationId,
    final String discountId,
    final V1Discount body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the category's associated location. |
| `discountId` | `String` | Template, Required | The ID of the discount to edit. |
| `body` | [`V1Discount`](/doc/models/v1-discount.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Discount`](/doc/models/v1-discount.md)

### Example Usage

```java
String locationId = "location_id4";
String discountId = "discount_id8";
V1Discount body = new V1Discount.Builder()
    .build();

v1ItemsApi.updateDiscountAsync(locationId, discountId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Fees

Lists all the fees (taxes) for a given location.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1Fee>> listFeesAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list fees for. |

### Response Type

[`List<V1Fee>`](/doc/models/v1-fee.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listFeesAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Fee

Creates a fee (tax).

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Fee> createFeeAsync(
    final String locationId,
    final V1Fee body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to create a fee for. |
| `body` | [`V1Fee`](/doc/models/v1-fee.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Fee`](/doc/models/v1-fee.md)

### Example Usage

```java
String locationId = "location_id4";
V1Fee body = new V1Fee.Builder()
    .build();

v1ItemsApi.createFeeAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Fee

Deletes an existing fee (tax).

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteFee__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeleteFeeRequest` object
as documented below.

```java
CompletableFuture<V1Fee> deleteFeeAsync(
    final String locationId,
    final String feeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the fee's associated location. |
| `feeId` | `String` | Template, Required | The ID of the fee to delete. |

### Response Type

[`V1Fee`](/doc/models/v1-fee.md)

### Example Usage

```java
String locationId = "location_id4";
String feeId = "fee_id8";

v1ItemsApi.deleteFeeAsync(locationId, feeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Fee

Modifies the details of an existing fee (tax).

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Fee> updateFeeAsync(
    final String locationId,
    final String feeId,
    final V1Fee body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the fee's associated location. |
| `feeId` | `String` | Template, Required | The ID of the fee to edit. |
| `body` | [`V1Fee`](/doc/models/v1-fee.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Fee`](/doc/models/v1-fee.md)

### Example Usage

```java
String locationId = "location_id4";
String feeId = "fee_id8";
V1Fee body = new V1Fee.Builder()
    .build();

v1ItemsApi.updateFeeAsync(locationId, feeId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Inventory

Provides inventory information for all inventory-enabled item
variations.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1InventoryEntry>> listInventoryAsync(
    final String locationId,
    final Integer limit,
    final String batchToken)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `limit` | `Integer` | Query, Optional | The maximum number of inventory entries to return in a single response. This value cannot exceed 1000. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

### Response Type

[`List<V1InventoryEntry>`](/doc/models/v1-inventory-entry.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listInventoryAsync(locationId, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Adjust Inventory

Adjusts the current available inventory of an item variation.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1InventoryEntry> adjustInventoryAsync(
    final String locationId,
    final String variationId,
    final V1AdjustInventoryRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `variationId` | `String` | Template, Required | The ID of the variation to adjust inventory information for. |
| `body` | [`V1AdjustInventoryRequest`](/doc/models/v1-adjust-inventory-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1InventoryEntry`](/doc/models/v1-inventory-entry.md)

### Example Usage

```java
String locationId = "location_id4";
String variationId = "variation_id2";
V1AdjustInventoryRequest body = new V1AdjustInventoryRequest.Builder()
    .build();

v1ItemsApi.adjustInventoryAsync(locationId, variationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Items

Provides summary information of all items for a given location.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1Item>> listItemsAsync(
    final String locationId,
    final String batchToken)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list items for. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

### Response Type

[`List<V1Item>`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listItemsAsync(locationId, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Item

Creates an item and at least one variation for it.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---


Item-related entities include fields you can use to associate them with
entities in a non-Square system.

When you create an item-related entity, you can optionally specify `id`.
This value must be unique among all IDs ever specified for the account,
including those specified by other applications. You can never reuse an
entity ID. If you do not specify an ID, Square generates one for the entity.

Item variations have a `user_data` string that lets you associate arbitrary
metadata with the variation. The string cannot exceed 255 characters.

```java
CompletableFuture<V1Item> createItemAsync(
    final String locationId,
    final V1Item body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to create an item for. |
| `body` | [`V1Item`](/doc/models/v1-item.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
V1Item body = new V1Item.Builder()
    .build();

v1ItemsApi.createItemAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Item

Deletes an existing item and all item variations associated with it.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteItem__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeleteItemRequest` object
as documented below.

```java
CompletableFuture<V1Item> deleteItemAsync(
    final String locationId,
    final String itemId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `itemId` | `String` | Template, Required | The ID of the item to modify. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";

v1ItemsApi.deleteItemAsync(locationId, itemId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Item

Provides the details for a single item, including associated modifier
lists and fees.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Item> retrieveItemAsync(
    final String locationId,
    final String itemId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `itemId` | `String` | Template, Required | The item's ID. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";

v1ItemsApi.retrieveItemAsync(locationId, itemId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Item

Modifies the core details of an existing item.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Item> updateItemAsync(
    final String locationId,
    final String itemId,
    final V1Item body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `itemId` | `String` | Template, Required | The ID of the item to modify. |
| `body` | [`V1Item`](/doc/models/v1-item.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";
V1Item body = new V1Item.Builder()
    .build();

v1ItemsApi.updateItemAsync(locationId, itemId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Remove Fee

Removes a fee assocation from an item so the fee is no longer
automatically applied to the item in Square Point of Sale.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Item> removeFeeAsync(
    final String locationId,
    final String itemId,
    final String feeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the fee's associated location. |
| `itemId` | `String` | Template, Required | The ID of the item to add the fee to. |
| `feeId` | `String` | Template, Required | The ID of the fee to apply. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";
String feeId = "fee_id8";

v1ItemsApi.removeFeeAsync(locationId, itemId, feeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Apply Fee

Associates a fee with an item so the fee is automatically applied to
the item in Square Point of Sale.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Item> applyFeeAsync(
    final String locationId,
    final String itemId,
    final String feeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the fee's associated location. |
| `itemId` | `String` | Template, Required | The ID of the item to add the fee to. |
| `feeId` | `String` | Template, Required | The ID of the fee to apply. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";
String feeId = "fee_id8";

v1ItemsApi.applyFeeAsync(locationId, itemId, feeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Remove Modifier List

Removes a modifier list association from an item so the modifier
options from the list can no longer be applied to the item.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Item> removeModifierListAsync(
    final String locationId,
    final String modifierListId,
    final String itemId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to remove. |
| `itemId` | `String` | Template, Required | The ID of the item to remove the modifier list from. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";
String itemId = "item_id0";

v1ItemsApi.removeModifierListAsync(locationId, modifierListId, itemId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Apply Modifier List

Associates a modifier list with an item so the associated modifier
options can be applied to the item.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Item> applyModifierListAsync(
    final String locationId,
    final String modifierListId,
    final String itemId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to apply. |
| `itemId` | `String` | Template, Required | The ID of the item to add the modifier list to. |

### Response Type

[`V1Item`](/doc/models/v1-item.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";
String itemId = "item_id0";

v1ItemsApi.applyModifierListAsync(locationId, modifierListId, itemId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Variation

Creates an item variation for an existing item.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Variation> createVariationAsync(
    final String locationId,
    final String itemId,
    final V1Variation body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `itemId` | `String` | Template, Required | The item's ID. |
| `body` | [`V1Variation`](/doc/models/v1-variation.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Variation`](/doc/models/v1-variation.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";
V1Variation body = new V1Variation.Builder()
    .build();

v1ItemsApi.createVariationAsync(locationId, itemId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Variation

Deletes an existing item variation from an item.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteVariation__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeleteVariationRequest` object
as documented below.

```java
CompletableFuture<V1Variation> deleteVariationAsync(
    final String locationId,
    final String itemId,
    final String variationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `itemId` | `String` | Template, Required | The ID of the item to delete. |
| `variationId` | `String` | Template, Required | The ID of the variation to delete. |

### Response Type

[`V1Variation`](/doc/models/v1-variation.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";
String variationId = "variation_id2";

v1ItemsApi.deleteVariationAsync(locationId, itemId, variationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Variation

Modifies the details of an existing item variation.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Variation> updateVariationAsync(
    final String locationId,
    final String itemId,
    final String variationId,
    final V1Variation body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `itemId` | `String` | Template, Required | The ID of the item to modify. |
| `variationId` | `String` | Template, Required | The ID of the variation to modify. |
| `body` | [`V1Variation`](/doc/models/v1-variation.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Variation`](/doc/models/v1-variation.md)

### Example Usage

```java
String locationId = "location_id4";
String itemId = "item_id0";
String variationId = "variation_id2";
V1Variation body = new V1Variation.Builder()
    .build();

v1ItemsApi.updateVariationAsync(locationId, itemId, variationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Modifier Lists

Lists all the modifier lists for a given location.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1ModifierList>> listModifierListsAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list modifier lists for. |

### Response Type

[`List<V1ModifierList>`](/doc/models/v1-modifier-list.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listModifierListsAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Modifier List

Creates an item modifier list and at least 1 modifier option for it.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1ModifierList> createModifierListAsync(
    final String locationId,
    final V1ModifierList body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to create a modifier list for. |
| `body` | [`V1ModifierList`](/doc/models/v1-modifier-list.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1ModifierList`](/doc/models/v1-modifier-list.md)

### Example Usage

```java
String locationId = "location_id4";
V1ModifierList body = new V1ModifierList.Builder()
    .build();

v1ItemsApi.createModifierListAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Modifier List

Deletes an existing item modifier list and all modifier options
associated with it.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteModifierList__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeleteModifierListRequest` object
as documented below.

```java
CompletableFuture<V1ModifierList> deleteModifierListAsync(
    final String locationId,
    final String modifierListId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to delete. |

### Response Type

[`V1ModifierList`](/doc/models/v1-modifier-list.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";

v1ItemsApi.deleteModifierListAsync(locationId, modifierListId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Modifier List

Provides the details for a single modifier list.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1ModifierList> retrieveModifierListAsync(
    final String locationId,
    final String modifierListId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The modifier list's ID. |

### Response Type

[`V1ModifierList`](/doc/models/v1-modifier-list.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";

v1ItemsApi.retrieveModifierListAsync(locationId, modifierListId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Modifier List

Modifies the details of an existing item modifier list.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1ModifierList> updateModifierListAsync(
    final String locationId,
    final String modifierListId,
    final V1UpdateModifierListRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to edit. |
| `body` | [`V1UpdateModifierListRequest`](/doc/models/v1-update-modifier-list-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1ModifierList`](/doc/models/v1-modifier-list.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";
V1UpdateModifierListRequest body = new V1UpdateModifierListRequest.Builder()
    .build();

v1ItemsApi.updateModifierListAsync(locationId, modifierListId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Modifier Option

Creates an item modifier option and adds it to a modifier list.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1ModifierOption> createModifierOptionAsync(
    final String locationId,
    final String modifierListId,
    final V1ModifierOption body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to edit. |
| `body` | [`V1ModifierOption`](/doc/models/v1-modifier-option.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1ModifierOption`](/doc/models/v1-modifier-option.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";
V1ModifierOption body = new V1ModifierOption.Builder()
    .build();

v1ItemsApi.createModifierOptionAsync(locationId, modifierListId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Modifier Option

Deletes an existing item modifier option from a modifier list.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeleteModifierOption__ returns nothing on success but Connect
SDKs map the empty response to an empty `V1DeleteModifierOptionRequest`
object.

```java
CompletableFuture<V1ModifierOption> deleteModifierOptionAsync(
    final String locationId,
    final String modifierListId,
    final String modifierOptionId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to delete. |
| `modifierOptionId` | `String` | Template, Required | The ID of the modifier list to edit. |

### Response Type

[`V1ModifierOption`](/doc/models/v1-modifier-option.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";
String modifierOptionId = "modifier_option_id6";

v1ItemsApi.deleteModifierOptionAsync(locationId, modifierListId, modifierOptionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Modifier Option

Modifies the details of an existing item modifier option.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1ModifierOption> updateModifierOptionAsync(
    final String locationId,
    final String modifierListId,
    final String modifierOptionId,
    final V1ModifierOption body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the item's associated location. |
| `modifierListId` | `String` | Template, Required | The ID of the modifier list to edit. |
| `modifierOptionId` | `String` | Template, Required | The ID of the modifier list to edit. |
| `body` | [`V1ModifierOption`](/doc/models/v1-modifier-option.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1ModifierOption`](/doc/models/v1-modifier-option.md)

### Example Usage

```java
String locationId = "location_id4";
String modifierListId = "modifier_list_id6";
String modifierOptionId = "modifier_option_id6";
V1ModifierOption body = new V1ModifierOption.Builder()
    .build();

v1ItemsApi.updateModifierOptionAsync(locationId, modifierListId, modifierOptionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Pages

Lists all Favorites pages (in Square Point of Sale) for a given
location.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<List<V1Page>> listPagesAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list Favorites pages for. |

### Response Type

[`List<V1Page>`](/doc/models/v1-page.md)

### Example Usage

```java
String locationId = "location_id4";

v1ItemsApi.listPagesAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Page

Creates a Favorites page in Square Point of Sale.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Page> createPageAsync(
    final String locationId,
    final V1Page body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to create an item for. |
| `body` | [`V1Page`](/doc/models/v1-page.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Page`](/doc/models/v1-page.md)

### Example Usage

```java
String locationId = "location_id4";
V1Page body = new V1Page.Builder()
    .build();

v1ItemsApi.createPageAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Page

Deletes an existing Favorites page and all of its cells.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeletePage__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeletePageRequest` object.

```java
CompletableFuture<V1Page> deletePageAsync(
    final String locationId,
    final String pageId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the Favorites page's associated location. |
| `pageId` | `String` | Template, Required | The ID of the page to delete. |

### Response Type

[`V1Page`](/doc/models/v1-page.md)

### Example Usage

```java
String locationId = "location_id4";
String pageId = "page_id0";

v1ItemsApi.deletePageAsync(locationId, pageId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Page

Modifies the details of a Favorites page in Square Point of Sale.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Page> updatePageAsync(
    final String locationId,
    final String pageId,
    final V1Page body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the Favorites page's associated location |
| `pageId` | `String` | Template, Required | The ID of the page to modify. |
| `body` | [`V1Page`](/doc/models/v1-page.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Page`](/doc/models/v1-page.md)

### Example Usage

```java
String locationId = "location_id4";
String pageId = "page_id0";
V1Page body = new V1Page.Builder()
    .build();

v1ItemsApi.updatePageAsync(locationId, pageId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Page Cell

Deletes a cell from a Favorites page in Square Point of Sale.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

__DeletePageCell__ returns nothing on success but Connect SDKs
map the empty response to an empty `V1DeletePageCellRequest` object
as documented below.

```java
CompletableFuture<V1Page> deletePageCellAsync(
    final String locationId,
    final String pageId,
    final String row,
    final String column)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the Favorites page's associated location. |
| `pageId` | `String` | Template, Required | The ID of the page to delete. |
| `row` | `String` | Query, Optional | The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top row. |
| `column` | `String` | Query, Optional | The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is the leftmost column. |

### Response Type

[`V1Page`](/doc/models/v1-page.md)

### Example Usage

```java
String locationId = "location_id4";
String pageId = "page_id0";

v1ItemsApi.deletePageCellAsync(locationId, pageId, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Page Cell

Modifies a cell of a Favorites page in Square Point of Sale.

---

- __Deprecation date__: 2019-11-20
- [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
- [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)

---

```java
CompletableFuture<V1Page> updatePageCellAsync(
    final String locationId,
    final String pageId,
    final V1PageCell body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the Favorites page's associated location. |
| `pageId` | `String` | Template, Required | The ID of the page the cell belongs to. |
| `body` | [`V1PageCell`](/doc/models/v1-page-cell.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Page`](/doc/models/v1-page.md)

### Example Usage

```java
String locationId = "location_id4";
String pageId = "page_id0";
V1PageCell body = new V1PageCell.Builder()
    .build();

v1ItemsApi.updatePageCellAsync(locationId, pageId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

