
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.AccumulateLoyaltyPointsRequest;
import com.squareup.square.models.AccumulateLoyaltyPointsResponse;
import com.squareup.square.models.AdjustLoyaltyPointsRequest;
import com.squareup.square.models.AdjustLoyaltyPointsResponse;
import com.squareup.square.models.CalculateLoyaltyPointsRequest;
import com.squareup.square.models.CalculateLoyaltyPointsResponse;
import com.squareup.square.models.CancelLoyaltyPromotionResponse;
import com.squareup.square.models.CreateLoyaltyAccountRequest;
import com.squareup.square.models.CreateLoyaltyAccountResponse;
import com.squareup.square.models.CreateLoyaltyPromotionRequest;
import com.squareup.square.models.CreateLoyaltyPromotionResponse;
import com.squareup.square.models.CreateLoyaltyRewardRequest;
import com.squareup.square.models.CreateLoyaltyRewardResponse;
import com.squareup.square.models.DeleteLoyaltyRewardResponse;
import com.squareup.square.models.ListLoyaltyProgramsResponse;
import com.squareup.square.models.ListLoyaltyPromotionsResponse;
import com.squareup.square.models.RedeemLoyaltyRewardRequest;
import com.squareup.square.models.RedeemLoyaltyRewardResponse;
import com.squareup.square.models.RetrieveLoyaltyAccountResponse;
import com.squareup.square.models.RetrieveLoyaltyProgramResponse;
import com.squareup.square.models.RetrieveLoyaltyPromotionResponse;
import com.squareup.square.models.RetrieveLoyaltyRewardResponse;
import com.squareup.square.models.SearchLoyaltyAccountsRequest;
import com.squareup.square.models.SearchLoyaltyAccountsResponse;
import com.squareup.square.models.SearchLoyaltyEventsRequest;
import com.squareup.square.models.SearchLoyaltyEventsResponse;
import com.squareup.square.models.SearchLoyaltyRewardsRequest;
import com.squareup.square.models.SearchLoyaltyRewardsResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultLoyaltyApi extends BaseApi implements LoyaltyApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultLoyaltyApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and
     * a `mapping` with the `phone_number` of the buyer.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateLoyaltyAccountResponse createLoyaltyAccount(
            final CreateLoyaltyAccountRequest body) throws ApiException, IOException {
        return prepareCreateLoyaltyAccountRequest(body).execute();
    }

    /**
     * Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and
     * a `mapping` with the `phone_number` of the buyer.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyAccountResponse response from the API call
     */
    public CompletableFuture<CreateLoyaltyAccountResponse> createLoyaltyAccountAsync(
            final CreateLoyaltyAccountRequest body) {
        try { 
            return prepareCreateLoyaltyAccountRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createLoyaltyAccount.
     */
    private ApiCall<CreateLoyaltyAccountResponse, ApiException> prepareCreateLoyaltyAccountRequest(
            final CreateLoyaltyAccountRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateLoyaltyAccountResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/accounts")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateLoyaltyAccountResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Searches for loyalty accounts in a loyalty program. You can search for a loyalty account
     * using the phone number or customer ID associated with the account. To return all loyalty
     * accounts, specify an empty `query` object or omit it entirely. Search results are sorted by
     * `created_at` in ascending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyAccountsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchLoyaltyAccountsResponse searchLoyaltyAccounts(
            final SearchLoyaltyAccountsRequest body) throws ApiException, IOException {
        return prepareSearchLoyaltyAccountsRequest(body).execute();
    }

    /**
     * Searches for loyalty accounts in a loyalty program. You can search for a loyalty account
     * using the phone number or customer ID associated with the account. To return all loyalty
     * accounts, specify an empty `query` object or omit it entirely. Search results are sorted by
     * `created_at` in ascending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyAccountsResponse response from the API call
     */
    public CompletableFuture<SearchLoyaltyAccountsResponse> searchLoyaltyAccountsAsync(
            final SearchLoyaltyAccountsRequest body) {
        try { 
            return prepareSearchLoyaltyAccountsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchLoyaltyAccounts.
     */
    private ApiCall<SearchLoyaltyAccountsResponse, ApiException> prepareSearchLoyaltyAccountsRequest(
            final SearchLoyaltyAccountsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchLoyaltyAccountsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/accounts/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchLoyaltyAccountsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a loyalty account.
     * @param  accountId  Required parameter: The ID of the [loyalty account](entity:LoyaltyAccount)
     *         to retrieve.
     * @return    Returns the RetrieveLoyaltyAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyAccountResponse retrieveLoyaltyAccount(
            final String accountId) throws ApiException, IOException {
        return prepareRetrieveLoyaltyAccountRequest(accountId).execute();
    }

    /**
     * Retrieves a loyalty account.
     * @param  accountId  Required parameter: The ID of the [loyalty account](entity:LoyaltyAccount)
     *         to retrieve.
     * @return    Returns the RetrieveLoyaltyAccountResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyAccountResponse> retrieveLoyaltyAccountAsync(
            final String accountId) {
        try { 
            return prepareRetrieveLoyaltyAccountRequest(accountId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLoyaltyAccount.
     */
    private ApiCall<RetrieveLoyaltyAccountResponse, ApiException> prepareRetrieveLoyaltyAccountRequest(
            final String accountId) throws IOException {
        return new ApiCall.Builder<RetrieveLoyaltyAccountResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/accounts/{account_id}")
                        .templateParam(param -> param.key("account_id").value(accountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLoyaltyAccountResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Adds points earned from a purchase to a [loyalty account]($m/LoyaltyAccount). - If you are
     * using the Orders API to manage orders, provide the `order_id`. Square reads the order to
     * compute the points earned from both the base loyalty program and an associated [loyalty
     * promotion]($m/LoyaltyPromotion). For purchases that qualify for multiple accrual rules,
     * Square computes points based on the accrual rule that grants the most points. For purchases
     * that qualify for multiple promotions, Square computes points based on the most recently
     * created promotion. A purchase must first qualify for program points to be eligible for
     * promotion points. - If you are not using the Orders API to manage orders, provide `points`
     * with the number of points to add. You must first perform a client-side computation of the
     * points earned from the loyalty program and loyalty promotion. For spend-based and visit-based
     * programs, you can call [CalculateLoyaltyPoints]($e/Loyalty/CalculateLoyaltyPoints) to compute
     * the points earned from the base loyalty program. For information about computing points
     * earned from a loyalty promotion, see [Calculating promotion
     * points](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#calculate-promotion-points).
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account](entity:LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AccumulateLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AccumulateLoyaltyPointsResponse accumulateLoyaltyPoints(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) throws ApiException, IOException {
        return prepareAccumulateLoyaltyPointsRequest(accountId, body).execute();
    }

    /**
     * Adds points earned from a purchase to a [loyalty account]($m/LoyaltyAccount). - If you are
     * using the Orders API to manage orders, provide the `order_id`. Square reads the order to
     * compute the points earned from both the base loyalty program and an associated [loyalty
     * promotion]($m/LoyaltyPromotion). For purchases that qualify for multiple accrual rules,
     * Square computes points based on the accrual rule that grants the most points. For purchases
     * that qualify for multiple promotions, Square computes points based on the most recently
     * created promotion. A purchase must first qualify for program points to be eligible for
     * promotion points. - If you are not using the Orders API to manage orders, provide `points`
     * with the number of points to add. You must first perform a client-side computation of the
     * points earned from the loyalty program and loyalty promotion. For spend-based and visit-based
     * programs, you can call [CalculateLoyaltyPoints]($e/Loyalty/CalculateLoyaltyPoints) to compute
     * the points earned from the base loyalty program. For information about computing points
     * earned from a loyalty promotion, see [Calculating promotion
     * points](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#calculate-promotion-points).
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account](entity:LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AccumulateLoyaltyPointsResponse response from the API call
     */
    public CompletableFuture<AccumulateLoyaltyPointsResponse> accumulateLoyaltyPointsAsync(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) {
        try { 
            return prepareAccumulateLoyaltyPointsRequest(accountId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for accumulateLoyaltyPoints.
     */
    private ApiCall<AccumulateLoyaltyPointsResponse, ApiException> prepareAccumulateLoyaltyPointsRequest(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<AccumulateLoyaltyPointsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/accounts/{account_id}/accumulate")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("account_id").value(accountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, AccumulateLoyaltyPointsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Adds points to or subtracts points from a buyer's account. Use this endpoint only when you
     * need to manually adjust points. Otherwise, in your application flow, you call
     * [AccumulateLoyaltyPoints]($e/Loyalty/AccumulateLoyaltyPoints) to add points when a buyer pays
     * for the purchase.
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account](entity:LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AdjustLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public AdjustLoyaltyPointsResponse adjustLoyaltyPoints(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) throws ApiException, IOException {
        return prepareAdjustLoyaltyPointsRequest(accountId, body).execute();
    }

    /**
     * Adds points to or subtracts points from a buyer's account. Use this endpoint only when you
     * need to manually adjust points. Otherwise, in your application flow, you call
     * [AccumulateLoyaltyPoints]($e/Loyalty/AccumulateLoyaltyPoints) to add points when a buyer pays
     * for the purchase.
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account](entity:LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AdjustLoyaltyPointsResponse response from the API call
     */
    public CompletableFuture<AdjustLoyaltyPointsResponse> adjustLoyaltyPointsAsync(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) {
        try { 
            return prepareAdjustLoyaltyPointsRequest(accountId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for adjustLoyaltyPoints.
     */
    private ApiCall<AdjustLoyaltyPointsResponse, ApiException> prepareAdjustLoyaltyPointsRequest(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<AdjustLoyaltyPointsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/accounts/{account_id}/adjust")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("account_id").value(accountId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, AdjustLoyaltyPointsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Searches for loyalty events. A Square loyalty program maintains a ledger of events that occur
     * during the lifetime of a buyer's loyalty account. Each change in the point balance (for
     * example, points earned, points redeemed, and points expired) is recorded in the ledger. Using
     * this endpoint, you can search the ledger for events. Search results are sorted by
     * `created_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyEventsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchLoyaltyEventsResponse searchLoyaltyEvents(
            final SearchLoyaltyEventsRequest body) throws ApiException, IOException {
        return prepareSearchLoyaltyEventsRequest(body).execute();
    }

    /**
     * Searches for loyalty events. A Square loyalty program maintains a ledger of events that occur
     * during the lifetime of a buyer's loyalty account. Each change in the point balance (for
     * example, points earned, points redeemed, and points expired) is recorded in the ledger. Using
     * this endpoint, you can search the ledger for events. Search results are sorted by
     * `created_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyEventsResponse response from the API call
     */
    public CompletableFuture<SearchLoyaltyEventsResponse> searchLoyaltyEventsAsync(
            final SearchLoyaltyEventsRequest body) {
        try { 
            return prepareSearchLoyaltyEventsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchLoyaltyEvents.
     */
    private ApiCall<SearchLoyaltyEventsResponse, ApiException> prepareSearchLoyaltyEventsRequest(
            final SearchLoyaltyEventsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchLoyaltyEventsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/events/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchLoyaltyEventsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a list of loyalty programs in the seller's account. Loyalty programs define how
     * buyers can earn points and redeem points for rewards. Square sellers can have only one
     * loyalty program, which is created and managed from the Seller Dashboard. For more
     * information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview). Replaced with
     * [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) when used with the
     * keyword `main`.
     * @deprecated
     * 
     * @return    Returns the ListLoyaltyProgramsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListLoyaltyProgramsResponse listLoyaltyPrograms() throws ApiException, IOException {
        return prepareListLoyaltyProgramsRequest().execute();
    }

    /**
     * Returns a list of loyalty programs in the seller's account. Loyalty programs define how
     * buyers can earn points and redeem points for rewards. Square sellers can have only one
     * loyalty program, which is created and managed from the Seller Dashboard. For more
     * information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview). Replaced with
     * [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) when used with the
     * keyword `main`.
     * @deprecated
     * 
     * @return    Returns the ListLoyaltyProgramsResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListLoyaltyProgramsResponse> listLoyaltyProgramsAsync() {
        try { 
            return prepareListLoyaltyProgramsRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listLoyaltyPrograms.
     */
    private ApiCall<ListLoyaltyProgramsResponse, ApiException> prepareListLoyaltyProgramsRequest() throws IOException {
        return new ApiCall.Builder<ListLoyaltyProgramsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListLoyaltyProgramsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves the loyalty program in a seller's account, specified by the program ID or the
     * keyword `main`. Loyalty programs define how buyers can earn points and redeem points for
     * rewards. Square sellers can have only one loyalty program, which is created and managed from
     * the Seller Dashboard. For more information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @param  programId  Required parameter: The ID of the loyalty program or the keyword `main`.
     *         Either value can be used to retrieve the single loyalty program that belongs to the
     *         seller.
     * @return    Returns the RetrieveLoyaltyProgramResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyProgramResponse retrieveLoyaltyProgram(
            final String programId) throws ApiException, IOException {
        return prepareRetrieveLoyaltyProgramRequest(programId).execute();
    }

    /**
     * Retrieves the loyalty program in a seller's account, specified by the program ID or the
     * keyword `main`. Loyalty programs define how buyers can earn points and redeem points for
     * rewards. Square sellers can have only one loyalty program, which is created and managed from
     * the Seller Dashboard. For more information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview).
     * @param  programId  Required parameter: The ID of the loyalty program or the keyword `main`.
     *         Either value can be used to retrieve the single loyalty program that belongs to the
     *         seller.
     * @return    Returns the RetrieveLoyaltyProgramResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyProgramResponse> retrieveLoyaltyProgramAsync(
            final String programId) {
        try { 
            return prepareRetrieveLoyaltyProgramRequest(programId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLoyaltyProgram.
     */
    private ApiCall<RetrieveLoyaltyProgramResponse, ApiException> prepareRetrieveLoyaltyProgramRequest(
            final String programId) throws IOException {
        return new ApiCall.Builder<RetrieveLoyaltyProgramResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs/{program_id}")
                        .templateParam(param -> param.key("program_id").value(programId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLoyaltyProgramResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Calculates the number of points a buyer can earn from a purchase. Applications might call
     * this endpoint to display the points to the buyer. - If you are using the Orders API to manage
     * orders, provide the `order_id` and (optional) `loyalty_account_id`. Square reads the order to
     * compute the points earned from the base loyalty program and an associated [loyalty
     * promotion]($m/LoyaltyPromotion). - If you are not using the Orders API to manage orders,
     * provide `transaction_amount_money` with the purchase amount. Square uses this amount to
     * calculate the points earned from the base loyalty program, but not points earned from a
     * loyalty promotion. For spend-based and visit-based programs, the `tax_mode` setting of the
     * accrual rule indicates how taxes should be treated for loyalty points accrual. If the
     * purchase qualifies for program points, call
     * [ListLoyaltyPromotions]($e/Loyalty/ListLoyaltyPromotions) and perform a client-side
     * computation to calculate whether the purchase also qualifies for promotion points. For more
     * information, see [Calculating promotion
     * points](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#calculate-promotion-points).
     * @param  programId  Required parameter: The ID of the [loyalty
     *         program](entity:LoyaltyProgram), which defines the rules for accruing points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CalculateLoyaltyPointsResponse calculateLoyaltyPoints(
            final String programId,
            final CalculateLoyaltyPointsRequest body) throws ApiException, IOException {
        return prepareCalculateLoyaltyPointsRequest(programId, body).execute();
    }

    /**
     * Calculates the number of points a buyer can earn from a purchase. Applications might call
     * this endpoint to display the points to the buyer. - If you are using the Orders API to manage
     * orders, provide the `order_id` and (optional) `loyalty_account_id`. Square reads the order to
     * compute the points earned from the base loyalty program and an associated [loyalty
     * promotion]($m/LoyaltyPromotion). - If you are not using the Orders API to manage orders,
     * provide `transaction_amount_money` with the purchase amount. Square uses this amount to
     * calculate the points earned from the base loyalty program, but not points earned from a
     * loyalty promotion. For spend-based and visit-based programs, the `tax_mode` setting of the
     * accrual rule indicates how taxes should be treated for loyalty points accrual. If the
     * purchase qualifies for program points, call
     * [ListLoyaltyPromotions]($e/Loyalty/ListLoyaltyPromotions) and perform a client-side
     * computation to calculate whether the purchase also qualifies for promotion points. For more
     * information, see [Calculating promotion
     * points](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#calculate-promotion-points).
     * @param  programId  Required parameter: The ID of the [loyalty
     *         program](entity:LoyaltyProgram), which defines the rules for accruing points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateLoyaltyPointsResponse response from the API call
     */
    public CompletableFuture<CalculateLoyaltyPointsResponse> calculateLoyaltyPointsAsync(
            final String programId,
            final CalculateLoyaltyPointsRequest body) {
        try { 
            return prepareCalculateLoyaltyPointsRequest(programId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for calculateLoyaltyPoints.
     */
    private ApiCall<CalculateLoyaltyPointsResponse, ApiException> prepareCalculateLoyaltyPointsRequest(
            final String programId,
            final CalculateLoyaltyPointsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CalculateLoyaltyPointsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs/{program_id}/calculate")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("program_id").value(programId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CalculateLoyaltyPointsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Lists the loyalty promotions associated with a [loyalty program]($m/LoyaltyProgram). Results
     * are sorted by the `created_at` date in descending order (newest to oldest).
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program](entity:LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) using the
     *         `main` keyword.
     * @param  status  Optional parameter: The status to filter the results by. If a status is
     *         provided, only loyalty promotions with the specified status are returned. Otherwise,
     *         all loyalty promotions associated with the loyalty program are returned.
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. The minimum value is 1 and the maximum value is 30. The default value is
     *         30. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListLoyaltyPromotionsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListLoyaltyPromotionsResponse listLoyaltyPromotions(
            final String programId,
            final String status,
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListLoyaltyPromotionsRequest(programId, status, cursor, limit).execute();
    }

    /**
     * Lists the loyalty promotions associated with a [loyalty program]($m/LoyaltyProgram). Results
     * are sorted by the `created_at` date in descending order (newest to oldest).
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program](entity:LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) using the
     *         `main` keyword.
     * @param  status  Optional parameter: The status to filter the results by. If a status is
     *         provided, only loyalty promotions with the specified status are returned. Otherwise,
     *         all loyalty promotions associated with the loyalty program are returned.
     * @param  cursor  Optional parameter: The cursor returned in the paged response from the
     *         previous call to this endpoint. Provide this cursor to retrieve the next page of
     *         results for your original request. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single paged
     *         response. The minimum value is 1 and the maximum value is 30. The default value is
     *         30. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListLoyaltyPromotionsResponse response from the API call
     */
    public CompletableFuture<ListLoyaltyPromotionsResponse> listLoyaltyPromotionsAsync(
            final String programId,
            final String status,
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListLoyaltyPromotionsRequest(programId, status, cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listLoyaltyPromotions.
     */
    private ApiCall<ListLoyaltyPromotionsResponse, ApiException> prepareListLoyaltyPromotionsRequest(
            final String programId,
            final String status,
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListLoyaltyPromotionsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs/{program_id}/promotions")
                        .queryParam(param -> param.key("status")
                                .value(status).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .templateParam(param -> param.key("program_id").value(programId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListLoyaltyPromotionsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a loyalty promotion for a [loyalty program]($m/LoyaltyProgram). A loyalty promotion
     * enables buyers to earn points in addition to those earned from the base loyalty program. This
     * endpoint sets the loyalty promotion to the `ACTIVE` or `SCHEDULED` status, depending on the
     * `available_time` setting. A loyalty program can have a maximum of 10 loyalty promotions with
     * an `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the [loyalty program](entity:LoyaltyProgram)
     *         to associate with the promotion. To get the program ID, call
     *         [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) using the
     *         `main` keyword.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyPromotionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateLoyaltyPromotionResponse createLoyaltyPromotion(
            final String programId,
            final CreateLoyaltyPromotionRequest body) throws ApiException, IOException {
        return prepareCreateLoyaltyPromotionRequest(programId, body).execute();
    }

    /**
     * Creates a loyalty promotion for a [loyalty program]($m/LoyaltyProgram). A loyalty promotion
     * enables buyers to earn points in addition to those earned from the base loyalty program. This
     * endpoint sets the loyalty promotion to the `ACTIVE` or `SCHEDULED` status, depending on the
     * `available_time` setting. A loyalty program can have a maximum of 10 loyalty promotions with
     * an `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the [loyalty program](entity:LoyaltyProgram)
     *         to associate with the promotion. To get the program ID, call
     *         [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) using the
     *         `main` keyword.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyPromotionResponse response from the API call
     */
    public CompletableFuture<CreateLoyaltyPromotionResponse> createLoyaltyPromotionAsync(
            final String programId,
            final CreateLoyaltyPromotionRequest body) {
        try { 
            return prepareCreateLoyaltyPromotionRequest(programId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createLoyaltyPromotion.
     */
    private ApiCall<CreateLoyaltyPromotionResponse, ApiException> prepareCreateLoyaltyPromotionRequest(
            final String programId,
            final CreateLoyaltyPromotionRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateLoyaltyPromotionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs/{program_id}/promotions")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("program_id").value(programId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateLoyaltyPromotionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a loyalty promotion.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion](entity:LoyaltyPromotion) to retrieve.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program](entity:LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) using the
     *         `main` keyword.
     * @return    Returns the RetrieveLoyaltyPromotionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyPromotionResponse retrieveLoyaltyPromotion(
            final String promotionId,
            final String programId) throws ApiException, IOException {
        return prepareRetrieveLoyaltyPromotionRequest(promotionId, programId).execute();
    }

    /**
     * Retrieves a loyalty promotion.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion](entity:LoyaltyPromotion) to retrieve.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program](entity:LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram](api-endpoint:Loyalty-RetrieveLoyaltyProgram) using the
     *         `main` keyword.
     * @return    Returns the RetrieveLoyaltyPromotionResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyPromotionResponse> retrieveLoyaltyPromotionAsync(
            final String promotionId,
            final String programId) {
        try { 
            return prepareRetrieveLoyaltyPromotionRequest(promotionId, programId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLoyaltyPromotion.
     */
    private ApiCall<RetrieveLoyaltyPromotionResponse, ApiException> prepareRetrieveLoyaltyPromotionRequest(
            final String promotionId,
            final String programId) throws IOException {
        return new ApiCall.Builder<RetrieveLoyaltyPromotionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs/{program_id}/promotions/{promotion_id}")
                        .templateParam(param -> param.key("promotion_id").value(promotionId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("program_id").value(programId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLoyaltyPromotionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Cancels a loyalty promotion. Use this endpoint to cancel an `ACTIVE` promotion earlier than
     * the end date, cancel an `ACTIVE` promotion when an end date is not specified, or cancel a
     * `SCHEDULED` promotion. Because updating a promotion is not supported, you can also use this
     * endpoint to cancel a promotion before you create a new one. This endpoint sets the loyalty
     * promotion to the `CANCELED` state.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion](entity:LoyaltyPromotion) to cancel. You can cancel a promotion that has an
     *         `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program](entity:LoyaltyProgram).
     * @return    Returns the CancelLoyaltyPromotionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CancelLoyaltyPromotionResponse cancelLoyaltyPromotion(
            final String promotionId,
            final String programId) throws ApiException, IOException {
        return prepareCancelLoyaltyPromotionRequest(promotionId, programId).execute();
    }

    /**
     * Cancels a loyalty promotion. Use this endpoint to cancel an `ACTIVE` promotion earlier than
     * the end date, cancel an `ACTIVE` promotion when an end date is not specified, or cancel a
     * `SCHEDULED` promotion. Because updating a promotion is not supported, you can also use this
     * endpoint to cancel a promotion before you create a new one. This endpoint sets the loyalty
     * promotion to the `CANCELED` state.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion](entity:LoyaltyPromotion) to cancel. You can cancel a promotion that has an
     *         `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program](entity:LoyaltyProgram).
     * @return    Returns the CancelLoyaltyPromotionResponse response from the API call
     */
    public CompletableFuture<CancelLoyaltyPromotionResponse> cancelLoyaltyPromotionAsync(
            final String promotionId,
            final String programId) {
        try { 
            return prepareCancelLoyaltyPromotionRequest(promotionId, programId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for cancelLoyaltyPromotion.
     */
    private ApiCall<CancelLoyaltyPromotionResponse, ApiException> prepareCancelLoyaltyPromotionRequest(
            final String promotionId,
            final String programId) throws IOException {
        return new ApiCall.Builder<CancelLoyaltyPromotionResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/programs/{program_id}/promotions/{promotion_id}/cancel")
                        .templateParam(param -> param.key("promotion_id").value(promotionId)
                                .shouldEncode(true))
                        .templateParam(param -> param.key("program_id").value(programId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CancelLoyaltyPromotionResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a loyalty reward. In the process, the endpoint does following: - Uses the
     * `reward_tier_id` in the request to determine the number of points to lock for this reward. -
     * If the request includes `order_id`, it adds the reward and related discount to the order.
     * After a reward is created, the points are locked and not available for the buyer to redeem
     * another reward.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateLoyaltyRewardResponse createLoyaltyReward(
            final CreateLoyaltyRewardRequest body) throws ApiException, IOException {
        return prepareCreateLoyaltyRewardRequest(body).execute();
    }

    /**
     * Creates a loyalty reward. In the process, the endpoint does following: - Uses the
     * `reward_tier_id` in the request to determine the number of points to lock for this reward. -
     * If the request includes `order_id`, it adds the reward and related discount to the order.
     * After a reward is created, the points are locked and not available for the buyer to redeem
     * another reward.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<CreateLoyaltyRewardResponse> createLoyaltyRewardAsync(
            final CreateLoyaltyRewardRequest body) {
        try { 
            return prepareCreateLoyaltyRewardRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createLoyaltyReward.
     */
    private ApiCall<CreateLoyaltyRewardResponse, ApiException> prepareCreateLoyaltyRewardRequest(
            final CreateLoyaltyRewardRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateLoyaltyRewardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/rewards")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateLoyaltyRewardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Searches for loyalty rewards. This endpoint accepts a request with no query filters and
     * returns results for all loyalty accounts. If you include a `query` object,
     * `loyalty_account_id` is required and `status` is optional. If you know a reward ID, use the
     * [RetrieveLoyaltyReward]($e/Loyalty/RetrieveLoyaltyReward) endpoint. Search results are sorted
     * by `updated_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyRewardsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchLoyaltyRewardsResponse searchLoyaltyRewards(
            final SearchLoyaltyRewardsRequest body) throws ApiException, IOException {
        return prepareSearchLoyaltyRewardsRequest(body).execute();
    }

    /**
     * Searches for loyalty rewards. This endpoint accepts a request with no query filters and
     * returns results for all loyalty accounts. If you include a `query` object,
     * `loyalty_account_id` is required and `status` is optional. If you know a reward ID, use the
     * [RetrieveLoyaltyReward]($e/Loyalty/RetrieveLoyaltyReward) endpoint. Search results are sorted
     * by `updated_at` in descending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyRewardsResponse response from the API call
     */
    public CompletableFuture<SearchLoyaltyRewardsResponse> searchLoyaltyRewardsAsync(
            final SearchLoyaltyRewardsRequest body) {
        try { 
            return prepareSearchLoyaltyRewardsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchLoyaltyRewards.
     */
    private ApiCall<SearchLoyaltyRewardsResponse, ApiException> prepareSearchLoyaltyRewardsRequest(
            final SearchLoyaltyRewardsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchLoyaltyRewardsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/rewards/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchLoyaltyRewardsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a loyalty reward by doing the following: - Returns the loyalty points back to the
     * loyalty account. - If an order ID was specified when the reward was created (see
     * [CreateLoyaltyReward]($e/Loyalty/CreateLoyaltyReward)), it updates the order by removing the
     * reward and related discounts. You cannot delete a reward that has reached the terminal state
     * (REDEEMED).
     * @param  rewardId  Required parameter: The ID of the [loyalty reward](entity:LoyaltyReward) to
     *         delete.
     * @return    Returns the DeleteLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteLoyaltyRewardResponse deleteLoyaltyReward(
            final String rewardId) throws ApiException, IOException {
        return prepareDeleteLoyaltyRewardRequest(rewardId).execute();
    }

    /**
     * Deletes a loyalty reward by doing the following: - Returns the loyalty points back to the
     * loyalty account. - If an order ID was specified when the reward was created (see
     * [CreateLoyaltyReward]($e/Loyalty/CreateLoyaltyReward)), it updates the order by removing the
     * reward and related discounts. You cannot delete a reward that has reached the terminal state
     * (REDEEMED).
     * @param  rewardId  Required parameter: The ID of the [loyalty reward](entity:LoyaltyReward) to
     *         delete.
     * @return    Returns the DeleteLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<DeleteLoyaltyRewardResponse> deleteLoyaltyRewardAsync(
            final String rewardId) {
        try { 
            return prepareDeleteLoyaltyRewardRequest(rewardId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for deleteLoyaltyReward.
     */
    private ApiCall<DeleteLoyaltyRewardResponse, ApiException> prepareDeleteLoyaltyRewardRequest(
            final String rewardId) throws IOException {
        return new ApiCall.Builder<DeleteLoyaltyRewardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/rewards/{reward_id}")
                        .templateParam(param -> param.key("reward_id").value(rewardId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, DeleteLoyaltyRewardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a loyalty reward.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward](entity:LoyaltyReward) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveLoyaltyRewardResponse retrieveLoyaltyReward(
            final String rewardId) throws ApiException, IOException {
        return prepareRetrieveLoyaltyRewardRequest(rewardId).execute();
    }

    /**
     * Retrieves a loyalty reward.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward](entity:LoyaltyReward) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<RetrieveLoyaltyRewardResponse> retrieveLoyaltyRewardAsync(
            final String rewardId) {
        try { 
            return prepareRetrieveLoyaltyRewardRequest(rewardId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveLoyaltyReward.
     */
    private ApiCall<RetrieveLoyaltyRewardResponse, ApiException> prepareRetrieveLoyaltyRewardRequest(
            final String rewardId) throws IOException {
        return new ApiCall.Builder<RetrieveLoyaltyRewardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/rewards/{reward_id}")
                        .templateParam(param -> param.key("reward_id").value(rewardId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveLoyaltyRewardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Redeems a loyalty reward. The endpoint sets the reward to the `REDEEMED` terminal state. If
     * you are using your own order processing system (not using the Orders API), you call this
     * endpoint after the buyer paid for the purchase. After the reward reaches the terminal state,
     * it cannot be deleted. In other words, points used for the reward cannot be returned to the
     * account.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward](entity:LoyaltyReward) to
     *         redeem.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RedeemLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RedeemLoyaltyRewardResponse redeemLoyaltyReward(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) throws ApiException, IOException {
        return prepareRedeemLoyaltyRewardRequest(rewardId, body).execute();
    }

    /**
     * Redeems a loyalty reward. The endpoint sets the reward to the `REDEEMED` terminal state. If
     * you are using your own order processing system (not using the Orders API), you call this
     * endpoint after the buyer paid for the purchase. After the reward reaches the terminal state,
     * it cannot be deleted. In other words, points used for the reward cannot be returned to the
     * account.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward](entity:LoyaltyReward) to
     *         redeem.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RedeemLoyaltyRewardResponse response from the API call
     */
    public CompletableFuture<RedeemLoyaltyRewardResponse> redeemLoyaltyRewardAsync(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) {
        try { 
            return prepareRedeemLoyaltyRewardRequest(rewardId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for redeemLoyaltyReward.
     */
    private ApiCall<RedeemLoyaltyRewardResponse, ApiException> prepareRedeemLoyaltyRewardRequest(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<RedeemLoyaltyRewardResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/loyalty/rewards/{reward_id}/redeem")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("reward_id").value(rewardId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RedeemLoyaltyRewardResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}