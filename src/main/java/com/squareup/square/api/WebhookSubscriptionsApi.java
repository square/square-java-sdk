
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateWebhookSubscriptionRequest;
import com.squareup.square.models.CreateWebhookSubscriptionResponse;
import com.squareup.square.models.DeleteWebhookSubscriptionResponse;
import com.squareup.square.models.ListWebhookEventTypesResponse;
import com.squareup.square.models.ListWebhookSubscriptionsResponse;
import com.squareup.square.models.RetrieveWebhookSubscriptionResponse;
import com.squareup.square.models.TestWebhookSubscriptionRequest;
import com.squareup.square.models.TestWebhookSubscriptionResponse;
import com.squareup.square.models.UpdateWebhookSubscriptionRequest;
import com.squareup.square.models.UpdateWebhookSubscriptionResponse;
import com.squareup.square.models.UpdateWebhookSubscriptionSignatureKeyRequest;
import com.squareup.square.models.UpdateWebhookSubscriptionSignatureKeyResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface WebhookSubscriptionsApi {
    /**
     * Lists all webhook event types that can be subscribed to.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListWebhookEventTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListWebhookEventTypesResponse listWebhookEventTypes(
            final String apiVersion) throws ApiException, IOException;

    /**
     * Lists all webhook event types that can be subscribed to.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListWebhookEventTypesResponse response from the API call
     */
    CompletableFuture<ListWebhookEventTypesResponse> listWebhookEventTypesAsync(
            final String apiVersion);

    /**
     * Lists all webhook subscriptions owned by your application.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  includeDisabled  Optional parameter: Includes disabled
     *         [Subscription]($m/WebhookSubscription)s. By default, all enabled
     *         [Subscription]($m/WebhookSubscription)s are returned.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the
     *         [Subscription]($m/WebhookSubscription) was created with the specified order. This
     *         field defaults to ASC.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. Default: 100
     * @return    Returns the ListWebhookSubscriptionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListWebhookSubscriptionsResponse listWebhookSubscriptions(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) throws ApiException, IOException;

    /**
     * Lists all webhook subscriptions owned by your application.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  includeDisabled  Optional parameter: Includes disabled
     *         [Subscription]($m/WebhookSubscription)s. By default, all enabled
     *         [Subscription]($m/WebhookSubscription)s are returned.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the
     *         [Subscription]($m/WebhookSubscription) was created with the specified order. This
     *         field defaults to ASC.
     * @param  limit  Optional parameter: The maximum number of results to be returned in a single
     *         page. It is possible to receive fewer results than the specified limit on a given
     *         page. The default value of 100 is also the maximum allowed value. Default: 100
     * @return    Returns the ListWebhookSubscriptionsResponse response from the API call
     */
    CompletableFuture<ListWebhookSubscriptionsResponse> listWebhookSubscriptionsAsync(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit);

    /**
     * Creates a webhook subscription.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateWebhookSubscriptionResponse createWebhookSubscription(
            final CreateWebhookSubscriptionRequest body) throws ApiException, IOException;

    /**
     * Creates a webhook subscription.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateWebhookSubscriptionResponse response from the API call
     */
    CompletableFuture<CreateWebhookSubscriptionResponse> createWebhookSubscriptionAsync(
            final CreateWebhookSubscriptionRequest body);

    /**
     * Deletes a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to delete.
     * @return    Returns the DeleteWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteWebhookSubscriptionResponse deleteWebhookSubscription(
            final String subscriptionId) throws ApiException, IOException;

    /**
     * Deletes a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to delete.
     * @return    Returns the DeleteWebhookSubscriptionResponse response from the API call
     */
    CompletableFuture<DeleteWebhookSubscriptionResponse> deleteWebhookSubscriptionAsync(
            final String subscriptionId);

    /**
     * Retrieves a webhook subscription identified by its ID.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to retrieve.
     * @return    Returns the RetrieveWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveWebhookSubscriptionResponse retrieveWebhookSubscription(
            final String subscriptionId) throws ApiException, IOException;

    /**
     * Retrieves a webhook subscription identified by its ID.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to retrieve.
     * @return    Returns the RetrieveWebhookSubscriptionResponse response from the API call
     */
    CompletableFuture<RetrieveWebhookSubscriptionResponse> retrieveWebhookSubscriptionAsync(
            final String subscriptionId);

    /**
     * Updates a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateWebhookSubscriptionResponse updateWebhookSubscription(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) throws ApiException, IOException;

    /**
     * Updates a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionResponse response from the API call
     */
    CompletableFuture<UpdateWebhookSubscriptionResponse> updateWebhookSubscriptionAsync(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body);

    /**
     * Updates a webhook subscription by replacing the existing signature key with a new one.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionSignatureKeyResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateWebhookSubscriptionSignatureKeyResponse updateWebhookSubscriptionSignatureKey(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) throws ApiException, IOException;

    /**
     * Updates a webhook subscription by replacing the existing signature key with a new one.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionSignatureKeyResponse response from the API call
     */
    CompletableFuture<UpdateWebhookSubscriptionSignatureKeyResponse> updateWebhookSubscriptionSignatureKeyAsync(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body);

    /**
     * Tests a webhook subscription by sending a test event to the notification URL.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to test.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the TestWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    TestWebhookSubscriptionResponse testWebhookSubscription(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) throws ApiException, IOException;

    /**
     * Tests a webhook subscription by sending a test event to the notification URL.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to test.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the TestWebhookSubscriptionResponse response from the API call
     */
    CompletableFuture<TestWebhookSubscriptionResponse> testWebhookSubscriptionAsync(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body);

}