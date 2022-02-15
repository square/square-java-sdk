
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InvoiceAcceptedPaymentMethods type.
 */
public class InvoiceAcceptedPaymentMethods {
    private final Boolean card;
    private final Boolean squareGiftCard;
    private final Boolean bankAccount;

    /**
     * Initialization constructor.
     * @param  card  Boolean value for card.
     * @param  squareGiftCard  Boolean value for squareGiftCard.
     * @param  bankAccount  Boolean value for bankAccount.
     */
    @JsonCreator
    public InvoiceAcceptedPaymentMethods(
            @JsonProperty("card") Boolean card,
            @JsonProperty("square_gift_card") Boolean squareGiftCard,
            @JsonProperty("bank_account") Boolean bankAccount) {
        this.card = card;
        this.squareGiftCard = squareGiftCard;
        this.bankAccount = bankAccount;
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
     * option is allowed only for invoices that have a single payment request of type `BALANCE`.
     * @return Returns the Boolean
     */
    @JsonGetter("bank_account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getBankAccount() {
        return bankAccount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(card, squareGiftCard, bankAccount);
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
            && Objects.equals(bankAccount, other.bankAccount);
    }

    /**
     * Converts this InvoiceAcceptedPaymentMethods into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceAcceptedPaymentMethods [" + "card=" + card + ", squareGiftCard="
                + squareGiftCard + ", bankAccount=" + bankAccount + "]";
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
                .bankAccount(getBankAccount());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceAcceptedPaymentMethods}.
     */
    public static class Builder {
        private Boolean card;
        private Boolean squareGiftCard;
        private Boolean bankAccount;



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
         * Builds a new {@link InvoiceAcceptedPaymentMethods} object using the set fields.
         * @return {@link InvoiceAcceptedPaymentMethods}
         */
        public InvoiceAcceptedPaymentMethods build() {
            return new InvoiceAcceptedPaymentMethods(card, squareGiftCard, bankAccount);
        }
    }
}
