
# HttpClientConfiguration.Builder Class

Class to build instances of {@link HttpClientConfiguration}.

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `timeout()` | The timeout in seconds to use for making HTTP requests. | `long` |
| `numberOfRetries()` | The number of retries to make. | `int` |
| `backOffFactor()` | To use in calculation of wait time for next request in case of failure. | `int` |
| `retryInterval()` | To use in calculation of wait time for next request in case of failure. | `long` |
| `httpStatusCodesToRetry()` | Http status codes to retry against. | `Set<Integer>` |
| `httpMethodsToRetry()` | Http methods to retry against. | `Set<HttpMethod>` |
| `maxBackOff()` | The maximum wait time for overall retrying requests. | `long` |
| `shouldRetryOnTimeout()` | Whether to retry on request timeout. | `boolean` |

