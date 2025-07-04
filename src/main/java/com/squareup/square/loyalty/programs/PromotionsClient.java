/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.loyalty.programs;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.loyalty.programs.types.CancelPromotionsRequest;
import com.squareup.square.loyalty.programs.types.CreateLoyaltyPromotionRequest;
import com.squareup.square.loyalty.programs.types.GetPromotionsRequest;
import com.squareup.square.loyalty.programs.types.ListPromotionsRequest;
import com.squareup.square.types.CancelLoyaltyPromotionResponse;
import com.squareup.square.types.CreateLoyaltyPromotionResponse;
import com.squareup.square.types.GetLoyaltyPromotionResponse;
import com.squareup.square.types.LoyaltyPromotion;

public class PromotionsClient {
    protected final ClientOptions clientOptions;

    private final RawPromotionsClient rawClient;

    public PromotionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawPromotionsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawPromotionsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Lists the loyalty promotions associated with a <a href="entity:LoyaltyProgram">loyalty program</a>.
     * Results are sorted by the <code>created_at</code> date in descending order (newest to oldest).
     */
    public SyncPagingIterable<LoyaltyPromotion> list(ListPromotionsRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Lists the loyalty promotions associated with a <a href="entity:LoyaltyProgram">loyalty program</a>.
     * Results are sorted by the <code>created_at</code> date in descending order (newest to oldest).
     */
    public SyncPagingIterable<LoyaltyPromotion> list(ListPromotionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Creates a loyalty promotion for a <a href="entity:LoyaltyProgram">loyalty program</a>. A loyalty promotion
     * enables buyers to earn points in addition to those earned from the base loyalty program.
     * <p>This endpoint sets the loyalty promotion to the <code>ACTIVE</code> or <code>SCHEDULED</code> status, depending on the
     * <code>available_time</code> setting. A loyalty program can have a maximum of 10 loyalty promotions with an
     * <code>ACTIVE</code> or <code>SCHEDULED</code> status.</p>
     */
    public CreateLoyaltyPromotionResponse create(CreateLoyaltyPromotionRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Creates a loyalty promotion for a <a href="entity:LoyaltyProgram">loyalty program</a>. A loyalty promotion
     * enables buyers to earn points in addition to those earned from the base loyalty program.
     * <p>This endpoint sets the loyalty promotion to the <code>ACTIVE</code> or <code>SCHEDULED</code> status, depending on the
     * <code>available_time</code> setting. A loyalty program can have a maximum of 10 loyalty promotions with an
     * <code>ACTIVE</code> or <code>SCHEDULED</code> status.</p>
     */
    public CreateLoyaltyPromotionResponse create(CreateLoyaltyPromotionRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }

    /**
     * Retrieves a loyalty promotion.
     */
    public GetLoyaltyPromotionResponse get(GetPromotionsRequest request) {
        return this.rawClient.get(request).body();
    }

    /**
     * Retrieves a loyalty promotion.
     */
    public GetLoyaltyPromotionResponse get(GetPromotionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).body();
    }

    /**
     * Cancels a loyalty promotion. Use this endpoint to cancel an <code>ACTIVE</code> promotion earlier than the
     * end date, cancel an <code>ACTIVE</code> promotion when an end date is not specified, or cancel a <code>SCHEDULED</code> promotion.
     * Because updating a promotion is not supported, you can also use this endpoint to cancel a promotion before
     * you create a new one.
     * <p>This endpoint sets the loyalty promotion to the <code>CANCELED</code> state</p>
     */
    public CancelLoyaltyPromotionResponse cancel(CancelPromotionsRequest request) {
        return this.rawClient.cancel(request).body();
    }

    /**
     * Cancels a loyalty promotion. Use this endpoint to cancel an <code>ACTIVE</code> promotion earlier than the
     * end date, cancel an <code>ACTIVE</code> promotion when an end date is not specified, or cancel a <code>SCHEDULED</code> promotion.
     * Because updating a promotion is not supported, you can also use this endpoint to cancel a promotion before
     * you create a new one.
     * <p>This endpoint sets the loyalty promotion to the <code>CANCELED</code> state</p>
     */
    public CancelLoyaltyPromotionResponse cancel(CancelPromotionsRequest request, RequestOptions requestOptions) {
        return this.rawClient.cancel(request, requestOptions).body();
    }
}
