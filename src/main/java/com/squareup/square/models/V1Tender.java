package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1Tender type.
 */
public class V1Tender {

    /**
     * Initialization constructor.
     * @param id
     * @param type
     * @param name
     * @param employeeId
     * @param receiptUrl
     * @param cardBrand
     * @param panSuffix
     * @param entryMethod
     * @param paymentNote
     * @param totalMoney
     * @param tenderedMoney
     * @param tenderedAt
     * @param settledAt
     * @param changeBackMoney
     * @param refundedMoney
     * @param isExchange
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, employeeId, receiptUrl, cardBrand, panSuffix,
            entryMethod, paymentNote, totalMoney, tenderedMoney, tenderedAt, settledAt,
            changeBackMoney, refundedMoney, isExchange);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Tender)) {
            return false;
        }
        V1Tender v1Tender = (V1Tender) obj;
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
     * Builds a new {@link V1Tender.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Tender.Builder} object
     */
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

    /**
     * Class to build instances of {@link V1Tender}
     */
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

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for employeeId
         * @param employeeId
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        /**
         * Setter for receiptUrl
         * @param receiptUrl
         * @return Builder
         */
        public Builder receiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }
        /**
         * Setter for cardBrand
         * @param cardBrand
         * @return Builder
         */
        public Builder cardBrand(String cardBrand) {
            this.cardBrand = cardBrand;
            return this;
        }
        /**
         * Setter for panSuffix
         * @param panSuffix
         * @return Builder
         */
        public Builder panSuffix(String panSuffix) {
            this.panSuffix = panSuffix;
            return this;
        }
        /**
         * Setter for entryMethod
         * @param entryMethod
         * @return Builder
         */
        public Builder entryMethod(String entryMethod) {
            this.entryMethod = entryMethod;
            return this;
        }
        /**
         * Setter for paymentNote
         * @param paymentNote
         * @return Builder
         */
        public Builder paymentNote(String paymentNote) {
            this.paymentNote = paymentNote;
            return this;
        }
        /**
         * Setter for totalMoney
         * @param totalMoney
         * @return Builder
         */
        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }
        /**
         * Setter for tenderedMoney
         * @param tenderedMoney
         * @return Builder
         */
        public Builder tenderedMoney(V1Money tenderedMoney) {
            this.tenderedMoney = tenderedMoney;
            return this;
        }
        /**
         * Setter for tenderedAt
         * @param tenderedAt
         * @return Builder
         */
        public Builder tenderedAt(String tenderedAt) {
            this.tenderedAt = tenderedAt;
            return this;
        }
        /**
         * Setter for settledAt
         * @param settledAt
         * @return Builder
         */
        public Builder settledAt(String settledAt) {
            this.settledAt = settledAt;
            return this;
        }
        /**
         * Setter for changeBackMoney
         * @param changeBackMoney
         * @return Builder
         */
        public Builder changeBackMoney(V1Money changeBackMoney) {
            this.changeBackMoney = changeBackMoney;
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
         * Setter for isExchange
         * @param isExchange
         * @return Builder
         */
        public Builder isExchange(Boolean isExchange) {
            this.isExchange = isExchange;
            return this;
        }

        /**
         * Builds a new {@link V1Tender} object using the set fields.
         * @return {@link V1Tender}
         */
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
