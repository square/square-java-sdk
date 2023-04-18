
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for OrderLineItemTax type.
 */
public class OrderLineItemTax {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<String> name;
    private final String type;
    private final OptionalNullable<String> percentage;
    private final OptionalNullable<Map<String, String>> metadata;
    private final Money appliedMoney;
    private final String scope;
    private final Boolean autoApplied;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  name  String value for name.
     * @param  type  String value for type.
     * @param  percentage  String value for percentage.
     * @param  metadata  Map of String, value for metadata.
     * @param  appliedMoney  Money value for appliedMoney.
     * @param  scope  String value for scope.
     * @param  autoApplied  Boolean value for autoApplied.
     */
    @JsonCreator
    public OrderLineItemTax(
            @JsonProperty("uid") String uid,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("name") String name,
            @JsonProperty("type") String type,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("applied_money") Money appliedMoney,
            @JsonProperty("scope") String scope,
            @JsonProperty("auto_applied") Boolean autoApplied) {
        this.uid = OptionalNullable.of(uid);
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.name = OptionalNullable.of(name);
        this.type = type;
        this.percentage = OptionalNullable.of(percentage);
        this.metadata = OptionalNullable.of(metadata);
        this.appliedMoney = appliedMoney;
        this.scope = scope;
        this.autoApplied = autoApplied;
    }

    /**
     * Internal initialization constructor.
     */
    protected OrderLineItemTax(OptionalNullable<String> uid,
            OptionalNullable<String> catalogObjectId, OptionalNullable<Long> catalogVersion,
            OptionalNullable<String> name, String type, OptionalNullable<String> percentage,
            OptionalNullable<Map<String, String>> metadata, Money appliedMoney, String scope,
            Boolean autoApplied) {
        this.uid = uid;
        this.catalogObjectId = catalogObjectId;
        this.catalogVersion = catalogVersion;
        this.name = name;
        this.type = type;
        this.percentage = percentage;
        this.metadata = metadata;
        this.appliedMoney = appliedMoney;
        this.scope = scope;
        this.autoApplied = autoApplied;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID that identifies the tax only within this order.
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
     * A unique ID that identifies the tax only within this order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The catalog object ID referencing [CatalogTax](entity:CatalogTax).
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
     * The catalog object ID referencing [CatalogTax](entity:CatalogTax).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the catalog object that this tax references.
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
     * The version of the catalog object that this tax references.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for Name.
     * The tax's name.
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
     * The tax's name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for Type.
     * Indicates how the tax is applied to the associated line item or order.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for Percentage.
     * The percentage of the tax, as a string representation of a decimal number. For example, a
     * value of `"7.25"` corresponds to a percentage of 7.25%.
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
     * The percentage of the tax, as a string representation of a decimal number. For example, a
     * value of `"7.25"` corresponds to a percentage of 7.25%.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentage() {
        return OptionalNullable.getFrom(percentage);
    }

    /**
     * Internal Getter for Metadata.
     * Application-defined data attached to this tax. Metadata fields are intended to store
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
     * Application-defined data attached to this tax. Metadata fields are intended to store
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
     * Getter for Scope.
     * Indicates whether this is a line-item or order-level tax.
     * @return Returns the String
     */
    @JsonGetter("scope")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScope() {
        return scope;
    }

    /**
     * Getter for AutoApplied.
     * Determines whether the tax was automatically applied to the order based on the catalog
     * configuration. For an example, see [Automatically Apply Taxes to an
     * Order](https://developer.squareup.com/docs/orders-api/apply-taxes-and-discounts/auto-apply-taxes).
     * @return Returns the Boolean
     */
    @JsonGetter("auto_applied")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAutoApplied() {
        return autoApplied;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, catalogObjectId, catalogVersion, name, type, percentage, metadata,
                appliedMoney, scope, autoApplied);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLineItemTax)) {
            return false;
        }
        OrderLineItemTax other = (OrderLineItemTax) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogVersion, other.catalogVersion)
            && Objects.equals(name, other.name)
            && Objects.equals(type, other.type)
            && Objects.equals(percentage, other.percentage)
            && Objects.equals(metadata, other.metadata)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(scope, other.scope)
            && Objects.equals(autoApplied, other.autoApplied);
    }

    /**
     * Converts this OrderLineItemTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderLineItemTax [" + "uid=" + uid + ", catalogObjectId=" + catalogObjectId
                + ", catalogVersion=" + catalogVersion + ", name=" + name + ", type=" + type
                + ", percentage=" + percentage + ", metadata=" + metadata + ", appliedMoney="
                + appliedMoney + ", scope=" + scope + ", autoApplied=" + autoApplied + "]";
    }

    /**
     * Builds a new {@link OrderLineItemTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderLineItemTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .appliedMoney(getAppliedMoney())
                .scope(getScope())
                .autoApplied(getAutoApplied());
        builder.uid = internalGetUid();
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.name = internalGetName();
        builder.percentage = internalGetPercentage();
        builder.metadata = internalGetMetadata();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderLineItemTax}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<String> name;
        private String type;
        private OptionalNullable<String> percentage;
        private OptionalNullable<Map<String, String>> metadata;
        private Money appliedMoney;
        private String scope;
        private Boolean autoApplied;



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
         * Setter for appliedMoney.
         * @param  appliedMoney  Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(Money appliedMoney) {
            this.appliedMoney = appliedMoney;
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
         * Setter for autoApplied.
         * @param  autoApplied  Boolean value for autoApplied.
         * @return Builder
         */
        public Builder autoApplied(Boolean autoApplied) {
            this.autoApplied = autoApplied;
            return this;
        }

        /**
         * Builds a new {@link OrderLineItemTax} object using the set fields.
         * @return {@link OrderLineItemTax}
         */
        public OrderLineItemTax build() {
            return new OrderLineItemTax(uid, catalogObjectId, catalogVersion, name, type,
                    percentage, metadata, appliedMoney, scope, autoApplied);
        }
    }
}
