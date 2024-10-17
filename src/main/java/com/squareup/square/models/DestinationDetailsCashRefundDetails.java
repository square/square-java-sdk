
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DestinationDetailsCashRefundDetails type.
 */
public class DestinationDetailsCashRefundDetails {
    private final Money sellerSuppliedMoney;
    private final Money changeBackMoney;

    /**
     * Initialization constructor.
     * @param  sellerSuppliedMoney  Money value for sellerSuppliedMoney.
     * @param  changeBackMoney  Money value for changeBackMoney.
     */
    @JsonCreator
    public DestinationDetailsCashRefundDetails(
            @JsonProperty("seller_supplied_money") Money sellerSuppliedMoney,
            @JsonProperty("change_back_money") Money changeBackMoney) {
        this.sellerSuppliedMoney = sellerSuppliedMoney;
        this.changeBackMoney = changeBackMoney;
    }

    /**
     * Getter for SellerSuppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("seller_supplied_money")
    public Money getSellerSuppliedMoney() {
        return sellerSuppliedMoney;
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
        return Objects.hash(sellerSuppliedMoney, changeBackMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DestinationDetailsCashRefundDetails)) {
            return false;
        }
        DestinationDetailsCashRefundDetails other = (DestinationDetailsCashRefundDetails) obj;
        return Objects.equals(sellerSuppliedMoney, other.sellerSuppliedMoney)
            && Objects.equals(changeBackMoney, other.changeBackMoney);
    }

    /**
     * Converts this DestinationDetailsCashRefundDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DestinationDetailsCashRefundDetails [" + "sellerSuppliedMoney="
                + sellerSuppliedMoney + ", changeBackMoney=" + changeBackMoney + "]";
    }

    /**
     * Builds a new {@link DestinationDetailsCashRefundDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DestinationDetailsCashRefundDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(sellerSuppliedMoney)
                .changeBackMoney(getChangeBackMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link DestinationDetailsCashRefundDetails}.
     */
    public static class Builder {
        private Money sellerSuppliedMoney;
        private Money changeBackMoney;

        /**
         * Initialization constructor.
         * @param  sellerSuppliedMoney  Money value for sellerSuppliedMoney.
         */
        public Builder(Money sellerSuppliedMoney) {
            this.sellerSuppliedMoney = sellerSuppliedMoney;
        }

        /**
         * Setter for sellerSuppliedMoney.
         * @param  sellerSuppliedMoney  Money value for sellerSuppliedMoney.
         * @return Builder
         */
        public Builder sellerSuppliedMoney(Money sellerSuppliedMoney) {
            this.sellerSuppliedMoney = sellerSuppliedMoney;
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
         * Builds a new {@link DestinationDetailsCashRefundDetails} object using the set fields.
         * @return {@link DestinationDetailsCashRefundDetails}
         */
        public DestinationDetailsCashRefundDetails build() {
            return new DestinationDetailsCashRefundDetails(sellerSuppliedMoney, changeBackMoney);
        }
    }
}
