
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for QuickPay type.
 */
public class QuickPay {
    private final String name;
    private final Money priceMoney;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  priceMoney  Money value for priceMoney.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public QuickPay(
            @JsonProperty("name") String name,
            @JsonProperty("price_money") Money priceMoney,
            @JsonProperty("location_id") String locationId) {
        this.name = name;
        this.priceMoney = priceMoney;
        this.locationId = locationId;
    }

    /**
     * Getter for Name.
     * The ad hoc item name. In the resulting `Order`, this name appears as the line item name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
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
    public Money getPriceMoney() {
        return priceMoney;
    }

    /**
     * Getter for LocationId.
     * The ID of the business location the checkout is associated with.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priceMoney, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuickPay)) {
            return false;
        }
        QuickPay other = (QuickPay) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(priceMoney, other.priceMoney)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this QuickPay into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "QuickPay [" + "name=" + name + ", priceMoney=" + priceMoney + ", locationId="
                + locationId + "]";
    }

    /**
     * Builds a new {@link QuickPay.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link QuickPay.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name, priceMoney, locationId);
        return builder;
    }

    /**
     * Class to build instances of {@link QuickPay}.
     */
    public static class Builder {
        private String name;
        private Money priceMoney;
        private String locationId;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         * @param  priceMoney  Money value for priceMoney.
         * @param  locationId  String value for locationId.
         */
        public Builder(String name, Money priceMoney, String locationId) {
            this.name = name;
            this.priceMoney = priceMoney;
            this.locationId = locationId;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link QuickPay} object using the set fields.
         * @return {@link QuickPay}
         */
        public QuickPay build() {
            return new QuickPay(name, priceMoney, locationId);
        }
    }
}
