
# Client Class Documentation

The following parameters are configurable for the API Client:

| Parameter | Type | Description |
|  --- | --- | --- |
| `squareVersion` | `String` | Square Connect API versions<br>*Default*: `"2024-05-15"` |
| `customUrl` | `String` | Sets the base URL requests are made to. Defaults to `https://connect.squareup.com`<br>*Default*: `"https://connect.squareup.com"` |
| `environment` | `string` | The API environment. <br> **Default: `production`** |
| `httpClientConfig` | [`ReadonlyHttpClientConfiguration`](http-client-configuration.md) | Http Client Configuration instance. |
| `additionalHeaders` | [`Headers`](headers.md) | Additional headers to add to each API request.<br>*Default*: `new Headers()` |
| `userAgentDetail` | `String` | Additional detail which can be appended with User-Agent header.<br>*Default*: `"null"` |
| `bearerAuthCredentials` | [`BearerAuthCredentials`](auth/oauth-2-bearer-token.md) | The Credentials Setter for OAuth 2 Bearer token |

The API client can be initialized as follows:

```java
SquareClient client = new SquareClient.Builder()
    .httpClientConfig(configBuilder -> configBuilder
            .timeout(0))
    .squareVersion("2024-05-15")
    .bearerAuthCredentials(new BearerAuthModel.Builder(
            "AccessToken"
        )
        .build())
    .environment(Environment.PRODUCTION)
    .customUrl("https://connect.squareup.com")
    .build();
```

## Make Calls with the API Client

```java
package com.example;

import com.squareup.square.SquareClient;
import com.squareup.square.api.LocationsApi;
import com.squareup.square.authentication.BearerAuthModel;

public class Program {

    public static void main(String[] args) {
        SquareClient client = new SquareClient.Builder()
            .httpClientConfig(configBuilder -> configBuilder
                    .timeout(0))
            .squareVersion("2024-05-15")
            .bearerAuthCredentials(new BearerAuthModel.Builder(
                    "AccessToken"
                )
                .build())
            .build();

        LocationsApi locationsApi = client.getLocationsApi();

        locationsApi.listLocationsAsync().thenAccept(result -> {
            // TODO success callback handler
            System.out.println(result);
        }).exceptionally(exception -> {
            // TODO failure callback handler
            exception.printStackTrace();
            return null;
        });
    }
}
```

## SquareClient Class

The gateway for the SDK. This class acts as a factory for the Apis and also holds the configuration of the SDK.

### API

