
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListCashDrawerShiftEventsResponse;
import com.squareup.square.models.ListCashDrawerShiftsResponse;
import com.squareup.square.models.RetrieveCashDrawerShiftResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CashDrawersApi {
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
    ListCashDrawerShiftsResponse listCashDrawerShifts(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

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
    CompletableFuture<ListCashDrawerShiftsResponse> listCashDrawerShiftsAsync(
            final String locationId,
            final String sortOrder,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor);

    /**
     * Provides the summary details for a single cash drawer shift. See
     * RetrieveCashDrawerShiftEvents for a list of cash drawer shift events.
     * @param  locationId  Required parameter: The ID of the location to retrieve cash drawer shifts
     *         from.
     * @param  shiftId  Required parameter: The shift ID.
     * @return    Returns the RetrieveCashDrawerShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveCashDrawerShiftResponse retrieveCashDrawerShift(
            final String locationId,
            final String shiftId) throws ApiException, IOException;

    /**
     * Provides the summary details for a single cash drawer shift. See
     * RetrieveCashDrawerShiftEvents for a list of cash drawer shift events.
     * @param  locationId  Required parameter: The ID of the location to retrieve cash drawer shifts
     *         from.
     * @param  shiftId  Required parameter: The shift ID.
     * @return    Returns the RetrieveCashDrawerShiftResponse response from the API call
     */
    CompletableFuture<RetrieveCashDrawerShiftResponse> retrieveCashDrawerShiftAsync(
            final String locationId,
            final String shiftId);

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
    ListCashDrawerShiftEventsResponse listCashDrawerShiftEvents(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

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
    CompletableFuture<ListCashDrawerShiftEventsResponse> listCashDrawerShiftEventsAsync(
            final String locationId,
            final String shiftId,
            final Integer limit,
            final String cursor);

}