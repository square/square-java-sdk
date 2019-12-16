package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class AdditionalRecipient {

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

    private final String locationId;
    private final String description;
    private final Money amountMoney;
    private final String receivableId;

    @Override
    public int hashCode() {
        return Objects.hash(locationId, description, amountMoney, receivableId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AdditionalRecipient)) {
            return false;
        }
        AdditionalRecipient additionalRecipient = (AdditionalRecipient) o;
        return Objects.equals(locationId, additionalRecipient.locationId) &&
            Objects.equals(description, additionalRecipient.description) &&
            Objects.equals(amountMoney, additionalRecipient.amountMoney) &&
            Objects.equals(receivableId, additionalRecipient.receivableId);
    }

    /**
     * Getter for LocationId.
     * The location ID for a recipient (other than the merchant) receiving a portion of this tender.
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

    /**
     * Getter for ReceivableId.
     * The unique ID for this [AdditionalRecipientReceivable](#type-additionalrecipientreceivable), assigned by the server.
     */
    @JsonGetter("receivable_id")
    public String getReceivableId() { 
        return this.receivableId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(locationId,
            description,
            amountMoney)
            .receivableId(getReceivableId());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private String description;
        private Money amountMoney;
        private String receivableId;

        public Builder(String locationId,
                String description,
                Money amountMoney) {
            this.locationId = locationId;
            this.description = description;
            this.amountMoney = amountMoney;
        }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder receivableId(String value) {
            receivableId = value;
            return this;
        }

        public AdditionalRecipient build() {
            return new AdditionalRecipient(locationId,
                description,
                amountMoney,
                receivableId);
        }
    }
}
