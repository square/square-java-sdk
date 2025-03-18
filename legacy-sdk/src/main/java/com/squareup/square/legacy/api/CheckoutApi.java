package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.CreateCheckoutRequest;
import com.squareup.square.legacy.models.CreateCheckoutResponse;
import com.squareup.square.legacy.models.CreatePaymentLinkRequest;
import com.squareup.square.legacy.models.CreatePaymentLinkResponse;
import com.squareup.square.legacy.models.DeletePaymentLinkResponse;
import com.squareup.square.legacy.models.ListPaymentLinksResponse;
import com.squareup.square.legacy.models.RetrieveLocationSettingsResponse;
import com.squareup.square.legacy.models.RetrieveMerchantSettingsResponse;
import com.squareup.square.legacy.models.RetrievePaymentLinkResponse;
import com.squareup.square.legacy.models.UpdateLocationSettingsRequest;
import com.squareup.square.legacy.models.UpdateLocationSettingsResponse;
import com.squareup.square.legacy.models.UpdateMerchantSettingsRequest;
import com.squareup.square.legacy.models.UpdateMerchantSettingsResponse;
import com.squareup.square.legacy.models.UpdatePaymentLinkRequest;
import com.squareup.square.legacy.models.UpdatePaymentLinkResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CheckoutApi {
    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers are directed to in order to
     * provide their payment information using a payment processing workflow hosted on
     * connect.squareup.com. NOTE: The Checkout API has been updated with new features. For more
     * information, see [Checkout API
     * highlights](https://developer.squareup.com/docs/checkout-api#checkout-api-highlights).
     * @deprecated
     *
     * @param  locationId  Required parameter: The ID of the business location to associate the
     *         checkout with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    CreateCheckoutResponse createCheckout(final String locationId, final CreateCheckoutRequest body)
            throws ApiException, IOException;

    /**
     * Links a `checkoutId` to a `checkout_page_url` that customers are directed to in order to
     * provide their payment information using a payment processing workflow hosted on
     * connect.squareup.com. NOTE: The Checkout API has been updated with new features. For more
     * information, see [Checkout API
     * highlights](https://developer.squareup.com/docs/checkout-api#checkout-api-highlights).
     * @deprecated
     *
     * @param  locationId  Required parameter: The ID of the business location to associate the
     *         checkout with.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCheckoutResponse response from the API call
     */
    @Deprecated
    CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
            final String locationId, final CreateCheckoutRequest body);

    /**
     * Retrieves the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @return    Returns the RetrieveLocationSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLocationSettingsResponse retrieveLocationSettings(final String locationId) throws ApiException, IOException;

    /**
     * Retrieves the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @return    Returns the RetrieveLocationSettingsResponse response from the API call
     */
    CompletableFuture<RetrieveLocationSettingsResponse> retrieveLocationSettingsAsync(final String locationId);

    /**
     * Updates the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateLocationSettingsResponse updateLocationSettings(
            final String locationId, final UpdateLocationSettingsRequest body) throws ApiException, IOException;

    /**
     * Updates the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationSettingsResponse response from the API call
     */
    CompletableFuture<UpdateLocationSettingsResponse> updateLocationSettingsAsync(
            final String locationId, final UpdateLocationSettingsRequest body);

    /**
     * Retrieves the merchant-level settings for a Square-hosted checkout page.
     * @return    Returns the RetrieveMerchantSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveMerchantSettingsResponse retrieveMerchantSettings() throws ApiException, IOException;

    /**
     * Retrieves the merchant-level settings for a Square-hosted checkout page.
     * @return    Returns the RetrieveMerchantSettingsResponse response from the API call
     */
    CompletableFuture<RetrieveMerchantSettingsResponse> retrieveMerchantSettingsAsync();

    /**
     * Updates the merchant-level settings for a Square-hosted checkout page.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateMerchantSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateMerchantSettingsResponse updateMerchantSettings(final UpdateMerchantSettingsRequest body)
            throws ApiException, IOException;

    /**
     * Updates the merchant-level settings for a Square-hosted checkout page.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateMerchantSettingsResponse response from the API call
     */
    CompletableFuture<UpdateMerchantSettingsResponse> updateMerchantSettingsAsync(
            final UpdateMerchantSettingsRequest body);

    /**
     * Lists all payment links.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: A limit on the number of results to return per page. The
     *         limit is advisory and the implementation might return more or less results. If the
     *         supplied limit is negative, zero, or greater than the maximum limit of 1000, it is
     *         ignored. Default value: `100`
     * @return    Returns the ListPaymentLinksResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListPaymentLinksResponse listPaymentLinks(final String cursor, final Integer limit)
            throws ApiException, IOException;

    /**
     * Lists all payment links.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: A limit on the number of results to return per page. The
     *         limit is advisory and the implementation might return more or less results. If the
     *         supplied limit is negative, zero, or greater than the maximum limit of 1000, it is
     *         ignored. Default value: `100`
     * @return    Returns the ListPaymentLinksResponse response from the API call
     */
    CompletableFuture<ListPaymentLinksResponse> listPaymentLinksAsync(final String cursor, final Integer limit);

    /**
     * Creates a Square-hosted checkout page. Applications can share the resulting payment link with
     * their buyer to pay for goods and services.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreatePaymentLinkResponse createPaymentLink(final CreatePaymentLinkRequest body) throws ApiException, IOException;

    /**
     * Creates a Square-hosted checkout page. Applications can share the resulting payment link with
     * their buyer to pay for goods and services.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentLinkResponse response from the API call
     */
    CompletableFuture<CreatePaymentLinkResponse> createPaymentLinkAsync(final CreatePaymentLinkRequest body);

    /**
     * Deletes a payment link.
     * @param  id  Required parameter: The ID of the payment link to delete.
     * @return    Returns the DeletePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeletePaymentLinkResponse deletePaymentLink(final String id) throws ApiException, IOException;

    /**
     * Deletes a payment link.
     * @param  id  Required parameter: The ID of the payment link to delete.
     * @return    Returns the DeletePaymentLinkResponse response from the API call
     */
    CompletableFuture<DeletePaymentLinkResponse> deletePaymentLinkAsync(final String id);

    /**
     * Retrieves a payment link.
     * @param  id  Required parameter: The ID of link to retrieve.
     * @return    Returns the RetrievePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrievePaymentLinkResponse retrievePaymentLink(final String id) throws ApiException, IOException;

    /**
     * Retrieves a payment link.
     * @param  id  Required parameter: The ID of link to retrieve.
     * @return    Returns the RetrievePaymentLinkResponse response from the API call
     */
    CompletableFuture<RetrievePaymentLinkResponse> retrievePaymentLinkAsync(final String id);

    /**
     * Updates a payment link. You can update the `payment_link` fields such as `description`,
     * `checkout_options`, and `pre_populated_data`. You cannot update other fields such as the
     * `order_id`, `version`, `URL`, or `timestamp` field.
     * @param  id  Required parameter: The ID of the payment link to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdatePaymentLinkResponse updatePaymentLink(final String id, final UpdatePaymentLinkRequest body)
            throws ApiException, IOException;

    /**
     * Updates a payment link. You can update the `payment_link` fields such as `description`,
     * `checkout_options`, and `pre_populated_data`. You cannot update other fields such as the
     * `order_id`, `version`, `URL`, or `timestamp` field.
     * @param  id  Required parameter: The ID of the payment link to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentLinkResponse response from the API call
     */
    CompletableFuture<UpdatePaymentLinkResponse> updatePaymentLinkAsync(
            final String id, final UpdatePaymentLinkRequest body);
}
