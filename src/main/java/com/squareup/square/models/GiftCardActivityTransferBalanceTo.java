
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityTransferBalanceTo type.
 */
public class GiftCardActivityTransferBalanceTo {
    private final String transferFromGiftCardId;
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  transferFromGiftCardId  String value for transferFromGiftCardId.
     * @param  amountMoney  Money value for amountMoney.
     */
    @JsonCreator
    public GiftCardActivityTransferBalanceTo(
            @JsonProperty("transfer_from_gift_card_id") String transferFromGiftCardId,
            @JsonProperty("amount_money") Money amountMoney) {
        this.transferFromGiftCardId = transferFromGiftCardId;
        this.amountMoney = amountMoney;
    }

    /**
     * Getter for TransferFromGiftCardId.
     * The ID of the gift card from which the specified amount was transferred.
     * @return Returns the String
     */
    @JsonGetter("transfer_from_gift_card_id")
    public String getTransferFromGiftCardId() {
        return transferFromGiftCardId;
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
        return Objects.hash(transferFromGiftCardId, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityTransferBalanceTo)) {
            return false;
        }
        GiftCardActivityTransferBalanceTo other = (GiftCardActivityTransferBalanceTo) obj;
        return Objects.equals(transferFromGiftCardId, other.transferFromGiftCardId)
            && Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this GiftCardActivityTransferBalanceTo into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityTransferBalanceTo [" + "transferFromGiftCardId="
                + transferFromGiftCardId + ", amountMoney=" + amountMoney + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityTransferBalanceTo.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityTransferBalanceTo.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(transferFromGiftCardId, amountMoney);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityTransferBalanceTo}.
     */
    public static class Builder {
        private String transferFromGiftCardId;
        private Money amountMoney;

        /**
         * Initialization constructor.
         * @param  transferFromGiftCardId  String value for transferFromGiftCardId.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String transferFromGiftCardId, Money amountMoney) {
            this.transferFromGiftCardId = transferFromGiftCardId;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for transferFromGiftCardId.
         * @param  transferFromGiftCardId  String value for transferFromGiftCardId.
         * @return Builder
         */
        public Builder transferFromGiftCardId(String transferFromGiftCardId) {
            this.transferFromGiftCardId = transferFromGiftCardId;
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
         * Builds a new {@link GiftCardActivityTransferBalanceTo} object using the set fields.
         * @return {@link GiftCardActivityTransferBalanceTo}
         */
        public GiftCardActivityTransferBalanceTo build() {
            return new GiftCardActivityTransferBalanceTo(transferFromGiftCardId, amountMoney);
        }
    }
}
