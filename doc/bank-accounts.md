# Bank Accounts

```java
BankAccountsApi bankAccountsApi = client.getBankAccountsApi();
```

## Class Name

`BankAccountsApi`

## Methods

* [List Bank Accounts](/doc/bank-accounts.md#list-bank-accounts)
* [Get Bank Account by V1 Id](/doc/bank-accounts.md#get-bank-account-by-v1-id)
* [Get Bank Account](/doc/bank-accounts.md#get-bank-account)

## List Bank Accounts

Returns a list of [BankAccount](#type-bankaccount) objects linked to a Square account. 
For more information, see 
[Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api).

```java
CompletableFuture<ListBankAccountsResponse> listBankAccountsAsync(
    final String cursor,
    final Integer limit,
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | The pagination cursor returned by a previous call to this endpoint.<br>Use it in the next `ListBankAccounts` request to retrieve the next set <br>of results.<br><br>See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information. |
| `limit` | `Integer` | Query, Optional | Upper limit on the number of bank accounts to return in the response. <br>Currently, 1000 is the largest supported limit. You can specify a limit <br>of up to 1000 bank accounts. This is also the default limit. |
| `locationId` | `String` | Query, Optional | Location ID. You can specify this optional filter <br>to retrieve only the linked bank accounts belonging to a specific location. |

### Response Type

[`ListBankAccountsResponse`](/doc/models/list-bank-accounts-response.md)

### Example Usage

```java
String cursor = "cursor6";
Integer limit = 172;
String locationId = "location_id4";

bankAccountsApi.listBankAccountsAsync(cursor, limit, locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Get Bank Account by V1 Id

Returns details of a [BankAccount](#type-bankaccount) identified by V1 bank account ID. 
For more information, see 
[Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-the-v1-bank-accounts-api).

```java
CompletableFuture<GetBankAccountByV1IdResponse> getBankAccountByV1IdAsync(
    final String v1BankAccountId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `v1BankAccountId` | `String` | Template, Required | Connect V1 ID of the desired `BankAccount`. For more information, see <br>[Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api). |

### Response Type

[`GetBankAccountByV1IdResponse`](/doc/models/get-bank-account-by-v1-id-response.md)

### Example Usage

```java
String v1BankAccountId = "v1_bank_account_id8";

bankAccountsApi.getBankAccountByV1IdAsync(v1BankAccountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Get Bank Account

Returns details of a [BankAccount](#type-bankaccount) 
linked to a Square account. For more information, see 
[Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api).

```java
CompletableFuture<GetBankAccountResponse> getBankAccountAsync(
    final String bankAccountId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bankAccountId` | `String` | Template, Required | Square-issued ID of the desired `BankAccount`. |

### Response Type

[`GetBankAccountResponse`](/doc/models/get-bank-account-response.md)

### Example Usage

```java
String bankAccountId = "bank_account_id0";

bankAccountsApi.getBankAccountAsync(bankAccountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

