
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogObjectCategory type.
 */
public class CatalogObjectCategory {
    private final String id;
    private final OptionalNullable<Long> ordinal;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  ordinal  Long value for ordinal.
     */
    @JsonCreator
    public CatalogObjectCategory(
            @JsonProperty("id") String id,
            @JsonProperty("ordinal") Long ordinal) {
        this.id = id;
        this.ordinal = OptionalNullable.of(ordinal);
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  ordinal  Long value for ordinal.
     */

    protected CatalogObjectCategory(String id, OptionalNullable<Long> ordinal) {
        this.id = id;
        this.ordinal = ordinal;
    }

    /**
     * Getter for Id.
     * The ID of the object's category.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for Ordinal.
     * The order of the object within the context of the category.
     * @return Returns the Internal Long
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for Ordinal.
     * The order of the object within the context of the category.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getOrdinal() {
        return OptionalNullable.getFrom(ordinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordinal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogObjectCategory)) {
            return false;
        }
        CatalogObjectCategory other = (CatalogObjectCategory) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(ordinal, other.ordinal);
    }

    /**
     * Converts this CatalogObjectCategory into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogObjectCategory [" + "id=" + id + ", ordinal=" + ordinal + "]";
    }

    /**
     * Builds a new {@link CatalogObjectCategory.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogObjectCategory.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId());
        builder.ordinal = internalGetOrdinal();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogObjectCategory}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<Long> ordinal;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Long value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Long ordinal) {
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
         * Builds a new {@link CatalogObjectCategory} object using the set fields.
         * @return {@link CatalogObjectCategory}
         */
        public CatalogObjectCategory build() {
            return new CatalogObjectCategory(id, ordinal);
        }
    }
}
