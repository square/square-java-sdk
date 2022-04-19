
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.GetPayoutResponse;
import com.squareup.square.models.ListPayoutEntriesResponse;
import com.squareup.square.models.ListPayoutsResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface PayoutsApi {
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
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListPayoutsResponse listPayouts(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws ApiException, IOException;

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
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutsResponse response from the API call
     */
    CompletableFuture<ListPayoutsResponse> listPayoutsAsync(
            final String locationId,
            final String status,
            final String beginTime,
            final String endTime,
            final String sortOrder,
            final String cursor,
            final Integer limit);

    /**
     * Retrieves details of a specific payout identified by a payout ID. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @return    Returns the GetPayoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetPayoutResponse getPayout(
            final String payoutId) throws ApiException, IOException;

    /**
     * Retrieves details of a specific payout identified by a payout ID. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @return    Returns the GetPayoutResponse response from the API call
     */
    CompletableFuture<GetPayoutResponse> getPayoutAsync(
            final String payoutId);

    /**
     * Retrieves a list of all payout entries for a specific payout. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @param  sortOrder  Optional parameter: The order in which payout entries are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutEntriesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListPayoutEntriesResponse listPayoutEntries(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit) throws ApiException, IOException;

    /**
     * Retrieves a list of all payout entries for a specific payout. To call this endpoint, set
     * `PAYOUTS_READ` for the OAuth scope.
     * @param  payoutId  Required parameter: The ID of the payout to retrieve the information for.
     * @param  sortOrder  Optional parameter: The order in which payout entries are listed.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If
     *         request parameters change between requests, subsequent results may contain duplicates
     *         or missing records.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. If the provided
     *         value is greater than 100, it is ignored and the default value is used instead.
     *         Default: `100`
     * @return    Returns the ListPayoutEntriesResponse response from the API call
     */
    CompletableFuture<ListPayoutEntriesResponse> listPayoutEntriesAsync(
            final String payoutId,
            final String sortOrder,
            final String cursor,
            final Integer limit);

}