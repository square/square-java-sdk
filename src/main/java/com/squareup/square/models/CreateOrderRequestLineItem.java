package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateOrderRequestLineItem {

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

    @Override
    public int hashCode() {
        return Objects.hash(quantity, name, basePriceMoney, variationName, note, catalogObjectId, modifiers, taxes, discounts);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateOrderRequestLineItem)) {
            return false;
        }
        CreateOrderRequestLineItem createOrderRequestLineItem = (CreateOrderRequestLineItem) o;
        return Objects.equals(quantity, createOrderRequestLineItem.quantity) &&
            Objects.equals(name, createOrderRequestLineItem.name) &&
            Objects.equals(basePriceMoney, createOrderRequestLineItem.basePriceMoney) &&
            Objects.equals(variationName, createOrderRequestLineItem.variationName) &&
            Objects.equals(note, createOrderRequestLineItem.note) &&
            Objects.equals(catalogObjectId, createOrderRequestLineItem.catalogObjectId) &&
            Objects.equals(modifiers, createOrderRequestLineItem.modifiers) &&
            Objects.equals(taxes, createOrderRequestLineItem.taxes) &&
            Objects.equals(discounts, createOrderRequestLineItem.discounts);
    }

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

        public Builder(String quantity) {
            this.quantity = quantity;
        }

        public Builder quantity(String value) {
            quantity = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder basePriceMoney(Money value) {
            basePriceMoney = value;
            return this;
        }
        public Builder variationName(String value) {
            variationName = value;
            return this;
        }
        public Builder note(String value) {
            note = value;
            return this;
        }
        public Builder catalogObjectId(String value) {
            catalogObjectId = value;
            return this;
        }
        public Builder modifiers(List<CreateOrderRequestModifier> value) {
            modifiers = value;
            return this;
        }
        public Builder taxes(List<CreateOrderRequestTax> value) {
            taxes = value;
            return this;
        }
        public Builder discounts(List<CreateOrderRequestDiscount> value) {
            discounts = value;
            return this;
        }

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
