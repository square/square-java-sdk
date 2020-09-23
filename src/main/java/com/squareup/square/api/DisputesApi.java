package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.AcceptDisputeResponse;
import com.squareup.square.models.CreateDisputeEvidenceFileRequest;
import com.squareup.square.models.CreateDisputeEvidenceFileResponse;
import com.squareup.square.models.CreateDisputeEvidenceTextRequest;
import com.squareup.square.models.CreateDisputeEvidenceTextResponse;
import com.squareup.square.models.ListDisputeEvidenceResponse;
import com.squareup.square.models.ListDisputesResponse;
import com.squareup.square.models.RemoveDisputeEvidenceResponse;
import com.squareup.square.models.RetrieveDisputeEvidenceResponse;
import com.squareup.square.models.RetrieveDisputeResponse;
import com.squareup.square.models.SubmitEvidenceResponse;
import com.squareup.square.utilities.FileWrapper;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface DisputesApi {
    /**
     * Returns a list of disputes associated
     * with a particular account.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query. For more information, see [Paginating](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param    states    Optional parameter: The dispute states to filter the result. If not specified, the endpoint returns all open disputes (dispute status is not `INQUIRY_CLOSED`, `WON`, or `LOST`).
     * @param    locationId    Optional parameter: The ID of the location for which to return  a list of disputes. If not specified, the endpoint returns all open disputes (dispute status is not `INQUIRY_CLOSED`, `WON`, or  `LOST`) associated with all locations.
     * @return    Returns the ListDisputesResponse response from the API call
     */
    ListDisputesResponse listDisputes(
            final String cursor,
            final String states,
            final String locationId) throws ApiException, IOException;

    /**
     * Returns a list of disputes associated
     * with a particular account.
     * @param    cursor    Optional parameter: A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve the next set of results for the original query. For more information, see [Paginating](https://developer.squareup.com/docs/basics/api101/pagination).
     * @param    states    Optional parameter: The dispute states to filter the result. If not specified, the endpoint returns all open disputes (dispute status is not `INQUIRY_CLOSED`, `WON`, or `LOST`).
     * @param    locationId    Optional parameter: The ID of the location for which to return  a list of disputes. If not specified, the endpoint returns all open disputes (dispute status is not `INQUIRY_CLOSED`, `WON`, or  `LOST`) associated with all locations.
     * @return    Returns the ListDisputesResponse response from the API call 
     */
    CompletableFuture<ListDisputesResponse> listDisputesAsync(
            final String cursor,
            final String states,
            final String locationId);

    /**
     * Returns details of a specific dispute.
     * @param    disputeId    Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call
     */
    RetrieveDisputeResponse retrieveDispute(
            final String disputeId) throws ApiException, IOException;

    /**
     * Returns details of a specific dispute.
     * @param    disputeId    Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call 
     */
    CompletableFuture<RetrieveDisputeResponse> retrieveDisputeAsync(
            final String disputeId);

    /**
     * Accepts loss on a dispute. Square returns
     * the disputed amount to the cardholder and updates the
     * dispute state to ACCEPTED.
     * Square debits the disputed amount from the seller’s Square
     * account. If the Square account balance does not have
     * sufficient funds, Square debits the associated bank account.
     * @param    disputeId    Required parameter: ID of the dispute you want to accept.
     * @return    Returns the AcceptDisputeResponse response from the API call
     */
    AcceptDisputeResponse acceptDispute(
            final String disputeId) throws ApiException, IOException;

    /**
     * Accepts loss on a dispute. Square returns
     * the disputed amount to the cardholder and updates the
     * dispute state to ACCEPTED.
     * Square debits the disputed amount from the seller’s Square
     * account. If the Square account balance does not have
     * sufficient funds, Square debits the associated bank account.
     * @param    disputeId    Required parameter: ID of the dispute you want to accept.
     * @return    Returns the AcceptDisputeResponse response from the API call 
     */
    CompletableFuture<AcceptDisputeResponse> acceptDisputeAsync(
            final String disputeId);

    /**
     * Returns a list of evidence associated with a dispute.
     * @param    disputeId    Required parameter: The ID of the dispute.
     * @return    Returns the ListDisputeEvidenceResponse response from the API call
     */
    ListDisputeEvidenceResponse listDisputeEvidence(
            final String disputeId) throws ApiException, IOException;

    /**
     * Returns a list of evidence associated with a dispute.
     * @param    disputeId    Required parameter: The ID of the dispute.
     * @return    Returns the ListDisputeEvidenceResponse response from the API call 
     */
    CompletableFuture<ListDisputeEvidenceResponse> listDisputeEvidenceAsync(
            final String disputeId);

    /**
     * Removes specified evidence from a dispute.
     * Square does not send the bank any evidence that
     * is removed. Also, you cannot remove evidence after
     * submitting it to the bank using [SubmitEvidence](https://developer.squareup.com/docs/reference/square/disputes-api/submit-evidence).
     * @param    disputeId    Required parameter: The ID of the dispute you want to remove evidence from.
     * @param    evidenceId    Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the RemoveDisputeEvidenceResponse response from the API call
     */
    RemoveDisputeEvidenceResponse removeDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException;

    /**
     * Removes specified evidence from a dispute.
     * Square does not send the bank any evidence that
     * is removed. Also, you cannot remove evidence after
     * submitting it to the bank using [SubmitEvidence](https://developer.squareup.com/docs/reference/square/disputes-api/submit-evidence).
     * @param    disputeId    Required parameter: The ID of the dispute you want to remove evidence from.
     * @param    evidenceId    Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the RemoveDisputeEvidenceResponse response from the API call 
     */
    CompletableFuture<RemoveDisputeEvidenceResponse> removeDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId);

    /**
     * Returns the specific evidence metadata associated with a specific dispute.
     * You must maintain a copy of the evidence you upload if you want to
     * reference it later. You cannot download the evidence
     * after you upload it.
     * @param    disputeId    Required parameter: The ID of the dispute that you want to retrieve evidence from.
     * @param    evidenceId    Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call
     */
    RetrieveDisputeEvidenceResponse retrieveDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException;

    /**
     * Returns the specific evidence metadata associated with a specific dispute.
     * You must maintain a copy of the evidence you upload if you want to
     * reference it later. You cannot download the evidence
     * after you upload it.
     * @param    disputeId    Required parameter: The ID of the dispute that you want to retrieve evidence from.
     * @param    evidenceId    Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call 
     */
    CompletableFuture<RetrieveDisputeEvidenceResponse> retrieveDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId);

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts
     * HTTP multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG,
     * and TIFF formats.
     * @param    disputeId    Required parameter: ID of the dispute you want to upload evidence for.
     * @param    request    Optional parameter: Defines parameters for a CreateDisputeEvidenceFile request.
     * @param    imageFile    Optional parameter: Example: 
     * @return    Returns the CreateDisputeEvidenceFileResponse response from the API call
     */
    CreateDisputeEvidenceFileResponse createDisputeEvidenceFile(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) throws ApiException, IOException;

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts
     * HTTP multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG,
     * and TIFF formats.
     * @param    disputeId    Required parameter: ID of the dispute you want to upload evidence for.
     * @param    request    Optional parameter: Defines parameters for a CreateDisputeEvidenceFile request.
     * @param    imageFile    Optional parameter: Example: 
     * @return    Returns the CreateDisputeEvidenceFileResponse response from the API call 
     */
    CompletableFuture<CreateDisputeEvidenceFileResponse> createDisputeEvidenceFileAsync(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile);

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param    disputeId    Required parameter: The ID of the dispute you want to upload evidence for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     */
    CreateDisputeEvidenceTextResponse createDisputeEvidenceText(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) throws ApiException, IOException;

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param    disputeId    Required parameter: The ID of the dispute you want to upload evidence for.
     * @param    body    Required parameter: An object containing the fields to POST for the request.  See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call 
     */
    CompletableFuture<CreateDisputeEvidenceTextResponse> createDisputeEvidenceTextAsync(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body);

    /**
     * Submits evidence to the cardholder's bank.
     * Before submitting evidence, Square compiles all available evidence. This includes
     * evidence uploaded using the
     * [CreateDisputeEvidenceFile](https://developer.squareup.com/docs/reference/square/disputes-api/create-dispute-evidence-file) and
     * [CreateDisputeEvidenceText](https://developer.squareup.com/docs/reference/square/disputes-api/create-dispute-evidence-text) endpoints,
     * and evidence automatically provided by Square, when
     * available.
     * @param    disputeId    Required parameter: The ID of the dispute you want to submit evidence for.
     * @return    Returns the SubmitEvidenceResponse response from the API call
     */
    SubmitEvidenceResponse submitEvidence(
            final String disputeId) throws ApiException, IOException;

    /**
     * Submits evidence to the cardholder's bank.
     * Before submitting evidence, Square compiles all available evidence. This includes
     * evidence uploaded using the
     * [CreateDisputeEvidenceFile](https://developer.squareup.com/docs/reference/square/disputes-api/create-dispute-evidence-file) and
     * [CreateDisputeEvidenceText](https://developer.squareup.com/docs/reference/square/disputes-api/create-dispute-evidence-text) endpoints,
     * and evidence automatically provided by Square, when
     * available.
     * @param    disputeId    Required parameter: The ID of the dispute you want to submit evidence for.
     * @return    Returns the SubmitEvidenceResponse response from the API call 
     */
    CompletableFuture<SubmitEvidenceResponse> submitEvidenceAsync(
            final String disputeId);

}