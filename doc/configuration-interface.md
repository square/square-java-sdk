
# Configuration Interface

This is the base class for all exceptions that represent an error response from the server.

## Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `getEnvironment()` | Current API environment. | `Environment` |
| `getCustomUrl()` | Sets the base URL requests are made to. Defaults to `https://connect.squareup.com` | `String` |
| `getSquareVersion()` | Square Connect API versions. | `String` |
| `getTimeout()` | The timeout to use for making HTTP requests. | `long` |
| `getHttpClientConfig()` | Http Client Configuration instance. | `ReadonlyHttpClientConfiguration` |
| `getAdditionalHeaders()` | Additional headers to add to each API request. | `Headers` |
| `getAccessToken()` | OAuth 2.0 Access Token. | `String` |
| `getBaseUri(Server server)` | Get base URI by current environment. | `String` |
| `getBaseUri()` | Get base URI by current environment. | `String` |

