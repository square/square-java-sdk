# Reference
## Mobile
<details><summary><code>client.mobile.authorizationCode(request) -> CreateMobileAuthorizationCodeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

__Note:__ This endpoint is used by the deprecated Reader SDK. 
Developers should update their integration to use the [Mobile Payments SDK](https://developer.squareup.com/docs/mobile-payments-sdk), which includes its own authorization methods. 

Generates code to authorize a mobile application to connect to a Square card reader.

Authorization codes are one-time-use codes and expire 60 minutes after being issued.

The `Authorization` header you provide to this endpoint must have the following format:

```
Authorization: Bearer ACCESS_TOKEN
```

Replace `ACCESS_TOKEN` with a
[valid production authorization credential](https://developer.squareup.com/docs/build-basics/access-tokens).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.mobile().authorizationCode(
    CreateMobileAuthorizationCodeRequest
        .builder()
        .locationId("YOUR_LOCATION_ID")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `Optional<String>` — The Square location ID that the authorization code should be tied to.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## OAuth
<details><summary><code>client.oAuth.revokeToken(request) -> RevokeTokenResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Revokes an access token generated with the OAuth flow.

If an account has more than one OAuth access token for your application, this
endpoint revokes all of them, regardless of which token you specify. 

__Important:__ The `Authorization` header for this endpoint must have the
following format:

```
Authorization: Client APPLICATION_SECRET
```

Replace `APPLICATION_SECRET` with the application secret on the **OAuth**
page for your application in the Developer Dashboard.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.oAuth().revokeToken(
    RevokeTokenRequest
        .builder()
        .clientId("CLIENT_ID")
        .accessToken("ACCESS_TOKEN")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**clientId:** `Optional<String>` 

The Square-issued ID for your application, which is available on the **OAuth** page in the
[Developer Dashboard](https://developer.squareup.com/apps).
    
</dd>
</dl>

<dl>
<dd>

**accessToken:** `Optional<String>` 

The access token of the merchant whose token you want to revoke.
Do not provide a value for `merchant_id` if you provide this parameter.
    
</dd>
</dl>

<dl>
<dd>

**merchantId:** `Optional<String>` 

The ID of the merchant whose token you want to revoke.
Do not provide a value for `access_token` if you provide this parameter.
    
</dd>
</dl>

<dl>
<dd>

**revokeOnlyAccessToken:** `Optional<Boolean>` 

If `true`, terminate the given single access token, but do not
terminate the entire authorization.
Default: `false`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.oAuth.obtainToken(request) -> ObtainTokenResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns an OAuth access token and refresh token using the `authorization_code`
or `refresh_token` grant type.

When `grant_type` is `authorization_code`:
- With the [code flow](https://developer.squareup.com/docs/oauth-api/overview#code-flow),
provide `code`, `client_id`, and `client_secret`.
- With the [PKCE flow](https://developer.squareup.com/docs/oauth-api/overview#pkce-flow),
provide `code`, `client_id`, and `code_verifier`. 

When `grant_type` is `refresh_token`:
- With the code flow, provide `refresh_token`, `client_id`, and `client_secret`.
The response returns the same refresh token provided in the request.
- With the PKCE flow, provide `refresh_token` and `client_id`. The response returns
a new refresh token.

You can use the `scopes` parameter to limit the set of permissions authorized by the
access token. You can use the `short_lived` parameter to create an access token that
expires in 24 hours.

__Important:__ OAuth tokens should be encrypted and stored on a secure server.
Application clients should never interact directly with OAuth tokens.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.oAuth().obtainToken(
    ObtainTokenRequest
        .builder()
        .clientId("sq0idp-uaPHILoPzWZk3tlJqlML0g")
        .grantType("authorization_code")
        .clientSecret("sq0csp-30a-4C_tVOnTh14Piza2BfTPBXyLafLPWSzY1qAjeBfM")
        .code("sq0cgb-l0SBqxs4uwxErTVyYOdemg")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**clientId:** `String` 

The Square-issued ID of your application, which is available as the **Application ID**
on the **OAuth** page in the [Developer Console](https://developer.squareup.com/apps).

Required for the code flow and PKCE flow for any grant type.
    
</dd>
</dl>

<dl>
<dd>

**clientSecret:** `Optional<String>` 

The secret key for your application, which is available as the **Application secret**
on the **OAuth** page in the [Developer Console](https://developer.squareup.com/apps).

Required for the code flow for any grant type. Don't confuse your client secret with your
personal access token.
    
</dd>
</dl>

<dl>
<dd>

**code:** `Optional<String>` 

The authorization code to exchange for an OAuth access token. This is the `code`
value that Square sent to your redirect URL in the authorization response.

Required for the code flow and PKCE flow if `grant_type` is `authorization_code`.
    
</dd>
</dl>

<dl>
<dd>

**redirectUri:** `Optional<String>` 

The redirect URL for your application, which you registered as the **Redirect URL**
on the **OAuth** page in the [Developer Console](https://developer.squareup.com/apps).

Required for the code flow and PKCE flow if `grant_type` is `authorization_code` and
you provided the `redirect_uri` parameter in your authorization URL.
    
</dd>
</dl>

<dl>
<dd>

**grantType:** `String` 

The method used to obtain an OAuth access token. The request must include the
credential that corresponds to the specified grant type. Valid values are:
- `authorization_code` - Requires the `code` field.
- `refresh_token` - Requires the `refresh_token` field.
- `migration_token` - LEGACY for access tokens obtained using a Square API version prior
to 2019-03-13. Requires the `migration_token` field.
    
</dd>
</dl>

<dl>
<dd>

**refreshToken:** `Optional<String>` 

A valid refresh token used to generate a new OAuth access token. This is a
refresh token that was returned in a previous `ObtainToken` response.

Required for the code flow and PKCE flow if `grant_type` is `refresh_token`.
    
</dd>
</dl>

<dl>
<dd>

**migrationToken:** `Optional<String>` 

__LEGACY__ A valid access token (obtained using a Square API version prior to 2019-03-13)
used to generate a new OAuth access token.

Required if `grant_type` is `migration_token`. For more information, see
[Migrate to Using Refresh Tokens](https://developer.squareup.com/docs/oauth-api/migrate-to-refresh-tokens).
    
</dd>
</dl>

<dl>
<dd>

**scopes:** `Optional<List<String>>` 

The list of permissions that are explicitly requested for the access token.
For example, ["MERCHANT_PROFILE_READ","PAYMENTS_READ","BANK_ACCOUNTS_READ"].

The returned access token is limited to the permissions that are the intersection
of these requested permissions and those authorized by the provided `refresh_token`.

Optional for the code flow and PKCE flow if `grant_type` is `refresh_token`.
    
</dd>
</dl>

<dl>
<dd>

**shortLived:** `Optional<Boolean>` 

Indicates whether the returned access token should expire in 24 hours.

Optional for the code flow and PKCE flow for any grant type. The default value is `false`.
    
</dd>
</dl>

<dl>
<dd>

**codeVerifier:** `Optional<String>` 

The secret your application generated for the authorization request used to
obtain the authorization code. This is the source of the `code_challenge` hash you
provided in your authorization URL.

Required for the PKCE flow if `grant_type` is `authorization_code`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.oAuth.retrieveTokenStatus() -> RetrieveTokenStatusResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns information about an [OAuth access token](https://developer.squareup.com/docs/build-basics/access-tokens#get-an-oauth-access-token) or an application’s [personal access token](https://developer.squareup.com/docs/build-basics/access-tokens#get-a-personal-access-token).

Add the access token to the Authorization header of the request.

__Important:__ The `Authorization` header you provide to this endpoint must have the following format:

```
Authorization: Bearer ACCESS_TOKEN
```

where `ACCESS_TOKEN` is a
[valid production authorization credential](https://developer.squareup.com/docs/build-basics/access-tokens).

If the access token is expired or not a valid access token, the endpoint returns an `UNAUTHORIZED` error.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.oAuth().retrieveTokenStatus();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.oAuth.authorize()</code></summary>
<dl>
<dd>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.oAuth().authorize();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## V1Transactions
<details><summary><code>client.v1Transactions.v1ListOrders(locationId) -> List&lt;V1Order&gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Provides summary information for a merchant's online store orders.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v1Transactions().v1ListOrders(
    V1ListOrdersRequest
        .builder()
        .locationId("location_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the location to list online store orders for.
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<SortOrder>` — The order in which payments are listed in the response.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The maximum number of payments to return in a single response. This value cannot exceed 200.
    
</dd>
</dl>

<dl>
<dd>

**batchToken:** `Optional<String>` 

A pagination cursor to retrieve the next set of results for your
original query to the endpoint.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.v1Transactions.v1RetrieveOrder(locationId, orderId) -> V1Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Provides comprehensive information for a single online store order, including the order's history.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v1Transactions().v1RetrieveOrder(
    V1RetrieveOrderRequest
        .builder()
        .locationId("location_id")
        .orderId("order_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the order's associated location.
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `String` — The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.v1Transactions.v1UpdateOrder(locationId, orderId, request) -> V1Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.v1Transactions().v1UpdateOrder(
    V1UpdateOrderRequest
        .builder()
        .locationId("location_id")
        .orderId("order_id")
        .action(V1UpdateOrderRequestAction.COMPLETE)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the order's associated location.
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `String` — The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
    
</dd>
</dl>

<dl>
<dd>

**action:** `V1UpdateOrderRequestAction` 

The action to perform on the order (COMPLETE, CANCEL, or REFUND).
See [V1UpdateOrderRequestAction](#type-v1updateorderrequestaction) for possible values
    
</dd>
</dl>

<dl>
<dd>

**shippedTrackingNumber:** `Optional<String>` — The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.
    
</dd>
</dl>

<dl>
<dd>

**completedNote:** `Optional<String>` — A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.
    
</dd>
</dl>

<dl>
<dd>

**refundedNote:** `Optional<String>` — A merchant-specified note about the refunding of the order. Only valid if action is REFUND.
    
</dd>
</dl>

<dl>
<dd>

**canceledNote:** `Optional<String>` — A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## ApplePay
<details><summary><code>client.applePay.registerDomain(request) -> RegisterDomainResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Activates a domain for use with Apple Pay on the Web and Square. A validation
is performed on this domain by Apple to ensure that it is properly set up as
an Apple Pay enabled domain.

This endpoint provides an easy way for platform developers to bulk activate
Apple Pay on the Web with Square for merchants using their platform.

Note: You will need to host a valid domain verification file on your domain to support Apple Pay.  The
current version of this file is always available at https://app.squareup.com/digital-wallets/apple-pay/apple-developer-merchantid-domain-association,
and should be hosted at `.well_known/apple-developer-merchantid-domain-association` on your
domain.  This file is subject to change; we strongly recommend checking for updates regularly and avoiding
long-lived caches that might not keep in sync with the correct file version.

To learn more about the Web Payments SDK and how to add Apple Pay, see [Take an Apple Pay Payment](https://developer.squareup.com/docs/web-payments/apple-pay).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.applePay().registerDomain(
    RegisterDomainRequest
        .builder()
        .domainName("example.com")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**domainName:** `String` — A domain name as described in RFC-1034 that will be registered with ApplePay.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## BankAccounts
<details><summary><code>client.bankAccounts.list() -> ListBankAccountsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of [BankAccount](entity:BankAccount) objects linked to a Square account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bankAccounts().list(
    ListBankAccountsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

The pagination cursor returned by a previous call to this endpoint.
Use it in the next `ListBankAccounts` request to retrieve the next set 
of results.

See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

Upper limit on the number of bank accounts to return in the response. 
Currently, 1000 is the largest supported limit. You can specify a limit 
of up to 1000 bank accounts. This is also the default limit.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 

Location ID. You can specify this optional filter 
to retrieve only the linked bank accounts belonging to a specific location.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bankAccounts.getByV1Id(v1BankAccountId) -> GetBankAccountByV1IdResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns details of a [BankAccount](entity:BankAccount) identified by V1 bank account ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bankAccounts().getByV1Id(
    GetByV1IdBankAccountsRequest
        .builder()
        .v1BankAccountId("v1_bank_account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**v1BankAccountId:** `String` 

Connect V1 ID of the desired `BankAccount`. For more information, see 
[Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bankAccounts.get(bankAccountId) -> GetBankAccountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns details of a [BankAccount](entity:BankAccount)
linked to a Square account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bankAccounts().get(
    GetBankAccountsRequest
        .builder()
        .bankAccountId("bank_account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**bankAccountId:** `String` — Square-issued ID of the desired `BankAccount`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Bookings
<details><summary><code>client.bookings.list() -> ListBookingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieve a collection of bookings.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().list(
    ListBookingsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**limit:** `Optional<Integer>` — The maximum number of results per page to return in a paged response.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` — The pagination cursor from the preceding response to return the next page of the results. Do not set this when retrieving the first page of the results.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `Optional<String>` — The [customer](entity:Customer) for whom to retrieve bookings. If this is not set, bookings for all customers are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**teamMemberId:** `Optional<String>` — The team member for whom to retrieve bookings. If this is not set, bookings of all members are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` — The location for which to retrieve bookings. If this is not set, all locations' bookings are retrieved.
    
</dd>
</dl>

<dl>
<dd>

**startAtMin:** `Optional<String>` — The RFC 3339 timestamp specifying the earliest of the start time. If this is not set, the current time is used.
    
</dd>
</dl>

<dl>
<dd>

**startAtMax:** `Optional<String>` — The RFC 3339 timestamp specifying the latest of the start time. If this is not set, the time of 31 days after `start_at_min` is used.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.create(request) -> CreateBookingResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a booking.

The required input must include the following:
- `Booking.location_id`
- `Booking.start_at`
- `Booking.AppointmentSegment.team_member_id`
- `Booking.AppointmentSegment.service_variation_id`
- `Booking.AppointmentSegment.service_variation_version`

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().create(
    CreateBookingRequest
        .builder()
        .booking(
            Booking
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` — A unique key to make this request an idempotent operation.
    
</dd>
</dl>

<dl>
<dd>

**booking:** `Booking` — The details of the booking to be created.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.searchAvailability(request) -> SearchAvailabilityResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for availabilities for booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().searchAvailability(
    SearchAvailabilityRequest
        .builder()
        .query(
            SearchAvailabilityQuery
                .builder()
                .filter(
                    SearchAvailabilityFilter
                        .builder()
                        .startAtRange(
                            TimeRange
                                .builder()
                                .build()
                        )
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**query:** `SearchAvailabilityQuery` — Query conditions used to filter buyer-accessible booking availabilities.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.bulkRetrieveBookings(request) -> BulkRetrieveBookingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Bulk-Retrieves a list of bookings by booking IDs.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().bulkRetrieveBookings(
    BulkRetrieveBookingsRequest
        .builder()
        .bookingIds(
            new ArrayList<String>(
                Arrays.asList("booking_ids")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**bookingIds:** `List<String>` — A non-empty list of [Booking](entity:Booking) IDs specifying bookings to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.getBusinessProfile() -> GetBusinessBookingProfileResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a seller's booking profile.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().getBusinessProfile();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.retrieveLocationBookingProfile(locationId) -> RetrieveLocationBookingProfileResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a seller's location booking profile.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().retrieveLocationBookingProfile(
    RetrieveLocationBookingProfileRequest
        .builder()
        .locationId("location_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the location to retrieve the booking profile.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.bulkRetrieveTeamMemberBookingProfiles(request) -> BulkRetrieveTeamMemberBookingProfilesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves one or more team members' booking profiles.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().bulkRetrieveTeamMemberBookingProfiles(
    BulkRetrieveTeamMemberBookingProfilesRequest
        .builder()
        .teamMemberIds(
            new ArrayList<String>(
                Arrays.asList("team_member_ids")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**teamMemberIds:** `List<String>` — A non-empty list of IDs of team members whose booking profiles you want to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.get(bookingId) -> GetBookingResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().get(
    GetBookingsRequest
        .builder()
        .bookingId("booking_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**bookingId:** `String` — The ID of the [Booking](entity:Booking) object representing the to-be-retrieved booking.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.update(bookingId, request) -> UpdateBookingResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().update(
    UpdateBookingRequest
        .builder()
        .bookingId("booking_id")
        .booking(
            Booking
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**bookingId:** `String` — The ID of the [Booking](entity:Booking) object representing the to-be-updated booking.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` — A unique key to make this request an idempotent operation.
    
</dd>
</dl>

<dl>
<dd>

**booking:** `Booking` — The booking to be updated. Individual attributes explicitly specified here override the corresponding values of the existing booking.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.bookings.cancel(bookingId, request) -> CancelBookingResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Cancels an existing booking.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.bookings().cancel(
    CancelBookingRequest
        .builder()
        .bookingId("booking_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**bookingId:** `String` — The ID of the [Booking](entity:Booking) object representing the to-be-cancelled booking.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` — A unique key to make this request an idempotent operation.
    
</dd>
</dl>

<dl>
<dd>

**bookingVersion:** `Optional<Integer>` — The revision number for the booking used for optimistic concurrency.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Cards
<details><summary><code>client.cards.list() -> ListCardsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a list of cards owned by the account making the request.
A max of 25 cards will be returned.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cards().list(
    ListCardsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this to retrieve the next set of results for your original query.

See [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination) for more information.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `Optional<String>` 

Limit results to cards associated with the customer supplied.
By default, all cards owned by the merchant are returned.
    
</dd>
</dl>

<dl>
<dd>

**includeDisabled:** `Optional<Boolean>` 

Includes disabled cards.
By default, all enabled cards owned by the merchant are returned.
    
</dd>
</dl>

<dl>
<dd>

**referenceId:** `Optional<String>` — Limit results to cards associated with the reference_id supplied.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<SortOrder>` 

Sorts the returned list by when the card was created with the specified order.
This field defaults to ASC.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.cards.create(request) -> CreateCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Adds a card on file to an existing merchant.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cards().create(
    CreateCardRequest
        .builder()
        .idempotencyKey("4935a656-a929-4792-b97c-8848be85c27c")
        .sourceId("cnon:uIbfJXhXETSP197M3GB")
        .card(
            Card
                .builder()
                .cardholderName("Amelia Earhart")
                .billingAddress(
                    Address
                        .builder()
                        .addressLine1("500 Electric Ave")
                        .addressLine2("Suite 600")
                        .locality("New York")
                        .administrativeDistrictLevel1("NY")
                        .postalCode("10003")
                        .country(Country.US)
                        .build()
                )
                .customerId("VDKXEEKPJN48QDG3BGGFAK05P8")
                .referenceId("user-id-1")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique string that identifies this CreateCard request. Keys can be
any valid string and must be unique for every request.

Max: 45 characters

See [Idempotency keys](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency) for more information.
    
</dd>
</dl>

<dl>
<dd>

**sourceId:** `String` — The ID of the source which represents the card information to be stored. This can be a card nonce or a payment id.
    
</dd>
</dl>

<dl>
<dd>

**verificationToken:** `Optional<String>` 

An identifying token generated by [Payments.verifyBuyer()](https://developer.squareup.com/reference/sdks/web/payments/objects/Payments#Payments.verifyBuyer).
Verification tokens encapsulate customer device information and 3-D Secure
challenge results to indicate that Square has verified the buyer identity.

See the [SCA Overview](https://developer.squareup.com/docs/sca-overview).
    
</dd>
</dl>

<dl>
<dd>

**card:** `Card` — Payment details associated with the card to be stored.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.cards.get(cardId) -> GetCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves details for a specific Card.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cards().get(
    GetCardsRequest
        .builder()
        .cardId("card_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cardId:** `String` — Unique ID for the desired Card.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.cards.disable(cardId) -> DisableCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Disables the card, preventing any further updates or charges.
Disabling an already disabled card is allowed but has no effect.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.cards().disable(
    DisableCardsRequest
        .builder()
        .cardId("card_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cardId:** `String` — Unique ID for the desired Card.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Catalog
<details><summary><code>client.catalog.batchDelete(request) -> BatchDeleteCatalogObjectsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a set of [CatalogItem](entity:CatalogItem)s based on the
provided list of target IDs and returns a set of successfully deleted IDs in
the response. Deletion is a cascading event such that all children of the
targeted object are also deleted. For example, deleting a CatalogItem will
also delete all of its [CatalogItemVariation](entity:CatalogItemVariation)
children.

`BatchDeleteCatalogObjects` succeeds even if only a portion of the targeted
IDs can be deleted. The response will only include IDs that were
actually deleted.

To ensure consistency, only one delete request is processed at a time per seller account.
While one (batch or non-batch) delete request is being processed, other (batched and non-batched)
delete requests are rejected with the `429` error code.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().batchDelete(
    BatchDeleteCatalogObjectsRequest
        .builder()
        .objectIds(
            new ArrayList<String>(
                Arrays.asList("W62UWFY35CWMYGVWK6TWJDNI", "AA27W3M2GGTF3H6AVPNB77CK")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**objectIds:** `List<String>` 

The IDs of the CatalogObjects to be deleted. When an object is deleted, other objects
in the graph that depend on that object will be deleted as well (for example, deleting a
CatalogItem will delete its CatalogItemVariation.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.batchGet(request) -> BatchGetCatalogObjectsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a set of objects based on the provided ID.
Each [CatalogItem](entity:CatalogItem) returned in the set includes all of its
child information including: all of its
[CatalogItemVariation](entity:CatalogItemVariation) objects, references to
its [CatalogModifierList](entity:CatalogModifierList) objects, and the ids of
any [CatalogTax](entity:CatalogTax) objects that apply to it.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().batchGet(
    BatchGetCatalogObjectsRequest
        .builder()
        .objectIds(
            new ArrayList<String>(
                Arrays.asList("W62UWFY35CWMYGVWK6TWJDNI", "AA27W3M2GGTF3H6AVPNB77CK")
            )
        )
        .includeRelatedObjects(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**objectIds:** `List<String>` — The IDs of the CatalogObjects to be retrieved.
    
</dd>
</dl>

<dl>
<dd>

**includeRelatedObjects:** `Optional<Boolean>` 

If `true`, the response will include additional objects that are related to the
requested objects. Related objects are defined as any objects referenced by ID by the results in the `objects` field
of the response. These objects are put in the `related_objects` field. Setting this to `true` is
helpful when the objects are needed for immediate display to a user.
This process only goes one level deep. Objects referenced by the related objects will not be included. For example,

if the `objects` field of the response contains a CatalogItem, its associated
CatalogCategory objects, CatalogTax objects, CatalogImage objects and
CatalogModifierLists will be returned in the `related_objects` field of the
response. If the `objects` field of the response contains a CatalogItemVariation,
its parent CatalogItem will be returned in the `related_objects` field of
the response.

Default value: `false`
    
</dd>
</dl>

<dl>
<dd>

**catalogVersion:** `Optional<Integer>` 

The specific version of the catalog objects to be included in the response. 
This allows you to retrieve historical versions of objects. The specified version value is matched against
the [CatalogObject](entity:CatalogObject)s' `version` attribute. If not included, results will
be from the current version of the catalog.
    
</dd>
</dl>

<dl>
<dd>

**includeDeletedObjects:** `Optional<Boolean>` — Indicates whether to include (`true`) or not (`false`) in the response deleted objects, namely, those with the `is_deleted` attribute set to `true`.
    
</dd>
</dl>

<dl>
<dd>

**includeCategoryPathToRoot:** `Optional<Boolean>` 

Specifies whether or not to include the `path_to_root` list for each returned category instance. The `path_to_root` list consists
of `CategoryPathToRootNode` objects and specifies the path that starts with the immediate parent category of the returned category
and ends with its root category. If the returned category is a top-level category, the `path_to_root` list is empty and is not returned
in the response payload.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.batchUpsert(request) -> BatchUpsertCatalogObjectsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates or updates up to 10,000 target objects based on the provided
list of objects. The target objects are grouped into batches and each batch is
inserted/updated in an all-or-nothing manner. If an object within a batch is
malformed in some way, or violates a database constraint, the entire batch
containing that item will be disregarded. However, other batches in the same
request may still succeed. Each batch may contain up to 1,000 objects, and
batches will be processed in order as long as the total object count for the
request (items, variations, modifier lists, discounts, and taxes) is no more
than 10,000.

To ensure consistency, only one update request is processed at a time per seller account.
While one (batch or non-batch) update request is being processed, other (batched and non-batched)
update requests are rejected with the `429` error code.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().batchUpsert(
    BatchUpsertCatalogObjectsRequest
        .builder()
        .idempotencyKey("789ff020-f723-43a9-b4b5-43b5dc1fa3dc")
        .batches(
            new ArrayList<CatalogObjectBatch>(
                Arrays.asList(
                    CatalogObjectBatch
                        .builder()
                        .objects(
                            new ArrayList<CatalogObject>(
                                Arrays.asList(
                                    CatalogObject.item(
                                        CatalogObjectItem
                                            .builder()
                                            .id("id")
                                            .build()
                                    ),
                                    CatalogObject.item(
                                        CatalogObjectItem
                                            .builder()
                                            .id("id")
                                            .build()
                                    ),
                                    CatalogObject.item(
                                        CatalogObjectItem
                                            .builder()
                                            .id("id")
                                            .build()
                                    ),
                                    CatalogObject.tax(
                                        CatalogObjectTax
                                            .builder()
                                            .id("id")
                                            .build()
                                    )
                                )
                            )
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` 

A value you specify that uniquely identifies this
request among all your requests. A common way to create
a valid idempotency key is to use a Universally unique
identifier (UUID).

If you're unsure whether a particular request was successful,
you can reattempt it with the same idempotency key without
worrying about creating duplicate objects.

See [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency) for more information.
    
</dd>
</dl>

<dl>
<dd>

**batches:** `List<CatalogObjectBatch>` 

A batch of CatalogObjects to be inserted/updated atomically.
The objects within a batch will be inserted in an all-or-nothing fashion, i.e., if an error occurs
attempting to insert or update an object within a batch, the entire batch will be rejected. However, an error
in one batch will not affect other batches within the same request.

For each object, its `updated_at` field is ignored and replaced with a current [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates), and its
`is_deleted` field must not be set to `true`.

To modify an existing object, supply its ID. To create a new object, use an ID starting
with `#`. These IDs may be used to create relationships between an object and attributes of
other objects that reference it. For example, you can create a CatalogItem with
ID `#ABC` and a CatalogItemVariation with its `item_id` attribute set to
`#ABC` in order to associate the CatalogItemVariation with its parent
CatalogItem.

Any `#`-prefixed IDs are valid only within a single atomic batch, and will be replaced by server-generated IDs.

Each batch may contain up to 1,000 objects. The total number of objects across all batches for a single request
may not exceed 10,000. If either of these limits is violated, an error will be returned and no objects will
be inserted or updated.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.info() -> CatalogInfoResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves information about the Square Catalog API, such as batch size
limits that can be used by the `BatchUpsertCatalogObjects` endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().info();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.list() -> ListCatalogResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of all [CatalogObject](entity:CatalogObject)s of the specified types in the catalog.

The `types` parameter is specified as a comma-separated list of the [CatalogObjectType](entity:CatalogObjectType) values,
for example, "`ITEM`, `ITEM_VARIATION`, `MODIFIER`, `MODIFIER_LIST`, `CATEGORY`, `DISCOUNT`, `TAX`, `IMAGE`".

__Important:__ ListCatalog does not return deleted catalog items. To retrieve
deleted catalog items, use [SearchCatalogObjects](api-endpoint:Catalog-SearchCatalogObjects)
and set the `include_deleted_objects` attribute value to `true`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().list(
    ListCatalogRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

The pagination cursor returned in the previous response. Leave unset for an initial request.
The page size is currently set to be 100.
See [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination) for more information.
    
</dd>
</dl>

<dl>
<dd>

**types:** `Optional<String>` 

An optional case-insensitive, comma-separated list of object types to retrieve.

The valid values are defined in the [CatalogObjectType](entity:CatalogObjectType) enum, for example,
`ITEM`, `ITEM_VARIATION`, `CATEGORY`, `DISCOUNT`, `TAX`,
`MODIFIER`, `MODIFIER_LIST`, `IMAGE`, etc.

If this is unspecified, the operation returns objects of all the top level types at the version
of the Square API used to make the request. Object types that are nested onto other object types
are not included in the defaults.

At the current API version the default object types are:
ITEM, CATEGORY, TAX, DISCOUNT, MODIFIER_LIST, 
PRICING_RULE, PRODUCT_SET, TIME_PERIOD, MEASUREMENT_UNIT,
SUBSCRIPTION_PLAN, ITEM_OPTION, CUSTOM_ATTRIBUTE_DEFINITION, QUICK_AMOUNT_SETTINGS.
    
</dd>
</dl>

<dl>
<dd>

**catalogVersion:** `Optional<Integer>` 

The specific version of the catalog objects to be included in the response.
This allows you to retrieve historical versions of objects. The specified version value is matched against
the [CatalogObject](entity:CatalogObject)s' `version` attribute.  If not included, results will be from the
current version of the catalog.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.search(request) -> SearchCatalogObjectsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for [CatalogObject](entity:CatalogObject) of any type by matching supported search attribute values,
excluding custom attribute values on items or item variations, against one or more of the specified query filters.

This (`SearchCatalogObjects`) endpoint differs from the [SearchCatalogItems](api-endpoint:Catalog-SearchCatalogItems)
endpoint in the following aspects:

- `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
- `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
- `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
- The both endpoints have different call conventions, including the query filter formats.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().search(
    SearchCatalogObjectsRequest
        .builder()
        .objectTypes(
            new ArrayList<CatalogObjectType>(
                Arrays.asList(CatalogObjectType.ITEM)
            )
        )
        .query(
            CatalogQuery
                .builder()
                .prefixQuery(
                    CatalogQueryPrefix
                        .builder()
                        .attributeName("name")
                        .attributePrefix("tea")
                        .build()
                )
                .build()
        )
        .limit(100)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

The pagination cursor returned in the previous response. Leave unset for an initial request.
See [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination) for more information.
    
</dd>
</dl>

<dl>
<dd>

**objectTypes:** `Optional<List<CatalogObjectType>>` 

The desired set of object types to appear in the search results.

If this is unspecified, the operation returns objects of all the top level types at the version
of the Square API used to make the request. Object types that are nested onto other object types
are not included in the defaults.

At the current API version the default object types are:
ITEM, CATEGORY, TAX, DISCOUNT, MODIFIER_LIST, 
PRICING_RULE, PRODUCT_SET, TIME_PERIOD, MEASUREMENT_UNIT,
SUBSCRIPTION_PLAN, ITEM_OPTION, CUSTOM_ATTRIBUTE_DEFINITION, QUICK_AMOUNT_SETTINGS.

Note that if you wish for the query to return objects belonging to nested types (i.e., COMPONENT, IMAGE,
ITEM_OPTION_VAL, ITEM_VARIATION, or MODIFIER), you must explicitly include all the types of interest
in this field.
    
</dd>
</dl>

<dl>
<dd>

**includeDeletedObjects:** `Optional<Boolean>` — If `true`, deleted objects will be included in the results. Defaults to `false`. Deleted objects will have their `is_deleted` field set to `true`. If `include_deleted_objects` is `true`, then the `include_category_path_to_root` request parameter must be `false`. Both properties cannot be `true` at the same time.
    
</dd>
</dl>

<dl>
<dd>

**includeRelatedObjects:** `Optional<Boolean>` 

If `true`, the response will include additional objects that are related to the
requested objects. Related objects are objects that are referenced by object ID by the objects
in the response. This is helpful if the objects are being fetched for immediate display to a user.
This process only goes one level deep. Objects referenced by the related objects will not be included.
For example:

If the `objects` field of the response contains a CatalogItem, its associated
CatalogCategory objects, CatalogTax objects, CatalogImage objects and
CatalogModifierLists will be returned in the `related_objects` field of the
response. If the `objects` field of the response contains a CatalogItemVariation,
its parent CatalogItem will be returned in the `related_objects` field of
the response.

Default value: `false`
    
</dd>
</dl>

<dl>
<dd>

**beginTime:** `Optional<String>` 

Return objects modified after this [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates), in RFC 3339
format, e.g., `2016-09-04T23:59:33.123Z`. The timestamp is exclusive - objects with a
timestamp equal to `begin_time` will not be included in the response.
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<CatalogQuery>` — A query to be used to filter or sort the results. If no query is specified, the entire catalog will be returned.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

A limit on the number of results to be returned in a single page. The limit is advisory -
the implementation may return more or fewer results. If the supplied limit is negative, zero, or
is higher than the maximum limit of 1,000, it will be ignored.
    
</dd>
</dl>

<dl>
<dd>

**includeCategoryPathToRoot:** `Optional<Boolean>` — Specifies whether or not to include the `path_to_root` list for each returned category instance. The `path_to_root` list consists of `CategoryPathToRootNode` objects and specifies the path that starts with the immediate parent category of the returned category and ends with its root category. If the returned category is a top-level category, the `path_to_root` list is empty and is not returned in the response payload. If `include_category_path_to_root` is `true`, then the `include_deleted_objects` request parameter must be `false`. Both properties cannot be `true` at the same time.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.searchItems(request) -> SearchCatalogItemsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for catalog items or item variations by matching supported search attribute values, including
custom attribute values, against one or more of the specified query filters.

This (`SearchCatalogItems`) endpoint differs from the [SearchCatalogObjects](api-endpoint:Catalog-SearchCatalogObjects)
endpoint in the following aspects:

- `SearchCatalogItems` can only search for items or item variations, whereas `SearchCatalogObjects` can search for any type of catalog objects.
- `SearchCatalogItems` supports the custom attribute query filters to return items or item variations that contain custom attribute values, where `SearchCatalogObjects` does not.
- `SearchCatalogItems` does not support the `include_deleted_objects` filter to search for deleted items or item variations, whereas `SearchCatalogObjects` does.
- The both endpoints use different call conventions, including the query filter formats.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().searchItems(
    SearchCatalogItemsRequest
        .builder()
        .textFilter("red")
        .categoryIds(
            new ArrayList<String>(
                Arrays.asList("WINE_CATEGORY_ID")
            )
        )
        .stockLevels(
            new ArrayList<SearchCatalogItemsRequestStockLevel>(
                Arrays.asList(SearchCatalogItemsRequestStockLevel.OUT, SearchCatalogItemsRequestStockLevel.LOW)
            )
        )
        .enabledLocationIds(
            new ArrayList<String>(
                Arrays.asList("ATL_LOCATION_ID")
            )
        )
        .limit(100)
        .sortOrder(SortOrder.ASC)
        .productTypes(
            new ArrayList<CatalogItemProductType>(
                Arrays.asList(CatalogItemProductType.REGULAR)
            )
        )
        .customAttributeFilters(
            new ArrayList<CustomAttributeFilter>(
                Arrays.asList(
                    CustomAttributeFilter
                        .builder()
                        .customAttributeDefinitionId("VEGAN_DEFINITION_ID")
                        .boolFilter(true)
                        .build(),
                    CustomAttributeFilter
                        .builder()
                        .customAttributeDefinitionId("BRAND_DEFINITION_ID")
                        .stringFilter("Dark Horse")
                        .build(),
                    CustomAttributeFilter
                        .builder()
                        .key("VINTAGE")
                        .numberFilter(
                            Range
                                .builder()
                                .min("min")
                                .max("max")
                                .build()
                        )
                        .build(),
                    CustomAttributeFilter
                        .builder()
                        .customAttributeDefinitionId("VARIETAL_DEFINITION_ID")
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**textFilter:** `Optional<String>` 

The text filter expression to return items or item variations containing specified text in
the `name`, `description`, or `abbreviation` attribute value of an item, or in
the `name`, `sku`, or `upc` attribute value of an item variation.
    
</dd>
</dl>

<dl>
<dd>

**categoryIds:** `Optional<List<String>>` — The category id query expression to return items containing the specified category IDs.
    
</dd>
</dl>

<dl>
<dd>

**stockLevels:** `Optional<List<SearchCatalogItemsRequestStockLevel>>` 

The stock-level query expression to return item variations with the specified stock levels.
See [SearchCatalogItemsRequestStockLevel](#type-searchcatalogitemsrequeststocklevel) for possible values
    
</dd>
</dl>

<dl>
<dd>

**enabledLocationIds:** `Optional<List<String>>` — The enabled-location query expression to return items and item variations having specified enabled locations.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` — The pagination token, returned in the previous response, used to fetch the next batch of pending results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The maximum number of results to return per page. The default value is 100.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<SortOrder>` 

The order to sort the results by item names. The default sort order is ascending (`ASC`).
See [SortOrder](#type-sortorder) for possible values
    
</dd>
</dl>

<dl>
<dd>

**productTypes:** `Optional<List<CatalogItemProductType>>` — The product types query expression to return items or item variations having the specified product types.
    
</dd>
</dl>

<dl>
<dd>

**customAttributeFilters:** `Optional<List<CustomAttributeFilter>>` 

The customer-attribute filter to return items or item variations matching the specified
custom attribute expressions. A maximum number of 10 custom attribute expressions are supported in
a single call to the [SearchCatalogItems](api-endpoint:Catalog-SearchCatalogItems) endpoint.
    
</dd>
</dl>

<dl>
<dd>

**archivedState:** `Optional<ArchivedState>` — The query filter to return not archived (`ARCHIVED_STATE_NOT_ARCHIVED`), archived (`ARCHIVED_STATE_ARCHIVED`), or either type (`ARCHIVED_STATE_ALL`) of items.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.updateItemModifierLists(request) -> UpdateItemModifierListsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the [CatalogModifierList](entity:CatalogModifierList) objects
that apply to the targeted [CatalogItem](entity:CatalogItem) without having
to perform an upsert on the entire item.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().updateItemModifierLists(
    UpdateItemModifierListsRequest
        .builder()
        .itemIds(
            new ArrayList<String>(
                Arrays.asList("H42BRLUJ5KTZTTMPVSLFAACQ", "2JXOBJIHCWBQ4NZ3RIXQGJA6")
            )
        )
        .modifierListsToEnable(
            new ArrayList<String>(
                Arrays.asList("H42BRLUJ5KTZTTMPVSLFAACQ", "2JXOBJIHCWBQ4NZ3RIXQGJA6")
            )
        )
        .modifierListsToDisable(
            new ArrayList<String>(
                Arrays.asList("7WRC16CJZDVLSNDQ35PP6YAD")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**itemIds:** `List<String>` — The IDs of the catalog items associated with the CatalogModifierList objects being updated.
    
</dd>
</dl>

<dl>
<dd>

**modifierListsToEnable:** `Optional<List<String>>` 

The IDs of the CatalogModifierList objects to enable for the CatalogItem.
At least one of `modifier_lists_to_enable` or `modifier_lists_to_disable` must be specified.
    
</dd>
</dl>

<dl>
<dd>

**modifierListsToDisable:** `Optional<List<String>>` 

The IDs of the CatalogModifierList objects to disable for the CatalogItem.
At least one of `modifier_lists_to_enable` or `modifier_lists_to_disable` must be specified.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.catalog.updateItemTaxes(request) -> UpdateItemTaxesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the [CatalogTax](entity:CatalogTax) objects that apply to the
targeted [CatalogItem](entity:CatalogItem) without having to perform an
upsert on the entire item.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.catalog().updateItemTaxes(
    UpdateItemTaxesRequest
        .builder()
        .itemIds(
            new ArrayList<String>(
                Arrays.asList("H42BRLUJ5KTZTTMPVSLFAACQ", "2JXOBJIHCWBQ4NZ3RIXQGJA6")
            )
        )
        .taxesToEnable(
            new ArrayList<String>(
                Arrays.asList("4WRCNHCJZDVLSNDQ35PP6YAD")
            )
        )
        .taxesToDisable(
            new ArrayList<String>(
                Arrays.asList("AQCEGCEBBQONINDOHRGZISEX")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**itemIds:** `List<String>` 

IDs for the CatalogItems associated with the CatalogTax objects being updated.
No more than 1,000 IDs may be provided.
    
</dd>
</dl>

<dl>
<dd>

**taxesToEnable:** `Optional<List<String>>` 

IDs of the CatalogTax objects to enable.
At least one of `taxes_to_enable` or `taxes_to_disable` must be specified.
    
</dd>
</dl>

<dl>
<dd>

**taxesToDisable:** `Optional<List<String>>` 

IDs of the CatalogTax objects to disable.
At least one of `taxes_to_enable` or `taxes_to_disable` must be specified.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Customers
<details><summary><code>client.customers.list() -> ListCustomersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists customer profiles associated with a Square account.

Under normal operating conditions, newly created or updated customer profiles become available
for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
profiles can take closer to one minute or longer, especially during network incidents and outages.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().list(
    ListCustomersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for your original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to return in a single page. This limit is advisory. The response might contain more or fewer results.
If the specified limit is less than 1 or greater than 100, Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 100.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**sortField:** `Optional<CustomerSortField>` 

Indicates how customers should be sorted.

The default value is `DEFAULT`.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<SortOrder>` 

Indicates whether customers should be sorted in ascending (`ASC`) or
descending (`DESC`) order.

The default value is `ASC`.
    
</dd>
</dl>

<dl>
<dd>

**count:** `Optional<Boolean>` 

Indicates whether to return the total count of customers in the `count` field of the response.

The default value is `false`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.create(request) -> CreateCustomerResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new customer for a business.

You must provide at least one of the following values in your request to this
endpoint:

- `given_name`
- `family_name`
- `company_name`
- `email_address`
- `phone_number`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().create(
    CreateCustomerRequest
        .builder()
        .givenName("Amelia")
        .familyName("Earhart")
        .emailAddress("Amelia.Earhart@example.com")
        .address(
            Address
                .builder()
                .addressLine1("500 Electric Ave")
                .addressLine2("Suite 600")
                .locality("New York")
                .administrativeDistrictLevel1("NY")
                .postalCode("10003")
                .country(Country.US)
                .build()
        )
        .phoneNumber("+1-212-555-4240")
        .referenceId("YOUR_REFERENCE_ID")
        .note("a customer")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

The idempotency key for the request.	For more information, see
[Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**givenName:** `Optional<String>` 

The given name (that is, the first name) associated with the customer profile.

The maximum length for this value is 300 characters.
    
</dd>
</dl>

<dl>
<dd>

**familyName:** `Optional<String>` 

The family name (that is, the last name) associated with the customer profile.

The maximum length for this value is 300 characters.
    
</dd>
</dl>

<dl>
<dd>

**companyName:** `Optional<String>` 

A business name associated with the customer profile.

The maximum length for this value is 500 characters.
    
</dd>
</dl>

<dl>
<dd>

**nickname:** `Optional<String>` 

A nickname for the customer profile.

The maximum length for this value is 100 characters.
    
</dd>
</dl>

<dl>
<dd>

**emailAddress:** `Optional<String>` 

The email address associated with the customer profile.

The maximum length for this value is 254 characters.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<Address>` 

The physical address associated with the customer profile. For maximum length constraints, see 
[Customer addresses](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#address).
The `first_name` and `last_name` fields are ignored if they are present in the request.
    
</dd>
</dl>

<dl>
<dd>

**phoneNumber:** `Optional<String>` 

The phone number associated with the customer profile. The phone number must be valid and can contain
9–16 digits, with an optional `+` prefix and country code. For more information, see
[Customer phone numbers](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#phone-number).
    
</dd>
</dl>

<dl>
<dd>

**referenceId:** `Optional<String>` 

An optional second ID used to associate the customer profile with an
entity in another system.

The maximum length for this value is 100 characters.
    
</dd>
</dl>

<dl>
<dd>

**note:** `Optional<String>` — A custom note associated with the customer profile.
    
</dd>
</dl>

<dl>
<dd>

**birthday:** `Optional<String>` 

The birthday associated with the customer profile, in `YYYY-MM-DD` or `MM-DD` format. For example,
specify `1998-09-21` for September 21, 1998, or `09-21` for September 21. Birthdays are returned in `YYYY-MM-DD`
format, where `YYYY` is the specified birth year or `0000` if a birth year is not specified.
    
</dd>
</dl>

<dl>
<dd>

**taxIds:** `Optional<CustomerTaxIds>` 

The tax ID associated with the customer profile. This field is available only for customers of sellers
in EU countries or the United Kingdom. For more information,
see [Customer tax IDs](https://developer.squareup.com/docs/customers-api/what-it-does#customer-tax-ids).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.batchCreate(request) -> BulkCreateCustomersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates multiple [customer profiles](entity:Customer) for a business.

This endpoint takes a map of individual create requests and returns a map of responses.

You must provide at least one of the following values in each create request:

- `given_name`
- `family_name`
- `company_name`
- `email_address`
- `phone_number`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().batchCreate(
    BulkCreateCustomersRequest
        .builder()
        .customers(
            new HashMap<String, BulkCreateCustomerData>() {{
                put("8bb76c4f-e35d-4c5b-90de-1194cd9179f0", BulkCreateCustomerData
                    .builder()
                    .givenName(Optional.of("Amelia"))
                    .familyName(Optional.of("Earhart"))
                    .emailAddress(Optional.of("Amelia.Earhart@example.com"))
                    .address(
                        Optional.of(
                            Address
                                .builder()
                                .addressLine1(Optional.of("500 Electric Ave"))
                                .addressLine2(Optional.of("Suite 600"))
                                .locality(Optional.of("New York"))
                                .administrativeDistrictLevel1(Optional.of("NY"))
                                .postalCode(Optional.of("10003"))
                                .country(Optional.of(Country.US))
                                .build()
                        )
                    )
                    .phoneNumber(Optional.of("+1-212-555-4240"))
                    .referenceId(Optional.of("YOUR_REFERENCE_ID"))
                    .note(Optional.of("a customer"))
                    .build());
                put("d1689f23-b25d-4932-b2f0-aed00f5e2029", BulkCreateCustomerData
                    .builder()
                    .givenName(Optional.of("Marie"))
                    .familyName(Optional.of("Curie"))
                    .emailAddress(Optional.of("Marie.Curie@example.com"))
                    .address(
                        Optional.of(
                            Address
                                .builder()
                                .addressLine1(Optional.of("500 Electric Ave"))
                                .addressLine2(Optional.of("Suite 601"))
                                .locality(Optional.of("New York"))
                                .administrativeDistrictLevel1(Optional.of("NY"))
                                .postalCode(Optional.of("10003"))
                                .country(Optional.of(Country.US))
                                .build()
                        )
                    )
                    .phoneNumber(Optional.of("+1-212-444-4240"))
                    .referenceId(Optional.of("YOUR_REFERENCE_ID"))
                    .note(Optional.of("another customer"))
                    .build());
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customers:** `Map<String, BulkCreateCustomerData>` 

A map of 1 to 100 individual create requests, represented by `idempotency key: { customer data }`
key-value pairs.

Each key is an [idempotency key](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency)
that uniquely identifies the create request. Each value contains the customer data used to create the
customer profile.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.bulkDeleteCustomers(request) -> BulkDeleteCustomersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes multiple customer profiles.

The endpoint takes a list of customer IDs and returns a map of responses.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().bulkDeleteCustomers(
    BulkDeleteCustomersRequest
        .builder()
        .customerIds(
            new ArrayList<String>(
                Arrays.asList("8DDA5NZVBZFGAX0V3HPF81HHE0", "N18CPRVXR5214XPBBA6BZQWF3C", "2GYD7WNXF7BJZW1PMGNXZ3Y8M8")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerIds:** `List<String>` — The IDs of the [customer profiles](entity:Customer) to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.bulkRetrieveCustomers(request) -> BulkRetrieveCustomersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves multiple customer profiles.

This endpoint takes a list of customer IDs and returns a map of responses.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().bulkRetrieveCustomers(
    BulkRetrieveCustomersRequest
        .builder()
        .customerIds(
            new ArrayList<String>(
                Arrays.asList("8DDA5NZVBZFGAX0V3HPF81HHE0", "N18CPRVXR5214XPBBA6BZQWF3C", "2GYD7WNXF7BJZW1PMGNXZ3Y8M8")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerIds:** `List<String>` — The IDs of the [customer profiles](entity:Customer) to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.bulkUpdateCustomers(request) -> BulkUpdateCustomersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates multiple customer profiles.

This endpoint takes a map of individual update requests and returns a map of responses.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().bulkUpdateCustomers(
    BulkUpdateCustomersRequest
        .builder()
        .customers(
            new HashMap<String, BulkUpdateCustomerData>() {{
                put("8DDA5NZVBZFGAX0V3HPF81HHE0", BulkUpdateCustomerData
                    .builder()
                    .emailAddress(Optional.of("New.Amelia.Earhart@example.com"))
                    .note(Optional.of("updated customer note"))
                    .version(Optional.of(2L))
                    .build());
                put("N18CPRVXR5214XPBBA6BZQWF3C", BulkUpdateCustomerData
                    .builder()
                    .givenName(Optional.of("Marie"))
                    .familyName(Optional.of("Curie"))
                    .version(Optional.of(0L))
                    .build());
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customers:** `Map<String, BulkUpdateCustomerData>` 

A map of 1 to 100 individual update requests, represented by `customer ID: { customer data }`
key-value pairs.

Each key is the ID of the [customer profile](entity:Customer) to update. To update a customer profile
that was created by merging existing profiles, provide the ID of the newly created profile.

Each value contains the updated customer data. Only new or changed fields are required. To add or
update a field, specify the new value. To remove a field, specify `null`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.search(request) -> SearchCustomersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches the customer profiles associated with a Square account using one or more supported query filters.

Calling `SearchCustomers` without any explicit query filter returns all
customer profiles ordered alphabetically based on `given_name` and
`family_name`.

Under normal operating conditions, newly created or updated customer profiles become available
for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
profiles can take closer to one minute or longer, especially during network incidents and outages.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().search(
    SearchCustomersRequest
        .builder()
        .limit(2L)
        .query(
            CustomerQuery
                .builder()
                .filter(
                    CustomerFilter
                        .builder()
                        .creationSource(
                            CustomerCreationSourceFilter
                                .builder()
                                .values(
                                    new ArrayList<CustomerCreationSource>(
                                        Arrays.asList(CustomerCreationSource.THIRD_PARTY)
                                    )
                                )
                                .rule(CustomerInclusionExclusion.INCLUDE)
                                .build()
                        )
                        .createdAt(
                            TimeRange
                                .builder()
                                .startAt("2018-01-01T00:00:00-00:00")
                                .endAt("2018-02-01T00:00:00-00:00")
                                .build()
                        )
                        .emailAddress(
                            CustomerTextFilter
                                .builder()
                                .fuzzy("example.com")
                                .build()
                        )
                        .groupIds(
                            FilterValue
                                .builder()
                                .all(
                                    new ArrayList<String>(
                                        Arrays.asList("545AXB44B4XXWMVQ4W8SBT3HHF")
                                    )
                                )
                                .build()
                        )
                        .build()
                )
                .sort(
                    CustomerSort
                        .builder()
                        .field(CustomerSortField.CREATED_AT)
                        .order(SortOrder.ASC)
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

Include the pagination cursor in subsequent calls to this endpoint to retrieve
the next set of results associated with the original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to return in a single page. This limit is advisory. The response might contain more or fewer results.
If the specified limit is invalid, Square returns a `400 VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 100.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<CustomerQuery>` 

The filtering and sorting criteria for the search request. If a query is not specified,
Square returns all customer profiles ordered alphabetically by `given_name` and `family_name`.
    
</dd>
</dl>

<dl>
<dd>

**count:** `Optional<Boolean>` 

Indicates whether to return the total count of matching customers in the `count` field of the response.

The default value is `false`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.get(customerId) -> GetCustomerResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns details for a single customer.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().get(
    GetCustomersRequest
        .builder()
        .customerId("customer_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerId:** `String` — The ID of the customer to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.update(customerId, request) -> UpdateCustomerResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a customer profile. This endpoint supports sparse updates, so only new or changed fields are required in the request.
To add or update a field, specify the new value. To remove a field, specify `null`.

To update a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().update(
    UpdateCustomerRequest
        .builder()
        .customerId("customer_id")
        .emailAddress("New.Amelia.Earhart@example.com")
        .note("updated customer note")
        .version(2L)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerId:** `String` — The ID of the customer to update.
    
</dd>
</dl>

<dl>
<dd>

**givenName:** `Optional<String>` 

The given name (that is, the first name) associated with the customer profile.

The maximum length for this value is 300 characters.
    
</dd>
</dl>

<dl>
<dd>

**familyName:** `Optional<String>` 

The family name (that is, the last name) associated with the customer profile.

The maximum length for this value is 300 characters.
    
</dd>
</dl>

<dl>
<dd>

**companyName:** `Optional<String>` 

A business name associated with the customer profile.

The maximum length for this value is 500 characters.
    
</dd>
</dl>

<dl>
<dd>

**nickname:** `Optional<String>` 

A nickname for the customer profile.

The maximum length for this value is 100 characters.
    
</dd>
</dl>

<dl>
<dd>

**emailAddress:** `Optional<String>` 

The email address associated with the customer profile.

The maximum length for this value is 254 characters.
    
</dd>
</dl>

<dl>
<dd>

**address:** `Optional<Address>` 

The physical address associated with the customer profile. Only new or changed fields are required in the request.

For maximum length constraints, see [Customer addresses](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#address).
The `first_name` and `last_name` fields are ignored if they are present in the request.
    
</dd>
</dl>

<dl>
<dd>

**phoneNumber:** `Optional<String>` 

The phone number associated with the customer profile. The phone number must be valid and can contain
9–16 digits, with an optional `+` prefix and country code. For more information, see
[Customer phone numbers](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#phone-number).
    
</dd>
</dl>

<dl>
<dd>

**referenceId:** `Optional<String>` 

An optional second ID used to associate the customer profile with an
entity in another system.

The maximum length for this value is 100 characters.
    
</dd>
</dl>

<dl>
<dd>

**note:** `Optional<String>` — A custom note associated with the customer profile.
    
</dd>
</dl>

<dl>
<dd>

**birthday:** `Optional<String>` 

The birthday associated with the customer profile, in `YYYY-MM-DD` or `MM-DD` format. For example,
specify `1998-09-21` for September 21, 1998, or `09-21` for September 21. Birthdays are returned in `YYYY-MM-DD`
format, where `YYYY` is the specified birth year or `0000` if a birth year is not specified.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<Integer>` 

The current version of the customer profile.

As a best practice, you should include this field to enable [optimistic concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency) control. For more information, see [Update a customer profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#update-a-customer-profile).
    
</dd>
</dl>

<dl>
<dd>

**taxIds:** `Optional<CustomerTaxIds>` 

The tax ID associated with the customer profile. This field is available only for customers of sellers
in EU countries or the United Kingdom. For more information,
see [Customer tax IDs](https://developer.squareup.com/docs/customers-api/what-it-does#customer-tax-ids).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.customers.delete(customerId) -> DeleteCustomerResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a customer profile from a business.

To delete a customer profile that was created by merging existing profiles, you must use the ID of the newly created profile.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.customers().delete(
    DeleteCustomersRequest
        .builder()
        .customerId("customer_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**customerId:** `String` — The ID of the customer to delete.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<Integer>` 

The current version of the customer profile.

As a best practice, you should include this parameter to enable [optimistic concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency) control.  For more information, see [Delete a customer profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Devices
<details><summary><code>client.devices.list() -> ListDevicesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List devices associated with the merchant. Currently, only Terminal API
devices are supported.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.devices().list(
    ListDevicesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.
See [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination) for more information.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<SortOrder>` 

The order in which results are listed.
- `ASC` - Oldest to newest.
- `DESC` - Newest to oldest (default).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The number of results to return in a single page.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` — If present, only returns devices at the target location.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.devices.get(deviceId) -> GetDeviceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves Device with the associated `device_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.devices().get(
    GetDevicesRequest
        .builder()
        .deviceId("device_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**deviceId:** `String` — The unique ID for the desired `Device`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Disputes
<details><summary><code>client.disputes.list() -> ListDisputesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of disputes associated with a particular account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.disputes().list(
    ListDisputesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.
For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**states:** `Optional<DisputeState>` — The dispute states used to filter the result. If not specified, the endpoint returns all disputes.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 

The ID of the location for which to return a list of disputes.
If not specified, the endpoint returns disputes associated with all locations.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.disputes.get(disputeId) -> GetDisputeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns details about a specific dispute.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.disputes().get(
    GetDisputesRequest
        .builder()
        .disputeId("dispute_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**disputeId:** `String` — The ID of the dispute you want more details about.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.disputes.accept(disputeId) -> AcceptDisputeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Accepts the loss on a dispute. Square returns the disputed amount to the cardholder and
updates the dispute state to ACCEPTED.

Square debits the disputed amount from the seller’s Square account. If the Square account
does not have sufficient funds, Square debits the associated bank account.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.disputes().accept(
    AcceptDisputesRequest
        .builder()
        .disputeId("dispute_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**disputeId:** `String` — The ID of the dispute you want to accept.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.disputes.createEvidenceFile(disputeId, request) -> CreateDisputeEvidenceFileResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Uploads a file to use as evidence in a dispute challenge. The endpoint accepts HTTP
multipart/form-data file uploads in HEIC, HEIF, JPEG, PDF, PNG, and TIFF formats.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.disputes().createEvidenceFile(
    CreateEvidenceFileDisputesRequest
        .builder()
        .disputeId("dispute_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**disputeId:** `String` — The ID of the dispute for which you want to upload evidence.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.disputes.createEvidenceText(disputeId, request) -> CreateDisputeEvidenceTextResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Uploads text to use as evidence for a dispute challenge.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.disputes().createEvidenceText(
    CreateDisputeEvidenceTextRequest
        .builder()
        .disputeId("dispute_id")
        .idempotencyKey("ed3ee3933d946f1514d505d173c82648")
        .evidenceText("1Z8888888888888888")
        .evidenceType(DisputeEvidenceType.TRACKING_NUMBER)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**disputeId:** `String` — The ID of the dispute for which you want to upload evidence.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` — A unique key identifying the request. For more information, see [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**evidenceType:** `Optional<DisputeEvidenceType>` 

The type of evidence you are uploading.
See [DisputeEvidenceType](#type-disputeevidencetype) for possible values
    
</dd>
</dl>

<dl>
<dd>

**evidenceText:** `String` — The evidence string.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.disputes.submitEvidence(disputeId) -> SubmitEvidenceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Submits evidence to the cardholder's bank.

The evidence submitted by this endpoint includes evidence uploaded
using the [CreateDisputeEvidenceFile](api-endpoint:Disputes-CreateDisputeEvidenceFile) and
[CreateDisputeEvidenceText](api-endpoint:Disputes-CreateDisputeEvidenceText) endpoints and
evidence automatically provided by Square, when available. Evidence cannot be removed from
a dispute after submission.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.disputes().submitEvidence(
    SubmitEvidenceDisputesRequest
        .builder()
        .disputeId("dispute_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**disputeId:** `String` — The ID of the dispute for which you want to submit evidence.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Employees
<details><summary><code>client.employees.list() -> ListEmployeesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.employees().list(
    ListEmployeesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `Optional<String>` — 
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<EmployeeStatus>` — Specifies the EmployeeStatus to filter the employee by.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The number of employees to be returned on each page.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` — The token required to retrieve the specified page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.employees.get(id) -> GetEmployeeResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.employees().get(
    GetEmployeesRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — UUID for the employee that was requested.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Events
<details><summary><code>client.events.searchEvents(request) -> SearchEventsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Search for Square API events that occur within a 28-day timeframe.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().searchEvents(
    SearchEventsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint. Provide this cursor to retrieve the next set of events for your original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of events to return in a single page. The response might contain fewer events. The default value is 100, which is also the maximum allowed value.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).

Default: 100
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<SearchEventsQuery>` — The filtering and sorting criteria for the search request. To retrieve additional pages using a cursor, you must use the original query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.disableEvents() -> DisableEventsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Disables events to prevent them from being searchable.
All events are disabled by default. You must enable events to make them searchable.
Disabling events for a specific time period prevents them from being searchable, even if you re-enable them later.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().disableEvents();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.enableEvents() -> EnableEventsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Enables events to make them searchable. Only events that occur while in the enabled state are searchable.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().enableEvents();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.events.listEventTypes() -> ListEventTypesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all event types that you can subscribe to as webhooks or query using the Events API.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.events().listEventTypes(
    ListEventTypesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**apiVersion:** `Optional<String>` — The API version for which to list event types. Setting this field overrides the default version used by the application.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## GiftCards
<details><summary><code>client.giftCards.list() -> ListGiftCardsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all gift cards. You can specify optional filters to retrieve 
a subset of the gift cards. Results are sorted by `created_at` in ascending order.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().list(
    ListGiftCardsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**type:** `Optional<String>` 

If a [type](entity:GiftCardType) is provided, the endpoint returns gift cards of the specified type.
Otherwise, the endpoint returns gift cards of all types.
    
</dd>
</dl>

<dl>
<dd>

**state:** `Optional<String>` 

If a [state](entity:GiftCardStatus) is provided, the endpoint returns the gift cards in the specified state.
Otherwise, the endpoint returns the gift cards of all states.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

If a limit is provided, the endpoint returns only the specified number of results per page.
The maximum value is 200. The default value is 30.
For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.
If a cursor is not provided, the endpoint returns the first page of the results. 
For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `Optional<String>` — If a customer ID is provided, the endpoint returns only the gift cards linked to the specified customer.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.giftCards.create(request) -> CreateGiftCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a digital gift card or registers a physical (plastic) gift card. The resulting gift card
has a `PENDING` state. To activate a gift card so that it can be redeemed for purchases, call
[CreateGiftCardActivity](api-endpoint:GiftCardActivities-CreateGiftCardActivity) and create an `ACTIVATE`
activity with the initial balance. Alternatively, you can use [RefundPayment](api-endpoint:Refunds-RefundPayment)
to refund a payment to the new gift card.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().create(
    CreateGiftCardRequest
        .builder()
        .idempotencyKey("NC9Tm69EjbjtConu")
        .locationId("81FN9BNFZTKS4")
        .giftCard(
            GiftCard
                .builder()
                .type(GiftCardType.DIGITAL)
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique identifier for this request, used to ensure idempotency. For more information, 
see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `String` 

The ID of the [location](entity:Location) where the gift card should be registered for 
reporting purposes. Gift cards can be redeemed at any of the seller's locations.
    
</dd>
</dl>

<dl>
<dd>

**giftCard:** `GiftCard` 

The gift card to create. The `type` field is required for this request. The `gan_source` 
and `gan` fields are included as follows: 

To direct Square to generate a 16-digit GAN, omit `gan_source` and `gan`.

To provide a custom GAN, include `gan_source` and `gan`.
- For `gan_source`, specify `OTHER`. 
- For `gan`, provide a custom GAN containing 8 to 20 alphanumeric characters. The GAN must be 
unique for the seller and cannot start with the same bank identification number (BIN) as major 
credit cards. Do not use GANs that are easy to guess (such as 12345678) because they greatly 
increase the risk of fraud. It is the responsibility of the developer to ensure the security 
of their custom GANs. For more information, see 
[Custom GANs](https://developer.squareup.com/docs/gift-cards/using-gift-cards-api#custom-gans). 

To register an unused, physical gift card that the seller previously ordered from Square, 
include `gan` and provide the GAN that is printed on the gift card.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.giftCards.getFromGan(request) -> GetGiftCardFromGanResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a gift card using the gift card account number (GAN).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().getFromGan(
    GetGiftCardFromGanRequest
        .builder()
        .gan("7783320001001635")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**gan:** `String` 

The gift card account number (GAN) of the gift card to retrieve.
The maximum length of a GAN is 255 digits to account for third-party GANs that have been imported.
Square-issued gift cards have 16-digit GANs.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.giftCards.getFromNonce(request) -> GetGiftCardFromNonceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a gift card using a secure payment token that represents the gift card.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().getFromNonce(
    GetGiftCardFromNonceRequest
        .builder()
        .nonce("cnon:7783322135245171")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**nonce:** `String` 

The payment token of the gift card to retrieve. Payment tokens are generated by the 
Web Payments SDK or In-App Payments SDK.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.giftCards.linkCustomer(giftCardId, request) -> LinkCustomerToGiftCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Links a customer to a gift card, which is also referred to as adding a card on file.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().linkCustomer(
    LinkCustomerToGiftCardRequest
        .builder()
        .giftCardId("gift_card_id")
        .customerId("GKY0FZ3V717AH8Q2D821PNT2ZW")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**giftCardId:** `String` — The ID of the gift card to be linked.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `String` — The ID of the customer to link to the gift card.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.giftCards.unlinkCustomer(giftCardId, request) -> UnlinkCustomerFromGiftCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Unlinks a customer from a gift card, which is also referred to as removing a card on file.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().unlinkCustomer(
    UnlinkCustomerFromGiftCardRequest
        .builder()
        .giftCardId("gift_card_id")
        .customerId("GKY0FZ3V717AH8Q2D821PNT2ZW")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**giftCardId:** `String` — The ID of the gift card to be unlinked.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `String` — The ID of the customer to unlink from the gift card.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.giftCards.get(id) -> GetGiftCardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a gift card using the gift card ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.giftCards().get(
    GetGiftCardsRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the gift card to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Inventory
<details><summary><code>client.inventory.deprecatedGetAdjustment(adjustmentId) -> GetInventoryAdjustmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deprecated version of [RetrieveInventoryAdjustment](api-endpoint:Inventory-RetrieveInventoryAdjustment) after the endpoint URL
is updated to conform to the standard convention.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().deprecatedGetAdjustment(
    DeprecatedGetAdjustmentInventoryRequest
        .builder()
        .adjustmentId("adjustment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**adjustmentId:** `String` — ID of the [InventoryAdjustment](entity:InventoryAdjustment) to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.getAdjustment(adjustmentId) -> GetInventoryAdjustmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the [InventoryAdjustment](entity:InventoryAdjustment) object
with the provided `adjustment_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().getAdjustment(
    GetAdjustmentInventoryRequest
        .builder()
        .adjustmentId("adjustment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**adjustmentId:** `String` — ID of the [InventoryAdjustment](entity:InventoryAdjustment) to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.deprecatedBatchChange(request) -> BatchChangeInventoryResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deprecated version of [BatchChangeInventory](api-endpoint:Inventory-BatchChangeInventory) after the endpoint URL
is updated to conform to the standard convention.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().deprecatedBatchChange(
    BatchChangeInventoryRequest
        .builder()
        .idempotencyKey("8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe")
        .changes(
            new ArrayList<InventoryChange>(
                Arrays.asList(
                    InventoryChange
                        .builder()
                        .type(InventoryChangeType.PHYSICAL_COUNT)
                        .physicalCount(
                            InventoryPhysicalCount
                                .builder()
                                .referenceId("1536bfbf-efed-48bf-b17d-a197141b2a92")
                                .catalogObjectId("W62UWFY35CWMYGVWK6TWJDNI")
                                .state(InventoryState.IN_STOCK)
                                .locationId("C6W5YS5QM06F5")
                                .quantity("53")
                                .teamMemberId("LRK57NSQ5X7PUD05")
                                .occurredAt("2016-11-16T22:25:24.878Z")
                                .build()
                        )
                        .build()
                )
            )
        )
        .ignoreUnchangedCounts(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `BatchChangeInventoryRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.deprecatedBatchGetChanges(request) -> BatchGetInventoryChangesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deprecated version of [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges) after the endpoint URL
is updated to conform to the standard convention.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().deprecatedBatchGetChanges(
    BatchRetrieveInventoryChangesRequest
        .builder()
        .catalogObjectIds(
            new ArrayList<String>(
                Arrays.asList("W62UWFY35CWMYGVWK6TWJDNI")
            )
        )
        .locationIds(
            new ArrayList<String>(
                Arrays.asList("C6W5YS5QM06F5")
            )
        )
        .types(
            new ArrayList<InventoryChangeType>(
                Arrays.asList(InventoryChangeType.PHYSICAL_COUNT)
            )
        )
        .states(
            new ArrayList<InventoryState>(
                Arrays.asList(InventoryState.IN_STOCK)
            )
        )
        .updatedAfter("2016-11-01T00:00:00.000Z")
        .updatedBefore("2016-12-01T00:00:00.000Z")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `BatchRetrieveInventoryChangesRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.deprecatedBatchGetCounts(request) -> BatchGetInventoryCountsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deprecated version of [BatchRetrieveInventoryCounts](api-endpoint:Inventory-BatchRetrieveInventoryCounts) after the endpoint URL
is updated to conform to the standard convention.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().deprecatedBatchGetCounts(
    BatchGetInventoryCountsRequest
        .builder()
        .catalogObjectIds(
            new ArrayList<String>(
                Arrays.asList("W62UWFY35CWMYGVWK6TWJDNI")
            )
        )
        .locationIds(
            new ArrayList<String>(
                Arrays.asList("59TNP9SA8VGDA")
            )
        )
        .updatedAfter("2016-11-16T00:00:00.000Z")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `BatchGetInventoryCountsRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.batchCreateChanges(request) -> BatchChangeInventoryResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Applies adjustments and counts to the provided item quantities.

On success: returns the current calculated counts for all objects
referenced in the request.
On failure: returns a list of related errors.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().batchCreateChanges(
    BatchChangeInventoryRequest
        .builder()
        .idempotencyKey("8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe")
        .changes(
            new ArrayList<InventoryChange>(
                Arrays.asList(
                    InventoryChange
                        .builder()
                        .type(InventoryChangeType.PHYSICAL_COUNT)
                        .physicalCount(
                            InventoryPhysicalCount
                                .builder()
                                .referenceId("1536bfbf-efed-48bf-b17d-a197141b2a92")
                                .catalogObjectId("W62UWFY35CWMYGVWK6TWJDNI")
                                .state(InventoryState.IN_STOCK)
                                .locationId("C6W5YS5QM06F5")
                                .quantity("53")
                                .teamMemberId("LRK57NSQ5X7PUD05")
                                .occurredAt("2016-11-16T22:25:24.878Z")
                                .build()
                        )
                        .build()
                )
            )
        )
        .ignoreUnchangedCounts(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `BatchChangeInventoryRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.batchGetChanges(request) -> BatchGetInventoryChangesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns historical physical counts and adjustments based on the
provided filter criteria.

Results are paginated and sorted in ascending order according their
`occurred_at` timestamp (oldest first).

BatchRetrieveInventoryChanges is a catch-all query endpoint for queries
that cannot be handled by other, simpler endpoints.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().batchGetChanges(
    BatchRetrieveInventoryChangesRequest
        .builder()
        .catalogObjectIds(
            new ArrayList<String>(
                Arrays.asList("W62UWFY35CWMYGVWK6TWJDNI")
            )
        )
        .locationIds(
            new ArrayList<String>(
                Arrays.asList("C6W5YS5QM06F5")
            )
        )
        .types(
            new ArrayList<InventoryChangeType>(
                Arrays.asList(InventoryChangeType.PHYSICAL_COUNT)
            )
        )
        .states(
            new ArrayList<InventoryState>(
                Arrays.asList(InventoryState.IN_STOCK)
            )
        )
        .updatedAfter("2016-11-01T00:00:00.000Z")
        .updatedBefore("2016-12-01T00:00:00.000Z")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `BatchRetrieveInventoryChangesRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.batchGetCounts(request) -> BatchGetInventoryCountsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns current counts for the provided
[CatalogObject](entity:CatalogObject)s at the requested
[Location](entity:Location)s.

Results are paginated and sorted in descending order according to their
`calculated_at` timestamp (newest first).

When `updated_after` is specified, only counts that have changed since that
time (based on the server timestamp for the most recent change) are
returned. This allows clients to perform a "sync" operation, for example
in response to receiving a Webhook notification.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().batchGetCounts(
    BatchGetInventoryCountsRequest
        .builder()
        .catalogObjectIds(
            new ArrayList<String>(
                Arrays.asList("W62UWFY35CWMYGVWK6TWJDNI")
            )
        )
        .locationIds(
            new ArrayList<String>(
                Arrays.asList("59TNP9SA8VGDA")
            )
        )
        .updatedAfter("2016-11-16T00:00:00.000Z")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `BatchGetInventoryCountsRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.deprecatedGetPhysicalCount(physicalCountId) -> GetInventoryPhysicalCountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deprecated version of [RetrieveInventoryPhysicalCount](api-endpoint:Inventory-RetrieveInventoryPhysicalCount) after the endpoint URL
is updated to conform to the standard convention.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().deprecatedGetPhysicalCount(
    DeprecatedGetPhysicalCountInventoryRequest
        .builder()
        .physicalCountId("physical_count_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**physicalCountId:** `String` 

ID of the
[InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.getPhysicalCount(physicalCountId) -> GetInventoryPhysicalCountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the [InventoryPhysicalCount](entity:InventoryPhysicalCount)
object with the provided `physical_count_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().getPhysicalCount(
    GetPhysicalCountInventoryRequest
        .builder()
        .physicalCountId("physical_count_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**physicalCountId:** `String` 

ID of the
[InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.getTransfer(transferId) -> GetInventoryTransferResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns the [InventoryTransfer](entity:InventoryTransfer) object
with the provided `transfer_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().getTransfer(
    GetTransferInventoryRequest
        .builder()
        .transferId("transfer_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**transferId:** `String` — ID of the [InventoryTransfer](entity:InventoryTransfer) to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.get(catalogObjectId) -> GetInventoryCountResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the current calculated stock count for a given
[CatalogObject](entity:CatalogObject) at a given set of
[Location](entity:Location)s. Responses are paginated and unsorted.
For more sophisticated queries, use a batch endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().get(
    GetInventoryRequest
        .builder()
        .catalogObjectId("catalog_object_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**catalogObjectId:** `String` — ID of the [CatalogObject](entity:CatalogObject) to retrieve.
    
</dd>
</dl>

<dl>
<dd>

**locationIds:** `Optional<String>` 

The [Location](entity:Location) IDs to look up as a comma-separated
list. An empty list queries all locations.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this to retrieve the next set of results for the original query.

See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.inventory.changes(catalogObjectId) -> GetInventoryChangesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a set of physical counts and inventory adjustments for the
provided [CatalogObject](entity:CatalogObject) at the requested
[Location](entity:Location)s.

You can achieve the same result by calling [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges)
and having the `catalog_object_ids` list contain a single element of the `CatalogObject` ID.

Results are paginated and sorted in descending order according to their
`occurred_at` timestamp (newest first).

There are no limits on how far back the caller can page. This endpoint can be
used to display recent changes for a specific item. For more
sophisticated queries, use a batch endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.inventory().changes(
    ChangesInventoryRequest
        .builder()
        .catalogObjectId("catalog_object_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**catalogObjectId:** `String` — ID of the [CatalogObject](entity:CatalogObject) to retrieve.
    
</dd>
</dl>

<dl>
<dd>

**locationIds:** `Optional<String>` 

The [Location](entity:Location) IDs to look up as a comma-separated
list. An empty list queries all locations.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this to retrieve the next set of results for the original query.

See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Invoices
<details><summary><code>client.invoices.list() -> ListInvoicesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a list of invoices for a given location. The response 
is paginated. If truncated, the response includes a `cursor` that you    
use in a subsequent request to retrieve the next set of invoices.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().list(
    ListInvoicesRequest
        .builder()
        .locationId("location_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the location for which to list invoices.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint. 
Provide this cursor to retrieve the next set of results for your original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of invoices to return (200 is the maximum `limit`). 
If not provided, the server uses a default limit of 100 invoices.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.create(request) -> CreateInvoiceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a draft [invoice](entity:Invoice) 
for an order created using the Orders API.

A draft invoice remains in your account and no action is taken. 
You must publish the invoice before Square can process it (send it to the customer's email address or charge the customer’s card on file).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().create(
    CreateInvoiceRequest
        .builder()
        .invoice(
            Invoice
                .builder()
                .locationId("ES0RJRZYEC39A")
                .orderId("CAISENgvlJ6jLWAzERDzjyHVybY")
                .primaryRecipient(
                    InvoiceRecipient
                        .builder()
                        .customerId("JDKYHBWT1D4F8MFH63DBMEN8Y4")
                        .build()
                )
                .paymentRequests(
                    new ArrayList<InvoicePaymentRequest>(
                        Arrays.asList(
                            InvoicePaymentRequest
                                .builder()
                                .requestType(InvoiceRequestType.BALANCE)
                                .dueDate("2030-01-24")
                                .tippingEnabled(true)
                                .automaticPaymentSource(InvoiceAutomaticPaymentSource.NONE)
                                .reminders(
                                    new ArrayList<InvoicePaymentReminder>(
                                        Arrays.asList(
                                            InvoicePaymentReminder
                                                .builder()
                                                .relativeScheduledDays(-1)
                                                .message("Your invoice is due tomorrow")
                                                .build()
                                        )
                                    )
                                )
                                .build()
                        )
                    )
                )
                .deliveryMethod(InvoiceDeliveryMethod.EMAIL)
                .invoiceNumber("inv-100")
                .title("Event Planning Services")
                .description("We appreciate your business!")
                .scheduledAt("2030-01-13T10:00:00Z")
                .acceptedPaymentMethods(
                    InvoiceAcceptedPaymentMethods
                        .builder()
                        .card(true)
                        .squareGiftCard(false)
                        .bankAccount(false)
                        .buyNowPayLater(false)
                        .cashAppPay(false)
                        .build()
                )
                .customFields(
                    new ArrayList<InvoiceCustomField>(
                        Arrays.asList(
                            InvoiceCustomField
                                .builder()
                                .label("Event Reference Number")
                                .value("Ref. #1234")
                                .placement(InvoiceCustomFieldPlacement.ABOVE_LINE_ITEMS)
                                .build(),
                            InvoiceCustomField
                                .builder()
                                .label("Terms of Service")
                                .value("The terms of service are...")
                                .placement(InvoiceCustomFieldPlacement.BELOW_LINE_ITEMS)
                                .build()
                        )
                    )
                )
                .saleOrServiceDate("2030-01-24")
                .storePaymentMethodEnabled(false)
                .build()
        )
        .idempotencyKey("ce3748f9-5fc1-4762-aa12-aae5e843f1f4")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoice:** `Invoice` — The invoice to create.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A unique string that identifies the `CreateInvoice` request. If you do not 
provide `idempotency_key` (or provide an empty string as the value), the endpoint 
treats each request as independent.

For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.search(request) -> SearchInvoicesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for invoices from a location specified in 
the filter. You can optionally specify customers in the filter for whom to 
retrieve invoices. In the current implementation, you can only specify one location and 
optionally one customer.

The response is paginated. If truncated, the response includes a `cursor` 
that you use in a subsequent request to retrieve the next set of invoices.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().search(
    SearchInvoicesRequest
        .builder()
        .query(
            InvoiceQuery
                .builder()
                .filter(
                    InvoiceFilter
                        .builder()
                        .locationIds(
                            new ArrayList<String>(
                                Arrays.asList("ES0RJRZYEC39A")
                            )
                        )
                        .customerIds(
                            new ArrayList<String>(
                                Arrays.asList("JDKYHBWT1D4F8MFH63DBMEN8Y4")
                            )
                        )
                        .build()
                )
                .sort(
                    InvoiceSort
                        .builder()
                        .field("INVOICE_SORT_DATE")
                        .order(SortOrder.DESC)
                        .build()
                )
                .build()
        )
        .limit(100)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**query:** `InvoiceQuery` — Describes the query criteria for searching invoices.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of invoices to return (200 is the maximum `limit`). 
If not provided, the server uses a default limit of 100 invoices.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint. 
Provide this cursor to retrieve the next set of results for your original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.get(invoiceId) -> GetInvoiceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves an invoice by invoice ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().get(
    GetInvoicesRequest
        .builder()
        .invoiceId("invoice_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the invoice to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.update(invoiceId, request) -> UpdateInvoiceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an invoice. This endpoint supports sparse updates, so you only need
to specify the fields you want to change along with the required `version` field.
Some restrictions apply to updating invoices. For example, you cannot change the
`order_id` or `location_id` field.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().update(
    UpdateInvoiceRequest
        .builder()
        .invoiceId("invoice_id")
        .invoice(
            Invoice
                .builder()
                .version(1)
                .paymentRequests(
                    new ArrayList<InvoicePaymentRequest>(
                        Arrays.asList(
                            InvoicePaymentRequest
                                .builder()
                                .uid("2da7964f-f3d2-4f43-81e8-5aa220bf3355")
                                .tippingEnabled(false)
                                .build()
                        )
                    )
                )
                .build()
        )
        .idempotencyKey("4ee82288-0910-499e-ab4c-5d0071dad1be")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the invoice to update.
    
</dd>
</dl>

<dl>
<dd>

**invoice:** `Invoice` 

The invoice fields to add, change, or clear. Fields can be cleared using
null values or the `remove` field (for individual payment requests or reminders).
The current invoice `version` is also required. For more information, including requirements,
limitations, and more examples, see [Update an Invoice](https://developer.squareup.com/docs/invoices-api/update-invoices).
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A unique string that identifies the `UpdateInvoice` request. If you do not
provide `idempotency_key` (or provide an empty string as the value), the endpoint
treats each request as independent.

For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**fieldsToClear:** `Optional<List<String>>` 

The list of fields to clear. Although this field is currently supported, we
recommend using null values or the `remove` field when possible. For examples, see
[Update an Invoice](https://developer.squareup.com/docs/invoices-api/update-invoices).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.delete(invoiceId) -> DeleteInvoiceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes the specified invoice. When an invoice is deleted, the 
associated order status changes to CANCELED. You can only delete a draft 
invoice (you cannot delete a published invoice, including one that is scheduled for processing).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().delete(
    DeleteInvoicesRequest
        .builder()
        .invoiceId("invoice_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the invoice to delete.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<Integer>` 

The version of the [invoice](entity:Invoice) to delete.
If you do not know the version, you can call [GetInvoice](api-endpoint:Invoices-GetInvoice) or 
[ListInvoices](api-endpoint:Invoices-ListInvoices).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.createInvoiceAttachment(invoiceId, request) -> CreateInvoiceAttachmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Uploads a file and attaches it to an invoice. This endpoint accepts HTTP multipart/form-data file uploads
with a JSON `request` part and a `file` part. The `file` part must be a `readable stream` that contains a file
in a supported format: GIF, JPEG, PNG, TIFF, BMP, or PDF.

Invoices can have up to 10 attachments with a total file size of 25 MB. Attachments can be added only to invoices
in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.

__NOTE:__ When testing in the Sandbox environment, the total file size is limited to 1 KB.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().createInvoiceAttachment(
    CreateInvoiceAttachmentRequest
        .builder()
        .invoiceId("invoice_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the [invoice](entity:Invoice) to attach the file to.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.deleteInvoiceAttachment(invoiceId, attachmentId) -> DeleteInvoiceAttachmentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Removes an attachment from an invoice and permanently deletes the file. Attachments can be removed only
from invoices in the `DRAFT`, `SCHEDULED`, `UNPAID`, or `PARTIALLY_PAID` state.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().deleteInvoiceAttachment(
    DeleteInvoiceAttachmentRequest
        .builder()
        .invoiceId("invoice_id")
        .attachmentId("attachment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the [invoice](entity:Invoice) to delete the attachment from.
    
</dd>
</dl>

<dl>
<dd>

**attachmentId:** `String` — The ID of the [attachment](entity:InvoiceAttachment) to delete.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.cancel(invoiceId, request) -> CancelInvoiceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Cancels an invoice. The seller cannot collect payments for 
the canceled invoice.

You cannot cancel an invoice in the `DRAFT` state or in a terminal state: `PAID`, `REFUNDED`, `CANCELED`, or `FAILED`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().cancel(
    CancelInvoiceRequest
        .builder()
        .invoiceId("invoice_id")
        .version(0)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the [invoice](entity:Invoice) to cancel.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Integer` 

The version of the [invoice](entity:Invoice) to cancel.
If you do not know the version, you can call 
[GetInvoice](api-endpoint:Invoices-GetInvoice) or [ListInvoices](api-endpoint:Invoices-ListInvoices).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.invoices.publish(invoiceId, request) -> PublishInvoiceResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Publishes the specified draft invoice. 

After an invoice is published, Square 
follows up based on the invoice configuration. For example, Square 
sends the invoice to the customer's email address, charges the customer's card on file, or does 
nothing. Square also makes the invoice available on a Square-hosted invoice page. 

The invoice `status` also changes from `DRAFT` to a status 
based on the invoice configuration. For example, the status changes to `UNPAID` if 
Square emails the invoice or `PARTIALLY_PAID` if Square charges a card on file for a portion of the 
invoice amount.

In addition to the required `ORDERS_WRITE` and `INVOICES_WRITE` permissions, `CUSTOMERS_READ`
and `PAYMENTS_WRITE` are required when publishing invoices configured for card-on-file payments.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.invoices().publish(
    PublishInvoiceRequest
        .builder()
        .invoiceId("invoice_id")
        .version(1)
        .idempotencyKey("32da42d0-1997-41b0-826b-f09464fc2c2e")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**invoiceId:** `String` — The ID of the invoice to publish.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Integer` 

The version of the [invoice](entity:Invoice) to publish.
This must match the current version of the invoice; otherwise, the request is rejected.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A unique string that identifies the `PublishInvoice` request. If you do not 
provide `idempotency_key` (or provide an empty string as the value), the endpoint 
treats each request as independent.

For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Labor
<details><summary><code>client.labor.createScheduledShift(request) -> CreateScheduledShiftResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a scheduled shift by providing draft shift details such as job ID,
team member assignment, and start and end times.

The following `draft_shift_details` fields are required:
- `location_id`
- `job_id`
- `start_at`
- `end_at`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().createScheduledShift(
    CreateScheduledShiftRequest
        .builder()
        .scheduledShift(
            ScheduledShift
                .builder()
                .draftShiftDetails(
                    ScheduledShiftDetails
                        .builder()
                        .teamMemberId("ormj0jJJZ5OZIzxrZYJI")
                        .locationId("PAA1RJZZKXBFG")
                        .jobId("FzbJAtt9qEWncK1BWgVCxQ6M")
                        .startAt("2019-01-25T03:11:00-05:00")
                        .endAt("2019-01-25T13:11:00-05:00")
                        .notes("Dont forget to prep the vegetables")
                        .isDeleted(false)
                        .build()
                )
                .build()
        )
        .idempotencyKey("HIDSNG5KS478L")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A unique identifier for the `CreateScheduledShift` request, used to ensure the
[idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency)
of the operation.
    
</dd>
</dl>

<dl>
<dd>

**scheduledShift:** `ScheduledShift` 

The scheduled shift with `draft_shift_details`.
If needed, call [ListLocations](api-endpoint:Locations-ListLocations) to get location IDs,
[ListJobs](api-endpoint:Team-ListJobs) to get job IDs, and [SearchTeamMembers](api-endpoint:Team-SearchTeamMembers)
to get team member IDs and current job assignments.

The `start_at` and `end_at` timestamps must be provided in the time zone + offset of the
shift location specified in `location_id`. Example for Pacific Standard Time: 2024-10-31T12:30:00-08:00
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.bulkPublishScheduledShifts(request) -> BulkPublishScheduledShiftsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Publishes 1 - 100 scheduled shifts. This endpoint takes a map of individual publish
requests and returns a map of responses. When a scheduled shift is published, Square keeps
the `draft_shift_details` field as is and copies it to the `published_shift_details` field.

The minimum `start_at` and maximum `end_at` timestamps of all shifts in a
`BulkPublishScheduledShifts` request must fall within a two-week period.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().bulkPublishScheduledShifts(
    BulkPublishScheduledShiftsRequest
        .builder()
        .scheduledShifts(
            new HashMap<String, BulkPublishScheduledShiftsData>() {{
                put("key", BulkPublishScheduledShiftsData
                    .builder()
                    .build());
            }}
        )
        .scheduledShiftNotificationAudience(ScheduledShiftNotificationAudience.AFFECTED)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**scheduledShifts:** `Map<String, BulkPublishScheduledShiftsData>` 

A map of 1 to 100 key-value pairs that represent individual publish requests.

- Each key is the ID of a scheduled shift you want to publish.
- Each value is a `BulkPublishScheduledShiftsData` object that contains the
`version` field or is an empty object.
    
</dd>
</dl>

<dl>
<dd>

**scheduledShiftNotificationAudience:** `Optional<ScheduledShiftNotificationAudience>` 

Indicates whether Square should send email notifications to team members and
which team members should receive the notifications. This setting applies to all shifts
specified in the bulk operation. The default value is `AFFECTED`.
See [ScheduledShiftNotificationAudience](#type-scheduledshiftnotificationaudience) for possible values
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.searchScheduledShifts(request) -> SearchScheduledShiftsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a paginated list of scheduled shifts, with optional filter and sort settings.
By default, results are sorted by `start_at` in ascending order.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().searchScheduledShifts(
    SearchScheduledShiftsRequest
        .builder()
        .query(
            ScheduledShiftQuery
                .builder()
                .filter(
                    ScheduledShiftFilter
                        .builder()
                        .assignmentStatus(ScheduledShiftFilterAssignmentStatus.ASSIGNED)
                        .build()
                )
                .sort(
                    ScheduledShiftSort
                        .builder()
                        .field(ScheduledShiftSortField.CREATED_AT)
                        .order(SortOrder.ASC)
                        .build()
                )
                .build()
        )
        .limit(2)
        .cursor("xoxp-1234-5678-90123")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**query:** `Optional<ScheduledShiftQuery>` — Query conditions used to filter and sort the results.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The maximum number of results to return in a single response page. The default value is 50.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

The pagination cursor returned by the previous call to this endpoint. Provide
this cursor to retrieve the next page of results for your original request. For more
information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.retrieveScheduledShift(id) -> RetrieveScheduledShiftResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a scheduled shift by ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().retrieveScheduledShift(
    RetrieveScheduledShiftRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the scheduled shift to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.updateScheduledShift(id, request) -> UpdateScheduledShiftResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the draft shift details for a scheduled shift. This endpoint supports
sparse updates, so only new, changed, or removed fields are required in the request.
You must publish the shift to make updates public.

You can make the following updates to `draft_shift_details`:
- Change the `location_id`, `job_id`, `start_at`, and `end_at` fields.
- Add, change, or clear the `team_member_id` and `notes` fields. To clear these fields,
set the value to null.
- Change the `is_deleted` field. To delete a scheduled shift, set `is_deleted` to true
and then publish the shift.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().updateScheduledShift(
    UpdateScheduledShiftRequest
        .builder()
        .id("id")
        .scheduledShift(
            ScheduledShift
                .builder()
                .draftShiftDetails(
                    ScheduledShiftDetails
                        .builder()
                        .teamMemberId("ormj0jJJZ5OZIzxrZYJI")
                        .locationId("PAA1RJZZKXBFG")
                        .jobId("FzbJAtt9qEWncK1BWgVCxQ6M")
                        .startAt("2019-03-25T03:11:00-05:00")
                        .endAt("2019-03-25T13:18:00-05:00")
                        .notes("Dont forget to prep the vegetables")
                        .isDeleted(false)
                        .build()
                )
                .version(1)
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the scheduled shift to update.
    
</dd>
</dl>

<dl>
<dd>

**scheduledShift:** `ScheduledShift` 

The scheduled shift with any updates in the `draft_shift_details` field.
If needed, call [ListLocations](api-endpoint:Locations-ListLocations) to get location IDs,
[ListJobs](api-endpoint:Team-ListJobs) to get job IDs, and [SearchTeamMembers](api-endpoint:Team-SearchTeamMembers)
to get team member IDs and current job assignments. Updates made to `published_shift_details`
are ignored.

If provided, the `start_at` and `end_at` timestamps must be in the time zone + offset of the
shift location specified in `location_id`. Example for Pacific Standard Time: 2024-10-31T12:30:00-08:00

To enable [optimistic concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
control for the request, provide the current version of the shift in the `version` field.
If the provided version doesn't match the server version, the request fails. If `version` is
omitted, Square executes a blind write, potentially overwriting data from another publish request.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.publishScheduledShift(id, request) -> PublishScheduledShiftResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Publishes a scheduled shift. When a scheduled shift is published, Square keeps the
`draft_shift_details` field as is and copies it to the `published_shift_details` field.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().publishScheduledShift(
    PublishScheduledShiftRequest
        .builder()
        .id("id")
        .idempotencyKey("HIDSNG5KS478L")
        .version(2)
        .scheduledShiftNotificationAudience(ScheduledShiftNotificationAudience.ALL)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the scheduled shift to publish.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique identifier for the `PublishScheduledShift` request, used to ensure the
[idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency)
of the operation.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<Integer>` 

The current version of the scheduled shift, used to enable [optimistic concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
control. If the provided version doesn't match the server version, the request fails.
If omitted, Square executes a blind write, potentially overwriting data from another publish request.
    
</dd>
</dl>

<dl>
<dd>

**scheduledShiftNotificationAudience:** `Optional<ScheduledShiftNotificationAudience>` 

Indicates whether Square should send an email notification to team members and
which team members should receive the notification. The default value is `AFFECTED`.
See [ScheduledShiftNotificationAudience](#type-scheduledshiftnotificationaudience) for possible values
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.createTimecard(request) -> CreateTimecardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new `Timecard`.

A `Timecard` represents a complete workday for a single team member.
You must provide the following values in your request to this
endpoint:

- `location_id`
- `team_member_id`
- `start_at`

An attempt to create a new `Timecard` can result in a `BAD_REQUEST` error when:
- The `status` of the new `Timecard` is `OPEN` and the team member has another
timecard with an `OPEN` status.
- The `start_at` date is in the future.
- The `start_at` or `end_at` date overlaps another timecard for the same team member.
- The `Break` instances are set in the request and a break `start_at`
is before the `Timecard.start_at`, a break `end_at` is after
the `Timecard.end_at`, or both.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().createTimecard(
    CreateTimecardRequest
        .builder()
        .timecard(
            Timecard
                .builder()
                .locationId("PAA1RJZZKXBFG")
                .startAt("2019-01-25T03:11:00-05:00")
                .teamMemberId("ormj0jJJZ5OZIzxrZYJI")
                .endAt("2019-01-25T13:11:00-05:00")
                .wage(
                    TimecardWage
                        .builder()
                        .title("Barista")
                        .hourlyRate(
                            Money
                                .builder()
                                .amount(1100L)
                                .currency(Currency.USD)
                                .build()
                        )
                        .tipEligible(true)
                        .build()
                )
                .breaks(
                    new ArrayList<Break>(
                        Arrays.asList(
                            Break
                                .builder()
                                .startAt("2019-01-25T06:11:00-05:00")
                                .breakTypeId("REGS1EQR1TPZ5")
                                .name("Tea Break")
                                .expectedDuration("PT5M")
                                .isPaid(true)
                                .endAt("2019-01-25T06:16:00-05:00")
                                .build()
                        )
                    )
                )
                .declaredCashTipMoney(
                    Money
                        .builder()
                        .amount(500L)
                        .currency(Currency.USD)
                        .build()
                )
                .build()
        )
        .idempotencyKey("HIDSNG5KS478L")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` — A unique string value to ensure the idempotency of the operation.
    
</dd>
</dl>

<dl>
<dd>

**timecard:** `Timecard` — The `Timecard` to be created.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.searchTimecards(request) -> SearchTimecardsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a paginated list of `Timecard` records for a business.
The list to be returned can be filtered by:
- Location IDs
- Team member IDs
- Timecard status (`OPEN` or `CLOSED`)
- Timecard start
- Timecard end
- Workday details

The list can be sorted by:
- `START_AT`
- `END_AT`
- `CREATED_AT`
- `UPDATED_AT`
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().searchTimecards(
    SearchTimecardsRequest
        .builder()
        .query(
            TimecardQuery
                .builder()
                .filter(
                    TimecardFilter
                        .builder()
                        .workday(
                            TimecardWorkday
                                .builder()
                                .dateRange(
                                    DateRange
                                        .builder()
                                        .startDate("2019-01-20")
                                        .endDate("2019-02-03")
                                        .build()
                                )
                                .matchTimecardsBy(TimecardWorkdayMatcher.START_AT)
                                .defaultTimezone("America/Los_Angeles")
                                .build()
                        )
                        .build()
                )
                .build()
        )
        .limit(100)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**query:** `Optional<TimecardQuery>` — Query filters.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The number of resources in a page (200 by default).
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` — An opaque cursor for fetching the next page.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.retrieveTimecard(id) -> RetrieveTimecardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a single `Timecard` specified by `id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().retrieveTimecard(
    RetrieveTimecardRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The UUID for the `Timecard` being retrieved.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.updateTimecard(id, request) -> UpdateTimecardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an existing `Timecard`.

When adding a `Break` to a `Timecard`, any earlier `Break` instances in the `Timecard` have
the `end_at` property set to a valid RFC-3339 datetime string.

When closing a `Timecard`, all `Break` instances in the `Timecard` must be complete with `end_at`
set on each `Break`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().updateTimecard(
    UpdateTimecardRequest
        .builder()
        .id("id")
        .timecard(
            Timecard
                .builder()
                .locationId("PAA1RJZZKXBFG")
                .startAt("2019-01-25T03:11:00-05:00")
                .teamMemberId("ormj0jJJZ5OZIzxrZYJI")
                .endAt("2019-01-25T13:11:00-05:00")
                .wage(
                    TimecardWage
                        .builder()
                        .title("Bartender")
                        .hourlyRate(
                            Money
                                .builder()
                                .amount(1500L)
                                .currency(Currency.USD)
                                .build()
                        )
                        .tipEligible(true)
                        .build()
                )
                .breaks(
                    new ArrayList<Break>(
                        Arrays.asList(
                            Break
                                .builder()
                                .startAt("2019-01-25T06:11:00-05:00")
                                .breakTypeId("REGS1EQR1TPZ5")
                                .name("Tea Break")
                                .expectedDuration("PT5M")
                                .isPaid(true)
                                .id("X7GAQYVVRRG6P")
                                .endAt("2019-01-25T06:16:00-05:00")
                                .build()
                        )
                    )
                )
                .status(TimecardStatus.CLOSED)
                .version(1)
                .declaredCashTipMoney(
                    Money
                        .builder()
                        .amount(500L)
                        .currency(Currency.USD)
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The ID of the object being updated.
    
</dd>
</dl>

<dl>
<dd>

**timecard:** `Timecard` — The updated `Timecard` object.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.labor.deleteTimecard(id) -> DeleteTimecardResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a `Timecard`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.labor().deleteTimecard(
    DeleteTimecardRequest
        .builder()
        .id("id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**id:** `String` — The UUID for the `Timecard` being deleted.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Locations
<details><summary><code>client.locations.list() -> ListLocationsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Provides details about all of the seller's [locations](https://developer.squareup.com/docs/locations-api),
including those with an inactive status. Locations are listed alphabetically by `name`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.locations().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.create(request) -> CreateLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a [location](https://developer.squareup.com/docs/locations-api).
Creating new locations allows for separate configuration of receipt layouts, item prices,
and sales reports. Developers can use locations to separate sales activity through applications
that integrate with Square from sales activity elsewhere in a seller's account.
Locations created programmatically with the Locations API last forever and
are visible to the seller for their own management. Therefore, ensure that
each location has a sensible and unique name.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.locations().create(
    CreateLocationRequest
        .builder()
        .location(
            Location
                .builder()
                .name("Midtown")
                .address(
                    Address
                        .builder()
                        .addressLine1("1234 Peachtree St. NE")
                        .locality("Atlanta")
                        .administrativeDistrictLevel1("GA")
                        .postalCode("30309")
                        .build()
                )
                .description("Midtown Atlanta store")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**location:** `Optional<Location>` 

The initial values of the location being created. The `name` field is required and must be unique within a seller account.
All other fields are optional, but any information you care about for the location should be included.
The remaining fields are automatically added based on the data from the [main location](https://developer.squareup.com/docs/locations-api#about-the-main-location).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.get(locationId) -> GetLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves details of a single location. Specify "main"
as the location ID to retrieve details of the [main location](https://developer.squareup.com/docs/locations-api#about-the-main-location).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.locations().get(
    GetLocationsRequest
        .builder()
        .locationId("location_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` 

The ID of the location to retrieve. Specify the string
"main" to return the main location.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.update(locationId, request) -> UpdateLocationResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a [location](https://developer.squareup.com/docs/locations-api).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.locations().update(
    UpdateLocationRequest
        .builder()
        .locationId("location_id")
        .location(
            Location
                .builder()
                .businessHours(
                    BusinessHours
                        .builder()
                        .periods(
                            new ArrayList<BusinessHoursPeriod>(
                                Arrays.asList(
                                    BusinessHoursPeriod
                                        .builder()
                                        .dayOfWeek(DayOfWeek.FRI)
                                        .startLocalTime("07:00")
                                        .endLocalTime("18:00")
                                        .build(),
                                    BusinessHoursPeriod
                                        .builder()
                                        .dayOfWeek(DayOfWeek.SAT)
                                        .startLocalTime("07:00")
                                        .endLocalTime("18:00")
                                        .build(),
                                    BusinessHoursPeriod
                                        .builder()
                                        .dayOfWeek(DayOfWeek.SUN)
                                        .startLocalTime("09:00")
                                        .endLocalTime("15:00")
                                        .build()
                                )
                            )
                        )
                        .build()
                )
                .description("Midtown Atlanta store - Open weekends")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the location to update.
    
</dd>
</dl>

<dl>
<dd>

**location:** `Optional<Location>` — The `Location` object with only the fields to update.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.locations.checkouts(locationId, request) -> CreateCheckoutResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Links a `checkoutId` to a `checkout_page_url` that customers are
directed to in order to provide their payment information using a
payment processing workflow hosted on connect.squareup.com. 


NOTE: The Checkout API has been updated with new features. 
For more information, see [Checkout API highlights](https://developer.squareup.com/docs/checkout-api#checkout-api-highlights).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.locations().checkouts(
    CreateCheckoutRequest
        .builder()
        .locationId("location_id")
        .idempotencyKey("86ae1696-b1e3-4328-af6d-f1e04d947ad6")
        .order(
            CreateOrderRequest
                .builder()
                .order(
                    Order
                        .builder()
                        .locationId("location_id")
                        .referenceId("reference_id")
                        .customerId("customer_id")
                        .lineItems(
                            new ArrayList<OrderLineItem>(
                                Arrays.asList(
                                    OrderLineItem
                                        .builder()
                                        .quantity("2")
                                        .name("Printed T Shirt")
                                        .appliedTaxes(
                                            new ArrayList<OrderLineItemAppliedTax>(
                                                Arrays.asList(
                                                    OrderLineItemAppliedTax
                                                        .builder()
                                                        .taxUid("38ze1696-z1e3-5628-af6d-f1e04d947fg3")
                                                        .build()
                                                )
                                            )
                                        )
                                        .appliedDiscounts(
                                            new ArrayList<OrderLineItemAppliedDiscount>(
                                                Arrays.asList(
                                                    OrderLineItemAppliedDiscount
                                                        .builder()
                                                        .discountUid("56ae1696-z1e3-9328-af6d-f1e04d947gd4")
                                                        .build()
                                                )
                                            )
                                        )
                                        .basePriceMoney(
                                            Money
                                                .builder()
                                                .amount(1500L)
                                                .currency(Currency.USD)
                                                .build()
                                        )
                                        .build(),
                                    OrderLineItem
                                        .builder()
                                        .quantity("1")
                                        .name("Slim Jeans")
                                        .basePriceMoney(
                                            Money
                                                .builder()
                                                .amount(2500L)
                                                .currency(Currency.USD)
                                                .build()
                                        )
                                        .build(),
                                    OrderLineItem
                                        .builder()
                                        .quantity("3")
                                        .name("Woven Sweater")
                                        .basePriceMoney(
                                            Money
                                                .builder()
                                                .amount(3500L)
                                                .currency(Currency.USD)
                                                .build()
                                        )
                                        .build()
                                )
                            )
                        )
                        .taxes(
                            new ArrayList<OrderLineItemTax>(
                                Arrays.asList(
                                    OrderLineItemTax
                                        .builder()
                                        .uid("38ze1696-z1e3-5628-af6d-f1e04d947fg3")
                                        .type(OrderLineItemTaxType.INCLUSIVE)
                                        .percentage("7.75")
                                        .scope(OrderLineItemTaxScope.LINE_ITEM)
                                        .build()
                                )
                            )
                        )
                        .discounts(
                            new ArrayList<OrderLineItemDiscount>(
                                Arrays.asList(
                                    OrderLineItemDiscount
                                        .builder()
                                        .uid("56ae1696-z1e3-9328-af6d-f1e04d947gd4")
                                        .type(OrderLineItemDiscountType.FIXED_AMOUNT)
                                        .amountMoney(
                                            Money
                                                .builder()
                                                .amount(100L)
                                                .currency(Currency.USD)
                                                .build()
                                        )
                                        .scope(OrderLineItemDiscountScope.LINE_ITEM)
                                        .build()
                                )
                            )
                        )
                        .build()
                )
                .idempotencyKey("12ae1696-z1e3-4328-af6d-f1e04d947gd4")
                .build()
        )
        .askForShippingAddress(true)
        .merchantSupportEmail("merchant+support@website.com")
        .prePopulateBuyerEmail("example@email.com")
        .prePopulateShippingAddress(
            Address
                .builder()
                .addressLine1("1455 Market St.")
                .addressLine2("Suite 600")
                .locality("San Francisco")
                .administrativeDistrictLevel1("CA")
                .postalCode("94103")
                .country(Country.US)
                .firstName("Jane")
                .lastName("Doe")
                .build()
        )
        .redirectUrl("https://merchant.website.com/order-confirm")
        .additionalRecipients(
            new ArrayList<ChargeRequestAdditionalRecipient>(
                Arrays.asList(
                    ChargeRequestAdditionalRecipient
                        .builder()
                        .locationId("057P5VYJ4A5X1")
                        .description("Application fees")
                        .amountMoney(
                            Money
                                .builder()
                                .amount(60L)
                                .currency(Currency.USD)
                                .build()
                        )
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the business location to associate the checkout with.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique string that identifies this checkout among others you have created. It can be
any valid string but must be unique for every order sent to Square Checkout for a given location ID.

The idempotency key is used to avoid processing the same order more than once. If you are 
unsure whether a particular checkout was created successfully, you can attempt it again with
the same idempotency key and all the same other parameters without worrying about creating duplicates.

You should use a random number/string generator native to the language
you are working in to generate strings for your idempotency keys.

For more information, see [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**order:** `CreateOrderRequest` — The order including line items to be checked out.
    
</dd>
</dl>

<dl>
<dd>

**askForShippingAddress:** `Optional<Boolean>` 

If `true`, Square Checkout collects shipping information on your behalf and stores 
that information with the transaction information in the Square Seller Dashboard.

Default: `false`.
    
</dd>
</dl>

<dl>
<dd>

**merchantSupportEmail:** `Optional<String>` 

The email address to display on the Square Checkout confirmation page
and confirmation email that the buyer can use to contact the seller.

If this value is not set, the confirmation page and email display the
primary email address associated with the seller's Square account.

Default: none; only exists if explicitly set.
    
</dd>
</dl>

<dl>
<dd>

**prePopulateBuyerEmail:** `Optional<String>` 

If provided, the buyer's email is prepopulated on the checkout page
as an editable text field.

Default: none; only exists if explicitly set.
    
</dd>
</dl>

<dl>
<dd>

**prePopulateShippingAddress:** `Optional<Address>` 

If provided, the buyer's shipping information is prepopulated on the
checkout page as editable text fields.

Default: none; only exists if explicitly set.
    
</dd>
</dl>

<dl>
<dd>

**redirectUrl:** `Optional<String>` 

The URL to redirect to after the checkout is completed with `checkoutId`,
`transactionId`, and `referenceId` appended as URL parameters. For example,
if the provided redirect URL is `http://www.example.com/order-complete`, a
successful transaction redirects the customer to:

`http://www.example.com/order-complete?checkoutId=xxxxxx&amp;referenceId=xxxxxx&amp;transactionId=xxxxxx`

If you do not provide a redirect URL, Square Checkout displays an order
confirmation page on your behalf; however, it is strongly recommended that
you provide a redirect URL so you can verify the transaction results and
finalize the order through your existing/normal confirmation workflow.

Default: none; only exists if explicitly set.
    
</dd>
</dl>

<dl>
<dd>

**additionalRecipients:** `Optional<List<ChargeRequestAdditionalRecipient>>` 

The basic primitive of a multi-party transaction. The value is optional.
The transaction facilitated by you can be split from here.

If you provide this value, the `amount_money` value in your `additional_recipients` field
cannot be more than 90% of the `total_money` calculated by Square for your order.
The `location_id` must be a valid seller location where the checkout is occurring.

This field requires `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission.

This field is currently not supported in the Square Sandbox.
    
</dd>
</dl>

<dl>
<dd>

**note:** `Optional<String>` 

An optional note to associate with the `checkout` object.

This value cannot exceed 60 characters.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Loyalty
<details><summary><code>client.loyalty.searchEvents(request) -> SearchLoyaltyEventsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for loyalty events.

A Square loyalty program maintains a ledger of events that occur during the lifetime of a
buyer's loyalty account. Each change in the point balance
(for example, points earned, points redeemed, and points expired) is
recorded in the ledger. Using this endpoint, you can search the ledger for events.

Search results are sorted by `created_at` in descending order.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.loyalty().searchEvents(
    SearchLoyaltyEventsRequest
        .builder()
        .query(
            LoyaltyEventQuery
                .builder()
                .filter(
                    LoyaltyEventFilter
                        .builder()
                        .orderFilter(
                            LoyaltyEventOrderFilter
                                .builder()
                                .orderId("PyATxhYLfsMqpVkcKJITPydgEYfZY")
                                .build()
                        )
                        .build()
                )
                .build()
        )
        .limit(30)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**query:** `Optional<LoyaltyEventQuery>` 

A set of one or more predefined query filters to apply when 
searching for loyalty events. The endpoint performs a logical AND to 
evaluate multiple filters and performs a logical OR on arrays  
that specifies multiple field values.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to include in the response. 
The last page might contain fewer events. 
The default is 30 events.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this to retrieve the next set of results for your original query.
For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Merchants
<details><summary><code>client.merchants.list() -> ListMerchantsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Provides details about the merchant associated with a given access token.

The access token used to connect your application to a Square seller is associated
with a single merchant. That means that `ListMerchants` returns a list
with a single `Merchant` object. You can specify your personal access token
to get your own merchant information or specify an OAuth token to get the
information for the merchant that granted your application access.

If you know the merchant ID, you can also use the [RetrieveMerchant](api-endpoint:Merchants-RetrieveMerchant)
endpoint to retrieve the merchant information.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.merchants().list(
    ListMerchantsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<Integer>` — The cursor generated by the previous response.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.merchants.get(merchantId) -> GetMerchantResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the `Merchant` object for the given `merchant_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.merchants().get(
    GetMerchantsRequest
        .builder()
        .merchantId("merchant_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**merchantId:** `String` 

The ID of the merchant to retrieve. If the string "me" is supplied as the ID,
then retrieve the merchant that is currently accessible to this call.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Checkout
<details><summary><code>client.checkout.retrieveLocationSettings(locationId) -> RetrieveLocationSettingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the location-level settings for a Square-hosted checkout page.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.checkout().retrieveLocationSettings(
    RetrieveLocationSettingsRequest
        .builder()
        .locationId("location_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the location for which to retrieve settings.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.checkout.updateLocationSettings(locationId, request) -> UpdateLocationSettingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the location-level settings for a Square-hosted checkout page.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.checkout().updateLocationSettings(
    UpdateLocationSettingsRequest
        .builder()
        .locationId("location_id")
        .locationSettings(
            CheckoutLocationSettings
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `String` — The ID of the location for which to retrieve settings.
    
</dd>
</dl>

<dl>
<dd>

**locationSettings:** `CheckoutLocationSettings` — Describe your updates using the `location_settings` object. Make sure it contains only the fields that have changed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.checkout.retrieveMerchantSettings() -> RetrieveMerchantSettingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves the merchant-level settings for a Square-hosted checkout page.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.checkout().retrieveMerchantSettings();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.checkout.updateMerchantSettings(request) -> UpdateMerchantSettingsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the merchant-level settings for a Square-hosted checkout page.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.checkout().updateMerchantSettings(
    UpdateMerchantSettingsRequest
        .builder()
        .merchantSettings(
            CheckoutMerchantSettings
                .builder()
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**merchantSettings:** `CheckoutMerchantSettings` — Describe your updates using the `merchant_settings` object. Make sure it contains only the fields that have changed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Orders
<details><summary><code>client.orders.create(request) -> CreateOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new [order](entity:Order) that can include information about products for
purchase and settings to apply to the purchase.

To pay for a created order, see
[Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders).

You can modify open orders using the [UpdateOrder](api-endpoint:Orders-UpdateOrder) endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().create(
    CreateOrderRequest
        .builder()
        .order(
            Order
                .builder()
                .locationId("057P5VYJ4A5X1")
                .referenceId("my-order-001")
                .lineItems(
                    new ArrayList<OrderLineItem>(
                        Arrays.asList(
                            OrderLineItem
                                .builder()
                                .quantity("1")
                                .name("New York Strip Steak")
                                .basePriceMoney(
                                    Money
                                        .builder()
                                        .amount(1599L)
                                        .currency(Currency.USD)
                                        .build()
                                )
                                .build(),
                            OrderLineItem
                                .builder()
                                .quantity("2")
                                .catalogObjectId("BEMYCSMIJL46OCDV4KYIKXIB")
                                .modifiers(
                                    new ArrayList<OrderLineItemModifier>(
                                        Arrays.asList(
                                            OrderLineItemModifier
                                                .builder()
                                                .catalogObjectId("CHQX7Y4KY6N5KINJKZCFURPZ")
                                                .build()
                                        )
                                    )
                                )
                                .appliedDiscounts(
                                    new ArrayList<OrderLineItemAppliedDiscount>(
                                        Arrays.asList(
                                            OrderLineItemAppliedDiscount
                                                .builder()
                                                .discountUid("one-dollar-off")
                                                .build()
                                        )
                                    )
                                )
                                .build()
                        )
                    )
                )
                .taxes(
                    new ArrayList<OrderLineItemTax>(
                        Arrays.asList(
                            OrderLineItemTax
                                .builder()
                                .uid("state-sales-tax")
                                .name("State Sales Tax")
                                .percentage("9")
                                .scope(OrderLineItemTaxScope.ORDER)
                                .build()
                        )
                    )
                )
                .discounts(
                    new ArrayList<OrderLineItemDiscount>(
                        Arrays.asList(
                            OrderLineItemDiscount
                                .builder()
                                .uid("labor-day-sale")
                                .name("Labor Day Sale")
                                .percentage("5")
                                .scope(OrderLineItemDiscountScope.ORDER)
                                .build(),
                            OrderLineItemDiscount
                                .builder()
                                .uid("membership-discount")
                                .catalogObjectId("DB7L55ZH2BGWI4H23ULIWOQ7")
                                .scope(OrderLineItemDiscountScope.ORDER)
                                .build(),
                            OrderLineItemDiscount
                                .builder()
                                .uid("one-dollar-off")
                                .name("Sale - $1.00 off")
                                .amountMoney(
                                    Money
                                        .builder()
                                        .amount(100L)
                                        .currency(Currency.USD)
                                        .build()
                                )
                                .scope(OrderLineItemDiscountScope.LINE_ITEM)
                                .build()
                        )
                    )
                )
                .build()
        )
        .idempotencyKey("8193148c-9586-11e6-99f9-28cfe92138cf")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `CreateOrderRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.batchGet(request) -> BatchGetOrdersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a set of [orders](entity:Order) by their IDs.

If a given order ID does not exist, the ID is ignored instead of generating an error.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().batchGet(
    BatchGetOrdersRequest
        .builder()
        .orderIds(
            new ArrayList<String>(
                Arrays.asList("CAISEM82RcpmcFBM0TfOyiHV3es", "CAISENgvlJ6jLWAzERDzjyHVybY")
            )
        )
        .locationId("057P5VYJ4A5X1")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `Optional<String>` 

The ID of the location for these orders. This field is optional: omit it to retrieve
orders within the scope of the current authorization's merchant ID.
    
</dd>
</dl>

<dl>
<dd>

**orderIds:** `List<String>` — The IDs of the orders to retrieve. A maximum of 100 orders can be retrieved per request.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.calculate(request) -> CalculateOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Enables applications to preview order pricing without creating an order.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().calculate(
    CalculateOrderRequest
        .builder()
        .order(
            Order
                .builder()
                .locationId("D7AVYMEAPJ3A3")
                .lineItems(
                    new ArrayList<OrderLineItem>(
                        Arrays.asList(
                            OrderLineItem
                                .builder()
                                .quantity("1")
                                .name("Item 1")
                                .basePriceMoney(
                                    Money
                                        .builder()
                                        .amount(500L)
                                        .currency(Currency.USD)
                                        .build()
                                )
                                .build(),
                            OrderLineItem
                                .builder()
                                .quantity("2")
                                .name("Item 2")
                                .basePriceMoney(
                                    Money
                                        .builder()
                                        .amount(300L)
                                        .currency(Currency.USD)
                                        .build()
                                )
                                .build()
                        )
                    )
                )
                .discounts(
                    new ArrayList<OrderLineItemDiscount>(
                        Arrays.asList(
                            OrderLineItemDiscount
                                .builder()
                                .name("50% Off")
                                .percentage("50")
                                .scope(OrderLineItemDiscountScope.ORDER)
                                .build()
                        )
                    )
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**order:** `Order` — The order to be calculated. Expects the entire order, not a sparse update.
    
</dd>
</dl>

<dl>
<dd>

**proposedRewards:** `Optional<List<OrderReward>>` 

Identifies one or more loyalty reward tiers to apply during the order calculation.
The discounts defined by the reward tiers are added to the order only to preview the
effect of applying the specified rewards. The rewards do not correspond to actual
redemptions; that is, no `reward`s are created. Therefore, the reward `id`s are
random strings used only to reference the reward tier.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.clone(request) -> CloneOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a new order, in the `DRAFT` state, by duplicating an existing order. The newly created order has
only the core fields (such as line items, taxes, and discounts) copied from the original order.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().clone(
    CloneOrderRequest
        .builder()
        .orderId("ZAISEM52YcpmcWAzERDOyiWS123")
        .version(3)
        .idempotencyKey("UNIQUE_STRING")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orderId:** `String` — The ID of the order to clone.
    
</dd>
</dl>

<dl>
<dd>

**version:** `Optional<Integer>` 

An optional order version for concurrency protection.

If a version is provided, it must match the latest stored version of the order to clone.
If a version is not provided, the API clones the latest version.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A value you specify that uniquely identifies this clone request.

If you are unsure whether a particular order was cloned successfully,
you can reattempt the call with the same idempotency key without
worrying about creating duplicate cloned orders.
The originally cloned order is returned.

For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.search(request) -> SearchOrdersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Search all orders for one or more locations. Orders include all sales,
returns, and exchanges regardless of how or when they entered the Square
ecosystem (such as Point of Sale, Invoices, and Connect APIs).

`SearchOrders` requests need to specify which locations to search and define a
[SearchOrdersQuery](entity:SearchOrdersQuery) object that controls
how to sort or filter the results. Your `SearchOrdersQuery` can:

  Set filter criteria.
  Set the sort order.
  Determine whether to return results as complete `Order` objects or as
[OrderEntry](entity:OrderEntry) objects.

Note that details for orders processed with Square Point of Sale while in
offline mode might not be transmitted to Square for up to 72 hours. Offline
orders have a `created_at` value that reflects the time the order was created,
not the time it was subsequently transmitted to Square.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().search(
    SearchOrdersRequest
        .builder()
        .locationIds(
            new ArrayList<String>(
                Arrays.asList("057P5VYJ4A5X1", "18YC4JDH91E1H")
            )
        )
        .query(
            SearchOrdersQuery
                .builder()
                .filter(
                    SearchOrdersFilter
                        .builder()
                        .stateFilter(
                            SearchOrdersStateFilter
                                .builder()
                                .states(
                                    new ArrayList<OrderState>(
                                        Arrays.asList(OrderState.COMPLETED)
                                    )
                                )
                                .build()
                        )
                        .dateTimeFilter(
                            SearchOrdersDateTimeFilter
                                .builder()
                                .closedAt(
                                    TimeRange
                                        .builder()
                                        .startAt("2018-03-03T20:00:00+00:00")
                                        .endAt("2019-03-04T21:54:45+00:00")
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .sort(
                    SearchOrdersSort
                        .builder()
                        .sortField(SearchOrdersSortField.CLOSED_AT)
                        .sortOrder(SortOrder.DESC)
                        .build()
                )
                .build()
        )
        .limit(3)
        .returnEntries(true)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationIds:** `Optional<List<String>>` 

The location IDs for the orders to query. All locations must belong to
the same merchant.

Max: 10 location IDs.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for your original query.
For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<SearchOrdersQuery>` 

Query conditions used to filter or sort the results. Note that when
retrieving additional pages using a cursor, you must use the original query.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to be returned in a single page.

Default: `500`
Max: `1000`
    
</dd>
</dl>

<dl>
<dd>

**returnEntries:** `Optional<Boolean>` 

A Boolean that controls the format of the search results. If `true`,
`SearchOrders` returns [OrderEntry](entity:OrderEntry) objects. If `false`, `SearchOrders`
returns complete order objects.

Default: `false`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.get(orderId) -> GetOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves an [Order](entity:Order) by ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().get(
    GetOrdersRequest
        .builder()
        .orderId("order_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orderId:** `String` — The ID of the order to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.update(orderId, request) -> UpdateOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates an open [order](entity:Order) by adding, replacing, or deleting
fields. Orders with a `COMPLETED` or `CANCELED` state cannot be updated.

An `UpdateOrder` request requires the following:

- The `order_id` in the endpoint path, identifying the order to update.
- The latest `version` of the order to update.
- The [sparse order](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects)
containing only the fields to update and the version to which the update is
being applied.
- If deleting fields, the [dot notation paths](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#identifying-fields-to-delete)
identifying the fields to clear.

To pay for an order, see
[Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().update(
    UpdateOrderRequest
        .builder()
        .orderId("order_id")
        .order(
            Order
                .builder()
                .locationId("location_id")
                .lineItems(
                    new ArrayList<OrderLineItem>(
                        Arrays.asList(
                            OrderLineItem
                                .builder()
                                .quantity("2")
                                .uid("cookie_uid")
                                .name("COOKIE")
                                .basePriceMoney(
                                    Money
                                        .builder()
                                        .amount(200L)
                                        .currency(Currency.USD)
                                        .build()
                                )
                                .build()
                        )
                    )
                )
                .version(1)
                .build()
        )
        .fieldsToClear(
            new ArrayList<String>(
                Arrays.asList("discounts")
            )
        )
        .idempotencyKey("UNIQUE_STRING")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orderId:** `String` — The ID of the order to update.
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<Order>` 

The [sparse order](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#sparse-order-objects)
containing only the fields to update and the version to which the update is
being applied.
    
</dd>
</dl>

<dl>
<dd>

**fieldsToClear:** `Optional<List<String>>` 

The [dot notation paths](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#identifying-fields-to-delete)
fields to clear. For example, `line_items[uid].note`.
For more information, see [Deleting fields](https://developer.squareup.com/docs/orders-api/manage-orders/update-orders#deleting-fields).
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A value you specify that uniquely identifies this update request.

If you are unsure whether a particular update was applied to an order successfully,
you can reattempt it with the same idempotency key without
worrying about creating duplicate updates to the order.
The latest order version is returned.

For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.pay(orderId, request) -> PayOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Pay for an [order](entity:Order) using one or more approved [payments](entity:Payment)
or settle an order with a total of `0`.

The total of the `payment_ids` listed in the request must be equal to the order
total. Orders with a total amount of `0` can be marked as paid by specifying an empty
array of `payment_ids` in the request.

To be used with `PayOrder`, a payment must:

- Reference the order by specifying the `order_id` when [creating the payment](api-endpoint:Payments-CreatePayment).
Any approved payments that reference the same `order_id` not specified in the
`payment_ids` is canceled.
- Be approved with [delayed capture](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture).
Using a delayed capture payment with `PayOrder` completes the approved payment.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().pay(
    PayOrderRequest
        .builder()
        .orderId("order_id")
        .idempotencyKey("c043a359-7ad9-4136-82a9-c3f1d66dcbff")
        .paymentIds(
            new ArrayList<String>(
                Arrays.asList("EnZdNAlWCmfh6Mt5FMNST1o7taB", "0LRiVlbXVwe8ozu4KbZxd12mvaB")
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**orderId:** `String` — The ID of the order being paid.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 

A value you specify that uniquely identifies this request among requests you have sent. If
you are unsure whether a particular payment request was completed successfully, you can reattempt
it with the same idempotency key without worrying about duplicate payments.

For more information, see [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**orderVersion:** `Optional<Integer>` — The version of the order being paid. If not supplied, the latest version will be paid.
    
</dd>
</dl>

<dl>
<dd>

**paymentIds:** `Optional<List<String>>` 

The IDs of the [payments](entity:Payment) to collect.
The payment total must match the order total.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Payments
<details><summary><code>client.payments.list() -> ListPaymentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a list of payments taken by the account making the request.

Results are eventually consistent, and new payments or changes to payments might take several
seconds to appear.

The maximum results per page is 100.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().list(
    ListPaymentsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**beginTime:** `Optional<String>` 

Indicates the start of the time range to retrieve payments for, in RFC 3339 format.  
The range is determined using the `created_at` field for each Payment.
Inclusive. Default: The current time minus one year.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` 

Indicates the end of the time range to retrieve payments for, in RFC 3339 format.  The 
range is determined using the `created_at` field for each Payment.

Default: The current time.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<String>` 

The order in which results are listed by `ListPaymentsRequest.sort_field`:
- `ASC` - Oldest to newest.
- `DESC` - Newest to oldest (default).
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 

Limit results to the location supplied. By default, results are returned
for the default (main) location associated with the seller.
    
</dd>
</dl>

<dl>
<dd>

**total:** `Optional<Integer>` — The exact amount in the `total_money` for a payment.
    
</dd>
</dl>

<dl>
<dd>

**last4:** `Optional<String>` — The last four digits of a payment card.
    
</dd>
</dl>

<dl>
<dd>

**cardBrand:** `Optional<String>` — The brand of the payment card (for example, VISA).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to be returned in a single page.
It is possible to receive fewer results than the specified limit on a given page.

The default value of 100 is also the maximum allowed value. If the provided value is 
greater than 100, it is ignored and the default value is used instead.

Default: `100`
    
</dd>
</dl>

<dl>
<dd>

**isOfflinePayment:** `Optional<Boolean>` — Whether the payment was taken offline or not.
    
</dd>
</dl>

<dl>
<dd>

**offlineBeginTime:** `Optional<String>` 

Indicates the start of the time range for which to retrieve offline payments, in RFC 3339
format for timestamps. The range is determined using the
`offline_payment_details.client_created_at` field for each Payment. If set, payments without a
value set in `offline_payment_details.client_created_at` will not be returned.

Default: The current time.
    
</dd>
</dl>

<dl>
<dd>

**offlineEndTime:** `Optional<String>` 

Indicates the end of the time range for which to retrieve offline payments, in RFC 3339
format for timestamps. The range is determined using the
`offline_payment_details.client_created_at` field for each Payment. If set, payments without a
value set in `offline_payment_details.client_created_at` will not be returned.

Default: The current time.
    
</dd>
</dl>

<dl>
<dd>

**updatedAtBeginTime:** `Optional<String>` 

Indicates the start of the time range to retrieve payments for, in RFC 3339 format.  The
range is determined using the `updated_at` field for each Payment.
    
</dd>
</dl>

<dl>
<dd>

**updatedAtEndTime:** `Optional<String>` 

Indicates the end of the time range to retrieve payments for, in RFC 3339 format.  The
range is determined using the `updated_at` field for each Payment.
    
</dd>
</dl>

<dl>
<dd>

**sortField:** `Optional<ListPaymentsRequestSortField>` — The field used to sort results by. The default is `CREATED_AT`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payments.create(request) -> CreatePaymentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a payment using the provided source. You can use this endpoint 
to charge a card (credit/debit card or    
Square gift card) or record a payment that the seller received outside of Square 
(cash payment from a buyer or a payment that an external entity 
processed on behalf of the seller).

The endpoint creates a 
`Payment` object and returns it in the response.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().create(
    CreatePaymentRequest
        .builder()
        .sourceId("ccof:GaJGNaZa8x4OgDJn4GB")
        .idempotencyKey("7b0f3ec5-086a-4871-8f13-3c81b3875218")
        .amountMoney(
            Money
                .builder()
                .amount(1000L)
                .currency(Currency.USD)
                .build()
        )
        .appFeeMoney(
            Money
                .builder()
                .amount(10L)
                .currency(Currency.USD)
                .build()
        )
        .autocomplete(true)
        .customerId("W92WH6P11H4Z77CTET0RNTGFW8")
        .locationId("L88917AVBK2S5")
        .referenceId("123456")
        .note("Brief description")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**sourceId:** `String` 

The ID for the source of funds for this payment.
This could be a payment token generated by the Web Payments SDK for any of its
[supported methods](https://developer.squareup.com/docs/web-payments/overview#explore-payment-methods),
including cards, bank transfers, Afterpay or Cash App Pay. If recording a payment
that the seller received outside of Square, specify either "CASH" or "EXTERNAL".
For more information, see 
[Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique string that identifies this `CreatePayment` request. Keys can be any valid string
but must be unique for every `CreatePayment` request.

Note: The number of allowed characters might be less than the stated maximum, if multi-byte
characters are used.

For more information, see [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**amountMoney:** `Optional<Money>` 

The amount of money to accept for this payment, not including `tip_money`.

The amount must be specified in the smallest denomination of the applicable currency
(for example, US dollar amounts are specified in cents). For more information, see
[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts).

The currency code must match the currency associated with the business
that is accepting the payment.
    
</dd>
</dl>

<dl>
<dd>

**tipMoney:** `Optional<Money>` 

The amount designated as a tip, in addition to `amount_money`.

The amount must be specified in the smallest denomination of the applicable currency
(for example, US dollar amounts are specified in cents). For more information, see
[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts).

The currency code must match the currency associated with the business
that is accepting the payment.
    
</dd>
</dl>

<dl>
<dd>

**appFeeMoney:** `Optional<Money>` 

The amount of money that the developer is taking as a fee
for facilitating the payment on behalf of the seller.

The amount cannot be more than 90% of the total amount of the payment.

The amount must be specified in the smallest denomination of the applicable currency
(for example, US dollar amounts are specified in cents). For more information, see
[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts).

The fee currency code must match the currency associated with the seller
that is accepting the payment. The application must be from a developer
account in the same country and using the same currency code as the seller.

For more information about the application fee scenario, see
[Take Payments and Collect Fees](https://developer.squareup.com/docs/payments-api/take-payments-and-collect-fees).

To set this field, `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission is required.
For more information, see [Permissions](https://developer.squareup.com/docs/payments-api/take-payments-and-collect-fees#permissions).
    
</dd>
</dl>

<dl>
<dd>

**delayDuration:** `Optional<String>` 

The duration of time after the payment's creation when Square automatically 
either completes or cancels the payment depending on the `delay_action` field value. 
For more information, see 
[Time threshold](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture#time-threshold). 

This parameter should be specified as a time duration, in RFC 3339 format.

Note: This feature is only supported for card payments. This parameter can only be set for a delayed
capture payment (`autocomplete=false`).

Default:

- Card-present payments: "PT36H" (36 hours) from the creation time.
- Card-not-present payments: "P7D" (7 days) from the creation time.
    
</dd>
</dl>

<dl>
<dd>

**delayAction:** `Optional<String>` 

The action to be applied to the payment when the `delay_duration` has elapsed. The action must be
CANCEL or COMPLETE. For more information, see 
[Time Threshold](https://developer.squareup.com/docs/payments-api/take-payments/card-payments/delayed-capture#time-threshold). 

Default: CANCEL
    
</dd>
</dl>

<dl>
<dd>

**autocomplete:** `Optional<Boolean>` 

If set to `true`, this payment will be completed when possible. If
set to `false`, this payment is held in an approved state until either
explicitly completed (captured) or canceled (voided). For more information, see
[Delayed capture](https://developer.squareup.com/docs/payments-api/take-payments/card-payments#delayed-capture-of-a-card-payment).

Default: true
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `Optional<String>` — Associates a previously created order with this payment.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `Optional<String>` 

The [Customer](entity:Customer) ID of the customer associated with the payment.

This is required if the `source_id` refers to a card on file created using the Cards API.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 

The location ID to associate with the payment. If not specified, the [main location](https://developer.squareup.com/docs/locations-api#about-the-main-location) is
used.
    
</dd>
</dl>

<dl>
<dd>

**teamMemberId:** `Optional<String>` 

An optional [TeamMember](entity:TeamMember) ID to associate with 
this payment.
    
</dd>
</dl>

<dl>
<dd>

**referenceId:** `Optional<String>` 

A user-defined ID to associate with the payment.

You can use this field to associate the payment to an entity in an external system 
(for example, you might specify an order ID that is generated by a third-party shopping cart).
    
</dd>
</dl>

<dl>
<dd>

**verificationToken:** `Optional<String>` 

An identifying token generated by [payments.verifyBuyer()](https://developer.squareup.com/reference/sdks/web/payments/objects/Payments#Payments.verifyBuyer).
Verification tokens encapsulate customer device information and 3-D Secure
challenge results to indicate that Square has verified the buyer identity.

For more information, see [SCA Overview](https://developer.squareup.com/docs/sca-overview).
    
</dd>
</dl>

<dl>
<dd>

**acceptPartialAuthorization:** `Optional<Boolean>` 

If set to `true` and charging a Square Gift Card, a payment might be returned with
`amount_money` equal to less than what was requested. For example, a request for $20 when charging
a Square Gift Card with a balance of $5 results in an APPROVED payment of $5. You might choose
to prompt the buyer for an additional payment to cover the remainder or cancel the Gift Card
payment. This field cannot be `true` when `autocomplete = true`.

For more information, see
[Partial amount with Square Gift Cards](https://developer.squareup.com/docs/payments-api/take-payments#partial-payment-gift-card).

Default: false
    
</dd>
</dl>

<dl>
<dd>

**buyerEmailAddress:** `Optional<String>` — The buyer's email address.
    
</dd>
</dl>

<dl>
<dd>

**buyerPhoneNumber:** `Optional<String>` 

The buyer's phone number.
Must follow the following format:
1. A leading + symbol (followed by a country code)
2. The phone number can contain spaces and the special characters `(` , `)` , `-` , and `.`.
Alphabetical characters aren't allowed.
3. The phone number must contain between 9 and 16 digits.
    
</dd>
</dl>

<dl>
<dd>

**billingAddress:** `Optional<Address>` — The buyer's billing address.
    
</dd>
</dl>

<dl>
<dd>

**shippingAddress:** `Optional<Address>` — The buyer's shipping address.
    
</dd>
</dl>

<dl>
<dd>

**note:** `Optional<String>` — An optional note to be entered by the developer when creating a payment.
    
</dd>
</dl>

<dl>
<dd>

**statementDescriptionIdentifier:** `Optional<String>` 

Optional additional payment information to include on the customer's card statement
as part of the statement description. This can be, for example, an invoice number, ticket number,
or short description that uniquely identifies the purchase.

Note that the `statement_description_identifier` might get truncated on the statement description
to fit the required information including the Square identifier (SQ *) and name of the
seller taking the payment.
    
</dd>
</dl>

<dl>
<dd>

**cashDetails:** `Optional<CashPaymentDetails>` — Additional details required when recording a cash payment (`source_id` is CASH).
    
</dd>
</dl>

<dl>
<dd>

**externalDetails:** `Optional<ExternalPaymentDetails>` — Additional details required when recording an external payment (`source_id` is EXTERNAL).
    
</dd>
</dl>

<dl>
<dd>

**customerDetails:** `Optional<CustomerDetails>` — Details about the customer making the payment.
    
</dd>
</dl>

<dl>
<dd>

**offlinePaymentDetails:** `Optional<OfflinePaymentDetails>` 

An optional field for specifying the offline payment details. This is intended for
internal 1st-party callers only.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payments.cancelByIdempotencyKey(request) -> CancelPaymentByIdempotencyKeyResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Cancels (voids) a payment identified by the idempotency key that is specified in the
request.

Use this method when the status of a `CreatePayment` request is unknown (for example, after you send a
`CreatePayment` request, a network error occurs and you do not get a response). In this case, you can
direct Square to cancel the payment using this endpoint. In the request, you provide the same
idempotency key that you provided in your `CreatePayment` request that you want to cancel. After
canceling the payment, you can submit your `CreatePayment` request again.

Note that if no payment with the specified idempotency key is found, no action is taken and the endpoint
returns successfully.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().cancelByIdempotencyKey(
    CancelPaymentByIdempotencyKeyRequest
        .builder()
        .idempotencyKey("a7e36d40-d24b-11e8-b568-0800200c9a66")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` — The `idempotency_key` identifying the payment to be canceled.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payments.get(paymentId) -> GetPaymentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves details for a specific payment.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().get(
    GetPaymentsRequest
        .builder()
        .paymentId("payment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**paymentId:** `String` — A unique ID for the desired payment.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payments.update(paymentId, request) -> UpdatePaymentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a payment with the APPROVED status.
You can update the `amount_money` and `tip_money` using this endpoint.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().update(
    UpdatePaymentRequest
        .builder()
        .paymentId("payment_id")
        .idempotencyKey("956f8b13-e4ec-45d6-85e8-d1d95ef0c5de")
        .payment(
            Payment
                .builder()
                .amountMoney(
                    Money
                        .builder()
                        .amount(1000L)
                        .currency(Currency.USD)
                        .build()
                )
                .tipMoney(
                    Money
                        .builder()
                        .amount(100L)
                        .currency(Currency.USD)
                        .build()
                )
                .versionToken("ODhwVQ35xwlzRuoZEwKXucfu7583sPTzK48c5zoGd0g6o")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**paymentId:** `String` — The ID of the payment to update.
    
</dd>
</dl>

<dl>
<dd>

**payment:** `Optional<Payment>` — The updated `Payment` object.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique string that identifies this `UpdatePayment` request. Keys can be any valid string
but must be unique for every `UpdatePayment` request.

For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payments.cancel(paymentId) -> CancelPaymentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Cancels (voids) a payment. You can use this endpoint to cancel a payment with 
the APPROVED `status`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().cancel(
    CancelPaymentsRequest
        .builder()
        .paymentId("payment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**paymentId:** `String` — The ID of the payment to cancel.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payments.complete(paymentId, request) -> CompletePaymentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Completes (captures) a payment.
By default, payments are set to complete immediately after they are created.

You can use this endpoint to complete a payment with the APPROVED `status`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payments().complete(
    CompletePaymentRequest
        .builder()
        .paymentId("payment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**paymentId:** `String` — The unique ID identifying the payment to be completed.
    
</dd>
</dl>

<dl>
<dd>

**versionToken:** `Optional<String>` 

Used for optimistic concurrency. This opaque token identifies the current `Payment` 
version that the caller expects. If the server has a different version of the Payment, 
the update fails and a response with a VERSION_MISMATCH error is returned.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Payouts
<details><summary><code>client.payouts.list() -> ListPayoutsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a list of all payouts for the default location.
You can filter payouts by location ID, status, time range, and order them in ascending or descending order.
To call this endpoint, set `PAYOUTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payouts().list(
    ListPayoutsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**locationId:** `Optional<String>` 

The ID of the location for which to list the payouts.
By default, payouts are returned for the default (main) location associated with the seller.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<PayoutStatus>` — If provided, only payouts with the given status are returned.
    
</dd>
</dl>

<dl>
<dd>

**beginTime:** `Optional<String>` 

The timestamp for the beginning of the payout creation time, in RFC 3339 format.
Inclusive. Default: The current time minus one year.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` 

The timestamp for the end of the payout creation time, in RFC 3339 format.
Default: The current time.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<SortOrder>` — The order in which payouts are listed.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.
For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
If request parameters change between requests, subsequent results may contain duplicates or missing records.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to be returned in a single page.
It is possible to receive fewer results than the specified limit on a given page.
The default value of 100 is also the maximum allowed value. If the provided value is
greater than 100, it is ignored and the default value is used instead.
Default: `100`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payouts.get(payoutId) -> GetPayoutResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves details of a specific payout identified by a payout ID.
To call this endpoint, set `PAYOUTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payouts().get(
    GetPayoutsRequest
        .builder()
        .payoutId("payout_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**payoutId:** `String` — The ID of the payout to retrieve the information for.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.payouts.listEntries(payoutId) -> ListPayoutEntriesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a list of all payout entries for a specific payout.
To call this endpoint, set `PAYOUTS_READ` for the OAuth scope.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.payouts().listEntries(
    ListEntriesPayoutsRequest
        .builder()
        .payoutId("payout_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**payoutId:** `String` — The ID of the payout to retrieve the information for.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<SortOrder>` — The order in which payout entries are listed.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.
For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
If request parameters change between requests, subsequent results may contain duplicates or missing records.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to be returned in a single page.
It is possible to receive fewer results than the specified limit on a given page.
The default value of 100 is also the maximum allowed value. If the provided value is
greater than 100, it is ignored and the default value is used instead.
Default: `100`
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Refunds
<details><summary><code>client.refunds.list() -> ListPaymentRefundsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a list of refunds for the account making the request.

Results are eventually consistent, and new refunds or changes to refunds might take several
seconds to appear.

The maximum results per page is 100.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.refunds().list(
    ListRefundsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**beginTime:** `Optional<String>` 

Indicates the start of the time range to retrieve each `PaymentRefund` for, in RFC 3339 
format.  The range is determined using the `created_at` field for each `PaymentRefund`. 

Default: The current time minus one year.
    
</dd>
</dl>

<dl>
<dd>

**endTime:** `Optional<String>` 

Indicates the end of the time range to retrieve each `PaymentRefund` for, in RFC 3339 
format.  The range is determined using the `created_at` field for each `PaymentRefund`.

Default: The current time.
    
</dd>
</dl>

<dl>
<dd>

**sortOrder:** `Optional<String>` 

The order in which results are listed by `PaymentRefund.created_at`:
- `ASC` - Oldest to newest.
- `DESC` - Newest to oldest (default).
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

A pagination cursor returned by a previous call to this endpoint.
Provide this cursor to retrieve the next set of results for the original query.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 

Limit results to the location supplied. By default, results are returned
for all locations associated with the seller.
    
</dd>
</dl>

<dl>
<dd>

**status:** `Optional<String>` 

If provided, only refunds with the given status are returned.
For a list of refund status values, see [PaymentRefund](entity:PaymentRefund).

Default: If omitted, refunds are returned regardless of their status.
    
</dd>
</dl>

<dl>
<dd>

**sourceType:** `Optional<String>` 

If provided, only returns refunds whose payments have the indicated source type.
Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`, `CASH`, and `EXTERNAL`.
For information about these payment source types, see
[Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).

Default: If omitted, refunds are returned regardless of the source type.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The maximum number of results to be returned in a single page.

It is possible to receive fewer results than the specified limit on a given page.

If the supplied value is greater than 100, no more than 100 results are returned.

Default: 100
    
</dd>
</dl>

<dl>
<dd>

**updatedAtBeginTime:** `Optional<String>` 

Indicates the start of the time range to retrieve each `PaymentRefund` for, in RFC 3339
format.  The range is determined using the `updated_at` field for each `PaymentRefund`.

Default: If omitted, the time range starts at `begin_time`.
    
</dd>
</dl>

<dl>
<dd>

**updatedAtEndTime:** `Optional<String>` 

Indicates the end of the time range to retrieve each `PaymentRefund` for, in RFC 3339
format.  The range is determined using the `updated_at` field for each `PaymentRefund`.

Default: The current time.
    
</dd>
</dl>

<dl>
<dd>

**sortField:** `Optional<ListPaymentRefundsRequestSortField>` — The field used to sort results by. The default is `CREATED_AT`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.refunds.refundPayment(request) -> RefundPaymentResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Refunds a payment. You can refund the entire payment amount or a
portion of it. You can use this endpoint to refund a card payment or record a 
refund of a cash or external payment. For more information, see
[Refund Payment](https://developer.squareup.com/docs/payments-api/refund-payments).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.refunds().refundPayment(
    RefundPaymentRequest
        .builder()
        .idempotencyKey("9b7f2dcf-49da-4411-b23e-a2d6af21333a")
        .amountMoney(
            Money
                .builder()
                .amount(1000L)
                .currency(Currency.USD)
                .build()
        )
        .appFeeMoney(
            Money
                .builder()
                .amount(10L)
                .currency(Currency.USD)
                .build()
        )
        .paymentId("R2B3Z8WMVt3EAmzYWLZvz7Y69EbZY")
        .reason("Example")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `String` 

 A unique string that identifies this `RefundPayment` request. The key can be any valid string
but must be unique for every `RefundPayment` request.

Keys are limited to a max of 45 characters - however, the number of allowed characters might be
less than 45, if multi-byte characters are used.

For more information, see [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**amountMoney:** `Money` 

The amount of money to refund.

This amount cannot be more than the `total_money` value of the payment minus the total
amount of all previously completed refunds for this payment.

This amount must be specified in the smallest denomination of the applicable currency
(for example, US dollar amounts are specified in cents). For more information, see
[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts).

The currency code must match the currency associated with the business
that is charging the card.
    
</dd>
</dl>

<dl>
<dd>

**appFeeMoney:** `Optional<Money>` 

The amount of money the developer contributes to help cover the refunded amount.
This amount is specified in the smallest denomination of the applicable currency (for example,
US dollar amounts are specified in cents).

The value cannot be more than the `amount_money`.

You can specify this parameter in a refund request only if the same parameter was also included
when taking the payment. This is part of the application fee scenario the API supports. For more
information, see [Take Payments and Collect Fees](https://developer.squareup.com/docs/payments-api/take-payments-and-collect-fees).

To set this field, `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission is required.
For more information, see [Permissions](https://developer.squareup.com/docs/payments-api/take-payments-and-collect-fees#permissions).
    
</dd>
</dl>

<dl>
<dd>

**paymentId:** `Optional<String>` 

The unique ID of the payment being refunded.
Required when unlinked=false, otherwise must not be set.
    
</dd>
</dl>

<dl>
<dd>

**destinationId:** `Optional<String>` 

The ID indicating where funds will be refunded to. Required for unlinked refunds. For more
information, see [Process an Unlinked Refund](https://developer.squareup.com/docs/refunds-api/unlinked-refunds).

For refunds linked to Square payments, `destination_id` is usually omitted; in this case, funds
will be returned to the original payment source. The field may be specified in order to request
a cross-method refund to a gift card. For more information,
see [Cross-method refunds to gift cards](https://developer.squareup.com/docs/payments-api/refund-payments#cross-method-refunds-to-gift-cards).
    
</dd>
</dl>

<dl>
<dd>

**unlinked:** `Optional<Boolean>` 

Indicates that the refund is not linked to a Square payment.
If set to true, `destination_id` and `location_id` must be supplied while `payment_id` must not
be provided.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `Optional<String>` 

The location ID associated with the unlinked refund.
Required for requests specifying `unlinked=true`.
Otherwise, if included when `unlinked=false`, will throw an error.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `Optional<String>` 

The [Customer](entity:Customer) ID of the customer associated with the refund.
This is required if the `destination_id` refers to a card on file created using the Cards
API. Only allowed when `unlinked=true`.
    
</dd>
</dl>

<dl>
<dd>

**reason:** `Optional<String>` — A description of the reason for the refund.
    
</dd>
</dl>

<dl>
<dd>

**paymentVersionToken:** `Optional<String>` 

 Used for optimistic concurrency. This opaque token identifies the current `Payment`
version that the caller expects. If the server has a different version of the Payment,
the update fails and a response with a VERSION_MISMATCH error is returned.
If the versions match, or the field is not provided, the refund proceeds as normal.
    
</dd>
</dl>

<dl>
<dd>

**teamMemberId:** `Optional<String>` — An optional [TeamMember](entity:TeamMember) ID to associate with this refund.
    
</dd>
</dl>

<dl>
<dd>

**cashDetails:** `Optional<DestinationDetailsCashRefundDetails>` — Additional details required when recording an unlinked cash refund (`destination_id` is CASH).
    
</dd>
</dl>

<dl>
<dd>

**externalDetails:** `Optional<DestinationDetailsExternalRefundDetails>` 

Additional details required when recording an unlinked external refund
(`destination_id` is EXTERNAL).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.refunds.get(refundId) -> GetPaymentRefundResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a specific refund using the `refund_id`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.refunds().get(
    GetRefundsRequest
        .builder()
        .refundId("refund_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**refundId:** `String` — The unique ID for the desired `PaymentRefund`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Sites
<details><summary><code>client.sites.list() -> ListSitesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists the Square Online sites that belong to a seller. Sites are listed in descending order by the `created_at` date.


__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.sites().list();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Snippets
<details><summary><code>client.snippets.get(siteId) -> GetSnippetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves your snippet from a Square Online site. A site can contain snippets from multiple snippet applications, but you can retrieve only the snippet that was added by your application.

You can call [ListSites](api-endpoint:Sites-ListSites) to get the IDs of the sites that belong to a seller.


__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.snippets().get(
    GetSnippetsRequest
        .builder()
        .siteId("site_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**siteId:** `String` — The ID of the site that contains the snippet.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.snippets.upsert(siteId, request) -> UpsertSnippetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Adds a snippet to a Square Online site or updates the existing snippet on the site. 
The snippet code is appended to the end of the `head` element on every page of the site, except checkout pages. A snippet application can add one snippet to a given site. 

You can call [ListSites](api-endpoint:Sites-ListSites) to get the IDs of the sites that belong to a seller.


__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.snippets().upsert(
    UpsertSnippetRequest
        .builder()
        .siteId("site_id")
        .snippet(
            Snippet
                .builder()
                .content("<script>var js = 1;</script>")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**siteId:** `String` — The ID of the site where you want to add or update the snippet.
    
</dd>
</dl>

<dl>
<dd>

**snippet:** `Snippet` — The snippet for the site.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.snippets.delete(siteId) -> DeleteSnippetResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Removes your snippet from a Square Online site.

You can call [ListSites](api-endpoint:Sites-ListSites) to get the IDs of the sites that belong to a seller.


__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.snippets().delete(
    DeleteSnippetsRequest
        .builder()
        .siteId("site_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**siteId:** `String` — The ID of the site that contains the snippet.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Subscriptions
<details><summary><code>client.subscriptions.create(request) -> CreateSubscriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Enrolls a customer in a subscription.

If you provide a card on file in the request, Square charges the card for
the subscription. Otherwise, Square sends an invoice to the customer's email
address. The subscription starts immediately, unless the request includes
the optional `start_date`. Each individual subscription is associated with a particular location.

For more information, see [Create a subscription](https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#create-a-subscription).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().create(
    CreateSubscriptionRequest
        .builder()
        .locationId("S8GWD5R9QB376")
        .customerId("CHFGVKYY8RSV93M5KCYTG4PN0G")
        .idempotencyKey("8193148c-9586-11e6-99f9-28cfe92138cf")
        .planVariationId("6JHXF3B2CW3YKHDV4XEM674H")
        .startDate("2023-06-20")
        .cardId("ccof:qy5x8hHGYsgLrp4Q4GB")
        .timezone("America/Los_Angeles")
        .source(
            SubscriptionSource
                .builder()
                .name("My Application")
                .build()
        )
        .phases(
            new ArrayList<Phase>(
                Arrays.asList(
                    Phase
                        .builder()
                        .ordinal(0L)
                        .orderTemplateId("U2NaowWxzXwpsZU697x7ZHOAnCNZY")
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**idempotencyKey:** `Optional<String>` 

A unique string that identifies this `CreateSubscription` request.
If you do not provide a unique string (or provide an empty string as the value),
the endpoint treats each request as independent.

For more information, see [Idempotency keys](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `String` — The ID of the location the subscription is associated with.
    
</dd>
</dl>

<dl>
<dd>

**planVariationId:** `Optional<String>` — The ID of the [subscription plan variation](https://developer.squareup.com/docs/subscriptions-api/plans-and-variations#plan-variations) created using the Catalog API.
    
</dd>
</dl>

<dl>
<dd>

**customerId:** `String` — The ID of the [customer](entity:Customer) subscribing to the subscription plan variation.
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `Optional<String>` 

The `YYYY-MM-DD`-formatted date to start the subscription. 
If it is unspecified, the subscription starts immediately.
    
</dd>
</dl>

<dl>
<dd>

**canceledDate:** `Optional<String>` 

The `YYYY-MM-DD`-formatted date when the newly created subscription is scheduled for cancellation. 

This date overrides the cancellation date set in the plan variation configuration.
If the cancellation date is earlier than the end date of a subscription cycle, the subscription stops
at the canceled date and the subscriber is sent a prorated invoice at the beginning of the canceled cycle. 

When the subscription plan of the newly created subscription has a fixed number of cycles and the `canceled_date`
occurs before the subscription plan expires, the specified `canceled_date` sets the date when the subscription 
stops through the end of the last cycle.
    
</dd>
</dl>

<dl>
<dd>

**taxPercentage:** `Optional<String>` 

The tax to add when billing the subscription.
The percentage is expressed in decimal form, using a `'.'` as the decimal
separator and without a `'%'` sign. For example, a value of 7.5
corresponds to 7.5%.
    
</dd>
</dl>

<dl>
<dd>

**priceOverrideMoney:** `Optional<Money>` 

A custom price which overrides the cost of a subscription plan variation with `STATIC` pricing.
This field does not affect itemized subscriptions with `RELATIVE` pricing. Instead, 
you should edit the Subscription's [order template](https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#phases-and-order-templates).
    
</dd>
</dl>

<dl>
<dd>

**cardId:** `Optional<String>` 

The ID of the [subscriber's](entity:Customer) [card](entity:Card) to charge.
If it is not specified, the subscriber receives an invoice via email with a link to pay for their subscription.
    
</dd>
</dl>

<dl>
<dd>

**timezone:** `Optional<String>` 

The timezone that is used in date calculations for the subscription. If unset, defaults to
the location timezone. If a timezone is not configured for the location, defaults to "America/New_York".
Format: the IANA Timezone Database identifier for the location timezone. For
a list of time zones, see [List of tz database time zones](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones).
    
</dd>
</dl>

<dl>
<dd>

**source:** `Optional<SubscriptionSource>` — The origination details of the subscription.
    
</dd>
</dl>

<dl>
<dd>

**monthlyBillingAnchorDate:** `Optional<Integer>` — The day-of-the-month to change the billing date to.
    
</dd>
</dl>

<dl>
<dd>

**phases:** `Optional<List<Phase>>` — array of phases for this subscription
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.bulkSwapPlan(request) -> BulkSwapPlanResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Schedules a plan variation change for all active subscriptions under a given plan
variation. For more information, see [Swap Subscription Plan Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().bulkSwapPlan(
    BulkSwapPlanRequest
        .builder()
        .newPlanVariationId("FQ7CDXXWSLUJRPM3GFJSJGZ7")
        .oldPlanVariationId("6JHXF3B2CW3YKHDV4XEM674H")
        .locationId("S8GWD5R9QB376")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**newPlanVariationId:** `String` 

The ID of the new subscription plan variation.

This field is required.
    
</dd>
</dl>

<dl>
<dd>

**oldPlanVariationId:** `String` 

The ID of the plan variation whose subscriptions should be swapped. Active subscriptions
using this plan variation will be subscribed to the new plan variation on their next billing
day.
    
</dd>
</dl>

<dl>
<dd>

**locationId:** `String` — The ID of the location to associate with the swapped subscriptions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.search(request) -> SearchSubscriptionsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Searches for subscriptions.

Results are ordered chronologically by subscription creation date. If
the request specifies more than one location ID,
the endpoint orders the result
by location ID, and then by creation date within each location. If no locations are given
in the query, all locations are searched.

You can also optionally specify `customer_ids` to search by customer.
If left unset, all customers
associated with the specified locations are returned.
If the request specifies customer IDs, the endpoint orders results
first by location, within location by customer ID, and within
customer by subscription creation date.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().search(
    SearchSubscriptionsRequest
        .builder()
        .query(
            SearchSubscriptionsQuery
                .builder()
                .filter(
                    SearchSubscriptionsFilter
                        .builder()
                        .customerIds(
                            new ArrayList<String>(
                                Arrays.asList("CHFGVKYY8RSV93M5KCYTG4PN0G")
                            )
                        )
                        .locationIds(
                            new ArrayList<String>(
                                Arrays.asList("S8GWD5R9QB376")
                            )
                        )
                        .sourceNames(
                            new ArrayList<String>(
                                Arrays.asList("My App")
                            )
                        )
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

When the total number of resulting subscriptions exceeds the limit of a paged response, 
specify the cursor returned from a preceding response here to fetch the next set of results.
If the cursor is unset, the response contains the last page of the results.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The upper limit on the number of subscriptions to return
in a paged response.
    
</dd>
</dl>

<dl>
<dd>

**query:** `Optional<SearchSubscriptionsQuery>` 

A subscription query consisting of specified filtering conditions.

If this `query` field is unspecified, the `SearchSubscriptions` call will return all subscriptions.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<List<String>>` 

An option to include related information in the response. 

The supported values are: 

- `actions`: to include scheduled actions on the targeted subscriptions.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.get(subscriptionId) -> GetSubscriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a specific subscription.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().get(
    GetSubscriptionsRequest
        .builder()
        .subscriptionId("subscription_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to retrieve.
    
</dd>
</dl>

<dl>
<dd>

**include:** `Optional<String>` 

A query parameter to specify related information to be included in the response. 

The supported query parameter values are: 

- `actions`: to include scheduled actions on the targeted subscription.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.update(subscriptionId, request) -> UpdateSubscriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a subscription by modifying or clearing `subscription` field values.
To clear a field, set its value to `null`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().update(
    UpdateSubscriptionRequest
        .builder()
        .subscriptionId("subscription_id")
        .subscription(
            Subscription
                .builder()
                .cardId("{NEW CARD ID}")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to update.
    
</dd>
</dl>

<dl>
<dd>

**subscription:** `Optional<Subscription>` 

The subscription object containing the current version, and fields to update.
Unset fields will be left at their current server values, and JSON `null` values will
be treated as a request to clear the relevant data.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.deleteAction(subscriptionId, actionId) -> DeleteSubscriptionActionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Deletes a scheduled action for a subscription.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().deleteAction(
    DeleteActionSubscriptionsRequest
        .builder()
        .subscriptionId("subscription_id")
        .actionId("action_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription the targeted action is to act upon.
    
</dd>
</dl>

<dl>
<dd>

**actionId:** `String` — The ID of the targeted action to be deleted.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.changeBillingAnchorDate(subscriptionId, request) -> ChangeBillingAnchorDateResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Changes the [billing anchor date](https://developer.squareup.com/docs/subscriptions-api/subscription-billing#billing-dates)
for a subscription.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().changeBillingAnchorDate(
    ChangeBillingAnchorDateRequest
        .builder()
        .subscriptionId("subscription_id")
        .monthlyBillingAnchorDate(1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to update the billing anchor date.
    
</dd>
</dl>

<dl>
<dd>

**monthlyBillingAnchorDate:** `Optional<Integer>` — The anchor day for the billing cycle.
    
</dd>
</dl>

<dl>
<dd>

**effectiveDate:** `Optional<String>` 

The `YYYY-MM-DD`-formatted date when the scheduled `BILLING_ANCHOR_CHANGE` action takes
place on the subscription.

When this date is unspecified or falls within the current billing cycle, the billing anchor date
is changed immediately.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.cancel(subscriptionId) -> CancelSubscriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Schedules a `CANCEL` action to cancel an active subscription. This 
sets the `canceled_date` field to the end of the active billing period. After this date, 
the subscription status changes from ACTIVE to CANCELED.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().cancel(
    CancelSubscriptionsRequest
        .builder()
        .subscriptionId("subscription_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to cancel.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.listEvents(subscriptionId) -> ListSubscriptionEventsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists all [events](https://developer.squareup.com/docs/subscriptions-api/actions-events) for a specific subscription.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().listEvents(
    ListEventsSubscriptionsRequest
        .builder()
        .subscriptionId("subscription_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to retrieve the events for.
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

When the total number of resulting subscription events exceeds the limit of a paged response, 
specify the cursor returned from a preceding response here to fetch the next set of results.
If the cursor is unset, the response contains the last page of the results.

For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` 

The upper limit on the number of subscription events to return
in a paged response.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.pause(subscriptionId, request) -> PauseSubscriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Schedules a `PAUSE` action to pause an active subscription.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().pause(
    PauseSubscriptionRequest
        .builder()
        .subscriptionId("subscription_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to pause.
    
</dd>
</dl>

<dl>
<dd>

**pauseEffectiveDate:** `Optional<String>` 

The `YYYY-MM-DD`-formatted date when the scheduled `PAUSE` action takes place on the subscription.

When this date is unspecified or falls within the current billing cycle, the subscription is paused
on the starting date of the next billing cycle.
    
</dd>
</dl>

<dl>
<dd>

**pauseCycleDuration:** `Optional<Integer>` 

The number of billing cycles the subscription will be paused before it is reactivated. 

When this is set, a `RESUME` action is also scheduled to take place on the subscription at 
the end of the specified pause cycle duration. In this case, neither `resume_effective_date` 
nor `resume_change_timing` may be specified.
    
</dd>
</dl>

<dl>
<dd>

**resumeEffectiveDate:** `Optional<String>` 

The date when the subscription is reactivated by a scheduled `RESUME` action. 
This date must be at least one billing cycle ahead of `pause_effective_date`.
    
</dd>
</dl>

<dl>
<dd>

**resumeChangeTiming:** `Optional<ChangeTiming>` 

The timing whether the subscription is reactivated immediately or at the end of the billing cycle, relative to 
`resume_effective_date`.
See [ChangeTiming](#type-changetiming) for possible values
    
</dd>
</dl>

<dl>
<dd>

**pauseReason:** `Optional<String>` — The user-provided reason to pause the subscription.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.resume(subscriptionId, request) -> ResumeSubscriptionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Schedules a `RESUME` action to resume a paused or a deactivated subscription.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().resume(
    ResumeSubscriptionRequest
        .builder()
        .subscriptionId("subscription_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to resume.
    
</dd>
</dl>

<dl>
<dd>

**resumeEffectiveDate:** `Optional<String>` — The `YYYY-MM-DD`-formatted date when the subscription reactivated.
    
</dd>
</dl>

<dl>
<dd>

**resumeChangeTiming:** `Optional<ChangeTiming>` 

The timing to resume a subscription, relative to the specified
`resume_effective_date` attribute value.
See [ChangeTiming](#type-changetiming) for possible values
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.subscriptions.swapPlan(subscriptionId, request) -> SwapPlanResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Schedules a `SWAP_PLAN` action to swap a subscription plan variation in an existing subscription. 
For more information, see [Swap Subscription Plan Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.subscriptions().swapPlan(
    SwapPlanRequest
        .builder()
        .subscriptionId("subscription_id")
        .newPlanVariationId("FQ7CDXXWSLUJRPM3GFJSJGZ7")
        .phases(
            new ArrayList<PhaseInput>(
                Arrays.asList(
                    PhaseInput
                        .builder()
                        .ordinal(0L)
                        .orderTemplateId("uhhnjH9osVv3shUADwaC0b3hNxQZY")
                        .build()
                )
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**subscriptionId:** `String` — The ID of the subscription to swap the subscription plan for.
    
</dd>
</dl>

<dl>
<dd>

**newPlanVariationId:** `Optional<String>` 

The ID of the new subscription plan variation.

This field is required.
    
</dd>
</dl>

<dl>
<dd>

**phases:** `Optional<List<PhaseInput>>` — A list of PhaseInputs, to pass phase-specific information used in the swap.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## TeamMembers
<details><summary><code>client.teamMembers.create(request) -> CreateTeamMemberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a single `TeamMember` object. The `TeamMember` object is returned on successful creates.
You must provide the following values in your request to this endpoint:
- `given_name`
- `family_name`

Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#createteammember).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.teamMembers().create(
    CreateTeamMemberRequest
        .builder()
        .idempotencyKey("idempotency-key-0")
        .teamMember(
            TeamMember
                .builder()
                .referenceId("reference_id_1")
                .status(TeamMemberStatus.ACTIVE)
                .givenName("Joe")
                .familyName("Doe")
                .emailAddress("joe_doe@gmail.com")
                .phoneNumber("+14159283333")
                .assignedLocations(
                    TeamMemberAssignedLocations
                        .builder()
                        .assignmentType(TeamMemberAssignedLocationsAssignmentType.EXPLICIT_LOCATIONS)
                        .locationIds(
                            new ArrayList<String>(
                                Arrays.asList("YSGH2WBKG94QZ", "GA2Y9HSJ8KRYT")
                            )
                        )
                        .build()
                )
                .wageSetting(
                    WageSetting
                        .builder()
                        .jobAssignments(
                            new ArrayList<JobAssignment>(
                                Arrays.asList(
                                    JobAssignment
                                        .builder()
                                        .payType(JobAssignmentPayType.SALARY)
                                        .annualRate(
                                            Money
                                                .builder()
                                                .amount(3000000L)
                                                .currency(Currency.USD)
                                                .build()
                                        )
                                        .weeklyHours(40)
                                        .jobId("FjS8x95cqHiMenw4f1NAUH4P")
                                        .build(),
                                    JobAssignment
                                        .builder()
                                        .payType(JobAssignmentPayType.HOURLY)
                                        .hourlyRate(
                                            Money
                                                .builder()
                                                .amount(2000L)
                                                .currency(Currency.USD)
                                                .build()
                                        )
                                        .jobId("VDNpRv8da51NU8qZFC5zDWpF")
                                        .build()
                                )
                            )
                        )
                        .isOvertimeExempt(true)
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**request:** `CreateTeamMemberRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.teamMembers.batchCreate(request) -> BatchCreateTeamMembersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates multiple `TeamMember` objects. The created `TeamMember` objects are returned on successful creates.
This process is non-transactional and processes as much of the request as possible. If one of the creates in
the request cannot be successfully processed, the request is not marked as failed, but the body of the response
contains explicit error information for the failed create.

Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#bulk-create-team-members).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.teamMembers().batchCreate(
    BatchCreateTeamMembersRequest
        .builder()
        .teamMembers(
            new HashMap<String, CreateTeamMemberRequest>() {{
                put("idempotency-key-1", CreateTeamMemberRequest
                    .builder()
                    .teamMember(
                        Optional.of(
                            TeamMember
                                .builder()
                                .referenceId(Optional.of("reference_id_1"))
                                .givenName(Optional.of("Joe"))
                                .familyName(Optional.of("Doe"))
                                .emailAddress(Optional.of("joe_doe@gmail.com"))
                                .phoneNumber(Optional.of("+14159283333"))
                                .assignedLocations(
                                    Optional.of(
                                        TeamMemberAssignedLocations
                                            .builder()
                                            .assignmentType(Optional.of(TeamMemberAssignedLocationsAssignmentType.EXPLICIT_LOCATIONS))
                                            .locationIds(
                                                Optional.of(
                                                    new ArrayList<String>(
                                                        Arrays.asList("YSGH2WBKG94QZ", "GA2Y9HSJ8KRYT")
                                                    )
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build());
                put("idempotency-key-2", CreateTeamMemberRequest
                    .builder()
                    .teamMember(
                        Optional.of(
                            TeamMember
                                .builder()
                                .referenceId(Optional.of("reference_id_2"))
                                .givenName(Optional.of("Jane"))
                                .familyName(Optional.of("Smith"))
                                .emailAddress(Optional.of("jane_smith@gmail.com"))
                                .phoneNumber(Optional.of("+14159223334"))
                                .assignedLocations(
                                    Optional.of(
                                        TeamMemberAssignedLocations
                                            .builder()
                                            .assignmentType(Optional.of(TeamMemberAssignedLocationsAssignmentType.ALL_CURRENT_AND_FUTURE_LOCATIONS))
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build());
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**teamMembers:** `Map<String, CreateTeamMemberRequest>` 

The data used to create the `TeamMember` objects. Each key is the `idempotency_key` that maps to the `CreateTeamMemberRequest`.
The maximum number of create objects is 25.

If you include a team member's `wage_setting`, you must provide `job_id` for each job assignment. To get job IDs,
call [ListJobs](api-endpoint:Team-ListJobs).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.teamMembers.batchUpdate(request) -> BatchUpdateTeamMembersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates multiple `TeamMember` objects. The updated `TeamMember` objects are returned on successful updates.
This process is non-transactional and processes as much of the request as possible. If one of the updates in
the request cannot be successfully processed, the request is not marked as failed, but the body of the response
contains explicit error information for the failed update.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#bulk-update-team-members).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.teamMembers().batchUpdate(
    BatchUpdateTeamMembersRequest
        .builder()
        .teamMembers(
            new HashMap<String, UpdateTeamMemberRequest>() {{
                put("AFMwA08kR-MIF-3Vs0OE", UpdateTeamMemberRequest
                    .builder()
                    .teamMember(
                        Optional.of(
                            TeamMember
                                .builder()
                                .referenceId(Optional.of("reference_id_2"))
                                .isOwner(Optional.of(false))
                                .status(Optional.of(TeamMemberStatus.ACTIVE))
                                .givenName(Optional.of("Jane"))
                                .familyName(Optional.of("Smith"))
                                .emailAddress(Optional.of("jane_smith@gmail.com"))
                                .phoneNumber(Optional.of("+14159223334"))
                                .assignedLocations(
                                    Optional.of(
                                        TeamMemberAssignedLocations
                                            .builder()
                                            .assignmentType(Optional.of(TeamMemberAssignedLocationsAssignmentType.ALL_CURRENT_AND_FUTURE_LOCATIONS))
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build());
                put("fpgteZNMaf0qOK-a4t6P", UpdateTeamMemberRequest
                    .builder()
                    .teamMember(
                        Optional.of(
                            TeamMember
                                .builder()
                                .referenceId(Optional.of("reference_id_1"))
                                .isOwner(Optional.of(false))
                                .status(Optional.of(TeamMemberStatus.ACTIVE))
                                .givenName(Optional.of("Joe"))
                                .familyName(Optional.of("Doe"))
                                .emailAddress(Optional.of("joe_doe@gmail.com"))
                                .phoneNumber(Optional.of("+14159283333"))
                                .assignedLocations(
                                    Optional.of(
                                        TeamMemberAssignedLocations
                                            .builder()
                                            .assignmentType(Optional.of(TeamMemberAssignedLocationsAssignmentType.EXPLICIT_LOCATIONS))
                                            .locationIds(
                                                Optional.of(
                                                    new ArrayList<String>(
                                                        Arrays.asList("YSGH2WBKG94QZ", "GA2Y9HSJ8KRYT")
                                                    )
                                                )
                                            )
                                            .build()
                                    )
                                )
                                .build()
                        )
                    )
                    .build());
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**teamMembers:** `Map<String, UpdateTeamMemberRequest>` 

The data used to update the `TeamMember` objects. Each key is the `team_member_id` that maps to the `UpdateTeamMemberRequest`.
The maximum number of update objects is 25.

For each team member, include the fields to add, change, or clear. Fields can be cleared using a null value.
To update `wage_setting.job_assignments`, you must provide the complete list of job assignments. If needed,
call [ListJobs](api-endpoint:Team-ListJobs) to get the required `job_id` values.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.teamMembers.search(request) -> SearchTeamMembersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns a paginated list of `TeamMember` objects for a business. 
The list can be filtered by location IDs, `ACTIVE` or `INACTIVE` status, or whether
the team member is the Square account owner.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.teamMembers().search(
    SearchTeamMembersRequest
        .builder()
        .query(
            SearchTeamMembersQuery
                .builder()
                .filter(
                    SearchTeamMembersFilter
                        .builder()
                        .locationIds(
                            new ArrayList<String>(
                                Arrays.asList("0G5P3VGACMMQZ")
                            )
                        )
                        .status(TeamMemberStatus.ACTIVE)
                        .build()
                )
                .build()
        )
        .limit(10)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**query:** `Optional<SearchTeamMembersQuery>` — The query parameters.
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The maximum number of `TeamMember` objects in a page (100 by default).
    
</dd>
</dl>

<dl>
<dd>

**cursor:** `Optional<String>` 

The opaque cursor for fetching the next page. For more information, see
[pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.teamMembers.get(teamMemberId) -> GetTeamMemberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a `TeamMember` object for the given `TeamMember.id`.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#retrieve-a-team-member).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.teamMembers().get(
    GetTeamMembersRequest
        .builder()
        .teamMemberId("team_member_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**teamMemberId:** `String` — The ID of the team member to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.teamMembers.update(teamMemberId, request) -> UpdateTeamMemberResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates a single `TeamMember` object. The `TeamMember` object is returned on successful updates.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#update-a-team-member).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.teamMembers().update(
    UpdateTeamMembersRequest
        .builder()
        .teamMemberId("team_member_id")
        .body(
            UpdateTeamMemberRequest
                .builder()
                .teamMember(
                    TeamMember
                        .builder()
                        .referenceId("reference_id_1")
                        .status(TeamMemberStatus.ACTIVE)
                        .givenName("Joe")
                        .familyName("Doe")
                        .emailAddress("joe_doe@gmail.com")
                        .phoneNumber("+14159283333")
                        .assignedLocations(
                            TeamMemberAssignedLocations
                                .builder()
                                .assignmentType(TeamMemberAssignedLocationsAssignmentType.EXPLICIT_LOCATIONS)
                                .locationIds(
                                    new ArrayList<String>(
                                        Arrays.asList("YSGH2WBKG94QZ", "GA2Y9HSJ8KRYT")
                                    )
                                )
                                .build()
                        )
                        .wageSetting(
                            WageSetting
                                .builder()
                                .jobAssignments(
                                    new ArrayList<JobAssignment>(
                                        Arrays.asList(
                                            JobAssignment
                                                .builder()
                                                .payType(JobAssignmentPayType.SALARY)
                                                .annualRate(
                                                    Money
                                                        .builder()
                                                        .amount(3000000L)
                                                        .currency(Currency.USD)
                                                        .build()
                                                )
                                                .weeklyHours(40)
                                                .jobId("FjS8x95cqHiMenw4f1NAUH4P")
                                                .build(),
                                            JobAssignment
                                                .builder()
                                                .payType(JobAssignmentPayType.HOURLY)
                                                .hourlyRate(
                                                    Money
                                                        .builder()
                                                        .amount(1200L)
                                                        .currency(Currency.USD)
                                                        .build()
                                                )
                                                .jobId("VDNpRv8da51NU8qZFC5zDWpF")
                                                .build()
                                        )
                                    )
                                )
                                .isOvertimeExempt(true)
                                .build()
                        )
                        .build()
                )
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**teamMemberId:** `String` — The ID of the team member to update.
    
</dd>
</dl>

<dl>
<dd>

**request:** `UpdateTeamMemberRequest` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Team
<details><summary><code>client.team.listJobs() -> ListJobsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists jobs in a seller account. Results are sorted by title in ascending order.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.team().listJobs(
    ListJobsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**cursor:** `Optional<String>` 

The pagination cursor returned by the previous call to this endpoint. Provide this
cursor to retrieve the next page of results for your original request. For more information,
see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.createJob(request) -> CreateJobResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates a job in a seller account. A job defines a title and tip eligibility. Note that
compensation is defined in a [job assignment](entity:JobAssignment) in a team member's wage setting.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.team().createJob(
    CreateJobRequest
        .builder()
        .job(
            Job
                .builder()
                .title("Cashier")
                .isTipEligible(true)
                .build()
        )
        .idempotencyKey("idempotency-key-0")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**job:** `Job` — The job to create. The `title` field is required and `is_tip_eligible` defaults to true.
    
</dd>
</dl>

<dl>
<dd>

**idempotencyKey:** `String` 

A unique identifier for the `CreateJob` request. Keys can be any valid string,
but must be unique for each request. For more information, see
[Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.retrieveJob(jobId) -> RetrieveJobResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Retrieves a specified job.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.team().retrieveJob(
    RetrieveJobRequest
        .builder()
        .jobId("job_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**jobId:** `String` — The ID of the job to retrieve.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.team.updateJob(jobId, request) -> UpdateJobResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Updates the title or tip eligibility of a job. Changes to the title propagate to all
`JobAssignment`, `Shift`, and `TeamMemberWage` objects that reference the job ID. Changes to
tip eligibility propagate to all `TeamMemberWage` objects that reference the job ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.team().updateJob(
    UpdateJobRequest
        .builder()
        .jobId("job_id")
        .job(
            Job
                .builder()
                .title("Cashier 1")
                .isTipEligible(true)
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**jobId:** `String` — The ID of the job to update.
    
</dd>
</dl>

<dl>
<dd>

**job:** `Job` 

The job with the updated fields, either `title`, `is_tip_eligible`, or both. Only changed fields need
to be included in the request. Optionally include `version` to enable optimistic concurrency control.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Terminal
<details><summary><code>client.terminal.dismissTerminalAction(actionId) -> DismissTerminalActionResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Dismisses a Terminal action request if the status and type of the request permits it.

See [Link and Dismiss Actions](https://developer.squareup.com/docs/terminal-api/advanced-features/custom-workflows/link-and-dismiss-actions) for more details.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.terminal().dismissTerminalAction(
    DismissTerminalActionRequest
        .builder()
        .actionId("action_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**actionId:** `String` — Unique ID for the `TerminalAction` associated with the action to be dismissed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.terminal.dismissTerminalCheckout(checkoutId) -> DismissTerminalCheckoutResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Dismisses a Terminal checkout request if the status and type of the request permits it.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.terminal().dismissTerminalCheckout(
    DismissTerminalCheckoutRequest
        .builder()
        .checkoutId("checkout_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**checkoutId:** `String` — Unique ID for the `TerminalCheckout` associated with the checkout to be dismissed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.terminal.dismissTerminalRefund(terminalRefundId) -> DismissTerminalRefundResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Dismisses a Terminal refund request if the status and type of the request permits it.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.terminal().dismissTerminalRefund(
    DismissTerminalRefundRequest
        .builder()
        .terminalRefundId("terminal_refund_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**terminalRefundId:** `String` — Unique ID for the `TerminalRefund` associated with the refund to be dismissed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Vendors
<details><summary><code>client.vendors.batchCreate(request) -> BatchCreateVendorsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Creates one or more [Vendor](entity:Vendor) objects to represent suppliers to a seller.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.vendors().batchCreate(
    BatchCreateVendorsRequest
        .builder()
        .vendors(
            new HashMap<String, Vendor>() {{
                put("8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe", Vendor
                    .builder()
                    .name(Optional.of("Joe's Fresh Seafood"))
                    .address(
                        Optional.of(
                            Address
                                .builder()
                                .addressLine1(Optional.of("505 Electric Ave"))
                                .addressLine2(Optional.of("Suite 600"))
                                .locality(Optional.of("New York"))
                                .administrativeDistrictLevel1(Optional.of("NY"))
                                .postalCode(Optional.of("10003"))
                                .country(Optional.of(Country.US))
                                .build()
                        )
                    )
                    .contacts(
                        Optional.of(
                            new ArrayList<VendorContact>(
                                Arrays.asList(
                                    VendorContact
                                        .builder()
                                        .ordinal(1)
                                        .name("Joe Burrow")
                                        .emailAddress("joe@joesfreshseafood.com")
                                        .phoneNumber("1-212-555-4250")
                                        .build()
                                )
                            )
                        )
                    )
                    .accountNumber(Optional.of("4025391"))
                    .note(Optional.of("a vendor"))
                    .build());
            }}
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**vendors:** `Map<String, Vendor>` — Specifies a set of new [Vendor](entity:Vendor) objects as represented by a collection of idempotency-key/`Vendor`-object pairs.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>