package com.squareup.square;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.request.HttpRequest;

/**
 * Utility class for authorization and token management
 */
 public class AccessTokenManager implements AuthManager, AccessTokenCredentials {

    /**
     * Constructor
     */
    public AccessTokenManager(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Header Param to be used for requests
     */
    private String accessToken;

    /**
     * @return public String getAccessToken()
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Adds authentication to the given HttpRequest
     */
    public HttpRequest apply(HttpRequest httpRequest) throws ApiException, IOException {
        httpRequest.getHeaders().add("Authorization", "Bearer " + accessToken);
        return httpRequest;
    }

    /**
     * Asynchronously adds authentication to the given HttpRequest
     */
    public CompletableFuture<HttpRequest> applyAsync(HttpRequest httpRequest) {
        httpRequest.getHeaders().add("Authorization", "Bearer " + accessToken);
        return CompletableFuture.completedFuture(httpRequest);
    }
}
