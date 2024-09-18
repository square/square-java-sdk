
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateDeviceCodeRequest;
import com.squareup.square.models.CreateDeviceCodeResponse;
import com.squareup.square.models.GetDeviceCodeResponse;
import com.squareup.square.models.GetDeviceResponse;
import com.squareup.square.models.ListDeviceCodesResponse;
import com.squareup.square.models.ListDevicesResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultDevicesApi extends BaseApi implements DevicesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultDevicesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * List devices associated with the merchant. Currently, only Terminal API devices are
     * supported.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. See
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     *         for more information.
     * @param  sortOrder  Optional parameter: The order in which results are listed. - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  limit  Optional parameter: The number of results to return in a single page.
     * @param  locationId  Optional parameter: If present, only returns devices at the target
     *         location.
     * @return    Returns the ListDevicesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListDevicesResponse listDevices(
            final String cursor,
            final String sortOrder,
            final Integer limit,
            final String locationId) throws ApiException, IOException {
        return prepareListDevicesRequest(cursor, sortOrder, limit, locationId).execute();
    }

    /**
     * List devices associated with the merchant. Currently, only Terminal API devices are
     * supported.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. See
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     *         for more information.
     * @param  sortOrder  Optional parameter: The order in which results are listed. - `ASC` -
     *         Oldest to newest. - `DESC` - Newest to oldest (default).
     * @param  limit  Optional parameter: The number of results to return in a single page.
     * @param  locationId  Optional parameter: If present, only returns devices at the target
     *         location.
     * @return    Returns the ListDevicesResponse response from the API call
     */
    public CompletableFuture<ListDevicesResponse> listDevicesAsync(
            final String cursor,
            final String sortOrder,
            final Integer limit,
            final String locationId) {
        try { 
            return prepareListDevicesRequest(cursor, sortOrder, limit, locationId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listDevices.
     */
    private ApiCall<ListDevicesResponse, ApiException> prepareListDevicesRequest(
            final String cursor,
            final String sortOrder,
            final Integer limit,
            final String locationId) throws IOException {
        return new ApiCall.Builder<ListDevicesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/devices")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListDevicesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists all DeviceCodes associated with the merchant.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating
     *         results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     *         information.
     * @param  locationId  Optional parameter: If specified, only returns DeviceCodes of the
     *         specified location. Returns DeviceCodes of all locations if empty.
     * @param  productType  Optional parameter: If specified, only returns DeviceCodes targeting the
     *         specified product type. Returns DeviceCodes of all product types if empty.
     * @param  status  Optional parameter: If specified, returns DeviceCodes with the specified
     *         statuses. Returns DeviceCodes of status `PAIRED` and `UNPAIRED` if empty.
     * @return    Returns the ListDeviceCodesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListDeviceCodesResponse listDeviceCodes(
            final String cursor,
            final String locationId,
            final String productType,
            final String status) throws ApiException, IOException {
        return prepareListDeviceCodesRequest(cursor, locationId, productType, status).execute();
    }

    /**
     * Lists all DeviceCodes associated with the merchant.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Paginating
     *         results](https://developer.squareup.com/docs/working-with-apis/pagination) for more
     *         information.
     * @param  locationId  Optional parameter: If specified, only returns DeviceCodes of the
     *         specified location. Returns DeviceCodes of all locations if empty.
     * @param  productType  Optional parameter: If specified, only returns DeviceCodes targeting the
     *         specified product type. Returns DeviceCodes of all product types if empty.
     * @param  status  Optional parameter: If specified, returns DeviceCodes with the specified
     *         statuses. Returns DeviceCodes of status `PAIRED` and `UNPAIRED` if empty.
     * @return    Returns the ListDeviceCodesResponse response from the API call
     */
    public CompletableFuture<ListDeviceCodesResponse> listDeviceCodesAsync(
            final String cursor,
            final String locationId,
            final String productType,
            final String status) {
        try { 
            return prepareListDeviceCodesRequest(cursor, locationId, productType, status).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listDeviceCodes.
     */
    private ApiCall<ListDeviceCodesResponse, ApiException> prepareListDeviceCodesRequest(
            final String cursor,
            final String locationId,
            final String productType,
            final String status) throws IOException {
        return new ApiCall.Builder<ListDeviceCodesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/devices/codes")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("product_type")
                                .value(productType).isRequired(false))
                        .queryParam(param -> param.key("status")
                                .value(status).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListDeviceCodesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the
     * connected terminal mode.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateDeviceCodeResponse createDeviceCode(
            final CreateDeviceCodeRequest body) throws ApiException, IOException {
        return prepareCreateDeviceCodeRequest(body).execute();
    }

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the
     * connected terminal mode.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call
     */
    public CompletableFuture<CreateDeviceCodeResponse> createDeviceCodeAsync(
            final CreateDeviceCodeRequest body) {
        try { 
            return prepareCreateDeviceCodeRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createDeviceCode.
     */
    private ApiCall<CreateDeviceCodeResponse, ApiException> prepareCreateDeviceCodeRequest(
            final CreateDeviceCodeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateDeviceCodeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/devices/codes")
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
                                response -> ApiHelper.deserialize(response, CreateDeviceCodeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param  id  Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetDeviceCodeResponse getDeviceCode(
            final String id) throws ApiException, IOException {
        return prepareGetDeviceCodeRequest(id).execute();
    }

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param  id  Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call
     */
    public CompletableFuture<GetDeviceCodeResponse> getDeviceCodeAsync(
            final String id) {
        try { 
            return prepareGetDeviceCodeRequest(id).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getDeviceCode.
     */
    private ApiCall<GetDeviceCodeResponse, ApiException> prepareGetDeviceCodeRequest(
            final String id) throws IOException {
        return new ApiCall.Builder<GetDeviceCodeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/devices/codes/{id}")
                        .templateParam(param -> param.key("id").value(id)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetDeviceCodeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves Device with the associated `device_id`.
     * @param  deviceId  Required parameter: The unique ID for the desired `Device`.
     * @return    Returns the GetDeviceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetDeviceResponse getDevice(
            final String deviceId) throws ApiException, IOException {
        return prepareGetDeviceRequest(deviceId).execute();
    }

    /**
     * Retrieves Device with the associated `device_id`.
     * @param  deviceId  Required parameter: The unique ID for the desired `Device`.
     * @return    Returns the GetDeviceResponse response from the API call
     */
    public CompletableFuture<GetDeviceResponse> getDeviceAsync(
            final String deviceId) {
        try { 
            return prepareGetDeviceRequest(deviceId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getDevice.
     */
    private ApiCall<GetDeviceResponse, ApiException> prepareGetDeviceRequest(
            final String deviceId) throws IOException {
        return new ApiCall.Builder<GetDeviceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/devices/{device_id}")
                        .templateParam(param -> param.key("device_id").value(deviceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetDeviceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}