
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogCategory type.
 */
public class CatalogCategory {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     */
    @JsonCreator
    public CatalogCategory(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * Getter for Name.
     * The category name. This is a searchable attribute for use in applicable query filters, and
     * its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
        return Objects.equals(name, other.name);
    }

    /**
     * Converts this CatalogCategory into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogCategory [" + "name=" + name + "]";
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
     * Class to build instances of {@link CatalogCategory}.
     */
    public static class Builder {
        private String name;



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
         * Builds a new {@link CatalogCategory} object using the set fields.
         * @return {@link CatalogCategory}
         */
        public CatalogCategory build() {
            return new CatalogCategory(name);
        }
    }
}
