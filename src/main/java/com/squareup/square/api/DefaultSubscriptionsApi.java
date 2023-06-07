
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CancelSubscriptionResponse;
import com.squareup.square.models.CreateSubscriptionRequest;
import com.squareup.square.models.CreateSubscriptionResponse;
import com.squareup.square.models.DeleteSubscriptionActionResponse;
import com.squareup.square.models.ListSubscriptionEventsResponse;
import com.squareup.square.models.PauseSubscriptionRequest;
import com.squareup.square.models.PauseSubscriptionResponse;
import com.squareup.square.models.ResumeSubscriptionRequest;
import com.squareup.square.models.ResumeSubscriptionResponse;
import com.squareup.square.models.RetrieveSubscriptionResponse;
import com.squareup.square.models.SearchSubscriptionsRequest;
import com.squareup.square.models.SearchSubscriptionsResponse;
import com.squareup.square.models.SwapPlanRequest;
import com.squareup.square.models.SwapPlanResponse;
import com.squareup.square.models.UpdateSubscriptionRequest;
import com.squareup.square.models.UpdateSubscriptionResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultSubscriptionsApi extends BaseApi implements SubscriptionsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultSubscriptionsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public CreateSubscriptionResponse createSubscription(
            final CreateSubscriptionRequest body) throws ApiException, IOException {
        return prepareCreateSubscriptionRequest(body).execute();
    }

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
    public CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(
            final CreateSubscriptionRequest body) {
        try { 
            return prepareCreateSubscriptionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createSubscription.
     */
    private ApiCall<CreateSubscriptionResponse, ApiException> prepareCreateSubscriptionRequest(
            final CreateSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public SearchSubscriptionsResponse searchSubscriptions(
            final SearchSubscriptionsRequest body) throws ApiException, IOException {
        return prepareSearchSubscriptionsRequest(body).execute();
    }

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
    public CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(
            final SearchSubscriptionsRequest body) {
        try { 
            return prepareSearchSubscriptionsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchSubscriptions.
     */
    private ApiCall<SearchSubscriptionsResponse, ApiException> prepareSearchSubscriptionsRequest(
            final SearchSubscriptionsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchSubscriptionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchSubscriptionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public RetrieveSubscriptionResponse retrieveSubscription(
            final String subscriptionId,
            final String include) throws ApiException, IOException {
        return prepareRetrieveSubscriptionRequest(subscriptionId, include).execute();
    }

    /**
     * Retrieves a specific subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to retrieve.
     * @param  include  Optional parameter: A query parameter to specify related information to be
     *         included in the response. The supported query parameter values are: - `actions`: to
     *         include scheduled actions on the targeted subscription.
     * @return    Returns the RetrieveSubscriptionResponse response from the API call
     */
    public CompletableFuture<RetrieveSubscriptionResponse> retrieveSubscriptionAsync(
            final String subscriptionId,
            final String include) {
        try { 
            return prepareRetrieveSubscriptionRequest(subscriptionId, include).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveSubscription.
     */
    private ApiCall<RetrieveSubscriptionResponse, ApiException> prepareRetrieveSubscriptionRequest(
            final String subscriptionId,
            final String include) throws IOException {
        return new ApiCall.Builder<RetrieveSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}")
                        .queryParam(param -> param.key("include")
                                .value(include).isRequired(false))
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdateSubscriptionResponse updateSubscription(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws ApiException, IOException {
        return prepareUpdateSubscriptionRequest(subscriptionId, body).execute();
    }

    /**
     * Updates a subscription by modifying or clearing `subscription` field values. To clear a
     * field, set its value to `null`.
     * @param  subscriptionId  Required parameter: The ID of the subscription to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateSubscriptionResponse response from the API call
     */
    public CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) {
        try { 
            return prepareUpdateSubscriptionRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateSubscription.
     */
    private ApiCall<UpdateSubscriptionResponse, ApiException> prepareUpdateSubscriptionRequest(
            final String subscriptionId,
            final UpdateSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a scheduled action for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription the targeted action is
     *         to act upon.
     * @param  actionId  Required parameter: The ID of the targeted action to be deleted.
     * @return    Returns the DeleteSubscriptionActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteSubscriptionActionResponse deleteSubscriptionAction(
            final String subscriptionId,
            final String actionId) throws ApiException, IOException {
        return prepareDeleteSubscriptionActionRequest(subscriptionId, actionId).execute();
    }

    /**
     * Deletes a scheduled action for a subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription the targeted action is
     *         to act upon.
     * @param  actionId  Required parameter: The ID of the targeted action to be deleted.
     * @return    Returns the DeleteSubscriptionActionResponse response from the API call
     */
    public CompletableFuture<DeleteSubscriptionActionResponse> deleteSubscriptionActionAsync(
            final String subscriptionId,
            final String actionId) {
        try { 
            return prepareDeleteSubscriptionActionRequest(subscriptionId, actionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteSubscriptionAction.
     */
    private ApiCall<DeleteSubscriptionActionResponse, ApiException> prepareDeleteSubscriptionActionRequest(
            final String subscriptionId,
            final String actionId) throws IOException {
        return new ApiCall.Builder<DeleteSubscriptionActionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}/actions/{action_id}")
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("action_id").value(actionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteSubscriptionActionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Schedules a `CANCEL` action to cancel an active subscription. This sets the `canceled_date`
     * field to the end of the active billing period. After this date, the subscription status
     * changes from ACTIVE to CANCELED.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelSubscriptionResponse cancelSubscription(
            final String subscriptionId) throws ApiException, IOException {
        return prepareCancelSubscriptionRequest(subscriptionId).execute();
    }

    /**
     * Schedules a `CANCEL` action to cancel an active subscription. This sets the `canceled_date`
     * field to the end of the active billing period. After this date, the subscription status
     * changes from ACTIVE to CANCELED.
     * @param  subscriptionId  Required parameter: The ID of the subscription to cancel.
     * @return    Returns the CancelSubscriptionResponse response from the API call
     */
    public CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(
            final String subscriptionId) {
        try { 
            return prepareCancelSubscriptionRequest(subscriptionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelSubscription.
     */
    private ApiCall<CancelSubscriptionResponse, ApiException> prepareCancelSubscriptionRequest(
            final String subscriptionId) throws IOException {
        return new ApiCall.Builder<CancelSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}/cancel")
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public ListSubscriptionEventsResponse listSubscriptionEvents(
            final String subscriptionId,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListSubscriptionEventsRequest(subscriptionId, cursor, limit).execute();
    }

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
    public CompletableFuture<ListSubscriptionEventsResponse> listSubscriptionEventsAsync(
            final String subscriptionId,
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListSubscriptionEventsRequest(subscriptionId, cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listSubscriptionEvents.
     */
    private ApiCall<ListSubscriptionEventsResponse, ApiException> prepareListSubscriptionEventsRequest(
            final String subscriptionId,
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListSubscriptionEventsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}/events")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListSubscriptionEventsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Schedules a `PAUSE` action to pause an active subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to pause.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PauseSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public PauseSubscriptionResponse pauseSubscription(
            final String subscriptionId,
            final PauseSubscriptionRequest body) throws ApiException, IOException {
        return preparePauseSubscriptionRequest(subscriptionId, body).execute();
    }

    /**
     * Schedules a `PAUSE` action to pause an active subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to pause.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the PauseSubscriptionResponse response from the API call
     */
    public CompletableFuture<PauseSubscriptionResponse> pauseSubscriptionAsync(
            final String subscriptionId,
            final PauseSubscriptionRequest body) {
        try { 
            return preparePauseSubscriptionRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for pauseSubscription.
     */
    private ApiCall<PauseSubscriptionResponse, ApiException> preparePauseSubscriptionRequest(
            final String subscriptionId,
            final PauseSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<PauseSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}/pause")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, PauseSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Schedules a `RESUME` action to resume a paused or a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ResumeSubscriptionResponse resumeSubscription(
            final String subscriptionId,
            final ResumeSubscriptionRequest body) throws ApiException, IOException {
        return prepareResumeSubscriptionRequest(subscriptionId, body).execute();
    }

    /**
     * Schedules a `RESUME` action to resume a paused or a deactivated subscription.
     * @param  subscriptionId  Required parameter: The ID of the subscription to resume.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the ResumeSubscriptionResponse response from the API call
     */
    public CompletableFuture<ResumeSubscriptionResponse> resumeSubscriptionAsync(
            final String subscriptionId,
            final ResumeSubscriptionRequest body) {
        try { 
            return prepareResumeSubscriptionRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for resumeSubscription.
     */
    private ApiCall<ResumeSubscriptionResponse, ApiException> prepareResumeSubscriptionRequest(
            final String subscriptionId,
            final ResumeSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<ResumeSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}/resume")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ResumeSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public SwapPlanResponse swapPlan(
            final String subscriptionId,
            final SwapPlanRequest body) throws ApiException, IOException {
        return prepareSwapPlanRequest(subscriptionId, body).execute();
    }

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
    public CompletableFuture<SwapPlanResponse> swapPlanAsync(
            final String subscriptionId,
            final SwapPlanRequest body) {
        try { 
            return prepareSwapPlanRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for swapPlan.
     */
    private ApiCall<SwapPlanResponse, ApiException> prepareSwapPlanRequest(
            final String subscriptionId,
            final SwapPlanRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SwapPlanResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/subscriptions/{subscription_id}/swap-plan")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SwapPlanResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}