package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for AdditionalRecipient type.
 */
public class AdditionalRecipient {
    private final String locationId;
    private final OptionalNullable<String> description;
    private final Money amountMoney;
    private final OptionalNullable<String> receivableId;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  amountMoney  Money value for amountMoney.
     * @param  description  String value for description.
     * @param  receivableId  String value for receivableId.
     */
    @JsonCreator
    public AdditionalRecipient(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("description") String description,
            @JsonProperty("receivable_id") String receivableId) {
        this.locationId = locationId;
        this.description = OptionalNullable.of(description);
        this.amountMoney = amountMoney;
        this.receivableId = OptionalNullable.of(receivableId);
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  amountMoney  Money value for amountMoney.
     * @param  description  String value for description.
     * @param  receivableId  String value for receivableId.
     */
    protected AdditionalRecipient(
            String locationId,
            Money amountMoney,
            OptionalNullable<String> description,
            OptionalNullable<String> receivableId) {
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
        return locationId;
    }

    /**
     * Internal Getter for Description.
     * The description of the additional recipient.
     * @return Returns the Internal String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDescription() {
        return this.description;
    }

    /**
     * Getter for Description.
     * The description of the additional recipient.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
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

    /**
     * Internal Getter for ReceivableId.
     * The unique ID for the RETIRED `AdditionalRecipientReceivable` object. This field should be
     * empty for any `AdditionalRecipient` objects created after the retirement.
     * @return Returns the Internal String
     */
    @JsonGetter("receivable_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReceivableId() {
        return this.receivableId;
    }

    /**
     * Getter for ReceivableId.
     * The unique ID for the RETIRED `AdditionalRecipientReceivable` object. This field should be
     * empty for any `AdditionalRecipient` objects created after the retirement.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReceivableId() {
        return OptionalNullable.getFrom(receivableId);
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
     * Converts this AdditionalRecipient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AdditionalRecipient [" + "locationId=" + locationId + ", amountMoney=" + amountMoney + ", description="
                + description + ", receivableId=" + receivableId + "]";
    }

    /**
     * Builds a new {@link AdditionalRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdditionalRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId, amountMoney);
        builder.description = internalGetDescription();
        builder.receivableId = internalGetReceivableId();
        return builder;
    }

    /**
     * Class to build instances of {@link AdditionalRecipient}.
     */
    public static class Builder {
        private String locationId;
        private Money amountMoney;
        private OptionalNullable<String> description;
        private OptionalNullable<String> receivableId;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String locationId, Money amountMoney) {
            this.locationId = locationId;
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
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = OptionalNullable.of(description);
            return this;
        }

        /**
         * UnSetter for description.
         * @return Builder
         */
        public Builder unsetDescription() {
            description = null;
            return this;
        }

        /**
         * Setter for receivableId.
         * @param  receivableId  String value for receivableId.
         * @return Builder
         */
        public Builder receivableId(String receivableId) {
            this.receivableId = OptionalNullable.of(receivableId);
            return this;
        }

        /**
         * UnSetter for receivableId.
         * @return Builder
         */
        public Builder unsetReceivableId() {
            receivableId = null;
            return this;
        }

        /**
         * Builds a new {@link AdditionalRecipient} object using the set fields.
         * @return {@link AdditionalRecipient}
         */
        public AdditionalRecipient build() {
            return new AdditionalRecipient(locationId, amountMoney, description, receivableId);
        }
    }
}
