
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogItem type.
 */
public class CatalogItem {
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> description;
    private final OptionalNullable<String> abbreviation;
    private final OptionalNullable<String> labelColor;
    private final OptionalNullable<Boolean> availableOnline;
    private final OptionalNullable<Boolean> availableForPickup;
    private final OptionalNullable<Boolean> availableElectronically;
    private final OptionalNullable<String> categoryId;
    private final OptionalNullable<List<String>> taxIds;
    private final OptionalNullable<List<CatalogItemModifierListInfo>> modifierListInfo;
    private final OptionalNullable<List<CatalogObject>> variations;
    private final String productType;
    private final OptionalNullable<Boolean> skipModifierScreen;
    private final OptionalNullable<List<CatalogItemOptionForItem>> itemOptions;
    private final OptionalNullable<List<String>> imageIds;
    private final OptionalNullable<String> sortName;
    private final OptionalNullable<String> descriptionHtml;
    private final String descriptionPlaintext;

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
     * @param  imageIds  List of String value for imageIds.
     * @param  sortName  String value for sortName.
     * @param  descriptionHtml  String value for descriptionHtml.
     * @param  descriptionPlaintext  String value for descriptionPlaintext.
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
            @JsonProperty("item_options") List<CatalogItemOptionForItem> itemOptions,
            @JsonProperty("image_ids") List<String> imageIds,
            @JsonProperty("sort_name") String sortName,
            @JsonProperty("description_html") String descriptionHtml,
            @JsonProperty("description_plaintext") String descriptionPlaintext) {
        this.name = OptionalNullable.of(name);
        this.description = OptionalNullable.of(description);
        this.abbreviation = OptionalNullable.of(abbreviation);
        this.labelColor = OptionalNullable.of(labelColor);
        this.availableOnline = OptionalNullable.of(availableOnline);
        this.availableForPickup = OptionalNullable.of(availableForPickup);
        this.availableElectronically = OptionalNullable.of(availableElectronically);
        this.categoryId = OptionalNullable.of(categoryId);
        this.taxIds = OptionalNullable.of(taxIds);
        this.modifierListInfo = OptionalNullable.of(modifierListInfo);
        this.variations = OptionalNullable.of(variations);
        this.productType = productType;
        this.skipModifierScreen = OptionalNullable.of(skipModifierScreen);
        this.itemOptions = OptionalNullable.of(itemOptions);
        this.imageIds = OptionalNullable.of(imageIds);
        this.sortName = OptionalNullable.of(sortName);
        this.descriptionHtml = OptionalNullable.of(descriptionHtml);
        this.descriptionPlaintext = descriptionPlaintext;
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogItem(OptionalNullable<String> name, OptionalNullable<String> description,
            OptionalNullable<String> abbreviation, OptionalNullable<String> labelColor,
            OptionalNullable<Boolean> availableOnline, OptionalNullable<Boolean> availableForPickup,
            OptionalNullable<Boolean> availableElectronically, OptionalNullable<String> categoryId,
            OptionalNullable<List<String>> taxIds,
            OptionalNullable<List<CatalogItemModifierListInfo>> modifierListInfo,
            OptionalNullable<List<CatalogObject>> variations, String productType,
            OptionalNullable<Boolean> skipModifierScreen,
            OptionalNullable<List<CatalogItemOptionForItem>> itemOptions,
            OptionalNullable<List<String>> imageIds, OptionalNullable<String> sortName,
            OptionalNullable<String> descriptionHtml, String descriptionPlaintext) {
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
        this.imageIds = imageIds;
        this.sortName = sortName;
        this.descriptionHtml = descriptionHtml;
        this.descriptionPlaintext = descriptionPlaintext;
    }

    /**
     * Internal Getter for Name.
     * The item's name. This is a searchable attribute for use in applicable query filters, its
     * value must not be empty, and the length is of Unicode code points.
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
     * The item's name. This is a searchable attribute for use in applicable query filters, its
     * value must not be empty, and the length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Description.
     * The item's description. This is a searchable attribute for use in applicable query filters,
     * and its value length is of Unicode code points. Deprecated at 2022-07-20, this field is
     * planned to retire in 6 months. You should migrate to use `description_html` to set the
     * description of the [CatalogItem](entity:CatalogItem) instance. The `description` and
     * `description_html` field values are kept in sync. If you try to set the both fields, the
     * `description_html` text value overwrites the `description` value. Updates in one field are
     * also reflected in the other, except for when you use an early version before Square API
     * 2022-07-20 and `description_html` is set to blank, setting the `description` value to null
     * does not nullify `description_html`.
     * @return Returns the Internal String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDescription() {
        return this.description;
    }

    /**
     * Getter for Description.
     * The item's description. This is a searchable attribute for use in applicable query filters,
     * and its value length is of Unicode code points. Deprecated at 2022-07-20, this field is
     * planned to retire in 6 months. You should migrate to use `description_html` to set the
     * description of the [CatalogItem](entity:CatalogItem) instance. The `description` and
     * `description_html` field values are kept in sync. If you try to set the both fields, the
     * `description_html` text value overwrites the `description` value. Updates in one field are
     * also reflected in the other, except for when you use an early version before Square API
     * 2022-07-20 and `description_html` is set to blank, setting the `description` value to null
     * does not nullify `description_html`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
    }

    /**
     * Internal Getter for Abbreviation.
     * The text of the item's display label in the Square Point of Sale app. Only up to the first
     * five characters of the string are used. This attribute is searchable, and its value length is
     * of Unicode code points.
     * @return Returns the Internal String
     */
    @JsonGetter("abbreviation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAbbreviation() {
        return this.abbreviation;
    }

    /**
     * Getter for Abbreviation.
     * The text of the item's display label in the Square Point of Sale app. Only up to the first
     * five characters of the string are used. This attribute is searchable, and its value length is
     * of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAbbreviation() {
        return OptionalNullable.getFrom(abbreviation);
    }

    /**
     * Internal Getter for LabelColor.
     * The color of the item's display label in the Square Point of Sale app. This must be a valid
     * hex color code.
     * @return Returns the Internal String
     */
    @JsonGetter("label_color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLabelColor() {
        return this.labelColor;
    }

    /**
     * Getter for LabelColor.
     * The color of the item's display label in the Square Point of Sale app. This must be a valid
     * hex color code.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLabelColor() {
        return OptionalNullable.getFrom(labelColor);
    }

    /**
     * Internal Getter for AvailableOnline.
     * If `true`, the item can be added to shipping orders from the merchant's online store.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("available_online")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAvailableOnline() {
        return this.availableOnline;
    }

    /**
     * Getter for AvailableOnline.
     * If `true`, the item can be added to shipping orders from the merchant's online store.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAvailableOnline() {
        return OptionalNullable.getFrom(availableOnline);
    }

    /**
     * Internal Getter for AvailableForPickup.
     * If `true`, the item can be added to pickup orders from the merchant's online store.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("available_for_pickup")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAvailableForPickup() {
        return this.availableForPickup;
    }

    /**
     * Getter for AvailableForPickup.
     * If `true`, the item can be added to pickup orders from the merchant's online store.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAvailableForPickup() {
        return OptionalNullable.getFrom(availableForPickup);
    }

    /**
     * Internal Getter for AvailableElectronically.
     * If `true`, the item can be added to electronically fulfilled orders from the merchant's
     * online store.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("available_electronically")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAvailableElectronically() {
        return this.availableElectronically;
    }

    /**
     * Getter for AvailableElectronically.
     * If `true`, the item can be added to electronically fulfilled orders from the merchant's
     * online store.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAvailableElectronically() {
        return OptionalNullable.getFrom(availableElectronically);
    }

    /**
     * Internal Getter for CategoryId.
     * The ID of the item's category, if any.
     * @return Returns the Internal String
     */
    @JsonGetter("category_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCategoryId() {
        return this.categoryId;
    }

    /**
     * Getter for CategoryId.
     * The ID of the item's category, if any.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCategoryId() {
        return OptionalNullable.getFrom(categoryId);
    }

    /**
     * Internal Getter for TaxIds.
     * A set of IDs indicating the taxes enabled for this item. When updating an item, any taxes
     * listed here will be added to the item. Taxes may also be added to or deleted from an item
     * using `UpdateItemTaxes`.
     * @return Returns the Internal List of String
     */
    @JsonGetter("tax_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetTaxIds() {
        return this.taxIds;
    }

    /**
     * Getter for TaxIds.
     * A set of IDs indicating the taxes enabled for this item. When updating an item, any taxes
     * listed here will be added to the item. Taxes may also be added to or deleted from an item
     * using `UpdateItemTaxes`.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getTaxIds() {
        return OptionalNullable.getFrom(taxIds);
    }

    /**
     * Internal Getter for ModifierListInfo.
     * A set of `CatalogItemModifierListInfo` objects representing the modifier lists that apply to
     * this item, along with the overrides and min and max limits that are specific to this item.
     * Modifier lists may also be added to or deleted from an item using `UpdateItemModifierLists`.
     * @return Returns the Internal List of CatalogItemModifierListInfo
     */
    @JsonGetter("modifier_list_info")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogItemModifierListInfo>> internalGetModifierListInfo() {
        return this.modifierListInfo;
    }

    /**
     * Getter for ModifierListInfo.
     * A set of `CatalogItemModifierListInfo` objects representing the modifier lists that apply to
     * this item, along with the overrides and min and max limits that are specific to this item.
     * Modifier lists may also be added to or deleted from an item using `UpdateItemModifierLists`.
     * @return Returns the List of CatalogItemModifierListInfo
     */
    @JsonIgnore
    public List<CatalogItemModifierListInfo> getModifierListInfo() {
        return OptionalNullable.getFrom(modifierListInfo);
    }

    /**
     * Internal Getter for Variations.
     * A list of [CatalogItemVariation](entity:CatalogItemVariation) objects for this item. An item
     * must have at least one variation.
     * @return Returns the Internal List of CatalogObject
     */
    @JsonGetter("variations")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogObject>> internalGetVariations() {
        return this.variations;
    }

    /**
     * Getter for Variations.
     * A list of [CatalogItemVariation](entity:CatalogItemVariation) objects for this item. An item
     * must have at least one variation.
     * @return Returns the List of CatalogObject
     */
    @JsonIgnore
    public List<CatalogObject> getVariations() {
        return OptionalNullable.getFrom(variations);
    }

    /**
     * Getter for ProductType.
     * The type of a CatalogItem. Connect V2 only allows the creation of `REGULAR` or
     * `APPOINTMENTS_SERVICE` items.
     * @return Returns the String
     */
    @JsonGetter("product_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getProductType() {
        return productType;
    }

    /**
     * Internal Getter for SkipModifierScreen.
     * If `false`, the Square Point of Sale app will present the `CatalogItem`'s details screen
     * immediately, allowing the merchant to choose `CatalogModifier`s before adding the item to the
     * cart. This is the default behavior. If `true`, the Square Point of Sale app will immediately
     * add the item to the cart with the pre-selected modifiers, and merchants can edit modifiers by
     * drilling down onto the item's details. Third-party clients are encouraged to implement
     * similar behaviors.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("skip_modifier_screen")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSkipModifierScreen() {
        return this.skipModifierScreen;
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
    @JsonIgnore
    public Boolean getSkipModifierScreen() {
        return OptionalNullable.getFrom(skipModifierScreen);
    }

    /**
     * Internal Getter for ItemOptions.
     * List of item options IDs for this item. Used to manage and group item variations in a
     * specified order. Maximum: 6 item options.
     * @return Returns the Internal List of CatalogItemOptionForItem
     */
    @JsonGetter("item_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogItemOptionForItem>> internalGetItemOptions() {
        return this.itemOptions;
    }

    /**
     * Getter for ItemOptions.
     * List of item options IDs for this item. Used to manage and group item variations in a
     * specified order. Maximum: 6 item options.
     * @return Returns the List of CatalogItemOptionForItem
     */
    @JsonIgnore
    public List<CatalogItemOptionForItem> getItemOptions() {
        return OptionalNullable.getFrom(itemOptions);
    }

    /**
     * Internal Getter for ImageIds.
     * The IDs of images associated with this `CatalogItem` instance. These images will be shown to
     * customers in Square Online Store. The first image will show up as the icon for this item in
     * POS.
     * @return Returns the Internal List of String
     */
    @JsonGetter("image_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetImageIds() {
        return this.imageIds;
    }

    /**
     * Getter for ImageIds.
     * The IDs of images associated with this `CatalogItem` instance. These images will be shown to
     * customers in Square Online Store. The first image will show up as the icon for this item in
     * POS.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getImageIds() {
        return OptionalNullable.getFrom(imageIds);
    }

    /**
     * Internal Getter for SortName.
     * A name to sort the item by. If this name is unspecified, namely, the `sort_name` field is
     * absent, the regular `name` field is used for sorting. Its value must not be empty. It is
     * currently supported for sellers of the Japanese locale only.
     * @return Returns the Internal String
     */
    @JsonGetter("sort_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSortName() {
        return this.sortName;
    }

    /**
     * Getter for SortName.
     * A name to sort the item by. If this name is unspecified, namely, the `sort_name` field is
     * absent, the regular `name` field is used for sorting. Its value must not be empty. It is
     * currently supported for sellers of the Japanese locale only.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSortName() {
        return OptionalNullable.getFrom(sortName);
    }

    /**
     * Internal Getter for DescriptionHtml.
     * The item's description as expressed in valid HTML elements. The length of this field value,
     * including those of HTML tags, is of Unicode points. With application query filters, the text
     * values of the HTML elements and attributes are searchable. Invalid or unsupported HTML
     * elements or attributes are ignored. Supported HTML elements include: - `a`: Link. Supports
     * linking to website URLs, email address, and telephone numbers. - `b`, `strong`: Bold text -
     * `br`: Line break - `code`: Computer code - `div`: Section - `h1-h6`: Headings - `i`, `em`:
     * Italics - `li`: List element - `ol`: Numbered list - `p`: Paragraph - `ul`: Bullet list -
     * `u`: Underline Supported HTML attributes include: - `align`: Alignment of the text content -
     * `href`: Link destination - `rel`: Relationship between link's target and source - `target`:
     * Place to open the linked document
     * @return Returns the Internal String
     */
    @JsonGetter("description_html")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDescriptionHtml() {
        return this.descriptionHtml;
    }

    /**
     * Getter for DescriptionHtml.
     * The item's description as expressed in valid HTML elements. The length of this field value,
     * including those of HTML tags, is of Unicode points. With application query filters, the text
     * values of the HTML elements and attributes are searchable. Invalid or unsupported HTML
     * elements or attributes are ignored. Supported HTML elements include: - `a`: Link. Supports
     * linking to website URLs, email address, and telephone numbers. - `b`, `strong`: Bold text -
     * `br`: Line break - `code`: Computer code - `div`: Section - `h1-h6`: Headings - `i`, `em`:
     * Italics - `li`: List element - `ol`: Numbered list - `p`: Paragraph - `ul`: Bullet list -
     * `u`: Underline Supported HTML attributes include: - `align`: Alignment of the text content -
     * `href`: Link destination - `rel`: Relationship between link's target and source - `target`:
     * Place to open the linked document
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescriptionHtml() {
        return OptionalNullable.getFrom(descriptionHtml);
    }

    /**
     * Getter for DescriptionPlaintext.
     * A server-generated plaintext version of the `description_html` field, without formatting
     * tags.
     * @return Returns the String
     */
    @JsonGetter("description_plaintext")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescriptionPlaintext() {
        return descriptionPlaintext;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, abbreviation, labelColor, availableOnline,
                availableForPickup, availableElectronically, categoryId, taxIds, modifierListInfo,
                variations, productType, skipModifierScreen, itemOptions, imageIds, sortName,
                descriptionHtml, descriptionPlaintext);
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
            && Objects.equals(itemOptions, other.itemOptions)
            && Objects.equals(imageIds, other.imageIds)
            && Objects.equals(sortName, other.sortName)
            && Objects.equals(descriptionHtml, other.descriptionHtml)
            && Objects.equals(descriptionPlaintext, other.descriptionPlaintext);
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
                + ", imageIds=" + imageIds + ", sortName=" + sortName + ", descriptionHtml="
                + descriptionHtml + ", descriptionPlaintext=" + descriptionPlaintext + "]";
    }

    /**
     * Builds a new {@link CatalogItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .productType(getProductType())
                .descriptionPlaintext(getDescriptionPlaintext());
        builder.name = internalGetName();
        builder.description = internalGetDescription();
        builder.abbreviation = internalGetAbbreviation();
        builder.labelColor = internalGetLabelColor();
        builder.availableOnline = internalGetAvailableOnline();
        builder.availableForPickup = internalGetAvailableForPickup();
        builder.availableElectronically = internalGetAvailableElectronically();
        builder.categoryId = internalGetCategoryId();
        builder.taxIds = internalGetTaxIds();
        builder.modifierListInfo = internalGetModifierListInfo();
        builder.variations = internalGetVariations();
        builder.skipModifierScreen = internalGetSkipModifierScreen();
        builder.itemOptions = internalGetItemOptions();
        builder.imageIds = internalGetImageIds();
        builder.sortName = internalGetSortName();
        builder.descriptionHtml = internalGetDescriptionHtml();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItem}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<String> description;
        private OptionalNullable<String> abbreviation;
        private OptionalNullable<String> labelColor;
        private OptionalNullable<Boolean> availableOnline;
        private OptionalNullable<Boolean> availableForPickup;
        private OptionalNullable<Boolean> availableElectronically;
        private OptionalNullable<String> categoryId;
        private OptionalNullable<List<String>> taxIds;
        private OptionalNullable<List<CatalogItemModifierListInfo>> modifierListInfo;
        private OptionalNullable<List<CatalogObject>> variations;
        private String productType;
        private OptionalNullable<Boolean> skipModifierScreen;
        private OptionalNullable<List<CatalogItemOptionForItem>> itemOptions;
        private OptionalNullable<List<String>> imageIds;
        private OptionalNullable<String> sortName;
        private OptionalNullable<String> descriptionHtml;
        private String descriptionPlaintext;



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
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = OptionalNullable.of(description);
            return this;
        }

        /**
         * UnSetter for description.
         * @return Builder
         */
        public Builder unsetDescription() {
            description = null;
            return this;
        }

        /**
         * Setter for abbreviation.
         * @param  abbreviation  String value for abbreviation.
         * @return Builder
         */
        public Builder abbreviation(String abbreviation) {
            this.abbreviation = OptionalNullable.of(abbreviation);
            return this;
        }

        /**
         * UnSetter for abbreviation.
         * @return Builder
         */
        public Builder unsetAbbreviation() {
            abbreviation = null;
            return this;
        }

        /**
         * Setter for labelColor.
         * @param  labelColor  String value for labelColor.
         * @return Builder
         */
        public Builder labelColor(String labelColor) {
            this.labelColor = OptionalNullable.of(labelColor);
            return this;
        }

        /**
         * UnSetter for labelColor.
         * @return Builder
         */
        public Builder unsetLabelColor() {
            labelColor = null;
            return this;
        }

        /**
         * Setter for availableOnline.
         * @param  availableOnline  Boolean value for availableOnline.
         * @return Builder
         */
        public Builder availableOnline(Boolean availableOnline) {
            this.availableOnline = OptionalNullable.of(availableOnline);
            return this;
        }

        /**
         * UnSetter for availableOnline.
         * @return Builder
         */
        public Builder unsetAvailableOnline() {
            availableOnline = null;
            return this;
        }

        /**
         * Setter for availableForPickup.
         * @param  availableForPickup  Boolean value for availableForPickup.
         * @return Builder
         */
        public Builder availableForPickup(Boolean availableForPickup) {
            this.availableForPickup = OptionalNullable.of(availableForPickup);
            return this;
        }

        /**
         * UnSetter for availableForPickup.
         * @return Builder
         */
        public Builder unsetAvailableForPickup() {
            availableForPickup = null;
            return this;
        }

        /**
         * Setter for availableElectronically.
         * @param  availableElectronically  Boolean value for availableElectronically.
         * @return Builder
         */
        public Builder availableElectronically(Boolean availableElectronically) {
            this.availableElectronically = OptionalNullable.of(availableElectronically);
            return this;
        }

        /**
         * UnSetter for availableElectronically.
         * @return Builder
         */
        public Builder unsetAvailableElectronically() {
            availableElectronically = null;
            return this;
        }

        /**
         * Setter for categoryId.
         * @param  categoryId  String value for categoryId.
         * @return Builder
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = OptionalNullable.of(categoryId);
            return this;
        }

        /**
         * UnSetter for categoryId.
         * @return Builder
         */
        public Builder unsetCategoryId() {
            categoryId = null;
            return this;
        }

        /**
         * Setter for taxIds.
         * @param  taxIds  List of String value for taxIds.
         * @return Builder
         */
        public Builder taxIds(List<String> taxIds) {
            this.taxIds = OptionalNullable.of(taxIds);
            return this;
        }

        /**
         * UnSetter for taxIds.
         * @return Builder
         */
        public Builder unsetTaxIds() {
            taxIds = null;
            return this;
        }

        /**
         * Setter for modifierListInfo.
         * @param  modifierListInfo  List of CatalogItemModifierListInfo value for modifierListInfo.
         * @return Builder
         */
        public Builder modifierListInfo(List<CatalogItemModifierListInfo> modifierListInfo) {
            this.modifierListInfo = OptionalNullable.of(modifierListInfo);
            return this;
        }

        /**
         * UnSetter for modifierListInfo.
         * @return Builder
         */
        public Builder unsetModifierListInfo() {
            modifierListInfo = null;
            return this;
        }

        /**
         * Setter for variations.
         * @param  variations  List of CatalogObject value for variations.
         * @return Builder
         */
        public Builder variations(List<CatalogObject> variations) {
            this.variations = OptionalNullable.of(variations);
            return this;
        }

        /**
         * UnSetter for variations.
         * @return Builder
         */
        public Builder unsetVariations() {
            variations = null;
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
            this.skipModifierScreen = OptionalNullable.of(skipModifierScreen);
            return this;
        }

        /**
         * UnSetter for skipModifierScreen.
         * @return Builder
         */
        public Builder unsetSkipModifierScreen() {
            skipModifierScreen = null;
            return this;
        }

        /**
         * Setter for itemOptions.
         * @param  itemOptions  List of CatalogItemOptionForItem value for itemOptions.
         * @return Builder
         */
        public Builder itemOptions(List<CatalogItemOptionForItem> itemOptions) {
            this.itemOptions = OptionalNullable.of(itemOptions);
            return this;
        }

        /**
         * UnSetter for itemOptions.
         * @return Builder
         */
        public Builder unsetItemOptions() {
            itemOptions = null;
            return this;
        }

        /**
         * Setter for imageIds.
         * @param  imageIds  List of String value for imageIds.
         * @return Builder
         */
        public Builder imageIds(List<String> imageIds) {
            this.imageIds = OptionalNullable.of(imageIds);
            return this;
        }

        /**
         * UnSetter for imageIds.
         * @return Builder
         */
        public Builder unsetImageIds() {
            imageIds = null;
            return this;
        }

        /**
         * Setter for sortName.
         * @param  sortName  String value for sortName.
         * @return Builder
         */
        public Builder sortName(String sortName) {
            this.sortName = OptionalNullable.of(sortName);
            return this;
        }

        /**
         * UnSetter for sortName.
         * @return Builder
         */
        public Builder unsetSortName() {
            sortName = null;
            return this;
        }

        /**
         * Setter for descriptionHtml.
         * @param  descriptionHtml  String value for descriptionHtml.
         * @return Builder
         */
        public Builder descriptionHtml(String descriptionHtml) {
            this.descriptionHtml = OptionalNullable.of(descriptionHtml);
            return this;
        }

        /**
         * UnSetter for descriptionHtml.
         * @return Builder
         */
        public Builder unsetDescriptionHtml() {
            descriptionHtml = null;
            return this;
        }

        /**
         * Setter for descriptionPlaintext.
         * @param  descriptionPlaintext  String value for descriptionPlaintext.
         * @return Builder
         */
        public Builder descriptionPlaintext(String descriptionPlaintext) {
            this.descriptionPlaintext = descriptionPlaintext;
            return this;
        }

        /**
         * Builds a new {@link CatalogItem} object using the set fields.
         * @return {@link CatalogItem}
         */
        public CatalogItem build() {
            return new CatalogItem(name, description, abbreviation, labelColor, availableOnline,
                    availableForPickup, availableElectronically, categoryId, taxIds,
                    modifierListInfo, variations, productType, skipModifierScreen, itemOptions,
                    imageIds, sortName, descriptionHtml, descriptionPlaintext);
        }
    }
}
