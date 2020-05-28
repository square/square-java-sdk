package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateCheckoutRequest;
import com.squareup.square.models.CreateCheckoutResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CheckoutApi {
    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers will
     * be directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * @param    locationId    Required parameter: The ID of the business location to associate the checkout with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     */
    CreateCheckoutResponse createCheckout(
            final String locationId,
            final CreateCheckoutRequest body) throws ApiException, IOException;

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers will
     * be directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * @param    locationId    Required parameter: The ID of the business location to associate the checkout with.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call 
     */
    CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
            final String locationId,
            final CreateCheckoutRequest body);

}