package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogCategory type.
 */
public class CatalogCategory {

    /**
     * Initialization constructor.
     * @param name
     */
    @JsonCreator
    public CatalogCategory(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    private final String name;
    /**
     * Getter for Name.
     * The category name. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogCategory)) {
            return false;
        }
        CatalogCategory catalogCategory = (CatalogCategory) obj;
        return Objects.equals(name, catalogCategory.name);
    }

    /**
     * Builds a new {@link CatalogCategory.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogCategory.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogCategory}
     */
    public static class Builder {
        private String name;

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
         * Builds a new {@link CatalogCategory} object using the set fields.
         * @return {@link CatalogCategory}
         */
        public CatalogCategory build() {
            return new CatalogCategory(name);
        }
    }
}
