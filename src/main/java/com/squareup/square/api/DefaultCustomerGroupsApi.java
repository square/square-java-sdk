
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateCustomerGroupRequest;
import com.squareup.square.models.CreateCustomerGroupResponse;
import com.squareup.square.models.DeleteCustomerGroupResponse;
import com.squareup.square.models.ListCustomerGroupsResponse;
import com.squareup.square.models.RetrieveCustomerGroupResponse;
import com.squareup.square.models.UpdateCustomerGroupRequest;
import com.squareup.square.models.UpdateCustomerGroupResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomerGroupsApi extends BaseApi implements CustomerGroupsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCustomerGroupsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Retrieves the list of customer groups of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. If the
     *         limit is less than 1 or greater than 50, Square returns a `400 VALUE_TOO_LOW` or `400
     *         VALUE_TOO_HIGH` error. The default value is 50. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListCustomerGroupsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomerGroupsResponse listCustomerGroups(
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListCustomerGroupsRequest(cursor, limit).execute();
    }

    /**
     * Retrieves the list of customer groups of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. If the
     *         limit is less than 1 or greater than 50, Square returns a `400 VALUE_TOO_LOW` or `400
     *         VALUE_TOO_HIGH` error. The default value is 50. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListCustomerGroupsResponse response from the API call
     */
    public CompletableFuture<ListCustomerGroupsResponse> listCustomerGroupsAsync(
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListCustomerGroupsRequest(cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCustomerGroups.
     */
    private ApiCall<ListCustomerGroupsResponse, ApiException> prepareListCustomerGroupsRequest(
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListCustomerGroupsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/groups")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCustomerGroupsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a new customer group for a business. The request must include the `name` value of the
     * group.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCustomerGroupResponse createCustomerGroup(
            final CreateCustomerGroupRequest body) throws ApiException, IOException {
        return prepareCreateCustomerGroupRequest(body).execute();
    }

    /**
     * Creates a new customer group for a business. The request must include the `name` value of the
     * group.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerGroupResponse response from the API call
     */
    public CompletableFuture<CreateCustomerGroupResponse> createCustomerGroupAsync(
            final CreateCustomerGroupRequest body) {
        try { 
            return prepareCreateCustomerGroupRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createCustomerGroup.
     */
    private ApiCall<CreateCustomerGroupResponse, ApiException> prepareCreateCustomerGroupRequest(
            final CreateCustomerGroupRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCustomerGroupResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/groups")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateCustomerGroupResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteCustomerGroupResponse deleteCustomerGroup(
            final String groupId) throws ApiException, IOException {
        return prepareDeleteCustomerGroupRequest(groupId).execute();
    }

    /**
     * Deletes a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to delete.
     * @return    Returns the DeleteCustomerGroupResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerGroupResponse> deleteCustomerGroupAsync(
            final String groupId) {
        try { 
            return prepareDeleteCustomerGroupRequest(groupId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteCustomerGroup.
     */
    private ApiCall<DeleteCustomerGroupResponse, ApiException> prepareDeleteCustomerGroupRequest(
            final String groupId) throws IOException {
        return new ApiCall.Builder<DeleteCustomerGroupResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/groups/{group_id}")
                        .templateParam(param -> param.key("group_id").value(groupId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteCustomerGroupResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerGroupResponse retrieveCustomerGroup(
            final String groupId) throws ApiException, IOException {
        return prepareRetrieveCustomerGroupRequest(groupId).execute();
    }

    /**
     * Retrieves a specific customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to retrieve.
     * @return    Returns the RetrieveCustomerGroupResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerGroupResponse> retrieveCustomerGroupAsync(
            final String groupId) {
        try { 
            return prepareRetrieveCustomerGroupRequest(groupId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCustomerGroup.
     */
    private ApiCall<RetrieveCustomerGroupResponse, ApiException> prepareRetrieveCustomerGroupRequest(
            final String groupId) throws IOException {
        return new ApiCall.Builder<RetrieveCustomerGroupResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/groups/{group_id}")
                        .templateParam(param -> param.key("group_id").value(groupId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCustomerGroupResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateCustomerGroupResponse updateCustomerGroup(
            final String groupId,
            final UpdateCustomerGroupRequest body) throws ApiException, IOException {
        return prepareUpdateCustomerGroupRequest(groupId, body).execute();
    }

    /**
     * Updates a customer group as identified by the `group_id` value.
     * @param  groupId  Required parameter: The ID of the customer group to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerGroupResponse response from the API call
     */
    public CompletableFuture<UpdateCustomerGroupResponse> updateCustomerGroupAsync(
            final String groupId,
            final UpdateCustomerGroupRequest body) {
        try { 
            return prepareUpdateCustomerGroupRequest(groupId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateCustomerGroup.
     */
    private ApiCall<UpdateCustomerGroupResponse, ApiException> prepareUpdateCustomerGroupRequest(
            final String groupId,
            final UpdateCustomerGroupRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateCustomerGroupResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/groups/{group_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("group_id").value(groupId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateCustomerGroupResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}