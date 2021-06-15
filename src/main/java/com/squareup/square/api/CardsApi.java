
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateCardRequest;
import com.squareup.square.models.CreateCardResponse;
import com.squareup.square.models.DisableCardResponse;
import com.squareup.square.models.ListCardsResponse;
import com.squareup.square.models.RetrieveCardResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CardsApi {
    /**
     * Retrieves a list of cards owned by the account making the request. A max of 25 cards will be
     * returned.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     *         more information.
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
    ListCardsResponse listCards(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder) throws ApiException, IOException;

    /**
     * Retrieves a list of cards owned by the account making the request. A max of 25 cards will be
     * returned.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this to retrieve the next set of results for your original query.
     *         See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     *         more information.
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
    CompletableFuture<ListCardsResponse> listCardsAsync(
            final String cursor,
            final String customerId,
            final Boolean includeDisabled,
            final String referenceId,
            final String sortOrder);

    /**
     * Adds a card on file to an existing merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateCardResponse createCard(
            final CreateCardRequest body) throws ApiException, IOException;

    /**
     * Adds a card on file to an existing merchant.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateCardResponse response from the API call
     */
    CompletableFuture<CreateCardResponse> createCardAsync(
            final CreateCardRequest body);

    /**
     * Retrieves details for a specific Card.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the RetrieveCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveCardResponse retrieveCard(
            final String cardId) throws ApiException, IOException;

    /**
     * Retrieves details for a specific Card.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the RetrieveCardResponse response from the API call
     */
    CompletableFuture<RetrieveCardResponse> retrieveCardAsync(
            final String cardId);

    /**
     * Disables the card, preventing any further updates or charges. Disabling an already disabled
     * card is allowed but has no effect.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the DisableCardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DisableCardResponse disableCard(
            final String cardId) throws ApiException, IOException;

    /**
     * Disables the card, preventing any further updates or charges. Disabling an already disabled
     * card is allowed but has no effect.
     * @param  cardId  Required parameter: Unique ID for the desired Card.
     * @return    Returns the DisableCardResponse response from the API call
     */
    CompletableFuture<DisableCardResponse> disableCardAsync(
            final String cardId);

}