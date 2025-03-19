/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = V1Tender.Builder.class)
public final class V1Tender {
    private final Optional<String> id;

    private final Optional<V1TenderType> type;

    private final Optional<String> name;

    private final Optional<String> employeeId;

    private final Optional<String> receiptUrl;

    private final Optional<V1TenderCardBrand> cardBrand;

    private final Optional<String> panSuffix;

    private final Optional<V1TenderEntryMethod> entryMethod;

    private final Optional<String> paymentNote;

    private final Optional<V1Money> totalMoney;

    private final Optional<V1Money> tenderedMoney;

    private final Optional<String> tenderedAt;

    private final Optional<String> settledAt;

    private final Optional<V1Money> changeBackMoney;

    private final Optional<V1Money> refundedMoney;

    private final Optional<Boolean> isExchange;

    private final Map<String, Object> additionalProperties;

    private V1Tender(
            Optional<String> id,
            Optional<V1TenderType> type,
            Optional<String> name,
            Optional<String> employeeId,
            Optional<String> receiptUrl,
            Optional<V1TenderCardBrand> cardBrand,
            Optional<String> panSuffix,
            Optional<V1TenderEntryMethod> entryMethod,
            Optional<String> paymentNote,
            Optional<V1Money> totalMoney,
            Optional<V1Money> tenderedMoney,
            Optional<String> tenderedAt,
            Optional<String> settledAt,
            Optional<V1Money> changeBackMoney,
            Optional<V1Money> refundedMoney,
            Optional<Boolean> isExchange,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The tender's unique ID.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The type of tender.
     * See <a href="#type-v1tendertype">V1TenderType</a> for possible values
     */
    @JsonProperty("type")
    public Optional<V1TenderType> getType() {
        return type;
    }

    /**
     * @return A human-readable description of the tender.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return The ID of the employee that processed the tender.
     */
    @JsonIgnore
    public Optional<String> getEmployeeId() {
        if (employeeId == null) {
            return Optional.empty();
        }
        return employeeId;
    }

    /**
     * @return The URL of the receipt for the tender.
     */
    @JsonIgnore
    public Optional<String> getReceiptUrl() {
        if (receiptUrl == null) {
            return Optional.empty();
        }
        return receiptUrl;
    }

    /**
     * @return The brand of credit card provided.
     * See <a href="#type-v1tendercardbrand">V1TenderCardBrand</a> for possible values
     */
    @JsonProperty("card_brand")
    public Optional<V1TenderCardBrand> getCardBrand() {
        return cardBrand;
    }

    /**
     * @return The last four digits of the provided credit card's account number.
     */
    @JsonIgnore
    public Optional<String> getPanSuffix() {
        if (panSuffix == null) {
            return Optional.empty();
        }
        return panSuffix;
    }

    /**
     * @return The tender's unique ID.
     * See <a href="#type-v1tenderentrymethod">V1TenderEntryMethod</a> for possible values
     */
    @JsonProperty("entry_method")
    public Optional<V1TenderEntryMethod> getEntryMethod() {
        return entryMethod;
    }

    /**
     * @return Notes entered by the merchant about the tender at the time of payment, if any. Typically only present for tender with the type: OTHER.
     */
    @JsonIgnore
    public Optional<String> getPaymentNote() {
        if (paymentNote == null) {
            return Optional.empty();
        }
        return paymentNote;
    }

    /**
     * @return The total amount of money provided in this form of tender.
     */
    @JsonProperty("total_money")
    public Optional<V1Money> getTotalMoney() {
        return totalMoney;
    }

    /**
     * @return The amount of total_money applied to the payment.
     */
    @JsonProperty("tendered_money")
    public Optional<V1Money> getTenderedMoney() {
        return tenderedMoney;
    }

    /**
     * @return The time when the tender was created, in ISO 8601 format.
     */
    @JsonIgnore
    public Optional<String> getTenderedAt() {
        if (tenderedAt == null) {
            return Optional.empty();
        }
        return tenderedAt;
    }

    /**
     * @return The time when the tender was settled, in ISO 8601 format.
     */
    @JsonIgnore
    public Optional<String> getSettledAt() {
        if (settledAt == null) {
            return Optional.empty();
        }
        return settledAt;
    }

    /**
     * @return The amount of total_money returned to the buyer as change.
     */
    @JsonProperty("change_back_money")
    public Optional<V1Money> getChangeBackMoney() {
        return changeBackMoney;
    }

    /**
     * @return The total of all refunds applied to this tender. This amount is always negative or zero.
     */
    @JsonProperty("refunded_money")
    public Optional<V1Money> getRefundedMoney() {
        return refundedMoney;
    }

    /**
     * @return Indicates whether or not the tender is associated with an exchange. If is_exchange is true, the tender represents the value of goods returned in an exchange not the actual money paid. The exchange value reduces the tender amounts needed to pay for items purchased in the exchange.
     */
    @JsonIgnore
    public Optional<Boolean> getIsExchange() {
        if (isExchange == null) {
            return Optional.empty();
        }
        return isExchange;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("employee_id")
    private Optional<String> _getEmployeeId() {
        return employeeId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("receipt_url")
    private Optional<String> _getReceiptUrl() {
        return receiptUrl;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("pan_suffix")
    private Optional<String> _getPanSuffix() {
        return panSuffix;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("payment_note")
    private Optional<String> _getPaymentNote() {
        return paymentNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("tendered_at")
    private Optional<String> _getTenderedAt() {
        return tenderedAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("settled_at")
    private Optional<String> _getSettledAt() {
        return settledAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("is_exchange")
    private Optional<Boolean> _getIsExchange() {
        return isExchange;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V1Tender && equalTo((V1Tender) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V1Tender other) {
        return id.equals(other.id)
                && type.equals(other.type)
                && name.equals(other.name)
                && employeeId.equals(other.employeeId)
                && receiptUrl.equals(other.receiptUrl)
                && cardBrand.equals(other.cardBrand)
                && panSuffix.equals(other.panSuffix)
                && entryMethod.equals(other.entryMethod)
                && paymentNote.equals(other.paymentNote)
                && totalMoney.equals(other.totalMoney)
                && tenderedMoney.equals(other.tenderedMoney)
                && tenderedAt.equals(other.tenderedAt)
                && settledAt.equals(other.settledAt)
                && changeBackMoney.equals(other.changeBackMoney)
                && refundedMoney.equals(other.refundedMoney)
                && isExchange.equals(other.isExchange);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.type,
                this.name,
                this.employeeId,
                this.receiptUrl,
                this.cardBrand,
                this.panSuffix,
                this.entryMethod,
                this.paymentNote,
                this.totalMoney,
                this.tenderedMoney,
                this.tenderedAt,
                this.settledAt,
                this.changeBackMoney,
                this.refundedMoney,
                this.isExchange);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<V1TenderType> type = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> employeeId = Optional.empty();

        private Optional<String> receiptUrl = Optional.empty();

        private Optional<V1TenderCardBrand> cardBrand = Optional.empty();

        private Optional<String> panSuffix = Optional.empty();

        private Optional<V1TenderEntryMethod> entryMethod = Optional.empty();

        private Optional<String> paymentNote = Optional.empty();

        private Optional<V1Money> totalMoney = Optional.empty();

        private Optional<V1Money> tenderedMoney = Optional.empty();

        private Optional<String> tenderedAt = Optional.empty();

        private Optional<String> settledAt = Optional.empty();

        private Optional<V1Money> changeBackMoney = Optional.empty();

        private Optional<V1Money> refundedMoney = Optional.empty();

        private Optional<Boolean> isExchange = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(V1Tender other) {
            id(other.getId());
            type(other.getType());
            name(other.getName());
            employeeId(other.getEmployeeId());
            receiptUrl(other.getReceiptUrl());
            cardBrand(other.getCardBrand());
            panSuffix(other.getPanSuffix());
            entryMethod(other.getEntryMethod());
            paymentNote(other.getPaymentNote());
            totalMoney(other.getTotalMoney());
            tenderedMoney(other.getTenderedMoney());
            tenderedAt(other.getTenderedAt());
            settledAt(other.getSettledAt());
            changeBackMoney(other.getChangeBackMoney());
            refundedMoney(other.getRefundedMoney());
            isExchange(other.getIsExchange());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<V1TenderType> type) {
            this.type = type;
            return this;
        }

        public Builder type(V1TenderType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Nullable<String> name) {
            if (name.isNull()) {
                this.name = null;
            } else if (name.isEmpty()) {
                this.name = Optional.empty();
            } else {
                this.name = Optional.of(name.get());
            }
            return this;
        }

        @JsonSetter(value = "employee_id", nulls = Nulls.SKIP)
        public Builder employeeId(Optional<String> employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = Optional.ofNullable(employeeId);
            return this;
        }

        public Builder employeeId(Nullable<String> employeeId) {
            if (employeeId.isNull()) {
                this.employeeId = null;
            } else if (employeeId.isEmpty()) {
                this.employeeId = Optional.empty();
            } else {
                this.employeeId = Optional.of(employeeId.get());
            }
            return this;
        }

        @JsonSetter(value = "receipt_url", nulls = Nulls.SKIP)
        public Builder receiptUrl(Optional<String> receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }

        public Builder receiptUrl(String receiptUrl) {
            this.receiptUrl = Optional.ofNullable(receiptUrl);
            return this;
        }

        public Builder receiptUrl(Nullable<String> receiptUrl) {
            if (receiptUrl.isNull()) {
                this.receiptUrl = null;
            } else if (receiptUrl.isEmpty()) {
                this.receiptUrl = Optional.empty();
            } else {
                this.receiptUrl = Optional.of(receiptUrl.get());
            }
            return this;
        }

        @JsonSetter(value = "card_brand", nulls = Nulls.SKIP)
        public Builder cardBrand(Optional<V1TenderCardBrand> cardBrand) {
            this.cardBrand = cardBrand;
            return this;
        }

        public Builder cardBrand(V1TenderCardBrand cardBrand) {
            this.cardBrand = Optional.ofNullable(cardBrand);
            return this;
        }

        @JsonSetter(value = "pan_suffix", nulls = Nulls.SKIP)
        public Builder panSuffix(Optional<String> panSuffix) {
            this.panSuffix = panSuffix;
            return this;
        }

        public Builder panSuffix(String panSuffix) {
            this.panSuffix = Optional.ofNullable(panSuffix);
            return this;
        }

        public Builder panSuffix(Nullable<String> panSuffix) {
            if (panSuffix.isNull()) {
                this.panSuffix = null;
            } else if (panSuffix.isEmpty()) {
                this.panSuffix = Optional.empty();
            } else {
                this.panSuffix = Optional.of(panSuffix.get());
            }
            return this;
        }

        @JsonSetter(value = "entry_method", nulls = Nulls.SKIP)
        public Builder entryMethod(Optional<V1TenderEntryMethod> entryMethod) {
            this.entryMethod = entryMethod;
            return this;
        }

        public Builder entryMethod(V1TenderEntryMethod entryMethod) {
            this.entryMethod = Optional.ofNullable(entryMethod);
            return this;
        }

        @JsonSetter(value = "payment_note", nulls = Nulls.SKIP)
        public Builder paymentNote(Optional<String> paymentNote) {
            this.paymentNote = paymentNote;
            return this;
        }

        public Builder paymentNote(String paymentNote) {
            this.paymentNote = Optional.ofNullable(paymentNote);
            return this;
        }

        public Builder paymentNote(Nullable<String> paymentNote) {
            if (paymentNote.isNull()) {
                this.paymentNote = null;
            } else if (paymentNote.isEmpty()) {
                this.paymentNote = Optional.empty();
            } else {
                this.paymentNote = Optional.of(paymentNote.get());
            }
            return this;
        }

        @JsonSetter(value = "total_money", nulls = Nulls.SKIP)
        public Builder totalMoney(Optional<V1Money> totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = Optional.ofNullable(totalMoney);
            return this;
        }

        @JsonSetter(value = "tendered_money", nulls = Nulls.SKIP)
        public Builder tenderedMoney(Optional<V1Money> tenderedMoney) {
            this.tenderedMoney = tenderedMoney;
            return this;
        }

        public Builder tenderedMoney(V1Money tenderedMoney) {
            this.tenderedMoney = Optional.ofNullable(tenderedMoney);
            return this;
        }

        @JsonSetter(value = "tendered_at", nulls = Nulls.SKIP)
        public Builder tenderedAt(Optional<String> tenderedAt) {
            this.tenderedAt = tenderedAt;
            return this;
        }

        public Builder tenderedAt(String tenderedAt) {
            this.tenderedAt = Optional.ofNullable(tenderedAt);
            return this;
        }

        public Builder tenderedAt(Nullable<String> tenderedAt) {
            if (tenderedAt.isNull()) {
                this.tenderedAt = null;
            } else if (tenderedAt.isEmpty()) {
                this.tenderedAt = Optional.empty();
            } else {
                this.tenderedAt = Optional.of(tenderedAt.get());
            }
            return this;
        }

        @JsonSetter(value = "settled_at", nulls = Nulls.SKIP)
        public Builder settledAt(Optional<String> settledAt) {
            this.settledAt = settledAt;
            return this;
        }

        public Builder settledAt(String settledAt) {
            this.settledAt = Optional.ofNullable(settledAt);
            return this;
        }

        public Builder settledAt(Nullable<String> settledAt) {
            if (settledAt.isNull()) {
                this.settledAt = null;
            } else if (settledAt.isEmpty()) {
                this.settledAt = Optional.empty();
            } else {
                this.settledAt = Optional.of(settledAt.get());
            }
            return this;
        }

        @JsonSetter(value = "change_back_money", nulls = Nulls.SKIP)
        public Builder changeBackMoney(Optional<V1Money> changeBackMoney) {
            this.changeBackMoney = changeBackMoney;
            return this;
        }

        public Builder changeBackMoney(V1Money changeBackMoney) {
            this.changeBackMoney = Optional.ofNullable(changeBackMoney);
            return this;
        }

        @JsonSetter(value = "refunded_money", nulls = Nulls.SKIP)
        public Builder refundedMoney(Optional<V1Money> refundedMoney) {
            this.refundedMoney = refundedMoney;
            return this;
        }

        public Builder refundedMoney(V1Money refundedMoney) {
            this.refundedMoney = Optional.ofNullable(refundedMoney);
            return this;
        }

        @JsonSetter(value = "is_exchange", nulls = Nulls.SKIP)
        public Builder isExchange(Optional<Boolean> isExchange) {
            this.isExchange = isExchange;
            return this;
        }

        public Builder isExchange(Boolean isExchange) {
            this.isExchange = Optional.ofNullable(isExchange);
            return this;
        }

        public Builder isExchange(Nullable<Boolean> isExchange) {
            if (isExchange.isNull()) {
                this.isExchange = null;
            } else if (isExchange.isEmpty()) {
                this.isExchange = Optional.empty();
            } else {
                this.isExchange = Optional.of(isExchange.get());
            }
            return this;
        }

        public V1Tender build() {
            return new V1Tender(
                    id,
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
                    isExchange,
                    additionalProperties);
        }
    }
}
