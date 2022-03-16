# Snippets

```java
SnippetsApi snippetsApi = client.getSnippetsApi();
```

## Class Name

`SnippetsApi`

## Methods

* [Delete Snippet](../../doc/api/snippets.md#delete-snippet)
* [Retrieve Snippet](../../doc/api/snippets.md#retrieve-snippet)
* [Upsert Snippet](../../doc/api/snippets.md#upsert-snippet)


# Delete Snippet

Removes your snippet from a Square Online site.

You can call [ListSites](../../doc/api/sites.md#list-sites) to get the IDs of the sites that belong to a seller.

__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).

```java
CompletableFuture<DeleteSnippetResponse> deleteSnippetAsync(
    final String siteId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `siteId` | `String` | Template, Required | The ID of the site that contains the snippet. |

## Response Type

[`DeleteSnippetResponse`](../../doc/models/delete-snippet-response.md)

## Example Usage

```java
String siteId = "site_id6";

snippetsApi.deleteSnippetAsync(siteId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Snippet

Retrieves your snippet from a Square Online site. A site can contain snippets from multiple snippet applications, but you can retrieve only the snippet that was added by your application.

You can call [ListSites](../../doc/api/sites.md#list-sites) to get the IDs of the sites that belong to a seller.

__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).

```java
CompletableFuture<RetrieveSnippetResponse> retrieveSnippetAsync(
    final String siteId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `siteId` | `String` | Template, Required | The ID of the site that contains the snippet. |

## Response Type

[`RetrieveSnippetResponse`](../../doc/models/retrieve-snippet-response.md)

## Example Usage

```java
String siteId = "site_id6";

snippetsApi.retrieveSnippetAsync(siteId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Upsert Snippet

Adds a snippet to a Square Online site or updates the existing snippet on the site.
The snippet code is appended to the end of the `head` element on every page of the site, except checkout pages. A snippet application can add one snippet to a given site.

You can call [ListSites](../../doc/api/sites.md#list-sites) to get the IDs of the sites that belong to a seller.

__Note:__ Square Online APIs are publicly available as part of an early access program. For more information, see [Early access program for Square Online APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).

```java
CompletableFuture<UpsertSnippetResponse> upsertSnippetAsync(
    final String siteId,
    final UpsertSnippetRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `siteId` | `String` | Template, Required | The ID of the site where you want to add or update the snippet. |
| `body` | [`UpsertSnippetRequest`](../../doc/models/upsert-snippet-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpsertSnippetResponse`](../../doc/models/upsert-snippet-response.md)

## Example Usage

```java
String siteId = "site_id6";
Snippet snippet = new Snippet.Builder(
        "<script>var js = 1;</script>")
    .id("id4")
    .siteId("site_id0")
    .createdAt("created_at8")
    .updatedAt("updated_at0")
    .build();
UpsertSnippetRequest body = new UpsertSnippetRequest.Builder(
        snippet)
    .build();

snippetsApi.upsertSnippetAsync(siteId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

