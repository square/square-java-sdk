package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateOrderRequestLineItem type.
 */
public class CreateOrderRequestLineItem {

    /**
     * Initialization constructor.
     * @param quantity
     * @param name
     * @param basePriceMoney
     * @param variationName
     * @param note
     * @param catalogObjectId
     * @param modifiers
     * @param taxes
     * @param discounts
     */
    @JsonCreator
    public CreateOrderRequestLineItem(
            @JsonProperty("quantity") String quantity,
            @JsonProperty("name") String name,
            @JsonProperty("base_price_money") Money basePriceMoney,
            @JsonProperty("variation_name") String variationName,
            @JsonProperty("note") String note,
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("modifiers") List<CreateOrderRequestModifier> modifiers,
            @JsonProperty("taxes") List<CreateOrderRequestTax> taxes,
            @JsonProperty("discounts") List<CreateOrderRequestDiscount> discounts) {
        this.name = name;
        this.quantity = quantity;
        this.basePriceMoney = basePriceMoney;
        this.variationName = variationName;
        this.note = note;
        this.catalogObjectId = catalogObjectId;
        this.modifiers = modifiers;
        this.taxes = taxes;
        this.discounts = discounts;
    }

    private final String name;
    private final String quantity;
    private final Money basePriceMoney;
    private final String variationName;
    private final String note;
    private final String catalogObjectId;
    private final List<CreateOrderRequestModifier> modifiers;
    private final List<CreateOrderRequestTax> taxes;
    private final List<CreateOrderRequestDiscount> discounts;
    /**
     * Getter for Name.
     * Only used for ad hoc line items. The name of the line item. This value cannot exceed 500 characters.
     * Do not provide a value for this field if you provide a value for `catalog_object_id`.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Quantity.
     * The quantity to purchase, as a string representation of a number.
     * This string must have a positive integer value.
     */
    @JsonGetter("quantity")
    public String getQuantity() {
        return this.quantity;
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
     * Getter for VariationName.
     * Only used for ad hoc line items. The variation name of the line item. This value cannot exceed 255 characters.
     * If this value is not set for an ad hoc line item, the default value of `Regular` is used.
     * Do not provide a value for this field if you provide a value for the `catalog_object_id`.
     */
    @JsonGetter("variation_name")
    public String getVariationName() {
        return this.variationName;
    }

    /**
     * Getter for Note.
     * The note of the line item. This value cannot exceed 500 characters.
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
    }

    /**
     * Getter for CatalogObjectId.
     * Only used for Catalog line items.
     * The catalog object ID for an existing [CatalogItemVariation](#type-catalogitemvariation).
     * Do not provide a value for this field if you provide a value for `name` and `base_price_money`.
     */
    @JsonGetter("catalog_object_id")
    public String getCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for Modifiers.
     * Only used for Catalog line items. The modifiers to include on the line item.
     */
    @JsonGetter("modifiers")
    public List<CreateOrderRequestModifier> getModifiers() {
        return this.modifiers;
    }

    /**
     * Getter for Taxes.
     * The taxes to include on the line item.
     */
    @JsonGetter("taxes")
    public List<CreateOrderRequestTax> getTaxes() {
        return this.taxes;
    }

    /**
     * Getter for Discounts.
     * The discounts to include on the line item.
     */
    @JsonGetter("discounts")
    public List<CreateOrderRequestDiscount> getDiscounts() {
        return this.discounts;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, basePriceMoney, variationName, note, catalogObjectId,
            modifiers, taxes, discounts);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateOrderRequestLineItem)) {
            return false;
        }
        CreateOrderRequestLineItem createOrderRequestLineItem = (CreateOrderRequestLineItem) obj;
        return Objects.equals(name, createOrderRequestLineItem.name) &&
            Objects.equals(quantity, createOrderRequestLineItem.quantity) &&
            Objects.equals(basePriceMoney, createOrderRequestLineItem.basePriceMoney) &&
            Objects.equals(variationName, createOrderRequestLineItem.variationName) &&
            Objects.equals(note, createOrderRequestLineItem.note) &&
            Objects.equals(catalogObjectId, createOrderRequestLineItem.catalogObjectId) &&
            Objects.equals(modifiers, createOrderRequestLineItem.modifiers) &&
            Objects.equals(taxes, createOrderRequestLineItem.taxes) &&
            Objects.equals(discounts, createOrderRequestLineItem.discounts);
    }

    /**
     * Builds a new {@link CreateOrderRequestLineItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateOrderRequestLineItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(quantity)
            .name(getName())
            .basePriceMoney(getBasePriceMoney())
            .variationName(getVariationName())
            .note(getNote())
            .catalogObjectId(getCatalogObjectId())
            .modifiers(getModifiers())
            .taxes(getTaxes())
            .discounts(getDiscounts());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateOrderRequestLineItem}
     */
    public static class Builder {
        private String quantity;
        private String name;
        private Money basePriceMoney;
        private String variationName;
        private String note;
        private String catalogObjectId;
        private List<CreateOrderRequestModifier> modifiers;
        private List<CreateOrderRequestTax> taxes;
        private List<CreateOrderRequestDiscount> discounts;

        /**
         * Initialization constructor
         */
        public Builder(String quantity) {
            this.quantity = quantity;
        }

        /**
         * Setter for quantity
         * @param quantity
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = quantity;
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
         * Setter for variationName
         * @param variationName
         * @return Builder
         */
        public Builder variationName(String variationName) {
            this.variationName = variationName;
            return this;
        }
        /**
         * Setter for note
         * @param note
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
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
         * Setter for modifiers
         * @param modifiers
         * @return Builder
         */
        public Builder modifiers(List<CreateOrderRequestModifier> modifiers) {
            this.modifiers = modifiers;
            return this;
        }
        /**
         * Setter for taxes
         * @param taxes
         * @return Builder
         */
        public Builder taxes(List<CreateOrderRequestTax> taxes) {
            this.taxes = taxes;
            return this;
        }
        /**
         * Setter for discounts
         * @param discounts
         * @return Builder
         */
        public Builder discounts(List<CreateOrderRequestDiscount> discounts) {
            this.discounts = discounts;
            return this;
        }

        /**
         * Builds a new {@link CreateOrderRequestLineItem} object using the set fields.
         * @return {@link CreateOrderRequestLineItem}
         */
        public CreateOrderRequestLineItem build() {
            return new CreateOrderRequestLineItem(quantity,
                name,
                basePriceMoney,
                variationName,
                note,
                catalogObjectId,
                modifiers,
                taxes,
                discounts);
        }
    }
}
