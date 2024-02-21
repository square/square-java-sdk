
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateLocationRequest;
import com.squareup.square.models.CreateLocationResponse;
import com.squareup.square.models.ListLocationsResponse;
import com.squareup.square.models.RetrieveLocationResponse;
import com.squareup.square.models.UpdateLocationRequest;
import com.squareup.square.models.UpdateLocationResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultLocationsApi extends BaseApi implements LocationsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultLocationsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Provides details about all of the seller's
     * [locations](https://developer.squareup.com/docs/locations-api), including those with an
     * inactive status. Locations are listed alphabetically by `name`.
     * @return    Returns the ListLocationsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListLocationsResponse listLocations() throws ApiException, IOException {
        return prepareListLocationsRequest().execute();
    }

    /**
     * Provides details about all of the seller's
     * [locations](https://developer.squareup.com/docs/locations-api), including those with an
     * inactive status. Locations are listed alphabetically by `name`.
     * @return    Returns the ListLocationsResponse response from the API call
     */
    public CompletableFuture<ListLocationsResponse> listLocationsAsync() {
        try { 
            return prepareListLocationsRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listLocations.
     */
    private ApiCall<ListLocationsResponse, ApiException> prepareListLocationsRequest() throws IOException {
        return new ApiCall.Builder<ListLocationsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListLocationsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public CreateLocationResponse createLocation(
            final CreateLocationRequest body) throws ApiException, IOException {
        return prepareCreateLocationRequest(body).execute();
    }

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
    public CompletableFuture<CreateLocationResponse> createLocationAsync(
            final CreateLocationRequest body) {
        try { 
            return prepareCreateLocationRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createLocation.
     */
    private ApiCall<CreateLocationResponse, ApiException> prepareCreateLocationRequest(
            final CreateLocationRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateLocationResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations")
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
                                response -> ApiHelper.deserialize(response, CreateLocationResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveLocationResponse retrieveLocation(
            final String locationId) throws ApiException, IOException {
        return prepareRetrieveLocationRequest(locationId).execute();
    }

    /**
     * Retrieves details of a single location. Specify "main" as the location ID to retrieve details
     * of the [main
     * location](https://developer.squareup.com/docs/locations-api#about-the-main-location).
     * @param  locationId  Required parameter: The ID of the location to retrieve. Specify the
     *         string "main" to return the main location.
     * @return    Returns the RetrieveLocationResponse response from the API call
     */
    public CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
            final String locationId) {
        try { 
            return prepareRetrieveLocationRequest(locationId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLocation.
     */
    private ApiCall<RetrieveLocationResponse, ApiException> prepareRetrieveLocationRequest(
            final String locationId) throws IOException {
        return new ApiCall.Builder<RetrieveLocationResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLocationResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a [location](https://developer.squareup.com/docs/locations-api).
     * @param  locationId  Required parameter: The ID of the location to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateLocationResponse updateLocation(
            final String locationId,
            final UpdateLocationRequest body) throws ApiException, IOException {
        return prepareUpdateLocationRequest(locationId, body).execute();
    }

    /**
     * Updates a [location](https://developer.squareup.com/docs/locations-api).
     * @param  locationId  Required parameter: The ID of the location to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationResponse response from the API call
     */
    public CompletableFuture<UpdateLocationResponse> updateLocationAsync(
            final String locationId,
            final UpdateLocationRequest body) {
        try { 
            return prepareUpdateLocationRequest(locationId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateLocation.
     */
    private ApiCall<UpdateLocationResponse, ApiException> prepareUpdateLocationRequest(
            final String locationId,
            final UpdateLocationRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateLocationResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateLocationResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}