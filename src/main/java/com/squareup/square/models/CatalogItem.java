package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItem type.
 */
public class CatalogItem {

    /**
     * Initialization constructor.
     * @param name
     * @param description
     * @param abbreviation
     * @param labelColor
     * @param availableOnline
     * @param availableForPickup
     * @param availableElectronically
     * @param categoryId
     * @param taxIds
     * @param modifierListInfo
     * @param variations
     * @param productType
     * @param skipModifierScreen
     * @param itemOptions
     */
    @JsonCreator
    public CatalogItem(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("abbreviation") String abbreviation,
            @JsonProperty("label_color") String labelColor,
            @JsonProperty("available_online") Boolean availableOnline,
            @JsonProperty("available_for_pickup") Boolean availableForPickup,
            @JsonProperty("available_electronically") Boolean availableElectronically,
            @JsonProperty("category_id") String categoryId,
            @JsonProperty("tax_ids") List<String> taxIds,
            @JsonProperty("modifier_list_info") List<CatalogItemModifierListInfo> modifierListInfo,
            @JsonProperty("variations") List<CatalogObject> variations,
            @JsonProperty("product_type") String productType,
            @JsonProperty("skip_modifier_screen") Boolean skipModifierScreen,
            @JsonProperty("item_options") List<CatalogItemOptionForItem> itemOptions) {
        this.name = name;
        this.description = description;
        this.abbreviation = abbreviation;
        this.labelColor = labelColor;
        this.availableOnline = availableOnline;
        this.availableForPickup = availableForPickup;
        this.availableElectronically = availableElectronically;
        this.categoryId = categoryId;
        this.taxIds = taxIds;
        this.modifierListInfo = modifierListInfo;
        this.variations = variations;
        this.productType = productType;
        this.skipModifierScreen = skipModifierScreen;
        this.itemOptions = itemOptions;
    }

    private final String name;
    private final String description;
    private final String abbreviation;
    private final String labelColor;
    private final Boolean availableOnline;
    private final Boolean availableForPickup;
    private final Boolean availableElectronically;
    private final String categoryId;
    private final List<String> taxIds;
    private final List<CatalogItemModifierListInfo> modifierListInfo;
    private final List<CatalogObject> variations;
    private final String productType;
    private final Boolean skipModifierScreen;
    private final List<CatalogItemOptionForItem> itemOptions;
    /**
     * Getter for Name.
     * The item's name. Searchable. This field must not be empty. This field has max length of 512 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Description.
     * The item's description. Searchable. This field has max length of 4096 Unicode code points.
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for Abbreviation.
     * The text of the item's display label in the Square Point of Sale app. Only up to the first five characters of the string are used. Searchable.
     * This field has max length of 24 Unicode code points.
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() {
        return this.abbreviation;
    }

    /**
     * Getter for LabelColor.
     * The color of the item's display label in the Square Point of Sale app. This must be a valid hex color code.
     */
    @JsonGetter("label_color")
    public String getLabelColor() {
        return this.labelColor;
    }

    /**
     * Getter for AvailableOnline.
     * If `true`, the item can be added to shipping orders from the merchant's online store.
     */
    @JsonGetter("available_online")
    public Boolean getAvailableOnline() {
        return this.availableOnline;
    }

    /**
     * Getter for AvailableForPickup.
     * If `true`, the item can be added to pickup orders from the merchant's online store.
     */
    @JsonGetter("available_for_pickup")
    public Boolean getAvailableForPickup() {
        return this.availableForPickup;
    }

