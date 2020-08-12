package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateCustomerGroupRequest;
import com.squareup.square.models.CreateCustomerGroupResponse;
import com.squareup.square.models.DeleteCustomerGroupResponse;
import com.squareup.square.models.ListCustomerGroupsResponse;
import com.squareup.square.models.RetrieveCustomerGroupResponse;
import com.squareup.square.models.UpdateCustomerGroupRequest;
import com.squareup.square.models.UpdateCustomerGroupResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomerGroupsApi {
    /**
     * Retrieves the list of customer groups of a business.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @return    Returns the ListCustomerGroupsResponse response from the API call
     */
    ListCustomerGroupsResponse listCustomerGroups(
            final String cursor) throws ApiException, IOException;

    /**
     * Retrieves the list of customer groups of a business.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information.
     * @return    Returns the ListCustomerGroupsResponse response from the API call 
     */
    CompletableFuture<ListCustomerGroupsResponse> listCustomerGroupsAsync(
            final String cursor);

    /**
     * Creates a new customer group for a business. 
     * The request must include the `name` value of the group.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call
     */
    CreateCustomerGroupResponse createCustomerGroup(
            final CreateCustomerGroupRequest body) throws ApiException, IOException;

    /**
     * Creates a new customer group for a business. 
     * The request must include the `name` value of the group.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call 
     */
    CompletableFuture<CreateCustomerGroupResponse> createCustomerGroupAsync(
            final CreateCustomerGroupRequest body);

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call
     */
    DeleteCustomerGroupResponse deleteCustomerGroup(
            final String groupId) throws ApiException, IOException;

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call 
     */
    CompletableFuture<DeleteCustomerGroupResponse> deleteCustomerGroupAsync(
            final String groupId);

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call
     */
    RetrieveCustomerGroupResponse retrieveCustomerGroup(
            final String groupId) throws ApiException, IOException;

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call 
     */
    CompletableFuture<RetrieveCustomerGroupResponse> retrieveCustomerGroupAsync(
            final String groupId);

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call
     */
    UpdateCustomerGroupResponse updateCustomerGroup(
            final String groupId,
            final UpdateCustomerGroupRequest body) throws ApiException, IOException;

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param    groupId    Required parameter: The ID of the customer group to update.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call 
     */
    CompletableFuture<UpdateCustomerGroupResponse> updateCustomerGroupAsync(
            final String groupId,
            final UpdateCustomerGroupRequest body);

}
