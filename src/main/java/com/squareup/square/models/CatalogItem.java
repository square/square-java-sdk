
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogItem type.
 */
public class CatalogItem {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String abbreviation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String labelColor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean availableOnline;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean availableForPickup;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean availableElectronically;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String categoryId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> taxIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogItemModifierListInfo> modifierListInfo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogObject> variations;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String productType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean skipModifierScreen;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogItemOptionForItem> itemOptions;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  description  String value for description.
     * @param  abbreviation  String value for abbreviation.
     * @param  labelColor  String value for labelColor.
     * @param  availableOnline  Boolean value for availableOnline.
     * @param  availableForPickup  Boolean value for availableForPickup.
     * @param  availableElectronically  Boolean value for availableElectronically.
     * @param  categoryId  String value for categoryId.
     * @param  taxIds  List of String value for taxIds.
     * @param  modifierListInfo  List of CatalogItemModifierListInfo value for modifierListInfo.
     * @param  variations  List of CatalogObject value for variations.
     * @param  productType  String value for productType.
     * @param  skipModifierScreen  Boolean value for skipModifierScreen.
     * @param  itemOptions  List of CatalogItemOptionForItem value for itemOptions.
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

    /**
     * Getter for Name.
     * The item's name. This is a searchable attribute for use in applicable query filters, its
     * value must not be empty, and the length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Description.
     * The item's description. This is a searchable attribute for use in applicable query filters,
     * and its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    /**
     * Getter for Abbreviation.
     * The text of the item's display label in the Square Point of Sale app. Only up to the first
     * five characters of the string are used. This attribute is searchable, and its value length is
     * of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Getter for LabelColor.
     * The color of the item's display label in the Square Point of Sale app. This must be a valid
     * hex color code.
     * @return Returns the String
     */
    @JsonGetter("label_color")
    public String getLabelColor() {
        return labelColor;
    }

    /**
     * Getter for AvailableOnline.
     * If `true`, the item can be added to shipping orders from the merchant's online store.
     * @return Returns the Boolean
     */
    @JsonGetter("available_online")
    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    /**
     * Getter for AvailableForPickup.
     * If `true`, the item can be added to pickup orders from the merchant's online store.
     * @return Returns the Boolean
     */
    @JsonGetter("available_for_pickup")
    public Boolean getAvailableForPickup() {
        return availableForPickup;
    }

    /**
     * Getter for AvailableElectronically.
     * If `true`, the item can be added to electronically fulfilled orders from the merchant's
     * online store.
     * @return Returns the Boolean
     */
    @JsonGetter("available_electronically")
    public Boolean getAvailableElectronically() {
        return availableElectronically;
    }

    /**
     * Getter for CategoryId.
     * The ID of the item's category, if any.
     * @return Returns the String
     */
    @JsonGetter("category_id")
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * Getter for TaxIds.
     * A set of IDs indicating the taxes enabled for this item. When updating an item, any taxes
     * listed here will be added to the item. Taxes may also be added to or deleted from an item
     * using `UpdateItemTaxes`.
     * @return Returns the List of String
     */
    @JsonGetter("tax_ids")
    public List<String> getTaxIds() {
        return taxIds;
    }

    /**
     * Getter for ModifierListInfo.
     * A set of `CatalogItemModifierListInfo` objects representing the modifier lists that apply to
     * this item, along with the overrides and min and max limits that are specific to this item.
     * Modifier lists may also be added to or deleted from an item using `UpdateItemModifierLists`.
     * @return Returns the List of CatalogItemModifierListInfo
     */
    @JsonGetter("modifier_list_info")
    public List<CatalogItemModifierListInfo> getModifierListInfo() {
        return modifierListInfo;
    }

    /**
     * Getter for Variations.
     * A list of CatalogObjects containing the `CatalogItemVariation`s for this item.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("variations")
    public List<CatalogObject> getVariations() {
        return variations;
    }

    /**
     * Getter for ProductType.
     * The type of a CatalogItem. Connect V2 only allows the creation of `REGULAR` or
     * `APPOINTMENTS_SERVICE` items.
     * @return Returns the String
     */
    @JsonGetter("product_type")
    public String getProductType() {
        return productType;
    }

    /**
     * Getter for SkipModifierScreen.
     * If `false`, the Square Point of Sale app will present the `CatalogItem`'s details screen
     * immediately, allowing the merchant to choose `CatalogModifier`s before adding the item to the
     * cart. This is the default behavior. If `true`, the Square Point of Sale app will immediately
     * add the item to the cart with the pre-selected modifiers, and merchants can edit modifiers by
     * drilling down onto the item's details. Third-party clients are encouraged to implement
     * similar behaviors.
     * @return Returns the Boolean
     */
    @JsonGetter("skip_modifier_screen")
    public Boolean getSkipModifierScreen() {
        return skipModifierScreen;
    }

