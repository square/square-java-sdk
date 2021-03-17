
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CancelTerminalCheckoutResponse;
import com.squareup.square.models.CancelTerminalRefundResponse;
import com.squareup.square.models.CreateTerminalCheckoutRequest;
import com.squareup.square.models.CreateTerminalCheckoutResponse;
import com.squareup.square.models.CreateTerminalRefundRequest;
import com.squareup.square.models.CreateTerminalRefundResponse;
import com.squareup.square.models.GetTerminalCheckoutResponse;
import com.squareup.square.models.GetTerminalRefundResponse;
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
     * Retrieves a filtered list of Terminal checkout requests created by the account making the
     * request.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchTerminalCheckoutsResponse searchTerminalCheckouts(
            final SearchTerminalCheckoutsRequest body) throws ApiException, IOException;

    /**
     * Retrieves a filtered list of Terminal checkout requests created by the account making the
     * request.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalCheckoutsResponse response from the API call
     */
    CompletableFuture<SearchTerminalCheckoutsResponse> searchTerminalCheckoutsAsync(
            final SearchTerminalCheckoutsRequest body);

    /**
     * Retrieves a Terminal checkout request by `checkout_id`.
     * @param  checkoutId  Required parameter: The unique ID for the desired `TerminalCheckout`.
     * @return    Returns the GetTerminalCheckoutResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTerminalCheckoutResponse getTerminalCheckout(
            final String checkoutId) throws ApiException, IOException;

    /**
     * Retrieves a Terminal checkout request by `checkout_id`.
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
     * Creates a request to refund an Interac payment completed on a Square Terminal.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateTerminalRefundResponse createTerminalRefund(
            final CreateTerminalRefundRequest body) throws ApiException, IOException;

    /**
     * Creates a request to refund an Interac payment completed on a Square Terminal.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTerminalRefundResponse response from the API call
     */
    CompletableFuture<CreateTerminalRefundResponse> createTerminalRefundAsync(
            final CreateTerminalRefundRequest body);

    /**
     * Retrieves a filtered list of Interac Terminal refund requests created by the seller making
     * the request.
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
     * the request.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTerminalRefundsResponse response from the API call
     */
    CompletableFuture<SearchTerminalRefundsResponse> searchTerminalRefundsAsync(
            final SearchTerminalRefundsRequest body);

    /**
     * Retrieves an Interac Terminal refund object by ID.
     * @param  terminalRefundId  Required parameter: The unique ID for the desired `TerminalRefund`.
     * @return    Returns the GetTerminalRefundResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTerminalRefundResponse getTerminalRefund(
            final String terminalRefundId) throws ApiException, IOException;

    /**
     * Retrieves an Interac Terminal refund object by ID.
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