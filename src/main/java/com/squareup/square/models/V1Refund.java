package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Refund type.
 */
public class V1Refund {

    /**
     * Initialization constructor.
     * @param type
     * @param reason
     * @param refundedMoney
     * @param refundedProcessingFeeMoney
     * @param refundedTaxMoney
     * @param refundedAdditiveTaxMoney
     * @param refundedAdditiveTax
     * @param refundedInclusiveTaxMoney
     * @param refundedInclusiveTax
     * @param refundedTipMoney
     * @param refundedDiscountMoney
     * @param refundedSurchargeMoney
     * @param refundedSurcharges
     * @param createdAt
     * @param processedAt
     * @param paymentId
     * @param merchantId
     * @param isExchange
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

    private HttpContext httpContext;
    private final String type;
    private final String reason;
    private final V1Money refundedMoney;
    private final V1Money refundedProcessingFeeMoney;
    private final V1Money refundedTaxMoney;
    private final V1Money refundedAdditiveTaxMoney;
    private final List<V1PaymentTax> refundedAdditiveTax;
    private final V1Money refundedInclusiveTaxMoney;
    private final List<V1PaymentTax> refundedInclusiveTax;
    private final V1Money refundedTipMoney;
    private final V1Money refundedDiscountMoney;
    private final V1Money refundedSurchargeMoney;
    private final List<V1PaymentSurcharge> refundedSurcharges;
    private final String createdAt;
    private final String processedAt;
    private final String paymentId;
    private final String merchantId;
    private final Boolean isExchange;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Reason.
     * The merchant-specified reason for the refund.
     */
    @JsonGetter("reason")
    public String getReason() {
        return this.reason;
    }

    /**
     * Getter for RefundedMoney.
     */
    @JsonGetter("refunded_money")
    public V1Money getRefundedMoney() {
        return this.refundedMoney;
    }

    /**
     * Getter for RefundedProcessingFeeMoney.
     */
    @JsonGetter("refunded_processing_fee_money")
    public V1Money getRefundedProcessingFeeMoney() {
        return this.refundedProcessingFeeMoney;
    }

    /**
     * Getter for RefundedTaxMoney.
     */
    @JsonGetter("refunded_tax_money")
    public V1Money getRefundedTaxMoney() {
        return this.refundedTaxMoney;
    }

    /**
     * Getter for RefundedAdditiveTaxMoney.
     */
    @JsonGetter("refunded_additive_tax_money")
    public V1Money getRefundedAdditiveTaxMoney() {
        return this.refundedAdditiveTaxMoney;
    }

    /**
     * Getter for RefundedAdditiveTax.
     * All of the additive taxes associated with the refund.
     */
    @JsonGetter("refunded_additive_tax")
    public List<V1PaymentTax> getRefundedAdditiveTax() {
        return this.refundedAdditiveTax;
    }

    /**
     * Getter for RefundedInclusiveTaxMoney.
     */
    @JsonGetter("refunded_inclusive_tax_money")
    public V1Money getRefundedInclusiveTaxMoney() {
        return this.refundedInclusiveTaxMoney;
    }

    /**
     * Getter for RefundedInclusiveTax.
     * All of the inclusive taxes associated with the refund.
     */
    @JsonGetter("refunded_inclusive_tax")
    public List<V1PaymentTax> getRefundedInclusiveTax() {
        return this.refundedInclusiveTax;
    }

    /**
     * Getter for RefundedTipMoney.
     */
    @JsonGetter("refunded_tip_money")
    public V1Money getRefundedTipMoney() {
        return this.refundedTipMoney;
    }

    /**
     * Getter for RefundedDiscountMoney.
     */
    @JsonGetter("refunded_discount_money")
    public V1Money getRefundedDiscountMoney() {
        return this.refundedDiscountMoney;
    }

    /**
     * Getter for RefundedSurchargeMoney.
     */
    @JsonGetter("refunded_surcharge_money")
    public V1Money getRefundedSurchargeMoney() {
        return this.refundedSurchargeMoney;
    }

    /**
     * Getter for RefundedSurcharges.
     * A list of all surcharges associated with the refund.
     */
    @JsonGetter("refunded_surcharges")
    public List<V1PaymentSurcharge> getRefundedSurcharges() {
        return this.refundedSurcharges;
    }

    /**
     * Getter for CreatedAt.
     * The time when the merchant initiated the refund for Square to process, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for ProcessedAt.
     * The time when Square processed the refund on behalf of the merchant, in ISO 8601 format.
     */
    @JsonGetter("processed_at")
    public String getProcessedAt() {
        return this.processedAt;
    }

