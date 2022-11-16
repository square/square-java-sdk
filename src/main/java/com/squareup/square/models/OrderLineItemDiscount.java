
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemDiscount type.
 */
public class OrderLineItemDiscount {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> name;
    private final String type;
    private final OptionalNullable<String> percentage;
    private final Money amountMoney;
    private final Money appliedMoney;
    private final OptionalNullable<Map<String, String>> metadata;
    private final String scope;
    private final List<String> rewardIds;
    private final String pricingRuleId;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  name  String value for name.
     * @param  type  String value for type.
     * @param  percentage  String value for percentage.
     * @param  amountMoney  Money value for amountMoney.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  metadata  Map of String, value for metadata.
     * @param  scope  String value for scope.
     * @param  rewardIds  List of String value for rewardIds.
     * @param  pricingRuleId  String value for pricingRuleId.
     */
    @JsonCreator
    public OrderLineItemDiscount(
            @JsonProperty("uid") String uid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("scope") String scope,
            @JsonProperty("reward_ids") List<String> rewardIds,
            @JsonProperty("pricing_rule_id") String pricingRuleId) {
        this.uid = OptionalNullable.of(uid);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.name = OptionalNullable.of(name);
        this.type = type;
        this.percentage = OptionalNullable.of(percentage);
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.metadata = OptionalNullable.of(metadata);
        this.scope = scope;
        this.rewardIds = rewardIds;
        this.pricingRuleId = pricingRuleId;
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderLineItemDiscount(OptionalNullable<String> uid,
            OptionalNullable<String> catalogObjectId, OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> name, String type, OptionalNullable<String> percentage,
            Money amountMoney, Money appliedMoney, OptionalNullable<Map<String, String>> metadata,
            String scope, List<String> rewardIds, String pricingRuleId) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.metadata = metadata;
        this.scope = scope;
        this.rewardIds = rewardIds;
        this.pricingRuleId = pricingRuleId;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the discount only within this order.
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
     * A unique ID that identifies the discount only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogDiscount]($m/CatalogDiscount).
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
     * The catalog object ID referencing [CatalogDiscount]($m/CatalogDiscount).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this discount references.
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
     * The version of the catalog object that this discount references.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for Name.
     * The discount's name.
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
     * The discount's name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for Type.
     * Indicates how the discount is applied to the associated line item or order.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for Percentage.
     * The percentage of the discount, as a string representation of a decimal number. A value of
     * `7.25` corresponds to a percentage of 7.25%. `percentage` is not set for amount-based
     * discounts.
     * @return Returns the Internal String
     */
    @JsonGetter("percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPercentage() {
        return this.percentage;
    }

    /**
     * Getter for Percentage.
     * The percentage of the discount, as a string representation of a decimal number. A value of
     * `7.25` corresponds to a percentage of 7.25%. `percentage` is not set for amount-based
     * discounts.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentage() {
        return OptionalNullable.getFrom(percentage);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for AppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("applied_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppliedMoney() {
        return appliedMoney;
    }

    /**
     * Internal Getter for Metadata.
     * Application-defined data attached to this discount. Metadata fields are intended to store
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
     * Application-defined data attached to this discount. Metadata fields are intended to store
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

    /**
     * Getter for Scope.
     * Indicates whether this is a line-item or order-level discount.
     * @return Returns the String
     */
    @JsonGetter("scope")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScope() {
        return scope;
    }

    /**
     * Getter for RewardIds.
     * The reward IDs corresponding to this discount. The application and specification of discounts
     * that have `reward_ids` are completely controlled by the backing criteria corresponding to the
     * reward tiers of the rewards that are added to the order through the Loyalty API. To manually
     * unapply discounts that are the result of added rewards, the rewards must be removed from the
     * order through the Loyalty API.
     * @return Returns the List of String
     */
    @JsonGetter("reward_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getRewardIds() {
        return rewardIds;
    }

    /**
     * Getter for PricingRuleId.
     * The object ID of a [pricing rule]($m/CatalogPricingRule) to be applied automatically to this
     * discount. The specification and application of the discounts, to which a `pricing_rule_id` is
     * assigned, are completely controlled by the corresponding pricing rule.
     * @return Returns the String
     */
    @JsonGetter("pricing_rule_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPricingRuleId() {
        return pricingRuleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, catalogObjectId, catalogVersion, name, type, percentage,
                amountMoney, appliedMoney, metadata, scope, rewardIds, pricingRuleId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemDiscount)) {
            return false;
        }
        OrderLineItemDiscount other = (OrderLineItemDiscount) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogVersion, other.catalogVersion)
            && Objects.equals(name, other.name)
            && Objects.equals(type, other.type)
            && Objects.equals(percentage, other.percentage)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(metadata, other.metadata)
            && Objects.equals(scope, other.scope)
            && Objects.equals(rewardIds, other.rewardIds)
            && Objects.equals(pricingRuleId, other.pricingRuleId);
    }

    /**
     * Converts this OrderLineItemDiscount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemDiscount [" + "uid=" + uid + ", catalogObjectId=" + catalogObjectId
                + ", catalogVersion=" + catalogVersion + ", name=" + name + ", type=" + type
                + ", percentage=" + percentage + ", amountMoney=" + amountMoney + ", appliedMoney="
                + appliedMoney + ", metadata=" + metadata + ", scope=" + scope + ", rewardIds="
                + rewardIds + ", pricingRuleId=" + pricingRuleId + "]";
    }

    /**
     * Builds a new {@link OrderLineItemDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .amountMoney(getAmountMoney())
                .appliedMoney(getAppliedMoney())
                .scope(getScope())
                .rewardIds(getRewardIds())
                .pricingRuleId(getPricingRuleId());
        builder.uid = internalGetUid();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.name = internalGetName();
        builder.percentage = internalGetPercentage();
        builder.metadata = internalGetMetadata();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemDiscount}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> name;
        private String type;
        private OptionalNullable<String> percentage;
        private Money amountMoney;
        private Money appliedMoney;
        private OptionalNullable<Map<String, String>> metadata;
        private String scope;
        private List<String> rewardIds;
        private String pricingRuleId;



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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for percentage.
         * @param  percentage  String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = OptionalNullable.of(percentage);
            return this;
        }

        /**
         * UnSetter for percentage.
         * @return Builder
         */
        public Builder unsetPercentage() {
            percentage = null;
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
         * Setter for appliedMoney.
         * @param  appliedMoney  Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
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
         * Setter for scope.
         * @param  scope  String value for scope.
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Setter for rewardIds.
         * @param  rewardIds  List of String value for rewardIds.
         * @return Builder
         */
        public Builder rewardIds(List<String> rewardIds) {
            this.rewardIds = rewardIds;
            return this;
        }

        /**
         * Setter for pricingRuleId.
         * @param  pricingRuleId  String value for pricingRuleId.
         * @return Builder
         */
        public Builder pricingRuleId(String pricingRuleId) {
            this.pricingRuleId = pricingRuleId;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemDiscount} object using the set fields.
         * @return {@link OrderLineItemDiscount}
         */
        public OrderLineItemDiscount build() {
            return new OrderLineItemDiscount(uid, catalogObjectId, catalogVersion, name, type,
                    percentage, amountMoney, appliedMoney, metadata, scope, rewardIds,
                    pricingRuleId);
        }
    }
}
