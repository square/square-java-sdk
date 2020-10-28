
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for AdditionalRecipient type.
 */
public class AdditionalRecipient {
    private final String locationId;
    private final String description;
    private final Money amountMoney;
    private final String receivableId;

    /**
     * Initialization constructor.
     * @param locationId String value for locationId.
     * @param description String value for description.
     * @param amountMoney Money value for amountMoney.
     * @param receivableId String value for receivableId.
     */
    @JsonCreator
    public AdditionalRecipient(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("description") String description,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("receivable_id") String receivableId) {
        this.locationId = locationId;
        this.description = description;
        this.amountMoney = amountMoney;
        this.receivableId = receivableId;
    }

    /**
     * Getter for LocationId.
     * The location ID for a recipient (other than the merchant) receiving a portion of this tender.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Description.
     * The description of the additional recipient.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
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
        return this.amountMoney;
    }

    /**
     * Getter for ReceivableId.
     * The unique ID for this [AdditionalRecipientReceivable](#type-additionalrecipientreceivable),
     * assigned by the server.
     * @return Returns the String
     */
    @JsonGetter("receivable_id")
    public String getReceivableId() {
        return this.receivableId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, description, amountMoney, receivableId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdditionalRecipient)) {
            return false;
        }
        AdditionalRecipient other = (AdditionalRecipient) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(description, other.description)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(receivableId, other.receivableId);
    }

    /**
     * Builds a new {@link AdditionalRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdditionalRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId,
            description,
            amountMoney)
            .receivableId(getReceivableId());
        return builder;
    }

    /**
     * Class to build instances of {@link AdditionalRecipient}.
     */
    public static class Builder {
        private String locationId;
        private String description;
        private Money amountMoney;
        private String receivableId;

        /**
         * Initialization constructor.
         * @param locationId String value for locationId.
         * @param description String value for description.
         * @param amountMoney Money value for amountMoney.
         */
        public Builder(String locationId,
                String description,
                Money amountMoney) {
            this.locationId = locationId;
            this.description = description;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for description.
         * @param description String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param amountMoney Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for receivableId.
         * @param receivableId String value for receivableId.
         * @return Builder
         */
        public Builder receivableId(String receivableId) {
            this.receivableId = receivableId;
            return this;
        }

        /**
         * Builds a new {@link AdditionalRecipient} object using the set fields.
         * @return {@link AdditionalRecipient}
         */
        public AdditionalRecipient build() {
            return new AdditionalRecipient(locationId,
                description,
                amountMoney,
                receivableId);
        }
    }
}
