package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderReturnLineItemModifier type.
 */
public class OrderReturnLineItemModifier {

    /**
     * Initialization constructor.
     * @param uid
     * @param sourceModifierUid
     * @param catalogObjectId
     * @param name
     * @param basePriceMoney
     * @param totalPriceMoney
     */
    @JsonCreator
    public OrderReturnLineItemModifier(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_modifier_uid") String sourceModifierUid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("total_price_money") Money totalPriceMoney) {
        this.uid = uid;
        this.sourceModifierUid = sourceModifierUid;
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
    }

    private final String uid;
    private final String sourceModifierUid;
    private final String catalogObjectId;
    private final String name;
    private final Money basePriceMoney;
    private final Money totalPriceMoney;
    /**
     * Getter for Uid.
     * Unique ID that identifies the return modifier only within this order.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for SourceModifierUid.
     * `uid` of the Modifier from the LineItem from the Order which contains the
     * original sale of this line item modifier.
     */
    @JsonGetter("source_modifier_uid")
    public String getSourceModifierUid() {
        return this.sourceModifierUid;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object id referencing [CatalogModifier](#type-catalogmodifier).
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * The name of the item modifier.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for BasePriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("base_price_money")
    public Money getBasePriceMoney() {
        return this.basePriceMoney;
    }

    /**
     * Getter for TotalPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_price_money")
    public Money getTotalPriceMoney() {
        return this.totalPriceMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceModifierUid, catalogObjectId, name, basePriceMoney,
            totalPriceMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderReturnLineItemModifier)) {
            return false;
        }
        OrderReturnLineItemModifier orderReturnLineItemModifier = (OrderReturnLineItemModifier) obj;
        return Objects.equals(uid, orderReturnLineItemModifier.uid) &&
            Objects.equals(sourceModifierUid, orderReturnLineItemModifier.sourceModifierUid) &&
            Objects.equals(catalogObjectId, orderReturnLineItemModifier.catalogObjectId) &&
            Objects.equals(name, orderReturnLineItemModifier.name) &&
            Objects.equals(basePriceMoney, orderReturnLineItemModifier.basePriceMoney) &&
            Objects.equals(totalPriceMoney, orderReturnLineItemModifier.totalPriceMoney);
    }

    /**
     * Builds a new {@link OrderReturnLineItemModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnLineItemModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .sourceModifierUid(getSourceModifierUid())
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .basePriceMoney(getBasePriceMoney())
            .totalPriceMoney(getTotalPriceMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnLineItemModifier}
     */
    public static class Builder {
        private String uid;
        private String sourceModifierUid;
        private String catalogObjectId;
        private String name;
        private Money basePriceMoney;
        private Money totalPriceMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for uid
         * @param uid
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
        /**
         * Setter for sourceModifierUid
         * @param sourceModifierUid
         * @return Builder
         */
        public Builder sourceModifierUid(String sourceModifierUid) {
            this.sourceModifierUid = sourceModifierUid;
            return this;
        }
        /**
         * Setter for catalogObjectId
         * @param catalogObjectId
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for basePriceMoney
         * @param basePriceMoney
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }
        /**
         * Setter for totalPriceMoney
         * @param totalPriceMoney
         * @return Builder
         */
        public Builder totalPriceMoney(Money totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnLineItemModifier} object using the set fields.
         * @return {@link OrderReturnLineItemModifier}
         */
        public OrderReturnLineItemModifier build() {
            return new OrderReturnLineItemModifier(uid,
                sourceModifierUid,
                catalogObjectId,
                name,
                basePriceMoney,
                totalPriceMoney);
        }
    }
}
