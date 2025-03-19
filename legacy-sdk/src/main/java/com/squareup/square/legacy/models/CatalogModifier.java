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
 * This is a model class for CatalogModifier type.
 */
public class CatalogModifier {
    private final OptionalNullable<String> name;
    private final Money priceMoney;
    private final OptionalNullable<Integer> ordinal;
    private final OptionalNullable<String> modifierListId;
    private final OptionalNullable<List<ModifierLocationOverrides>> locationOverrides;
    private final OptionalNullable<String> imageId;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  priceMoney  Money value for priceMoney.
     * @param  ordinal  Integer value for ordinal.
     * @param  modifierListId  String value for modifierListId.
     * @param  locationOverrides  List of ModifierLocationOverrides value for locationOverrides.
     * @param  imageId  String value for imageId.
     */
    @JsonCreator
    public CatalogModifier(
            @JsonProperty("name") String name,
            @JsonProperty("price_money") Money priceMoney,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("modifier_list_id") String modifierListId,
            @JsonProperty("location_overrides") List<ModifierLocationOverrides> locationOverrides,
            @JsonProperty("image_id") String imageId) {
        this.name = OptionalNullable.of(name);
        this.priceMoney = priceMoney;
        this.ordinal = OptionalNullable.of(ordinal);
        this.modifierListId = OptionalNullable.of(modifierListId);
        this.locationOverrides = OptionalNullable.of(locationOverrides);
        this.imageId = OptionalNullable.of(imageId);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  priceMoney  Money value for priceMoney.
     * @param  ordinal  Integer value for ordinal.
     * @param  modifierListId  String value for modifierListId.
     * @param  locationOverrides  List of ModifierLocationOverrides value for locationOverrides.
     * @param  imageId  String value for imageId.
     */
    protected CatalogModifier(
            OptionalNullable<String> name,
            Money priceMoney,
            OptionalNullable<Integer> ordinal,
            OptionalNullable<String> modifierListId,
            OptionalNullable<List<ModifierLocationOverrides>> locationOverrides,
            OptionalNullable<String> imageId) {
        this.name = name;
        this.priceMoney = priceMoney;
        this.ordinal = ordinal;
        this.modifierListId = modifierListId;
        this.locationOverrides = locationOverrides;
        this.imageId = imageId;
    }

    /**
     * Internal Getter for Name.
     * The modifier name. This is a searchable attribute for use in applicable query filters, and
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
     * The modifier name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for PriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("price_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getPriceMoney() {
        return priceMoney;
    }

    /**
     * Internal Getter for Ordinal.
     * Determines where this `CatalogModifier` appears in the `CatalogModifierList`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for Ordinal.
     * Determines where this `CatalogModifier` appears in the `CatalogModifierList`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getOrdinal() {
        return OptionalNullable.getFrom(ordinal);
    }

    /**
     * Internal Getter for ModifierListId.
     * The ID of the `CatalogModifierList` associated with this modifier.
     * @return Returns the Internal String
     */
    @JsonGetter("modifier_list_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetModifierListId() {
        return this.modifierListId;
    }

    /**
     * Getter for ModifierListId.
     * The ID of the `CatalogModifierList` associated with this modifier.
     * @return Returns the String
     */
    @JsonIgnore
    public String getModifierListId() {
        return OptionalNullable.getFrom(modifierListId);
    }

    /**
     * Internal Getter for LocationOverrides.
     * Location-specific price overrides.
     * @return Returns the Internal List of ModifierLocationOverrides
     */
    @JsonGetter("location_overrides")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<ModifierLocationOverrides>> internalGetLocationOverrides() {
        return this.locationOverrides;
    }

    /**
     * Getter for LocationOverrides.
     * Location-specific price overrides.
     * @return Returns the List of ModifierLocationOverrides
     */
    @JsonIgnore
    public List<ModifierLocationOverrides> getLocationOverrides() {
        return OptionalNullable.getFrom(locationOverrides);
    }

    /**
     * Internal Getter for ImageId.
     * The ID of the image associated with this `CatalogModifier` instance. Currently this image is
     * not displayed by Square, but is free to be displayed in 3rd party applications.
     * @return Returns the Internal String
     */
    @JsonGetter("image_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetImageId() {
        return this.imageId;
    }

    /**
     * Getter for ImageId.
     * The ID of the image associated with this `CatalogModifier` instance. Currently this image is
     * not displayed by Square, but is free to be displayed in 3rd party applications.
     * @return Returns the String
     */
    @JsonIgnore
    public String getImageId() {
        return OptionalNullable.getFrom(imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priceMoney, ordinal, modifierListId, locationOverrides, imageId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogModifier)) {
            return false;
        }
        CatalogModifier other = (CatalogModifier) obj;
        return Objects.equals(name, other.name)
                && Objects.equals(priceMoney, other.priceMoney)
                && Objects.equals(ordinal, other.ordinal)
                && Objects.equals(modifierListId, other.modifierListId)
                && Objects.equals(locationOverrides, other.locationOverrides)
                && Objects.equals(imageId, other.imageId);
    }

