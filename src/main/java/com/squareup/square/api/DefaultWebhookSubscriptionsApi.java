
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultWebhookSubscriptionsApi extends BaseApi implements WebhookSubscriptionsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultWebhookSubscriptionsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListWebhookEventTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListWebhookEventTypesResponse listWebhookEventTypes(
            final String apiVersion) throws ApiException, IOException {
        return prepareListWebhookEventTypesRequest(apiVersion).execute();
    }

    /**
     * Lists all webhook event types that can be subscribed to.
     * @param  apiVersion  Optional parameter: The API version for which to list event types.
     *         Setting this field overrides the default version used by the application.
     * @return    Returns the ListWebhookEventTypesResponse response from the API call
     */
    public CompletableFuture<ListWebhookEventTypesResponse> listWebhookEventTypesAsync(
            final String apiVersion) {
        try { 
            return prepareListWebhookEventTypesRequest(apiVersion).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listWebhookEventTypes.
     */
    private ApiCall<ListWebhookEventTypesResponse, ApiException> prepareListWebhookEventTypesRequest(
            final String apiVersion) throws IOException {
        return new ApiCall.Builder<ListWebhookEventTypesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/event-types")
                        .queryParam(param -> param.key("api_version")
                                .value(apiVersion).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListWebhookEventTypesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public ListWebhookSubscriptionsResponse listWebhookSubscriptions(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) throws ApiException, IOException {
        return prepareListWebhookSubscriptionsRequest(cursor, includeDisabled, sortOrder,
                limit).execute();
    }

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
    public CompletableFuture<ListWebhookSubscriptionsResponse> listWebhookSubscriptionsAsync(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) {
        try { 
            return prepareListWebhookSubscriptionsRequest(cursor, includeDisabled, sortOrder,
            limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listWebhookSubscriptions.
     */
    private ApiCall<ListWebhookSubscriptionsResponse, ApiException> prepareListWebhookSubscriptionsRequest(
            final String cursor,
            final Boolean includeDisabled,
            final String sortOrder,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListWebhookSubscriptionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("include_disabled")
                                .value((includeDisabled != null) ? includeDisabled : false).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListWebhookSubscriptionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a webhook subscription.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateWebhookSubscriptionResponse createWebhookSubscription(
            final CreateWebhookSubscriptionRequest body) throws ApiException, IOException {
        return prepareCreateWebhookSubscriptionRequest(body).execute();
    }

    /**
     * Creates a webhook subscription.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<CreateWebhookSubscriptionResponse> createWebhookSubscriptionAsync(
            final CreateWebhookSubscriptionRequest body) {
        try { 
            return prepareCreateWebhookSubscriptionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createWebhookSubscription.
     */
    private ApiCall<CreateWebhookSubscriptionResponse, ApiException> prepareCreateWebhookSubscriptionRequest(
            final CreateWebhookSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateWebhookSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateWebhookSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to delete.
     * @return    Returns the DeleteWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteWebhookSubscriptionResponse deleteWebhookSubscription(
            final String subscriptionId) throws ApiException, IOException {
        return prepareDeleteWebhookSubscriptionRequest(subscriptionId).execute();
    }

    /**
     * Deletes a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to delete.
     * @return    Returns the DeleteWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<DeleteWebhookSubscriptionResponse> deleteWebhookSubscriptionAsync(
            final String subscriptionId) {
        try { 
            return prepareDeleteWebhookSubscriptionRequest(subscriptionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteWebhookSubscription.
     */
    private ApiCall<DeleteWebhookSubscriptionResponse, ApiException> prepareDeleteWebhookSubscriptionRequest(
            final String subscriptionId) throws IOException {
        return new ApiCall.Builder<DeleteWebhookSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions/{subscription_id}")
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteWebhookSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a webhook subscription identified by its ID.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to retrieve.
     * @return    Returns the RetrieveWebhookSubscriptionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveWebhookSubscriptionResponse retrieveWebhookSubscription(
            final String subscriptionId) throws ApiException, IOException {
        return prepareRetrieveWebhookSubscriptionRequest(subscriptionId).execute();
    }

    /**
     * Retrieves a webhook subscription identified by its ID.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to retrieve.
     * @return    Returns the RetrieveWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<RetrieveWebhookSubscriptionResponse> retrieveWebhookSubscriptionAsync(
            final String subscriptionId) {
        try { 
            return prepareRetrieveWebhookSubscriptionRequest(subscriptionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveWebhookSubscription.
     */
    private ApiCall<RetrieveWebhookSubscriptionResponse, ApiException> prepareRetrieveWebhookSubscriptionRequest(
            final String subscriptionId) throws IOException {
        return new ApiCall.Builder<RetrieveWebhookSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions/{subscription_id}")
                        .templateParam(param -> param.key("subscription_id").value(subscriptionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveWebhookSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdateWebhookSubscriptionResponse updateWebhookSubscription(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) throws ApiException, IOException {
        return prepareUpdateWebhookSubscriptionRequest(subscriptionId, body).execute();
    }

    /**
     * Updates a webhook subscription.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<UpdateWebhookSubscriptionResponse> updateWebhookSubscriptionAsync(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) {
        try { 
            return prepareUpdateWebhookSubscriptionRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateWebhookSubscription.
     */
    private ApiCall<UpdateWebhookSubscriptionResponse, ApiException> prepareUpdateWebhookSubscriptionRequest(
            final String subscriptionId,
            final UpdateWebhookSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateWebhookSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions/{subscription_id}")
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
                                response -> ApiHelper.deserialize(response, UpdateWebhookSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdateWebhookSubscriptionSignatureKeyResponse updateWebhookSubscriptionSignatureKey(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) throws ApiException, IOException {
        return prepareUpdateWebhookSubscriptionSignatureKeyRequest(subscriptionId, body).execute();
    }

    /**
     * Updates a webhook subscription by replacing the existing signature key with a new one.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWebhookSubscriptionSignatureKeyResponse response from the API call
     */
    public CompletableFuture<UpdateWebhookSubscriptionSignatureKeyResponse> updateWebhookSubscriptionSignatureKeyAsync(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) {
        try { 
            return prepareUpdateWebhookSubscriptionSignatureKeyRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateWebhookSubscriptionSignatureKey.
     */
    private ApiCall<UpdateWebhookSubscriptionSignatureKeyResponse, ApiException> prepareUpdateWebhookSubscriptionSignatureKeyRequest(
            final String subscriptionId,
            final UpdateWebhookSubscriptionSignatureKeyRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateWebhookSubscriptionSignatureKeyResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions/{subscription_id}/signature-key")
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
                                response -> ApiHelper.deserialize(response, UpdateWebhookSubscriptionSignatureKeyResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public TestWebhookSubscriptionResponse testWebhookSubscription(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) throws ApiException, IOException {
        return prepareTestWebhookSubscriptionRequest(subscriptionId, body).execute();
    }

    /**
     * Tests a webhook subscription by sending a test event to the notification URL.
     * @param  subscriptionId  Required parameter: [REQUIRED] The ID of the
     *         [Subscription]($m/WebhookSubscription) to test.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the TestWebhookSubscriptionResponse response from the API call
     */
    public CompletableFuture<TestWebhookSubscriptionResponse> testWebhookSubscriptionAsync(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) {
        try { 
            return prepareTestWebhookSubscriptionRequest(subscriptionId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for testWebhookSubscription.
     */
    private ApiCall<TestWebhookSubscriptionResponse, ApiException> prepareTestWebhookSubscriptionRequest(
            final String subscriptionId,
            final TestWebhookSubscriptionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<TestWebhookSubscriptionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/webhooks/subscriptions/{subscription_id}/test")
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
                                response -> ApiHelper.deserialize(response, TestWebhookSubscriptionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}