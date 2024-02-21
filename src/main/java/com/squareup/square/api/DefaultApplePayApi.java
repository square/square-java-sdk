
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.RegisterDomainRequest;
import com.squareup.square.models.RegisterDomainResponse;
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
    public RegisterDomainResponse registerDomain(
            final RegisterDomainRequest body) throws ApiException, IOException {
        return prepareRegisterDomainRequest(body).execute();
    }

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
    public CompletableFuture<RegisterDomainResponse> registerDomainAsync(
            final RegisterDomainRequest body) {
        try { 
            return prepareRegisterDomainRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for registerDomain.
     */
    private ApiCall<RegisterDomainResponse, ApiException> prepareRegisterDomainRequest(
            final RegisterDomainRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RegisterDomainResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/apple-pay/domains")
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
                                response -> ApiHelper.deserialize(response, RegisterDomainResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}