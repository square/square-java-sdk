
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelSubscriptionResponse;
import com.squareup.square.models.CreateSubscriptionRequest;
import com.squareup.square.models.CreateSubscriptionResponse;
import com.squareup.square.models.ListSubscriptionEventsResponse;
import com.squareup.square.models.ResumeSubscriptionResponse;
import com.squareup.square.models.RetrieveSubscriptionResponse;
import com.squareup.square.models.SearchSubscriptionsRequest;
import com.squareup.square.models.SearchSubscriptionsResponse;
import com.squareup.square.models.UpdateSubscriptionRequest;
import com.squareup.square.models.UpdateSubscriptionResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface SubscriptionsApi {
    /**
     * Creates a subscription for a customer to a subscription plan. If you provide a card on file
     * in the request, Square charges the card for the subscription. Otherwise, Square bills an
     * invoice to the customer's email address. The subscription starts immediately, unless the
     * request includes the optional `start_date`. Each individual subscription is associated with a
     * particular location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateSubscriptionResponse createSubscription(
            final CreateSubscriptionRequest body) throws ApiException, IOException;

    /**
     * Creates a subscription for a customer to a subscription plan. If you provide a card on file
     * in the request, Square charges the card for the subscription. Otherwise, Square bills an
     * invoice to the customer's email address. The subscription starts immediately, unless the
     * request includes the optional `start_date`. Each individual subscription is associated with a
     * particular location.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     */
    CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(
            final CreateSubscriptionRequest body);

    /**
     * Searches for subscriptions. Results are ordered chronologically by subscription creation
     * date. If the request specifies more than one location ID, the endpoint orders the result by
     * location ID, and then by creation date within each location. If no locations are given in the
     * query, all locations are searched. You can also optionally specify `customer_ids` to search
     * by customer. If left unset, all customers associated with the specified locations are
     * returned. If the request specifies customer IDs, the endpoint orders results first by
     * location, within location by customer ID, and within customer by subscription creation date.
     * For more information, see [Retrieve
     * subscriptions](https://developer.squareup.com/docs/subscriptions-api/overview#retrieve-subscriptions).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchSubscriptionsResponse searchSubscriptions(
            final SearchSubscriptionsRequest body) throws ApiException, IOException;

    /**
     * Searches for subscriptions. Results are ordered chronologically by subscription creation
     * date. If the request specifies more than one location ID, the endpoint orders the result by
     * location ID, and then by creation date within each location. If no locations are given in the
     * query, all locations are searched. You can also optionally specify `customer_ids` to search
     * by customer. If left unset, all customers associated with the specified locations are
     * returned. If the request specifies customer IDs, the endpoint orders results first by
     * location, within location by customer ID, and within customer by subscription creation date.
     * For more information, see [Retrieve
     * subscriptions](https://developer.squareup.com/docs/subscriptions-api/overview#retrieve-subscriptions).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     */
    CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(
            final SearchSubscriptionsRequest body);

    /**
     * Retrieves a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveSubscriptionResponse retrieveSubscription(
            final String subscriptionId) throws ApiException, IOException;

    /**
     * Retrieves a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     */
    CompletableFuture<RetrieveSubscriptionResponse> retrieveSubscriptionAsync(
            final String subscriptionId);

    /**
     * Updates a subscription. You can set, modify, and clear the `subscription` field values.
     * @param  subscriptionId  Required parameter: The ID for the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateSubscriptionResponse updateSubscription(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws ApiException, IOException;

    /**
     * Updates a subscription. You can set, modify, and clear the `subscription` field values.
     * @param  subscriptionId  Required parameter: The ID for the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     */
    CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
            final String subscriptionId,
            final UpdateSubscriptionRequest body);

    /**
     * Sets the `canceled_date` field to the end of the active billing period. After this date, the
     * status changes from ACTIVE to CANCELED.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelSubscriptionResponse cancelSubscription(
            final String subscriptionId) throws ApiException, IOException;

    /**
     * Sets the `canceled_date` field to the end of the active billing period. After this date, the
     * status changes from ACTIVE to CANCELED.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     */
    CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(
            final String subscriptionId);

    /**
     * Lists all events for a specific subscription. In the current implementation, only
     * `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are
     * returned.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve the events
     *         for.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The upper limit on the number of subscription events to
     *         return in the response. Default: `200`
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListSubscriptionEventsResponse listSubscriptionEvents(
            final String subscriptionId,
            final String cursor,
            final Integer limit) throws ApiException, IOException;

    /**
     * Lists all events for a specific subscription. In the current implementation, only
     * `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are
     * returned.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve the events
     *         for.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for the original query.
     *         For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The upper limit on the number of subscription events to
     *         return in the response. Default: `200`
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     */
    CompletableFuture<ListSubscriptionEventsResponse> listSubscriptionEventsAsync(
            final String subscriptionId,
            final String cursor,
            final Integer limit);

    /**
     * Resumes a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ResumeSubscriptionResponse resumeSubscription(
            final String subscriptionId) throws ApiException, IOException;

    /**
     * Resumes a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     */
    CompletableFuture<ResumeSubscriptionResponse> resumeSubscriptionAsync(
            final String subscriptionId);

}