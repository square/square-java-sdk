
# ApiException Class

This is the base class for all exceptions that represent an error response from the server.

## Constructors

| Name | Description |
|  --- | --- |
| `ApiException(String reason)` | Initialization constructor. |
| `ApiException(String reason,` [`HttpContext`](http-context.md) `context)` | Initialization constructor. |

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `getResponseCode()` | The HTTP response code from the API request | `int` |
| `getHeaders()` | The HTTP response body from the API request. | [`Headers`](headers.md) |
| `getErrors()` | A list of errors. | `List<Error>` |
| `getData()` | Returns data about the steps that completed successfully before an error was raised. This field is currently only populated for the PaymentsApi.CreatePayment endpoint. | `Object` |

