package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1Tender {

    @JsonCreator
    public V1Tender(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("name") String name,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("receipt_url") String receiptUrl,
            @JsonProperty("card_brand") String cardBrand,
            @JsonProperty("pan_suffix") String panSuffix,
            @JsonProperty("entry_method") String entryMethod,
            @JsonProperty("payment_note") String paymentNote,
            @JsonProperty("total_money") V1Money totalMoney,
            @JsonProperty("tendered_money") V1Money tenderedMoney,
            @JsonProperty("tendered_at") String tenderedAt,
            @JsonProperty("settled_at") String settledAt,
            @JsonProperty("change_back_money") V1Money changeBackMoney,
            @JsonProperty("refunded_money") V1Money refundedMoney,
            @JsonProperty("is_exchange") Boolean isExchange) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.employeeId = employeeId;
        this.receiptUrl = receiptUrl;
        this.cardBrand = cardBrand;
        this.panSuffix = panSuffix;
        this.entryMethod = entryMethod;
        this.paymentNote = paymentNote;
        this.totalMoney = totalMoney;
        this.tenderedMoney = tenderedMoney;
        this.tenderedAt = tenderedAt;
        this.settledAt = settledAt;
        this.changeBackMoney = changeBackMoney;
        this.refundedMoney = refundedMoney;
        this.isExchange = isExchange;
    }

    private final String id;
    private final String type;
    private final String name;
    private final String employeeId;
    private final String receiptUrl;
    private final String cardBrand;
    private final String panSuffix;
    private final String entryMethod;
    private final String paymentNote;
    private final V1Money totalMoney;
    private final V1Money tenderedMoney;
    private final String tenderedAt;
    private final String settledAt;
    private final V1Money changeBackMoney;
    private final V1Money refundedMoney;
    private final Boolean isExchange;

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, employeeId, receiptUrl, cardBrand, panSuffix, entryMethod, paymentNote, totalMoney, tenderedMoney, tenderedAt, settledAt, changeBackMoney, refundedMoney, isExchange);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Tender)) {
            return false;
        }
        V1Tender v1Tender = (V1Tender) o;
        return Objects.equals(id, v1Tender.id) &&
            Objects.equals(type, v1Tender.type) &&
            Objects.equals(name, v1Tender.name) &&
            Objects.equals(employeeId, v1Tender.employeeId) &&
            Objects.equals(receiptUrl, v1Tender.receiptUrl) &&
            Objects.equals(cardBrand, v1Tender.cardBrand) &&
            Objects.equals(panSuffix, v1Tender.panSuffix) &&
            Objects.equals(entryMethod, v1Tender.entryMethod) &&
            Objects.equals(paymentNote, v1Tender.paymentNote) &&
            Objects.equals(totalMoney, v1Tender.totalMoney) &&
            Objects.equals(tenderedMoney, v1Tender.tenderedMoney) &&
            Objects.equals(tenderedAt, v1Tender.tenderedAt) &&
            Objects.equals(settledAt, v1Tender.settledAt) &&
            Objects.equals(changeBackMoney, v1Tender.changeBackMoney) &&
            Objects.equals(refundedMoney, v1Tender.refundedMoney) &&
            Objects.equals(isExchange, v1Tender.isExchange);
    }

    /**
     * Getter for Id.
     * The tender's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for Name.
     * A human-readable description of the tender.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee that processed the tender.
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() { 
        return this.employeeId;
    }

    /**
     * Getter for ReceiptUrl.
     * The URL of the receipt for the tender.
     */
    @JsonGetter("receipt_url")
    public String getReceiptUrl() { 
        return this.receiptUrl;
    }

    /**
     * Getter for CardBrand.
     * The brand of a credit card.
     */
    @JsonGetter("card_brand")
    public String getCardBrand() { 
        return this.cardBrand;
    }

    /**
     * Getter for PanSuffix.
     * The last four digits of the provided credit card's account number.
     */
    @JsonGetter("pan_suffix")
    public String getPanSuffix() { 
        return this.panSuffix;
    }

    /**
     * Getter for EntryMethod.
     */
    @JsonGetter("entry_method")
    public String getEntryMethod() { 
        return this.entryMethod;
    }

    /**
     * Getter for PaymentNote.
     * Notes entered by the merchant about the tender at the time of payment, if any. Typically only present for tender with the type: OTHER.
     */
    @JsonGetter("payment_note")
    public String getPaymentNote() { 
        return this.paymentNote;
    }

    /**
     * Getter for TotalMoney.
     */
    @JsonGetter("total_money")
    public V1Money getTotalMoney() { 
        return this.totalMoney;
    }

    /**
     * Getter for TenderedMoney.
     */
    @JsonGetter("tendered_money")
    public V1Money getTenderedMoney() { 
        return this.tenderedMoney;
    }

    /**
     * Getter for TenderedAt.
     * The time when the tender was created, in ISO 8601 format.
     */
    @JsonGetter("tendered_at")
    public String getTenderedAt() { 
        return this.tenderedAt;
    }

    /**
     * Getter for SettledAt.
     * The time when the tender was settled, in ISO 8601 format.
     */
    @JsonGetter("settled_at")
    public String getSettledAt() { 
        return this.settledAt;
    }

    /**
     * Getter for ChangeBackMoney.
     */
    @JsonGetter("change_back_money")
    public V1Money getChangeBackMoney() { 
        return this.changeBackMoney;
    }

    /**
     * Getter for RefundedMoney.
     */
    @JsonGetter("refunded_money")
    public V1Money getRefundedMoney() { 
        return this.refundedMoney;
    }

    /**
     * Getter for IsExchange.
     * Indicates whether or not the tender is associated with an exchange. If is_exchange is true, the tender represents the value of goods returned in an exchange not the actual money paid. The exchange value reduces the tender amounts needed to pay for items purchased in the exchange.
     */
    @JsonGetter("is_exchange")
    public Boolean getIsExchange() { 
        return this.isExchange;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .type(getType())
            .name(getName())
            .employeeId(getEmployeeId())
            .receiptUrl(getReceiptUrl())
            .cardBrand(getCardBrand())
            .panSuffix(getPanSuffix())
            .entryMethod(getEntryMethod())
            .paymentNote(getPaymentNote())
            .totalMoney(getTotalMoney())
            .tenderedMoney(getTenderedMoney())
            .tenderedAt(getTenderedAt())
            .settledAt(getSettledAt())
            .changeBackMoney(getChangeBackMoney())
            .refundedMoney(getRefundedMoney())
            .isExchange(getIsExchange());
            return builder;
    }

    public static class Builder {
        private String id;
        private String type;
        private String name;
        private String employeeId;
        private String receiptUrl;
        private String cardBrand;
        private String panSuffix;
        private String entryMethod;
        private String paymentNote;
        private V1Money totalMoney;
        private V1Money tenderedMoney;
        private String tenderedAt;
        private String settledAt;
        private V1Money changeBackMoney;
        private V1Money refundedMoney;
        private Boolean isExchange;

        public Builder() { }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder employeeId(String value) {
            employeeId = value;
            return this;
        }
        public Builder receiptUrl(String value) {
            receiptUrl = value;
            return this;
        }
        public Builder cardBrand(String value) {
            cardBrand = value;
            return this;
        }
        public Builder panSuffix(String value) {
            panSuffix = value;
            return this;
        }
        public Builder entryMethod(String value) {
            entryMethod = value;
            return this;
        }
        public Builder paymentNote(String value) {
            paymentNote = value;
            return this;
        }
        public Builder totalMoney(V1Money value) {
            totalMoney = value;
            return this;
        }
        public Builder tenderedMoney(V1Money value) {
            tenderedMoney = value;
            return this;
        }
        public Builder tenderedAt(String value) {
            tenderedAt = value;
            return this;
        }
        public Builder settledAt(String value) {
            settledAt = value;
            return this;
        }
        public Builder changeBackMoney(V1Money value) {
            changeBackMoney = value;
            return this;
        }
        public Builder refundedMoney(V1Money value) {
            refundedMoney = value;
            return this;
        }
        public Builder isExchange(Boolean value) {
            isExchange = value;
            return this;
        }

        public V1Tender build() {
            return new V1Tender(id,
                type,
                name,
                employeeId,
                receiptUrl,
                cardBrand,
                panSuffix,
                entryMethod,
                paymentNote,
                totalMoney,
                tenderedMoney,
                tenderedAt,
                settledAt,
                changeBackMoney,
                refundedMoney,
                isExchange);
        }
    }
}
