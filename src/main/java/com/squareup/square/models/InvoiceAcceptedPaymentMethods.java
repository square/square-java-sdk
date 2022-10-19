
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for InvoiceAcceptedPaymentMethods type.
 */
public class InvoiceAcceptedPaymentMethods {
    private final Boolean card;
    private final Boolean squareGiftCard;
    private final Boolean bankAccount;
    private final Boolean buyNowPayLater;

    /**
     * Initialization constructor.
     * @param  card  Boolean value for card.
     * @param  squareGiftCard  Boolean value for squareGiftCard.
     * @param  bankAccount  Boolean value for bankAccount.
     * @param  buyNowPayLater  Boolean value for buyNowPayLater.
     */
    @JsonCreator
    public InvoiceAcceptedPaymentMethods(
            @JsonProperty("card") Boolean card,
            @JsonProperty("square_gift_card") Boolean squareGiftCard,
            @JsonProperty("bank_account") Boolean bankAccount,
            @JsonProperty("buy_now_pay_later") Boolean buyNowPayLater) {
        this.card = card;
        this.squareGiftCard = squareGiftCard;
        this.bankAccount = bankAccount;
        this.buyNowPayLater = buyNowPayLater;
    }

    /**
     * Getter for Card.
     * Indicates whether credit card or debit card payments are accepted. The default value is
     * `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("card")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getCard() {
        return card;
    }

    /**
     * Getter for SquareGiftCard.
     * Indicates whether Square gift card payments are accepted. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("square_gift_card")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getSquareGiftCard() {
        return squareGiftCard;
    }

    /**
     * Getter for BankAccount.
     * Indicates whether bank transfer payments are accepted. The default value is `false`. This
     * option is allowed only for invoices that have a single payment request of the `BALANCE` type.
     * @return Returns the Boolean
     */
    @JsonGetter("bank_account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getBankAccount() {
        return bankAccount;
    }

    /**
     * Getter for BuyNowPayLater.
     * Indicates whether Afterpay (also known as Clearpay) payments are accepted. The default value
     * is `false`. This option is allowed only for invoices that have a single payment request of
     * the `BALANCE` type. This payment method is supported if the seller account accepts Afterpay
     * payments and the seller location is in a country where Afterpay invoice payments are
     * supported. As a best practice, consider enabling an additional payment method when allowing
     * `buy_now_pay_later` payments. For more information, including detailed requirements and
     * processing limits, see [Buy Now Pay Later payments with
     * Afterpay](https://developer.squareup.com/docs/invoices-api/overview#buy-now-pay-later).
     * @return Returns the Boolean
     */
    @JsonGetter("buy_now_pay_later")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getBuyNowPayLater() {
        return buyNowPayLater;
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, squareGiftCard, bankAccount, buyNowPayLater);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoiceAcceptedPaymentMethods)) {
            return false;
        }
        InvoiceAcceptedPaymentMethods other = (InvoiceAcceptedPaymentMethods) obj;
        return Objects.equals(card, other.card)
            && Objects.equals(squareGiftCard, other.squareGiftCard)
            && Objects.equals(bankAccount, other.bankAccount)
            && Objects.equals(buyNowPayLater, other.buyNowPayLater);
    }

    /**
     * Converts this InvoiceAcceptedPaymentMethods into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceAcceptedPaymentMethods [" + "card=" + card + ", squareGiftCard="
                + squareGiftCard + ", bankAccount=" + bankAccount + ", buyNowPayLater="
                + buyNowPayLater + "]";
    }

    /**
     * Builds a new {@link InvoiceAcceptedPaymentMethods.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceAcceptedPaymentMethods.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .card(getCard())
                .squareGiftCard(getSquareGiftCard())
                .bankAccount(getBankAccount())
                .buyNowPayLater(getBuyNowPayLater());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceAcceptedPaymentMethods}.
     */
    public static class Builder {
        private Boolean card;
        private Boolean squareGiftCard;
        private Boolean bankAccount;
        private Boolean buyNowPayLater;



        /**
         * Setter for card.
         * @param  card  Boolean value for card.
         * @return Builder
         */
        public Builder card(Boolean card) {
            this.card = card;
            return this;
        }

        /**
         * Setter for squareGiftCard.
         * @param  squareGiftCard  Boolean value for squareGiftCard.
         * @return Builder
         */
        public Builder squareGiftCard(Boolean squareGiftCard) {
            this.squareGiftCard = squareGiftCard;
            return this;
        }

        /**
         * Setter for bankAccount.
         * @param  bankAccount  Boolean value for bankAccount.
         * @return Builder
         */
        public Builder bankAccount(Boolean bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        /**
         * Setter for buyNowPayLater.
         * @param  buyNowPayLater  Boolean value for buyNowPayLater.
         * @return Builder
         */
        public Builder buyNowPayLater(Boolean buyNowPayLater) {
            this.buyNowPayLater = buyNowPayLater;
            return this;
        }

        /**
         * Builds a new {@link InvoiceAcceptedPaymentMethods} object using the set fields.
         * @return {@link InvoiceAcceptedPaymentMethods}
         */
        public InvoiceAcceptedPaymentMethods build() {
            return new InvoiceAcceptedPaymentMethods(card, squareGiftCard, bankAccount,
                    buyNowPayLater);
        }
    }
}
