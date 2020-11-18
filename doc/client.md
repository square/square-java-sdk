
# Client Class Documentation

The following parameters are configurable for the API Client:

| Parameter | Type | Description |
|  --- | --- | --- |
| `squareVersion` | `String` | Square Connect API versions<br>*Default*: `"2020-11-18"` |
| `environment` | `string` | The API environment. <br> **Default: `production`** |

The API client can be initialized as follows:

```java
SquareClient client = new SquareClient.Builder()
    .squareVersion("2020-11-18")
    .accessToken("AccessToken")
    .environment(Environment.PRODUCTION)
    .build();
```

## Make Calls with the API Client

```java
package com.example;

import java.util.*;
import java.io.*;

import com.squareup.square.*;
import com.squareup.square.models.*;
import com.squareup.square.api.*;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.*;

public class Program {

    public static void main(String[] args) {
        SquareClient client = new SquareClient.Builder()
            .squareVersion("2020-11-18")
            .accessToken("AccessToken")
            .build();
        
        LocationsApi locationsApi = client.getLocationsApi();
        
        locationsApi.listLocationsAsync().thenAccept(result -> {
            // TODO success callback handler
        }).exceptionally(exception -> {
            // TODO failure callback handler
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
| `getV1LocationsApi()` | Provides access to V1Locations controller. | `V1LocationsApi` |
| `getV1EmployeesApi()` | Provides access to V1Employees controller. | `V1EmployeesApi` |
| `getV1TransactionsApi()` | Provides access to V1Transactions controller. | `V1TransactionsApi` |
| `getV1ItemsApi()` | Provides access to V1Items controller. | `V1ItemsApi` |
| `getApplePayApi()` | Provides access to ApplePay controller. | `ApplePayApi` |
| `getBankAccountsApi()` | Provides access to BankAccounts controller. | `BankAccountsApi` |
| `getBookingsApi()` | Provides access to Bookings controller. | `BookingsApi` |
| `getCashDrawersApi()` | Provides access to CashDrawers controller. | `CashDrawersApi` |
| `getCatalogApi()` | Provides access to Catalog controller. | `CatalogApi` |
| `getCustomersApi()` | Provides access to Customers controller. | `CustomersApi` |
| `getCustomerGroupsApi()` | Provides access to CustomerGroups controller. | `CustomerGroupsApi` |
| `getCustomerSegmentsApi()` | Provides access to CustomerSegments controller. | `CustomerSegmentsApi` |
| `getDevicesApi()` | Provides access to Devices controller. | `DevicesApi` |
| `getDisputesApi()` | Provides access to Disputes controller. | `DisputesApi` |
| `getEmployeesApi()` | Provides access to Employees controller. | `EmployeesApi` |
| `getInventoryApi()` | Provides access to Inventory controller. | `InventoryApi` |
| `getInvoicesApi()` | Provides access to Invoices controller. | `InvoicesApi` |
| `getLaborApi()` | Provides access to Labor controller. | `LaborApi` |
| `getLocationsApi()` | Provides access to Locations controller. | `LocationsApi` |
| `getCheckoutApi()` | Provides access to Checkout controller. | `CheckoutApi` |
| `getTransactionsApi()` | Provides access to Transactions controller. | `TransactionsApi` |
| `getLoyaltyApi()` | Provides access to Loyalty controller. | `LoyaltyApi` |
| `getMerchantsApi()` | Provides access to Merchants controller. | `MerchantsApi` |
| `getOrdersApi()` | Provides access to Orders controller. | `OrdersApi` |
| `getPaymentsApi()` | Provides access to Payments controller. | `PaymentsApi` |
| `getRefundsApi()` | Provides access to Refunds controller. | `RefundsApi` |
| `getSubscriptionsApi()` | Provides access to Subscriptions controller. | `SubscriptionsApi` |
| `getTeamApi()` | Provides access to Team controller. | `TeamApi` |
| `getTerminalApi()` | Provides access to Terminal controller. | `TerminalApi` |

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `shutdown()` | Shutdown the underlying HttpClient instance. | `void` |
| `getEnvironment()` | Current API environment. | `Environment` |
| `getSquareVersion()` | Square Connect API versions. | `String` |
| `getHttpClient()` | The HTTP Client instance to use for making HTTP requests. | `HttpClient` |
| `getTimeout()` | The timeout to use for making HTTP requests. | `long` |
| `getHttpClientConfig()` | Http Client Configuration instance. | `ReadonlyHttpClientConfiguration` |
| `getAdditionalHeaders()` | Additional headers to add to each API request. | `Headers` |
| `getAccessTokenCredentials()` | The credentials to use with AccessToken. | `AccessTokenCredentials` |
| `getAccessToken()` | OAuth 2.0 Access Token. | `String` |
| `getSdkVersion()` | Current SDK Version. | `String` |
| `getBaseUri(Server server)` | Get base URI by current environment | `String` |
| `getBaseUri()` | Get base URI by current environment | `String` |