    /**
     * Converts this CatalogModifier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogModifier [" + "name=" + name + ", priceMoney=" + priceMoney + ", ordinal="
                + ordinal + ", modifierListId=" + modifierListId + ", locationOverrides="
                + locationOverrides + ", imageId=" + imageId + "]";
    }

    /**
     * Builds a new {@link CatalogModifier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogModifier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().priceMoney(getPriceMoney());
        builder.name = internalGetName();
        builder.ordinal = internalGetOrdinal();
        builder.modifierListId = internalGetModifierListId();
        builder.locationOverrides = internalGetLocationOverrides();
        builder.imageId = internalGetImageId();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogModifier}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private Money priceMoney;
        private OptionalNullable<Integer> ordinal;
        private OptionalNullable<String> modifierListId;
        private OptionalNullable<List<ModifierLocationOverrides>> locationOverrides;
        private OptionalNullable<String> imageId;

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
         * Setter for priceMoney.
         * @param  priceMoney  Money value for priceMoney.
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = OptionalNullable.of(ordinal);
            return this;
        }

        /**
         * UnSetter for ordinal.
         * @return Builder
         */
        public Builder unsetOrdinal() {
            ordinal = null;
            return this;
        }

        /**
         * Setter for modifierListId.
         * @param  modifierListId  String value for modifierListId.
         * @return Builder
         */
        public Builder modifierListId(String modifierListId) {
            this.modifierListId = OptionalNullable.of(modifierListId);
            return this;
        }

        /**
         * UnSetter for modifierListId.
         * @return Builder
         */
        public Builder unsetModifierListId() {
            modifierListId = null;
            return this;
        }

        /**
         * Setter for locationOverrides.
         * @param  locationOverrides  List of ModifierLocationOverrides value for locationOverrides.
         * @return Builder
         */
        public Builder locationOverrides(List<ModifierLocationOverrides> locationOverrides) {
            this.locationOverrides = OptionalNullable.of(locationOverrides);
            return this;
        }

        /**
         * UnSetter for locationOverrides.
         * @return Builder
         */
        public Builder unsetLocationOverrides() {
            locationOverrides = null;
            return this;
        }

        /**
         * Setter for imageId.
         * @param  imageId  String value for imageId.
         * @return Builder
         */
        public Builder imageId(String imageId) {
            this.imageId = OptionalNullable.of(imageId);
            return this;
        }

        /**
         * UnSetter for imageId.
         * @return Builder
         */
        public Builder unsetImageId() {
            imageId = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogModifier} object using the set fields.
         * @return {@link CatalogModifier}
         */
        public CatalogModifier build() {
            return new CatalogModifier(name, priceMoney, ordinal, modifierListId, locationOverrides, imageId);
        }
    }
}
