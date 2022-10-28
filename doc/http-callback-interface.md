
# HttpCallback Interface

Callback to be called before and after the HTTP call for an endpoint is made.

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `onBeforeRequest(`[`HttpRequest`](http-request.md) `request)` | Callback called just before the HTTP request is sent. | `void` |
| `onAfterResponse(`[`HttpContext`](http-context.md) `context)` | Callback called just after the HTTP response is received. | `void` |

