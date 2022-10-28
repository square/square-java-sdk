
# HttpClientConfiguration.Builder Class

Class to build instances of {@link HttpClientConfiguration}.

## Constructors

| Name | Description |
|  --- | --- |
| `Builder()` | Default Constructor to initiate builder with default properties. |

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `timeout(long timeout)` | Sets the timeout in seconds to use for making http requests. | [`Builder`](http-client-configuration-builder.md) |
| `numberOfRetries(int numberOfRetries)` | Sets the number of retries to make. | [`Builder`](http-client-configuration-builder.md) |
| `backOffFactor(int backOffFactor)` | Sets to use in calculation of wait time for next request in case of failure. | [`Builder`](http-client-configuration-builder.md) |
| `retryInterval(long retryInterval)` | Sets to use in calculation of wait time for next request in case of failure. | [`Builder`](http-client-configuration-builder.md) |
| `httpStatusCodesToRetry(Set<Integer> httpStatusCodesToRetry)` | Sets http status codes to retry against. | [`Builder`](http-client-configuration-builder.md) |
| `httpMethodsToRetry(Set<HttpMethod> httpMethodsToRetry)` | Sets http methods to retry against. | [`Builder`](http-client-configuration-builder.md) |
| `maximumRetryWaitTime(long maximumRetryWaitTime)` | Sets the maximum wait time for overall retrying requests. | [`Builder`](http-client-configuration-builder.md) |
| `shouldRetryOnTimeout(boolean shouldRetryOnTimeout)` | Sets whether to retry on request timeout. | [`Builder`](http-client-configuration-builder.md) |
| `httpClientInstance(okhttp3.OkHttpClient httpClientInstance)` | Sets the okhttpclient instance used to make the http calls. | [`Builder`](http-client-configuration-builder.md) |
| `httpClientInstance(okhttp3.OkHttpClient httpClientInstance, boolean overrideHttpClientConfigurations)` | Sets the okhttpclient instance used to make the http calls and an option to Allow the SDK to override HTTP client instance's settings used for features like retries, timeouts etc. | [`Builder`](http-client-configuration-builder.md) |
| `build()` | Builds a new HttpClientConfiguration object using the set fields. | [`HttpClientConfiguration`](http-client-configuration.md) |

