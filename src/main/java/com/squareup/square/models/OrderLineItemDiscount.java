package com.squareup.square.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderLineItemDiscount type.
 */
public class OrderLineItemDiscount {

    /**
     * Initialization constructor.
     * @param uid
     * @param catalogObjectId
     * @param name
     * @param type
     * @param percentage
     * @param amountMoney
     * @param appliedMoney
     * @param metadata
     * @param scope
     * @param rewardIds
     * @param pricingRuleId
     */
    @JsonCreator
    public OrderLineItemDiscount(
            @JsonProperty("uid") String uid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("scope") String scope,
            @JsonProperty("reward_ids") List<String> rewardIds,
            @JsonProperty("pricing_rule_id") String pricingRuleId) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
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

    private final String uid;
    private final String catalogObjectId;
    private final String name;
    private final String type;
    private final String percentage;
    private final Money amountMoney;
    private final Money appliedMoney;
    private final Map<String, String> metadata;
    private final String scope;
    private final List<String> rewardIds;
    private final String pricingRuleId;
    /**
     * Getter for Uid.
     * Unique ID that identifies the discount only within this order.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for CatalogObjectId.
     * The catalog object id referencing [CatalogDiscount](#type-catalogdiscount).
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Name.
     * The discount's name.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Type.
     * Indicates how the discount is applied to the associated line item or order.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Percentage.
     * The percentage of the discount, as a string representation of a decimal number.
     * A value of `7.25` corresponds to a percentage of 7.25%.
     * `percentage` is not set for amount-based discounts.
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return this.percentage;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return this.amountMoney;
    }

    /**
     * Getter for AppliedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("applied_money")
    public Money getAppliedMoney() {
        return this.appliedMoney;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this discount. Metadata fields are intended
     * to store descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns it
     * in relevant API calls. Do not use metadata to store any sensitive information (personally
     * identifiable information, card details, etc.).
     * Keys written by applications must be 60 characters or less and must be in the character set
     * `[a-zA-Z0-9_-]`. Entries may also include metadata generated by Square. These keys are prefixed
     * with a namespace, separated from the key with a ':' character.
     * Values have a max length of 255 characters.
     * An application may have up to 10 entries per metadata field.
     * Entries written by applications are private and can only be read or modified by the same
     * application.
     * See [Metadata](https://developer.squareup.com/docs/build-basics/metadata) for more information.
     */
    @JsonGetter("metadata")
    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    /**
     * Getter for Scope.
     * Indicates whether this is a line item or order level discount.
     */
    @JsonGetter("scope")
    public String getScope() {
        return this.scope;
    }

    /**
     * Getter for RewardIds.
     * The reward identifiers corresponding to this discount. The application and
     * specification of discounts that have `reward_ids` are completely controlled by the backing
     * criteria corresponding to the reward tiers of the rewards that are added to the order
     * through the Loyalty API. To manually unapply discounts that are the result of added rewards,
     * the rewards must be removed from the order through the Loyalty API.
     */
    @JsonGetter("reward_ids")
    public List<String> getRewardIds() {
        return this.rewardIds;
    }

    /**
     * Getter for PricingRuleId.
     * The object identifier of a [pricing rule](#type-CatalogPricingRule) to be applied automatically
     * to this discount. The specification and application of the discounts, to which a `pricing_rule_id` is
     * assigned, are completely controlled by the corresponding pricing rule.
     */
    @JsonGetter("pricing_rule_id")
    public String getPricingRuleId() {
        return this.pricingRuleId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, catalogObjectId, name, type, percentage, amountMoney, appliedMoney,
            metadata, scope, rewardIds, pricingRuleId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderLineItemDiscount)) {
            return false;
        }
        OrderLineItemDiscount orderLineItemDiscount = (OrderLineItemDiscount) obj;
        return Objects.equals(uid, orderLineItemDiscount.uid) &&
            Objects.equals(catalogObjectId, orderLineItemDiscount.catalogObjectId) &&
            Objects.equals(name, orderLineItemDiscount.name) &&
            Objects.equals(type, orderLineItemDiscount.type) &&
            Objects.equals(percentage, orderLineItemDiscount.percentage) &&
            Objects.equals(amountMoney, orderLineItemDiscount.amountMoney) &&
            Objects.equals(appliedMoney, orderLineItemDiscount.appliedMoney) &&
            Objects.equals(metadata, orderLineItemDiscount.metadata) &&
            Objects.equals(scope, orderLineItemDiscount.scope) &&
            Objects.equals(rewardIds, orderLineItemDiscount.rewardIds) &&
            Objects.equals(pricingRuleId, orderLineItemDiscount.pricingRuleId);
    }

    /**
     * Builds a new {@link OrderLineItemDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .type(getType())
            .percentage(getPercentage())
            .amountMoney(getAmountMoney())
            .appliedMoney(getAppliedMoney())
            .metadata(getMetadata())
            .scope(getScope())
            .rewardIds(getRewardIds())
            .pricingRuleId(getPricingRuleId());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemDiscount}
     */
    public static class Builder {
        private String uid;
        private String catalogObjectId;
        private String name;
        private String type;
        private String percentage;
        private Money amountMoney;
        private Money appliedMoney;
        private Map<String, String> metadata;
        private String scope;
        private List<String> rewardIds;
        private String pricingRuleId;

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
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for percentage
         * @param percentage
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }
        /**
         * Setter for appliedMoney
         * @param appliedMoney
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }
        /**
         * Setter for metadata
         * @param metadata
         * @return Builder
         */
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        /**
         * Setter for scope
         * @param scope
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }
        /**
         * Setter for rewardIds
         * @param rewardIds
         * @return Builder
         */
        public Builder rewardIds(List<String> rewardIds) {
            this.rewardIds = rewardIds;
            return this;
        }
        /**
         * Setter for pricingRuleId
         * @param pricingRuleId
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
            return new OrderLineItemDiscount(uid,
                catalogObjectId,
                name,
                type,
                percentage,
                amountMoney,
                appliedMoney,
                metadata,
                scope,
                rewardIds,
                pricingRuleId);
        }
    }
}
