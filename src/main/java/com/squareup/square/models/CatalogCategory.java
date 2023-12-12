
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
 * This is a model class for CatalogCategory type.
 */
public class CatalogCategory {
    private final OptionalNullable<String> name;
    private final OptionalNullable<List<String>> imageIds;
    private final String categoryType;
    private final CatalogObjectCategory parentCategory;
    private final OptionalNullable<Boolean> isTopLevel;
    private final OptionalNullable<List<String>> channels;
    private final OptionalNullable<List<String>> availabilityPeriodIds;
    private final OptionalNullable<Boolean> onlineVisibility;
    private final String rootCategory;
    private final CatalogEcomSeoData ecomSeoData;
    private final OptionalNullable<List<CategoryPathToRootNode>> pathToRoot;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  imageIds  List of String value for imageIds.
     * @param  categoryType  String value for categoryType.
     * @param  parentCategory  CatalogObjectCategory value for parentCategory.
     * @param  isTopLevel  Boolean value for isTopLevel.
     * @param  channels  List of String value for channels.
     * @param  availabilityPeriodIds  List of String value for availabilityPeriodIds.
     * @param  onlineVisibility  Boolean value for onlineVisibility.
     * @param  rootCategory  String value for rootCategory.
     * @param  ecomSeoData  CatalogEcomSeoData value for ecomSeoData.
     * @param  pathToRoot  List of CategoryPathToRootNode value for pathToRoot.
     */
    @JsonCreator
    public CatalogCategory(
            @JsonProperty("name") String name,
            @JsonProperty("image_ids") List<String> imageIds,
            @JsonProperty("category_type") String categoryType,
            @JsonProperty("parent_category") CatalogObjectCategory parentCategory,
            @JsonProperty("is_top_level") Boolean isTopLevel,
            @JsonProperty("channels") List<String> channels,
            @JsonProperty("availability_period_ids") List<String> availabilityPeriodIds,
            @JsonProperty("online_visibility") Boolean onlineVisibility,
            @JsonProperty("root_category") String rootCategory,
            @JsonProperty("ecom_seo_data") CatalogEcomSeoData ecomSeoData,
            @JsonProperty("path_to_root") List<CategoryPathToRootNode> pathToRoot) {
        this.name = OptionalNullable.of(name);
        this.imageIds = OptionalNullable.of(imageIds);
        this.categoryType = categoryType;
        this.parentCategory = parentCategory;
        this.isTopLevel = OptionalNullable.of(isTopLevel);
        this.channels = OptionalNullable.of(channels);
        this.availabilityPeriodIds = OptionalNullable.of(availabilityPeriodIds);
        this.onlineVisibility = OptionalNullable.of(onlineVisibility);
        this.rootCategory = rootCategory;
        this.ecomSeoData = ecomSeoData;
        this.pathToRoot = OptionalNullable.of(pathToRoot);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  imageIds  List of String value for imageIds.
     * @param  categoryType  String value for categoryType.
     * @param  parentCategory  CatalogObjectCategory value for parentCategory.
     * @param  isTopLevel  Boolean value for isTopLevel.
     * @param  channels  List of String value for channels.
     * @param  availabilityPeriodIds  List of String value for availabilityPeriodIds.
     * @param  onlineVisibility  Boolean value for onlineVisibility.
     * @param  rootCategory  String value for rootCategory.
     * @param  ecomSeoData  CatalogEcomSeoData value for ecomSeoData.
     * @param  pathToRoot  List of CategoryPathToRootNode value for pathToRoot.
     */

    protected CatalogCategory(OptionalNullable<String> name,
            OptionalNullable<List<String>> imageIds, String categoryType,
            CatalogObjectCategory parentCategory, OptionalNullable<Boolean> isTopLevel,
            OptionalNullable<List<String>> channels,
            OptionalNullable<List<String>> availabilityPeriodIds,
            OptionalNullable<Boolean> onlineVisibility, String rootCategory,
            CatalogEcomSeoData ecomSeoData,
            OptionalNullable<List<CategoryPathToRootNode>> pathToRoot) {
        this.name = name;
        this.imageIds = imageIds;
        this.categoryType = categoryType;
        this.parentCategory = parentCategory;
        this.isTopLevel = isTopLevel;
        this.channels = channels;
        this.availabilityPeriodIds = availabilityPeriodIds;
        this.onlineVisibility = onlineVisibility;
        this.rootCategory = rootCategory;
        this.ecomSeoData = ecomSeoData;
        this.pathToRoot = pathToRoot;
    }

    /**
     * Internal Getter for Name.
     * The category name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
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
     * The category name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for ImageIds.
     * The IDs of images associated with this `CatalogCategory` instance. Currently these images are
     * not displayed by Square, but are free to be displayed in 3rd party applications.
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
     * The IDs of images associated with this `CatalogCategory` instance. Currently these images are
     * not displayed by Square, but are free to be displayed in 3rd party applications.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getImageIds() {
        return OptionalNullable.getFrom(imageIds);
    }

    /**
     * Getter for CategoryType.
     * Indicates the type of a category.
     * @return Returns the String
     */
    @JsonGetter("category_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * Getter for ParentCategory.
     * A category that can be assigned to an item or a parent category that can be assigned to
     * another category. For example, a clothing category can be assigned to a t-shirt item or be
     * made as the parent category to the pants category.
     * @return Returns the CatalogObjectCategory
     */
    @JsonGetter("parent_category")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogObjectCategory getParentCategory() {
        return parentCategory;
    }

    /**
     * Internal Getter for IsTopLevel.
     * Indicates whether a category is a top level category, which does not have any
     * parent_category.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_top_level")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsTopLevel() {
        return this.isTopLevel;
    }

    /**
     * Getter for IsTopLevel.
     * Indicates whether a category is a top level category, which does not have any
     * parent_category.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsTopLevel() {
        return OptionalNullable.getFrom(isTopLevel);
    }

    /**
     * Internal Getter for Channels.
     * A list of IDs representing channels, such as a Square Online site, where the category can be
     * made visible.
     * @return Returns the Internal List of String
     */
    @JsonGetter("channels")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetChannels() {
        return this.channels;
    }

    /**
     * Getter for Channels.
     * A list of IDs representing channels, such as a Square Online site, where the category can be
     * made visible.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getChannels() {
        return OptionalNullable.getFrom(channels);
    }

    /**
     * Internal Getter for AvailabilityPeriodIds.
     * The IDs of the `CatalogAvailabilityPeriod` objects associated with the category.
     * @return Returns the Internal List of String
     */
    @JsonGetter("availability_period_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetAvailabilityPeriodIds() {
        return this.availabilityPeriodIds;
    }

    /**
     * Getter for AvailabilityPeriodIds.
     * The IDs of the `CatalogAvailabilityPeriod` objects associated with the category.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getAvailabilityPeriodIds() {
        return OptionalNullable.getFrom(availabilityPeriodIds);
    }

    /**
     * Internal Getter for OnlineVisibility.
     * Indicates whether the category is visible (`true`) or hidden (`false`) on all of the seller's
     * Square Online sites.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("online_visibility")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetOnlineVisibility() {
        return this.onlineVisibility;
    }

    /**
     * Getter for OnlineVisibility.
     * Indicates whether the category is visible (`true`) or hidden (`false`) on all of the seller's
     * Square Online sites.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getOnlineVisibility() {
        return OptionalNullable.getFrom(onlineVisibility);
    }

    /**
     * Getter for RootCategory.
     * The top-level category in a category hierarchy.
     * @return Returns the String
     */
    @JsonGetter("root_category")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRootCategory() {
        return rootCategory;
    }

    /**
     * Getter for EcomSeoData.
     * SEO data for for a seller's Square Online store.
     * @return Returns the CatalogEcomSeoData
     */
    @JsonGetter("ecom_seo_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogEcomSeoData getEcomSeoData() {
        return ecomSeoData;
    }

    /**
     * Internal Getter for PathToRoot.
     * The path from the category to its root category. The first node of the path is the parent of
     * the category and the last is the root category. The path is empty if the category is a root
     * category.
     * @return Returns the Internal List of CategoryPathToRootNode
     */
    @JsonGetter("path_to_root")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CategoryPathToRootNode>> internalGetPathToRoot() {
        return this.pathToRoot;
    }

    /**
     * Getter for PathToRoot.
     * The path from the category to its root category. The first node of the path is the parent of
     * the category and the last is the root category. The path is empty if the category is a root
     * category.
     * @return Returns the List of CategoryPathToRootNode
     */
    @JsonIgnore
    public List<CategoryPathToRootNode> getPathToRoot() {
        return OptionalNullable.getFrom(pathToRoot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageIds, categoryType, parentCategory, isTopLevel, channels,
                availabilityPeriodIds, onlineVisibility, rootCategory, ecomSeoData, pathToRoot);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogCategory)) {
            return false;
        }
        CatalogCategory other = (CatalogCategory) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(imageIds, other.imageIds)
            && Objects.equals(categoryType, other.categoryType)
            && Objects.equals(parentCategory, other.parentCategory)
            && Objects.equals(isTopLevel, other.isTopLevel)
            && Objects.equals(channels, other.channels)
            && Objects.equals(availabilityPeriodIds, other.availabilityPeriodIds)
            && Objects.equals(onlineVisibility, other.onlineVisibility)
            && Objects.equals(rootCategory, other.rootCategory)
            && Objects.equals(ecomSeoData, other.ecomSeoData)
            && Objects.equals(pathToRoot, other.pathToRoot);
    }

