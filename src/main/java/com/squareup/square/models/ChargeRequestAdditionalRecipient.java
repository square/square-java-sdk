package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ChargeRequestAdditionalRecipient type.
 */
public class ChargeRequestAdditionalRecipient {

    /**
     * Initialization constructor.
     * @param locationId
     * @param description
     * @param amountMoney
     */
    @JsonCreator
    public ChargeRequestAdditionalRecipient(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("description") String description,
            @JsonProperty("amount_money") Money amountMoney) {
        this.locationId = locationId;
        this.description = description;
        this.amountMoney = amountMoney;
    }

    private final String locationId;
    private final String description;
    private final Money amountMoney;
    /**
     * Getter for LocationId.
     * The location ID for a recipient (other than the merchant) receiving a portion of the tender.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Description.
     * The description of the additional recipient.
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return this.amountMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, description, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ChargeRequestAdditionalRecipient)) {
            return false;
        }
        ChargeRequestAdditionalRecipient chargeRequestAdditionalRecipient = (ChargeRequestAdditionalRecipient) obj;
        return Objects.equals(locationId, chargeRequestAdditionalRecipient.locationId) &&
            Objects.equals(description, chargeRequestAdditionalRecipient.description) &&
            Objects.equals(amountMoney, chargeRequestAdditionalRecipient.amountMoney);
    }

    /**
     * Builds a new {@link ChargeRequestAdditionalRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChargeRequestAdditionalRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId,
            description,
            amountMoney);
            return builder;
    }

    /**
     * Class to build instances of {@link ChargeRequestAdditionalRecipient}
     */
    public static class Builder {
        private String locationId;
        private String description;
        private Money amountMoney;

        /**
         * Initialization constructor
         */
        public Builder(String locationId,
                String description,
                Money amountMoney) {
            this.locationId = locationId;
            this.description = description;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for description
         * @param description
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Builds a new {@link ChargeRequestAdditionalRecipient} object using the set fields.
         * @return {@link ChargeRequestAdditionalRecipient}
         */
        public ChargeRequestAdditionalRecipient build() {
            return new ChargeRequestAdditionalRecipient(locationId,
                description,
                amountMoney);
        }
    }
}
