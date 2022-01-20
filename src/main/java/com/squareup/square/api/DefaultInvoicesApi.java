
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.Headers;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.CancelInvoiceRequest;
import com.squareup.square.models.CancelInvoiceResponse;
import com.squareup.square.models.CreateInvoiceRequest;
import com.squareup.square.models.CreateInvoiceResponse;
import com.squareup.square.models.DeleteInvoiceResponse;
import com.squareup.square.models.GetInvoiceResponse;
import com.squareup.square.models.ListInvoicesResponse;
import com.squareup.square.models.PublishInvoiceRequest;
import com.squareup.square.models.PublishInvoiceResponse;
import com.squareup.square.models.SearchInvoicesRequest;
import com.squareup.square.models.SearchInvoicesResponse;
import com.squareup.square.models.UpdateInvoiceRequest;
import com.squareup.square.models.UpdateInvoiceResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultInvoicesApi extends BaseApi implements InvoicesApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultInvoicesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public DefaultInvoicesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns a list of invoices for a given location. The response is paginated. If truncated, the
     * response includes a `cursor` that you use in a subsequent request to retrieve the next set of
     * invoices.
     * @param  locationId  Required parameter: The ID of the location for which to list invoices.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of invoices to return (200 is the
     *         maximum `limit`). If not provided, the server uses a default limit of 100 invoices.
     * @return    Returns the ListInvoicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListInvoicesResponse listInvoices(
            final String locationId,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        HttpRequest request = buildListInvoicesRequest(locationId, cursor, limit);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListInvoicesResponse(context);
    }

    /**
     * Returns a list of invoices for a given location. The response is paginated. If truncated, the
     * response includes a `cursor` that you use in a subsequent request to retrieve the next set of
     * invoices.
     * @param  locationId  Required parameter: The ID of the location for which to list invoices.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for your original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of invoices to return (200 is the
     *         maximum `limit`). If not provided, the server uses a default limit of 100 invoices.
     * @return    Returns the ListInvoicesResponse response from the API call
     */
    public CompletableFuture<ListInvoicesResponse> listInvoicesAsync(
            final String locationId,
            final String cursor,
            final Integer limit) {
        return makeHttpCallAsync(() -> buildListInvoicesRequest(locationId, cursor, limit),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListInvoicesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listInvoices.
     */
    private HttpRequest buildListInvoicesRequest(
            final String locationId,
            final String cursor,
            final Integer limit) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("location_id", locationId);
        queryParameters.put("cursor", cursor);
        queryParameters.put("limit", limit);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listInvoices.
     * @return An object of type ListInvoicesResponse
     */
    private ListInvoicesResponse handleListInvoicesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        ListInvoicesResponse result = ApiHelper.deserialize(responseBody,
                ListInvoicesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Creates a draft [invoice]($m/Invoice) for an order created using the Orders API. A draft
     * invoice remains in your account and no action is taken. You must publish the invoice before
     * Square can process it (send it to the customer's email address or charge the customer’s card
     * on file).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateInvoiceResponse createInvoice(
            final CreateInvoiceRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateInvoiceRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateInvoiceResponse(context);
    }

    /**
     * Creates a draft [invoice]($m/Invoice) for an order created using the Orders API. A draft
     * invoice remains in your account and no action is taken. You must publish the invoice before
     * Square can process it (send it to the customer's email address or charge the customer’s card
     * on file).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateInvoiceResponse response from the API call
     */
    public CompletableFuture<CreateInvoiceResponse> createInvoiceAsync(
            final CreateInvoiceRequest body) {
        return makeHttpCallAsync(() -> buildCreateInvoiceRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateInvoiceResponse(context));
    }

    /**
     * Builds the HttpRequest object for createInvoice.
     */
    private HttpRequest buildCreateInvoiceRequest(
            final CreateInvoiceRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for createInvoice.
     * @return An object of type CreateInvoiceResponse
     */
    private CreateInvoiceResponse handleCreateInvoiceResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CreateInvoiceResponse result = ApiHelper.deserialize(responseBody,
                CreateInvoiceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Searches for invoices from a location specified in the filter. You can optionally specify
     * customers in the filter for whom to retrieve invoices. In the current implementation, you can
     * only specify one location and optionally one customer. The response is paginated. If
     * truncated, the response includes a `cursor` that you use in a subsequent request to retrieve
     * the next set of invoices.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchInvoicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchInvoicesResponse searchInvoices(
            final SearchInvoicesRequest body) throws ApiException, IOException {
        HttpRequest request = buildSearchInvoicesRequest(body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSearchInvoicesResponse(context);
    }

    /**
     * Searches for invoices from a location specified in the filter. You can optionally specify
     * customers in the filter for whom to retrieve invoices. In the current implementation, you can
     * only specify one location and optionally one customer. The response is paginated. If
     * truncated, the response includes a `cursor` that you use in a subsequent request to retrieve
     * the next set of invoices.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchInvoicesResponse response from the API call
     */
    public CompletableFuture<SearchInvoicesResponse> searchInvoicesAsync(
            final SearchInvoicesRequest body) {
        return makeHttpCallAsync(() -> buildSearchInvoicesRequest(body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSearchInvoicesResponse(context));
    }

    /**
     * Builds the HttpRequest object for searchInvoices.
     */
    private HttpRequest buildSearchInvoicesRequest(
            final SearchInvoicesRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices/search");

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for searchInvoices.
     * @return An object of type SearchInvoicesResponse
     */
    private SearchInvoicesResponse handleSearchInvoicesResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        SearchInvoicesResponse result = ApiHelper.deserialize(responseBody,
                SearchInvoicesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice]($m/Invoice) to delete. If
     *         you do not know the version, you can call [GetInvoice]($e/Invoices/GetInvoice) or
     *         [ListInvoices]($e/Invoices/ListInvoices).
     * @return    Returns the DeleteInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteInvoiceResponse deleteInvoice(
            final String invoiceId,
            final Integer version) throws ApiException, IOException {
        HttpRequest request = buildDeleteInvoiceRequest(invoiceId, version);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteInvoiceResponse(context);
    }

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice]($m/Invoice) to delete. If
     *         you do not know the version, you can call [GetInvoice]($e/Invoices/GetInvoice) or
     *         [ListInvoices]($e/Invoices/ListInvoices).
     * @return    Returns the DeleteInvoiceResponse response from the API call
     */
    public CompletableFuture<DeleteInvoiceResponse> deleteInvoiceAsync(
            final String invoiceId,
            final Integer version) {
        return makeHttpCallAsync(() -> buildDeleteInvoiceRequest(invoiceId, version),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteInvoiceResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteInvoice.
     */
    private HttpRequest buildDeleteInvoiceRequest(
            final String invoiceId,
            final Integer version) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices/{invoice_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("invoice_id",
                new SimpleEntry<Object, Boolean>(invoiceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("version", version);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteInvoice.
     * @return An object of type DeleteInvoiceResponse
     */
    private DeleteInvoiceResponse handleDeleteInvoiceResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        DeleteInvoiceResponse result = ApiHelper.deserialize(responseBody,
                DeleteInvoiceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The ID of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetInvoiceResponse getInvoice(
            final String invoiceId) throws ApiException, IOException {
        HttpRequest request = buildGetInvoiceRequest(invoiceId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleGetInvoiceResponse(context);
    }

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The ID of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     */
    public CompletableFuture<GetInvoiceResponse> getInvoiceAsync(
            final String invoiceId) {
        return makeHttpCallAsync(() -> buildGetInvoiceRequest(invoiceId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleGetInvoiceResponse(context));
    }

    /**
     * Builds the HttpRequest object for getInvoice.
     */
    private HttpRequest buildGetInvoiceRequest(
            final String invoiceId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices/{invoice_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("invoice_id",
                new SimpleEntry<Object, Boolean>(invoiceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for getInvoice.
     * @return An object of type GetInvoiceResponse
     */
    private GetInvoiceResponse handleGetInvoiceResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        GetInvoiceResponse result = ApiHelper.deserialize(responseBody,
                GetInvoiceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Updates an invoice by modifying fields, clearing fields, or both. For most updates, you can
     * use a sparse `Invoice` object to add fields or change values and use the `fields_to_clear`
     * field to specify fields to clear. However, some restrictions apply. For example, you cannot
     * change the `order_id` or `location_id` field and you must provide the complete
     * `custom_fields` list to update a custom field. Published invoices have additional
     * restrictions.
     * @param  invoiceId  Required parameter: The ID of the invoice to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateInvoiceResponse updateInvoice(
            final String invoiceId,
            final UpdateInvoiceRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpdateInvoiceRequest(invoiceId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpdateInvoiceResponse(context);
    }

    /**
     * Updates an invoice by modifying fields, clearing fields, or both. For most updates, you can
     * use a sparse `Invoice` object to add fields or change values and use the `fields_to_clear`
     * field to specify fields to clear. However, some restrictions apply. For example, you cannot
     * change the `order_id` or `location_id` field and you must provide the complete
     * `custom_fields` list to update a custom field. Published invoices have additional
     * restrictions.
     * @param  invoiceId  Required parameter: The ID of the invoice to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateInvoiceResponse response from the API call
     */
    public CompletableFuture<UpdateInvoiceResponse> updateInvoiceAsync(
            final String invoiceId,
            final UpdateInvoiceRequest body) {
        return makeHttpCallAsync(() -> buildUpdateInvoiceRequest(invoiceId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpdateInvoiceResponse(context));
    }

    /**
     * Builds the HttpRequest object for updateInvoice.
     */
    private HttpRequest buildUpdateInvoiceRequest(
            final String invoiceId,
            final UpdateInvoiceRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices/{invoice_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("invoice_id",
                new SimpleEntry<Object, Boolean>(invoiceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().putBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for updateInvoice.
     * @return An object of type UpdateInvoiceResponse
     */
    private UpdateInvoiceResponse handleUpdateInvoiceResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        UpdateInvoiceResponse result = ApiHelper.deserialize(responseBody,
                UpdateInvoiceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice]($m/Invoice) to cancel.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelInvoiceResponse cancelInvoice(
            final String invoiceId,
            final CancelInvoiceRequest body) throws ApiException, IOException {
        HttpRequest request = buildCancelInvoiceRequest(invoiceId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCancelInvoiceResponse(context);
    }

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice]($m/Invoice) to cancel.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CancelInvoiceResponse response from the API call
     */
    public CompletableFuture<CancelInvoiceResponse> cancelInvoiceAsync(
            final String invoiceId,
            final CancelInvoiceRequest body) {
        return makeHttpCallAsync(() -> buildCancelInvoiceRequest(invoiceId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCancelInvoiceResponse(context));
    }

    /**
     * Builds the HttpRequest object for cancelInvoice.
     */
    private HttpRequest buildCancelInvoiceRequest(
            final String invoiceId,
            final CancelInvoiceRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices/{invoice_id}/cancel");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("invoice_id",
                new SimpleEntry<Object, Boolean>(invoiceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for cancelInvoice.
     * @return An object of type CancelInvoiceResponse
     */
    private CancelInvoiceResponse handleCancelInvoiceResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        CancelInvoiceResponse result = ApiHelper.deserialize(responseBody,
                CancelInvoiceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charge a card on file for a portion
     * of the invoice amount.
     * @param  invoiceId  Required parameter: The ID of the invoice to publish.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PublishInvoiceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public PublishInvoiceResponse publishInvoice(
            final String invoiceId,
            final PublishInvoiceRequest body) throws ApiException, IOException {
        HttpRequest request = buildPublishInvoiceRequest(invoiceId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handlePublishInvoiceResponse(context);
    }

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charge a card on file for a portion
     * of the invoice amount.
     * @param  invoiceId  Required parameter: The ID of the invoice to publish.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PublishInvoiceResponse response from the API call
     */
    public CompletableFuture<PublishInvoiceResponse> publishInvoiceAsync(
            final String invoiceId,
            final PublishInvoiceRequest body) {
        return makeHttpCallAsync(() -> buildPublishInvoiceRequest(invoiceId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handlePublishInvoiceResponse(context));
    }

    /**
     * Builds the HttpRequest object for publishInvoice.
     */
    private HttpRequest buildPublishInvoiceRequest(
            final String invoiceId,
            final PublishInvoiceRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/invoices/{invoice_id}/publish");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("invoice_id",
                new SimpleEntry<Object, Boolean>(invoiceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for publishInvoice.
     * @return An object of type PublishInvoiceResponse
     */
    private PublishInvoiceResponse handlePublishInvoiceResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        PublishInvoiceResponse result = ApiHelper.deserialize(responseBody,
                PublishInvoiceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}