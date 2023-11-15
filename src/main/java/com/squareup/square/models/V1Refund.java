
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.squareup.square.http.client.HttpContext;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1Refund type.
 */
public class V1Refund {
    private HttpContext httpContext;
    private final String type;
    private final OptionalNullable<String> reason;
    private final V1Money refundedMoney;
    private final V1Money refundedProcessingFeeMoney;
    private final V1Money refundedTaxMoney;
    private final V1Money refundedAdditiveTaxMoney;
    private final OptionalNullable<List<V1PaymentTax>> refundedAdditiveTax;
    private final V1Money refundedInclusiveTaxMoney;
    private final OptionalNullable<List<V1PaymentTax>> refundedInclusiveTax;
    private final V1Money refundedTipMoney;
    private final V1Money refundedDiscountMoney;
    private final V1Money refundedSurchargeMoney;
    private final OptionalNullable<List<V1PaymentSurcharge>> refundedSurcharges;
    private final String createdAt;
    private final OptionalNullable<String> processedAt;
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> merchantId;
    private final OptionalNullable<Boolean> isExchange;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  reason  String value for reason.
     * @param  refundedMoney  V1Money value for refundedMoney.
     * @param  refundedProcessingFeeMoney  V1Money value for refundedProcessingFeeMoney.
     * @param  refundedTaxMoney  V1Money value for refundedTaxMoney.
     * @param  refundedAdditiveTaxMoney  V1Money value for refundedAdditiveTaxMoney.
     * @param  refundedAdditiveTax  List of V1PaymentTax value for refundedAdditiveTax.
     * @param  refundedInclusiveTaxMoney  V1Money value for refundedInclusiveTaxMoney.
     * @param  refundedInclusiveTax  List of V1PaymentTax value for refundedInclusiveTax.
     * @param  refundedTipMoney  V1Money value for refundedTipMoney.
     * @param  refundedDiscountMoney  V1Money value for refundedDiscountMoney.
     * @param  refundedSurchargeMoney  V1Money value for refundedSurchargeMoney.
     * @param  refundedSurcharges  List of V1PaymentSurcharge value for refundedSurcharges.
     * @param  createdAt  String value for createdAt.
     * @param  processedAt  String value for processedAt.
     * @param  paymentId  String value for paymentId.
     * @param  merchantId  String value for merchantId.
     * @param  isExchange  Boolean value for isExchange.
     */
    @JsonCreator
    public V1Refund(
            @JsonProperty("type") String type,
            @JsonProperty("reason") String reason,
            @JsonProperty("refunded_money") V1Money refundedMoney,
            @JsonProperty("refunded_processing_fee_money") V1Money refundedProcessingFeeMoney,
            @JsonProperty("refunded_tax_money") V1Money refundedTaxMoney,
            @JsonProperty("refunded_additive_tax_money") V1Money refundedAdditiveTaxMoney,
            @JsonProperty("refunded_additive_tax") List<V1PaymentTax> refundedAdditiveTax,
            @JsonProperty("refunded_inclusive_tax_money") V1Money refundedInclusiveTaxMoney,
            @JsonProperty("refunded_inclusive_tax") List<V1PaymentTax> refundedInclusiveTax,
            @JsonProperty("refunded_tip_money") V1Money refundedTipMoney,
            @JsonProperty("refunded_discount_money") V1Money refundedDiscountMoney,
            @JsonProperty("refunded_surcharge_money") V1Money refundedSurchargeMoney,
            @JsonProperty("refunded_surcharges") List<V1PaymentSurcharge> refundedSurcharges,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("processed_at") String processedAt,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("is_exchange") Boolean isExchange) {
        this.type = type;
        this.reason = OptionalNullable.of(reason);
        this.refundedMoney = refundedMoney;
        this.refundedProcessingFeeMoney = refundedProcessingFeeMoney;
        this.refundedTaxMoney = refundedTaxMoney;
        this.refundedAdditiveTaxMoney = refundedAdditiveTaxMoney;
        this.refundedAdditiveTax = OptionalNullable.of(refundedAdditiveTax);
        this.refundedInclusiveTaxMoney = refundedInclusiveTaxMoney;
        this.refundedInclusiveTax = OptionalNullable.of(refundedInclusiveTax);
        this.refundedTipMoney = refundedTipMoney;
        this.refundedDiscountMoney = refundedDiscountMoney;
        this.refundedSurchargeMoney = refundedSurchargeMoney;
        this.refundedSurcharges = OptionalNullable.of(refundedSurcharges);
        this.createdAt = createdAt;
        this.processedAt = OptionalNullable.of(processedAt);
        this.paymentId = OptionalNullable.of(paymentId);
        this.merchantId = OptionalNullable.of(merchantId);
        this.isExchange = OptionalNullable.of(isExchange);
    }

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  reason  String value for reason.
     * @param  refundedMoney  V1Money value for refundedMoney.
     * @param  refundedProcessingFeeMoney  V1Money value for refundedProcessingFeeMoney.
     * @param  refundedTaxMoney  V1Money value for refundedTaxMoney.
     * @param  refundedAdditiveTaxMoney  V1Money value for refundedAdditiveTaxMoney.
     * @param  refundedAdditiveTax  List of V1PaymentTax value for refundedAdditiveTax.
     * @param  refundedInclusiveTaxMoney  V1Money value for refundedInclusiveTaxMoney.
     * @param  refundedInclusiveTax  List of V1PaymentTax value for refundedInclusiveTax.
     * @param  refundedTipMoney  V1Money value for refundedTipMoney.
     * @param  refundedDiscountMoney  V1Money value for refundedDiscountMoney.
     * @param  refundedSurchargeMoney  V1Money value for refundedSurchargeMoney.
     * @param  refundedSurcharges  List of V1PaymentSurcharge value for refundedSurcharges.
     * @param  createdAt  String value for createdAt.
     * @param  processedAt  String value for processedAt.
     * @param  paymentId  String value for paymentId.
     * @param  merchantId  String value for merchantId.
     * @param  isExchange  Boolean value for isExchange.
     */

