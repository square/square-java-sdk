
# HttpClientConfiguration.Builder Class

Class to build instances of {@link HttpClientConfiguration}.

## Constructors

| Name | Description |
|  --- | --- |
| `Builder()` | Default Constructor to initiate builder with default properties. |

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `timeout(long timeout)` | Sets the timeout in seconds to use for making http requests. | `Builder` |
| `numberOfRetries(int numberOfRetries)` | Sets the number of retries to make. | `Builder` |
| `backOffFactor(int backOffFactor)` | Sets to use in calculation of wait time for next request in case of failure. | `Builder` |
| `retryInterval(long retryInterval)` | Sets to use in calculation of wait time for next request in case of failure. | `Builder` |
| `httpStatusCodesToRetry(Set<Integer> httpStatusCodesToRetry)` | Sets http status codes to retry against. | `Builder` |
| `httpMethodsToRetry(Set<HttpMethod> httpMethodsToRetry)` | Sets http methods to retry against. | `Builder` |
| `maximumRetryWaitTime(long maximumRetryWaitTime)` | Sets the maximum wait time for overall retrying requests. | `Builder` |
| `shouldRetryOnTimeout(boolean shouldRetryOnTimeout)` | Sets whether to retry on request timeout. | `Builder` |
| `httpClientInstance(okhttp3.OkHttpClient httpClientInstance)` | Sets the okhttpclient instance used to make the http calls. | `Builder` |
| `httpClientInstance(okhttp3.OkHttpClient httpClientInstance, boolean overrideHttpClientConfigurations)` | Sets the okhttpclient instance used to make the http calls and an option to Allow the SDK to override HTTP client instance's settings used for features like retries, timeouts etc. | `Builder` |
| `build()` | Builds a new HttpClientConfiguration object using the set fields. | `HttpClientConfiguration` |

