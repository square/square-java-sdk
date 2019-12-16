package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Payment {

    @JsonCreator
    public V1Payment(
            @JsonProperty("id") String id,
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("creator_id") String creatorId,
            @JsonProperty("device") Device device,
            @JsonProperty("payment_url") String paymentUrl,
            @JsonProperty("receipt_url") String receiptUrl,
            @JsonProperty("inclusive_tax_money") V1Money inclusiveTaxMoney,
            @JsonProperty("additive_tax_money") V1Money additiveTaxMoney,
            @JsonProperty("tax_money") V1Money taxMoney,
            @JsonProperty("tip_money") V1Money tipMoney,
            @JsonProperty("discount_money") V1Money discountMoney,
            @JsonProperty("total_collected_money") V1Money totalCollectedMoney,
            @JsonProperty("processing_fee_money") V1Money processingFeeMoney,
            @JsonProperty("net_total_money") V1Money netTotalMoney,
            @JsonProperty("refunded_money") V1Money refundedMoney,
            @JsonProperty("swedish_rounding_money") V1Money swedishRoundingMoney,
            @JsonProperty("gross_sales_money") V1Money grossSalesMoney,
            @JsonProperty("net_sales_money") V1Money netSalesMoney,
            @JsonProperty("inclusive_tax") List<V1PaymentTax> inclusiveTax,
            @JsonProperty("additive_tax") List<V1PaymentTax> additiveTax,
            @JsonProperty("tender") List<V1Tender> tender,
            @JsonProperty("refunds") List<V1Refund> refunds,
            @JsonProperty("itemizations") List<V1PaymentItemization> itemizations,
            @JsonProperty("surcharge_money") V1Money surchargeMoney,
            @JsonProperty("surcharges") List<V1PaymentSurcharge> surcharges,
            @JsonProperty("is_partial") Boolean isPartial) {
        this.id = id;
        this.merchantId = merchantId;
        this.createdAt = createdAt;
        this.creatorId = creatorId;
        this.device = device;
        this.paymentUrl = paymentUrl;
        this.receiptUrl = receiptUrl;
        this.inclusiveTaxMoney = inclusiveTaxMoney;
        this.additiveTaxMoney = additiveTaxMoney;
        this.taxMoney = taxMoney;
        this.tipMoney = tipMoney;
        this.discountMoney = discountMoney;
        this.totalCollectedMoney = totalCollectedMoney;
        this.processingFeeMoney = processingFeeMoney;
        this.netTotalMoney = netTotalMoney;
        this.refundedMoney = refundedMoney;
        this.swedishRoundingMoney = swedishRoundingMoney;
        this.grossSalesMoney = grossSalesMoney;
        this.netSalesMoney = netSalesMoney;
        this.inclusiveTax = inclusiveTax;
        this.additiveTax = additiveTax;
        this.tender = tender;
        this.refunds = refunds;
        this.itemizations = itemizations;
        this.surchargeMoney = surchargeMoney;
        this.surcharges = surcharges;
        this.isPartial = isPartial;
    }

    private HttpContext httpContext;
    private final String id;
    private final String merchantId;
    private final String createdAt;
    private final String creatorId;
    private final Device device;
    private final String paymentUrl;
    private final String receiptUrl;
    private final V1Money inclusiveTaxMoney;
    private final V1Money additiveTaxMoney;
    private final V1Money taxMoney;
    private final V1Money tipMoney;
    private final V1Money discountMoney;
    private final V1Money totalCollectedMoney;
    private final V1Money processingFeeMoney;
    private final V1Money netTotalMoney;
    private final V1Money refundedMoney;
    private final V1Money swedishRoundingMoney;
    private final V1Money grossSalesMoney;
    private final V1Money netSalesMoney;
    private final List<V1PaymentTax> inclusiveTax;
    private final List<V1PaymentTax> additiveTax;
    private final List<V1Tender> tender;
    private final List<V1Refund> refunds;
    private final List<V1PaymentItemization> itemizations;
    private final V1Money surchargeMoney;
    private final List<V1PaymentSurcharge> surcharges;
    private final Boolean isPartial;

    @Override
    public int hashCode() {
        return Objects.hash(id, merchantId, createdAt, creatorId, device, paymentUrl, receiptUrl, inclusiveTaxMoney, additiveTaxMoney, taxMoney, tipMoney, discountMoney, totalCollectedMoney, processingFeeMoney, netTotalMoney, refundedMoney, swedishRoundingMoney, grossSalesMoney, netSalesMoney, inclusiveTax, additiveTax, tender, refunds, itemizations, surchargeMoney, surcharges, isPartial);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Payment)) {
            return false;
        }
        V1Payment v1Payment = (V1Payment) o;
        return Objects.equals(id, v1Payment.id) &&
            Objects.equals(merchantId, v1Payment.merchantId) &&
            Objects.equals(createdAt, v1Payment.createdAt) &&
            Objects.equals(creatorId, v1Payment.creatorId) &&
            Objects.equals(device, v1Payment.device) &&
            Objects.equals(paymentUrl, v1Payment.paymentUrl) &&
            Objects.equals(receiptUrl, v1Payment.receiptUrl) &&
            Objects.equals(inclusiveTaxMoney, v1Payment.inclusiveTaxMoney) &&
            Objects.equals(additiveTaxMoney, v1Payment.additiveTaxMoney) &&
            Objects.equals(taxMoney, v1Payment.taxMoney) &&
            Objects.equals(tipMoney, v1Payment.tipMoney) &&
            Objects.equals(discountMoney, v1Payment.discountMoney) &&
            Objects.equals(totalCollectedMoney, v1Payment.totalCollectedMoney) &&
            Objects.equals(processingFeeMoney, v1Payment.processingFeeMoney) &&
            Objects.equals(netTotalMoney, v1Payment.netTotalMoney) &&
            Objects.equals(refundedMoney, v1Payment.refundedMoney) &&
            Objects.equals(swedishRoundingMoney, v1Payment.swedishRoundingMoney) &&
            Objects.equals(grossSalesMoney, v1Payment.grossSalesMoney) &&
            Objects.equals(netSalesMoney, v1Payment.netSalesMoney) &&
            Objects.equals(inclusiveTax, v1Payment.inclusiveTax) &&
            Objects.equals(additiveTax, v1Payment.additiveTax) &&
            Objects.equals(tender, v1Payment.tender) &&
            Objects.equals(refunds, v1Payment.refunds) &&
            Objects.equals(itemizations, v1Payment.itemizations) &&
            Objects.equals(surchargeMoney, v1Payment.surchargeMoney) &&
            Objects.equals(surcharges, v1Payment.surcharges) &&
            Objects.equals(isPartial, v1Payment.isPartial);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The payment's unique identifier.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for MerchantId.
     * The unique identifier of the merchant that took the payment.
     */
    @JsonGetter("merchant_id")
    public String getMerchantId() { 
        return this.merchantId;
    }

    /**
     * Getter for CreatedAt.
     * The time when the payment was created, in ISO 8601 format. Reflects the time of the first payment if the object represents an incomplete partial payment, and the time of the last or complete payment otherwise.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for CreatorId.
     * The unique identifier of the Square account that took the payment.
     */
    @JsonGetter("creator_id")
    public String getCreatorId() { 
        return this.creatorId;
    }

    /**
     * Getter for Device.
     */
    @JsonGetter("device")
    public Device getDevice() { 
        return this.device;
    }

    /**
     * Getter for PaymentUrl.
     * The URL of the payment's detail page in the merchant dashboard. The merchant must be signed in to the merchant dashboard to view this page.
     */
    @JsonGetter("payment_url")
    public String getPaymentUrl() { 
        return this.paymentUrl;
    }

    /**
     * Getter for ReceiptUrl.
     * The URL of the receipt for the payment. Note that for split tender
     * payments, this URL corresponds to the receipt for the first tender
     * listed in the payment's tender field. Each Tender object has its own
     * receipt_url field you can use to get the other receipts associated with
     * a split tender payment.
     */
    @JsonGetter("receipt_url")
    public String getReceiptUrl() { 
        return this.receiptUrl;
    }

    /**
     * Getter for InclusiveTaxMoney.
     */
    @JsonGetter("inclusive_tax_money")
    public V1Money getInclusiveTaxMoney() { 
        return this.inclusiveTaxMoney;
    }

    /**
     * Getter for AdditiveTaxMoney.
     */
    @JsonGetter("additive_tax_money")
    public V1Money getAdditiveTaxMoney() { 
        return this.additiveTaxMoney;
    }

    /**
     * Getter for TaxMoney.
     */
    @JsonGetter("tax_money")
    public V1Money getTaxMoney() { 
        return this.taxMoney;
    }

    /**
     * Getter for TipMoney.
     */
    @JsonGetter("tip_money")
    public V1Money getTipMoney() { 
        return this.tipMoney;
    }

    /**
     * Getter for DiscountMoney.
     */
    @JsonGetter("discount_money")
    public V1Money getDiscountMoney() { 
        return this.discountMoney;
    }

    /**
     * Getter for TotalCollectedMoney.
     */
    @JsonGetter("total_collected_money")
    public V1Money getTotalCollectedMoney() { 
        return this.totalCollectedMoney;
    }

    /**
     * Getter for ProcessingFeeMoney.
     */
    @JsonGetter("processing_fee_money")
    public V1Money getProcessingFeeMoney() { 
        return this.processingFeeMoney;
    }

    /**
     * Getter for NetTotalMoney.
     */
    @JsonGetter("net_total_money")
    public V1Money getNetTotalMoney() { 
        return this.netTotalMoney;
    }

    /**
     * Getter for RefundedMoney.
     */
    @JsonGetter("refunded_money")
    public V1Money getRefundedMoney() { 
        return this.refundedMoney;
    }

    /**
     * Getter for SwedishRoundingMoney.
     */
    @JsonGetter("swedish_rounding_money")
    public V1Money getSwedishRoundingMoney() { 
        return this.swedishRoundingMoney;
    }

    /**
     * Getter for GrossSalesMoney.
     */
    @JsonGetter("gross_sales_money")
    public V1Money getGrossSalesMoney() { 
        return this.grossSalesMoney;
    }

    /**
     * Getter for NetSalesMoney.
     */
    @JsonGetter("net_sales_money")
    public V1Money getNetSalesMoney() { 
        return this.netSalesMoney;
    }

    /**
     * Getter for InclusiveTax.
     * All of the inclusive taxes associated with the payment.
     */
    @JsonGetter("inclusive_tax")
    public List<V1PaymentTax> getInclusiveTax() { 
        return this.inclusiveTax;
    }

    /**
     * Getter for AdditiveTax.
     * All of the additive taxes associated with the payment.
     */
    @JsonGetter("additive_tax")
    public List<V1PaymentTax> getAdditiveTax() { 
        return this.additiveTax;
    }

    /**
     * Getter for Tender.
     * All of the tenders associated with the payment.
     */
    @JsonGetter("tender")
    public List<V1Tender> getTender() { 
        return this.tender;
    }

    /**
     * Getter for Refunds.
     * All of the refunds applied to the payment. Note that the value of all refunds on a payment can exceed the value of all tenders if a merchant chooses to refund money to a tender after previously accepting returned goods as part of an exchange.
     */
    @JsonGetter("refunds")
    public List<V1Refund> getRefunds() { 
        return this.refunds;
    }

    /**
     * Getter for Itemizations.
     * The items purchased in the payment.
     */
    @JsonGetter("itemizations")
    public List<V1PaymentItemization> getItemizations() { 
        return this.itemizations;
    }

    /**
     * Getter for SurchargeMoney.
     */
    @JsonGetter("surcharge_money")
    public V1Money getSurchargeMoney() { 
        return this.surchargeMoney;
    }

    /**
     * Getter for Surcharges.
     * A list of all surcharges associated with the payment.
     */
    @JsonGetter("surcharges")
    public List<V1PaymentSurcharge> getSurcharges() { 
        return this.surcharges;
    }

    /**
     * Getter for IsPartial.
     * Indicates whether or not the payment is only partially paid for.
     * If true, this payment will have the tenders collected so far, but the
     * itemizations will be empty until the payment is completed.
     */
    @JsonGetter("is_partial")
    public Boolean getIsPartial() { 
        return this.isPartial;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .merchantId(getMerchantId())
            .createdAt(getCreatedAt())
            .creatorId(getCreatorId())
            .device(getDevice())
            .paymentUrl(getPaymentUrl())
            .receiptUrl(getReceiptUrl())
            .inclusiveTaxMoney(getInclusiveTaxMoney())
            .additiveTaxMoney(getAdditiveTaxMoney())
            .taxMoney(getTaxMoney())
            .tipMoney(getTipMoney())
            .discountMoney(getDiscountMoney())
            .totalCollectedMoney(getTotalCollectedMoney())
            .processingFeeMoney(getProcessingFeeMoney())
            .netTotalMoney(getNetTotalMoney())
            .refundedMoney(getRefundedMoney())
            .swedishRoundingMoney(getSwedishRoundingMoney())
            .grossSalesMoney(getGrossSalesMoney())
            .netSalesMoney(getNetSalesMoney())
            .inclusiveTax(getInclusiveTax())
            .additiveTax(getAdditiveTax())
            .tender(getTender())
            .refunds(getRefunds())
            .itemizations(getItemizations())
            .surchargeMoney(getSurchargeMoney())
            .surcharges(getSurcharges())
            .isPartial(getIsPartial());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String merchantId;
        private String createdAt;
        private String creatorId;
        private Device device;
        private String paymentUrl;
        private String receiptUrl;
        private V1Money inclusiveTaxMoney;
        private V1Money additiveTaxMoney;
        private V1Money taxMoney;
        private V1Money tipMoney;
        private V1Money discountMoney;
        private V1Money totalCollectedMoney;
        private V1Money processingFeeMoney;
        private V1Money netTotalMoney;
        private V1Money refundedMoney;
        private V1Money swedishRoundingMoney;
        private V1Money grossSalesMoney;
        private V1Money netSalesMoney;
        private List<V1PaymentTax> inclusiveTax;
        private List<V1PaymentTax> additiveTax;
        private List<V1Tender> tender;
        private List<V1Refund> refunds;
        private List<V1PaymentItemization> itemizations;
        private V1Money surchargeMoney;
        private List<V1PaymentSurcharge> surcharges;
        private Boolean isPartial;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder merchantId(String value) {
            merchantId = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder creatorId(String value) {
            creatorId = value;
            return this;
        }
        public Builder device(Device value) {
            device = value;
            return this;
        }
        public Builder paymentUrl(String value) {
            paymentUrl = value;
            return this;
        }
        public Builder receiptUrl(String value) {
            receiptUrl = value;
            return this;
        }
        public Builder inclusiveTaxMoney(V1Money value) {
            inclusiveTaxMoney = value;
            return this;
        }
        public Builder additiveTaxMoney(V1Money value) {
            additiveTaxMoney = value;
            return this;
        }
        public Builder taxMoney(V1Money value) {
            taxMoney = value;
            return this;
        }
        public Builder tipMoney(V1Money value) {
            tipMoney = value;
            return this;
        }
        public Builder discountMoney(V1Money value) {
            discountMoney = value;
            return this;
        }
        public Builder totalCollectedMoney(V1Money value) {
            totalCollectedMoney = value;
            return this;
        }
        public Builder processingFeeMoney(V1Money value) {
            processingFeeMoney = value;
            return this;
        }
        public Builder netTotalMoney(V1Money value) {
            netTotalMoney = value;
            return this;
        }
        public Builder refundedMoney(V1Money value) {
            refundedMoney = value;
            return this;
        }
        public Builder swedishRoundingMoney(V1Money value) {
            swedishRoundingMoney = value;
            return this;
        }
        public Builder grossSalesMoney(V1Money value) {
            grossSalesMoney = value;
            return this;
        }
        public Builder netSalesMoney(V1Money value) {
            netSalesMoney = value;
            return this;
        }
        public Builder inclusiveTax(List<V1PaymentTax> value) {
            inclusiveTax = value;
            return this;
        }
        public Builder additiveTax(List<V1PaymentTax> value) {
            additiveTax = value;
            return this;
        }
        public Builder tender(List<V1Tender> value) {
            tender = value;
            return this;
        }
        public Builder refunds(List<V1Refund> value) {
            refunds = value;
            return this;
        }
        public Builder itemizations(List<V1PaymentItemization> value) {
            itemizations = value;
            return this;
        }
        public Builder surchargeMoney(V1Money value) {
            surchargeMoney = value;
            return this;
        }
        public Builder surcharges(List<V1PaymentSurcharge> value) {
            surcharges = value;
            return this;
        }
        public Builder isPartial(Boolean value) {
            isPartial = value;
            return this;
        }

        public V1Payment build() {
            V1Payment model = new V1Payment(id,
                merchantId,
                createdAt,
                creatorId,
                device,
                paymentUrl,
                receiptUrl,
                inclusiveTaxMoney,
                additiveTaxMoney,
                taxMoney,
                tipMoney,
                discountMoney,
                totalCollectedMoney,
                processingFeeMoney,
                netTotalMoney,
                refundedMoney,
                swedishRoundingMoney,
                grossSalesMoney,
                netSalesMoney,
                inclusiveTax,
                additiveTax,
                tender,
                refunds,
                itemizations,
                surchargeMoney,
                surcharges,
                isPartial);
            model.httpContext = httpContext;
            return model;
        }
    }
}
