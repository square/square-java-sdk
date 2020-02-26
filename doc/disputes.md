# Disputes

```java
DisputesApi disputesApi = client.getDisputesApi();
```

## Class Name

`DisputesApi`

## Methods

* [List Disputes](/doc/disputes.md#list-disputes)
* [Retrieve Dispute](/doc/disputes.md#retrieve-dispute)
* [Accept Dispute](/doc/disputes.md#accept-dispute)
* [List Dispute Evidence](/doc/disputes.md#list-dispute-evidence)
* [Remove Dispute Evidence](/doc/disputes.md#remove-dispute-evidence)
* [Retrieve Dispute Evidence](/doc/disputes.md#retrieve-dispute-evidence)
* [Create Dispute Evidence File](/doc/disputes.md#create-dispute-evidence-file)
* [Create Dispute Evidence Text](/doc/disputes.md#create-dispute-evidence-text)
* [Submit Evidence](/doc/disputes.md#submit-evidence)

## List Disputes

Returns a list of disputes associated
with a particular account.

```java
CompletableFuture<ListDisputesResponse> listDisputesAsync(
    final String cursor,
    final String states,
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br>For more information, see [Paginating](https://developer.squareup.com/docs/basics/api101/pagination). |
| `states` | [`String`](/doc/models/dispute-state.md) | Query, Optional | The dispute states to filter the result.<br>If not specified, the endpoint<br>returns all open disputes (dispute status is not<br>`INQUIRY_CLOSED`, `WON`, or `LOST`). |
| `locationId` | `String` | Query, Optional | The ID of the location for which to return <br>a list of disputes. If not specified,<br>the endpoint returns all open disputes<br>(dispute status is not `INQUIRY_CLOSED`, `WON`, or <br>`LOST`) associated with all locations. |

### Response Type

[`ListDisputesResponse`](/doc/models/list-disputes-response.md)

### Example Usage

```java
disputesApi.listDisputesAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Dispute

Returns details of a specific dispute.

```java
CompletableFuture<RetrieveDisputeResponse> retrieveDisputeAsync(
    final String disputeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want more details about. |

### Response Type

[`RetrieveDisputeResponse`](/doc/models/retrieve-dispute-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.retrieveDisputeAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Accept Dispute

Accepts loss on a dispute. Square returns
the disputed amount to the cardholder and updates the
dispute state to ACCEPTED.

Square debits the disputed amount from the seller’s Square
account. If the Square account balance does not have
sufficient funds, Square debits the associated bank account.
For an overview of the Disputes API, see [Overview](https://developer.squareup.com/docs/docs/disputes-api/overview).

```java
CompletableFuture<AcceptDisputeResponse> acceptDisputeAsync(
    final String disputeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | ID of the dispute you want to accept. |

### Response Type

[`AcceptDisputeResponse`](/doc/models/accept-dispute-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.acceptDisputeAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Dispute Evidence

Returns a list of evidence associated with a dispute.

```java
CompletableFuture<ListDisputeEvidenceResponse> listDisputeEvidenceAsync(
    final String disputeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute. |

### Response Type

[`ListDisputeEvidenceResponse`](/doc/models/list-dispute-evidence-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.listDisputeEvidenceAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Remove Dispute Evidence

Removes specified evidence from a dispute.

Square does not send the bank any evidence that
is removed. Also, you cannot remove evidence after
submitting it to the bank using [SubmitEvidence](https://developer.squareup.com/docs/reference/square/disputes-api/submit-evidence).

```java
CompletableFuture<RemoveDisputeEvidenceResponse> removeDisputeEvidenceAsync(
    final String disputeId,
    final String evidenceId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to remove evidence from. |
| `evidenceId` | `String` | Template, Required | The ID of the evidence you want to remove. |

### Response Type

[`RemoveDisputeEvidenceResponse`](/doc/models/remove-dispute-evidence-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";
String evidenceId = "evidence_id2";

disputesApi.removeDisputeEvidenceAsync(disputeId, evidenceId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Dispute Evidence

Returns the specific evidence metadata associated with a specific dispute.

You must maintain a copy of the evidence you upload if you want to
reference it later. You cannot download the evidence
after you upload it.

```java
CompletableFuture<RetrieveDisputeEvidenceResponse> retrieveDisputeEvidenceAsync(
    final String disputeId,
    final String evidenceId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute that you want to retrieve evidence from. |
| `evidenceId` | `String` | Template, Required | The ID of the evidence to retrieve. |

### Response Type

[`RetrieveDisputeEvidenceResponse`](/doc/models/retrieve-dispute-evidence-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";
String evidenceId = "evidence_id2";

disputesApi.retrieveDisputeEvidenceAsync(disputeId, evidenceId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Dispute Evidence File

Uploads a file to use as evidence in a dispute challenge. The endpoint accepts
HTTP multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG,
and TIFF formats. The following is an example of such an HTTP request:
```
curl -X POST \
-H 'Accept: application/json' \
-H 'Authorization: Bearer {{ACCESS_TOKEN}}' \
-H 'Content-Type: multipart/form-data' \
-F 'evidence=@/path/to/file/filename.tiff' \
-F 'request={ "idempotency_key":"{{UNIQUE_KEY}}", "evidence_type":"{{EVIDENCE_TYPE}}", "content_type":"image/tiff" }' \
'https://connect.squareup.com/v2/disputes/{{DISPUTE_ID}}/evidence_file'
```
For more information, see [Challenge a Dispute](https://developer.squareup.com/docs/docs/disputes-api/process-disputes#challenge-a-dispute).

```java
CompletableFuture<CreateDisputeEvidenceFileResponse> createDisputeEvidenceFileAsync(
    final String disputeId,
    final CreateDisputeEvidenceFileRequest request,
    final FileWrapper imageFile)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | ID of the dispute you want to upload evidence for. |
| `request` | [`CreateDisputeEvidenceFileRequest`](/doc/models/create-dispute-evidence-file-request.md) | Form, Optional | Defines parameters for a CreateDisputeEvidenceFile request. |
| `imageFile` | `FileWrapper` | Form, Optional | - |

### Response Type

[`CreateDisputeEvidenceFileResponse`](/doc/models/create-dispute-evidence-file-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.createDisputeEvidenceFileAsync(disputeId, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Dispute Evidence Text

Uploads text to use as evidence for a dispute challenge. For more information, see
[Challenge a Dispute](https://developer.squareup.com/docs/docs/disputes-api/process-disputes#challenge-a-dispute).

```java
CompletableFuture<CreateDisputeEvidenceTextResponse> createDisputeEvidenceTextAsync(
    final String disputeId,
    final CreateDisputeEvidenceTextRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to upload evidence for. |
| `body` | [`CreateDisputeEvidenceTextRequest`](/doc/models/create-dispute-evidence-text-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateDisputeEvidenceTextResponse`](/doc/models/create-dispute-evidence-text-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";
CreateDisputeEvidenceTextRequest body = new CreateDisputeEvidenceTextRequest.Builder(
        "ed3ee3933d946f1514d505d173c82648",
        "1Z8888888888888888")
    .evidenceType("TRACKING_NUMBER")
    .build();

disputesApi.createDisputeEvidenceTextAsync(disputeId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Submit Evidence

Submits evidence to the cardholder's bank.

Before submitting evidence, Square compiles all available evidence. This includes
evidence uploaded using the
[CreateDisputeEvidenceFile](https://developer.squareup.com/docs/reference/square/disputes-api/create-dispute-evidence-file) and
[CreateDisputeEvidenceText](https://developer.squareup.com/docs/reference/square/disputes-api/create-dispute-evidence-text) endpoints,
and evidence automatically provided by Square, when
available. For more information, see
[Challenge a Dispute](https://developer.squareup.com/docs/docs/disputes-api/process-disputes#challenge-a-dispute).

```java
CompletableFuture<SubmitEvidenceResponse> submitEvidenceAsync(
    final String disputeId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to submit evidence for. |

### Response Type

[`SubmitEvidenceResponse`](/doc/models/submit-evidence-response.md)

### Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.submitEvidenceAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

