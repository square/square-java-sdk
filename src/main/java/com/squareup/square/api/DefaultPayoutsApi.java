
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.GetPayoutResponse;
import com.squareup.square.models.ListPayoutEntriesResponse;
import com.squareup.square.models.ListPayoutsResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultPayoutsApi extends BaseApi implements PayoutsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultPayoutsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Retrieves a list of all payouts for the default location. You can filter payouts by location
     * ID, status, time range, and order them in ascending or descending order. To call this
     * endpoint, set `PAYOUTS_READ` for the OAuth scope.
     * @param  locationId  Optional parameter: The ID of the location for which to list the payouts.
     *         By default, payouts are returned for the default (main) location associated with the
     *         seller.
     * @param  status  Optional parameter: If provided, only payouts with the given status are
     *         returned.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the payout creation
     *         time, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the payout creation time,
     *         in RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which payouts are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     *         If request parameters change between requests, subsequent results may contain
     *         duplicates or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPayoutsResponse listPayouts(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListPayoutsRequest(locationId, status, beginTime, endTime, sortOrder, cursor,
                limit).execute();
    }

    /**
     * Retrieves a list of all payouts for the default location. You can filter payouts by location
     * ID, status, time range, and order them in ascending or descending order. To call this
     * endpoint, set `PAYOUTS_READ` for the OAuth scope.
     * @param  locationId  Optional parameter: The ID of the location for which to list the payouts.
     *         By default, payouts are returned for the default (main) location associated with the
     *         seller.
     * @param  status  Optional parameter: If provided, only payouts with the given status are
     *         returned.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the payout creation
     *         time, in RFC 3339 format. Inclusive. Default: The current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the payout creation time,
     *         in RFC 3339 format. Default: The current time.
     * @param  sortOrder  Optional parameter: The order in which payouts are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     *         If request parameters change between requests, subsequent results may contain
     *         duplicates or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutsResponse response from the API call
     */
    public CompletableFuture<ListPayoutsResponse> listPayoutsAsync(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListPayoutsRequest(locationId, status, beginTime, endTime, sortOrder, cursor,
            limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listPayouts.
     */
    private ApiCall<ListPayoutsResponse, ApiException> prepareListPayoutsRequest(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListPayoutsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payouts")
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("status")
                                .value(status).isRequired(false))
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
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
                                response -> ApiHelper.deserialize(response, ListPayoutsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves details of a specific payout identified by a payout ID. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @return    Returns the GetPayoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetPayoutResponse getPayout(
            final String payoutId) throws ApiException, IOException {
        return prepareGetPayoutRequest(payoutId).execute();
    }

    /**
     * Retrieves details of a specific payout identified by a payout ID. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @return    Returns the GetPayoutResponse response from the API call
     */
    public CompletableFuture<GetPayoutResponse> getPayoutAsync(
            final String payoutId) {
        try { 
            return prepareGetPayoutRequest(payoutId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getPayout.
     */
    private ApiCall<GetPayoutResponse, ApiException> prepareGetPayoutRequest(
            final String payoutId) throws IOException {
        return new ApiCall.Builder<GetPayoutResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payouts/{payout_id}")
                        .templateParam(param -> param.key("payout_id").value(payoutId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetPayoutResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a list of all payout entries for a specific payout. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @param  sortOrder  Optional parameter: The order in which payout entries are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     *         If request parameters change between requests, subsequent results may contain
     *         duplicates or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutEntriesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPayoutEntriesResponse listPayoutEntries(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListPayoutEntriesRequest(payoutId, sortOrder, cursor, limit).execute();
    }

    /**
     * Retrieves a list of all payout entries for a specific payout. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @param  sortOrder  Optional parameter: The order in which payout entries are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     *         If request parameters change between requests, subsequent results may contain
     *         duplicates or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutEntriesResponse response from the API call
     */
    public CompletableFuture<ListPayoutEntriesResponse> listPayoutEntriesAsync(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListPayoutEntriesRequest(payoutId, sortOrder, cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listPayoutEntries.
     */
    private ApiCall<ListPayoutEntriesResponse, ApiException> prepareListPayoutEntriesRequest(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListPayoutEntriesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/payouts/{payout_id}/payout-entries")
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .templateParam(param -> param.key("payout_id").value(payoutId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListPayoutEntriesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}