| Name | Description | Return Type |
|  --- | --- | --- |
| `getMobileAuthorizationApi()` | Provides access to MobileAuthorization controller. | `MobileAuthorizationApi` |
| `getOAuthApi()` | Provides access to OAuth controller. | `OAuthApi` |
| `getV1TransactionsApi()` | Provides access to V1Transactions controller. | `V1TransactionsApi` |
| `getApplePayApi()` | Provides access to ApplePay controller. | `ApplePayApi` |
| `getBankAccountsApi()` | Provides access to BankAccounts controller. | `BankAccountsApi` |
| `getBookingsApi()` | Provides access to Bookings controller. | `BookingsApi` |
| `getBookingCustomAttributesApi()` | Provides access to BookingCustomAttributes controller. | `BookingCustomAttributesApi` |
| `getCardsApi()` | Provides access to Cards controller. | `CardsApi` |
| `getCashDrawersApi()` | Provides access to CashDrawers controller. | `CashDrawersApi` |
| `getCatalogApi()` | Provides access to Catalog controller. | `CatalogApi` |
| `getCustomersApi()` | Provides access to Customers controller. | `CustomersApi` |
| `getCustomerCustomAttributesApi()` | Provides access to CustomerCustomAttributes controller. | `CustomerCustomAttributesApi` |
| `getCustomerGroupsApi()` | Provides access to CustomerGroups controller. | `CustomerGroupsApi` |
| `getCustomerSegmentsApi()` | Provides access to CustomerSegments controller. | `CustomerSegmentsApi` |
| `getDevicesApi()` | Provides access to Devices controller. | `DevicesApi` |
| `getDisputesApi()` | Provides access to Disputes controller. | `DisputesApi` |
| `getEmployeesApi()` | Provides access to Employees controller. | `EmployeesApi` |
| `getGiftCardsApi()` | Provides access to GiftCards controller. | `GiftCardsApi` |
| `getGiftCardActivitiesApi()` | Provides access to GiftCardActivities controller. | `GiftCardActivitiesApi` |
| `getInventoryApi()` | Provides access to Inventory controller. | `InventoryApi` |
| `getInvoicesApi()` | Provides access to Invoices controller. | `InvoicesApi` |
| `getLaborApi()` | Provides access to Labor controller. | `LaborApi` |
| `getLocationsApi()` | Provides access to Locations controller. | `LocationsApi` |
| `getLocationCustomAttributesApi()` | Provides access to LocationCustomAttributes controller. | `LocationCustomAttributesApi` |
| `getCheckoutApi()` | Provides access to Checkout controller. | `CheckoutApi` |
| `getTransactionsApi()` | Provides access to Transactions controller. | `TransactionsApi` |
| `getLoyaltyApi()` | Provides access to Loyalty controller. | `LoyaltyApi` |
| `getMerchantsApi()` | Provides access to Merchants controller. | `MerchantsApi` |
| `getMerchantCustomAttributesApi()` | Provides access to MerchantCustomAttributes controller. | `MerchantCustomAttributesApi` |
| `getOrdersApi()` | Provides access to Orders controller. | `OrdersApi` |
| `getOrderCustomAttributesApi()` | Provides access to OrderCustomAttributes controller. | `OrderCustomAttributesApi` |
| `getPaymentsApi()` | Provides access to Payments controller. | `PaymentsApi` |
| `getPayoutsApi()` | Provides access to Payouts controller. | `PayoutsApi` |
| `getRefundsApi()` | Provides access to Refunds controller. | `RefundsApi` |
| `getSitesApi()` | Provides access to Sites controller. | `SitesApi` |
| `getSnippetsApi()` | Provides access to Snippets controller. | `SnippetsApi` |
| `getSubscriptionsApi()` | Provides access to Subscriptions controller. | `SubscriptionsApi` |
| `getTeamApi()` | Provides access to Team controller. | `TeamApi` |
| `getTerminalApi()` | Provides access to Terminal controller. | `TerminalApi` |
| `getVendorsApi()` | Provides access to Vendors controller. | `VendorsApi` |
| `getWebhookSubscriptionsApi()` | Provides access to WebhookSubscriptions controller. | `WebhookSubscriptionsApi` |

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `shutdown()` | Shutdown the underlying HttpClient instance. | `void` |
| `getEnvironment()` | Current API environment. | `Environment` |
| `getCustomUrl()` | Sets the base URL requests are made to. Defaults to `https://connect.squareup.com` | `String` |
| `getSquareVersion()` | Square Connect API versions. | `String` |
| `getHttpClient()` | The HTTP Client instance to use for making HTTP requests. | `HttpClient` |
| `getHttpClientConfig()` | Http Client Configuration instance. | [`ReadonlyHttpClientConfiguration`](http-client-configuration.md) |
| `getAdditionalHeaders()` | Additional headers to add to each API request. | [`Headers`](headers.md) |
| `getUserAgentDetail()` | Additional detail which can be appended with User-Agent header. | `String` |
| `getBearerAuthCredentials()` | The credentials to use with BearerAuth. | [`BearerAuthCredentials`](auth/oauth-2-bearer-token.md) |
| `getAccessToken()` | OAuth 2.0 Access Token. | `String` |
| `getSdkVersion()` | Current SDK Version. | `String` |
| `getBaseUri(Server server)` | Get base URI by current environment | `String` |
| `getBaseUri()` | Get base URI by current environment | `String` |

