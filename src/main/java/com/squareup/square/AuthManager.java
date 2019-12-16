package com.squareup.square;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.request.HttpRequest;

/**
 * Interface for defining the behaviour of Authentication Classes.
 */
public interface AuthManager {

    /**
     * Adds authentication to the given HttpRequest
     */
    HttpRequest apply(HttpRequest httpRequest) throws ApiException, IOException;

    /**
     * Asynchronously adds authentication to the given HttpRequest
     */
    CompletableFuture<HttpRequest> applyAsync(HttpRequest httpRequest);
}
