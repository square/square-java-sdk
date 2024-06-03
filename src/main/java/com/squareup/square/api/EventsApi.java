
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.DisableEventsResponse;
import com.squareup.square.models.EnableEventsResponse;
import com.squareup.square.models.ListEventTypesResponse;
import com.squareup.square.models.SearchEventsRequest;
import com.squareup.square.models.SearchEventsResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface EventsApi {
    /**
     * Search for Square API events that occur within a 28-day timeframe.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchEventsResponse searchEvents(
            final SearchEventsRequest body) throws ApiException, IOException;

    /**
     * Search for Square API events that occur within a 28-day timeframe.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchEventsResponse response from the API call
     */
    CompletableFuture<SearchEventsResponse> searchEventsAsync(
            final SearchEventsRequest body);

    /**
     * Disables events to prevent them from being searchable. All events are disabled by default.
     * You must enable events to make them searchable. Disabling events for a specific time period
     * prevents them from being searchable, even if you re-enable them later.
     * @return    Returns the DisableEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DisableEventsResponse disableEvents() throws ApiException, IOException;

    /**
     * Disables events to prevent them from being searchable. All events are disabled by default.
     * You must enable events to make them searchable. Disabling events for a specific time period
     * prevents them from being searchable, even if you re-enable them later.
     * @return    Returns the DisableEventsResponse response from the API call
     */
    CompletableFuture<DisableEventsResponse> disableEventsAsync();

    /**
     * Enables events to make them searchable. Only events that occur while in the enabled state are
     * searchable.
     * @return    Returns the EnableEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    EnableEventsResponse enableEvents() throws ApiException, IOException;

    /**
     * Enables events to make them searchable. Only events that occur while in the enabled state are
     * searchable.
     * @return    Returns the EnableEventsResponse response from the API call
     */
    CompletableFuture<EnableEventsResponse> enableEventsAsync();

    /**
     * Lists all event types that you can subscribe to as webhooks or query using the Events API.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListEventTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListEventTypesResponse listEventTypes(
            final String apiVersion) throws ApiException, IOException;

    /**
     * Lists all event types that you can subscribe to as webhooks or query using the Events API.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListEventTypesResponse response from the API call
     */
    CompletableFuture<ListEventTypesResponse> listEventTypesAsync(
            final String apiVersion);

}