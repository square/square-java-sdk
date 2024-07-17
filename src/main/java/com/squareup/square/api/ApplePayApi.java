
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
     * Web with Square for merchants using their platform. Note: You will need to host a valid
     * domain verification file on your domain to support Apple Pay. The current version of this
     * file is always available at
     * https://app.squareup.com/digital-wallets/apple-pay/apple-developer-merchantid-domain-association,
     * and should be hosted at `.well_known/apple-developer-merchantid-domain-association` on your
     * domain. This file is subject to change; we strongly recommend checking for updates regularly
     * and avoiding long-lived caches that might not keep in sync with the correct file version. To
     * learn more about the Web Payments SDK and how to add Apple Pay, see [Take an Apple Pay
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
     * Web with Square for merchants using their platform. Note: You will need to host a valid
     * domain verification file on your domain to support Apple Pay. The current version of this
     * file is always available at
     * https://app.squareup.com/digital-wallets/apple-pay/apple-developer-merchantid-domain-association,
     * and should be hosted at `.well_known/apple-developer-merchantid-domain-association` on your
     * domain. This file is subject to change; we strongly recommend checking for updates regularly
     * and avoiding long-lived caches that might not keep in sync with the correct file version. To
     * learn more about the Web Payments SDK and how to add Apple Pay, see [Take an Apple Pay
     * Payment](https://developer.squareup.com/docs/web-payments/apple-pay).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RegisterDomainResponse response from the API call
     */
    CompletableFuture<RegisterDomainResponse> registerDomainAsync(
            final RegisterDomainRequest body);

}