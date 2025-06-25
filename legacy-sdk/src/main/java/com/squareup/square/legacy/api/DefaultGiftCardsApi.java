package com.squareup.square.legacy.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.CreateGiftCardRequest;
import com.squareup.square.legacy.models.CreateGiftCardResponse;
import com.squareup.square.legacy.models.LinkCustomerToGiftCardRequest;
import com.squareup.square.legacy.models.LinkCustomerToGiftCardResponse;
import com.squareup.square.legacy.models.ListGiftCardsResponse;
import com.squareup.square.legacy.models.RetrieveGiftCardFromGANRequest;
import com.squareup.square.legacy.models.RetrieveGiftCardFromGANResponse;
import com.squareup.square.legacy.models.RetrieveGiftCardFromNonceRequest;
import com.squareup.square.legacy.models.RetrieveGiftCardFromNonceResponse;
import com.squareup.square.legacy.models.RetrieveGiftCardResponse;
import com.squareup.square.legacy.models.UnlinkCustomerFromGiftCardRequest;
import com.squareup.square.legacy.models.UnlinkCustomerFromGiftCardResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultGiftCardsApi extends BaseApi implements GiftCardsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultGiftCardsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists all gift cards. You can specify optional filters to retrieve a subset of the gift
     * cards. Results are sorted by `created_at` in ascending order.
     * @param  type  Optional parameter: If a [type](entity:GiftCardType) is provided, the endpoint
     *         returns gift cards of the specified type. Otherwise, the endpoint returns gift cards
     *         of all types.
     * @param  state  Optional parameter: If a [state](entity:GiftCardStatus) is provided, the
     *         endpoint returns the gift cards in the specified state. Otherwise, the endpoint
     *         returns the gift cards of all states.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns only the
     *         specified number of results per page. The maximum value is 200. The default value is
     *         30. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  customerId  Optional parameter: If a customer ID is provided, the endpoint returns
     *         only the gift cards linked to the specified customer.
     * @return    Returns the ListGiftCardsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListGiftCardsResponse listGiftCards(
            final String type, final String state, final Integer limit, final String cursor, final String customerId)
            throws ApiException, IOException {
        return prepareListGiftCardsRequest(type, state, limit, cursor, customerId)
                .execute();
    }

    /**
     * Lists all gift cards. You can specify optional filters to retrieve a subset of the gift
     * cards. Results are sorted by `created_at` in ascending order.
     * @param  type  Optional parameter: If a [type](entity:GiftCardType) is provided, the endpoint
     *         returns gift cards of the specified type. Otherwise, the endpoint returns gift cards
     *         of all types.
     * @param  state  Optional parameter: If a [state](entity:GiftCardStatus) is provided, the
     *         endpoint returns the gift cards in the specified state. Otherwise, the endpoint
     *         returns the gift cards of all states.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns only the
     *         specified number of results per page. The maximum value is 200. The default value is
     *         30. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. If a cursor is not provided, the endpoint returns the first page of the
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  customerId  Optional parameter: If a customer ID is provided, the endpoint returns
     *         only the gift cards linked to the specified customer.
     * @return    Returns the ListGiftCardsResponse response from the API call
     */
    public CompletableFuture<ListGiftCardsResponse> listGiftCardsAsync(
            final String type, final String state, final Integer limit, final String cursor, final String customerId) {
        try {
            return prepareListGiftCardsRequest(type, state, limit, cursor, customerId)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listGiftCards.
     */
    private ApiCall<ListGiftCardsResponse, ApiException> prepareListGiftCardsRequest(
            final String type, final String state, final Integer limit, final String cursor, final String customerId)
            throws IOException {
        return new ApiCall.Builder<ListGiftCardsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards")
                        .queryParam(param -> param.key("type").value(type).isRequired(false))
                        .queryParam(param -> param.key("state").value(state).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .queryParam(param ->
                                param.key("customer_id").value(customerId).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListGiftCardsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a digital gift card or registers a physical (plastic) gift card. The resulting gift
     * card has a `PENDING` state. To activate a gift card so that it can be redeemed for purchases,
     * call [CreateGiftCardActivity]($e/GiftCardActivities/CreateGiftCardActivity) and create an
     * `ACTIVATE` activity with the initial balance. Alternatively, you can use
     * [RefundPayment]($e/Refunds/RefundPayment) to refund a payment to the new gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateGiftCardResponse createGiftCard(final CreateGiftCardRequest body) throws ApiException, IOException {
        return prepareCreateGiftCardRequest(body).execute();
    }

    /**
     * Creates a digital gift card or registers a physical (plastic) gift card. The resulting gift
     * card has a `PENDING` state. To activate a gift card so that it can be redeemed for purchases,
     * call [CreateGiftCardActivity]($e/GiftCardActivities/CreateGiftCardActivity) and create an
     * `ACTIVATE` activity with the initial balance. Alternatively, you can use
     * [RefundPayment]($e/Refunds/RefundPayment) to refund a payment to the new gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardResponse response from the API call
     */
    public CompletableFuture<CreateGiftCardResponse> createGiftCardAsync(final CreateGiftCardRequest body) {
        try {
            return prepareCreateGiftCardRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for createGiftCard.
     */
    private ApiCall<CreateGiftCardResponse, ApiException> prepareCreateGiftCardRequest(final CreateGiftCardRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateGiftCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, CreateGiftCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a gift card using the gift card account number (GAN).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromGANResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveGiftCardFromGANResponse retrieveGiftCardFromGAN(final RetrieveGiftCardFromGANRequest body)
            throws ApiException, IOException {
        return prepareRetrieveGiftCardFromGANRequest(body).execute();
    }

    /**
     * Retrieves a gift card using the gift card account number (GAN).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromGANResponse response from the API call
     */
    public CompletableFuture<RetrieveGiftCardFromGANResponse> retrieveGiftCardFromGANAsync(
            final RetrieveGiftCardFromGANRequest body) {
        try {
            return prepareRetrieveGiftCardFromGANRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveGiftCardFromGAN.
     */
    private ApiCall<RetrieveGiftCardFromGANResponse, ApiException> prepareRetrieveGiftCardFromGANRequest(
            final RetrieveGiftCardFromGANRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RetrieveGiftCardFromGANResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/from-gan")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveGiftCardFromGANResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a gift card using a secure payment token that represents the gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromNonceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveGiftCardFromNonceResponse retrieveGiftCardFromNonce(final RetrieveGiftCardFromNonceRequest body)
            throws ApiException, IOException {
        return prepareRetrieveGiftCardFromNonceRequest(body).execute();
    }

    /**
     * Retrieves a gift card using a secure payment token that represents the gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromNonceResponse response from the API call
     */
    public CompletableFuture<RetrieveGiftCardFromNonceResponse> retrieveGiftCardFromNonceAsync(
            final RetrieveGiftCardFromNonceRequest body) {
        try {
            return prepareRetrieveGiftCardFromNonceRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveGiftCardFromNonce.
     */
    private ApiCall<RetrieveGiftCardFromNonceResponse, ApiException> prepareRetrieveGiftCardFromNonceRequest(
            final RetrieveGiftCardFromNonceRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RetrieveGiftCardFromNonceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/from-nonce")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveGiftCardFromNonceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Links a customer to a gift card, which is also referred to as adding a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be linked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the LinkCustomerToGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public LinkCustomerToGiftCardResponse linkCustomerToGiftCard(
            final String giftCardId, final LinkCustomerToGiftCardRequest body) throws ApiException, IOException {
        return prepareLinkCustomerToGiftCardRequest(giftCardId, body).execute();
    }

    /**
     * Links a customer to a gift card, which is also referred to as adding a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be linked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the LinkCustomerToGiftCardResponse response from the API call
     */
    public CompletableFuture<LinkCustomerToGiftCardResponse> linkCustomerToGiftCardAsync(
            final String giftCardId, final LinkCustomerToGiftCardRequest body) {
        try {
            return prepareLinkCustomerToGiftCardRequest(giftCardId, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for linkCustomerToGiftCard.
     */
    private ApiCall<LinkCustomerToGiftCardResponse, ApiException> prepareLinkCustomerToGiftCardRequest(
            final String giftCardId, final LinkCustomerToGiftCardRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<LinkCustomerToGiftCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/{gift_card_id}/link-customer")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param ->
                                param.key("gift_card_id").value(giftCardId).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, LinkCustomerToGiftCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Unlinks a customer from a gift card, which is also referred to as removing a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be unlinked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UnlinkCustomerFromGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UnlinkCustomerFromGiftCardResponse unlinkCustomerFromGiftCard(
            final String giftCardId, final UnlinkCustomerFromGiftCardRequest body) throws ApiException, IOException {
        return prepareUnlinkCustomerFromGiftCardRequest(giftCardId, body).execute();
    }

    /**
     * Unlinks a customer from a gift card, which is also referred to as removing a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be unlinked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UnlinkCustomerFromGiftCardResponse response from the API call
     */
    public CompletableFuture<UnlinkCustomerFromGiftCardResponse> unlinkCustomerFromGiftCardAsync(
            final String giftCardId, final UnlinkCustomerFromGiftCardRequest body) {
        try {
            return prepareUnlinkCustomerFromGiftCardRequest(giftCardId, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for unlinkCustomerFromGiftCard.
     */
    private ApiCall<UnlinkCustomerFromGiftCardResponse, ApiException> prepareUnlinkCustomerFromGiftCardRequest(
            final String giftCardId, final UnlinkCustomerFromGiftCardRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UnlinkCustomerFromGiftCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/{gift_card_id}/unlink-customer")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param ->
                                param.key("gift_card_id").value(giftCardId).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UnlinkCustomerFromGiftCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a gift card using the gift card ID.
     * @param  id  Required parameter: The ID of the gift card to retrieve.
     * @return    Returns the RetrieveGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveGiftCardResponse retrieveGiftCard(final String id) throws ApiException, IOException {
        return prepareRetrieveGiftCardRequest(id).execute();
    }

    /**
     * Retrieves a gift card using the gift card ID.
     * @param  id  Required parameter: The ID of the gift card to retrieve.
     * @return    Returns the RetrieveGiftCardResponse response from the API call
     */
    public CompletableFuture<RetrieveGiftCardResponse> retrieveGiftCardAsync(final String id) {
        try {
            return prepareRetrieveGiftCardRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for retrieveGiftCard.
     */
    private ApiCall<RetrieveGiftCardResponse, ApiException> prepareRetrieveGiftCardRequest(final String id)
            throws IOException {
        return new ApiCall.Builder<RetrieveGiftCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/gift-cards/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, RetrieveGiftCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
