# O Auth

```java
OAuthApi oAuthApi = client.getOAuthApi();
```

## Class Name

`OAuthApi`

## Methods

* [Renew Token](/doc/api/o-auth.md#renew-token)
* [Revoke Token](/doc/api/o-auth.md#revoke-token)
* [Obtain Token](/doc/api/o-auth.md#obtain-token)


# Renew Token

**This endpoint is deprecated. **

`RenewToken` is deprecated. For information about refreshing OAuth access tokens, see
[Renew OAuth Token](https://developer.squareup.com/docs/oauth-api/cookbook/renew-oauth-tokens).

Renews an OAuth access token before it expires.

OAuth access tokens besides your application's personal access token expire after __30 days__.
You can also renew expired tokens within __15 days__ of their expiration.
You cannot renew an access token that has been expired for more than 15 days.
Instead, the associated user must re-complete the OAuth flow from the beginning.

__Important:__ The `Authorization` header for this endpoint must have the
following format:

```
Authorization: Client APPLICATION_SECRET
```

Replace `APPLICATION_SECRET` with the application secret on the Credentials
page in the [application dashboard](https://connect.squareup.com/apps).

:information_source: **Note** This endpoint does not require authentication.

```java
CompletableFuture<RenewTokenResponse> renewTokenAsync(
    final String clientId,
    final RenewTokenRequest body,
    final String authorization)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `clientId` | `String` | Template, Required | Your application ID, available from the [application dashboard](https://connect.squareup.com/apps). |
| `body` | [`RenewTokenRequest`](/doc/models/renew-token-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |
| `authorization` | `String` | Header, Required | Client APPLICATION_SECRET |

## Response Type

[`RenewTokenResponse`](/doc/models/renew-token-response.md)

## Example Usage

```java
String clientId = "client_id8";
RenewTokenRequest body = new RenewTokenRequest.Builder()
    .accessToken("ACCESS_TOKEN")
    .build();
String authorization = "Client CLIENT_SECRET";

oAuthApi.renewTokenAsync(clientId, body, authorization).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Revoke Token

Revokes an access token generated with the OAuth flow.

If an account has more than one OAuth access token for your application, this
endpoint revokes all of them, regardless of which token you specify. When an
OAuth access token is revoked, all of the active subscriptions associated
with that OAuth token are canceled immediately.

__Important:__ The `Authorization` header for this endpoint must have the
following format:

```
Authorization: Client APPLICATION_SECRET
```

Replace `APPLICATION_SECRET` with the application secret on the Credentials
page in the [Developer Dashboard](https://developer.squareup.com/apps).

:information_source: **Note** This endpoint does not require authentication.

```java
CompletableFuture<RevokeTokenResponse> revokeTokenAsync(
    final RevokeTokenRequest body,
    final String authorization)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`RevokeTokenRequest`](/doc/models/revoke-token-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |
| `authorization` | `String` | Header, Required | Client APPLICATION_SECRET |

## Response Type

[`RevokeTokenResponse`](/doc/models/revoke-token-response.md)

## Example Usage

```java
RevokeTokenRequest body = new RevokeTokenRequest.Builder()
    .clientId("CLIENT_ID")
    .accessToken("ACCESS_TOKEN")
    .merchantId("merchant_id6")
    .revokeOnlyAccessToken(false)
    .build();
String authorization = "Client CLIENT_SECRET";

oAuthApi.revokeTokenAsync(body, authorization).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Obtain Token

Returns an OAuth access token.

The endpoint supports distinct methods of obtaining OAuth access tokens.
Applications specify a method by adding the `grant_type` parameter
in the request and also provide relevant information.

__Note:__ Regardless of the method application specified,
the endpoint always returns two items; an OAuth access token and
a refresh token in the response.

__OAuth tokens should only live on secure servers. Application clients
should never interact directly with OAuth tokens__.

:information_source: **Note** This endpoint does not require authentication.

```java
CompletableFuture<ObtainTokenResponse> obtainTokenAsync(
    final ObtainTokenRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`ObtainTokenRequest`](/doc/models/obtain-token-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`ObtainTokenResponse`](/doc/models/obtain-token-response.md)

## Example Usage

```java
List<String> bodyScopes = new LinkedList<>();
bodyScopes.add("scopes6");
bodyScopes.add("scopes7");
bodyScopes.add("scopes8");
ObtainTokenRequest body = new ObtainTokenRequest.Builder(
        "APPLICATION_ID",
        "APPLICATION_SECRET",
        "authorization_code")
    .code("CODE_FROM_AUTHORIZE")
    .redirectUri("redirect_uri4")
    .refreshToken("refresh_token6")
    .migrationToken("migration_token4")
    .scopes(bodyScopes)
    .build();

oAuthApi.obtainTokenAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

