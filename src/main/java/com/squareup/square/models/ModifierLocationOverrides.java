
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ModifierLocationOverrides type.
 */
public class ModifierLocationOverrides {
    private final OptionalNullable<String> locationId;
    private final Money priceMoney;
    private final Boolean soldOut;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  priceMoney  Money value for priceMoney.
     * @param  soldOut  Boolean value for soldOut.
     */
    @JsonCreator
    public ModifierLocationOverrides(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("price_money") Money priceMoney,
            @JsonProperty("sold_out") Boolean soldOut) {
        this.locationId = OptionalNullable.of(locationId);
        this.priceMoney = priceMoney;
        this.soldOut = soldOut;
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  priceMoney  Money value for priceMoney.
     * @param  soldOut  Boolean value for soldOut.
     */

    protected ModifierLocationOverrides(OptionalNullable<String> locationId, Money priceMoney,
            Boolean soldOut) {
        this.locationId = locationId;
        this.priceMoney = priceMoney;
        this.soldOut = soldOut;
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the `Location` object representing the location. This can include a deactivated
     * location.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the `Location` object representing the location. This can include a deactivated
     * location.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Getter for PriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("price_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getPriceMoney() {
        return priceMoney;
    }

    /**
     * Getter for SoldOut.
     * Indicates whether the modifier is sold out at the specified location or not. As an example,
     * for cheese (modifier) burger (item), when the modifier is sold out, it is the cheese, but not
     * the burger, that is sold out. The seller can manually set this sold out status. Attempts by
     * an application to set this attribute are ignored.
     * @return Returns the Boolean
     */
    @JsonGetter("sold_out")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getSoldOut() {
        return soldOut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, priceMoney, soldOut);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModifierLocationOverrides)) {
            return false;
        }
        ModifierLocationOverrides other = (ModifierLocationOverrides) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(priceMoney, other.priceMoney)
            && Objects.equals(soldOut, other.soldOut);
    }

    /**
     * Converts this ModifierLocationOverrides into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ModifierLocationOverrides [" + "locationId=" + locationId + ", priceMoney="
                + priceMoney + ", soldOut=" + soldOut + "]";
    }

    /**
     * Builds a new {@link ModifierLocationOverrides.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ModifierLocationOverrides.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .priceMoney(getPriceMoney())
                .soldOut(getSoldOut());
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link ModifierLocationOverrides}.
     */
    public static class Builder {
        private OptionalNullable<String> locationId;
        private Money priceMoney;
        private Boolean soldOut;



        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for priceMoney.
         * @param  priceMoney  Money value for priceMoney.
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Setter for soldOut.
         * @param  soldOut  Boolean value for soldOut.
         * @return Builder
         */
        public Builder soldOut(Boolean soldOut) {
            this.soldOut = soldOut;
            return this;
        }

        /**
         * Builds a new {@link ModifierLocationOverrides} object using the set fields.
         * @return {@link ModifierLocationOverrides}
         */
        public ModifierLocationOverrides build() {
            return new ModifierLocationOverrides(locationId, priceMoney, soldOut);
        }
    }
}
