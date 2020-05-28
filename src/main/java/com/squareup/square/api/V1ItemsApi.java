package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1AdjustInventoryRequest;
import com.squareup.square.models.V1Category;
import com.squareup.square.models.V1Discount;
import com.squareup.square.models.V1Fee;
import com.squareup.square.models.V1InventoryEntry;
import com.squareup.square.models.V1Item;
import com.squareup.square.models.V1ModifierList;
import com.squareup.square.models.V1ModifierOption;
import com.squareup.square.models.V1Page;
import com.squareup.square.models.V1PageCell;
import com.squareup.square.models.V1UpdateModifierListRequest;
import com.squareup.square.models.V1Variation;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface V1ItemsApi {
    /**
     * Lists all the item categories for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Category> response from the API call
     */
    @Deprecated    List<V1Category> listCategories(
            final String locationId) throws ApiException, IOException;

    /**
     * Lists all the item categories for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Category> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1Category>> listCategoriesAsync(
            final String locationId);

    /**
     * Creates an item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated    V1Category createCategory(
            final String locationId,
            final V1Category body) throws ApiException, IOException;

    /**
     * Creates an item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Category> createCategoryAsync(
            final String locationId,
            final V1Category body);

    /**
     * Deletes an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteCategory__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteCategoryRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    categoryId    Required parameter: The ID of the category to delete.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated    V1Category deleteCategory(
            final String locationId,
            final String categoryId) throws ApiException, IOException;

    /**
     * Deletes an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteCategory__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteCategoryRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    categoryId    Required parameter: The ID of the category to delete.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Category> deleteCategoryAsync(
            final String locationId,
            final String categoryId);

    /**
     * Modifies the details of an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    categoryId    Required parameter: The ID of the category to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call
     */
    @Deprecated    V1Category updateCategory(
            final String locationId,
            final String categoryId,
            final V1Category body) throws ApiException, IOException;

    /**
     * Modifies the details of an existing item category.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    categoryId    Required parameter: The ID of the category to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Category response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Category> updateCategoryAsync(
            final String locationId,
            final String categoryId,
            final V1Category body);

    /**
     * Lists all the discounts for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Discount> response from the API call
     */
    @Deprecated    List<V1Discount> listDiscounts(
            final String locationId) throws ApiException, IOException;

    /**
     * Lists all the discounts for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list categories for.
     * @return    Returns the List<V1Discount> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1Discount>> listDiscountsAsync(
            final String locationId);

    /**
     * Creates a discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated    V1Discount createDiscount(
            final String locationId,
            final V1Discount body) throws ApiException, IOException;

    /**
     * Creates a discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Discount> createDiscountAsync(
            final String locationId,
            final V1Discount body);

    /**
     * Deletes an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteDiscount__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteDiscountRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    discountId    Required parameter: The ID of the discount to delete.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated    V1Discount deleteDiscount(
            final String locationId,
            final String discountId) throws ApiException, IOException;

    /**
     * Deletes an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteDiscount__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteDiscountRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    discountId    Required parameter: The ID of the discount to delete.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Discount> deleteDiscountAsync(
            final String locationId,
            final String discountId);

    /**
     * Modifies the details of an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    discountId    Required parameter: The ID of the discount to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call
     */
    @Deprecated    V1Discount updateDiscount(
            final String locationId,
            final String discountId,
            final V1Discount body) throws ApiException, IOException;

    /**
     * Modifies the details of an existing discount.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the category's associated location.
     * @param    discountId    Required parameter: The ID of the discount to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Discount response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Discount> updateDiscountAsync(
            final String locationId,
            final String discountId,
            final V1Discount body);

    /**
     * Lists all the fees (taxes) for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list fees for.
     * @return    Returns the List<V1Fee> response from the API call
     */
    @Deprecated    List<V1Fee> listFees(
            final String locationId) throws ApiException, IOException;

    /**
     * Lists all the fees (taxes) for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list fees for.
     * @return    Returns the List<V1Fee> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1Fee>> listFeesAsync(
            final String locationId);

    /**
     * Creates a fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a fee for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated    V1Fee createFee(
            final String locationId,
            final V1Fee body) throws ApiException, IOException;

    /**
     * Creates a fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a fee for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Fee> createFeeAsync(
            final String locationId,
            final V1Fee body);

    /**
     * Deletes an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteFee__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteFeeRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to delete.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated    V1Fee deleteFee(
            final String locationId,
            final String feeId) throws ApiException, IOException;

    /**
     * Deletes an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteFee__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteFeeRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to delete.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Fee> deleteFeeAsync(
            final String locationId,
            final String feeId);

    /**
     * Modifies the details of an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call
     */
    @Deprecated    V1Fee updateFee(
            final String locationId,
            final String feeId,
            final V1Fee body) throws ApiException, IOException;

    /**
     * Modifies the details of an existing fee (tax).
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    feeId    Required parameter: The ID of the fee to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Fee response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Fee> updateFeeAsync(
            final String locationId,
            final String feeId,
            final V1Fee body);

    /**
     * Provides inventory information for all inventory-enabled item
     * variations.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    limit    Optional parameter: The maximum number of inventory entries to return in a single response. This value cannot exceed 1000.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1InventoryEntry> response from the API call
     */
    @Deprecated    List<V1InventoryEntry> listInventory(
            final String locationId,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides inventory information for all inventory-enabled item
     * variations.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    limit    Optional parameter: The maximum number of inventory entries to return in a single response. This value cannot exceed 1000.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1InventoryEntry> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1InventoryEntry>> listInventoryAsync(
            final String locationId,
            final Integer limit,
            final String batchToken);

    /**
     * Adjusts the current available inventory of an item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    variationId    Required parameter: The ID of the variation to adjust inventory information for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1InventoryEntry response from the API call
     */
    @Deprecated    V1InventoryEntry adjustInventory(
            final String locationId,
            final String variationId,
            final V1AdjustInventoryRequest body) throws ApiException, IOException;

    /**
     * Adjusts the current available inventory of an item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    variationId    Required parameter: The ID of the variation to adjust inventory information for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1InventoryEntry response from the API call 
     */
    @Deprecated
    CompletableFuture<V1InventoryEntry> adjustInventoryAsync(
            final String locationId,
            final String variationId,
            final V1AdjustInventoryRequest body);

    /**
     * Provides summary information of all items for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list items for.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Item> response from the API call
     */
    @Deprecated    List<V1Item> listItems(
            final String locationId,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information of all items for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list items for.
     * @param    batchToken    Optional parameter: A pagination cursor to retrieve the next set of results for your original query to the endpoint.
     * @return    Returns the List<V1Item> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1Item>> listItemsAsync(
            final String locationId,
            final String batchToken);

    /**
     * Creates an item and at least one variation for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * Item-related entities include fields you can use to associate them with
     * entities in a non-Square system.
     * When you create an item-related entity, you can optionally specify `id`.
     * This value must be unique among all IDs ever specified for the account,
     * including those specified by other applications. You can never reuse an
     * entity ID. If you do not specify an ID, Square generates one for the entity.
     * Item variations have a `user_data` string that lets you associate arbitrary
     * metadata with the variation. The string cannot exceed 255 characters.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item createItem(
            final String locationId,
            final V1Item body) throws ApiException, IOException;

    /**
     * Creates an item and at least one variation for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * Item-related entities include fields you can use to associate them with
     * entities in a non-Square system.
     * When you create an item-related entity, you can optionally specify `id`.
     * This value must be unique among all IDs ever specified for the account,
     * including those specified by other applications. You can never reuse an
     * entity ID. If you do not specify an ID, Square generates one for the entity.
     * Item variations have a `user_data` string that lets you associate arbitrary
     * metadata with the variation. The string cannot exceed 255 characters.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> createItemAsync(
            final String locationId,
            final V1Item body);

    /**
     * Deletes an existing item and all item variations associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteItem__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteItemRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item deleteItem(
            final String locationId,
            final String itemId) throws ApiException, IOException;

    /**
     * Deletes an existing item and all item variations associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteItem__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteItemRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> deleteItemAsync(
            final String locationId,
            final String itemId);

    /**
     * Provides the details for a single item, including associated modifier
     * lists and fees.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item retrieveItem(
            final String locationId,
            final String itemId) throws ApiException, IOException;

    /**
     * Provides the details for a single item, including associated modifier
     * lists and fees.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> retrieveItemAsync(
            final String locationId,
            final String itemId);

    /**
     * Modifies the core details of an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item updateItem(
            final String locationId,
            final String itemId,
            final V1Item body) throws ApiException, IOException;

    /**
     * Modifies the core details of an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> updateItemAsync(
            final String locationId,
            final String itemId,
            final V1Item body);

    /**
     * Removes a fee assocation from an item so the fee is no longer
     * automatically applied to the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item removeFee(
            final String locationId,
            final String itemId,
            final String feeId) throws ApiException, IOException;

    /**
     * Removes a fee assocation from an item so the fee is no longer
     * automatically applied to the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> removeFeeAsync(
            final String locationId,
            final String itemId,
            final String feeId);

    /**
     * Associates a fee with an item so the fee is automatically applied to
     * the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item applyFee(
            final String locationId,
            final String itemId,
            final String feeId) throws ApiException, IOException;

    /**
     * Associates a fee with an item so the fee is automatically applied to
     * the item in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the fee's associated location.
     * @param    itemId    Required parameter: The ID of the item to add the fee to.
     * @param    feeId    Required parameter: The ID of the fee to apply.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> applyFeeAsync(
            final String locationId,
            final String itemId,
            final String feeId);

    /**
     * Removes a modifier list association from an item so the modifier
     * options from the list can no longer be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to remove.
     * @param    itemId    Required parameter: The ID of the item to remove the modifier list from.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item removeModifierList(
            final String locationId,
            final String modifierListId,
            final String itemId) throws ApiException, IOException;

    /**
     * Removes a modifier list association from an item so the modifier
     * options from the list can no longer be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to remove.
     * @param    itemId    Required parameter: The ID of the item to remove the modifier list from.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> removeModifierListAsync(
            final String locationId,
            final String modifierListId,
            final String itemId);

    /**
     * Associates a modifier list with an item so the associated modifier
     * options can be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to apply.
     * @param    itemId    Required parameter: The ID of the item to add the modifier list to.
     * @return    Returns the V1Item response from the API call
     */
    @Deprecated    V1Item applyModifierList(
            final String locationId,
            final String modifierListId,
            final String itemId) throws ApiException, IOException;

    /**
     * Associates a modifier list with an item so the associated modifier
     * options can be applied to the item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to apply.
     * @param    itemId    Required parameter: The ID of the item to add the modifier list to.
     * @return    Returns the V1Item response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Item> applyModifierListAsync(
            final String locationId,
            final String modifierListId,
            final String itemId);

    /**
     * Creates an item variation for an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call
     */
    @Deprecated    V1Variation createVariation(
            final String locationId,
            final String itemId,
            final V1Variation body) throws ApiException, IOException;

    /**
     * Creates an item variation for an existing item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The item's ID.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Variation> createVariationAsync(
            final String locationId,
            final String itemId,
            final V1Variation body);

    /**
     * Deletes an existing item variation from an item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteVariation__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteVariationRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to delete.
     * @param    variationId    Required parameter: The ID of the variation to delete.
     * @return    Returns the V1Variation response from the API call
     */
    @Deprecated    V1Variation deleteVariation(
            final String locationId,
            final String itemId,
            final String variationId) throws ApiException, IOException;

    /**
     * Deletes an existing item variation from an item.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteVariation__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteVariationRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to delete.
     * @param    variationId    Required parameter: The ID of the variation to delete.
     * @return    Returns the V1Variation response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Variation> deleteVariationAsync(
            final String locationId,
            final String itemId,
            final String variationId);

    /**
     * Modifies the details of an existing item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    variationId    Required parameter: The ID of the variation to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call
     */
    @Deprecated    V1Variation updateVariation(
            final String locationId,
            final String itemId,
            final String variationId,
            final V1Variation body) throws ApiException, IOException;

    /**
     * Modifies the details of an existing item variation.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    itemId    Required parameter: The ID of the item to modify.
     * @param    variationId    Required parameter: The ID of the variation to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Variation response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Variation> updateVariationAsync(
            final String locationId,
            final String itemId,
            final String variationId,
            final V1Variation body);

    /**
     * Lists all the modifier lists for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list modifier lists for.
     * @return    Returns the List<V1ModifierList> response from the API call
     */
    @Deprecated    List<V1ModifierList> listModifierLists(
            final String locationId) throws ApiException, IOException;

    /**
     * Lists all the modifier lists for a given location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list modifier lists for.
     * @return    Returns the List<V1ModifierList> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1ModifierList>> listModifierListsAsync(
            final String locationId);

    /**
     * Creates an item modifier list and at least 1 modifier option for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a modifier list for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated    V1ModifierList createModifierList(
            final String locationId,
            final V1ModifierList body) throws ApiException, IOException;

    /**
     * Creates an item modifier list and at least 1 modifier option for it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create a modifier list for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierList> createModifierListAsync(
            final String locationId,
            final V1ModifierList body);

    /**
     * Deletes an existing item modifier list and all modifier options
     * associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierList__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteModifierListRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated    V1ModifierList deleteModifierList(
            final String locationId,
            final String modifierListId) throws ApiException, IOException;

    /**
     * Deletes an existing item modifier list and all modifier options
     * associated with it.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierList__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeleteModifierListRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierList> deleteModifierListAsync(
            final String locationId,
            final String modifierListId);

    /**
     * Provides the details for a single modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The modifier list's ID.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated    V1ModifierList retrieveModifierList(
            final String locationId,
            final String modifierListId) throws ApiException, IOException;

    /**
     * Provides the details for a single modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The modifier list's ID.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierList> retrieveModifierListAsync(
            final String locationId,
            final String modifierListId);

    /**
     * Modifies the details of an existing item modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call
     */
    @Deprecated    V1ModifierList updateModifierList(
            final String locationId,
            final String modifierListId,
            final V1UpdateModifierListRequest body) throws ApiException, IOException;

    /**
     * Modifies the details of an existing item modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierList response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierList> updateModifierListAsync(
            final String locationId,
            final String modifierListId,
            final V1UpdateModifierListRequest body);

    /**
     * Creates an item modifier option and adds it to a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call
     */
    @Deprecated    V1ModifierOption createModifierOption(
            final String locationId,
            final String modifierListId,
            final V1ModifierOption body) throws ApiException, IOException;

    /**
     * Creates an item modifier option and adds it to a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierOption> createModifierOptionAsync(
            final String locationId,
            final String modifierListId,
            final V1ModifierOption body);

    /**
     * Deletes an existing item modifier option from a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierOption__ returns nothing on success but Connect
     * SDKs map the empty response to an empty `V1DeleteModifierOptionRequest`
     * object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @return    Returns the V1ModifierOption response from the API call
     */
    @Deprecated    V1ModifierOption deleteModifierOption(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId) throws ApiException, IOException;

    /**
     * Deletes an existing item modifier option from a modifier list.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeleteModifierOption__ returns nothing on success but Connect
     * SDKs map the empty response to an empty `V1DeleteModifierOptionRequest`
     * object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to delete.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @return    Returns the V1ModifierOption response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierOption> deleteModifierOptionAsync(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId);

    /**
     * Modifies the details of an existing item modifier option.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call
     */
    @Deprecated    V1ModifierOption updateModifierOption(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId,
            final V1ModifierOption body) throws ApiException, IOException;

    /**
     * Modifies the details of an existing item modifier option.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the item's associated location.
     * @param    modifierListId    Required parameter: The ID of the modifier list to edit.
     * @param    modifierOptionId    Required parameter: The ID of the modifier list to edit.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1ModifierOption response from the API call 
     */
    @Deprecated
    CompletableFuture<V1ModifierOption> updateModifierOptionAsync(
            final String locationId,
            final String modifierListId,
            final String modifierOptionId,
            final V1ModifierOption body);

    /**
     * Lists all Favorites pages (in Square Point of Sale) for a given
     * location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list Favorites pages for.
     * @return    Returns the List<V1Page> response from the API call
     */
    @Deprecated    List<V1Page> listPages(
            final String locationId) throws ApiException, IOException;

    /**
     * Lists all Favorites pages (in Square Point of Sale) for a given
     * location.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to list Favorites pages for.
     * @return    Returns the List<V1Page> response from the API call 
     */
    @Deprecated
    CompletableFuture<List<V1Page>> listPagesAsync(
            final String locationId);

    /**
     * Creates a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated    V1Page createPage(
            final String locationId,
            final V1Page body) throws ApiException, IOException;

    /**
     * Creates a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the location to create an item for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Page> createPageAsync(
            final String locationId,
            final V1Page body);

    /**
     * Deletes an existing Favorites page and all of its cells.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePage__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageRequest` object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated    V1Page deletePage(
            final String locationId,
            final String pageId) throws ApiException, IOException;

    /**
     * Deletes an existing Favorites page and all of its cells.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePage__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageRequest` object.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Page> deletePageAsync(
            final String locationId,
            final String pageId);

    /**
     * Modifies the details of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location
     * @param    pageId    Required parameter: The ID of the page to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated    V1Page updatePage(
            final String locationId,
            final String pageId,
            final V1Page body) throws ApiException, IOException;

    /**
     * Modifies the details of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location
     * @param    pageId    Required parameter: The ID of the page to modify.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Page> updatePageAsync(
            final String locationId,
            final String pageId,
            final V1Page body);

    /**
     * Deletes a cell from a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePageCell__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageCellRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @param    row    Optional parameter: The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top row.
     * @param    column    Optional parameter: The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is the leftmost column.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated    V1Page deletePageCell(
            final String locationId,
            final String pageId,
            final String row,
            final String column) throws ApiException, IOException;

    /**
     * Deletes a cell from a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * __DeletePageCell__ returns nothing on success but Connect SDKs
     * map the empty response to an empty `V1DeletePageCellRequest` object
     * as documented below.
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page to delete.
     * @param    row    Optional parameter: The row of the cell to clear. Always an integer between 0 and 4, inclusive. Row 0 is the top row.
     * @param    column    Optional parameter: The column of the cell to clear. Always an integer between 0 and 4, inclusive. Column 0 is the leftmost column.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Page> deletePageCellAsync(
            final String locationId,
            final String pageId,
            final String row,
            final String column);

    /**
     * Modifies a cell of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page the cell belongs to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call
     */
    @Deprecated    V1Page updatePageCell(
            final String locationId,
            final String pageId,
            final V1PageCell body) throws ApiException, IOException;

    /**
     * Modifies a cell of a Favorites page in Square Point of Sale.
     * ---
     * - __Deprecation date__: 2019-11-20
     * - [__Retirement date__](https://developer.squareup.com/docs/build-basics/api-lifecycle#deprecated): 2020-11-18
     * - [Migration guide](https://developer.squareup.com/docs/migrate-from-v1/guides/v1-items)
     * ---
     * @deprecated
     * 
     * @param    locationId    Required parameter: The ID of the Favorites page's associated location.
     * @param    pageId    Required parameter: The ID of the page the cell belongs to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the V1Page response from the API call 
     */
    @Deprecated
    CompletableFuture<V1Page> updatePageCellAsync(
            final String locationId,
            final String pageId,
            final V1PageCell body);

}