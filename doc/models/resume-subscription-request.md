
# Resume Subscription Request

Defines input parameters in a request to the
[ResumeSubscription](../../doc/api/subscriptions.md#resume-subscription) endpoint.

## Structure

`ResumeSubscriptionRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ResumeEffectiveDate` | `String` | Optional | The `YYYY-MM-DD`-formatted date when the subscription reactivated. | String getResumeEffectiveDate() |
| `ResumeChangeTiming` | [`String`](../../doc/models/change-timing.md) | Optional | Supported timings when a pending change, as an action, takes place to a subscription. | String getResumeChangeTiming() |

## Example (as JSON)

```json
{
  "resume_effective_date": null,
  "resume_change_timing": null
}
```