    protected V1Refund(String type, OptionalNullable<String> reason, V1Money refundedMoney,
            V1Money refundedProcessingFeeMoney, V1Money refundedTaxMoney,
            V1Money refundedAdditiveTaxMoney,
            OptionalNullable<List<V1PaymentTax>> refundedAdditiveTax,
            V1Money refundedInclusiveTaxMoney,
            OptionalNullable<List<V1PaymentTax>> refundedInclusiveTax, V1Money refundedTipMoney,
            V1Money refundedDiscountMoney, V1Money refundedSurchargeMoney,
            OptionalNullable<List<V1PaymentSurcharge>> refundedSurcharges, String createdAt,
            OptionalNullable<String> processedAt, OptionalNullable<String> paymentId,
            OptionalNullable<String> merchantId, OptionalNullable<Boolean> isExchange) {
        this.type = type;
        this.reason = reason;
        this.refundedMoney = refundedMoney;
        this.refundedProcessingFeeMoney = refundedProcessingFeeMoney;
        this.refundedTaxMoney = refundedTaxMoney;
        this.refundedAdditiveTaxMoney = refundedAdditiveTaxMoney;
        this.refundedAdditiveTax = refundedAdditiveTax;
        this.refundedInclusiveTaxMoney = refundedInclusiveTaxMoney;
        this.refundedInclusiveTax = refundedInclusiveTax;
        this.refundedTipMoney = refundedTipMoney;
        this.refundedDiscountMoney = refundedDiscountMoney;
        this.refundedSurchargeMoney = refundedSurchargeMoney;
        this.refundedSurcharges = refundedSurcharges;
        this.createdAt = createdAt;
        this.processedAt = processedAt;
        this.paymentId = paymentId;
        this.merchantId = merchantId;
        this.isExchange = isExchange;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for Reason.
     * The merchant-specified reason for the refund.
     * @return Returns the Internal String
     */
    @JsonGetter("reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReason() {
        return this.reason;
    }

    /**
     * Getter for Reason.
     * The merchant-specified reason for the refund.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReason() {
        return OptionalNullable.getFrom(reason);
    }

    /**
     * Getter for RefundedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedMoney() {
        return refundedMoney;
    }

    /**
     * Getter for RefundedProcessingFeeMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_processing_fee_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedProcessingFeeMoney() {
        return refundedProcessingFeeMoney;
    }

    /**
     * Getter for RefundedTaxMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_tax_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedTaxMoney() {
        return refundedTaxMoney;
    }

    /**
     * Getter for RefundedAdditiveTaxMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_additive_tax_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedAdditiveTaxMoney() {
        return refundedAdditiveTaxMoney;
    }

    /**
     * Internal Getter for RefundedAdditiveTax.
     * All of the additive taxes associated with the refund.
     * @return Returns the Internal List of V1PaymentTax
     */
    @JsonGetter("refunded_additive_tax")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentTax>> internalGetRefundedAdditiveTax() {
        return this.refundedAdditiveTax;
    }

    /**
     * Getter for RefundedAdditiveTax.
     * All of the additive taxes associated with the refund.
     * @return Returns the List of V1PaymentTax
     */
    @JsonIgnore
    public List<V1PaymentTax> getRefundedAdditiveTax() {
        return OptionalNullable.getFrom(refundedAdditiveTax);
    }

    /**
     * Getter for RefundedInclusiveTaxMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_inclusive_tax_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedInclusiveTaxMoney() {
        return refundedInclusiveTaxMoney;
    }

    /**
     * Internal Getter for RefundedInclusiveTax.
     * All of the inclusive taxes associated with the refund.
     * @return Returns the Internal List of V1PaymentTax
     */
    @JsonGetter("refunded_inclusive_tax")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentTax>> internalGetRefundedInclusiveTax() {
        return this.refundedInclusiveTax;
    }

    /**
     * Getter for RefundedInclusiveTax.
     * All of the inclusive taxes associated with the refund.
     * @return Returns the List of V1PaymentTax
     */
    @JsonIgnore
    public List<V1PaymentTax> getRefundedInclusiveTax() {
        return OptionalNullable.getFrom(refundedInclusiveTax);
    }

    /**
     * Getter for RefundedTipMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_tip_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedTipMoney() {
        return refundedTipMoney;
    }

    /**
     * Getter for RefundedDiscountMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_discount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedDiscountMoney() {
        return refundedDiscountMoney;
    }

    /**
     * Getter for RefundedSurchargeMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_surcharge_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getRefundedSurchargeMoney() {
        return refundedSurchargeMoney;
    }

    /**
     * Internal Getter for RefundedSurcharges.
     * A list of all surcharges associated with the refund.
     * @return Returns the Internal List of V1PaymentSurcharge
     */
    @JsonGetter("refunded_surcharges")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentSurcharge>> internalGetRefundedSurcharges() {
        return this.refundedSurcharges;
    }

    /**
     * Getter for RefundedSurcharges.
     * A list of all surcharges associated with the refund.
     * @return Returns the List of V1PaymentSurcharge
     */
    @JsonIgnore
    public List<V1PaymentSurcharge> getRefundedSurcharges() {
        return OptionalNullable.getFrom(refundedSurcharges);
    }

    /**
     * Getter for CreatedAt.
     * The time when the merchant initiated the refund for Square to process, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for ProcessedAt.
     * The time when Square processed the refund on behalf of the merchant, in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("processed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetProcessedAt() {
        return this.processedAt;
    }

    /**
     * Getter for ProcessedAt.
     * The time when Square processed the refund on behalf of the merchant, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getProcessedAt() {
        return OptionalNullable.getFrom(processedAt);
    }

    /**
     * Internal Getter for PaymentId.
     * A Square-issued ID associated with the refund. For single-tender refunds, payment_id is the
     * ID of the original payment ID. For split-tender refunds, payment_id is the ID of the original
     * tender. For exchange-based refunds (is_exchange == true), payment_id is the ID of the
     * original payment ID even if the payment includes other tenders.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for PaymentId.
     * A Square-issued ID associated with the refund. For single-tender refunds, payment_id is the
     * ID of the original payment ID. For split-tender refunds, payment_id is the ID of the original
     * tender. For exchange-based refunds (is_exchange == true), payment_id is the ID of the
     * original payment ID even if the payment includes other tenders.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    /**
     * Internal Getter for MerchantId.
     * @return Returns the Internal String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for MerchantId.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantId() {
        return OptionalNullable.getFrom(merchantId);
    }

    /**
     * Internal Getter for IsExchange.
     * Indicates whether or not the refund is associated with an exchange. If is_exchange is true,
     * the refund reflects the value of goods returned in the exchange not the total money refunded.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_exchange")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsExchange() {
        return this.isExchange;
    }

    /**
     * Getter for IsExchange.
     * Indicates whether or not the refund is associated with an exchange. If is_exchange is true,
     * the refund reflects the value of goods returned in the exchange not the total money refunded.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsExchange() {
        return OptionalNullable.getFrom(isExchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, reason, refundedMoney, refundedProcessingFeeMoney,
                refundedTaxMoney, refundedAdditiveTaxMoney, refundedAdditiveTax,
                refundedInclusiveTaxMoney, refundedInclusiveTax, refundedTipMoney,
                refundedDiscountMoney, refundedSurchargeMoney, refundedSurcharges, createdAt,
                processedAt, paymentId, merchantId, isExchange);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Refund)) {
            return false;
        }
        V1Refund other = (V1Refund) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(reason, other.reason)
            && Objects.equals(refundedMoney, other.refundedMoney)
            && Objects.equals(refundedProcessingFeeMoney, other.refundedProcessingFeeMoney)
            && Objects.equals(refundedTaxMoney, other.refundedTaxMoney)
            && Objects.equals(refundedAdditiveTaxMoney, other.refundedAdditiveTaxMoney)
            && Objects.equals(refundedAdditiveTax, other.refundedAdditiveTax)
            && Objects.equals(refundedInclusiveTaxMoney, other.refundedInclusiveTaxMoney)
            && Objects.equals(refundedInclusiveTax, other.refundedInclusiveTax)
            && Objects.equals(refundedTipMoney, other.refundedTipMoney)
            && Objects.equals(refundedDiscountMoney, other.refundedDiscountMoney)
            && Objects.equals(refundedSurchargeMoney, other.refundedSurchargeMoney)
            && Objects.equals(refundedSurcharges, other.refundedSurcharges)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(processedAt, other.processedAt)
            && Objects.equals(paymentId, other.paymentId)
            && Objects.equals(merchantId, other.merchantId)
            && Objects.equals(isExchange, other.isExchange);
    }

    /**
     * Converts this V1Refund into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Refund [" + "type=" + type + ", reason=" + reason + ", refundedMoney="
                + refundedMoney + ", refundedProcessingFeeMoney=" + refundedProcessingFeeMoney
                + ", refundedTaxMoney=" + refundedTaxMoney + ", refundedAdditiveTaxMoney="
                + refundedAdditiveTaxMoney + ", refundedAdditiveTax=" + refundedAdditiveTax
                + ", refundedInclusiveTaxMoney=" + refundedInclusiveTaxMoney
                + ", refundedInclusiveTax=" + refundedInclusiveTax + ", refundedTipMoney="
                + refundedTipMoney + ", refundedDiscountMoney=" + refundedDiscountMoney
                + ", refundedSurchargeMoney=" + refundedSurchargeMoney + ", refundedSurcharges="
                + refundedSurcharges + ", createdAt=" + createdAt + ", processedAt=" + processedAt
                + ", paymentId=" + paymentId + ", merchantId=" + merchantId + ", isExchange="
                + isExchange + "]";
    }

    /**
     * Builds a new {@link V1Refund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Refund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .refundedMoney(getRefundedMoney())
                .refundedProcessingFeeMoney(getRefundedProcessingFeeMoney())
                .refundedTaxMoney(getRefundedTaxMoney())
                .refundedAdditiveTaxMoney(getRefundedAdditiveTaxMoney())
                .refundedInclusiveTaxMoney(getRefundedInclusiveTaxMoney())
                .refundedTipMoney(getRefundedTipMoney())
                .refundedDiscountMoney(getRefundedDiscountMoney())
                .refundedSurchargeMoney(getRefundedSurchargeMoney())
                .createdAt(getCreatedAt());
        builder.reason = internalGetReason();
        builder.refundedAdditiveTax = internalGetRefundedAdditiveTax();
        builder.refundedInclusiveTax = internalGetRefundedInclusiveTax();
        builder.refundedSurcharges = internalGetRefundedSurcharges();
        builder.processedAt = internalGetProcessedAt();
        builder.paymentId = internalGetPaymentId();
        builder.merchantId = internalGetMerchantId();
        builder.isExchange = internalGetIsExchange();
        return builder;
    }

    /**
     * Class to build instances of {@link V1Refund}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String type;
        private OptionalNullable<String> reason;
        private V1Money refundedMoney;
        private V1Money refundedProcessingFeeMoney;
        private V1Money refundedTaxMoney;
        private V1Money refundedAdditiveTaxMoney;
        private OptionalNullable<List<V1PaymentTax>> refundedAdditiveTax;
        private V1Money refundedInclusiveTaxMoney;
        private OptionalNullable<List<V1PaymentTax>> refundedInclusiveTax;
        private V1Money refundedTipMoney;
        private V1Money refundedDiscountMoney;
        private V1Money refundedSurchargeMoney;
        private OptionalNullable<List<V1PaymentSurcharge>> refundedSurcharges;
        private String createdAt;
        private OptionalNullable<String> processedAt;
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> merchantId;
        private OptionalNullable<Boolean> isExchange;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = OptionalNullable.of(reason);
            return this;
        }

        /**
         * UnSetter for reason.
         * @return Builder
         */
        public Builder unsetReason() {
            reason = null;
            return this;
        }

        /**
         * Setter for refundedMoney.
         * @param  refundedMoney  V1Money value for refundedMoney.
         * @return Builder
         */
        public Builder refundedMoney(V1Money refundedMoney) {
            this.refundedMoney = refundedMoney;
            return this;
        }

        /**
         * Setter for refundedProcessingFeeMoney.
         * @param  refundedProcessingFeeMoney  V1Money value for refundedProcessingFeeMoney.
         * @return Builder
         */
        public Builder refundedProcessingFeeMoney(V1Money refundedProcessingFeeMoney) {
            this.refundedProcessingFeeMoney = refundedProcessingFeeMoney;
            return this;
        }

        /**
         * Setter for refundedTaxMoney.
         * @param  refundedTaxMoney  V1Money value for refundedTaxMoney.
         * @return Builder
         */
        public Builder refundedTaxMoney(V1Money refundedTaxMoney) {
            this.refundedTaxMoney = refundedTaxMoney;
            return this;
        }

        /**
         * Setter for refundedAdditiveTaxMoney.
         * @param  refundedAdditiveTaxMoney  V1Money value for refundedAdditiveTaxMoney.
         * @return Builder
         */
        public Builder refundedAdditiveTaxMoney(V1Money refundedAdditiveTaxMoney) {
            this.refundedAdditiveTaxMoney = refundedAdditiveTaxMoney;
            return this;
        }

        /**
         * Setter for refundedAdditiveTax.
         * @param  refundedAdditiveTax  List of V1PaymentTax value for refundedAdditiveTax.
         * @return Builder
         */
        public Builder refundedAdditiveTax(List<V1PaymentTax> refundedAdditiveTax) {
            this.refundedAdditiveTax = OptionalNullable.of(refundedAdditiveTax);
            return this;
        }

        /**
         * UnSetter for refundedAdditiveTax.
         * @return Builder
         */
        public Builder unsetRefundedAdditiveTax() {
            refundedAdditiveTax = null;
            return this;
        }

        /**
         * Setter for refundedInclusiveTaxMoney.
         * @param  refundedInclusiveTaxMoney  V1Money value for refundedInclusiveTaxMoney.
         * @return Builder
         */
        public Builder refundedInclusiveTaxMoney(V1Money refundedInclusiveTaxMoney) {
            this.refundedInclusiveTaxMoney = refundedInclusiveTaxMoney;
            return this;
        }

        /**
         * Setter for refundedInclusiveTax.
         * @param  refundedInclusiveTax  List of V1PaymentTax value for refundedInclusiveTax.
         * @return Builder
         */
        public Builder refundedInclusiveTax(List<V1PaymentTax> refundedInclusiveTax) {
            this.refundedInclusiveTax = OptionalNullable.of(refundedInclusiveTax);
            return this;
        }

        /**
         * UnSetter for refundedInclusiveTax.
         * @return Builder
         */
        public Builder unsetRefundedInclusiveTax() {
            refundedInclusiveTax = null;
            return this;
        }

        /**
         * Setter for refundedTipMoney.
         * @param  refundedTipMoney  V1Money value for refundedTipMoney.
         * @return Builder
         */
        public Builder refundedTipMoney(V1Money refundedTipMoney) {
            this.refundedTipMoney = refundedTipMoney;
            return this;
        }

        /**
         * Setter for refundedDiscountMoney.
         * @param  refundedDiscountMoney  V1Money value for refundedDiscountMoney.
         * @return Builder
         */
        public Builder refundedDiscountMoney(V1Money refundedDiscountMoney) {
            this.refundedDiscountMoney = refundedDiscountMoney;
            return this;
        }

        /**
         * Setter for refundedSurchargeMoney.
         * @param  refundedSurchargeMoney  V1Money value for refundedSurchargeMoney.
         * @return Builder
         */
        public Builder refundedSurchargeMoney(V1Money refundedSurchargeMoney) {
            this.refundedSurchargeMoney = refundedSurchargeMoney;
            return this;
        }

        /**
         * Setter for refundedSurcharges.
         * @param  refundedSurcharges  List of V1PaymentSurcharge value for refundedSurcharges.
         * @return Builder
         */
        public Builder refundedSurcharges(List<V1PaymentSurcharge> refundedSurcharges) {
            this.refundedSurcharges = OptionalNullable.of(refundedSurcharges);
            return this;
        }

        /**
         * UnSetter for refundedSurcharges.
         * @return Builder
         */
        public Builder unsetRefundedSurcharges() {
            refundedSurcharges = null;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for processedAt.
         * @param  processedAt  String value for processedAt.
         * @return Builder
         */
        public Builder processedAt(String processedAt) {
            this.processedAt = OptionalNullable.of(processedAt);
            return this;
        }

        /**
         * UnSetter for processedAt.
         * @return Builder
         */
        public Builder unsetProcessedAt() {
            processedAt = null;
            return this;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = OptionalNullable.of(paymentId);
            return this;
        }

        /**
         * UnSetter for paymentId.
         * @return Builder
         */
        public Builder unsetPaymentId() {
            paymentId = null;
            return this;
        }

        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = OptionalNullable.of(merchantId);
            return this;
        }

        /**
         * UnSetter for merchantId.
         * @return Builder
         */
        public Builder unsetMerchantId() {
            merchantId = null;
            return this;
        }

        /**
         * Setter for isExchange.
         * @param  isExchange  Boolean value for isExchange.
         * @return Builder
         */
        public Builder isExchange(Boolean isExchange) {
            this.isExchange = OptionalNullable.of(isExchange);
            return this;
        }

        /**
         * UnSetter for isExchange.
         * @return Builder
         */
        public Builder unsetIsExchange() {
            isExchange = null;
            return this;
        }

        /**
         * Builds a new {@link V1Refund} object using the set fields.
         * @return {@link V1Refund}
         */
        public V1Refund build() {
            V1Refund model =
                    new V1Refund(type, reason, refundedMoney, refundedProcessingFeeMoney,
                            refundedTaxMoney, refundedAdditiveTaxMoney, refundedAdditiveTax,
                            refundedInclusiveTaxMoney, refundedInclusiveTax, refundedTipMoney,
                            refundedDiscountMoney, refundedSurchargeMoney, refundedSurcharges,
                            createdAt, processedAt, paymentId, merchantId, isExchange);
            model.httpContext = httpContext;
            return model;
        }
    }
}
