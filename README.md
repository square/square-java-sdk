# Square Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The Square Java library provides convenient access to the Square API from Java.

## Requirements

Use of the Square Java SDK requires:

- Java 8+

## Installation

[!NOTE]
Replace `VERSION` in the examples below with the version you want to use. These instructions apply to version `44.0.0.20250319` and later.

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.squareup:square:VERSION'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square</artifactId>
    <version>VERSION</version>
</dependency>
```

## Usage

Instantiate and use the client with the following:

```java
package com.square.examples;

import com.squareup.square.SquareClient;
import com.squareup.square.types.CashPaymentDetails;
import com.squareup.square.types.CreatePaymentRequest;
import com.squareup.square.types.CreatePaymentResponse;
import com.squareup.square.types.Currency;
import com.squareup.square.types.Money;

public class QuickStart {

    public static void main(String[] args) {
        SquareClient square = SquareClient.builder().build();
        CreatePaymentResponse response = square.payments()
                .create(CreatePaymentRequest.builder()
                        .sourceId("CASH")
                        .idempotencyKey("4935a656-a929-4792-b97c-8848be85c27c")
                        .amountMoney(Money.builder()
                                .amount(100L)
                                .currency(Currency.USD)
                                .build())
                        .tipMoney(Money.builder()
                                .amount(50L)
                                .currency(Currency.USD)
                                .build())
                        .cashDetails(CashPaymentDetails.builder()
                                .buyerSuppliedMoney(Money.builder()
                                        .amount(200L)
                                        .currency(Currency.USD)
                                        .build())
                                .build())
                        .build());
    }
}
```

## Instantiation

To get started with the Square SDK, instantiate the `SquareClient` class as follows:

```java
import com.squareup.square.SquareClient;

SquareClient square = SquareClient.builder().token("SQUARE_TOKEN").build();
```

Alternatively, you can omit the token when constructing the client. In this case, the SDK will automatically read the 
token from the `SQUARE_TOKEN` environment variable:

```java
import com.squareup.square.SquareClient;

SquareClient square = SquareClient.builder().build();
```

### Environment and Custom URLs

This SDK allows you to configure different environments or custom URLs for API requests. You can either use the 
predefined environments or specify your own custom URL.

**Environments**

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.Environment;

SquareClient square = SquareClient.builder().environment(Environment.PRODUCTION).build();
```

**Custom URL**

```java
import com.squareup.square.SquareClient;

SquareClient square = SquareClient.builder().url("https://custom-staging.com").build();
```

## Enums

This SDK wraps enums for forward compatibility. We define enum properties as constant type instances with `String` properties 
and use `valueOf` to specify custom enum types that may not yet be included as constants.

### Example Usage

**Supported Property**

```java
import com.squareup.square.types.InvoicePaymentRequest;
import com.squareup.square.types.InvoiceRequestType;

InvoicePaymentRequest paymentRequest = InvoicePaymentRequest.builder()
        .requestType(InvoiceRequestType.BALANCE)
        .build();
```

**Custom Property**

```java
import com.squareup.square.types.InvoicePaymentRequest;
import com.squareup.square.types.InvoiceRequestType;

InvoicePaymentRequest paymentRequest = InvoicePaymentRequest.builder()
        .requestType(InvoiceRequestType.valueOf("CUSTOM"))
        .build();
```

## Versioning
By default, the SDK is pinned to the version 2025-03-19. If you would like to 
override this version you can simply pass in a request option.

```java
client.cards().create(..., RequestOptions.builder()
    .version("2024-05-04")  // override the version used
    .build());
```

## Automatic Pagination

Paginated requests will return an `Iterable<T>`, which can be used to loop through the underlying items.

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.Payment;
import com.squareup.square.types.PaymentsListRequest;

SquareClient square = SquareClient.builder().token("YOUR_TOKEN").build();

SyncPagingIterable<Payment> payments =
        square.payments().list(PaymentsListRequest.builder().total(100L).build());

