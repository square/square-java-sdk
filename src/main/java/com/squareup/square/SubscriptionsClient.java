/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.BulkSwapPlanRequest;
import com.squareup.square.types.BulkSwapPlanResponse;
import com.squareup.square.types.CancelSubscriptionResponse;
import com.squareup.square.types.CancelSubscriptionsRequest;
import com.squareup.square.types.ChangeBillingAnchorDateRequest;
import com.squareup.square.types.ChangeBillingAnchorDateResponse;
import com.squareup.square.types.CreateSubscriptionRequest;
import com.squareup.square.types.CreateSubscriptionResponse;
import com.squareup.square.types.DeleteActionSubscriptionsRequest;
import com.squareup.square.types.DeleteSubscriptionActionResponse;
import com.squareup.square.types.GetSubscriptionResponse;
import com.squareup.square.types.GetSubscriptionsRequest;
import com.squareup.square.types.ListEventsSubscriptionsRequest;
import com.squareup.square.types.PauseSubscriptionRequest;
import com.squareup.square.types.PauseSubscriptionResponse;
import com.squareup.square.types.ResumeSubscriptionRequest;
import com.squareup.square.types.ResumeSubscriptionResponse;
import com.squareup.square.types.SearchSubscriptionsRequest;
import com.squareup.square.types.SearchSubscriptionsResponse;
import com.squareup.square.types.SubscriptionEvent;
import com.squareup.square.types.SwapPlanRequest;
import com.squareup.square.types.SwapPlanResponse;
import com.squareup.square.types.UpdateSubscriptionRequest;
import com.squareup.square.types.UpdateSubscriptionResponse;

public class SubscriptionsClient {
    protected final ClientOptions clientOptions;

    private final RawSubscriptionsClient rawClient;

