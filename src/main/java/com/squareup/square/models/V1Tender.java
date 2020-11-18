
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1Tender type.
 */
public class V1Tender {
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
     * Initialization constructor.
     * @param id String value for id.
     * @param type String value for type.
     * @param name String value for name.
     * @param employeeId String value for employeeId.
     * @param receiptUrl String value for receiptUrl.
     * @param cardBrand String value for cardBrand.
     * @param panSuffix String value for panSuffix.
     * @param entryMethod String value for entryMethod.
     * @param paymentNote String value for paymentNote.
     * @param totalMoney V1Money value for totalMoney.
     * @param tenderedMoney V1Money value for tenderedMoney.
     * @param tenderedAt String value for tenderedAt.
     * @param settledAt String value for settledAt.
     * @param changeBackMoney V1Money value for changeBackMoney.
     * @param refundedMoney V1Money value for refundedMoney.
     * @param isExchange Boolean value for isExchange.
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

    /**
     * Getter for Id.
     * The tender's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Name.
     * A human-readable description of the tender.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee that processed the tender.
     * @return Returns the String
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for ReceiptUrl.
     * The URL of the receipt for the tender.
     * @return Returns the String
     */
    @JsonGetter("receipt_url")
    public String getReceiptUrl() {
        return this.receiptUrl;
    }

    /**
     * Getter for CardBrand.
     * The brand of a credit card.
     * @return Returns the String
     */
    @JsonGetter("card_brand")
    public String getCardBrand() {
        return this.cardBrand;
    }

    /**
     * Getter for PanSuffix.
     * The last four digits of the provided credit card's account number.
     * @return Returns the String
     */
    @JsonGetter("pan_suffix")
    public String getPanSuffix() {
        return this.panSuffix;
    }

    /**
     * Getter for EntryMethod.
     * @return Returns the String
     */
    @JsonGetter("entry_method")
    public String getEntryMethod() {
        return this.entryMethod;
    }

    /**
     * Getter for PaymentNote.
     * Notes entered by the merchant about the tender at the time of payment, if any. Typically only
     * present for tender with the type: OTHER.
     * @return Returns the String
     */
    @JsonGetter("payment_note")
    public String getPaymentNote() {
        return this.paymentNote;
    }

