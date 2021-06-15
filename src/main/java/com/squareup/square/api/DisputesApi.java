
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
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
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface DisputesApi {
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
    ListDisputesResponse listDisputes(
            final String cursor,
            final String states,
            final String locationId) throws ApiException, IOException;

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
    CompletableFuture<ListDisputesResponse> listDisputesAsync(
            final String cursor,
            final String states,
            final String locationId);

    /**
     * Returns details about a specific dispute.
     * @param  disputeId  Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveDisputeResponse retrieveDispute(
            final String disputeId) throws ApiException, IOException;

    /**
     * Returns details about a specific dispute.
     * @param  disputeId  Required parameter: The ID of the dispute you want more details about.
     * @return    Returns the RetrieveDisputeResponse response from the API call
     */
    CompletableFuture<RetrieveDisputeResponse> retrieveDisputeAsync(
            final String disputeId);

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
    AcceptDisputeResponse acceptDispute(
            final String disputeId) throws ApiException, IOException;

    /**
     * Accepts the loss on a dispute. Square returns the disputed amount to the cardholder and
     * updates the dispute state to ACCEPTED. Square debits the disputed amount from the seller’s
     * Square account. If the Square account does not have sufficient funds, Square debits the
     * associated bank account.
     * @param  disputeId  Required parameter: The ID of the dispute you want to accept.
     * @return    Returns the AcceptDisputeResponse response from the API call
     */
    CompletableFuture<AcceptDisputeResponse> acceptDisputeAsync(
            final String disputeId);

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
    ListDisputeEvidenceResponse listDisputeEvidence(
            final String disputeId,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a list of evidence associated with a dispute.
     * @param  disputeId  Required parameter: The ID of the dispute.
     * @param  cursor  Optional parameter: A pagination cursor returned by a previous call to this
     *         endpoint. Provide this cursor to retrieve the next set of results for the original
     *         query. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return    Returns the ListDisputeEvidenceResponse response from the API call
     */
    CompletableFuture<ListDisputeEvidenceResponse> listDisputeEvidenceAsync(
            final String disputeId,
            final String cursor);

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
    CreateDisputeEvidenceFileResponse createDisputeEvidenceFile(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile) throws ApiException, IOException;

    /**
     * Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
     * multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  request  Optional parameter: Defines the parameters for a `CreateDisputeEvidenceFile`
     *         request.
     * @param  imageFile  Optional parameter: Example:
     * @return    Returns the CreateDisputeEvidenceFileResponse response from the API call
     */
    CompletableFuture<CreateDisputeEvidenceFileResponse> createDisputeEvidenceFileAsync(
            final String disputeId,
            final CreateDisputeEvidenceFileRequest request,
            final FileWrapper imageFile);

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateDisputeEvidenceTextResponse createDisputeEvidenceText(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body) throws ApiException, IOException;

    /**
     * Uploads text to use as evidence for a dispute challenge.
     * @param  disputeId  Required parameter: The ID of the dispute you want to upload evidence for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateDisputeEvidenceTextResponse response from the API call
     */
    CompletableFuture<CreateDisputeEvidenceTextResponse> createDisputeEvidenceTextAsync(
            final String disputeId,
            final CreateDisputeEvidenceTextRequest body);

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
    DeleteDisputeEvidenceResponse deleteDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException;

    /**
     * Removes specified evidence from a dispute. Square does not send the bank any evidence that is
     * removed. Also, you cannot remove evidence after submitting it to the bank using
     * [SubmitEvidence]($e/Disputes/SubmitEvidence).
     * @param  disputeId  Required parameter: The ID of the dispute you want to remove evidence
     *         from.
     * @param  evidenceId  Required parameter: The ID of the evidence you want to remove.
     * @return    Returns the DeleteDisputeEvidenceResponse response from the API call
     */
    CompletableFuture<DeleteDisputeEvidenceResponse> deleteDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId);

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
    RetrieveDisputeEvidenceResponse retrieveDisputeEvidence(
            final String disputeId,
            final String evidenceId) throws ApiException, IOException;

    /**
     * Returns the evidence metadata specified by the evidence ID in the request URL path You must
     * maintain a copy of the evidence you upload if you want to reference it later. You cannot
     * download the evidence after you upload it.
     * @param  disputeId  Required parameter: The ID of the dispute that you want to retrieve
     *         evidence from.
     * @param  evidenceId  Required parameter: The ID of the evidence to retrieve.
     * @return    Returns the RetrieveDisputeEvidenceResponse response from the API call
     */
    CompletableFuture<RetrieveDisputeEvidenceResponse> retrieveDisputeEvidenceAsync(
            final String disputeId,
            final String evidenceId);

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
    SubmitEvidenceResponse submitEvidence(
            final String disputeId) throws ApiException, IOException;

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
    CompletableFuture<SubmitEvidenceResponse> submitEvidenceAsync(
            final String disputeId);

}