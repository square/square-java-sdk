# Square Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=https%3A%2F%2Fgithub.com%2Fsquare%2Fsquare-java-sdk)
[![Maven Central](https://img.shields.io/maven-central/v/com.squareup/square)](https://central.sonatype.com/artifact/com.squareup/square)

The Square Java library provides convenient access to the Square APIs from Java.

## Requirements

Use of the Square Java SDK requires:

- Java 8+

## Installation

### Gradle

Add the dependency in your `build.gradle` file:

```groovy
dependencies {
  implementation 'com.squareup:square'
}
```

### Maven

Add the dependency in your `pom.xml` file:

```xml
<dependency>
  <groupId>com.squareup</groupId>
  <artifactId>square</artifactId>
  <version>45.0.2.20250820</version>
</dependency>
```

## Reference

A full reference for this library is available [here](https://github.com/square/square-java-sdk/blob/HEAD/./reference.md).

## Legacy SDKs

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

1. Include the following dependencies in your project

Gradle:

```groovy
dependencies {
    implementation 'com.squareup:square:45.0.2.20250820'
    implementation 'com.squareup:square-legacy:45.0.2.20250820'
}
```

Maven:

```xml
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square</artifactId>
    <version>45.0.2.20250820</version>
</dependency>
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square-legacy</artifactId>
    <version>45.0.2.20250820</version>
</dependency>
```

2. Search and replace all imports from `com.squareup.square` to `com.squareup.square.legacy`
3. Gradually move over to use the new SDK by importing it from the `com.squareup.square` import


## Usage

Instantiate and use the client with the following:

```java
package com.example.usage;

import com.squareup.square.SquareClient;
import com.squareup.square.types.CreatePaymentRequest;
import com.squareup.square.types.Currency;
import com.squareup.square.types.Money;

public class Example {
    public static void main(String[] args) {
        SquareClient client = SquareClient
            .builder()
            .token("<token>")
            .build();

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

## Environments

This SDK allows you to configure different environments for API requests.

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.Environment;

SquareClient client = SquareClient
    .builder()
    .environment(Environment.Production)
    .build();
```

## Base Url

You can set a custom base URL when constructing the client.

```java
import com.squareup.square.SquareClient;

SquareClient client = SquareClient
    .builder()
    .url("https://example.com")
    .build();
```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), an API exception will be thrown.

```java
import com.squareup.square.core.SquareApiException;

try {
    client.payments().create(...);
} catch (SquareApiException e) {
    // Do something with the API exception...
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

1. Include the following dependencies in your project

Gradle:

```groovy
dependencies {
    implementation 'com.squareup:square:44.0.0.20250319'
    implementation 'com.squareup:square-legacy:44.0.0.20250319'
}
```

Maven:

```xml
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square</artifactId>
    <version>44.0.0.20250319</version>
</dependency>
<dependency>
    <groupId>com.squareup</groupId>
    <artifactId>square-legacy</artifactId>
    <version>44.0.0.20250319</version>
</dependency>
```

2. Search and replace all imports from `com.squareup.square` to `com.squareup.square.legacy`
3. Gradually move over to use the new SDK by importing it from the `com.squareup.square` import
## Advanced

### Custom Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one. 
However, you can pass your own client like so:

```java
import com.squareup.square.SquareClient;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ...;

SquareClient client = SquareClient
    .builder()
    .httpClient(customClient)
    .build();
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retryable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2).

A request is deemed retryable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` client option to configure this behavior.

```java
import com.squareup.square.SquareClient;

SquareClient client = SquareClient
    .builder()
    .maxRetries(1)
    .build();
```

### Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout option at the client or request level.

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.RequestOptions;

// Client level
SquareClient client = SquareClient
    .builder()
    .timeout(10)
    .build();

// Request level
client.payments().create(
    ...,
    RequestOptions
        .builder()
        .timeout(10)
        .build()
);
```

### Custom Headers

The SDK allows you to add custom headers to requests. You can configure headers at the client level or at the request level.

```java
import com.squareup.square.SquareClient;
import com.squareup.square.core.RequestOptions;

// Client level
SquareClient client = SquareClient
    .builder()
    .addHeader("X-Custom-Header", "custom-value")
    .addHeader("X-Request-Id", "abc-123")
    .build();
;

// Request level
client.payments().create(
    ...,
    RequestOptions
        .builder()
        .addHeader("X-Request-Header", "request-value")
        .build()
);
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!