# Disputes

```java
DisputesApi disputesApi = client.getDisputesApi();
```

## Class Name

`DisputesApi`

## Methods

* [List Disputes](../../doc/api/disputes.md#list-disputes)
* [Retrieve Dispute](../../doc/api/disputes.md#retrieve-dispute)
* [Accept Dispute](../../doc/api/disputes.md#accept-dispute)
* [List Dispute Evidence](../../doc/api/disputes.md#list-dispute-evidence)
* [Create Dispute Evidence File](../../doc/api/disputes.md#create-dispute-evidence-file)
* [Create Dispute Evidence Text](../../doc/api/disputes.md#create-dispute-evidence-text)
* [Delete Dispute Evidence](../../doc/api/disputes.md#delete-dispute-evidence)
* [Retrieve Dispute Evidence](../../doc/api/disputes.md#retrieve-dispute-evidence)
* [Submit Evidence](../../doc/api/disputes.md#submit-evidence)


# List Disputes

Returns a list of disputes associated with a particular account.

```java
CompletableFuture<ListDisputesResponse> listDisputesAsync(
    final String cursor,
    final String states,
    final String locationId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>For more information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). |
| `states` | [`String`](../../doc/models/dispute-state.md) | Query, Optional | The dispute states to filter the result.<br>If not specified, the endpoint returns all open disputes (the dispute status is not `INQUIRY_CLOSED`, `WON`,<br>or `LOST`). |
| `locationId` | `String` | Query, Optional | The ID of the location for which to return a list of disputes. If not specified, the endpoint returns<br>all open disputes (the dispute status is not `INQUIRY_CLOSED`, `WON`, or `LOST`) associated with all locations. |

## Response Type

[`ListDisputesResponse`](../../doc/models/list-disputes-response.md)

## Example Usage

```java
String cursor = "cursor6";
String states = "INQUIRY_EVIDENCE_REQUIRED";
String locationId = "location_id4";

disputesApi.listDisputesAsync(cursor, states, locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Dispute

Returns details about a specific dispute.

```java
CompletableFuture<RetrieveDisputeResponse> retrieveDisputeAsync(
    final String disputeId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want more details about. |

## Response Type

[`RetrieveDisputeResponse`](../../doc/models/retrieve-dispute-response.md)

## Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.retrieveDisputeAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Accept Dispute

Accepts the loss on a dispute. Square returns the disputed amount to the cardholder and
updates the dispute state to ACCEPTED.

Square debits the disputed amount from the seller’s Square account. If the Square account
does not have sufficient funds, Square debits the associated bank account.

```java
CompletableFuture<AcceptDisputeResponse> acceptDisputeAsync(
    final String disputeId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to accept. |

## Response Type

[`AcceptDisputeResponse`](../../doc/models/accept-dispute-response.md)

## Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.acceptDisputeAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Dispute Evidence

Returns a list of evidence associated with a dispute.

```java
CompletableFuture<ListDisputeEvidenceResponse> listDisputeEvidenceAsync(
    final String disputeId,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>For more information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). |

## Response Type

[`ListDisputeEvidenceResponse`](../../doc/models/list-dispute-evidence-response.md)

## Example Usage

```java
String disputeId = "dispute_id2";
String cursor = "cursor6";

disputesApi.listDisputeEvidenceAsync(disputeId, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Dispute Evidence File

Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.

```java
CompletableFuture<CreateDisputeEvidenceFileResponse> createDisputeEvidenceFileAsync(
    final String disputeId,
    final CreateDisputeEvidenceFileRequest request,
    final FileWrapper imageFile)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to upload evidence for. |
| `request` | [`CreateDisputeEvidenceFileRequest`](../../doc/models/create-dispute-evidence-file-request.md) | Form, Optional | Defines the parameters for a `CreateDisputeEvidenceFile` request. |
| `imageFile` | `FileWrapper` | Form, Optional | - |

## Response Type

[`CreateDisputeEvidenceFileResponse`](../../doc/models/create-dispute-evidence-file-response.md)

## Example Usage

```java
String disputeId = "dispute_id2";
CreateDisputeEvidenceFileRequest request = new CreateDisputeEvidenceFileRequest.Builder(
        "idempotency_key2")
    .evidenceType("REBUTTAL_EXPLANATION")
    .contentType("content_type0")
    .build();
FileWrapper imageFile = new FileWrapper(new File("dummy_file"), "optional-content-type");

disputesApi.createDisputeEvidenceFileAsync(disputeId, request, imageFile).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Dispute Evidence Text

Uploads text to use as evidence for a dispute challenge.

```java
CompletableFuture<CreateDisputeEvidenceTextResponse> createDisputeEvidenceTextAsync(
    final String disputeId,
    final CreateDisputeEvidenceTextRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to upload evidence for. |
| `body` | [`CreateDisputeEvidenceTextRequest`](../../doc/models/create-dispute-evidence-text-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateDisputeEvidenceTextResponse`](../../doc/models/create-dispute-evidence-text-response.md)

## Example Usage

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


# Delete Dispute Evidence

Removes specified evidence from a dispute.

Square does not send the bank any evidence that is removed. Also, you cannot remove evidence after
submitting it to the bank using [SubmitEvidence](../../doc/api/disputes.md#submit-evidence).

```java
CompletableFuture<DeleteDisputeEvidenceResponse> deleteDisputeEvidenceAsync(
    final String disputeId,
    final String evidenceId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute you want to remove evidence from. |
| `evidenceId` | `String` | Template, Required | The ID of the evidence you want to remove. |

## Response Type

[`DeleteDisputeEvidenceResponse`](../../doc/models/delete-dispute-evidence-response.md)

## Example Usage

```java
String disputeId = "dispute_id2";
String evidenceId = "evidence_id2";

disputesApi.deleteDisputeEvidenceAsync(disputeId, evidenceId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Dispute Evidence

Returns the evidence metadata specified by the evidence ID in the request URL path

You must maintain a copy of the evidence you upload if you want to reference it later. You cannot
download the evidence after you upload it.

```java
CompletableFuture<RetrieveDisputeEvidenceResponse> retrieveDisputeEvidenceAsync(
    final String disputeId,
    final String evidenceId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute that you want to retrieve evidence from. |
| `evidenceId` | `String` | Template, Required | The ID of the evidence to retrieve. |

## Response Type

[`RetrieveDisputeEvidenceResponse`](../../doc/models/retrieve-dispute-evidence-response.md)

## Example Usage

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


# Submit Evidence

Submits evidence to the cardholder's bank.

Before submitting evidence, Square compiles all available evidence. This includes evidence uploaded
using the [CreateDisputeEvidenceFile](../../doc/api/disputes.md#create-dispute-evidence-file) and
[CreateDisputeEvidenceText](../../doc/api/disputes.md#create-dispute-evidence-text) endpoints and
evidence automatically provided by Square, when available.

```java
CompletableFuture<SubmitEvidenceResponse> submitEvidenceAsync(
    final String disputeId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `disputeId` | `String` | Template, Required | The ID of the dispute that you want to submit evidence for. |

## Response Type

[`SubmitEvidenceResponse`](../../doc/models/submit-evidence-response.md)

## Example Usage

```java
String disputeId = "dispute_id2";

disputesApi.submitEvidenceAsync(disputeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