    /**
     * Getter for PaymentId.
     * A Square-issued ID associated with the refund. For single-tender refunds, payment_id is the ID of the original payment ID. For split-tender refunds, payment_id is the ID of the original tender. For exchange-based refunds (is_exchange == true), payment_id is the ID of the original payment ID even if the payment includes other tenders.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for MerchantId.
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for IsExchange.
     * Indicates whether or not the refund is associated with an exchange. If is_exchange is true, the refund reflects the value of goods returned in the exchange not the total money refunded.
     */
    @JsonGetter("is_exchange")
    public Boolean getIsExchange() {
        return this.isExchange;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(type, reason, refundedMoney, refundedProcessingFeeMoney,
            refundedTaxMoney, refundedAdditiveTaxMoney, refundedAdditiveTax,
            refundedInclusiveTaxMoney, refundedInclusiveTax, refundedTipMoney, refundedDiscountMoney,
            refundedSurchargeMoney, refundedSurcharges, createdAt, processedAt, paymentId,
            merchantId, isExchange);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Refund)) {
            return false;
        }
        V1Refund v1Refund = (V1Refund) obj;
        return Objects.equals(type, v1Refund.type) &&
            Objects.equals(reason, v1Refund.reason) &&
            Objects.equals(refundedMoney, v1Refund.refundedMoney) &&
            Objects.equals(refundedProcessingFeeMoney, v1Refund.refundedProcessingFeeMoney) &&
            Objects.equals(refundedTaxMoney, v1Refund.refundedTaxMoney) &&
            Objects.equals(refundedAdditiveTaxMoney, v1Refund.refundedAdditiveTaxMoney) &&
            Objects.equals(refundedAdditiveTax, v1Refund.refundedAdditiveTax) &&
            Objects.equals(refundedInclusiveTaxMoney, v1Refund.refundedInclusiveTaxMoney) &&
            Objects.equals(refundedInclusiveTax, v1Refund.refundedInclusiveTax) &&
            Objects.equals(refundedTipMoney, v1Refund.refundedTipMoney) &&
            Objects.equals(refundedDiscountMoney, v1Refund.refundedDiscountMoney) &&
            Objects.equals(refundedSurchargeMoney, v1Refund.refundedSurchargeMoney) &&
            Objects.equals(refundedSurcharges, v1Refund.refundedSurcharges) &&
            Objects.equals(createdAt, v1Refund.createdAt) &&
            Objects.equals(processedAt, v1Refund.processedAt) &&
            Objects.equals(paymentId, v1Refund.paymentId) &&
            Objects.equals(merchantId, v1Refund.merchantId) &&
            Objects.equals(isExchange, v1Refund.isExchange);
    }

    /**
     * Builds a new {@link V1Refund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Refund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .type(getType())
            .reason(getReason())
            .refundedMoney(getRefundedMoney())
            .refundedProcessingFeeMoney(getRefundedProcessingFeeMoney())
            .refundedTaxMoney(getRefundedTaxMoney())
            .refundedAdditiveTaxMoney(getRefundedAdditiveTaxMoney())
            .refundedAdditiveTax(getRefundedAdditiveTax())
            .refundedInclusiveTaxMoney(getRefundedInclusiveTaxMoney())
            .refundedInclusiveTax(getRefundedInclusiveTax())
            .refundedTipMoney(getRefundedTipMoney())
            .refundedDiscountMoney(getRefundedDiscountMoney())
            .refundedSurchargeMoney(getRefundedSurchargeMoney())
            .refundedSurcharges(getRefundedSurcharges())
            .createdAt(getCreatedAt())
            .processedAt(getProcessedAt())
            .paymentId(getPaymentId())
            .merchantId(getMerchantId())
            .isExchange(getIsExchange());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Refund}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String type;
        private String reason;
        private V1Money refundedMoney;
        private V1Money refundedProcessingFeeMoney;
        private V1Money refundedTaxMoney;
        private V1Money refundedAdditiveTaxMoney;
        private List<V1PaymentTax> refundedAdditiveTax;
        private V1Money refundedInclusiveTaxMoney;
        private List<V1PaymentTax> refundedInclusiveTax;
        private V1Money refundedTipMoney;
        private V1Money refundedDiscountMoney;
        private V1Money refundedSurchargeMoney;
        private List<V1PaymentSurcharge> refundedSurcharges;
        private String createdAt;
        private String processedAt;
        private String paymentId;
        private String merchantId;
        private Boolean isExchange;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for reason
         * @param reason
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }
        /**
         * Setter for refundedMoney
         * @param refundedMoney
         * @return Builder
         */
        public Builder refundedMoney(V1Money refundedMoney) {
            this.refundedMoney = refundedMoney;
            return this;
        }
        /**
         * Setter for refundedProcessingFeeMoney
         * @param refundedProcessingFeeMoney
         * @return Builder
         */
        public Builder refundedProcessingFeeMoney(V1Money refundedProcessingFeeMoney) {
            this.refundedProcessingFeeMoney = refundedProcessingFeeMoney;
            return this;
        }
        /**
         * Setter for refundedTaxMoney
         * @param refundedTaxMoney
         * @return Builder
         */
        public Builder refundedTaxMoney(V1Money refundedTaxMoney) {
            this.refundedTaxMoney = refundedTaxMoney;
            return this;
        }
        /**
         * Setter for refundedAdditiveTaxMoney
         * @param refundedAdditiveTaxMoney
         * @return Builder
         */
        public Builder refundedAdditiveTaxMoney(V1Money refundedAdditiveTaxMoney) {
            this.refundedAdditiveTaxMoney = refundedAdditiveTaxMoney;
            return this;
        }
        /**
         * Setter for refundedAdditiveTax
         * @param refundedAdditiveTax
         * @return Builder
         */
        public Builder refundedAdditiveTax(List<V1PaymentTax> refundedAdditiveTax) {
            this.refundedAdditiveTax = refundedAdditiveTax;
            return this;
        }
        /**
         * Setter for refundedInclusiveTaxMoney
         * @param refundedInclusiveTaxMoney
         * @return Builder
         */
        public Builder refundedInclusiveTaxMoney(V1Money refundedInclusiveTaxMoney) {
            this.refundedInclusiveTaxMoney = refundedInclusiveTaxMoney;
            return this;
        }
        /**
         * Setter for refundedInclusiveTax
         * @param refundedInclusiveTax
         * @return Builder
         */
        public Builder refundedInclusiveTax(List<V1PaymentTax> refundedInclusiveTax) {
            this.refundedInclusiveTax = refundedInclusiveTax;
            return this;
        }
        /**
         * Setter for refundedTipMoney
         * @param refundedTipMoney
         * @return Builder
         */
        public Builder refundedTipMoney(V1Money refundedTipMoney) {
            this.refundedTipMoney = refundedTipMoney;
            return this;
        }
        /**
         * Setter for refundedDiscountMoney
         * @param refundedDiscountMoney
         * @return Builder
         */
        public Builder refundedDiscountMoney(V1Money refundedDiscountMoney) {
            this.refundedDiscountMoney = refundedDiscountMoney;
            return this;
        }
        /**
         * Setter for refundedSurchargeMoney
         * @param refundedSurchargeMoney
         * @return Builder
         */
        public Builder refundedSurchargeMoney(V1Money refundedSurchargeMoney) {
            this.refundedSurchargeMoney = refundedSurchargeMoney;
            return this;
        }
        /**
         * Setter for refundedSurcharges
         * @param refundedSurcharges
         * @return Builder
         */
        public Builder refundedSurcharges(List<V1PaymentSurcharge> refundedSurcharges) {
            this.refundedSurcharges = refundedSurcharges;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for processedAt
         * @param processedAt
         * @return Builder
         */
        public Builder processedAt(String processedAt) {
            this.processedAt = processedAt;
            return this;
        }
        /**
         * Setter for paymentId
         * @param paymentId
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }
        /**
         * Setter for merchantId
         * @param merchantId
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }
        /**
         * Setter for isExchange
         * @param isExchange
         * @return Builder
         */
        public Builder isExchange(Boolean isExchange) {
            this.isExchange = isExchange;
            return this;
        }

        /**
         * Builds a new {@link V1Refund} object using the set fields.
         * @return {@link V1Refund}
         */
        public V1Refund build() {
            V1Refund model = new V1Refund(type,
                reason,
                refundedMoney,
                refundedProcessingFeeMoney,
                refundedTaxMoney,
                refundedAdditiveTaxMoney,
                refundedAdditiveTax,
                refundedInclusiveTaxMoney,
                refundedInclusiveTax,
                refundedTipMoney,
                refundedDiscountMoney,
                refundedSurchargeMoney,
                refundedSurcharges,
                createdAt,
                processedAt,
                paymentId,
                merchantId,
                isExchange);
            model.httpContext = httpContext;
            return model;
        }
    }
}
