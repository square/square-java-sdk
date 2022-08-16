
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.AddGroupToCustomerResponse;
import com.squareup.square.models.CreateCustomerCardRequest;
import com.squareup.square.models.CreateCustomerCardResponse;
import com.squareup.square.models.CreateCustomerRequest;
import com.squareup.square.models.CreateCustomerResponse;
import com.squareup.square.models.DeleteCustomerCardResponse;
import com.squareup.square.models.DeleteCustomerResponse;
import com.squareup.square.models.ListCustomersResponse;
import com.squareup.square.models.RemoveGroupFromCustomerResponse;
import com.squareup.square.models.RetrieveCustomerResponse;
import com.squareup.square.models.SearchCustomersRequest;
import com.squareup.square.models.SearchCustomersResponse;
import com.squareup.square.models.UpdateCustomerRequest;
import com.squareup.square.models.UpdateCustomerResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomersApi {
    /**
     * Lists customer profiles associated with a Square account. Under normal operating conditions,
     * newly created or updated customer profiles become available for the listing operation in well
     * under 30 seconds. Occasionally, propagation of the new or updated profiles can take closer to
     * one minute or longer, especially during network incidents and outages.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. If the
     *         specified limit is less than 1 or greater than 100, Square returns a `400
     *         VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 100. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  sortField  Optional parameter: Indicates how customers should be sorted. The default
     *         value is `DEFAULT`.
     * @param  sortOrder  Optional parameter: Indicates whether customers should be sorted in
     *         ascending (`ASC`) or descending (`DESC`) order. The default value is `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListCustomersResponse listCustomers(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder) throws ApiException, IOException;

    /**
     * Lists customer profiles associated with a Square account. Under normal operating conditions,
     * newly created or updated customer profiles become available for the listing operation in well
     * under 30 seconds. Occasionally, propagation of the new or updated profiles can take closer to
     * one minute or longer, especially during network incidents and outages.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. If the
     *         specified limit is less than 1 or greater than 100, Square returns a `400
     *         VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 100. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  sortField  Optional parameter: Indicates how customers should be sorted. The default
     *         value is `DEFAULT`.
     * @param  sortOrder  Optional parameter: Indicates whether customers should be sorted in
     *         ascending (`ASC`) or descending (`DESC`) order. The default value is `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call
     */
    CompletableFuture<ListCustomersResponse> listCustomersAsync(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder);

    /**
     * Creates a new customer for a business. You must provide at least one of the following values
     * in your request to this endpoint: - `given_name` - `family_name` - `company_name` -
     * `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateCustomerResponse createCustomer(
            final CreateCustomerRequest body) throws ApiException, IOException;

    /**
     * Creates a new customer for a business. You must provide at least one of the following values
     * in your request to this endpoint: - `given_name` - `family_name` - `company_name` -
     * `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     */
    CompletableFuture<CreateCustomerResponse> createCustomerAsync(
            final CreateCustomerRequest body);

    /**
     * Searches the customer profiles associated with a Square account using one or more supported
     * query filters. Calling `SearchCustomers` without any explicit query filter returns all
     * customer profiles ordered alphabetically based on `given_name` and `family_name`. Under
     * normal operating conditions, newly created or updated customer profiles become available for
     * the search operation in well under 30 seconds. Occasionally, propagation of the new or
     * updated profiles can take closer to one minute or longer, especially during network incidents
     * and outages.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchCustomersResponse searchCustomers(
            final SearchCustomersRequest body) throws ApiException, IOException;

    /**
     * Searches the customer profiles associated with a Square account using one or more supported
     * query filters. Calling `SearchCustomers` without any explicit query filter returns all
     * customer profiles ordered alphabetically based on `given_name` and `family_name`. Under
     * normal operating conditions, newly created or updated customer profiles become available for
     * the search operation in well under 30 seconds. Occasionally, propagation of the new or
     * updated profiles can take closer to one minute or longer, especially during network incidents
     * and outages.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call
     */
    CompletableFuture<SearchCustomersResponse> searchCustomersAsync(
            final SearchCustomersRequest body);

    /**
     * Deletes a customer profile from a business. This operation also unlinks any associated cards
     * on file. As a best practice, you should include the `version` field in the request to enable
     * [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To delete a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile.
     * @param  customerId  Required parameter: The ID of the customer to delete.
     * @param  version  Optional parameter: The current version of the customer profile. As a best
     *         practice, you should include this parameter to enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control. For more information, see [Delete a customer
     *         profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
     * @return    Returns the DeleteCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteCustomerResponse deleteCustomer(
            final String customerId,
            final Long version) throws ApiException, IOException;

    /**
     * Deletes a customer profile from a business. This operation also unlinks any associated cards
     * on file. As a best practice, you should include the `version` field in the request to enable
     * [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To delete a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile.
     * @param  customerId  Required parameter: The ID of the customer to delete.
     * @param  version  Optional parameter: The current version of the customer profile. As a best
     *         practice, you should include this parameter to enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control. For more information, see [Delete a customer
     *         profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
     * @return    Returns the DeleteCustomerResponse response from the API call
     */
    CompletableFuture<DeleteCustomerResponse> deleteCustomerAsync(
            final String customerId,
            final Long version);

    /**
     * Returns details for a single customer.
     * @param  customerId  Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveCustomerResponse retrieveCustomer(
            final String customerId) throws ApiException, IOException;

    /**
     * Returns details for a single customer.
     * @param  customerId  Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     */
    CompletableFuture<RetrieveCustomerResponse> retrieveCustomerAsync(
            final String customerId);

    /**
     * Updates a customer profile. To change an attribute, specify the new value. To remove an
     * attribute, specify the value as an empty string or empty object. As a best practice, you
     * should include the `version` field in the request to enable [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To update a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile. You cannot use this endpoint to change cards on file. To make changes,
     * use the [Cards API]($e/Cards) or [Gift Cards API]($e/GiftCards).
     * @param  customerId  Required parameter: The ID of the customer to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateCustomerResponse updateCustomer(
            final String customerId,
            final UpdateCustomerRequest body) throws ApiException, IOException;

    /**
     * Updates a customer profile. To change an attribute, specify the new value. To remove an
     * attribute, specify the value as an empty string or empty object. As a best practice, you
     * should include the `version` field in the request to enable [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. The value must be set to the current version of the customer profile. To update a
     * customer profile that was created by merging existing profiles, you must use the ID of the
     * newly created profile. You cannot use this endpoint to change cards on file. To make changes,
     * use the [Cards API]($e/Cards) or [Gift Cards API]($e/GiftCards).
     * @param  customerId  Required parameter: The ID of the customer to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     */
    CompletableFuture<UpdateCustomerResponse> updateCustomerAsync(
            final String customerId,
            final UpdateCustomerRequest body);

    /**
     * Adds a card on file to an existing customer. As with charges, calls to `CreateCustomerCard`
     * are idempotent. Multiple calls with the same card nonce return the same card record that was
     * created with the provided nonce during the _first_ call.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The Square ID of the customer profile the card is
     *         linked to.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    CreateCustomerCardResponse createCustomerCard(
            final String customerId,
            final CreateCustomerCardRequest body) throws ApiException, IOException;

    /**
     * Adds a card on file to an existing customer. As with charges, calls to `CreateCustomerCard`
     * are idempotent. Multiple calls with the same card nonce return the same card record that was
     * created with the provided nonce during the _first_ call.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The Square ID of the customer profile the card is
     *         linked to.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call
     */
    @Deprecated
    CompletableFuture<CreateCustomerCardResponse> createCustomerCardAsync(
            final String customerId,
            final CreateCustomerCardRequest body);

    /**
     * Removes a card on file from a customer.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The ID of the customer that the card on file belongs
     *         to.
     * @param  cardId  Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    DeleteCustomerCardResponse deleteCustomerCard(
            final String customerId,
            final String cardId) throws ApiException, IOException;

    /**
     * Removes a card on file from a customer.
     * @deprecated
     * 
     * @param  customerId  Required parameter: The ID of the customer that the card on file belongs
     *         to.
     * @param  cardId  Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call
     */
    @Deprecated
    CompletableFuture<DeleteCustomerCardResponse> deleteCustomerCardAsync(
            final String customerId,
            final String cardId);

    /**
     * Removes a group membership from a customer. The customer is identified by the `customer_id`
     * value and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to remove from the group.
     * @param  groupId  Required parameter: The ID of the customer group to remove the customer
     *         from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RemoveGroupFromCustomerResponse removeGroupFromCustomer(
            final String customerId,
            final String groupId) throws ApiException, IOException;

    /**
     * Removes a group membership from a customer. The customer is identified by the `customer_id`
     * value and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to remove from the group.
     * @param  groupId  Required parameter: The ID of the customer group to remove the customer
     *         from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call
     */
    CompletableFuture<RemoveGroupFromCustomerResponse> removeGroupFromCustomerAsync(
            final String customerId,
            final String groupId);

    /**
     * Adds a group membership to a customer. The customer is identified by the `customer_id` value
     * and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to add to a group.
     * @param  groupId  Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    AddGroupToCustomerResponse addGroupToCustomer(
            final String customerId,
            final String groupId) throws ApiException, IOException;

    /**
     * Adds a group membership to a customer. The customer is identified by the `customer_id` value
     * and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to add to a group.
     * @param  groupId  Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     */
    CompletableFuture<AddGroupToCustomerResponse> addGroupToCustomerAsync(
            final String customerId,
            final String groupId);

}