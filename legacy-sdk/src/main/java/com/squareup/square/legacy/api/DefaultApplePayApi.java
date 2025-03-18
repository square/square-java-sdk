package com.squareup.square.legacy.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.RegisterDomainRequest;
import com.squareup.square.legacy.models.RegisterDomainResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultApplePayApi extends BaseApi implements ApplePayApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultApplePayApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public RegisterDomainResponse registerDomain(final RegisterDomainRequest body) throws ApiException, IOException {
        return prepareRegisterDomainRequest(body).execute();
    }

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
    public CompletableFuture<RegisterDomainResponse> registerDomainAsync(final RegisterDomainRequest body) {
        try {
            return prepareRegisterDomainRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for registerDomain.
     */
    private ApiCall<RegisterDomainResponse, ApiException> prepareRegisterDomainRequest(final RegisterDomainRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RegisterDomainResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/apple-pay/domains")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, RegisterDomainResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