    /**
     * Getter for ItemOptions.
     * List of item options IDs for this item. Used to manage and group item variations in a
     * specified order. Maximum: 6 item options.
     * @return Returns the List of CatalogItemOptionForItem
     */
    @JsonGetter("item_options")
    public List<CatalogItemOptionForItem> getItemOptions() {
        return itemOptions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, abbreviation, labelColor, availableOnline,
                availableForPickup, availableElectronically, categoryId, taxIds, modifierListInfo,
                variations, productType, skipModifierScreen, itemOptions);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItem)) {
            return false;
        }
        CatalogItem other = (CatalogItem) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(description, other.description)
            && Objects.equals(abbreviation, other.abbreviation)
            && Objects.equals(labelColor, other.labelColor)
            && Objects.equals(availableOnline, other.availableOnline)
            && Objects.equals(availableForPickup, other.availableForPickup)
            && Objects.equals(availableElectronically, other.availableElectronically)
            && Objects.equals(categoryId, other.categoryId)
            && Objects.equals(taxIds, other.taxIds)
            && Objects.equals(modifierListInfo, other.modifierListInfo)
            && Objects.equals(variations, other.variations)
            && Objects.equals(productType, other.productType)
            && Objects.equals(skipModifierScreen, other.skipModifierScreen)
            && Objects.equals(itemOptions, other.itemOptions);
    }

    /**
     * Converts this CatalogItem into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItem [" + "name=" + name + ", description=" + description + ", abbreviation="
                + abbreviation + ", labelColor=" + labelColor + ", availableOnline="
                + availableOnline + ", availableForPickup=" + availableForPickup
                + ", availableElectronically=" + availableElectronically + ", categoryId="
                + categoryId + ", taxIds=" + taxIds + ", modifierListInfo=" + modifierListInfo
                + ", variations=" + variations + ", productType=" + productType
                + ", skipModifierScreen=" + skipModifierScreen + ", itemOptions=" + itemOptions
                + "]";
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
     * Class to build instances of {@link CatalogItem}.
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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for abbreviation.
         * @param  abbreviation  String value for abbreviation.
         * @return Builder
         */
        public Builder abbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }

        /**
         * Setter for labelColor.
         * @param  labelColor  String value for labelColor.
         * @return Builder
         */
        public Builder labelColor(String labelColor) {
            this.labelColor = labelColor;
            return this;
        }

        /**
         * Setter for availableOnline.
         * @param  availableOnline  Boolean value for availableOnline.
         * @return Builder
         */
        public Builder availableOnline(Boolean availableOnline) {
            this.availableOnline = availableOnline;
            return this;
        }

        /**
         * Setter for availableForPickup.
         * @param  availableForPickup  Boolean value for availableForPickup.
         * @return Builder
         */
        public Builder availableForPickup(Boolean availableForPickup) {
            this.availableForPickup = availableForPickup;
            return this;
        }

        /**
         * Setter for availableElectronically.
         * @param  availableElectronically  Boolean value for availableElectronically.
         * @return Builder
         */
        public Builder availableElectronically(Boolean availableElectronically) {
            this.availableElectronically = availableElectronically;
            return this;
        }

        /**
         * Setter for categoryId.
         * @param  categoryId  String value for categoryId.
         * @return Builder
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        /**
         * Setter for taxIds.
         * @param  taxIds  List of String value for taxIds.
         * @return Builder
         */
        public Builder taxIds(List<String> taxIds) {
            this.taxIds = taxIds;
            return this;
        }

        /**
         * Setter for modifierListInfo.
         * @param  modifierListInfo  List of CatalogItemModifierListInfo value for modifierListInfo.
         * @return Builder
         */
        public Builder modifierListInfo(List<CatalogItemModifierListInfo> modifierListInfo) {
            this.modifierListInfo = modifierListInfo;
            return this;
        }

        /**
         * Setter for variations.
         * @param  variations  List of CatalogObject value for variations.
         * @return Builder
         */
        public Builder variations(List<CatalogObject> variations) {
            this.variations = variations;
            return this;
        }

        /**
         * Setter for productType.
         * @param  productType  String value for productType.
         * @return Builder
         */
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        /**
         * Setter for skipModifierScreen.
         * @param  skipModifierScreen  Boolean value for skipModifierScreen.
         * @return Builder
         */
        public Builder skipModifierScreen(Boolean skipModifierScreen) {
            this.skipModifierScreen = skipModifierScreen;
            return this;
        }

        /**
         * Setter for itemOptions.
         * @param  itemOptions  List of CatalogItemOptionForItem value for itemOptions.
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
            return new CatalogItem(name, description, abbreviation, labelColor, availableOnline,
                    availableForPickup, availableElectronically, categoryId, taxIds,
                    modifierListInfo, variations, productType, skipModifierScreen, itemOptions);
        }
    }
}
