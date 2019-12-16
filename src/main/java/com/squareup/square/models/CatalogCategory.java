package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogCategory {

    @JsonCreator
    public CatalogCategory(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    private final String name;

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogCategory)) {
            return false;
        }
        CatalogCategory catalogCategory = (CatalogCategory) o;
        return Objects.equals(name, catalogCategory.name);
    }

    /**
     * Getter for Name.
     * The category name. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName());
            return builder;
    }

    public static class Builder {
        private String name;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }

        public CatalogCategory build() {
            return new CatalogCategory(name);
        }
    }
}
