
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityTransferBalanceFrom type.
 */
public class GiftCardActivityTransferBalanceFrom {
    private final String transferToGiftCardId;
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  transferToGiftCardId  String value for transferToGiftCardId.
     * @param  amountMoney  Money value for amountMoney.
     */
    @JsonCreator
    public GiftCardActivityTransferBalanceFrom(
            @JsonProperty("transfer_to_gift_card_id") String transferToGiftCardId,
            @JsonProperty("amount_money") Money amountMoney) {
        this.transferToGiftCardId = transferToGiftCardId;
        this.amountMoney = amountMoney;
    }

    /**
     * Getter for TransferToGiftCardId.
     * The ID of the gift card to which the specified amount was transferred.
     * @return Returns the String
     */
    @JsonGetter("transfer_to_gift_card_id")
    public String getTransferToGiftCardId() {
        return transferToGiftCardId;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transferToGiftCardId, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityTransferBalanceFrom)) {
            return false;
        }
        GiftCardActivityTransferBalanceFrom other = (GiftCardActivityTransferBalanceFrom) obj;
        return Objects.equals(transferToGiftCardId, other.transferToGiftCardId)
            && Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this GiftCardActivityTransferBalanceFrom into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityTransferBalanceFrom [" + "transferToGiftCardId="
                + transferToGiftCardId + ", amountMoney=" + amountMoney + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityTransferBalanceFrom.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityTransferBalanceFrom.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(transferToGiftCardId, amountMoney);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityTransferBalanceFrom}.
     */
    public static class Builder {
        private String transferToGiftCardId;
        private Money amountMoney;

        /**
         * Initialization constructor.
         * @param  transferToGiftCardId  String value for transferToGiftCardId.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String transferToGiftCardId, Money amountMoney) {
            this.transferToGiftCardId = transferToGiftCardId;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for transferToGiftCardId.
         * @param  transferToGiftCardId  String value for transferToGiftCardId.
         * @return Builder
         */
        public Builder transferToGiftCardId(String transferToGiftCardId) {
            this.transferToGiftCardId = transferToGiftCardId;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Builds a new {@link GiftCardActivityTransferBalanceFrom} object using the set fields.
         * @return {@link GiftCardActivityTransferBalanceFrom}
         */
        public GiftCardActivityTransferBalanceFrom build() {
            return new GiftCardActivityTransferBalanceFrom(transferToGiftCardId, amountMoney);
        }
    }
}
