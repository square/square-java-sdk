
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateGiftCardActivityRequest;
import com.squareup.square.models.CreateGiftCardActivityResponse;
import com.squareup.square.models.ListGiftCardActivitiesResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface GiftCardActivitiesApi {
    /**
     * Lists gift card activities. By default, you get gift card activities for all gift cards in
     * the seller's account. You can optionally specify query parameters to filter the list. For
     * example, you can get a list of gift card activities for a gift card, for all gift cards in a
     * specific region, or for activities within a time window.
     * @param  giftCardId  Optional parameter: If a gift card ID is provided, the endpoint returns
     *         activities related to the specified gift card. Otherwise, the endpoint returns all
     *         gift card activities for the seller.
     * @param  type  Optional parameter: If a [type]($m/GiftCardActivityType) is provided, the
     *         endpoint returns gift card activities of the specified type. Otherwise, the endpoint
     *         returns all types of gift card activities.
     * @param  locationId  Optional parameter: If a location ID is provided, the endpoint returns
     *         gift card activities for the specified location. Otherwise, the endpoint returns gift
     *         card activities for all locations.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. This start time is inclusive. The default value is the
     *         current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. This end time is inclusive. The default value is the current time.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns the specified
     *         number of results (or fewer) per page. The maximum value is 100. The default value is
     *         50. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  sortOrder  Optional parameter: The order in which the endpoint returns the
     *         activities, based on `created_at`. - `ASC` - Oldest to newest. - `DESC` - Newest to
     *         oldest (default).
     * @return    Returns the ListGiftCardActivitiesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListGiftCardActivitiesResponse listGiftCardActivities(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) throws ApiException, IOException;

    /**
     * Lists gift card activities. By default, you get gift card activities for all gift cards in
     * the seller's account. You can optionally specify query parameters to filter the list. For
     * example, you can get a list of gift card activities for a gift card, for all gift cards in a
     * specific region, or for activities within a time window.
     * @param  giftCardId  Optional parameter: If a gift card ID is provided, the endpoint returns
     *         activities related to the specified gift card. Otherwise, the endpoint returns all
     *         gift card activities for the seller.
     * @param  type  Optional parameter: If a [type]($m/GiftCardActivityType) is provided, the
     *         endpoint returns gift card activities of the specified type. Otherwise, the endpoint
     *         returns all types of gift card activities.
     * @param  locationId  Optional parameter: If a location ID is provided, the endpoint returns
     *         gift card activities for the specified location. Otherwise, the endpoint returns gift
     *         card activities for all locations.
     * @param  beginTime  Optional parameter: The timestamp for the beginning of the reporting
     *         period, in RFC 3339 format. This start time is inclusive. The default value is the
     *         current time minus one year.
     * @param  endTime  Optional parameter: The timestamp for the end of the reporting period, in
     *         RFC 3339 format. This end time is inclusive. The default value is the current time.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns the specified
     *         number of results (or fewer) per page. The maximum value is 100. The default value is
     *         50. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  sortOrder  Optional parameter: The order in which the endpoint returns the
     *         activities, based on `created_at`. - `ASC` - Oldest to newest. - `DESC` - Newest to
     *         oldest (default).
     * @return    Returns the ListGiftCardActivitiesResponse response from the API call
     */
    CompletableFuture<ListGiftCardActivitiesResponse> listGiftCardActivitiesAsync(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder);

    /**
     * Creates a gift card activity to manage the balance or state of a [gift card]($m/GiftCard).
     * For example, you create an `ACTIVATE` activity to activate a gift card with an initial
     * balance before the gift card can be used.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardActivityResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateGiftCardActivityResponse createGiftCardActivity(
            final CreateGiftCardActivityRequest body) throws ApiException, IOException;

    /**
     * Creates a gift card activity to manage the balance or state of a [gift card]($m/GiftCard).
     * For example, you create an `ACTIVATE` activity to activate a gift card with an initial
     * balance before the gift card can be used.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardActivityResponse response from the API call
     */
    CompletableFuture<CreateGiftCardActivityResponse> createGiftCardActivityAsync(
            final CreateGiftCardActivityRequest body);

}