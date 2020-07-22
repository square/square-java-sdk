package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection type.
 */
public class CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection {

    /**
     * Initialization constructor.
     * @param name
     * @param uid
     */
    @JsonCreator
    public CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection(
            @JsonProperty("name") String name,
            @JsonProperty("uid") String uid) {
        this.uid = uid;
        this.name = name;
    }

    private final String uid;
    private final String name;
    /**
     * Getter for Uid.
     * Unique ID set by Square.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for Name.
     * Selection name, unique within `allowed_selections`.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection)) {
            return false;
        }
        CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection catalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection = (CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection) obj;
        return Objects.equals(uid, catalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection.uid) &&
            Objects.equals(name, catalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection.name);
    }

    /**
     * Builds a new {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name)
            .uid(getUid());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection}
     */
    public static class Builder {
        private String name;
        private String uid;

        /**
         * Initialization constructor
         */
        public Builder(String name) {
            this.name = name;
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
         * Setter for uid
         * @param uid
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Builds a new {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection} object using the set fields.
         * @return {@link CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection}
         */
        public CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection build() {
            return new CatalogCustomAttributeDefinitionSelectionConfigCustomAttributeSelection(name,
                uid);
        }
    }
}
