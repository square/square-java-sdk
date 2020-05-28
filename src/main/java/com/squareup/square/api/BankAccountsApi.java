package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.GetBankAccountByV1IdResponse;
import com.squareup.square.models.GetBankAccountResponse;
import com.squareup.square.models.ListBankAccountsResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface BankAccountsApi {
    /**
     * Returns a list of [BankAccount](#type-bankaccount) objects linked to a Square account. 
     * For more information, see 
     * [Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api).
     * @param    cursor    Optional parameter: The pagination cursor returned by a previous call to this endpoint. Use it in the next `ListBankAccounts` request to retrieve the next set  of results.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @param    limit    Optional parameter: Upper limit on the number of bank accounts to return in the response.  Currently, 1000 is the largest supported limit. You can specify a limit  of up to 1000 bank accounts. This is also the default limit.
     * @param    locationId    Optional parameter: Location ID. You can specify this optional filter  to retrieve only the linked bank accounts belonging to a specific location.
     * @return    Returns the ListBankAccountsResponse response from the API call
     */
    ListBankAccountsResponse listBankAccounts(
            final String cursor,
            final Integer limit,
            final String locationId) throws ApiException, IOException;

    /**
     * Returns a list of [BankAccount](#type-bankaccount) objects linked to a Square account. 
     * For more information, see 
     * [Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api).
     * @param    cursor    Optional parameter: The pagination cursor returned by a previous call to this endpoint. Use it in the next `ListBankAccounts` request to retrieve the next set  of results.  See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     * @param    limit    Optional parameter: Upper limit on the number of bank accounts to return in the response.  Currently, 1000 is the largest supported limit. You can specify a limit  of up to 1000 bank accounts. This is also the default limit.
     * @param    locationId    Optional parameter: Location ID. You can specify this optional filter  to retrieve only the linked bank accounts belonging to a specific location.
     * @return    Returns the ListBankAccountsResponse response from the API call 
     */
    CompletableFuture<ListBankAccountsResponse> listBankAccountsAsync(
            final String cursor,
            final Integer limit,
            final String locationId);

    /**
     * Returns details of a [BankAccount](#type-bankaccount) identified by V1 bank account ID. 
     * For more information, see 
     * [Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-the-v1-bank-accounts-api).
     * @param    v1BankAccountId    Required parameter: Connect V1 ID of the desired `BankAccount`. For more information, see  [Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call
     */
    GetBankAccountByV1IdResponse getBankAccountByV1Id(
            final String v1BankAccountId) throws ApiException, IOException;

    /**
     * Returns details of a [BankAccount](#type-bankaccount) identified by V1 bank account ID. 
     * For more information, see 
     * [Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-the-v1-bank-accounts-api).
     * @param    v1BankAccountId    Required parameter: Connect V1 ID of the desired `BankAccount`. For more information, see  [Retrieve a bank account by using an ID issued by V1 Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call 
     */
    CompletableFuture<GetBankAccountByV1IdResponse> getBankAccountByV1IdAsync(
            final String v1BankAccountId);

    /**
     * Returns details of a [BankAccount](#type-bankaccount) 
     * linked to a Square account. For more information, see 
     * [Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api).
     * @param    bankAccountId    Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     */
    GetBankAccountResponse getBankAccount(
            final String bankAccountId) throws ApiException, IOException;

    /**
     * Returns details of a [BankAccount](#type-bankaccount) 
     * linked to a Square account. For more information, see 
     * [Bank Accounts API](https://developer.squareup.com/docs/docs/bank-accounts-api).
     * @param    bankAccountId    Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call 
     */
    CompletableFuture<GetBankAccountResponse> getBankAccountAsync(
            final String bankAccountId);

}