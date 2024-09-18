
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import io.apimatic.coreinterfaces.http.request.MutliPartRequestType;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultDisputesApi extends BaseApi implements DisputesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultDisputesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Returns a list of disputes associated with a particular account.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  states  Optional parameter: The dispute states used to filter the result. If not
     *         specified, the endpoint returns all disputes.
     * @param  locationId  Optional parameter: The ID of the location for which to return a list of
     *         disputes. If not specified, the endpoint returns disputes associated with all
     *         locations.
     * @return    Returns the ListDisputesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListDisputesResponse listDisputes(
            final String cursor,
            final String states,
            final String locationId) throws ApiException, IOException {
        return prepareListDisputesRequest(cursor, states, locationId).execute();
    }

    /**
     * Returns a list of disputes associated with a particular account.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  states  Optional parameter: The dispute states used to filter the result. If not
     *         specified, the endpoint returns all disputes.
     * @param  locationId  Optional parameter: The ID of the location for which to return a list of
     *         disputes. If not specified, the endpoint returns disputes associated with all
     *         locations.
     * @return    Returns the ListDisputesResponse response from the API call
     */
    public CompletableFuture<ListDisputesResponse> listDisputesAsync(
            final String cursor,
            final String states,
            final String locationId) {
        try { 
            return prepareListDisputesRequest(cursor, states, locationId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listDisputes.
     */
    private ApiCall<ListDisputesResponse, ApiException> prepareListDisputesRequest(
            final String cursor,
            final String states,
            final String locationId) throws IOException {
        return new ApiCall.Builder<ListDisputesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("states")
                                .value(states).isRequired(false))
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListDisputesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareRetrieveDisputeRequest(disputeId).execute();
    }

    /**
     * Returns details about a specific dispute.
     * @param  disputeId  Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call
     */
    public CompletableFuture<RetrieveDisputeResponse> retrieveDisputeAsync(
            final String disputeId) {
        try { 
            return prepareRetrieveDisputeRequest(disputeId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveDispute.
     */
    private ApiCall<RetrieveDisputeResponse, ApiException> prepareRetrieveDisputeRequest(
            final String disputeId) throws IOException {
        return new ApiCall.Builder<RetrieveDisputeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}")
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveDisputeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
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
        return prepareAcceptDisputeRequest(disputeId).execute();
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
        try { 
            return prepareAcceptDisputeRequest(disputeId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for acceptDispute.
     */
    private ApiCall<AcceptDisputeResponse, ApiException> prepareAcceptDisputeRequest(
            final String disputeId) throws IOException {
        return new ApiCall.Builder<AcceptDisputeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/accept")
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, AcceptDisputeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a list of evidence associated with a dispute.
     * @param  disputeId  Required parameter: The ID of the dispute.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListDisputeEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListDisputeEvidenceResponse listDisputeEvidence(
            final String disputeId,
            final String cursor) throws ApiException, IOException {
        return prepareListDisputeEvidenceRequest(disputeId, cursor).execute();
    }

    /**
     * Returns a list of evidence associated with a dispute.
     * @param  disputeId  Required parameter: The ID of the dispute.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListDisputeEvidenceResponse response from the API call
     */
    public CompletableFuture<ListDisputeEvidenceResponse> listDisputeEvidenceAsync(
            final String disputeId,
            final String cursor) {
        try { 
            return prepareListDisputeEvidenceRequest(disputeId, cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listDisputeEvidence.
     */
    private ApiCall<ListDisputeEvidenceResponse, ApiException> prepareListDisputeEvidenceRequest(
            final String disputeId,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListDisputeEvidenceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/evidence")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListDisputeEvidenceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
     * multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.
     * @param  disputeId  Required parameter: The ID of the dispute for which you want to upload
     *         evidence.
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
        return prepareCreateDisputeEvidenceFileRequest(disputeId, request, imageFile).execute();
    }

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
     * multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.
     * @param  disputeId  Required parameter: The ID of the dispute for which you want to upload
     *         evidence.
     * @param  request  Optional parameter: Defines the parameters for a `CreateDisputeEvidenceFile`
     *         request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateDisputeEvidenceFileResponse response from the API call
     */
    public CompletableFuture<CreateDisputeEvidenceFileResponse> createDisputeEvidenceFileAsync(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) {
        try { 
            return prepareCreateDisputeEvidenceFileRequest(disputeId, request, imageFile).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createDisputeEvidenceFile.
     */
    private ApiCall<CreateDisputeEvidenceFileResponse, ApiException> prepareCreateDisputeEvidenceFileRequest(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateDisputeEvidenceFileResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/evidence-files")
                        .formParam(param -> param.key("request")
                                .value(request)
                                .multipartSerializer(() -> 
                                        ApiHelper.serialize(request))
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART)
                                .multipartHeaders("Content-Type", "application/json; charset=utf-8"))
                        .formParam(param -> param.key("image_file")
                                .value(imageFile)
                                .multiPartRequestType(MutliPartRequestType.MULTI_PART_FILE)
                                .multipartHeaders("Content-Type", "image/jpeg"))
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateDisputeEvidenceFileResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param  disputeId  Required parameter: The ID of the dispute for which you want to upload
     *         evidence.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateDisputeEvidenceTextResponse createDisputeEvidenceText(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) throws ApiException, IOException {
        return prepareCreateDisputeEvidenceTextRequest(disputeId, body).execute();
    }

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param  disputeId  Required parameter: The ID of the dispute for which you want to upload
     *         evidence.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     */
    public CompletableFuture<CreateDisputeEvidenceTextResponse> createDisputeEvidenceTextAsync(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) {
        try { 
            return prepareCreateDisputeEvidenceTextRequest(disputeId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createDisputeEvidenceText.
     */
    private ApiCall<CreateDisputeEvidenceTextResponse, ApiException> prepareCreateDisputeEvidenceTextRequest(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateDisputeEvidenceTextResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/evidence-text")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateDisputeEvidenceTextResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Removes specified evidence from a dispute. Square does not send the bank any evidence that is
     * removed.
     * @param  disputeId  Required parameter: The ID of the dispute from which you want to remove
     *         evidence.
     * @param  evidenceId  Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the DeleteDisputeEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteDisputeEvidenceResponse deleteDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException {
        return prepareDeleteDisputeEvidenceRequest(disputeId, evidenceId).execute();
    }

    /**
     * Removes specified evidence from a dispute. Square does not send the bank any evidence that is
     * removed.
     * @param  disputeId  Required parameter: The ID of the dispute from which you want to remove
     *         evidence.
     * @param  evidenceId  Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the DeleteDisputeEvidenceResponse response from the API call
     */
    public CompletableFuture<DeleteDisputeEvidenceResponse> deleteDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId) {
        try { 
            return prepareDeleteDisputeEvidenceRequest(disputeId, evidenceId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteDisputeEvidence.
     */
    private ApiCall<DeleteDisputeEvidenceResponse, ApiException> prepareDeleteDisputeEvidenceRequest(
            final String disputeId,
            final String evidenceId) throws IOException {
        return new ApiCall.Builder<DeleteDisputeEvidenceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/evidence/{evidence_id}")
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("evidence_id").value(evidenceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteDisputeEvidenceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns the metadata for the evidence specified in the request URL path. You must maintain a
     * copy of any evidence uploaded if you want to reference it later. Evidence cannot be
     * downloaded after you upload it.
     * @param  disputeId  Required parameter: The ID of the dispute from which you want to retrieve
     *         evidence metadata.
     * @param  evidenceId  Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveDisputeEvidenceResponse retrieveDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException {
        return prepareRetrieveDisputeEvidenceRequest(disputeId, evidenceId).execute();
    }

    /**
     * Returns the metadata for the evidence specified in the request URL path. You must maintain a
     * copy of any evidence uploaded if you want to reference it later. Evidence cannot be
     * downloaded after you upload it.
     * @param  disputeId  Required parameter: The ID of the dispute from which you want to retrieve
     *         evidence metadata.
     * @param  evidenceId  Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call
     */
    public CompletableFuture<RetrieveDisputeEvidenceResponse> retrieveDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId) {
        try { 
            return prepareRetrieveDisputeEvidenceRequest(disputeId, evidenceId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveDisputeEvidence.
     */
    private ApiCall<RetrieveDisputeEvidenceResponse, ApiException> prepareRetrieveDisputeEvidenceRequest(
            final String disputeId,
            final String evidenceId) throws IOException {
        return new ApiCall.Builder<RetrieveDisputeEvidenceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/evidence/{evidence_id}")
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("evidence_id").value(evidenceId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveDisputeEvidenceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Submits evidence to the cardholder's bank. The evidence submitted by this endpoint includes
     * evidence uploaded using the
     * [CreateDisputeEvidenceFile]($e/Disputes/CreateDisputeEvidenceFile) and
     * [CreateDisputeEvidenceText]($e/Disputes/CreateDisputeEvidenceText) endpoints and evidence
     * automatically provided by Square, when available. Evidence cannot be removed from a dispute
     * after submission.
     * @param  disputeId  Required parameter: The ID of the dispute for which you want to submit
     *         evidence.
     * @return    Returns the SubmitEvidenceResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SubmitEvidenceResponse submitEvidence(
            final String disputeId) throws ApiException, IOException {
        return prepareSubmitEvidenceRequest(disputeId).execute();
    }

    /**
     * Submits evidence to the cardholder's bank. The evidence submitted by this endpoint includes
     * evidence uploaded using the
     * [CreateDisputeEvidenceFile]($e/Disputes/CreateDisputeEvidenceFile) and
     * [CreateDisputeEvidenceText]($e/Disputes/CreateDisputeEvidenceText) endpoints and evidence
     * automatically provided by Square, when available. Evidence cannot be removed from a dispute
     * after submission.
     * @param  disputeId  Required parameter: The ID of the dispute for which you want to submit
     *         evidence.
     * @return    Returns the SubmitEvidenceResponse response from the API call
     */
    public CompletableFuture<SubmitEvidenceResponse> submitEvidenceAsync(
            final String disputeId) {
        try { 
            return prepareSubmitEvidenceRequest(disputeId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for submitEvidence.
     */
    private ApiCall<SubmitEvidenceResponse, ApiException> prepareSubmitEvidenceRequest(
            final String disputeId) throws IOException {
        return new ApiCall.Builder<SubmitEvidenceResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/disputes/{dispute_id}/submit-evidence")
                        .templateParam(param -> param.key("dispute_id").value(disputeId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SubmitEvidenceResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}