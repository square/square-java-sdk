
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
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
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface LoyaltyApi {
    /**
     * Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and
     * a `mapping` with the `phone_number` of the buyer.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateLoyaltyAccountResponse createLoyaltyAccount(
            final CreateLoyaltyAccountRequest body) throws ApiException, IOException;

    /**
     * Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and
     * a `mapping` with the `phone_number` of the buyer.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyAccountResponse response from the API call
     */
    CompletableFuture<CreateLoyaltyAccountResponse> createLoyaltyAccountAsync(
            final CreateLoyaltyAccountRequest body);

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
    SearchLoyaltyAccountsResponse searchLoyaltyAccounts(
            final SearchLoyaltyAccountsRequest body) throws ApiException, IOException;

    /**
     * Searches for loyalty accounts in a loyalty program. You can search for a loyalty account
     * using the phone number or customer ID associated with the account. To return all loyalty
     * accounts, specify an empty `query` object or omit it entirely. Search results are sorted by
     * `created_at` in ascending order.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchLoyaltyAccountsResponse response from the API call
     */
    CompletableFuture<SearchLoyaltyAccountsResponse> searchLoyaltyAccountsAsync(
            final SearchLoyaltyAccountsRequest body);

    /**
     * Retrieves a loyalty account.
     * @param  accountId  Required parameter: The ID of the [loyalty account]($m/LoyaltyAccount) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyAccountResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLoyaltyAccountResponse retrieveLoyaltyAccount(
            final String accountId) throws ApiException, IOException;

    /**
     * Retrieves a loyalty account.
     * @param  accountId  Required parameter: The ID of the [loyalty account]($m/LoyaltyAccount) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyAccountResponse response from the API call
     */
    CompletableFuture<RetrieveLoyaltyAccountResponse> retrieveLoyaltyAccountAsync(
            final String accountId);

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
     * the points earned from the loyalty program (but not points earned from a loyalty promotion).
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account]($m/LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AccumulateLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    AccumulateLoyaltyPointsResponse accumulateLoyaltyPoints(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body) throws ApiException, IOException;

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
     * the points earned from the loyalty program (but not points earned from a loyalty promotion).
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account]($m/LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AccumulateLoyaltyPointsResponse response from the API call
     */
    CompletableFuture<AccumulateLoyaltyPointsResponse> accumulateLoyaltyPointsAsync(
            final String accountId,
            final AccumulateLoyaltyPointsRequest body);

    /**
     * Adds points to or subtracts points from a buyer's account. Use this endpoint only when you
     * need to manually adjust points. Otherwise, in your application flow, you call
     * [AccumulateLoyaltyPoints]($e/Loyalty/AccumulateLoyaltyPoints) to add points when a buyer pays
     * for the purchase.
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account]($m/LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AdjustLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    AdjustLoyaltyPointsResponse adjustLoyaltyPoints(
            final String accountId,
            final AdjustLoyaltyPointsRequest body) throws ApiException, IOException;

    /**
     * Adds points to or subtracts points from a buyer's account. Use this endpoint only when you
     * need to manually adjust points. Otherwise, in your application flow, you call
     * [AccumulateLoyaltyPoints]($e/Loyalty/AccumulateLoyaltyPoints) to add points when a buyer pays
     * for the purchase.
     * @param  accountId  Required parameter: The ID of the target [loyalty
     *         account]($m/LoyaltyAccount).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the AdjustLoyaltyPointsResponse response from the API call
     */
    CompletableFuture<AdjustLoyaltyPointsResponse> adjustLoyaltyPointsAsync(
            final String accountId,
            final AdjustLoyaltyPointsRequest body);

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
    SearchLoyaltyEventsResponse searchLoyaltyEvents(
            final SearchLoyaltyEventsRequest body) throws ApiException, IOException;

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
    CompletableFuture<SearchLoyaltyEventsResponse> searchLoyaltyEventsAsync(
            final SearchLoyaltyEventsRequest body);

    /**
     * Returns a list of loyalty programs in the seller's account. Loyalty programs define how
     * buyers can earn points and redeem points for rewards. Square sellers can have only one
     * loyalty program, which is created and managed from the Seller Dashboard. For more
     * information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview). Replaced with
     * [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) when used with the keyword
     * `main`.
     * @deprecated
     * 
     * @return    Returns the ListLoyaltyProgramsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    ListLoyaltyProgramsResponse listLoyaltyPrograms() throws ApiException, IOException;

    /**
     * Returns a list of loyalty programs in the seller's account. Loyalty programs define how
     * buyers can earn points and redeem points for rewards. Square sellers can have only one
     * loyalty program, which is created and managed from the Seller Dashboard. For more
     * information, see [Loyalty Program
     * Overview](https://developer.squareup.com/docs/loyalty/overview). Replaced with
     * [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) when used with the keyword
     * `main`.
     * @deprecated
     * 
     * @return    Returns the ListLoyaltyProgramsResponse response from the API call
     */
    @Deprecated
    CompletableFuture<ListLoyaltyProgramsResponse> listLoyaltyProgramsAsync();

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
    RetrieveLoyaltyProgramResponse retrieveLoyaltyProgram(
            final String programId) throws ApiException, IOException;

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
    CompletableFuture<RetrieveLoyaltyProgramResponse> retrieveLoyaltyProgramAsync(
            final String programId);

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
     * @param  programId  Required parameter: The ID of the [loyalty program]($m/LoyaltyProgram),
     *         which defines the rules for accruing points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateLoyaltyPointsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CalculateLoyaltyPointsResponse calculateLoyaltyPoints(
            final String programId,
            final CalculateLoyaltyPointsRequest body) throws ApiException, IOException;

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
     * @param  programId  Required parameter: The ID of the [loyalty program]($m/LoyaltyProgram),
     *         which defines the rules for accruing points.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CalculateLoyaltyPointsResponse response from the API call
     */
    CompletableFuture<CalculateLoyaltyPointsResponse> calculateLoyaltyPointsAsync(
            final String programId,
            final CalculateLoyaltyPointsRequest body);

    /**
     * Lists the loyalty promotions associated with a [loyalty program]($m/LoyaltyProgram). Results
     * are sorted by the `created_at` date in descending order (newest to oldest).
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program]($m/LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) using the `main` keyword.
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
    ListLoyaltyPromotionsResponse listLoyaltyPromotions(
            final String programId,
            final String status,
            final String cursor,
            final Integer limit) throws ApiException, IOException;

    /**
     * Lists the loyalty promotions associated with a [loyalty program]($m/LoyaltyProgram). Results
     * are sorted by the `created_at` date in descending order (newest to oldest).
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program]($m/LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) using the `main` keyword.
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
    CompletableFuture<ListLoyaltyPromotionsResponse> listLoyaltyPromotionsAsync(
            final String programId,
            final String status,
            final String cursor,
            final Integer limit);

    /**
     * Creates a loyalty promotion for a [loyalty program]($m/LoyaltyProgram). A loyalty promotion
     * enables buyers to earn points in addition to those earned from the base loyalty program. This
     * endpoint sets the loyalty promotion to the `ACTIVE` or `SCHEDULED` status, depending on the
     * `available_time` setting. A loyalty program can have a maximum of 10 loyalty promotions with
     * an `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the [loyalty program]($m/LoyaltyProgram) to
     *         associate with the promotion. To get the program ID, call
     *         [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) using the `main` keyword.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyPromotionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateLoyaltyPromotionResponse createLoyaltyPromotion(
            final String programId,
            final CreateLoyaltyPromotionRequest body) throws ApiException, IOException;

    /**
     * Creates a loyalty promotion for a [loyalty program]($m/LoyaltyProgram). A loyalty promotion
     * enables buyers to earn points in addition to those earned from the base loyalty program. This
     * endpoint sets the loyalty promotion to the `ACTIVE` or `SCHEDULED` status, depending on the
     * `available_time` setting. A loyalty program can have a maximum of 10 loyalty promotions with
     * an `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the [loyalty program]($m/LoyaltyProgram) to
     *         associate with the promotion. To get the program ID, call
     *         [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) using the `main` keyword.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateLoyaltyPromotionResponse response from the API call
     */
    CompletableFuture<CreateLoyaltyPromotionResponse> createLoyaltyPromotionAsync(
            final String programId,
            final CreateLoyaltyPromotionRequest body);

    /**
     * Retrieves a loyalty promotion.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion]($m/LoyaltyPromotion) to retrieve.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program]($m/LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) using the `main` keyword.
     * @return    Returns the RetrieveLoyaltyPromotionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLoyaltyPromotionResponse retrieveLoyaltyPromotion(
            final String promotionId,
            final String programId) throws ApiException, IOException;

    /**
     * Retrieves a loyalty promotion.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion]($m/LoyaltyPromotion) to retrieve.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program]($m/LoyaltyProgram). To get the program ID, call
     *         [RetrieveLoyaltyProgram]($e/Loyalty/RetrieveLoyaltyProgram) using the `main` keyword.
     * @return    Returns the RetrieveLoyaltyPromotionResponse response from the API call
     */
    CompletableFuture<RetrieveLoyaltyPromotionResponse> retrieveLoyaltyPromotionAsync(
            final String promotionId,
            final String programId);

    /**
     * Cancels a loyalty promotion. Use this endpoint to cancel an `ACTIVE` promotion earlier than
     * the end date, cancel an `ACTIVE` promotion when an end date is not specified, or cancel a
     * `SCHEDULED` promotion. Because updating a promotion is not supported, you can also use this
     * endpoint to cancel a promotion before you create a new one. This endpoint sets the loyalty
     * promotion to the `CANCELED` state.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion]($m/LoyaltyPromotion) to cancel. You can cancel a promotion that has an
     *         `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program]($m/LoyaltyProgram).
     * @return    Returns the CancelLoyaltyPromotionResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CancelLoyaltyPromotionResponse cancelLoyaltyPromotion(
            final String promotionId,
            final String programId) throws ApiException, IOException;

    /**
     * Cancels a loyalty promotion. Use this endpoint to cancel an `ACTIVE` promotion earlier than
     * the end date, cancel an `ACTIVE` promotion when an end date is not specified, or cancel a
     * `SCHEDULED` promotion. Because updating a promotion is not supported, you can also use this
     * endpoint to cancel a promotion before you create a new one. This endpoint sets the loyalty
     * promotion to the `CANCELED` state.
     * @param  promotionId  Required parameter: The ID of the [loyalty
     *         promotion]($m/LoyaltyPromotion) to cancel. You can cancel a promotion that has an
     *         `ACTIVE` or `SCHEDULED` status.
     * @param  programId  Required parameter: The ID of the base [loyalty
     *         program]($m/LoyaltyProgram).
     * @return    Returns the CancelLoyaltyPromotionResponse response from the API call
     */
    CompletableFuture<CancelLoyaltyPromotionResponse> cancelLoyaltyPromotionAsync(
            final String promotionId,
            final String programId);

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
    CreateLoyaltyRewardResponse createLoyaltyReward(
            final CreateLoyaltyRewardRequest body) throws ApiException, IOException;

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
    CompletableFuture<CreateLoyaltyRewardResponse> createLoyaltyRewardAsync(
            final CreateLoyaltyRewardRequest body);

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
    SearchLoyaltyRewardsResponse searchLoyaltyRewards(
            final SearchLoyaltyRewardsRequest body) throws ApiException, IOException;

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
    CompletableFuture<SearchLoyaltyRewardsResponse> searchLoyaltyRewardsAsync(
            final SearchLoyaltyRewardsRequest body);

    /**
     * Deletes a loyalty reward by doing the following: - Returns the loyalty points back to the
     * loyalty account. - If an order ID was specified when the reward was created (see
     * [CreateLoyaltyReward]($e/Loyalty/CreateLoyaltyReward)), it updates the order by removing the
     * reward and related discounts. You cannot delete a reward that has reached the terminal state
     * (REDEEMED).
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         delete.
     * @return    Returns the DeleteLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteLoyaltyRewardResponse deleteLoyaltyReward(
            final String rewardId) throws ApiException, IOException;

    /**
     * Deletes a loyalty reward by doing the following: - Returns the loyalty points back to the
     * loyalty account. - If an order ID was specified when the reward was created (see
     * [CreateLoyaltyReward]($e/Loyalty/CreateLoyaltyReward)), it updates the order by removing the
     * reward and related discounts. You cannot delete a reward that has reached the terminal state
     * (REDEEMED).
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         delete.
     * @return    Returns the DeleteLoyaltyRewardResponse response from the API call
     */
    CompletableFuture<DeleteLoyaltyRewardResponse> deleteLoyaltyRewardAsync(
            final String rewardId);

    /**
     * Retrieves a loyalty reward.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveLoyaltyRewardResponse retrieveLoyaltyReward(
            final String rewardId) throws ApiException, IOException;

    /**
     * Retrieves a loyalty reward.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         retrieve.
     * @return    Returns the RetrieveLoyaltyRewardResponse response from the API call
     */
    CompletableFuture<RetrieveLoyaltyRewardResponse> retrieveLoyaltyRewardAsync(
            final String rewardId);

    /**
     * Redeems a loyalty reward. The endpoint sets the reward to the `REDEEMED` terminal state. If
     * you are using your own order processing system (not using the Orders API), you call this
     * endpoint after the buyer paid for the purchase. After the reward reaches the terminal state,
     * it cannot be deleted. In other words, points used for the reward cannot be returned to the
     * account.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         redeem.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RedeemLoyaltyRewardResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RedeemLoyaltyRewardResponse redeemLoyaltyReward(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body) throws ApiException, IOException;

    /**
     * Redeems a loyalty reward. The endpoint sets the reward to the `REDEEMED` terminal state. If
     * you are using your own order processing system (not using the Orders API), you call this
     * endpoint after the buyer paid for the purchase. After the reward reaches the terminal state,
     * it cannot be deleted. In other words, points used for the reward cannot be returned to the
     * account.
     * @param  rewardId  Required parameter: The ID of the [loyalty reward]($m/LoyaltyReward) to
     *         redeem.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the RedeemLoyaltyRewardResponse response from the API call
     */
    CompletableFuture<RedeemLoyaltyRewardResponse> redeemLoyaltyRewardAsync(
            final String rewardId,
            final RedeemLoyaltyRewardRequest body);

}