
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.DisableEventsResponse;
import com.squareup.square.models.EnableEventsResponse;
import com.squareup.square.models.ListEventTypesResponse;
import com.squareup.square.models.SearchEventsRequest;
import com.squareup.square.models.SearchEventsResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultEventsApi extends BaseApi implements EventsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultEventsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Search for Square API events that occur within a 28-day timeframe.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchEventsResponse searchEvents(
            final SearchEventsRequest body) throws ApiException, IOException {
        return prepareSearchEventsRequest(body).execute();
    }

    /**
     * Search for Square API events that occur within a 28-day timeframe.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchEventsResponse response from the API call
     */
    public CompletableFuture<SearchEventsResponse> searchEventsAsync(
            final SearchEventsRequest body) {
        try { 
            return prepareSearchEventsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchEvents.
     */
    private ApiCall<SearchEventsResponse, ApiException> prepareSearchEventsRequest(
            final SearchEventsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchEventsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/events")
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
                                response -> ApiHelper.deserialize(response, SearchEventsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Disables events to prevent them from being searchable. All events are disabled by default.
     * You must enable events to make them searchable. Disabling events for a specific time period
     * prevents them from being searchable, even if you re-enable them later.
     * @return    Returns the DisableEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DisableEventsResponse disableEvents() throws ApiException, IOException {
        return prepareDisableEventsRequest().execute();
    }

    /**
     * Disables events to prevent them from being searchable. All events are disabled by default.
     * You must enable events to make them searchable. Disabling events for a specific time period
     * prevents them from being searchable, even if you re-enable them later.
     * @return    Returns the DisableEventsResponse response from the API call
     */
    public CompletableFuture<DisableEventsResponse> disableEventsAsync() {
        try { 
            return prepareDisableEventsRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for disableEvents.
     */
    private ApiCall<DisableEventsResponse, ApiException> prepareDisableEventsRequest() throws IOException {
        return new ApiCall.Builder<DisableEventsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/events/disable")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DisableEventsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Enables events to make them searchable. Only events that occur while in the enabled state are
     * searchable.
     * @return    Returns the EnableEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public EnableEventsResponse enableEvents() throws ApiException, IOException {
        return prepareEnableEventsRequest().execute();
    }

    /**
     * Enables events to make them searchable. Only events that occur while in the enabled state are
     * searchable.
     * @return    Returns the EnableEventsResponse response from the API call
     */
    public CompletableFuture<EnableEventsResponse> enableEventsAsync() {
        try { 
            return prepareEnableEventsRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for enableEvents.
     */
    private ApiCall<EnableEventsResponse, ApiException> prepareEnableEventsRequest() throws IOException {
        return new ApiCall.Builder<EnableEventsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/events/enable")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, EnableEventsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists all event types that you can subscribe to as webhooks or query using the Events API.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListEventTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListEventTypesResponse listEventTypes(
            final String apiVersion) throws ApiException, IOException {
        return prepareListEventTypesRequest(apiVersion).execute();
    }

    /**
     * Lists all event types that you can subscribe to as webhooks or query using the Events API.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListEventTypesResponse response from the API call
     */
    public CompletableFuture<ListEventTypesResponse> listEventTypesAsync(
            final String apiVersion) {
        try { 
            return prepareListEventTypesRequest(apiVersion).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listEventTypes.
     */
    private ApiCall<ListEventTypesResponse, ApiException> prepareListEventTypesRequest(
            final String apiVersion) throws IOException {
        return new ApiCall.Builder<ListEventTypesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/events/types")
                        .queryParam(param -> param.key("api_version")
                                .value(apiVersion).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListEventTypesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}