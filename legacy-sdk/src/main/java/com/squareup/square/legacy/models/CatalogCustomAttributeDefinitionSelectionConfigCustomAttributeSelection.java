package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection type.
 */
public class CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection {
    private final OptionalNullable<String> uid;
    private final String name;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  uid  String value for uid.
     */
    @JsonCreator
    public CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection(
            @JsonProperty("name") String name, @JsonProperty("uid") String uid) {
        this.uid = OptionalNullable.of(uid);
        this.name = name;
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  uid  String value for uid.
     */
    protected CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection(
            String name, OptionalNullable<String> uid) {
        this.uid = uid;
        this.name = name;
    }

    /**
     * Internal Getter for Uid.
     * Unique ID set by Square.
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * Unique ID set by Square.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for Name.
     * Selection name, unique within `allowed_selections`.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection)) {
            return false;
        }
        CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection other =
                (CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection) obj;
        return Objects.equals(uid, other.uid) && Objects.equals(name, other.name);
    }

    /**
     * Converts this CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection [" + "name=" + name + ", uid="
                + uid + "]";
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name);
        builder.uid = internalGetUid();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection}.
     */
    public static class Builder {
        private String name;
        private OptionalNullable<String> uid;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         */
        public Builder(String name) {
            this.name = name;
        }

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
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Builds a new {@link
         * CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection} object using the
         * set fields.
         * @return {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection}
         */
        public CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection build() {
            return new CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection(name, uid);
        }
    }
}
