package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemModifier type.
 */
public class OrderLineItemModifier {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> quantity;
    private final Money basePriceMoney;
    private final Money totalPriceMoney;
    private final OptionalNullable<Map<String, String>> metadata;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  name  String value for name.
     * @param  quantity  String value for quantity.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  totalPriceMoney  Money value for totalPriceMoney.
     * @param  metadata  Map of String, value for metadata.
     */
    @JsonCreator
    public OrderLineItemModifier(
            @JsonProperty("uid") String uid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("name") String name,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("total_price_money") Money totalPriceMoney,
            @JsonProperty("metadata") Map<String, String> metadata) {
        this.uid = OptionalNullable.of(uid);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.name = OptionalNullable.of(name);
        this.quantity = OptionalNullable.of(quantity);
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
        this.metadata = OptionalNullable.of(metadata);
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  name  String value for name.
     * @param  quantity  String value for quantity.
     * @param  basePriceMoney  Money value for basePriceMoney.
     * @param  totalPriceMoney  Money value for totalPriceMoney.
     * @param  metadata  Map of String, value for metadata.
     */
    protected OrderLineItemModifier(
            OptionalNullable<String> uid,
            OptionalNullable<String> catalogObjectId,
            OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> name,
            OptionalNullable<String> quantity,
            Money basePriceMoney,
            Money totalPriceMoney,
            OptionalNullable<Map<String, String>> metadata) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.quantity = quantity;
        this.basePriceMoney = basePriceMoney;
        this.totalPriceMoney = totalPriceMoney;
        this.metadata = metadata;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the modifier only within this order.
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
     * A unique ID that identifies the modifier only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
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
     * The version of the catalog object that this modifier references.
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
     * The version of the catalog object that this modifier references.
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
     * Internal Getter for Metadata.
     * Application-defined data attached to this order. Metadata fields are intended to store
     * descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns
     * it in relevant API calls. Do not use metadata to store any sensitive information (such as
     * personally identifiable information or card details). Keys written by applications must be 60
     * characters or less and must be in the character set `[a-zA-Z0-9_-]`. Entries can also include
     * metadata generated by Square. These keys are prefixed with a namespace, separated from the
     * key with a ':' character. Values have a maximum length of 255 characters. An application can
     * have up to 10 entries per metadata field. Entries written by applications are private and can
     * only be read or modified by the same application. For more information, see
     * [Metadata](https://developer.squareup.com/docs/build-basics/metadata).
     * @return Returns the Internal Map of String, String
     */
    @JsonGetter("metadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Map<String, String>> internalGetMetadata() {
        return this.metadata;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this order. Metadata fields are intended to store
     * descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns
     * it in relevant API calls. Do not use metadata to store any sensitive information (such as
     * personally identifiable information or card details). Keys written by applications must be 60
     * characters or less and must be in the character set `[a-zA-Z0-9_-]`. Entries can also include
     * metadata generated by Square. These keys are prefixed with a namespace, separated from the
     * key with a ':' character. Values have a maximum length of 255 characters. An application can
     * have up to 10 entries per metadata field. Entries written by applications are private and can
     * only be read or modified by the same application. For more information, see
     * [Metadata](https://developer.squareup.com/docs/build-basics/metadata).
     * @return Returns the Map of String, String
     */
    @JsonIgnore
    public Map<String, String> getMetadata() {
        return OptionalNullable.getFrom(metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                uid, catalogObjectId, catalogVersion, name, quantity, basePriceMoney, totalPriceMoney, metadata);
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
                && Objects.equals(catalogVersion, other.catalogVersion)
                && Objects.equals(name, other.name)
                && Objects.equals(quantity, other.quantity)
                && Objects.equals(basePriceMoney, other.basePriceMoney)
                && Objects.equals(totalPriceMoney, other.totalPriceMoney)
                && Objects.equals(metadata, other.metadata);
    }

    /**
     * Converts this OrderLineItemModifier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemModifier [" + "uid=" + uid + ", catalogObjectId=" + catalogObjectId
                + ", catalogVersion=" + catalogVersion + ", name=" + name + ", quantity=" + quantity
                + ", basePriceMoney=" + basePriceMoney + ", totalPriceMoney=" + totalPriceMoney
                + ", metadata=" + metadata + "]";
    }

    /**
     * Builds a new {@link OrderLineItemModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().basePriceMoney(getBasePriceMoney()).totalPriceMoney(getTotalPriceMoney());
        builder.uid = internalGetUid();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.name = internalGetName();
        builder.quantity = internalGetQuantity();
        builder.metadata = internalGetMetadata();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemModifier}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> name;
        private OptionalNullable<String> quantity;
        private Money basePriceMoney;
        private Money totalPriceMoney;
        private OptionalNullable<Map<String, String>> metadata;

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
         * Setter for metadata.
         * @param  metadata  Map of String, value for metadata.
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = OptionalNullable.of(metadata);
            return this;
        }

        /**
         * UnSetter for metadata.
         * @return Builder
         */
        public Builder unsetMetadata() {
            metadata = null;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemModifier} object using the set fields.
         * @return {@link OrderLineItemModifier}
         */
        public OrderLineItemModifier build() {
            return new OrderLineItemModifier(
                    uid, catalogObjectId, catalogVersion, name, quantity, basePriceMoney, totalPriceMoney, metadata);
        }
    }
}
