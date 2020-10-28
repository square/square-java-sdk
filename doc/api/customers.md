# Customers

```java
CustomersApi customersApi = client.getCustomersApi();
```

## Class Name

`CustomersApi`

## Methods

* [List Customers](/doc/api/customers.md#list-customers)
* [Create Customer](/doc/api/customers.md#create-customer)
* [Search Customers](/doc/api/customers.md#search-customers)
* [Delete Customer](/doc/api/customers.md#delete-customer)
* [Retrieve Customer](/doc/api/customers.md#retrieve-customer)
* [Update Customer](/doc/api/customers.md#update-customer)
* [Create Customer Card](/doc/api/customers.md#create-customer-card)
* [Delete Customer Card](/doc/api/customers.md#delete-customer-card)
* [Remove Group From Customer](/doc/api/customers.md#remove-group-from-customer)
* [Add Group to Customer](/doc/api/customers.md#add-group-to-customer)


# List Customers

Lists customer profiles associated with a Square account.

Under normal operating conditions, newly created or updated customer profiles become available
for the listing operation in well under 30 seconds. Occasionally, propagation of the new or updated
profiles can take closer to one minute or longer, especially during network incidents and outages.

```java
CompletableFuture<ListCustomersResponse> listCustomersAsync(
    final String cursor,
    final String sortField,
    final String sortOrder)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information. |
| `sortField` | [`String`](/doc/models/customer-sort-field.md) | Query, Optional | Indicates how Customers should be sorted.<br><br>Default: `DEFAULT`. |
| `sortOrder` | [`String`](/doc/models/sort-order.md) | Query, Optional | Indicates whether Customers should be sorted in ascending (`ASC`) or<br>descending (`DESC`) order.<br><br>Default: `ASC`. |

## Response Type

[`ListCustomersResponse`](/doc/models/list-customers-response.md)

## Example Usage

```java
String cursor = "cursor6";
String sortField = "DEFAULT";
String sortOrder = "DESC";

customersApi.listCustomersAsync(cursor, sortField, sortOrder).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Customer

Creates a new customer for a business, which can have associated cards on file.

You must provide __at least one__ of the following values in your request to this
endpoint:

- `given_name`
- `family_name`
- `company_name`
- `email_address`
- `phone_number`

```java
CompletableFuture<CreateCustomerResponse> createCustomerAsync(
    final CreateCustomerRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateCustomerRequest`](/doc/models/create-customer-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateCustomerResponse`](/doc/models/create-customer-response.md)

## Example Usage

```java
Address bodyAddress = new Address.Builder()
    .addressLine1("500 Electric Ave")
    .addressLine2("Suite 600")
    .addressLine3("address_line_38")
    .locality("New York")
    .sublocality("sublocality2")
    .administrativeDistrictLevel1("NY")
    .postalCode("10003")
    .country("US")
    .build();
CreateCustomerRequest body = new CreateCustomerRequest.Builder()
    .idempotencyKey("idempotency_key2")
    .givenName("Amelia")
    .familyName("Earhart")
    .companyName("company_name2")
    .nickname("nickname2")
    .emailAddress("Amelia.Earhart@example.com")
    .address(bodyAddress)
    .phoneNumber("1-212-555-4240")
    .referenceId("YOUR_REFERENCE_ID")
    .note("a customer")
    .build();

customersApi.createCustomerAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Customers

Searches the customer profiles associated with a Square account using a supported query filter.

Calling `SearchCustomers` without any explicit query filter returns all
customer profiles ordered alphabetically based on `given_name` and
`family_name`.

Under normal operating conditions, newly created or updated customer profiles become available
for the search operation in well under 30 seconds. Occasionally, propagation of the new or updated
profiles can take closer to one minute or longer, especially during network incidents and outages.

```java
CompletableFuture<SearchCustomersResponse> searchCustomersAsync(
    final SearchCustomersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchCustomersRequest`](/doc/models/search-customers-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchCustomersResponse`](/doc/models/search-customers-response.md)

## Example Usage

```java
List<String> bodyQueryFilterCreationSourceValues = new LinkedList<>();
bodyQueryFilterCreationSourceValues.add("THIRD_PARTY");
CustomerCreationSourceFilter bodyQueryFilterCreationSource = new CustomerCreationSourceFilter.Builder()
    .values(bodyQueryFilterCreationSourceValues)
    .rule("INCLUDE")
    .build();
TimeRange bodyQueryFilterCreatedAt = new TimeRange.Builder()
    .startAt("2018-01-01T00:00:00-00:00")
    .endAt("2018-02-01T00:00:00-00:00")
    .build();
TimeRange bodyQueryFilterUpdatedAt = new TimeRange.Builder()
    .startAt("start_at4")
    .endAt("end_at8")
    .build();
CustomerTextFilter bodyQueryFilterEmailAddress = new CustomerTextFilter.Builder()
    .exact("exact0")
    .fuzzy("example.com")
    .build();
CustomerTextFilter bodyQueryFilterPhoneNumber = new CustomerTextFilter.Builder()
    .exact("exact0")
    .fuzzy("fuzzy6")
    .build();
List<String> bodyQueryFilterGroupIdsAll = new LinkedList<>();
bodyQueryFilterGroupIdsAll.add("545AXB44B4XXWMVQ4W8SBT3HHF");
List<String> bodyQueryFilterGroupIdsAny = new LinkedList<>();
bodyQueryFilterGroupIdsAny.add("any0");
bodyQueryFilterGroupIdsAny.add("any1");
bodyQueryFilterGroupIdsAny.add("any2");
List<String> bodyQueryFilterGroupIdsNone = new LinkedList<>();
bodyQueryFilterGroupIdsNone.add("none5");
bodyQueryFilterGroupIdsNone.add("none6");
FilterValue bodyQueryFilterGroupIds = new FilterValue.Builder()
    .all(bodyQueryFilterGroupIdsAll)
    .any(bodyQueryFilterGroupIdsAny)
    .none(bodyQueryFilterGroupIdsNone)
    .build();
CustomerFilter bodyQueryFilter = new CustomerFilter.Builder()
    .creationSource(bodyQueryFilterCreationSource)
    .createdAt(bodyQueryFilterCreatedAt)
    .updatedAt(bodyQueryFilterUpdatedAt)
    .emailAddress(bodyQueryFilterEmailAddress)
    .phoneNumber(bodyQueryFilterPhoneNumber)
    .groupIds(bodyQueryFilterGroupIds)
    .build();
CustomerSort bodyQuerySort = new CustomerSort.Builder()
    .field("CREATED_AT")
    .order("ASC")
    .build();
CustomerQuery bodyQuery = new CustomerQuery.Builder()
    .filter(bodyQueryFilter)
    .sort(bodyQuerySort)
    .build();
SearchCustomersRequest body = new SearchCustomersRequest.Builder()
    .cursor("cursor0")
    .limit(2L)
    .query(bodyQuery)
    .build();

customersApi.searchCustomersAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Customer

Deletes a customer from a business, along with any linked cards on file. When two profiles
are merged into a single profile, that profile is assigned a new `customer_id`. You must use the
new `customer_id` to delete merged profiles.

```java
CompletableFuture<DeleteCustomerResponse> deleteCustomerAsync(
    final String customerId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The ID of the customer to delete. |

## Response Type

[`DeleteCustomerResponse`](/doc/models/delete-customer-response.md)

## Example Usage

```java
String customerId = "customer_id8";

customersApi.deleteCustomerAsync(customerId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Customer

Returns details for a single customer.

```java
CompletableFuture<RetrieveCustomerResponse> retrieveCustomerAsync(
    final String customerId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The ID of the customer to retrieve. |

## Response Type

[`RetrieveCustomerResponse`](/doc/models/retrieve-customer-response.md)

## Example Usage

```java
String customerId = "customer_id8";

customersApi.retrieveCustomerAsync(customerId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Customer

Updates the details of an existing customer. When two profiles are merged
into a single profile, that profile is assigned a new `customer_id`. You must use
the new `customer_id` to update merged profiles.

You cannot edit a customer's cards on file with this endpoint. To make changes
to a card on file, you must delete the existing card on file with the
[DeleteCustomerCard](#endpoint-Customers-deletecustomercard) endpoint, then create a new one with the
[CreateCustomerCard](#endpoint-Customers-createcustomercard) endpoint.

```java
CompletableFuture<UpdateCustomerResponse> updateCustomerAsync(
    final String customerId,
    final UpdateCustomerRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The ID of the customer to update. |
| `body` | [`UpdateCustomerRequest`](/doc/models/update-customer-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateCustomerResponse`](/doc/models/update-customer-response.md)

## Example Usage

```java
String customerId = "customer_id8";
UpdateCustomerRequest body = new UpdateCustomerRequest.Builder()
    .givenName("given_name8")
    .familyName("family_name0")
    .companyName("company_name2")
    .nickname("nickname2")
    .emailAddress("New.Amelia.Earhart@example.com")
    .phoneNumber("")
    .note("updated customer note")
    .build();

customersApi.updateCustomerAsync(customerId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Customer Card

Adds a card on file to an existing customer.

As with charges, calls to `CreateCustomerCard` are idempotent. Multiple
calls with the same card nonce return the same card record that was created
with the provided nonce during the _first_ call.

```java
CompletableFuture<CreateCustomerCardResponse> createCustomerCardAsync(
    final String customerId,
    final CreateCustomerCardRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The Square ID of the customer profile the card is linked to. |
| `body` | [`CreateCustomerCardRequest`](/doc/models/create-customer-card-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateCustomerCardResponse`](/doc/models/create-customer-card-response.md)

## Example Usage

```java
String customerId = "customer_id8";
Address bodyBillingAddress = new Address.Builder()
    .addressLine1("500 Electric Ave")
    .addressLine2("Suite 600")
    .addressLine3("address_line_38")
    .locality("New York")
    .sublocality("sublocality2")
    .administrativeDistrictLevel1("NY")
    .postalCode("10003")
    .country("US")
    .build();
CreateCustomerCardRequest body = new CreateCustomerCardRequest.Builder(
        "YOUR_CARD_NONCE")
    .billingAddress(bodyBillingAddress)
    .cardholderName("Amelia Earhart")
    .verificationToken("verification_token0")
    .build();

customersApi.createCustomerCardAsync(customerId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Customer Card

Removes a card on file from a customer.

```java
CompletableFuture<DeleteCustomerCardResponse> deleteCustomerCardAsync(
    final String customerId,
    final String cardId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The ID of the customer that the card on file belongs to. |
| `cardId` | `String` | Template, Required | The ID of the card on file to delete. |

## Response Type

[`DeleteCustomerCardResponse`](/doc/models/delete-customer-card-response.md)

## Example Usage

```java
String customerId = "customer_id8";
String cardId = "card_id4";

customersApi.deleteCustomerCardAsync(customerId, cardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Remove Group From Customer

Removes a group membership from a customer.

The customer is identified by the `customer_id` value
and the customer group is identified by the `group_id` value.

```java
CompletableFuture<RemoveGroupFromCustomerResponse> removeGroupFromCustomerAsync(
    final String customerId,
    final String groupId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The ID of the customer to remove from the group. |
| `groupId` | `String` | Template, Required | The ID of the customer group to remove the customer from. |

## Response Type

[`RemoveGroupFromCustomerResponse`](/doc/models/remove-group-from-customer-response.md)

## Example Usage

```java
String customerId = "customer_id8";
String groupId = "group_id0";

customersApi.removeGroupFromCustomerAsync(customerId, groupId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Add Group to Customer

Adds a group membership to a customer.

The customer is identified by the `customer_id` value
and the customer group is identified by the `group_id` value.

```java
CompletableFuture<AddGroupToCustomerResponse> addGroupToCustomerAsync(
    final String customerId,
    final String groupId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `customerId` | `String` | Template, Required | The ID of the customer to add to a group. |
| `groupId` | `String` | Template, Required | The ID of the customer group to add the customer to. |

## Response Type

[`AddGroupToCustomerResponse`](/doc/models/add-group-to-customer-response.md)

## Example Usage

```java
String customerId = "customer_id8";
String groupId = "group_id0";

customersApi.addGroupToCustomerAsync(customerId, groupId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

