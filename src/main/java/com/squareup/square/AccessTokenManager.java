
package com.squareup.square;

import com.squareup.square.http.request.HttpRequest;
import java.util.concurrent.CompletableFuture;

/**
 * Utility class for authorization and token management.
 */
public class AccessTokenManager implements AuthManager, AccessTokenCredentials {

    private String accessToken;

    /**
     * Constructor.
     * @param accessToken String value for accessToken.
     */
    public AccessTokenManager(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * String value for accessToken.
     * @return accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Checks if provided credentials matched with existing ones.
     * @param accessToken String value for credentials.
     * @return true if credentials matched.
     */
    public boolean equals(String accessToken) {
        return accessToken.equals(getAccessToken());
    }

    /**
     * Converts this AccessTokenManager into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AccessTokenManager [" + "accessToken=" + accessToken + "]";
    }

    /**
     * Adds authentication to the given HttpRequest.
     */
    public HttpRequest apply(HttpRequest httpRequest) {
        httpRequest.getHeaders().add("Authorization", "Bearer " + accessToken);
        return httpRequest;
    }
    
    /**
     * Asynchronously adds authentication to the given HttpRequest.
     */
    public CompletableFuture<HttpRequest> applyAsync(HttpRequest httpRequest) {
        return CompletableFuture.completedFuture(apply(httpRequest));
    }
}