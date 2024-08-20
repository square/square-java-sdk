
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateGiftCardActivityRequest;
import com.squareup.square.models.CreateGiftCardActivityResponse;
import com.squareup.square.models.ListGiftCardActivitiesResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultGiftCardActivitiesApi extends BaseApi implements GiftCardActivitiesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultGiftCardActivitiesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists gift card activities. By default, you get gift card activities for all gift cards in
     * the seller's account. You can optionally specify query parameters to filter the list. For
     * example, you can get a list of gift card activities for a gift card, for all gift cards in a
     * specific region, or for activities within a time window.
     * @param  giftCardId  Optional parameter: If a gift card ID is provided, the endpoint returns
     *         activities related to the specified gift card. Otherwise, the endpoint returns all
     *         gift card activities for the seller.
     * @param  type  Optional parameter: If a [type](entity:GiftCardActivityType) is provided, the
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
    public ListGiftCardActivitiesResponse listGiftCardActivities(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) throws ApiException, IOException {
        return prepareListGiftCardActivitiesRequest(giftCardId, type, locationId, beginTime,
                endTime, limit, cursor, sortOrder).execute();
    }

    /**
     * Lists gift card activities. By default, you get gift card activities for all gift cards in
     * the seller's account. You can optionally specify query parameters to filter the list. For
     * example, you can get a list of gift card activities for a gift card, for all gift cards in a
     * specific region, or for activities within a time window.
     * @param  giftCardId  Optional parameter: If a gift card ID is provided, the endpoint returns
     *         activities related to the specified gift card. Otherwise, the endpoint returns all
     *         gift card activities for the seller.
     * @param  type  Optional parameter: If a [type](entity:GiftCardActivityType) is provided, the
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
    public CompletableFuture<ListGiftCardActivitiesResponse> listGiftCardActivitiesAsync(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) {
        try { 
            return prepareListGiftCardActivitiesRequest(giftCardId, type, locationId, beginTime, endTime,
            limit, cursor, sortOrder).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listGiftCardActivities.
     */
    private ApiCall<ListGiftCardActivitiesResponse, ApiException> prepareListGiftCardActivitiesRequest(
            final String giftCardId,
            final String type,
            final String locationId,
            final String beginTime,
            final String endTime,
            final Integer limit,
            final String cursor,
            final String sortOrder) throws IOException {
        return new ApiCall.Builder<ListGiftCardActivitiesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/activities")
                        .queryParam(param -> param.key("gift_card_id")
                                .value(giftCardId).isRequired(false))
                        .queryParam(param -> param.key("type")
                                .value(type).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("begin_time")
                                .value(beginTime).isRequired(false))
                        .queryParam(param -> param.key("end_time")
                                .value(endTime).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListGiftCardActivitiesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a gift card activity to manage the balance or state of a [gift card]($m/GiftCard).
     * For example, create an `ACTIVATE` activity to activate a gift card with an initial balance
     * before first use.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardActivityResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateGiftCardActivityResponse createGiftCardActivity(
            final CreateGiftCardActivityRequest body) throws ApiException, IOException {
        return prepareCreateGiftCardActivityRequest(body).execute();
    }

    /**
     * Creates a gift card activity to manage the balance or state of a [gift card]($m/GiftCard).
     * For example, create an `ACTIVATE` activity to activate a gift card with an initial balance
     * before first use.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardActivityResponse response from the API call
     */
    public CompletableFuture<CreateGiftCardActivityResponse> createGiftCardActivityAsync(
            final CreateGiftCardActivityRequest body) {
        try { 
            return prepareCreateGiftCardActivityRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createGiftCardActivity.
     */
    private ApiCall<CreateGiftCardActivityResponse, ApiException> prepareCreateGiftCardActivityRequest(
            final CreateGiftCardActivityRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateGiftCardActivityResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/activities")
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
                                response -> ApiHelper.deserialize(response, CreateGiftCardActivityResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}