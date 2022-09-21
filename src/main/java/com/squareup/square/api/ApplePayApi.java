
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.RegisterDomainRequest;
import com.squareup.square.models.RegisterDomainResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface ApplePayApi {
    /**
     * Activates a domain for use with Apple Pay on the Web and Square. A validation is performed on
     * this domain by Apple to ensure that it is properly set up as an Apple Pay enabled domain.
     * This endpoint provides an easy way for platform developers to bulk activate Apple Pay on the
     * Web with Square for merchants using their platform. Note: The SqPaymentForm library is
     * deprecated as of May 13, 2021, and will only receive critical security updates until it is
     * retired on October 31, 2022. You must migrate your payment form code to the Web Payments SDK
     * to continue using your domain for Apple Pay. For more information on migrating to the Web
     * Payments SDK, see [Migrate to the Web Payments
     * SDK](https://developer.squareup.com/docs/web-payments/migrate). To learn more about the Web
     * Payments SDK and how to add Apple Pay, see [Take an Apple Pay
     * Payment](https://developer.squareup.com/docs/web-payments/apple-pay).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RegisterDomainResponse registerDomain(
            final RegisterDomainRequest body) throws ApiException, IOException;

    /**
     * Activates a domain for use with Apple Pay on the Web and Square. A validation is performed on
     * this domain by Apple to ensure that it is properly set up as an Apple Pay enabled domain.
     * This endpoint provides an easy way for platform developers to bulk activate Apple Pay on the
     * Web with Square for merchants using their platform. Note: The SqPaymentForm library is
     * deprecated as of May 13, 2021, and will only receive critical security updates until it is
     * retired on October 31, 2022. You must migrate your payment form code to the Web Payments SDK
     * to continue using your domain for Apple Pay. For more information on migrating to the Web
     * Payments SDK, see [Migrate to the Web Payments
     * SDK](https://developer.squareup.com/docs/web-payments/migrate). To learn more about the Web
     * Payments SDK and how to add Apple Pay, see [Take an Apple Pay
     * Payment](https://developer.squareup.com/docs/web-payments/apple-pay).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call
     */
    CompletableFuture<RegisterDomainResponse> registerDomainAsync(
            final RegisterDomainRequest body);

}