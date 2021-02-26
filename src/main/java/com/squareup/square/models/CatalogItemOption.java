
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogItemOption type.
 */
public class CatalogItemOption {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String displayName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean showColors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogObject> values;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  displayName  String value for displayName.
     * @param  description  String value for description.
     * @param  showColors  Boolean value for showColors.
     * @param  values  List of CatalogObject value for values.
     */
    @JsonCreator
    public CatalogItemOption(
            @JsonProperty("name") String name,
            @JsonProperty("display_name") String displayName,
            @JsonProperty("description") String description,
            @JsonProperty("show_colors") Boolean showColors,
            @JsonProperty("values") List<CatalogObject> values) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.showColors = showColors;
        this.values = values;
    }

    /**
     * Getter for Name.
     * The item option's display name for the seller. Must be unique across all item options. This
     * is a searchable attribute for use in applicable query filters.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for DisplayName.
     * The item option's display name for the customer. This is a searchable attribute for use in
     * applicable query filters.
     * @return Returns the String
     */
    @JsonGetter("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Getter for Description.
     * The item option's human-readable description. Displayed in the Square Point of Sale app for
     * the seller and in the Online Store or on receipts for the buyer. This is a searchable
     * attribute for use in applicable query filters.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    /**
     * Getter for ShowColors.
     * If true, display colors for entries in `values` when present.
     * @return Returns the Boolean
     */
    @JsonGetter("show_colors")
    public Boolean getShowColors() {
        return showColors;
    }

    /**
     * Getter for Values.
     * A list of CatalogObjects containing the `CatalogItemOptionValue`s for this item.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("values")
    public List<CatalogObject> getValues() {
        return values;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, description, showColors, values);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemOption)) {
            return false;
        }
        CatalogItemOption other = (CatalogItemOption) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(displayName, other.displayName)
            && Objects.equals(description, other.description)
            && Objects.equals(showColors, other.showColors)
            && Objects.equals(values, other.values);
    }

    /**
     * Converts this CatalogItemOption into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemOption [" + "name=" + name + ", displayName=" + displayName
                + ", description=" + description + ", showColors=" + showColors + ", values="
                + values + "]";
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
                .values(getValues());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOption}.
     */
    public static class Builder {
        private String name;
        private String displayName;
        private String description;
        private Boolean showColors;
        private List<CatalogObject> values;



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
         * Setter for displayName.
         * @param  displayName  String value for displayName.
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = displayName;
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
         * Setter for showColors.
         * @param  showColors  Boolean value for showColors.
         * @return Builder
         */
        public Builder showColors(Boolean showColors) {
            this.showColors = showColors;
            return this;
        }

        /**
         * Setter for values.
         * @param  values  List of CatalogObject value for values.
         * @return Builder
         */
        public Builder values(List<CatalogObject> values) {
            this.values = values;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemOption} object using the set fields.
         * @return {@link CatalogItemOption}
         */
        public CatalogItemOption build() {
            return new CatalogItemOption(name, displayName, description, showColors, values);
        }
    }
}
