/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareClientHttpResponse;
import com.squareup.square.core.SquareException;
import com.squareup.square.types.ObtainTokenRequest;
import com.squareup.square.types.ObtainTokenResponse;
import com.squareup.square.types.RetrieveTokenStatusResponse;
import com.squareup.square.types.RevokeTokenRequest;
import com.squareup.square.types.RevokeTokenResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawOAuthClient {
    protected final ClientOptions clientOptions;

    public AsyncRawOAuthClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Revokes an access token generated with the OAuth flow.
     * <p>If an account has more than one OAuth access token for your application, this
     * endpoint revokes all of them, regardless of which token you specify.</p>
     * <p><strong>Important:</strong> The <code>Authorization</code> header for this endpoint must have the
     * following format:</p>
     * <pre><code>Authorization: Client APPLICATION_SECRET
     * </code></pre>
     * <p>Replace <code>APPLICATION_SECRET</code> with the application secret on the <strong>OAuth</strong>
     * page for your application in the Developer Dashboard.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<RevokeTokenResponse>> revokeToken() {
        return revokeToken(RevokeTokenRequest.builder().build());
    }

    /**
     * Revokes an access token generated with the OAuth flow.
     * <p>If an account has more than one OAuth access token for your application, this
     * endpoint revokes all of them, regardless of which token you specify.</p>
     * <p><strong>Important:</strong> The <code>Authorization</code> header for this endpoint must have the
     * following format:</p>
     * <pre><code>Authorization: Client APPLICATION_SECRET
     * </code></pre>
     * <p>Replace <code>APPLICATION_SECRET</code> with the application secret on the <strong>OAuth</strong>
     * page for your application in the Developer Dashboard.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<RevokeTokenResponse>> revokeToken(RevokeTokenRequest request) {
        return revokeToken(request, null);
    }

    /**
     * Revokes an access token generated with the OAuth flow.
     * <p>If an account has more than one OAuth access token for your application, this
     * endpoint revokes all of them, regardless of which token you specify.</p>
     * <p><strong>Important:</strong> The <code>Authorization</code> header for this endpoint must have the
     * following format:</p>
     * <pre><code>Authorization: Client APPLICATION_SECRET
     * </code></pre>
     * <p>Replace <code>APPLICATION_SECRET</code> with the application secret on the <strong>OAuth</strong>
     * page for your application in the Developer Dashboard.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<RevokeTokenResponse>> revokeToken(
            RevokeTokenRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("oauth2/revoke")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<RevokeTokenResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), RevokeTokenResponse.class),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Returns an OAuth access token and refresh token using the <code>authorization_code</code>
     * or <code>refresh_token</code> grant type.
     * <p>When <code>grant_type</code> is <code>authorization_code</code>:</p>
     * <ul>
     * <li>With the <a href="https://developer.squareup.com/docs/oauth-api/overview#code-flow">code flow</a>,
     * provide <code>code</code>, <code>client_id</code>, and <code>client_secret</code>.</li>
     * <li>With the <a href="https://developer.squareup.com/docs/oauth-api/overview#pkce-flow">PKCE flow</a>,
     * provide <code>code</code>, <code>client_id</code>, and <code>code_verifier</code>.</li>
     * </ul>
     * <p>When <code>grant_type</code> is <code>refresh_token</code>:</p>
     * <ul>
     * <li>With the code flow, provide <code>refresh_token</code>, <code>client_id</code>, and <code>client_secret</code>.
     * The response returns the same refresh token provided in the request.</li>
     * <li>With the PKCE flow, provide <code>refresh_token</code> and <code>client_id</code>. The response returns
     * a new refresh token.</li>
     * </ul>
     * <p>You can use the <code>scopes</code> parameter to limit the set of permissions authorized by the
     * access token. You can use the <code>short_lived</code> parameter to create an access token that
     * expires in 24 hours.</p>
     * <p><strong>Important:</strong> OAuth tokens should be encrypted and stored on a secure server.
     * Application clients should never interact directly with OAuth tokens.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<ObtainTokenResponse>> obtainToken(ObtainTokenRequest request) {
        return obtainToken(request, null);
    }

    /**
     * Returns an OAuth access token and refresh token using the <code>authorization_code</code>
     * or <code>refresh_token</code> grant type.
     * <p>When <code>grant_type</code> is <code>authorization_code</code>:</p>
     * <ul>
     * <li>With the <a href="https://developer.squareup.com/docs/oauth-api/overview#code-flow">code flow</a>,
     * provide <code>code</code>, <code>client_id</code>, and <code>client_secret</code>.</li>
     * <li>With the <a href="https://developer.squareup.com/docs/oauth-api/overview#pkce-flow">PKCE flow</a>,
     * provide <code>code</code>, <code>client_id</code>, and <code>code_verifier</code>.</li>
     * </ul>
     * <p>When <code>grant_type</code> is <code>refresh_token</code>:</p>
     * <ul>
     * <li>With the code flow, provide <code>refresh_token</code>, <code>client_id</code>, and <code>client_secret</code>.
     * The response returns the same refresh token provided in the request.</li>
     * <li>With the PKCE flow, provide <code>refresh_token</code> and <code>client_id</code>. The response returns
     * a new refresh token.</li>
     * </ul>
     * <p>You can use the <code>scopes</code> parameter to limit the set of permissions authorized by the
     * access token. You can use the <code>short_lived</code> parameter to create an access token that
     * expires in 24 hours.</p>
     * <p><strong>Important:</strong> OAuth tokens should be encrypted and stored on a secure server.
     * Application clients should never interact directly with OAuth tokens.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<ObtainTokenResponse>> obtainToken(
            ObtainTokenRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("oauth2/token")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SquareException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<ObtainTokenResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ObtainTokenResponse.class),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    /**
     * Returns information about an <a href="https://developer.squareup.com/docs/build-basics/access-tokens#get-an-oauth-access-token">OAuth access token</a> or an application’s <a href="https://developer.squareup.com/docs/build-basics/access-tokens#get-a-personal-access-token">personal access token</a>.
     * <p>Add the access token to the Authorization header of the request.</p>
     * <p><strong>Important:</strong> The <code>Authorization</code> header you provide to this endpoint must have the following format:</p>
     * <pre><code>Authorization: Bearer ACCESS_TOKEN
     * </code></pre>
     * <p>where <code>ACCESS_TOKEN</code> is a
     * <a href="https://developer.squareup.com/docs/build-basics/access-tokens">valid production authorization credential</a>.</p>
     * <p>If the access token is expired or not a valid access token, the endpoint returns an <code>UNAUTHORIZED</code> error.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<RetrieveTokenStatusResponse>> retrieveTokenStatus() {
        return retrieveTokenStatus(null);
    }

    /**
     * Returns information about an <a href="https://developer.squareup.com/docs/build-basics/access-tokens#get-an-oauth-access-token">OAuth access token</a> or an application’s <a href="https://developer.squareup.com/docs/build-basics/access-tokens#get-a-personal-access-token">personal access token</a>.
     * <p>Add the access token to the Authorization header of the request.</p>
     * <p><strong>Important:</strong> The <code>Authorization</code> header you provide to this endpoint must have the following format:</p>
     * <pre><code>Authorization: Bearer ACCESS_TOKEN
     * </code></pre>
     * <p>where <code>ACCESS_TOKEN</code> is a
     * <a href="https://developer.squareup.com/docs/build-basics/access-tokens">valid production authorization credential</a>.</p>
     * <p>If the access token is expired or not a valid access token, the endpoint returns an <code>UNAUTHORIZED</code> error.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<RetrieveTokenStatusResponse>> retrieveTokenStatus(
            RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("oauth2/token/status")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<RetrieveTokenStatusResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(
                                        responseBody.string(), RetrieveTokenStatusResponse.class),
                                response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }

    public CompletableFuture<SquareClientHttpResponse<Void>> authorize() {
        return authorize(null);
    }

    public CompletableFuture<SquareClientHttpResponse<Void>> authorize(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("oauth2/authorize")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<Void>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(null, response));
                        return;
                    }
                    String responseBodyString = responseBody != null ? responseBody.string() : "{}";
                    future.completeExceptionally(new SquareApiException(
                            "Error with status code " + response.code(),
                            response.code(),
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                            response));
                    return;
                } catch (IOException e) {
                    future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(new SquareException("Network error executing HTTP request", e));
            }
        });
        return future;
    }
}
