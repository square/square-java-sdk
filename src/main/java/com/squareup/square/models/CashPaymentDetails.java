
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CashPaymentDetails type.
 */
public class CashPaymentDetails {
    private final Money buyerSuppliedMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money changeBackMoney;

    /**
     * Initialization constructor.
     * @param  buyerSuppliedMoney  Money value for buyerSuppliedMoney.
     * @param  changeBackMoney  Money value for changeBackMoney.
     */
    @JsonCreator
    public CashPaymentDetails(
            @JsonProperty("buyer_supplied_money") Money buyerSuppliedMoney,
            @JsonProperty("change_back_money") Money changeBackMoney) {
        this.buyerSuppliedMoney = buyerSuppliedMoney;
        this.changeBackMoney = changeBackMoney;
    }

    /**
     * Getter for BuyerSuppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("buyer_supplied_money")
    public Money getBuyerSuppliedMoney() {
        return buyerSuppliedMoney;
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
    public Money getChangeBackMoney() {
        return changeBackMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerSuppliedMoney, changeBackMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashPaymentDetails)) {
            return false;
        }
        CashPaymentDetails other = (CashPaymentDetails) obj;
        return Objects.equals(buyerSuppliedMoney, other.buyerSuppliedMoney)
            && Objects.equals(changeBackMoney, other.changeBackMoney);
    }

    /**
     * Converts this CashPaymentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashPaymentDetails [" + "buyerSuppliedMoney=" + buyerSuppliedMoney
                + ", changeBackMoney=" + changeBackMoney + "]";
    }

    /**
     * Builds a new {@link CashPaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashPaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(buyerSuppliedMoney)
                .changeBackMoney(getChangeBackMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link CashPaymentDetails}.
     */
    public static class Builder {
        private Money buyerSuppliedMoney;
        private Money changeBackMoney;

        /**
         * Initialization constructor.
         * @param  buyerSuppliedMoney  Money value for buyerSuppliedMoney.
         */
        public Builder(Money buyerSuppliedMoney) {
            this.buyerSuppliedMoney = buyerSuppliedMoney;
        }

        /**
         * Setter for buyerSuppliedMoney.
         * @param  buyerSuppliedMoney  Money value for buyerSuppliedMoney.
         * @return Builder
         */
        public Builder buyerSuppliedMoney(Money buyerSuppliedMoney) {
            this.buyerSuppliedMoney = buyerSuppliedMoney;
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
         * Builds a new {@link CashPaymentDetails} object using the set fields.
         * @return {@link CashPaymentDetails}
         */
        public CashPaymentDetails build() {
            return new CashPaymentDetails(buyerSuppliedMoney, changeBackMoney);
        }
    }
}
