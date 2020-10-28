
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1Item type.
 */
public class V1Item {
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

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param name String value for name.
     * @param description String value for description.
     * @param type String value for type.
     * @param color String value for color.
     * @param abbreviation String value for abbreviation.
     * @param visibility String value for visibility.
     * @param availableOnline Boolean value for availableOnline.
     * @param masterImage V1ItemImage value for masterImage.
     * @param category V1Category value for category.
     * @param variations List of V1Variation value for variations.
     * @param modifierLists List of V1ModifierList value for modifierLists.
     * @param fees List of V1Fee value for fees.
     * @param taxable Boolean value for taxable.
     * @param categoryId String value for categoryId.
     * @param availableForPickup Boolean value for availableForPickup.
     * @param v2Id String value for v2Id.
     */
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The item's ID. Must be unique among all entity IDs ever provided on behalf of the merchant.
     * You can never reuse an ID. This value can include alphanumeric characters, dashes (-), and
     * underscores (_).
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The item's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Description.
     * The item's description.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Color.
     * @return Returns the String
     */
    @JsonGetter("color")
    public String getColor() {
        return this.color;
    }

    /**
     * Getter for Abbreviation.
     * The text of the item's display label in Square Point of Sale. Only up to the first five
     * characters of the string are used.
     * @return Returns the String
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() {
        return this.abbreviation;
    }

    /**
     * Getter for Visibility.
     * @return Returns the String
     */
    @JsonGetter("visibility")
    public String getVisibility() {
        return this.visibility;
    }

    /**
     * Getter for AvailableOnline.
     * If true, the item can be added to shipping orders from the merchant's online store.
     * @return Returns the Boolean
     */
    @JsonGetter("available_online")
    public Boolean getAvailableOnline() {
        return this.availableOnline;
    }

    /**
     * Getter for MasterImage.
     * V1ItemImage
     * @return Returns the V1ItemImage
     */
    @JsonGetter("master_image")
    public V1ItemImage getMasterImage() {
        return this.masterImage;
    }

    /**
     * Getter for Category.
     * V1Category
     * @return Returns the V1Category
     */
    @JsonGetter("category")
    public V1Category getCategory() {
        return this.category;
    }

    /**
     * Getter for Variations.
     * The item's variations. You must specify at least one variation.
     * @return Returns the List of V1Variation
     */
    @JsonGetter("variations")
    public List<V1Variation> getVariations() {
        return this.variations;
    }

    /**
     * Getter for ModifierLists.
     * The modifier lists that apply to the item, if any.
     * @return Returns the List of V1ModifierList
     */
    @JsonGetter("modifier_lists")
    public List<V1ModifierList> getModifierLists() {
        return this.modifierLists;
    }

    /**
     * Getter for Fees.
     * The fees that apply to the item, if any.
     * @return Returns the List of V1Fee
     */
    @JsonGetter("fees")
    public List<V1Fee> getFees() {
        return this.fees;
    }

    /**
     * Getter for Taxable.
     * Deprecated. This field is not used.
     * @return Returns the Boolean
     */
    @JsonGetter("taxable")
    public Boolean getTaxable() {
        return this.taxable;
    }

    /**
     * Getter for CategoryId.
     * The ID of the item's category, if any.
     * @return Returns the String
     */
    @JsonGetter("category_id")
    public String getCategoryId() {
        return this.categoryId;
    }

