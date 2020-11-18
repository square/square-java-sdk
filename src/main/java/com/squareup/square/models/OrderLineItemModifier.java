
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemModifier type.
 */
public class OrderLineItemModifier {
    private final String uid;
    private final String catalogObjectId;
    private final String name;
    private final Money basePriceMoney;
    private final Money totalPriceMoney;

    /**
     * Initialization constructor.
     * @param uid String value for uid.
     * @param catalogObjectId String value for catalogObjectId.
     * @param name String value for name.
     * @param basePriceMoney Money value for basePriceMoney.
     * @param totalPriceMoney Money value for totalPriceMoney.
     */
    @JsonCreator
    public OrderLineItemModifier(
            @JsonProperty("uid") String uid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("total_price_money") Money totalPriceMoney) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the modifier only within this order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object id referencing [CatalogModifier](#type-catalogmodifier).
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * The name of the item modifier.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for BasePriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("base_price_money")
    public Money getBasePriceMoney() {
        return this.basePriceMoney;
    }

    /**
     * Getter for TotalPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_price_money")
    public Money getTotalPriceMoney() {
        return this.totalPriceMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, catalogObjectId, name, basePriceMoney, totalPriceMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemModifier)) {
            return false;
        }
        OrderLineItemModifier other = (OrderLineItemModifier) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(name, other.name)
            && Objects.equals(basePriceMoney, other.basePriceMoney)
            && Objects.equals(totalPriceMoney, other.totalPriceMoney);
    }

    /**
     * Converts this OrderLineItemModifier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemModifier [" + "uid=" + uid + ", catalogObjectId=" + catalogObjectId
                + ", name=" + name + ", basePriceMoney=" + basePriceMoney + ", totalPriceMoney="
                + totalPriceMoney + "]";
    }

    /**
     * Builds a new {@link OrderLineItemModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .uid(getUid())
                .catalogObjectId(getCatalogObjectId())
                .name(getName())
                .basePriceMoney(getBasePriceMoney())
                .totalPriceMoney(getTotalPriceMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemModifier}.
     */
    public static class Builder {
        private String uid;
        private String catalogObjectId;
        private String name;
        private Money basePriceMoney;
        private Money totalPriceMoney;



        /**
         * Setter for uid.
         * @param uid String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param catalogObjectId String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for basePriceMoney.
         * @param basePriceMoney Money value for basePriceMoney.
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }

        /**
         * Setter for totalPriceMoney.
         * @param totalPriceMoney Money value for totalPriceMoney.
         * @return Builder
         */
        public Builder totalPriceMoney(Money totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemModifier} object using the set fields.
         * @return {@link OrderLineItemModifier}
         */
        public OrderLineItemModifier build() {
            return new OrderLineItemModifier(uid, catalogObjectId, name, basePriceMoney,
                    totalPriceMoney);
        }
    }
}