    public SubscriptionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawSubscriptionsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawSubscriptionsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Enrolls a customer in a subscription.
     * <p>If you provide a card on file in the request, Square charges the card for
     * the subscription. Otherwise, Square sends an invoice to the customer's email
     * address. The subscription starts immediately, unless the request includes
     * the optional <code>start_date</code>. Each individual subscription is associated with a particular location.</p>
     * <p>For more information, see <a href="https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#create-a-subscription">Create a subscription</a>.</p>
     */
    public CreateSubscriptionResponse create(CreateSubscriptionRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Enrolls a customer in a subscription.
     * <p>If you provide a card on file in the request, Square charges the card for
     * the subscription. Otherwise, Square sends an invoice to the customer's email
     * address. The subscription starts immediately, unless the request includes
     * the optional <code>start_date</code>. Each individual subscription is associated with a particular location.</p>
     * <p>For more information, see <a href="https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#create-a-subscription">Create a subscription</a>.</p>
     */
    public CreateSubscriptionResponse create(CreateSubscriptionRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * Schedules a plan variation change for all active subscriptions under a given plan
     * variation. For more information, see <a href="https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations">Swap Subscription Plan Variations</a>.
     */
    public BulkSwapPlanResponse bulkSwapPlan(BulkSwapPlanRequest request) {
        return this.rawClient.bulkSwapPlan(request).body();
    }

    /**
     * Schedules a plan variation change for all active subscriptions under a given plan
     * variation. For more information, see <a href="https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations">Swap Subscription Plan Variations</a>.
     */
    public BulkSwapPlanResponse bulkSwapPlan(BulkSwapPlanRequest request, RequestOptions requestOptions) {
        return this.rawClient.bulkSwapPlan(request, requestOptions).body();
    }

    /**
     * Searches for subscriptions.
     * <p>Results are ordered chronologically by subscription creation date. If
     * the request specifies more than one location ID,
     * the endpoint orders the result
     * by location ID, and then by creation date within each location. If no locations are given
     * in the query, all locations are searched.</p>
     * <p>You can also optionally specify <code>customer_ids</code> to search by customer.
     * If left unset, all customers
     * associated with the specified locations are returned.
     * If the request specifies customer IDs, the endpoint orders results
     * first by location, within location by customer ID, and within
     * customer by subscription creation date.</p>
     */
    public SearchSubscriptionsResponse search() {
        return this.rawClient.search().body();
    }

    /**
     * Searches for subscriptions.
     * <p>Results are ordered chronologically by subscription creation date. If
     * the request specifies more than one location ID,
     * the endpoint orders the result
     * by location ID, and then by creation date within each location. If no locations are given
     * in the query, all locations are searched.</p>
     * <p>You can also optionally specify <code>customer_ids</code> to search by customer.
     * If left unset, all customers
     * associated with the specified locations are returned.
     * If the request specifies customer IDs, the endpoint orders results
     * first by location, within location by customer ID, and within
     * customer by subscription creation date.</p>
     */
    public SearchSubscriptionsResponse search(SearchSubscriptionsRequest request) {
        return this.rawClient.search(request).body();
    }

    /**
     * Searches for subscriptions.
     * <p>Results are ordered chronologically by subscription creation date. If
     * the request specifies more than one location ID,
     * the endpoint orders the result
     * by location ID, and then by creation date within each location. If no locations are given
     * in the query, all locations are searched.</p>
     * <p>You can also optionally specify <code>customer_ids</code> to search by customer.
     * If left unset, all customers
     * associated with the specified locations are returned.
     * If the request specifies customer IDs, the endpoint orders results
     * first by location, within location by customer ID, and within
     * customer by subscription creation date.</p>
     */
    public SearchSubscriptionsResponse search(SearchSubscriptionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.search(request, requestOptions).body();
    }

    /**
     * Retrieves a specific subscription.
     */
    public GetSubscriptionResponse get(GetSubscriptionsRequest request) {
        return this.rawClient.get(request).body();
    }

    /**
     * Retrieves a specific subscription.
     */
    public GetSubscriptionResponse get(GetSubscriptionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).body();
    }

    /**
     * Updates a subscription by modifying or clearing <code>subscription</code> field values.
     * To clear a field, set its value to <code>null</code>.
     */
    public UpdateSubscriptionResponse update(UpdateSubscriptionRequest request) {
        return this.rawClient.update(request).body();
    }

    /**
     * Updates a subscription by modifying or clearing <code>subscription</code> field values.
     * To clear a field, set its value to <code>null</code>.
     */
    public UpdateSubscriptionResponse update(UpdateSubscriptionRequest request, RequestOptions requestOptions) {
        return this.rawClient.update(request, requestOptions).body();
    }

    /**
     * Deletes a scheduled action for a subscription.
     */
    public DeleteSubscriptionActionResponse deleteAction(DeleteActionSubscriptionsRequest request) {
        return this.rawClient.deleteAction(request).body();
    }

    /**
     * Deletes a scheduled action for a subscription.
     */
    public DeleteSubscriptionActionResponse deleteAction(
            DeleteActionSubscriptionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.deleteAction(request, requestOptions).body();
    }

    /**
     * Changes the <a href="https://developer.squareup.com/docs/subscriptions-api/subscription-billing#billing-dates">billing anchor date</a>
     * for a subscription.
     */
    public ChangeBillingAnchorDateResponse changeBillingAnchorDate(ChangeBillingAnchorDateRequest request) {
        return this.rawClient.changeBillingAnchorDate(request).body();
    }

    /**
     * Changes the <a href="https://developer.squareup.com/docs/subscriptions-api/subscription-billing#billing-dates">billing anchor date</a>
     * for a subscription.
     */
    public ChangeBillingAnchorDateResponse changeBillingAnchorDate(
            ChangeBillingAnchorDateRequest request, RequestOptions requestOptions) {
        return this.rawClient.changeBillingAnchorDate(request, requestOptions).body();
    }

    /**
     * Schedules a <code>CANCEL</code> action to cancel an active subscription. This
     * sets the <code>canceled_date</code> field to the end of the active billing period. After this date,
     * the subscription status changes from ACTIVE to CANCELED.
     */
    public CancelSubscriptionResponse cancel(CancelSubscriptionsRequest request) {
        return this.rawClient.cancel(request).body();
    }

    /**
     * Schedules a <code>CANCEL</code> action to cancel an active subscription. This
     * sets the <code>canceled_date</code> field to the end of the active billing period. After this date,
     * the subscription status changes from ACTIVE to CANCELED.
     */
    public CancelSubscriptionResponse cancel(CancelSubscriptionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.cancel(request, requestOptions).body();
    }

    /**
     * Lists all <a href="https://developer.squareup.com/docs/subscriptions-api/actions-events">events</a> for a specific subscription.
     */
    public SyncPagingIterable<SubscriptionEvent> listEvents(ListEventsSubscriptionsRequest request) {
        return this.rawClient.listEvents(request).body();
    }

    /**
     * Lists all <a href="https://developer.squareup.com/docs/subscriptions-api/actions-events">events</a> for a specific subscription.
     */
    public SyncPagingIterable<SubscriptionEvent> listEvents(
            ListEventsSubscriptionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.listEvents(request, requestOptions).body();
    }

    /**
     * Schedules a <code>PAUSE</code> action to pause an active subscription.
     */
    public PauseSubscriptionResponse pause(PauseSubscriptionRequest request) {
        return this.rawClient.pause(request).body();
    }

    /**
     * Schedules a <code>PAUSE</code> action to pause an active subscription.
     */
    public PauseSubscriptionResponse pause(PauseSubscriptionRequest request, RequestOptions requestOptions) {
        return this.rawClient.pause(request, requestOptions).body();
    }

    /**
     * Schedules a <code>RESUME</code> action to resume a paused or a deactivated subscription.
     */
    public ResumeSubscriptionResponse resume(ResumeSubscriptionRequest request) {
        return this.rawClient.resume(request).body();
    }

    /**
     * Schedules a <code>RESUME</code> action to resume a paused or a deactivated subscription.
     */
    public ResumeSubscriptionResponse resume(ResumeSubscriptionRequest request, RequestOptions requestOptions) {
        return this.rawClient.resume(request, requestOptions).body();
    }

    /**
     * Schedules a <code>SWAP_PLAN</code> action to swap a subscription plan variation in an existing subscription.
     * For more information, see <a href="https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations">Swap Subscription Plan Variations</a>.
     */
    public SwapPlanResponse swapPlan(SwapPlanRequest request) {
        return this.rawClient.swapPlan(request).body();
    }

    /**
     * Schedules a <code>SWAP_PLAN</code> action to swap a subscription plan variation in an existing subscription.
     * For more information, see <a href="https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations">Swap Subscription Plan Variations</a>.
     */
    public SwapPlanResponse swapPlan(SwapPlanRequest request, RequestOptions requestOptions) {
        return this.rawClient.swapPlan(request, requestOptions).body();
    }
}
