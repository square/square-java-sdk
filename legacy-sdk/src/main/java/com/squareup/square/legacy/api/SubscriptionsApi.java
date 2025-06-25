package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.BulkSwapPlanRequest;
import com.squareup.square.legacy.models.BulkSwapPlanResponse;
import com.squareup.square.legacy.models.CancelSubscriptionResponse;
import com.squareup.square.legacy.models.ChangeBillingAnchorDateRequest;
import com.squareup.square.legacy.models.ChangeBillingAnchorDateResponse;
import com.squareup.square.legacy.models.CreateSubscriptionRequest;
import com.squareup.square.legacy.models.CreateSubscriptionResponse;
import com.squareup.square.legacy.models.DeleteSubscriptionActionResponse;
import com.squareup.square.legacy.models.ListSubscriptionEventsResponse;
import com.squareup.square.legacy.models.PauseSubscriptionRequest;
import com.squareup.square.legacy.models.PauseSubscriptionResponse;
import com.squareup.square.legacy.models.ResumeSubscriptionRequest;
import com.squareup.square.legacy.models.ResumeSubscriptionResponse;
import com.squareup.square.legacy.models.RetrieveSubscriptionResponse;
import com.squareup.square.legacy.models.SearchSubscriptionsRequest;
import com.squareup.square.legacy.models.SearchSubscriptionsResponse;
import com.squareup.square.legacy.models.SwapPlanRequest;
import com.squareup.square.legacy.models.SwapPlanResponse;
import com.squareup.square.legacy.models.UpdateSubscriptionRequest;
import com.squareup.square.legacy.models.UpdateSubscriptionResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface SubscriptionsApi {
    /**
     * Enrolls a customer in a subscription. If you provide a card on file in the request, Square
     * charges the card for the subscription. Otherwise, Square sends an invoice to the customer's
     * email address. The subscription starts immediately, unless the request includes the optional
     * `start_date`. Each individual subscription is associated with a particular location. For more
     * information, see [Create a
     * subscription](https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#create-a-subscription).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateSubscriptionResponse createSubscription(final CreateSubscriptionRequest body)
            throws ApiException, IOException;

    /**
     * Enrolls a customer in a subscription. If you provide a card on file in the request, Square
     * charges the card for the subscription. Otherwise, Square sends an invoice to the customer's
     * email address. The subscription starts immediately, unless the request includes the optional
     * `start_date`. Each individual subscription is associated with a particular location. For more
     * information, see [Create a
     * subscription](https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#create-a-subscription).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateSubscriptionResponse response from the API call
     */
    CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(final CreateSubscriptionRequest body);

    /**
     * Schedules a plan variation change for all active subscriptions under a given plan variation.
     * For more information, see [Swap Subscription Plan
     * Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkSwapPlanResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkSwapPlanResponse bulkSwapPlan(final BulkSwapPlanRequest body) throws ApiException, IOException;

    /**
     * Schedules a plan variation change for all active subscriptions under a given plan variation.
     * For more information, see [Swap Subscription Plan
     * Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkSwapPlanResponse response from the API call
     */
    CompletableFuture<BulkSwapPlanResponse> bulkSwapPlanAsync(final BulkSwapPlanRequest body);

    /**
     * Searches for subscriptions. Results are ordered chronologically by subscription creation
     * date. If the request specifies more than one location ID, the endpoint orders the result by
     * location ID, and then by creation date within each location. If no locations are given in the
     * query, all locations are searched. You can also optionally specify `customer_ids` to search
     * by customer. If left unset, all customers associated with the specified locations are
     * returned. If the request specifies customer IDs, the endpoint orders results first by
     * location, within location by customer ID, and within customer by subscription creation date.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchSubscriptionsResponse searchSubscriptions(final SearchSubscriptionsRequest body)
            throws ApiException, IOException;

    /**
     * Searches for subscriptions. Results are ordered chronologically by subscription creation
     * date. If the request specifies more than one location ID, the endpoint orders the result by
     * location ID, and then by creation date within each location. If no locations are given in the
     * query, all locations are searched. You can also optionally specify `customer_ids` to search
     * by customer. If left unset, all customers associated with the specified locations are
     * returned. If the request specifies customer IDs, the endpoint orders results first by
     * location, within location by customer ID, and within customer by subscription creation date.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchSubscriptionsResponse response from the API call
     */
    CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(final SearchSubscriptionsRequest body);

    /**
     * Retrieves a specific subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @param  include  Optional parameter: A query parameter to specify related information to be
     *         included in the response. The supported query parameter values are: - `actions`: to
     *         include scheduled actions on the targeted subscription.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveSubscriptionResponse retrieveSubscription(final String subscriptionId, final String include)
            throws ApiException, IOException;

    /**
     * Retrieves a specific subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @param  include  Optional parameter: A query parameter to specify related information to be
     *         included in the response. The supported query parameter values are: - `actions`: to
     *         include scheduled actions on the targeted subscription.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     */
    CompletableFuture<RetrieveSubscriptionResponse> retrieveSubscriptionAsync(
            final String subscriptionId, final String include);

    /**
     * Updates a subscription by modifying or clearing `subscription` field values. To clear a
     * field, set its value to `null`.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateSubscriptionResponse updateSubscription(final String subscriptionId, final UpdateSubscriptionRequest body)
            throws ApiException, IOException;

    /**
     * Updates a subscription by modifying or clearing `subscription` field values. To clear a
     * field, set its value to `null`.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     */
    CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
            final String subscriptionId, final UpdateSubscriptionRequest body);

    /**
     * Deletes a scheduled action for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription the targeted action is
     *         to act upon.
     * @param  actionId  Required parameter: The ID of the targeted action to be deleted.
     * @return    Returns the DeleteSubscriptionActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteSubscriptionActionResponse deleteSubscriptionAction(final String subscriptionId, final String actionId)
            throws ApiException, IOException;

    /**
     * Deletes a scheduled action for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription the targeted action is
     *         to act upon.
     * @param  actionId  Required parameter: The ID of the targeted action to be deleted.
     * @return    Returns the DeleteSubscriptionActionResponse response from the API call
     */
    CompletableFuture<DeleteSubscriptionActionResponse> deleteSubscriptionActionAsync(
            final String subscriptionId, final String actionId);

    /**
     * Changes the [billing anchor
     * date](https://developer.squareup.com/docs/subscriptions-api/subscription-billing#billing-dates)
     * for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update the billing
     *         anchor date.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ChangeBillingAnchorDateResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ChangeBillingAnchorDateResponse changeBillingAnchorDate(
            final String subscriptionId, final ChangeBillingAnchorDateRequest body) throws ApiException, IOException;

    /**
     * Changes the [billing anchor
     * date](https://developer.squareup.com/docs/subscriptions-api/subscription-billing#billing-dates)
     * for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update the billing
     *         anchor date.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ChangeBillingAnchorDateResponse response from the API call
     */
    CompletableFuture<ChangeBillingAnchorDateResponse> changeBillingAnchorDateAsync(
            final String subscriptionId, final ChangeBillingAnchorDateRequest body);

    /**
     * Schedules a `CANCEL` action to cancel an active subscription. This sets the `canceled_date`
     * field to the end of the active billing period. After this date, the subscription status
     * changes from ACTIVE to CANCELED.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelSubscriptionResponse cancelSubscription(final String subscriptionId) throws ApiException, IOException;

    /**
     * Schedules a `CANCEL` action to cancel an active subscription. This sets the `canceled_date`
     * field to the end of the active billing period. After this date, the subscription status
     * changes from ACTIVE to CANCELED.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     */
    CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(final String subscriptionId);

    /**
     * Lists all [events](https://developer.squareup.com/docs/subscriptions-api/actions-events) for
     * a specific subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve the events
     *         for.
     * @param  cursor  Optional parameter: When the total number of resulting subscription events
     *         exceeds the limit of a paged response, specify the cursor returned from a preceding
     *         response here to fetch the next set of results. If the cursor is unset, the response
     *         contains the last page of the results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The upper limit on the number of subscription events to
     *         return in a paged response.
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListSubscriptionEventsResponse listSubscriptionEvents(
            final String subscriptionId, final String cursor, final Integer limit) throws ApiException, IOException;

    /**
     * Lists all [events](https://developer.squareup.com/docs/subscriptions-api/actions-events) for
     * a specific subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve the events
     *         for.
     * @param  cursor  Optional parameter: When the total number of resulting subscription events
     *         exceeds the limit of a paged response, specify the cursor returned from a preceding
     *         response here to fetch the next set of results. If the cursor is unset, the response
     *         contains the last page of the results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The upper limit on the number of subscription events to
     *         return in a paged response.
     * @return    Returns the ListSubscriptionEventsResponse response from the API call
     */
    CompletableFuture<ListSubscriptionEventsResponse> listSubscriptionEventsAsync(
            final String subscriptionId, final String cursor, final Integer limit);

    /**
     * Schedules a `PAUSE` action to pause an active subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to pause.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PauseSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    PauseSubscriptionResponse pauseSubscription(final String subscriptionId, final PauseSubscriptionRequest body)
            throws ApiException, IOException;

    /**
     * Schedules a `PAUSE` action to pause an active subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to pause.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PauseSubscriptionResponse response from the API call
     */
    CompletableFuture<PauseSubscriptionResponse> pauseSubscriptionAsync(
            final String subscriptionId, final PauseSubscriptionRequest body);

    /**
     * Schedules a `RESUME` action to resume a paused or a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ResumeSubscriptionResponse resumeSubscription(final String subscriptionId, final ResumeSubscriptionRequest body)
            throws ApiException, IOException;

    /**
     * Schedules a `RESUME` action to resume a paused or a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     */
    CompletableFuture<ResumeSubscriptionResponse> resumeSubscriptionAsync(
            final String subscriptionId, final ResumeSubscriptionRequest body);

    /**
     * Schedules a `SWAP_PLAN` action to swap a subscription plan variation in an existing
     * subscription. For more information, see [Swap Subscription Plan
     * Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).
     * @param  subscriptionId  Required parameter: The ID of the subscription to swap the
     *         subscription plan for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SwapPlanResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SwapPlanResponse swapPlan(final String subscriptionId, final SwapPlanRequest body) throws ApiException, IOException;

    /**
     * Schedules a `SWAP_PLAN` action to swap a subscription plan variation in an existing
     * subscription. For more information, see [Swap Subscription Plan
     * Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).
     * @param  subscriptionId  Required parameter: The ID of the subscription to swap the
     *         subscription plan for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SwapPlanResponse response from the API call
     */
    CompletableFuture<SwapPlanResponse> swapPlanAsync(final String subscriptionId, final SwapPlanRequest body);
}
