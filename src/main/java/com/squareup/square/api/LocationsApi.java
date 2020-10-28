
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateLocationRequest;
import com.squareup.square.models.CreateLocationResponse;
import com.squareup.square.models.ListLocationsResponse;
import com.squareup.square.models.RetrieveLocationResponse;
import com.squareup.square.models.UpdateLocationRequest;
import com.squareup.square.models.UpdateLocationResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface LocationsApi {
    /**
     * Provides information of all locations of a business. Many Square API endpoints require a
     * `location_id` parameter. The `id` field of the [`Location`](#type-location) objects returned
     * by this endpoint correspond to that `location_id` parameter.
     * @return    Returns the ListLocationsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListLocationsResponse listLocations() throws ApiException, IOException;

    /**
     * Provides information of all locations of a business. Many Square API endpoints require a
     * `location_id` parameter. The `id` field of the [`Location`](#type-location) objects returned
     * by this endpoint correspond to that `location_id` parameter.
     * @return    Returns the ListLocationsResponse response from the API call
     */
    CompletableFuture<ListLocationsResponse> listLocationsAsync();

    /**
     * Creates a location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateLocationResponse createLocation(
            final CreateLocationRequest body) throws ApiException, IOException;

    /**
     * Creates a location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call
     */
    CompletableFuture<CreateLocationResponse> createLocationAsync(
            final CreateLocationRequest body);

    /**
     * Retrieves details of a location. You can specify "main" as the location ID to retrieve
     * details of the main location.
     * @param  locationId  Required parameter: The ID of the location to retrieve. If you specify
     *         the string "main", then the endpoint returns the main location.
     * @return    Returns the RetrieveLocationResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLocationResponse retrieveLocation(
            final String locationId) throws ApiException, IOException;

    /**
     * Retrieves details of a location. You can specify "main" as the location ID to retrieve
     * details of the main location.
     * @param  locationId  Required parameter: The ID of the location to retrieve. If you specify
     *         the string "main", then the endpoint returns the main location.
     * @return    Returns the RetrieveLocationResponse response from the API call
     */
    CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
            final String locationId);

    /**
     * Updates a location.
     * @param  locationId  Required parameter: The ID of the location to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateLocationResponse updateLocation(
            final String locationId,
            final UpdateLocationRequest body) throws ApiException, IOException;

    /**
     * Updates a location.
     * @param  locationId  Required parameter: The ID of the location to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     */
    CompletableFuture<UpdateLocationResponse> updateLocationAsync(
            final String locationId,
            final UpdateLocationRequest body);

}