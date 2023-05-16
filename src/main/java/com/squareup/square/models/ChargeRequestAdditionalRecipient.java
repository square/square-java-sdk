
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ChargeRequestAdditionalRecipient type.
 */
public class ChargeRequestAdditionalRecipient {
    private final String locationId;
    private final String description;
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  description  String value for description.
     * @param  amountMoney  Money value for amountMoney.
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

    /**
     * Getter for LocationId.
     * The location ID for a recipient (other than the merchant) receiving a portion of the tender.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Description.
     * The description of the additional recipient.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return description;
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
        return Objects.hash(locationId, description, amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChargeRequestAdditionalRecipient)) {
            return false;
        }
        ChargeRequestAdditionalRecipient other = (ChargeRequestAdditionalRecipient) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(description, other.description)
            && Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this ChargeRequestAdditionalRecipient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ChargeRequestAdditionalRecipient [" + "locationId=" + locationId + ", description="
                + description + ", amountMoney=" + amountMoney + "]";
    }

    /**
     * Builds a new {@link ChargeRequestAdditionalRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChargeRequestAdditionalRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId, description, amountMoney);
        return builder;
    }

    /**
     * Class to build instances of {@link ChargeRequestAdditionalRecipient}.
     */
    public static class Builder {
        private String locationId;
        private String description;
        private Money amountMoney;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         * @param  description  String value for description.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String locationId, String description, Money amountMoney) {
            this.locationId = locationId;
            this.description = description;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
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
         * Builds a new {@link ChargeRequestAdditionalRecipient} object using the set fields.
         * @return {@link ChargeRequestAdditionalRecipient}
         */
        public ChargeRequestAdditionalRecipient build() {
            return new ChargeRequestAdditionalRecipient(locationId, description, amountMoney);
        }
    }
}
