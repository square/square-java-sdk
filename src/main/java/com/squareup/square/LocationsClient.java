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
import com.squareup.square.core.SquareException;
import com.squareup.square.core.Suppliers;
import com.squareup.square.locations.CustomAttributeDefinitionsClient;
import com.squareup.square.locations.CustomAttributesClient;
import com.squareup.square.locations.TransactionsClient;
import com.squareup.square.types.CreateCheckoutRequest;
import com.squareup.square.types.CreateCheckoutResponse;
import com.squareup.square.types.CreateLocationRequest;
import com.squareup.square.types.CreateLocationResponse;
import com.squareup.square.types.GetLocationResponse;
import com.squareup.square.types.GetLocationsRequest;
import com.squareup.square.types.ListLocationsResponse;
import com.squareup.square.types.UpdateLocationRequest;
import com.squareup.square.types.UpdateLocationResponse;
import java.io.IOException;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LocationsClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<CustomAttributeDefinitionsClient> customAttributeDefinitionsClient;

    protected final Supplier<CustomAttributesClient> customAttributesClient;

    protected final Supplier<TransactionsClient> transactionsClient;

    public LocationsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.customAttributeDefinitionsClient =
                Suppliers.memoize(() -> new CustomAttributeDefinitionsClient(clientOptions));
        this.customAttributesClient = Suppliers.memoize(() -> new CustomAttributesClient(clientOptions));
        this.transactionsClient = Suppliers.memoize(() -> new TransactionsClient(clientOptions));
    }

    /**
     * Provides details about all of the seller's <a href="https://developer.squareup.com/docs/locations-api">locations</a>,
     * including those with an inactive status. Locations are listed alphabetically by <code>name</code>.
     */
    public ListLocationsResponse list() {
        return list(null);
    }

    /**
     * Provides details about all of the seller's <a href="https://developer.squareup.com/docs/locations-api">locations</a>,
     * including those with an inactive status. Locations are listed alphabetically by <code>name</code>.
     */
    public ListLocationsResponse list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListLocationsResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Creates a <a href="https://developer.squareup.com/docs/locations-api">location</a>.
     * Creating new locations allows for separate configuration of receipt layouts, item prices,
     * and sales reports. Developers can use locations to separate sales activity through applications
     * that integrate with Square from sales activity elsewhere in a seller's account.
     * Locations created programmatically with the Locations API last forever and
     * are visible to the seller for their own management. Therefore, ensure that
     * each location has a sensible and unique name.
     */
    public CreateLocationResponse create() {
        return create(CreateLocationRequest.builder().build());
    }

    /**
     * Creates a <a href="https://developer.squareup.com/docs/locations-api">location</a>.
     * Creating new locations allows for separate configuration of receipt layouts, item prices,
     * and sales reports. Developers can use locations to separate sales activity through applications
     * that integrate with Square from sales activity elsewhere in a seller's account.
     * Locations created programmatically with the Locations API last forever and
     * are visible to the seller for their own management. Therefore, ensure that
     * each location has a sensible and unique name.
     */
    public CreateLocationResponse create(CreateLocationRequest request) {
        return create(request, null);
    }

    /**
     * Creates a <a href="https://developer.squareup.com/docs/locations-api">location</a>.
     * Creating new locations allows for separate configuration of receipt layouts, item prices,
     * and sales reports. Developers can use locations to separate sales activity through applications
     * that integrate with Square from sales activity elsewhere in a seller's account.
     * Locations created programmatically with the Locations API last forever and
     * are visible to the seller for their own management. Therefore, ensure that
     * each location has a sensible and unique name.
     */
    public CreateLocationResponse create(CreateLocationRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
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
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateLocationResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Retrieves details of a single location. Specify &quot;main&quot;
     * as the location ID to retrieve details of the <a href="https://developer.squareup.com/docs/locations-api#about-the-main-location">main location</a>.
     */
    public GetLocationResponse get(GetLocationsRequest request) {
        return get(request, null);
    }

    /**
     * Retrieves details of a single location. Specify &quot;main&quot;
     * as the location ID to retrieve details of the <a href="https://developer.squareup.com/docs/locations-api#about-the-main-location">main location</a>.
     */
    public GetLocationResponse get(GetLocationsRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetLocationResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Updates a <a href="https://developer.squareup.com/docs/locations-api">location</a>.
     */
    public UpdateLocationResponse update(UpdateLocationRequest request) {
        return update(request, null);
    }

    /**
     * Updates a <a href="https://developer.squareup.com/docs/locations-api">location</a>.
     */
    public UpdateLocationResponse update(UpdateLocationRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
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
                .method("PUT", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateLocationResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    /**
     * Links a <code>checkoutId</code> to a <code>checkout_page_url</code> that customers are
     * directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * <p>NOTE: The Checkout API has been updated with new features.
     * For more information, see <a href="https://developer.squareup.com/docs/checkout-api#checkout-api-highlights">Checkout API highlights</a>.</p>
     */
    public CreateCheckoutResponse checkouts(CreateCheckoutRequest request) {
        return checkouts(request, null);
    }

    /**
     * Links a <code>checkoutId</code> to a <code>checkout_page_url</code> that customers are
     * directed to in order to provide their payment information using a
     * payment processing workflow hosted on connect.squareup.com.
     * <p>NOTE: The Checkout API has been updated with new features.
     * For more information, see <a href="https://developer.squareup.com/docs/checkout-api#checkout-api-highlights">Checkout API highlights</a>.</p>
     */
    public CreateCheckoutResponse checkouts(CreateCheckoutRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/locations")
                .addPathSegment(request.getLocationId())
                .addPathSegments("checkouts")
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
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateCheckoutResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SquareApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SquareException("Network error executing HTTP request", e);
        }
    }

    public CustomAttributeDefinitionsClient customAttributeDefinitions() {
        return this.customAttributeDefinitionsClient.get();
    }

    public CustomAttributesClient customAttributes() {
        return this.customAttributesClient.get();
    }

    public TransactionsClient transactions() {
        return this.transactionsClient.get();
    }
}
