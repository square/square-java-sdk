package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderLineItemDiscount {

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
            @JsonProperty("scope") String scope) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.amountMoney = amountMoney;
        this.appliedMoney = appliedMoney;
        this.metadata = metadata;
        this.scope = scope;
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

    @Override
    public int hashCode() {
        return Objects.hash(uid, catalogObjectId, name, type, percentage, amountMoney, appliedMoney, metadata, scope);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderLineItemDiscount)) {
            return false;
        }
        OrderLineItemDiscount orderLineItemDiscount = (OrderLineItemDiscount) o;
        return Objects.equals(uid, orderLineItemDiscount.uid) &&
            Objects.equals(catalogObjectId, orderLineItemDiscount.catalogObjectId) &&
            Objects.equals(name, orderLineItemDiscount.name) &&
            Objects.equals(type, orderLineItemDiscount.type) &&
            Objects.equals(percentage, orderLineItemDiscount.percentage) &&
            Objects.equals(amountMoney, orderLineItemDiscount.amountMoney) &&
            Objects.equals(appliedMoney, orderLineItemDiscount.appliedMoney) &&
            Objects.equals(metadata, orderLineItemDiscount.metadata) &&
            Objects.equals(scope, orderLineItemDiscount.scope);
    }

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
            .scope(getScope());
            return builder;
    }

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

        public Builder() { }

        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder percentage(String value) {
            percentage = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder appliedMoney(Money value) {
            appliedMoney = value;
            return this;
        }
        public Builder metadata(Map<String, String> value) {
            metadata = value;
            return this;
        }
        public Builder scope(String value) {
            scope = value;
            return this;
        }

        public OrderLineItemDiscount build() {
            return new OrderLineItemDiscount(uid,
                catalogObjectId,
                name,
                type,
                percentage,
                amountMoney,
                appliedMoney,
                metadata,
                scope);
        }
    }
}
