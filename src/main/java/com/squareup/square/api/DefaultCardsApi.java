
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateCardRequest;
import com.squareup.square.models.CreateCardResponse;
import com.squareup.square.models.DisableCardResponse;
import com.squareup.square.models.ListCardsResponse;
import com.squareup.square.models.RetrieveCardResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCardsApi extends BaseApi implements CardsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCardsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Retrieves a list of cards owned by the account making the request. A max of 25 cards will be
     * returned.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     *         for more information.
     * @param  customerId  Optional parameter: Limit results to cards associated with the customer
     *         supplied. By default, all cards owned by the merchant are returned.
     * @param  includeDisabled  Optional parameter: Includes disabled cards. By default, all enabled
     *         cards owned by the merchant are returned.
     * @param  referenceId  Optional parameter: Limit results to cards associated with the
     *         reference_id supplied.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the card was created
     *         with the specified order. This field defaults to ASC.
     * @return    Returns the ListCardsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCardsResponse listCards(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) throws ApiException, IOException {
        return prepareListCardsRequest(cursor, customerId, includeDisabled, referenceId,
                sortOrder).execute();
    }

    /**
     * Retrieves a list of cards owned by the account making the request. A max of 25 cards will be
     * returned.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination)
     *         for more information.
     * @param  customerId  Optional parameter: Limit results to cards associated with the customer
     *         supplied. By default, all cards owned by the merchant are returned.
     * @param  includeDisabled  Optional parameter: Includes disabled cards. By default, all enabled
     *         cards owned by the merchant are returned.
     * @param  referenceId  Optional parameter: Limit results to cards associated with the
     *         reference_id supplied.
     * @param  sortOrder  Optional parameter: Sorts the returned list by when the card was created
     *         with the specified order. This field defaults to ASC.
     * @return    Returns the ListCardsResponse response from the API call
     */
    public CompletableFuture<ListCardsResponse> listCardsAsync(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) {
        try { 
            return prepareListCardsRequest(cursor, customerId, includeDisabled, referenceId,
            sortOrder).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCards.
     */
    private ApiCall<ListCardsResponse, ApiException> prepareListCardsRequest(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) throws IOException {
        return new ApiCall.Builder<ListCardsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cards")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("customer_id")
                                .value(customerId).isRequired(false))
                        .queryParam(param -> param.key("include_disabled")
                                .value((includeDisabled != null) ? includeDisabled : false).isRequired(false))
                        .queryParam(param -> param.key("reference_id")
                                .value(referenceId).isRequired(false))
                        .queryParam(param -> param.key("sort_order")
                                .value(sortOrder).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCardsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Adds a card on file to an existing merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateCardResponse createCard(
            final CreateCardRequest body) throws ApiException, IOException {
        return prepareCreateCardRequest(body).execute();
    }

    /**
     * Adds a card on file to an existing merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCardResponse response from the API call
     */
    public CompletableFuture<CreateCardResponse> createCardAsync(
            final CreateCardRequest body) {
        try { 
            return prepareCreateCardRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createCard.
     */
    private ApiCall<CreateCardResponse, ApiException> prepareCreateCardRequest(
            final CreateCardRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cards")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves details for a specific Card.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the RetrieveCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCardResponse retrieveCard(
            final String cardId) throws ApiException, IOException {
        return prepareRetrieveCardRequest(cardId).execute();
    }

    /**
     * Retrieves details for a specific Card.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the RetrieveCardResponse response from the API call
     */
    public CompletableFuture<RetrieveCardResponse> retrieveCardAsync(
            final String cardId) {
        try { 
            return prepareRetrieveCardRequest(cardId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCard.
     */
    private ApiCall<RetrieveCardResponse, ApiException> prepareRetrieveCardRequest(
            final String cardId) throws IOException {
        return new ApiCall.Builder<RetrieveCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cards/{card_id}")
                        .templateParam(param -> param.key("card_id").value(cardId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Disables the card, preventing any further updates or charges. Disabling an already disabled
     * card is allowed but has no effect.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the DisableCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DisableCardResponse disableCard(
            final String cardId) throws ApiException, IOException {
        return prepareDisableCardRequest(cardId).execute();
    }

    /**
     * Disables the card, preventing any further updates or charges. Disabling an already disabled
     * card is allowed but has no effect.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the DisableCardResponse response from the API call
     */
    public CompletableFuture<DisableCardResponse> disableCardAsync(
            final String cardId) {
        try { 
            return prepareDisableCardRequest(cardId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for disableCard.
     */
    private ApiCall<DisableCardResponse, ApiException> prepareDisableCardRequest(
            final String cardId) throws IOException {
        return new ApiCall.Builder<DisableCardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/cards/{card_id}/disable")
                        .templateParam(param -> param.key("card_id").value(cardId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DisableCardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}