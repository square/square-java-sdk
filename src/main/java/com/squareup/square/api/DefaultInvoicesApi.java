
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultInvoicesApi extends BaseApi implements InvoicesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultInvoicesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
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
        return prepareListInvoicesRequest(locationId, cursor, limit).execute();
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
        try { 
            return prepareListInvoicesRequest(locationId, cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listInvoices.
     */
    private ApiCall<ListInvoicesResponse, ApiException> prepareListInvoicesRequest(
            final String locationId,
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListInvoicesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices")
                        .queryParam(param -> param.key("location_id")
                                .value(locationId))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListInvoicesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareCreateInvoiceRequest(body).execute();
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
        try { 
            return prepareCreateInvoiceRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createInvoice.
     */
    private ApiCall<CreateInvoiceResponse, ApiException> prepareCreateInvoiceRequest(
            final CreateInvoiceRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateInvoiceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareSearchInvoicesRequest(body).execute();
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
        try { 
            return prepareSearchInvoicesRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchInvoices.
     */
    private ApiCall<SearchInvoicesResponse, ApiException> prepareSearchInvoicesRequest(
            final SearchInvoicesRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchInvoicesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchInvoicesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareDeleteInvoiceRequest(invoiceId, version).execute();
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
        try { 
            return prepareDeleteInvoiceRequest(invoiceId, version).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteInvoice.
     */
    private ApiCall<DeleteInvoiceResponse, ApiException> prepareDeleteInvoiceRequest(
            final String invoiceId,
            final Integer version) throws IOException {
        return new ApiCall.Builder<DeleteInvoiceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}")
                        .queryParam(param -> param.key("version")
                                .value(version).isRequired(false))
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareGetInvoiceRequest(invoiceId).execute();
    }

    /**
     * Retrieves an invoice by invoice ID.
     * @param  invoiceId  Required parameter: The ID of the invoice to retrieve.
     * @return    Returns the GetInvoiceResponse response from the API call
     */
    public CompletableFuture<GetInvoiceResponse> getInvoiceAsync(
            final String invoiceId) {
        try { 
            return prepareGetInvoiceRequest(invoiceId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getInvoice.
     */
    private ApiCall<GetInvoiceResponse, ApiException> prepareGetInvoiceRequest(
            final String invoiceId) throws IOException {
        return new ApiCall.Builder<GetInvoiceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}")
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareUpdateInvoiceRequest(invoiceId, body).execute();
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
        try { 
            return prepareUpdateInvoiceRequest(invoiceId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateInvoice.
     */
    private ApiCall<UpdateInvoiceResponse, ApiException> prepareUpdateInvoiceRequest(
            final String invoiceId,
            final UpdateInvoiceRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateInvoiceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareCancelInvoiceRequest(invoiceId, body).execute();
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
        try { 
            return prepareCancelInvoiceRequest(invoiceId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelInvoice.
     */
    private ApiCall<CancelInvoiceResponse, ApiException> prepareCancelInvoiceRequest(
            final String invoiceId,
            final CancelInvoiceRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CancelInvoiceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}/cancel")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return preparePublishInvoiceRequest(invoiceId, body).execute();
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
        try { 
            return preparePublishInvoiceRequest(invoiceId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for publishInvoice.
     */
    private ApiCall<PublishInvoiceResponse, ApiException> preparePublishInvoiceRequest(
            final String invoiceId,
            final PublishInvoiceRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<PublishInvoiceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}/publish")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, PublishInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}