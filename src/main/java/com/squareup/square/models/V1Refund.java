package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Refund {

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

    @Override
    public int hashCode() {
        return Objects.hash(type, reason, refundedMoney, refundedProcessingFeeMoney, refundedTaxMoney, refundedAdditiveTaxMoney, refundedAdditiveTax, refundedInclusiveTaxMoney, refundedInclusiveTax, refundedTipMoney, refundedDiscountMoney, refundedSurchargeMoney, refundedSurcharges, createdAt, processedAt, paymentId, merchantId, isExchange);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Refund)) {
            return false;
        }
        V1Refund v1Refund = (V1Refund) o;
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

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder reason(String value) {
            reason = value;
            return this;
        }
        public Builder refundedMoney(V1Money value) {
            refundedMoney = value;
            return this;
        }
        public Builder refundedProcessingFeeMoney(V1Money value) {
            refundedProcessingFeeMoney = value;
            return this;
        }
        public Builder refundedTaxMoney(V1Money value) {
            refundedTaxMoney = value;
            return this;
        }
        public Builder refundedAdditiveTaxMoney(V1Money value) {
            refundedAdditiveTaxMoney = value;
            return this;
        }
        public Builder refundedAdditiveTax(List<V1PaymentTax> value) {
            refundedAdditiveTax = value;
            return this;
        }
        public Builder refundedInclusiveTaxMoney(V1Money value) {
            refundedInclusiveTaxMoney = value;
            return this;
        }
        public Builder refundedInclusiveTax(List<V1PaymentTax> value) {
            refundedInclusiveTax = value;
            return this;
        }
        public Builder refundedTipMoney(V1Money value) {
            refundedTipMoney = value;
            return this;
        }
        public Builder refundedDiscountMoney(V1Money value) {
            refundedDiscountMoney = value;
            return this;
        }
        public Builder refundedSurchargeMoney(V1Money value) {
            refundedSurchargeMoney = value;
            return this;
        }
        public Builder refundedSurcharges(List<V1PaymentSurcharge> value) {
            refundedSurcharges = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder processedAt(String value) {
            processedAt = value;
            return this;
        }
        public Builder paymentId(String value) {
            paymentId = value;
            return this;
        }
        public Builder merchantId(String value) {
            merchantId = value;
            return this;
        }
        public Builder isExchange(Boolean value) {
            isExchange = value;
            return this;
        }

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
