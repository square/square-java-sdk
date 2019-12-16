package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateModifierListRequest {

    @JsonCreator
    public V1UpdateModifierListRequest(
            @JsonProperty("name") String name,
            @JsonProperty("selection_type") String selectionType) {
        this.name = name;
        this.selectionType = selectionType;
    }

    private final String name;
    private final String selectionType;

    @Override
    public int hashCode() {
        return Objects.hash(name, selectionType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateModifierListRequest)) {
            return false;
        }
        V1UpdateModifierListRequest v1UpdateModifierListRequest = (V1UpdateModifierListRequest) o;
        return Objects.equals(name, v1UpdateModifierListRequest.name) &&
            Objects.equals(selectionType, v1UpdateModifierListRequest.selectionType);
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .selectionType(getSelectionType());
            return builder;
    }

    public static class Builder {
        private String name;
        private String selectionType;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder selectionType(String value) {
            selectionType = value;
            return this;
        }

        public V1UpdateModifierListRequest build() {
            return new V1UpdateModifierListRequest(name,
                selectionType);
        }
    }
}
