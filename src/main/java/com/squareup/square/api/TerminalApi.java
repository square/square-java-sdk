
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelTerminalActionResponse;
import com.squareup.square.models.CancelTerminalCheckoutResponse;
import com.squareup.square.models.CancelTerminalRefundResponse;
import com.squareup.square.models.CreateTerminalActionRequest;
import com.squareup.square.models.CreateTerminalActionResponse;
import com.squareup.square.models.CreateTerminalCheckoutRequest;
import com.squareup.square.models.CreateTerminalCheckoutResponse;
import com.squareup.square.models.CreateTerminalRefundRequest;
import com.squareup.square.models.CreateTerminalRefundResponse;
import com.squareup.square.models.GetTerminalActionResponse;
import com.squareup.square.models.GetTerminalCheckoutResponse;
import com.squareup.square.models.GetTerminalRefundResponse;
import com.squareup.square.models.SearchTerminalActionsRequest;
import com.squareup.square.models.SearchTerminalActionsResponse;
import com.squareup.square.models.SearchTerminalCheckoutsRequest;
import com.squareup.square.models.SearchTerminalCheckoutsResponse;
import com.squareup.square.models.SearchTerminalRefundsRequest;
import com.squareup.square.models.SearchTerminalRefundsResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface TerminalApi {
    /**
     * Creates a Terminal action request and sends it to the specified device.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateTerminalActionResponse createTerminalAction(
            final CreateTerminalActionRequest body) throws ApiException, IOException;

    /**
     * Creates a Terminal action request and sends it to the specified device.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalActionResponse response from the API call
     */
    CompletableFuture<CreateTerminalActionResponse> createTerminalActionAsync(
            final CreateTerminalActionRequest body);

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the
     * request. Terminal action requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalActionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchTerminalActionsResponse searchTerminalActions(
            final SearchTerminalActionsRequest body) throws ApiException, IOException;

    /**
     * Retrieves a filtered list of Terminal action requests created by the account making the
     * request. Terminal action requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalActionsResponse response from the API call
     */
    CompletableFuture<SearchTerminalActionsResponse> searchTerminalActionsAsync(
            final SearchTerminalActionsRequest body);

    /**
     * Retrieves a Terminal action request by `action_id`. Terminal action requests are available
     * for 30 days.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the GetTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTerminalActionResponse getTerminalAction(
            final String actionId) throws ApiException, IOException;

    /**
     * Retrieves a Terminal action request by `action_id`. Terminal action requests are available
     * for 30 days.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the GetTerminalActionResponse response from the API call
     */
    CompletableFuture<GetTerminalActionResponse> getTerminalActionAsync(
            final String actionId);

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the CancelTerminalActionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelTerminalActionResponse cancelTerminalAction(
            final String actionId) throws ApiException, IOException;

    /**
     * Cancels a Terminal action request if the status of the request permits it.
     * @param  actionId  Required parameter: Unique ID for the desired `TerminalAction`
     * @return    Returns the CancelTerminalActionResponse response from the API call
     */
    CompletableFuture<CancelTerminalActionResponse> cancelTerminalActionAsync(
            final String actionId);

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateTerminalCheckoutResponse createTerminalCheckout(
            final CreateTerminalCheckoutRequest body) throws ApiException, IOException;

    /**
     * Creates a Terminal checkout request and sends it to the specified device to take a payment
     * for the requested amount.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalCheckoutResponse response from the API call
     */
    CompletableFuture<CreateTerminalCheckoutResponse> createTerminalCheckoutAsync(
            final CreateTerminalCheckoutRequest body);

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
    SearchTerminalCheckoutsResponse searchTerminalCheckouts(
            final SearchTerminalCheckoutsRequest body) throws ApiException, IOException;

    /**
     * Returns a filtered list of Terminal checkout requests created by the application making the
     * request. Only Terminal checkout requests created for the merchant scoped to the OAuth token
     * are returned. Terminal checkout requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     */
    CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
            final SearchTerminalCheckoutsRequest body);

    /**
     * Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are
     * available for 30 days.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTerminalCheckoutResponse getTerminalCheckout(
            final String checkoutId) throws ApiException, IOException;

    /**
     * Retrieves a Terminal checkout request by `checkout_id`. Terminal checkout requests are
     * available for 30 days.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     */
    CompletableFuture<GetTerminalCheckoutResponse> getTerminalCheckoutAsync(
            final String checkoutId);

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelTerminalCheckoutResponse cancelTerminalCheckout(
            final String checkoutId) throws ApiException, IOException;

    /**
     * Cancels a Terminal checkout request if the status of the request permits it.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the CancelTerminalCheckoutResponse response from the API call
     */
    CompletableFuture<CancelTerminalCheckoutResponse> cancelTerminalCheckoutAsync(
            final String checkoutId);

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
    CreateTerminalRefundResponse createTerminalRefund(
            final CreateTerminalRefundRequest body) throws ApiException, IOException;

    /**
     * Creates a request to refund an Interac payment completed on a Square Terminal. Refunds for
     * Interac payments on a Square Terminal are supported only for Interac debit cards in Canada.
     * Other refunds for Terminal payments should use the Refunds API. For more information, see
     * [Refunds API]($e/Refunds).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     */
    CompletableFuture<CreateTerminalRefundResponse> createTerminalRefundAsync(
            final CreateTerminalRefundRequest body);

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request. Terminal refund requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchTerminalRefundsResponse searchTerminalRefunds(
            final SearchTerminalRefundsRequest body) throws ApiException, IOException;

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request. Terminal refund requests are available for 30 days.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     */
    CompletableFuture<SearchTerminalRefundsResponse> searchTerminalRefundsAsync(
            final SearchTerminalRefundsRequest body);

    /**
     * Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for
     * 30 days.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTerminalRefundResponse getTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException;

    /**
     * Retrieves an Interac Terminal refund object by ID. Terminal refund objects are available for
     * 30 days.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     */
    CompletableFuture<GetTerminalRefundResponse> getTerminalRefundAsync(
            final String terminalRefundId);

    /**
     * Cancels an Interac Terminal refund request by refund request ID if the status of the request
     * permits it.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the CancelTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelTerminalRefundResponse cancelTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException;

    /**
     * Cancels an Interac Terminal refund request by refund request ID if the status of the request
     * permits it.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the CancelTerminalRefundResponse response from the API call
     */
    CompletableFuture<CancelTerminalRefundResponse> cancelTerminalRefundAsync(
            final String terminalRefundId);

}