    /**
     * Converts this CatalogCategory into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogCategory [" + "name=" + name + ", imageIds=" + imageIds + ", categoryType="
                + categoryType + ", parentCategory=" + parentCategory + ", isTopLevel=" + isTopLevel
                + ", channels=" + channels + ", availabilityPeriodIds=" + availabilityPeriodIds
                + ", onlineVisibility=" + onlineVisibility + ", rootCategory=" + rootCategory
                + ", ecomSeoData=" + ecomSeoData + ", pathToRoot=" + pathToRoot + "]";
    }

    /**
     * Builds a new {@link CatalogCategory.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCategory.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .categoryType(getCategoryType())
                .parentCategory(getParentCategory())
                .rootCategory(getRootCategory())
                .ecomSeoData(getEcomSeoData());
        builder.name = internalGetName();
        builder.imageIds = internalGetImageIds();
        builder.isTopLevel = internalGetIsTopLevel();
        builder.channels = internalGetChannels();
        builder.availabilityPeriodIds = internalGetAvailabilityPeriodIds();
        builder.onlineVisibility = internalGetOnlineVisibility();
        builder.pathToRoot = internalGetPathToRoot();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogCategory}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<List<String>> imageIds;
        private String categoryType;
        private CatalogObjectCategory parentCategory;
        private OptionalNullable<Boolean> isTopLevel;
        private OptionalNullable<List<String>> channels;
        private OptionalNullable<List<String>> availabilityPeriodIds;
        private OptionalNullable<Boolean> onlineVisibility;
        private String rootCategory;
        private CatalogEcomSeoData ecomSeoData;
        private OptionalNullable<List<CategoryPathToRootNode>> pathToRoot;



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
         * Setter for categoryType.
         * @param  categoryType  String value for categoryType.
         * @return Builder
         */
        public Builder categoryType(String categoryType) {
            this.categoryType = categoryType;
            return this;
        }

