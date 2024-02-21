
# Configuration Interface

This is the interface for client class that holds the configuration getters.

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `getEnvironment()` | Current API environment. | `Environment` |
| `getCustomUrl()` | Sets the base URL requests are made to. Defaults to `https://connect.squareup.com` | `String` |
| `getSquareVersion()` | Square Connect API versions. | `String` |
| `getHttpClientConfig()` | Http Client Configuration instance. | [`ReadonlyHttpClientConfiguration`](http-client-configuration.md) |
| `getAdditionalHeaders()` | Additional headers to add to each API request. | [`Headers`](headers.md) |
| `getUserAgentDetail()` | Additional detail which can be appended with User-Agent header. | `String` |
| `getBaseUri(Server server)` | Get base URI by current environment. | `String` |
| `getBaseUri()` | Get base URI by current environment. | `String` |

