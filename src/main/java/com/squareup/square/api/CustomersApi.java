package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
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

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomersApi {
    /**
     * Lists customer profiles associated with a Square account.
     * Under normal operating conditions, newly created or updated customer profiles become available 
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated 
     * profiles can take closer to one minute or longer, espeically during network incidents and outages.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @param    sortField    Optional parameter: Indicates how Customers should be sorted.  Default: `DEFAULT`.
     * @param    sortOrder    Optional parameter: Indicates whether Customers should be sorted in ascending (`ASC`) or descending (`DESC`) order.  Default: `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call
     */
    ListCustomersResponse listCustomers(
            final String cursor,
            final String sortField,
            final String sortOrder) throws ApiException, IOException;

    /**
     * Lists customer profiles associated with a Square account.
     * Under normal operating conditions, newly created or updated customer profiles become available 
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated 
     * profiles can take closer to one minute or longer, espeically during network incidents and outages.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @param    sortField    Optional parameter: Indicates how Customers should be sorted.  Default: `DEFAULT`.
     * @param    sortOrder    Optional parameter: Indicates whether Customers should be sorted in ascending (`ASC`) or descending (`DESC`) order.  Default: `ASC`.
     * @return    Returns the ListCustomersResponse response from the API call 
     */
    CompletableFuture<ListCustomersResponse> listCustomersAsync(
            final String cursor,
            final String sortField,
            final String sortOrder);

    /**
     * Creates a new customer for a business, which can have associated cards on file.
     * You must provide __at least one__ of the following values in your request to this
     * endpoint:
     * - `given_name`
     * - `family_name`
     * - `company_name`
     * - `email_address`
     * - `phone_number`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     */
    CreateCustomerResponse createCustomer(
            final CreateCustomerRequest body) throws ApiException, IOException;

    /**
     * Creates a new customer for a business, which can have associated cards on file.
     * You must provide __at least one__ of the following values in your request to this
     * endpoint:
     * - `given_name`
     * - `family_name`
     * - `company_name`
     * - `email_address`
     * - `phone_number`
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call 
     */
    CompletableFuture<CreateCustomerResponse> createCustomerAsync(
            final CreateCustomerRequest body);

    /**
     * Searches the customer profiles associated with a Square account using 
     * one or more supported query filters. 
     * Calling `SearchCustomers` without any explicit query filter returns all
     * customer profiles ordered alphabetically based on `given_name` and
     * `family_name`.
     * Under normal operating conditions, newly created or updated customer profiles become available 
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated 
     * profiles can take closer to one minute or longer, espeically during network incidents and outages.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call
     */
    SearchCustomersResponse searchCustomers(
            final SearchCustomersRequest body) throws ApiException, IOException;

    /**
     * Searches the customer profiles associated with a Square account using 
     * one or more supported query filters. 
     * Calling `SearchCustomers` without any explicit query filter returns all
     * customer profiles ordered alphabetically based on `given_name` and
     * `family_name`.
     * Under normal operating conditions, newly created or updated customer profiles become available 
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated 
     * profiles can take closer to one minute or longer, espeically during network incidents and outages.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchCustomersResponse response from the API call 
     */
    CompletableFuture<SearchCustomersResponse> searchCustomersAsync(
            final SearchCustomersRequest body);

    /**
     * Deletes a customer from a business, along with any linked cards on file. When two profiles
     * are merged into a single profile, that profile is assigned a new `customer_id`. You must use the
     * new `customer_id` to delete merged profiles.
     * @param    customerId    Required parameter: The ID of the customer to delete.
     * @return    Returns the DeleteCustomerResponse response from the API call
     */
    DeleteCustomerResponse deleteCustomer(
            final String customerId) throws ApiException, IOException;

    /**
     * Deletes a customer from a business, along with any linked cards on file. When two profiles
     * are merged into a single profile, that profile is assigned a new `customer_id`. You must use the
     * new `customer_id` to delete merged profiles.
     * @param    customerId    Required parameter: The ID of the customer to delete.
     * @return    Returns the DeleteCustomerResponse response from the API call 
     */
    CompletableFuture<DeleteCustomerResponse> deleteCustomerAsync(
            final String customerId);

    /**
     * Returns details for a single customer.
     * @param    customerId    Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     */
    RetrieveCustomerResponse retrieveCustomer(
            final String customerId) throws ApiException, IOException;

    /**
     * Returns details for a single customer.
     * @param    customerId    Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call 
     */
    CompletableFuture<RetrieveCustomerResponse> retrieveCustomerAsync(
            final String customerId);

    /**
     * Updates the details of an existing customer. When two profiles are merged
     * into a single profile, that profile is assigned a new `customer_id`. You must use
     * the new `customer_id` to update merged profiles.
     * You cannot edit a customer's cards on file with this endpoint. To make changes
     * to a card on file, you must delete the existing card on file with the
     * [DeleteCustomerCard](#endpoint-deletecustomercard) endpoint, then create a new one with the
     * [CreateCustomerCard](#endpoint-createcustomercard) endpoint.
     * @param    customerId    Required parameter: The ID of the customer to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     */
    UpdateCustomerResponse updateCustomer(
            final String customerId,
            final UpdateCustomerRequest body) throws ApiException, IOException;

    /**
     * Updates the details of an existing customer. When two profiles are merged
     * into a single profile, that profile is assigned a new `customer_id`. You must use
     * the new `customer_id` to update merged profiles.
     * You cannot edit a customer's cards on file with this endpoint. To make changes
     * to a card on file, you must delete the existing card on file with the
     * [DeleteCustomerCard](#endpoint-deletecustomercard) endpoint, then create a new one with the
     * [CreateCustomerCard](#endpoint-createcustomercard) endpoint.
     * @param    customerId    Required parameter: The ID of the customer to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call 
     */
    CompletableFuture<UpdateCustomerResponse> updateCustomerAsync(
            final String customerId,
            final UpdateCustomerRequest body);

    /**
     * Adds a card on file to an existing customer.
     * As with charges, calls to `CreateCustomerCard` are idempotent. Multiple
     * calls with the same card nonce return the same card record that was created
     * with the provided nonce during the _first_ call.
     * @param    customerId    Required parameter: The Square ID of the customer profile the card is linked to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call
     */
    CreateCustomerCardResponse createCustomerCard(
            final String customerId,
            final CreateCustomerCardRequest body) throws ApiException, IOException;

    /**
     * Adds a card on file to an existing customer.
     * As with charges, calls to `CreateCustomerCard` are idempotent. Multiple
     * calls with the same card nonce return the same card record that was created
     * with the provided nonce during the _first_ call.
     * @param    customerId    Required parameter: The Square ID of the customer profile the card is linked to.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerCardResponse response from the API call 
     */
    CompletableFuture<CreateCustomerCardResponse> createCustomerCardAsync(
            final String customerId,
            final CreateCustomerCardRequest body);

    /**
     * Removes a card on file from a customer.
     * @param    customerId    Required parameter: The ID of the customer that the card on file belongs to.
     * @param    cardId    Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call
     */
    DeleteCustomerCardResponse deleteCustomerCard(
            final String customerId,
            final String cardId) throws ApiException, IOException;

    /**
     * Removes a card on file from a customer.
     * @param    customerId    Required parameter: The ID of the customer that the card on file belongs to.
     * @param    cardId    Required parameter: The ID of the card on file to delete.
     * @return    Returns the DeleteCustomerCardResponse response from the API call 
     */
    CompletableFuture<DeleteCustomerCardResponse> deleteCustomerCardAsync(
            final String customerId,
            final String cardId);

    /**
     * Removes a group membership from a customer. 
     * The customer is identified by the `customer_id` value 
     * and the customer group is identified by the `group_id` value.
     * @param    customerId    Required parameter: The ID of the customer to remove from the group.
     * @param    groupId    Required parameter: The ID of the customer group to remove the customer from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call
     */
    RemoveGroupFromCustomerResponse removeGroupFromCustomer(
            final String customerId,
            final String groupId) throws ApiException, IOException;

    /**
     * Removes a group membership from a customer. 
     * The customer is identified by the `customer_id` value 
     * and the customer group is identified by the `group_id` value.
     * @param    customerId    Required parameter: The ID of the customer to remove from the group.
     * @param    groupId    Required parameter: The ID of the customer group to remove the customer from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call 
     */
    CompletableFuture<RemoveGroupFromCustomerResponse> removeGroupFromCustomerAsync(
            final String customerId,
            final String groupId);

    /**
     * Adds a group membership to a customer. 
     * The customer is identified by the `customer_id` value 
     * and the customer group is identified by the `group_id` value.
     * @param    customerId    Required parameter: The ID of the customer to add to a group.
     * @param    groupId    Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     */
    AddGroupToCustomerResponse addGroupToCustomer(
            final String customerId,
            final String groupId) throws ApiException, IOException;

    /**
     * Adds a group membership to a customer. 
     * The customer is identified by the `customer_id` value 
     * and the customer group is identified by the `group_id` value.
     * @param    customerId    Required parameter: The ID of the customer to add to a group.
     * @param    groupId    Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call 
     */
    CompletableFuture<AddGroupToCustomerResponse> addGroupToCustomerAsync(
            final String customerId,
            final String groupId);

}