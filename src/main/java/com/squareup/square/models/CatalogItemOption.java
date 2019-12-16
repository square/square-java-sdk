package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogItemOption {

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

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, description, showColors, values, itemCount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogItemOption)) {
            return false;
        }
        CatalogItemOption catalogItemOption = (CatalogItemOption) o;
        return Objects.equals(name, catalogItemOption.name) &&
            Objects.equals(displayName, catalogItemOption.displayName) &&
            Objects.equals(description, catalogItemOption.description) &&
            Objects.equals(showColors, catalogItemOption.showColors) &&
            Objects.equals(values, catalogItemOption.values) &&
            Objects.equals(itemCount, catalogItemOption.itemCount);
    }

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

    public static class Builder {
        private String name;
        private String displayName;
        private String description;
        private Boolean showColors;
        private List<CatalogObject> values;
        private Long itemCount;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder displayName(String value) {
            displayName = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public Builder showColors(Boolean value) {
            showColors = value;
            return this;
        }
        public Builder values(List<CatalogObject> value) {
            values = value;
            return this;
        }
        public Builder itemCount(Long value) {
            itemCount = value;
            return this;
        }

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
