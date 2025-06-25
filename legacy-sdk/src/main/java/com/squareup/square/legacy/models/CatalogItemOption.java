package com.squareup.square.legacy.models;

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
 * This is a model class for CatalogItemOption type.
 */
public class CatalogItemOption {
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> displayName;
    private final OptionalNullable<String> description;
    private final OptionalNullable<Boolean> showColors;
    private final OptionalNullable<List<CatalogObject>> values;

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
        this.name = OptionalNullable.of(name);
        this.displayName = OptionalNullable.of(displayName);
        this.description = OptionalNullable.of(description);
        this.showColors = OptionalNullable.of(showColors);
        this.values = OptionalNullable.of(values);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  displayName  String value for displayName.
     * @param  description  String value for description.
     * @param  showColors  Boolean value for showColors.
     * @param  values  List of CatalogObject value for values.
     */
    protected CatalogItemOption(
            OptionalNullable<String> name,
            OptionalNullable<String> displayName,
            OptionalNullable<String> description,
            OptionalNullable<Boolean> showColors,
            OptionalNullable<List<CatalogObject>> values) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.showColors = showColors;
        this.values = values;
    }

    /**
     * Internal Getter for Name.
     * The item option's display name for the seller. Must be unique across all item options. This
     * is a searchable attribute for use in applicable query filters.
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
     * The item option's display name for the seller. Must be unique across all item options. This
     * is a searchable attribute for use in applicable query filters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for DisplayName.
     * The item option's display name for the customer. This is a searchable attribute for use in
     * applicable query filters.
     * @return Returns the Internal String
     */
    @JsonGetter("display_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDisplayName() {
        return this.displayName;
    }

    /**
     * Getter for DisplayName.
     * The item option's display name for the customer. This is a searchable attribute for use in
     * applicable query filters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDisplayName() {
        return OptionalNullable.getFrom(displayName);
    }

    /**
     * Internal Getter for Description.
     * The item option's human-readable description. Displayed in the Square Point of Sale app for
     * the seller and in the Online Store or on receipts for the buyer. This is a searchable
     * attribute for use in applicable query filters.
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
     * The item option's human-readable description. Displayed in the Square Point of Sale app for
     * the seller and in the Online Store or on receipts for the buyer. This is a searchable
     * attribute for use in applicable query filters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
    }

    /**
     * Internal Getter for ShowColors.
     * If true, display colors for entries in `values` when present.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("show_colors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetShowColors() {
        return this.showColors;
    }

    /**
     * Getter for ShowColors.
     * If true, display colors for entries in `values` when present.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getShowColors() {
        return OptionalNullable.getFrom(showColors);
    }

    /**
     * Internal Getter for Values.
     * A list of CatalogObjects containing the `CatalogItemOptionValue`s for this item.
     * @return Returns the Internal List of CatalogObject
     */
    @JsonGetter("values")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogObject>> internalGetValues() {
        return this.values;
    }

    /**
     * Getter for Values.
     * A list of CatalogObjects containing the `CatalogItemOptionValue`s for this item.
     * @return Returns the List of CatalogObject
     */
    @JsonIgnore
    public List<CatalogObject> getValues() {
        return OptionalNullable.getFrom(values);
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
        Builder builder = new Builder();
        builder.name = internalGetName();
        builder.displayName = internalGetDisplayName();
        builder.description = internalGetDescription();
        builder.showColors = internalGetShowColors();
        builder.values = internalGetValues();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOption}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private OptionalNullable<String> displayName;
        private OptionalNullable<String> description;
        private OptionalNullable<Boolean> showColors;
        private OptionalNullable<List<CatalogObject>> values;

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
         * Setter for displayName.
         * @param  displayName  String value for displayName.
         * @return Builder
         */
        public Builder displayName(String displayName) {
            this.displayName = OptionalNullable.of(displayName);
            return this;
        }

        /**
         * UnSetter for displayName.
         * @return Builder
         */
        public Builder unsetDisplayName() {
            displayName = null;
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
         * Setter for showColors.
         * @param  showColors  Boolean value for showColors.
         * @return Builder
         */
        public Builder showColors(Boolean showColors) {
            this.showColors = OptionalNullable.of(showColors);
            return this;
        }

        /**
         * UnSetter for showColors.
         * @return Builder
         */
        public Builder unsetShowColors() {
            showColors = null;
            return this;
        }

        /**
         * Setter for values.
         * @param  values  List of CatalogObject value for values.
         * @return Builder
         */
        public Builder values(List<CatalogObject> values) {
            this.values = OptionalNullable.of(values);
            return this;
        }

        /**
         * UnSetter for values.
         * @return Builder
         */
        public Builder unsetValues() {
            values = null;
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
