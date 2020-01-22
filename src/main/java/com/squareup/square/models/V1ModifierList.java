package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1ModifierList type.
 */
public class V1ModifierList {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     * @param selectionType
     * @param modifierOptions
     * @param v2Id
     */
    @JsonCreator
    public V1ModifierList(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("selection_type") String selectionType,
            @JsonProperty("modifier_options") List<V1ModifierOption> modifierOptions,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.selectionType = selectionType;
        this.modifierOptions = modifierOptions;
        this.v2Id = v2Id;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String selectionType;
    private final List<V1ModifierOption> modifierOptions;
    private final String v2Id;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The modifier list's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The modifier list's name.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for SelectionType.
     */
    @JsonGetter("selection_type")
    public String getSelectionType() {
        return this.selectionType;
    }

    /**
     * Getter for ModifierOptions.
     * The options included in the modifier list.
     */
    @JsonGetter("modifier_options")
    public List<V1ModifierOption> getModifierOptions() {
        return this.modifierOptions;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID.
     */
    @JsonGetter("v2_id")
    public String getV2Id() {
        return this.v2Id;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, selectionType, modifierOptions, v2Id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ModifierList)) {
            return false;
        }
        V1ModifierList v1ModifierList = (V1ModifierList) obj;
        return Objects.equals(id, v1ModifierList.id) &&
            Objects.equals(name, v1ModifierList.name) &&
            Objects.equals(selectionType, v1ModifierList.selectionType) &&
            Objects.equals(modifierOptions, v1ModifierList.modifierOptions) &&
            Objects.equals(v2Id, v1ModifierList.v2Id);
    }

    /**
     * Builds a new {@link V1ModifierList.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ModifierList.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .selectionType(getSelectionType())
            .modifierOptions(getModifierOptions())
            .v2Id(getV2Id());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ModifierList}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String selectionType;
        private List<V1ModifierOption> modifierOptions;
        private String v2Id;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
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
         * Setter for selectionType
         * @param selectionType
         * @return Builder
         */
        public Builder selectionType(String selectionType) {
            this.selectionType = selectionType;
            return this;
        }
        /**
         * Setter for modifierOptions
         * @param modifierOptions
         * @return Builder
         */
        public Builder modifierOptions(List<V1ModifierOption> modifierOptions) {
            this.modifierOptions = modifierOptions;
            return this;
        }
        /**
         * Setter for v2Id
         * @param v2Id
         * @return Builder
         */
        public Builder v2Id(String v2Id) {
            this.v2Id = v2Id;
            return this;
        }

        /**
         * Builds a new {@link V1ModifierList} object using the set fields.
         * @return {@link V1ModifierList}
         */
        public V1ModifierList build() {
            V1ModifierList model = new V1ModifierList(id,
                name,
                selectionType,
                modifierOptions,
                v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
