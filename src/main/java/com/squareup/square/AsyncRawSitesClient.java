/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareClientHttpResponse;
import com.squareup.square.core.SquareException;
import com.squareup.square.types.ListSitesResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class AsyncRawSitesClient {
    protected final ClientOptions clientOptions;

    public AsyncRawSitesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Lists the Square Online sites that belong to a seller. Sites are listed in descending order by the <code>created_at</code> date.
     * <p><strong>Note:</strong> Square Online APIs are publicly available as part of an early access program. For more information, see <a href="https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis">Early access program for Square Online APIs</a>.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<ListSitesResponse>> list() {
        return list(null);
    }

    /**
     * Lists the Square Online sites that belong to a seller. Sites are listed in descending order by the <code>created_at</code> date.
     * <p><strong>Note:</strong> Square Online APIs are publicly available as part of an early access program. For more information, see <a href="https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis">Early access program for Square Online APIs</a>.</p>
     */
    public CompletableFuture<SquareClientHttpResponse<ListSitesResponse>> list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/sites")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        CompletableFuture<SquareClientHttpResponse<ListSitesResponse>> future = new CompletableFuture<>();
        client.newCall(okhttpRequest).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        future.complete(new SquareClientHttpResponse<>(
                                ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListSitesResponse.class),
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
}
