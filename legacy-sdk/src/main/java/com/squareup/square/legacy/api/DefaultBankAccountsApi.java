package com.squareup.square.legacy.api;

import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.GetBankAccountByV1IdResponse;
import com.squareup.square.legacy.models.GetBankAccountResponse;
import com.squareup.square.legacy.models.ListBankAccountsResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultBankAccountsApi extends BaseApi implements BankAccountsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultBankAccountsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

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
    public ListBankAccountsResponse listBankAccounts(final String cursor, final Integer limit, final String locationId)
            throws ApiException, IOException {
        return prepareListBankAccountsRequest(cursor, limit, locationId).execute();
    }

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
    public CompletableFuture<ListBankAccountsResponse> listBankAccountsAsync(
            final String cursor, final Integer limit, final String locationId) {
        try {
            return prepareListBankAccountsRequest(cursor, limit, locationId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listBankAccounts.
     */
    private ApiCall<ListBankAccountsResponse, ApiException> prepareListBankAccountsRequest(
            final String cursor, final Integer limit, final String locationId) throws IOException {
        return new ApiCall.Builder<ListBankAccountsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bank-accounts")
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param ->
                                param.key("location_id").value(locationId).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListBankAccountsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

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
    public GetBankAccountByV1IdResponse getBankAccountByV1Id(final String v1BankAccountId)
            throws ApiException, IOException {
        return prepareGetBankAccountByV1IdRequest(v1BankAccountId).execute();
    }

    /**
     * Returns details of a [BankAccount]($m/BankAccount) identified by V1 bank account ID.
     * @param  v1BankAccountId  Required parameter: Connect V1 ID of the desired `BankAccount`. For
     *         more information, see [Retrieve a bank account by using an ID issued by V1 Bank
     *         Accounts
     *         API](https://developer.squareup.com/docs/bank-accounts-api#retrieve-a-bank-account-by-using-an-id-issued-by-v1-bank-accounts-api).
     * @return    Returns the GetBankAccountByV1IdResponse response from the API call
     */
    public CompletableFuture<GetBankAccountByV1IdResponse> getBankAccountByV1IdAsync(final String v1BankAccountId) {
        try {
            return prepareGetBankAccountByV1IdRequest(v1BankAccountId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for getBankAccountByV1Id.
     */
    private ApiCall<GetBankAccountByV1IdResponse, ApiException> prepareGetBankAccountByV1IdRequest(
            final String v1BankAccountId) throws IOException {
        return new ApiCall.Builder<GetBankAccountByV1IdResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bank-accounts/by-v1-id/{v1_bank_account_id}")
                        .templateParam(param -> param.key("v1_bank_account_id")
                                .value(v1BankAccountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, GetBankAccountByV1IdResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns details of a [BankAccount]($m/BankAccount) linked to a Square account.
     * @param  bankAccountId  Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetBankAccountResponse getBankAccount(final String bankAccountId) throws ApiException, IOException {
        return prepareGetBankAccountRequest(bankAccountId).execute();
    }

    /**
     * Returns details of a [BankAccount]($m/BankAccount) linked to a Square account.
     * @param  bankAccountId  Required parameter: Square-issued ID of the desired `BankAccount`.
     * @return    Returns the GetBankAccountResponse response from the API call
     */
    public CompletableFuture<GetBankAccountResponse> getBankAccountAsync(final String bankAccountId) {
        try {
            return prepareGetBankAccountRequest(bankAccountId).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for getBankAccount.
     */
    private ApiCall<GetBankAccountResponse, ApiException> prepareGetBankAccountRequest(final String bankAccountId)
            throws IOException {
        return new ApiCall.Builder<GetBankAccountResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/bank-accounts/{bank_account_id}")
                        .templateParam(param -> param.key("bank_account_id")
                                .value(bankAccountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, GetBankAccountResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