    /**
     * Getter for AvailableElectronically.
     * If `true`, the item can be added to electronically fulfilled orders from the merchant's online store.
     */
    @JsonGetter("available_electronically")
    public Boolean getAvailableElectronically() {
        return this.availableElectronically;
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
     * Getter for TaxIds.
     * A set of IDs indicating the taxes enabled for
     * this item. When updating an item, any taxes listed here will be added to the item.
     * Taxes may also be added to or deleted from an item using `UpdateItemTaxes`.
     */
    @JsonGetter("tax_ids")
    public List<String> getTaxIds() {
        return this.taxIds;
    }

    /**
     * Getter for ModifierListInfo.
     * A set of `CatalogItemModifierListInfo` objects
     * representing the modifier lists that apply to this item, along with the overrides and min
     * and max limits that are specific to this item. Modifier lists
     * may also be added to or deleted from an item using `UpdateItemModifierLists`.
     */
    @JsonGetter("modifier_list_info")
    public List<CatalogItemModifierListInfo> getModifierListInfo() {
        return this.modifierListInfo;
    }

    /**
     * Getter for Variations.
     * A list of CatalogObjects containing the `CatalogItemVariation`s for this item.
     */
    @JsonGetter("variations")
    public List<CatalogObject> getVariations() {
        return this.variations;
    }

    /**
     * Getter for ProductType.
     * The type of a CatalogItem. Connect V2 only allows the creation of `REGULAR` or `APPOINTMENTS_SERVICE` items.
     */
    @JsonGetter("product_type")
    public String getProductType() {
        return this.productType;
    }

    /**
     * Getter for SkipModifierScreen.
     * If `false`, the Square Point of Sale app will present the `CatalogItem`'s
     * details screen immediately, allowing the merchant to choose `CatalogModifier`s
     * before adding the item to the cart.  This is the default behavior.
     * If `true`, the Square Point of Sale app will immediately add the item to the cart with the pre-selected
     * modifiers, and merchants can edit modifiers by drilling down onto the item's details.
     * Third-party clients are encouraged to implement similar behaviors.
     */
    @JsonGetter("skip_modifier_screen")
    public Boolean getSkipModifierScreen() {
        return this.skipModifierScreen;
    }

    /**
     * Getter for ItemOptions.
     * List of item options IDs for this item. Used to manage and group item
     * variations in a specified order.
     * Maximum: 6 item options.
     */
    @JsonGetter("item_options")
    public List<CatalogItemOptionForItem> getItemOptions() {
        return this.itemOptions;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, description, abbreviation, labelColor, availableOnline,
            availableForPickup, availableElectronically, categoryId, taxIds, modifierListInfo,
            variations, productType, skipModifierScreen, itemOptions);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItem)) {
            return false;
        }
        CatalogItem catalogItem = (CatalogItem) obj;
        return Objects.equals(name, catalogItem.name) &&
            Objects.equals(description, catalogItem.description) &&
            Objects.equals(abbreviation, catalogItem.abbreviation) &&
            Objects.equals(labelColor, catalogItem.labelColor) &&
            Objects.equals(availableOnline, catalogItem.availableOnline) &&
            Objects.equals(availableForPickup, catalogItem.availableForPickup) &&
            Objects.equals(availableElectronically, catalogItem.availableElectronically) &&
            Objects.equals(categoryId, catalogItem.categoryId) &&
            Objects.equals(taxIds, catalogItem.taxIds) &&
            Objects.equals(modifierListInfo, catalogItem.modifierListInfo) &&
            Objects.equals(variations, catalogItem.variations) &&
            Objects.equals(productType, catalogItem.productType) &&
            Objects.equals(skipModifierScreen, catalogItem.skipModifierScreen) &&
            Objects.equals(itemOptions, catalogItem.itemOptions);
    }

    /**
     * Builds a new {@link CatalogItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .description(getDescription())
            .abbreviation(getAbbreviation())
            .labelColor(getLabelColor())
            .availableOnline(getAvailableOnline())
            .availableForPickup(getAvailableForPickup())
            .availableElectronically(getAvailableElectronically())
            .categoryId(getCategoryId())
            .taxIds(getTaxIds())
            .modifierListInfo(getModifierListInfo())
            .variations(getVariations())
            .productType(getProductType())
            .skipModifierScreen(getSkipModifierScreen())
            .itemOptions(getItemOptions());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogItem}
     */
    public static class Builder {
        private String name;
        private String description;
        private String abbreviation;
        private String labelColor;
        private Boolean availableOnline;
        private Boolean availableForPickup;
        private Boolean availableElectronically;
        private String categoryId;
        private List<String> taxIds;
        private List<CatalogItemModifierListInfo> modifierListInfo;
        private List<CatalogObject> variations;
        private String productType;
        private Boolean skipModifierScreen;
        private List<CatalogItemOptionForItem> itemOptions;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for description
         * @param description
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        /**
         * Setter for abbreviation
         * @param abbreviation
         * @return Builder
         */
        public Builder abbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }
        /**
         * Setter for labelColor
         * @param labelColor
         * @return Builder
         */
        public Builder labelColor(String labelColor) {
            this.labelColor = labelColor;
            return this;
        }
        /**
         * Setter for availableOnline
         * @param availableOnline
         * @return Builder
         */
        public Builder availableOnline(Boolean availableOnline) {
            this.availableOnline = availableOnline;
            return this;
        }
        /**
         * Setter for availableForPickup
         * @param availableForPickup
         * @return Builder
         */
        public Builder availableForPickup(Boolean availableForPickup) {
            this.availableForPickup = availableForPickup;
            return this;
        }
        /**
         * Setter for availableElectronically
         * @param availableElectronically
         * @return Builder
         */
        public Builder availableElectronically(Boolean availableElectronically) {
            this.availableElectronically = availableElectronically;
            return this;
        }
        /**
         * Setter for categoryId
         * @param categoryId
         * @return Builder
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }
        /**
         * Setter for taxIds
         * @param taxIds
         * @return Builder
         */
        public Builder taxIds(List<String> taxIds) {
            this.taxIds = taxIds;
            return this;
        }
        /**
         * Setter for modifierListInfo
         * @param modifierListInfo
         * @return Builder
         */
        public Builder modifierListInfo(List<CatalogItemModifierListInfo> modifierListInfo) {
            this.modifierListInfo = modifierListInfo;
            return this;
        }
        /**
         * Setter for variations
         * @param variations
         * @return Builder
         */
        public Builder variations(List<CatalogObject> variations) {
            this.variations = variations;
            return this;
        }
        /**
         * Setter for productType
         * @param productType
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }
        /**
         * Setter for skipModifierScreen
         * @param skipModifierScreen
         * @return Builder
         */
        public Builder skipModifierScreen(Boolean skipModifierScreen) {
            this.skipModifierScreen = skipModifierScreen;
            return this;
        }
        /**
         * Setter for itemOptions
         * @param itemOptions
         * @return Builder
         */
        public Builder itemOptions(List<CatalogItemOptionForItem> itemOptions) {
            this.itemOptions = itemOptions;
            return this;
        }

        /**
         * Builds a new {@link CatalogItem} object using the set fields.
         * @return {@link CatalogItem}
         */
        public CatalogItem build() {
            return new CatalogItem(name,
                description,
                abbreviation,
                labelColor,
                availableOnline,
                availableForPickup,
                availableElectronically,
                categoryId,
                taxIds,
                modifierListInfo,
                variations,
                productType,
                skipModifierScreen,
                itemOptions);
        }
    }
}
