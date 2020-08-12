package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelTerminalCheckoutResponse;
import com.squareup.square.models.CreateTerminalCheckoutRequest;
import com.squareup.square.models.CreateTerminalCheckoutResponse;
import com.squareup.square.models.GetTerminalCheckoutResponse;
import com.squareup.square.models.SearchTerminalCheckoutsRequest;
import com.squareup.square.models.SearchTerminalCheckoutsResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface TerminalApi {
    /**
     * Creates a new Terminal checkout request and sends it to the specified device to take a payment for the requested amount.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     */
    CreateTerminalCheckoutResponse createTerminalCheckout(
            final CreateTerminalCheckoutRequest body) throws ApiException, IOException;

    /**
     * Creates a new Terminal checkout request and sends it to the specified device to take a payment for the requested amount.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call 
     */
    CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
            final CreateTerminalCheckoutRequest body);

    /**
     * Retrieves a filtered list of Terminal checkout requests created by the account making the request.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     */
    SearchTerminalCheckoutsResponse searchTerminalCheckouts(
            final SearchTerminalCheckoutsRequest body) throws ApiException, IOException;

    /**
     * Retrieves a filtered list of Terminal checkout requests created by the account making the request.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call 
     */
    CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
            final SearchTerminalCheckoutsRequest body);

    /**
     * Retrieves a Terminal checkout request by checkout_id.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     */
    GetTerminalCheckoutResponse getTerminalCheckout(
            final String checkoutId) throws ApiException, IOException;

    /**
     * Retrieves a Terminal checkout request by checkout_id.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the GetTerminalCheckoutResponse response from the API call 
     */
    CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
            final String checkoutId);

    /**
     * Cancels a Terminal checkout request, if the status of the request permits it.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     */
    CancelTerminalCheckoutResponse cancelTerminalCheckout(
            final String checkoutId) throws ApiException, IOException;

    /**
     * Cancels a Terminal checkout request, if the status of the request permits it.
     * @param    checkoutId    Required parameter: Unique ID for the desired `TerminalCheckout`
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call 
     */
    CompletableFuture<CancelTerminalCheckoutResponse> cancelTerminalCheckoutAsync(
            final String checkoutId);

}
