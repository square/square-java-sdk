package com.squareup.square.legacy.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.AddGroupToCustomerResponse;
import com.squareup.square.legacy.models.BulkCreateCustomersRequest;
import com.squareup.square.legacy.models.BulkCreateCustomersResponse;
import com.squareup.square.legacy.models.BulkDeleteCustomersRequest;
import com.squareup.square.legacy.models.BulkDeleteCustomersResponse;
import com.squareup.square.legacy.models.BulkRetrieveCustomersRequest;
import com.squareup.square.legacy.models.BulkRetrieveCustomersResponse;
import com.squareup.square.legacy.models.BulkUpdateCustomersRequest;
import com.squareup.square.legacy.models.BulkUpdateCustomersResponse;
import com.squareup.square.legacy.models.CreateCustomerCardRequest;
import com.squareup.square.legacy.models.CreateCustomerCardResponse;
import com.squareup.square.legacy.models.CreateCustomerRequest;
import com.squareup.square.legacy.models.CreateCustomerResponse;
import com.squareup.square.legacy.models.DeleteCustomerCardResponse;
import com.squareup.square.legacy.models.DeleteCustomerResponse;
import com.squareup.square.legacy.models.ListCustomersResponse;
import com.squareup.square.legacy.models.RemoveGroupFromCustomerResponse;
import com.squareup.square.legacy.models.RetrieveCustomerResponse;
import com.squareup.square.legacy.models.SearchCustomersRequest;
import com.squareup.square.legacy.models.SearchCustomersResponse;
import com.squareup.square.legacy.models.UpdateCustomerRequest;
import com.squareup.square.legacy.models.UpdateCustomerResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomersApi extends BaseApi implements CustomersApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCustomersApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
     * @param  count  Optional parameter: Indicates whether to return the total count of customers
     *         in the `count` field of the response. The default value is `false`.
     * @return    Returns the ListCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomersResponse listCustomers(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder,
            final Boolean count)
            throws ApiException, IOException {
        return prepareListCustomersRequest(cursor, limit, sortField, sortOrder, count)
                .execute();
    }

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
     * @param  count  Optional parameter: Indicates whether to return the total count of customers
     *         in the `count` field of the response. The default value is `false`.
     * @return    Returns the ListCustomersResponse response from the API call
     */
    public CompletableFuture<ListCustomersResponse> listCustomersAsync(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder,
            final Boolean count) {
        try {
            return prepareListCustomersRequest(cursor, limit, sortField, sortOrder, count)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listCustomers.
     */
    private ApiCall<ListCustomersResponse, ApiException> prepareListCustomersRequest(
            final String cursor,
            final Integer limit,
            final String sortField,
            final String sortOrder,
            final Boolean count)
            throws IOException {
        return new ApiCall.Builder<ListCustomersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers")
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param ->
                                param.key("sort_field").value(sortField).isRequired(false))
                        .queryParam(param ->
                                param.key("sort_order").value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("count")
                                .value((count != null) ? count : false)
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListCustomersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public CreateCustomerResponse createCustomer(final CreateCustomerRequest body) throws ApiException, IOException {
        return prepareCreateCustomerRequest(body).execute();
    }

    /**
     * Creates a new customer for a business. You must provide at least one of the following values
     * in your request to this endpoint: - `given_name` - `family_name` - `company_name` -
     * `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCustomerResponse response from the API call
     */
    public CompletableFuture<CreateCustomerResponse> createCustomerAsync(final CreateCustomerRequest body) {
        try {
            return prepareCreateCustomerRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for createCustomer.
     */
    private ApiCall<CreateCustomerResponse, ApiException> prepareCreateCustomerRequest(final CreateCustomerRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCustomerResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, CreateCustomerResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates multiple [customer profiles]($m/Customer) for a business. This endpoint takes a map
     * of individual create requests and returns a map of responses. You must provide at least one
     * of the following values in each create request: - `given_name` - `family_name` -
     * `company_name` - `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkCreateCustomersResponse bulkCreateCustomers(final BulkCreateCustomersRequest body)
            throws ApiException, IOException {
        return prepareBulkCreateCustomersRequest(body).execute();
    }

    /**
     * Creates multiple [customer profiles]($m/Customer) for a business. This endpoint takes a map
     * of individual create requests and returns a map of responses. You must provide at least one
     * of the following values in each create request: - `given_name` - `family_name` -
     * `company_name` - `email_address` - `phone_number`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateCustomersResponse response from the API call
     */
    public CompletableFuture<BulkCreateCustomersResponse> bulkCreateCustomersAsync(
            final BulkCreateCustomersRequest body) {
        try {
            return prepareBulkCreateCustomersRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for bulkCreateCustomers.
     */
    private ApiCall<BulkCreateCustomersResponse, ApiException> prepareBulkCreateCustomersRequest(
            final BulkCreateCustomersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkCreateCustomersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/bulk-create")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, BulkCreateCustomersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes multiple customer profiles. The endpoint takes a list of customer IDs and returns a
     * map of responses.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkDeleteCustomersResponse bulkDeleteCustomers(final BulkDeleteCustomersRequest body)
            throws ApiException, IOException {
        return prepareBulkDeleteCustomersRequest(body).execute();
    }

    /**
     * Deletes multiple customer profiles. The endpoint takes a list of customer IDs and returns a
     * map of responses.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkDeleteCustomersResponse response from the API call
     */
    public CompletableFuture<BulkDeleteCustomersResponse> bulkDeleteCustomersAsync(
            final BulkDeleteCustomersRequest body) {
        try {
            return prepareBulkDeleteCustomersRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for bulkDeleteCustomers.
     */
    private ApiCall<BulkDeleteCustomersResponse, ApiException> prepareBulkDeleteCustomersRequest(
            final BulkDeleteCustomersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkDeleteCustomersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/bulk-delete")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, BulkDeleteCustomersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves multiple customer profiles. This endpoint takes a list of customer IDs and returns
     * a map of responses.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkRetrieveCustomersResponse bulkRetrieveCustomers(final BulkRetrieveCustomersRequest body)
            throws ApiException, IOException {
        return prepareBulkRetrieveCustomersRequest(body).execute();
    }

    /**
     * Retrieves multiple customer profiles. This endpoint takes a list of customer IDs and returns
     * a map of responses.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveCustomersResponse response from the API call
     */
    public CompletableFuture<BulkRetrieveCustomersResponse> bulkRetrieveCustomersAsync(
            final BulkRetrieveCustomersRequest body) {
        try {
            return prepareBulkRetrieveCustomersRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for bulkRetrieveCustomers.
     */
    private ApiCall<BulkRetrieveCustomersResponse, ApiException> prepareBulkRetrieveCustomersRequest(
            final BulkRetrieveCustomersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkRetrieveCustomersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/bulk-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, BulkRetrieveCustomersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates multiple customer profiles. This endpoint takes a map of individual update requests
     * and returns a map of responses. You cannot use this endpoint to change cards on file. To make
     * changes, use the [Cards API]($e/Cards) or [Gift Cards API]($e/GiftCards).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateCustomersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpdateCustomersResponse bulkUpdateCustomers(final BulkUpdateCustomersRequest body)
            throws ApiException, IOException {
        return prepareBulkUpdateCustomersRequest(body).execute();
    }

    /**
     * Updates multiple customer profiles. This endpoint takes a map of individual update requests
     * and returns a map of responses. You cannot use this endpoint to change cards on file. To make
     * changes, use the [Cards API]($e/Cards) or [Gift Cards API]($e/GiftCards).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateCustomersResponse response from the API call
     */
    public CompletableFuture<BulkUpdateCustomersResponse> bulkUpdateCustomersAsync(
            final BulkUpdateCustomersRequest body) {
        try {
            return prepareBulkUpdateCustomersRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for bulkUpdateCustomers.
     */
    private ApiCall<BulkUpdateCustomersResponse, ApiException> prepareBulkUpdateCustomersRequest(
            final BulkUpdateCustomersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpdateCustomersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/bulk-update")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, BulkUpdateCustomersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public SearchCustomersResponse searchCustomers(final SearchCustomersRequest body) throws ApiException, IOException {
        return prepareSearchCustomersRequest(body).execute();
    }

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
    public CompletableFuture<SearchCustomersResponse> searchCustomersAsync(final SearchCustomersRequest body) {
        try {
            return prepareSearchCustomersRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for searchCustomers.
     */
    private ApiCall<SearchCustomersResponse, ApiException> prepareSearchCustomersRequest(
            final SearchCustomersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchCustomersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, SearchCustomersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a customer profile from a business. This operation also unlinks any associated cards
     * on file. To delete a customer profile that was created by merging existing profiles, you must
     * use the ID of the newly created profile.
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
    public DeleteCustomerResponse deleteCustomer(final String customerId, final Long version)
            throws ApiException, IOException {
        return prepareDeleteCustomerRequest(customerId, version).execute();
    }

    /**
     * Deletes a customer profile from a business. This operation also unlinks any associated cards
     * on file. To delete a customer profile that was created by merging existing profiles, you must
     * use the ID of the newly created profile.
     * @param  customerId  Required parameter: The ID of the customer to delete.
     * @param  version  Optional parameter: The current version of the customer profile. As a best
     *         practice, you should include this parameter to enable [optimistic
     *         concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     *         control. For more information, see [Delete a customer
     *         profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
     * @return    Returns the DeleteCustomerResponse response from the API call
     */
    public CompletableFuture<DeleteCustomerResponse> deleteCustomerAsync(final String customerId, final Long version) {
        try {
            return prepareDeleteCustomerRequest(customerId, version).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for deleteCustomer.
     */
    private ApiCall<DeleteCustomerResponse, ApiException> prepareDeleteCustomerRequest(
            final String customerId, final Long version) throws IOException {
        return new ApiCall.Builder<DeleteCustomerResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}")
                        .queryParam(param -> param.key("version").value(version).isRequired(false))
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, DeleteCustomerResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns details for a single customer.
     * @param  customerId  Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerResponse retrieveCustomer(final String customerId) throws ApiException, IOException {
        return prepareRetrieveCustomerRequest(customerId).execute();
    }

    /**
     * Returns details for a single customer.
     * @param  customerId  Required parameter: The ID of the customer to retrieve.
     * @return    Returns the RetrieveCustomerResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerResponse> retrieveCustomerAsync(final String customerId) {
        try {
            return prepareRetrieveCustomerRequest(customerId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveCustomer.
     */
    private ApiCall<RetrieveCustomerResponse, ApiException> prepareRetrieveCustomerRequest(final String customerId)
            throws IOException {
        return new ApiCall.Builder<RetrieveCustomerResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}")
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, RetrieveCustomerResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a customer profile. This endpoint supports sparse updates, so only new or changed
     * fields are required in the request. To add or update a field, specify the new value. To
     * remove a field, specify `null`. To update a customer profile that was created by merging
     * existing profiles, you must use the ID of the newly created profile. You cannot use this
     * endpoint to change cards on file. To make changes, use the [Cards API]($e/Cards) or [Gift
     * Cards API]($e/GiftCards).
     * @param  customerId  Required parameter: The ID of the customer to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateCustomerResponse updateCustomer(final String customerId, final UpdateCustomerRequest body)
            throws ApiException, IOException {
        return prepareUpdateCustomerRequest(customerId, body).execute();
    }

    /**
     * Updates a customer profile. This endpoint supports sparse updates, so only new or changed
     * fields are required in the request. To add or update a field, specify the new value. To
     * remove a field, specify `null`. To update a customer profile that was created by merging
     * existing profiles, you must use the ID of the newly created profile. You cannot use this
     * endpoint to change cards on file. To make changes, use the [Cards API]($e/Cards) or [Gift
     * Cards API]($e/GiftCards).
     * @param  customerId  Required parameter: The ID of the customer to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateCustomerResponse response from the API call
     */
    public CompletableFuture<UpdateCustomerResponse> updateCustomerAsync(
            final String customerId, final UpdateCustomerRequest body) {
        try {
            return prepareUpdateCustomerRequest(customerId, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for updateCustomer.
     */
    private ApiCall<UpdateCustomerResponse, ApiException> prepareUpdateCustomerRequest(
            final String customerId, final UpdateCustomerRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateCustomerResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, UpdateCustomerResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    @Deprecated
    public CreateCustomerCardResponse createCustomerCard(final String customerId, final CreateCustomerCardRequest body)
            throws ApiException, IOException {
        return prepareCreateCustomerCardRequest(customerId, body).execute();
    }

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
    public CompletableFuture<CreateCustomerCardResponse> createCustomerCardAsync(
            final String customerId, final CreateCustomerCardRequest body) {
        try {
            return prepareCreateCustomerCardRequest(customerId, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for createCustomerCard.
     */
    private ApiCall<CreateCustomerCardResponse, ApiException> prepareCreateCustomerCardRequest(
            final String customerId, final CreateCustomerCardRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCustomerCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/cards")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, CreateCustomerCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    @Deprecated
    public DeleteCustomerCardResponse deleteCustomerCard(final String customerId, final String cardId)
            throws ApiException, IOException {
        return prepareDeleteCustomerCardRequest(customerId, cardId).execute();
    }

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
    public CompletableFuture<DeleteCustomerCardResponse> deleteCustomerCardAsync(
            final String customerId, final String cardId) {
        try {
            return prepareDeleteCustomerCardRequest(customerId, cardId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for deleteCustomerCard.
     */
    private ApiCall<DeleteCustomerCardResponse, ApiException> prepareDeleteCustomerCardRequest(
            final String customerId, final String cardId) throws IOException {
        return new ApiCall.Builder<DeleteCustomerCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/cards/{card_id}")
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .templateParam(
                                param -> param.key("card_id").value(cardId).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, DeleteCustomerCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RemoveGroupFromCustomerResponse removeGroupFromCustomer(final String customerId, final String groupId)
            throws ApiException, IOException {
        return prepareRemoveGroupFromCustomerRequest(customerId, groupId).execute();
    }

    /**
     * Removes a group membership from a customer. The customer is identified by the `customer_id`
     * value and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to remove from the group.
     * @param  groupId  Required parameter: The ID of the customer group to remove the customer
     *         from.
     * @return    Returns the RemoveGroupFromCustomerResponse response from the API call
     */
    public CompletableFuture<RemoveGroupFromCustomerResponse> removeGroupFromCustomerAsync(
            final String customerId, final String groupId) {
        try {
            return prepareRemoveGroupFromCustomerRequest(customerId, groupId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for removeGroupFromCustomer.
     */
    private ApiCall<RemoveGroupFromCustomerResponse, ApiException> prepareRemoveGroupFromCustomerRequest(
            final String customerId, final String groupId) throws IOException {
        return new ApiCall.Builder<RemoveGroupFromCustomerResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/groups/{group_id}")
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .templateParam(
                                param -> param.key("group_id").value(groupId).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RemoveGroupFromCustomerResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Adds a group membership to a customer. The customer is identified by the `customer_id` value
     * and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to add to a group.
     * @param  groupId  Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AddGroupToCustomerResponse addGroupToCustomer(final String customerId, final String groupId)
            throws ApiException, IOException {
        return prepareAddGroupToCustomerRequest(customerId, groupId).execute();
    }

    /**
     * Adds a group membership to a customer. The customer is identified by the `customer_id` value
     * and the customer group is identified by the `group_id` value.
     * @param  customerId  Required parameter: The ID of the customer to add to a group.
     * @param  groupId  Required parameter: The ID of the customer group to add the customer to.
     * @return    Returns the AddGroupToCustomerResponse response from the API call
     */
    public CompletableFuture<AddGroupToCustomerResponse> addGroupToCustomerAsync(
            final String customerId, final String groupId) {
        try {
            return prepareAddGroupToCustomerRequest(customerId, groupId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for addGroupToCustomer.
     */
    private ApiCall<AddGroupToCustomerResponse, ApiException> prepareAddGroupToCustomerRequest(
            final String customerId, final String groupId) throws IOException {
        return new ApiCall.Builder<AddGroupToCustomerResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/{customer_id}/groups/{group_id}")
                        .templateParam(param ->
                                param.key("customer_id").value(customerId).shouldEncode(true))
                        .templateParam(
                                param -> param.key("group_id").value(groupId).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, AddGroupToCustomerResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
