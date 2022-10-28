
# HttpClientConfiguration Class

Class for holding http client configuration.

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `getTimeout()` | The timeout in seconds to use for making HTTP requests. | `long` |
| `getNumberOfRetries()` | The number of retries to make. | `int` |
| `getBackOffFactor()` | To use in calculation of wait time for next request in case of failure. | `int` |
| `getRetryInterval()` | To use in calculation of wait time for next request in case of failure. | `long` |
| `getHttpStatusCodesToRetry()` | Http status codes to retry against. | `Set<Integer>` |
| `getHttpMethodsToRetry()` | Http methods to retry against. | `Set<HttpMethod>` |
| `getMaximumRetryWaitTime()` | The maximum wait time for overall retrying requests. | `long` |
| `shouldRetryOnTimeout()` | Whether to retry on request timeout. | `boolean` |
| `getHttpClientInstance()` | The OkHttpClient instance used to make the HTTP calls. | `okhttp3.OkHttpClient` |
| `shouldOverrideHttpClientConfigurations()` | Allow the SDK to override HTTP client instance's settings used for features like retries, timeouts etc. | `boolean` |
| `toString()` | Converts this HttpClientConfiguration into string format. | `String` |
| `newBuilder()` | Builds a new {@link HttpClientConfiguration.Builder} object. Creates the instance with the current state. | [`HttpClientConfiguration.Builder`](http-client-configuration-builder.md) |

