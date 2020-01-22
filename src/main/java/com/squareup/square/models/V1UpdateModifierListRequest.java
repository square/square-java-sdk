package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateModifierListRequest type.
 */
public class V1UpdateModifierListRequest {

    /**
     * Initialization constructor.
     * @param name
     * @param selectionType
     */
    @JsonCreator
    public V1UpdateModifierListRequest(
            @JsonProperty("name") String name,
            @JsonProperty("selection_type") String selectionType) {
        this.name = name;
        this.selectionType = selectionType;
    }

    private final String name;
    private final String selectionType;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(name, selectionType);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1UpdateModifierListRequest)) {
            return false;
        }
        V1UpdateModifierListRequest v1UpdateModifierListRequest = (V1UpdateModifierListRequest) obj;
        return Objects.equals(name, v1UpdateModifierListRequest.name) &&
            Objects.equals(selectionType, v1UpdateModifierListRequest.selectionType);
    }

    /**
     * Builds a new {@link V1UpdateModifierListRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateModifierListRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .selectionType(getSelectionType());
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateModifierListRequest}
     */
    public static class Builder {
        private String name;
        private String selectionType;

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
         * Setter for selectionType
         * @param selectionType
         * @return Builder
         */
        public Builder selectionType(String selectionType) {
            this.selectionType = selectionType;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateModifierListRequest} object using the set fields.
         * @return {@link V1UpdateModifierListRequest}
         */
        public V1UpdateModifierListRequest build() {
            return new V1UpdateModifierListRequest(name,
                selectionType);
        }
    }
}
