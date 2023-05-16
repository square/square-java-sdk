
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
 * This is a model class for OrderReturnLineItemModifier type.
 */
public class OrderReturnLineItemModifier {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> sourceModifierUid;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> name;
    private final Money basePriceMoney;
    private final Money totalPriceMoney;
    private final OptionalNullable<String> quantity;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  sourceModifierUid  String value for sourceModifierUid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  name  String value for name.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  totalPriceMoney  Money value for totalPriceMoney.
     * @param  quantity  String value for quantity.
     */
    @JsonCreator
    public OrderReturnLineItemModifier(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_modifier_uid") String sourceModifierUid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("name") String name,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("total_price_money") Money totalPriceMoney,
            @JsonProperty("quantity") String quantity) {
        this.uid = OptionalNullable.of(uid);
        this.sourceModifierUid = OptionalNullable.of(sourceModifierUid);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.name = OptionalNullable.of(name);
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
        this.quantity = OptionalNullable.of(quantity);
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderReturnLineItemModifier(OptionalNullable<String> uid,
            OptionalNullable<String> sourceModifierUid, OptionalNullable<String> catalogObjectId,
            OptionalNullable<Long> catalogVersion, OptionalNullable<String> name,
            Money basePriceMoney, Money totalPriceMoney, OptionalNullable<String> quantity) {
        this.uid = uid;
        this.sourceModifierUid = sourceModifierUid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
        this.quantity = quantity;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the return modifier only within this order.
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * A unique ID that identifies the return modifier only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for SourceModifierUid.
     * The modifier `uid` from the order's line item that contains the original sale of this line
     * item modifier.
     * @return Returns the Internal String
     */
    @JsonGetter("source_modifier_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceModifierUid() {
        return this.sourceModifierUid;
    }

    /**
     * Getter for SourceModifierUid.
     * The modifier `uid` from the order's line item that contains the original sale of this line
     * item modifier.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceModifierUid() {
        return OptionalNullable.getFrom(sourceModifierUid);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogModifier](entity:CatalogModifier).
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogModifier](entity:CatalogModifier).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this line item modifier references.
     * @return Returns the Internal Long
     */
    @JsonGetter("catalog_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetCatalogVersion() {
        return this.catalogVersion;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the catalog object that this line item modifier references.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for Name.
     * The name of the item modifier.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name of the item modifier.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getBasePriceMoney() {
        return basePriceMoney;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalPriceMoney() {
        return totalPriceMoney;
    }

    /**
     * Internal Getter for Quantity.
     * The quantity of the line item modifier. The modifier quantity can be 0 or more. For example,
     * suppose a restaurant offers a cheeseburger on the menu. When a buyer orders this item, the
     * restaurant records the purchase by creating an `Order` object with a line item for a burger.
     * The line item includes a line item modifier: the name is cheese and the quantity is 1. The
     * buyer has the option to order extra cheese (or no cheese). If the buyer chooses the extra
     * cheese option, the modifier quantity increases to 2. If the buyer does not want any cheese,
     * the modifier quantity is set to 0.
     * @return Returns the Internal String
     */
    @JsonGetter("quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetQuantity() {
        return this.quantity;
    }

    /**
     * Getter for Quantity.
     * The quantity of the line item modifier. The modifier quantity can be 0 or more. For example,
     * suppose a restaurant offers a cheeseburger on the menu. When a buyer orders this item, the
     * restaurant records the purchase by creating an `Order` object with a line item for a burger.
     * The line item includes a line item modifier: the name is cheese and the quantity is 1. The
     * buyer has the option to order extra cheese (or no cheese). If the buyer chooses the extra
     * cheese option, the modifier quantity increases to 2. If the buyer does not want any cheese,
     * the modifier quantity is set to 0.
     * @return Returns the String
     */
    @JsonIgnore
    public String getQuantity() {
        return OptionalNullable.getFrom(quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceModifierUid, catalogObjectId, catalogVersion, name,
                basePriceMoney, totalPriceMoney, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderReturnLineItemModifier)) {
            return false;
        }
        OrderReturnLineItemModifier other = (OrderReturnLineItemModifier) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(sourceModifierUid, other.sourceModifierUid)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogVersion, other.catalogVersion)
            && Objects.equals(name, other.name)
            && Objects.equals(basePriceMoney, other.basePriceMoney)
            && Objects.equals(totalPriceMoney, other.totalPriceMoney)
            && Objects.equals(quantity, other.quantity);
    }

    /**
     * Converts this OrderReturnLineItemModifier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderReturnLineItemModifier [" + "uid=" + uid + ", sourceModifierUid="
                + sourceModifierUid + ", catalogObjectId=" + catalogObjectId + ", catalogVersion="
                + catalogVersion + ", name=" + name + ", basePriceMoney=" + basePriceMoney
                + ", totalPriceMoney=" + totalPriceMoney + ", quantity=" + quantity + "]";
    }

    /**
     * Builds a new {@link OrderReturnLineItemModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnLineItemModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .basePriceMoney(getBasePriceMoney())
                .totalPriceMoney(getTotalPriceMoney());
        builder.uid = internalGetUid();
        builder.sourceModifierUid = internalGetSourceModifierUid();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.name = internalGetName();
        builder.quantity = internalGetQuantity();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnLineItemModifier}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> sourceModifierUid;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> name;
        private Money basePriceMoney;
        private Money totalPriceMoney;
        private OptionalNullable<String> quantity;



        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Setter for sourceModifierUid.
         * @param  sourceModifierUid  String value for sourceModifierUid.
         * @return Builder
         */
        public Builder sourceModifierUid(String sourceModifierUid) {
            this.sourceModifierUid = OptionalNullable.of(sourceModifierUid);
            return this;
        }

        /**
         * UnSetter for sourceModifierUid.
         * @return Builder
         */
        public Builder unsetSourceModifierUid() {
            sourceModifierUid = null;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = OptionalNullable.of(catalogObjectId);
            return this;
        }

        /**
         * UnSetter for catalogObjectId.
         * @return Builder
         */
        public Builder unsetCatalogObjectId() {
            catalogObjectId = null;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = OptionalNullable.of(catalogVersion);
            return this;
        }

        /**
         * UnSetter for catalogVersion.
         * @return Builder
         */
        public Builder unsetCatalogVersion() {
            catalogVersion = null;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for basePriceMoney.
         * @param  basePriceMoney  Money value for basePriceMoney.
         * @return Builder
         */
        public Builder basePriceMoney(Money basePriceMoney) {
            this.basePriceMoney = basePriceMoney;
            return this;
        }

        /**
         * Setter for totalPriceMoney.
         * @param  totalPriceMoney  Money value for totalPriceMoney.
         * @return Builder
         */
        public Builder totalPriceMoney(Money totalPriceMoney) {
            this.totalPriceMoney = totalPriceMoney;
            return this;
        }

        /**
         * Setter for quantity.
         * @param  quantity  String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = OptionalNullable.of(quantity);
            return this;
        }

        /**
         * UnSetter for quantity.
         * @return Builder
         */
        public Builder unsetQuantity() {
            quantity = null;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnLineItemModifier} object using the set fields.
         * @return {@link OrderReturnLineItemModifier}
         */
        public OrderReturnLineItemModifier build() {
            return new OrderReturnLineItemModifier(uid, sourceModifierUid, catalogObjectId,
                    catalogVersion, name, basePriceMoney, totalPriceMoney, quantity);
        }
    }
}
