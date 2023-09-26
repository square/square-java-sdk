
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateDeviceCodeRequest;
import com.squareup.square.models.CreateDeviceCodeResponse;
import com.squareup.square.models.GetDeviceCodeResponse;
import com.squareup.square.models.GetDeviceResponse;
import com.squareup.square.models.ListDeviceCodesResponse;
import com.squareup.square.models.ListDevicesResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface DevicesApi {
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
    ListDevicesResponse listDevices(
            final String cursor,
            final String sortOrder,
            final Integer limit,
            final String locationId) throws ApiException, IOException;

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
    CompletableFuture<ListDevicesResponse> listDevicesAsync(
            final String cursor,
            final String sortOrder,
            final Integer limit,
            final String locationId);

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
    ListDeviceCodesResponse listDeviceCodes(
            final String cursor,
            final String locationId,
            final String productType,
            final String status) throws ApiException, IOException;

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
    CompletableFuture<ListDeviceCodesResponse> listDeviceCodesAsync(
            final String cursor,
            final String locationId,
            final String productType,
            final String status);

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the
     * connected terminal mode.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateDeviceCodeResponse createDeviceCode(
            final CreateDeviceCodeRequest body) throws ApiException, IOException;

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the
     * connected terminal mode.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call
     */
    CompletableFuture<CreateDeviceCodeResponse> createDeviceCodeAsync(
            final CreateDeviceCodeRequest body);

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param  id  Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetDeviceCodeResponse getDeviceCode(
            final String id) throws ApiException, IOException;

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param  id  Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call
     */
    CompletableFuture<GetDeviceCodeResponse> getDeviceCodeAsync(
            final String id);

    /**
     * Retrieves Device with the associated `device_id`.
     * @param  deviceId  Required parameter: The unique ID for the desired `Device`.
     * @return    Returns the GetDeviceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetDeviceResponse getDevice(
            final String deviceId) throws ApiException, IOException;

    /**
     * Retrieves Device with the associated `device_id`.
     * @param  deviceId  Required parameter: The unique ID for the desired `Device`.
     * @return    Returns the GetDeviceResponse response from the API call
     */
    CompletableFuture<GetDeviceResponse> getDeviceAsync(
            final String deviceId);

}