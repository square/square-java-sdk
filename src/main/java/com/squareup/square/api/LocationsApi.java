
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
     * Provides details about all of the seller's
     * [locations](https://developer.squareup.com/docs/locations-api), including those with an
     * inactive status.
     * @return    Returns the ListLocationsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListLocationsResponse listLocations() throws ApiException, IOException;

    /**
     * Provides details about all of the seller's
     * [locations](https://developer.squareup.com/docs/locations-api), including those with an
     * inactive status.
     * @return    Returns the ListLocationsResponse response from the API call
     */
    CompletableFuture<ListLocationsResponse> listLocationsAsync();

    /**
     * Creates a [location](https://developer.squareup.com/docs/locations-api). Creating new
     * locations allows for separate configuration of receipt layouts, item prices, and sales
     * reports. Developers can use locations to separate sales activity through applications that
     * integrate with Square from sales activity elsewhere in a seller's account. Locations created
     * programmatically with the Locations API last forever and are visible to the seller for their
     * own management. Therefore, ensure that each location has a sensible and unique name.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateLocationResponse createLocation(
            final CreateLocationRequest body) throws ApiException, IOException;

    /**
     * Creates a [location](https://developer.squareup.com/docs/locations-api). Creating new
     * locations allows for separate configuration of receipt layouts, item prices, and sales
     * reports. Developers can use locations to separate sales activity through applications that
     * integrate with Square from sales activity elsewhere in a seller's account. Locations created
     * programmatically with the Locations API last forever and are visible to the seller for their
     * own management. Therefore, ensure that each location has a sensible and unique name.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLocationResponse response from the API call
     */
    CompletableFuture<CreateLocationResponse> createLocationAsync(
            final CreateLocationRequest body);

    /**
     * Retrieves details of a single location. Specify "main" as the location ID to retrieve details
     * of the [main
     * location](https://developer.squareup.com/docs/locations-api#about-the-main-location).
     * @param  locationId  Required parameter: The ID of the location to retrieve. Specify the
     *         string "main" to return the main location.
     * @return    Returns the RetrieveLocationResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLocationResponse retrieveLocation(
            final String locationId) throws ApiException, IOException;

    /**
     * Retrieves details of a single location. Specify "main" as the location ID to retrieve details
     * of the [main
     * location](https://developer.squareup.com/docs/locations-api#about-the-main-location).
     * @param  locationId  Required parameter: The ID of the location to retrieve. Specify the
     *         string "main" to return the main location.
     * @return    Returns the RetrieveLocationResponse response from the API call
     */
    CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
            final String locationId);

    /**
     * Updates a [location](https://developer.squareup.com/docs/locations-api).
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
     * Updates a [location](https://developer.squareup.com/docs/locations-api).
     * @param  locationId  Required parameter: The ID of the location to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     */
    CompletableFuture<UpdateLocationResponse> updateLocationAsync(
            final String locationId,
            final UpdateLocationRequest body);

}