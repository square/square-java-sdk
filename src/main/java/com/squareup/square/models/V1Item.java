package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Item {

    @JsonCreator
    public V1Item(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("type") String type,
            @JsonProperty("color") String color,
            @JsonProperty("abbreviation") String abbreviation,
            @JsonProperty("visibility") String visibility,
            @JsonProperty("available_online") Boolean availableOnline,
            @JsonProperty("master_image") V1ItemImage masterImage,
            @JsonProperty("category") V1Category category,
            @JsonProperty("variations") List<V1Variation> variations,
            @JsonProperty("modifier_lists") List<V1ModifierList> modifierLists,
            @JsonProperty("fees") List<V1Fee> fees,
            @JsonProperty("taxable") Boolean taxable,
            @JsonProperty("category_id") String categoryId,
            @JsonProperty("available_for_pickup") Boolean availableForPickup,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.color = color;
        this.abbreviation = abbreviation;
        this.visibility = visibility;
        this.availableOnline = availableOnline;
        this.masterImage = masterImage;
        this.category = category;
        this.variations = variations;
        this.modifierLists = modifierLists;
        this.fees = fees;
        this.taxable = taxable;
        this.categoryId = categoryId;
        this.availableForPickup = availableForPickup;
        this.v2Id = v2Id;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String description;
    private final String type;
    private final String color;
    private final String abbreviation;
    private final String visibility;
    private final Boolean availableOnline;
    private final V1ItemImage masterImage;
    private final V1Category category;
    private final List<V1Variation> variations;
    private final List<V1ModifierList> modifierLists;
    private final List<V1Fee> fees;
    private final Boolean taxable;
    private final String categoryId;
    private final Boolean availableForPickup;
    private final String v2Id;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, color, abbreviation, visibility, availableOnline, masterImage, category, variations, modifierLists, fees, taxable, categoryId, availableForPickup, v2Id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Item)) {
            return false;
        }
        V1Item v1Item = (V1Item) o;
        return Objects.equals(id, v1Item.id) &&
            Objects.equals(name, v1Item.name) &&
            Objects.equals(description, v1Item.description) &&
            Objects.equals(type, v1Item.type) &&
            Objects.equals(color, v1Item.color) &&
            Objects.equals(abbreviation, v1Item.abbreviation) &&
            Objects.equals(visibility, v1Item.visibility) &&
            Objects.equals(availableOnline, v1Item.availableOnline) &&
            Objects.equals(masterImage, v1Item.masterImage) &&
            Objects.equals(category, v1Item.category) &&
            Objects.equals(variations, v1Item.variations) &&
            Objects.equals(modifierLists, v1Item.modifierLists) &&
            Objects.equals(fees, v1Item.fees) &&
            Objects.equals(taxable, v1Item.taxable) &&
            Objects.equals(categoryId, v1Item.categoryId) &&
            Objects.equals(availableForPickup, v1Item.availableForPickup) &&
            Objects.equals(v2Id, v1Item.v2Id);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The item's ID. Must be unique among all entity IDs ever provided on behalf of the merchant. You can never reuse an ID. This value can include alphanumeric characters, dashes (-), and underscores (_).
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The item's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Description.
     * The item's description.
     */
    @JsonGetter("description")
    public String getDescription() { 
        return this.description;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for Color.
     */
    @JsonGetter("color")
    public String getColor() { 
        return this.color;
    }

    /**
     * Getter for Abbreviation.
     * The text of the item's display label in Square Point of Sale. Only up to the first five characters of the string are used.
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() { 
        return this.abbreviation;
    }

    /**
     * Getter for Visibility.
     */
    @JsonGetter("visibility")
    public String getVisibility() { 
        return this.visibility;
    }

    /**
     * Getter for AvailableOnline.
     * If true, the item can be added to shipping orders from the merchant's online store.
     */
    @JsonGetter("available_online")
    public Boolean getAvailableOnline() { 
        return this.availableOnline;
    }

    /**
     * Getter for MasterImage.
     * V1ItemImage
     */
    @JsonGetter("master_image")
    public V1ItemImage getMasterImage() { 
        return this.masterImage;
    }

    /**
     * Getter for Category.
     * V1Category
     */
    @JsonGetter("category")
    public V1Category getCategory() { 
        return this.category;
    }

    /**
     * Getter for Variations.
     * The item's variations. You must specify at least one variation.
     */
    @JsonGetter("variations")
    public List<V1Variation> getVariations() { 
        return this.variations;
    }

    /**
     * Getter for ModifierLists.
     * The modifier lists that apply to the item, if any.
     */
    @JsonGetter("modifier_lists")
    public List<V1ModifierList> getModifierLists() { 
        return this.modifierLists;
    }

    /**
     * Getter for Fees.
     * The fees that apply to the item, if any.
     */
    @JsonGetter("fees")
    public List<V1Fee> getFees() { 
        return this.fees;
    }

    /**
     * Getter for Taxable.
     * Deprecated. This field is not used.
     */
    @JsonGetter("taxable")
    public Boolean getTaxable() { 
        return this.taxable;
    }

    /**
     * Getter for CategoryId.
     * The ID of the item's category, if any.
     */
    @JsonGetter("category_id")
    public String getCategoryId() { 
        return this.categoryId;
    }

    /**
     * Getter for AvailableForPickup.
     * If true, the item can be added to pickup orders from the merchant's online store. Default value: false
     */
    @JsonGetter("available_for_pickup")
    public Boolean getAvailableForPickup() { 
        return this.availableForPickup;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID.
     */
    @JsonGetter("v2_id")
    public String getV2Id() { 
        return this.v2Id;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .description(getDescription())
            .type(getType())
            .color(getColor())
            .abbreviation(getAbbreviation())
            .visibility(getVisibility())
            .availableOnline(getAvailableOnline())
            .masterImage(getMasterImage())
            .category(getCategory())
            .variations(getVariations())
            .modifierLists(getModifierLists())
            .fees(getFees())
            .taxable(getTaxable())
            .categoryId(getCategoryId())
            .availableForPickup(getAvailableForPickup())
            .v2Id(getV2Id());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String description;
        private String type;
        private String color;
        private String abbreviation;
        private String visibility;
        private Boolean availableOnline;
        private V1ItemImage masterImage;
        private V1Category category;
        private List<V1Variation> variations;
        private List<V1ModifierList> modifierLists;
        private List<V1Fee> fees;
        private Boolean taxable;
        private String categoryId;
        private Boolean availableForPickup;
        private String v2Id;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder color(String value) {
            color = value;
            return this;
        }
        public Builder abbreviation(String value) {
            abbreviation = value;
            return this;
        }
        public Builder visibility(String value) {
            visibility = value;
            return this;
        }
        public Builder availableOnline(Boolean value) {
            availableOnline = value;
            return this;
        }
        public Builder masterImage(V1ItemImage value) {
            masterImage = value;
            return this;
        }
        public Builder category(V1Category value) {
            category = value;
            return this;
        }
        public Builder variations(List<V1Variation> value) {
            variations = value;
            return this;
        }
        public Builder modifierLists(List<V1ModifierList> value) {
            modifierLists = value;
            return this;
        }
        public Builder fees(List<V1Fee> value) {
            fees = value;
            return this;
        }
        public Builder taxable(Boolean value) {
            taxable = value;
            return this;
        }
        public Builder categoryId(String value) {
            categoryId = value;
            return this;
        }
        public Builder availableForPickup(Boolean value) {
            availableForPickup = value;
            return this;
        }
        public Builder v2Id(String value) {
            v2Id = value;
            return this;
        }

        public V1Item build() {
            V1Item model = new V1Item(id,
                name,
                description,
                type,
                color,
                abbreviation,
                visibility,
                availableOnline,
                masterImage,
                category,
                variations,
                modifierLists,
                fees,
                taxable,
                categoryId,
                availableForPickup,
                v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
