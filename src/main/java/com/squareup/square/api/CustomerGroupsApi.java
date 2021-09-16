
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateCustomerGroupRequest;
import com.squareup.square.models.CreateCustomerGroupResponse;
import com.squareup.square.models.DeleteCustomerGroupResponse;
import com.squareup.square.models.ListCustomerGroupsResponse;
import com.squareup.square.models.RetrieveCustomerGroupResponse;
import com.squareup.square.models.UpdateCustomerGroupRequest;
import com.squareup.square.models.UpdateCustomerGroupResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomerGroupsApi {
    /**
     * Retrieves the list of customer groups of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. The limit
     *         is ignored if it is less than 1 or greater than 50. The default value is 50. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return    Returns the ListCustomerGroupsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListCustomerGroupsResponse listCustomerGroups(
            final String cursor,
            final Integer limit) throws ApiException, IOException;

    /**
     * Retrieves the list of customer groups of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. The limit
     *         is ignored if it is less than 1 or greater than 50. The default value is 50. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return    Returns the ListCustomerGroupsResponse response from the API call
     */
    CompletableFuture<ListCustomerGroupsResponse> listCustomerGroupsAsync(
            final String cursor,
            final Integer limit);

    /**
     * Creates a new customer group for a business. The request must include the `name` value of the
     * group.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateCustomerGroupResponse createCustomerGroup(
            final CreateCustomerGroupRequest body) throws ApiException, IOException;

    /**
     * Creates a new customer group for a business. The request must include the `name` value of the
     * group.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call
     */
    CompletableFuture<CreateCustomerGroupResponse> createCustomerGroupAsync(
            final CreateCustomerGroupRequest body);

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteCustomerGroupResponse deleteCustomerGroup(
            final String groupId) throws ApiException, IOException;

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call
     */
    CompletableFuture<DeleteCustomerGroupResponse> deleteCustomerGroupAsync(
            final String groupId);

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveCustomerGroupResponse retrieveCustomerGroup(
            final String groupId) throws ApiException, IOException;

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call
     */
    CompletableFuture<RetrieveCustomerGroupResponse> retrieveCustomerGroupAsync(
            final String groupId);

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateCustomerGroupResponse updateCustomerGroup(
            final String groupId,
            final UpdateCustomerGroupRequest body) throws ApiException, IOException;

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call
     */
    CompletableFuture<UpdateCustomerGroupResponse> updateCustomerGroupAsync(
            final String groupId,
            final UpdateCustomerGroupRequest body);

}