    /**
     * Getter for TotalMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_money")
    public V1Money getTotalMoney() {
        return this.totalMoney;
    }

    /**
     * Getter for TenderedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("tendered_money")
    public V1Money getTenderedMoney() {
        return this.tenderedMoney;
    }

    /**
     * Getter for TenderedAt.
     * The time when the tender was created, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("tendered_at")
    public String getTenderedAt() {
        return this.tenderedAt;
    }

    /**
     * Getter for SettledAt.
     * The time when the tender was settled, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("settled_at")
    public String getSettledAt() {
        return this.settledAt;
    }

    /**
     * Getter for ChangeBackMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("change_back_money")
    public V1Money getChangeBackMoney() {
        return this.changeBackMoney;
    }

    /**
     * Getter for RefundedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("refunded_money")
    public V1Money getRefundedMoney() {
        return this.refundedMoney;
    }

    /**
     * Getter for IsExchange.
     * Indicates whether or not the tender is associated with an exchange. If is_exchange is true,
     * the tender represents the value of goods returned in an exchange not the actual money paid.
     * The exchange value reduces the tender amounts needed to pay for items purchased in the
     * exchange.
     * @return Returns the Boolean
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Tender)) {
            return false;
        }
        V1Tender other = (V1Tender) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(name, other.name)
            && Objects.equals(employeeId, other.employeeId)
            && Objects.equals(receiptUrl, other.receiptUrl)
            && Objects.equals(cardBrand, other.cardBrand)
            && Objects.equals(panSuffix, other.panSuffix)
            && Objects.equals(entryMethod, other.entryMethod)
            && Objects.equals(paymentNote, other.paymentNote)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(tenderedMoney, other.tenderedMoney)
            && Objects.equals(tenderedAt, other.tenderedAt)
            && Objects.equals(settledAt, other.settledAt)
            && Objects.equals(changeBackMoney, other.changeBackMoney)
            && Objects.equals(refundedMoney, other.refundedMoney)
            && Objects.equals(isExchange, other.isExchange);
    }

    /**
     * Converts this V1Tender into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Tender [" + "id=" + id + ", type=" + type + ", name=" + name + ", employeeId="
                + employeeId + ", receiptUrl=" + receiptUrl + ", cardBrand=" + cardBrand
                + ", panSuffix=" + panSuffix + ", entryMethod=" + entryMethod + ", paymentNote="
                + paymentNote + ", totalMoney=" + totalMoney + ", tenderedMoney=" + tenderedMoney
                + ", tenderedAt=" + tenderedAt + ", settledAt=" + settledAt + ", changeBackMoney="
                + changeBackMoney + ", refundedMoney=" + refundedMoney + ", isExchange="
                + isExchange + "]";
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
     * Class to build instances of {@link V1Tender}.
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
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for type.
         * @param type String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for employeeId.
         * @param employeeId String value for employeeId.
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        /**
         * Setter for receiptUrl.
         * @param receiptUrl String value for receiptUrl.
         * @return Builder
         */
        public Builder receiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }

        /**
         * Setter for cardBrand.
         * @param cardBrand String value for cardBrand.
         * @return Builder
         */
        public Builder cardBrand(String cardBrand) {
            this.cardBrand = cardBrand;
            return this;
        }

        /**
         * Setter for panSuffix.
         * @param panSuffix String value for panSuffix.
         * @return Builder
         */
        public Builder panSuffix(String panSuffix) {
            this.panSuffix = panSuffix;
            return this;
        }

        /**
         * Setter for entryMethod.
         * @param entryMethod String value for entryMethod.
         * @return Builder
         */
        public Builder entryMethod(String entryMethod) {
            this.entryMethod = entryMethod;
            return this;
        }

        /**
         * Setter for paymentNote.
         * @param paymentNote String value for paymentNote.
         * @return Builder
         */
        public Builder paymentNote(String paymentNote) {
            this.paymentNote = paymentNote;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param totalMoney V1Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for tenderedMoney.
         * @param tenderedMoney V1Money value for tenderedMoney.
         * @return Builder
         */
        public Builder tenderedMoney(V1Money tenderedMoney) {
            this.tenderedMoney = tenderedMoney;
            return this;
        }

        /**
         * Setter for tenderedAt.
         * @param tenderedAt String value for tenderedAt.
         * @return Builder
         */
        public Builder tenderedAt(String tenderedAt) {
            this.tenderedAt = tenderedAt;
            return this;
        }

        /**
         * Setter for settledAt.
         * @param settledAt String value for settledAt.
         * @return Builder
         */
        public Builder settledAt(String settledAt) {
            this.settledAt = settledAt;
            return this;
        }

        /**
         * Setter for changeBackMoney.
         * @param changeBackMoney V1Money value for changeBackMoney.
         * @return Builder
         */
        public Builder changeBackMoney(V1Money changeBackMoney) {
            this.changeBackMoney = changeBackMoney;
            return this;
        }

        /**
         * Setter for refundedMoney.
         * @param refundedMoney V1Money value for refundedMoney.
         * @return Builder
         */
        public Builder refundedMoney(V1Money refundedMoney) {
            this.refundedMoney = refundedMoney;
            return this;
        }

        /**
         * Setter for isExchange.
         * @param isExchange Boolean value for isExchange.
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
            return new V1Tender(id, type, name, employeeId, receiptUrl, cardBrand, panSuffix,
                    entryMethod, paymentNote, totalMoney, tenderedMoney, tenderedAt, settledAt,
                    changeBackMoney, refundedMoney, isExchange);
        }
    }
}
