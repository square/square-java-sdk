
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.CreateMobileAuthorizationCodeRequest;
import com.squareup.square.models.CreateMobileAuthorizationCodeResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultMobileAuthorizationApi extends BaseApi implements MobileAuthorizationApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultMobileAuthorizationApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader.
     * Authorization codes are one-time-use codes and expire 60 minutes after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the
     * following format: ``` Authorization: Bearer ACCESS_TOKEN ``` Replace `ACCESS_TOKEN` with a
     * [valid production authorization
     * credential](https://developer.squareup.com/docs/build-basics/access-tokens).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateMobileAuthorizationCodeResponse createMobileAuthorizationCode(
            final CreateMobileAuthorizationCodeRequest body) throws ApiException, IOException {
        return prepareCreateMobileAuthorizationCodeRequest(body).execute();
    }

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader.
     * Authorization codes are one-time-use codes and expire 60 minutes after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the
     * following format: ``` Authorization: Bearer ACCESS_TOKEN ``` Replace `ACCESS_TOKEN` with a
     * [valid production authorization
     * credential](https://developer.squareup.com/docs/build-basics/access-tokens).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call
     */
    public CompletableFuture<CreateMobileAuthorizationCodeResponse> createMobileAuthorizationCodeAsync(
            final CreateMobileAuthorizationCodeRequest body) {
        try { 
            return prepareCreateMobileAuthorizationCodeRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createMobileAuthorizationCode.
     */
    private ApiCall<CreateMobileAuthorizationCodeResponse, ApiException> prepareCreateMobileAuthorizationCodeRequest(
            final CreateMobileAuthorizationCodeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateMobileAuthorizationCodeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/mobile/authorization-code")
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
                                response -> ApiHelper.deserialize(response, CreateMobileAuthorizationCodeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}