    /**
     * Getter for AvailableForPickup.
     * If true, the item can be added to pickup orders from the merchant's online store. Default
     * value: false
     * @return Returns the Boolean
     */
    @JsonGetter("available_for_pickup")
    public Boolean getAvailableForPickup() {
        return this.availableForPickup;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple
     * locations share the same v2 ID.
     * @return Returns the String
     */
    @JsonGetter("v2_id")
    public String getV2Id() {
        return this.v2Id;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, color, abbreviation, visibility,
                availableOnline, masterImage, category, variations, modifierLists, fees, taxable,
                categoryId, availableForPickup, v2Id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Item)) {
            return false;
        }
        V1Item other = (V1Item) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(description, other.description)
            && Objects.equals(type, other.type)
            && Objects.equals(color, other.color)
            && Objects.equals(abbreviation, other.abbreviation)
            && Objects.equals(visibility, other.visibility)
            && Objects.equals(availableOnline, other.availableOnline)
            && Objects.equals(masterImage, other.masterImage)
            && Objects.equals(category, other.category)
            && Objects.equals(variations, other.variations)
            && Objects.equals(modifierLists, other.modifierLists)
            && Objects.equals(fees, other.fees)
            && Objects.equals(taxable, other.taxable)
            && Objects.equals(categoryId, other.categoryId)
            && Objects.equals(availableForPickup, other.availableForPickup)
            && Objects.equals(v2Id, other.v2Id);
    }

    /**
     * Builds a new {@link V1Item.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Item.Builder} object
     */
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

    /**
     * Class to build instances of {@link V1Item}.
     */
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



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for description.
         * @param description String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for type.
         * @param type String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for color.
         * @param color String value for color.
         * @return Builder
         */
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        /**
         * Setter for abbreviation.
         * @param abbreviation String value for abbreviation.
         * @return Builder
         */
        public Builder abbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }

        /**
         * Setter for visibility.
         * @param visibility String value for visibility.
         * @return Builder
         */
        public Builder visibility(String visibility) {
            this.visibility = visibility;
            return this;
        }

        /**
         * Setter for availableOnline.
         * @param availableOnline Boolean value for availableOnline.
         * @return Builder
         */
        public Builder availableOnline(Boolean availableOnline) {
            this.availableOnline = availableOnline;
            return this;
        }

        /**
         * Setter for masterImage.
         * @param masterImage V1ItemImage value for masterImage.
         * @return Builder
         */
        public Builder masterImage(V1ItemImage masterImage) {
            this.masterImage = masterImage;
            return this;
        }

        /**
         * Setter for category.
         * @param category V1Category value for category.
         * @return Builder
         */
        public Builder category(V1Category category) {
            this.category = category;
            return this;
        }

        /**
         * Setter for variations.
         * @param variations List of V1Variation value for variations.
         * @return Builder
         */
        public Builder variations(List<V1Variation> variations) {
            this.variations = variations;
            return this;
        }

        /**
         * Setter for modifierLists.
         * @param modifierLists List of V1ModifierList value for modifierLists.
         * @return Builder
         */
        public Builder modifierLists(List<V1ModifierList> modifierLists) {
            this.modifierLists = modifierLists;
            return this;
        }

        /**
         * Setter for fees.
         * @param fees List of V1Fee value for fees.
         * @return Builder
         */
        public Builder fees(List<V1Fee> fees) {
            this.fees = fees;
            return this;
        }

        /**
         * Setter for taxable.
         * @param taxable Boolean value for taxable.
         * @return Builder
         */
        public Builder taxable(Boolean taxable) {
            this.taxable = taxable;
            return this;
        }

        /**
         * Setter for categoryId.
         * @param categoryId String value for categoryId.
         * @return Builder
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        /**
         * Setter for availableForPickup.
         * @param availableForPickup Boolean value for availableForPickup.
         * @return Builder
         */
        public Builder availableForPickup(Boolean availableForPickup) {
            this.availableForPickup = availableForPickup;
            return this;
        }

        /**
         * Setter for v2Id.
         * @param v2Id String value for v2Id.
         * @return Builder
         */
        public Builder v2Id(String v2Id) {
            this.v2Id = v2Id;
            return this;
        }

        /**
         * Builds a new {@link V1Item} object using the set fields.
         * @return {@link V1Item}
         */
        public V1Item build() {
            V1Item model =
                    new V1Item(id,
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
