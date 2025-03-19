package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.CreateMobileAuthorizationCodeRequest;
import com.squareup.square.legacy.models.CreateMobileAuthorizationCodeResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface MobileAuthorizationApi {
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
    CreateMobileAuthorizationCodeResponse createMobileAuthorizationCode(final CreateMobileAuthorizationCodeRequest body)
            throws ApiException, IOException;

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
    CompletableFuture<CreateMobileAuthorizationCodeResponse> createMobileAuthorizationCodeAsync(
            final CreateMobileAuthorizationCodeRequest body);
}