for (Payment payment : payments) {
    System.out.printf(
            "payment: ID: %s Created at: %s, Updated at: %s\n",
            payment.getId(), payment.getCreatedAt(), payment.getUpdatedAt());
}
```

or stream them:  

```java
square.payments()
        .list(PaymentsListRequest.builder().total(100L).build())
        .streamItems()
        .map(item -> ...);
```

or calling `nextPage()` to perform the pagination manually:

```java
// First page
List<Payment> pagePayments = payments.getItems();
for (Payment payment : pagePayments) {
    // ...
}

// Remaining pages
while (payments.hasNext()) {
    pagePayments = payments.nextPage().getItems();
    for (Payment payment : pagePayments) {
        // ...
    }
}
```

## Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retriable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2).

A request is deemed retriable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` request option to configure this behavior.

```java
square.cards().create(..., RequestOptions.builder()
  .maxRetries(1)
  .build());
```

## Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout 
option at the client or request level.

```java
square.cards().create(..., RequestOptions.builder()
  .timeout(10)
  .build());
```

## Exception Handling

When the API returns a non-success status code (`4xx` or `5xx` response), a `SquareApiException` will be thrown.

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.SquareApiException;

try {
    square.payments().create(...);
} catch (SquareApiException e) {
    System.out.println("Square API exception occurred: " + e.getMessage());
    System.out.println("Status code: " + e.statusCode());
    System.out.println("Response body: " + e.body());
}
```

## Webhook Signature Verification

The SDK provides utility methods that allow you to verify webhook signatures and ensure that all webhook events 
originate from Square. The `WebhooksHelper.verifySignature` method can be used to easily verify the signature like so:

```java
import com.squareup.square.utilities.WebhooksHelper;

boolean isValid = WebhooksHelper.verifySignature(
        requestBody,
        headers.get("x-square-hmacsha256-signature"),
        "YOUR_SIGNATURE_KEY",
        "https://example.com/webhook" // The URL where event notifications are sent.
);
```

## Legacy SDK

While the new SDK has a lot of improvements, we at Square understand that it takes time to upgrade when there are breaking changes. 
To make the migration easier, the new SDK also exports the legacy SDK as `com.squareup.square.legacy...`. Here's an example of how you 
can use the legacy SDK alongside the new SDK inside a single file:

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.Environment;

SquareClient square = 
        SquareClient.builder()
                .environment(Environment.PRODUCTION)
                .token("YOUR_TOKEN")
                .build();

com.squareup.square.legacy.SquareClient legacyClient = 
        new com.squareup.square.legacy.SquareClient.Builder()
                .environment(com.squareup.square.legacy.Environment.PRODUCTION)
                .accessToken("YOUR_TOKEN")
                .build();
```

We recommend migrating to the new SDK using the following steps:

[!NOTE]
Replace `VERSION` in the examples below with the version you want to use.
These instructions apply to version `44.0.0.20250319` and later.


1. Include the following dependencies in your project

Gradle:

```groovy
dependencies {
    implementation 'com.squareup:square:VERSION'
    implementation 'com.squareup:square-legacy:VERSION'
}
```

Maven:

```xml
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square</artifactId>
    <version>VERSION</version>
</dependency>
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square-legacy</artifactId>
    <version>VERSION</version>
</dependency>
```

2. Search and replace all imports from `com.squareup.square` to `com.squareup.square.legacy`
3. Gradually move over to use the new SDK by importing it from the `com.squareup.square` import
## Advanced

### Custom HTTP Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one. However, you can pass your own client like so:

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.Environment;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ... ;

SquareClient square =
        SquareClient.builder()
                .environment(Environment.PRODUCTION)
                .token("YOUR_TOKEN")
                .httpClient(customClient)
                .build();
```

### Receive Additional Properties

Every response type includes the `getAdditionalProperties` method, which returns an array that contains any properties in the JSON response that 
were not specified in the returned class. Similar to the use case for sending additional parameters, this can be useful for API features not present in the SDK yet.

You can access the additional properties like so:

```java
CreatePaymentResponse payments = square.payments().create(...);
Map<String, Object> additionalProperties = payments.getAdditionalProperties();
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
