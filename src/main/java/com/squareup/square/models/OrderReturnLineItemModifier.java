
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderReturnLineItemModifier type.
 */
public class OrderReturnLineItemModifier {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String uid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String sourceModifierUid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String catalogObjectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long catalogVersion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money basePriceMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money totalPriceMoney;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  sourceModifierUid  String value for sourceModifierUid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  name  String value for name.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  totalPriceMoney  Money value for totalPriceMoney.
     */
    @JsonCreator
    public OrderReturnLineItemModifier(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_modifier_uid") String sourceModifierUid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("name") String name,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("total_price_money") Money totalPriceMoney) {
        this.uid = uid;
        this.sourceModifierUid = sourceModifierUid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
    }

    /**
     * Getter for Uid.
     * A unique ID that identifies the return modifier only within this order.
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return uid;
    }

    /**
     * Getter for SourceModifierUid.
     * The modifier `uid` from the order's line item that contains the original sale of this line
     * item modifier.
     * @return Returns the String
     */
    @JsonGetter("source_modifier_uid")
    public String getSourceModifierUid() {
        return sourceModifierUid;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogModifier]($m/CatalogModifier).
     * @return Returns the String
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return catalogObjectId;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the catalog object that this line item modifier references.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    public Long getCatalogVersion() {
        return catalogVersion;
    }

    /**
     * Getter for Name.
     * The name of the item modifier.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
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
    public Money getTotalPriceMoney() {
        return totalPriceMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceModifierUid, catalogObjectId, catalogVersion, name,
                basePriceMoney, totalPriceMoney);
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
            && Objects.equals(totalPriceMoney, other.totalPriceMoney);
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
                + ", totalPriceMoney=" + totalPriceMoney + "]";
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
                .catalogVersion(getCatalogVersion())
                .name(getName())
                .basePriceMoney(getBasePriceMoney())
                .totalPriceMoney(getTotalPriceMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnLineItemModifier}.
     */
    public static class Builder {
        private String uid;
        private String sourceModifierUid;
        private String catalogObjectId;
        private Long catalogVersion;
        private String name;
        private Money basePriceMoney;
        private Money totalPriceMoney;



        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for sourceModifierUid.
         * @param  sourceModifierUid  String value for sourceModifierUid.
         * @return Builder
         */
        public Builder sourceModifierUid(String sourceModifierUid) {
            this.sourceModifierUid = sourceModifierUid;
            return this;
        }

        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = catalogObjectId;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
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
         * Builds a new {@link OrderReturnLineItemModifier} object using the set fields.
         * @return {@link OrderReturnLineItemModifier}
         */
        public OrderReturnLineItemModifier build() {
            return new OrderReturnLineItemModifier(uid, sourceModifierUid, catalogObjectId,
                    catalogVersion, name, basePriceMoney, totalPriceMoney);
        }
    }
}
