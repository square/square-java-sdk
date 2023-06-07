
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CancelTerminalActionResponse;
import com.squareup.square.models.CancelTerminalCheckoutResponse;
import com.squareup.square.models.CancelTerminalRefundResponse;
import com.squareup.square.models.CreateTerminalActionRequest;
import com.squareup.square.models.CreateTerminalActionResponse;
import com.squareup.square.models.CreateTerminalCheckoutRequest;
import com.squareup.square.models.CreateTerminalCheckoutResponse;
import com.squareup.square.models.CreateTerminalRefundRequest;
import com.squareup.square.models.CreateTerminalRefundResponse;
import com.squareup.square.models.DismissTerminalActionResponse;
import com.squareup.square.models.GetTerminalActionResponse;
import com.squareup.square.models.GetTerminalCheckoutResponse;
import com.squareup.square.models.GetTerminalRefundResponse;
import com.squareup.square.models.SearchTerminalActionsRequest;
import com.squareup.square.models.SearchTerminalActionsResponse;
import com.squareup.square.models.SearchTerminalCheckoutsRequest;
import com.squareup.square.models.SearchTerminalCheckoutsResponse;
import com.squareup.square.models.SearchTerminalRefundsRequest;
import com.squareup.square.models.SearchTerminalRefundsResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTerminalApi extends BaseApi implements TerminalApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultTerminalApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Creates a Terminal action request and sends it to the specified device.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTerminalActionResponse createTerminalAction(
            final CreateTerminalActionRequest body) throws ApiException, IOException {
        return prepareCreateTerminalActionRequest(body).execute();
    }

    /**
     * Creates a Terminal action request and sends it to the specified device.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalActionResponse response from the API call
     */
    public CompletableFuture<CreateTerminalActionResponse> createTerminalActionAsync(
            final CreateTerminalActionRequest body) {
        try { 
            return prepareCreateTerminalActionRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createTerminalAction.
     */
    private ApiCall<CreateTerminalActionResponse, ApiException> prepareCreateTerminalActionRequest(
            final CreateTerminalActionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateTerminalActionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/actions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateTerminalActionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the
     * request. Terminal action requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalActionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTerminalActionsResponse searchTerminalActions(
            final SearchTerminalActionsRequest body) throws ApiException, IOException {
        return prepareSearchTerminalActionsRequest(body).execute();
    }

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the
     * request. Terminal action requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalActionsResponse response from the API call
     */
    public CompletableFuture<SearchTerminalActionsResponse> searchTerminalActionsAsync(
            final SearchTerminalActionsRequest body) {
        try { 
            return prepareSearchTerminalActionsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchTerminalActions.
     */
    private ApiCall<SearchTerminalActionsResponse, ApiException> prepareSearchTerminalActionsRequest(
            final SearchTerminalActionsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchTerminalActionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/actions/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchTerminalActionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a Terminal action request by `action_id`. Terminal action requests are available
     * for 30 days.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`.
     * @return    Returns the GetTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTerminalActionResponse getTerminalAction(
            final String actionId) throws ApiException, IOException {
        return prepareGetTerminalActionRequest(actionId).execute();
    }

    /**
     * Retrieves a Terminal action request by `action_id`. Terminal action requests are available
     * for 30 days.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`.
     * @return    Returns the GetTerminalActionResponse response from the API call
     */
    public CompletableFuture<GetTerminalActionResponse> getTerminalActionAsync(
            final String actionId) {
        try { 
            return prepareGetTerminalActionRequest(actionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getTerminalAction.
     */
    private ApiCall<GetTerminalActionResponse, ApiException> prepareGetTerminalActionRequest(
            final String actionId) throws IOException {
        return new ApiCall.Builder<GetTerminalActionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/actions/{action_id}")
                        .templateParam(param -> param.key("action_id").value(actionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetTerminalActionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`.
     * @return    Returns the CancelTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelTerminalActionResponse cancelTerminalAction(
            final String actionId) throws ApiException, IOException {
        return prepareCancelTerminalActionRequest(actionId).execute();
    }

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`.
     * @return    Returns the CancelTerminalActionResponse response from the API call
     */
    public CompletableFuture<CancelTerminalActionResponse> cancelTerminalActionAsync(
            final String actionId) {
        try { 
            return prepareCancelTerminalActionRequest(actionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelTerminalAction.
     */
    private ApiCall<CancelTerminalActionResponse, ApiException> prepareCancelTerminalActionRequest(
            final String actionId) throws IOException {
        return new ApiCall.Builder<CancelTerminalActionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/actions/{action_id}/cancel")
                        .templateParam(param -> param.key("action_id").value(actionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelTerminalActionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Dismisses a Terminal action request if the status and type of the request permits it. See
     * [Link and Dismiss
     * Actions](https://developer.squareup.com/docs/terminal-api/advanced-features/custom-workflows/link-and-dismiss-actions)
     * for more details.
     * @param  actionId  Required parameter: Unique ID for the `TerminalAction` associated with the
     *         waiting dialog to be dismissed.
     * @return    Returns the DismissTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DismissTerminalActionResponse dismissTerminalAction(
            final String actionId) throws ApiException, IOException {
        return prepareDismissTerminalActionRequest(actionId).execute();
    }

    /**
     * Dismisses a Terminal action request if the status and type of the request permits it. See
     * [Link and Dismiss
     * Actions](https://developer.squareup.com/docs/terminal-api/advanced-features/custom-workflows/link-and-dismiss-actions)
     * for more details.
     * @param  actionId  Required parameter: Unique ID for the `TerminalAction` associated with the
     *         waiting dialog to be dismissed.
     * @return    Returns the DismissTerminalActionResponse response from the API call
     */
    public CompletableFuture<DismissTerminalActionResponse> dismissTerminalActionAsync(
            final String actionId) {
        try { 
            return prepareDismissTerminalActionRequest(actionId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for dismissTerminalAction.
     */
    private ApiCall<DismissTerminalActionResponse, ApiException> prepareDismissTerminalActionRequest(
            final String actionId) throws IOException {
        return new ApiCall.Builder<DismissTerminalActionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/actions/{action_id}/dismiss")
                        .templateParam(param -> param.key("action_id").value(actionId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DismissTerminalActionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTerminalCheckoutResponse createTerminalCheckout(
            final CreateTerminalCheckoutRequest body) throws ApiException, IOException {
        return prepareCreateTerminalCheckoutRequest(body).execute();
    }

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     */
    public CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
            final CreateTerminalCheckoutRequest body) {
        try { 
            return prepareCreateTerminalCheckoutRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createTerminalCheckout.
     */
    private ApiCall<CreateTerminalCheckoutResponse, ApiException> prepareCreateTerminalCheckoutRequest(
            final CreateTerminalCheckoutRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateTerminalCheckoutResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/checkouts")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateTerminalCheckoutResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the
     * request. Only Terminal checkout requests created for the merchant scoped to the OAuth token
     * are returned. Terminal checkout requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTerminalCheckoutsResponse searchTerminalCheckouts(
            final SearchTerminalCheckoutsRequest body) throws ApiException, IOException {
        return prepareSearchTerminalCheckoutsRequest(body).execute();
    }

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the
     * request. Only Terminal checkout requests created for the merchant scoped to the OAuth token
     * are returned. Terminal checkout requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     */
    public CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
            final SearchTerminalCheckoutsRequest body) {
        try { 
            return prepareSearchTerminalCheckoutsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchTerminalCheckouts.
     */
    private ApiCall<SearchTerminalCheckoutsResponse, ApiException> prepareSearchTerminalCheckoutsRequest(
            final SearchTerminalCheckoutsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchTerminalCheckoutsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/checkouts/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchTerminalCheckoutsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are
     * available for 30 days.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTerminalCheckoutResponse getTerminalCheckout(
            final String checkoutId) throws ApiException, IOException {
        return prepareGetTerminalCheckoutRequest(checkoutId).execute();
    }

    /**
     * Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are
     * available for 30 days.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     */
    public CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
            final String checkoutId) {
        try { 
            return prepareGetTerminalCheckoutRequest(checkoutId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getTerminalCheckout.
     */
    private ApiCall<GetTerminalCheckoutResponse, ApiException> prepareGetTerminalCheckoutRequest(
            final String checkoutId) throws IOException {
        return new ApiCall.Builder<GetTerminalCheckoutResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/checkouts/{checkout_id}")
                        .templateParam(param -> param.key("checkout_id").value(checkoutId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetTerminalCheckoutResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelTerminalCheckoutResponse cancelTerminalCheckout(
            final String checkoutId) throws ApiException, IOException {
        return prepareCancelTerminalCheckoutRequest(checkoutId).execute();
    }

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     */
    public CompletableFuture<CancelTerminalCheckoutResponse> cancelTerminalCheckoutAsync(
            final String checkoutId) {
        try { 
            return prepareCancelTerminalCheckoutRequest(checkoutId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelTerminalCheckout.
     */
    private ApiCall<CancelTerminalCheckoutResponse, ApiException> prepareCancelTerminalCheckoutRequest(
            final String checkoutId) throws IOException {
        return new ApiCall.Builder<CancelTerminalCheckoutResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/checkouts/{checkout_id}/cancel")
                        .templateParam(param -> param.key("checkout_id").value(checkoutId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelTerminalCheckoutResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a request to refund an Interac payment completed on a Square Terminal. Refunds for
     * Interac payments on a Square Terminal are supported only for Interac debit cards in Canada.
     * Other refunds for Terminal payments should use the Refunds API. For more information, see
     * [Refunds API]($e/Refunds).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTerminalRefundResponse createTerminalRefund(
            final CreateTerminalRefundRequest body) throws ApiException, IOException {
        return prepareCreateTerminalRefundRequest(body).execute();
    }

    /**
     * Creates a request to refund an Interac payment completed on a Square Terminal. Refunds for
     * Interac payments on a Square Terminal are supported only for Interac debit cards in Canada.
     * Other refunds for Terminal payments should use the Refunds API. For more information, see
     * [Refunds API]($e/Refunds).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     */
    public CompletableFuture<CreateTerminalRefundResponse> createTerminalRefundAsync(
            final CreateTerminalRefundRequest body) {
        try { 
            return prepareCreateTerminalRefundRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createTerminalRefund.
     */
    private ApiCall<CreateTerminalRefundResponse, ApiException> prepareCreateTerminalRefundRequest(
            final CreateTerminalRefundRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateTerminalRefundResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/refunds")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateTerminalRefundResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request. Terminal refund requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTerminalRefundsResponse searchTerminalRefunds(
            final SearchTerminalRefundsRequest body) throws ApiException, IOException {
        return prepareSearchTerminalRefundsRequest(body).execute();
    }

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request. Terminal refund requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     */
    public CompletableFuture<SearchTerminalRefundsResponse> searchTerminalRefundsAsync(
            final SearchTerminalRefundsRequest body) {
        try { 
            return prepareSearchTerminalRefundsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchTerminalRefunds.
     */
    private ApiCall<SearchTerminalRefundsResponse, ApiException> prepareSearchTerminalRefundsRequest(
            final SearchTerminalRefundsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchTerminalRefundsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/refunds/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchTerminalRefundsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for
     * 30 days.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTerminalRefundResponse getTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException {
        return prepareGetTerminalRefundRequest(terminalRefundId).execute();
    }

    /**
     * Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for
     * 30 days.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     */
    public CompletableFuture<GetTerminalRefundResponse> getTerminalRefundAsync(
            final String terminalRefundId) {
        try { 
            return prepareGetTerminalRefundRequest(terminalRefundId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for getTerminalRefund.
     */
    private ApiCall<GetTerminalRefundResponse, ApiException> prepareGetTerminalRefundRequest(
            final String terminalRefundId) throws IOException {
        return new ApiCall.Builder<GetTerminalRefundResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/refunds/{terminal_refund_id}")
                        .templateParam(param -> param.key("terminal_refund_id").value(terminalRefundId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, GetTerminalRefundResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels an Interac Terminal refund request by refund request ID if the status of the request
     * permits it.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the CancelTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelTerminalRefundResponse cancelTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException {
        return prepareCancelTerminalRefundRequest(terminalRefundId).execute();
    }

    /**
     * Cancels an Interac Terminal refund request by refund request ID if the status of the request
     * permits it.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the CancelTerminalRefundResponse response from the API call
     */
    public CompletableFuture<CancelTerminalRefundResponse> cancelTerminalRefundAsync(
            final String terminalRefundId) {
        try { 
            return prepareCancelTerminalRefundRequest(terminalRefundId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelTerminalRefund.
     */
    private ApiCall<CancelTerminalRefundResponse, ApiException> prepareCancelTerminalRefundRequest(
            final String terminalRefundId) throws IOException {
        return new ApiCall.Builder<CancelTerminalRefundResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/terminals/refunds/{terminal_refund_id}/cancel")
                        .templateParam(param -> param.key("terminal_refund_id").value(terminalRefundId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelTerminalRefundResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}