package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItemOption type.
 */
public class CatalogItemOption {

    /**
     * Initialization constructor.
     * @param name
     * @param displayName
     * @param description
     * @param showColors
     * @param values
     * @param itemCount
     */
    @JsonCreator
    public CatalogItemOption(
            @JsonProperty("name") String name,
            @JsonProperty("display_name") String displayName,
            @JsonProperty("description") String description,
            @JsonProperty("show_colors") Boolean showColors,
            @JsonProperty("values") List<CatalogObject> values,
            @JsonProperty("item_count") Long itemCount) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.showColors = showColors;
        this.values = values;
        this.itemCount = itemCount;
    }

    private final String name;
    private final String displayName;
    private final String description;
    private final Boolean showColors;
    private final List<CatalogObject> values;
    private final Long itemCount;
    /**
     * Getter for Name.
     * The item option's display name for the seller. Must be unique across
     * all item options. Searchable.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for DisplayName.
     * The item option's display name for the customer. Searchable.
     */
    @JsonGetter("display_name")
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Getter for Description.
     * The item option's human-readable description. Displayed in the Square
     * Point of Sale app for the seller and in the Online Store or on receipts for
     * the buyer.
     */
    @JsonGetter("description")
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for ShowColors.
     * If true, display colors for entries in `values` when present.
     */
    @JsonGetter("show_colors")
    public Boolean getShowColors() {
        return this.showColors;
    }

    /**
     * Getter for Values.
     * A list of CatalogObjects containing the
     * `CatalogItemOptionValue`s for this item.
     */
    @JsonGetter("values")
    public List<CatalogObject> getValues() {
        return this.values;
    }

    /**
     * Getter for ItemCount.
     * The number of `CatalogItem`s currently associated
     * with this item option. Present only if the `include_counts` was specified
     * in the request. Any count over 100 will be returned as `100`.
     */
    @JsonGetter("item_count")
    public Long getItemCount() {
        return this.itemCount;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, description, showColors, values, itemCount);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItemOption)) {
            return false;
        }
        CatalogItemOption catalogItemOption = (CatalogItemOption) obj;
        return Objects.equals(name, catalogItemOption.name) &&
            Objects.equals(displayName, catalogItemOption.displayName) &&
            Objects.equals(description, catalogItemOption.description) &&
            Objects.equals(showColors, catalogItemOption.showColors) &&
            Objects.equals(values, catalogItemOption.values) &&
            Objects.equals(itemCount, catalogItemOption.itemCount);
    }

    /**
     * Builds a new {@link CatalogItemOption.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemOption.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .displayName(getDisplayName())
            .description(getDescription())
            .showColors(getShowColors())
            .values(getValues())
            .itemCount(getItemCount());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOption}
     */
    public static class Builder {
        private String name;
        private String displayName;
        private String description;
        private Boolean showColors;
        private List<CatalogObject> values;
        private Long itemCount;

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
         * Setter for displayName
         * @param displayName
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = displayName;
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
         * Setter for showColors
         * @param showColors
         * @return Builder
         */
        public Builder showColors(Boolean showColors) {
            this.showColors = showColors;
            return this;
        }
        /**
         * Setter for values
         * @param values
         * @return Builder
         */
        public Builder values(List<CatalogObject> values) {
            this.values = values;
            return this;
        }
        /**
         * Setter for itemCount
         * @param itemCount
         * @return Builder
         */
        public Builder itemCount(Long itemCount) {
            this.itemCount = itemCount;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemOption} object using the set fields.
         * @return {@link CatalogItemOption}
         */
        public CatalogItemOption build() {
            return new CatalogItemOption(name,
                displayName,
                description,
                showColors,
                values,
                itemCount);
        }
    }
}
