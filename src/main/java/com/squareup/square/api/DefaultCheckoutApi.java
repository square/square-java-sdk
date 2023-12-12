
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateCheckoutRequest;
import com.squareup.square.models.CreateCheckoutResponse;
import com.squareup.square.models.CreatePaymentLinkRequest;
import com.squareup.square.models.CreatePaymentLinkResponse;
import com.squareup.square.models.DeletePaymentLinkResponse;
import com.squareup.square.models.ListPaymentLinksResponse;
import com.squareup.square.models.RetrieveLocationSettingsResponse;
import com.squareup.square.models.RetrieveMerchantSettingsResponse;
import com.squareup.square.models.RetrievePaymentLinkResponse;
import com.squareup.square.models.UpdateLocationSettingsRequest;
import com.squareup.square.models.UpdateLocationSettingsResponse;
import com.squareup.square.models.UpdateMerchantSettingsRequest;
import com.squareup.square.models.UpdateMerchantSettingsResponse;
import com.squareup.square.models.UpdatePaymentLinkRequest;
import com.squareup.square.models.UpdatePaymentLinkResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCheckoutApi extends BaseApi implements CheckoutApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCheckoutApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public CreateCheckoutResponse createCheckout(
            final String locationId,
            final CreateCheckoutRequest body) throws ApiException, IOException {
        return prepareCreateCheckoutRequest(locationId, body).execute();
    }

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
    public CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
            final String locationId,
            final CreateCheckoutRequest body) {
        try { 
            return prepareCreateCheckoutRequest(locationId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createCheckout.
     */
    private ApiCall<CreateCheckoutResponse, ApiException> prepareCreateCheckoutRequest(
            final String locationId,
            final CreateCheckoutRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCheckoutResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/locations/{location_id}/checkouts")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateCheckoutResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @return    Returns the RetrieveLocationSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLocationSettingsResponse retrieveLocationSettings(
            final String locationId) throws ApiException, IOException {
        return prepareRetrieveLocationSettingsRequest(locationId).execute();
    }

    /**
     * Retrieves the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @return    Returns the RetrieveLocationSettingsResponse response from the API call
     */
    public CompletableFuture<RetrieveLocationSettingsResponse> retrieveLocationSettingsAsync(
            final String locationId) {
        try { 
            return prepareRetrieveLocationSettingsRequest(locationId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLocationSettings.
     */
    private ApiCall<RetrieveLocationSettingsResponse, ApiException> prepareRetrieveLocationSettingsRequest(
            final String locationId) throws IOException {
        return new ApiCall.Builder<RetrieveLocationSettingsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/location-settings/{location_id}")
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLocationSettingsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdateLocationSettingsResponse updateLocationSettings(
            final String locationId,
            final UpdateLocationSettingsRequest body) throws ApiException, IOException {
        return prepareUpdateLocationSettingsRequest(locationId, body).execute();
    }

    /**
     * Updates the location-level settings for a Square-hosted checkout page.
     * @param  locationId  Required parameter: The ID of the location for which to retrieve
     *         settings.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateLocationSettingsResponse response from the API call
     */
    public CompletableFuture<UpdateLocationSettingsResponse> updateLocationSettingsAsync(
            final String locationId,
            final UpdateLocationSettingsRequest body) {
        try { 
            return prepareUpdateLocationSettingsRequest(locationId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateLocationSettings.
     */
    private ApiCall<UpdateLocationSettingsResponse, ApiException> prepareUpdateLocationSettingsRequest(
            final String locationId,
            final UpdateLocationSettingsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateLocationSettingsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/location-settings/{location_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("location_id").value(locationId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateLocationSettingsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves the merchant-level settings for a Square-hosted checkout page.
     * @return    Returns the RetrieveMerchantSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveMerchantSettingsResponse retrieveMerchantSettings() throws ApiException, IOException {
        return prepareRetrieveMerchantSettingsRequest().execute();
    }

    /**
     * Retrieves the merchant-level settings for a Square-hosted checkout page.
     * @return    Returns the RetrieveMerchantSettingsResponse response from the API call
     */
    public CompletableFuture<RetrieveMerchantSettingsResponse> retrieveMerchantSettingsAsync() {
        try { 
            return prepareRetrieveMerchantSettingsRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveMerchantSettings.
     */
    private ApiCall<RetrieveMerchantSettingsResponse, ApiException> prepareRetrieveMerchantSettingsRequest() throws IOException {
        return new ApiCall.Builder<RetrieveMerchantSettingsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/merchant-settings")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveMerchantSettingsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates the merchant-level settings for a Square-hosted checkout page.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateMerchantSettingsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateMerchantSettingsResponse updateMerchantSettings(
            final UpdateMerchantSettingsRequest body) throws ApiException, IOException {
        return prepareUpdateMerchantSettingsRequest(body).execute();
    }

    /**
     * Updates the merchant-level settings for a Square-hosted checkout page.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateMerchantSettingsResponse response from the API call
     */
    public CompletableFuture<UpdateMerchantSettingsResponse> updateMerchantSettingsAsync(
            final UpdateMerchantSettingsRequest body) {
        try { 
            return prepareUpdateMerchantSettingsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateMerchantSettings.
     */
    private ApiCall<UpdateMerchantSettingsResponse, ApiException> prepareUpdateMerchantSettingsRequest(
            final UpdateMerchantSettingsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateMerchantSettingsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/merchant-settings")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateMerchantSettingsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists all payment links.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  limit  Optional parameter: A limit on the number of results to return per page. The
     *         limit is advisory and the implementation might return more or less results. If the
     *         supplied limit is negative, zero, or greater than the maximum limit of 1000, it is
     *         ignored. Default value: `100`
     * @return    Returns the ListPaymentLinksResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListPaymentLinksResponse listPaymentLinks(
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListPaymentLinksRequest(cursor, limit).execute();
    }

    /**
     * Lists all payment links.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  limit  Optional parameter: A limit on the number of results to return per page. The
     *         limit is advisory and the implementation might return more or less results. If the
     *         supplied limit is negative, zero, or greater than the maximum limit of 1000, it is
     *         ignored. Default value: `100`
     * @return    Returns the ListPaymentLinksResponse response from the API call
     */
    public CompletableFuture<ListPaymentLinksResponse> listPaymentLinksAsync(
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListPaymentLinksRequest(cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listPaymentLinks.
     */
    private ApiCall<ListPaymentLinksResponse, ApiException> prepareListPaymentLinksRequest(
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListPaymentLinksResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/payment-links")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListPaymentLinksResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a Square-hosted checkout page. Applications can share the resulting payment link with
     * their buyer to pay for goods and services.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreatePaymentLinkResponse createPaymentLink(
            final CreatePaymentLinkRequest body) throws ApiException, IOException {
        return prepareCreatePaymentLinkRequest(body).execute();
    }

    /**
     * Creates a Square-hosted checkout page. Applications can share the resulting payment link with
     * their buyer to pay for goods and services.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreatePaymentLinkResponse response from the API call
     */
    public CompletableFuture<CreatePaymentLinkResponse> createPaymentLinkAsync(
            final CreatePaymentLinkRequest body) {
        try { 
            return prepareCreatePaymentLinkRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createPaymentLink.
     */
    private ApiCall<CreatePaymentLinkResponse, ApiException> prepareCreatePaymentLinkRequest(
            final CreatePaymentLinkRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreatePaymentLinkResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/payment-links")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreatePaymentLinkResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a payment link.
     * @param  id  Required parameter: The ID of the payment link to delete.
     * @return    Returns the DeletePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeletePaymentLinkResponse deletePaymentLink(
            final String id) throws ApiException, IOException {
        return prepareDeletePaymentLinkRequest(id).execute();
    }

    /**
     * Deletes a payment link.
     * @param  id  Required parameter: The ID of the payment link to delete.
     * @return    Returns the DeletePaymentLinkResponse response from the API call
     */
    public CompletableFuture<DeletePaymentLinkResponse> deletePaymentLinkAsync(
            final String id) {
        try { 
            return prepareDeletePaymentLinkRequest(id).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deletePaymentLink.
     */
    private ApiCall<DeletePaymentLinkResponse, ApiException> prepareDeletePaymentLinkRequest(
            final String id) throws IOException {
        return new ApiCall.Builder<DeletePaymentLinkResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/payment-links/{id}")
                        .templateParam(param -> param.key("id").value(id)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeletePaymentLinkResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a payment link.
     * @param  id  Required parameter: The ID of link to retrieve.
     * @return    Returns the RetrievePaymentLinkResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrievePaymentLinkResponse retrievePaymentLink(
            final String id) throws ApiException, IOException {
        return prepareRetrievePaymentLinkRequest(id).execute();
    }

    /**
     * Retrieves a payment link.
     * @param  id  Required parameter: The ID of link to retrieve.
     * @return    Returns the RetrievePaymentLinkResponse response from the API call
     */
    public CompletableFuture<RetrievePaymentLinkResponse> retrievePaymentLinkAsync(
            final String id) {
        try { 
            return prepareRetrievePaymentLinkRequest(id).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrievePaymentLink.
     */
    private ApiCall<RetrievePaymentLinkResponse, ApiException> prepareRetrievePaymentLinkRequest(
            final String id) throws IOException {
        return new ApiCall.Builder<RetrievePaymentLinkResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/payment-links/{id}")
                        .templateParam(param -> param.key("id").value(id)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrievePaymentLinkResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public UpdatePaymentLinkResponse updatePaymentLink(
            final String id,
            final UpdatePaymentLinkRequest body) throws ApiException, IOException {
        return prepareUpdatePaymentLinkRequest(id, body).execute();
    }

    /**
     * Updates a payment link. You can update the `payment_link` fields such as `description`,
     * `checkout_options`, and `pre_populated_data`. You cannot update other fields such as the
     * `order_id`, `version`, `URL`, or `timestamp` field.
     * @param  id  Required parameter: The ID of the payment link to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdatePaymentLinkResponse response from the API call
     */
    public CompletableFuture<UpdatePaymentLinkResponse> updatePaymentLinkAsync(
            final String id,
            final UpdatePaymentLinkRequest body) {
        try { 
            return prepareUpdatePaymentLinkRequest(id, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updatePaymentLink.
     */
    private ApiCall<UpdatePaymentLinkResponse, ApiException> prepareUpdatePaymentLinkRequest(
            final String id,
            final UpdatePaymentLinkRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdatePaymentLinkResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/online-checkout/payment-links/{id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("id").value(id)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdatePaymentLinkResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}