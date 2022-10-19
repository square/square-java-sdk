
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.V1CreateRefundRequest;
import com.squareup.square.models.V1Order;
import com.squareup.square.models.V1Payment;
import com.squareup.square.models.V1Refund;
import com.squareup.square.models.V1Settlement;
import com.squareup.square.models.V1UpdateOrderRequest;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultV1TransactionsApi extends BaseApi implements V1TransactionsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultV1TransactionsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Provides summary information for a merchant's online store orders.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list online store orders
     *         for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Order response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Order> v1ListOrders(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) throws ApiException, IOException {
        return prepareV1ListOrdersRequest(locationId, order, limit, batchToken).execute();
    }

    /**
     * Provides summary information for a merchant's online store orders.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list online store orders
     *         for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Order response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Order>> v1ListOrdersAsync(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) {
        try { 
            return prepareV1ListOrdersRequest(locationId, order, limit, batchToken).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1ListOrders.
     */
    private ApiCall<List<V1Order>, ApiException> prepareV1ListOrdersRequest(
            final String locationId,
            final String order,
            final Integer limit,
            final String batchToken) throws IOException {
        return new ApiCall.Builder<List<V1Order>, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/orders")
                        .queryParam(param -> param.key("order")
                                .value(order).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("batch_token")
                                .value(batchToken).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserializeArray(response,
                                        V1Order[].class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> {
                                for (int i = 0; i < result.size(); i++) {
                                result.set(i, result.get(i).toBuilder()
                                        .httpContext((HttpContext)context).build());
                                }
                                return result;
                                })
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides comprehensive information for a single online store order, including the order's
     * history.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Order v1RetrieveOrder(
            final String locationId,
            final String orderId) throws ApiException, IOException {
        return prepareV1RetrieveOrderRequest(locationId, orderId).execute();
    }

    /**
     * Provides comprehensive information for a single online store order, including the order's
     * history.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @return    Returns the V1Order response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Order> v1RetrieveOrderAsync(
            final String locationId,
            final String orderId) {
        try { 
            return prepareV1RetrieveOrderRequest(locationId, orderId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1RetrieveOrder.
     */
    private ApiCall<V1Order, ApiException> prepareV1RetrieveOrderRequest(
            final String locationId,
            final String orderId) throws IOException {
        return new ApiCall.Builder<V1Order, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/orders/{order_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("order_id").value(orderId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Order.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates the details of an online store order. Every update you perform on an order
     * corresponds to one of three actions:.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Order v1UpdateOrder(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) throws ApiException, IOException {
        return prepareV1UpdateOrderRequest(locationId, orderId, body).execute();
    }

    /**
     * Updates the details of an online store order. Every update you perform on an order
     * corresponds to one of three actions:.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the order's associated location.
     * @param  orderId  Required parameter: The order's Square-issued ID. You obtain this value from
     *         Order objects returned by the List Orders endpoint
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Order response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Order> v1UpdateOrderAsync(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) {
        try { 
            return prepareV1UpdateOrderRequest(locationId, orderId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1UpdateOrder.
     */
    private ApiCall<V1Order, ApiException> prepareV1UpdateOrderRequest(
            final String locationId,
            final String orderId,
            final V1UpdateOrderRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<V1Order, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/orders/{order_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("order_id").value(orderId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Order.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides summary information for all payments taken for a given Square account during a date
     * range. Date ranges cannot exceed 1 year in length. See Date ranges for details of inclusive
     * and exclusive dates. *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours. Offline payments have a
     * `created_at` value that reflects the time the payment was originally processed, not the time
     * it was subsequently transmitted to Square. Consequently, the ListPayments endpoint might list
     * an offline payment chronologically between online payments that were seen in a previous
     * request.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list payments for. If you
     *         specify me, this endpoint returns payments aggregated from all of the business's
     *         locations.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @param  includePartial  Optional parameter: Indicates whether or not to include partial
     *         payments in the response. Partial payments will have the tenders collected so far,
     *         but the itemizations will be empty until the payment is completed.
     * @return    Returns the List of V1Payment response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Payment> v1ListPayments(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) throws ApiException, IOException {
        return prepareV1ListPaymentsRequest(locationId, order, beginTime, endTime, limit,
                batchToken, includePartial).execute();
    }

    /**
     * Provides summary information for all payments taken for a given Square account during a date
     * range. Date ranges cannot exceed 1 year in length. See Date ranges for details of inclusive
     * and exclusive dates. *Note**: Details for payments processed with Square Point of Sale while
     * in offline mode may not be transmitted to Square for up to 72 hours. Offline payments have a
     * `created_at` value that reflects the time the payment was originally processed, not the time
     * it was subsequently transmitted to Square. Consequently, the ListPayments endpoint might list
     * an offline payment chronologically between online payments that were seen in a previous
     * request.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list payments for. If you
     *         specify me, this endpoint returns payments aggregated from all of the business's
     *         locations.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of payments to return in a single
     *         response. This value cannot exceed 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @param  includePartial  Optional parameter: Indicates whether or not to include partial
     *         payments in the response. Partial payments will have the tenders collected so far,
     *         but the itemizations will be empty until the payment is completed.
     * @return    Returns the List of V1Payment response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Payment>> v1ListPaymentsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) {
        try { 
            return prepareV1ListPaymentsRequest(locationId, order, beginTime, endTime, limit, batchToken,
            includePartial).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1ListPayments.
     */
    private ApiCall<List<V1Payment>, ApiException> prepareV1ListPaymentsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken,
            final Boolean includePartial) throws IOException {
        return new ApiCall.Builder<List<V1Payment>, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/payments")
                        .queryParam(param -> param.key("order")
                                .value(order).isRequired(false))
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("batch_token")
                                .value(batchToken).isRequired(false))
                        .queryParam(param -> param.key("include_partial")
                                .value((includePartial != null) ? includePartial : false).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserializeArray(response,
                                        V1Payment[].class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> {
                                for (int i = 0; i < result.size(); i++) {
                                result.set(i, result.get(i).toBuilder()
                                        .httpContext((HttpContext)context).build());
                                }
                                return result;
                                })
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides comprehensive information for a single payment.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the payment's associated location.
     * @param  paymentId  Required parameter: The Square-issued payment ID. payment_id comes from
     *         Payment objects returned by the List Payments endpoint, Settlement objects returned
     *         by the List Settlements endpoint, or Refund objects returned by the List Refunds
     *         endpoint.
     * @return    Returns the V1Payment response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Payment v1RetrievePayment(
            final String locationId,
            final String paymentId) throws ApiException, IOException {
        return prepareV1RetrievePaymentRequest(locationId, paymentId).execute();
    }

    /**
     * Provides comprehensive information for a single payment.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the payment's associated location.
     * @param  paymentId  Required parameter: The Square-issued payment ID. payment_id comes from
     *         Payment objects returned by the List Payments endpoint, Settlement objects returned
     *         by the List Settlements endpoint, or Refund objects returned by the List Refunds
     *         endpoint.
     * @return    Returns the V1Payment response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Payment> v1RetrievePaymentAsync(
            final String locationId,
            final String paymentId) {
        try { 
            return prepareV1RetrievePaymentRequest(locationId, paymentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1RetrievePayment.
     */
    private ApiCall<V1Payment, ApiException> prepareV1RetrievePaymentRequest(
            final String locationId,
            final String paymentId) throws IOException {
        return new ApiCall.Builder<V1Payment, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/payments/{payment_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("payment_id").value(paymentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Payment.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile
     * staff during a date range. Date ranges cannot exceed one year in length.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The approximate number of refunds to return in a single
     *         response. Default: 100. Max: 200. Response may contain more results than the
     *         prescribed limit when refunds are made simultaneously to multiple tenders in a
     *         payment or when refunds are generated in an exchange to account for the value of
     *         returned goods.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Refund response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Refund> v1ListRefunds(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) throws ApiException, IOException {
        return prepareV1ListRefundsRequest(locationId, order, beginTime, endTime, limit,
                batchToken).execute();
    }

    /**
     * Provides the details for all refunds initiated by a merchant or any of the merchant's mobile
     * staff during a date range. Date ranges cannot exceed one year in length.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list refunds for.
     * @param  order  Optional parameter: The order in which payments are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The approximate number of refunds to return in a single
     *         response. Default: 100. Max: 200. Response may contain more results than the
     *         prescribed limit when refunds are made simultaneously to multiple tenders in a
     *         payment or when refunds are generated in an exchange to account for the value of
     *         returned goods.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Refund response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Refund>> v1ListRefundsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) {
        try { 
            return prepareV1ListRefundsRequest(locationId, order, beginTime, endTime, limit,
            batchToken).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1ListRefunds.
     */
    private ApiCall<List<V1Refund>, ApiException> prepareV1ListRefundsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String batchToken) throws IOException {
        return new ApiCall.Builder<List<V1Refund>, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/refunds")
                        .queryParam(param -> param.key("order")
                                .value(order).isRequired(false))
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("batch_token")
                                .value(batchToken).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserializeArray(response,
                                        V1Refund[].class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> {
                                for (int i = 0; i < result.size(); i++) {
                                result.set(i, result.get(i).toBuilder()
                                        .httpContext((HttpContext)context).build());
                                }
                                return result;
                                })
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Issues a refund for a previously processed payment. You must issue a refund within 60 days of
     * the associated payment. You cannot issue a partial refund for a split tender payment. You
     * must instead issue a full or partial refund for a particular tender, by providing the
     * applicable tender id to the V1CreateRefund endpoint. Issuing a full refund for a split tender
     * payment refunds all tenders associated with the payment. Issuing a refund for a card payment
     * is not reversible. For development purposes, you can create fake cash payments in Square
     * Point of Sale and refund them.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original payment's associated location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Refund v1CreateRefund(
            final String locationId,
            final V1CreateRefundRequest body) throws ApiException, IOException {
        return prepareV1CreateRefundRequest(locationId, body).execute();
    }

    /**
     * Issues a refund for a previously processed payment. You must issue a refund within 60 days of
     * the associated payment. You cannot issue a partial refund for a split tender payment. You
     * must instead issue a full or partial refund for a particular tender, by providing the
     * applicable tender id to the V1CreateRefund endpoint. Issuing a full refund for a split tender
     * payment refunds all tenders associated with the payment. Issuing a refund for a card payment
     * is not reversible. For development purposes, you can create fake cash payments in Square
     * Point of Sale and refund them.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the original payment's associated location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Refund response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Refund> v1CreateRefundAsync(
            final String locationId,
            final V1CreateRefundRequest body) {
        try { 
            return prepareV1CreateRefundRequest(locationId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1CreateRefund.
     */
    private ApiCall<V1Refund, ApiException> prepareV1CreateRefundRequest(
            final String locationId,
            final V1CreateRefundRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<V1Refund, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/refunds")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Refund.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides summary information for all deposits and withdrawals initiated by Square to a linked
     * bank account during a date range. Date ranges cannot exceed one year in length. *Note**: the
     * ListSettlements endpoint does not provide entry information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list settlements for. If
     *         you specify me, this endpoint returns settlements aggregated from all of the
     *         business's locations.
     * @param  order  Optional parameter: The order in which settlements are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of settlements to return in a single
     *         response. This value cannot exceed 200.
     * @param  status  Optional parameter: Provide this parameter to retrieve only settlements with
     *         a particular status (SENT or FAILED).
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Settlement response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public List<V1Settlement> v1ListSettlements(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) throws ApiException, IOException {
        return prepareV1ListSettlementsRequest(locationId, order, beginTime, endTime, limit, status,
                batchToken).execute();
    }

    /**
     * Provides summary information for all deposits and withdrawals initiated by Square to a linked
     * bank account during a date range. Date ranges cannot exceed one year in length. *Note**: the
     * ListSettlements endpoint does not provide entry information.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list settlements for. If
     *         you specify me, this endpoint returns settlements aggregated from all of the
     *         business's locations.
     * @param  order  Optional parameter: The order in which settlements are listed in the response.
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this
     *         endpoint returns an error. Default value: The current time minus one year.
     * @param  endTime  Optional parameter: The end of the requested reporting period, in ISO 8601
     *         format. If this value is more than one year greater than begin_time, this endpoint
     *         returns an error. Default value: The current time.
     * @param  limit  Optional parameter: The maximum number of settlements to return in a single
     *         response. This value cannot exceed 200.
     * @param  status  Optional parameter: Provide this parameter to retrieve only settlements with
     *         a particular status (SENT or FAILED).
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Settlement response from the API call
     */
    @Deprecated
    public CompletableFuture<List<V1Settlement>> v1ListSettlementsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) {
        try { 
            return prepareV1ListSettlementsRequest(locationId, order, beginTime, endTime, limit, status,
            batchToken).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1ListSettlements.
     */
    private ApiCall<List<V1Settlement>, ApiException> prepareV1ListSettlementsRequest(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String status,
            final String batchToken) throws IOException {
        return new ApiCall.Builder<List<V1Settlement>, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/settlements")
                        .queryParam(param -> param.key("order")
                                .value(order).isRequired(false))
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("status")
                                .value(status).isRequired(false))
                        .queryParam(param -> param.key("batch_token")
                                .value(batchToken).isRequired(false))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserializeArray(response,
                                        V1Settlement[].class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> {
                                for (int i = 0; i < result.size(); i++) {
                                result.set(i, result.get(i).toBuilder()
                                        .httpContext((HttpContext)context).build());
                                }
                                return result;
                                })
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides comprehensive information for a single settlement. The returned `Settlement` objects
     * include an `entries` field that lists the transactions that contribute to the settlement
     * total. Most settlement entries correspond to a payment payout, but settlement entries are
     * also generated for less common events, like refunds, manual adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the [Deposit Options with
     * Square](https://squareup.com/help/us/en/article/3807) help article. Details for a regular
     * deposit are usually not available from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only whether it has failed.
     * A completed settlement is typically reflected in a bank account within 3 business days, but
     * in exceptional cases it may take longer.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the settlements's associated location.
     * @param  settlementId  Required parameter: The settlement's Square-issued ID. You obtain this
     *         value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public V1Settlement v1RetrieveSettlement(
            final String locationId,
            final String settlementId) throws ApiException, IOException {
        return prepareV1RetrieveSettlementRequest(locationId, settlementId).execute();
    }

    /**
     * Provides comprehensive information for a single settlement. The returned `Settlement` objects
     * include an `entries` field that lists the transactions that contribute to the settlement
     * total. Most settlement entries correspond to a payment payout, but settlement entries are
     * also generated for less common events, like refunds, manual adjustments, or chargeback holds.
     * Square initiates its regular deposits as indicated in the [Deposit Options with
     * Square](https://squareup.com/help/us/en/article/3807) help article. Details for a regular
     * deposit are usually not available from Connect API endpoints before 10 p.m. PST the same day.
     * Square does not know when an initiated settlement **completes**, only whether it has failed.
     * A completed settlement is typically reflected in a bank account within 3 business days, but
     * in exceptional cases it may take longer.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the settlements's associated location.
     * @param  settlementId  Required parameter: The settlement's Square-issued ID. You obtain this
     *         value from Settlement objects returned by the List Settlements endpoint.
     * @return    Returns the V1Settlement response from the API call
     */
    @Deprecated
    public CompletableFuture<V1Settlement> v1RetrieveSettlementAsync(
            final String locationId,
            final String settlementId) {
        try { 
            return prepareV1RetrieveSettlementRequest(locationId, settlementId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for v1RetrieveSettlement.
     */
    private ApiCall<V1Settlement, ApiException> prepareV1RetrieveSettlementRequest(
            final String locationId,
            final String settlementId) throws IOException {
        return new ApiCall.Builder<V1Settlement, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v1/{location_id}/settlements/{settlement_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("settlement_id").value(settlementId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Settlement.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}