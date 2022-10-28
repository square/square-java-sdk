
# HttpResponse Class

Class to hold HTTP Response.

## Constructors

| Name | Description |
|  --- | --- |
| `HttpResponse(int code, Headers headers, InputStream rawBody)` | Constructor for HttpResponse. |

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `getStatusCode()` | HTTP Status code of the http response.. | `int` |
| `getHeaders()` | Headers of the http response. | [`Headers`](headers.md) |
| `getRawBody()` | Raw body of the http response. | `InputStream` |

