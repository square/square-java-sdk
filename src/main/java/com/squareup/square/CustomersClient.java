/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.MediaTypes;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.QueryStringMapper;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SquareException;
import com.squareup.square.core.Suppliers;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.customers.CardsClient;
import com.squareup.square.customers.CustomAttributeDefinitionsClient;
import com.squareup.square.customers.CustomAttributesClient;
import com.squareup.square.customers.GroupsClient;
import com.squareup.square.customers.SegmentsClient;
import com.squareup.square.types.BulkCreateCustomersRequest;
import com.squareup.square.types.BulkCreateCustomersResponse;
import com.squareup.square.types.BulkDeleteCustomersRequest;
import com.squareup.square.types.BulkDeleteCustomersResponse;
import com.squareup.square.types.BulkRetrieveCustomersRequest;
import com.squareup.square.types.BulkRetrieveCustomersResponse;
import com.squareup.square.types.BulkUpdateCustomersRequest;
import com.squareup.square.types.BulkUpdateCustomersResponse;
import com.squareup.square.types.CreateCustomerRequest;
import com.squareup.square.types.CreateCustomerResponse;
import com.squareup.square.types.Customer;
import com.squareup.square.types.DeleteCustomerResponse;
import com.squareup.square.types.DeleteCustomersRequest;
import com.squareup.square.types.GetCustomerResponse;
import com.squareup.square.types.GetCustomersRequest;
import com.squareup.square.types.ListCustomersRequest;
import com.squareup.square.types.ListCustomersResponse;
import com.squareup.square.types.SearchCustomersRequest;
import com.squareup.square.types.SearchCustomersResponse;
import com.squareup.square.types.UpdateCustomerRequest;
import com.squareup.square.types.UpdateCustomerResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CustomersClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<CustomAttributeDefinitionsClient> customAttributeDefinitionsClient;

    protected final Supplier<GroupsClient> groupsClient;

    protected final Supplier<SegmentsClient> segmentsClient;

    protected final Supplier<CardsClient> cardsClient;

    protected final Supplier<CustomAttributesClient> customAttributesClient;

    public CustomersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.customAttributeDefinitionsClient =
                Suppliers.memoize(() -> new CustomAttributeDefinitionsClient(clientOptions));
        this.groupsClient = Suppliers.memoize(() -> new GroupsClient(clientOptions));
        this.segmentsClient = Suppliers.memoize(() -> new SegmentsClient(clientOptions));
        this.cardsClient = Suppliers.memoize(() -> new CardsClient(clientOptions));
        this.customAttributesClient = Suppliers.memoize(() -> new CustomAttributesClient(clientOptions));
    }

    /**
     * Lists customer profiles associated with a Square account.
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public SyncPagingIterable<Customer> list() {
        return list(ListCustomersRequest.builder().build());
    }

    /**
     * Lists customer profiles associated with a Square account.
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public SyncPagingIterable<Customer> list(ListCustomersRequest request) {
        return list(request, null);
    }

    /**
     * Lists customer profiles associated with a Square account.
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public SyncPagingIterable<Customer> list(ListCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers");
        if (request.getCursor().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "cursor", request.getCursor().get(), false);
        }
        if (request.getLimit().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "limit", request.getLimit().get().toString(), false);
        }
        if (request.getSortField().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "sort_field", request.getSortField().get().toString(), false);
        }
        if (request.getSortOrder().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "sort_order", request.getSortOrder().get().toString(), false);
        }
        if (request.getCount().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "count", request.getCount().get().toString(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
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
                ListCustomersResponse parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListCustomersResponse.class);
                Optional<String> startingAfter = parsedResponse.getCursor();
                ListCustomersRequest nextRequest = ListCustomersRequest.builder()
                        .from(request)
                        .cursor(startingAfter)
                        .build();
                List<Customer> result = parsedResponse.getCustomers().orElse(Collections.emptyList());
                return new SyncPagingIterable<Customer>(
                        startingAfter.isPresent(), result, () -> list(nextRequest, requestOptions));
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
     * Creates a new customer for a business.
     * <p>You must provide at least one of the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CreateCustomerResponse create() {
        return create(CreateCustomerRequest.builder().build());
    }

    /**
     * Creates a new customer for a business.
     * <p>You must provide at least one of the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        return create(request, null);
    }

    /**
     * Creates a new customer for a business.
     * <p>You must provide at least one of the following values in your request to this
     * endpoint:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public CreateCustomerResponse create(CreateCustomerRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateCustomerResponse.class);
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
     * Creates multiple <a href="entity:Customer">customer profiles</a> for a business.
     * <p>This endpoint takes a map of individual create requests and returns a map of responses.</p>
     * <p>You must provide at least one of the following values in each create request:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public BulkCreateCustomersResponse batchCreate(BulkCreateCustomersRequest request) {
        return batchCreate(request, null);
    }

    /**
     * Creates multiple <a href="entity:Customer">customer profiles</a> for a business.
     * <p>This endpoint takes a map of individual create requests and returns a map of responses.</p>
     * <p>You must provide at least one of the following values in each create request:</p>
     * <ul>
     * <li><code>given_name</code></li>
     * <li><code>family_name</code></li>
     * <li><code>company_name</code></li>
     * <li><code>email_address</code></li>
     * <li><code>phone_number</code></li>
     * </ul>
     */
    public BulkCreateCustomersResponse batchCreate(BulkCreateCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers/bulk-create")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BulkCreateCustomersResponse.class);
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
     * Deletes multiple customer profiles.
     * <p>The endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public BulkDeleteCustomersResponse bulkDeleteCustomers(BulkDeleteCustomersRequest request) {
        return bulkDeleteCustomers(request, null);
    }

    /**
     * Deletes multiple customer profiles.
     * <p>The endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public BulkDeleteCustomersResponse bulkDeleteCustomers(
            BulkDeleteCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers/bulk-delete")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BulkDeleteCustomersResponse.class);
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
     * Retrieves multiple customer profiles.
     * <p>This endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public BulkRetrieveCustomersResponse bulkRetrieveCustomers(BulkRetrieveCustomersRequest request) {
        return bulkRetrieveCustomers(request, null);
    }

    /**
     * Retrieves multiple customer profiles.
     * <p>This endpoint takes a list of customer IDs and returns a map of responses.</p>
     */
    public BulkRetrieveCustomersResponse bulkRetrieveCustomers(
            BulkRetrieveCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers/bulk-retrieve")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BulkRetrieveCustomersResponse.class);
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
     * Updates multiple customer profiles.
     * <p>This endpoint takes a map of individual update requests and returns a map of responses.</p>
     */
    public BulkUpdateCustomersResponse bulkUpdateCustomers(BulkUpdateCustomersRequest request) {
        return bulkUpdateCustomers(request, null);
    }

    /**
     * Updates multiple customer profiles.
     * <p>This endpoint takes a map of individual update requests and returns a map of responses.</p>
     */
    public BulkUpdateCustomersResponse bulkUpdateCustomers(
            BulkUpdateCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers/bulk-update")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), BulkUpdateCustomersResponse.class);
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
     * Searches the customer profiles associated with a Square account using one or more supported query filters.
     * <p>Calling <code>SearchCustomers</code> without any explicit query filter returns all
     * customer profiles ordered alphabetically based on <code>given_name</code> and
     * <code>family_name</code>.</p>
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public SearchCustomersResponse search() {
        return search(SearchCustomersRequest.builder().build());
    }

    /**
     * Searches the customer profiles associated with a Square account using one or more supported query filters.
     * <p>Calling <code>SearchCustomers</code> without any explicit query filter returns all
     * customer profiles ordered alphabetically based on <code>given_name</code> and
     * <code>family_name</code>.</p>
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public SearchCustomersResponse search(SearchCustomersRequest request) {
        return search(request, null);
    }

    /**
     * Searches the customer profiles associated with a Square account using one or more supported query filters.
     * <p>Calling <code>SearchCustomers</code> without any explicit query filter returns all
     * customer profiles ordered alphabetically based on <code>given_name</code> and
     * <code>family_name</code>.</p>
     * <p>Under normal operating conditions, newly created or updated customer profiles become available
     * for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
     * profiles can take closer to one minute or longer, especially during network incidents and outages.</p>
     */
    public SearchCustomersResponse search(SearchCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers/search")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), SearchCustomersResponse.class);
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
     * Returns details for a single customer.
     */
    public GetCustomerResponse get(GetCustomersRequest request) {
        return get(request, null);
    }

    /**
     * Returns details for a single customer.
     */
    public GetCustomerResponse get(GetCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId())
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), GetCustomerResponse.class);
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
     * Updates a customer profile. This endpoint supports sparse updates, so only new or changed fields are required in the request.
     * To add or update a field, specify the new value. To remove a field, specify <code>null</code>.
     * <p>To update a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public UpdateCustomerResponse update(UpdateCustomerRequest request) {
        return update(request, null);
    }

    /**
     * Updates a customer profile. This endpoint supports sparse updates, so only new or changed fields are required in the request.
     * To add or update a field, specify the new value. To remove a field, specify <code>null</code>.
     * <p>To update a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public UpdateCustomerResponse update(UpdateCustomerRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId())
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UpdateCustomerResponse.class);
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
     * Deletes a customer profile from a business.
     * <p>To delete a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public DeleteCustomerResponse delete(DeleteCustomersRequest request) {
        return delete(request, null);
    }

    /**
     * Deletes a customer profile from a business.
     * <p>To delete a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.</p>
     */
    public DeleteCustomerResponse delete(DeleteCustomersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/customers")
                .addPathSegment(request.getCustomerId());
        if (request.getVersion().isPresent()) {
            QueryStringMapper.addQueryParameter(
                    httpUrl, "version", request.getVersion().get().toString(), false);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("DELETE", null)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DeleteCustomerResponse.class);
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

    public GroupsClient groups() {
        return this.groupsClient.get();
    }

    public SegmentsClient segments() {
        return this.segmentsClient.get();
    }

    public CardsClient cards() {
        return this.cardsClient.get();
    }

    public CustomAttributesClient customAttributes() {
        return this.customAttributesClient.get();
    }
}