        /**
         * Setter for parentCategory.
         * @param  parentCategory  CatalogObjectCategory value for parentCategory.
         * @return Builder
         */
        public Builder parentCategory(CatalogObjectCategory parentCategory) {
            this.parentCategory = parentCategory;
            return this;
        }

        /**
         * Setter for isTopLevel.
         * @param  isTopLevel  Boolean value for isTopLevel.
         * @return Builder
         */
        public Builder isTopLevel(Boolean isTopLevel) {
            this.isTopLevel = OptionalNullable.of(isTopLevel);
            return this;
        }

        /**
         * UnSetter for isTopLevel.
         * @return Builder
         */
        public Builder unsetIsTopLevel() {
            isTopLevel = null;
            return this;
        }

        /**
         * Setter for channels.
         * @param  channels  List of String value for channels.
         * @return Builder
         */
        public Builder channels(List<String> channels) {
            this.channels = OptionalNullable.of(channels);
            return this;
        }

        /**
         * UnSetter for channels.
         * @return Builder
         */
        public Builder unsetChannels() {
            channels = null;
            return this;
        }

        /**
         * Setter for availabilityPeriodIds.
         * @param  availabilityPeriodIds  List of String value for availabilityPeriodIds.
         * @return Builder
         */
        public Builder availabilityPeriodIds(List<String> availabilityPeriodIds) {
            this.availabilityPeriodIds = OptionalNullable.of(availabilityPeriodIds);
            return this;
        }

        /**
         * UnSetter for availabilityPeriodIds.
         * @return Builder
         */
        public Builder unsetAvailabilityPeriodIds() {
            availabilityPeriodIds = null;
            return this;
        }

        /**
         * Setter for onlineVisibility.
         * @param  onlineVisibility  Boolean value for onlineVisibility.
         * @return Builder
         */
        public Builder onlineVisibility(Boolean onlineVisibility) {
            this.onlineVisibility = OptionalNullable.of(onlineVisibility);
            return this;
        }

        /**
         * UnSetter for onlineVisibility.
         * @return Builder
         */
        public Builder unsetOnlineVisibility() {
            onlineVisibility = null;
            return this;
        }

        /**
         * Setter for rootCategory.
         * @param  rootCategory  String value for rootCategory.
         * @return Builder
         */
        public Builder rootCategory(String rootCategory) {
            this.rootCategory = rootCategory;
            return this;
        }

        /**
         * Setter for ecomSeoData.
         * @param  ecomSeoData  CatalogEcomSeoData value for ecomSeoData.
         * @return Builder
         */
        public Builder ecomSeoData(CatalogEcomSeoData ecomSeoData) {
            this.ecomSeoData = ecomSeoData;
            return this;
        }

        /**
         * Setter for pathToRoot.
         * @param  pathToRoot  List of CategoryPathToRootNode value for pathToRoot.
         * @return Builder
         */
        public Builder pathToRoot(List<CategoryPathToRootNode> pathToRoot) {
            this.pathToRoot = OptionalNullable.of(pathToRoot);
            return this;
        }

        /**
         * UnSetter for pathToRoot.
         * @return Builder
         */
        public Builder unsetPathToRoot() {
            pathToRoot = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogCategory} object using the set fields.
         * @return {@link CatalogCategory}
         */
        public CatalogCategory build() {
            return new CatalogCategory(name, imageIds, categoryType, parentCategory, isTopLevel,
                    channels, availabilityPeriodIds, onlineVisibility, rootCategory, ecomSeoData,
                    pathToRoot);
        }
    }
}
