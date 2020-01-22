package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderReturnDiscount type.
 */
public class OrderReturnDiscount {

    /**
     * Initialization constructor.
     * @param uid
     * @param sourceDiscountUid
     * @param catalogObjectId
     * @param name
     * @param type
     * @param percentage
     * @param amountMoney
     * @param appliedMoney
     * @param scope
     */
    @JsonCreator
    public OrderReturnDiscount(
            @JsonProperty("uid") String uid,
            @JsonProperty("source_discount_uid") String sourceDiscountUid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("scope") String scope) {
        this.uid = uid;
        this.sourceDiscountUid = sourceDiscountUid;
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.scope = scope;
    }

    private final String uid;
    private final String sourceDiscountUid;
    private final String catalogObjectId;
    private final String name;
    private final String type;
    private final String percentage;
    private final Money amountMoney;
    private final Money appliedMoney;
    private final String scope;
    /**
     * Getter for Uid.
     * Unique ID that identifies the return discount only within this order.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for SourceDiscountUid.
     * `uid` of the Discount from the Order which contains the original application of this discount.
     */
    @JsonGetter("source_discount_uid")
    public String getSourceDiscountUid() {
        return this.sourceDiscountUid;
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
     * The percentage of the tax, as a string representation of a decimal number.
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
     * Getter for Scope.
     * Indicates whether this is a line item or order level discount.
     */
    @JsonGetter("scope")
    public String getScope() {
        return this.scope;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, sourceDiscountUid, catalogObjectId, name, type, percentage,
            amountMoney, appliedMoney, scope);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderReturnDiscount)) {
            return false;
        }
        OrderReturnDiscount orderReturnDiscount = (OrderReturnDiscount) obj;
        return Objects.equals(uid, orderReturnDiscount.uid) &&
            Objects.equals(sourceDiscountUid, orderReturnDiscount.sourceDiscountUid) &&
            Objects.equals(catalogObjectId, orderReturnDiscount.catalogObjectId) &&
            Objects.equals(name, orderReturnDiscount.name) &&
            Objects.equals(type, orderReturnDiscount.type) &&
            Objects.equals(percentage, orderReturnDiscount.percentage) &&
            Objects.equals(amountMoney, orderReturnDiscount.amountMoney) &&
            Objects.equals(appliedMoney, orderReturnDiscount.appliedMoney) &&
            Objects.equals(scope, orderReturnDiscount.scope);
    }

    /**
     * Builds a new {@link OrderReturnDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderReturnDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .sourceDiscountUid(getSourceDiscountUid())
            .catalogObjectId(getCatalogObjectId())
            .name(getName())
            .type(getType())
            .percentage(getPercentage())
            .amountMoney(getAmountMoney())
            .appliedMoney(getAppliedMoney())
            .scope(getScope());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderReturnDiscount}
     */
    public static class Builder {
        private String uid;
        private String sourceDiscountUid;
        private String catalogObjectId;
        private String name;
        private String type;
        private String percentage;
        private Money amountMoney;
        private Money appliedMoney;
        private String scope;

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
         * Setter for sourceDiscountUid
         * @param sourceDiscountUid
         * @return Builder
         */
        public Builder sourceDiscountUid(String sourceDiscountUid) {
            this.sourceDiscountUid = sourceDiscountUid;
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
         * Setter for scope
         * @param scope
         * @return Builder
         */
        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Builds a new {@link OrderReturnDiscount} object using the set fields.
         * @return {@link OrderReturnDiscount}
         */
        public OrderReturnDiscount build() {
            return new OrderReturnDiscount(uid,
                sourceDiscountUid,
                catalogObjectId,
                name,
                type,
                percentage,
                amountMoney,
                appliedMoney,
                scope);
        }
    }
}
