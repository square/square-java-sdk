
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SubscriptionPricing type.
 */
public class SubscriptionPricing {
    private final String type;
    private final OptionalNullable<List<String>> discountIds;
    private final Money priceMoney;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  discountIds  List of String value for discountIds.
     * @param  priceMoney  Money value for priceMoney.
     */
    @JsonCreator
    public SubscriptionPricing(
            @JsonProperty("type") String type,
            @JsonProperty("discount_ids") List<String> discountIds,
            @JsonProperty("price_money") Money priceMoney) {
        this.type = type;
        this.discountIds = OptionalNullable.of(discountIds);
        this.priceMoney = priceMoney;
    }

    /**
     * Internal initialization constructor.
     */
    protected SubscriptionPricing(String type, OptionalNullable<List<String>> discountIds,
            Money priceMoney) {
        this.type = type;
        this.discountIds = discountIds;
        this.priceMoney = priceMoney;
    }

    /**
     * Getter for Type.
     * Determines the pricing of a [Subscription]($m/Subscription)
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for DiscountIds.
     * The ids of the discount catalog objects
     * @return Returns the Internal List of String
     */
    @JsonGetter("discount_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetDiscountIds() {
        return this.discountIds;
    }

    /**
     * Getter for DiscountIds.
     * The ids of the discount catalog objects
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getDiscountIds() {
        return OptionalNullable.getFrom(discountIds);
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

    @Override
    public int hashCode() {
        return Objects.hash(type, discountIds, priceMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionPricing)) {
            return false;
        }
        SubscriptionPricing other = (SubscriptionPricing) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(discountIds, other.discountIds)
            && Objects.equals(priceMoney, other.priceMoney);
    }

    /**
     * Converts this SubscriptionPricing into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionPricing [" + "type=" + type + ", discountIds=" + discountIds
                + ", priceMoney=" + priceMoney + "]";
    }

    /**
     * Builds a new {@link SubscriptionPricing.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionPricing.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .priceMoney(getPriceMoney());
        builder.discountIds = internalGetDiscountIds();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionPricing}.
     */
    public static class Builder {
        private String type;
        private OptionalNullable<List<String>> discountIds;
        private Money priceMoney;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for discountIds.
         * @param  discountIds  List of String value for discountIds.
         * @return Builder
         */
        public Builder discountIds(List<String> discountIds) {
            this.discountIds = OptionalNullable.of(discountIds);
            return this;
        }

        /**
         * UnSetter for discountIds.
         * @return Builder
         */
        public Builder unsetDiscountIds() {
            discountIds = null;
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
         * Builds a new {@link SubscriptionPricing} object using the set fields.
         * @return {@link SubscriptionPricing}
         */
        public SubscriptionPricing build() {
            return new SubscriptionPricing(type, discountIds, priceMoney);
        }
    }
}
