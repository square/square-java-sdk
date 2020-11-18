# Mobile Authorization

```java
MobileAuthorizationApi mobileAuthorizationApi = client.getMobileAuthorizationApi();
```

## Class Name

`MobileAuthorizationApi`


# Create Mobile Authorization Code

Generates code to authorize a mobile application to connect to a Square card reader

Authorization codes are one-time-use and expire __60 minutes__ after being issued.

__Important:__ The `Authorization` header you provide to this endpoint must have the following format:

```
Authorization: Bearer ACCESS_TOKEN
```

Replace `ACCESS_TOKEN` with a
[valid production authorization credential](https://developer.squareup.com/docs/build-basics/access-tokens).

```java
CompletableFuture<CreateMobileAuthorizationCodeResponse> createMobileAuthorizationCodeAsync(
    final CreateMobileAuthorizationCodeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateMobileAuthorizationCodeRequest`](/doc/models/create-mobile-authorization-code-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateMobileAuthorizationCodeResponse`](/doc/models/create-mobile-authorization-code-response.md)

## Example Usage

```java
CreateMobileAuthorizationCodeRequest body = new CreateMobileAuthorizationCodeRequest.Builder()
    .locationId("YOUR_LOCATION_ID")
    .build();

mobileAuthorizationApi.createMobileAuthorizationCodeAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

