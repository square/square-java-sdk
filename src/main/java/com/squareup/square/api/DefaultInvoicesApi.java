
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CancelInvoiceRequest;
import com.squareup.square.models.CancelInvoiceResponse;
import com.squareup.square.models.CreateInvoiceAttachmentRequest;
import com.squareup.square.models.CreateInvoiceAttachmentResponse;
import com.squareup.square.models.CreateInvoiceRequest;
import com.squareup.square.models.CreateInvoiceResponse;
import com.squareup.square.models.DeleteInvoiceAttachmentResponse;
import com.squareup.square.models.DeleteInvoiceResponse;
import com.squareup.square.models.GetInvoiceResponse;
import com.squareup.square.models.ListInvoicesResponse;
import com.squareup.square.models.PublishInvoiceRequest;
import com.squareup.square.models.PublishInvoiceResponse;
import com.squareup.square.models.SearchInvoicesRequest;
import com.squareup.square.models.SearchInvoicesResponse;
import com.squareup.square.models.UpdateInvoiceRequest;
import com.squareup.square.models.UpdateInvoiceResponse;
import com.squareup.square.utilities.FileWrapper;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import io.apimatic.coreinterfaces.http.request.MutliPartRequestType;
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
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListInvoicesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchInvoicesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes the specified invoice. When an invoice is deleted, the associated order status
     * changes to CANCELED. You can only delete a draft invoice (you cannot delete a published
     * invoice, including one that is scheduled for processing).
     * @param  invoiceId  Required parameter: The ID of the invoice to delete.
     * @param  version  Optional parameter: The version of the [invoice](entity:Invoice) to delete.
     *         If you do not know the version, you can call
     *         [GetInvoice](api-endpoint:Invoices-GetInvoice) or
     *         [ListInvoices](api-endpoint:Invoices-ListInvoices).
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
     * @param  version  Optional parameter: The version of the [invoice](entity:Invoice) to delete.
     *         If you do not know the version, you can call
     *         [GetInvoice](api-endpoint:Invoices-GetInvoice) or
     *         [ListInvoices](api-endpoint:Invoices-ListInvoices).
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates an invoice. This endpoint supports sparse updates, so you only need to specify the
     * fields you want to change along with the required `version` field. Some restrictions apply to
     * updating invoices. For example, you cannot change the `order_id` or `location_id` field.
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
     * Updates an invoice. This endpoint supports sparse updates, so you only need to specify the
     * fields you want to change along with the required `version` field. Some restrictions apply to
     * updating invoices. For example, you cannot change the `order_id` or `location_id` field.
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Uploads a file and attaches it to an invoice. This endpoint accepts HTTP multipart/form-data
     * file uploads with a JSON `request` part and a `file` part. The `file` part must be a
     * `readable stream` that contains a file in a supported format: GIF, JPEG, PNG, TIFF, BMP, or
     * PDF. Invoices can have up to 10 attachments with a total file size of 25 MB. Attachments can
     * be added only to invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to attach the
     *         file to.
     * @param  request  Optional parameter: Represents a
     *         [CreateInvoiceAttachment]($e/Invoices/CreateInvoiceAttachment) request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateInvoiceAttachmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateInvoiceAttachmentResponse createInvoiceAttachment(
            final String invoiceId,
            final CreateInvoiceAttachmentRequest request,
            final FileWrapper imageFile) throws ApiException, IOException {
        return prepareCreateInvoiceAttachmentRequest(invoiceId, request, imageFile).execute();
    }

    /**
     * Uploads a file and attaches it to an invoice. This endpoint accepts HTTP multipart/form-data
     * file uploads with a JSON `request` part and a `file` part. The `file` part must be a
     * `readable stream` that contains a file in a supported format: GIF, JPEG, PNG, TIFF, BMP, or
     * PDF. Invoices can have up to 10 attachments with a total file size of 25 MB. Attachments can
     * be added only to invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to attach the
     *         file to.
     * @param  request  Optional parameter: Represents a
     *         [CreateInvoiceAttachment]($e/Invoices/CreateInvoiceAttachment) request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateInvoiceAttachmentResponse response from the API call
     */
    public CompletableFuture<CreateInvoiceAttachmentResponse> createInvoiceAttachmentAsync(
            final String invoiceId,
            final CreateInvoiceAttachmentRequest request,
            final FileWrapper imageFile) {
        try { 
            return prepareCreateInvoiceAttachmentRequest(invoiceId, request, imageFile).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createInvoiceAttachment.
     */
    private ApiCall<CreateInvoiceAttachmentResponse, ApiException> prepareCreateInvoiceAttachmentRequest(
            final String invoiceId,
            final CreateInvoiceAttachmentRequest request,
            final FileWrapper imageFile) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateInvoiceAttachmentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}/attachments")
                        .formParam(param -> param.key("request")
                                .value(request)
                                .multipartSerializer(() -> 
                                        ApiHelper.serialize(request))
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART)
                                .multipartHeaders("Content-Type", "application/json; charset=utf-8"))
                        .formParam(param -> param.key("image_file")
                                .value(imageFile)
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART_FILE)
                                .multipartHeaders("Content-Type", "image/jpeg"))
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateInvoiceAttachmentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Removes an attachment from an invoice and permanently deletes the file. Attachments can be
     * removed only from invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to delete the
     *         attachment from.
     * @param  attachmentId  Required parameter: The ID of the
     *         [attachment](entity:InvoiceAttachment) to delete.
     * @return    Returns the DeleteInvoiceAttachmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteInvoiceAttachmentResponse deleteInvoiceAttachment(
            final String invoiceId,
            final String attachmentId) throws ApiException, IOException {
        return prepareDeleteInvoiceAttachmentRequest(invoiceId, attachmentId).execute();
    }

    /**
     * Removes an attachment from an invoice and permanently deletes the file. Attachments can be
     * removed only from invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to delete the
     *         attachment from.
     * @param  attachmentId  Required parameter: The ID of the
     *         [attachment](entity:InvoiceAttachment) to delete.
     * @return    Returns the DeleteInvoiceAttachmentResponse response from the API call
     */
    public CompletableFuture<DeleteInvoiceAttachmentResponse> deleteInvoiceAttachmentAsync(
            final String invoiceId,
            final String attachmentId) {
        try { 
            return prepareDeleteInvoiceAttachmentRequest(invoiceId, attachmentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteInvoiceAttachment.
     */
    private ApiCall<DeleteInvoiceAttachmentResponse, ApiException> prepareDeleteInvoiceAttachmentRequest(
            final String invoiceId,
            final String attachmentId) throws IOException {
        return new ApiCall.Builder<DeleteInvoiceAttachmentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/invoices/{invoice_id}/attachments/{attachment_id}")
                        .templateParam(param -> param.key("invoice_id").value(invoiceId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("attachment_id").value(attachmentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteInvoiceAttachmentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels an invoice. The seller cannot collect payments for the canceled invoice. You cannot
     * cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`,
     * `CANCELED`, or `FAILED`.
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to cancel.
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
     * @param  invoiceId  Required parameter: The ID of the [invoice](entity:Invoice) to cancel.
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Publishes the specified draft invoice. After an invoice is published, Square follows up based
     * on the invoice configuration. For example, Square sends the invoice to the customer's email
     * address, charges the customer's card on file, or does nothing. Square also makes the invoice
     * available on a Square-hosted invoice page. The invoice `status` also changes from `DRAFT` to
     * a status based on the invoice configuration. For example, the status changes to `UNPAID` if
     * Square emails the invoice or `PARTIALLY_PAID` if Square charges a card on file for a portion
     * of the invoice amount. In addition to the required `ORDERS_WRITE` and `INVOICES_WRITE`
     * permissions, `CUSTOMERS_READ` and `PAYMENTS_WRITE` are required when publishing invoices
     * configured for card-on-file payments.
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
     * Square emails the invoice or `PARTIALLY_PAID` if Square charges a card on file for a portion
     * of the invoice amount. In addition to the required `ORDERS_WRITE` and `INVOICES_WRITE`
     * permissions, `CUSTOMERS_READ` and `PAYMENTS_WRITE` are required when publishing invoices
     * configured for card-on-file payments.
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, PublishInvoiceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}