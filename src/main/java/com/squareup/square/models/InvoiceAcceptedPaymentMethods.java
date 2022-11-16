
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for InvoiceAcceptedPaymentMethods type.
 */
public class InvoiceAcceptedPaymentMethods {
    private final OptionalNullable<Boolean> card;
    private final OptionalNullable<Boolean> squareGiftCard;
    private final OptionalNullable<Boolean> bankAccount;
    private final OptionalNullable<Boolean> buyNowPayLater;

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
        this.card = OptionalNullable.of(card);
        this.squareGiftCard = OptionalNullable.of(squareGiftCard);
        this.bankAccount = OptionalNullable.of(bankAccount);
        this.buyNowPayLater = OptionalNullable.of(buyNowPayLater);
    }

    /**
     * Internal initialization constructor.
     */
    protected InvoiceAcceptedPaymentMethods(OptionalNullable<Boolean> card,
            OptionalNullable<Boolean> squareGiftCard, OptionalNullable<Boolean> bankAccount,
            OptionalNullable<Boolean> buyNowPayLater) {
        this.card = card;
        this.squareGiftCard = squareGiftCard;
        this.bankAccount = bankAccount;
        this.buyNowPayLater = buyNowPayLater;
    }

    /**
     * Internal Getter for Card.
     * Indicates whether credit card or debit card payments are accepted. The default value is
     * `false`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("card")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCard() {
        return this.card;
    }

    /**
     * Getter for Card.
     * Indicates whether credit card or debit card payments are accepted. The default value is
     * `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCard() {
        return OptionalNullable.getFrom(card);
    }

    /**
     * Internal Getter for SquareGiftCard.
     * Indicates whether Square gift card payments are accepted. The default value is `false`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("square_gift_card")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSquareGiftCard() {
        return this.squareGiftCard;
    }

    /**
     * Getter for SquareGiftCard.
     * Indicates whether Square gift card payments are accepted. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSquareGiftCard() {
        return OptionalNullable.getFrom(squareGiftCard);
    }

    /**
     * Internal Getter for BankAccount.
     * Indicates whether bank transfer payments are accepted. The default value is `false`. This
     * option is allowed only for invoices that have a single payment request of the `BALANCE` type.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("bank_account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetBankAccount() {
        return this.bankAccount;
    }

    /**
     * Getter for BankAccount.
     * Indicates whether bank transfer payments are accepted. The default value is `false`. This
     * option is allowed only for invoices that have a single payment request of the `BALANCE` type.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getBankAccount() {
        return OptionalNullable.getFrom(bankAccount);
    }

    /**
     * Internal Getter for BuyNowPayLater.
     * Indicates whether Afterpay (also known as Clearpay) payments are accepted. The default value
     * is `false`. This option is allowed only for invoices that have a single payment request of
     * the `BALANCE` type. This payment method is supported if the seller account accepts Afterpay
     * payments and the seller location is in a country where Afterpay invoice payments are
     * supported. As a best practice, consider enabling an additional payment method when allowing
     * `buy_now_pay_later` payments. For more information, including detailed requirements and
     * processing limits, see [Buy Now Pay Later payments with
     * Afterpay](https://developer.squareup.com/docs/invoices-api/overview#buy-now-pay-later).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("buy_now_pay_later")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetBuyNowPayLater() {
        return this.buyNowPayLater;
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
    @JsonIgnore
    public Boolean getBuyNowPayLater() {
        return OptionalNullable.getFrom(buyNowPayLater);
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
        Builder builder = new Builder();
        builder.card = internalGetCard();
        builder.squareGiftCard = internalGetSquareGiftCard();
        builder.bankAccount = internalGetBankAccount();
        builder.buyNowPayLater = internalGetBuyNowPayLater();
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceAcceptedPaymentMethods}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> card;
        private OptionalNullable<Boolean> squareGiftCard;
        private OptionalNullable<Boolean> bankAccount;
        private OptionalNullable<Boolean> buyNowPayLater;



        /**
         * Setter for card.
         * @param  card  Boolean value for card.
         * @return Builder
         */
        public Builder card(Boolean card) {
            this.card = OptionalNullable.of(card);
            return this;
        }

        /**
         * UnSetter for card.
         * @return Builder
         */
        public Builder unsetCard() {
            card = null;
            return this;
        }

        /**
         * Setter for squareGiftCard.
         * @param  squareGiftCard  Boolean value for squareGiftCard.
         * @return Builder
         */
        public Builder squareGiftCard(Boolean squareGiftCard) {
            this.squareGiftCard = OptionalNullable.of(squareGiftCard);
            return this;
        }

        /**
         * UnSetter for squareGiftCard.
         * @return Builder
         */
        public Builder unsetSquareGiftCard() {
            squareGiftCard = null;
            return this;
        }

        /**
         * Setter for bankAccount.
         * @param  bankAccount  Boolean value for bankAccount.
         * @return Builder
         */
        public Builder bankAccount(Boolean bankAccount) {
            this.bankAccount = OptionalNullable.of(bankAccount);
            return this;
        }

        /**
         * UnSetter for bankAccount.
         * @return Builder
         */
        public Builder unsetBankAccount() {
            bankAccount = null;
            return this;
        }

        /**
         * Setter for buyNowPayLater.
         * @param  buyNowPayLater  Boolean value for buyNowPayLater.
         * @return Builder
         */
        public Builder buyNowPayLater(Boolean buyNowPayLater) {
            this.buyNowPayLater = OptionalNullable.of(buyNowPayLater);
            return this;
        }

        /**
         * UnSetter for buyNowPayLater.
         * @return Builder
         */
        public Builder unsetBuyNowPayLater() {
            buyNowPayLater = null;
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
