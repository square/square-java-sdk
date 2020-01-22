package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ExternalPaymentDetails type.
 */
public class ExternalPaymentDetails {

    /**
     * Initialization constructor.
     * @param type
     * @param source
     * @param sourceId
     * @param sourceFeeMoney
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(type, source, sourceId, sourceFeeMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ExternalPaymentDetails)) {
            return false;
        }
        ExternalPaymentDetails externalPaymentDetails = (ExternalPaymentDetails) obj;
        return Objects.equals(type, externalPaymentDetails.type) &&
            Objects.equals(source, externalPaymentDetails.source) &&
            Objects.equals(sourceId, externalPaymentDetails.sourceId) &&
            Objects.equals(sourceFeeMoney, externalPaymentDetails.sourceFeeMoney);
    }

    /**
     * Builds a new {@link ExternalPaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ExternalPaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            source)
            .sourceId(getSourceId())
            .sourceFeeMoney(getSourceFeeMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link ExternalPaymentDetails}
     */
    public static class Builder {
        private String type;
        private String source;
        private String sourceId;
        private Money sourceFeeMoney;

        /**
         * Initialization constructor
         */
        public Builder(String type,
                String source) {
            this.type = type;
            this.source = source;
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
         * Setter for source
         * @param source
         * @return Builder
         */
        public Builder source(String source) {
            this.source = source;
            return this;
        }
        /**
         * Setter for sourceId
         * @param sourceId
         * @return Builder
         */
        public Builder sourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
        }
        /**
         * Setter for sourceFeeMoney
         * @param sourceFeeMoney
         * @return Builder
         */
        public Builder sourceFeeMoney(Money sourceFeeMoney) {
            this.sourceFeeMoney = sourceFeeMoney;
            return this;
        }

        /**
         * Builds a new {@link ExternalPaymentDetails} object using the set fields.
         * @return {@link ExternalPaymentDetails}
         */
        public ExternalPaymentDetails build() {
            return new ExternalPaymentDetails(type,
                source,
                sourceId,
                sourceFeeMoney);
        }
    }
}
