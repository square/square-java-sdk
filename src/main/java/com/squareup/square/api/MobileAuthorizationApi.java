package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateMobileAuthorizationCodeRequest;
import com.squareup.square.models.CreateMobileAuthorizationCodeResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface MobileAuthorizationApi {
    /**
     * Generates code to authorize a mobile application to connect to a Square card reader
     * Authorization codes are one-time-use and expire __60 minutes__ after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the following format:
     * ```
     * Authorization: Bearer ACCESS_TOKEN
     * ```
     * Replace `ACCESS_TOKEN` with a
     * [valid production authorization credential](https://developer.squareup.com/docs/docs/build-basics/access-tokens).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call
     */
    CreateMobileAuthorizationCodeResponse createMobileAuthorizationCode(
            final CreateMobileAuthorizationCodeRequest body) throws ApiException, IOException;

    /**
     * Generates code to authorize a mobile application to connect to a Square card reader
     * Authorization codes are one-time-use and expire __60 minutes__ after being issued.
     * __Important:__ The `Authorization` header you provide to this endpoint must have the following format:
     * ```
     * Authorization: Bearer ACCESS_TOKEN
     * ```
     * Replace `ACCESS_TOKEN` with a
     * [valid production authorization credential](https://developer.squareup.com/docs/docs/build-basics/access-tokens).
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateMobileAuthorizationCodeResponse response from the API call 
     */
    CompletableFuture<CreateMobileAuthorizationCodeResponse> createMobileAuthorizationCodeAsync(
            final CreateMobileAuthorizationCodeRequest body);

}