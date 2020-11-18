
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.AuthManager;
import com.squareup.square.Configuration;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.Headers;
import com.squareup.square.http.client.HttpCallback;
import com.squareup.square.http.client.HttpClient;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpRequest;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.GetBankAccountByV1IdResponse;
import com.squareup.square.models.GetBankAccountResponse;
import com.squareup.square.models.ListBankAccountsResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultBankAccountsApi extends BaseApi implements BankAccountsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultBankAccountsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers) {
        super(config, httpClient, authManagers);
    }

    /**
     * Initializes the controller with HTTPCallback.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     * @param httpCallback    Callback to be called before and after the HTTP call.
     */
    public DefaultBankAccountsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns a list of [BankAccount](#type-bankaccount) objects linked to a Square account.
     * @param  cursor  Optional parameter: The pagination cursor returned by a previous call to this
     *         endpoint. Use it in the next `ListBankAccounts` request to retrieve the next set of
     *         results. See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @param  limit  Optional parameter: Upper limit on the number of bank accounts to return in
     *         the response. Currently, 1000 is the largest supported limit. You can specify a limit
     *         of up to 1000 bank accounts. This is also the default limit.
     * @param  locationId  Optional parameter: Location ID. You can specify this optional filter to
     *         retrieve only the linked bank accounts belonging to a specific location.
     * @return    Returns the ListBankAccountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListBankAccountsResponse listBankAccounts(
            final String cursor,
            final Integer limit,
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListBankAccountsRequest(cursor, limit, locationId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleListBankAccountsResponse(context);
    }

    /**
     * Returns a list of [BankAccount](#type-bankaccount) objects linked to a Square account.
     * @param  cursor  Optional parameter: The pagination cursor returned by a previous call to this
     *         endpoint. Use it in the next `ListBankAccounts` request to retrieve the next set of
     *         results. See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @param  limit  Optional parameter: Upper limit on the number of bank accounts to return in
     *         the response. Currently, 1000 is the largest supported limit. You can specify a limit
     *         of up to 1000 bank accounts. This is also the default limit.
     * @param  locationId  Optional parameter: Location ID. You can specify this optional filter to
     *         retrieve only the linked bank accounts belonging to a specific location.
     * @return    Returns the ListBankAccountsResponse response from the API call
     */
    public CompletableFuture<ListBankAccountsResponse> listBankAccountsAsync(
            final String cursor,
            final Integer limit,
            final String locationId) {
        return makeHttpCallAsync(() -> buildListBankAccountsRequest(cursor, limit, locationId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleListBankAccountsResponse(context));
    }

    /**
     * Builds the HttpRequest object for listBankAccounts.
     */
    private HttpRequest buildListBankAccountsRequest(
            final String cursor,
            final Integer limit,
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bank-accounts");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("limit", limit);
        queryParameters.put("location_id", locationId);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, queryParameters,
                null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for listBankAccounts.
     * @return An object of type ListBankAccountsResponse
     */
    private ListBankAccountsResponse handleListBankAccountsResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        ListBankAccountsResponse result = ApiHelper.deserialize(responseBody,
                ListBankAccountsResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns details of a [BankAccount](#type-bankaccount) identified by V1 bank account ID.
     * @param  v1BankAccountId  Required parameter: Connect V1 ID of the desired `BankAccount`. For
     *         more information, see [Retrieve a bank account by using an ID issued by V1 Bank
     *         Accounts
     *         API](https://developer.squareup.com/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetBankAccountByV1IdResponse getBankAccountByV1Id(
            final String v1BankAccountId) throws ApiException, IOException {
        HttpRequest request = buildGetBankAccountByV1IdRequest(v1BankAccountId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetBankAccountByV1IdResponse(context);
    }

    /**
     * Returns details of a [BankAccount](#type-bankaccount) identified by V1 bank account ID.
     * @param  v1BankAccountId  Required parameter: Connect V1 ID of the desired `BankAccount`. For
     *         more information, see [Retrieve a bank account by using an ID issued by V1 Bank
     *         Accounts
     *         API](https://developer.squareup.com/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call
     */
    public CompletableFuture<GetBankAccountByV1IdResponse> getBankAccountByV1IdAsync(
            final String v1BankAccountId) {
        return makeHttpCallAsync(() -> buildGetBankAccountByV1IdRequest(v1BankAccountId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleGetBankAccountByV1IdResponse(context));
    }

    /**
     * Builds the HttpRequest object for getBankAccountByV1Id.
     */
    private HttpRequest buildGetBankAccountByV1IdRequest(
            final String v1BankAccountId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bank-accounts/by-v1-id/{v1_bank_account_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("v1_bank_account_id",
                new SimpleEntry<Object, Boolean>(v1BankAccountId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for getBankAccountByV1Id.
     * @return An object of type GetBankAccountByV1IdResponse
     */
    private GetBankAccountByV1IdResponse handleGetBankAccountByV1IdResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        GetBankAccountByV1IdResponse result = ApiHelper.deserialize(responseBody,
                GetBankAccountByV1IdResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns details of a [BankAccount](#type-bankaccount) linked to a Square account.
     * @param  bankAccountId  Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetBankAccountResponse getBankAccount(
            final String bankAccountId) throws ApiException, IOException {
        HttpRequest request = buildGetBankAccountRequest(bankAccountId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().executeAsString(request);
        HttpContext context = new HttpContext(request, response);

        return handleGetBankAccountResponse(context);
    }

    /**
     * Returns details of a [BankAccount](#type-bankaccount) linked to a Square account.
     * @param  bankAccountId  Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     */
    public CompletableFuture<GetBankAccountResponse> getBankAccountAsync(
            final String bankAccountId) {
        return makeHttpCallAsync(() -> buildGetBankAccountRequest(bankAccountId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsStringAsync(request)),
            context -> handleGetBankAccountResponse(context));
    }

    /**
     * Builds the HttpRequest object for getBankAccount.
     */
    private HttpRequest buildGetBankAccountRequest(
            final String bankAccountId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/bank-accounts/{bank_account_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("bank_account_id",
                new SimpleEntry<Object, Boolean>(bankAccountId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().get(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for getBankAccount.
     * @return An object of type GetBankAccountResponse
     */
    private GetBankAccountResponse handleGetBankAccountResponse(
            HttpContext context) throws ApiException, IOException {
        HttpResponse response = context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onAfterResponse(context);
        }

        //handle errors defined at the API level
        validateResponse(response, context);

        //extract result from the http response
        String responseBody = ((HttpStringResponse) response).getBody();
        GetBankAccountResponse result = ApiHelper.deserialize(responseBody,
                GetBankAccountResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}