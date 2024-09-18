
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.ListCashDrawerShiftEventsResponse;
import com.squareup.square.models.ListCashDrawerShiftsResponse;
import com.squareup.square.models.RetrieveCashDrawerShiftResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCashDrawersApi extends BaseApi implements CashDrawersApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCashDrawersApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Provides the details for all of the cash drawer shifts for a location in a date range.
     * @param  locationId  Required parameter: The ID of the location to query for a list of cash
     *         drawer shifts.
     * @param  sortOrder  Optional parameter: The order in which cash drawer shifts are listed in
     *         the response, based on their opened_at field. Default value: ASC
     * @param  beginTime  Optional parameter: The inclusive start time of the query on opened_at, in
     *         ISO 8601 format.
     * @param  endTime  Optional parameter: The exclusive end date of the query on opened_at, in ISO
     *         8601 format.
     * @param  limit  Optional parameter: Number of cash drawer shift events in a page of results
     *         (200 by default, 1000 max).
     * @param  cursor  Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCashDrawerShiftsResponse listCashDrawerShifts(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit,
                cursor).execute();
    }

    /**
     * Provides the details for all of the cash drawer shifts for a location in a date range.
     * @param  locationId  Required parameter: The ID of the location to query for a list of cash
     *         drawer shifts.
     * @param  sortOrder  Optional parameter: The order in which cash drawer shifts are listed in
     *         the response, based on their opened_at field. Default value: ASC
     * @param  beginTime  Optional parameter: The inclusive start time of the query on opened_at, in
     *         ISO 8601 format.
     * @param  endTime  Optional parameter: The exclusive end date of the query on opened_at, in ISO
     *         8601 format.
     * @param  limit  Optional parameter: Number of cash drawer shift events in a page of results
     *         (200 by default, 1000 max).
     * @param  cursor  Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftsResponse response from the API call
     */
    public CompletableFuture<ListCashDrawerShiftsResponse> listCashDrawerShiftsAsync(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCashDrawerShifts.
     */
    private ApiCall<ListCashDrawerShiftsResponse, ApiException> prepareListCashDrawerShiftsRequest(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListCashDrawerShiftsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cash-drawers/shifts")
                        .queryParam(param -> param.key("location_id")
                                .value(locationId))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCashDrawerShiftsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides the summary details for a single cash drawer shift. See
     * [ListCashDrawerShiftEvents]($e/CashDrawers/ListCashDrawerShiftEvents) for a list of cash
     * drawer shift events.
     * @param  locationId  Required parameter: The ID of the location to retrieve cash drawer shifts
     *         from.
     * @param  shiftId  Required parameter: The shift ID.
     * @return    Returns the RetrieveCashDrawerShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCashDrawerShiftResponse retrieveCashDrawerShift(
            final String locationId,
            final String shiftId) throws ApiException, IOException {
        return prepareRetrieveCashDrawerShiftRequest(locationId, shiftId).execute();
    }

    /**
     * Provides the summary details for a single cash drawer shift. See
     * [ListCashDrawerShiftEvents]($e/CashDrawers/ListCashDrawerShiftEvents) for a list of cash
     * drawer shift events.
     * @param  locationId  Required parameter: The ID of the location to retrieve cash drawer shifts
     *         from.
     * @param  shiftId  Required parameter: The shift ID.
     * @return    Returns the RetrieveCashDrawerShiftResponse response from the API call
     */
    public CompletableFuture<RetrieveCashDrawerShiftResponse> retrieveCashDrawerShiftAsync(
            final String locationId,
            final String shiftId) {
        try { 
            return prepareRetrieveCashDrawerShiftRequest(locationId, shiftId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCashDrawerShift.
     */
    private ApiCall<RetrieveCashDrawerShiftResponse, ApiException> prepareRetrieveCashDrawerShiftRequest(
            final String locationId,
            final String shiftId) throws IOException {
        return new ApiCall.Builder<RetrieveCashDrawerShiftResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cash-drawers/shifts/{shift_id}")
                        .queryParam(param -> param.key("location_id")
                                .value(locationId))
                        .templateParam(param -> param.key("shift_id").value(shiftId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCashDrawerShiftResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Provides a paginated list of events for a single cash drawer shift.
     * @param  locationId  Required parameter: The ID of the location to list cash drawer shifts
     *         for.
     * @param  shiftId  Required parameter: The shift ID.
     * @param  limit  Optional parameter: Number of resources to be returned in a page of results
     *         (200 by default, 1000 max).
     * @param  cursor  Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCashDrawerShiftEventsResponse listCashDrawerShiftEvents(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListCashDrawerShiftEventsRequest(locationId, shiftId, limit,
                cursor).execute();
    }

    /**
     * Provides a paginated list of events for a single cash drawer shift.
     * @param  locationId  Required parameter: The ID of the location to list cash drawer shifts
     *         for.
     * @param  shiftId  Required parameter: The shift ID.
     * @param  limit  Optional parameter: Number of resources to be returned in a page of results
     *         (200 by default, 1000 max).
     * @param  cursor  Optional parameter: Opaque cursor for fetching the next page of results.
     * @return    Returns the ListCashDrawerShiftEventsResponse response from the API call
     */
    public CompletableFuture<ListCashDrawerShiftEventsResponse> listCashDrawerShiftEventsAsync(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListCashDrawerShiftEventsRequest(locationId, shiftId, limit,
            cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCashDrawerShiftEvents.
     */
    private ApiCall<ListCashDrawerShiftEventsResponse, ApiException> prepareListCashDrawerShiftEventsRequest(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListCashDrawerShiftEventsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cash-drawers/shifts/{shift_id}/events")
                        .queryParam(param -> param.key("location_id")
                                .value(locationId))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .templateParam(param -> param.key("shift_id").value(shiftId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCashDrawerShiftEventsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}