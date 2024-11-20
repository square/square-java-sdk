# Team

```java
TeamApi teamApi = client.getTeamApi();
```

## Class Name

`TeamApi`

## Methods

* [Create Team Member](../../doc/api/team.md#create-team-member)
* [Bulk Create Team Members](../../doc/api/team.md#bulk-create-team-members)
* [Bulk Update Team Members](../../doc/api/team.md#bulk-update-team-members)
* [Search Team Members](../../doc/api/team.md#search-team-members)
* [Retrieve Team Member](../../doc/api/team.md#retrieve-team-member)
* [Update Team Member](../../doc/api/team.md#update-team-member)
* [Retrieve Wage Setting](../../doc/api/team.md#retrieve-wage-setting)
* [Update Wage Setting](../../doc/api/team.md#update-wage-setting)


# Create Team Member

Creates a single `TeamMember` object. The `TeamMember` object is returned on successful creates.
You must provide the following values in your request to this endpoint:

- `given_name`
- `family_name`

Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#createteammember).

```java
CompletableFuture<CreateTeamMemberResponse> createTeamMemberAsync(
    final CreateTeamMemberRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateTeamMemberRequest`](../../doc/models/create-team-member-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateTeamMemberResponse`](../../doc/models/create-team-member-response.md)

## Example Usage

```java
CreateTeamMemberRequest body = new CreateTeamMemberRequest.Builder()
    .idempotencyKey("idempotency-key-0")
    .teamMember(new TeamMember.Builder()
        .referenceId("reference_id_1")
        .status("ACTIVE")
        .givenName("Joe")
        .familyName("Doe")
        .emailAddress("joe_doe@gmail.com")
        .phoneNumber("+14159283333")
        .assignedLocations(new TeamMemberAssignedLocations.Builder()
            .assignmentType("EXPLICIT_LOCATIONS")
            .locationIds(Arrays.asList(
                "YSGH2WBKG94QZ",
                "GA2Y9HSJ8KRYT"
            ))
            .build())
        .build())
    .build();

teamApi.createTeamMemberAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Bulk Create Team Members

Creates multiple `TeamMember` objects. The created `TeamMember` objects are returned on successful creates.
This process is non-transactional and processes as much of the request as possible. If one of the creates in
the request cannot be successfully processed, the request is not marked as failed, but the body of the response
contains explicit error information for the failed create.

Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#bulk-create-team-members).

```java
CompletableFuture<BulkCreateTeamMembersResponse> bulkCreateTeamMembersAsync(
    final BulkCreateTeamMembersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkCreateTeamMembersRequest`](../../doc/models/bulk-create-team-members-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkCreateTeamMembersResponse`](../../doc/models/bulk-create-team-members-response.md)

## Example Usage

```java
BulkCreateTeamMembersRequest body = new BulkCreateTeamMembersRequest.Builder(
    new LinkedHashMap<String, CreateTeamMemberRequest>() {{
        put("idempotency-key-1", new CreateTeamMemberRequest.Builder()
            .teamMember(new TeamMember.Builder()
                .referenceId("reference_id_1")
                .givenName("Joe")
                .familyName("Doe")
                .emailAddress("joe_doe@gmail.com")
                .phoneNumber("+14159283333")
                .assignedLocations(new TeamMemberAssignedLocations.Builder()
                    .assignmentType("EXPLICIT_LOCATIONS")
                    .locationIds(Arrays.asList(
                        "YSGH2WBKG94QZ",
                        "GA2Y9HSJ8KRYT"
                    ))
                    .build())
                .build())
            .build());
        put("idempotency-key-2", new CreateTeamMemberRequest.Builder()
            .teamMember(new TeamMember.Builder()
                .referenceId("reference_id_2")
                .givenName("Jane")
                .familyName("Smith")
                .emailAddress("jane_smith@gmail.com")
                .phoneNumber("+14159223334")
                .assignedLocations(new TeamMemberAssignedLocations.Builder()
                    .assignmentType("ALL_CURRENT_AND_FUTURE_LOCATIONS")
                    .build())
                .build())
            .build());
    }}
)
.build();

teamApi.bulkCreateTeamMembersAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Bulk Update Team Members

Updates multiple `TeamMember` objects. The updated `TeamMember` objects are returned on successful updates.
This process is non-transactional and processes as much of the request as possible. If one of the updates in
the request cannot be successfully processed, the request is not marked as failed, but the body of the response
contains explicit error information for the failed update.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#bulk-update-team-members).

```java
CompletableFuture<BulkUpdateTeamMembersResponse> bulkUpdateTeamMembersAsync(
    final BulkUpdateTeamMembersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkUpdateTeamMembersRequest`](../../doc/models/bulk-update-team-members-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkUpdateTeamMembersResponse`](../../doc/models/bulk-update-team-members-response.md)

## Example Usage

```java
BulkUpdateTeamMembersRequest body = new BulkUpdateTeamMembersRequest.Builder(
    new LinkedHashMap<String, UpdateTeamMemberRequest>() {{
        put("AFMwA08kR-MIF-3Vs0OE", new UpdateTeamMemberRequest.Builder()
            .teamMember(new TeamMember.Builder()
                .referenceId("reference_id_2")
                .status("ACTIVE")
                .givenName("Jane")
                .familyName("Smith")
                .emailAddress("jane_smith@gmail.com")
                .phoneNumber("+14159223334")
                .assignedLocations(new TeamMemberAssignedLocations.Builder()
                    .assignmentType("ALL_CURRENT_AND_FUTURE_LOCATIONS")
                    .build())
                .build())
            .build());
        put("fpgteZNMaf0qOK-a4t6P", new UpdateTeamMemberRequest.Builder()
            .teamMember(new TeamMember.Builder()
                .referenceId("reference_id_1")
                .status("ACTIVE")
                .givenName("Joe")
                .familyName("Doe")
                .emailAddress("joe_doe@gmail.com")
                .phoneNumber("+14159283333")
                .assignedLocations(new TeamMemberAssignedLocations.Builder()
                    .assignmentType("EXPLICIT_LOCATIONS")
                    .locationIds(Arrays.asList(
                        "YSGH2WBKG94QZ",
                        "GA2Y9HSJ8KRYT"
                    ))
                    .build())
                .build())
            .build());
    }}
)
.build();

teamApi.bulkUpdateTeamMembersAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Search Team Members

Returns a paginated list of `TeamMember` objects for a business.
The list can be filtered by the following:

- location IDs
- `status`

```java
CompletableFuture<SearchTeamMembersResponse> searchTeamMembersAsync(
    final SearchTeamMembersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchTeamMembersRequest`](../../doc/models/search-team-members-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchTeamMembersResponse`](../../doc/models/search-team-members-response.md)

## Example Usage

```java
SearchTeamMembersRequest body = new SearchTeamMembersRequest.Builder()
    .query(new SearchTeamMembersQuery.Builder()
        .filter(new SearchTeamMembersFilter.Builder()
            .locationIds(Arrays.asList(
                "0G5P3VGACMMQZ"
            ))
            .status("ACTIVE")
            .build())
        .build())
    .limit(10)
    .build();

teamApi.searchTeamMembersAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Team Member

Retrieves a `TeamMember` object for the given `TeamMember.id`.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#retrieve-a-team-member).

```java
CompletableFuture<RetrieveTeamMemberResponse> retrieveTeamMemberAsync(
    final String teamMemberId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `teamMemberId` | `String` | Template, Required | The ID of the team member to retrieve. |

## Response Type

[`RetrieveTeamMemberResponse`](../../doc/models/retrieve-team-member-response.md)

## Example Usage

```java
String teamMemberId = "team_member_id0";

teamApi.retrieveTeamMemberAsync(teamMemberId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Team Member

Updates a single `TeamMember` object. The `TeamMember` object is returned on successful updates.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#update-a-team-member).

```java
CompletableFuture<UpdateTeamMemberResponse> updateTeamMemberAsync(
    final String teamMemberId,
    final UpdateTeamMemberRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `teamMemberId` | `String` | Template, Required | The ID of the team member to update. |
| `body` | [`UpdateTeamMemberRequest`](../../doc/models/update-team-member-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateTeamMemberResponse`](../../doc/models/update-team-member-response.md)

## Example Usage

```java
String teamMemberId = "team_member_id0";
UpdateTeamMemberRequest body = new UpdateTeamMemberRequest.Builder()
    .teamMember(new TeamMember.Builder()
        .referenceId("reference_id_1")
        .status("ACTIVE")
        .givenName("Joe")
        .familyName("Doe")
        .emailAddress("joe_doe@gmail.com")
        .phoneNumber("+14159283333")
        .assignedLocations(new TeamMemberAssignedLocations.Builder()
            .assignmentType("EXPLICIT_LOCATIONS")
            .locationIds(Arrays.asList(
                "YSGH2WBKG94QZ",
                "GA2Y9HSJ8KRYT"
            ))
            .build())
        .build())
    .build();

teamApi.updateTeamMemberAsync(teamMemberId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Wage Setting

Retrieves a `WageSetting` object for a team member specified
by `TeamMember.id`.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting).

```java
CompletableFuture<RetrieveWageSettingResponse> retrieveWageSettingAsync(
    final String teamMemberId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `teamMemberId` | `String` | Template, Required | The ID of the team member for which to retrieve the wage setting. |

## Response Type

[`RetrieveWageSettingResponse`](../../doc/models/retrieve-wage-setting-response.md)

## Example Usage

```java
String teamMemberId = "team_member_id0";

teamApi.retrieveWageSettingAsync(teamMemberId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Wage Setting

Creates or updates a `WageSetting` object. The object is created if a
`WageSetting` with the specified `team_member_id` does not exist. Otherwise,
it fully replaces the `WageSetting` object for the team member.
The `WageSetting` is returned on a successful update.
Learn about [Troubleshooting the Team API](https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting).

```java
CompletableFuture<UpdateWageSettingResponse> updateWageSettingAsync(
    final String teamMemberId,
    final UpdateWageSettingRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `teamMemberId` | `String` | Template, Required | The ID of the team member for which to update the `WageSetting` object. |
| `body` | [`UpdateWageSettingRequest`](../../doc/models/update-wage-setting-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateWageSettingResponse`](../../doc/models/update-wage-setting-response.md)

## Example Usage

```java
String teamMemberId = "team_member_id0";
UpdateWageSettingRequest body = new UpdateWageSettingRequest.Builder(
    new WageSetting.Builder()
        .jobAssignments(Arrays.asList(
            new JobAssignment.Builder(
                "Manager",
                "SALARY"
            )
            .annualRate(new Money.Builder()
                    .amount(3000000L)
                    .currency("USD")
                    .build())
            .weeklyHours(40)
            .build(),
            new JobAssignment.Builder(
                "Cashier",
                "HOURLY"
            )
            .hourlyRate(new Money.Builder()
                    .amount(1200L)
                    .currency("USD")
                    .build())
            .build()
        ))
        .isOvertimeExempt(true)
        .build()
)
.build();

teamApi.updateWageSettingAsync(teamMemberId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```

