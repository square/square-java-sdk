
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
import com.squareup.square.http.request.MultipartFileWrapper;
import com.squareup.square.http.request.MultipartWrapper;
import com.squareup.square.http.response.HttpResponse;
import com.squareup.square.http.response.HttpStringResponse;
import com.squareup.square.models.AcceptDisputeResponse;
import com.squareup.square.models.CreateDisputeEvidenceFileRequest;
import com.squareup.square.models.CreateDisputeEvidenceFileResponse;
import com.squareup.square.models.CreateDisputeEvidenceTextRequest;
import com.squareup.square.models.CreateDisputeEvidenceTextResponse;
import com.squareup.square.models.DeleteDisputeEvidenceResponse;
import com.squareup.square.models.ListDisputeEvidenceResponse;
import com.squareup.square.models.ListDisputesResponse;
import com.squareup.square.models.RetrieveDisputeEvidenceResponse;
import com.squareup.square.models.RetrieveDisputeResponse;
import com.squareup.square.models.SubmitEvidenceResponse;
import com.squareup.square.utilities.FileWrapper;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultDisputesApi extends BaseApi implements DisputesApi {

    /**
     * Initializes the controller.
     * @param config    Configurations added in client.
     * @param httpClient    Send HTTP requests and read the responses.
     * @param authManagers    Apply authorization to requests.
     */
    public DefaultDisputesApi(Configuration config, HttpClient httpClient,
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
    public DefaultDisputesApi(Configuration config, HttpClient httpClient,
            Map<String, AuthManager> authManagers, HttpCallback httpCallback) {
        super(config, httpClient, authManagers, httpCallback);
    }

    /**
     * Returns a list of disputes associated with a particular account.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  states  Optional parameter: The dispute states to filter the result. If not
     *         specified, the endpoint returns all open disputes (the dispute status is not
     *         `INQUIRY_CLOSED`, `WON`, or `LOST`).
     * @param  locationId  Optional parameter: The ID of the location for which to return a list of
     *         disputes. If not specified, the endpoint returns all open disputes (the dispute
     *         status is not `INQUIRY_CLOSED`, `WON`, or `LOST`) associated with all locations.
     * @return    Returns the ListDisputesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListDisputesResponse listDisputes(
            final String cursor,
            final String states,
            final String locationId) throws ApiException, IOException {
        HttpRequest request = buildListDisputesRequest(cursor, states, locationId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListDisputesResponse(context);
    }

    /**
     * Returns a list of disputes associated with a particular account.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param  states  Optional parameter: The dispute states to filter the result. If not
     *         specified, the endpoint returns all open disputes (the dispute status is not
     *         `INQUIRY_CLOSED`, `WON`, or `LOST`).
     * @param  locationId  Optional parameter: The ID of the location for which to return a list of
     *         disputes. If not specified, the endpoint returns all open disputes (the dispute
     *         status is not `INQUIRY_CLOSED`, `WON`, or `LOST`) associated with all locations.
     * @return    Returns the ListDisputesResponse response from the API call
     */
    public CompletableFuture<ListDisputesResponse> listDisputesAsync(
            final String cursor,
            final String states,
            final String locationId) {
        return makeHttpCallAsync(() -> buildListDisputesRequest(cursor, states, locationId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListDisputesResponse(context));
    }

    /**
     * Builds the HttpRequest object for listDisputes.
     */
    private HttpRequest buildListDisputesRequest(
            final String cursor,
            final String states,
            final String locationId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes");

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);
        queryParameters.put("states", states);
        queryParameters.put("location_id", locationId);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for listDisputes.
     * @return An object of type ListDisputesResponse
     */
    private ListDisputesResponse handleListDisputesResponse(
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
        ListDisputesResponse result = ApiHelper.deserialize(responseBody,
                ListDisputesResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns details about a specific dispute.
     * @param  disputeId  Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveDisputeResponse retrieveDispute(
            final String disputeId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveDisputeRequest(disputeId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveDisputeResponse(context);
    }

    /**
     * Returns details about a specific dispute.
     * @param  disputeId  Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call
     */
    public CompletableFuture<RetrieveDisputeResponse> retrieveDisputeAsync(
            final String disputeId) {
        return makeHttpCallAsync(() -> buildRetrieveDisputeRequest(disputeId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveDisputeResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveDispute.
     */
    private HttpRequest buildRetrieveDisputeRequest(
            final String disputeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for retrieveDispute.
     * @return An object of type RetrieveDisputeResponse
     */
    private RetrieveDisputeResponse handleRetrieveDisputeResponse(
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
        RetrieveDisputeResponse result = ApiHelper.deserialize(responseBody,
                RetrieveDisputeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Accepts the loss on a dispute. Square returns the disputed amount to the cardholder and
     * updates the dispute state to ACCEPTED. Square debits the disputed amount from the seller’s
     * Square account. If the Square account does not have sufficient funds, Square debits the
     * associated bank account.
     * @param  disputeId  Required parameter: The ID of the dispute you want to accept.
     * @return    Returns the AcceptDisputeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AcceptDisputeResponse acceptDispute(
            final String disputeId) throws ApiException, IOException {
        HttpRequest request = buildAcceptDisputeRequest(disputeId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleAcceptDisputeResponse(context);
    }

    /**
     * Accepts the loss on a dispute. Square returns the disputed amount to the cardholder and
     * updates the dispute state to ACCEPTED. Square debits the disputed amount from the seller’s
     * Square account. If the Square account does not have sufficient funds, Square debits the
     * associated bank account.
     * @param  disputeId  Required parameter: The ID of the dispute you want to accept.
     * @return    Returns the AcceptDisputeResponse response from the API call
     */
    public CompletableFuture<AcceptDisputeResponse> acceptDisputeAsync(
            final String disputeId) {
        return makeHttpCallAsync(() -> buildAcceptDisputeRequest(disputeId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleAcceptDisputeResponse(context));
    }

    /**
     * Builds the HttpRequest object for acceptDispute.
     */
    private HttpRequest buildAcceptDisputeRequest(
            final String disputeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/accept");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().post(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for acceptDispute.
     * @return An object of type AcceptDisputeResponse
     */
    private AcceptDisputeResponse handleAcceptDisputeResponse(
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
        AcceptDisputeResponse result = ApiHelper.deserialize(responseBody,
                AcceptDisputeResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns a list of evidence associated with a dispute.
     * @param  disputeId  Required parameter: The ID of the dispute.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return    Returns the ListDisputeEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListDisputeEvidenceResponse listDisputeEvidence(
            final String disputeId,
            final String cursor) throws ApiException, IOException {
        HttpRequest request = buildListDisputeEvidenceRequest(disputeId, cursor);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleListDisputeEvidenceResponse(context);
    }

    /**
     * Returns a list of evidence associated with a dispute.
     * @param  disputeId  Required parameter: The ID of the dispute.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return    Returns the ListDisputeEvidenceResponse response from the API call
     */
    public CompletableFuture<ListDisputeEvidenceResponse> listDisputeEvidenceAsync(
            final String disputeId,
            final String cursor) {
        return makeHttpCallAsync(() -> buildListDisputeEvidenceRequest(disputeId, cursor),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleListDisputeEvidenceResponse(context));
    }

    /**
     * Builds the HttpRequest object for listDisputeEvidence.
     */
    private HttpRequest buildListDisputeEvidenceRequest(
            final String disputeId,
            final String cursor) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/evidence");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all query parameters
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("cursor", cursor);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for listDisputeEvidence.
     * @return An object of type ListDisputeEvidenceResponse
     */
    private ListDisputeEvidenceResponse handleListDisputeEvidenceResponse(
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
        ListDisputeEvidenceResponse result = ApiHelper.deserialize(responseBody,
                ListDisputeEvidenceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
     * multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  request  Optional parameter: Defines the parameters for a `CreateDisputeEvidenceFile`
     *         request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateDisputeEvidenceFileResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateDisputeEvidenceFileResponse createDisputeEvidenceFile(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) throws ApiException, IOException {
        HttpRequest internalRequest = buildCreateDisputeEvidenceFileRequest(disputeId, request,
                imageFile);
        authManagers.get("global").apply(internalRequest);

        HttpResponse response = getClientInstance().execute(internalRequest, false);
        HttpContext context = new HttpContext(internalRequest, response);

        return handleCreateDisputeEvidenceFileResponse(context);
    }

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
     * multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  request  Optional parameter: Defines the parameters for a `CreateDisputeEvidenceFile`
     *         request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateDisputeEvidenceFileResponse response from the API call
     */
    public CompletableFuture<CreateDisputeEvidenceFileResponse> createDisputeEvidenceFileAsync(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) {
        return makeHttpCallAsync(() -> buildCreateDisputeEvidenceFileRequest(disputeId, request,
                imageFile),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(internalRequest -> getClientInstance()
                        .executeAsync(internalRequest, false)),
            context -> handleCreateDisputeEvidenceFileResponse(context));
    }

    /**
     * Builds the HttpRequest object for createDisputeEvidenceFile.
     */
    private HttpRequest buildCreateDisputeEvidenceFileRequest(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/evidence-files");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());
        Headers requestHeaders = new Headers();
        requestHeaders.add("Content-Type", "application/json; charset=utf-8");
        MultipartWrapper requestWrapper = new MultipartWrapper(
                ApiHelper.serialize(request), requestHeaders);
        Headers imageFileHeaders = new Headers();
        imageFileHeaders.add("Content-Type", "image/jpeg");
        MultipartFileWrapper imageFileWrapper =
                new MultipartFileWrapper(imageFile, imageFileHeaders);

        //load all fields for the outgoing API request
        Map<String, Object> formParameters = new HashMap<>();
        formParameters.put("request", requestWrapper);
        formParameters.put("image_file", imageFileWrapper);

        //prepare and invoke the API call request to fetch the response
        HttpRequest internalRequest = getClientInstance().post(queryBuilder, headers, null,
                ApiHelper.prepareFormFields(formParameters));

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(internalRequest);
        }

        return internalRequest;
    }

    /**
     * Processes the response for createDisputeEvidenceFile.
     * @return An object of type CreateDisputeEvidenceFileResponse
     */
    private CreateDisputeEvidenceFileResponse handleCreateDisputeEvidenceFileResponse(
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
        CreateDisputeEvidenceFileResponse result = ApiHelper.deserialize(responseBody,
                CreateDisputeEvidenceFileResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateDisputeEvidenceTextResponse createDisputeEvidenceText(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) throws ApiException, IOException {
        HttpRequest request = buildCreateDisputeEvidenceTextRequest(disputeId, body);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleCreateDisputeEvidenceTextResponse(context);
    }

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     */
    public CompletableFuture<CreateDisputeEvidenceTextResponse> createDisputeEvidenceTextAsync(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) {
        return makeHttpCallAsync(() -> buildCreateDisputeEvidenceTextRequest(disputeId, body),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleCreateDisputeEvidenceTextResponse(context));
    }

    /**
     * Builds the HttpRequest object for createDisputeEvidenceText.
     */
    private HttpRequest buildCreateDisputeEvidenceTextRequest(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) throws JsonProcessingException {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/evidence-text");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Content-Type", "application/json");
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for createDisputeEvidenceText.
     * @return An object of type CreateDisputeEvidenceTextResponse
     */
    private CreateDisputeEvidenceTextResponse handleCreateDisputeEvidenceTextResponse(
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
        CreateDisputeEvidenceTextResponse result = ApiHelper.deserialize(responseBody,
                CreateDisputeEvidenceTextResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Removes specified evidence from a dispute. Square does not send the bank any evidence that is
     * removed. Also, you cannot remove evidence after submitting it to the bank using
     * [SubmitEvidence]($e/Disputes/SubmitEvidence).
     * @param  disputeId  Required parameter: The ID of the dispute you want to remove evidence
     *         from.
     * @param  evidenceId  Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the DeleteDisputeEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteDisputeEvidenceResponse deleteDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException {
        HttpRequest request = buildDeleteDisputeEvidenceRequest(disputeId, evidenceId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleDeleteDisputeEvidenceResponse(context);
    }

    /**
     * Removes specified evidence from a dispute. Square does not send the bank any evidence that is
     * removed. Also, you cannot remove evidence after submitting it to the bank using
     * [SubmitEvidence]($e/Disputes/SubmitEvidence).
     * @param  disputeId  Required parameter: The ID of the dispute you want to remove evidence
     *         from.
     * @param  evidenceId  Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the DeleteDisputeEvidenceResponse response from the API call
     */
    public CompletableFuture<DeleteDisputeEvidenceResponse> deleteDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId) {
        return makeHttpCallAsync(() -> buildDeleteDisputeEvidenceRequest(disputeId, evidenceId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleDeleteDisputeEvidenceResponse(context));
    }

    /**
     * Builds the HttpRequest object for deleteDisputeEvidence.
     */
    private HttpRequest buildDeleteDisputeEvidenceRequest(
            final String disputeId,
            final String evidenceId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/evidence/{evidence_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        templateParameters.put("evidence_id",
                new SimpleEntry<Object, Boolean>(evidenceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for deleteDisputeEvidence.
     * @return An object of type DeleteDisputeEvidenceResponse
     */
    private DeleteDisputeEvidenceResponse handleDeleteDisputeEvidenceResponse(
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
        DeleteDisputeEvidenceResponse result = ApiHelper.deserialize(responseBody,
                DeleteDisputeEvidenceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Returns the evidence metadata specified by the evidence ID in the request URL path You must
     * maintain a copy of the evidence you upload if you want to reference it later. You cannot
     * download the evidence after you upload it.
     * @param  disputeId  Required parameter: The ID of the dispute that you want to retrieve
     *         evidence from.
     * @param  evidenceId  Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveDisputeEvidenceResponse retrieveDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException {
        HttpRequest request = buildRetrieveDisputeEvidenceRequest(disputeId, evidenceId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleRetrieveDisputeEvidenceResponse(context);
    }

    /**
     * Returns the evidence metadata specified by the evidence ID in the request URL path You must
     * maintain a copy of the evidence you upload if you want to reference it later. You cannot
     * download the evidence after you upload it.
     * @param  disputeId  Required parameter: The ID of the dispute that you want to retrieve
     *         evidence from.
     * @param  evidenceId  Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call
     */
    public CompletableFuture<RetrieveDisputeEvidenceResponse> retrieveDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId) {
        return makeHttpCallAsync(() -> buildRetrieveDisputeEvidenceRequest(disputeId, evidenceId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleRetrieveDisputeEvidenceResponse(context));
    }

    /**
     * Builds the HttpRequest object for retrieveDisputeEvidence.
     */
    private HttpRequest buildRetrieveDisputeEvidenceRequest(
            final String disputeId,
            final String evidenceId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/evidence/{evidence_id}");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        templateParameters.put("evidence_id",
                new SimpleEntry<Object, Boolean>(evidenceId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
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
     * Processes the response for retrieveDisputeEvidence.
     * @return An object of type RetrieveDisputeEvidenceResponse
     */
    private RetrieveDisputeEvidenceResponse handleRetrieveDisputeEvidenceResponse(
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
        RetrieveDisputeEvidenceResponse result = ApiHelper.deserialize(responseBody,
                RetrieveDisputeEvidenceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

    /**
     * Submits evidence to the cardholder's bank. Before submitting evidence, Square compiles all
     * available evidence. This includes evidence uploaded using the
     * [CreateDisputeEvidenceFile]($e/Disputes/CreateDisputeEvidenceFile) and
     * [CreateDisputeEvidenceText]($e/Disputes/CreateDisputeEvidenceText) endpoints and evidence
     * automatically provided by Square, when available.
     * @param  disputeId  Required parameter: The ID of the dispute that you want to submit evidence
     *         for.
     * @return    Returns the SubmitEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SubmitEvidenceResponse submitEvidence(
            final String disputeId) throws ApiException, IOException {
        HttpRequest request = buildSubmitEvidenceRequest(disputeId);
        authManagers.get("global").apply(request);

        HttpResponse response = getClientInstance().execute(request, false);
        HttpContext context = new HttpContext(request, response);

        return handleSubmitEvidenceResponse(context);
    }

    /**
     * Submits evidence to the cardholder's bank. Before submitting evidence, Square compiles all
     * available evidence. This includes evidence uploaded using the
     * [CreateDisputeEvidenceFile]($e/Disputes/CreateDisputeEvidenceFile) and
     * [CreateDisputeEvidenceText]($e/Disputes/CreateDisputeEvidenceText) endpoints and evidence
     * automatically provided by Square, when available.
     * @param  disputeId  Required parameter: The ID of the dispute that you want to submit evidence
     *         for.
     * @return    Returns the SubmitEvidenceResponse response from the API call
     */
    public CompletableFuture<SubmitEvidenceResponse> submitEvidenceAsync(
            final String disputeId) {
        return makeHttpCallAsync(() -> buildSubmitEvidenceRequest(disputeId),
            req -> authManagers.get("global").applyAsync(req)
                .thenCompose(request -> getClientInstance()
                        .executeAsync(request, false)),
            context -> handleSubmitEvidenceResponse(context));
    }

    /**
     * Builds the HttpRequest object for submitEvidence.
     */
    private HttpRequest buildSubmitEvidenceRequest(
            final String disputeId) {
        //the base uri for api requests
        String baseUri = config.getBaseUri();

        //prepare query string for API call
        final StringBuilder queryBuilder = new StringBuilder(baseUri
                + "/v2/disputes/{dispute_id}/submit-evidence");

        //process template parameters
        Map<String, SimpleEntry<Object, Boolean>> templateParameters = new HashMap<>();
        templateParameters.put("dispute_id",
                new SimpleEntry<Object, Boolean>(disputeId, true));
        ApiHelper.appendUrlWithTemplateParameters(queryBuilder, templateParameters);

        //load all headers for the outgoing API request
        Headers headers = new Headers();
        headers.add("Square-Version", config.getSquareVersion());
        headers.add("user-agent", internalUserAgent);
        headers.add("accept", "application/json");
        headers.addAll(config.getAdditionalHeaders());

        //prepare and invoke the API call request to fetch the response
        HttpRequest request = getClientInstance().post(queryBuilder, headers, null, null);

        // Invoke the callback before request if its not null
        if (getHttpCallback() != null) {
            getHttpCallback().onBeforeRequest(request);
        }

        return request;
    }

    /**
     * Processes the response for submitEvidence.
     * @return An object of type SubmitEvidenceResponse
     */
    private SubmitEvidenceResponse handleSubmitEvidenceResponse(
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
        SubmitEvidenceResponse result = ApiHelper.deserialize(responseBody,
                SubmitEvidenceResponse.class);

        result = result.toBuilder().httpContext(context).build();
        return result;
    }

}