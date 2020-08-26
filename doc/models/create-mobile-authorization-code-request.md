## Create Mobile Authorization Code Request

Defines the body parameters that can be provided in a request to the
__CreateMobileAuthorizationCode__ endpoint.

### Structure

`CreateMobileAuthorizationCodeRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` | Optional | The Square location ID the authorization code should be tied to. | String getLocationId() |

### Example (as JSON)

```json
{
  "location_id": "YOUR_LOCATION_ID"
}
```

