
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.V1Order;
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserializeArray(response,
                                        V1Order[].class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> {
                                for (int i = 0; i < result.size(); i++) {
                                result.set(i, result.get(i).toBuilder()
                                        .httpContext((HttpContext) context).build());
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Order.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
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
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, V1Order.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}