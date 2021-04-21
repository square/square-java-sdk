
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.GetBankAccountByV1IdResponse;
import com.squareup.square.models.GetBankAccountResponse;
import com.squareup.square.models.ListBankAccountsResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface BankAccountsApi {
    /**
     * Returns a list of [BankAccount]($m/BankAccount) objects linked to a Square account.
     * @param  cursor  Optional parameter: The pagination cursor returned by a previous call to this
     *         endpoint. Use it in the next `ListBankAccounts` request to retrieve the next set of
     *         results. See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @param  limit  Optional parameter: Upper limit on the number of bank accounts to return in
     *         the response. Currently, 1000 is the largest supported limit. You can specify a limit
     *         of up to 1000 bank accounts. This is also the default limit.
     * @param  locationId  Optional parameter: Location ID. You can specify this optional filter to
     *         retrieve only the linked bank accounts belonging to a specific location.
     * @return    Returns the ListBankAccountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListBankAccountsResponse listBankAccounts(
            final String cursor,
            final Integer limit,
            final String locationId) throws ApiException, IOException;

    /**
     * Returns a list of [BankAccount]($m/BankAccount) objects linked to a Square account.
     * @param  cursor  Optional parameter: The pagination cursor returned by a previous call to this
     *         endpoint. Use it in the next `ListBankAccounts` request to retrieve the next set of
     *         results. See the
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide
     *         for more information.
     * @param  limit  Optional parameter: Upper limit on the number of bank accounts to return in
     *         the response. Currently, 1000 is the largest supported limit. You can specify a limit
     *         of up to 1000 bank accounts. This is also the default limit.
     * @param  locationId  Optional parameter: Location ID. You can specify this optional filter to
     *         retrieve only the linked bank accounts belonging to a specific location.
     * @return    Returns the ListBankAccountsResponse response from the API call
     */
    CompletableFuture<ListBankAccountsResponse> listBankAccountsAsync(
            final String cursor,
            final Integer limit,
            final String locationId);

    /**
     * Returns details of a [BankAccount]($m/BankAccount) identified by V1 bank account ID.
     * @param  v1BankAccountId  Required parameter: Connect V1 ID of the desired `BankAccount`. For
     *         more information, see [Retrieve a bank account by using an ID issued by V1 Bank
     *         Accounts
     *         API](https://developer.squareup.com/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetBankAccountByV1IdResponse getBankAccountByV1Id(
            final String v1BankAccountId) throws ApiException, IOException;

    /**
     * Returns details of a [BankAccount]($m/BankAccount) identified by V1 bank account ID.
     * @param  v1BankAccountId  Required parameter: Connect V1 ID of the desired `BankAccount`. For
     *         more information, see [Retrieve a bank account by using an ID issued by V1 Bank
     *         Accounts
     *         API](https://developer.squareup.com/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call
     */
    CompletableFuture<GetBankAccountByV1IdResponse> getBankAccountByV1IdAsync(
            final String v1BankAccountId);

    /**
     * Returns details of a [BankAccount]($m/BankAccount) linked to a Square account.
     * @param  bankAccountId  Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetBankAccountResponse getBankAccount(
            final String bankAccountId) throws ApiException, IOException;

    /**
     * Returns details of a [BankAccount]($m/BankAccount) linked to a Square account.
     * @param  bankAccountId  Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     */
    CompletableFuture<GetBankAccountResponse> getBankAccountAsync(
            final String bankAccountId);

}