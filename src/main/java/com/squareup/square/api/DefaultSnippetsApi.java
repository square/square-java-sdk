
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.squareup.square.models.DeleteSnippetResponse;
import com.squareup.square.models.RetrieveSnippetResponse;
import com.squareup.square.models.UpsertSnippetRequest;
import com.squareup.square.models.UpsertSnippetResponse;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultSnippetsApi extends BaseApi implements SnippetsApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultSnippetsApi(Configuration config, HttpClient httpClient,
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
    public DefaultSnippetsApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Removes your snippet from a Square Online site. You can call [ListSites]($e/Sites/ListSites)
     * to get the IDs of the sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the DeleteSnippetResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteSnippetResponse deleteSnippet(
            final String siteId) throws ApiException, IOException {
        HttpRequest request = buildDeleteSnippetRequest(siteId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteSnippetResponse(context);
    }

    /**
     * Removes your snippet from a Square Online site. You can call [ListSites]($e/Sites/ListSites)
     * to get the IDs of the sites that belong to a seller. __Note:__ Square Online APIs are
     * publicly available as part of an early access program. For more information, see [Early
     * access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the DeleteSnippetResponse response from the API call
     */
    public CompletableFuture<DeleteSnippetResponse> deleteSnippetAsync(
            final String siteId) {
        return makeHttpCallAsync(() -> buildDeleteSnippetRequest(siteId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteSnippetResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteSnippet.
     */
    private HttpRequest buildDeleteSnippetRequest(
            final String siteId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/sites/{site_id}/snippet");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("site_id",
                new SimpleEntry<Object, Boolean>(siteId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().delete(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for deleteSnippet.
     * @return An object of type DeleteSnippetResponse
     */
    private DeleteSnippetResponse handleDeleteSnippetResponse(
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
        DeleteSnippetResponse result = ApiHelper.deserialize(responseBody,
                DeleteSnippetResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Retrieves your snippet from a Square Online site. A site can contain snippets from multiple
     * snippet applications, but you can retrieve only the snippet that was added by your
     * application. You can call [ListSites]($e/Sites/ListSites) to get the IDs of the sites that
     * belong to a seller. __Note:__ Square Online APIs are publicly available as part of an early
     * access program. For more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the RetrieveSnippetResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveSnippetResponse retrieveSnippet(
            final String siteId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveSnippetRequest(siteId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveSnippetResponse(context);
    }

    /**
     * Retrieves your snippet from a Square Online site. A site can contain snippets from multiple
     * snippet applications, but you can retrieve only the snippet that was added by your
     * application. You can call [ListSites]($e/Sites/ListSites) to get the IDs of the sites that
     * belong to a seller. __Note:__ Square Online APIs are publicly available as part of an early
     * access program. For more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site that contains the snippet.
     * @return    Returns the RetrieveSnippetResponse response from the API call
     */
    public CompletableFuture<RetrieveSnippetResponse> retrieveSnippetAsync(
            final String siteId) {
        return makeHttpCallAsync(() -> buildRetrieveSnippetRequest(siteId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveSnippetResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveSnippet.
     */
    private HttpRequest buildRetrieveSnippetRequest(
            final String siteId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/sites/{site_id}/snippet");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("site_id",
                new SimpleEntry<Object, Boolean>(siteId, true));
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
     * Processes the response for retrieveSnippet.
     * @return An object of type RetrieveSnippetResponse
     */
    private RetrieveSnippetResponse handleRetrieveSnippetResponse(
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
        RetrieveSnippetResponse result = ApiHelper.deserialize(responseBody,
                RetrieveSnippetResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Adds a snippet to a Square Online site or updates the existing snippet on the site. The
     * snippet code is appended to the end of the `head` element on every page of the site, except
     * checkout pages. A snippet application can add one snippet to a given site. You can call
     * [ListSites]($e/Sites/ListSites) to get the IDs of the sites that belong to a seller.
     * __Note:__ Square Online APIs are publicly available as part of an early access program. For
     * more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site where you want to add or update the
     *         snippet.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertSnippetResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpsertSnippetResponse upsertSnippet(
            final String siteId,
            final UpsertSnippetRequest body) throws ApiException, IOException {
        HttpRequest request = buildUpsertSnippetRequest(siteId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleUpsertSnippetResponse(context);
    }

    /**
     * Adds a snippet to a Square Online site or updates the existing snippet on the site. The
     * snippet code is appended to the end of the `head` element on every page of the site, except
     * checkout pages. A snippet application can add one snippet to a given site. You can call
     * [ListSites]($e/Sites/ListSites) to get the IDs of the sites that belong to a seller.
     * __Note:__ Square Online APIs are publicly available as part of an early access program. For
     * more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @param  siteId  Required parameter: The ID of the site where you want to add or update the
     *         snippet.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpsertSnippetResponse response from the API call
     */
    public CompletableFuture<UpsertSnippetResponse> upsertSnippetAsync(
            final String siteId,
            final UpsertSnippetRequest body) {
        return makeHttpCallAsync(() -> buildUpsertSnippetRequest(siteId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleUpsertSnippetResponse(context));
    }

    /**
     * Builds the HttpRequest object for upsertSnippet.
     */
    private HttpRequest buildUpsertSnippetRequest(
            final String siteId,
            final UpsertSnippetRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/sites/{site_id}/snippet");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("site_id",
                new SimpleEntry<Object, Boolean>(siteId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", BaseApi.userAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        String bodyJson = ApiHelper.serialize(body);
        HttpRequest request = getClientInstance().postBody(queryBuilder, headers, null, bodyJson);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for upsertSnippet.
     * @return An object of type UpsertSnippetResponse
     */
    private UpsertSnippetResponse handleUpsertSnippetResponse(
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
        UpsertSnippetResponse result = ApiHelper.deserialize(responseBody,
                UpsertSnippetResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}