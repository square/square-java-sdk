
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1UpdateModifierListRequest type.
 */
public class V1UpdateModifierListRequest {
    private final String name;
    private final String selectionType;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param selectionType String value for selectionType.
     */
    @JsonCreator
    public V1UpdateModifierListRequest(
            @JsonProperty("name") String name,
            @JsonProperty("selection_type") String selectionType) {
        this.name = name;
        this.selectionType = selectionType;
    }

    /**
     * Getter for Name.
     * The modifier list's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for SelectionType.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1UpdateModifierListRequest)) {
            return false;
        }
        V1UpdateModifierListRequest other = (V1UpdateModifierListRequest) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(selectionType, other.selectionType);
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
     * Class to build instances of {@link V1UpdateModifierListRequest}.
     */
    public static class Builder {
        private String name;
        private String selectionType;



        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for selectionType.
         * @param selectionType String value for selectionType.
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
