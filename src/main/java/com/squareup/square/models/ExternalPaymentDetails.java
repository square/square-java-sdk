package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ExternalPaymentDetails {

    @JsonCreator
    public ExternalPaymentDetails(
            @JsonProperty("type") String type,
            @JsonProperty("source") String source,
            @JsonProperty("source_id") String sourceId,
            @JsonProperty("source_fee_money") Money sourceFeeMoney) {
        this.type = type;
        this.source = source;
        this.sourceId = sourceId;
        this.sourceFeeMoney = sourceFeeMoney;
    }

    private final String type;
    private final String source;
    private final String sourceId;
    private final Money sourceFeeMoney;

    @Override
    public int hashCode() {
        return Objects.hash(type, source, sourceId, sourceFeeMoney);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ExternalPaymentDetails)) {
            return false;
        }
        ExternalPaymentDetails externalPaymentDetails = (ExternalPaymentDetails) o;
        return Objects.equals(type, externalPaymentDetails.type) &&
            Objects.equals(source, externalPaymentDetails.source) &&
            Objects.equals(sourceId, externalPaymentDetails.sourceId) &&
            Objects.equals(sourceFeeMoney, externalPaymentDetails.sourceFeeMoney);
    }

    /**
     * Getter for Type.
     * The type of External payment which can be one of:
     * CHECK - Paid by a physical check
     * BANK_TRANSFER - Paid by ACH or other bank transfer
     * OTHER_GIFT_CARD - Paid by a non-square gift card
     * CRYPTO - Paid via a crypto currency
     * SQUARE_CASH - Paid via Square Cash app
     * SOCIAL - Venmo, WeChatPay, AliPay, etc.
     * EXTERNAL - A 3rd party application gathered this payment outside of Square
     * EMONEY - A Japanese e-money brand Square doesn’t support
     * CREDIT/DEBIT - A credit/debit card Square doesn’t support
     * OTHER - A type not listed here
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for Source.
     * A description of the source of the external payment, e.g. “Uber Eats”, “Stripe”, “Shopify”.
     * Limit 255 characters
     */
    @JsonGetter("source")
    public String getSource() { 
        return this.source;
    }

    /**
     * Getter for SourceId.
     * An ID to associate this payment to its originating source
     * Limit 255 characters.
     */
    @JsonGetter("source_id")
    public String getSourceId() { 
        return this.sourceId;
    }

    /**
     * Getter for SourceFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("source_fee_money")
    public Money getSourceFeeMoney() { 
        return this.sourceFeeMoney;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            source)
            .sourceId(getSourceId())
            .sourceFeeMoney(getSourceFeeMoney());
            return builder;
    }

    public static class Builder {
        private String type;
        private String source;
        private String sourceId;
        private Money sourceFeeMoney;

        public Builder(String type,
                String source) {
            this.type = type;
            this.source = source;
        }

        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder source(String value) {
            source = value;
            return this;
        }
        public Builder sourceId(String value) {
            sourceId = value;
            return this;
        }
        public Builder sourceFeeMoney(Money value) {
            sourceFeeMoney = value;
            return this;
        }

        public ExternalPaymentDetails build() {
            return new ExternalPaymentDetails(type,
                source,
                sourceId,
                sourceFeeMoney);
        }
    }
}
