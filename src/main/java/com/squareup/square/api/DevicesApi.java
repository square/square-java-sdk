package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateDeviceCodeRequest;
import com.squareup.square.models.CreateDeviceCodeResponse;
import com.squareup.square.models.GetDeviceCodeResponse;
import com.squareup.square.models.ListDeviceCodesResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface DevicesApi {
    /**
     * Lists all DeviceCodes associated with the merchant.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @param    locationId    Optional parameter: If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all locations if empty.
     * @param    productType    Optional parameter: If specified, only returns DeviceCodes targeting the specified product type. Returns DeviceCodes of all product types if empty.
     * @return    Returns the ListDeviceCodesResponse response from the API call
     */
    ListDeviceCodesResponse listDeviceCodes(
            final String cursor,
            final String locationId,
            final String productType) throws ApiException, IOException;

    /**
     * Lists all DeviceCodes associated with the merchant.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for your original query.  See [Paginating results](#paginatingresults) for more information.
     * @param    locationId    Optional parameter: If specified, only returns DeviceCodes of the specified location. Returns DeviceCodes of all locations if empty.
     * @param    productType    Optional parameter: If specified, only returns DeviceCodes targeting the specified product type. Returns DeviceCodes of all product types if empty.
     * @return    Returns the ListDeviceCodesResponse response from the API call 
     */
    CompletableFuture<ListDeviceCodesResponse> listDeviceCodesAsync(
            final String cursor,
            final String locationId,
            final String productType);

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the connected
     * terminal mode.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call
     */
    CreateDeviceCodeResponse createDeviceCode(
            final CreateDeviceCodeRequest body) throws ApiException, IOException;

    /**
     * Creates a DeviceCode that can be used to login to a Square Terminal device to enter the connected
     * terminal mode.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateDeviceCodeResponse response from the API call 
     */
    CompletableFuture<CreateDeviceCodeResponse> createDeviceCodeAsync(
            final CreateDeviceCodeRequest body);

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param    id    Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call
     */
    GetDeviceCodeResponse getDeviceCode(
            final String id) throws ApiException, IOException;

    /**
     * Retrieves DeviceCode with the associated ID.
     * @param    id    Required parameter: The unique identifier for the device code.
     * @return    Returns the GetDeviceCodeResponse response from the API call 
     */
    CompletableFuture<GetDeviceCodeResponse> getDeviceCodeAsync(
            final String id);

}