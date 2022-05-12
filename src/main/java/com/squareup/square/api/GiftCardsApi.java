
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateGiftCardRequest;
import com.squareup.square.models.CreateGiftCardResponse;
import com.squareup.square.models.LinkCustomerToGiftCardRequest;
import com.squareup.square.models.LinkCustomerToGiftCardResponse;
import com.squareup.square.models.ListGiftCardsResponse;
import com.squareup.square.models.RetrieveGiftCardFromGANRequest;
import com.squareup.square.models.RetrieveGiftCardFromGANResponse;
import com.squareup.square.models.RetrieveGiftCardFromNonceRequest;
import com.squareup.square.models.RetrieveGiftCardFromNonceResponse;
import com.squareup.square.models.RetrieveGiftCardResponse;
import com.squareup.square.models.UnlinkCustomerFromGiftCardRequest;
import com.squareup.square.models.UnlinkCustomerFromGiftCardResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface GiftCardsApi {
    /**
     * Lists all gift cards. You can specify optional filters to retrieve a subset of the gift
     * cards.
     * @param  type  Optional parameter: If a [type]($m/GiftCardType) is provided, the endpoint
     *         returns gift cards of the specified type. Otherwise, the endpoint returns gift cards
     *         of all types.
     * @param  state  Optional parameter: If a [state]($m/GiftCardStatus) is provided, the endpoint
     *         returns the gift cards in the specified state. Otherwise, the endpoint returns the
     *         gift cards of all states.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns only the
     *         specified number of results per page. The maximum value is 50. The default value is
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
    ListGiftCardsResponse listGiftCards(
            final String type,
            final String state,
            final Integer limit,
            final String cursor,
            final String customerId) throws ApiException, IOException;

    /**
     * Lists all gift cards. You can specify optional filters to retrieve a subset of the gift
     * cards.
     * @param  type  Optional parameter: If a [type]($m/GiftCardType) is provided, the endpoint
     *         returns gift cards of the specified type. Otherwise, the endpoint returns gift cards
     *         of all types.
     * @param  state  Optional parameter: If a [state]($m/GiftCardStatus) is provided, the endpoint
     *         returns the gift cards in the specified state. Otherwise, the endpoint returns the
     *         gift cards of all states.
     * @param  limit  Optional parameter: If a limit is provided, the endpoint returns only the
     *         specified number of results per page. The maximum value is 50. The default value is
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
    CompletableFuture<ListGiftCardsResponse> listGiftCardsAsync(
            final String type,
            final String state,
            final Integer limit,
            final String cursor,
            final String customerId);

    /**
     * Creates a digital gift card or registers a physical (plastic) gift card. After the gift card
     * is created, you must call
     * [CreateGiftCardActivity]($e/GiftCardActivities/CreateGiftCardActivity) to activate the card
     * with an initial balance before it can be used for payment.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateGiftCardResponse createGiftCard(
            final CreateGiftCardRequest body) throws ApiException, IOException;

    /**
     * Creates a digital gift card or registers a physical (plastic) gift card. After the gift card
     * is created, you must call
     * [CreateGiftCardActivity]($e/GiftCardActivities/CreateGiftCardActivity) to activate the card
     * with an initial balance before it can be used for payment.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateGiftCardResponse response from the API call
     */
    CompletableFuture<CreateGiftCardResponse> createGiftCardAsync(
            final CreateGiftCardRequest body);

    /**
     * Retrieves a gift card using the gift card account number (GAN).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromGANResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveGiftCardFromGANResponse retrieveGiftCardFromGAN(
            final RetrieveGiftCardFromGANRequest body) throws ApiException, IOException;

    /**
     * Retrieves a gift card using the gift card account number (GAN).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromGANResponse response from the API call
     */
    CompletableFuture<RetrieveGiftCardFromGANResponse> retrieveGiftCardFromGANAsync(
            final RetrieveGiftCardFromGANRequest body);

    /**
     * Retrieves a gift card using a secure payment token that represents the gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromNonceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveGiftCardFromNonceResponse retrieveGiftCardFromNonce(
            final RetrieveGiftCardFromNonceRequest body) throws ApiException, IOException;

    /**
     * Retrieves a gift card using a secure payment token that represents the gift card.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RetrieveGiftCardFromNonceResponse response from the API call
     */
    CompletableFuture<RetrieveGiftCardFromNonceResponse> retrieveGiftCardFromNonceAsync(
            final RetrieveGiftCardFromNonceRequest body);

    /**
     * Links a customer to a gift card, which is also referred to as adding a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be linked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the LinkCustomerToGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    LinkCustomerToGiftCardResponse linkCustomerToGiftCard(
            final String giftCardId,
            final LinkCustomerToGiftCardRequest body) throws ApiException, IOException;

    /**
     * Links a customer to a gift card, which is also referred to as adding a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be linked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the LinkCustomerToGiftCardResponse response from the API call
     */
    CompletableFuture<LinkCustomerToGiftCardResponse> linkCustomerToGiftCardAsync(
            final String giftCardId,
            final LinkCustomerToGiftCardRequest body);

    /**
     * Unlinks a customer from a gift card, which is also referred to as removing a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be unlinked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UnlinkCustomerFromGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UnlinkCustomerFromGiftCardResponse unlinkCustomerFromGiftCard(
            final String giftCardId,
            final UnlinkCustomerFromGiftCardRequest body) throws ApiException, IOException;

    /**
     * Unlinks a customer from a gift card, which is also referred to as removing a card on file.
     * @param  giftCardId  Required parameter: The ID of the gift card to be unlinked.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UnlinkCustomerFromGiftCardResponse response from the API call
     */
    CompletableFuture<UnlinkCustomerFromGiftCardResponse> unlinkCustomerFromGiftCardAsync(
            final String giftCardId,
            final UnlinkCustomerFromGiftCardRequest body);

    /**
     * Retrieves a gift card using the gift card ID.
     * @param  id  Required parameter: The ID of the gift card to retrieve.
     * @return    Returns the RetrieveGiftCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveGiftCardResponse retrieveGiftCard(
            final String id) throws ApiException, IOException;

    /**
     * Retrieves a gift card using the gift card ID.
     * @param  id  Required parameter: The ID of the gift card to retrieve.
     * @return    Returns the RetrieveGiftCardResponse response from the API call
     */
    CompletableFuture<RetrieveGiftCardResponse> retrieveGiftCardAsync(
            final String id);

}