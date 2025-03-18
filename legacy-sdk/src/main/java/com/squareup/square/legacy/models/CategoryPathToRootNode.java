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
 * This is a model class for CategoryPathToRootNode type.
 */
public class CategoryPathToRootNode {
    private final OptionalNullable<String> categoryId;
    private final OptionalNullable<String> categoryName;

    /**
     * Initialization constructor.
     * @param  categoryId  String value for categoryId.
     * @param  categoryName  String value for categoryName.
     */
    @JsonCreator
    public CategoryPathToRootNode(
            @JsonProperty("category_id") String categoryId, @JsonProperty("category_name") String categoryName) {
        this.categoryId = OptionalNullable.of(categoryId);
        this.categoryName = OptionalNullable.of(categoryName);
    }

    /**
     * Initialization constructor.
     * @param  categoryId  String value for categoryId.
     * @param  categoryName  String value for categoryName.
     */
    protected CategoryPathToRootNode(OptionalNullable<String> categoryId, OptionalNullable<String> categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    /**
     * Internal Getter for CategoryId.
     * The category's ID.
     * @return Returns the Internal String
     */
    @JsonGetter("category_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCategoryId() {
        return this.categoryId;
    }

    /**
     * Getter for CategoryId.
     * The category's ID.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCategoryId() {
        return OptionalNullable.getFrom(categoryId);
    }

    /**
     * Internal Getter for CategoryName.
     * The category's name.
     * @return Returns the Internal String
     */
    @JsonGetter("category_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCategoryName() {
        return this.categoryName;
    }

    /**
     * Getter for CategoryName.
     * The category's name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCategoryName() {
        return OptionalNullable.getFrom(categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryPathToRootNode)) {
            return false;
        }
        CategoryPathToRootNode other = (CategoryPathToRootNode) obj;
        return Objects.equals(categoryId, other.categoryId) && Objects.equals(categoryName, other.categoryName);
    }

    /**
     * Converts this CategoryPathToRootNode into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CategoryPathToRootNode [" + "categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }

    /**
     * Builds a new {@link CategoryPathToRootNode.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CategoryPathToRootNode.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.categoryId = internalGetCategoryId();
        builder.categoryName = internalGetCategoryName();
        return builder;
    }

    /**
     * Class to build instances of {@link CategoryPathToRootNode}.
     */
    public static class Builder {
        private OptionalNullable<String> categoryId;
        private OptionalNullable<String> categoryName;

        /**
         * Setter for categoryId.
         * @param  categoryId  String value for categoryId.
         * @return Builder
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = OptionalNullable.of(categoryId);
            return this;
        }

        /**
         * UnSetter for categoryId.
         * @return Builder
         */
        public Builder unsetCategoryId() {
            categoryId = null;
            return this;
        }

        /**
         * Setter for categoryName.
         * @param  categoryName  String value for categoryName.
         * @return Builder
         */
        public Builder categoryName(String categoryName) {
            this.categoryName = OptionalNullable.of(categoryName);
            return this;
        }

        /**
         * UnSetter for categoryName.
         * @return Builder
         */
        public Builder unsetCategoryName() {
            categoryName = null;
            return this;
        }

        /**
         * Builds a new {@link CategoryPathToRootNode} object using the set fields.
         * @return {@link CategoryPathToRootNode}
         */
        public CategoryPathToRootNode build() {
            return new CategoryPathToRootNode(categoryId, categoryName);
        }
    }
}
