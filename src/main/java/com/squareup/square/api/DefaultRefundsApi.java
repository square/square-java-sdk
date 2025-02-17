
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.GetPaymentRefundResponse;
import com.squareup.square.models.ListPaymentRefundsResponse;
import com.squareup.square.models.RefundPaymentRequest;
import com.squareup.square.models.RefundPaymentResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultRefundsApi extends BaseApi implements RefundsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultRefundsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Retrieves a list of refunds for the account making the request. Results are eventually
     * consistent, and new refunds or changes to refunds might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed by
     *         `PaymentRefund.created_at`: - `ASC` - Oldest to newest. - `DESC` - Newest to oldest
     *         (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for all locations associated with the seller.
     * @param  status  Optional parameter: If provided, only refunds with the given status are
     *         returned. For a list of refund status values, see
     *         [PaymentRefund](entity:PaymentRefund). Default: If omitted, refunds are returned
     *         regardless of their status.
     * @param  sourceType  Optional parameter: If provided, only returns refunds whose payments have
     *         the indicated source type. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     *         `CASH`, and `EXTERNAL`. For information about these payment source types, see [Take
     *         Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default:
     *         If omitted, refunds are returned regardless of the source type.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. If the supplied value is greater than 100, no more than 100 results are
     *         returned. Default: 100
     * @param  updatedAtBeginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: if omitted, the time range starts at `beginTime`.
     * @param  updatedAtEndTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: The current time.
     * @param  sortField  Optional parameter: The field used to sort results by. The default is `CREATED_AT`.
     *         Current values include `CREATED_AT` and `UPDATED_AT`.
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPaymentRefundsResponse listPaymentRefunds(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit,
            final String updatedAtBeginTime,
            final String updatedAtEndTime,
            final String sortField) throws ApiException, IOException {
        return prepareListPaymentRefundsRequest(beginTime, endTime, sortOrder, cursor, locationId,
                status, sourceType, limit, updatedAtBeginTime, updatedAtEndTime, sortField).execute();
    }

    /**
     * Retrieves a list of refunds for the account making the request. Results are eventually
     * consistent, and new refunds or changes to refunds might take several seconds to appear. The
     * maximum results per page is 100.
     * @param  beginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time minus one
     *         year.
     * @param  endTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `created_at` field for each `PaymentRefund`. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which results are listed by
     *         `PaymentRefund.created_at`: - `ASC` - Oldest to newest. - `DESC` - Newest to oldest
     *         (default).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  locationId  Optional parameter: Limit results to the location supplied. By default,
     *         results are returned for all locations associated with the seller.
     * @param  status  Optional parameter: If provided, only refunds with the given status are
     *         returned. For a list of refund status values, see
     *         [PaymentRefund](entity:PaymentRefund). Default: If omitted, refunds are returned
     *         regardless of their status.
     * @param  sourceType  Optional parameter: If provided, only returns refunds whose payments have
     *         the indicated source type. Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`,
     *         `CASH`, and `EXTERNAL`. For information about these payment source types, see [Take
     *         Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default:
     *         If omitted, refunds are returned regardless of the source type.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. If the supplied value is greater than 100, no more than 100 results are
     *         returned. Default: 100
     * @param  updatedAtBeginTime  Optional parameter: Indicates the start of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: if omitted, the time range starts at `beginTime`.
     * @param  updatedAtEndTime  Optional parameter: Indicates the end of the time range to retrieve each
     *         `PaymentRefund` for, in RFC 3339 format. The range is determined using the
     *         `updated_at` field for each `PaymentRefund`. Default: The current time.
     * @param  sortField  Optional parameter: The field used to sort results by. The default is `CREATED_AT`.
     *         Current values include `CREATED_AT` and `UPDATED_AT`.
     * @return    Returns the ListPaymentRefundsResponse response from the API call
     */
    public CompletableFuture<ListPaymentRefundsResponse> listPaymentRefundsAsync(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit,
            final String updatedAtBeginTime,
            final String updatedAtEndTime,
            final String sortField) {
        try { 
            return prepareListPaymentRefundsRequest(beginTime, endTime, updatedAtBeginTime, updatedAtEndTime, sortField, sortOrder, cursor, locationId,
            status, sourceType, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listPaymentRefunds.
     */
    private ApiCall<ListPaymentRefundsResponse, ApiException> prepareListPaymentRefundsRequest(
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final String locationId,
            final String status,
            final String sourceType,
            final Integer limit,
            final String updatedAtBeginTime,
            final String updatedAtEndTime,
            final String sortField) throws IOException {
        return new ApiCall.Builder<ListPaymentRefundsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/refunds")
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("status")
                                .value(status).isRequired(false))
                        .queryParam(param -> param.key("source_type")
                                .value(sourceType).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("updated_at_begin_time")
                                .value(updatedAtBeginTime).isRequired(false))
                        .queryParam(param -> param.key("updated_at_end_time")
                                .value(updatedAtEndTime).isRequired(false))
                        .queryParam(param -> param.key("sort_field")
                                .value(sortField).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListPaymentRefundsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Refunds a payment. You can refund the entire payment amount or a portion of it. You can use
     * this endpoint to refund a card payment or record a refund of a cash or external payment. For
     * more information, see [Refund
     * Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RefundPaymentResponse refundPayment(
            final RefundPaymentRequest body) throws ApiException, IOException {
        return prepareRefundPaymentRequest(body).execute();
    }

    /**
     * Refunds a payment. You can refund the entire payment amount or a portion of it. You can use
     * this endpoint to refund a card payment or record a refund of a cash or external payment. For
     * more information, see [Refund
     * Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RefundPaymentResponse response from the API call
     */
    public CompletableFuture<RefundPaymentResponse> refundPaymentAsync(
            final RefundPaymentRequest body) {
        try { 
            return prepareRefundPaymentRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for refundPayment.
     */
    private ApiCall<RefundPaymentResponse, ApiException> prepareRefundPaymentRequest(
            final RefundPaymentRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RefundPaymentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/refunds")
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
                                response -> ApiHelper.deserialize(response, RefundPaymentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a specific refund using the `refund_id`.
     * @param  refundId  Required parameter: The unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetPaymentRefundResponse getPaymentRefund(
            final String refundId) throws ApiException, IOException {
        return prepareGetPaymentRefundRequest(refundId).execute();
    }

    /**
     * Retrieves a specific refund using the `refund_id`.
     * @param  refundId  Required parameter: The unique ID for the desired `PaymentRefund`.
     * @return    Returns the GetPaymentRefundResponse response from the API call
     */
    public CompletableFuture<GetPaymentRefundResponse> getPaymentRefundAsync(
            final String refundId) {
        try { 
            return prepareGetPaymentRefundRequest(refundId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getPaymentRefund.
     */
    private ApiCall<GetPaymentRefundResponse, ApiException> prepareGetPaymentRefundRequest(
            final String refundId) throws IOException {
        return new ApiCall.Builder<GetPaymentRefundResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/refunds/{refund_id}")
                        .templateParam(param -> param.key("refund_id").value(refundId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetPaymentRefundResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}