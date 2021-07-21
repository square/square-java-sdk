
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ExternalPaymentDetails type.
 */
public class ExternalPaymentDetails {
    private final String type;
    private final String source;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sourceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money sourceFeeMoney;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  source  String value for source.
     * @param  sourceId  String value for sourceId.
     * @param  sourceFeeMoney  Money value for sourceFeeMoney.
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

    /**
     * Getter for Type.
     * The type of external payment the seller received. It can be one of the following: - CHECK -
     * Paid using a physical check. - BANK_TRANSFER - Paid using external bank transfer. -
     * OTHER\_GIFT\_CARD - Paid using a non-Square gift card. - CRYPTO - Paid using a crypto
     * currency. - SQUARE_CASH - Paid using Square Cash App. - SOCIAL - Paid using peer-to-peer
     * payment applications. - EXTERNAL - A third-party application gathered this payment outside of
     * Square. - EMONEY - Paid using an E-money provider. - CARD - A credit or debit card that
     * Square does not support. - STORED_BALANCE - Use for house accounts, store credit, and so
     * forth. - FOOD_VOUCHER - Restaurant voucher provided by employers to employees to pay for
     * meals - OTHER - A type not listed here.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Source.
     * A description of the external payment source. For example, "Food Delivery Service".
     * @return Returns the String
     */
    @JsonGetter("source")
    public String getSource() {
        return source;
    }

    /**
     * Getter for SourceId.
     * An ID to associate the payment to its originating source.
     * @return Returns the String
     */
    @JsonGetter("source_id")
    public String getSourceId() {
        return sourceId;
    }

    /**
     * Getter for SourceFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("source_fee_money")
    public Money getSourceFeeMoney() {
        return sourceFeeMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, source, sourceId, sourceFeeMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPaymentDetails)) {
            return false;
        }
        ExternalPaymentDetails other = (ExternalPaymentDetails) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(source, other.source)
            && Objects.equals(sourceId, other.sourceId)
            && Objects.equals(sourceFeeMoney, other.sourceFeeMoney);
    }

    /**
     * Converts this ExternalPaymentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ExternalPaymentDetails [" + "type=" + type + ", source=" + source + ", sourceId="
                + sourceId + ", sourceFeeMoney=" + sourceFeeMoney + "]";
    }

    /**
     * Builds a new {@link ExternalPaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ExternalPaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type, source)
                .sourceId(getSourceId())
                .sourceFeeMoney(getSourceFeeMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link ExternalPaymentDetails}.
     */
    public static class Builder {
        private String type;
        private String source;
        private String sourceId;
        private Money sourceFeeMoney;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         * @param  source  String value for source.
         */
        public Builder(String type, String source) {
            this.type = type;
            this.source = source;
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
         * Setter for source.
         * @param  source  String value for source.
         * @return Builder
         */
        public Builder source(String source) {
            this.source = source;
            return this;
        }

        /**
         * Setter for sourceId.
         * @param  sourceId  String value for sourceId.
         * @return Builder
         */
        public Builder sourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        /**
         * Setter for sourceFeeMoney.
         * @param  sourceFeeMoney  Money value for sourceFeeMoney.
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
            return new ExternalPaymentDetails(type, source, sourceId, sourceFeeMoney);
        }
    }
}
