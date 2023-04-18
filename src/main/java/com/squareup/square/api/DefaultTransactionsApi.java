
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CaptureTransactionResponse;
import com.squareup.square.models.ListTransactionsResponse;
import com.squareup.square.models.RetrieveTransactionResponse;
import com.squareup.square.models.VoidTransactionResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTransactionsApi extends BaseApi implements TransactionsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultTransactionsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](https://developer.squareup.com/docs/working-with-apis/pagination): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating
     *         results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     *         information.
     * @return    Returns the ListTransactionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListTransactionsResponse listTransactions(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws ApiException, IOException {
        return prepareListTransactionsRequest(locationId, beginTime, endTime, sortOrder,
                cursor).execute();
    }

    /**
     * Lists transactions for a particular location. Transactions include payment information from
     * sales and exchanges and refund information from returns and exchanges. Max results per
     * [page](https://developer.squareup.com/docs/working-with-apis/pagination): 50.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list transactions for.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         RFC 3339 format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in RFC 3339
     *         format. See [Date
     *         ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for
     *         details on date inclusivity/exclusivity. Default value: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed in the response
     *         (`ASC` for oldest first, `DESC` for newest first). Default value: `DESC`
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating
     *         results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     *         information.
     * @return    Returns the ListTransactionsResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListTransactionsResponse> listTransactionsAsync(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) {
        try { 
            return prepareListTransactionsRequest(locationId, beginTime, endTime, sortOrder,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listTransactions.
     */
    private ApiCall<ListTransactionsResponse, ApiException> prepareListTransactionsRequest(
            final String locationId,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListTransactionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/transactions")
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListTransactionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves details for a single transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the transaction's associated location.
     * @param  transactionId  Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RetrieveTransactionResponse retrieveTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException {
        return prepareRetrieveTransactionRequest(locationId, transactionId).execute();
    }

    /**
     * Retrieves details for a single transaction.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the transaction's associated location.
     * @param  transactionId  Required parameter: The ID of the transaction to retrieve.
     * @return    Returns the RetrieveTransactionResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveTransactionResponse> retrieveTransactionAsync(
            final String locationId,
            final String transactionId) {
        try { 
            return prepareRetrieveTransactionRequest(locationId, transactionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveTransaction.
     */
    private ApiCall<RetrieveTransactionResponse, ApiException> prepareRetrieveTransactionRequest(
            final String locationId,
            final String transactionId) throws IOException {
        return new ApiCall.Builder<RetrieveTransactionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/transactions/{transaction_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("transaction_id").value(transactionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveTransactionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Captures a transaction that was created with the [Charge](api-endpoint:Transactions-Charge)
     * endpoint with a `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the CaptureTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public CaptureTransactionResponse captureTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException {
        return prepareCaptureTransactionRequest(locationId, transactionId).execute();
    }

    /**
     * Captures a transaction that was created with the [Charge](api-endpoint:Transactions-Charge)
     * endpoint with a `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the CaptureTransactionResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<CaptureTransactionResponse> captureTransactionAsync(
            final String locationId,
            final String transactionId) {
        try { 
            return prepareCaptureTransactionRequest(locationId, transactionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for captureTransaction.
     */
    private ApiCall<CaptureTransactionResponse, ApiException> prepareCaptureTransactionRequest(
            final String locationId,
            final String transactionId) throws IOException {
        return new ApiCall.Builder<CaptureTransactionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/transactions/{transaction_id}/capture")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("transaction_id").value(transactionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CaptureTransactionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels a transaction that was created with the [Charge](api-endpoint:Transactions-Charge)
     * endpoint with a `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the VoidTransactionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public VoidTransactionResponse voidTransaction(
            final String locationId,
            final String transactionId) throws ApiException, IOException {
        return prepareVoidTransactionRequest(locationId, transactionId).execute();
    }

    /**
     * Cancels a transaction that was created with the [Charge](api-endpoint:Transactions-Charge)
     * endpoint with a `delay_capture` value of `true`. See [Delayed capture
     * transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
     * for more information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: Example:
     * @param  transactionId  Required parameter: Example:
     * @return    Returns the VoidTransactionResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<VoidTransactionResponse> voidTransactionAsync(
            final String locationId,
            final String transactionId) {
        try { 
            return prepareVoidTransactionRequest(locationId, transactionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for voidTransaction.
     */
    private ApiCall<VoidTransactionResponse, ApiException> prepareVoidTransactionRequest(
            final String locationId,
            final String transactionId) throws IOException {
        return new ApiCall.Builder<VoidTransactionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/transactions/{transaction_id}/void")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("transaction_id").value(transactionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, VoidTransactionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}