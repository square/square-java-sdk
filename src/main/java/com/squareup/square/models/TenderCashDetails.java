
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TenderCashDetails type.
 */
public class TenderCashDetails {
    private final Money buyerTenderedMoney;
    private final Money changeBackMoney;

    /**
     * Initialization constructor.
     * @param  buyerTenderedMoney  Money value for buyerTenderedMoney.
     * @param  changeBackMoney  Money value for changeBackMoney.
     */
    @JsonCreator
    public TenderCashDetails(
            @JsonProperty("buyer_tendered_money") Money buyerTenderedMoney,
            @JsonProperty("change_back_money") Money changeBackMoney) {
        this.buyerTenderedMoney = buyerTenderedMoney;
        this.changeBackMoney = changeBackMoney;
    }

    /**
     * Getter for BuyerTenderedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("buyer_tendered_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getBuyerTenderedMoney() {
        return buyerTenderedMoney;
    }

    /**
     * Getter for ChangeBackMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("change_back_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getChangeBackMoney() {
        return changeBackMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerTenderedMoney, changeBackMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TenderCashDetails)) {
            return false;
        }
        TenderCashDetails other = (TenderCashDetails) obj;
        return Objects.equals(buyerTenderedMoney, other.buyerTenderedMoney)
            && Objects.equals(changeBackMoney, other.changeBackMoney);
    }

    /**
     * Converts this TenderCashDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TenderCashDetails [" + "buyerTenderedMoney=" + buyerTenderedMoney
                + ", changeBackMoney=" + changeBackMoney + "]";
    }

    /**
     * Builds a new {@link TenderCashDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TenderCashDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .buyerTenderedMoney(getBuyerTenderedMoney())
                .changeBackMoney(getChangeBackMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link TenderCashDetails}.
     */
    public static class Builder {
        private Money buyerTenderedMoney;
        private Money changeBackMoney;



        /**
         * Setter for buyerTenderedMoney.
         * @param  buyerTenderedMoney  Money value for buyerTenderedMoney.
         * @return Builder
         */
        public Builder buyerTenderedMoney(Money buyerTenderedMoney) {
            this.buyerTenderedMoney = buyerTenderedMoney;
            return this;
        }

        /**
         * Setter for changeBackMoney.
         * @param  changeBackMoney  Money value for changeBackMoney.
         * @return Builder
         */
        public Builder changeBackMoney(Money changeBackMoney) {
            this.changeBackMoney = changeBackMoney;
            return this;
        }

        /**
         * Builds a new {@link TenderCashDetails} object using the set fields.
         * @return {@link TenderCashDetails}
         */
        public TenderCashDetails build() {
            return new TenderCashDetails(buyerTenderedMoney, changeBackMoney);
        }
    }
}
